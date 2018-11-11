package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompat;
import androidx.work.e;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: BatteryChargingTracker */
public class a extends c<Boolean> {
    public a(Context context) {
        super(context);
    }

    /* renamed from: cg */
    public Boolean ci() {
        Intent registerReceiver = this.mAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(b(registerReceiver));
        }
        e.e("BatteryChrgTracker", "getInitialState - null intent received", new Throwable[0]);
        return null;
    }

    public IntentFilter ch() {
        IntentFilter intentFilter = new IntentFilter();
        if (VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    public void b(android.content.Context r5, @android.support.annotation.NonNull android.content.Intent r6) {
        /*
        r4 = this;
        r5 = r6.getAction();
        if (r5 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r6 = "BatteryChrgTracker";
        r0 = "Received %s";
        r1 = 1;
        r2 = new java.lang.Object[r1];
        r3 = 0;
        r2[r3] = r5;
        r0 = java.lang.String.format(r0, r2);
        r2 = new java.lang.Throwable[r3];
        androidx.work.e.b(r6, r0, r2);
        r6 = -1;
        r0 = r5.hashCode();
        r2 = -1886648615; // 0xffffffff8f8c06d9 float:-1.3807703E-29 double:NaN;
        if (r0 == r2) goto L_0x0052;
    L_0x0024:
        r2 = -54942926; // 0xfffffffffcb9a332 float:-7.711079E36 double:NaN;
        if (r0 == r2) goto L_0x0048;
    L_0x0029:
        r2 = 948344062; // 0x388694fe float:6.41737E-5 double:4.685442215E-315;
        if (r0 == r2) goto L_0x003e;
    L_0x002e:
        r2 = 1019184907; // 0x3cbf870b float:0.023379823 double:5.035442493E-315;
        if (r0 == r2) goto L_0x0034;
    L_0x0033:
        goto L_0x005c;
    L_0x0034:
        r0 = "android.intent.action.ACTION_POWER_CONNECTED";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x005c;
    L_0x003c:
        r5 = 2;
        goto L_0x005d;
    L_0x003e:
        r0 = "android.os.action.CHARGING";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x005c;
    L_0x0046:
        r5 = 0;
        goto L_0x005d;
    L_0x0048:
        r0 = "android.os.action.DISCHARGING";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x005c;
    L_0x0050:
        r5 = 1;
        goto L_0x005d;
    L_0x0052:
        r0 = "android.intent.action.ACTION_POWER_DISCONNECTED";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x005c;
    L_0x005a:
        r5 = 3;
        goto L_0x005d;
    L_0x005c:
        r5 = -1;
    L_0x005d:
        switch(r5) {
            case 0: goto L_0x0079;
            case 1: goto L_0x0071;
            case 2: goto L_0x0069;
            case 3: goto L_0x0061;
            default: goto L_0x0060;
        };
    L_0x0060:
        goto L_0x0080;
    L_0x0061:
        r5 = java.lang.Boolean.valueOf(r3);
        r4.setState(r5);
        goto L_0x0080;
    L_0x0069:
        r5 = java.lang.Boolean.valueOf(r1);
        r4.setState(r5);
        goto L_0x0080;
    L_0x0071:
        r5 = java.lang.Boolean.valueOf(r3);
        r4.setState(r5);
        goto L_0x0080;
    L_0x0079:
        r5 = java.lang.Boolean.valueOf(r1);
        r4.setState(r5);
    L_0x0080:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.a.b.a.b(android.content.Context, android.content.Intent):void");
    }

    private boolean b(Intent intent) {
        if (VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }
}
