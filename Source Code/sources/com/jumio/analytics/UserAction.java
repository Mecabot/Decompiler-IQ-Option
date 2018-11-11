package com.jumio.analytics;

public enum UserAction {
    CHOOSE_OTHER_COUNTRY_SELECTED("ChooseOtherCountrySelected"),
    COUNTRY_SELECTED("CountrySelected"),
    SCAN_OPTIONS_COMPLETED("ScanOptionsCompleted"),
    SEARCH_STARTED("SearchStarted"),
    SCAN_TRIGGERED("ScanTriggered"),
    REFOCUS("Refocus"),
    HELP_SELECTED("HelpSelected"),
    FLASH("Flash"),
    CAMERA("Camera"),
    ORIENTATION_CHANGED("OrientationChanged"),
    FALLBACK("Fallback"),
    CONFIRM("Confirm"),
    BACK("Back"),
    RETRY("Retry"),
    CANCEL("Cancel"),
    CLOSE("Close"),
    NFC_NO_EMRTD("NFCNoEMRTD"),
    NFC_EXTRACTION_STARTED("NFCExtractionStarted"),
    EYE_TRACKING_STARTED("EyeTrackingStarted"),
    EYE_TRACKING_OUT_OF_BOUNDS("EyeTrackingOutOfBounds"),
    EYE_TRACKING_FACE_NOT_DETECTED("EyeTrackingFaceNotDetected"),
    EYE_TRACKING_EYES_CLOSED("EyeTrackingEyesClosed");
    
    private final String value;

    private UserAction(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
