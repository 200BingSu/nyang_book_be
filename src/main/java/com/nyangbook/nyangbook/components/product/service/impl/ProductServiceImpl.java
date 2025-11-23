package com.nyangbook.nyangbook.components.product.service.impl;

import com.nyangbook.nyangbook.components.product.ProductMapper;
import com.nyangbook.nyangbook.components.product.service.ProductService;
import com.nyangbook.nyangbook.components.product.service.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductVO> selectList (ProductVO productVO){ return productMapper.selectProducts(productVO); };
}
