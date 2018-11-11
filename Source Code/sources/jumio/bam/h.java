package jumio.bam;

import com.jumio.core.data.Strings;
import com.jumio.core.data.Strings.SDKStringFactory;

/* compiled from: NSStrings */
public class h extends Strings {

    /* compiled from: NSStrings */
    public static class a implements SDKStringFactory {
        public Strings createInstance() {
            return new h();
        }
    }

    public h() {
        this.mPrefix = "bam_";
        this.stringProvider.put("activity_title_scan", "Scan card");
        this.stringProvider.put("activity_title_additional_info", "Additional info");
        this.stringProvider.put("error_view_button_try_again", "Try again");
        this.stringProvider.put("error_view_button_cancel", "Cancel");
        this.stringProvider.put("error_view_message_credit_card_not_supported", "Your card type is not accepted");
        this.stringProvider.put("error_view_message_credit_card_expired", "Your card is expired");
        this.stringProvider.put("error_view_message_auth_failed", "Authentication failed");
        this.stringProvider.put("error_view_message_startup_error", "Scanning not available at this time, please contact the app vendor");
        this.stringProvider.put("error_view_message_cancelled_by_user", "Cancelled by end-user");
        this.stringProvider.put("error_view_message_background_execution_not_supported", "Background execution not supported");
        this.stringProvider.put("error_view_message_no_camera_connection", "The camera is currently not available");
        this.stringProvider.put("error_view_message_certificate_not_valid_anymore", "Certificate not valid anymore. Please update your application.");
        this.stringProvider.put("scan_area_present_your_card_number", "PRESENT YOUR CARD NUMBER");
        this.stringProvider.put("scan_area_card_holder", "");
        this.stringProvider.put("scan_area_creditcard_number", "1234 5678 9123 4567");
        this.stringProvider.put("scan_area_valid_thru", "");
        this.stringProvider.put("scan_area_expiry_date", "");
        this.stringProvider.put("manual_entry_cvv", "CVV");
        this.stringProvider.put("manual_entry_cvc", "CVC");
        this.stringProvider.put("manual_entry_cid", "CID");
        this.stringProvider.put("manual_entry_cav", "CAV");
        this.stringProvider.put("manual_entry_cardholder_name", "Card holder name");
        this.stringProvider.put("manual_entry_hint_month", "MM");
        this.stringProvider.put("manual_entry_hint_year", "YY");
        this.stringProvider.put("manual_entry_valid_through", "Expiration date");
    }
}
