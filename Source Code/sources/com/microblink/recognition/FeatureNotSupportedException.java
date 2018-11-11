package com.microblink.recognition;

import com.microblink.view.NotSupportedReason;

/* compiled from: line */
public class FeatureNotSupportedException extends Exception {
    private NotSupportedReason llIIlIlIIl;

    public FeatureNotSupportedException(NotSupportedReason notSupportedReason) {
        super(notSupportedReason.getDescription());
        this.llIIlIlIIl = notSupportedReason;
    }
}
