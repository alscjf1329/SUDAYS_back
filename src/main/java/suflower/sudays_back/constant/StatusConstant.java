package suflower.sudays_back.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusConstant {
    DRAFT(0),       // 임시 저장 상태
    PUBLISHED(1),   // 출판된 상태
    REMOVED(99);    // 삭제된 상태
    private final int value;
}
