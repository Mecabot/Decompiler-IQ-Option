package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.l;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.e;
import kotlin.reflect.jvm.internal.impl.types.k;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: LazySubstitutingClassDescriptor */
public class r implements d {
    private an eCt;
    private List<kotlin.reflect.jvm.internal.impl.descriptors.an> eDA;
    private List<kotlin.reflect.jvm.internal.impl.descriptors.an> eDB;
    private final d eDx;
    private final TypeSubstitutor eDy;
    private TypeSubstitutor eDz;

    public r(d dVar, TypeSubstitutor typeSubstitutor) {
        this.eDx = dVar;
        this.eDy = typeSubstitutor;
    }

    private TypeSubstitutor beO() {
        if (this.eDz == null) {
            if (this.eDy.isEmpty()) {
                this.eDz = this.eDy;
            } else {
                List parameters = this.eDx.bby().getParameters();
                this.eDA = new ArrayList(parameters.size());
                this.eDz = k.a(parameters, this.eDy.bzi(), this, this.eDA);
                this.eDB = u.b(this.eDA, new b<kotlin.reflect.jvm.internal.impl.descriptors.an, Boolean>() {
                    /* renamed from: b */
                    public Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.an anVar) {
                        return Boolean.valueOf(anVar.bcX() ^ 1);
                    }
                });
            }
        }
        return this.eDz;
    }

    public an bby() {
        an bby = this.eDx.bby();
        if (this.eDy.isEmpty()) {
            return bby;
        }
        if (this.eCt == null) {
            TypeSubstitutor beO = beO();
            Collection<w> beu = bby.beu();
            Collection arrayList = new ArrayList(beu.size());
            for (w c : beu) {
                arrayList.add(beO.c(c, Variance.INVARIANT));
            }
            this.eCt = new e(this, this.eDA, arrayList, LockBasedStorageManager.eUc);
        }
        return this.eCt;
    }

    public h a(as asVar) {
        h a = this.eDx.a(asVar);
        if (this.eDy.isEmpty()) {
            return a;
        }
        return new l(a, beO());
    }

    public h bbA() {
        h bbA = this.eDx.bbA();
        if (this.eDy.isEmpty()) {
            return bbA;
        }
        return new l(bbA, beO());
    }

    public h bbx() {
        return this.eDx.bbx();
    }

    public ad bdb() {
        return x.a(bbQ(), this, au.cn(bby().getParameters()));
    }

    public ag bdh() {
        throw new UnsupportedOperationException();
    }

    public Collection<c> bbE() {
        Collection<c> bbE = this.eDx.bbE();
        Collection<c> arrayList = new ArrayList(bbE.size());
        for (c cVar : bbE) {
            arrayList.add(cVar.b(this, cVar.bbG(), cVar.bbJ(), cVar.bcW(), false).a(beO()));
        }
        return arrayList;
    }

    public g bbQ() {
        return this.eDx.bbQ();
    }

    public f bdc() {
        return this.eDx.bdc();
    }

    /* renamed from: bdi */
    public d bda() {
        return this.eDx.bdi();
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.k bbv() {
        return this.eDx.bbv();
    }

    /* renamed from: g */
    public d f(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return new r(this, TypeSubstitutor.b(typeSubstitutor.bzi(), beO().bzi()));
    }

    public d bbC() {
        return this.eDx.bbC();
    }

    public ClassKind bbF() {
        return this.eDx.bbF();
    }

    public Modality bbG() {
        return this.eDx.bbG();
    }

    public av bbJ() {
        return this.eDx.bbJ();
    }

    public boolean bbL() {
        return this.eDx.bbL();
    }

    public boolean bbM() {
        return this.eDx.bbM();
    }

    public boolean bbN() {
        return this.eDx.bbN();
    }

    public boolean isExternal() {
        return this.eDx.isExternal();
    }

    public boolean bbK() {
        return this.eDx.bbK();
    }

    public boolean bbO() {
        return this.eDx.bbO();
    }

    public boolean bbP() {
        return this.eDx.bbP();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((d) this, (Object) d);
    }

    public h bdg() {
        return this.eDx.bdg();
    }

    public c bbI() {
        return this.eDx.bbI();
    }

    public ai bbR() {
        return ai.eAX;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.an> bbS() {
        beO();
        return this.eDB;
    }
}
