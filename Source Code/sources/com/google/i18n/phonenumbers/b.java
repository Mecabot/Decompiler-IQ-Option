package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.internal.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AsYouTypeFormatter */
public class b {
    private static final PhoneMetadata ZL = new PhoneMetadata().dv("NA");
    private static final Pattern ZP = Pattern.compile("\\[([^\\[\\]])*\\]");
    private static final Pattern ZQ = Pattern.compile("\\d(?=[^,}][^,}])");
    private static final Pattern ZR = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*)+");
    private static final Pattern ZS = Pattern.compile("[- ]");
    private static final Pattern ZT = Pattern.compile(" ");
    private StringBuilder ZB = new StringBuilder();
    private String ZC = "";
    private StringBuilder ZD = new StringBuilder();
    private StringBuilder ZE = new StringBuilder();
    private boolean ZF = true;
    private boolean ZG = false;
    private boolean ZH = false;
    private boolean ZI = false;
    private final PhoneNumberUtil ZJ = PhoneNumberUtil.xo();
    private String ZK;
    private PhoneMetadata ZN;
    private PhoneMetadata ZO;
    private int ZU = 0;
    private int ZV = 0;
    private int ZX = 0;
    private StringBuilder ZY = new StringBuilder();
    private boolean ZZ = false;
    private String Zz = "";
    private String aaa = "";
    private StringBuilder aab = new StringBuilder();
    private List<NumberFormat> aac = new ArrayList();
    private c aad = new c(64);

    b(String str) {
        this.ZK = str;
        this.ZO = de(this.ZK);
        this.ZN = this.ZO;
    }

    private PhoneMetadata de(String str) {
        PhoneMetadata de = this.ZJ.de(this.ZJ.bG(this.ZJ.dn(str)));
        if (de != null) {
            return de;
        }
        return ZL;
    }

    private boolean xb() {
        Iterator it = this.aac.iterator();
        while (it.hasNext()) {
            NumberFormat numberFormat = (NumberFormat) it.next();
            String pattern = numberFormat.getPattern();
            if (this.ZC.equals(pattern)) {
                return false;
            }
            if (a(numberFormat)) {
                this.ZC = pattern;
                this.ZZ = ZS.matcher(numberFormat.xq()).find();
                this.ZU = 0;
                return true;
            }
            it.remove();
        }
        this.ZF = false;
        return false;
    }

    private void df(String str) {
        List xN;
        if (!this.ZH || this.ZO.xQ() <= 0) {
            xN = this.ZO.xN();
        } else {
            xN = this.ZO.xP();
        }
        boolean xG = this.ZO.xG();
        for (NumberFormat numberFormat : xN) {
            if ((!xG || this.ZH || numberFormat.xr() || PhoneNumberUtil.dl(numberFormat.xq())) && dg(numberFormat.getFormat())) {
                this.aac.add(numberFormat);
            }
        }
        dh(str);
    }

    private boolean dg(String str) {
        return ZR.matcher(str).matches();
    }

    private void dh(String str) {
        int length = str.length() - 3;
        Iterator it = this.aac.iterator();
        while (it.hasNext()) {
            NumberFormat numberFormat = (NumberFormat) it.next();
            if (numberFormat.xp() != 0) {
                if (!this.aad.dH(numberFormat.bH(Math.min(length, numberFormat.xp() - 1))).matcher(str).lookingAt()) {
                    it.remove();
                }
            }
        }
    }

    private boolean a(NumberFormat numberFormat) {
        CharSequence pattern = numberFormat.getPattern();
        if (pattern.indexOf(124) != -1) {
            return false;
        }
        String replaceAll = ZQ.matcher(ZP.matcher(pattern).replaceAll("\\\\d")).replaceAll("\\\\d");
        this.ZB.setLength(0);
        String S = S(replaceAll, numberFormat.getFormat());
        if (S.length() <= 0) {
            return false;
        }
        this.ZB.append(S);
        return true;
    }

    private String S(String str, String str2) {
        Matcher matcher = this.aad.dH(str).matcher("999999999999999");
        matcher.find();
        String group = matcher.group();
        if (group.length() < this.aab.length()) {
            return "";
        }
        return group.replaceAll(str, str2).replaceAll("9", " ");
    }

    public void clear() {
        this.Zz = "";
        this.ZD.setLength(0);
        this.ZE.setLength(0);
        this.ZB.setLength(0);
        this.ZU = 0;
        this.ZC = "";
        this.ZY.setLength(0);
        this.aaa = "";
        this.aab.setLength(0);
        this.ZF = true;
        this.ZG = false;
        this.ZX = 0;
        this.ZV = 0;
        this.ZH = false;
        this.ZI = false;
        this.aac.clear();
        this.ZZ = false;
        if (!this.ZO.equals(this.ZN)) {
            this.ZO = de(this.ZK);
        }
    }

    public String i(char c) {
        this.Zz = a(c, false);
        return this.Zz;
    }

    public String j(char c) {
        this.Zz = a(c, true);
        return this.Zz;
    }

    private String a(char c, boolean z) {
        this.ZD.append(c);
        if (z) {
            this.ZV = this.ZD.length();
        }
        if (k(c)) {
            c = b(c, z);
        } else {
            this.ZF = false;
            this.ZG = true;
        }
        if (this.ZF) {
            switch (this.ZE.length()) {
                case 0:
                case 1:
                case 2:
                    return this.ZD.toString();
                case 3:
                    if (xk()) {
                        this.ZI = true;
                        break;
                    }
                    this.aaa = xj();
                    return xg();
            }
            if (this.ZI) {
                if (xl()) {
                    this.ZI = false;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.ZY);
                stringBuilder.append(this.aab.toString());
                return stringBuilder.toString();
            } else if (this.aac.size() <= 0) {
                return xg();
            } else {
                String l = l(c);
                String xe = xe();
                if (xe.length() > 0) {
                    return xe;
                }
                dh(this.aab.toString());
                if (xb()) {
                    return xh();
                }
                if (this.ZF) {
                    l = di(l);
                } else {
                    l = this.ZD.toString();
                }
                return l;
            }
        } else if (this.ZG) {
            return this.ZD.toString();
        } else {
            if (xk()) {
                if (xl()) {
                    return xc();
                }
            } else if (xd()) {
                this.ZY.append(' ');
                return xc();
            }
            return this.ZD.toString();
        }
    }

    private String xc() {
        this.ZF = true;
        this.ZI = false;
        this.aac.clear();
        this.ZU = 0;
        this.ZB.setLength(0);
        this.ZC = "";
        return xg();
    }

    private boolean xd() {
        if (this.aaa.length() > 0) {
            this.aab.insert(0, this.aaa);
            this.ZY.setLength(this.ZY.lastIndexOf(this.aaa));
        }
        return this.aaa.equals(xj()) ^ 1;
    }

    private boolean k(char c) {
        if (Character.isDigit(c)) {
            return true;
        }
        if (this.ZD.length() == 1 && PhoneNumberUtil.aaw.matcher(Character.toString(c)).matches()) {
            return true;
        }
        return false;
    }

    String xe() {
        for (NumberFormat numberFormat : this.aac) {
            Matcher matcher = this.aad.dH(numberFormat.getPattern()).matcher(this.aab);
            if (matcher.matches()) {
                this.ZZ = ZS.matcher(numberFormat.xq()).find();
                return di(matcher.replaceAll(numberFormat.getFormat()));
            }
        }
        return "";
    }

    public int xf() {
        if (!this.ZF) {
            return this.ZV;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.ZX && i2 < this.Zz.length()) {
            if (this.ZE.charAt(i) == this.Zz.charAt(i2)) {
                i++;
            }
            i2++;
        }
        return i2;
    }

    private String di(String str) {
        int length = this.ZY.length();
        StringBuilder stringBuilder;
        if (!this.ZZ || length <= 0 || this.ZY.charAt(length - 1) == ' ') {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.ZY);
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(new String(this.ZY));
        stringBuilder.append(' ');
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String xg() {
        if (this.aab.length() < 3) {
            return di(this.aab.toString());
        }
        df(this.aab.toString());
        String xe = xe();
        if (xe.length() > 0) {
            return xe;
        }
        return xb() ? xh() : this.ZD.toString();
    }

    private String xh() {
        int length = this.aab.length();
        if (length <= 0) {
            return this.ZY.toString();
        }
        String str = "";
        for (int i = 0; i < length; i++) {
            str = l(this.aab.charAt(i));
        }
        return this.ZF ? di(str) : this.ZD.toString();
    }

    private boolean xi() {
        if (this.ZO.xE() != 1 || this.aab.charAt(0) != '1' || this.aab.charAt(1) == '0' || this.aab.charAt(1) == '1') {
            return false;
        }
        return true;
    }

    private String xj() {
        int i = 1;
        if (xi()) {
            StringBuilder stringBuilder = this.ZY;
            stringBuilder.append('1');
            stringBuilder.append(' ');
            this.ZH = true;
        } else {
            if (this.ZO.xJ()) {
                Matcher matcher = this.aad.dH(this.ZO.xK()).matcher(this.aab);
                if (matcher.lookingAt() && matcher.end() > 0) {
                    this.ZH = true;
                    i = matcher.end();
                    this.ZY.append(this.aab.substring(0, i));
                }
            }
            i = 0;
        }
        String substring = this.aab.substring(0, i);
        this.aab.delete(0, i);
        return substring;
    }

    private boolean xk() {
        c cVar = this.aad;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\+|");
        stringBuilder.append(this.ZO.xF());
        Matcher matcher = cVar.dH(stringBuilder.toString()).matcher(this.ZE);
        if (!matcher.lookingAt()) {
            return false;
        }
        this.ZH = true;
        int end = matcher.end();
        this.aab.setLength(0);
        this.aab.append(this.ZE.substring(end));
        this.ZY.setLength(0);
        this.ZY.append(this.ZE.substring(0, end));
        if (this.ZE.charAt(0) != '+') {
            this.ZY.append(' ');
        }
        return true;
    }

    private boolean xl() {
        if (this.aab.length() == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int a = this.ZJ.a(this.aab, stringBuilder);
        if (a == 0) {
            return false;
        }
        this.aab.setLength(0);
        this.aab.append(stringBuilder);
        String bG = this.ZJ.bG(a);
        if ("001".equals(bG)) {
            this.ZO = this.ZJ.bD(a);
        } else if (!bG.equals(this.ZK)) {
            this.ZO = de(bG);
        }
        bG = Integer.toString(a);
        StringBuilder stringBuilder2 = this.ZY;
        stringBuilder2.append(bG);
        stringBuilder2.append(' ');
        this.aaa = "";
        return true;
    }

    private char b(char c, boolean z) {
        if (c == '+') {
            this.ZE.append(c);
        } else {
            c = Character.forDigit(Character.digit(c, 10), 10);
            this.ZE.append(c);
            this.aab.append(c);
        }
        if (z) {
            this.ZX = this.ZE.length();
        }
        return c;
    }

    private String l(char c) {
        Matcher matcher = ZT.matcher(this.ZB);
        if (matcher.find(this.ZU)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c));
            this.ZB.replace(0, replaceFirst.length(), replaceFirst);
            this.ZU = matcher.start();
            return this.ZB.substring(0, this.ZU + 1);
        }
        if (this.aac.size() == 1) {
            this.ZF = false;
        }
        this.ZC = "";
        return this.ZD.toString();
    }
}
