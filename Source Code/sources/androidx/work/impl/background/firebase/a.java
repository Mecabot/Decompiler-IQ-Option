package androidx.work.impl.background.firebase;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import androidx.work.BackoffPolicy;
import androidx.work.impl.b.j;
import com.firebase.jobdispatcher.e;
import com.firebase.jobdispatcher.n;
import com.firebase.jobdispatcher.u.b;
import com.firebase.jobdispatcher.w;
import com.firebase.jobdispatcher.x;
import com.firebase.jobdispatcher.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: FirebaseJobConverter */
class a {
    private e fe;

    n a(j jVar) {
        com.firebase.jobdispatcher.n.a g = this.fe.oA().k(FirebaseJobService.class).cu(jVar.id).ar(2).V(true).b(d(jVar)).g(e(jVar));
        a(g, jVar);
        return g.oO();
    }

    private void a(com.firebase.jobdispatcher.n.a aVar, j jVar) {
        if (VERSION.SDK_INT >= 24 && jVar.gv.aN()) {
            aVar.b(b(jVar));
        } else if (jVar.isPeriodic()) {
            aVar.b(c(jVar));
            aVar.W(true);
        } else {
            aVar.b(y.KT);
        }
    }

    @RequiresApi(24)
    private static com.firebase.jobdispatcher.u.a b(j jVar) {
        List arrayList = new ArrayList();
        Iterator it = jVar.gv.aM().iterator();
        while (it.hasNext()) {
            arrayList.add(a((androidx.work.c.a) it.next()));
        }
        return y.t(arrayList);
    }

    private static b c(j jVar) {
        int b = b(jVar.gt);
        return y.r(b - b(jVar.gu), b);
    }

    static int b(long j) {
        return (int) TimeUnit.SECONDS.convert(j, TimeUnit.MILLISECONDS);
    }

    private x d(j jVar) {
        return this.fe.e(jVar.gx == BackoffPolicy.LINEAR ? 2 : 1, (int) TimeUnit.SECONDS.convert(jVar.gy, TimeUnit.MILLISECONDS), (int) TimeUnit.SECONDS.convert(18000000, TimeUnit.MILLISECONDS));
    }

    private static w a(androidx.work.c.a aVar) {
        return new w(aVar.getUri(), aVar.aP());
    }

    private int[] e(j jVar) {
        androidx.work.b bVar = jVar.gv;
        List arrayList = new ArrayList();
        if (VERSION.SDK_INT >= 23 && bVar.aJ()) {
            arrayList.add(Integer.valueOf(8));
        }
        if (bVar.aI()) {
            arrayList.add(Integer.valueOf(4));
        }
        if (bVar.aK()) {
            androidx.work.e.d("FirebaseJobConverter", "Battery Not Low is not a supported constraint with FirebaseJobDispatcher", new Throwable[0]);
        }
        if (bVar.aL()) {
            androidx.work.e.d("FirebaseJobConverter", "Storage Not Low is not a supported constraint with FirebaseJobDispatcher", new Throwable[0]);
        }
        switch (bVar.aH()) {
            case CONNECTED:
                arrayList.add(Integer.valueOf(2));
                break;
            case UNMETERED:
                arrayList.add(Integer.valueOf(1));
                break;
            case NOT_ROAMING:
                androidx.work.e.d("FirebaseJobConverter", "Not Roaming Network is not a supported constraint with FirebaseJobDispatcher. Falling back to Any Network constraint.", new Throwable[0]);
                arrayList.add(Integer.valueOf(2));
                break;
            case METERED:
                androidx.work.e.d("FirebaseJobConverter", "Metered Network is not a supported constraint with FirebaseJobDispatcher. Falling back to Any Network constraint.", new Throwable[0]);
                arrayList.add(Integer.valueOf(2));
                break;
        }
        return g(arrayList);
    }

    private int[] g(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }
}
