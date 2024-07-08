package com.ggs.event.service.impl;

import com.ggs.event.entity.Customer;
import com.ggs.event.mapper.CustomerMapper;
import com.ggs.event.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhh
 * @since 2024-07-08
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
