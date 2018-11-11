package org.yaml.snakeyaml.scanner;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token.ID;
import org.yaml.snakeyaml.tokens.b;
import org.yaml.snakeyaml.tokens.d;
import org.yaml.snakeyaml.tokens.e;
import org.yaml.snakeyaml.tokens.f;
import org.yaml.snakeyaml.tokens.g;
import org.yaml.snakeyaml.tokens.h;
import org.yaml.snakeyaml.tokens.i;
import org.yaml.snakeyaml.tokens.j;
import org.yaml.snakeyaml.tokens.k;
import org.yaml.snakeyaml.tokens.l;
import org.yaml.snakeyaml.tokens.m;
import org.yaml.snakeyaml.tokens.n;
import org.yaml.snakeyaml.tokens.o;
import org.yaml.snakeyaml.tokens.p;
import org.yaml.snakeyaml.tokens.q;
import org.yaml.snakeyaml.tokens.r;
import org.yaml.snakeyaml.tokens.s;
import org.yaml.snakeyaml.tokens.t;
import org.yaml.snakeyaml.tokens.u;

/* compiled from: ScannerImpl */
public final class c implements b {
    private static final Pattern fkb = Pattern.compile("[^0-9A-Fa-f]");
    public static final Map<Character, String> fkc = new HashMap();
    public static final Map<Character, Integer> fkd = new HashMap();
    private boolean done = false;
    private int fhj = -1;
    private final org.yaml.snakeyaml.reader.a fke;
    private int fkf = 0;
    private List<Token> fkg;
    private int fkh = 0;
    private org.yaml.snakeyaml.d.a<Integer> fki;
    private boolean fkj = true;
    private Map<Integer, d> fkk;

    /* compiled from: ScannerImpl */
    private static class a {
        private final Boolean fkl;
        private final int fkm;

        public a(Boolean bool, int i) {
            this.fkl = bool;
            this.fkm = i;
        }

        public boolean bFu() {
            return this.fkl == null || this.fkl.booleanValue();
        }

        public boolean bFv() {
            return this.fkl != null && this.fkl.booleanValue();
        }

        public int getIncrement() {
            return this.fkm;
        }
    }

    static {
        fkc.put(Character.valueOf('0'), "\u0000");
        fkc.put(Character.valueOf('a'), "\u0007");
        fkc.put(Character.valueOf('b'), "\b");
        fkc.put(Character.valueOf('t'), "\t");
        fkc.put(Character.valueOf('n'), "\n");
        fkc.put(Character.valueOf('v'), "\u000b");
        fkc.put(Character.valueOf('f'), "\f");
        fkc.put(Character.valueOf('r'), "\r");
        fkc.put(Character.valueOf('e'), "\u001b");
        fkc.put(Character.valueOf(' '), " ");
        fkc.put(Character.valueOf('\"'), "\"");
        fkc.put(Character.valueOf('\\'), "\\");
        fkc.put(Character.valueOf('N'), "");
        fkc.put(Character.valueOf('_'), " ");
        fkc.put(Character.valueOf('L'), " ");
        fkc.put(Character.valueOf('P'), " ");
        fkd.put(Character.valueOf('x'), Integer.valueOf(2));
        fkd.put(Character.valueOf('u'), Integer.valueOf(4));
        fkd.put(Character.valueOf('U'), Integer.valueOf(8));
    }

    public c(org.yaml.snakeyaml.reader.a aVar) {
        this.fke = aVar;
        this.fkg = new ArrayList(100);
        this.fki = new org.yaml.snakeyaml.d.a(10);
        this.fkk = new LinkedHashMap();
        bEL();
    }

