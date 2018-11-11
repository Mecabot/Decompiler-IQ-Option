package org.apache.commons.lang3.builder;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.b;
import org.apache.commons.lang3.d;

public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle fbG = new DefaultToStringStyle();
    public static final ToStringStyle fbH = new MultiLineToStringStyle();
    public static final ToStringStyle fbI = new NoFieldNameToStringStyle();
    public static final ToStringStyle fbJ = new ShortPrefixToStringStyle();
    public static final ToStringStyle fbK = new SimpleToStringStyle();
    private static final ThreadLocal<WeakHashMap<Object, Object>> fbL = new ThreadLocal();
    private static final long serialVersionUID = -2587890625525655916L;
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private String arraySeparator = ",";
    private String arrayStart = "{";
    private String contentEnd = "]";
    private String contentStart = "[";
    private boolean defaultFullDetail = true;
    private String fieldNameValueSeparator = "=";
    private String fieldSeparator = ",";
    private boolean fieldSeparatorAtEnd = false;
    private boolean fieldSeparatorAtStart = false;
    private String nullText = "<null>";
    private String sizeEndText = ">";
    private String sizeStartText = "<size=";
    private String summaryObjectEndText = ">";
    private String summaryObjectStartText = "<";
    private boolean useClassName = true;
    private boolean useFieldNames = true;
    private boolean useIdentityHashCode = true;
    private boolean useShortClassName = false;

    private static final class DefaultToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        DefaultToStringStyle() {
        }

        private Object readResolve() {
            return ToStringStyle.fbG;
        }
    }

    private static final class MultiLineToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        MultiLineToStringStyle() {
            nl("[");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.eZD);
            stringBuilder.append("  ");
            nn(stringBuilder.toString());
            hq(true);
            stringBuilder = new StringBuilder();
            stringBuilder.append(d.eZD);
            stringBuilder.append("]");
            nm(stringBuilder.toString());
        }

        private Object readResolve() {
            return ToStringStyle.fbH;
        }
    }

    private static final class NoFieldNameToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        NoFieldNameToStringStyle() {
            hp(false);
        }

        private Object readResolve() {
            return ToStringStyle.fbI;
        }
    }

    private static final class ShortPrefixToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        ShortPrefixToStringStyle() {
            hn(true);
            ho(false);
        }

        private Object readResolve() {
            return ToStringStyle.fbJ;
        }
    }

    private static final class SimpleToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        SimpleToStringStyle() {
            hm(false);
            ho(false);
            hp(false);
            nl("");
            nm("");
        }

        private Object readResolve() {
            return ToStringStyle.fbK;
        }
    }

    static Map<Object, Object> bAs() {
        return (Map) fbL.get();
    }

    static boolean dr(Object obj) {
        Map bAs = bAs();
        return bAs != null && bAs.containsKey(obj);
    }

    static void aD(Object obj) {
        if (obj != null) {
            if (bAs() == null) {
                fbL.set(new WeakHashMap());
            }
            bAs().put(obj, null);
        }
    }

    static void unregister(Object obj) {
        if (obj != null) {
            Map bAs = bAs();
            if (bAs != null) {
                bAs.remove(obj);
                if (bAs.isEmpty()) {
                    fbL.remove();
                }
            }
        }
    }

    protected ToStringStyle() {
    }

    public void b(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            d(stringBuffer, obj);
            e(stringBuffer, obj);
            b(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                d(stringBuffer);
            }
        }
    }

    public void c(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            a(stringBuffer);
        }
        c(stringBuffer);
        unregister(obj);
    }

    protected void a(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            Object obj = null;
            for (int i = 0; i < length2; i++) {
                if (stringBuffer.charAt((length - 1) - i) != this.fieldSeparator.charAt((length2 - 1) - i)) {
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        b(stringBuffer, str);
        if (obj == null) {
            a(stringBuffer, str);
        } else {
            a(stringBuffer, str, obj, v(bool));
        }
        c(stringBuffer, str);
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (!dr(obj) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character)) {
            aD(obj);
            try {
                if (obj instanceof Collection) {
                    if (z) {
                        a(stringBuffer, str, (Collection) obj);
                    } else {
                        b(stringBuffer, str, ((Collection) obj).size());
                    }
                } else if (obj instanceof Map) {
                    if (z) {
                        a(stringBuffer, str, (Map) obj);
                    } else {
                        b(stringBuffer, str, ((Map) obj).size());
                    }
                } else if (obj instanceof long[]) {
                    if (z) {
                        a(stringBuffer, str, (long[]) obj);
                    } else {
                        b(stringBuffer, str, (long[]) obj);
                    }
                } else if (obj instanceof int[]) {
                    if (z) {
                        a(stringBuffer, str, (int[]) obj);
                    } else {
                        b(stringBuffer, str, (int[]) obj);
                    }
                } else if (obj instanceof short[]) {
                    if (z) {
                        a(stringBuffer, str, (short[]) obj);
                    } else {
                        b(stringBuffer, str, (short[]) obj);
                    }
                } else if (obj instanceof byte[]) {
                    if (z) {
                        a(stringBuffer, str, (byte[]) obj);
                    } else {
                        b(stringBuffer, str, (byte[]) obj);
                    }
                } else if (obj instanceof char[]) {
                    if (z) {
                        a(stringBuffer, str, (char[]) obj);
                    } else {
                        b(stringBuffer, str, (char[]) obj);
                    }
                } else if (obj instanceof double[]) {
                    if (z) {
                        a(stringBuffer, str, (double[]) obj);
                    } else {
                        b(stringBuffer, str, (double[]) obj);
                    }
                } else if (obj instanceof float[]) {
                    if (z) {
                        a(stringBuffer, str, (float[]) obj);
                    } else {
                        b(stringBuffer, str, (float[]) obj);
                    }
                } else if (obj instanceof boolean[]) {
                    if (z) {
                        a(stringBuffer, str, (boolean[]) obj);
                    } else {
                        b(stringBuffer, str, (boolean[]) obj);
                    }
                } else if (obj.getClass().isArray()) {
                    if (z) {
                        a(stringBuffer, str, (Object[]) obj);
                    } else {
                        b(stringBuffer, str, (Object[]) obj);
                    }
                } else if (z) {
                    b(stringBuffer, str, obj);
                } else {
                    c(stringBuffer, str, obj);
                }
                unregister(obj);
            } catch (Throwable th) {
                unregister(obj);
            }
        } else {
            a(stringBuffer, str, obj);
        }
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj) {
        ObjectUtils.a(stringBuffer, obj);
    }

    protected void b(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void a(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected void a(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    protected void c(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(X(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    protected void a(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    protected void a(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    protected void a(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append(s);
    }

    protected void a(StringBuffer stringBuffer, String str, byte b) {
        stringBuffer.append(b);
    }

    protected void a(StringBuffer stringBuffer, String str, char c) {
        stringBuffer.append(c);
    }

    protected void a(StringBuffer stringBuffer, String str, double d) {
        stringBuffer.append(d);
    }

    protected void a(StringBuffer stringBuffer, String str, float f) {
        stringBuffer.append(f);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    protected void a(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                a(stringBuffer, str);
            } else {
                a(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void d(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                a(stringBuffer, str);
            } else {
                a(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, Object[] objArr) {
        b(stringBuffer, str, objArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, long[] jArr) {
        b(stringBuffer, str, jArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, int[] iArr) {
        b(stringBuffer, str, iArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, short[] sArr) {
        b(stringBuffer, str, sArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, byte[] bArr) {
        b(stringBuffer, str, bArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, char[] cArr) {
        b(stringBuffer, str, cArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, double[] dArr) {
        b(stringBuffer, str, dArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, float[] fArr) {
        b(stringBuffer, str, fArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            a(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, String str, boolean[] zArr) {
        b(stringBuffer, str, zArr.length);
    }

    protected void d(StringBuffer stringBuffer, Object obj) {
        if (this.useClassName && obj != null) {
            aD(obj);
            if (this.useShortClassName) {
                stringBuffer.append(X(obj.getClass()));
            } else {
                stringBuffer.append(obj.getClass().getName());
            }
        }
    }

    protected void e(StringBuffer stringBuffer, Object obj) {
        if (bAt() && obj != null) {
            aD(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    protected void b(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    protected void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    protected void a(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    protected void d(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    protected void b(StringBuffer stringBuffer, String str) {
        if (this.useFieldNames && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    protected void c(StringBuffer stringBuffer, String str) {
        d(stringBuffer);
    }

    protected void b(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i);
        stringBuffer.append(this.sizeEndText);
    }

    protected boolean v(Boolean bool) {
        if (bool == null) {
            return this.defaultFullDetail;
        }
        return bool.booleanValue();
    }

    protected String X(Class<?> cls) {
        return b.X(cls);
    }

    protected void hm(boolean z) {
        this.useClassName = z;
    }

    protected void hn(boolean z) {
        this.useShortClassName = z;
    }

    protected boolean bAt() {
        return this.useIdentityHashCode;
    }

    protected void ho(boolean z) {
        this.useIdentityHashCode = z;
    }

    protected void hp(boolean z) {
        this.useFieldNames = z;
    }

    protected void nl(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    protected void nm(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    protected void nn(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    protected void hq(boolean z) {
        this.fieldSeparatorAtStart = z;
    }

    protected String bAu() {
        return this.nullText;
    }
}
