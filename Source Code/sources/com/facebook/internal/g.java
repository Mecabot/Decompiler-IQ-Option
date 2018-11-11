package com.facebook.internal;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.h;
import com.facebook.internal.y.a;
import com.facebook.internal.y.c;
import com.google.android.gms.plus.PlusShare;

/* compiled from: FacebookDialogFragment */
public class g extends DialogFragment {
    private Dialog Cl;

    public void a(Dialog dialog) {
        this.Cl = dialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.Cl == null) {
            Dialog c;
            Context activity = zzakw();
            Bundle g = s.g(activity.getIntent());
            if (g.getBoolean("is_fallback", false)) {
                String string = g.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (w.bc(string)) {
                    w.E("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                c = j.c(activity, string, String.format("fb%s://bridge/", new Object[]{h.it()}));
                c.a(new c() {
                    public void b(Bundle bundle, FacebookException facebookException) {
                        g.this.h(bundle);
                    }
                });
            } else {
                String string2 = g.getString("action");
                g = g.getBundle("params");
                if (w.bc(string2)) {
                    w.E("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                c = new a(activity, string2, g).b(new c() {
                    public void b(Bundle bundle, FacebookException facebookException) {
                        g.this.a(bundle, facebookException);
                    }
                }).mJ();
            }
            this.Cl = c;
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.Cl == null) {
            a(null, null);
            setShowsDialog(false);
        }
        return this.Cl;
    }

    public void onResume() {
        super.onResume();
        if (this.Cl instanceof y) {
            ((y) this.Cl).resize();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.Cl instanceof y) && isResumed()) {
            ((y) this.Cl).resize();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private void a(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = zzakw();
        activity.setResult(facebookException == null ? -1 : 0, s.a(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    private void h(Bundle bundle) {
        FragmentActivity activity = zzakw();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
