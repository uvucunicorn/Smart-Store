package com.unicorn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unicorn.entity.AddressBook;
import com.unicorn.mapper.AddressBookMapper;
import com.unicorn.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
