package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppVersionDTO {
    private String lastVersion;

    private byte platform;

    private String description;

    private Boolean forceUpdate;

    private String downLoadUrl;

    private String createTime;

    private boolean needUpdate;
}
