package suflower.sudays_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suflower.sudays_back.dto.CreateDiaryRequestDTO;
import suflower.sudays_back.dto.CreateDiaryResponseDTO;
import suflower.sudays_back.entity.Diary;
import suflower.sudays_back.service.DiaryService;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("")
    public ResponseEntity<CreateDiaryResponseDTO> createDiary(
        @RequestBody CreateDiaryRequestDTO createDiaryRequest) {
        Diary createdDiary = diaryService.createDiary(createDiaryRequest);
        CreateDiaryResponseDTO createDiaryResponseDTO = new CreateDiaryResponseDTO(createdDiary);
        return new ResponseEntity<>(createDiaryResponseDTO, HttpStatus.OK);
    }
}
