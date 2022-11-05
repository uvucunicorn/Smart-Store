package com.unicorn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unicorn.entity.DishFlavor;
import com.unicorn.mapper.DishFlavorMapper;
import com.unicorn.service.DishFlavorService;
import com.unicorn.service.DishService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper,DishFlavor> implements DishFlavorService {
}
