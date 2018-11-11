package com.jumio.sdk.view.interactors;

import android.view.TextureView;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.sdk.view.InteractibleView;

public interface BaseScanView extends InteractibleView {
    DeviceRotationManager getRotationManager();

    TextureView getTextureView();

    void invalidateDrawView(boolean z);

    void resetCameraControls(boolean z, boolean z2);

    void updateBranding(boolean z);

    void updateCameraControls(boolean z, boolean z2);
}
