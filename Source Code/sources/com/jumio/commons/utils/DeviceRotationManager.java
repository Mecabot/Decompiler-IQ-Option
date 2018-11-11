package com.jumio.commons.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.enums.ScreenAngle;

public class DeviceRotationManager {
    private Activity mActivity;
    private ScreenAngle mAngle;
    private int mDefaultOrientation;
    private boolean mIsTablet;
    private int mManifestOrientation;
    private Rotation mRotation;

    /* JADX WARNING: Missing block: B:40:0x00b6, code:
            if (r8.mDefaultOrientation == 2) goto L_0x00b8;
     */
    /* JADX WARNING: Missing block: B:41:0x00b8, code:
            r2 = 1;
     */
    /* JADX WARNING: Missing block: B:42:0x00ba, code:
            r2 = 8;
     */
    /* JADX WARNING: Missing block: B:46:0x00c3, code:
            if (r8.mDefaultOrientation == 2) goto L_0x00ba;
     */
    /* JADX WARNING: Missing block: B:51:0x00cf, code:
            if (r8.mDefaultOrientation == 2) goto L_0x00c6;
     */
    /* JADX WARNING: Missing block: B:55:0x00d8, code:
            if (r8.mDefaultOrientation == 2) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:56:0x00da, code:
            r8.mManifestOrientation = r2;
     */
    public DeviceRotationManager(android.app.Activity r9, com.jumio.commons.enums.Rotation r10) {
        /*
        r8 = this;
        r8.<init>();
        r8.mActivity = r9;
        r8.mRotation = r10;
        r10 = isTabletDevice(r9);
        r8.mIsTablet = r10;
        r10 = r8.getDeviceDefaultOrientation(r9);
        r8.mDefaultOrientation = r10;
        r10 = com.jumio.commons.enums.Rotation.NONE;
        r10 = r8.isRotation(r10);
        r0 = 1;
        r1 = 2;
        r2 = 0;
        if (r10 == 0) goto L_0x0030;
    L_0x001e:
        r10 = r8.mActivity;
        r3 = r8.mIsTablet;
        if (r3 == 0) goto L_0x002c;
    L_0x0024:
        r3 = r8.getDefaultOrientation();
        if (r3 != r1) goto L_0x002c;
    L_0x002a:
        r3 = 0;
        goto L_0x002d;
    L_0x002c:
        r3 = 1;
    L_0x002d:
        r10.setRequestedOrientation(r3);
    L_0x0030:
        r10 = r8.getScreenOrientation();
        r8.mAngle = r10;
        r10 = -1;
        r3 = r9.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0048 }
        r9 = r9.getComponentName();	 Catch:{ NameNotFoundException -> 0x0048 }
        r9 = r3.getActivityInfo(r9, r2);	 Catch:{ NameNotFoundException -> 0x0048 }
        r9 = r9.screenOrientation;	 Catch:{ NameNotFoundException -> 0x0048 }
        r8.mManifestOrientation = r9;	 Catch:{ NameNotFoundException -> 0x0048 }
        goto L_0x004a;
    L_0x0048:
        r8.mManifestOrientation = r10;
    L_0x004a:
        r9 = r8.mManifestOrientation;
        r3 = 3;
        r4 = 4;
        if (r9 == r3) goto L_0x00e7;
    L_0x0050:
        r9 = r8.mManifestOrientation;
        r3 = 10;
        if (r9 != r3) goto L_0x0058;
    L_0x0056:
        goto L_0x00e7;
    L_0x0058:
        r9 = r8.mManifestOrientation;
        r5 = 11;
        r6 = 6;
        if (r9 != r5) goto L_0x0063;
    L_0x005f:
        r8.mManifestOrientation = r6;
        goto L_0x00e9;
    L_0x0063:
        r9 = r8.mManifestOrientation;
        r5 = 12;
        r7 = 7;
        if (r9 != r5) goto L_0x006e;
    L_0x006a:
        r8.mManifestOrientation = r7;
        goto L_0x00e9;
    L_0x006e:
        r9 = r8.mManifestOrientation;
        if (r9 == r10) goto L_0x0087;
    L_0x0072:
        r9 = r8.mManifestOrientation;
        if (r9 != r1) goto L_0x0077;
    L_0x0076:
        goto L_0x0087;
    L_0x0077:
        r9 = r8.mManifestOrientation;
        if (r9 != r7) goto L_0x007f;
    L_0x007b:
        r8.mManifestOrientation = r0;
        goto L_0x00e9;
    L_0x007f:
        r9 = r8.mManifestOrientation;
        if (r9 != r6) goto L_0x00e9;
    L_0x0083:
        r8.mManifestOrientation = r2;
        goto L_0x00e9;
    L_0x0087:
        r9 = r8.mActivity;
        r9 = r9.getContentResolver();
        r10 = "accelerometer_rotation";
        r9 = android.provider.Settings.System.getInt(r9, r10, r2);
        if (r9 != 0) goto L_0x00dd;
    L_0x0095:
        r9 = r8.mActivity;
        r10 = "window";
        r9 = r9.getSystemService(r10);
        r9 = (android.view.WindowManager) r9;
        r9 = r9.getDefaultDisplay();
        r9 = r9.getRotation();
        r10 = 9;
        r3 = 8;
        switch(r9) {
            case 0: goto L_0x00d2;
            case 1: goto L_0x00c9;
            case 2: goto L_0x00bd;
            case 3: goto L_0x00b0;
            default: goto L_0x00af;
        };
    L_0x00af:
        goto L_0x00da;
    L_0x00b0:
        r9 = r8.mIsTablet;
        if (r9 == 0) goto L_0x00ba;
    L_0x00b4:
        r9 = r8.mDefaultOrientation;
        if (r9 != r1) goto L_0x00ba;
    L_0x00b8:
        r2 = 1;
        goto L_0x00da;
    L_0x00ba:
        r2 = 8;
        goto L_0x00da;
    L_0x00bd:
        r9 = r8.mIsTablet;
        if (r9 == 0) goto L_0x00c6;
    L_0x00c1:
        r9 = r8.mDefaultOrientation;
        if (r9 != r1) goto L_0x00c6;
    L_0x00c5:
        goto L_0x00ba;
    L_0x00c6:
        r2 = 9;
        goto L_0x00da;
    L_0x00c9:
        r9 = r8.mIsTablet;
        if (r9 == 0) goto L_0x00da;
    L_0x00cd:
        r9 = r8.mDefaultOrientation;
        if (r9 != r1) goto L_0x00da;
    L_0x00d1:
        goto L_0x00c6;
    L_0x00d2:
        r9 = r8.mIsTablet;
        if (r9 == 0) goto L_0x00b8;
    L_0x00d6:
        r9 = r8.mDefaultOrientation;
        if (r9 != r1) goto L_0x00b8;
    L_0x00da:
        r8.mManifestOrientation = r2;
        goto L_0x00e9;
    L_0x00dd:
        r9 = r8.mIsTablet;
        if (r9 == 0) goto L_0x00e4;
    L_0x00e1:
        r8.mManifestOrientation = r3;
        goto L_0x00e9;
    L_0x00e4:
        r8.mManifestOrientation = r4;
        goto L_0x00e9;
    L_0x00e7:
        r8.mManifestOrientation = r4;
    L_0x00e9:
        r8.setAngleFromScreen();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.DeviceRotationManager.<init>(android.app.Activity, com.jumio.commons.enums.Rotation):void");
    }

    @SuppressLint({"NewApi"})
    public static boolean isTabletDevice(Context context) {
        Object obj = (VERSION.SDK_INT < 13 ? (context.getResources().getConfiguration().screenLayout & 15) != 4 : context.getResources().getConfiguration().smallestScreenWidthDp < 600) ? null : 1;
        if (obj != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 240 || displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213 || displayMetrics.densityDpi == 320) {
                return true;
            }
        }
        return false;
    }

    private int getDeviceDefaultOrientation(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        Configuration configuration = activity.getResources().getConfiguration();
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) {
            return 2;
        }
        return 1;
    }

    public int getDisplayRotation() {
        return ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public ScreenAngle getScreenOrientation() {
        ScreenAngle screenAngle = ScreenAngle.PORTRAIT;
        switch (((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                return (this.mIsTablet && this.mDefaultOrientation == 2) ? ScreenAngle.LANDSCAPE : ScreenAngle.PORTRAIT;
            case 1:
                return (this.mIsTablet && this.mDefaultOrientation == 2) ? ScreenAngle.INVERTED_PORTRAIT : ScreenAngle.LANDSCAPE;
            case 2:
                return (this.mIsTablet && this.mDefaultOrientation == 2) ? ScreenAngle.INVERTED_LANDSCAPE : ScreenAngle.INVERTED_PORTRAIT;
            case 3:
                return (this.mIsTablet && this.mDefaultOrientation == 2) ? ScreenAngle.PORTRAIT : ScreenAngle.INVERTED_LANDSCAPE;
            default:
                return screenAngle;
        }
    }

    public Rotation getRotation() {
        return this.mRotation;
    }

    public boolean isRotation(Rotation rotation) {
        return this.mRotation.equals(rotation);
    }

    public boolean isTablet() {
        return this.mIsTablet;
    }

    public ScreenAngle getAngle() {
        return this.mAngle;
    }

    public boolean isAngle(ScreenAngle screenAngle) {
        return this.mAngle.equals(screenAngle);
    }

    public void setAngleFromOrientation(int i) {
        if (isTablet() && getDefaultOrientation() == 2) {
            i = ((i - 90) + 360) % 360;
        }
        if ((i > 355 || i < 5) && this.mAngle != ScreenAngle.PORTRAIT) {
            this.mAngle = ScreenAngle.PORTRAIT;
        } else if (i > 85 && i < 95 && this.mAngle != ScreenAngle.INVERTED_LANDSCAPE) {
            this.mAngle = ScreenAngle.INVERTED_LANDSCAPE;
        } else if (i <= 175 || i >= 185 || this.mAngle == ScreenAngle.INVERTED_PORTRAIT) {
            if (i > 265 && i < 275 && this.mAngle != ScreenAngle.LANDSCAPE) {
                this.mAngle = ScreenAngle.LANDSCAPE;
            }
        } else if (isTablet() || this.mManifestOrientation != 4) {
            this.mAngle = ScreenAngle.INVERTED_PORTRAIT;
        }
    }

    public void setAngleFromScreen() {
        this.mAngle = getScreenOrientation();
    }

    public boolean isPortrait() {
        return this.mAngle == ScreenAngle.PORTRAIT || this.mAngle == ScreenAngle.INVERTED_PORTRAIT;
    }

    public boolean isLandscape() {
        return this.mAngle == ScreenAngle.LANDSCAPE || this.mAngle == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isScreenPortrait() {
        ScreenAngle screenOrientation = getScreenOrientation();
        return screenOrientation == ScreenAngle.PORTRAIT || screenOrientation == ScreenAngle.INVERTED_PORTRAIT;
    }

    public boolean isScreenLandscape() {
        ScreenAngle screenOrientation = getScreenOrientation();
        return screenOrientation == ScreenAngle.LANDSCAPE || screenOrientation == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isInverted() {
        return this.mAngle == ScreenAngle.INVERTED_PORTRAIT || this.mAngle == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public void setOrientationFromAngle() {
        if (isRotation(Rotation.NATIVE)) {
            int i = 1;
            if (this.mAngle != ScreenAngle.PORTRAIT) {
                if (this.mAngle == ScreenAngle.INVERTED_PORTRAIT) {
                    if (isTablet()) {
                        i = 9;
                    }
                } else if (this.mAngle == ScreenAngle.LANDSCAPE) {
                    i = 0;
                } else if (this.mAngle == ScreenAngle.INVERTED_LANDSCAPE) {
                    i = 8;
                }
            }
            this.mActivity.setRequestedOrientation(i);
        }
    }

    public void setOrientationFromManifest() {
        this.mActivity.setRequestedOrientation(this.mManifestOrientation);
        setAngleFromScreen();
    }

    public boolean isScreenEqualOrientation() {
        return isAngle(getScreenOrientation());
    }

    public int getDefaultOrientation() {
        return this.mDefaultOrientation;
    }

    public boolean isSensorOrientation() {
        for (int i : new int[]{4, 10, 7, 6}) {
            if (i == this.mManifestOrientation) {
                return true;
            }
        }
        return false;
    }
}
