package com.xz.fld.domain;

import java.util.Date;

public class AccountBalance {
    private String userId;

    private String totalAmount;

    private String enableBalance;

    private String unableBalance;

    private String rebateAmount;

    private String enableCash;

    private String unableCash;

    private String unRebateAmount;

    private String argueAmount;

    private Date updateTime;

    private Date createTime;

    private String rewardAmount;

    private String putOutRewardAmount;

    private String unPutOutRewardAmount;

    private Integer rewardCount;

    private Integer putOutRewardCount;

    private Integer unPutOutRewardCount;

    private Integer rebateCount;

    private Integer putOutRebateCount;

    private Integer unPutOutRebateCount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount == null ? null : totalAmount.trim();
    }

    public String getEnableBalance() {
        return enableBalance;
    }

    public void setEnableBalance(String enableBalance) {
        this.enableBalance = enableBalance == null ? null : enableBalance.trim();
    }

    public String getUnableBalance() {
        return unableBalance;
    }

    public void setUnableBalance(String unableBalance) {
        this.unableBalance = unableBalance == null ? null : unableBalance.trim();
    }

    public String getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(String rebateAmount) {
        this.rebateAmount = rebateAmount == null ? null : rebateAmount.trim();
    }

    public String getEnableCash() {
        return enableCash;
    }

    public void setEnableCash(String enableCash) {
        this.enableCash = enableCash == null ? null : enableCash.trim();
    }

    public String getUnableCash() {
        return unableCash;
    }

    public void setUnableCash(String unableCash) {
        this.unableCash = unableCash == null ? null : unableCash.trim();
    }

    public String getUnRebateAmount() {
        return unRebateAmount;
    }

    public void setUnRebateAmount(String unRebateAmount) {
        this.unRebateAmount = unRebateAmount == null ? null : unRebateAmount.trim();
    }

    public String getArgueAmount() {
        return argueAmount;
    }

    public void setArgueAmount(String argueAmount) {
        this.argueAmount = argueAmount == null ? null : argueAmount.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(String rewardAmount) {
        this.rewardAmount = rewardAmount == null ? null : rewardAmount.trim();
    }

    public String getPutOutRewardAmount() {
        return putOutRewardAmount;
    }

    public void setPutOutRewardAmount(String putOutRewardAmount) {
        this.putOutRewardAmount = putOutRewardAmount == null ? null : putOutRewardAmount.trim();
    }

    public String getUnPutOutRewardAmount() {
        return unPutOutRewardAmount;
    }

    public void setUnPutOutRewardAmount(String unPutOutRewardAmount) {
        this.unPutOutRewardAmount = unPutOutRewardAmount == null ? null : unPutOutRewardAmount.trim();
    }

    public Integer getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(Integer rewardCount) {
        this.rewardCount = rewardCount;
    }

    public Integer getPutOutRewardCount() {
        return putOutRewardCount;
    }

    public void setPutOutRewardCount(Integer putOutRewardCount) {
        this.putOutRewardCount = putOutRewardCount;
    }

    public Integer getUnPutOutRewardCount() {
        return unPutOutRewardCount;
    }

    public void setUnPutOutRewardCount(Integer unPutOutRewardCount) {
        this.unPutOutRewardCount = unPutOutRewardCount;
    }

    public Integer getRebateCount() {
        return rebateCount;
    }

    public void setRebateCount(Integer rebateCount) {
        this.rebateCount = rebateCount;
    }

    public Integer getPutOutRebateCount() {
        return putOutRebateCount;
    }

    public void setPutOutRebateCount(Integer putOutRebateCount) {
        this.putOutRebateCount = putOutRebateCount;
    }

    public Integer getUnPutOutRebateCount() {
        return unPutOutRebateCount;
    }

    public void setUnPutOutRebateCount(Integer unPutOutRebateCount) {
        this.unPutOutRebateCount = unPutOutRebateCount;
    }
}