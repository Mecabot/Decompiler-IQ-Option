package com.jumio.nv.data.document;

import android.content.Context;
import com.jumio.core.data.Strings;
import com.jumio.nv.data.NVStrings;

public enum NVDocumentType {
    PASSPORT,
    VISA,
    DRIVER_LICENSE,
    IDENTITY_CARD;

    public static NVDocumentType fromString(String str) {
        if (str.equals("DRIVING_LICENSE") || str.equals("DRIVER_LICENSE")) {
            return DRIVER_LICENSE;
        }
        if (str.equals("ID_CARD")) {
            return IDENTITY_CARD;
        }
        if (str.equals("PASSPORT")) {
            return PASSPORT;
        }
        if (str.equals("VISA")) {
            return VISA;
        }
        return null;
    }

    public String toString() {
        String str = "";
        switch (this) {
            case PASSPORT:
                return "PASSPORT";
            case VISA:
                return "VISA";
            case DRIVER_LICENSE:
                return "DRIVING_LICENSE";
            case IDENTITY_CARD:
                return "ID_CARD";
            default:
                return str;
        }
    }

    public String getLocalizedName(Context context) {
        String str = "";
        switch (this) {
            case PASSPORT:
                str = NVStrings.DOCUMENTTYPE_PASSPORT;
                break;
            case VISA:
                str = NVStrings.DOCUMENTTYPE_VISA;
                break;
            case DRIVER_LICENSE:
                str = NVStrings.DOCUMENTTYPE_DRIVERLICENSE;
                break;
            case IDENTITY_CARD:
                str = NVStrings.DOCUMENTTYPE_IDCARD;
                break;
        }
        return Strings.getExternalString(context, str);
    }
}
