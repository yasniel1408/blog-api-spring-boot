package org.zenith.utilities.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class DecimalDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String doubleAsString = jsonParser.getValueAsString();
        Double value = null;
        if (StringUtils.isNotBlank(doubleAsString)) {
            value = Double.parseDouble(doubleAsString.replace(",", StringUtils.EMPTY));
        }
        return value;
    }
}
