package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.w;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation;

/* compiled from: JvmNameResolver.kt */
public final class h implements c {
    private static final List<String> eMN = m.listOf("kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator");
    private static final Map<String, Integer> eMO;
    public static final a eMP = new a();
    private final Set<Integer> eMK;
    private final List<Record> eML;
    private final StringTableTypes eMM;
    private final String[] strings;

    /* compiled from: JvmNameResolver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public h(StringTableTypes stringTableTypes, String[] strArr) {
        kotlin.jvm.internal.h.e(stringTableTypes, "types");
        kotlin.jvm.internal.h.e(strArr, "strings");
        this.eMM = stringTableTypes;
        this.strings = strArr;
        List bsT = this.eMM.bsT();
        this.eMK = bsT.isEmpty() ? aj.emptySet() : u.Y(bsT);
        ArrayList arrayList = new ArrayList();
        List<Record> bsS = this.eMM.bsS();
        arrayList.ensureCapacity(bsS.size());
        for (Record record : bsS) {
            kotlin.jvm.internal.h.d(record, "record");
            int bth = record.bth();
            for (int i = 0; i < bth; i++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        this.eML = arrayList;
    }

    public String getString(int i) {
        String string;
        int size;
        Integer num;
        Record record = (Record) this.eML.get(i);
        if (record.hasString()) {
            string = record.getString();
        } else {
            if (record.bti()) {
                size = eMN.size();
                int btj = record.btj();
                if (btj >= 0 && size > btj) {
                    string = (String) eMN.get(record.btj());
                }
            }
            string = this.strings[i];
        }
        if (record.bto() >= 2) {
            List btn = record.btn();
            Integer num2 = (Integer) btn.get(0);
            num = (Integer) btn.get(1);
            kotlin.jvm.internal.h.d(num2, "begin");
            if (kotlin.jvm.internal.h.compare(0, num2.intValue()) <= 0) {
                int intValue = num2.intValue();
                kotlin.jvm.internal.h.d(num, "end");
                if (kotlin.jvm.internal.h.compare(intValue, num.intValue()) <= 0 && kotlin.jvm.internal.h.compare(num.intValue(), string.length()) <= 0) {
                    kotlin.jvm.internal.h.d(string, "string");
                    int intValue2 = num2.intValue();
                    size = num.intValue();
                    if (string == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    string = string.substring(intValue2, size);
                    kotlin.jvm.internal.h.d(string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str = string;
        if (record.btq() >= 2) {
            List btp = record.btp();
            num = (Integer) btp.get(0);
            Integer num3 = (Integer) btp.get(1);
            kotlin.jvm.internal.h.d(str, "string");
            str = u.a(str, (char) num.intValue(), (char) num3.intValue(), false, 4, null);
        }
        String str2 = str;
        Operation btm = record.btm();
        if (btm == null) {
            btm = Operation.NONE;
        }
        switch (i.aoS[btm.ordinal()]) {
            case 2:
                kotlin.jvm.internal.h.d(str2, "string");
                str2 = u.a(str2, '$', '.', false, 4, null);
                break;
            case 3:
                if (str2.length() >= 2) {
                    kotlin.jvm.internal.h.d(str2, "string");
                    i = str2.length() - 1;
                    if (str2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    str2 = str2.substring(1, i);
                    kotlin.jvm.internal.h.d(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                String str3 = str2;
                kotlin.jvm.internal.h.d(str3, "string");
                str2 = u.a(str3, '$', '.', false, 4, null);
                break;
        }
        kotlin.jvm.internal.h.d(str2, "string");
        return str2;
    }

    public String le(int i) {
        return getString(i);
    }

    public boolean lf(int i) {
        return this.eMK.contains(Integer.valueOf(i));
    }

    static {
        Iterable<w> Z = u.Z(eMN);
        Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(Z, 10)), 16));
        for (w wVar : Z) {
            linkedHashMap.put((String) wVar.getValue(), Integer.valueOf(wVar.getIndex()));
        }
        eMO = linkedHashMap;
    }
}
