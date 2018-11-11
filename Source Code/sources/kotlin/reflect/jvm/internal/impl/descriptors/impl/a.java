package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.l;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.au;

/* compiled from: AbstractClassDescriptor */
public abstract class a implements d {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final f eBW;
    protected final e<ad> eBX;
    private final e<h> eBY;
    private final e<ag> eBZ;

    /* renamed from: bdi */
    public d bda() {
        return this;
    }

    public a(kotlin.reflect.jvm.internal.impl.storage.h hVar, f fVar) {
        this.eBW = fVar;
        this.eBX = hVar.i(new kotlin.jvm.a.a<ad>() {
            /* renamed from: bcI */
            public ad invoke() {
                return au.a(a.this, a.this.bbA());
            }
        });
        this.eBY = hVar.i(new kotlin.jvm.a.a<h>() {
            /* renamed from: bbn */
            public h invoke() {
                return new kotlin.reflect.jvm.internal.impl.resolve.scopes.f(a.this.bbA());
            }
        });
        this.eBZ = hVar.i(new kotlin.jvm.a.a<ag>() {
            /* renamed from: aYS */
            public ag invoke() {
                return new p(a.this);
            }
        });
    }

    public f bdc() {
        return this.eBW;
    }

    public h bdg() {
        return (h) this.eBY.invoke();
    }

    public ag bdh() {
        return (ag) this.eBZ.invoke();
    }

    public h a(as asVar) {
        if (asVar.isEmpty()) {
            return bbA();
        }
        return new l(bbA(), TypeSubstitutor.e(asVar));
    }

    /* renamed from: g */
    public d f(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return new r(this, typeSubstitutor);
    }

    public ad bdb() {
        return (ad) this.eBX.invoke();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((d) this, (Object) d);
    }
}
