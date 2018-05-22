package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String orderId;

    private String userId;

    private Integer productId;

    private String productName;

    private String productImage;

    private String applyTime;

    private Byte applyStatus;

    private String applyStatusDesc;

    private Byte rebateFlag;

    private String rebateFlagDesc;

    private String rebateTime;

    private String rebateAmount;

    private String createTime;

}
