package com.microblink.view;

/* compiled from: line */
public enum NotSupportedReason {
    UNSUPPORTED_ANDROID_VERSION("Current Android version is not supported. SDK requires newer version of Android."),
    NO_CAMERA("Device does not have camera."),
    NO_AUTOFOCUS_CAMERA("Selected recognizer configuration requires camera with autofocus and selected camera does not support it."),
    BLACKLISTED_DEVICE("Device is blacklisted."),
    INVALID_LICENSE_KEY("License key entered is invalid for current recognizer configuration."),
    CUSTOM_UI_FORBIDDEN("Entered license key does not allow using SDK outside of default provided activities."),
    UNSUPPORTED_PROCESSOR_ARCHITECTURE("Device CPU has incompatible architecture.");
    
    private String lllllIlIll;

    private NotSupportedReason(String str) {
        this.lllllIlIll = str;
    }

    public final String getDescription() {
        return this.lllllIlIll;
    }
}
