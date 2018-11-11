package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.b;

/* compiled from: LazyJavaPackageFragment.kt */
final class LazyJavaPackageFragment$partToFacade$2 extends Lambda implements a<HashMap<b, b>> {
    final /* synthetic */ h this$0;

    LazyJavaPackageFragment$partToFacade$2(h hVar) {
        this.this$0 = hVar;
        super(0);
    }

    /* renamed from: Xx */
    public final HashMap<b, b> invoke() {
        HashMap<b, b> hashMap = new HashMap();
        for (Entry entry : this.this$0.bgL().entrySet()) {
            String str = (String) entry.getKey();
            n nVar = (n) entry.getValue();
            b mR = b.mR(str);
            KotlinClassHeader bap = nVar.bap();
            switch (bap.biM()) {
                case MULTIFILE_CLASS_PART:
                    Map map = hashMap;
                    h.d(mR, "partName");
                    String biJ = bap.biJ();
                    if (biJ == null) {
                        break;
                    }
                    b mR2 = b.mR(biJ);
                    h.d(mR2, "JvmClassName.byInternalN…: continue@kotlinClasses)");
                    map.put(mR, mR2);
                    break;
                case FILE_FACADE:
                    Map map2 = hashMap;
                    h.d(mR, "partName");
                    map2.put(mR, mR);
                    break;
                default:
                    break;
            }
        }
        return hashMap;
    }
}
