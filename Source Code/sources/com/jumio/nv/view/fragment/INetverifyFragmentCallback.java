package com.jumio.nv.view.fragment;

import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.nv.extraction.NfcController;
import com.jumio.sdk.view.fragment.IBaseFragmentCallback;

public interface INetverifyFragmentCallback extends IBaseFragmentCallback<INetverifyActivityCallback> {
    void animateActionbar(boolean z, boolean z2);

    NfcController getNfcController();

    DeviceRotationManager getRotationManager();
}
