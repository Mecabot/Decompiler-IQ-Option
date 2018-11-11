package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzo extends LifecycleCallback implements OnCancelListener {
    protected volatile boolean mStarted;
    protected final GoogleApiAvailability zzftg;
    protected final AtomicReference<zzp> zzfut;
    private final Handler zzfuu;

    protected zzo(zzcf zzcf) {
        this(zzcf, GoogleApiAvailability.getInstance());
    }

    private zzo(zzcf zzcf, GoogleApiAvailability googleApiAvailability) {
        super(zzcf);
        this.zzfut = new AtomicReference(null);
        this.zzfuu = new Handler(Looper.getMainLooper());
        this.zzftg = googleApiAvailability;
    }

    private static int zza(@Nullable zzp zzp) {
        return zzp == null ? -1 : zzp.zzaim();
    }

    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = r3.zzfut;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.zzp) r0;
        r1 = 1;
        r2 = 0;
        switch(r4) {
            case 1: goto L_0x002e;
            case 2: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        goto L_0x0053;
    L_0x000e:
        r4 = r3.zzftg;
        r5 = r3.getActivity();
        r4 = r4.isGooglePlayServicesAvailable(r5);
        if (r4 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x001c;
    L_0x001b:
        r1 = 0;
    L_0x001c:
        if (r0 != 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        r5 = r0.zzain();
        r5 = r5.getErrorCode();
        r6 = 18;
        if (r5 != r6) goto L_0x0054;
    L_0x002b:
        if (r4 != r6) goto L_0x0054;
    L_0x002d:
        return;
    L_0x002e:
        r4 = -1;
        if (r5 != r4) goto L_0x0032;
    L_0x0031:
        goto L_0x0054;
    L_0x0032:
        if (r5 != 0) goto L_0x0053;
    L_0x0034:
        r4 = 13;
        if (r6 == 0) goto L_0x003e;
    L_0x0038:
        r5 = "<<ResolutionFailureErrorDetail>>";
        r4 = r6.getIntExtra(r5, r4);
    L_0x003e:
        r5 = new com.google.android.gms.common.api.internal.zzp;
        r6 = new com.google.android.gms.common.ConnectionResult;
        r1 = 0;
        r6.<init>(r4, r1);
        r4 = zza(r0);
        r5.<init>(r6, r4);
        r4 = r3.zzfut;
        r4.set(r5);
        r0 = r5;
    L_0x0053:
        r1 = 0;
    L_0x0054:
        if (r1 == 0) goto L_0x005a;
    L_0x0056:
        r3.zzail();
        return;
    L_0x005a:
        if (r0 == 0) goto L_0x0067;
    L_0x005c:
        r4 = r0.zzain();
        r5 = r0.zzaim();
        r3.zza(r4, r5);
    L_0x0067:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzo.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), zza((zzp) this.zzfut.get()));
        zzail();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzfut.set(bundle.getBoolean("resolving_error", false) ? new zzp(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zzp zzp = (zzp) this.zzfut.get();
        if (zzp != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzp.zzaim());
            bundle.putInt("failed_status", zzp.zzain().getErrorCode());
            bundle.putParcelable("failed_resolution", zzp.zzain().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    protected abstract void zza(ConnectionResult connectionResult, int i);

    protected abstract void zzaih();

    protected final void zzail() {
        this.zzfut.set(null);
        zzaih();
    }

    public final void zzb(ConnectionResult connectionResult, int i) {
        zzp zzp = new zzp(connectionResult, i);
        if (this.zzfut.compareAndSet(null, zzp)) {
            this.zzfuu.post(new zzq(this, zzp));
        }
    }
}
