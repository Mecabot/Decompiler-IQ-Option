package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Modifier;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.load.java.k;
import kotlin.reflect.jvm.internal.impl.load.java.structure.r;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaModifierListOwner;", "isAbstract", "", "()Z", "isFinal", "isStatic", "modifiers", "", "getModifiers", "()I", "visibility", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "getVisibility", "()Lorg/jetbrains/kotlin/descriptors/Visibility;", "descriptors.runtime"})
/* compiled from: ReflectJavaModifierListOwner.kt */
public interface t extends r {

    @i(aXC = {1, 1, 11})
    /* compiled from: ReflectJavaModifierListOwner.kt */
    public static final class a {
        public static boolean a(t tVar) {
            return Modifier.isAbstract(tVar.getModifiers());
        }

        public static boolean b(t tVar) {
            return Modifier.isStatic(tVar.getModifiers());
        }

        public static boolean c(t tVar) {
            return Modifier.isFinal(tVar.getModifiers());
        }

        public static av d(t tVar) {
            int modifiers = tVar.getModifiers();
            av avVar;
            if (Modifier.isPublic(modifiers)) {
                avVar = au.eBg;
                h.d(avVar, "Visibilities.PUBLIC");
                return avVar;
            } else if (Modifier.isPrivate(modifiers)) {
                avVar = au.eBc;
                h.d(avVar, "Visibilities.PRIVATE");
                return avVar;
            } else if (Modifier.isProtected(modifiers)) {
                if (Modifier.isStatic(modifiers)) {
                    avVar = k.eFg;
                } else {
                    avVar = k.eFh;
                }
                h.d(avVar, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
                return avVar;
            } else {
                avVar = k.eFf;
                h.d(avVar, "JavaVisibilities.PACKAGE_VISIBILITY");
                return avVar;
            }
        }
    }

    int getModifiers();
}
