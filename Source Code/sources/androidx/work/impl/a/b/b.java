package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompat;
import androidx.work.e;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: BatteryNotLowTracker */
public class b extends c<Boolean> {
    public b(Context context) {
        super(context);
    }

    /* renamed from: cg */
    public Boolean ci() {
        Intent registerReceiver = this.mAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            e.e("BatteryNotLowTracker", "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("plugged", 0);
        int intExtra2 = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        float intExtra3 = ((float) registerReceiver.getIntExtra(com.google.firebase.analytics.FirebaseAnalytics.b.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        boolean z = true;
        if (intExtra == 0 && intExtra2 != 1 && intExtra3 <= 0.15f) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public IntentFilter ch() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    public void b(Context context, @NonNull Intent intent) {
        if (intent.getAction() != null) {
            e.b("BatteryNotLowTracker", String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            Object obj = -1;
            int hashCode = action.hashCode();
            if (hashCode != -1980154005) {
                if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                    obj = 1;
                }
            } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    setState(Boolean.valueOf(true));
                    break;
                case 1:
                    setState(Boolean.valueOf(false));
                    break;
            }
        }
    }
}
