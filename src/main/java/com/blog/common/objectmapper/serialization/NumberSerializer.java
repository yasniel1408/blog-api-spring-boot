package org.zenith.utilities.objectmapper.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import java.io.IOException;
import java.text.NumberFormat;

/**
 * NumberSerializer class specifies the prototypes for serializing Number objects and their descendants.
 *
 * @param <T> type of Number e.g. Integer, Double, BigDecimal
 */
abstract class NumberSerializer<T extends Number> extends JsonSerializer<T> {
	
	/**
	 * Logger used to track any issues when formatting Number objects.
	 */
	protected final XLogger logger = XLoggerFactory.getXLogger(getClass());
	
	/**
	 * Used to format the number based on locale.
	 */
	protected NumberFormat numberFormat;
	
	/**
	 * Default constructor creates a new instance of NumberSerialize with default values.
	 */
	NumberSerializer() {
		setNumberFormat();
	}
	
	/**
	 * Serialize the number.
	 *
	 * @param value              Value to serialize; can not be null.
	 * @param jsonGenerator      Generator used to output resulting Json content
	 * @param serializerProvider Provider that can be used to get serializer for serializing Objects value contains, if any.
	 */
	@Override
	public void serialize(T value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeString(serialize(value));
	}
	
	/**
	 * Serialize the number.
	 * @param value to be formatted
	 * @return the formatted number
	 */
	protected String serialize(T value) {
		return numberFormat.format(value);
	}
	
	/**
	 * Prototype to set the number format used for serialization.
	 */
	protected abstract void setNumberFormat();
}