    public boolean a(ID... idArr) {
        while (bEF()) {
            bEG();
        }
        if (!this.fkg.isEmpty()) {
            if (idArr.length == 0) {
                return true;
            }
            ID bFx = ((Token) this.fkg.get(0)).bFx();
            for (ID id : idArr) {
                if (bFx == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public Token bED() {
        while (bEF()) {
            bEG();
        }
        return (Token) this.fkg.get(0);
    }

    public Token bEE() {
        if (this.fkg.isEmpty()) {
            return null;
        }
        this.fkh++;
        return (Token) this.fkg.remove(0);
    }

    private boolean bEF() {
        boolean z = false;
        if (this.done) {
            return false;
        }
        if (this.fkg.isEmpty()) {
            return true;
        }
        bEI();
        if (bEH() == this.fkh) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00dd  */
    private void bEG() {
        /*
        r5 = this;
        r5.bFn();
        r5.bEI();
        r0 = r5.fke;
        r0 = r0.getColumn();
        r5.nw(r0);
        r0 = r5.fke;
        r0 = r0.peek();
        switch(r0) {
            case 0: goto L_0x008e;
            case 33: goto L_0x008a;
            case 34: goto L_0x0086;
            case 37: goto L_0x007c;
            case 38: goto L_0x0078;
            case 39: goto L_0x0074;
            case 42: goto L_0x0070;
            case 44: goto L_0x006c;
            case 45: goto L_0x0058;
            case 46: goto L_0x004e;
            case 58: goto L_0x0044;
            case 62: goto L_0x003c;
            case 63: goto L_0x0032;
            case 91: goto L_0x002e;
            case 93: goto L_0x002a;
            case 123: goto L_0x0026;
            case 124: goto L_0x001e;
            case 125: goto L_0x001a;
            default: goto L_0x0018;
        };
    L_0x0018:
        goto L_0x0092;
    L_0x001a:
        r5.bET();
        return;
    L_0x001e:
        r1 = r5.fkf;
        if (r1 != 0) goto L_0x0092;
    L_0x0022:
        r5.bFb();
        return;
    L_0x0026:
        r5.bER();
        return;
    L_0x002a:
        r5.bES();
        return;
    L_0x002e:
        r5.bEQ();
        return;
    L_0x0032:
        r1 = r5.bFk();
        if (r1 == 0) goto L_0x0092;
    L_0x0038:
        r5.bEW();
        return;
    L_0x003c:
        r1 = r5.fkf;
        if (r1 != 0) goto L_0x0092;
    L_0x0040:
        r5.bFc();
        return;
    L_0x0044:
        r1 = r5.bFl();
        if (r1 == 0) goto L_0x0092;
    L_0x004a:
        r5.bEX();
        return;
    L_0x004e:
        r1 = r5.bFi();
        if (r1 == 0) goto L_0x0092;
    L_0x0054:
        r5.bEP();
        return;
    L_0x0058:
        r1 = r5.bFh();
        if (r1 == 0) goto L_0x0062;
    L_0x005e:
        r5.bEO();
        return;
    L_0x0062:
        r1 = r5.bFj();
        if (r1 == 0) goto L_0x0092;
    L_0x0068:
        r5.bEV();
        return;
    L_0x006c:
        r5.bEU();
        return;
    L_0x0070:
        r5.bEY();
        return;
    L_0x0074:
        r5.bFd();
        return;
    L_0x0078:
        r5.bEZ();
        return;
    L_0x007c:
        r1 = r5.bFg();
        if (r1 == 0) goto L_0x0092;
    L_0x0082:
        r5.bEN();
        return;
    L_0x0086:
        r5.bFe();
        return;
    L_0x008a:
        r5.bFa();
        return;
    L_0x008e:
        r5.bEM();
        return;
    L_0x0092:
        r1 = r5.bFm();
        if (r1 == 0) goto L_0x009c;
    L_0x0098:
        r5.bFf();
        return;
    L_0x009c:
        r1 = java.lang.Character.toChars(r0);
        r1 = java.lang.String.valueOf(r1);
        r2 = fkc;
        r2 = r2.keySet();
        r2 = r2.iterator();
    L_0x00ae:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00d9;
    L_0x00b4:
        r3 = r2.next();
        r3 = (java.lang.Character) r3;
        r4 = fkc;
        r4 = r4.get(r3);
        r4 = (java.lang.String) r4;
        r4 = r4.equals(r1);
        if (r4 == 0) goto L_0x00ae;
    L_0x00c8:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "\\";
        r1.append(r2);
        r1.append(r3);
        r1 = r1.toString();
    L_0x00d9:
        r2 = 9;
        if (r0 != r2) goto L_0x00ee;
    L_0x00dd:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r1);
        r1 = "(TAB)";
        r0.append(r1);
        r1 = r0.toString();
    L_0x00ee:
        r0 = "found character '%s' that cannot start any token. (Do not use %s for indentation)";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r1;
        r3 = 1;
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        r1 = new org.yaml.snakeyaml.scanner.ScannerException;
        r2 = "while scanning for the next token";
        r3 = 0;
        r4 = r5.fke;
        r4 = r4.bEy();
        r1.<init>(r2, r3, r0, r4);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.c.bEG():void");
    }

    private int bEH() {
        return !this.fkk.isEmpty() ? ((d) this.fkk.values().iterator().next()).bFw() : -1;
    }

    private void bEI() {
        if (!this.fkk.isEmpty()) {
            Iterator it = this.fkk.values().iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bDX() != this.fke.bDX() || this.fke.getIndex() - dVar.getIndex() > 1024) {
                    if (dVar.isRequired()) {
                        throw new ScannerException("while scanning a simple key", dVar.bEy(), "could not find expected ':'", this.fke.bEy());
                    }
                    it.remove();
                }
            }
        }
    }

    private void bEJ() {
        boolean z = this.fkf == 0 && this.fhj == this.fke.getColumn();
        if (!this.fkj && z) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        } else if (this.fkj) {
            bEK();
            this.fkk.put(Integer.valueOf(this.fkf), new d(this.fkh + this.fkg.size(), z, this.fke.getIndex(), this.fke.bDX(), this.fke.getColumn(), this.fke.bEy()));
        }
    }

    private void bEK() {
        d dVar = (d) this.fkk.remove(Integer.valueOf(this.fkf));
        if (dVar != null && dVar.isRequired()) {
            throw new ScannerException("while scanning a simple key", dVar.bEy(), "could not find expected ':'", this.fke.bEy());
        }
    }

    private void nw(int i) {
        if (this.fkf == 0) {
            while (this.fhj > i) {
                Mark bEy = this.fke.bEy();
                this.fhj = ((Integer) this.fki.pop()).intValue();
                this.fkg.add(new org.yaml.snakeyaml.tokens.c(bEy, bEy));
            }
        }
    }

    private boolean nx(int i) {
        if (this.fhj >= i) {
            return false;
        }
        this.fki.push(Integer.valueOf(this.fhj));
        this.fhj = i;
        return true;
    }

    private void bEL() {
        Mark bEy = this.fke.bEy();
        this.fkg.add(new r(bEy, bEy));
    }

    private void bEM() {
        nw(-1);
        bEK();
        this.fkj = false;
        this.fkk.clear();
        Mark bEy = this.fke.bEy();
        this.fkg.add(new q(bEy, bEy));
        this.done = true;
    }

    private void bEN() {
        nw(-1);
        bEK();
        this.fkj = false;
        this.fkg.add(bFo());
    }

    private void bEO() {
        hy(true);
    }

    private void bEP() {
        hy(false);
    }

    private void hy(boolean z) {
        Object iVar;
        nw(-1);
        bEK();
        this.fkj = false;
        Mark bEy = this.fke.bEy();
        this.fke.nq(3);
        Mark bEy2 = this.fke.bEy();
        if (z) {
            iVar = new i(bEy, bEy2);
        } else {
            iVar = new h(bEy, bEy2);
        }
        this.fkg.add(iVar);
    }

    private void bEQ() {
        hz(false);
    }

    private void bER() {
        hz(true);
    }

    private void hz(boolean z) {
        Object lVar;
        bEJ();
        this.fkf++;
        this.fkj = true;
        Mark bEy = this.fke.bEy();
        this.fke.nq(1);
        Mark bEy2 = this.fke.bEy();
        if (z) {
            lVar = new l(bEy, bEy2);
        } else {
            lVar = new n(bEy, bEy2);
        }
        this.fkg.add(lVar);
    }

    private void bES() {
        hA(false);
    }

    private void bET() {
        hA(true);
    }

    private void hA(boolean z) {
        Object kVar;
        bEK();
        this.fkf--;
        this.fkj = false;
        Mark bEy = this.fke.bEy();
        this.fke.bEz();
        Mark bEy2 = this.fke.bEy();
        if (z) {
            kVar = new k(bEy, bEy2);
        } else {
            kVar = new m(bEy, bEy2);
        }
        this.fkg.add(kVar);
    }

    private void bEU() {
        this.fkj = true;
        bEK();
        Mark bEy = this.fke.bEy();
        this.fke.bEz();
        this.fkg.add(new j(bEy, this.fke.bEy()));
    }

    private void bEV() {
        Mark bEy;
        if (this.fkf == 0) {
            if (!this.fkj) {
                throw new ScannerException(null, null, "sequence entries are not allowed here", this.fke.bEy());
            } else if (nx(this.fke.getColumn())) {
                bEy = this.fke.bEy();
                this.fkg.add(new f(bEy, bEy));
            }
        }
        this.fkj = true;
        bEK();
        bEy = this.fke.bEy();
        this.fke.bEz();
        this.fkg.add(new d(bEy, this.fke.bEy()));
    }

    private void bEW() {
        Mark bEy;
        if (this.fkf == 0) {
            if (!this.fkj) {
                throw new ScannerException(null, null, "mapping keys are not allowed here", this.fke.bEy());
            } else if (nx(this.fke.getColumn())) {
                bEy = this.fke.bEy();
                this.fkg.add(new e(bEy, bEy));
            }
        }
        this.fkj = this.fkf == 0;
        bEK();
        bEy = this.fke.bEy();
        this.fke.bEz();
        this.fkg.add(new o(bEy, this.fke.bEy()));
    }

    private void bEX() {
        Mark bEy;
        d dVar = (d) this.fkk.remove(Integer.valueOf(this.fkf));
        boolean z = false;
        if (dVar != null) {
            this.fkg.add(dVar.bFw() - this.fkh, new o(dVar.bEy(), dVar.bEy()));
            if (this.fkf == 0 && nx(dVar.getColumn())) {
                this.fkg.add(dVar.bFw() - this.fkh, new e(dVar.bEy(), dVar.bEy()));
            }
            this.fkj = false;
        } else if (this.fkf != 0 || this.fkj) {
            if (this.fkf == 0 && nx(this.fke.getColumn())) {
                bEy = this.fke.bEy();
                this.fkg.add(new e(bEy, bEy));
            }
            if (this.fkf == 0) {
                z = true;
            }
            this.fkj = z;
            bEK();
        } else {
            throw new ScannerException(null, null, "mapping values are not allowed here", this.fke.bEy());
        }
        bEy = this.fke.bEy();
        this.fke.bEz();
        this.fkg.add(new u(bEy, this.fke.bEy()));
    }

    private void bEY() {
        bEJ();
        this.fkj = false;
        this.fkg.add(hB(false));
    }

    private void bEZ() {
        bEJ();
        this.fkj = false;
        this.fkg.add(hB(true));
    }

    private void bFa() {
        bEJ();
        this.fkj = false;
        this.fkg.add(bFp());
    }

    private void bFb() {
        G('|');
    }

    private void bFc() {
        G('>');
    }

    private void G(char c) {
        this.fkj = true;
        bEK();
        this.fkg.add(I(c));
    }

    private void bFd() {
        H('\'');
    }

    private void bFe() {
        H('\"');
    }

    private void H(char c) {
        bEJ();
        this.fkj = false;
        this.fkg.add(J(c));
    }

    private void bFf() {
        bEJ();
        this.fkj = false;
        this.fkg.add(bFr());
    }

    private boolean bFg() {
        return this.fke.getColumn() == 0;
    }

    private boolean bFh() {
        return this.fke.getColumn() == 0 && "---".equals(this.fke.nr(3)) && a.fjU.nu(this.fke.peek(3));
    }

    private boolean bFi() {
        return this.fke.getColumn() == 0 && "...".equals(this.fke.nr(3)) && a.fjU.nu(this.fke.peek(3));
    }

    private boolean bFj() {
        return a.fjU.nu(this.fke.peek(1));
    }

    private boolean bFk() {
        if (this.fkf != 0) {
            return true;
        }
        return a.fjU.nu(this.fke.peek(1));
    }

    private boolean bFl() {
        if (this.fkf != 0) {
            return true;
        }
        return a.fjU.nu(this.fke.peek(1));
    }

    private boolean bFm() {
        int peek = this.fke.peek();
        if (a.fjU.q(peek, "-?:,[]{}#&*!|>'\"%@`")) {
            return true;
        }
        if (a.fjU.nv(this.fke.peek(1))) {
            if (peek == 45) {
                return true;
            }
            if (this.fkf == 0 && "?:".indexOf(peek) != -1) {
                return true;
            }
        }
        return false;
    }

    private void bFn() {
        if (this.fke.getIndex() == 0 && this.fke.peek() == 65279) {
            this.fke.bEz();
        }
        Object obj = null;
        while (obj == null) {
            int i = 0;
            while (this.fke.peek(i) == 32) {
                i++;
            }
            if (i > 0) {
                this.fke.nq(i);
            }
            if (this.fke.peek() == 35) {
                i = 0;
                while (a.fjS.nv(this.fke.peek(i))) {
                    i++;
                }
                if (i > 0) {
                    this.fke.nq(i);
                }
            }
            if (bFt().length() == 0) {
                obj = 1;
            } else if (this.fkf == 0) {
                this.fkj = true;
            }
        }
    }

    private Token bFo() {
        List d;
        Mark bEy;
        Mark bEy2 = this.fke.bEy();
        this.fke.bEz();
        String c = c(bEy2);
        if ("YAML".equals(c)) {
            d = d(bEy2);
            bEy = this.fke.bEy();
        } else if ("TAG".equals(c)) {
            d = f(bEy2);
            bEy = this.fke.bEy();
        } else {
            bEy = this.fke.bEy();
            int i = 0;
            while (a.fjS.nv(this.fke.peek(i))) {
                i++;
            }
            if (i > 0) {
                this.fke.nq(i);
            }
            d = null;
        }
        i(bEy2);
        return new g(c, d, bEy2, bEy);
    }

    private String c(Mark mark) {
        int i = 0;
        int peek = this.fke.peek(0);
        while (a.fjX.nu(peek)) {
            i++;
            peek = this.fke.peek(i);
        }
        StringBuilder stringBuilder;
        if (i == 0) {
            String valueOf = String.valueOf(Character.toChars(peek));
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected alphabetic or numeric character, but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek);
            stringBuilder.append(")");
            throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
        }
        String ns = this.fke.ns(i);
        i = this.fke.peek();
        if (!a.fjT.nv(i)) {
            return ns;
        }
        ns = String.valueOf(Character.toChars(i));
        stringBuilder = new StringBuilder();
        stringBuilder.append("expected alphabetic or numeric character, but found ");
        stringBuilder.append(ns);
        stringBuilder.append("(");
        stringBuilder.append(i);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
    }

    private List<Integer> d(Mark mark) {
        while (this.fke.peek() == 32) {
            this.fke.bEz();
        }
        Integer e = e(mark);
        int peek = this.fke.peek();
        String valueOf;
        StringBuilder stringBuilder;
        if (peek != 46) {
            valueOf = String.valueOf(Character.toChars(peek));
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected a digit or '.', but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek);
            stringBuilder.append(")");
            throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
        }
        this.fke.bEz();
        Integer e2 = e(mark);
        int peek2 = this.fke.peek();
        if (a.fjT.nv(peek2)) {
            valueOf = String.valueOf(Character.toChars(peek2));
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected a digit or ' ', but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek2);
            stringBuilder.append(")");
            throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
        }
        List<Integer> arrayList = new ArrayList(2);
        arrayList.add(e);
        arrayList.add(e2);
        return arrayList;
    }

    private Integer e(Mark mark) {
        int peek = this.fke.peek();
        if (Character.isDigit(peek)) {
            int i = 0;
            while (Character.isDigit(this.fke.peek(i))) {
                i++;
            }
            return Integer.valueOf(Integer.parseInt(this.fke.ns(i)));
        }
        String valueOf = String.valueOf(Character.toChars(peek));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected a digit, but found ");
        stringBuilder.append(valueOf);
        stringBuilder.append("(");
        stringBuilder.append(peek);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
    }

    private List<String> f(Mark mark) {
        while (this.fke.peek() == 32) {
            this.fke.bEz();
        }
        String g = g(mark);
        while (this.fke.peek() == 32) {
            this.fke.bEz();
        }
        String h = h(mark);
        List<String> arrayList = new ArrayList(2);
        arrayList.add(g);
        arrayList.add(h);
        return arrayList;
    }

    private String g(Mark mark) {
        String a = a("directive", mark);
        int peek = this.fke.peek();
        if (peek == 32) {
            return a;
        }
        a = String.valueOf(Character.toChars(peek));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected ' ', but found ");
        stringBuilder.append(a);
        stringBuilder.append("(");
        stringBuilder.append(peek);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
    }

    private String h(Mark mark) {
        String b = b("directive", mark);
        int peek = this.fke.peek();
        if (!a.fjT.nv(peek)) {
            return b;
        }
        b = String.valueOf(Character.toChars(peek));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected ' ', but found ");
        stringBuilder.append(b);
        stringBuilder.append("(");
        stringBuilder.append(peek);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
    }

    private void i(Mark mark) {
        while (this.fke.peek() == 32) {
            this.fke.bEz();
        }
        if (this.fke.peek() == 35) {
            while (a.fjS.nv(this.fke.peek())) {
                this.fke.bEz();
            }
        }
        int peek = this.fke.peek();
        if (bFt().length() == 0 && peek != 0) {
            String valueOf = String.valueOf(Character.toChars(peek));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected a comment or a line break, but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek);
            stringBuilder.append(")");
            throw new ScannerException("while scanning a directive", mark, stringBuilder.toString(), this.fke.bEy());
        }
    }

    private Token hB(boolean z) {
        Mark bEy = this.fke.bEy();
        String str = this.fke.peek() == 42 ? "alias" : "anchor";
        this.fke.bEz();
        int i = 0;
        int peek = this.fke.peek(0);
        while (a.fjX.nu(peek)) {
            i++;
            peek = this.fke.peek(i);
        }
        String valueOf;
        StringBuilder stringBuilder;
        if (i == 0) {
            valueOf = String.valueOf(Character.toChars(peek));
            stringBuilder = new StringBuilder();
            stringBuilder.append("while scanning an ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected alphabetic or numeric character, but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek);
            stringBuilder.append(")");
            throw new ScannerException(str, bEy, stringBuilder.toString(), this.fke.bEy());
        }
        String ns = this.fke.ns(i);
        peek = this.fke.peek();
        if (a.fjU.q(peek, "?:,]}%@`")) {
            valueOf = String.valueOf(Character.toChars(peek));
            stringBuilder = new StringBuilder();
            stringBuilder.append("while scanning an ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected alphabetic or numeric character, but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek);
            stringBuilder.append(")");
            throw new ScannerException(str, bEy, stringBuilder.toString(), this.fke.bEy());
        }
        Mark bEy2 = this.fke.bEy();
        if (z) {
            return new b(ns, bEy, bEy2);
        }
        return new org.yaml.snakeyaml.tokens.a(ns, bEy, bEy2);
    }

    private Token bFp() {
        String b;
        StringBuilder stringBuilder;
        Mark bEy = this.fke.bEy();
        int i = 1;
        int peek = this.fke.peek(1);
        String str = null;
        if (peek == 60) {
            this.fke.nq(2);
            b = b("tag", bEy);
            i = this.fke.peek();
            if (i != 62) {
                b = String.valueOf(Character.toChars(i));
                stringBuilder = new StringBuilder();
                stringBuilder.append("expected '>', but found '");
                stringBuilder.append(b);
                stringBuilder.append("' (");
                stringBuilder.append(i);
                stringBuilder.append(")");
                throw new ScannerException("while scanning a tag", bEy, stringBuilder.toString(), this.fke.bEy());
            }
            this.fke.bEz();
        } else if (a.fjU.nu(peek)) {
            b = "!";
            this.fke.bEz();
        } else {
            int i2 = 1;
            while (a.fjT.nv(peek)) {
                if (peek == 33) {
                    break;
                }
                i2++;
                peek = this.fke.peek(i2);
            }
            i = 0;
            if (i != 0) {
                b = a("tag", bEy);
            } else {
                b = "!";
                this.fke.bEz();
            }
            str = b;
            b = b("tag", bEy);
        }
        i = this.fke.peek();
        if (!a.fjT.nv(i)) {
            return new s(new t(str, b), bEy, this.fke.bEy());
        }
        b = String.valueOf(Character.toChars(i));
        stringBuilder = new StringBuilder();
        stringBuilder.append("expected ' ', but found '");
        stringBuilder.append(b);
        stringBuilder.append("' (");
        stringBuilder.append(i);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a tag", bEy, stringBuilder.toString(), this.fke.bEy());
    }

    private Token I(char c) {
        String str;
        Mark mark;
        Mark mark2;
        Object obj = c == '>' ? 1 : null;
        StringBuilder stringBuilder = new StringBuilder();
        Mark bEy = this.fke.bEy();
        this.fke.bEz();
        a j = j(bEy);
        int increment = j.getIncrement();
        k(bEy);
        int i = this.fhj + 1;
        if (i < 1) {
            i = 1;
        }
        Object[] bFq;
        if (increment == -1) {
            bFq = bFq();
            str = (String) bFq[0];
            int intValue = ((Integer) bFq[1]).intValue();
            mark = (Mark) bFq[2];
            i = Math.max(i, intValue);
        } else {
            i = (i + increment) - 1;
            bFq = ny(i);
            str = (String) bFq[0];
            mark = (Mark) bFq[1];
        }
        String str2 = "";
        while (this.fke.getColumn() == i && this.fke.peek() != 0) {
            stringBuilder.append(str);
            Object obj2 = " \t".indexOf(this.fke.peek()) == -1 ? 1 : null;
            int i2 = 0;
            while (a.fjS.nv(this.fke.peek(i2))) {
                i2++;
            }
            stringBuilder.append(this.fke.ns(i2));
            str2 = bFt();
            Object[] ny = ny(i);
            String str3 = (String) ny[0];
            Mark mark3 = (Mark) ny[1];
            if (this.fke.getColumn() != i || this.fke.peek() == 0) {
                mark2 = mark3;
                str = str3;
                break;
            }
            if (obj == null || !"\n".equals(str2) || obj2 == null || " \t".indexOf(this.fke.peek()) != -1) {
                stringBuilder.append(str2);
            } else if (str3.length() == 0) {
                stringBuilder.append(" ");
            }
            mark = mark3;
            str = str3;
        }
        mark2 = mark;
        if (j.bFu()) {
            stringBuilder.append(str2);
        }
        if (j.bFv()) {
            stringBuilder.append(str);
        }
        return new p(stringBuilder.toString(), false, bEy, mark2, ScalarStyle.createStyle(Character.valueOf(c)));
    }

    private a j(Mark mark) {
        int peek = this.fke.peek();
        Boolean bool = null;
        int i = -1;
        Boolean bool2;
        if (peek == 45 || peek == 43) {
            if (peek == 43) {
                bool2 = Boolean.TRUE;
            } else {
                bool2 = Boolean.FALSE;
            }
            bool = bool2;
            this.fke.bEz();
            peek = this.fke.peek();
            if (Character.isDigit(peek)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(peek)));
                if (i == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.fke.bEy());
                }
                this.fke.bEz();
            }
        } else if (Character.isDigit(peek)) {
            i = Integer.parseInt(String.valueOf(Character.toChars(peek)));
            if (i == 0) {
                throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.fke.bEy());
            }
            this.fke.bEz();
            peek = this.fke.peek();
            if (peek == 45 || peek == 43) {
                if (peek == 43) {
                    bool2 = Boolean.TRUE;
                } else {
                    bool2 = Boolean.FALSE;
                }
                bool = bool2;
                this.fke.bEz();
            }
        }
        peek = this.fke.peek();
        if (!a.fjT.nv(peek)) {
            return new a(bool, i);
        }
        String valueOf = String.valueOf(Character.toChars(peek));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected chomping or indentation indicators, but found ");
        stringBuilder.append(valueOf);
        stringBuilder.append("(");
        stringBuilder.append(peek);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a block scalar", mark, stringBuilder.toString(), this.fke.bEy());
    }

    private String k(Mark mark) {
        while (this.fke.peek() == 32) {
            this.fke.bEz();
        }
        if (this.fke.peek() == 35) {
            while (a.fjS.nv(this.fke.peek())) {
                this.fke.bEz();
            }
        }
        int peek = this.fke.peek();
        String bFt = bFt();
        if (bFt.length() != 0 || peek == 0) {
            return bFt;
        }
        bFt = String.valueOf(Character.toChars(peek));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected a comment or a line break, but found ");
        stringBuilder.append(bFt);
        stringBuilder.append("(");
        stringBuilder.append(peek);
        stringBuilder.append(")");
        throw new ScannerException("while scanning a block scalar", mark, stringBuilder.toString(), this.fke.bEy());
    }

    private Object[] bFq() {
        StringBuilder stringBuilder = new StringBuilder();
        Mark bEy = this.fke.bEy();
        int i = 0;
        while (a.fjQ.p(this.fke.peek(), " \r")) {
            if (this.fke.peek() != 32) {
                stringBuilder.append(bFt());
                bEy = this.fke.bEy();
            } else {
                this.fke.bEz();
                if (this.fke.getColumn() > i) {
                    i = this.fke.getColumn();
                }
            }
        }
        return new Object[]{stringBuilder.toString(), Integer.valueOf(i), bEy};
    }

    private Object[] ny(int i) {
        int column;
        StringBuilder stringBuilder = new StringBuilder();
        Mark bEy = this.fke.bEy();
        for (column = this.fke.getColumn(); column < i && this.fke.peek() == 32; column++) {
            this.fke.bEz();
        }
        while (true) {
            String bFt = bFt();
            if (bFt.length() != 0) {
                stringBuilder.append(bFt);
                bEy = this.fke.bEy();
                for (column = this.fke.getColumn(); column < i && this.fke.peek() == 32; column++) {
                    this.fke.bEz();
                }
            } else {
                return new Object[]{stringBuilder.toString(), bEy};
            }
        }
    }

    private Token J(char c) {
        boolean z = c == '\"';
        StringBuilder stringBuilder = new StringBuilder();
        Mark bEy = this.fke.bEy();
        int peek = this.fke.peek();
        this.fke.bEz();
        stringBuilder.append(a(z, bEy));
        while (this.fke.peek() != peek) {
            stringBuilder.append(l(bEy));
            stringBuilder.append(a(z, bEy));
        }
        this.fke.bEz();
        return new p(stringBuilder.toString(), false, bEy, this.fke.bEy(), ScalarStyle.createStyle(Character.valueOf(c)));
    }

    private String a(boolean z, Mark mark) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int i = 0;
            while (a.fjU.q(this.fke.peek(i), "'\"\\")) {
                i++;
            }
            if (i != 0) {
                stringBuilder.append(this.fke.ns(i));
            }
            i = this.fke.peek();
            if (!z && i == 39 && this.fke.peek(1) == 39) {
                stringBuilder.append("'");
                this.fke.nq(2);
            } else if ((z && i == 39) || (!z && "\"\\".indexOf(i) != -1)) {
                stringBuilder.appendCodePoint(i);
                this.fke.bEz();
            } else if (z && i == 92) {
                char c;
                StringBuilder stringBuilder2;
                this.fke.bEz();
                i = this.fke.peek();
                if (!Character.isSupplementaryCodePoint(i)) {
                    c = (char) i;
                    if (fkc.containsKey(Character.valueOf(c))) {
                        stringBuilder.append((String) fkc.get(Character.valueOf(c)));
                        this.fke.bEz();
                    }
                }
                if (!Character.isSupplementaryCodePoint(i)) {
                    c = (char) i;
                    if (fkd.containsKey(Character.valueOf(c))) {
                        i = ((Integer) fkd.get(Character.valueOf(c))).intValue();
                        this.fke.bEz();
                        String nr = this.fke.nr(i);
                        if (fkb.matcher(nr).find()) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("expected escape sequence of ");
                            stringBuilder2.append(i);
                            stringBuilder2.append(" hexadecimal numbers, but found: ");
                            stringBuilder2.append(nr);
                            throw new ScannerException("while scanning a double-quoted scalar", mark, stringBuilder2.toString(), this.fke.bEy());
                        }
                        stringBuilder.append(new String(Character.toChars(Integer.parseInt(nr, 16))));
                        this.fke.nq(i);
                    }
                }
                if (bFt().length() != 0) {
                    stringBuilder.append(m(mark));
                } else {
                    String valueOf = String.valueOf(Character.toChars(i));
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("found unknown escape character ");
                    stringBuilder2.append(valueOf);
                    stringBuilder2.append("(");
                    stringBuilder2.append(i);
                    stringBuilder2.append(")");
                    throw new ScannerException("while scanning a double-quoted scalar", mark, stringBuilder2.toString(), this.fke.bEy());
                }
            }
        }
        return stringBuilder.toString();
    }

    private String l(Mark mark) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (" \t".indexOf(this.fke.peek(i)) != -1) {
            i++;
        }
        String ns = this.fke.ns(i);
        if (this.fke.peek() == 0) {
            throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected end of stream", this.fke.bEy());
        }
        String bFt = bFt();
        if (bFt.length() != 0) {
            String m = m(mark);
            if (!"\n".equals(bFt)) {
                stringBuilder.append(bFt);
            } else if (m.length() == 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(m);
        } else {
            stringBuilder.append(ns);
        }
        return stringBuilder.toString();
    }

    private String m(Mark mark) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String nr = this.fke.nr(3);
            if (("---".equals(nr) || "...".equals(nr)) && a.fjU.nu(this.fke.peek(3))) {
                throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", this.fke.bEy());
            }
            while (" \t".indexOf(this.fke.peek()) != -1) {
                this.fke.bEz();
            }
            nr = bFt();
            if (nr.length() == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(nr);
        }
    }

    private Token bFr() {
        StringBuilder stringBuilder = new StringBuilder();
        Mark bEy = this.fke.bEy();
        int i = this.fhj + 1;
        String str = "";
        Mark mark = bEy;
        while (this.fke.peek() != 35) {
            int i2 = 0;
            while (true) {
                int peek = this.fke.peek(i2);
                if (!a.fjU.nu(peek) && ((this.fkf != 0 || peek != 58 || !a.fjU.nu(this.fke.peek(i2 + 1))) && (this.fkf == 0 || ",:?[]{}".indexOf(peek) == -1))) {
                    i2++;
                }
            }
            if (this.fkf == 0 || peek != 58 || !a.fjU.q(this.fke.peek(i2 + 1), ",[]{}")) {
                if (i2 != 0) {
                    this.fkj = false;
                    stringBuilder.append(str);
                    stringBuilder.append(this.fke.ns(i2));
                    mark = this.fke.bEy();
                    str = bFs();
                    if (str.length() == 0 || this.fke.peek() == 35 || (this.fkf == 0 && this.fke.getColumn() < i)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            this.fke.nq(i2);
            throw new ScannerException("while scanning a plain scalar", bEy, "found unexpected ':'", this.fke.bEy(), "Please check http://pyyaml.org/wiki/YAMLColonInFlowContext for details.");
        }
        return new p(stringBuilder.toString(), bEy, mark, true);
    }

    private String bFs() {
        int i = 0;
        while (true) {
            if (this.fke.peek(i) != 32 && this.fke.peek(i) != 9) {
                break;
            }
            i++;
        }
        String ns = this.fke.ns(i);
        String bFt = bFt();
        if (bFt.length() == 0) {
            return ns;
        }
        this.fkj = true;
        ns = this.fke.nr(3);
        if ("---".equals(ns) || ("...".equals(ns) && a.fjU.nu(this.fke.peek(3)))) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            if (this.fke.peek() == 32) {
                this.fke.bEz();
            } else {
                String bFt2 = bFt();
                if (bFt2.length() != 0) {
                    stringBuilder.append(bFt2);
                    bFt2 = this.fke.nr(3);
                    if ("---".equals(bFt2) || ("...".equals(bFt2) && a.fjU.nu(this.fke.peek(3)))) {
                    }
                } else if (!"\n".equals(bFt)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(bFt);
                    stringBuilder2.append(stringBuilder);
                    return stringBuilder2.toString();
                } else if (stringBuilder.length() == 0) {
                    return " ";
                } else {
                    return stringBuilder.toString();
                }
            }
        }
        return "";
    }

    private String a(String str, Mark mark) {
        int peek = this.fke.peek();
        String valueOf;
        StringBuilder stringBuilder;
        if (peek != 33) {
            valueOf = String.valueOf(Character.toChars(peek));
            stringBuilder = new StringBuilder();
            stringBuilder.append("while scanning a ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected '!', but found ");
            stringBuilder.append(valueOf);
            stringBuilder.append("(");
            stringBuilder.append(peek);
            stringBuilder.append(")");
            throw new ScannerException(str, mark, stringBuilder.toString(), this.fke.bEy());
        }
        int i = 1;
        peek = this.fke.peek(1);
        if (peek != 32) {
            int i2 = 1;
            while (a.fjX.nu(peek)) {
                i2++;
                peek = this.fke.peek(i2);
            }
            if (peek != 33) {
                this.fke.nq(i2);
                valueOf = String.valueOf(Character.toChars(peek));
                stringBuilder = new StringBuilder();
                stringBuilder.append("while scanning a ");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append("expected '!', but found ");
                stringBuilder.append(valueOf);
                stringBuilder.append("(");
                stringBuilder.append(peek);
                stringBuilder.append(")");
                throw new ScannerException(str, mark, stringBuilder.toString(), this.fke.bEy());
            }
            i = 1 + i2;
        }
        return this.fke.ns(i);
    }

    private String b(String str, Mark mark) {
        StringBuilder stringBuilder = new StringBuilder();
        int peek = this.fke.peek(0);
        int i = 0;
        while (a.fjW.nu(peek)) {
            if (peek == 37) {
                stringBuilder.append(this.fke.ns(i));
                stringBuilder.append(c(str, mark));
                i = 0;
            } else {
                i++;
            }
            peek = this.fke.peek(i);
        }
        if (i != 0) {
            stringBuilder.append(this.fke.ns(i));
        }
        if (stringBuilder.length() != 0) {
            return stringBuilder.toString();
        }
        String valueOf = String.valueOf(Character.toChars(peek));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("while scanning a ");
        stringBuilder2.append(str);
        str = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("expected URI, but found ");
        stringBuilder2.append(valueOf);
        stringBuilder2.append("(");
        stringBuilder2.append(peek);
        stringBuilder2.append(")");
        throw new ScannerException(str, mark, stringBuilder2.toString(), this.fke.bEy());
    }

    private String c(String str, Mark mark) {
        int i = 1;
        while (this.fke.peek(i * 3) == 37) {
            i++;
        }
        Mark bEy = this.fke.bEy();
        ByteBuffer allocate = ByteBuffer.allocate(i);
        while (this.fke.peek() == 37) {
            this.fke.bEz();
            try {
                allocate.put((byte) Integer.parseInt(this.fke.nr(2), 16));
                this.fke.nq(2);
            } catch (NumberFormatException unused) {
                i = this.fke.peek();
                String valueOf = String.valueOf(Character.toChars(i));
                int peek = this.fke.peek(1);
                String valueOf2 = String.valueOf(Character.toChars(peek));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("while scanning a ");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append("expected URI escape sequence of 2 hexadecimal numbers, but found ");
                stringBuilder.append(valueOf);
                stringBuilder.append("(");
                stringBuilder.append(i);
                stringBuilder.append(") and ");
                stringBuilder.append(valueOf2);
                stringBuilder.append("(");
                stringBuilder.append(peek);
                stringBuilder.append(")");
                throw new ScannerException(str, mark, stringBuilder.toString(), this.fke.bEy());
            }
        }
        allocate.flip();
        try {
            return org.yaml.snakeyaml.d.c.a(allocate);
        } catch (CharacterCodingException e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("while scanning a ");
            stringBuilder2.append(str);
            str = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("expected URI in UTF-8: ");
            stringBuilder2.append(e.getMessage());
            throw new ScannerException(str, mark, stringBuilder2.toString(), bEy);
        }
    }

    private String bFt() {
        int peek = this.fke.peek();
        if (peek == 13 || peek == 10 || peek == 133) {
            if (peek == 13 && 10 == this.fke.peek(1)) {
                this.fke.nq(2);
            } else {
                this.fke.bEz();
            }
            return "\n";
        } else if (peek != 8232 && peek != 8233) {
            return "";
        } else {
            this.fke.bEz();
            return String.valueOf(Character.toChars(peek));
        }
    }
}
