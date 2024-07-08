package com.ggs.event.service.impl;

import java.time.LocalDate;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ggs.event.entity.CarComplain;
import com.ggs.event.entity.Customer;
import com.ggs.event.mapper.CarComplainMapper;
import com.ggs.event.mapper.CustomerMapper;
import com.ggs.event.service.ICarComplainService;
import com.ggs.event.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhh
 * @since 2024-07-08
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    private final CustomerMapper customerMapper;

    private final ICarComplainService carComplainService;

    @Override
    @Transactional
    public void normalTest() {
        Customer customer = new Customer();
        customer.setCity("广东");
        customer.setCno(1);
        customer.setFname("sss");
        customer.setLname("lskdfjkls");
        customer.setSex(1);
        customer.setWeight(100);
        customerMapper.insert(customer);

        Long customerId = customer.getId();
        int flag = customerMapper.update(Wrappers.lambdaUpdate(Customer.class).set(Customer::getLname, "lucy").eq(Customer::getId, customerId));

        CarComplain carComplain = new CarComplain();
        carComplain.setChexi("A");
        carComplain.setCode(1001L);
        carComplain.setDate(LocalDate.now());
        carComplain.setPinpai("大宗");
        carComplain.setProblemClass("有问题");
        carComplainService.save(carComplain);
    }

    @Override
    @Async("taskExecutor")
    @Transactional(propagation = Propagation.REQUIRED)
    public void threadTest() {
        Customer customer = new Customer();
        customer.setCity("广东");
        customer.setCno(1);
        customer.setFname("sss");
        customer.setLname("lskdfjkls");
        customer.setSex(1);
        customer.setWeight(100);
        customerMapper.insert(customer);

        Long customerId = customer.getId();
        int flag = customerMapper.update(Wrappers.lambdaUpdate(Customer.class).set(Customer::getLname, "lucy").eq(Customer::getId, customerId));

        CarComplain carComplain = new CarComplain();
        carComplain.setChexi("A");
        carComplain.setCode(1001L);
        carComplain.setDate(LocalDate.now());
        carComplain.setPinpai("大宗");
        carComplain.setProblemClass("有问题");
        carComplainService.save(carComplain);
    }

}
