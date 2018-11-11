package com.jumio.sdk.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.core.mvp.view.MvpFragment;
import com.jumio.sdk.view.InteractibleView;

public abstract class BaseFragment<P extends Presenter, FragmentCallback extends IBaseFragmentCallback> extends MvpFragment<P> implements InteractibleView, IBaseActivityCallback {
    protected FragmentCallback callback;
    private String fragmentName;

    public boolean onBackButtonPressed() {
        return false;
    }

    public boolean onHomeButtonPressed() {
        return false;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        attach(context);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        attach(activity);
    }

    protected void attach(Context context) {
        try {
            this.callback = (IBaseFragmentCallback) context;
        } catch (ClassCastException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement IBaseActivityCallback ");
            ClassCastException classCastException = new ClassCastException(stringBuilder.toString());
            classCastException.setStackTrace(e.getStackTrace());
            throw classCastException;
        }
    }

    public Context getContext() {
        if (VERSION.SDK_INT >= 23) {
            return super.getContext();
        }
        return getActivity();
    }

    protected void setStatusBarColor(int i) {
        Activity activity = getActivity();
        if (activity != null && VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(i);
        }
    }

    protected void showActionbar(boolean z) {
        Activity activity = getActivity();
        if (activity != null) {
            if (activity instanceof AppCompatActivity) {
                ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (supportActionBar != null) {
                    if (z) {
                        supportActionBar.show();
                    } else {
                        supportActionBar.hide();
                    }
                }
            } else {
                android.app.ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    if (z) {
                        actionBar.show();
                    } else {
                        actionBar.hide();
                    }
                }
            }
        }
    }

    protected void showHomeIndicator(boolean z) {
        Activity activity = getActivity();
        if (activity != null) {
            if (activity instanceof AppCompatActivity) {
                ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(z);
                }
            } else {
                android.app.ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(z);
                }
            }
        }
    }

    protected void setActionbarTitle(String str) {
        Activity activity = getActivity();
        if (activity != null) {
            CharSequence charSequence = null;
            if (!(str == null || str.length() == 0)) {
                charSequence = new SpannableString(str);
                charSequence.setSpan(new AbsoluteSizeSpan(20, true), 0, charSequence.length(), 33);
            }
            if (activity instanceof AppCompatActivity) {
                ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle(charSequence);
                }
            } else {
                android.app.ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    actionBar.setTitle(charSequence);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fragmentName = getClass().getSimpleName();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
