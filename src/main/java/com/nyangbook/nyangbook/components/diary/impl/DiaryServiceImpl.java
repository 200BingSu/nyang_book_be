package com.nyangbook.nyangbook.components.diary.impl;


import com.nyangbook.nyangbook.components.diary.DiaryMapper;
import com.nyangbook.nyangbook.components.diary.DiaryService;
import com.nyangbook.nyangbook.components.diary.DiaryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
    private final DiaryMapper diaryMapper;
//    private final DiaryDAO diaryDAO;

    @Override
    public DiaryVO postDiary (DiaryVO diaryVO){
        diaryMapper.insertDiary(diaryVO);
        return diaryVO;
    }
    @Override
    public List<DiaryVO> selectDiaryList(DiaryVO diaryVO){ return diaryMapper.selectDiaryList(diaryVO);};

    @Override
    public void updateDiary (DiaryVO diaryVO){diaryMapper.updateDiary(diaryVO);};
    @Override
    public void deleteDiary (DiaryVO diaryVO){diaryMapper.deleteDiary(diaryVO);};
}
