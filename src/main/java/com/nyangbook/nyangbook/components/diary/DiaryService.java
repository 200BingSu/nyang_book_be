package com.nyangbook.nyangbook.components.diary;

import java.util.List;

public interface DiaryService {
    DiaryVO insertDiary(DiaryVO diaryVO);
    List<DiaryVO> selectDiaryList(DiaryVO diaryVO);
}
