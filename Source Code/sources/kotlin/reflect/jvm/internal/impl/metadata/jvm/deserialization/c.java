package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.f.d;
import kotlin.jvm.internal.h;

/* compiled from: ClassMapperLite.kt */
public final class c {
    public static final c eMB = new c();
    private static final Map<String, String> map;

    static {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        String stringBuilder3;
        Map linkedHashMap = new LinkedHashMap();
        List listOf = m.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        d a = j.a((d) m.L(listOf), 2);
        int first = a.getFirst();
        int last = a.getLast();
        int aYh = a.aYh();
        if (aYh <= 0 ? first < last : first > last) {
            while (true) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("kotlin/");
                stringBuilder.append((String) listOf.get(first));
                int i = first + 1;
                linkedHashMap.put(stringBuilder.toString(), listOf.get(i));
                stringBuilder = new StringBuilder();
                stringBuilder.append("kotlin/");
                stringBuilder.append((String) listOf.get(first));
                stringBuilder.append("Array");
                String stringBuilder4 = stringBuilder.toString();
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append('[');
                stringBuilder5.append((String) listOf.get(i));
                linkedHashMap.put(stringBuilder4, stringBuilder5.toString());
                if (first == last) {
                    break;
                }
                first += aYh;
            }
        }
        linkedHashMap.put("kotlin/Unit", "V");
        ClassMapperLite$map$1$1 classMapperLite$map$1$1 = new ClassMapperLite$map$1$1(linkedHashMap);
        classMapperLite$map$1$1.Z("Any", "java/lang/Object");
        classMapperLite$map$1$1.Z("Nothing", "java/lang/Void");
        classMapperLite$map$1$1.Z("Annotation", "java/lang/annotation/Annotation");
        for (String str : m.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("java/lang/");
            stringBuilder2.append(str);
            classMapperLite$map$1$1.Z(str, stringBuilder2.toString());
        }
        for (String str2 : m.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("collections/");
            stringBuilder2.append(str2);
            stringBuilder3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("java/util/");
            stringBuilder.append(str2);
            classMapperLite$map$1$1.Z(stringBuilder3, stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("collections/Mutable");
            stringBuilder2.append(str2);
            stringBuilder3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("java/util/");
            stringBuilder.append(str2);
            classMapperLite$map$1$1.Z(stringBuilder3, stringBuilder.toString());
        }
        classMapperLite$map$1$1.Z("collections/Iterable", "java/lang/Iterable");
        classMapperLite$map$1$1.Z("collections/MutableIterable", "java/lang/Iterable");
        classMapperLite$map$1$1.Z("collections/Map.Entry", "java/util/Map$Entry");
        classMapperLite$map$1$1.Z("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (aYh = 0; aYh <= 22; aYh++) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Function");
            stringBuilder2.append(aYh);
            stringBuilder3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin/jvm/functions/Function");
            stringBuilder.append(aYh);
            classMapperLite$map$1$1.Z(stringBuilder3, stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("reflect/KFunction");
            stringBuilder2.append(aYh);
            classMapperLite$map$1$1.Z(stringBuilder2.toString(), "kotlin/reflect/KFunction");
        }
        for (String str22 : m.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str22);
            stringBuilder2.append(".Companion");
            stringBuilder3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin/jvm/internal/");
            stringBuilder.append(str22);
            stringBuilder.append("CompanionObject");
            classMapperLite$map$1$1.Z(stringBuilder3, stringBuilder.toString());
        }
        map = linkedHashMap;
    }

    private c() {
    }

    public static final String my(String str) {
        h.e(str, "classId");
        String str2 = (String) map.get(str);
        if (str2 != null) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('L');
        stringBuilder.append(u.a(str, '.', '$', false, 4, null));
        stringBuilder.append(';');
        return stringBuilder.toString();
    }
}
