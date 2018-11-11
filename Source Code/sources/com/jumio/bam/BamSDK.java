package com.jumio.bam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.jumio.MobileSDK;
import com.jumio.bam.custom.BamCustomScanInterface;
import com.jumio.bam.custom.BamCustomScanPresenter;
import com.jumio.bam.custom.BamCustomScanView;
import com.jumio.bam.enums.CreditCardType;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.data.Strings;
import com.jumio.core.enums.JumioCameraPosition;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.core.environment.Environment;
import com.jumio.core.exceptions.MissingPermissionException;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.models.OfflineCredentialsModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
import jumio.bam.aa;
import jumio.bam.ac;
import jumio.bam.ad;
import jumio.bam.ae;
import jumio.bam.g;
import jumio.bam.h.a;
import jumio.bam.x;
import jumio.bam.z;

public final class BamSDK extends MobileSDK {
    public static final String EXTRA_CARD_INFORMATION = "com.jumio.bam.BamSDK.EXTRA_CARD_INFORMATION";
    public static final String EXTRA_DETAILED_ERROR_CODE = "com.jumio.bam.BamSDK.EXTRA_DETAILED_ERROR_CODE";
    public static final String EXTRA_ERROR_CODE = "com.jumio.bam.BamSDK.EXTRA_ERROR_CODE";
    public static final String EXTRA_ERROR_MESSAGE = "com.jumio.bam.BamSDK.EXTRA_ERROR_MESSAGE";
    public static final String EXTRA_SCAN_ATTEMPTS = "com.jumio.bam.BamSDK.EXTRA_SCAN_ATTEMPTS";
    public static int REQUEST_CODE = 100;
    private static BamSDK a;
    private Activity b;
    private x c;
    private CredentialsModel d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private String o;
    private boolean p;
    private ArrayList<CreditCardType> q;
    private ArrayList<ac> r;

    private BamSDK(Activity activity, String str, String str2, JumioDataCenter jumioDataCenter) {
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = true;
        this.m = false;
        this.n = -1;
        this.o = "";
        this.p = false;
        if (activity == null) {
            throw new NullPointerException("rootActivity is null");
        }
        MobileSDK.checkSDKRequirements(activity, false);
        aa.a();
        Log.d("SDK Build Version: JMSDK 2.10.0 (0-63), TEMPLATE_MATCHER Build Version: 1.102.0");
        this.d = new CredentialsModel();
        this.d.setApiToken(str);
        this.d.setApiSecret(str2);
        this.d.setDataCenter(jumioDataCenter);
        this.c = new x();
        this.c.a(activity);
        Environment.checkOcrVersion(activity);
        this.b = activity;
        this.r = new ArrayList();
    }

    private BamSDK(Activity activity, String str) {
        this(activity, null, null, null);
        this.d = new OfflineCredentialsModel();
        ((OfflineCredentialsModel) this.d).setOfflineToken(str);
        ((OfflineCredentialsModel) this.d).verify(activity);
    }

    public static synchronized BamSDK create(Activity activity, String str, String str2, JumioDataCenter jumioDataCenter) {
        BamSDK bamSDK;
        synchronized (BamSDK.class) {
            if (a == null) {
                a = new BamSDK(activity, str, str2, jumioDataCenter);
            }
            bamSDK = a;
        }
        return bamSDK;
    }

    public static synchronized BamSDK create(Activity activity, String str) {
        BamSDK bamSDK;
        synchronized (BamSDK.class) {
            if (a == null) {
                a = new BamSDK(activity, str);
            }
            bamSDK = a;
        }
        return bamSDK;
    }

    private static synchronized void a() {
        synchronized (BamSDK.class) {
            a = null;
        }
    }

    public static boolean isSupportedPlatform(Context context) {
        return MobileSDK.isSupportedPlatform(context, false);
    }

    public synchronized void destroy() {
        a();
        super.destroy();
    }

    public void addCustomField(String str, String str2, int i, String str3) {
        if (str3 == null || str3.trim().equals("")) {
            this.r.add(new ad(str, str2, i, null));
        } else {
            this.r.add(new ad(str, str2, i, Pattern.compile(str3)));
        }
    }

