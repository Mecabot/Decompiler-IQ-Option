package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: JobParameters */
public interface r {
    @Nullable
    Bundle getExtras();

    int getLifetime();

    @NonNull
    String getTag();

    int[] oI();

    @NonNull
    x oJ();

    boolean oK();

    @NonNull
    u oL();

    boolean oM();

    @NonNull
    String oN();
}
