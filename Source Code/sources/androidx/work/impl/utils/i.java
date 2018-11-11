package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WakeLocks */
public class i {
    public static WakeLock d(@NonNull Context context, @NonNull String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkManager: ");
        stringBuilder.append(str);
        return powerManager.newWakeLock(1, stringBuilder.toString());
    }
}
