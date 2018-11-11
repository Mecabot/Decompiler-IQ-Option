package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.z;
import kotlin.jvm.a.m;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.builtins.i;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: FunctionClassDescriptor.kt */
public final class FunctionClassDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a {
    private final int arity;
    private final h exB;
    private final a ezJ = new a();
    private final c ezK = new c(this.exB, this);
    private final x ezL;
    private final Kind ezM;
    private final List<an> parameters;

    /* compiled from: FunctionClassDescriptor.kt */
    public enum Kind {
        Function(r3, "Function"),
        SuspendFunction(r3, "SuspendFunction"),
        KFunction(i.bbo(), "KFunction"),
        KSuspendFunction(i.bbo(), "KSuspendFunction");
        
        public static final a Companion = null;
        private final String classNamePrefix;
        private final b packageFqName;

        /* compiled from: FunctionClassDescriptor.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final Kind a(b bVar, String str) {
                kotlin.jvm.internal.h.e(bVar, "packageFqName");
                kotlin.jvm.internal.h.e(str, "className");
                for (Kind kind : Kind.values()) {
                    Object obj = (kotlin.jvm.internal.h.E(kind.getPackageFqName(), bVar) && u.a(str, kind.getClassNamePrefix(), false, 2, null)) ? 1 : null;
                    if (obj != null) {
                        return kind;
                    }
                }
                return null;
            }
        }

        protected Kind(b bVar, String str) {
            kotlin.jvm.internal.h.e(bVar, "packageFqName");
            kotlin.jvm.internal.h.e(str, "classNamePrefix");
            this.packageFqName = bVar;
            this.classNamePrefix = str;
        }

        public final String getClassNamePrefix() {
            return this.classNamePrefix;
        }

        public final b getPackageFqName() {
            return this.packageFqName;
        }

        static {
            Companion = new a();
        }

        public final f numberedClassName(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.classNamePrefix);
            stringBuilder.append(i);
            return f.mD(stringBuilder.toString());
        }
    }

    /* compiled from: FunctionClassDescriptor.kt */
    private final class a extends kotlin.reflect.jvm.internal.impl.types.b {
        public boolean bbY() {
            return true;
        }

        public a() {
            super(FunctionClassDescriptor.this.exB);
        }

        protected Collection<w> bbU() {
            Kind kind;
            ArrayList arrayList = new ArrayList(2);
            FunctionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1 functionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1 = new FunctionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1(this, arrayList);
            x a;
            f mD;
            switch (FunctionClassDescriptor.this.bbT()) {
                case SuspendFunction:
                    a = FunctionClassDescriptor.this.ezL;
                    mD = f.mD("Function");
                    kotlin.jvm.internal.h.d(mD, "Name.identifier(\"Function\")");
                    functionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1.a(a, mD);
                    break;
                case KSuspendFunction:
                    a = FunctionClassDescriptor.this.ezL;
                    mD = f.mD("KFunction");
                    kotlin.jvm.internal.h.d(mD, "Name.identifier(\"KFunction\")");
                    functionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1.a(a, mD);
                    break;
                default:
                    a = FunctionClassDescriptor.this.ezL;
                    mD = f.mD(FunctionClassDescriptor.this.bbT().getClassNamePrefix());
                    kotlin.jvm.internal.h.d(mD, "Name.identifier(functionKind.classNamePrefix)");
                    functionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1.a(a, mD);
                    break;
            }
            switch (FunctionClassDescriptor.this.bbT()) {
                case KFunction:
                    kind = Kind.Function;
                    break;
                case KSuspendFunction:
                    kind = Kind.SuspendFunction;
                    break;
                default:
                    kind = null;
                    break;
            }
            if (kind != null) {
                u bdC = FunctionClassDescriptor.this.ezL.bdC();
                b bVar = g.exp;
                kotlin.jvm.internal.h.d(bVar, "BUILT_INS_PACKAGE_FQ_NAME");
                Iterable fragments = bdC.g(bVar).getFragments();
                Collection arrayList2 = new ArrayList();
                for (Object next : fragments) {
                    if (next instanceof c) {
                        arrayList2.add(next);
                    }
                }
                x xVar = (c) u.bU((List) arrayList2);
                f numberedClassName = kind.numberedClassName(FunctionClassDescriptor.this.aYv());
                kotlin.jvm.internal.h.d(numberedClassName, "numberedSupertypeKind.numberedClassName(arity)");
                functionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1.a(xVar, numberedClassName);
            }
            return u.W(arrayList);
        }

        public List<an> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        /* renamed from: bbV */
        public FunctionClassDescriptor bbX() {
            return FunctionClassDescriptor.this;
        }

        public String toString() {
            return bbX().toString();
        }

        protected al bbZ() {
            return kotlin.reflect.jvm.internal.impl.descriptors.al.a.eAZ;
        }
    }

    public Void bbB() {
        return null;
    }

    public Void bbH() {
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

    public boolean isExternal() {
        return false;
    }

    public /* synthetic */ d bbC() {
        return (d) bbB();
    }

    public /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.c bbI() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.c) bbH();
    }

    public final Kind bbT() {
        return this.ezM;
    }

    public final int aYv() {
        return this.arity;
    }

    public FunctionClassDescriptor(h hVar, x xVar, Kind kind, int i) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(xVar, "containingDeclaration");
        kotlin.jvm.internal.h.e(kind, "functionKind");
        super(hVar, kind.numberedClassName(i));
        this.exB = hVar;
        this.ezL = xVar;
        this.ezM = kind;
        this.arity = i;
        final ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = new m<Variance, String, l>(this) {
            final /* synthetic */ FunctionClassDescriptor this$0;

            public /* synthetic */ Object B(Object obj, Object obj2) {
                a((Variance) obj, (String) obj2);
                return l.etX;
            }

            public final void a(Variance variance, String str) {
                kotlin.jvm.internal.h.e(variance, "variance");
                kotlin.jvm.internal.h.e(str, "name");
                arrayList.add(ag.a(this.this$0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), false, variance, f.mD(str), arrayList.size()));
            }
        };
        Iterable fVar = new kotlin.f.f(1, this.arity);
        Collection arrayList2 = new ArrayList(n.e(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            int nextInt = ((z) it).nextInt();
            Variance variance = Variance.IN_VARIANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('P');
            stringBuilder.append(nextInt);
            anonymousClass1.a(variance, stringBuilder.toString());
            arrayList2.add(l.etX);
        }
        List list = (List) arrayList2;
        anonymousClass1.a(Variance.OUT_VARIANCE, "R");
        this.parameters = u.W(arrayList);
    }

    /* renamed from: bbu */
    public x bbv() {
        return this.ezL;
    }

    /* renamed from: bbw */
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c bbx() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
    }

    public kotlin.reflect.jvm.internal.impl.types.an bby() {
        return this.ezJ;
    }

    /* renamed from: bbz */
    public c bbA() {
        return this.ezK;
    }

    /* renamed from: bbD */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.c> bbE() {
        return m.emptyList();
    }

    public ClassKind bbF() {
        return ClassKind.INTERFACE;
    }

    public Modality bbG() {
        return Modality.ABSTRACT;
    }

    public av bbJ() {
        return au.eBg;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel();
    }

    public ai bbR() {
        ai aiVar = ai.eAX;
        kotlin.jvm.internal.h.d(aiVar, "SourceElement.NO_SOURCE");
        return aiVar;
    }

    public List<an> bbS() {
        return this.parameters;
    }

    public String toString() {
        return bdc().asString();
    }
}
