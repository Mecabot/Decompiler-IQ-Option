package com.jumio.nv.view.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.nv.R;
import com.jumio.sdk.view.fragment.BaseFragment;

public abstract class NVBaseFragment<P extends Presenter> extends BaseFragment<P, INetverifyFragmentCallback> {
    public abstract void handleOrientationChange(boolean z, boolean z2);

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean z = ((INetverifyFragmentCallback) this.callback).getRotationManager().isScreenPortrait() || ((INetverifyFragmentCallback) this.callback).getRotationManager().isTablet();
        handleOrientationChange(z, false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = configuration.orientation == 1 || ((INetverifyFragmentCallback) this.callback).getRotationManager().isTablet();
        handleOrientationChange(z, true);
    }

    protected void setActionbarSubTitle(String str) {
        Activity activity = getActivity();
        if (activity != null) {
            TextView textView = (TextView) activity.findViewById(R.id.toolbar_subtitle);
            if (str != null) {
                textView.setVisibility(0);
                textView.setText(str);
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
