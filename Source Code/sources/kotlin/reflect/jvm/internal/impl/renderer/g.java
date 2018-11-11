package kotlin.reflect.jvm.internal.impl.renderer;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin.e.d;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.renderer.a.c;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DescriptorRendererOptionsImpl.kt */
public final class g implements f {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "withDefinedIn", "getWithDefinedIn()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "modifiers", "getModifiers()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "startFromName", "getStartFromName()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "debugMode", "getDebugMode()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "verbose", "getVerbose()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "unitReturnType", "getUnitReturnType()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "withoutReturnType", "getWithoutReturnType()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "enhancedTypes", "getEnhancedTypes()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "receiverAfterName", "getReceiverAfterName()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderAccessors", "getRenderAccessors()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z"))};
    private final d ePA = da(Boolean.valueOf(true));
    private final d ePB = da(DescriptorRendererModifier.DEFAULTS);
    private final d ePC = da(Boolean.valueOf(false));
    private final d ePD = da(Boolean.valueOf(false));
    private final d ePE = da(Boolean.valueOf(false));
    private final d ePF = da(Boolean.valueOf(false));
    private final d ePG = da(Boolean.valueOf(false));
    private final d ePH = da(Boolean.valueOf(true));
    private final d ePI = da(Boolean.valueOf(false));
    private final d ePJ = da(Boolean.valueOf(false));
    private final d ePK = da(Boolean.valueOf(false));
    private final d ePL = da(Boolean.valueOf(true));
    private final d ePM = da(Boolean.valueOf(false));
    private final d ePN = da(Boolean.valueOf(false));
    private final d ePO = da(Boolean.valueOf(false));
    private final d ePP = da(Boolean.valueOf(false));
    private final d ePQ = da(DescriptorRendererOptionsImpl$typeNormalizer$2.eQr);
    private final d ePR = da(DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2.eQo);
    private final d ePS = da(Boolean.valueOf(true));
    private final d ePT = da(OverrideRenderingPolicy.RENDER_OPEN);
    private final d ePU = da(kotlin.reflect.jvm.internal.impl.renderer.b.b.a.ePr);
    private final d ePV = da(RenderingFormat.PLAIN);
    private final d ePW = da(ParameterNameRenderingPolicy.ALL);
    private final d ePX = da(Boolean.valueOf(false));
    private final d ePY = da(Boolean.valueOf(false));
    private final d ePZ = da(Boolean.valueOf(false));
    private boolean ePx;
    private final d ePy = da(c.eOX);
    private final d ePz = da(Boolean.valueOf(true));
    private final d eQa = da(Boolean.valueOf(false));
    private final d eQb = da(Boolean.valueOf(false));
    private final d eQc = da(aj.emptySet());
    private final d eQd = da(h.eQt.bwu());
    private final d eQe = da(null);
    private final d eQf = da(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
    private final d eQg = da(Boolean.valueOf(false));
    private final d eQh = da(Boolean.valueOf(true));
    private final d eQi = da(Boolean.valueOf(true));
    private final d eQj = da(Boolean.valueOf(true));
    private final d eQk = da(Boolean.valueOf(true));
    private final d eQl = da(Boolean.valueOf(false));
    private final d eQm = da(Boolean.valueOf(false));
    private final d eQn = da(Boolean.valueOf(false));

    /* compiled from: Delegates.kt */
    public static final class a extends kotlin.e.c<T> {
        final /* synthetic */ Object eQp;
        final /* synthetic */ g eQq;

        public a(Object obj, Object obj2, g gVar) {
            this.eQp = obj;
            this.eQq = gVar;
            super(obj2);
        }

        protected boolean a(j<?> jVar, T t, T t2) {
            h.e(jVar, "property");
            if (!this.eQq.isLocked()) {
                return true;
            }
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
    }

    public boolean HW() {
        return ((Boolean) this.ePE.b(this, apP[6])).booleanValue();
    }

    public void a(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        h.e(annotationArgumentsRenderingPolicy, "<set-?>");
        this.eQf.a(this, apP[33], annotationArgumentsRenderingPolicy);
    }

    public void a(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        h.e(parameterNameRenderingPolicy, "<set-?>");
        this.ePW.a(this, apP[24], parameterNameRenderingPolicy);
    }

    public void a(RenderingFormat renderingFormat) {
        h.e(renderingFormat, "<set-?>");
        this.ePV.a(this, apP[23], renderingFormat);
    }

    public void a(a aVar) {
        h.e(aVar, "<set-?>");
        this.ePy.a(this, apP[0], aVar);
    }

    public boolean bvE() {
        return ((Boolean) this.eQg.b(this, apP[34])).booleanValue();
    }

    public AnnotationArgumentsRenderingPolicy bvF() {
        return (AnnotationArgumentsRenderingPolicy) this.eQf.b(this, apP[33]);
    }

    public b<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> bvG() {
        return (b) this.eQe.b(this, apP[32]);
    }

    public boolean bvH() {
        return ((Boolean) this.eQn.b(this, apP[41])).booleanValue();
    }

    public boolean bvI() {
        return ((Boolean) this.ePF.b(this, apP[7])).booleanValue();
    }

    public a bvJ() {
        return (a) this.ePy.b(this, apP[0]);
    }

    public b<aq, String> bvK() {
        return (b) this.ePR.b(this, apP[19]);
    }

    public boolean bvL() {
        return ((Boolean) this.eQb.b(this, apP[29])).booleanValue();
    }

    public boolean bvM() {
        return ((Boolean) this.ePJ.b(this, apP[11])).booleanValue();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.b> bvN() {
        return (Set) this.eQc.b(this, apP[30]);
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.b> bvO() {
        return (Set) this.eQd.b(this, apP[31]);
    }

    public boolean bvP() {
        return ((Boolean) this.eQj.b(this, apP[37])).booleanValue();
    }

    public boolean bvQ() {
        return ((Boolean) this.ePN.b(this, apP[15])).booleanValue();
    }

    public boolean bvR() {
        return ((Boolean) this.ePK.b(this, apP[12])).booleanValue();
    }

    public OverrideRenderingPolicy bvS() {
        return (OverrideRenderingPolicy) this.ePT.b(this, apP[21]);
    }

    public ParameterNameRenderingPolicy bvT() {
        return (ParameterNameRenderingPolicy) this.ePW.b(this, apP[24]);
    }

    public boolean bvU() {
        return ((Boolean) this.eQk.b(this, apP[38])).booleanValue();
    }

    public boolean bvV() {
        return ((Boolean) this.eQm.b(this, apP[40])).booleanValue();
    }

    public boolean bvW() {
        return ((Boolean) this.ePX.b(this, apP[25])).booleanValue();
    }

    public boolean bvX() {
        return ((Boolean) this.ePZ.b(this, apP[27])).booleanValue();
    }

    public boolean bvY() {
        return ((Boolean) this.ePY.b(this, apP[26])).booleanValue();
    }

    public boolean bvZ() {
        return ((Boolean) this.eQh.b(this, apP[35])).booleanValue();
    }

    public boolean bwa() {
        return ((Boolean) this.eQa.b(this, apP[28])).booleanValue();
    }

    public boolean bwb() {
        return ((Boolean) this.ePL.b(this, apP[13])).booleanValue();
    }

    public boolean bwc() {
        return ((Boolean) this.eQi.b(this, apP[36])).booleanValue();
    }

    public boolean bwd() {
        return ((Boolean) this.ePS.b(this, apP[20])).booleanValue();
    }

    public boolean bwe() {
        return ((Boolean) this.ePD.b(this, apP[5])).booleanValue();
    }

    public boolean bwf() {
        return ((Boolean) this.ePC.b(this, apP[4])).booleanValue();
    }

    public RenderingFormat bwg() {
        return (RenderingFormat) this.ePV.b(this, apP[23]);
    }

    public b<w, w> bwh() {
        return (b) this.ePQ.b(this, apP[18]);
    }

    public boolean bwi() {
        return ((Boolean) this.ePM.b(this, apP[14])).booleanValue();
    }

    public boolean bwj() {
        return ((Boolean) this.ePH.b(this, apP[9])).booleanValue();
    }

    public b.b bwk() {
        return (b.b) this.ePU.b(this, apP[22]);
    }

    public boolean bwl() {
        return ((Boolean) this.ePG.b(this, apP[8])).booleanValue();
    }

    public boolean bwm() {
        return ((Boolean) this.ePz.b(this, apP[1])).booleanValue();
    }

    public boolean bwn() {
        return ((Boolean) this.ePA.b(this, apP[2])).booleanValue();
    }

    public boolean bwo() {
        return ((Boolean) this.ePI.b(this, apP[10])).booleanValue();
    }

    public boolean bwp() {
        return ((Boolean) this.ePP.b(this, apP[17])).booleanValue();
    }

    public boolean bwq() {
        return ((Boolean) this.ePO.b(this, apP[16])).booleanValue();
    }

    public void bx(boolean z) {
        this.ePE.a(this, apP[6], Boolean.valueOf(z));
    }

    public void gV(boolean z) {
        this.ePX.a(this, apP[25], Boolean.valueOf(z));
    }

    public void gW(boolean z) {
        this.ePY.a(this, apP[26], Boolean.valueOf(z));
    }

    public void gX(boolean z) {
        this.ePC.a(this, apP[4], Boolean.valueOf(z));
    }

    public void gY(boolean z) {
        this.ePz.a(this, apP[1], Boolean.valueOf(z));
    }

    public void gZ(boolean z) {
        this.ePP.a(this, apP[17], Boolean.valueOf(z));
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return (Set) this.ePB.b(this, apP[3]);
    }

    public void ha(boolean z) {
        this.ePO.a(this, apP[16], Boolean.valueOf(z));
    }

    public void k(Set<kotlin.reflect.jvm.internal.impl.name.b> set) {
        h.e(set, "<set-?>");
        this.eQd.a(this, apP[31], set);
    }

    public void l(Set<? extends DescriptorRendererModifier> set) {
        h.e(set, "<set-?>");
        this.ePB.a(this, apP[3], set);
    }

    public void setVerbose(boolean z) {
        this.ePG.a(this, apP[8], Boolean.valueOf(z));
    }

    public boolean getIncludeAnnotationArguments() {
        return kotlin.reflect.jvm.internal.impl.renderer.f.a.b(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return kotlin.reflect.jvm.internal.impl.renderer.f.a.c(this);
    }

    public final boolean isLocked() {
        return this.ePx;
    }

    public final void lock() {
        int i = this.ePx ^ 1;
        if (m.etY && i == 0) {
            throw new AssertionError("Assertion failed");
        }
        this.ePx = true;
    }

    public final g bwt() {
        g gVar = new g();
        for (Field field : getClass().getDeclaredFields()) {
            h.d(field, "field");
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                if (!(obj instanceof kotlin.e.c)) {
                    obj = null;
                }
                kotlin.e.c cVar = (kotlin.e.c) obj;
                if (cVar != null) {
                    String name = field.getName();
                    h.d(name, "field.name");
                    int a = 1 ^ u.a(name, "is", false, 2, null);
                    if (m.etY && a == 0) {
                        throw new AssertionError("Fields named is* are not supported here yet");
                    }
                    kotlin.reflect.d F = kotlin.jvm.internal.j.F(g.class);
                    String name2 = field.getName();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("get");
                    String name3 = field.getName();
                    h.d(name3, "field.name");
                    stringBuilder.append(u.capitalize(name3));
                    field.set(gVar, gVar.da(cVar.b(this, new PropertyReference1Impl(F, name2, stringBuilder.toString()))));
                } else {
                    continue;
                }
            }
        }
        return gVar;
    }

    private final <T> d<g, T> da(T t) {
        kotlin.e.a aVar = kotlin.e.a.euA;
        return new a(t, t, this);
    }
}
