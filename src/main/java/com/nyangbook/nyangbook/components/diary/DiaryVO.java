package com.nyangbook.nyangbook.components.diary;

import lombok.*;

import java.time.LocalDateTime;
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
    private LocalDateTime created_at;


}
