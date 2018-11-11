package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class x<T> {
    final int YI;
    final TaskCompletionSource<T> YJ = new TaskCompletionSource();
    final Bundle YK;
    final int what;

    x(int i, int i2, Bundle bundle) {
        this.YI = i;
        this.what = i2;
        this.YK = bundle;
    }

    abstract void I(Bundle bundle);

    final void b(zzu zzu) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzu);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.YJ.setException(zzu);
    }

    final void finish(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 16) + String.valueOf(valueOf2).length());
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.YJ.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.YI;
        boolean wI = wI();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=");
        stringBuilder.append(wI);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    abstract boolean wI();
}
