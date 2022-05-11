package org.zenith.utilities.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeSerializer is mainly used by Spring to serialize from a Java LocalDateTime to a json formatting with iso formatting ("yyyy-MM-dd HH:mm:ss").
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(StringUtils.capitalize(value.format(DateTimeFormatter.ofPattern(DateTimeFormat.ABBREVIATED_MONTH_DAY_COMMA_YEAR_AND_TIME.getValue()))));
    }
}
