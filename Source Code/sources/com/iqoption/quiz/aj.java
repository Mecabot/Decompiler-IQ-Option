package com.iqoption.quiz;

import android.util.Patterns;
import com.iqoption.core.ext.c;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004¨\u0006\u001e"}, aXE = {"Lcom/iqoption/quiz/Util;", "", "()V", "formatAmount", "", "amount", "Ljava/math/BigDecimal;", "minorUnits", "", "mask", "formatOnline", "", "data", "getDisplayNameFromEmail", "email", "getDisplayNameSurnameFromEmail", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getUserAgent", "context", "Landroid/content/Context;", "applicationName", "isValidEmail", "", "nonNullString", "str", "parseDottedFullName", "Lcom/iqoption/quiz/Util$ParsedName;", "fullName", "ParsedName", "quiz_release"})
/* compiled from: Util.kt */
public final class aj {
    public static final aj dhZ = new aj();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b¨\u0006\u000f"}, aXE = {"Lcom/iqoption/quiz/Util$ParsedName;", "", "firstName", "", "(Ljava/lang/String;)V", "lastName", "(Ljava/lang/String;Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "fullName", "getFullName", "initials", "getInitials", "getLastName", "Companion", "quiz_release"})
    /* compiled from: Util.kt */
    public static final class a {
        private static final a dib = new a("");
        public static final a dic = new a();
        private final String dia;
        private final String firstName;
        private final String fullName;
        private final String lastName;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, aXE = {"Lcom/iqoption/quiz/Util$ParsedName$Companion;", "", "()V", "EMPTY_NAME", "Lcom/iqoption/quiz/Util$ParsedName;", "getEMPTY_NAME", "()Lcom/iqoption/quiz/Util$ParsedName;", "fromFullName", "fullName", "", "quiz_release"})
        /* compiled from: Util.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final a azG() {
                return a.dib;
            }

            public final a je(String str) {
                h.e(str, "fullName");
                CharSequence charSequence = str;
                int length = charSequence.length() - 1;
                int i = 0;
                Object obj = null;
                while (i <= length) {
                    Object obj2 = charSequence.charAt(obj == null ? i : length) <= ' ' ? 1 : null;
                    if (obj == null) {
                        if (obj2 == null) {
                            obj = 1;
                        } else {
                            i++;
                        }
                    } else if (obj2 == null) {
                        break;
                    } else {
                        length--;
                    }
                }
                str = charSequence.subSequence(i, length + 1).toString();
                i = v.b((CharSequence) str, ' ', 0, false, 6, null);
                if (i == -1 || i + 2 >= str.length()) {
                    return new a(str);
                }
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(0, i);
                h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                i++;
                int length2 = str.length();
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                str = str.substring(i, length2);
                h.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new a(substring, str);
            }
        }

        public a(String str, String str2) {
            h.e(str, "firstName");
            this.firstName = str;
            this.lastName = str2;
            if (this.lastName != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.valueOf(this.firstName.charAt(0)));
                stringBuilder.append(String.valueOf(this.lastName.charAt(0)));
                this.dia = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.firstName);
                stringBuilder.append(' ');
                stringBuilder.append(this.lastName);
                this.fullName = stringBuilder.toString();
                return;
            }
            str = this.firstName;
            int min = Math.min(this.firstName.length(), 3);
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(0, min);
            h.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.toUpperCase();
            h.d(str, "(this as java.lang.String).toUpperCase()");
            this.dia = str;
            this.fullName = this.firstName;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getInitials() {
            return this.dia;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public a(String str) {
            h.e(str, "firstName");
            this(str, null);
        }
    }

    public final String jc(String str) {
        return str != null ? str : "";
    }

    private aj() {
    }

    public final String a(BigDecimal bigDecimal, int i, String str) {
        h.e(bigDecimal, "amount");
        String toPlainString;
        if (str == null) {
            toPlainString = bigDecimal.setScale(i, 1).toPlainString();
            h.d(toPlainString, "amount.setScale(minorUni…UND_DOWN).toPlainString()");
            return toPlainString;
        }
        m mVar = m.euz;
        Locale locale = Locale.US;
        h.d(locale, "Locale.US");
        Object[] objArr = new Object[]{bigDecimal.setScale(i, 1).toPlainString()};
        toPlainString = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        h.d(toPlainString, "java.lang.String.format(locale, format, *args)");
        return toPlainString;
    }

    public final boolean z(CharSequence charSequence) {
        return charSequence == null ? false : Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public final CharSequence gm(int i) {
        if (i < 1000) {
            return String.valueOf(i);
        }
        if (i < 1000000) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c.b(((double) i) / ((double) 1000), 1));
            stringBuilder.append('K');
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(c.b(((double) i) / ((double) 1000000), 1));
        stringBuilder2.append('M');
        return stringBuilder2.toString();
    }

    public final a jd(String str) {
        h.e(str, "fullName");
        CharSequence charSequence = str;
        if ((charSequence.length() == 0 ? 1 : null) != null) {
            return a.dic.azG();
        }
        List k = new Regex("\\.").k(charSequence, 0);
        if (!k.isEmpty()) {
            ListIterator listIterator = k.listIterator(k.size());
            while (listIterator.hasPrevious()) {
                Object obj;
                if (((String) listIterator.previous()).length() == 0) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    k = u.g(k, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        k = m.emptyList();
        Collection collection = k;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Object[] toArray = collection.toArray(new String[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) toArray;
        StringBuilder stringBuilder;
        String valueOf;
        if (strArr.length == 1) {
            stringBuilder = new StringBuilder();
            valueOf = String.valueOf(strArr[0].charAt(0));
            if (valueOf == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            valueOf = valueOf.toUpperCase();
            h.d(valueOf, "(this as java.lang.String).toUpperCase()");
            stringBuilder.append(valueOf);
            str = strArr[0];
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(1);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            if (str.length() == 0) {
                str = "Name";
            }
            return new a(str);
        }
        stringBuilder = new StringBuilder();
        valueOf = String.valueOf(strArr[0].charAt(0));
        if (valueOf == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        valueOf = valueOf.toUpperCase();
        h.d(valueOf, "(this as java.lang.String).toUpperCase()");
        stringBuilder.append(valueOf);
        valueOf = strArr[0];
        if (valueOf == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        valueOf = valueOf.substring(1);
        h.d(valueOf, "(this as java.lang.String).substring(startIndex)");
        stringBuilder.append(valueOf);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        String valueOf2 = String.valueOf(strArr[1].charAt(0));
        if (valueOf2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        valueOf2 = valueOf2.toUpperCase();
        h.d(valueOf2, "(this as java.lang.String).toUpperCase()");
        stringBuilder3.append(valueOf2);
        str = strArr[1];
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        str = str.substring(1);
        h.d(str, "(this as java.lang.String).substring(startIndex)");
        stringBuilder3.append(str);
        return new a(stringBuilder2, stringBuilder3.toString());
    }
}
