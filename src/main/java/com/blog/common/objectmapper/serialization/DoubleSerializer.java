package com.blog.common.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * DoubleSerializer class serializes Double objects into a decimal format.
 *
 */
abstract class DoubleSerializer extends NumberSerializer<Double> {

	/**
	 * Serialize the double.
	 *
	 * @param value              Value to serialize; can not be null.
	 * @param jsonGenerator      Generator used to output resulting Json content
	 * @param serializerProvider Provider that can be used to get serializer for serializing Objects value contains, if any.
	 */
    @Override
    public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(serialize(value));
    }
}
