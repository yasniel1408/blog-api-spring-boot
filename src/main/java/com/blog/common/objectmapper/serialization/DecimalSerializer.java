package com.blog.common.objectmapper.serialization;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * DecimalSerializer class formats all Doubles to include commas and limits to 2 digits after decimal.
 * e.g. if the text is 1234.1223323 then it will be serialized as 1,234.12
 *
 */
public class DecimalSerializer extends DoubleSerializer {

	/**
	 * Used to format decimal numbers.
	 */
    private static final String DECIMAL_FORMAT = "#,##0.00";
    
    /**
     * Set the number format as the default locale's decimal formatter.
     */
	@Override
	protected void setNumberFormat() {
		numberFormat = new DecimalFormat(DECIMAL_FORMAT, new DecimalFormatSymbols(Locale.getDefault()));
	}
}
