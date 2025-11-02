package com.nyangbook.nyangbook.components.diary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface DiaryMapper {

    int insertDiary(DiaryVO diaryVO);
    List<DiaryVO> selectDiaryList(DiaryVO diaryVO);
}

