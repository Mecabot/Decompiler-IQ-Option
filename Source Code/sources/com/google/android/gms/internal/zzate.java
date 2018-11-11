package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzbq;

class zzate extends BroadcastReceiver {
    private static String zzedv = "com.google.android.gms.internal.zzate";
    private boolean mRegistered;
    private final zzark zzdyp;
    private boolean zzedw;

    zzate(zzark zzark) {
        zzbq.checkNotNull(zzark);
        this.zzdyp = zzark;
    }

    private final void zzaav() {
        this.zzdyp.zzxy();
        this.zzdyp.zzyc();
    }

    private final boolean zzaax() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzdyp.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        } catch (SecurityException unused) {
            return false;
        }
    }

    public final boolean isConnected() {
        if (!this.mRegistered) {
            this.zzdyp.zzxy().zzed("Connectivity unknown. Receiver not registered");
        }
        return this.zzedw;
    }

    public void onReceive(Context context, Intent intent) {
        zzaav();
        String action = intent.getAction();
        this.zzdyp.zzxy().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzaax = zzaax();
            if (this.zzedw != zzaax) {
                this.zzedw = zzaax;
                zzarh zzyc = this.zzdyp.zzyc();
                zzyc.zza("Network connectivity status changed", Boolean.valueOf(zzaax));
                zzyc.zzya().zzd(new zzarb(zzyc, zzaax));
            }
        } else if ("com.google.analytics.RADIO_POWERED".equals(action)) {
            if (!intent.hasExtra(zzedv)) {
                zzarh zzyc2 = this.zzdyp.zzyc();
                zzyc2.zzea("Radio powered up");
                zzyc2.zzxs();
            }
        } else {
            this.zzdyp.zzxy().zzd("NetworkBroadcastReceiver received unknown action", action);
        }
    }

    public final void unregister() {
        if (this.mRegistered) {
            this.zzdyp.zzxy().zzea("Unregistering connectivity change receiver");
            this.mRegistered = false;
            this.zzedw = false;
            try {
                this.zzdyp.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzdyp.zzxy().zze("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final void zzaau() {
        zzaav();
        if (!this.mRegistered) {
            Context context = this.zzdyp.getContext();
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(this, intentFilter);
            this.zzedw = zzaax();
            this.zzdyp.zzxy().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzedw));
            this.mRegistered = true;
        }
    }

    public final void zzaaw() {
        Context context = this.zzdyp.getContext();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzedv, true);
        context.sendOrderedBroadcast(intent, null);
    }
}
