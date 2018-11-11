package androidx.work;

import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* compiled from: WorkStatus */
public final class l {
    @NonNull
    private UUID dV;
    @NonNull
    private Set<String> dX;
    @NonNull
    private State dZ;
    @NonNull
    private Data ea;

    public l(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list) {
        this.dV = uuid;
        this.dZ = state;
        this.ea = data;
        this.dX = new HashSet(list);
    }

    @NonNull
    public State bf() {
        return this.dZ;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (!this.dV == null ? this.dV.equals(lVar.dV) : lVar.dV == null) {
            return false;
        }
        if (this.dZ != lVar.dZ) {
            return false;
        }
        if (!this.ea == null ? this.ea.equals(lVar.ea) : lVar.ea == null) {
            return false;
        }
        if (this.dX != null) {
            z = this.dX.equals(lVar.dX);
        } else if (lVar.dX != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((this.dV != null ? this.dV.hashCode() : 0) * 31) + (this.dZ != null ? this.dZ.hashCode() : 0)) * 31) + (this.ea != null ? this.ea.hashCode() : 0)) * 31;
        if (this.dX != null) {
            i = this.dX.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkStatus{mId='");
        stringBuilder.append(this.dV);
        stringBuilder.append('\'');
        stringBuilder.append(", mState=");
        stringBuilder.append(this.dZ);
        stringBuilder.append(", mOutputData=");
        stringBuilder.append(this.ea);
        stringBuilder.append(", mTags=");
        stringBuilder.append(this.dX);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
