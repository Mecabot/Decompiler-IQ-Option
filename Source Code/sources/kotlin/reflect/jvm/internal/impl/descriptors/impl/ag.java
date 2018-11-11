package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: TypeParameterDescriptorImpl */
public class ag extends e {
    private final b<w, Void> eEh;
    private final List<w> eEi = new ArrayList(1);
    private boolean initialized = false;

    public static an a(k kVar, g gVar, boolean z, Variance variance, f fVar, int i) {
        an a = a(kVar, gVar, z, variance, fVar, i, ai.eAX);
        a.U(a.Q(kVar).baW());
        a.setInitialized();
        return a;
    }

    public static ag a(k kVar, g gVar, boolean z, Variance variance, f fVar, int i, ai aiVar) {
        return a(kVar, gVar, z, variance, fVar, i, aiVar, null, al.a.eAZ);
    }

    public static ag a(k kVar, g gVar, boolean z, Variance variance, f fVar, int i, ai aiVar, b<w, Void> bVar, al alVar) {
        return new ag(kVar, gVar, z, variance, fVar, i, aiVar, bVar, alVar);
    }

    private ag(k kVar, g gVar, boolean z, Variance variance, f fVar, int i, ai aiVar, b<w, Void> bVar, al alVar) {
        super(LockBasedStorageManager.eUc, kVar, gVar, fVar, variance, z, i, aiVar, alVar);
        this.eEh = bVar;
    }

    private void gm() {
        if (!this.initialized) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Type parameter descriptor is not initialized: ");
            stringBuilder.append(bfp());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void bfo() {
        if (this.initialized) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Type parameter descriptor is already initialized: ");
            stringBuilder.append(bfp());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private String bfp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bdc());
        stringBuilder.append(" declared in ");
        stringBuilder.append(c.w(bbv()));
        return stringBuilder.toString();
    }

    public void setInitialized() {
        bfo();
        this.initialized = true;
    }

    public void U(w wVar) {
        bfo();
        V(wVar);
    }

    private void V(w wVar) {
        if (!y.aF(wVar)) {
            this.eEi.add(wVar);
        }
    }

    protected void P(w wVar) {
        if (this.eEh != null) {
            this.eEh.invoke(wVar);
        }
    }

    protected List<w> bev() {
        gm();
        return this.eEi;
    }
}
