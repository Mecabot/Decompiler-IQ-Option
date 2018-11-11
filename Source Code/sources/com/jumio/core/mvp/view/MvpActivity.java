package com.jumio.core.mvp.view;

import android.support.v7.app.AppCompatActivity;
import com.jumio.core.mvp.PresenterFactory;
import com.jumio.core.mvp.presenter.Presentable;
import com.jumio.core.mvp.presenter.Presenter;

public abstract class MvpActivity<P extends Presenter> extends AppCompatActivity implements Presentable<P> {
    private P mPresenter;

    public P getPresenter() {
        if (this.mPresenter == null) {
            this.mPresenter = PresenterFactory.createClass(getClass());
        }
        return this.mPresenter;
    }

    protected void onResume() {
        super.onResume();
        getPresenter().attachView(this);
    }

    protected void onPause() {
        super.onPause();
        getPresenter().detachView();
    }
}
