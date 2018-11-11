package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.WorkerThread;
import androidx.work.e;
import androidx.work.impl.a;
import androidx.work.impl.b.j;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: CommandHandler */
public class b implements a {
    private final Map<String, a> fn = new HashMap();
    private final Context mContext;
    private final Object mLock = new Object();

    static Intent a(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent b(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent c(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent f(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent g(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent a(@NonNull Context context, @NonNull String str, boolean z, boolean z2) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_IS_SUCCESSFUL", z);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z2);
        return intent;
    }

    b(@NonNull Context context) {
        this.mContext = context;
    }

    public void a(@NonNull String str, boolean z, boolean z2) {
        synchronized (this.mLock) {
            a aVar = (a) this.fn.remove(str);
            if (aVar != null) {
                aVar.a(str, z, z2);
            }
        }
    }

    boolean bR() {
        boolean isEmpty;
        synchronized (this.mLock) {
            isEmpty = this.fn.isEmpty() ^ 1;
        }
        return isEmpty;
    }

    @WorkerThread
    void a(@NonNull Intent intent, int i, @NonNull e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            e(intent, i, eVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            f(intent, i, eVar);
        } else if (!a(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            e.e("CommandHandler", String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            b(intent, i, eVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            c(intent, i, eVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            d(intent, i, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            g(intent, i, eVar);
        } else {
            e.d("CommandHandler", String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }

    private void b(@NonNull Intent intent, int i, @NonNull e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        e.b("CommandHandler", String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        j M = eVar.bX().bA().bu().M(string);
        long ct = M.ct();
        if (M.cu()) {
            e.b("CommandHandler", String.format("Opportunistically setting an alarm for %s", new Object[]{string}), new Throwable[0]);
            a.a(this.mContext, eVar.bX(), string, ct);
            eVar.d(new a(eVar, f(this.mContext), i));
            return;
        }
        e.b("CommandHandler", String.format("Setting up Alarms for %s", new Object[]{string}), new Throwable[0]);
        a.a(this.mContext, eVar.bX(), string, ct);
    }

    private void c(@NonNull Intent intent, int i, @NonNull e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.mLock) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            e.b("CommandHandler", String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            d dVar = new d(this.mContext, i, string, eVar);
            this.fn.put(string, dVar);
            dVar.bT();
        }
    }

    private void d(@NonNull Intent intent, int i, @NonNull e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        e.b("CommandHandler", String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        eVar.bX().z(string);
        a.a(this.mContext, eVar.bX(), string);
        eVar.a(string, false, false);
    }

    private void e(@NonNull Intent intent, int i, @NonNull e eVar) {
        e.b("CommandHandler", String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new c(this.mContext, i, eVar).bS();
    }

    private void f(@NonNull Intent intent, int i, @NonNull e eVar) {
        e.b("CommandHandler", String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        eVar.bX().bG();
    }

    private void g(@NonNull Intent intent, int i, @NonNull e eVar) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_IS_SUCCESSFUL");
        boolean z2 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        e.b("CommandHandler", String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        a(string, z, z2);
        eVar.d(new b(eVar));
    }

    private static boolean a(@Nullable Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (!bundle.containsKey(str) || bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }
}
