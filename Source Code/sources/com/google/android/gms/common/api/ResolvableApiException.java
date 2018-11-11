package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.support.annotation.NonNull;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@NonNull Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return this.mStatus.getResolution();
    }

    public void startResolutionForResult(Activity activity, int i) {
        this.mStatus.startResolutionForResult(activity, i);
    }
}
