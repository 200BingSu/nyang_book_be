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
    private Integer type_key;
    private Integer attributes_key;
    private Integer taste_key;
}
