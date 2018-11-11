package com.jumio.dv.view.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.sdk.view.fragment.BaseFragment;

public abstract class DvBaseFragment<P extends Presenter> extends BaseFragment<P, IDvFragmentCallback> {
    public abstract void handleOrientationChange(boolean z, boolean z2);

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean z = ((IDvFragmentCallback) this.callback).getRotationManager().isScreenPortrait() || ((IDvFragmentCallback) this.callback).getRotationManager().isTablet();
        handleOrientationChange(z, false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = configuration.orientation == 1 || ((IDvFragmentCallback) this.callback).getRotationManager().isTablet();
        handleOrientationChange(z, true);
    }
}
