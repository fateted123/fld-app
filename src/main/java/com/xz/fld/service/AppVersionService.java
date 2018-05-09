package com.xz.fld.service;

import com.xz.fld.domain.AppVersion;
import com.xz.fld.dto.AppVersionDTO;
import com.xz.fld.mapper.AppVersionMapper;
import com.xz.fld.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    public AppVersionDTO loadVersion(String version, byte platform) {

        AppVersion currentVersion = appVersionMapper.getCurrent(platform);

        AppVersionDTO appVersionDTO = new AppVersionDTO();
        appVersionDTO.setLastVersion(currentVersion.getAppVersion());
        appVersionDTO.setCreateTime(DateUtils.dateToString(currentVersion.getCreateTime()));
        appVersionDTO.setDescription(currentVersion.getDescription());
        appVersionDTO.setForceUpdate(currentVersion.getForceUpdate() == 1);
        appVersionDTO.setPlatform(platform);
        appVersionDTO.setDownLoadUrl(currentVersion.getUrl());
        appVersionDTO.setNeedUpdate(!currentVersion.getAppVersion().equalsIgnoreCase(version));

        return appVersionDTO;
    }
}
