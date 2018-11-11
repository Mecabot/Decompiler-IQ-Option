package com.facebook.share.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.common.a.d;
import com.facebook.common.a.e;
import com.facebook.common.a.f;
import com.facebook.common.a.g;
import com.facebook.i;
import com.facebook.i.b;
import com.facebook.internal.x;
import com.facebook.l;
import com.facebook.share.a.c;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceShareDialogFragment */
public class a extends DialogFragment {
    private static ScheduledThreadPoolExecutor zk;
    private Dialog Cl;
    private TextView Fx;
    private ProgressBar Hw;
    private volatile a Hx;
    private volatile ScheduledFuture Hy;
    private com.facebook.share.a.a Hz;

    /* compiled from: DeviceShareDialogFragment */
    private static class a implements Parcelable {
        public static final Creator<a> CREATOR = new Creator<a>() {
            /* renamed from: r */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* renamed from: ad */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        private String FT;
        private long HB;

        public int describeContents() {
            return 0;
        }

        a() {
        }

        public String mX() {
            return this.FT;
        }

        public void bS(String str) {
            this.FT = str;
        }

        public long nR() {
            return this.HB;
        }

        public void w(long j) {
            this.HB = j;
        }

        protected a(Parcel parcel) {
            this.FT = parcel.readString();
            this.HB = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.FT);
            parcel.writeLong(this.HB);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null) {
            a aVar = (a) bundle.getParcelable("request_state");
            if (aVar != null) {
                a(aVar);
            }
        }
        return onCreateView;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.Cl = new Dialog(zzakw(), g.com_facebook_auth_dialog);
        View inflate = zzakw().getLayoutInflater().inflate(e.com_facebook_device_auth_dialog_fragment, null);
        this.Hw = (ProgressBar) inflate.findViewById(d.progress_bar);
        this.Fx = (TextView) inflate.findViewById(d.confirmation_code);
        ((Button) inflate.findViewById(d.cancel_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.Cl.dismiss();
            }
        });
        ((TextView) inflate.findViewById(d.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(f.com_facebook_device_auth_instructions)));
        this.Cl.setContentView(inflate);
        nQ();
        return this.Cl;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.Hy != null) {
            this.Hy.cancel(true);
        }
        c(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.Hx != null) {
            bundle.putParcelable("request_state", this.Hx);
        }
    }

    private void c(int i, Intent intent) {
        if (this.Hx != null) {
            com.facebook.a.a.a.bz(this.Hx.mX());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.getErrorMessage(), 0).show();
        }
        if (isAdded()) {
            Activity activity = zzakw();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    private void detach() {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    public void a(com.facebook.share.a.a aVar) {
        this.Hz = aVar;
    }

    private Bundle nP() {
        com.facebook.share.a.a aVar = this.Hz;
        if (aVar == null) {
            return null;
        }
        if (aVar instanceof c) {
            return j.a((c) aVar);
        }
        if (aVar instanceof com.facebook.share.a.g) {
            return j.b((com.facebook.share.a.g) aVar);
        }
        return null;
    }

    private void nQ() {
        Bundle nP = nP();
        if (nP == null || nP.size() == 0) {
            a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x.mD());
        stringBuilder.append("|");
        stringBuilder.append(x.mE());
        nP.putString("access_token", stringBuilder.toString());
        nP.putString("device_info", com.facebook.a.a.a.lt());
        new i(null, "device/share", nP, HttpMethod.POST, new b() {
            public void a(l lVar) {
                FacebookRequestError jJ = lVar.jJ();
                if (jJ != null) {
                    a.this.a(jJ);
                    return;
                }
                JSONObject jK = lVar.jK();
                a aVar = new a();
                try {
                    aVar.bS(jK.getString("user_code"));
                    aVar.w(jK.getLong("expires_in"));
                    a.this.a(aVar);
                } catch (JSONException unused) {
                    a.this.a(new FacebookRequestError(0, "", "Malformed server response"));
                }
            }
        }).jr();
    }

    private void a(FacebookRequestError facebookRequestError) {
        detach();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        c(-1, intent);
    }

    private static synchronized ScheduledThreadPoolExecutor nb() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (a.class) {
            if (zk == null) {
                zk = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = zk;
        }
        return scheduledThreadPoolExecutor;
    }

    private void a(a aVar) {
        this.Hx = aVar;
        this.Fx.setText(aVar.mX());
        this.Fx.setVisibility(0);
        this.Hw.setVisibility(8);
        this.Hy = nb().schedule(new Runnable() {
            public void run() {
                a.this.Cl.dismiss();
            }
        }, aVar.nR(), TimeUnit.SECONDS);
    }
}
