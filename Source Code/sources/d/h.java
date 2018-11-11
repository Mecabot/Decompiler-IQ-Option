package d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: UserAgentParser */
public class h {
    private final List<a> flb;

    /* compiled from: UserAgentParser */
    protected static class a {
        private final String flj;
        private final String flk;
        private final String flp;
        private final Pattern pattern;

        public a(Pattern pattern, String str, String str2, String str3) {
            this.pattern = pattern;
            this.flp = str;
            this.flj = str2;
            this.flk = str3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
        public d.g ol(java.lang.String r7) {
            /*
            r6 = this;
            r0 = r6.pattern;
            r7 = r0.matcher(r7);
            r0 = r7.find();
            r1 = 0;
            if (r0 != 0) goto L_0x000e;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r7.groupCount();
            r2 = r6.flp;
            r3 = 1;
            if (r2 == 0) goto L_0x003d;
        L_0x0017:
            r2 = r6.flp;
            r4 = "$1";
            r2 = r2.contains(r4);
            if (r2 == 0) goto L_0x003a;
        L_0x0021:
            if (r0 < r3) goto L_0x003a;
        L_0x0023:
            r2 = r7.group(r3);
            if (r2 == 0) goto L_0x003a;
        L_0x0029:
            r2 = r6.flp;
            r4 = "\\$1";
            r3 = r7.group(r3);
            r3 = java.util.regex.Matcher.quoteReplacement(r3);
            r2 = r2.replaceFirst(r4, r3);
            goto L_0x0045;
        L_0x003a:
            r2 = r6.flp;
            goto L_0x0045;
        L_0x003d:
            if (r0 < r3) goto L_0x0044;
        L_0x003f:
            r2 = r7.group(r3);
            goto L_0x0045;
        L_0x0044:
            r2 = r1;
        L_0x0045:
            r3 = r6.flj;
            if (r3 == 0) goto L_0x004c;
        L_0x0049:
            r3 = r6.flj;
            goto L_0x0055;
        L_0x004c:
            r3 = 2;
            if (r0 < r3) goto L_0x0054;
        L_0x004f:
            r3 = r7.group(r3);
            goto L_0x0055;
        L_0x0054:
            r3 = r1;
        L_0x0055:
            r4 = r6.flk;
            if (r4 == 0) goto L_0x005e;
        L_0x0059:
            r7 = r6.flk;
            r4 = r7;
        L_0x005c:
            r7 = r1;
            goto L_0x006f;
        L_0x005e:
            r4 = 3;
            if (r0 < r4) goto L_0x006d;
        L_0x0061:
            r4 = r7.group(r4);
            r5 = 4;
            if (r0 < r5) goto L_0x005c;
        L_0x0068:
            r7 = r7.group(r5);
            goto L_0x006f;
        L_0x006d:
            r7 = r1;
            r4 = r7;
        L_0x006f:
            if (r2 != 0) goto L_0x0072;
        L_0x0071:
            goto L_0x0077;
        L_0x0072:
            r1 = new d.g;
            r1.<init>(r2, r3, r4, r7);
        L_0x0077:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: d.h.a.ol(java.lang.String):d.g");
        }
    }

    public h(List<a> list) {
        this.flb = list;
    }

    public static h cv(List<Map<String, String>> list) {
        List arrayList = new ArrayList();
        for (Map S : list) {
            arrayList.add(S(S));
        }
        return new h(arrayList);
    }

    public g ok(String str) {
        if (str == null) {
            return null;
        }
        for (a ol : this.flb) {
            g ol2 = ol.ol(str);
            if (ol2 != null) {
                return ol2;
            }
        }
        return new g("Other", null, null, null);
    }

    protected static a S(Map<String, String> map) {
        String str = (String) map.get("regex");
        if (str != null) {
            return new a(Pattern.compile(str), (String) map.get("family_replacement"), (String) map.get("v1_replacement"), (String) map.get("v2_replacement"));
        }
        throw new IllegalArgumentException("User agent is missing regex");
    }
}
