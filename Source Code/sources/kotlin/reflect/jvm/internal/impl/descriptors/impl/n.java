package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.i;
import kotlin.reflect.jvm.internal.impl.storage.b;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: EnumEntrySyntheticClassDescriptor */
public class n extends g {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final g eBt;
    private final an eCt;
    private final h eCx;
    private final e<Set<f>> eCy;

    /* compiled from: EnumEntrySyntheticClassDescriptor */
    private class a extends i {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final b<f, Collection<ad>> eCA;
        private final e<Collection<k>> eCB;
        private final b<f, Collection<ah>> eCz;

        static {
            Class cls = n.class;
        }

        public a(kotlin.reflect.jvm.internal.impl.storage.h hVar) {
            this.eCz = hVar.o(new kotlin.jvm.a.b<f, Collection<ah>>(n.this) {
                /* renamed from: h */
                public Collection<ah> invoke(f fVar) {
                    return a.this.g(fVar);
                }
            });
            this.eCA = hVar.o(new kotlin.jvm.a.b<f, Collection<ad>>(n.this) {
                /* renamed from: h */
                public Collection<ad> invoke(f fVar) {
                    return a.this.f(fVar);
                }
            });
            this.eCB = hVar.i(new kotlin.jvm.a.a<Collection<k>>(n.this) {
                /* renamed from: aZh */
                public Collection<k> invoke() {
                    return a.this.beB();
                }
            });
        }

        public Collection a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            return (Collection) this.eCA.invoke(fVar);
        }

        private Collection<ad> f(f fVar) {
            return a(fVar, beA().a(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        public Collection b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            return (Collection) this.eCz.invoke(fVar);
        }

        private Collection<ah> g(f fVar) {
            return a(fVar, beA().b(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        private h beA() {
            return ((w) n.this.bby().beu().iterator().next()).bbk();
        }

        private <D extends CallableMemberDescriptor> Collection<D> a(f fVar, Collection<D> collection) {
            final Collection linkedHashSet = new LinkedHashSet();
            OverridingUtil.a(fVar, collection, Collections.emptySet(), n.this, new kotlin.reflect.jvm.internal.impl.resolve.g() {
                protected void a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                }

                public void h(CallableMemberDescriptor callableMemberDescriptor) {
                    OverridingUtil.a(callableMemberDescriptor, null);
                    linkedHashSet.add(callableMemberDescriptor);
                }
            });
            return linkedHashSet;
        }

        public Collection<k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
            return (Collection) this.eCB.invoke();
        }

        private Collection<k> beB() {
            Collection<k> hashSet = new HashSet();
            for (f fVar : (Set) n.this.eCy.invoke()) {
                hashSet.addAll(b(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                hashSet.addAll(a(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
            }
            return hashSet;
        }

        public Set<f> beC() {
            return (Set) n.this.eCy.invoke();
        }

        public Set<f> beD() {
            return (Set) n.this.eCy.invoke();
        }
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d bbC() {
        return null;
    }

    public c bbI() {
        return null;
    }

    public boolean bbK() {
        return false;
    }

    public boolean bbL() {
        return false;
    }

    public boolean bbM() {
        return false;
    }

    public boolean bbN() {
        return false;
    }

    public boolean bbO() {
        return false;
    }

    public boolean bbP() {
        return false;
    }

    public static n a(kotlin.reflect.jvm.internal.impl.storage.h hVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, f fVar, e<Set<f>> eVar, g gVar, ai aiVar) {
        return new n(hVar, dVar, dVar.bdb(), fVar, eVar, gVar, aiVar);
    }

    private n(kotlin.reflect.jvm.internal.impl.storage.h hVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, w wVar, f fVar, e<Set<f>> eVar, g gVar, ai aiVar) {
        super(hVar, dVar, fVar, aiVar, false);
        this.eBt = gVar;
        this.eCt = new kotlin.reflect.jvm.internal.impl.types.e(this, Collections.emptyList(), Collections.singleton(wVar), hVar);
        this.eCx = new a(hVar);
        this.eCy = eVar;
    }

    public h bbA() {
        return this.eCx;
    }

    public h bbx() {
        return h.c.eSm;
    }

    public Collection<c> bbE() {
        return Collections.emptyList();
    }

    public an bby() {
        return this.eCt;
    }

    public ClassKind bbF() {
        return ClassKind.ENUM_ENTRY;
    }

    public Modality bbG() {
        return Modality.FINAL;
    }

    public av bbJ() {
        return au.eBg;
    }

    public g bbQ() {
        return this.eBt;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("enum entry ");
        stringBuilder.append(bdc());
        return stringBuilder.toString();
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.an> bbS() {
        return Collections.emptyList();
    }
}
