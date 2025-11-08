package com.nyangbook.nyangbook.components.search;

import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchVO {
    private List<ServiceVO> serviceVOList;
    private List<?> dataList;
    private int serviceVOListCount = serviceVOList != null?  serviceVOList.size():0;
    private int dataListCount = dataList != null? dataList.size():0;
}
