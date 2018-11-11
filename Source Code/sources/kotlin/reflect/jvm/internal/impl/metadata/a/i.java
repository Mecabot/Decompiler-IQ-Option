package kotlin.reflect.jvm.internal.impl.metadata.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: VersionRequirement.kt */
public final class i {
    public static final a eMa = new a();
    private final b eLW;
    private final VersionKind eLX;
    private final DeprecationLevel eLY;
    private final Integer eLZ;
    private final String message;

    /* compiled from: VersionRequirement.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final List<i> a(n nVar, c cVar, k kVar) {
            Object bkG;
            h.e(nVar, "proto");
            h.e(cVar, "nameResolver");
            h.e(kVar, "table");
            if (nVar instanceof Class) {
                bkG = ((Class) nVar).bkG();
            } else if (nVar instanceof Constructor) {
                bkG = ((Constructor) nVar).bkG();
            } else if (nVar instanceof Function) {
                bkG = ((Function) nVar).bkG();
            } else if (nVar instanceof Property) {
                bkG = ((Property) nVar).bkG();
            } else if (nVar instanceof TypeAlias) {
                bkG = ((TypeAlias) nVar).bkG();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected declaration: ");
                stringBuilder.append(nVar.getClass());
                throw new IllegalStateException(stringBuilder.toString());
            }
            h.d(bkG, "ids");
            Collection arrayList = new ArrayList();
            for (Integer num : (Iterable) bkG) {
                a aVar = i.eMa;
                h.d(num, "id");
                i a = aVar.a(num.intValue(), cVar, kVar);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return (List) arrayList;
        }

        public final i a(int i, c cVar, k kVar) {
            h.e(cVar, "nameResolver");
            h.e(kVar, "table");
            VersionRequirement li = kVar.li(i);
            i iVar = null;
            if (li == null) {
                return null;
            }
            DeprecationLevel deprecationLevel;
            b a = b.eMc.a(li.bqz() ? Integer.valueOf(li.getVersion()) : null, li.bqA() ? Integer.valueOf(li.bqB()) : null);
            Level bqD = li.bqD();
            if (bqD == null) {
                h.aXZ();
            }
            switch (bqD) {
                case WARNING:
                    deprecationLevel = DeprecationLevel.WARNING;
                    break;
                case ERROR:
                    deprecationLevel = DeprecationLevel.ERROR;
                    break;
                case HIDDEN:
                    deprecationLevel = DeprecationLevel.HIDDEN;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer valueOf = li.bqE() ? Integer.valueOf(li.getErrorCode()) : null;
            if (li.bqF()) {
                iVar = cVar.getString(li.bqG());
            }
            i iVar2 = iVar;
            VersionKind bqI = li.bqI();
            h.d(bqI, "info.versionKind");
            return new i(a, bqI, deprecationLevel2, valueOf, iVar2);
        }
    }

    /* compiled from: VersionRequirement.kt */
    public static final class b {
        public static final b eMb = new b(256, 256, 256);
        public static final a eMc = new a();
        private final int eLc;
        private final int major;
        private final int minor;

        /* compiled from: VersionRequirement.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final b a(Integer num, Integer num2) {
                if (num2 != null) {
                    return new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return b.eMb;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if ((this.major == bVar.major ? 1 : null) != null) {
                    if ((this.minor == bVar.minor ? 1 : null) != null) {
                        if ((this.eLc == bVar.eLc ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.eLc;
        }

        public b(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.eLc = i3;
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, f fVar) {
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            this(i, i2, i3);
        }

        public final String asString() {
            StringBuilder stringBuilder;
            int i;
            if (this.eLc == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.major);
                stringBuilder.append('.');
                i = this.minor;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.major);
                stringBuilder.append('.');
                stringBuilder.append(this.minor);
                stringBuilder.append('.');
                i = this.eLc;
            }
            stringBuilder.append(i);
            return stringBuilder.toString();
        }

        public String toString() {
            return asString();
        }
    }

    public i(b bVar, VersionKind versionKind, DeprecationLevel deprecationLevel, Integer num, String str) {
        h.e(bVar, "version");
        h.e(versionKind, "kind");
        h.e(deprecationLevel, com.google.firebase.analytics.FirebaseAnalytics.b.LEVEL);
        this.eLW = bVar;
        this.eLX = versionKind;
        this.eLY = deprecationLevel;
        this.eLZ = num;
        this.message = str;
    }

    public final b brf() {
        return this.eLW;
    }

    public final VersionKind brg() {
        return this.eLX;
    }

    public String toString() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("since ");
        stringBuilder3.append(this.eLW);
        stringBuilder3.append(' ');
        stringBuilder3.append(this.eLY);
        if (this.eLZ != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" error ");
            stringBuilder.append(this.eLZ);
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.message != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(": ");
            stringBuilder.append(this.message);
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        return stringBuilder3.toString();
    }
}
