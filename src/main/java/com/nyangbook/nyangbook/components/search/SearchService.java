package com.nyangbook.nyangbook.components.search;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface SearchService {
    List<Map<String, Object>> getDataList(SearchVO searchVO);
}
