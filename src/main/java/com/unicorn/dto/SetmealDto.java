package com.unicorn.dto;

import com.unicorn.entity.Setmeal;
import com.unicorn.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
