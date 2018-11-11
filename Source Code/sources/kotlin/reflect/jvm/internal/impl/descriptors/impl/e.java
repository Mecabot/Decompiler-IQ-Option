package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.m;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.c;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: AbstractTypeParameterDescriptor */
public abstract class e extends k implements an {
    private final kotlin.reflect.jvm.internal.impl.storage.e<ad> eBX;
    private final Variance eCf;
    private final boolean eCg;
    private final kotlin.reflect.jvm.internal.impl.storage.e<kotlin.reflect.jvm.internal.impl.types.an> eCh;
    private final int index;

    /* compiled from: AbstractTypeParameterDescriptor */
    private class a extends c {
        private final al eCn;

        public boolean bbY() {
            return true;
        }

        public a(h hVar, al alVar) {
            super(hVar);
            this.eCn = alVar;
        }

        protected Collection<w> bbU() {
            return e.this.bev();
        }

        public List<an> getParameters() {
            return Collections.emptyList();
        }

        public f bbW() {
            return e.this;
        }

        public g bdy() {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(e.this);
        }

        public String toString() {
            return e.this.bdc().toString();
        }

        protected al bbZ() {
            return this.eCn;
        }

        protected void P(w wVar) {
            e.this.P(wVar);
        }

        protected w bex() {
            return p.mU("Cyclic upper bounds");
        }
    }

    protected abstract void P(w wVar);

    public boolean bcX() {
        return false;
    }

    protected abstract List<w> bev();

    protected e(final h hVar, k kVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, final kotlin.reflect.jvm.internal.impl.name.f fVar, Variance variance, boolean z, int i, ai aiVar, final al alVar) {
        super(kVar, gVar, fVar, aiVar);
        this.eCf = variance;
        this.eCg = z;
        this.index = i;
        this.eCh = hVar.i(new kotlin.jvm.a.a<kotlin.reflect.jvm.internal.impl.types.an>() {
            /* renamed from: bew */
            public kotlin.reflect.jvm.internal.impl.types.an invoke() {
                return new a(hVar, alVar);
            }
        });
        this.eBX = hVar.i(new kotlin.jvm.a.a<ad>() {
            /* renamed from: bcI */
            public ad invoke() {
                return x.a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), e.this.bby(), Collections.emptyList(), false, new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(hVar.i(new kotlin.jvm.a.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h>() {
                    /* renamed from: bbn */
                    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Scope for type parameter ");
                        stringBuilder.append(fVar.asString());
                        return m.a(stringBuilder.toString(), e.this.aYq());
                    }
                })));
            }
        });
    }

    public Variance bdd() {
        return this.eCf;
    }

    public boolean bde() {
        return this.eCg;
    }

    public int getIndex() {
        return this.index;
    }

    public List<w> aYq() {
        return ((a) bby()).beu();
    }

    public final kotlin.reflect.jvm.internal.impl.types.an bby() {
        return (kotlin.reflect.jvm.internal.impl.types.an) this.eCh.invoke();
    }

    public ad bdb() {
        return (ad) this.eBX.invoke();
    }

    /* renamed from: bcY */
    public an beq() {
        return (an) super.bcZ();
    }

    public <R, D> R a(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d) {
        return mVar.a((an) this, (Object) d);
    }
}
