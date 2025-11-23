package com.nyangbook.nyangbook.components.product.service;


import com.nyangbook.nyangbook.components.util.service.PaginationVO;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductVO extends PaginationVO {
    private int product_key;
    private String product_name;
    private String created_at;

    private Integer brand_key;
    private String brand_name;

    private Integer type_key;
    private String type_name;

    private Integer attributes_key;
    private String attributes_name;

    private Integer taste_key;
    private String taste_name;

    private double like_point;
}
