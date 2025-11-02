package com.nyangbook.nyangbook.components.diary.impl;

import com.nyangbook.nyangbook.components.diary.DiaryService;
import com.nyangbook.nyangbook.components.diary.DiaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    DiaryDAO diaryDAO;

    @Autowired
    DiaryMapper diaryMapper;

    @Override
    public DiaryVO insertDiary (DiaryVO diaryVO){
        return diaryDAO.insertDairy(diaryVO);
    }
    @Override
    public List<DiaryVO> selectDiaryList(DiaryVO diaryVO){ return diaryMapper.selectDiaryList(diaryVO);};
}
