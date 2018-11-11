package com.jumio.dv.a;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.jumio.core.data.Strings;
import com.jumio.sdk.exception.JumioErrorCase;

/* compiled from: DvErrorCase */
public enum a implements JumioErrorCase {
    REQUEST_COMPLETE_FAILED(100, "error_network_problems", true),
    CERTIFICATE_ERROR(200, "error_auth_failed", false),
    AUTH_FAILED(210, "error_auth_failed", false),
    INVALID_CREDENTIALS(220, "error_auth_failed", false),
    DEVICE_IS_OFFLINE(230, "error_device_is_offline", true),
    OCR_LOADING_FAILED(240, "error_startup_error", false),
    CANCEL_TYPE_USER(Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "error_cancelled_by_user", false),
    NO_CAMERA_CONNECTION(260, "error_no_camera_connection", false),
    ALE_KEY_NOT_VALID(280, "error_certificate_not_valid_anymore", false);
    
    protected int j;
    protected String k;
    protected boolean l;

    private a(int i, String str, boolean z) {
        this.j = i;
        this.k = str;
        this.l = z;
    }

    public int code() {
        return this.j;
    }

    public String message() {
        return this.k;
    }

    public String localizedMessage(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Strings.getExternalString(context, this.k));
        stringBuilder.append(" (");
        stringBuilder.append(this.j);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean retry() {
        return this.l;
    }
}
