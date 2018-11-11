package org.slf4j.impl;

import com.noveogroup.android.log.Logger;
import com.noveogroup.android.log.Logger.Level;
import org.slf4j.helpers.MarkerIgnoringBase;

public class AndroidLoggerAdapter extends MarkerIgnoringBase {
    private final Logger logger;

    public AndroidLoggerAdapter(Logger logger) {
        this.logger = logger;
    }

    private boolean a(Level level) {
        return this.logger.a(level);
    }

    private void a(Level level, String str) {
        this.logger.a(level, str, null);
    }

    private void b(Level level, String str, Throwable th) {
        this.logger.a(level, str, th);
    }

    public boolean isDebugEnabled() {
        return a(Level.DEBUG);
    }

    public void debug(String str) {
        a(Level.DEBUG, str);
    }

    public void error(String str) {
        a(Level.ERROR, str);
    }

    public void error(String str, Throwable th) {
        b(Level.ERROR, str, th);
    }
}
