package com.tenzin.flooring.view;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Tenzin Woesel
 */
public interface UserIO {

    void print(String msg);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);

    BigDecimal readBigDecimal(String prompt);
    BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max);

    LocalDate readDate(String prompt);

    LocalDate readDate(String prompt, LocalDate min, LocalDate max);
}
