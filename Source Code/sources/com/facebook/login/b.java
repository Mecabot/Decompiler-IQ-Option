package com.facebook.login;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.common.a.d;
import com.facebook.common.a.e;
import com.facebook.common.a.f;
import com.facebook.common.a.g;
import com.facebook.h;
import com.facebook.i;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.facebook.j;
import com.facebook.l;
import com.facebook.login.LoginClient.c;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: DeviceAuthDialog */
public class b extends DialogFragment {
    private Dialog Cl;
    private AtomicBoolean FA = new AtomicBoolean();
    private volatile j FB;
    private volatile ScheduledFuture FC;
    private volatile a FD;
    private boolean FE = false;
    private boolean FF = false;
    private c FG = null;
    private View Fw;
    private TextView Fx;
    private TextView Fy;
    private c Fz;

    /* compiled from: DeviceAuthDialog */
    private static class a implements Parcelable {
        public static final Creator<a> CREATOR = new Creator<a>() {
            /* renamed from: i */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* renamed from: U */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        private String FS;
        private String FT;
        private String FU;
        private long FV;
        private long FW;

        public int describeContents() {
            return 0;
        }

        a() {
        }

        public String mW() {
            return this.FS;
        }

        public String mX() {
            return this.FT;
        }

        public void bS(String str) {
            this.FT = str;
            this.FS = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{str});
        }

        public String mY() {
            return this.FU;
        }

        public void bT(String str) {
            this.FU = str;
        }

        public long getInterval() {
            return this.FV;
        }

        public void setInterval(long j) {
            this.FV = j;
        }

        public void v(long j) {
            this.FW = j;
        }

        protected a(Parcel parcel) {
            this.FS = parcel.readString();
            this.FT = parcel.readString();
            this.FU = parcel.readString();
            this.FV = parcel.readLong();
            this.FW = parcel.readLong();
        }

