package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.text.Regex;

/* compiled from: OperatorNameConventions.kt */
public final class j {
    public static final f eWA = f.mD("set");
    public static final f eWB = f.mD("next");
    public static final f eWC = f.mD("hasNext");
    public static final Regex eWD = new Regex("component\\d+");
    public static final f eWE = f.mD("and");
    public static final f eWF = f.mD("or");
    public static final f eWG = f.mD("inc");
    public static final f eWH = f.mD("dec");
    public static final f eWI = f.mD("plus");
    public static final f eWJ = f.mD("minus");
    public static final f eWK = f.mD("not");
    public static final f eWL = f.mD("unaryMinus");
    public static final f eWM = f.mD("unaryPlus");
    public static final f eWN = f.mD("times");
    public static final f eWO = f.mD("div");
    public static final f eWP = f.mD("mod");
    public static final f eWQ = f.mD("rem");
    public static final f eWR = f.mD("rangeTo");
    public static final f eWS = f.mD("timesAssign");
    public static final f eWT = f.mD("divAssign");
    public static final f eWU = f.mD("modAssign");
    public static final f eWV = f.mD("remAssign");
    public static final f eWW = f.mD("plusAssign");
    public static final f eWX = f.mD("minusAssign");
    public static final Set<f> eWY = aj.I(eWG, eWH, eWM, eWL, eWK);
    public static final Set<f> eWZ = aj.I(eWM, eWL, eWK);
    public static final f eWr = f.mD("getValue");
    public static final f eWs = f.mD("setValue");
    public static final f eWt = f.mD("provideDelegate");
    public static final f eWu = f.mD("equals");
    public static final f eWv = f.mD("compareTo");
    public static final f eWw = f.mD("contains");
    public static final f eWx = f.mD("invoke");
    public static final f eWy = f.mD("iterator");
    public static final f eWz = f.mD("get");
    public static final Set<f> eXa = aj.I(eWN, eWI, eWJ, eWO, eWP, eWQ, eWR);
    public static final Set<f> eXb = aj.I(eWS, eWT, eWU, eWV, eWW, eWX);
    public static final j eXc = new j();

    private j() {
    }
}
