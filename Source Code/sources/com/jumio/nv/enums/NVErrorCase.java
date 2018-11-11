package com.jumio.nv.enums;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.jumio.core.data.Strings;
import com.jumio.nv.data.NVStrings;
import com.jumio.sdk.exception.JumioErrorCase;

public enum NVErrorCase implements JumioErrorCase {
    REQUEST_SETTINGS_FAILED(100, "error_network_problems", true),
    REQUEST_INITIATE_FAILED(110, "error_network_problems", true),
    REQUEST_ADD_PART_FAILED(130, "error_network_problems", true),
    REQUEST_DATA_FAILED(140, "error_network_problems", true),
    REQUEST_EXTRACT_DATA_FAILED(150, "error_network_problems", true),
    REQUEST_FINALIZE_FAILED(160, "error_network_problems", true),
    CERTIFICATE_ERROR(200, "error_auth_failed", false),
    AUTH_FAILED(210, "error_auth_failed", false),
    INVALID_CREDENTIALS(220, "error_auth_failed", false),
    DEVICE_IS_OFFLINE(230, "error_device_is_offline", true),
    OCR_LOADING_FAILED(240, "error_startup_error", false),
    GOOGLE_VISION_LOADING_FAILED(241, "error_startup_error", false),
    CANCEL_TYPE_USER(Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "error_cancelled_by_user", false),
    NO_CAMERA_CONNECTION(260, "error_no_camera_connection", false),
    ALE_KEY_NOT_VALID(280, "error_certificate_not_valid_anymore", false),
    TRANSACTION_FINISHED(290, NVStrings.ERROR_TRANSACTION_ALREADY_FINISHED, false),
    ADDRESS_MISSING(400, NVStrings.HELPVIEW_DESCRIPTION_USDL_FALLBACK, true),
    NO_FACE_ON_BACK(410, NVStrings.HELPVIEW_DESCRIPTION_FACE_ON_BACK, true);
    
    protected int code;
    protected String message;
    protected boolean retry;

    private NVErrorCase(int i, String str, boolean z) {
        this.code = i;
        this.message = str;
        this.retry = z;
    }

    public static NVErrorCase fromCode(int i) {
        switch (i) {
            case 100:
                return REQUEST_SETTINGS_FAILED;
            case 110:
                return REQUEST_INITIATE_FAILED;
            case 130:
                return REQUEST_ADD_PART_FAILED;
            case 140:
                return REQUEST_DATA_FAILED;
            case 150:
                return REQUEST_EXTRACT_DATA_FAILED;
            case 160:
                return REQUEST_FINALIZE_FAILED;
            case 200:
                return CERTIFICATE_ERROR;
            case 210:
                return AUTH_FAILED;
            case 220:
                return INVALID_CREDENTIALS;
            case 230:
                return DEVICE_IS_OFFLINE;
            case 240:
                return OCR_LOADING_FAILED;
            case Callback.DEFAULT_SWIPE_ANIMATION_DURATION /*250*/:
                return CANCEL_TYPE_USER;
            case 260:
                return NO_CAMERA_CONNECTION;
            case 280:
                return ALE_KEY_NOT_VALID;
            case 290:
                return TRANSACTION_FINISHED;
            default:
                return null;
        }
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public String localizedMessage(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Strings.getExternalString(context, this.message));
        stringBuilder.append(" (");
        stringBuilder.append(this.code);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean retry() {
        return this.retry;
    }
}
