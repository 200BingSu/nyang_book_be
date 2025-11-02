package com.nyangbook.nyangbook.components.user.service;


import com.nyangbook.nyangbook.components.util.service.PaginationVO;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO extends PaginationVO{
    private UUID id;
    private String email;
    private String password;
    private String created_at;
    private String updated_at;
    private String deleted_at;


    private int ut_key;
    private String user_type;

    private List<PetsVO> petsList;




}
