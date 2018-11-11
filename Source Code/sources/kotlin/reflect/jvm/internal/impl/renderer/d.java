package kotlin.reflect.jvm.internal.impl.renderer;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ab;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.aj;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ao;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.as;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.o;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.ax;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.az;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: DescriptorRendererImpl.kt */
public final class d extends b implements f {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "functionTypeAnnotationsRenderer", "getFunctionTypeAnnotationsRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRendererImpl;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "functionTypeParameterTypesRenderer", "getFunctionTypeParameterTypesRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;"))};
    private final kotlin.d ePs;
    private final kotlin.d ePt;
    private final g ePu;

    /* compiled from: DescriptorRendererImpl.kt */
    private final class a implements m<l, StringBuilder> {
        public void a(aq aqVar, StringBuilder stringBuilder) {
            h.e(aqVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(aqVar, true, stringBuilder, true);
        }

        public void b(ad adVar, StringBuilder stringBuilder) {
            h.e(adVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(adVar, stringBuilder);
        }

        public void a(ae aeVar, StringBuilder stringBuilder) {
            h.e(aeVar, "descriptor");
            h.e(stringBuilder, "builder");
            if (d.this.bvX()) {
                d.this.a((ac) aeVar, stringBuilder);
                stringBuilder.append("getter for ");
                d dVar = d.this;
                ad bdH = aeVar.bdH();
                h.d(bdH, "descriptor.correspondingProperty");
                dVar.a(bdH, stringBuilder);
                return;
            }
            d((r) aeVar, stringBuilder);
        }

        public void a(af afVar, StringBuilder stringBuilder) {
            h.e(afVar, "descriptor");
            h.e(stringBuilder, "builder");
            if (d.this.bvX()) {
                d.this.a((ac) afVar, stringBuilder);
                stringBuilder.append("setter for ");
                d dVar = d.this;
                ad bdH = afVar.bdH();
                h.d(bdH, "descriptor.correspondingProperty");
                dVar.a(bdH, stringBuilder);
                return;
            }
            d((r) afVar, stringBuilder);
        }

        public void d(r rVar, StringBuilder stringBuilder) {
            h.e(rVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.c(rVar, stringBuilder);
        }

        public void a(ag agVar, StringBuilder stringBuilder) {
            h.e(agVar, "descriptor");
            h.e(stringBuilder, "builder");
            stringBuilder.append(agVar.bdc());
        }

        public void b(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, StringBuilder stringBuilder) {
            h.e(jVar, "constructorDescriptor");
            h.e(stringBuilder, "builder");
            d.this.a(jVar, stringBuilder);
        }

        public void a(an anVar, StringBuilder stringBuilder) {
            h.e(anVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(anVar, stringBuilder, true);
        }

        public void b(x xVar, StringBuilder stringBuilder) {
            h.e(xVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(xVar, stringBuilder);
        }

        public void b(z zVar, StringBuilder stringBuilder) {
            h.e(zVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(zVar, stringBuilder);
        }

        public void a(u uVar, StringBuilder stringBuilder) {
            h.e(uVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a((k) uVar, stringBuilder, true);
        }

        public void d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder stringBuilder) {
            h.e(dVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(dVar, stringBuilder);
        }

        public void b(am amVar, StringBuilder stringBuilder) {
            h.e(amVar, "descriptor");
            h.e(stringBuilder, "builder");
            d.this.a(amVar, stringBuilder);
        }
    }

    private final d bvy() {
        kotlin.d dVar = this.ePs;
        j jVar = apP[0];
        return (d) dVar.getValue();
    }

    private final b bvz() {
        kotlin.d dVar = this.ePt;
        j jVar = apP[1];
        return (b) dVar.getValue();
    }

    public boolean HW() {
        return this.ePu.HW();
    }

    public void a(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        h.e(annotationArgumentsRenderingPolicy, "<set-?>");
        this.ePu.a(annotationArgumentsRenderingPolicy);
    }

    public void a(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        h.e(parameterNameRenderingPolicy, "<set-?>");
        this.ePu.a(parameterNameRenderingPolicy);
    }

    public void a(RenderingFormat renderingFormat) {
        h.e(renderingFormat, "<set-?>");
        this.ePu.a(renderingFormat);
    }

    public void a(a aVar) {
        h.e(aVar, "<set-?>");
        this.ePu.a(aVar);
    }

    public boolean bvE() {
        return this.ePu.bvE();
    }

    public AnnotationArgumentsRenderingPolicy bvF() {
        return this.ePu.bvF();
    }

    public b<c, Boolean> bvG() {
        return this.ePu.bvG();
    }

    public boolean bvH() {
        return this.ePu.bvH();
    }

    public boolean bvI() {
        return this.ePu.bvI();
    }

    public a bvJ() {
        return this.ePu.bvJ();
    }

    public b<aq, String> bvK() {
        return this.ePu.bvK();
    }

    public boolean bvL() {
        return this.ePu.bvL();
    }

    public boolean bvM() {
        return this.ePu.bvM();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.b> bvN() {
        return this.ePu.bvN();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.b> bvO() {
        return this.ePu.bvO();
    }

    public boolean bvP() {
        return this.ePu.bvP();
    }

    public boolean bvQ() {
        return this.ePu.bvQ();
    }

    public boolean bvR() {
        return this.ePu.bvR();
    }

    public OverrideRenderingPolicy bvS() {
        return this.ePu.bvS();
    }

    public ParameterNameRenderingPolicy bvT() {
        return this.ePu.bvT();
    }

    public boolean bvU() {
        return this.ePu.bvU();
    }

    public boolean bvV() {
        return this.ePu.bvV();
    }

    public boolean bvW() {
        return this.ePu.bvW();
    }

    public boolean bvX() {
        return this.ePu.bvX();
    }

    public boolean bvY() {
        return this.ePu.bvY();
    }

    public boolean bvZ() {
        return this.ePu.bvZ();
    }

    public boolean bwa() {
        return this.ePu.bwa();
    }

    public boolean bwb() {
        return this.ePu.bwb();
    }

    public boolean bwc() {
        return this.ePu.bwc();
    }

    public boolean bwd() {
        return this.ePu.bwd();
    }

    public boolean bwe() {
        return this.ePu.bwe();
    }

    public boolean bwf() {
        return this.ePu.bwf();
    }

    public RenderingFormat bwg() {
        return this.ePu.bwg();
    }

    public b<w, w> bwh() {
        return this.ePu.bwh();
    }

    public boolean bwi() {
        return this.ePu.bwi();
    }

    public boolean bwj() {
        return this.ePu.bwj();
    }

    public b.b bwk() {
        return this.ePu.bwk();
    }

    public boolean bwl() {
        return this.ePu.bwl();
    }

    public boolean bwm() {
        return this.ePu.bwm();
    }

    public boolean bwn() {
        return this.ePu.bwn();
    }

    public boolean bwo() {
        return this.ePu.bwo();
    }

    public boolean bwp() {
        return this.ePu.bwp();
    }

    public boolean bwq() {
        return this.ePu.bwq();
    }

    public void bx(boolean z) {
        this.ePu.bx(z);
    }

    public void gV(boolean z) {
        this.ePu.gV(z);
    }

    public void gW(boolean z) {
        this.ePu.gW(z);
    }

    public void gX(boolean z) {
        this.ePu.gX(z);
    }

    public void gY(boolean z) {
        this.ePu.gY(z);
    }

    public void gZ(boolean z) {
        this.ePu.gZ(z);
    }

    public boolean getIncludeAnnotationArguments() {
        return this.ePu.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.ePu.getIncludeEmptyAnnotationArguments();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.ePu.getModifiers();
    }

    public void ha(boolean z) {
        this.ePu.ha(z);
    }

    public void k(Set<kotlin.reflect.jvm.internal.impl.name.b> set) {
        h.e(set, "<set-?>");
        this.ePu.k(set);
    }

    public void l(Set<? extends DescriptorRendererModifier> set) {
        h.e(set, "<set-?>");
        this.ePu.l(set);
    }

    public void setVerbose(boolean z) {
        this.ePu.setVerbose(z);
    }

    public final g bvD() {
        return this.ePu;
    }

    public d(g gVar) {
        h.e(gVar, "options");
        this.ePu = gVar;
        boolean isLocked = this.ePu.isLocked();
        if (!kotlin.m.etY || isLocked) {
            this.ePs = g.f(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
            this.ePt = g.f(new DescriptorRendererImpl$functionTypeParameterTypesRenderer$2(this));
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    private final String mL(String str) {
        switch (bwg()) {
            case PLAIN:
                return str;
            case HTML:
                if (!bvH()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("<b>");
                    stringBuilder.append(str);
                    stringBuilder.append("</b>");
                    str = stringBuilder.toString();
                }
                return str;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String mM(String str) {
        switch (bwg()) {
            case PLAIN:
                return str;
            case HTML:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<font color=red><b>");
                stringBuilder.append(str);
                stringBuilder.append("</b></font>");
                return stringBuilder.toString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String escape(String str) {
        return bwg().escape(str);
    }

    private final String bvA() {
        return escape("<");
    }

    private final String bvB() {
        return escape(">");
    }

    private final String bvC() {
        switch (bwg()) {
            case PLAIN:
                return escape("->");
            case HTML:
                return "&rarr;";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public String mN(String str) {
        h.e(str, "message");
        switch (bwg()) {
            case PLAIN:
                return str;
            case HTML:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<i>");
                stringBuilder.append(str);
                stringBuilder.append("</i>");
                return stringBuilder.toString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public String b(f fVar, boolean z) {
        h.e(fVar, "name");
        String escape = escape(j.K(fVar));
        if (!bvH() || bwg() != RenderingFormat.HTML || !z) {
            return escape;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b>");
        stringBuilder.append(escape);
        stringBuilder.append("</b>");
        return stringBuilder.toString();
    }

    private final void a(k kVar, StringBuilder stringBuilder, boolean z) {
        f bdc = kVar.bdc();
        h.d(bdc, "descriptor.name");
        stringBuilder.append(b(bdc, z));
    }

    private final void a(k kVar, StringBuilder stringBuilder) {
        if (bvY()) {
            if (bwf()) {
                stringBuilder.append("companion object");
            }
            s(stringBuilder);
            k bbv = kVar.bbv();
            if (bbv != null) {
                stringBuilder.append("of ");
                f bdc = bbv.bdc();
                h.d(bdc, "containingDeclaration.name");
                stringBuilder.append(b(bdc, false));
            }
        }
        if (bwl() || (h.E(kVar.bdc(), kotlin.reflect.jvm.internal.impl.name.h.eNq) ^ 1) != 0) {
            if (!bwf()) {
                s(stringBuilder);
            }
            f bdc2 = kVar.bdc();
            h.d(bdc2, "descriptor.name");
            stringBuilder.append(b(bdc2, true));
        }
    }

    public String f(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        h.e(cVar, "fqName");
        List pathSegments = cVar.pathSegments();
        h.d(pathSegments, "fqName.pathSegments()");
        return cj(pathSegments);
    }

    private final String cj(List<f> list) {
        return escape(j.cj(list));
    }

    public String b(kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        h.e(fVar, "klass");
        if (p.W(fVar)) {
            return fVar.bby().toString();
        }
        return bvJ().a(fVar, this);
    }

    public String b(w wVar) {
        h.e(wVar, Param.TYPE);
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder, (w) bwh().invoke(wVar));
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private final void b(StringBuilder stringBuilder, w wVar) {
        ay bzc = wVar.bzc();
        if (!(bzc instanceof kotlin.reflect.jvm.internal.impl.types.a)) {
            bzc = null;
        }
        kotlin.reflect.jvm.internal.impl.types.a aVar = (kotlin.reflect.jvm.internal.impl.types.a) bzc;
        if (aVar != null) {
            c(stringBuilder, (w) aVar.byI());
            if (bwc()) {
                a(stringBuilder, aVar);
            }
            return;
        }
        c(stringBuilder, wVar);
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (bwg() == RenderingFormat.HTML) {
            stringBuilder.append("<font color=\"808080\"><i>");
        }
        stringBuilder.append(" /* = ");
        c(stringBuilder, (w) aVar.bdO());
        stringBuilder.append(" */");
        if (bwg() == RenderingFormat.HTML) {
            stringBuilder.append("</i></font>");
        }
    }

    private final void c(StringBuilder stringBuilder, w wVar) {
        if ((wVar instanceof az) && HW() && !((az) wVar).byE()) {
            stringBuilder.append("<Not computed yet>");
            return;
        }
        ay bzc = wVar.bzc();
        if (bzc instanceof q) {
            stringBuilder.append(((q) bzc).a(this, this));
        } else if (bzc instanceof kotlin.reflect.jvm.internal.impl.types.ad) {
            a(stringBuilder, (kotlin.reflect.jvm.internal.impl.types.ad) bzc);
        }
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.types.ad adVar) {
        if (!h.E(adVar, au.eVn)) {
            w wVar = adVar;
            if (!au.aS(wVar)) {
                if (p.aA(wVar)) {
                    if (bwi()) {
                        kotlin.reflect.jvm.internal.impl.types.an bwA = adVar.bwA();
                        if (bwA == null) {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
                        }
                        an byS = ((kotlin.reflect.jvm.internal.impl.types.p.d) bwA).byS();
                        h.d(byS, "(type.constructor as Uni…).typeParameterDescriptor");
                        String fVar = byS.bdc().toString();
                        h.d(fVar, "(type.constructor as Uni…escriptor.name.toString()");
                        stringBuilder.append(mM(fVar));
                    } else {
                        stringBuilder.append("???");
                    }
                    return;
                } else if (y.aF(wVar)) {
                    d(stringBuilder, wVar);
                    return;
                } else {
                    if (aj(wVar)) {
                        e(stringBuilder, wVar);
                    } else {
                        d(stringBuilder, wVar);
                    }
                    return;
                }
            }
        }
        stringBuilder.append("???");
    }

    private final boolean aj(w wVar) {
        if (!kotlin.reflect.jvm.internal.impl.builtins.f.e(wVar)) {
            return false;
        }
        Object obj;
        Iterable<ap> bdF = wVar.bdF();
        if (!((bdF instanceof Collection) && ((Collection) bdF).isEmpty())) {
            for (ap bze : bdF) {
                if (bze.bze()) {
                    obj = null;
                    break;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            return true;
        }
        return false;
    }

    public String a(String str, String str2, g gVar) {
        String str3 = str;
        String str4 = str2;
        h.e(str3, "lowerRendered");
        h.e(str4, "upperRendered");
        h.e(gVar, "builtIns");
        StringBuilder stringBuilder;
        if (!bj(str, str2)) {
            a bvJ = bvJ();
            kotlin.reflect.jvm.internal.impl.descriptors.d baR = gVar.baR();
            h.d(baR, "builtIns.collection");
            b bVar = this;
            String a = v.a(bvJ.a(baR, bVar), "Collection", null, 2, null);
            String str5 = "Mutable";
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append(str5);
            String stringBuilder3 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append('(');
            stringBuilder2.append(str5);
            stringBuilder2.append(')');
            str5 = c(str3, stringBuilder3, str4, a, stringBuilder2.toString());
            if (str5 != null) {
                return str5;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("MutableMap.MutableEntry");
            stringBuilder3 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("Map.Entry");
            String stringBuilder4 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("(Mutable)Map.(Mutable)Entry");
            str5 = c(str3, stringBuilder3, str4, stringBuilder4, stringBuilder.toString());
            if (str5 != null) {
                return str5;
            }
            bvJ = bvJ();
            baR = gVar.baN();
            h.d(baR, "builtIns.array");
            str5 = v.a(bvJ.a(baR, bVar), "Array", null, 2, null);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str5);
            stringBuilder2.append(escape("Array<"));
            stringBuilder3 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str5);
            stringBuilder2.append(escape("Array<out "));
            stringBuilder4 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str5);
            stringBuilder2.append(escape("Array<(out) "));
            str5 = c(str3, stringBuilder3, str4, stringBuilder4, stringBuilder2.toString());
            if (str5 != null) {
                return str5;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append('(');
            stringBuilder.append(str3);
            stringBuilder.append("..");
            stringBuilder.append(str4);
            stringBuilder.append(')');
            return stringBuilder.toString();
        } else if (u.a(str4, "(", false, 2, null)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append('(');
            stringBuilder.append(str3);
            stringBuilder.append(")!");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append("!");
            return stringBuilder.toString();
        }
    }

    public String ck(List<? extends ap> list) {
        h.e(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bvA());
        a(stringBuilder, (List) list);
        stringBuilder.append(bvB());
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private final void d(StringBuilder stringBuilder, w wVar) {
        a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) wVar);
        if (y.aF(wVar)) {
            if ((wVar instanceof ax) && bvV()) {
                stringBuilder.append(((ax) wVar).bzj());
            } else {
                stringBuilder.append(wVar.bwA().toString());
            }
            stringBuilder.append(ck(wVar.bdF()));
        } else {
            a(this, stringBuilder, wVar, null, 2, null);
        }
        if (wVar.aYp()) {
            stringBuilder.append("?");
        }
        if (kotlin.reflect.jvm.internal.impl.types.ag.aI(wVar)) {
            stringBuilder.append("!!");
        }
    }

    static /* synthetic */ void a(d dVar, StringBuilder stringBuilder, w wVar, kotlin.reflect.jvm.internal.impl.types.an anVar, int i, Object obj) {
        if ((i & 2) != 0) {
            anVar = wVar.bwA();
        }
        dVar.a(stringBuilder, wVar, anVar);
    }

    private final void a(StringBuilder stringBuilder, w wVar, kotlin.reflect.jvm.internal.impl.types.an anVar) {
        ab O = ao.O(wVar);
        if (O == null) {
            stringBuilder.append(a(anVar));
            stringBuilder.append(ck(wVar.bdF()));
            return;
        }
        a(stringBuilder, O);
    }

    /* JADX WARNING: Missing block: B:3:0x0023, code:
            if (r3 != null) goto L_0x003a;
     */
    private final void a(java.lang.StringBuilder r3, kotlin.reflect.jvm.internal.impl.descriptors.ab r4) {
        /*
        r2 = this;
        r0 = r4.bdG();
        if (r0 == 0) goto L_0x0026;
    L_0x0006:
        r2.a(r3, r0);
        r0 = 46;
        r3.append(r0);
        r0 = r4.bdE();
        r0 = r0.bdc();
        r1 = "possiblyInnerType.classifierDescriptor.name";
        kotlin.jvm.internal.h.d(r0, r1);
        r1 = 0;
        r0 = r2.b(r0, r1);
        r3.append(r0);
        if (r3 == 0) goto L_0x0026;
    L_0x0025:
        goto L_0x003a;
    L_0x0026:
        r0 = r4.bdE();
        r0 = r0.bby();
        r1 = "possiblyInnerType.classi…escriptor.typeConstructor";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = r2.a(r0);
        r3.append(r0);
    L_0x003a:
        r4 = r4.bdF();
        r4 = r2.ck(r4);
        r3.append(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.a(java.lang.StringBuilder, kotlin.reflect.jvm.internal.impl.descriptors.ab):void");
    }

    public String a(kotlin.reflect.jvm.internal.impl.types.an anVar) {
        h.e(anVar, "typeConstructor");
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = anVar.bbW();
        if ((bbW instanceof an) || (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) || (bbW instanceof am)) {
            return b(bbW);
        }
        if (bbW == null) {
            return anVar.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected classifier: ");
        stringBuilder.append(bbW.getClass());
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public String a(ap apVar) {
        h.e(apVar, "typeProjection");
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, l.cr(apVar));
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private final void a(StringBuilder stringBuilder, List<? extends ap> list) {
        u.a(list, stringBuilder, ", ", null, null, 0, null, new DescriptorRendererImpl$appendTypeProjections$1(this), 60, null);
    }

    private final void e(StringBuilder stringBuilder, w wVar) {
        int length = stringBuilder.length();
        bvy().a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) wVar);
        int i = 1;
        Object obj = stringBuilder.length() != length ? 1 : null;
        boolean d = kotlin.reflect.jvm.internal.impl.builtins.f.d(wVar);
        boolean aYp = wVar.aYp();
        w h = kotlin.reflect.jvm.internal.impl.builtins.f.h(wVar);
        Object obj2 = (aYp || !(obj == null || h == null)) ? 1 : null;
        if (obj2 != null) {
            if (d) {
                stringBuilder.insert(length, '(');
            } else {
                if (obj != null) {
                    CharSequence charSequence = stringBuilder;
                    obj = x.R(charSequence) == ' ' ? 1 : null;
                    if (kotlin.m.etY && obj == null) {
                        throw new AssertionError("Assertion failed");
                    } else if (stringBuilder.charAt(v.O(charSequence) - 1) != ')') {
                        stringBuilder.insert(v.O(charSequence), "()");
                    }
                }
                stringBuilder.append("(");
            }
        }
        a(stringBuilder, d, "suspend");
        if (h != null) {
            if ((!aj(h) || h.aYp()) && !ak(h)) {
                i = 0;
            }
            if (i != 0) {
                stringBuilder.append("(");
            }
            b(stringBuilder, h);
            if (i != 0) {
                stringBuilder.append(")");
            }
            stringBuilder.append(".");
        }
        stringBuilder.append("(");
        int i2 = 0;
        for (ap apVar : kotlin.reflect.jvm.internal.impl.builtins.f.j(wVar)) {
            f k;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if (bvU()) {
                w bai = apVar.bai();
                h.d(bai, "typeProjection.type");
                k = kotlin.reflect.jvm.internal.impl.builtins.f.k(bai);
            } else {
                k = null;
            }
            if (k != null) {
                stringBuilder.append(b(k, false));
                stringBuilder.append(": ");
            }
            stringBuilder.append(bvz().a(apVar));
            i2++;
        }
        stringBuilder.append(") ");
        stringBuilder.append(bvC());
        stringBuilder.append(" ");
        b(stringBuilder, kotlin.reflect.jvm.internal.impl.builtins.f.i(wVar));
        if (obj2 != null) {
            stringBuilder.append(")");
        }
        if (aYp) {
            stringBuilder.append("?");
        }
    }

    private final boolean ak(w wVar) {
        return kotlin.reflect.jvm.internal.impl.builtins.f.d(wVar) || !wVar.bbQ().isEmpty();
    }

    private final void a(StringBuilder stringBuilder, k kVar) {
        if (!(kVar instanceof x) && !(kVar instanceof z)) {
            if (kVar instanceof u) {
                stringBuilder.append(" is a module");
                return;
            }
            k bbv = kVar.bbv();
            if (!(bbv == null || (bbv instanceof u))) {
                stringBuilder.append(" ");
                stringBuilder.append(mN("defined in"));
                stringBuilder.append(" ");
                kotlin.reflect.jvm.internal.impl.name.c w = kotlin.reflect.jvm.internal.impl.resolve.c.w(bbv);
                h.d(w, "fqName");
                stringBuilder.append(w.isRoot() ? "root package" : f(w));
                if (bwn() && (bbv instanceof x) && (kVar instanceof n)) {
                    ai bbR = ((n) kVar).bbR();
                    h.d(bbR, "descriptor.source");
                    aj ban = bbR.ban();
                    h.d(ban, "descriptor.source.containingFile");
                    String name = ban.getName();
                    if (name != null) {
                        stringBuilder.append(" ");
                        stringBuilder.append(mN("in file"));
                        stringBuilder.append(" ");
                        stringBuilder.append(name);
                    }
                }
            }
        }
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set bvO = aVar instanceof w ? bvO() : bvN();
            b bvG = bvG();
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar : aVar.bbQ().bek()) {
                c beh = fVar.beh();
                AnnotationUseSiteTarget bei = fVar.bei();
                if (!u.b((Iterable) bvO, (Object) beh.bdD()) && (bvG == null || ((Boolean) bvG.invoke(beh)).booleanValue())) {
                    stringBuilder.append(a(beh, bei));
                    if (bvL()) {
                        q.t(stringBuilder);
                    } else {
                        stringBuilder.append(" ");
                    }
                }
            }
        }
    }

    public String a(c cVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
        h.e(cVar, "annotation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        if (annotationUseSiteTarget != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(annotationUseSiteTarget.getRenderName());
            stringBuilder2.append(":");
            stringBuilder.append(stringBuilder2.toString());
        }
        w bai = cVar.bai();
        stringBuilder.append(b(bai));
        if (getIncludeAnnotationArguments()) {
            List k = k(cVar);
            if (getIncludeEmptyAnnotationArguments() || (k.isEmpty() ^ 1) != 0) {
                u.a(k, stringBuilder, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (bwl() && (y.aF(bai) || (bai.bwA().bbW() instanceof kotlin.reflect.jvm.internal.impl.descriptors.w.b))) {
            stringBuilder.append(" /* annotation class not found */");
        }
        String stringBuilder3 = stringBuilder.toString();
        h.d(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }

    private final List<String> k(c cVar) {
        List bcS;
        Collection arrayList;
        StringBuilder stringBuilder;
        f fVar;
        Map bee = cVar.bee();
        List list = null;
        kotlin.reflect.jvm.internal.impl.descriptors.d l = bwa() ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(cVar) : null;
        if (l != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.c bbI = l.bbI();
            if (bbI != null) {
                bcS = bbI.bcS();
                if (bcS != null) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next : bcS) {
                        if (((aq) next).bdR()) {
                            arrayList2.add(next);
                        }
                    }
                    Iterable<aq> iterable = (List) arrayList2;
                    arrayList = new ArrayList(n.e(iterable, 10));
                    for (aq aqVar : iterable) {
                        h.d(aqVar, "it");
                        arrayList.add(aqVar.bdc());
                    }
                    list = (List) arrayList;
                }
            }
        }
        if (list == null) {
            list = m.emptyList();
        }
        Collection arrayList3 = new ArrayList();
        for (Object next2 : list) {
            if ((bee.containsKey((f) next2) ^ 1) != 0) {
                arrayList3.add(next2);
            }
        }
        Iterable<f> iterable2 = (List) arrayList3;
        arrayList = new ArrayList(n.e(iterable2, 10));
        for (f fVar2 : iterable2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(fVar2.asString());
            stringBuilder.append(" = ...");
            arrayList.add(stringBuilder.toString());
        }
        bcS = (List) arrayList;
        Iterable<Entry> entrySet = bee.entrySet();
        arrayList3 = new ArrayList(n.e(entrySet, 10));
        for (Entry entry : entrySet) {
            fVar2 = (f) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar3 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) entry.getValue();
            stringBuilder = new StringBuilder();
            stringBuilder.append(fVar2.asString());
            stringBuilder.append(" = ");
            stringBuilder.append(!list.contains(fVar2) ? c(fVar3) : "...");
            arrayList3.add(stringBuilder.toString());
        }
        return u.U(u.b((Collection) bcS, (Iterable) (List) arrayList3));
    }

    private final String c(kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> fVar) {
        if (fVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            return u.a((Iterable) ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) fVar).getValue(), ", ", "{", "}", 0, null, new DescriptorRendererImpl$renderConstant$1(this), 24, null);
        }
        if (fVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            return v.a(b.a(this, (c) ((kotlin.reflect.jvm.internal.impl.resolve.constants.a) fVar).getValue(), null, 2, null), (CharSequence) "@");
        }
        if (!(fVar instanceof o)) {
            return fVar.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(((o) fVar).getValue()));
        stringBuilder.append("::class");
        return stringBuilder.toString();
    }

    private final void a(av avVar, StringBuilder stringBuilder) {
        if (getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            if (bvR()) {
                avVar = avVar.bec();
            }
            if (bwb() || !h.E(avVar, kotlin.reflect.jvm.internal.impl.descriptors.au.eBn)) {
                stringBuilder.append(mL(avVar.getDisplayName()));
                stringBuilder.append(" ");
            }
        }
    }

    private final void a(Modality modality, StringBuilder stringBuilder) {
        boolean contains = getModifiers().contains(DescriptorRendererModifier.MODALITY);
        String name = modality.name();
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        name = name.toLowerCase();
        h.d(name, "(this as java.lang.String).toLowerCase()");
        a(stringBuilder, contains, name);
    }

    private final void a(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        if ((!kotlin.reflect.jvm.internal.impl.resolve.c.A((k) callableMemberDescriptor) || callableMemberDescriptor.bbG() != Modality.FINAL) && (bvS() != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.bbG() != Modality.OPEN || !z(callableMemberDescriptor))) {
            Modality bbG = callableMemberDescriptor.bbG();
            h.d(bbG, "callable.modality");
            a(bbG, stringBuilder);
        }
    }

    private final void b(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && z(callableMemberDescriptor) && bvS() != OverrideRenderingPolicy.RENDER_OPEN) {
            a(stringBuilder, true, "override");
            if (bwl()) {
                stringBuilder.append("/*");
                stringBuilder.append(callableMemberDescriptor.bcU().size());
                stringBuilder.append("*/ ");
            }
        }
    }

    private final void c(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && bwl() && callableMemberDescriptor.bcW() != Kind.DECLARATION) {
            stringBuilder.append("/*");
            String name = callableMemberDescriptor.bcW().name();
            if (name == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            name = name.toLowerCase();
            h.d(name, "(this as java.lang.String).toLowerCase()");
            stringBuilder.append(name);
            stringBuilder.append("*/ ");
        }
    }

    private final void a(StringBuilder stringBuilder, boolean z, String str) {
        if (z) {
            stringBuilder.append(mL(str));
            stringBuilder.append(" ");
        }
    }

    private final void a(s sVar, StringBuilder stringBuilder) {
        a(stringBuilder, sVar.isExternal(), "external");
        boolean z = false;
        boolean z2 = getModifiers().contains(DescriptorRendererModifier.EXPECT) && sVar.bbO();
        a(stringBuilder, z2, "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) && sVar.bbP()) {
            z = true;
        }
        a(stringBuilder, z, "actual");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.r r7, java.lang.StringBuilder r8) {
        /*
        r6 = this;
        r0 = r7.bdn();
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0048;
    L_0x0008:
        r0 = r7.bcU();
        r3 = "functionDescriptor.overriddenDescriptors";
        kotlin.jvm.internal.h.d(r0, r3);
        r0 = (java.lang.Iterable) r0;
        r3 = r0 instanceof java.util.Collection;
        if (r3 == 0) goto L_0x0022;
    L_0x0017:
        r3 = r0;
        r3 = (java.util.Collection) r3;
        r3 = r3.isEmpty();
        if (r3 == 0) goto L_0x0022;
    L_0x0020:
        r0 = 1;
        goto L_0x003e;
    L_0x0022:
        r0 = r0.iterator();
    L_0x0026:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0020;
    L_0x002c:
        r3 = r0.next();
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r3;
        r4 = "it";
        kotlin.jvm.internal.h.d(r3, r4);
        r3 = r3.bdn();
        if (r3 == 0) goto L_0x0026;
    L_0x003d:
        r0 = 0;
    L_0x003e:
        if (r0 != 0) goto L_0x0046;
    L_0x0040:
        r0 = r6.bvE();
        if (r0 == 0) goto L_0x0048;
    L_0x0046:
        r0 = 1;
        goto L_0x0049;
    L_0x0048:
        r0 = 0;
    L_0x0049:
        r3 = r7.bdo();
        if (r3 == 0) goto L_0x008e;
    L_0x004f:
        r3 = r7.bcU();
        r4 = "functionDescriptor.overriddenDescriptors";
        kotlin.jvm.internal.h.d(r3, r4);
        r3 = (java.lang.Iterable) r3;
        r4 = r3 instanceof java.util.Collection;
        if (r4 == 0) goto L_0x0069;
    L_0x005e:
        r4 = r3;
        r4 = (java.util.Collection) r4;
        r4 = r4.isEmpty();
        if (r4 == 0) goto L_0x0069;
    L_0x0067:
        r3 = 1;
        goto L_0x0085;
    L_0x0069:
        r3 = r3.iterator();
    L_0x006d:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0067;
    L_0x0073:
        r4 = r3.next();
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r4;
        r5 = "it";
        kotlin.jvm.internal.h.d(r4, r5);
        r4 = r4.bdo();
        if (r4 == 0) goto L_0x006d;
    L_0x0084:
        r3 = 0;
    L_0x0085:
        if (r3 != 0) goto L_0x008d;
    L_0x0087:
        r3 = r6.bvE();
        if (r3 == 0) goto L_0x008e;
    L_0x008d:
        r1 = 1;
    L_0x008e:
        r2 = r7.bcb();
        r3 = "tailrec";
        r6.a(r8, r2, r3);
        r6.b(r7, r8);
        r7 = r7.bbN();
        r2 = "inline";
        r6.a(r8, r7, r2);
        r7 = "infix";
        r6.a(r8, r1, r7);
        r7 = "operator";
        r6.a(r8, r0, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.a(kotlin.reflect.jvm.internal.impl.descriptors.r, java.lang.StringBuilder):void");
    }

    private final void b(r rVar, StringBuilder stringBuilder) {
        a(stringBuilder, rVar.bdq(), "suspend");
    }

    public String s(k kVar) {
        h.e(kVar, "declarationDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        kVar.a(new a(), stringBuilder);
        if (bwm()) {
            a(stringBuilder, kVar);
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private final void a(an anVar, StringBuilder stringBuilder, boolean z) {
        if (z) {
            stringBuilder.append(bvA());
        }
        if (bwl()) {
            stringBuilder.append("/*");
            stringBuilder.append(anVar.getIndex());
            stringBuilder.append("*/ ");
        }
        a(stringBuilder, anVar.bde(), "reified");
        String label = anVar.bdd().getLabel();
        Object obj = 1;
        a(stringBuilder, ((CharSequence) label).length() > 0, label);
        a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) anVar);
        a((k) anVar, stringBuilder, z);
        int size = anVar.aYq().size();
        if ((size > 1 && !z) || size == 1) {
            w wVar = (w) anVar.aYq().iterator().next();
            if (!g.F(wVar)) {
                stringBuilder.append(" : ");
                h.d(wVar, "upperBound");
                stringBuilder.append(b(wVar));
            }
        } else if (z) {
            for (w wVar2 : anVar.aYq()) {
                if (!g.F(wVar2)) {
                    if (obj != null) {
                        stringBuilder.append(" : ");
                    } else {
                        stringBuilder.append(" & ");
                    }
                    h.d(wVar2, "upperBound");
                    stringBuilder.append(b(wVar2));
                    obj = null;
                }
            }
        }
        if (z) {
            stringBuilder.append(bvB());
        }
    }

    private final void a(List<? extends an> list, StringBuilder stringBuilder, boolean z) {
        if (!(bwq() || list.isEmpty())) {
            stringBuilder.append(bvA());
            b(stringBuilder, (List) list);
            stringBuilder.append(bvB());
            if (z) {
                stringBuilder.append(" ");
            }
        }
    }

    private final void b(StringBuilder stringBuilder, List<? extends an> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a((an) it.next(), stringBuilder, false);
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
    }

    private final void c(r rVar, StringBuilder stringBuilder) {
        List typeParameters;
        if (!bwf()) {
            if (!bwe()) {
                a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) rVar);
                av bbJ = rVar.bbJ();
                h.d(bbJ, "function.visibility");
                a(bbJ, stringBuilder);
                CallableMemberDescriptor callableMemberDescriptor = rVar;
                a(callableMemberDescriptor, stringBuilder);
                if (bvP()) {
                    a((s) rVar, stringBuilder);
                }
                b(callableMemberDescriptor, stringBuilder);
                if (bvP()) {
                    a(rVar, stringBuilder);
                } else {
                    b(rVar, stringBuilder);
                }
                c(callableMemberDescriptor, stringBuilder);
                if (bwl()) {
                    if (rVar.bdm()) {
                        stringBuilder.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (rVar.bdp()) {
                        stringBuilder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            stringBuilder.append(mL("fun"));
            stringBuilder.append(" ");
            typeParameters = rVar.getTypeParameters();
            h.d(typeParameters, "function.typeParameters");
            a(typeParameters, stringBuilder, true);
            b((kotlin.reflect.jvm.internal.impl.descriptors.a) rVar, stringBuilder);
        }
        a((k) rVar, stringBuilder, true);
        typeParameters = rVar.bcS();
        h.d(typeParameters, "function.valueParameters");
        a((Collection) typeParameters, rVar.bcT(), stringBuilder);
        a((kotlin.reflect.jvm.internal.impl.descriptors.a) rVar, stringBuilder);
        w bcQ = rVar.bcQ();
        if (!bwo() && (bwj() || bcQ == null || !g.G(bcQ))) {
            stringBuilder.append(": ");
            stringBuilder.append(bcQ == null ? "[NULL]" : b(bcQ));
        }
        List typeParameters2 = rVar.getTypeParameters();
        h.d(typeParameters2, "function.typeParameters");
        a(typeParameters2, stringBuilder);
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder stringBuilder) {
        if (bvW()) {
            ag bcO = aVar.bcO();
            if (bcO != null) {
                stringBuilder.append(" on ");
                w bai = bcO.bai();
                h.d(bai, "receiver.type");
                stringBuilder.append(b(bai));
            }
        }
    }

    private final void b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder stringBuilder) {
        ag bcO = aVar.bcO();
        if (bcO != null) {
            w bai = bcO.bai();
            h.d(bai, Param.TYPE);
            String b = b(bai);
            if (aj(bai) && !au.aW(bai)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append('(');
                stringBuilder2.append(b);
                stringBuilder2.append(')');
                b = stringBuilder2.toString();
            }
            stringBuilder.append(b);
            stringBuilder.append(".");
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, StringBuilder stringBuilder) {
        List typeParameters;
        a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) jVar);
        av bbJ = jVar.bbJ();
        h.d(bbJ, "constructor.visibility");
        a(bbJ, stringBuilder);
        c((CallableMemberDescriptor) jVar, stringBuilder);
        if (bvZ()) {
            stringBuilder.append(mL("constructor"));
        }
        if (bwd()) {
            kotlin.reflect.jvm.internal.impl.descriptors.g bdj = jVar.bdj();
            if (bvZ()) {
                stringBuilder.append(" ");
            }
            h.d(bdj, "classDescriptor");
            a((k) bdj, stringBuilder, true);
            typeParameters = jVar.getTypeParameters();
            h.d(typeParameters, "constructor.typeParameters");
            a(typeParameters, stringBuilder, false);
        }
        typeParameters = jVar.bcS();
        h.d(typeParameters, "constructor.valueParameters");
        a((Collection) typeParameters, jVar.bcT(), stringBuilder);
        if (bwd()) {
            List typeParameters2 = jVar.getTypeParameters();
            h.d(typeParameters2, "constructor.typeParameters");
            a(typeParameters2, stringBuilder);
        }
    }

    private final void a(List<? extends an> list, StringBuilder stringBuilder) {
        if (!bwq()) {
            ArrayList arrayList = new ArrayList(0);
            for (an anVar : list) {
                List aYq = anVar.aYq();
                h.d(aYq, "typeParameter.upperBounds");
                for (w wVar : u.f((Iterable) aYq, 1)) {
                    Collection collection = arrayList;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    f bdc = anVar.bdc();
                    h.d(bdc, "typeParameter.name");
                    stringBuilder2.append(b(bdc, false));
                    stringBuilder2.append(" : ");
                    h.d(wVar, "it");
                    stringBuilder2.append(b(wVar));
                    collection.add(stringBuilder2.toString());
                }
                Collection collection2 = arrayList;
            }
            if (!arrayList.isEmpty()) {
                stringBuilder.append(" ");
                stringBuilder.append(mL("where"));
                stringBuilder.append(" ");
                u.a(arrayList, stringBuilder, ", ", null, null, 0, null, null, 124, null);
            }
        }
    }

    private final void a(Collection<? extends aq> collection, boolean z, StringBuilder stringBuilder) {
        z = gU(z);
        int size = collection.size();
        bwk().b(size, stringBuilder);
        int i = 0;
        for (aq aqVar : collection) {
            bwk().a(aqVar, i, size, stringBuilder);
            a(aqVar, z, stringBuilder, false);
            bwk().b(aqVar, i, size, stringBuilder);
            i++;
        }
        bwk().c(size, stringBuilder);
    }

    private final boolean gU(boolean z) {
        switch (bvT()) {
            case ALL:
                return true;
            case ONLY_NON_SYNTHESIZED:
                return z ^ true;
            case NONE:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.aq r3, boolean r4, java.lang.StringBuilder r5, boolean r6) {
        /*
        r2 = this;
        if (r6 == 0) goto L_0x0010;
    L_0x0002:
        r0 = "value-parameter";
        r0 = r2.mL(r0);
        r5.append(r0);
        r0 = " ";
        r5.append(r0);
    L_0x0010:
        r0 = r2.bwl();
        if (r0 == 0) goto L_0x0027;
    L_0x0016:
        r0 = "/*";
        r5.append(r0);
        r0 = r3.getIndex();
        r5.append(r0);
        r0 = "*/ ";
        r5.append(r0);
    L_0x0027:
        r0 = r3;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) r0;
        r2.a(r5, r0);
        r0 = r3.bdU();
        r1 = "crossinline";
        r2.a(r5, r0, r1);
        r0 = r3.bdV();
        r1 = "noinline";
        r2.a(r5, r0, r1);
        r0 = r3;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.as) r0;
        r2.a(r0, r4, r5, r6);
        r4 = r2.bvK();
        if (r4 == 0) goto L_0x005e;
    L_0x004b:
        r4 = r2.HW();
        if (r4 == 0) goto L_0x0056;
    L_0x0051:
        r4 = r3.bdR();
        goto L_0x005a;
    L_0x0056:
        r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(r3);
    L_0x005a:
        if (r4 == 0) goto L_0x005e;
    L_0x005c:
        r4 = 1;
        goto L_0x005f;
    L_0x005e:
        r4 = 0;
    L_0x005f:
        if (r4 == 0) goto L_0x0084;
    L_0x0061:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = " = ";
        r4.append(r6);
        r6 = r2.bvK();
        if (r6 != 0) goto L_0x0074;
    L_0x0071:
        kotlin.jvm.internal.h.aXZ();
    L_0x0074:
        r3 = r6.invoke(r3);
        r3 = (java.lang.String) r3;
        r4.append(r3);
        r3 = r4.toString();
        r5.append(r3);
    L_0x0084:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.a(kotlin.reflect.jvm.internal.impl.descriptors.aq, boolean, java.lang.StringBuilder, boolean):void");
    }

    private final void a(as asVar, StringBuilder stringBuilder) {
        if (!(asVar instanceof aq)) {
            stringBuilder.append(mL(asVar.bdW() ? "var" : "val"));
            stringBuilder.append(" ");
        }
    }

    private final void a(as asVar, boolean z, StringBuilder stringBuilder, boolean z2) {
        w wVar;
        w bai = asVar.bai();
        aq aqVar = (aq) (!(asVar instanceof aq) ? null : asVar);
        w bdS = aqVar != null ? aqVar.bdS() : null;
        if (bdS != null) {
            wVar = bdS;
        } else {
            h.d(bai, "realType");
            wVar = bai;
        }
        a(stringBuilder, bdS != null, "vararg");
        if (z2 && !bwf()) {
            a(asVar, stringBuilder);
        }
        if (z) {
            a((k) asVar, stringBuilder, z2);
            stringBuilder.append(": ");
        }
        stringBuilder.append(b(wVar));
        b(asVar, stringBuilder);
        if (bwl() && bdS != null) {
            stringBuilder.append(" /*");
            h.d(bai, "realType");
            stringBuilder.append(b(bai));
            stringBuilder.append("*/");
        }
    }

    private final void a(ad adVar, StringBuilder stringBuilder) {
        if (!bwf()) {
            if (!bwe()) {
                a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) adVar);
                av bbJ = adVar.bbJ();
                h.d(bbJ, "property.visibility");
                a(bbJ, stringBuilder);
                a(stringBuilder, adVar.bdY(), "const");
                a((s) adVar, stringBuilder);
                CallableMemberDescriptor callableMemberDescriptor = adVar;
                a(callableMemberDescriptor, stringBuilder);
                b(callableMemberDescriptor, stringBuilder);
                a(stringBuilder, adVar.bdZ(), "lateinit");
                c(callableMemberDescriptor, stringBuilder);
            }
            a((as) adVar, stringBuilder);
            List typeParameters = adVar.getTypeParameters();
            h.d(typeParameters, "property.typeParameters");
            a(typeParameters, stringBuilder, true);
            b((kotlin.reflect.jvm.internal.impl.descriptors.a) adVar, stringBuilder);
        }
        a((k) adVar, stringBuilder, true);
        stringBuilder.append(": ");
        w bai = adVar.bai();
        h.d(bai, "property.type");
        stringBuilder.append(b(bai));
        a((kotlin.reflect.jvm.internal.impl.descriptors.a) adVar, stringBuilder);
        b((as) adVar, stringBuilder);
        List typeParameters2 = adVar.getTypeParameters();
        h.d(typeParameters2, "property.typeParameters");
        a(typeParameters2, stringBuilder);
    }

    private final void b(as asVar, StringBuilder stringBuilder) {
        if (bvQ()) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.f bdX = asVar.bdX();
            if (bdX != null) {
                stringBuilder.append(" = ");
                h.d(bdX, "constant");
                stringBuilder.append(escape(c(bdX)));
            }
        }
    }

    private final void a(am amVar, StringBuilder stringBuilder) {
        a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) amVar);
        av bbJ = amVar.bbJ();
        h.d(bbJ, "typeAlias.visibility");
        a(bbJ, stringBuilder);
        a((s) amVar, stringBuilder);
        stringBuilder.append(mL("typealias"));
        stringBuilder.append(" ");
        a((k) amVar, stringBuilder, true);
        List bbS = amVar.bbS();
        h.d(bbS, "typeAlias.declaredTypeParameters");
        a(bbS, stringBuilder, false);
        a((kotlin.reflect.jvm.internal.impl.descriptors.g) amVar, stringBuilder);
        stringBuilder.append(" = ");
        stringBuilder.append(b((w) amVar.bdN()));
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, StringBuilder stringBuilder) {
        List bbS = gVar.bbS();
        kotlin.reflect.jvm.internal.impl.types.an bby = gVar.bby();
        h.d(bby, "classifier.typeConstructor");
        List parameters = bby.getParameters();
        if (bwl() && gVar.bbL() && parameters.size() > bbS.size()) {
            stringBuilder.append(" /*captured type parameters: ");
            b(stringBuilder, parameters.subList(bbS.size(), parameters.size()));
            stringBuilder.append("*/");
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder stringBuilder) {
        ClassKind bbF;
        Object obj = dVar.bbF() == ClassKind.ENUM_ENTRY ? 1 : null;
        if (!bwf()) {
            a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) dVar);
            if (obj == null) {
                av bbJ = dVar.bbJ();
                h.d(bbJ, "klass.visibility");
                a(bbJ, stringBuilder);
            }
            if (!(dVar.bbF() == ClassKind.INTERFACE && dVar.bbG() == Modality.ABSTRACT)) {
                bbF = dVar.bbF();
                h.d(bbF, "klass.kind");
                if (!(bbF.isSingleton() && dVar.bbG() == Modality.FINAL)) {
                    Modality bbG = dVar.bbG();
                    h.d(bbG, "klass.modality");
                    a(bbG, stringBuilder);
                }
            }
            a((s) dVar, stringBuilder);
            boolean z = getModifiers().contains(DescriptorRendererModifier.INNER) && dVar.bbL();
            a(stringBuilder, z, "inner");
            z = getModifiers().contains(DescriptorRendererModifier.DATA) && dVar.bbM();
            a(stringBuilder, z, "data");
            z = getModifiers().contains(DescriptorRendererModifier.INLINE) && dVar.bbN();
            a(stringBuilder, z, "inline");
            c(dVar, stringBuilder);
        }
        k kVar = dVar;
        if (kotlin.reflect.jvm.internal.impl.resolve.c.D(kVar)) {
            a(kVar, stringBuilder);
        } else {
            if (!bwf()) {
                s(stringBuilder);
            }
            a(kVar, stringBuilder, true);
        }
        if (obj == null) {
            List bbS = dVar.bbS();
            h.d(bbS, "typeParameters");
            a(bbS, stringBuilder, false);
            a((kotlin.reflect.jvm.internal.impl.descriptors.g) dVar, stringBuilder);
            bbF = dVar.bbF();
            h.d(bbF, "klass.kind");
            if (!bbF.isSingleton() && bvI()) {
                kotlin.reflect.jvm.internal.impl.descriptors.c bbI = dVar.bbI();
                if (bbI != null) {
                    stringBuilder.append(" ");
                    a(stringBuilder, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) bbI);
                    av bbJ2 = bbI.bbJ();
                    h.d(bbJ2, "primaryConstructor.visibility");
                    a(bbJ2, stringBuilder);
                    stringBuilder.append(mL("constructor"));
                    List bcS = bbI.bcS();
                    h.d(bcS, "primaryConstructor.valueParameters");
                    a((Collection) bcS, bbI.bcT(), stringBuilder);
                }
            }
            b(dVar, stringBuilder);
            a(bbS, stringBuilder);
        }
    }

    private final void b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder stringBuilder) {
        if (!bwp() && !g.B(dVar.bdb())) {
            kotlin.reflect.jvm.internal.impl.types.an bby = dVar.bby();
            h.d(bby, "klass.typeConstructor");
            Collection beu = bby.beu();
            if (!beu.isEmpty() && (beu.size() != 1 || !g.D((w) beu.iterator().next()))) {
                s(stringBuilder);
                stringBuilder.append(": ");
                h.d(beu, "supertypes");
                u.a(beu, stringBuilder, ", ", null, null, 0, null, new DescriptorRendererImpl$renderSuperTypes$1(this), 60, null);
            }
        }
    }

    private final void c(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder stringBuilder) {
        stringBuilder.append(mL(b.ePh.b(dVar)));
    }

    private final void a(z zVar, StringBuilder stringBuilder) {
        a(zVar.bdD(), "package", stringBuilder);
        if (HW()) {
            stringBuilder.append(" in context of ");
            a((k) zVar.bar(), stringBuilder, false);
        }
    }

    private final void a(x xVar, StringBuilder stringBuilder) {
        a(xVar.bdD(), "package-fragment", stringBuilder);
        if (HW()) {
            stringBuilder.append(" in ");
            a((k) xVar.bdC(), stringBuilder, false);
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.name.b bVar, String str, StringBuilder stringBuilder) {
        stringBuilder.append(mL(str));
        kotlin.reflect.jvm.internal.impl.name.c btL = bVar.btL();
        h.d(btL, "fqName.toUnsafe()");
        String f = f(btL);
        if ((((CharSequence) f).length() > 0 ? 1 : null) != null) {
            stringBuilder.append(" ");
            stringBuilder.append(f);
        }
    }

    private final void a(ac acVar, StringBuilder stringBuilder) {
        a((s) acVar, stringBuilder);
    }

    private final void s(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        if (length == 0 || stringBuilder.charAt(length - 1) != ' ') {
            stringBuilder.append(' ');
        }
    }

    private final String c(String str, String str2, String str3, String str4, String str5) {
        if (u.a(str, str2, false, 2, null) && u.a(str3, str4, false, 2, null)) {
            int length = str2.length();
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(length);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            length = str4.length();
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str2 = str3.substring(length);
            h.d(str2, "(this as java.lang.String).substring(startIndex)");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str5);
            stringBuilder.append(str);
            str3 = stringBuilder.toString();
            if (h.E(str, str2)) {
                return str3;
            }
            if (bj(str, str2)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str3);
                stringBuilder2.append("!");
                return stringBuilder2.toString();
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:5:0x0032, code:
            if (kotlin.jvm.internal.h.E(r0.toString(), r8) == false) goto L_0x0034;
     */
    private final boolean bj(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        r1 = "?";
        r2 = "";
        r3 = 0;
        r4 = 4;
        r5 = 0;
        r0 = r8;
        r0 = kotlin.text.u.a(r0, r1, r2, r3, r4, r5);
        r0 = kotlin.jvm.internal.h.E(r7, r0);
        r1 = 0;
        if (r0 != 0) goto L_0x0050;
    L_0x0013:
        r0 = "?";
        r2 = 2;
        r3 = 0;
        r0 = kotlin.text.u.b(r8, r0, r1, r2, r3);
        if (r0 == 0) goto L_0x0034;
    L_0x001d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r2 = 63;
        r0.append(r2);
        r0 = r0.toString();
        r0 = kotlin.jvm.internal.h.E(r0, r8);
        if (r0 != 0) goto L_0x0050;
    L_0x0034:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = 40;
        r0.append(r2);
        r0.append(r7);
        r7 = ")?";
        r0.append(r7);
        r7 = r0.toString();
        r7 = kotlin.jvm.internal.h.E(r7, r8);
        if (r7 == 0) goto L_0x0051;
    L_0x0050:
        r1 = 1;
    L_0x0051:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.bj(java.lang.String, java.lang.String):boolean");
    }

    private final boolean z(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.bcU().isEmpty() ^ 1;
    }
}
