package com.kafka.util;

import java.time.format.DateTimeFormatter;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:35 AM
 * Project: commodity
 * Package Name: com.kafka.order.util
 * To change this template use File | Settings | File and Code Template
 */
public interface DateConstant {
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DateConstant.DATE_TIME_FORMAT);
}
