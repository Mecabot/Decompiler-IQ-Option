package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$_parameters$1 extends Lambda implements kotlin.jvm.a.a<ArrayList<KParameter>> {
    final /* synthetic */ g this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(((KParameter) t).getName(), ((KParameter) t2).getName());
        }
    }

    KCallableImpl$_parameters$1(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    /* renamed from: acC */
    public final ArrayList<KParameter> invoke() {
        int i;
        final CallableMemberDescriptor aYM = this.this$0.aYM();
        ArrayList<KParameter> arrayList = new ArrayList();
        int i2 = 0;
        if (aYM.bcP() == null || this.this$0.isBound()) {
            i = 0;
        } else {
            arrayList.add(new o(this.this$0, 0, Kind.INSTANCE, new kotlin.jvm.a.a<ag>() {
                /* renamed from: aYS */
                public final ag invoke() {
                    ag bcP = aYM.bcP();
                    if (bcP == null) {
                        h.aXZ();
                    }
                    return bcP;
                }
            }));
            i = 1;
        }
        if (!(aYM.bcO() == null || this.this$0.isBound())) {
            int i3 = i + 1;
            arrayList.add(new o(this.this$0, i, Kind.EXTENSION_RECEIVER, new kotlin.jvm.a.a<ag>() {
                /* renamed from: aYS */
                public final ag invoke() {
                    ag bcO = aYM.bcO();
                    if (bcO == null) {
                        h.aXZ();
                    }
                    return bcO;
                }
            }));
            i = i3;
        }
        List bcS = aYM.bcS();
        h.d(bcS, "descriptor.valueParameters");
        int size = bcS.size();
        while (i2 < size) {
            int i4 = i + 1;
            arrayList.add(new o(this.this$0, i, Kind.VALUE, new kotlin.jvm.a.a<aq>() {
                /* renamed from: aYT */
                public final aq invoke() {
                    Object obj = aYM.bcS().get(i2);
                    h.d(obj, "descriptor.valueParameters[i]");
                    return (aq) obj;
                }
            }));
            i2++;
            i = i4;
        }
        if (this.this$0.aYQ() && (aYM instanceof b)) {
            List list = arrayList;
            if (list.size() > 1) {
                q.a(list, new a());
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
