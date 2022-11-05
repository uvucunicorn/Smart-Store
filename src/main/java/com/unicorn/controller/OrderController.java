package com.unicorn.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.unicorn.common.BaseContext;
import com.unicorn.common.R;
import com.unicorn.dto.OrdersDto;
import com.unicorn.entity.OrderDetail;
import com.unicorn.entity.Orders;
import com.unicorn.service.OrderDetailService;
import com.unicorn.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        orderService.submit(orders);
        return R.success("下单成功");
    }


    /**
     * 订单展示
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R<Page> page(Integer page, Integer pageSize) {
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);
        Page<OrdersDto> orderDtoPage = new Page<>();

        //构建条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);
        //进行分页查询
        orderService.page(pageInfo, queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo, orderDtoPage, "records");
        List<Orders> records = pageInfo.getRecords();
        List<OrdersDto> list = records.stream().map((item) -> {
            OrdersDto ordersDto = new OrdersDto();

            BeanUtils.copyProperties(item, ordersDto);
            Long id = item.getId();
            Orders orders = orderService.getById(id);
            String number = orders.getNumber();
            LambdaQueryWrapper<OrderDetail> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(OrderDetail::getOrderId, number);
            int count = orderDetailService.count(queryWrapper1);
            ordersDto.setSumNum(count);
            return ordersDto;

        }).collect(Collectors.toList());

        orderDtoPage.setRecords(list);
        return R.success(orderDtoPage);
    }
}
