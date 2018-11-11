package com.jumio.core.mvp.view;

import android.app.Fragment;
import android.os.Bundle;
import com.jumio.core.mvp.PresenterFactory;
import com.jumio.core.mvp.presenter.Presentable;
import com.jumio.core.mvp.presenter.Presenter;

public abstract class MvpFragment<P extends Presenter> extends Fragment implements Presentable<P> {
    private P mPresenter;

    public P getPresenter() {
        if (this.mPresenter == null) {
            this.mPresenter = PresenterFactory.createClass(getClass());
        }
        return this.mPresenter;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getPresenter().attachView(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detachView();
    }

    public void onResume() {
        super.onResume();
        getPresenter().activate();
    }

    public void onPause() {
        super.onPause();
        getPresenter().deactivate();
    }
}
