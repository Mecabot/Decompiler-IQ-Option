package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.Method;

public final class RouteException extends RuntimeException {
    private static final Method addSuppressedExceptionMethod;
    private IOException lastException;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            declaredMethod = null;
        }
        addSuppressedExceptionMethod = declaredMethod;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.lastException = iOException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public void addConnectException(IOException iOException) {
        addSuppressedIfPossible(iOException, this.lastException);
        this.lastException = iOException;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000f A:{RETURN, Splitter: B:2:0x0004, ExcHandler: java.lang.reflect.InvocationTargetException (unused java.lang.reflect.InvocationTargetException)} */
    /* JADX WARNING: Missing block: B:4:0x000f, code:
            return;
     */
    private void addSuppressedIfPossible(java.io.IOException r4, java.io.IOException r5) {
        /*
        r3 = this;
        r0 = addSuppressedExceptionMethod;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = addSuppressedExceptionMethod;	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r2 = 0;
        r1[r2] = r5;	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r0.invoke(r4, r1);	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RouteException.addSuppressedIfPossible(java.io.IOException, java.io.IOException):void");
    }
}
