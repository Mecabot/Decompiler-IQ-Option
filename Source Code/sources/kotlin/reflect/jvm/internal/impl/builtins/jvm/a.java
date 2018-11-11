package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.e;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: CloneableClassScope.kt */
public final class a extends e {
    private static final f ezO = f.mD("clone");
    public static final a ezP = new a();

    /* compiled from: CloneableClassScope.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final f bcd() {
            return a.ezO;
        }
    }

    public a(h hVar, d dVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(dVar, "containingClass");
        super(hVar, dVar);
    }

    protected List<r> bca() {
        ac a = ac.a((k) bxh(), g.eBF.bel(), ezO, Kind.DECLARATION, ai.eAX);
        a.a(null, bxh().bdh(), m.emptyList(), m.emptyList(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(bxh()).baU(), Modality.OPEN, au.eBe);
        return l.cr(a);
    }
}
