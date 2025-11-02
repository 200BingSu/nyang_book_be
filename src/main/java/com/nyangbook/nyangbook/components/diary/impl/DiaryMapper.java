package com.nyangbook.nyangbook.components.diary.impl;
import com.nyangbook.nyangbook.components.diary.DiaryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryVO> selectDiaryList(DiaryVO diaryVO);
}
