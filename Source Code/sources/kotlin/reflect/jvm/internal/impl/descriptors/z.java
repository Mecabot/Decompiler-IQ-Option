package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: PackageViewDescriptor.kt */
public interface z extends k {

    /* compiled from: PackageViewDescriptor.kt */
    public static final class a {
        public static boolean a(z zVar) {
            return zVar.getFragments().isEmpty();
        }
    }

    u bar();

    h bbk();

    b bdD();

    List<x> getFragments();

    boolean isEmpty();
}
