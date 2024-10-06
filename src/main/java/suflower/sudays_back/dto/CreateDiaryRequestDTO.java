package suflower.sudays_back.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import suflower.sudays_back.constant.ConditionConstants;

@Getter
@AllArgsConstructor
public class CreateDiaryRequestDTO {

    @NotNull(message = "condition cannot be null")
    @Range(min = 0, max = 3, message = "Condition must be between 0 and 3")
    private final Integer condition;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 car")
    private final String title;

    @NotBlank(message = "Content cannot be blank")
    @Size(min = 1, max = 10000, message = "Content must be between 1 and 10,000 char")
    private final String content;
}
