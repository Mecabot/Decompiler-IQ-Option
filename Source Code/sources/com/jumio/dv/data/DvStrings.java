package com.jumio.dv.data;

import com.jumio.core.data.Strings;
import com.jumio.core.data.Strings.SDKStringFactory;

public class DvStrings extends Strings {
    public static final String BUTTON_CANCEL = "button_cancel";
    public static final String BUTTON_RETRY = "button_retry";
    public static final String ERROR_AUTH_FAILED = "error_auth_failed";
    public static final String ERROR_CANCELLED_BY_USER = "error_cancelled_by_user";
    public static final String ERROR_CERTIFICATE_NOT_VALID_ANYMORE = "error_certificate_not_valid_anymore";
    public static final String ERROR_DEVICE_IS_OFFLINE = "error_device_is_offline";
    public static final String ERROR_NETWORK_PROBLEMS = "error_network_problems";
    public static final String ERROR_NO_CAMERA_CONNECTION = "error_no_camera_connection";
    public static final String ERROR_STARTUP_ERROR = "error_startup_error";
    public static final String HELPVIEW_HEADER_BANK_STATEMENT = "helpview_header_bank_statement";
    public static final String HELPVIEW_HEADER_BIRTH_CERTIFICATE = "helpview_header_birth_certificate";
    public static final String HELPVIEW_HEADER_CASH_ADVANCE_APPLICATION = "helpview_header_cash_advance_application";
    public static final String HELPVIEW_HEADER_CORPORATE_RESOLUTION_CERTIFICATE = "helpview_header_corporate_resolution_certificate";
    public static final String HELPVIEW_HEADER_COUNCIL_BILL = "helpview_header_council_bill";
    public static final String HELPVIEW_HEADER_CREDIT_CARD = "helpview_header_credit_card";
    public static final String HELPVIEW_HEADER_CREDIT_CARD_STATEMENT = "helpview_header_credit_card_statement";
    public static final String HELPVIEW_HEADER_DOCUMENT = "helpview_header_document";
    public static final String HELPVIEW_HEADER_HEALTH_CARE_CARD = "helpview_header_health_care_card";
    public static final String HELPVIEW_HEADER_INSURANCE_CARD = "helpview_header_insurance_card";
    public static final String HELPVIEW_HEADER_LEASE_AGREEMENT = "helpview_header_lease_agreement";
    public static final String HELPVIEW_HEADER_LOAN_APPLICATION = "helpview_header_loan_application";
    public static final String HELPVIEW_HEADER_MEDICARE_CARD = "helpview_header_medicare_card";
    public static final String HELPVIEW_HEADER_MORTGAGE_APPLICATION = "helpview_header_mortgage_application";
    public static final String HELPVIEW_HEADER_PHONE_BILL = "helpview_header_phone_bill";
    public static final String HELPVIEW_HEADER_SCHOOL_ENROLMENT_LETTER = "helpview_header_school_enrolment_letter";
    public static final String HELPVIEW_HEADER_SENIORS_CARD = "helpview_header_seniors_card";
    public static final String HELPVIEW_HEADER_SOCIAL_SECURITY_CARD = "helpview_header_social_security_card";
    public static final String HELPVIEW_HEADER_STUDENT_CARD = "helpview_header_student_card";
    public static final String HELPVIEW_HEADER_SUPERANNUATION_STATEMENT = "helpview_header_superannuation_statement";
    public static final String HELPVIEW_HEADER_TAX_RETURN = "helpview_header_tax_return";
    public static final String HELPVIEW_HEADER_TRADE_ASSOCIATION_CARD = "helpview_header_trade_association_card";
    public static final String HELPVIEW_HEADER_US_SOCIAL_SECURITY_CARD = "helpview_header_us_social_security_card";
    public static final String HELPVIEW_HEADER_UTILITY_BILL = "helpview_header_utility_bill";
    public static final String HELPVIEW_HEADER_VEHICLE_TITLE = "helpview_header_vehicle_title";
    public static final String HELPVIEW_HEADER_VOIDED_CHECK = "helpview_header_voided_check";
    public static final String HELPVIEW_HEADER_WORKING_WITH_CHILDREN_CHECK = "helpview_header_working_with_children_check";
    public static final String HELPVIEW_SMALL_TITLE_CAPTURE = "helpview_small_title_capture";
    public static final String SCANVIEW_READABLE = "scanview_readable";
    public static final String SCANVIEW_RETAKE = "scanview_retake";
    public static final String SCANVIEW_SNACKBAR_CHECK = "scanview_snackbar_check";
    public static final String SCANVIEW_TITLE = "scanview_title";
    public static final String SCANVIEW_TITLE_CHECK = "scanview_title_check";
    public static final String UPLOAD_ERROR = "upload_error";
    public static final String UPLOAD_ERROR_DESCRIPTION = "upload_error_description";
    public static final String UPLOAD_PROGRESS = "upload_progress";
    public static final String UPLOAD_PROGRESS_DESCRIPTION = "upload_progress_description";
    public static final String UPLOAD_SUCCESSFUL = "upload_successful";

