package com.xz.fld.service;

import com.xz.fld.domain.Product;
import com.xz.fld.domain.ProductOrder;
import com.xz.fld.dto.OrderDTO;
import com.xz.fld.enums.OrderStatusEnum;
import com.xz.fld.enums.ProductStatusEnum;
import com.xz.fld.enums.RebateFlagEnum;
import com.xz.fld.exception.BizException;
import com.xz.fld.mapper.ProductMapper;
import com.xz.fld.mapper.ProductOrderMapper;
import com.xz.fld.util.DateUtils;
import com.xz.fld.util.IDUtils;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductOrderService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductOrderMapper productOrderMapper;

    @Value("${fld.image.url}")
    private String productImageUrl;

    public void createOrder(String uid, int productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        if (null == product) {
            throw new BizException("产品不存在");
        }

        if (product.getProductStatus() != ProductStatusEnum.enable.getK()) {
            throw new BizException("产品已下架");
        }

        Date date = new Date();

        ProductOrder productOrder = new ProductOrder();
        productOrder.setApplyStatus(OrderStatusEnum.意向申请.getK());
        productOrder.setApplyTime(date);
        productOrder.setCreateTime(date);
        productOrder.setModifyTime(date);
        productOrder.setOrderId(IDUtils.createOrderId());
        productOrder.setProductId(productId);
        productOrder.setRebateAmount("0");
        productOrder.setRebateFlag(RebateFlagEnum.不返利.getK());
        productOrder.setRebateTime(null);
        productOrder.setUserId(uid);

        int rows = productOrderMapper.insert(productOrder);
        if (1 != rows) {
            throw new BizException("下单失败");
        }

    }

    public List<OrderDTO> listOrders(String uid, byte rebateFlag) {

        List<ProductOrder> productOrders = productOrderMapper.listOrders(uid, rebateFlag);
        List<OrderDTO> dtoList = new ArrayList<>(productOrders.size());

        for (ProductOrder order : productOrders) {
            OrderDTO orderDTO = new OrderDTO();
            dtoList.add(orderDTO);

            Product product = productMapper.selectByPrimaryKey(order.getProductId());

            orderDTO.setApplyStatus(order.getApplyStatus());
            orderDTO.setApplyStatusDesc(OrderStatusEnum.getEnum(order.getApplyStatus()).getV());
            orderDTO.setApplyTime(DateUtils.dateToString(order.getApplyTime()));
            orderDTO.setCreateTime(DateUtils.dateToString(order.getCreateTime()));
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setRebateAmount(order.getRebateAmount());
            orderDTO.setProductId(order.getProductId());
            orderDTO.setRebateFlag(order.getRebateFlag());
            orderDTO.setRebateFlagDesc(RebateFlagEnum.getEnum(order.getRebateFlag()).getV());
            orderDTO.setRebateTime(order.getRebateTime() == null ? "" : DateUtils.dateToString(order.getRebateTime()));
            orderDTO.setUserId(uid);
            orderDTO.setProductName(product.getProductName());
            orderDTO.setProductImage(productImageUrl + product.getProductLogo());
        }

        return dtoList;
    }
}
