package com.jumio.sdk.exception;

import android.content.Context;

public interface JumioErrorCase {
    int code();

    String localizedMessage(Context context);

    String message();

    boolean retry();
}
