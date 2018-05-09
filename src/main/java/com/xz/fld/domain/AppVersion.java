package com.xz.fld.domain;

import java.util.Date;

public class AppVersion {
    private Integer id;

    private String appVersion;

    private Byte platform;

    private String description;

    private Byte forceUpdate;

    private String url;

    private Byte currentVersion;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public Byte getPlatform() {
        return platform;
    }

    public void setPlatform(Byte platform) {
        this.platform = platform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Byte forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Byte currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}