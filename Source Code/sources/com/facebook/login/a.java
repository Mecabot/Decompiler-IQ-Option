package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.customtabs.CustomTabsService;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.h;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.facebook.login.LoginClient.c;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomTabLoginMethodHandler */
public class a extends o {
    public static final Creator<a> CREATOR = new Creator() {
        /* renamed from: h */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: T */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private static final String[] Ft = new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    private String Fu;
    private String Fv;

    public int describeContents() {
        return 0;
    }

    String mM() {
        return "custom_tab";
    }

    protected String mO() {
        return "chrome_custom_tab";
    }

    a(LoginClient loginClient) {
        super(loginClient);
        this.Fv = w.Q(20);
    }

    AccessTokenSource mN() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    boolean a(c cVar) {
        if (!mP()) {
            return false;
        }
        Bundle a = a(i(cVar), cVar);
        Intent intent = new Intent(this.Gv.getActivity(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.wV, a);
        intent.putExtra(CustomTabMainActivity.wW, mR());
        this.Gv.getFragment().startActivityForResult(intent, 1);
        return true;
    }

    private boolean mP() {
        return mQ() && mR() != null && mS() && x.ak(h.getApplicationContext());
    }

    private boolean mQ() {
        l bF = FetchedAppSettingsManager.bF(w.ac(this.Gv.getActivity()));
        return bF != null && bF.lG();
    }

    private String mR() {
        if (this.Fu != null) {
            return this.Fu;
        }
        Context activity = this.Gv.getActivity();
        List<ResolveInfo> queryIntentServices = activity.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        if (queryIntentServices != null) {
            Set hashSet = new HashSet(Arrays.asList(Ft));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    this.Fu = serviceInfo.packageName;
                    return this.Fu;
                }
            }
        }
        return null;
    }

    private boolean mS() {
        return !w.ai(this.Gv.getActivity());
    }

    boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            return super.onActivityResult(i, i2, intent);
        }
        c nc = this.Gv.nc();
        if (i2 == -1) {
            a(intent.getStringExtra(CustomTabMainActivity.wX), nc);
            return true;
        }
        super.a(nc, null, new FacebookOperationCanceledException());
        return false;
    }

    private void a(String str, c cVar) {
        if (str != null && str.startsWith(CustomTabMainActivity.iM())) {
            Uri parse = Uri.parse(str);
            Bundle bO = w.bO(parse.getQuery());
            bO.putAll(w.bO(parse.getFragment()));
            if (n(bO)) {
                str = bO.getString("error");
                if (str == null) {
                    str = bO.getString("error_type");
                }
                String string = bO.getString("error_msg");
                if (string == null) {
                    string = bO.getString("error_message");
                }
                if (string == null) {
                    string = bO.getString("error_description");
                }
                String string2 = bO.getString("error_code");
                if (!w.bc(string2)) {
                    int parseInt;
                    try {
                        parseInt = Integer.parseInt(string2);
                    } catch (NumberFormatException unused) {
                        parseInt = -1;
                    }
                    if (w.bc(str) && w.bc(string) && parseInt == -1) {
                        super.a(cVar, bO, null);
                    } else if (str != null && (str.equals("access_denied") || str.equals("OAuthAccessDeniedException"))) {
                        super.a(cVar, null, new FacebookOperationCanceledException());
                    } else if (parseInt == 4201) {
                        super.a(cVar, null, new FacebookOperationCanceledException());
                    } else {
                        super.a(cVar, null, new FacebookServiceException(new FacebookRequestError(parseInt, str, string), string));
                    }
                }
            } else {
                super.a(cVar, null, new FacebookException("Invalid state parameter"));
            }
        }
    }

    protected void l(JSONObject jSONObject) {
        jSONObject.put("7_challenge", this.Fv);
    }

    private boolean n(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.Fv);
        } catch (JSONException unused) {
            return false;
        }
    }

    a(Parcel parcel) {
        super(parcel);
        this.Fv = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.Fv);
    }
}
