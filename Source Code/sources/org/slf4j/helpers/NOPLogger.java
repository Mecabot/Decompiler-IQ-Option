package org.slf4j.helpers;

public class NOPLogger extends MarkerIgnoringBase {
    public static final NOPLogger fdr = new NOPLogger();
    private static final long serialVersionUID = -517220405410904473L;

    public final void debug(String str) {
    }

    public final void error(String str) {
    }

    public final void error(String str, Throwable th) {
    }

    public String getName() {
        return "NOP";
    }

    public final boolean isDebugEnabled() {
        return false;
    }

    protected NOPLogger() {
    }
}
