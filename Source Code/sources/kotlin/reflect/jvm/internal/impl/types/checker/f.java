package kotlin.reflect.jvm.internal.impl.types.checker;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ao;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;
import kotlin.reflect.jvm.internal.impl.utils.d;

/* compiled from: NewCapturedType.kt */
public final class f {
    public static /* synthetic */ ad a(ad adVar, CaptureStatus captureStatus, m mVar, int i, Object obj) {
        if ((i & 4) != 0) {
            mVar = d.bzz();
        }
        return a(adVar, captureStatus, mVar);
    }

    public static final ad a(ad adVar, CaptureStatus captureStatus, m<? super Integer, ? super d, l> mVar) {
        h.e(adVar, Param.TYPE);
        h.e(captureStatus, NotificationCompat.CATEGORY_STATUS);
        h.e(mVar, "acceptNewCapturedType");
        if (adVar.bdF().size() != adVar.bwA().getParameters().size()) {
            return null;
        }
        ap apVar;
        Object obj;
        List bdF = adVar.bdF();
        Iterable<ap> iterable = bdF;
        Object obj2 = 1;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (ap apVar2 : iterable) {
                if (apVar2.bzf() == Variance.INVARIANT) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    obj2 = null;
                    break;
                }
            }
        }
        if (obj2 != null) {
            return null;
        }
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Object obj3 : iterable) {
            if (obj3.bzf() != Variance.INVARIANT) {
                ay bzc = (obj3.bze() || obj3.bzf() != Variance.IN_VARIANCE) ? null : obj3.bai().bzc();
                obj3 = a.bk(new d(captureStatus, bzc, obj3));
            }
            arrayList.add(obj3);
        }
        List list = (List) arrayList;
        TypeSubstitutor bzh = ao.eVe.b(adVar.bwA(), list).bzh();
        int size = bdF.size();
        for (int i = 0; i < size; i++) {
            ap apVar3 = (ap) bdF.get(i);
            apVar2 = (ap) list.get(i);
            if (apVar3.bzf() != Variance.INVARIANT) {
                Object obj4 = adVar.bwA().getParameters().get(i);
                h.d(obj4, "type.constructor.parameters[index]");
                List aYq = ((an) obj4).aYq();
                h.d(aYq, "type.constructor.parameters[index].upperBounds");
                Iterable<w> iterable2 = aYq;
                Collection arrayList2 = new ArrayList(n.e(iterable2, 10));
                for (w b : iterable2) {
                    arrayList2.add(g.eVz.e(bzh.b(b, Variance.INVARIANT).bzc()));
                }
                List list2 = (List) arrayList2;
                if (!apVar3.bze() && apVar3.bzf() == Variance.OUT_VARIANCE) {
                    list2 = u.i((Collection) list2, (Object) g.eVz.e(apVar3.bai().bzc()));
                }
                w bai = apVar2.bai();
                if (bai == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                }
                d dVar = (d) bai;
                dVar.bwA().cp(list2);
                mVar.B(Integer.valueOf(i), dVar);
            }
        }
        return x.c(adVar.bbQ(), adVar.bwA(), list, adVar.aYp());
    }
}
