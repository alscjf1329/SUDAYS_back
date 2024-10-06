package suflower.sudays_back.constant.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;
import suflower.sudays_back.constant.ConditionConstants;

@Component
@Converter(autoApply = true)
public class ConditionAttributeConverter implements
    AttributeConverter<ConditionConstants, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ConditionConstants condition) {
        if (condition == null) {
            return null;
        }
        return condition.getValue();
    }

    @Override
    public ConditionConstants convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        for (ConditionConstants condition : ConditionConstants.values()) {
            if (condition.getValue() == dbData) {
                return condition;
            }
        }
        throw new IllegalArgumentException("Unknown status value: " + dbData);
    }
}
