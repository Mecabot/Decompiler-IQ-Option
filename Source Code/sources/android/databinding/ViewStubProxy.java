package android.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;

public class ViewStubProxy {
    private ViewDataBinding mContainingBinding;
    private OnInflateListener mOnInflateListener;
    private OnInflateListener mProxyListener = new OnInflateListener() {
        public void onInflate(ViewStub viewStub, View view) {
            ViewStubProxy.this.mRoot = view;
            ViewStubProxy.this.mViewDataBinding = DataBindingUtil.bind(ViewStubProxy.this.mContainingBinding.mBindingComponent, view, viewStub.getLayoutResource());
            ViewStubProxy.this.mViewStub = null;
            if (ViewStubProxy.this.mOnInflateListener != null) {
                ViewStubProxy.this.mOnInflateListener.onInflate(viewStub, view);
                ViewStubProxy.this.mOnInflateListener = null;
            }
            ViewStubProxy.this.mContainingBinding.invalidateAll();
            ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
        }
    };
    private View mRoot;
    private ViewDataBinding mViewDataBinding;
    private ViewStub mViewStub;

    public ViewStubProxy(@NonNull ViewStub viewStub) {
        this.mViewStub = viewStub;
        this.mViewStub.setOnInflateListener(this.mProxyListener);
    }

    public void setContainingBinding(@NonNull ViewDataBinding viewDataBinding) {
        this.mContainingBinding = viewDataBinding;
    }

    public boolean isInflated() {
        return this.mRoot != null;
    }

    public View getRoot() {
        return this.mRoot;
    }

    @Nullable
    public ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    @Nullable
    public ViewStub getViewStub() {
        return this.mViewStub;
    }

    public void setOnInflateListener(@Nullable OnInflateListener onInflateListener) {
        if (this.mViewStub != null) {
            this.mOnInflateListener = onInflateListener;
        }
    }
}
