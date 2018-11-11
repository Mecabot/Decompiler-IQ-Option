package androidx.work;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

/* compiled from: Constraints */
public final class b {
    public static final b dJ = new a().aO();
    private NetworkType dK;
    private boolean dL;
    private boolean dM;
    private boolean dN;
    private boolean dO;
    @Nullable
    private c dP;

    /* compiled from: Constraints */
    public static final class a {
        NetworkType dK = NetworkType.NOT_REQUIRED;
        boolean dL = false;
        boolean dM = false;
        boolean dN = false;
        boolean dO = false;
        c dP = new c();

        @NonNull
        public a b(@NonNull NetworkType networkType) {
            this.dK = networkType;
            return this;
        }

        @NonNull
        public b aO() {
            return new b(this);
        }
    }

    b(a aVar) {
        this.dL = aVar.dL;
        boolean z = VERSION.SDK_INT >= 23 && aVar.dM;
        this.dM = z;
        this.dK = aVar.dK;
        this.dN = aVar.dN;
        this.dO = aVar.dO;
        this.dP = VERSION.SDK_INT >= 24 ? aVar.dP : new c();
    }

    public b(@NonNull b bVar) {
        this.dL = bVar.dL;
        this.dM = bVar.dM;
        this.dK = bVar.dK;
        this.dN = bVar.dN;
        this.dO = bVar.dO;
        this.dP = bVar.dP;
    }

    @NonNull
    public NetworkType aH() {
        return this.dK;
    }

    public void a(@NonNull NetworkType networkType) {
        this.dK = networkType;
    }

    public boolean aI() {
        return this.dL;
    }

    public void m(boolean z) {
        this.dL = z;
    }

    @RequiresApi(23)
    public boolean aJ() {
        return this.dM;
    }

    @RequiresApi(23)
    public void n(boolean z) {
        this.dM = z;
    }

    public boolean aK() {
        return this.dN;
    }

    public void o(boolean z) {
        this.dN = z;
    }

    public boolean aL() {
        return this.dO;
    }

    public void p(boolean z) {
        this.dO = z;
    }

    @RequiresApi(24)
    public void a(@Nullable c cVar) {
        this.dP = cVar;
    }

    @Nullable
    @RequiresApi(24)
    public c aM() {
        return this.dP;
    }

    @RequiresApi(24)
    public boolean aN() {
        return this.dP != null && this.dP.size() > 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!(this.dK == bVar.dK && this.dL == bVar.dL && this.dM == bVar.dM && this.dN == bVar.dN && this.dO == bVar.dO && (!this.dP == null ? !this.dP.equals(bVar.dP) : bVar.dP != null))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((((this.dK.hashCode() * 31) + this.dL) * 31) + this.dM) * 31) + this.dN) * 31) + this.dO) * 31) + (this.dP != null ? this.dP.hashCode() : 0);
    }
}
