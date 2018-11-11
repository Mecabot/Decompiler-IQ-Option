package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.w;
import kotlin.j;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class k {
    private final Map<String, h> eIZ = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    public final class a {
        private final String className;
        final /* synthetic */ k eJa;

        /* compiled from: predefinedEnhancementInfo.kt */
        public final class a {
            private Pair<String, o> eJb = j.D("V", null);
            private final String eJc;
            final /* synthetic */ a eJd;
            private final List<Pair<String, o>> parameters = new ArrayList();

            public a(a aVar, String str) {
                h.e(str, "functionName");
                this.eJd = aVar;
                this.eJc = str;
            }

            public final void a(String str, d... dVarArr) {
                Object obj;
                h.e(str, Param.TYPE);
                h.e(dVarArr, "qualifiers");
                Collection collection = this.parameters;
                if ((dVarArr.length == 0 ? 1 : null) != null) {
                    obj = null;
                } else {
                    Iterable<w> D = i.D(dVarArr);
                    Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(D, 10)), 16));
                    for (w wVar : D) {
                        linkedHashMap.put(Integer.valueOf(wVar.getIndex()), (d) wVar.getValue());
                    }
                    obj = new o(linkedHashMap);
                }
                collection.add(j.D(str, obj));
            }

            public final void b(String str, d... dVarArr) {
                h.e(str, Param.TYPE);
                h.e(dVarArr, "qualifiers");
                Iterable<w> D = i.D(dVarArr);
                Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(D, 10)), 16));
                for (w wVar : D) {
                    linkedHashMap.put(Integer.valueOf(wVar.getIndex()), (d) wVar.getValue());
                }
                this.eJb = j.D(str, new o(linkedHashMap));
            }

            public final void a(JvmPrimitiveType jvmPrimitiveType) {
                h.e(jvmPrimitiveType, Param.TYPE);
                this.eJb = j.D(jvmPrimitiveType.getDesc(), null);
            }

            public final Pair<String, h> bik() {
                u uVar = u.eJX;
                String className = this.eJd.getClassName();
                String str = this.eJc;
                Iterable<Pair> iterable = this.parameters;
                Collection arrayList = new ArrayList(n.e(iterable, 10));
                for (Pair first : iterable) {
                    arrayList.add((String) first.getFirst());
                }
                String be = uVar.be(className, uVar.a(str, (List) arrayList, (String) this.eJb.getFirst()));
                o oVar = (o) this.eJb.aXF();
                Iterable<Pair> iterable2 = this.parameters;
                Collection arrayList2 = new ArrayList(n.e(iterable2, 10));
                for (Pair aXF : iterable2) {
                    arrayList2.add((o) aXF.aXF());
                }
                return j.D(be, new h(oVar, (List) arrayList2));
            }
        }

        public a(k kVar, String str) {
            h.e(str, "className");
            this.eJa = kVar;
            this.className = str;
        }

        public final String getClassName() {
            return this.className;
        }

        public final void f(String str, b<? super a, l> bVar) {
            h.e(str, "name");
            h.e(bVar, "block");
            Map a = this.eJa.eIZ;
            a aVar = new a(this, str);
            bVar.invoke(aVar);
            Pair bik = aVar.bik();
            a.put(bik.getFirst(), bik.aXF());
        }
    }

    public final Map<String, h> build() {
        return this.eIZ;
    }
}
