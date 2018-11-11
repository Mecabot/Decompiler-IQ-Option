package com.jumio;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.log.Log;
import com.jumio.core.exceptions.PlatformNotSupportedException;
import com.jumio.core.util.DeviceUtil;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.util.RootCheck;
import java.util.ArrayList;
import java.util.List;

public abstract class MobileSDK {
    private static int MEGABYTES_IN_BYTES = 1048576;
    private static int MEMORY_WARNING_THRESHOLD_IN_MB = 16;
    private int mCustomThemeId = 0;

    public static String getSDKVersion() {
        return "JMSDK 2.10.0 (0-63)";
    }

    public abstract void start();

    protected static boolean isSupportedPlatform(Context context, boolean z) {
        try {
            return checkSDKRequirements(context, z);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isRooted(Context context) {
        return RootCheck.isRooted(context);
    }

    protected Intent getIntent(Context context, Class cls, CredentialsModel credentialsModel) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(MobileActivity.EXTRA_CREDENTIALS, credentialsModel);
        if (this.mCustomThemeId != 0) {
            intent.putExtra(MobileActivity.EXTRA_CUSTOM_THEME, this.mCustomThemeId);
        }
        return intent;
    }

    public void setCustomTheme(@StyleRes int i) {
        this.mCustomThemeId = i;
    }

    protected static boolean checkSDKRequirements(Context context, boolean z) {
        if (VERSION.SDK_INT < 16) {
            throw new PlatformNotSupportedException("SDK Version 16 required");
        } else if (JumioCameraManager.getNumberOfCameras(context) == 0) {
            throw new PlatformNotSupportedException("No useable camera present");
        } else if (DeviceUtil.isSupportedPlatform(z)) {
            checkMemoryAllocation();
            return true;
        } else {
            throw new PlatformNotSupportedException("ARMv7 CPU Architecture with NEON Intrinsics required");
        }
    }

    protected static void checkMemoryAllocation() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / ((long) MEGABYTES_IN_BYTES);
        long maxMemory = runtime.maxMemory() / ((long) MEGABYTES_IN_BYTES);
        long j = maxMemory - totalMemory;
        if (j < ((long) MEMORY_WARNING_THRESHOLD_IN_MB)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Critical memory warning: Heap situation ");
            stringBuilder.append(totalMemory);
            stringBuilder.append("/");
            stringBuilder.append(maxMemory);
            stringBuilder.append("MB , free ");
            stringBuilder.append(j);
            stringBuilder.append("MB");
            Log.w(stringBuilder.toString());
        }
    }

    @NonNull
    public static String[] getRequiredPermissions() {
        return new String[]{"android.permission.CAMERA"};
    }

    public static boolean hasAllRequiredPermissions(Context context) {
        return hasPermissionsFor(context, getRequiredPermissions());
    }

    public static boolean hasPermissionsFor(Context context, String[] strArr) {
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static String[] getMissingPermissions(Context context) {
        int i = 0;
        if (hasAllRequiredPermissions(context)) {
            return new String[0];
        }
        List arrayList = new ArrayList();
        String[] requiredPermissions = getRequiredPermissions();
        int length = requiredPermissions.length;
        while (i < length) {
            String str = requiredPermissions[i];
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized void destroy() {
        System.gc();
    }
}
