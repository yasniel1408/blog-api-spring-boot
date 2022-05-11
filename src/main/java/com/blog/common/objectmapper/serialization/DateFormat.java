package com.blog.common.objectmapper.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DateTimeFormat ENUM to define all used date formats in the application.
 */
@Getter
@AllArgsConstructor
public enum DateFormat {

    ISO_LOCAL_DATE("yyyy-MM-dd"),
    BASIC_ISO_DATE("yyyyMMdd"),
    MONTH_DAY_YEAR_WITH_LEADING_ZEROS("mm/dd/yyyy"),
    FULL_MONTH_DAY_COMMA_YEAR("MMMM dd, yyyy"),
    ABBREVIATED_MONTH_DAY_COMMA_YEAR("MMM dd, yyyy");

    private final String value;

}
