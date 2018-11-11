package org.yaml.snakeyaml.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.DumperOptions.Version;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: ParserImpl */
public class b implements a {
    private static final Map<String, String> fjh = new HashMap();
    protected final org.yaml.snakeyaml.scanner.b fji;
    private Event fjj;
    private final org.yaml.snakeyaml.d.a<c> fjk;
    private final org.yaml.snakeyaml.d.a<Mark> fjl;
    private c fjm;
    private d fjn;

    /* compiled from: ParserImpl */
    private class a implements c {
        private a() {
        }

        public Event bEv() {
            b.this.fjl.push(b.this.fji.bEE().bEb());
            return new b().bEv();
        }
    }

    /* compiled from: ParserImpl */
    private class b implements c {
        private b() {
        }

        public Event bEv() {
            Token bEE;
            if (b.this.fji.a(ID.Key)) {
                bEE = b.this.fji.bEE();
                if (b.this.fji.a(ID.Key, ID.Value, ID.BlockEnd)) {
                    b.this.fjm = new c();
                    return b.this.b(bEE.bEc());
                }
                b.this.fjk.push(new c());
                return b.this.bEu();
            }
            if (b.this.fji.a(ID.BlockEnd)) {
                bEE = b.this.fji.bEE();
                Event gVar = new org.yaml.snakeyaml.events.g(bEE.bEb(), bEE.bEc());
                b.this.fjm = (c) b.this.fjk.pop();
                b.this.fjl.pop();
                return gVar;
            }
            bEE = b.this.fji.bED();
            Mark mark = (Mark) b.this.fjl.pop();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected <block end>, but found ");
            stringBuilder.append(bEE.bFx());
            throw new ParserException("while parsing a block mapping", mark, stringBuilder.toString(), bEE.bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class c implements c {
        private c() {
        }

        public Event bEv() {
            if (b.this.fji.a(ID.Value)) {
                Token bEE = b.this.fji.bEE();
                if (b.this.fji.a(ID.Key, ID.Value, ID.BlockEnd)) {
                    b.this.fjm = new b();
                    return b.this.b(bEE.bEc());
                }
                b.this.fjk.push(new b());
                return b.this.bEu();
            }
            b.this.fjm = new b();
            return b.this.b(b.this.fji.bED().bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class d implements c {
        private d() {
        }

        public Event bEv() {
            return b.this.p(true, false);
        }
    }

    /* compiled from: ParserImpl */
    private class e implements c {
        private e() {
        }

        public Event bEv() {
            if (b.this.fji.a(ID.BlockEntry)) {
                org.yaml.snakeyaml.tokens.d dVar = (org.yaml.snakeyaml.tokens.d) b.this.fji.bEE();
                if (b.this.fji.a(ID.BlockEntry, ID.BlockEnd)) {
                    b.this.fjm = new e();
                    return b.this.b(dVar.bEc());
                }
                b.this.fjk.push(new e());
                return new d().bEv();
            }
            Token bEE;
            if (b.this.fji.a(ID.BlockEnd)) {
                bEE = b.this.fji.bEE();
                Event kVar = new org.yaml.snakeyaml.events.k(bEE.bEb(), bEE.bEc());
                b.this.fjm = (c) b.this.fjk.pop();
                b.this.fjl.pop();
                return kVar;
            }
            bEE = b.this.fji.bED();
            Mark mark = (Mark) b.this.fjl.pop();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected <block end>, but found ");
            stringBuilder.append(bEE.bFx());
            throw new ParserException("while parsing a block collection", mark, stringBuilder.toString(), bEE.bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class f implements c {
        private f() {
        }

        public Event bEv() {
            b.this.fjl.push(b.this.fji.bEE().bEb());
            return new e().bEv();
        }
    }

    /* compiled from: ParserImpl */
    private class g implements c {
        private g() {
        }

        public Event bEv() {
            if (!b.this.fji.a(ID.Directive, ID.DocumentStart, ID.DocumentEnd, ID.StreamEnd)) {
                return new d().bEv();
            }
            Event a = b.this.b(b.this.fji.bED().bEb());
            b.this.fjm = (c) b.this.fjk.pop();
            return a;
        }
    }

    /* compiled from: ParserImpl */
    private class h implements c {
        private h() {
        }

        public Event bEv() {
            Mark bEc;
            Mark bEb = b.this.fji.bED().bEb();
            boolean z = true;
            if (b.this.fji.a(ID.DocumentEnd)) {
                bEc = b.this.fji.bEE().bEc();
            } else {
                bEc = bEb;
                z = false;
            }
            Event dVar = new org.yaml.snakeyaml.events.d(bEb, bEc, z);
            b.this.fjm = new i();
            return dVar;
        }
    }

    /* compiled from: ParserImpl */
    private class i implements c {
        private i() {
        }

        public Event bEv() {
            while (true) {
                if (!b.this.fji.a(ID.DocumentEnd)) {
                    break;
                }
                b.this.fji.bEE();
            }
            StringBuilder stringBuilder;
            if (b.this.fji.a(ID.StreamEnd)) {
                org.yaml.snakeyaml.tokens.q qVar = (org.yaml.snakeyaml.tokens.q) b.this.fji.bEE();
                Event mVar = new org.yaml.snakeyaml.events.m(qVar.bEb(), qVar.bEc());
                if (!b.this.fjk.isEmpty()) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected end of stream. States left: ");
                    stringBuilder.append(b.this.fjk);
                    throw new YAMLException(stringBuilder.toString());
                } else if (b.this.fjl.isEmpty()) {
                    b.this.fjm = null;
                    return mVar;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected end of stream. Marks left: ");
                    stringBuilder.append(b.this.fjl);
                    throw new YAMLException(stringBuilder.toString());
                }
            }
            Mark bEb = b.this.fji.bED().bEb();
            d b = b.this.bEs();
            if (b.this.fji.a(ID.DocumentStart)) {
                Event eVar = new org.yaml.snakeyaml.events.e(bEb, b.this.fji.bEE().bEc(), true, b.bEw(), b.bEx());
                b.this.fjk.push(new h());
                b.this.fjm = new g();
                return eVar;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected '<document start>', but found ");
            stringBuilder.append(b.this.fji.bED().bFx());
            throw new ParserException(null, null, stringBuilder.toString(), b.this.fji.bED().bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class j implements c {
        private j() {
        }

        public Event bEv() {
            b.this.fjm = new l(false);
            return b.this.b(b.this.fji.bED().bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class k implements c {
        private k() {
        }

        public Event bEv() {
            b.this.fjl.push(b.this.fji.bEE().bEb());
            return new l(true).bEv();
        }
    }

    /* compiled from: ParserImpl */
    private class l implements c {
        private boolean ent = false;

        public l(boolean z) {
            this.ent = z;
        }

        public Event bEv() {
            Token bED;
            if (!b.this.fji.a(ID.FlowMappingEnd)) {
                if (!this.ent) {
                    if (b.this.fji.a(ID.FlowEntry)) {
                        b.this.fji.bEE();
                    } else {
                        bED = b.this.fji.bED();
                        Mark mark = (Mark) b.this.fjl.pop();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("expected ',' or '}', but got ");
                        stringBuilder.append(bED.bFx());
                        throw new ParserException("while parsing a flow mapping", mark, stringBuilder.toString(), bED.bEb());
                    }
                }
                if (b.this.fji.a(ID.Key)) {
                    bED = b.this.fji.bEE();
                    if (b.this.fji.a(ID.Value, ID.FlowEntry, ID.FlowMappingEnd)) {
                        b.this.fjm = new m();
                        return b.this.b(bED.bEc());
                    }
                    b.this.fjk.push(new m());
                    return b.this.bEt();
                }
                if (!b.this.fji.a(ID.FlowMappingEnd)) {
                    b.this.fjk.push(new j());
                    return b.this.bEt();
                }
            }
            bED = b.this.fji.bEE();
            Event gVar = new org.yaml.snakeyaml.events.g(bED.bEb(), bED.bEc());
            b.this.fjm = (c) b.this.fjk.pop();
            b.this.fjl.pop();
            return gVar;
        }
    }

    /* compiled from: ParserImpl */
    private class m implements c {
        private m() {
        }

        public Event bEv() {
            if (b.this.fji.a(ID.Value)) {
                Token bEE = b.this.fji.bEE();
                if (b.this.fji.a(ID.FlowEntry, ID.FlowMappingEnd)) {
                    b.this.fjm = new l(false);
                    return b.this.b(bEE.bEc());
                }
                b.this.fjk.push(new l(false));
                return b.this.bEt();
            }
            b.this.fjm = new l(false);
            return b.this.b(b.this.fji.bED().bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class n implements c {
        private boolean ent = false;

        public n(boolean z) {
            this.ent = z;
        }

        public Event bEv() {
            Token bED;
            Event hVar;
            if (!b.this.fji.a(ID.FlowSequenceEnd)) {
                if (!this.ent) {
                    if (b.this.fji.a(ID.FlowEntry)) {
                        b.this.fji.bEE();
                    } else {
                        bED = b.this.fji.bED();
                        Mark mark = (Mark) b.this.fjl.pop();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("expected ',' or ']', but got ");
                        stringBuilder.append(bED.bFx());
                        throw new ParserException("while parsing a flow sequence", mark, stringBuilder.toString(), bED.bEb());
                    }
                }
                if (b.this.fji.a(ID.Key)) {
                    bED = b.this.fji.bED();
                    hVar = new org.yaml.snakeyaml.events.h(null, null, true, bED.bEb(), bED.bEc(), FlowStyle.FLOW);
                    b.this.fjm = new p();
                    return hVar;
                }
                if (!b.this.fji.a(ID.FlowSequenceEnd)) {
                    b.this.fjk.push(new n(false));
                    return b.this.bEt();
                }
            }
            bED = b.this.fji.bEE();
            hVar = new org.yaml.snakeyaml.events.k(bED.bEb(), bED.bEc());
            b.this.fjm = (c) b.this.fjk.pop();
            b.this.fjl.pop();
            return hVar;
        }
    }

    /* compiled from: ParserImpl */
    private class o implements c {
        private o() {
        }

        public Event bEv() {
            b.this.fjm = new n(false);
            Token bED = b.this.fji.bED();
            return new org.yaml.snakeyaml.events.g(bED.bEb(), bED.bEc());
        }
    }

    /* compiled from: ParserImpl */
    private class p implements c {
        private p() {
        }

        public Event bEv() {
            Token bEE = b.this.fji.bEE();
            if (b.this.fji.a(ID.Value, ID.FlowEntry, ID.FlowSequenceEnd)) {
                b.this.fjm = new q();
                return b.this.b(bEE.bEc());
            }
            b.this.fjk.push(new q());
            return b.this.bEt();
        }
    }

    /* compiled from: ParserImpl */
    private class q implements c {
        private q() {
        }

        public Event bEv() {
            if (b.this.fji.a(ID.Value)) {
                Token bEE = b.this.fji.bEE();
                if (b.this.fji.a(ID.FlowEntry, ID.FlowSequenceEnd)) {
                    b.this.fjm = new o();
                    return b.this.b(bEE.bEc());
                }
                b.this.fjk.push(new o());
                return b.this.bEt();
            }
            b.this.fjm = new o();
            return b.this.b(b.this.fji.bED().bEb());
        }
    }

    /* compiled from: ParserImpl */
    private class r implements c {
        private r() {
        }

        public Event bEv() {
            b.this.fjl.push(b.this.fji.bEE().bEb());
            return new n(true).bEv();
        }
    }

    /* compiled from: ParserImpl */
    private class s implements c {
        private s() {
        }

        public Event bEv() {
            if (b.this.fji.a(ID.Directive, ID.DocumentStart, ID.StreamEnd)) {
                return new i().bEv();
            }
            b.this.fjn = new d(null, b.fjh);
            Mark bEb = b.this.fji.bED().bEb();
            Event eVar = new org.yaml.snakeyaml.events.e(bEb, bEb, false, null, null);
            b.this.fjk.push(new h());
            b.this.fjm = new d();
            return eVar;
        }
    }

    /* compiled from: ParserImpl */
    private class t implements c {
        private t() {
        }

        public Event bEv() {
            Token bEE;
            if (b.this.fji.a(ID.BlockEntry)) {
                bEE = b.this.fji.bEE();
                if (b.this.fji.a(ID.BlockEntry, ID.Key, ID.Value, ID.BlockEnd)) {
                    b.this.fjm = new t();
                    return b.this.b(bEE.bEc());
                }
                b.this.fjk.push(new t());
                return new d().bEv();
            }
            bEE = b.this.fji.bED();
            Event kVar = new org.yaml.snakeyaml.events.k(bEE.bEb(), bEE.bEc());
            b.this.fjm = (c) b.this.fjk.pop();
            return kVar;
        }
    }

    /* compiled from: ParserImpl */
    private class u implements c {
        private u() {
        }

        public Event bEv() {
            org.yaml.snakeyaml.tokens.r rVar = (org.yaml.snakeyaml.tokens.r) b.this.fji.bEE();
            Event nVar = new org.yaml.snakeyaml.events.n(rVar.bEb(), rVar.bEc());
            b.this.fjm = new s();
            return nVar;
        }
    }

    static {
        fjh.put("!", "!");
        fjh.put("!!", "tag:yaml.org,2002:");
    }

    public b(org.yaml.snakeyaml.reader.a aVar) {
        this(new org.yaml.snakeyaml.scanner.c(aVar));
    }

    public b(org.yaml.snakeyaml.scanner.b bVar) {
        this.fji = bVar;
        this.fjj = null;
        this.fjn = new d(null, new HashMap(fjh));
        this.fjk = new org.yaml.snakeyaml.d.a(100);
        this.fjl = new org.yaml.snakeyaml.d.a(10);
        this.fjm = new u();
    }

    public boolean b(Event.ID id) {
        bEq();
        return this.fjj != null && this.fjj.a(id);
    }

    public Event bEq() {
        if (this.fjj == null && this.fjm != null) {
            this.fjj = this.fjm.bEv();
        }
        return this.fjj;
    }

    public Event bEr() {
        bEq();
        Event event = this.fjj;
        this.fjj = null;
        return event;
    }

    private d bEs() {
        Map hashMap = new HashMap();
        Version version = null;
        while (true) {
            if (this.fji.a(ID.Directive)) {
                org.yaml.snakeyaml.tokens.g gVar = (org.yaml.snakeyaml.tokens.g) this.fji.bEE();
                if (gVar.getName().equals("YAML")) {
                    if (version != null) {
                        throw new ParserException(null, null, "found duplicate YAML directive", gVar.bEb());
                    }
                    List bEj = gVar.bEj();
                    if (((Integer) bEj.get(0)).intValue() != 1) {
                        throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", gVar.bEb());
                    } else if (((Integer) bEj.get(1)).intValue() != 0) {
                        version = Version.V1_1;
                    } else {
                        version = Version.V1_0;
                    }
                } else if (gVar.getName().equals("TAG")) {
                    List bEj2 = gVar.bEj();
                    String str = (String) bEj2.get(0);
                    String str2 = (String) bEj2.get(1);
                    if (hashMap.containsKey(str)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("duplicate tag handle ");
                        stringBuilder.append(str);
                        throw new ParserException(null, null, stringBuilder.toString(), gVar.bEb());
                    }
                    hashMap.put(str, str2);
                } else {
                    continue;
                }
            } else {
                if (!(version == null && hashMap.isEmpty())) {
                    for (String str3 : fjh.keySet()) {
                        if (!hashMap.containsKey(str3)) {
                            hashMap.put(str3, fjh.get(str3));
                        }
                    }
                    this.fjn = new d(version, hashMap);
                }
                return this.fjn;
            }
        }
    }

    private Event bEt() {
        return p(false, false);
    }

    private Event bEu() {
        return p(true, true);
    }

    private Event p(boolean z, boolean z2) {
        if (this.fji.a(ID.Alias)) {
            org.yaml.snakeyaml.tokens.a aVar = (org.yaml.snakeyaml.tokens.a) this.fji.bEE();
            Event aVar2 = new org.yaml.snakeyaml.events.a(aVar.getValue(), aVar.bEb(), aVar.bEc());
            this.fjm = (c) this.fjk.pop();
            return aVar2;
        }
        Mark bEb;
        Mark bEc;
        String value;
        Mark bEb2;
        String str;
        org.yaml.snakeyaml.tokens.t tVar;
        String str2;
        Mark bEb3;
        Mark mark;
        Event lVar;
        if (this.fji.a(ID.Anchor)) {
            Mark bEc2;
            org.yaml.snakeyaml.tokens.t bFz;
            org.yaml.snakeyaml.tokens.b bVar = (org.yaml.snakeyaml.tokens.b) this.fji.bEE();
            bEb = bVar.bEb();
            bEc = bVar.bEc();
            value = bVar.getValue();
            if (this.fji.a(ID.Tag)) {
                org.yaml.snakeyaml.tokens.s sVar = (org.yaml.snakeyaml.tokens.s) this.fji.bEE();
                bEb2 = sVar.bEb();
                bEc2 = sVar.bEc();
                bFz = sVar.bFz();
            } else {
                bEb2 = null;
                bEc2 = bEc;
                bFz = bEb2;
            }
            str = value;
            tVar = bFz;
            bEc = bEc2;
        } else {
            if (this.fji.a(ID.Tag)) {
                org.yaml.snakeyaml.tokens.s sVar2 = (org.yaml.snakeyaml.tokens.s) this.fji.bEE();
                bEb = sVar2.bEb();
                bEc = sVar2.bEc();
                tVar = sVar2.bFz();
                if (this.fji.a(ID.Anchor)) {
                    org.yaml.snakeyaml.tokens.b bVar2 = (org.yaml.snakeyaml.tokens.b) this.fji.bEE();
                    bEb2 = bVar2.bEc();
                    str = bVar2.getValue();
                    bEc = bEb2;
                } else {
                    str = null;
                }
                bEb2 = bEb;
            } else {
                tVar = null;
                bEb = tVar;
                bEc = bEb;
                bEb2 = bEc;
                str = bEb2;
            }
        }
        if (tVar != null) {
            String bFA = tVar.bFA();
            value = tVar.getSuffix();
            if (bFA != null) {
                if (this.fjn.bEx().containsKey(bFA)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String) this.fjn.bEx().get(bFA));
                    stringBuilder.append(value);
                    value = stringBuilder.toString();
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("found undefined tag handle ");
                    stringBuilder2.append(bFA);
                    throw new ParserException("while parsing a node", bEb, stringBuilder2.toString(), bEb2);
                }
            }
            str2 = value;
        } else {
            str2 = null;
        }
        if (bEb == null) {
            bEb3 = this.fji.bED().bEb();
            mark = bEb3;
        } else {
            bEb3 = bEb;
            mark = bEc;
        }
        boolean z3 = str2 == null || str2.equals("!");
        if (z2) {
            if (this.fji.a(ID.BlockEntry)) {
                lVar = new org.yaml.snakeyaml.events.l(str, str2, z3, bEb3, this.fji.bED().bEc(), FlowStyle.BLOCK);
                this.fjm = new t();
                return lVar;
            }
        }
        if (this.fji.a(ID.Scalar)) {
            org.yaml.snakeyaml.events.f fVar;
            org.yaml.snakeyaml.tokens.p pVar = (org.yaml.snakeyaml.tokens.p) this.fji.bEE();
            mark = pVar.bEc();
            if ((pVar.bFy() && str2 == null) || "!".equals(str2)) {
                fVar = new org.yaml.snakeyaml.events.f(true, false);
            } else if (str2 == null) {
                fVar = new org.yaml.snakeyaml.events.f(false, true);
            } else {
                fVar = new org.yaml.snakeyaml.events.f(false, false);
            }
            lVar = new org.yaml.snakeyaml.events.j(str, str2, fVar, pVar.getValue(), bEb3, mark, pVar.bEf());
            this.fjm = (c) this.fjk.pop();
            return lVar;
        }
        if (this.fji.a(ID.FlowSequenceStart)) {
            lVar = new org.yaml.snakeyaml.events.l(str, str2, z3, bEb3, this.fji.bED().bEc(), FlowStyle.FLOW);
            this.fjm = new r();
            return lVar;
        }
        if (this.fji.a(ID.FlowMappingStart)) {
            lVar = new org.yaml.snakeyaml.events.h(str, str2, z3, bEb3, this.fji.bED().bEc(), FlowStyle.FLOW);
            this.fjm = new k();
            return lVar;
        }
        if (z) {
            if (this.fji.a(ID.BlockSequenceStart)) {
                lVar = new org.yaml.snakeyaml.events.l(str, str2, z3, bEb3, this.fji.bED().bEb(), FlowStyle.BLOCK);
                this.fjm = new f();
                return lVar;
            }
        }
        if (z) {
            if (this.fji.a(ID.BlockMappingStart)) {
                lVar = new org.yaml.snakeyaml.events.h(str, str2, z3, bEb3, this.fji.bED().bEb(), FlowStyle.BLOCK);
                this.fjm = new a();
                return lVar;
            }
        }
        if (str == null && str2 == null) {
            String str3 = z ? "block" : "flow";
            Token bED = this.fji.bED();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("while parsing a ");
            stringBuilder3.append(str3);
            stringBuilder3.append(" node");
            str3 = stringBuilder3.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("expected the node content, but found ");
            stringBuilder3.append(bED.bFx());
            throw new ParserException(str3, bEb3, stringBuilder3.toString(), bED.bEb());
        }
        lVar = new org.yaml.snakeyaml.events.j(str, str2, new org.yaml.snakeyaml.events.f(z3, false), "", bEb3, mark, ScalarStyle.PLAIN);
        this.fjm = (c) this.fjk.pop();
        return lVar;
    }

    private Event b(Mark mark) {
        return new org.yaml.snakeyaml.events.j(null, null, new org.yaml.snakeyaml.events.f(true, false), "", mark, mark, ScalarStyle.PLAIN);
    }
}
