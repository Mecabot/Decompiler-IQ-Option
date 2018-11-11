package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.iid.zzi;
import com.google.android.gms.iid.zzj;

@Hide
public class m implements Parcelable {
    public static final Creator<m> CREATOR = new n();
    private Messenger Yt;
    private zzi Yu;

    public static final class a extends ClassLoader {
        protected final Class<?> loadClass(String str, boolean z) {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (FirebaseInstanceId.wp()) {
                Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            }
            return m.class;
        }
    }

    public m(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.Yt = new Messenger(iBinder);
        } else {
            this.Yu = zzj.zzbc(iBinder);
        }
    }

    private final IBinder getBinder() {
        return this.Yt != null ? this.Yt.getBinder() : this.Yu.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((m) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) {
        if (this.Yt != null) {
            this.Yt.send(message);
        } else {
            this.Yu.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.Yt != null ? this.Yt.getBinder() : this.Yu.asBinder());
    }
}
