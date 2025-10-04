package com.nyangbook.nyangbook.components.user.service;


import com.nyangbook.nyangbook.components.util.service.PaginationVO;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO extends PaginationVO {
    private int user_key;
    private String user_id;
    private String user_name;
    private String password;
    private String created_at;
}
