package com.nyangbook.nyangbook.components.service.service;

import lombok.*;


import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceVO {
    private  int service_key;
    private String service_name;
    private String service_type;
    private String service_en;
    private int index;
    private String icon;

    private List<Map<String, Object>> childService;
    private String childServiceJson;


    private int parent_service_key;
    private String parent_service_name;
    private String parent_service_en;

    private int child_service_key;
    private String child_service_name;
    private String child_service_en;

    private int su_key;
    private int ut_key;
    private String user_type;
}
