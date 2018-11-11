package com.google.android.gms.analytics;

import android.content.BroadcastReceiver.PendingResult;

final class zzc implements Runnable {
    private /* synthetic */ PendingResult zzdue;

    zzc(CampaignTrackingReceiver campaignTrackingReceiver, PendingResult pendingResult) {
        this.zzdue = pendingResult;
    }

    public final void run() {
        if (this.zzdue != null) {
            this.zzdue.finish();
        }
    }
}
