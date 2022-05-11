package com.blog.common.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateDeserializer class used to deserialize LocalDate objects.
 *
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String dateValueAsString = jsonParser.getValueAsString();
        LocalDate localDate = null;

        // Check if the local date time is in epoch time.
        if (StringUtils.isNumeric(dateValueAsString)) {
            int dateLength = dateValueAsString.length();
            if (dateLength > 8) {
                // This will work for all dates after Thu Jan 01 1970 20:46:39 MST (999999999 epoch ms).
                localDate = Instant.ofEpochMilli(Long.parseLong(dateValueAsString)).atZone(ZoneId.systemDefault()).toLocalDate();
            } else if (dateLength == 8) {
                // For dates with format yyyyMMdd: a 4 digit year, 2 digit month, and 2 digit day.
                localDate = LocalDate.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern(DateFormat.BASIC_ISO_DATE.getValue()));
            }
        } else {
            localDate = LocalDate.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern(DateFormat.ISO_LOCAL_DATE.getValue()));
        }

        return localDate;
    }
}
