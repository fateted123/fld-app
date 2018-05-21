package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountBalanceDTO {
    private String userId;

    private String totalAmount;

    private String enableBalance;

    private String unableBalance;

    private String rebateAmount;

    private String enableCash;

    private String unableCash;

    private String unRebateAmount;

    private String argueAmount;

    private String rewardAmount;

    private String putOutRewardAmount;

    private String unPutOutRewardAmount;

    private int rewardCount;

    private int putOutRewardCount;

    private int unPutOutRewardCount;

    private int rebateCount;

    private int putOutRebateCount;

    private int unPutOutRebateCount;
}
