package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;

public class Joiner {
    private final String separator;

    /* synthetic */ Joiner(Joiner joiner, AnonymousClass1 anonymousClass1) {
        this(joiner);
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public static Joiner e(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String str) {
        this.separator = (String) i.checkNotNull(str);
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public <A extends Appendable> A a(A a, Iterator<?> it) {
        i.checkNotNull(a);
        if (it.hasNext()) {
            a.append(A(it.next()));
            while (it.hasNext()) {
                a.append(this.separator);
                a.append(A(it.next()));
            }
        }
        return a;
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterable<?> iterable) {
        return a(stringBuilder, iterable.iterator());
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public final String join(Iterator<?> it) {
        return a(new StringBuilder(), (Iterator) it).toString();
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    public final String join(Object obj, Object obj2, Object... objArr) {
        return join(a(obj, obj2, objArr));
    }

    public Joiner cF(final String str) {
        i.checkNotNull(str);
        return new Joiner(this) {
            CharSequence A(Object obj) {
                return obj == null ? str : Joiner.this.A(obj);
            }

            public Joiner cF(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    CharSequence A(Object obj) {
        i.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    private static Iterable<Object> a(final Object obj, final Object obj2, final Object[] objArr) {
        i.checkNotNull(objArr);
        return new AbstractList<Object>() {
            public int size() {
                return objArr.length + 2;
            }

            public Object get(int i) {
                switch (i) {
                    case 0:
                        return obj;
                    case 1:
                        return obj2;
                    default:
                        return objArr[i - 2];
                }
            }
        };
    }
}
