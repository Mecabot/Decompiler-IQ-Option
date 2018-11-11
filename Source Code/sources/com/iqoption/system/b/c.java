package com.iqoption.system.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject;
import android.support.v4.os.CancellationSignal;
import com.iqoption.core.i;
import java.security.KeyStore;
import javax.crypto.Cipher;

/* compiled from: FingerprintHelper */
public class c extends AuthenticationCallback {
    private static final String TAG = "com.iqoption.system.b.c";
    private final FingerprintManagerCompat drW;
    private final a drX;
    private CancellationSignal drY;
    private CryptoObject drZ;
    private Cipher dsa;
    private KeyStore dsb;
    private boolean dsc;

    public c(Context context, a aVar) {
        this.drW = FingerprintManagerCompat.from(context);
        this.drX = aVar;
        try {
            if (VERSION.SDK_INT >= 23) {
                this.dsa = Cipher.getInstance("AES/CBC/PKCS7Padding");
            }
            this.dsb = KeyStore.getInstance("AndroidKeyStore");
            u("default_key", true);
        } catch (Throwable e) {
            i.e(TAG, "Unable to initialize fingerprint", e);
        }
    }

    public boolean aEt() {
        return a(this.drW);
    }

    public static boolean bN(Context context) {
        return a(FingerprintManagerCompat.from(context));
    }

    private static boolean a(FingerprintManagerCompat fingerprintManagerCompat) {
        return fingerprintManagerCompat.isHardwareDetected() && fingerprintManagerCompat.hasEnrolledFingerprints();
    }

    public void startListening() {
        if (aEt() && a(this.dsa, "default_key")) {
            this.drZ = new CryptoObject(this.dsa);
            this.drY = new CancellationSignal();
            this.dsc = false;
            this.drW.authenticate(this.drZ, 0, this.drY, this, null);
        }
    }

    public void stopListening() {
        if (this.drY != null) {
            this.dsc = true;
            this.drY.cancel();
            this.drY = null;
        }
    }

    public void onAuthenticationError(int i, CharSequence charSequence) {
        if (!this.dsc) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onAuthenticationError ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(charSequence);
            i.d(str, stringBuilder.toString());
            this.drX.onAuthenticationError(i, charSequence);
        }
    }

    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAuthenticationHelp ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(charSequence);
        i.d(str, stringBuilder.toString());
        this.drX.onAuthenticationHelp(i, charSequence);
    }

    public void onAuthenticationFailed() {
        i.d(TAG, "onAuthenticationFailed");
        this.drX.onAuthenticationFailed();
    }

    public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAuthenticationSucceeded ");
        stringBuilder.append(authenticationResult);
        i.d(str, stringBuilder.toString());
        this.drX.ajK();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001a A:{Splitter: B:3:0x0008, ExcHandler: java.security.GeneralSecurityException (r4_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:6:0x001a, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x001b, code:
            com.iqoption.core.i.e(TAG, "Failed to init Cipher", r4);
     */
    /* JADX WARNING: Missing block: B:8:0x0023, code:
            return false;
     */
    private boolean a(javax.crypto.Cipher r4, java.lang.String r5) {
        /*
        r3 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 1;
        r2 = 23;
        if (r0 >= r2) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r3.dsb;	 Catch:{ GeneralSecurityException -> 0x001a, GeneralSecurityException -> 0x001a }
        r2 = 0;
        r0.load(r2);	 Catch:{ GeneralSecurityException -> 0x001a, GeneralSecurityException -> 0x001a }
        r0 = r3.dsb;	 Catch:{ GeneralSecurityException -> 0x001a, GeneralSecurityException -> 0x001a }
        r5 = r0.getKey(r5, r2);	 Catch:{ GeneralSecurityException -> 0x001a, GeneralSecurityException -> 0x001a }
        r5 = (javax.crypto.SecretKey) r5;	 Catch:{ GeneralSecurityException -> 0x001a, GeneralSecurityException -> 0x001a }
        r4.init(r1, r5);	 Catch:{ GeneralSecurityException -> 0x001a, GeneralSecurityException -> 0x001a }
        return r1;
    L_0x001a:
        r4 = move-exception;
        r5 = TAG;
        r0 = "Failed to init Cipher";
        com.iqoption.core.i.e(r5, r0, r4);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.system.b.c.a(javax.crypto.Cipher, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x003f A:{Splitter: B:3:0x0007, ExcHandler: java.security.GeneralSecurityException (r2_7 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:5:0x003f, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:6:0x0040, code:
            com.iqoption.core.i.e(TAG, "unable to create key", r2);
     */
    public void u(java.lang.String r2, boolean r3) {
        /*
        r1 = this;
        r3 = android.os.Build.VERSION.SDK_INT;
        r0 = 23;
        if (r3 >= r0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r3 = r1.dsb;	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r0 = 0;
        r3.load(r0);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r3 = new android.security.keystore.KeyGenParameterSpec$Builder;	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r0 = 3;
        r3.<init>(r2, r0);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r2 = "CBC";
        r2 = new java.lang.String[]{r2};	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r2 = r3.setBlockModes(r2);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r3 = 1;
        r2 = r2.setUserAuthenticationRequired(r3);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r3 = "PKCS7Padding";
        r3 = new java.lang.String[]{r3};	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r2 = r2.setEncryptionPaddings(r3);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r3 = "AES";
        r0 = "AndroidKeyStore";
        r3 = javax.crypto.KeyGenerator.getInstance(r3, r0);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r2 = r2.build();	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r3.init(r2);	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        r3.generateKey();	 Catch:{ GeneralSecurityException -> 0x003f, GeneralSecurityException -> 0x003f }
        goto L_0x0048;
    L_0x003f:
        r2 = move-exception;
        r3 = TAG;
        r0 = "unable to create key";
        com.iqoption.core.i.e(r3, r0, r2);
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.system.b.c.u(java.lang.String, boolean):void");
    }
}
