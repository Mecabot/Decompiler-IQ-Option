package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.a.d;
import com.facebook.common.a.e;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.b;
import com.facebook.login.LoginClient.c;

/* compiled from: LoginFragment */
public class h extends Fragment {
    private c Gt;
    private String Gu;
    private LoginClient Gv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.Gv = (LoginClient) bundle.getParcelable("loginClient");
            this.Gv.setFragment(this);
        } else {
            this.Gv = nz();
        }
        this.Gv.a(new b() {
            public void e(Result result) {
                h.this.f(result);
            }
        });
        Activity activity = zzakw();
        if (activity != null) {
            k(activity);
            Intent intent = activity.getIntent();
            if (intent != null) {
                bundle = intent.getBundleExtra("com.facebook.LoginFragment:Request");
                if (bundle != null) {
                    this.Gt = (c) bundle.getParcelable("request");
                }
            }
        }
    }

    protected LoginClient nz() {
        return new LoginClient((Fragment) this);
    }

    public void onDestroy() {
        this.Gv.nf();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.com_facebook_login_fragment, viewGroup, false);
        final View findViewById = inflate.findViewById(d.com_facebook_login_fragment_progress_bar);
        this.Gv.a(new a() {
            public void np() {
                findViewById.setVisibility(0);
            }

            public void nq() {
                findViewById.setVisibility(8);
            }
        });
        return inflate;
    }

    private void f(Result result) {
        this.Gt = null;
        int i = result.Gq == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            zzakw().setResult(i, intent);
            zzakw().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.Gu == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            zzakw().finish();
            return;
        }
        this.Gv.d(this.Gt);
    }

    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(d.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.Gv.onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.Gv);
    }

    private void k(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.Gu = callingActivity.getPackageName();
        }
    }

    LoginClient nA() {
        return this.Gv;
    }
}
