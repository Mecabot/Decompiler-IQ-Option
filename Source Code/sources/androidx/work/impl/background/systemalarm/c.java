package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.WorkerThread;
import androidx.work.e;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: ConstraintsCommandHandler */
class c {
    private final d fk = new d(this.mContext, null);
    private final e fo;
    private final List<j> fp = new ArrayList();
    private final Context mContext;
    private final int mStartId;

    c(@NonNull Context context, int i, @NonNull e eVar) {
        this.mContext = context;
        this.mStartId = i;
        this.fo = eVar;
    }

    @WorkerThread
    void bS() {
        List<j> l = this.fo.bX().bA().bu().l(this.fo.bX().bB().aE());
        List<j> arrayList = new ArrayList(l.size());
        for (j jVar : l) {
            if (jVar.gB != -1) {
                arrayList.add(jVar);
            }
        }
        ConstraintProxy.a(this.mContext, arrayList);
        this.fk.j(arrayList);
        for (j jVar2 : arrayList) {
            String str = jVar2.id;
            if (!jVar2.cu() || this.fk.F(str)) {
                this.fp.add(jVar2);
            }
        }
        for (j jVar22 : this.fp) {
            Intent b = b.b(this.mContext, jVar22.id);
            e.b("ConstraintsCmdHandler", String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{r1}), new Throwable[0]);
            this.fo.d(new a(this.fo, b, this.mStartId));
        }
        this.fk.reset();
    }
}
