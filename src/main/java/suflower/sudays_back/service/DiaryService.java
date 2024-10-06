package suflower.sudays_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suflower.sudays_back.constant.ConditionConstants;
import suflower.sudays_back.constant.StatusConstant;
import suflower.sudays_back.constant.converter.ConditionAttributeConverter;
import suflower.sudays_back.dto.CreateDiaryRequestDTO;
import suflower.sudays_back.entity.Diary;
import suflower.sudays_back.repository.DiaryRepository;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final ConditionAttributeConverter conditionAttributeConverter;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository,
        ConditionAttributeConverter conditionAttributeConverter) {
        this.diaryRepository = diaryRepository;
        this.conditionAttributeConverter = conditionAttributeConverter;
    }

    public Diary createDiary(CreateDiaryRequestDTO createDiaryRequest) {
        ConditionConstants condition = conditionAttributeConverter.convertToEntityAttribute(
            createDiaryRequest.getCondition());

        Diary diary = Diary.builder()
            .title(createDiaryRequest.getTitle())
            .content(createDiaryRequest.getContent())
            .condition(condition)
            .status(StatusConstant.DRAFT)
            .build();

        return saveDiary(diary);
    }

    private Diary saveDiary(Diary diary) {
        return diaryRepository.save(diary);
    }
}
