package kotlin.reflect.jvm.internal.impl.name;

/* compiled from: SpecialNames */
public class h {
    public static final f eNo = f.mF("<no name provided>");
    public static final f eNp = f.mF("<root package>");
    public static final f eNq = f.mD("Companion");
    public static final f eNr = f.mD("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
    public static final f eNs = f.mF("<anonymous>");

    public static f I(f fVar) {
        return (fVar == null || fVar.btR()) ? eNr : fVar;
    }

    public static boolean J(f fVar) {
        return (fVar.asString().isEmpty() || fVar.btR()) ? false : true;
    }
}
