package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r.b;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;

/* compiled from: ContractDeserializer.kt */
public interface g {
    public static final a eSI = a.eSK;

    /* compiled from: ContractDeserializer.kt */
    public static final class a {
        private static final g eSJ = new a();
        static final /* synthetic */ a eSK = new a();

        /* compiled from: ContractDeserializer.kt */
        public static final class a implements g {
            public Pair a(Function function, r rVar, h hVar, v vVar) {
                kotlin.jvm.internal.h.e(function, "proto");
                kotlin.jvm.internal.h.e(rVar, "ownerFunction");
                kotlin.jvm.internal.h.e(hVar, "typeTable");
                kotlin.jvm.internal.h.e(vVar, "typeDeserializer");
                return null;
            }

            a() {
            }
        }

        private a() {
        }

        public final g bxs() {
            return eSJ;
        }
    }

    Pair<b<?>, Object> a(Function function, r rVar, h hVar, v vVar);
}
