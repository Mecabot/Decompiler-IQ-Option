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
import com.iqoption.core.i;
import com.iqoption.kyc.b;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.jumio.MobileSDK;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.dv.DocumentVerificationSDK;

/* compiled from: KycMultiDocumentFragment */
public class g extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.g";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && g.this.isAdded() && ac.c(g.this.getFragmentManager(), g.TAG)) {
                am.n(g.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO = new OnBackStackChangedListener() {
        public void onBackStackChanged() {
            if (ac.c(g.this.getFragmentManager(), g.TAG)) {
                g.this.aqi();
            }
        }
    };
    private String cLA;
    private String cLB;
    private DocumentVerificationSDK cLC;
    private a cLD;
    private com.iqoption.kyc.g cLE;
    private String cLz;
    private String callbackUrl;
    private String documentType;
    private String merchantScanReference;
    private Long userId;

    /* compiled from: KycMultiDocumentFragment */
    public interface a {
        void b(String str, String str2, boolean z, int i);
    }

    public static g a(String str, String str2, String str3, String str4, String str5, String str6, Long l) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_API_TOKEN", str);
        bundle.putString("KEY_API_SECRET", str2);
        bundle.putString("KEY_DOCUMENT_TYPE", str4);
        bundle.putString("KEY_ISO_COUNTRY", str5);
        bundle.putString("KEY_MERCHANT_SCAN_REFERENCE", str6);
        bundle.putString("KEY_CALLBACK_URL", str3);
        bundle.putLong("KEY_USER_ID", l.longValue());
        gVar.setArguments(bundle);
        return gVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cLz = arguments.getString("KEY_API_TOKEN");
            this.cLA = arguments.getString("KEY_API_SECRET");
            this.documentType = arguments.getString("KEY_DOCUMENT_TYPE");
            this.cLB = arguments.getString("KEY_ISO_COUNTRY");
            this.merchantScanReference = arguments.containsKey("KEY_MERCHANT_SCAN_REFERENCE") ? arguments.getString("KEY_MERCHANT_SCAN_REFERENCE") : null;
            this.userId = arguments.containsKey("KEY_USER_ID") ? Long.valueOf(arguments.getLong("KEY_USER_ID")) : null;
            this.callbackUrl = arguments.containsKey("KEY_CALLBACK_URL") ? arguments.getString("KEY_CALLBACK_URL") : null;
            if (this.cLB == null || this.cLB.length() != 3) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("length of iso country code is not equal 3, isoCountry=");
                stringBuilder.append(this.cLB);
                i.e(str, stringBuilder.toString());
            }
        }
        this.adG = new am(zzakw());
        aqi();
        com.iqoption.core.d.a.aSe.execute(new Runnable() {
            public void run() {
                if (g.this.aqj()) {
                    g.this.cLE.a(g.this.cLC, MobileEvents.EVENTTYPE_USERACTION);
                } else {
                    g.this.getFragmentManager().popBackStack();
                }
            }
        });
        return null;
    }

    private void aqi() {
        com.iqoption.kyc.i.a((AppCompatActivity) zzakw());
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
            this.cLD = (a) context;
            if (context instanceof com.iqoption.kyc.g) {
                this.cLE = (com.iqoption.kyc.g) context;
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
        this.cLD = null;
    }

    public void onDestroyView() {
        i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private boolean aqj() {
        try {
            DocumentVerificationSDK.isSupportedPlatform(getContext());
            if (MobileSDK.isRooted(zzakw())) {
                i.w(TAG, "Device is rooted");
            }
            this.cLC = DocumentVerificationSDK.create(zzakw(), this.cLz, this.cLA, JumioDataCenter.EU);
            this.cLC.setType(this.documentType);
            this.cLC.setCountry(this.cLB);
            if (this.merchantScanReference != null) {
                this.cLC.setMerchantScanReference(this.merchantScanReference);
            }
            if (this.userId != null) {
                this.cLC.setCustomerId(this.userId.toString());
            }
            if ("CUSTOM".equals(this.documentType)) {
                this.cLC.setCustomDocumentCode("OTHER");
            }
            if (this.callbackUrl != null) {
                this.cLC.setCallbackUrl(this.callbackUrl);
            }
            return true;
        } catch (Throwable e) {
            i.e(TAG, "initializeMultiDocumentSDK error", e);
            com.crashlytics.android.a.log("Jumio MultiDocument initializeNetverifySDK error. Platform is not supported");
            com.crashlytics.android.a.c(e);
            Toast.makeText(zzakw().getApplicationContext(), "This platform is not supported", 1).show();
            return false;
        } catch (Throwable e2) {
            com.crashlytics.android.a.log("Jumio MultiDocument initializeNetverifySDK error");
            com.crashlytics.android.a.c(e2);
            com.iqoption.app.a.b.FG();
            return false;
        }
    }

    public void d(int i, int i2, Intent intent) {
        if (i == DocumentVerificationSDK.REQUEST_CODE) {
            if (intent == null) {
                i.e(TAG, "onActivityResult data=null");
                return;
            }
            String stringExtra;
            StringBuilder stringBuilder;
            if (i2 == -1) {
                stringExtra = intent.getStringExtra(DocumentVerificationSDK.EXTRA_SCAN_REFERENCE);
                String str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("scanReference=");
                stringBuilder.append(stringExtra);
                i.d(str, stringBuilder.toString());
                com.iqoption.kyc.a.a.a(getContext(), true, null, true);
                this.cLD.b(this.merchantScanReference, stringExtra, false, 0);
            } else if (i2 == 0) {
                stringExtra = intent.getStringExtra(DocumentVerificationSDK.EXTRA_ERROR_MESSAGE);
                i2 = intent.getIntExtra(DocumentVerificationSDK.EXTRA_ERROR_CODE, 0);
                stringBuilder = new StringBuilder();
                stringBuilder.append("Jumio Multidocument error. errorMessage=");
                stringBuilder.append(stringExtra);
                stringBuilder.append("; errorCode=");
                stringBuilder.append(i2);
                String stringBuilder2 = stringBuilder.toString();
                i.e(TAG, stringBuilder2);
                if (i2 != Callback.DEFAULT_SWIPE_ANIMATION_DURATION) {
                    com.crashlytics.android.a.c(new JumioException(stringBuilder2));
                }
                com.iqoption.kyc.a.a.a(getContext(), false, stringExtra, true);
                com.iqoption.kyc.a.a.a(getContext(), stringExtra, true);
                this.cLD.b(this.merchantScanReference, null, true, i2);
            }
            if (this.cLC != null) {
                this.cLC.destroy();
                this.cLC = null;
            }
        }
    }
}
