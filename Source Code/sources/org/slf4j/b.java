package org.slf4j;

/* compiled from: Logger */
public interface b {
    void debug(String str);

    void error(String str);

    void error(String str, Throwable th);

    String getName();

    boolean isDebugEnabled();
}
