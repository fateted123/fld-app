package com.xz.fld.service;

import com.xz.fld.domain.Invit;
import com.xz.fld.domain.User;
import com.xz.fld.domain.UserDetail;
import com.xz.fld.dto.InvitDTO;
import com.xz.fld.dto.ShareRegistDTO;
import com.xz.fld.dto.UserDTO;
import com.xz.fld.dto.UserRegister4PhoneDTO;
import com.xz.fld.enums.ShareChannelEnum;
import com.xz.fld.exception.BizException;
import com.xz.fld.mapper.InvitMapper;
import com.xz.fld.mapper.UserDetailMapper;
import com.xz.fld.mapper.UserMapper;
import com.xz.fld.util.DateUtils;
import com.xz.fld.util.IDUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private InvitMapper invitMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Value("${share.url.key}")
    private String shareKey;

    @Value("${share.regist.url}")
    private String shareRegistUrl;

    @Value("${regist.pwd.key}")
    private String pwdKey;

    public void register4Phone(UserRegister4PhoneDTO userRegister4PhoneDTO) {

        String code = cacheService.getRegistCode(userRegister4PhoneDTO.getPhone());
        if (StringUtils.isBlank(code)) {
            throw new BizException("验证码过期");
        }

        if (!code.equalsIgnoreCase(userRegister4PhoneDTO.getCode())) {
            throw new BizException("验证码不正确");
        }

        User user = userMapper.getUserByPhone(userRegister4PhoneDTO.getPhone());
        if (null != user) {
            throw new BizException("手机已注册");
        }

        user = new User();
        user.setEmail(userRegister4PhoneDTO.getEmail());
        user.setDefaultRegisterState((byte)1);
        user.setInvitUserId(userRegister4PhoneDTO.getInvitUserId());
        user.setOpenTime(new Date());
        user.setPhone(userRegister4PhoneDTO.getPhone());
        String encodePwd = DigestUtils.md5Hex(userRegister4PhoneDTO.getPhone() + userRegister4PhoneDTO.getPwd() + pwdKey);
        user.setPwd(encodePwd);
        user.setRegisterChannel(userRegister4PhoneDTO.getRegisterChannel());
        user.setState((byte)1);
        user.setTerminalInfo(userRegister4PhoneDTO.getTerminalInfo());
        user.setUpdateTime(new Date());
        user.setUserId(IDUtils.createUserId());
        user.setRegisterMode(userRegister4PhoneDTO.getRegisterMode());

        int rows = userMapper.insert(user);
        if (1 != rows) {
            throw new BizException("注册失败");
        }
    }

    public User login4Pwd(String phone, String pwd) {
        User user = userMapper.getUserByPhone(phone);

        if (null == user) {
            throw new BizException("用户不存在或者密码错误");
        }

        String encodePwd = DigestUtils.md5Hex(phone + pwd + pwdKey);
        if (!user.getPwd().equals(encodePwd)) {
            throw new BizException("用户不存在或者密码错误");
        }

        if (2 == user.getState()) {
            throw new BizException("用户已被冻结，请联系客服");
        }

        if (3 == user.getState()) {
            throw new BizException("用户已被销户，请联系客服");
        }

        return user;
    }

    public UserDTO getUserInfo(String uid) {
        User user = userMapper.selectByPrimaryKey(uid);

        if (null == user) {
            throw new BizException("用户不存在");
        }

        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setUserId(uid);
        return dto;
    }

    public List<ShareRegistDTO> getUserShareUrl(String userId) {
        String param = "uid=" + userId + "&channel=" + ShareChannelEnum.qq.getK();
        String token = DigestUtils.md5Hex(param + shareKey);
        String qqUrl = shareRegistUrl + "?" + param + "&token=" + token;

        param = "uid=" + userId + "&channel=" + ShareChannelEnum.weibo.getK();
        token = DigestUtils.md5Hex(param + shareKey);
        String weiboUrl = shareRegistUrl + "?" + param + "&token=" + token;

        param = "uid=" + userId + "&channel=" + ShareChannelEnum.weixin.getK();
        token = DigestUtils.md5Hex(param + shareKey);
        String weixinUrl = shareRegistUrl + "?" + param + "&token=" + token;

        param = "uid=" + userId + "&channel=" + ShareChannelEnum.weixin_pengyou.getK();
        token = DigestUtils.md5Hex(param + shareKey);
        String pengyouquanUrl = shareRegistUrl + "?" + param + "&token=" + token;

        param = "uid=" + userId + "&channel=" + ShareChannelEnum.qqzoo.getK();
        token = DigestUtils.md5Hex(param + shareKey);
        String qqzooUrl = shareRegistUrl + "?" + param + "&token=" + token;

        List<ShareRegistDTO> dtoList = new ArrayList<>(5);

        dtoList.add(new ShareRegistDTO(qqUrl, ShareChannelEnum.qq.getK(), ShareChannelEnum.qq.getV()));
        dtoList.add(new ShareRegistDTO(weiboUrl, ShareChannelEnum.weibo.getK(), ShareChannelEnum.weibo.getV()));
        dtoList.add(new ShareRegistDTO(weixinUrl, ShareChannelEnum.weixin.getK(), ShareChannelEnum.weixin.getV()));
        dtoList.add(new ShareRegistDTO(qqzooUrl, ShareChannelEnum.qqzoo.getK(), ShareChannelEnum.qqzoo.getV()));
        dtoList.add(new ShareRegistDTO(pengyouquanUrl, ShareChannelEnum.weixin_pengyou.getK(), ShareChannelEnum.weixin_pengyou.getV()));

        return dtoList;
    }

    public void checkShareRegist(String uid, byte channel, String token) {
        String param = "uid=" + uid + "&channel=" + channel;
        String myToken = DigestUtils.md5Hex(param + shareKey);

        if (!myToken.equals(token)) {
            throw new BizException("非法签名");
        }

    }

    public void register4Share(String phone, String pwd, String code, String uid, byte channel, String token) {

        checkShareRegist(uid, channel, token);

        String sendCode = cacheService.getRegistCode(phone);
        if (StringUtils.isBlank(sendCode)) {
            throw new BizException("验证码过期");
        }

        if (!sendCode.equalsIgnoreCase(code)) {
            throw new BizException("验证码不正确");
        }

        User user = userMapper.getUserByPhone(phone);
        if (null != user) {
            throw new BizException("手机已注册");
        }

        user = new User();
        user.setDefaultRegisterState((byte)1);
        user.setInvitUserId(uid);
        user.setOpenTime(new Date());
        user.setPhone(phone);
        String encodePwd = DigestUtils.md5Hex(phone + pwd + pwdKey);
        user.setPwd(encodePwd);
        user.setRegisterChannel(channel);
        user.setState((byte)1);
        user.setUpdateTime(new Date());
        user.setUserId(IDUtils.createUserId());
        user.setRegisterMode((byte)0);

        int rows = userMapper.insert(user);
        if (1 != rows) {
            throw new BizException("注册失败");
        }

        User invitUser = userMapper.selectByPrimaryKey(uid);
        UserDetail userDetail = userDetailMapper.selectByPrimaryKey(uid);

        //添加邀请记录
        Invit invit = new Invit();
        invit.setInvitMobile(invitUser.getPhone());
        invit.setInvitName(userDetail == null ? "" : userDetail.getKittyname());
        invit.setInvitUserId(user.getUserId());
        invit.setRegChannel(channel);
        invit.setUserId(uid);
        invit.setRegtime(new Date());

        rows = invitMapper.insert(invit);
        if (1 != rows) {
            throw new BizException("注册失败");
        }
    }

    public void resetPwd(String uid, String code, String newPwd) {
        //校验短信码
        User user = userMapper.selectByPrimaryKey(uid);
        if (null == user) {
            throw new BizException("用户不存在");
        }
        String resetCode = cacheService.getRegistCode(user.getPhone());
        if (StringUtils.isBlank(resetCode)) {
            throw new BizException("验证码过期");
        }

        if (!resetCode.equalsIgnoreCase(code)) {
            throw new BizException("验证码不正确");
        }

        String encodePwd = DigestUtils.md5Hex(user.getPhone() + newPwd + pwdKey);
        int rows = userMapper.updatePwd(uid, encodePwd);
        if (1 != rows) {
            throw new BizException("密码设置失败");
        }
    }

    public List<InvitDTO> loadInvit(String uid) {
        List<Invit> invits = invitMapper.listInvit(uid);
        List<InvitDTO> dtoList = new ArrayList<>(invits.size());

        for (Invit invit : invits) {
            InvitDTO invitDTO = new InvitDTO();
            dtoList.add(invitDTO);

            invitDTO.setId(invit.getId());
            invitDTO.setInvitMobile(invit.getInvitMobile());
            invitDTO.setInvitName(invit.getInvitName());
            invitDTO.setInvitUserId(invit.getInvitUserId());
            invitDTO.setRegChannel(ShareChannelEnum.getShareChannelEnum(invit.getRegChannel()).getV());
            invitDTO.setRegtime(DateUtils.dateToString(invit.getRegtime()));
            invitDTO.setUserId(invit.getUserId());
        }

        return dtoList;
    }

}
