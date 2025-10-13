package com.nyangbook.nyangbook.components.diary;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiaryVO {
    private int diary_key;
    private String diary_content;
    private String users_key;
    private String created_at;

    public UUID getUUID (){
        return UUID.fromString(users_key);
    }
}
