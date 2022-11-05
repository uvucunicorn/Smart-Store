package com.unicorn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unicorn.dto.SetmealDto;
import com.unicorn.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

   public void removeWithDish(List<Long> ids);

    public SetmealDto getByIdWithDish(Long id);

    void updateMealByDish(SetmealDto setmealDto);
}