    public static class a implements SDKStringFactory {
        public Strings createInstance() {
            return new DvStrings();
        }
    }

    public DvStrings() {
        this.mPrefix = "dv_";
        this.stringProvider.put("error_network_problems", "We have encountered a network communication problem");
        this.stringProvider.put("error_auth_failed", "Authentication failed");
        this.stringProvider.put("error_device_is_offline", "No internet connection available");
        this.stringProvider.put("error_startup_error", "Scanning not available at this time, please contact the app vendor");
        this.stringProvider.put("error_cancelled_by_user", "Cancelled by end-user");
        this.stringProvider.put("error_no_camera_connection", "The camera is currently not available");
        this.stringProvider.put("error_certificate_not_valid_anymore", "Certificate not valid anymore. Please update your application");
        this.stringProvider.put("button_retry", "Retry");
        this.stringProvider.put("button_cancel", "Cancel");
        this.stringProvider.put("upload_progress", "<b>Uploading</b> your documents");
        this.stringProvider.put("upload_progress_description", "This should only take a couple of seconds, depending on your network connectivity");
        this.stringProvider.put("upload_successful", "<b>Upload successful</b>");
        this.stringProvider.put("upload_error", "<b>Upload issues</b>");
        this.stringProvider.put(UPLOAD_ERROR_DESCRIPTION, "We have encountered a network communication problem");
        this.stringProvider.put("scanview_title", "Scan document");
        this.stringProvider.put("scanview_title_check", "Check readability");
        this.stringProvider.put("scanview_snackbar_check", "Make sure that all data on your document is fully visible, glare free and not blurred");
        this.stringProvider.put("scanview_retake", "RETAKE");
        this.stringProvider.put("scanview_readable", "READABLE");
        this.stringProvider.put("helpview_small_title_capture", "<b>Capture %1$s</b>");
        this.stringProvider.put(HELPVIEW_HEADER_DOCUMENT, "Document");
        this.stringProvider.put(HELPVIEW_HEADER_BANK_STATEMENT, "Bank statement");
        this.stringProvider.put(HELPVIEW_HEADER_CREDIT_CARD, "Credit card");
        this.stringProvider.put(HELPVIEW_HEADER_INSURANCE_CARD, "Insurance card");
        this.stringProvider.put(HELPVIEW_HEADER_UTILITY_BILL, "Utility bill");
        this.stringProvider.put(HELPVIEW_HEADER_CASH_ADVANCE_APPLICATION, "Cash advance application");
        this.stringProvider.put(HELPVIEW_HEADER_CORPORATE_RESOLUTION_CERTIFICATE, "Corporate resolution certificate");
        this.stringProvider.put(HELPVIEW_HEADER_CREDIT_CARD_STATEMENT, "Credit card statement");
        this.stringProvider.put(HELPVIEW_HEADER_LEASE_AGREEMENT, "Lease agreement");
        this.stringProvider.put(HELPVIEW_HEADER_LOAN_APPLICATION, "Loan application");
        this.stringProvider.put(HELPVIEW_HEADER_MORTGAGE_APPLICATION, "Mortgage application");
        this.stringProvider.put(HELPVIEW_HEADER_TAX_RETURN, "Tax return");
        this.stringProvider.put(HELPVIEW_HEADER_VEHICLE_TITLE, "Vehicle title");
        this.stringProvider.put(HELPVIEW_HEADER_VOIDED_CHECK, "Voided check");
        this.stringProvider.put(HELPVIEW_HEADER_STUDENT_CARD, "Student card");
        this.stringProvider.put(HELPVIEW_HEADER_HEALTH_CARE_CARD, "Health care card");
        this.stringProvider.put(HELPVIEW_HEADER_COUNCIL_BILL, "Council bill");
        this.stringProvider.put(HELPVIEW_HEADER_SENIORS_CARD, "Seniors card");
        this.stringProvider.put(HELPVIEW_HEADER_MEDICARE_CARD, "Medicare card");
        this.stringProvider.put(HELPVIEW_HEADER_BIRTH_CERTIFICATE, "Birth certificate");
        this.stringProvider.put(HELPVIEW_HEADER_US_SOCIAL_SECURITY_CARD, "US social security card");
        this.stringProvider.put(HELPVIEW_HEADER_WORKING_WITH_CHILDREN_CHECK, "Working with children check");
        this.stringProvider.put(HELPVIEW_HEADER_SUPERANNUATION_STATEMENT, "Superannuation statement");
        this.stringProvider.put(HELPVIEW_HEADER_TRADE_ASSOCIATION_CARD, "Trade association card");
        this.stringProvider.put(HELPVIEW_HEADER_SCHOOL_ENROLMENT_LETTER, "School enrolment letter");
        this.stringProvider.put(HELPVIEW_HEADER_PHONE_BILL, "Phone bill");
        this.stringProvider.put(HELPVIEW_HEADER_SOCIAL_SECURITY_CARD, "Social security card");
    }
}
