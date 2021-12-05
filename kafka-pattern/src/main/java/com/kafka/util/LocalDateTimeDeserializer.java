package com.kafka.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:39 AM
 * Project: commodity
 * Package Name: com.kafka.order.util
 * To change this template use File | Settings | File and Code Template
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    public LocalDateTimeDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return LocalDateTime.parse(jsonParser.readValueAs(String.class), DateConstant.DATE_TIME_FORMATTER);
    }
}
