package com.jumio.nv.nfc.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import com.jumio.core.mvp.model.PublisherWithUpdate;
import com.jumio.core.mvp.model.SubscriberWithUpdate;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.nv.nfc.core.communication.TagAccessSpec;
import java.security.Security;
import java.security.cert.CertificateException;
import jumio.nv.nfc.e;
import jumio.nv.nfc.g;
import jumio.nv.nfc.h;
import jumio.nv.nfc.j;
import jumio.nv.nfc.o;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class NfcControllerImpl extends PublisherWithUpdate<o, o> implements NfcController {
    private static final int PENDING_INTENT_NFC_SETTINGS = 11;
    private static final int PENDING_INTENT_NFC_TECH_DETECTED = 10;
    private static final String TAG = "NfcControllerImp";
    private j mAuthenticator;
    private Context mContext;
    private h mDatabase;
    boolean mForegroundDispatchActive;
    private boolean mIsActive;
    private transient NfcAdapter mNfcAdapter;
    private TagAccessSpec mTagAccess;

    class a implements SubscriberWithUpdate<o, o> {
        private a() {
        }

        /* renamed from: a */
        public void onUpdate(o oVar) {
            NfcControllerImpl.this.a(oVar);
        }

        /* renamed from: b */
        public void onResult(o oVar) {
            NfcControllerImpl.this.b(oVar);
        }

        public void onError(Throwable th) {
            NfcControllerImpl.this.e(th);
        }
    }

    private void initSecurityProviders() {
    }

    public void stop() {
    }

    public NfcControllerImpl(@NonNull Context context) {
        this(context, null);
    }

    NfcControllerImpl(@NonNull Context context, TagAccessSpec tagAccessSpec) {
        this.mForegroundDispatchActive = false;
        this.mIsActive = false;
        this.mContext = context;
        this.mTagAccess = tagAccessSpec;
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    public void downloadCertificates(ServerSettingsModel serverSettingsModel) {
        if (serverSettingsModel != null && serverSettingsModel.isCdnUsable()) {
            try {
                this.mDatabase = new h(serverSettingsModel);
            } catch (CertificateException unused) {
                this.mDatabase = null;
            }
        }
    }

    public void start(Activity activity) {
        enableForegroundDispatch(activity, 10);
    }

    public void pause(Activity activity) {
        disableForegroundDispatch(activity);
    }

    protected synchronized void enableForegroundDispatch(Activity activity, int i) {
        if (!this.mForegroundDispatchActive) {
            this.mForegroundDispatchActive = true;
            initNfcAdapter();
            if (this.mNfcAdapter != null) {
                Intent intent = new Intent();
                intent.addFlags(536870912);
                PendingIntent createPendingResult = activity.createPendingResult(i, intent, 0);
                if (createPendingResult != null) {
                    try {
                        this.mNfcAdapter.enableForegroundDispatch(activity, createPendingResult, new IntentFilter[]{new IntentFilter("android.nfc.action.TECH_DISCOVERED"), new IntentFilter("android.nfc.action.TAG_DISCOVERED")}, new String[][]{new String[]{"android.nfc.tech.IsoDep"}});
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    protected synchronized void disableForegroundDispatch(Activity activity) {
        this.mForegroundDispatchActive = false;
        initNfcAdapter();
        if (this.mNfcAdapter != null) {
            try {
                this.mNfcAdapter.disableForegroundDispatch(activity);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized boolean isNfcEnabled() {
        boolean z;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mContext);
        z = defaultAdapter != null && defaultAdapter.isEnabled();
        return z;
    }

    protected void tagDetected(g gVar, TagAccessSpec tagAccessSpec) {
        if (this.mAuthenticator == null || !this.mAuthenticator.a()) {
            this.mAuthenticator = new j(this.mDatabase, gVar, tagAccessSpec);
            this.mAuthenticator.subscribe(new a());
            this.mAuthenticator.b();
        }
    }

    public boolean hasRootCertificate(String str) {
        return this.mDatabase != null && this.mDatabase.a(str);
    }

    public boolean hasNfcFeature() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public boolean consumeIntent(int i, Intent intent) {
        if (!this.mIsActive) {
            return false;
        }
        switch (i) {
            case 10:
                resolveIntent(intent);
                return true;
            case 11:
                return false;
            default:
                return false;
        }
    }

    public void setTagAccess(Object obj) {
        if (obj instanceof TagAccessSpec) {
            this.mTagAccess = (TagAccessSpec) obj;
            return;
        }
        throw new IllegalArgumentException("accessSpec must be of type TagAccessSpec");
    }

    public void setEnabled(boolean z) {
        this.mIsActive = z;
    }

    private void resolveIntent(Intent intent) {
        if (this.mTagAccess == null) {
            throw new e("NFC tag access was null! Call NfcController.setTagAccess() before starting the scan!");
        }
        String action = intent.getAction();
        if ("android.nfc.action.TECH_DISCOVERED".equals(action) && (intent.getFlags() & 1048576) == 0) {
            tagDetected(new g((Tag) intent.getParcelableExtra("android.nfc.extra.TAG")), this.mTagAccess);
        } else if ("android.nfc.action.TAG_DISCOVERED".equals(action) && (intent.getFlags() & 1048576) == 0) {
            tagDetected(new g((Tag) intent.getParcelableExtra("android.nfc.extra.TAG")), this.mTagAccess);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:12:0x0022, code:
            return;
     */
    private synchronized void initNfcAdapter() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mContext;	 Catch:{ all -> 0x0023 }
        r1 = "nfc";
        r0 = r0.getSystemService(r1);	 Catch:{ all -> 0x0023 }
        r0 = (android.nfc.NfcManager) r0;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0013;
    L_0x000d:
        r0 = r0.getDefaultAdapter();	 Catch:{ all -> 0x0023 }
        r2.mNfcAdapter = r0;	 Catch:{ all -> 0x0023 }
    L_0x0013:
        r0 = r2.mNfcAdapter;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0021;
    L_0x0017:
        r0 = r2.mNfcAdapter;	 Catch:{ Exception -> 0x001c }
        r0.isEnabled();	 Catch:{ Exception -> 0x001c }
    L_0x001c:
        r0 = r2.mNfcAdapter;	 Catch:{ Exception -> 0x0021 }
        r0.isEnabled();	 Catch:{ Exception -> 0x0021 }
    L_0x0021:
        monitor-exit(r2);
        return;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.nfc.core.NfcControllerImpl.initNfcAdapter():void");
    }
}
