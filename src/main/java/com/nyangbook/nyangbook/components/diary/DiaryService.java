package com.nyangbook.nyangbook.components.diary;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface DiaryService {
    DiaryVO postDiary(DiaryVO diaryVO);
    List<DiaryVO> selectDiaryList(DiaryVO diaryVO);
    void updateDiary (DiaryVO diaryVO);
    void deleteDiary (DiaryVO diaryVO);
}
