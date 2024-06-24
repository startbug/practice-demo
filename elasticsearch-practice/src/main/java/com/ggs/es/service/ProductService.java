package com.ggs.es.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggs.es.entity.Product;
import com.ggs.es.mapper.ProductMapper;

import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> {
}
