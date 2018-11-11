package com.jumio.core.exceptions;

import java.util.Arrays;

public class MissingPermissionException extends Exception {
    private String[] mPermissions;

    public MissingPermissionException(String[] strArr) {
        super(createMessage(strArr));
        this.mPermissions = (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public MissingPermissionException(String str) {
        this(new String[]{str});
        this.mPermissions = new String[]{str};
    }

    private static String createMessage(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder("On devices running Android Marshmallow (6.0) you need to acquire the following permissions dynamically before starting the SDK: ");
        for (String append : strArr) {
            stringBuilder.append(append);
            stringBuilder.append("\n");
        }
        stringBuilder.append("On any other API level permissions must be declared in the AndroidManifest. More information about that can be found here: https://developer.android.com/training/permissions/requesting.html");
        return stringBuilder.toString();
    }

    public String[] getPermissions() {
        return this.mPermissions;
    }
}
