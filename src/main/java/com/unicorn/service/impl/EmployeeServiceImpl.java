package com.unicorn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unicorn.entity.Employee;
import com.unicorn.mapper.EmployeeMapper;
import com.unicorn.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
