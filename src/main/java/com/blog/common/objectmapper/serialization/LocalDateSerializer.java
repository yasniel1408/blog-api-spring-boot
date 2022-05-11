package com.blog.common.objectmapper.serialization;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateSerializer class used to deserialize LocalDate objects.
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(StringUtils.capitalize(value.format(DateTimeFormatter.ofPattern(DateFormat.ABBREVIATED_MONTH_DAY_COMMA_YEAR.getValue())).toUpperCase()));
    }

}