        public boolean mZ() {
            boolean z = false;
            if (this.FW == 0) {
                return false;
            }
            if ((new Date().getTime() - this.FW) - (this.FV * 1000) < 0) {
                z = true;
            }
            return z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.FS);
            parcel.writeString(this.FT);
            parcel.writeString(this.FU);
            parcel.writeLong(this.FV);
            parcel.writeLong(this.FW);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.Fz = (c) ((h) ((FacebookActivity) zzakw()).iN()).nA().ng();
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
        boolean z = com.facebook.a.a.a.isAvailable() && !this.FF;
        this.Cl.setContentView(N(z));
        return this.Cl;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.FE) {
            onCancel();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.FD != null) {
            bundle.putParcelable("request_state", this.FD);
        }
    }

    public void onDestroy() {
        this.FE = true;
        this.FA.set(true);
        super.onDestroy();
        if (this.FB != null) {
            this.FB.cancel(true);
        }
        if (this.FC != null) {
            this.FC.cancel(true);
        }
    }

    public void b(c cVar) {
        this.FG = cVar;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", cVar.ip()));
        String nv = cVar.nv();
        if (nv != null) {
            bundle.putString("redirect_uri", nv);
        }
        String nw = cVar.nw();
        if (nw != null) {
            bundle.putString("target_user_id", nw);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x.mD());
        stringBuilder.append("|");
        stringBuilder.append(x.mE());
        bundle.putString("access_token", stringBuilder.toString());
        bundle.putString("device_info", com.facebook.a.a.a.lt());
        new i(null, "device/login", bundle, HttpMethod.POST, new com.facebook.i.b() {
            public void a(l lVar) {
                if (!b.this.FE) {
                    if (lVar.jJ() != null) {
                        b.this.b(lVar.jJ().iV());
                        return;
                    }
                    JSONObject jK = lVar.jK();
                    a aVar = new a();
                    try {
                        aVar.bS(jK.getString("user_code"));
                        aVar.bT(jK.getString("code"));
                        aVar.setInterval(jK.getLong("interval"));
                        b.this.a(aVar);
                    } catch (Throwable e) {
                        b.this.b(new FacebookException(e));
                    }
                }
            }
        }).jr();
    }

    private void a(a aVar) {
        this.FD = aVar;
        this.Fx.setText(aVar.mX());
        this.Fy.setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(getResources(), com.facebook.a.a.a.by(aVar.mW())), null, null);
        this.Fx.setVisibility(0);
        this.Fw.setVisibility(8);
        if (!this.FF && com.facebook.a.a.a.bx(aVar.mX())) {
            AppEventsLogger.T(getContext()).a("fb_smart_login_service", null, null);
        }
        if (aVar.mZ()) {
            mU();
        } else {
            mT();
        }
    }

    protected View N(boolean z) {
        View inflate = zzakw().getLayoutInflater().inflate(O(z), null);
        this.Fw = inflate.findViewById(d.progress_bar);
        this.Fx = (TextView) inflate.findViewById(d.confirmation_code);
        ((Button) inflate.findViewById(d.cancel_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.onCancel();
            }
        });
        this.Fy = (TextView) inflate.findViewById(d.com_facebook_device_auth_instructions);
        this.Fy.setText(Html.fromHtml(getString(f.com_facebook_device_auth_instructions)));
        return inflate;
    }

    @LayoutRes
    protected int O(boolean z) {
        return z ? e.com_facebook_smart_device_dialog_fragment : e.com_facebook_device_auth_dialog_fragment;
    }

    private void mT() {
        this.FD.v(new Date().getTime());
        this.FB = mV().jr();
    }

    private void mU() {
        this.FC = c.nb().schedule(new Runnable() {
            public void run() {
                b.this.mT();
            }
        }, this.FD.getInterval(), TimeUnit.SECONDS);
    }

    private i mV() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.FD.mY());
        return new i(null, "device/login_status", bundle, HttpMethod.POST, new com.facebook.i.b() {
            public void a(l lVar) {
                if (!b.this.FA.get()) {
                    FacebookRequestError jJ = lVar.jJ();
                    if (jJ != null) {
                        int iS = jJ.iS();
                        if (iS != 1349152) {
                            switch (iS) {
                                case 1349172:
                                case 1349174:
                                    b.this.mU();
                                    break;
                                case 1349173:
                                    b.this.onCancel();
                                    break;
                                default:
                                    b.this.b(lVar.jJ().iV());
                                    break;
                            }
                        }
                        if (b.this.FD != null) {
                            com.facebook.a.a.a.bz(b.this.FD.mX());
                        }
                        if (b.this.FG != null) {
                            b.this.b(b.this.FG);
                        } else {
                            b.this.onCancel();
                        }
                        return;
                    }
                    try {
                        JSONObject jK = lVar.jK();
                        b.this.a(jK.getString("access_token"), Long.valueOf(jK.getLong("expires_in")), Long.valueOf(jK.optLong("data_access_expiration_time")));
                    } catch (Throwable e) {
                        b.this.b(new FacebookException(e));
                    }
                }
            }
        });
    }

    private void a(String str, com.facebook.internal.w.b bVar, String str2, String str3, Date date, Date date2) {
        CharSequence string = getResources().getString(f.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(f.com_facebook_smart_login_confirmation_continue_as);
        CharSequence string3 = getResources().getString(f.com_facebook_smart_login_confirmation_cancel);
        CharSequence format = String.format(string2, new Object[]{str3});
        Builder builder = new Builder(getContext());
        final String str4 = str;
        final com.facebook.internal.w.b bVar2 = bVar;
        final String str5 = str2;
        final Date date3 = date;
        final Date date4 = date2;
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.a(str4, bVar2, str5, date3, date4);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.Cl.setContentView(b.this.N(false));
                b.this.b(b.this.FG);
            }
        });
        builder.create().show();
    }

    private void a(String str, Long l, Long l2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date = null;
        final Date date2 = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        if (!(l2.longValue() == 0 || l2 == null)) {
            date = new Date(l2.longValue() * 1000);
        }
        final String str2 = str;
        new i(new com.facebook.a(str, h.it(), "0", null, null, null, date2, null, date), "me", bundle, HttpMethod.GET, new com.facebook.i.b() {
            public void a(l lVar) {
                if (!b.this.FA.get()) {
                    if (lVar.jJ() != null) {
                        b.this.b(lVar.jJ().iV());
                        return;
                    }
                    try {
                        JSONObject jK = lVar.jK();
                        String string = jK.getString("id");
                        com.facebook.internal.w.b k = w.k(jK);
                        String string2 = jK.getString("name");
                        com.facebook.a.a.a.bz(b.this.FD.mX());
                        if (!FetchedAppSettingsManager.bF(h.it()).lI().contains(SmartLoginOption.RequireConfirm) || b.this.FF) {
                            b.this.a(string, k, str2, date2, date);
                            return;
                        }
                        b.this.FF = true;
                        b.this.a(string, k, str2, string2, date2, date);
                    } catch (Throwable e) {
                        b.this.b(new FacebookException(e));
                    }
                }
            }
        }).jr();
    }

    private void a(String str, com.facebook.internal.w.b bVar, String str2, Date date, Date date2) {
        this.Fz.a(str2, h.it(), str, bVar.mA(), bVar.mB(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.Cl.dismiss();
    }

    protected void b(FacebookException facebookException) {
        if (this.FA.compareAndSet(false, true)) {
            if (this.FD != null) {
                com.facebook.a.a.a.bz(this.FD.mX());
            }
            this.Fz.a((Exception) facebookException);
            this.Cl.dismiss();
        }
    }

    protected void onCancel() {
        if (this.FA.compareAndSet(false, true)) {
            if (this.FD != null) {
                com.facebook.a.a.a.bz(this.FD.mX());
            }
            if (this.Fz != null) {
                this.Fz.onCancel();
            }
            this.Cl.dismiss();
        }
    }
}
