package androidx.work;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.impl.b.j;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: WorkRequest */
public abstract class k {
    @NonNull
    private UUID dV;
    @NonNull
    private j dW;
    @NonNull
    private Set<String> dX;

    /* compiled from: WorkRequest */
    public static abstract class a<B extends a, W extends k> {
        UUID dV = UUID.randomUUID();
        j dW;
        Set<String> dX = new HashSet();
        boolean dY = false;

        @NonNull
        abstract B aU();

        @NonNull
        abstract W aV();

        a(@NonNull Class<? extends Worker> cls) {
            this.dW = new j(this.dV.toString(), cls.getName());
            p(cls.getName());
        }

        @NonNull
        public final B a(@NonNull BackoffPolicy backoffPolicy, long j, @NonNull TimeUnit timeUnit) {
            this.dY = true;
            this.dW.gx = backoffPolicy;
            this.dW.c(timeUnit.toMillis(j));
            return aU();
        }

        @NonNull
        public final B a(@NonNull b bVar) {
            this.dW.gv = bVar;
            return aU();
        }

        @NonNull
        public final B p(@NonNull String str) {
            this.dX.add(str);
            return aU();
        }

        @NonNull
        public final W be() {
            W aV = aV();
            this.dV = UUID.randomUUID();
            this.dW = new j(this.dW);
            this.dW.id = this.dV.toString();
            return aV;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected k(@NonNull UUID uuid, @NonNull j jVar, @NonNull Set<String> set) {
        this.dV = uuid;
        this.dW = jVar;
        this.dX = set;
    }

    @NonNull
    public UUID getId() {
        return this.dV;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public String bb() {
        return this.dV.toString();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public j bc() {
        return this.dW;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public Set<String> bd() {
        return this.dX;
    }
}
