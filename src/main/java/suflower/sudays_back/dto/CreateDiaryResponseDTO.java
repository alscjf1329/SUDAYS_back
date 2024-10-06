package suflower.sudays_back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import suflower.sudays_back.entity.Diary;

@Getter
@AllArgsConstructor
public class CreateDiaryResponseDTO {

    private Diary diary;
}
