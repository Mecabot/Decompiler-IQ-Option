package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$cloneableType$2 extends Lambda implements a<ad> {
    final /* synthetic */ h $storageManager;
    final /* synthetic */ JvmBuiltInsSettings this$0;

    JvmBuiltInsSettings$cloneableType$2(JvmBuiltInsSettings jvmBuiltInsSettings, h hVar) {
        this.this$0 = jvmBuiltInsSettings;
        this.$storageManager = hVar;
        super(0);
    }

    /* renamed from: bcI */
    public final ad invoke() {
        u c = this.this$0.bcw();
        kotlin.reflect.jvm.internal.impl.name.a bcq = d.eAm.bcq();
        kotlin.jvm.internal.h.d(bcq, "JvmBuiltInClassDescripto…actory.CLONEABLE_CLASS_ID");
        return q.a(c, bcq, new w(this.$storageManager, this.this$0.bcw())).bdb();
    }
}
