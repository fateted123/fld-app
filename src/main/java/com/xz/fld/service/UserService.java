package com.xz.fld.service;

import com.xz.fld.domain.User;
import com.xz.fld.dto.UserDTO;
import com.xz.fld.dto.UserRegister4PhoneDTO;
import com.xz.fld.exception.BizException;
import com.xz.fld.mapper.UserMapper;
import com.xz.fld.util.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheService cacheService;

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
        user.setPwd(userRegister4PhoneDTO.getPwd());
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

        if (!user.getPwd().equals(pwd)) {
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

}
