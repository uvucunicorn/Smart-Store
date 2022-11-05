package com.unicorn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unicorn.entity.Orders;

public interface OrderService extends IService<Orders> {
    void submit(Orders orders);
}
