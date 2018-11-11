package com.jumio.analytics;

public enum Screen {
    COUNTRY_LIST("CountryList"),
    SCAN("Scan"),
    CONFIRMATION("Confirmation"),
    SUBMISSION("Submission"),
    ERROR("Error"),
    SCAN_OPTIONS("ScanOptions"),
    HELP("Help");
    
    private final String value;

    private Screen(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
