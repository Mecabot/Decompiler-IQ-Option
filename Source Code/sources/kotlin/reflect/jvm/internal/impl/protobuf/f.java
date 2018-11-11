package kotlin.reflect.jvm.internal.impl.protobuf;

import android.support.v4.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.e;

/* compiled from: ExtensionRegistryLite */
public class f {
    private static volatile boolean eNM = false;
    private static final f eNO = new f(true);
    private final Map<a, e<?, ?>> eNN;

    /* compiled from: ExtensionRegistryLite */
    private static final class a {
        private final int number;
        private final Object object;

        a(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.object == aVar.object && this.number == aVar.number) {
                z = true;
            }
            return z;
        }
    }

    public static f buD() {
        return new f();
    }

    public static f buE() {
        return eNO;
    }

    public <ContainingType extends n> e<ContainingType, ?> a(ContainingType containingType, int i) {
        return (e) this.eNN.get(new a(containingType, i));
    }

    public final void a(e<?, ?> eVar) {
        this.eNN.put(new a(eVar.buU(), eVar.getNumber()), eVar);
    }

    f() {
        this.eNN = new HashMap();
    }

    private f(boolean z) {
        this.eNN = Collections.emptyMap();
    }
}
