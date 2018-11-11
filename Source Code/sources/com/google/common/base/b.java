package com.google.common.base;

import java.util.Arrays;

/* compiled from: CharMatcher */
public abstract class b implements j<Character> {
    @Deprecated
    public static final b LW = pw();
    @Deprecated
    public static final b LX = px();
    @Deprecated
    public static final b LZ = py();
    @Deprecated
    public static final b Ma = pz();
    @Deprecated
    public static final b Mb = pA();
    @Deprecated
    public static final b Mc = pB();
    @Deprecated
    public static final b Md = pC();
    @Deprecated
    public static final b Me = pD();
    @Deprecated
    public static final b Mf = pE();
    @Deprecated
    public static final b Mg = pF();
    @Deprecated
    public static final b Mh = pG();
    @Deprecated
    public static final b Mi = pH();
    @Deprecated
    public static final b Mj = pu();
    @Deprecated
    public static final b Mk = pv();

    /* compiled from: CharMatcher */
    private static final class c extends b {
        static final b Mn = new c();

        public boolean b(char c) {
            boolean z = true;
            if (!(c == ' ' || c == 133 || c == 5760)) {
                if (c == 8199) {
                    return false;
                }
                if (!(c == 8287 || c == 12288)) {
                    switch (c) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            switch (c) {
                                case 8232:
                                case 8233:
                                    break;
                                default:
                                    if (c < 8192 || c > 8202) {
                                        z = false;
                                    }
                                    return z;
                            }
                    }
                }
            }
            return true;
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }

        private c() {
        }
    }

    /* compiled from: CharMatcher */
    static abstract class e extends b {
        e() {
        }
    }

    /* compiled from: CharMatcher */
    private static final class h extends b {
        static final h Mr = new h();

        public String toString() {
            return "CharMatcher.javaDigit()";
        }

        private h() {
        }

        public boolean b(char c) {
            return Character.isDigit(c);
        }
    }

    /* compiled from: CharMatcher */
    private static final class j extends b {
        static final j Mt = new j();

        public String toString() {
            return "CharMatcher.javaLetter()";
        }

        private j() {
        }

        public boolean b(char c) {
            return Character.isLetter(c);
        }
    }

    /* compiled from: CharMatcher */
    private static final class k extends b {
        static final k Mu = new k();

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }

        private k() {
        }

        public boolean b(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    /* compiled from: CharMatcher */
    private static final class l extends b {
        static final l Mv = new l();

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }

        private l() {
        }

        public boolean b(char c) {
            return Character.isLowerCase(c);
        }
    }

    /* compiled from: CharMatcher */
    private static final class m extends b {
        static final m Mw = new m();

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }

        private m() {
        }

        public boolean b(char c) {
            return Character.isUpperCase(c);
        }
    }

    /* compiled from: CharMatcher */
    private static class p extends b {
        private final char[] My;
        private final char[] Mz;
        private final String description;

        p(String str, char[] cArr, char[] cArr2) {
            this.description = str;
            this.My = cArr;
            this.Mz = cArr2;
            i.checkArgument(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                i.checkArgument(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    i.checkArgument(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        public boolean b(char c) {
            int binarySearch = Arrays.binarySearch(this.My, c);
            boolean z = true;
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.Mz[binarySearch]) {
                z = false;
            }
            return z;
        }

        public String toString() {
            return this.description;
        }
    }

    /* compiled from: CharMatcher */
    private static final class d extends p {
        static final d Mo = new d();

        private static char[] pI() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }

        private static char[] pJ() {
            char[] cArr = new char["0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".length()];
            for (int i = 0; i < "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".length(); i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i) + 9);
            }
            return cArr;
        }

        private d() {
            super("CharMatcher.digit()", pI(), pJ());
        }
    }

    /* compiled from: CharMatcher */
    private static final class f extends p {
        static final f Mp = new f();

        private f() {
            super("CharMatcher.invisible()", "\u0000­؀؜۝܏࣢ ᠎   ⁦　?﻿￹".toCharArray(), "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻".toCharArray());
        }
    }

    /* compiled from: CharMatcher */
    private static final class g extends e {
        private final char Mq;

        g(char c) {
            this.Mq = c;
        }

        public boolean b(char c) {
            return c == this.Mq;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CharMatcher.is('");
            stringBuilder.append(b.c(this.Mq));
            stringBuilder.append("')");
            return stringBuilder.toString();
        }
    }

    /* compiled from: CharMatcher */
    static abstract class n extends e {
        private final String description;

        n(String str) {
            this.description = (String) i.checkNotNull(str);
        }

        public final String toString() {
            return this.description;
        }
    }

    /* compiled from: CharMatcher */
    private static final class q extends p {
        static final q MB = new q();

        private q() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    /* compiled from: CharMatcher */
    private static final class a extends n {
        static final a Ml = new a();

        public boolean b(char c) {
            return true;
        }

        private a() {
            super("CharMatcher.any()");
        }

        public int a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            i.t(i, length);
            return i == length ? -1 : i;
        }
    }

    /* compiled from: CharMatcher */
    private static final class b extends n {
        static final b Mm = new b();

        public boolean b(char c) {
            return c <= 127;
        }

        b() {
            super("CharMatcher.ascii()");
        }
    }

    /* compiled from: CharMatcher */
    private static final class i extends n {
        static final i Ms = new i();

        public boolean b(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }

        private i() {
            super("CharMatcher.javaIsoControl()");
        }
    }

    /* compiled from: CharMatcher */
    private static final class o extends n {
        static final o Mx = new o();

        public boolean b(char c) {
            return false;
        }

        private o() {
            super("CharMatcher.none()");
        }

        public int a(CharSequence charSequence, int i) {
            i.t(i, charSequence.length());
            return -1;
        }
    }

    /* compiled from: CharMatcher */
    static final class r extends n {
        static final r MI = new r();
        static final int SHIFT = Integer.numberOfLeadingZeros(" 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".length() - 1);

        r() {
            super("CharMatcher.whitespace()");
        }

        public boolean b(char c) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((1682554634 * c) >>> SHIFT) == c;
        }
    }

    public abstract boolean b(char c);

    public static b pu() {
        return a.Ml;
    }

    public static b pv() {
        return o.Mx;
    }

    public static b pw() {
        return r.MI;
    }

    public static b px() {
        return c.Mn;
    }

    public static b py() {
        return b.Mm;
    }

    @Deprecated
    public static b pz() {
        return d.Mo;
    }

    @Deprecated
    public static b pA() {
        return h.Mr;
    }

    @Deprecated
    public static b pB() {
        return j.Mt;
    }

    @Deprecated
    public static b pC() {
        return k.Mu;
    }

    @Deprecated
    public static b pD() {
        return m.Mw;
    }

    @Deprecated
    public static b pE() {
        return l.Mv;
    }

    public static b pF() {
        return i.Ms;
    }

    @Deprecated
    public static b pG() {
        return f.Mp;
    }

    @Deprecated
    public static b pH() {
        return q.MB;
    }

    public static b a(char c) {
        return new g(c);
    }

    protected b() {
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        i.t(i, length);
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Deprecated
    /* renamed from: a */
    public boolean apply(Character ch) {
        return b(ch.charValue());
    }

    public String toString() {
        return super.toString();
    }

    private static String c(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            int c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
