package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.a.d;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmModuleProtoBuf.Module;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmModuleProtoBuf.PackageParts;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* compiled from: ModuleMapping.kt */
public final class k {
    public static final k eMU = new k(ad.emptyMap(), new a(m.emptyList()), "EMPTY");
    public static final k eMV = new k(ad.emptyMap(), new a(m.emptyList()), "CORRUPTED");
    public static final a eMW = new a();
    private final String debugName;
    private final Map<String, m> eMS;
    private final a eMT;

    /* compiled from: ModuleMapping.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final k a(byte[] bArr, String str, boolean z, boolean z2, b<? super g, l> bVar) {
            byte[] bArr2 = bArr;
            String str2 = str;
            b<? super g, l> bVar2 = bVar;
            h.e(str2, "debugName");
            h.e(bVar2, "reportIncompatibleVersionError");
            if (bArr2 == null) {
                return k.eMU;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2));
            try {
                int[] iArr = new int[dataInputStream.readInt()];
                int length = iArr.length;
                for (int i = 0; i < length; i++) {
                    iArr[i] = dataInputStream.readInt();
                }
                g gVar = new g(Arrays.copyOf(iArr, iArr.length));
                if (z || gVar.btC()) {
                    Module j = Module.j(dataInputStream);
                    if (j == null) {
                        return k.eMU;
                    }
                    String brI;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (PackageParts packageParts : j.brl()) {
                        List brL;
                        Integer num;
                        q brM;
                        String str3;
                        h.d(packageParts, "proto");
                        brI = packageParts.brI();
                        Map map = linkedHashMap;
                        h.d(brI, "packageFqName");
                        Object obj = map.get(brI);
                        if (obj == null) {
                            obj = new m(brI);
                            map.put(brI, obj);
                        }
                        m mVar = (m) obj;
                        q<String> brK = packageParts.brK();
                        h.d(brK, "proto.shortClassNameList");
                        int i2 = 0;
                        for (String str4 : brK) {
                            brL = packageParts.brL();
                            h.d(brL, "proto.multifileFacadeShortNameIdList");
                            num = (Integer) u.h(brL, i2);
                            num = num != null ? Integer.valueOf(num.intValue() - 1) : null;
                            if (num != null) {
                                brM = packageParts.brM();
                                h.d(brM, "proto.multifileFacadeShortNameList");
                                str3 = (String) u.h(brM, num.intValue());
                            } else {
                                str3 = null;
                            }
                            str3 = str3 != null ? l.bf(brI, str3) : null;
                            h.d(str4, "partShortName");
                            mVar.bh(l.bf(brI, str4), str3);
                            i2++;
                        }
                        if (z2) {
                            q<String> brN = packageParts.brN();
                            h.d(brN, "proto.classWithJvmPackageNameShortNameList");
                            int i3 = 0;
                            for (String str42 : brN) {
                                brL = packageParts.brO();
                                h.d(brL, "proto.classWithJvmPackageNamePackageIdList");
                                num = (Integer) u.h(brL, i3);
                                if (num == null) {
                                    brL = packageParts.brO();
                                    h.d(brL, "proto.classWithJvmPackageNamePackageIdList");
                                    num = (Integer) u.bX(brL);
                                }
                                if (num != null) {
                                    int intValue = num.intValue();
                                    brM = j.brp();
                                    h.d(brM, "moduleProto.jvmPackageNameList");
                                    str3 = (String) u.h(brM, intValue);
                                    if (str3 != null) {
                                        h.d(str42, "partShortName");
                                        mVar.bh(l.bf(str3, str42), null);
                                    }
                                }
                                i3++;
                            }
                        }
                    }
                    for (PackageParts packageParts2 : j.brn()) {
                        Map map2 = linkedHashMap;
                        h.d(packageParts2, "proto");
                        brI = packageParts2.brI();
                        h.d(brI, "proto.packageFqName");
                        Object obj2 = map2.get(brI);
                        if (obj2 == null) {
                            String brI2 = packageParts2.brI();
                            h.d(brI2, "proto.packageFqName");
                            obj2 = new m(brI2);
                            map2.put(brI, obj2);
                        }
                        m mVar2 = (m) obj2;
                        q<String> brK2 = packageParts2.brK();
                        h.d(brK2, "proto.shortClassNameList");
                        for (String mz : brK2) {
                            mVar2.mz(mz);
                        }
                    }
                    StringTable brr = j.brr();
                    h.d(brr, "moduleProto.stringTable");
                    QualifiedNameTable brt = j.brt();
                    h.d(brt, "moduleProto.qualifiedNameTable");
                    d dVar = new d(brr, brt);
                    List bpq = j.bpq();
                    h.d(bpq, "moduleProto.annotationList");
                    Iterable<Annotation> iterable = bpq;
                    Collection arrayList = new ArrayList(n.e(iterable, 10));
                    for (Annotation annotation : iterable) {
                        h.d(annotation, "proto");
                        arrayList.add(dVar.le(annotation.getId()));
                    }
                    return new k(linkedHashMap, new a((List) arrayList), str2, null);
                }
                bVar2.invoke(gVar);
                return k.eMU;
            } catch (IOException unused) {
                return k.eMV;
            }
        }
    }

    private k(Map<String, m> map, a aVar, String str) {
        this.eMS = map;
        this.eMT = aVar;
        this.debugName = str;
    }

    public /* synthetic */ k(Map map, a aVar, String str, f fVar) {
        this(map, aVar, str);
    }

    public final Map<String, m> btE() {
        return this.eMS;
    }

    public String toString() {
        return this.debugName;
    }
}
