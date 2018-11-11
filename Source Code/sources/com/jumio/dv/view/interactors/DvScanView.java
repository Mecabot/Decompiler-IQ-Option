package com.jumio.dv.view.interactors;

import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.sdk.view.interactors.BaseScanView;

public interface DvScanView extends BaseScanView {

    public enum GuiState {
        SCAN,
        CONFIRMATION,
        LOADING
    }

    public enum HelpViewStyle {
        NONE,
        MICRO,
        MINI,
        SMALL
    }

    void extractionStarted();

    void hideHelp();

    void scansComplete();

    void showConfirmation(String str, boolean z);

    void showHelp(String str, HelpViewStyle helpViewStyle, String str2, boolean z);

    void showLoading();

    void updateUiAutomationScanId(PluginMode pluginMode);
}
