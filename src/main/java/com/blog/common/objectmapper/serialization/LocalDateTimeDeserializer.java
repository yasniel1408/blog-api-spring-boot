package com.blog.common.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * DateTimeDeserializer is used by Spring (it could also be used directly by regular java code) to de-serialize from a Json formatting to LocalDateTime.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String stringLocalDateTime = jsonParser.getValueAsString();
        LocalDateTime localDateTime = null;

        if (StringUtils.isNotBlank(stringLocalDateTime) && StringUtils.isNumeric(stringLocalDateTime)) {
            localDateTime = Instant.ofEpochMilli(Long.parseLong(stringLocalDateTime)).atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        // If the input String could not be parsed as LocalDateTime, then try one more time with the default parser.
        // In case that fails, this will also use DateTimeException handler to log the correct message.
        if (localDateTime == null && StringUtils.isNotBlank(stringLocalDateTime)) {
            localDateTime = LocalDateTime.parse(stringLocalDateTime);
        }
        return localDateTime;
    }
}
