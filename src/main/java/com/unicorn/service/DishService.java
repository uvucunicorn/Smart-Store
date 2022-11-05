package com.unicorn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unicorn.dto.DishDto;
import com.unicorn.entity.Dish;
import org.springframework.stereotype.Service;


public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
