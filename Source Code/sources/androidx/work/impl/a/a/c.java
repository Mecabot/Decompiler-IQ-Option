package androidx.work.impl.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import androidx.work.impl.a.b.d;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ConstraintController */
public abstract class c<T> implements androidx.work.impl.a.a<T> {
    private final List<String> fL = new ArrayList();
    private T fM;
    private d<T> fN;
    private a fO;

    /* compiled from: ConstraintController */
    public interface a {
        void k(@NonNull List<String> list);

        void l(@NonNull List<String> list);
    }

    abstract boolean i(@NonNull T t);

    abstract boolean j(@NonNull j jVar);

    c(d<T> dVar) {
        this.fN = dVar;
    }

    public void a(a aVar) {
        if (this.fO != aVar) {
            this.fO = aVar;
            cf();
        }
    }

    public void j(@NonNull List<j> list) {
        this.fL.clear();
        for (j jVar : list) {
            if (j(jVar)) {
                this.fL.add(jVar.id);
            }
        }
        if (this.fL.isEmpty()) {
            this.fN.b(this);
        } else {
            this.fN.a(this);
        }
        cf();
    }

    public void reset() {
        if (!this.fL.isEmpty()) {
            this.fL.clear();
            this.fN.b(this);
        }
    }

    public boolean G(@NonNull String str) {
        return this.fM != null && i(this.fM) && this.fL.contains(str);
    }

    private void cf() {
        if (!this.fL.isEmpty() && this.fO != null) {
            if (this.fM == null || i(this.fM)) {
                this.fO.l(this.fL);
            } else {
                this.fO.k(this.fL);
            }
        }
    }

    public void h(@Nullable T t) {
        this.fM = t;
        cf();
    }
}
