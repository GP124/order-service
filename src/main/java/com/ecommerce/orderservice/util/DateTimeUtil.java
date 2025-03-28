package com.ecommerce.orderservice.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
        public static String formatDate(LocalDateTime dateTime) {
            return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
}
