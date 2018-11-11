package kotlin.jvm;

import com.iqoption.dto.entity.position.Position;
import java.lang.annotation.Annotation;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018GX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, aXE = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
/* compiled from: JvmClassMapping.kt */
public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        h.e(bVar, "$receiver");
        Class<T> aXV = ((c) bVar).aXV();
        if (aXV != null) {
            return aXV;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final <T> java.lang.Class<T> b(kotlin.reflect.b<T> r1) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r1, r0);
        r1 = (kotlin.jvm.internal.c) r1;
        r1 = r1.aXV();
        r0 = r1.isPrimitive();
        if (r0 == 0) goto L_0x001c;
    L_0x0011:
        if (r1 != 0) goto L_0x001b;
    L_0x0013:
        r1 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type java.lang.Class<T>";
        r1.<init>(r0);
        throw r1;
    L_0x001b:
        return r1;
    L_0x001c:
        r1 = r1.getName();
        if (r1 != 0) goto L_0x0024;
    L_0x0022:
        goto L_0x0090;
    L_0x0024:
        r0 = r1.hashCode();
        switch(r0) {
            case -2056817302: goto L_0x0085;
            case -527879800: goto L_0x007a;
            case -515992664: goto L_0x006f;
            case 155276373: goto L_0x0064;
            case 344809556: goto L_0x0059;
            case 398507100: goto L_0x004e;
            case 398795216: goto L_0x0043;
            case 399092968: goto L_0x0038;
            case 761287205: goto L_0x002d;
            default: goto L_0x002b;
        };
    L_0x002b:
        goto L_0x0090;
    L_0x002d:
        r0 = "java.lang.Double";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x0035:
        r1 = java.lang.Double.TYPE;
        goto L_0x0091;
    L_0x0038:
        r0 = "java.lang.Void";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x0040:
        r1 = java.lang.Void.TYPE;
        goto L_0x0091;
    L_0x0043:
        r0 = "java.lang.Long";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x004b:
        r1 = java.lang.Long.TYPE;
        goto L_0x0091;
    L_0x004e:
        r0 = "java.lang.Byte";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x0056:
        r1 = java.lang.Byte.TYPE;
        goto L_0x0091;
    L_0x0059:
        r0 = "java.lang.Boolean";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x0061:
        r1 = java.lang.Boolean.TYPE;
        goto L_0x0091;
    L_0x0064:
        r0 = "java.lang.Character";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x006c:
        r1 = java.lang.Character.TYPE;
        goto L_0x0091;
    L_0x006f:
        r0 = "java.lang.Short";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x0077:
        r1 = java.lang.Short.TYPE;
        goto L_0x0091;
    L_0x007a:
        r0 = "java.lang.Float";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x0082:
        r1 = java.lang.Float.TYPE;
        goto L_0x0091;
    L_0x0085:
        r0 = "java.lang.Integer";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0090;
    L_0x008d:
        r1 = java.lang.Integer.TYPE;
        goto L_0x0091;
    L_0x0090:
        r1 = 0;
    L_0x0091:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.a.b(kotlin.reflect.b):java.lang.Class<T>");
    }

    public static final <T> Class<T> c(b<T> bVar) {
        h.e(bVar, "$receiver");
        Class<T> aXV = ((c) bVar).aXV();
        if (aXV.isPrimitive()) {
            String name = aXV.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            aXV = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            aXV = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            aXV = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            aXV = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals(Position.TYPE_LONG)) {
                            aXV = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            aXV = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            aXV = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            aXV = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals(Position.TYPE_SHORT)) {
                            aXV = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (aXV != null) {
                return aXV;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (aXV != null) {
            return aXV;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    public static final <T> b<T> E(Class<T> cls) {
        h.e(cls, "$receiver");
        return j.F(cls);
    }

    public static final <T extends Annotation> b<? extends T> a(T t) {
        h.e(t, "$receiver");
        Class annotationType = t.annotationType();
        h.d(annotationType, "(this as java.lang.annot…otation).annotationType()");
        b<? extends T> E = E(annotationType);
        if (E != null) {
            return E;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
