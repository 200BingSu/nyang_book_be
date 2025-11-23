package com.nyangbook.nyangbook.components.product;

import com.nyangbook.nyangbook.components.product.service.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductVO> selectProducts (ProductVO productVO);
}
