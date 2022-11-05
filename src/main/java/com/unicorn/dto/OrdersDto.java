package com.unicorn.dto;

import com.unicorn.entity.OrderDetail;
import com.unicorn.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private int sumNum;

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
