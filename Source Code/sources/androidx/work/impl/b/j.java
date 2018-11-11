package androidx.work.impl.b;

import android.arch.core.util.Function;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.State;
import androidx.work.e;
import androidx.work.l;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WorkSpec */
public class j {
    public static final Function<List<b>, List<l>> gC = new Function<List<b>, List<l>>() {
        /* renamed from: m */
        public List<l> apply(List<b> list) {
            if (list == null) {
                return null;
            }
            List<l> arrayList = new ArrayList(list.size());
            for (b cv : list) {
                arrayList.add(cv.cv());
            }
            return arrayList;
        }
    };
    public long gA;
    public long gB = -1;
    @NonNull
    public State gn = State.ENQUEUED;
    @NonNull
    public String go;
    public String gp;
    @NonNull
    public Data gq = Data.dS;
    @NonNull
    public Data gr = Data.dS;
    public long gs;
    public long gt;
    public long gu;
    @NonNull
    public androidx.work.b gv = androidx.work.b.dJ;
    public int gw;
    @NonNull
    public BackoffPolicy gx = BackoffPolicy.EXPONENTIAL;
    public long gy = 30000;
    public long gz;
    @NonNull
    public String id;

    /* compiled from: WorkSpec */
    public static class a {
        public State gn;
        public String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.gn != aVar.gn) {
                return false;
            }
            return this.id.equals(aVar.id);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.gn.hashCode();
        }
    }

    /* compiled from: WorkSpec */
    public static class b {
        public List<String> gD;
        public State gn;
        public Data gr;
        public String id;

        public l cv() {
            return new l(UUID.fromString(this.id), this.gn, this.gr, this.gD);
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
            if (!this.id == null ? this.id.equals(bVar.id) : bVar.id == null) {
                return false;
            }
            if (this.gn != bVar.gn) {
                return false;
            }
            if (!this.gr == null ? this.gr.equals(bVar.gr) : bVar.gr == null) {
                return false;
            }
            if (this.gD != null) {
                z = this.gD.equals(bVar.gD);
            } else if (bVar.gD != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.gn != null ? this.gn.hashCode() : 0)) * 31) + (this.gr != null ? this.gr.hashCode() : 0)) * 31;
            if (this.gD != null) {
                i = this.gD.hashCode();
            }
            return hashCode + i;
        }
    }

    public j(@NonNull String str, @NonNull String str2) {
        this.id = str;
        this.go = str2;
    }

    public j(@NonNull j jVar) {
        this.id = jVar.id;
        this.go = jVar.go;
        this.gn = jVar.gn;
        this.gp = jVar.gp;
        this.gq = new Data(jVar.gq);
        this.gr = new Data(jVar.gr);
        this.gs = jVar.gs;
        this.gt = jVar.gt;
        this.gu = jVar.gu;
        this.gv = new androidx.work.b(jVar.gv);
        this.gw = jVar.gw;
        this.gx = jVar.gx;
        this.gy = jVar.gy;
        this.gz = jVar.gz;
        this.gA = jVar.gA;
        this.gB = jVar.gB;
    }

    public void c(long j) {
        if (j > 18000000) {
            e.d("WorkSpec", "Backoff delay duration exceeds maximum value", new Throwable[0]);
            j = 18000000;
        }
        if (j < 10000) {
            e.d("WorkSpec", "Backoff delay duration less than minimum value", new Throwable[0]);
            j = 10000;
        }
        this.gy = j;
    }

    public boolean isPeriodic() {
        return this.gt != 0;
    }

    public boolean cs() {
        return this.gn == State.ENQUEUED && this.gw > 0;
    }

    public void d(long j) {
        if (j < 900000) {
            e.d("WorkSpec", String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(900000)}), new Throwable[0]);
            j = 900000;
        }
        a(j, j);
    }

    public void a(long j, long j2) {
        if (j < 900000) {
            e.d("WorkSpec", String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(900000)}), new Throwable[0]);
            j = 900000;
        }
        if (j2 < 300000) {
            e.d("WorkSpec", String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(300000)}), new Throwable[0]);
            j2 = 300000;
        }
        if (j2 > j) {
            e.d("WorkSpec", String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(j)}), new Throwable[0]);
            j2 = j;
        }
        this.gt = j;
        this.gu = j2;
    }

    public long ct() {
        if (cs()) {
            long j;
            if ((this.gx == BackoffPolicy.LINEAR ? 1 : null) != null) {
                j = this.gy * ((long) this.gw);
            } else {
                j = (long) Math.scalb((float) this.gy, this.gw - 1);
            }
            return this.gz + Math.min(18000000, j);
        } else if (isPeriodic()) {
            return (this.gz + this.gt) - this.gu;
        } else {
            return this.gz + this.gs;
        }
    }

    public boolean cu() {
        return androidx.work.b.dJ.equals(this.gv) ^ 1;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.gs != jVar.gs || this.gt != jVar.gt || this.gu != jVar.gu || this.gw != jVar.gw || this.gy != jVar.gy || this.gz != jVar.gz || this.gA != jVar.gA || this.gB != jVar.gB || !this.id.equals(jVar.id) || this.gn != jVar.gn || !this.go.equals(jVar.go)) {
            return false;
        }
        if (!this.gp == null ? this.gp.equals(jVar.gp) : jVar.gp == null) {
            return false;
        }
        if (!this.gq.equals(jVar.gq) || !this.gr.equals(jVar.gr) || !this.gv.equals(jVar.gv)) {
            return false;
        }
        if (this.gx != jVar.gx) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.gn.hashCode()) * 31) + this.go.hashCode()) * 31) + (this.gp != null ? this.gp.hashCode() : 0)) * 31) + this.gq.hashCode()) * 31) + this.gr.hashCode()) * 31) + ((int) (this.gs ^ (this.gs >>> 32)))) * 31) + ((int) (this.gt ^ (this.gt >>> 32)))) * 31) + ((int) (this.gu ^ (this.gu >>> 32)))) * 31) + this.gv.hashCode()) * 31) + this.gw) * 31) + this.gx.hashCode()) * 31) + ((int) (this.gy ^ (this.gy >>> 32)))) * 31) + ((int) (this.gz ^ (this.gz >>> 32)))) * 31) + ((int) (this.gA ^ (this.gA >>> 32)))) * 31) + ((int) (this.gB ^ (this.gB >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{WorkSpec: ");
        stringBuilder.append(this.id);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
