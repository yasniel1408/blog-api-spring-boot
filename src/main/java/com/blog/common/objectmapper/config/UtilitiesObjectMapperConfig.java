package org.zenith.utilities.objectmapper.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.zenith.utilities.objectmapper.serialization.CurrencyDeserializer;
import org.zenith.utilities.objectmapper.serialization.CurrencySerializer;
import org.zenith.utilities.objectmapper.serialization.DecimalDeserializer;
import org.zenith.utilities.objectmapper.serialization.DecimalSerializer;
import org.zenith.utilities.objectmapper.serialization.LocalDateSerializer;
import org.zenith.utilities.objectmapper.serialization.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Utilities object mapper config.
 */
@Configuration
public class UtilitiesObjectMapperConfig {

    /**
     * The constant DEFAULT_OBJECT_MAPPER.
     */
    private static final String DEFAULT_OBJECT_MAPPER = "defaultObjectMapper";

    /**
     * Default object mapper object mapper.
     *
     * @return the object mapper
     */
    @Bean(DEFAULT_OBJECT_MAPPER)
    @Primary
    public ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        registerJavaTimeModule(objectMapper);

        registerSimpleModule(objectMapper);

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        objectMapper.setDefaultPrettyPrinter(new MinimalPrettyPrinter());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
        return objectMapper;
    }

    private void registerSimpleModule(ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(BigDecimal.class, new CurrencySerializer());
        simpleModule.addDeserializer(BigDecimal.class, new CurrencyDeserializer());
        simpleModule.addSerializer(Double.class, new DecimalSerializer());//This is to add commas and decimals to all Doubles
        simpleModule.addDeserializer(Double.class, new DecimalDeserializer());//This is to add commas and decimals to all Doubles
        objectMapper.registerModule(simpleModule);
    }

    private void registerJavaTimeModule(ObjectMapper objectMapper) {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
//        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
//        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        objectMapper.registerModule(javaTimeModule);
    }
}
