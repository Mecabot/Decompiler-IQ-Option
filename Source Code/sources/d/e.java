package d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: OSParser */
public class e {
    private final List<a> flb;

    /* compiled from: OSParser */
    protected static class a {
        private final String fli;
        private final String flj;
        private final String flk;
        private final String fll;
        private final Pattern pattern;

        public a(Pattern pattern, String str, String str2, String str3, String str4) {
            this.pattern = pattern;
            this.fli = str;
            this.flj = str2;
            this.flk = str3;
            this.fll = str4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
        public d.d oe(java.lang.String r10) {
            /*
            r9 = this;
            r0 = r9.pattern;
            r10 = r0.matcher(r10);
            r0 = r10.find();
            r1 = 0;
            if (r0 != 0) goto L_0x000e;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r10.groupCount();
            r2 = r9.fli;
            r3 = 1;
            if (r2 == 0) goto L_0x004c;
        L_0x0017:
            if (r0 < r3) goto L_0x0049;
        L_0x0019:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r4 = "(";
            r2.append(r4);
            r4 = "$1";
            r4 = java.util.regex.Pattern.quote(r4);
            r2.append(r4);
            r4 = ")";
            r2.append(r4);
            r2 = r2.toString();
            r2 = java.util.regex.Pattern.compile(r2);
            r4 = r9.fli;
            r2 = r2.matcher(r4);
            r3 = r10.group(r3);
            r2 = r2.replaceAll(r3);
        L_0x0047:
            r4 = r2;
            goto L_0x0054;
        L_0x0049:
            r2 = r9.fli;
            goto L_0x0047;
        L_0x004c:
            if (r0 < r3) goto L_0x0053;
        L_0x004e:
            r2 = r10.group(r3);
            goto L_0x0047;
        L_0x0053:
            r4 = r1;
        L_0x0054:
            r2 = r9.flj;
            if (r2 == 0) goto L_0x0060;
        L_0x0058:
            r2 = r9.flj;
            r2 = r9.a(r10, r2);
        L_0x005e:
            r5 = r2;
            goto L_0x0069;
        L_0x0060:
            r2 = 2;
            if (r0 < r2) goto L_0x0068;
        L_0x0063:
            r2 = r10.group(r2);
            goto L_0x005e;
        L_0x0068:
            r5 = r1;
        L_0x0069:
            r2 = r9.flk;
            if (r2 == 0) goto L_0x0075;
        L_0x006d:
            r2 = r9.flk;
            r2 = r9.a(r10, r2);
        L_0x0073:
            r6 = r2;
            goto L_0x007e;
        L_0x0075:
            r2 = 3;
            if (r0 < r2) goto L_0x007d;
        L_0x0078:
            r2 = r10.group(r2);
            goto L_0x0073;
        L_0x007d:
            r6 = r1;
        L_0x007e:
            r2 = r9.fll;
            if (r2 == 0) goto L_0x008a;
        L_0x0082:
            r2 = r9.fll;
            r2 = r9.a(r10, r2);
        L_0x0088:
            r7 = r2;
            goto L_0x0093;
        L_0x008a:
            r2 = 4;
            if (r0 < r2) goto L_0x0092;
        L_0x008d:
            r2 = r10.group(r2);
            goto L_0x0088;
        L_0x0092:
            r7 = r1;
        L_0x0093:
            r2 = 5;
            if (r0 < r2) goto L_0x009c;
        L_0x0096:
            r10 = r10.group(r2);
            r8 = r10;
            goto L_0x009d;
        L_0x009c:
            r8 = r1;
        L_0x009d:
            if (r4 != 0) goto L_0x00a1;
        L_0x009f:
            r10 = r1;
            goto L_0x00a7;
        L_0x00a1:
            r10 = new d.d;
            r3 = r10;
            r3.<init>(r4, r5, r6, r7, r8);
        L_0x00a7:
            return r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: d.e.a.oe(java.lang.String):d.d");
        }

        private String a(Matcher matcher, String str) {
            return of(str) ? matcher.group(og(str)) : str;
        }

        private boolean of(String str) {
            return str.startsWith("$");
        }

        private int og(String str) {
            return Integer.valueOf(str.substring(1)).intValue();
        }
    }

    public e(List<a> list) {
        this.flb = list;
    }

    public static e cu(List<Map<String, String>> list) {
        List arrayList = new ArrayList();
        for (Map R : list) {
            arrayList.add(R(R));
        }
        return new e(arrayList);
    }

    public d od(String str) {
        if (str == null) {
            return null;
        }
        for (a oe : this.flb) {
            d oe2 = oe.oe(str);
            if (oe2 != null) {
                return oe2;
            }
        }
        return new d("Other", null, null, null, null);
    }

    protected static a R(Map<String, String> map) {
        String str = (String) map.get("regex");
        if (str != null) {
            return new a(Pattern.compile(str), (String) map.get("os_replacement"), (String) map.get("os_v1_replacement"), (String) map.get("os_v2_replacement"), (String) map.get("os_v3_replacement"));
        }
        throw new IllegalArgumentException("OS is missing regex");
    }
}
