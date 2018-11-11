package com.iqoption.kyc.fragment.jumio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.iqoption.kyc.b;
import com.iqoption.kyc.g;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.jumio.MobileSDK;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.NetverifySDK;

/* compiled from: KycNetverifyFragment */
public class h extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.h";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && h.this.isAdded() && ac.c(h.this.getFragmentManager(), h.TAG)) {
                am.n(h.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO = new OnBackStackChangedListener() {
        public void onBackStackChanged() {
            if (ac.c(h.this.getFragmentManager(), h.TAG)) {
                h.this.aqi();
            }
        }
    };
    private String cLA;
    private g cLE;
    private Boolean cLG;
    private Boolean cLH;
    private NetverifySDK cLI;
    private a cLJ;
    private String cLz;
    private String callbackUrl;
    private String merchantScanReference;
    private Long userId;

    /* compiled from: KycNetverifyFragment */
    public interface a {
        void a(String str, String str2, boolean z, int i);
    }

    public static h a(String str, String str2, String str3, String str4, Long l) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_API_TOKEN", str);
        bundle.putString("KEY_API_SECRET", str2);
        bundle.putString("KEY_MERCHANT_SCAN_REFERENCE", str4);
        bundle.putString("KEY_CALLBACK_URL", str3);
        bundle.putBoolean("KEY_ID_VERIFICATION", true);
        bundle.putLong("KEY_USER_ID", l.longValue());
        hVar.setArguments(bundle);
        return hVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cLz = arguments.getString("KEY_API_TOKEN");
            this.cLA = arguments.getString("KEY_API_SECRET");
            this.userId = arguments.containsKey("KEY_USER_ID") ? Long.valueOf(arguments.getLong("KEY_USER_ID")) : null;
            this.merchantScanReference = arguments.containsKey("KEY_MERCHANT_SCAN_REFERENCE") ? arguments.getString("KEY_MERCHANT_SCAN_REFERENCE") : null;
            this.callbackUrl = arguments.containsKey("KEY_CALLBACK_URL") ? arguments.getString("KEY_CALLBACK_URL") : null;
            this.cLG = arguments.containsKey("KEY_ID_VERIFICATION") ? Boolean.valueOf(arguments.getBoolean("KEY_ID_VERIFICATION")) : null;
            this.cLH = arguments.containsKey("KEY_FACE_MATCH") ? Boolean.valueOf(arguments.getBoolean("KEY_FACE_MATCH")) : null;
        }
        this.adG = new am(zzakw());
        aqi();
        com.iqoption.core.d.a.aSe.execute(new Runnable() {
            public void run() {
                if (h.this.aqk()) {
                    h.this.cLE.a(h.this.cLI, MobileEvents.EVENTTYPE_ANDROID_LIFECYCLE);
                } else {
                    h.this.getFragmentManager().popBackStack();
                }
            }
        });
        return null;
    }

    private void aqi() {
        i.a((AppCompatActivity) zzakw());
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        StringBuilder stringBuilder;
        if (context instanceof a) {
            this.cLJ = (a) context;
            if (context instanceof g) {
                this.cLE = (g) context;
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement KycStartJumio");
            throw new RuntimeException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLJ = null;
    }

    private boolean aqk() {
        try {
            if (MobileSDK.isRooted(zzakw())) {
                com.iqoption.core.i.w(TAG, "Device is rooted");
            }
            this.cLI = NetverifySDK.create(zzakw(), this.cLz, this.cLA, JumioDataCenter.EU);
            if (this.cLG != null) {
                this.cLI.setRequireVerification(this.cLG.booleanValue());
            }
            if (this.merchantScanReference != null) {
                this.cLI.setMerchantScanReference(this.merchantScanReference);
            }
            if (this.userId != null) {
                this.cLI.setCustomerId(this.userId.toString());
            }
            if (this.callbackUrl != null) {
                this.cLI.setCallbackUrl(this.callbackUrl);
            }
            if (this.cLH != null) {
                this.cLI.setRequireFaceMatch(this.cLH.booleanValue());
            }
            return true;
        } catch (Throwable e) {
            com.iqoption.core.i.e(TAG, "initializeNetverifySDK error", e);
            com.crashlytics.android.a.log("Jumio Netverify initializeNetverifySDK error. Platform is not supported");
            com.crashlytics.android.a.c(e);
            Toast.makeText(zzakw().getApplicationContext(), "This platform is not supported", 1).show();
            return false;
        } catch (Throwable e2) {
            com.crashlytics.android.a.log("Jumio Netverify initializeNetverifySDK error");
            com.crashlytics.android.a.c(e2);
            com.iqoption.app.a.b.aT(getContext());
            return false;
        }
    }

    public void d(int i, int i2, Intent intent) {
        if (i == NetverifySDK.REQUEST_CODE) {
            if (intent == null) {
                com.iqoption.core.i.e(TAG, "onActivityResult data=null");
                return;
            }
            String stringExtra;
            if (i2 == -1) {
                stringExtra = intent.getStringExtra(NetverifySDK.EXTRA_SCAN_REFERENCE);
                NetverifyDocumentData netverifyDocumentData = (NetverifyDocumentData) intent.getParcelableExtra(NetverifySDK.EXTRA_SCAN_DATA);
                if (netverifyDocumentData != null) {
                    netverifyDocumentData.getMrzData();
                }
                com.iqoption.kyc.a.a.a(getContext(), true, null, true);
                this.cLJ.a(this.merchantScanReference, stringExtra, false, 0);
            } else if (i2 == 0) {
                stringExtra = intent.getStringExtra(NetverifySDK.EXTRA_ERROR_MESSAGE);
                i2 = intent.getIntExtra(NetverifySDK.EXTRA_ERROR_CODE, 0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Jumio Netverify error. errorMessage=");
                stringBuilder.append(stringExtra);
                stringBuilder.append("; errorCode=");
                stringBuilder.append(i2);
                String stringBuilder2 = stringBuilder.toString();
                com.iqoption.core.i.e(TAG, stringBuilder2);
                if (i2 != Callback.DEFAULT_SWIPE_ANIMATION_DURATION) {
                    com.crashlytics.android.a.c(new JumioException(stringBuilder2));
                }
                com.iqoption.kyc.a.a.a(getContext(), false, stringExtra, true);
                com.iqoption.kyc.a.a.a(getContext(), stringExtra, true);
                this.cLJ.a(this.merchantScanReference, null, true, i2);
            }
            if (this.cLI != null) {
                this.cLI.destroy();
                this.cLI = null;
            }
        }
    }
}
