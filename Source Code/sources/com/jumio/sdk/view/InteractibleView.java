package com.jumio.sdk.view;

import android.content.Context;

public interface InteractibleView {
    Context getContext();

    void onError(Throwable th);
}