    public void addCustomField(String str, String str2, int i) {
        addCustomField(str, str2, i, null);
    }

    public void addCustomField(String str, String str2, ArrayList<String> arrayList, boolean z, String str3) {
        this.r.add(new ae(str, str2, arrayList, z, str3));
    }

    public void addCustomField(String str, String str2, ArrayList<String> arrayList, boolean z) {
        this.r.add(new ae(str, str2, arrayList, z, ""));
    }

    public void addCustomField(String str, String str2, ArrayList<String> arrayList) {
        addCustomField(str, str2, arrayList, false, "");
    }

    public void addCustomField(String str, String str2) {
        addCustomField(str, str2, -1, null);
    }

    public void clearCustomFields() {
        this.r.clear();
    }

    public ArrayList<ac> getCustomFields() {
        if (this.r == null) {
            return new ArrayList();
        }
        return this.r;
    }

    public void setMerchantReportingCriteria(String str) {
        if (str == null) {
            this.o = "";
            return;
        }
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.o = str;
    }

    public void setCardHolderNameRequired(boolean z) {
        this.h = z;
    }

    public void setCardHolderNameEditable(boolean z) {
        this.i = z;
    }

    public void setCardNumberMaskingEnabled(boolean z) {
        this.l = z;
    }

    public void setSupportedCreditCardTypes(ArrayList<CreditCardType> arrayList) {
        this.q = arrayList;
    }

    public void setExpiryRequired(boolean z) {
        this.e = z;
    }

    public void setExpiryEditable(boolean z) {
        this.f = z;
    }

    public void setCvvRequired(boolean z) {
        this.g = z;
    }

    public void setSortCodeAndAccountNumberRequired(boolean z) {
        this.j = z;
    }

    public void setVibrationEffectEnabled(boolean z) {
        this.k = z;
    }

    public void setSoundEffect(int i) {
        this.n = i;
    }

    public void setEnableFlashOnScanStart(boolean z) {
        this.m = z;
    }

    public void setCameraPosition(JumioCameraPosition jumioCameraPosition) {
        this.p = jumioCameraPosition == JumioCameraPosition.FRONT;
    }

    private void a(boolean z) {
        if (this.q == null) {
            this.q = new ArrayList();
            this.q.add(CreditCardType.VISA);
            this.q.add(CreditCardType.MASTER_CARD);
            this.q.add(CreditCardType.AMERICAN_EXPRESS);
            this.q.add(CreditCardType.DINERS_CLUB);
            this.q.add(CreditCardType.DISCOVER);
            this.q.add(CreditCardType.JCB);
            this.q.add(CreditCardType.CHINA_UNIONPAY);
        }
        this.c.a(this.q);
        this.c.a(this.e);
        this.c.b(this.f);
        this.c.c(this.g);
        this.c.d(this.h);
        this.c.f(this.j);
        this.c.g(this.k);
        this.c.a(this.n);
        this.c.a(this.o);
        this.c.i(this.m);
        this.c.j(this.p);
        if (!z) {
            this.c.e(this.i);
            this.c.h(this.l);
            this.c.b(this.r);
        }
        DataAccess.delete(this.b, PreviewProperties.class);
        DataAccess.update(this.b, x.class, this.c);
    }

    public Intent getIntent() {
        if (MobileSDK.hasAllRequiredPermissions(this.b)) {
            a(false);
            return super.getIntent(this.b, BamActivity.class, this.d);
        }
        throw new MissingPermissionException(MobileSDK.getMissingPermissions(this.b));
    }

    public void start() {
        this.b.startActivityForResult(getIntent(), REQUEST_CODE);
    }

    public BamCustomScanPresenter start(BamCustomScanInterface bamCustomScanInterface, BamCustomScanView bamCustomScanView) {
        Strings.setFactory(new a());
        a(true);
        z zVar = new z();
        return new BamCustomScanPresenter(new g(this.b, zVar, bamCustomScanView, bamCustomScanInterface, this.d), zVar);
    }
}
