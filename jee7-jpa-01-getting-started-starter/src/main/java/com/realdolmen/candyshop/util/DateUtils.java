package com.realdolmen.candyshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {
    public static Date createDate(String pattern) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(pattern);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date", e);
        }
    }

}
