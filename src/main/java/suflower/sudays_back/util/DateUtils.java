package suflower.sudays_back.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_FORMATTER =
        DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);

    // 현재 시간을 기본 포맷으로 반환
    public static String nowToString() {
        return LocalDateTime.now().format(DEFAULT_FORMATTER);
    }

    // 특정 LocalDateTime 객체를 기본 포맷으로 변환
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_FORMATTER);
    }
}
