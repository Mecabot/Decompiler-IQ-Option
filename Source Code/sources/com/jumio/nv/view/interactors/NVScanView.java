package com.jumio.nv.view.interactors;

import android.os.Bundle;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.extraction.NfcController;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.view.interactors.BaseScanView;

public interface NVScanView extends BaseScanView {

    public enum GuiState {
        HELP,
        CONFIRMATION,
        LOADING,
        SCAN
    }

    public enum HelpViewStyle {
        NONE,
        MICRO,
        MINI,
        SMALL
    }

    public static class NVHelpConfiguration {
        public NVDocumentType documentType;
        public NVDocumentVariant documentVariant;
        public HelpViewStyle helpViewStyle;
        public DocumentScanMode initialScanMode;
        public boolean isExpandable;
        public boolean isIdBackFaceDetected;
        public boolean isPortrait;
        public boolean isUSDLFallback;
        public int part;
        public DocumentScanMode scanMode;
        public boolean showFallback;
        public boolean showFullscreen;
        public ScanSide side;
        public int totalParts;
    }

    boolean displayOverlay(boolean z);

    void extractionStarted();

    void faceOnBackside();

    CredentialsModel getCredentialsModel();

    int getHelpViewHeight(HelpViewStyle helpViewStyle);

    NfcController getNfcController();

    void hideHelp();

    void noUsAddressFound();

    void partComplete();

    void scansComplete();

    void showConfirmation(String str, boolean z);

    void showHelp(NVHelpConfiguration nVHelpConfiguration, boolean z);

    void showLegalHint(String str);

    void showLoading();

    void showNFC(Bundle bundle);

    void updateUiAutomationScanId(PluginMode pluginMode);
}
