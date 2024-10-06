package suflower.sudays_back.constant.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;
import suflower.sudays_back.constant.StatusConstant;

@Component
@Converter(autoApply = true)
public class StatusAttributeConverter implements AttributeConverter<StatusConstant, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusConstant status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public StatusConstant convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        for (StatusConstant status : StatusConstant.values()) {
            if (status.getValue() == dbData) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status value: " + dbData);
    }
}
