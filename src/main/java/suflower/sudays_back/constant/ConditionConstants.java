package suflower.sudays_back.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConditionConstants {
    HAPPY(0),
    SO_SO(1),
    SAD(2),
    ANGRY(3);
    private final int value;
}
