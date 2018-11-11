package org.threeten.bp.temporal;

import org.threeten.bp.DateTimeException;

public class UnsupportedTemporalTypeException extends DateTimeException {
    private static final long serialVersionUID = -189676278478L;

    public UnsupportedTemporalTypeException(String str) {
        super(str);
    }
}
