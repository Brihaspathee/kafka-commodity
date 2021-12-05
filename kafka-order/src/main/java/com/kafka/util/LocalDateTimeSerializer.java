package com.kafka.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:37 AM
 * Project: commodity
 * Package Name: com.kafka.order.util
 * To change this template use File | Settings | File and Code Template
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    public LocalDateTimeSerializer() {
        this(null);
    }

    public LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(DateConstant.DATE_TIME_FORMATTER.format(localDateTime));
    }
}
