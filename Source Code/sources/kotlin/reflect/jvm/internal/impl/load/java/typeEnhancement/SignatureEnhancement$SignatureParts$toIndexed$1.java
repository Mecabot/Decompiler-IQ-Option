package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.a;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.d;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$SignatureParts$toIndexed$1 extends Lambda implements m<w, h, l> {
    final /* synthetic */ ArrayList $list;

    SignatureEnhancement$SignatureParts$toIndexed$1(ArrayList arrayList) {
        this.$list = arrayList;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        a((w) obj, (h) obj2);
        return l.etX;
    }

    public final void a(w wVar, h hVar) {
        kotlin.jvm.internal.h.e(wVar, Param.TYPE);
        kotlin.jvm.internal.h.e(hVar, "ownerContext");
        hVar = a.b(hVar, wVar.bbQ());
        ArrayList arrayList = this.$list;
        d bgo = hVar.bgo();
        arrayList.add(new n(wVar, bgo != null ? bgo.c(QualifierApplicabilityType.TYPE_USE) : null));
        for (ap apVar : wVar.bdF()) {
            w bai;
            if (apVar.bze()) {
                ArrayList arrayList2 = this.$list;
                bai = apVar.bai();
                kotlin.jvm.internal.h.d(bai, "arg.type");
                arrayList2.add(new n(bai, null));
            } else {
                SignatureEnhancement$SignatureParts$toIndexed$1 signatureEnhancement$SignatureParts$toIndexed$1 = this;
                bai = apVar.bai();
                kotlin.jvm.internal.h.d(bai, "arg.type");
                signatureEnhancement$SignatureParts$toIndexed$1.a(bai, hVar);
            }
        }
    }
}
