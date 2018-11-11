package org.threeten.bp.zone;

import org.threeten.bp.DateTimeException;

public class ZoneRulesException extends DateTimeException {
    private static final long serialVersionUID = -1632418723876261839L;

    public ZoneRulesException(String str) {
        super(str);
    }

    public ZoneRulesException(String str, Throwable th) {
        super(str, th);
    }
}
