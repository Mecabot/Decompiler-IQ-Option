package androidx.work.impl.background.firebase;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.a;
import androidx.work.impl.g;
import com.firebase.jobdispatcher.r;
import com.firebase.jobdispatcher.s;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FirebaseJobService extends s implements a {
    private g eo;
    private final Map<String, r> fj = new HashMap();

    public void onCreate() {
        super.onCreate();
        this.eo = g.bz();
        this.eo.bD().a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eo.bD().b(this);
    }

    public boolean a(r rVar) {
        Object tag = rVar.getTag();
        if (TextUtils.isEmpty(tag)) {
            e.e("FirebaseJobService", "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        e.b("FirebaseJobService", String.format("onStartJob for %s", new Object[]{tag}), new Throwable[0]);
        synchronized (this.fj) {
            this.fj.put(tag, rVar);
        }
        this.eo.y(tag);
        return true;
    }

    public boolean b(r rVar) {
        String tag = rVar.getTag();
        if (TextUtils.isEmpty(tag)) {
            e.e("FirebaseJobService", "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        e.b("FirebaseJobService", String.format("onStopJob for %s", new Object[]{tag}), new Throwable[0]);
        synchronized (this.fj) {
            this.fj.remove(tag);
        }
        this.eo.z(tag);
        return this.eo.bD().t(tag) ^ true;
    }

    public void a(@NonNull String str, boolean z, boolean z2) {
        r rVar;
        e.b("FirebaseJobService", String.format("%s executed on FirebaseJobDispatcher", new Object[]{str}), new Throwable[0]);
        synchronized (this.fj) {
            rVar = (r) this.fj.get(str);
        }
        if (rVar != null) {
            b(rVar, z2);
        }
    }
}
