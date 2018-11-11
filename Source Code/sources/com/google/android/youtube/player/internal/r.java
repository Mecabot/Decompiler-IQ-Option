package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.u.a;
import com.google.android.youtube.player.internal.u.b;

public final class r extends s<n> implements d {
    private final String b;
    private final String c;
    private final String d;
    private boolean e;

    public r(Context context, String str, String str2, String str3, a aVar, b bVar) {
        super(context, aVar, bVar);
        this.b = (String) b.u(str);
        this.c = b.c(str2, "callingPackage cannot be null or empty");
        this.d = b.c(str3, "callingAppVersion cannot be null or empty");
    }

    private final void pi() {
        i();
        if (this.e) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    protected final void a(k kVar, d dVar) {
        kVar.a(dVar, 1202, this.c, this.d, this.b, null);
    }

    public final void a(boolean z) {
        if (f()) {
            try {
                ((n) pm()).a(z);
            } catch (RemoteException unused) {
                this.e = true;
            }
        }
    }

    protected final String b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    public final void d() {
        if (!this.e) {
            a(true);
        }
        super.d();
    }

    public final IBinder ph() {
        pi();
        try {
            return ((n) pm()).ph();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final String pl() {
        return "com.google.android.youtube.api.service.START";
    }
}
