package com.unicorn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unicorn.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
