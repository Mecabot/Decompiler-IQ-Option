package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.NetworkType;
import androidx.work.b;
import androidx.work.e;
import androidx.work.impl.b.j;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {

    public static class BatteryChargingProxy extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
    }

    public static class NetworkStateProxy extends ConstraintProxy {
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
    }

    ConstraintProxy() {
    }

    public void onReceive(Context context, Intent intent) {
        e.b("ConstraintProxy", String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(b.f(context));
    }

    static void a(Context context, List<j> list) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (j jVar : list) {
            b bVar = jVar.gv;
            z |= bVar.aK();
            z2 |= bVar.aI();
            z3 |= bVar.aL();
            z4 |= bVar.aH() != NetworkType.NOT_REQUIRED ? 1 : 0;
            if (z && z2 && z3 && z4) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.b(z, z2, z3, z4));
    }
}
