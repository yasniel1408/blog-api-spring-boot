package org.zenith.utilities.objectmapper.serialization;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DateTimeFormat ENUM to define all used date time formats in the application.
 */
@Getter
@AllArgsConstructor
public enum DateTimeFormat {

    ISO_LOCAL_DATE_TIME_SSS("yyyy-MM-dd'T'HH:mm:ss.SSS"),
    ISO_LOCAL_DATE_TIME_SS("yyyy-MM-dd'T'HH:mm:ss.SS"),
    ISO_LOCAL_DATE_TIME("yyyy-MM-dd'T'HH:mm:ss"),
    ISO_DATE_TIME_SSS("yyyy-MM-dd HH:mm:ss.SSS"),
    ISO_DATE_TIME_SS("yyyy-MM-dd HH:mm:ss.SS"),
    ISO_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    ABBREVIATED_MONTH_DAY_COMMA_YEAR_AND_TIME("MMM dd, yyyy hh:mm:ss a"),
    FULL_MONTH_DAY_COMMA_YEAR_AND_TIME("MMMM dd, yyyy HH:mm:ss");

    private final String value;

}
