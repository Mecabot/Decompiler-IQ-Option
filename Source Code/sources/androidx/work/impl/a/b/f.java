package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.e;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: StorageNotLowTracker */
public class f extends c<Boolean> {
    public f(Context context) {
        super(context);
    }

    /* renamed from: cg */
    public Boolean ci() {
        Intent registerReceiver = this.mAppContext.registerReceiver(null, ch());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.valueOf(true);
        }
        String action = registerReceiver.getAction();
        Object obj = -1;
        int hashCode = action.hashCode();
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                obj = null;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            obj = 1;
        }
        switch (obj) {
            case null:
                return Boolean.valueOf(true);
            case 1:
                return Boolean.valueOf(false);
            default:
                return null;
        }
    }

    public IntentFilter ch() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    public void b(Context context, @NonNull Intent intent) {
        if (intent.getAction() != null) {
            e.b("StorageNotLowTracker", String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            Object obj = -1;
            int hashCode = action.hashCode();
            if (hashCode != -1181163412) {
                if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                    obj = null;
                }
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                obj = 1;
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
