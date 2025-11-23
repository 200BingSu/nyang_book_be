package com.nyangbook.nyangbook.components.search;

import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchVO {

    private String query;
    private Integer key;
    private List<Map<String,Object>> orderBy;

    private List<ServiceVO> serviceVOList;
    private List<?> dataList;
    public int getServiceVOListCount() {
        return serviceVOList == null ? 0 : serviceVOList.size();
    }

    public int getDataListCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
