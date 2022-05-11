package com.blog.common.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeAbbreviatedMonthDateSerializer serializes local date times in the following format: "MMM dd, yyyy".
 */
public class LocalDateTimeAbbreviatedMonthDateSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(StringUtils.capitalize(value.format(DateTimeFormatter.ofPattern(DateFormat.ABBREVIATED_MONTH_DAY_COMMA_YEAR.getValue()))));
    }

}
