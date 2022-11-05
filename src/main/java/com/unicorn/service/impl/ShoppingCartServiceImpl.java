package com.unicorn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unicorn.entity.ShoppingCart;
import com.unicorn.mapper.ShoppingCartMapper;
import com.unicorn.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
