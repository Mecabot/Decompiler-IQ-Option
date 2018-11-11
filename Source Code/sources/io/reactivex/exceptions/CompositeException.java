package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        CompositeExceptionCausalChain() {
        }
    }

    static abstract class a {
        abstract void println(Object obj);

        a() {
        }
    }

    static final class b extends a {
        private final PrintStream eql;

        b(PrintStream printStream) {
            this.eql = printStream;
        }

        void println(Object obj) {
            this.eql.println(obj);
        }
    }

    static final class c extends a {
        private final PrintWriter eqm;

        c(PrintWriter printWriter) {
            this.eqm = printWriter;
        }

        void println(Object obj) {
            this.eqm.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).aWq());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.exceptions.size());
        stringBuilder.append(" exceptions occurred. ");
        this.message = stringBuilder.toString();
    }

    public List<Throwable> aWq() {
        return this.exceptions;
    }

    public String getMessage() {
        return this.message;
    }

    public synchronized Throwable getCause() {
        if (this.cause == null) {
            Throwable compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            Set hashSet = new HashSet();
            Throwable th = compositeExceptionCausalChain;
            for (Throwable th2 : this.exceptions) {
                Throwable th22;
                if (!hashSet.contains(th22)) {
                    hashSet.add(th22);
                    for (Throwable th3 : T(th22)) {
                        if (hashSet.contains(th3)) {
                            th22 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th3);
                        }
                    }
                    th.initCause(th22);
                    try {
                    } catch (Throwable unused) {
                        th = U(th);
                    }
                }
            }
            this.cause = compositeExceptionCausalChain;
        }
        return this.cause;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        a(new b(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        a(new c(printWriter));
    }

    private void a(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append(10);
        for (Object obj : getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(obj);
            stringBuilder.append(10);
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(i);
            stringBuilder.append(" :\n");
            a(stringBuilder, th, "\t");
            i++;
        }
        aVar.println(stringBuilder.toString());
    }

    private void a(StringBuilder stringBuilder, Throwable th, String str) {
        stringBuilder.append(str);
        stringBuilder.append(th);
        stringBuilder.append(10);
        for (Object obj : th.getStackTrace()) {
            stringBuilder.append("\t\tat ");
            stringBuilder.append(obj);
            stringBuilder.append(10);
        }
        if (th.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            a(stringBuilder, th.getCause(), "");
        }
    }

    private List<Throwable> T(Throwable th) {
        List<Throwable> arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            th = cause.getCause();
            if (th == null || th == cause) {
                return arrayList;
            }
            cause = th;
        }
        return arrayList;
    }

    Throwable U(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.cause == cause) {
            return th;
        }
        while (true) {
            th = cause.getCause();
            if (th == null || th == cause) {
                return cause;
            }
            cause = th;
        }
        return cause;
    }
}
