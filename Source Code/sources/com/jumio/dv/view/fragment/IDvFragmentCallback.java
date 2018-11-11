package com.jumio.dv.view.fragment;

import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.sdk.view.fragment.IBaseFragmentCallback;

public interface IDvFragmentCallback extends IBaseFragmentCallback<IDvActivityCallback> {
    void animateActionbar(boolean z);

    DeviceRotationManager getRotationManager();
}
