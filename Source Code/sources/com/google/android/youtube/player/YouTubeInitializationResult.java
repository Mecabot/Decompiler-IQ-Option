package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.b;
import com.google.android.youtube.player.internal.o;
import com.google.android.youtube.player.internal.z;

public enum YouTubeInitializationResult {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    private static final class a implements OnClickListener {
        private final Intent KV;
        private final Activity a;
        private final int c;

        public a(Activity activity, Intent intent, int i) {
            this.a = (Activity) b.u(activity);
            this.KV = (Intent) b.u(intent);
            this.c = ((Integer) b.u(Integer.valueOf(i))).intValue();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.a.startActivityForResult(this.KV, this.c);
                dialogInterface.dismiss();
            } catch (Throwable e) {
                z.b("Can't perform resolution for YouTubeInitalizationError", e);
            }
        }
    }

    public final Dialog getErrorDialog(Activity activity, int i) {
        return getErrorDialog(activity, i, null);
    }

    public final Dialog getErrorDialog(Activity activity, int i, OnCancelListener onCancelListener) {
        Intent cE;
        Builder message;
        CharSequence charSequence;
        Builder builder = new Builder(activity);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                cE = aa.cE(aa.at(activity));
                break;
            case SERVICE_DISABLED:
                cE = aa.cD(aa.at(activity));
                break;
            default:
                cE = null;
                break;
        }
        OnClickListener aVar = new a(activity, cE, i);
        o oVar = new o(activity);
        switch (this) {
            case SERVICE_MISSING:
                message = builder.setTitle(oVar.b).setMessage(oVar.c);
                charSequence = oVar.d;
                break;
            case SERVICE_DISABLED:
                message = builder.setTitle(oVar.e).setMessage(oVar.f);
                charSequence = oVar.g;
                break;
            case SERVICE_VERSION_UPDATE_REQUIRED:
                message = builder.setTitle(oVar.h).setMessage(oVar.i);
                charSequence = oVar.j;
                break;
            default:
                String str = "Unexpected errorReason: ";
                String valueOf = String.valueOf(name());
                throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        return message.setPositiveButton(charSequence, aVar).create();
    }

    public final boolean isUserRecoverableError() {
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_DISABLED:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return true;
            default:
                return false;
        }
    }
}
