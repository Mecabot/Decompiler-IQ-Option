package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: DFS */
public class b {

    /* compiled from: DFS */
    public interface b<N> {
        Iterable<? extends N> cK(N n);
    }

    /* compiled from: DFS */
    public interface c<N, R> {
        R bcM();

        boolean cL(N n);

        void dc(N n);
    }

    /* compiled from: DFS */
    public interface d<N> {
        boolean dh(N n);
    }

    /* compiled from: DFS */
    public static abstract class a<N, R> implements c<N, R> {
        public boolean cL(N n) {
            return true;
        }

        public void dc(N n) {
        }
    }

    /* compiled from: DFS */
    public static class e<N> implements d<N> {
        private final Set<N> Vz;

        public e() {
            this(new HashSet());
        }

        public e(Set<N> set) {
            this.Vz = set;
        }

        public boolean dh(N n) {
            return this.Vz.add(n);
        }
    }

    public static <N, R> R a(Collection<N> collection, b<N> bVar, d<N> dVar, c<N, R> cVar) {
        for (N a : collection) {
            a((Object) a, (b) bVar, (d) dVar, (c) cVar);
        }
        return cVar.bcM();
    }

    public static <N, R> R a(Collection<N> collection, b<N> bVar, c<N, R> cVar) {
        return a((Collection) collection, (b) bVar, new e(), (c) cVar);
    }

    public static <N> Boolean a(Collection<N> collection, b<N> bVar, final kotlin.jvm.a.b<N, Boolean> bVar2) {
        final boolean[] zArr = new boolean[1];
        return (Boolean) a((Collection) collection, (b) bVar, new a<N, Boolean>() {
            public boolean cL(N n) {
                if (((Boolean) bVar2.invoke(n)).booleanValue()) {
                    zArr[0] = true;
                }
                return zArr[0] ^ true;
            }

            /* renamed from: bzx */
            public Boolean bcM() {
                return Boolean.valueOf(zArr[0]);
            }
        });
    }

    public static <N> void a(N n, b<N> bVar, d<N> dVar, c<N, ?> cVar) {
        if (dVar.dh(n) && cVar.cL(n)) {
            for (Object a : bVar.cK(n)) {
                a(a, (b) bVar, (d) dVar, (c) cVar);
            }
            cVar.dc(n);
        }
    }
}
