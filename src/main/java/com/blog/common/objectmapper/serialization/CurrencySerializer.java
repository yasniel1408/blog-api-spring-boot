package org.zenith.utilities.objectmapper.serialization;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * CurrencySerializer class serializes BigDecimal objects into a currency format.
 *
 * @author pclaud
 */
public class CurrencySerializer extends NumberSerializer<BigDecimal> {

    /**
     * Set the number format as the default locale's currency formatter.
     */
    @Override
    protected void setNumberFormat() {
        numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
    }

    /**
     * Serialize the currency.
     *
     * @param value to be formatted
     * @return the formatted number
     */
    @Override
    protected String serialize(BigDecimal value) {

        String formattedValue;

        // Some locales, including the US, format currencies of negative values
        // with parentheses.
        // Example: -1234.444 would get formatted into (1,234.44)
        // Update this behavior so that the value gets formatted into -$1,234.44 instead
        if (value.doubleValue() < 0) {
            value = value.multiply(BigDecimal.valueOf(-1));
            formattedValue = numberFormat.format(value);
            formattedValue = "-" + formattedValue;
        } else {
            formattedValue = numberFormat.format(value);
        }

        return formattedValue;
    }

    /**
     * Serialize the string representation of the currency.
     *
     * @param text to be converted into a BigDecimal
     * @return the serialized string representation of the currency
     */
    public String serialize(String text) {
        String serializedValue = text;
        if (StringUtils.isNotBlank(text)) {
            text = text.trim();
            BigDecimal bigDecimal;
            try {
                bigDecimal = new BigDecimal(text);
                serializedValue = serialize(bigDecimal);
            } catch (NumberFormatException numberFormatException) {
                logger.warn("An exception occurred while trying to create the BigDecimal from " + text, numberFormatException);
            }
        }
        return serializedValue;
    }
}
