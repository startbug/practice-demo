package com.ggs.event.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.ggs.event.entity.R;
import com.ggs.event.service.ICustomerService;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhh
 * @since 2024-07-08
 */
@Controller
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/normal-test")
    public R normalTest() {
        customerService.normalTest();
        return R.ok();
    }

    @GetMapping("/thread-test")
    public R threadTest() {
        customerService.threadTest();
        return R.ok();
    }

}
