package androidx.work.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.i;
import androidx.work.impl.utils.b;
import androidx.work.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WorkContinuationImpl */
public class e extends i {
    private final g eo;
    private final ExistingWorkPolicy ep;
    private final List<? extends k> eq;
    private final List<String> er;
    private final List<String> es;
    private final List<e> et;
    private boolean eu;
    private final String mName;

    @NonNull
    public g bk() {
        return this.eo;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    public ExistingWorkPolicy bl() {
        return this.ep;
    }

    @NonNull
    public List<? extends k> bm() {
        return this.eq;
    }

    @NonNull
    public List<String> bn() {
        return this.er;
    }

    public boolean isEnqueued() {
        return this.eu;
    }

    public void bo() {
        this.eu = true;
    }

    public List<e> bp() {
        return this.et;
    }

    e(@NonNull g gVar, @NonNull List<? extends k> list) {
        this(gVar, null, ExistingWorkPolicy.KEEP, list, null);
    }

    e(@NonNull g gVar, String str, ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends k> list) {
        this(gVar, str, existingWorkPolicy, list, null);
    }

    e(@NonNull g gVar, String str, ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends k> list, @Nullable List<e> list2) {
        this.eo = gVar;
        this.mName = str;
        this.ep = existingWorkPolicy;
        this.eq = list;
        this.et = list2;
        this.er = new ArrayList(this.eq.size());
        this.es = new ArrayList();
        if (list2 != null) {
            for (e eVar : list2) {
                this.es.addAll(eVar.es);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            str = ((k) list.get(i)).bb();
            this.er.add(str);
            this.es.add(str);
        }
    }

    public void aY() {
        if (this.eu) {
            androidx.work.e.d("WorkContinuationImpl", String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.er)}), new Throwable[0]);
            return;
        }
        this.eo.bE().e(new b(this));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean bq() {
        return a(this, new HashSet());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    private static boolean a(@NonNull e eVar, @NonNull Set<String> set) {
        set.addAll(eVar.bn());
        Set a = a(eVar);
        for (String contains : set) {
            if (a.contains(contains)) {
                return true;
            }
        }
        List<e> bp = eVar.bp();
        if (!(bp == null || bp.isEmpty())) {
            for (e a2 : bp) {
                if (a(a2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(eVar.bn());
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static Set<String> a(e eVar) {
        Set<String> hashSet = new HashSet();
        List<e> bp = eVar.bp();
        if (!(bp == null || bp.isEmpty())) {
            for (e bn : bp) {
                hashSet.addAll(bn.bn());
            }
        }
        return hashSet;
    }
}
