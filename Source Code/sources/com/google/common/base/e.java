package com.google.common.base;

import java.util.Arrays;

/* compiled from: MoreObjects */
public final class e {

    /* compiled from: MoreObjects */
    public static final class a {
        private final a Ng;
        private a Nh;
        private boolean Ni;
        private final String className;

        /* compiled from: MoreObjects */
        private static final class a {
            a Nj;
            String name;
            Object value;

            private a() {
            }
        }

        private a(String str) {
            this.Ng = new a();
            this.Nh = this.Ng;
            this.Ni = false;
            this.className = (String) i.checkNotNull(str);
        }

        public a d(String str, Object obj) {
            return e(str, obj);
        }

        public a n(String str, int i) {
            return e(str, String.valueOf(i));
        }

        public a e(String str, long j) {
            return e(str, String.valueOf(j));
        }

        public a C(Object obj) {
            return D(obj);
        }

        public String toString() {
            boolean z = this.Ni;
            String str = "";
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(this.className);
            stringBuilder.append('{');
            for (a aVar = this.Ng.Nj; aVar != null; aVar = aVar.Nj) {
                Object obj = aVar.value;
                if (!z || obj != null) {
                    stringBuilder.append(str);
                    str = ", ";
                    if (aVar.name != null) {
                        stringBuilder.append(aVar.name);
                        stringBuilder.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        stringBuilder.append(obj);
                    } else {
                        CharSequence deepToString = Arrays.deepToString(new Object[]{obj});
                        stringBuilder.append(deepToString, 1, deepToString.length() - 1);
                    }
                }
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        private a pM() {
            a aVar = new a();
            this.Nh.Nj = aVar;
            this.Nh = aVar;
            return aVar;
        }

        private a D(Object obj) {
            pM().value = obj;
            return this;
        }

        private a e(String str, Object obj) {
            a pM = pM();
            pM.value = obj;
            pM.name = (String) i.checkNotNull(str);
            return this;
        }
    }

    public static <T> T h(T t, T t2) {
        return t != null ? t : i.checkNotNull(t2);
    }

    public static a B(Object obj) {
        return new a(obj.getClass().getSimpleName());
    }
}
