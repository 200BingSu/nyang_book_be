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

    private List<Map<String, Object>> childService;

    private int su_key;
    private int ut_key;
    private String user_type;
}
