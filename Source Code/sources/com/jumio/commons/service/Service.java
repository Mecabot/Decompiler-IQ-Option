package com.jumio.commons.service;

import android.content.Context;

public interface Service {
    String getName();

    boolean hasContext();

    void setContext(Context context);
}
