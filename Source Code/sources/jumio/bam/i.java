package jumio.bam;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.jumio.core.data.Strings;
import com.jumio.sdk.exception.JumioErrorCase;

/* compiled from: NSErrorCase */
public enum i implements JumioErrorCase {
    CREDIT_CARD_NOT_SUPPORTED(300, "error_view_message_credit_card_not_supported", true),
    CANCEL_TYPE_BACKGROUND(310, "error_view_message_background_execution_not_supported", false),
    CREDIT_CARD_EXPIRED(320, "error_view_message_credit_card_expired", true),
    CERTIFICATE_ERROR(200, "error_view_message_auth_failed", false),
    AUTH_FAILED(210, "error_view_message_auth_failed", false),
    INVALID_CREDENTIALS(220, "error_view_message_auth_failed", false),
    OCR_LOADING_FAILED(240, "error_view_message_startup_error", false),
    CANCEL_TYPE_USER(Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "error_view_message_cancelled_by_user", false),
    NO_CAMERA_CONNECTION(260, "error_view_message_no_camera_connection", false),
    ALE_KEY_NOT_VALID(280, "error_view_message_certificate_not_valid_anymore", false),
    CARD_NOT_DETECTED(0, "", true);
    
    private int l;
    private String m;
    private boolean n;

    private i(int i, String str, boolean z) {
        this.l = i;
        this.m = str;
        this.n = z;
    }

    public int code() {
        return this.l;
    }

    public String message() {
        return this.m;
    }

    public String localizedMessage(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Strings.getExternalString(context, this.m));
        stringBuilder.append(" (");
        stringBuilder.append(this.l);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean retry() {
        return this.n;
    }
}
