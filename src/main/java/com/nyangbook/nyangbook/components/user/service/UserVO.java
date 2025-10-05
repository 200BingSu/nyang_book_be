package com.nyangbook.nyangbook.components.user.service;


import com.nyangbook.nyangbook.components.util.service.PaginationVO;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO extends PaginationVO{
    private String user_key;
    private String user_id;
    private String user_name;
    private String password;
    private String created_at;

    private String user_type;

    private List<PetsVO> petsList;


}
