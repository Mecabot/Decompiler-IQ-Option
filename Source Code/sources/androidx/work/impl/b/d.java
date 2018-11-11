package androidx.work.impl.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: SystemIdInfo */
public class d {
    @NonNull
    public final String gc;
    public final int gh;

    public d(@NonNull String str, int i) {
        this.gc = str;
        this.gh = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.gh != dVar.gh) {
            return false;
        }
        return this.gc.equals(dVar.gc);
    }

    public int hashCode() {
        return (this.gc.hashCode() * 31) + this.gh;
    }
}
