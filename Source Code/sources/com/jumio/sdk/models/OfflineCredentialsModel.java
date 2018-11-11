package com.jumio.sdk.models;

import android.content.Context;
import com.jumio.alejwt.swig.JWT;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.commons.utils.StringUtil;
import com.jumio.core.enums.JumioDataCenter;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public class OfflineCredentialsModel extends CredentialsModel {
    private static final String PUBLIC_KEY = StringObfuscater.format(new byte[]{(byte) 57, (byte) 50, (byte) 21, (byte) 9, (byte) 106, (byte) -75, (byte) -21, (byte) -53, (byte) -40, (byte) -127, (byte) 83, (byte) 99, (byte) 122, (byte) 62, (byte) -42, (byte) -42, (byte) -46, Byte.MAX_VALUE, (byte) -75, (byte) 92, (byte) 29, (byte) 17, (byte) 113, (byte) -2, (byte) 100, (byte) 66, (byte) -58, (byte) 121, (byte) 84, (byte) 83, (byte) -62, (byte) -112, (byte) 40, (byte) 42, (byte) 118, (byte) -102, (byte) -27, (byte) -77, (byte) 53, (byte) -47, (byte) -38, (byte) 8, (byte) 23, (byte) -124, (byte) -59, (byte) -83, (byte) 40, (byte) 65, (byte) -79, (byte) -79, (byte) -27, (byte) -103, (byte) 115, (byte) -52, (byte) -32, (byte) 70, (byte) -78, (byte) -127, (byte) -31, (byte) -51, (byte) -124, (byte) -22, (byte) 26, (byte) -29, (byte) 84, (byte) 19, (byte) 55, (byte) 104, (byte) -3, (byte) -112, (byte) 37, (byte) 57, (byte) -40, (byte) 48, (byte) 102, (byte) 10, (byte) -26, (byte) -93, (byte) -32, (byte) -5, (byte) -9, (byte) 65, (byte) 95, (byte) 5, (byte) 44, (byte) -108, (byte) 4, (byte) 82, (byte) 47, (byte) -23, (byte) -41, (byte) 76, (byte) -44, (byte) 101, (byte) 45, (byte) 60, (byte) 71, (byte) -110, (byte) 72, (byte) -104, (byte) 43, (byte) -6, (byte) -66, (byte) 85, (byte) -49, (byte) -116, (byte) -124, (byte) -51, (byte) -18, (byte) 22, (byte) -100, (byte) -108, (byte) -75, (byte) -2, (byte) 87, (byte) -70, (byte) 19, (byte) -107, (byte) -6, (byte) 33, (byte) -22, (byte) 82, (byte) -14, (byte) 16, (byte) 120, (byte) 95, (byte) 22, (byte) -54, (byte) 1, (byte) -97, (byte) -21, (byte) 16, (byte) 58, (byte) -87, (byte) -70, (byte) -22, (byte) 114, (byte) -51, (byte) -102, (byte) -78, (byte) -67, (byte) -75, (byte) -19, (byte) -82, (byte) 65, (byte) -101, (byte) 52, (byte) 107, (byte) -78, (byte) -117, (byte) -116, (byte) -92, (byte) -4, (byte) -122, (byte) 75, (byte) -63, (byte) -96, (byte) 14, (byte) 25, (byte) -100, (byte) 30, (byte) -108, (byte) -72, (byte) -2, (byte) 57, (byte) -101, (byte) 114, (byte) 22, (byte) -84, (byte) 76, (byte) -127, (byte) 50, (byte) 118, (byte) -127, (byte) -79, (byte) -118, (byte) 121, (byte) -111, (byte) -54, (byte) -73, (byte) -83, (byte) -45, (byte) 117, (byte) 98, (byte) -20, (byte) -67, (byte) -43, (byte) -68, (byte) -24, (byte) -96, (byte) 9, (byte) -109, (byte) -11, (byte) 93, (byte) 15, (byte) -60, (byte) -41, (byte) -13, (byte) -125, (byte) -32, (byte) 16, (byte) 18, (byte) 76, (byte) 105, (byte) -11, (byte) -37, (byte) -118, (byte) 54, (byte) 107, (byte) -69, (byte) -47, (byte) -43, (byte) -45, (byte) 90, (byte) -79, (byte) 68, (byte) -73, (byte) -107, (byte) 104, (byte) 28, (byte) 106, (byte) 25, (byte) -52, (byte) 75, (byte) -80, (byte) -77, (byte) 113, (byte) 50, (byte) -46, (byte) -21, (byte) 0, Byte.MIN_VALUE, (byte) 85, (byte) -102, (byte) 33, (byte) 11, (byte) 46, (byte) -66, (byte) 10, (byte) -38, (byte) 18, (byte) 86, (byte) -40, (byte) -105, Byte.MIN_VALUE, (byte) -65, (byte) -50, (byte) -98, (byte) 21, (byte) 32, (byte) -93, (byte) 79, (byte) -65, (byte) -106, (byte) -113, (byte) -76, (byte) -59, (byte) 106, (byte) -17, (byte) -87, (byte) -95, (byte) 99, (byte) -5, (byte) -89, (byte) -43, (byte) 60, (byte) -119, (byte) 110, (byte) -121, (byte) -59, (byte) -74, (byte) -72, (byte) -17, (byte) -27, (byte) -120, (byte) -41, (byte) 65, (byte) 116, (byte) -127, (byte) -97, (byte) -95, (byte) 119, (byte) -25, (byte) 88, (byte) 27, (byte) 2, (byte) 9, (byte) 0, (byte) -67, (byte) 69, (byte) 81, (byte) -65, (byte) -78, (byte) 113, (byte) -48, Byte.MIN_VALUE, (byte) 82, (byte) 95, (byte) -77, (byte) -31, (byte) -17, (byte) -93, (byte) -21, (byte) 36, (byte) 99, (byte) -97, (byte) 123, (byte) 55, (byte) -67, (byte) -37, (byte) 47, (byte) -25, (byte) 112, (byte) 41, (byte) -114, (byte) 78, (byte) -42, (byte) 33, (byte) -99, (byte) 12, (byte) -57, (byte) 81, (byte) 83, (byte) 62, (byte) 93, (byte) 111, (byte) 88, (byte) -103, (byte) 121, (byte) 119, (byte) 115, (byte) 74, (byte) -88, (byte) 32, (byte) -90, (byte) -114, (byte) 50, (byte) -39, (byte) 115, (byte) 52, (byte) -117, (byte) -70, (byte) 3, (byte) -96, (byte) 26, (byte) 110, (byte) 123, Byte.MIN_VALUE, (byte) -26, (byte) -113, (byte) 25, (byte) -120, (byte) -75, (byte) 63, (byte) 8, (byte) -99, (byte) -25, (byte) -66, (byte) -17, (byte) 95, Byte.MAX_VALUE, (byte) 91, (byte) -16, (byte) 123, (byte) 107, (byte) -68, (byte) -109, (byte) -55, (byte) -120, (byte) 43, (byte) 12, (byte) 124, (byte) -19, (byte) -8, (byte) -32, (byte) 56, (byte) -9, (byte) -43, (byte) -109, (byte) 23, (byte) 12, (byte) 72, (byte) -65, (byte) 93, (byte) 82, (byte) -110, (byte) -28, (byte) 49, (byte) -7, (byte) 96, (byte) -95, (byte) -61, Byte.MIN_VALUE, (byte) -66, (byte) -97, (byte) -23, (byte) -118, (byte) 50, (byte) -39, (byte) 60, (byte) -72, (byte) -52, (byte) 6, (byte) -122, (byte) -113, (byte) 77, (byte) 50, (byte) -121, (byte) 47, (byte) -119, (byte) -65, (byte) 124, (byte) 42, (byte) 3, (byte) 35, (byte) 49, (byte) 94, (byte) -48, (byte) 9, (byte) 24, (byte) 74, (byte) 0, (byte) -26, (byte) 84, (byte) 124, (byte) -112, (byte) 35, (byte) -55, (byte) 82, (byte) -42, (byte) -86, (byte) 31, (byte) -98, (byte) 16, (byte) -41, (byte) 6, (byte) 44, (byte) -22, (byte) -39, (byte) 66, (byte) -23, (byte) 104, (byte) -9, (byte) 90, (byte) -39, (byte) -41, (byte) 72, (byte) -2, (byte) -12, (byte) -76}, 3675737677248833051L);
    private static byte[] publicKey = PUBLIC_KEY.getBytes();
    private boolean branding = false;
    private String offlineToken = null;

    protected void configureJWT(JWT jwt) {
    }

    protected void parseJson(JSONObject jSONObject) {
    }

    public final void setDataCenter(JumioDataCenter jumioDataCenter) {
    }

    public OfflineCredentialsModel() {
        super.setApiToken(null);
        super.setApiSecret(null);
        super.setDataCenter(JumioDataCenter.US);
    }

    public final void setOfflineToken(String str) {
        this.offlineToken = str;
    }

    public final boolean isBranding() {
        return this.branding;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c1  */
    public void verify(android.content.Context r12) {
        /*
        r11 = this;
        r0 = r11.offlineToken;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r12 = new com.jumio.core.exceptions.PlatformNotSupportedException;
        r0 = "Token not set";
        r12.<init>(r0);
        throw r12;
    L_0x000c:
        com.jumio.core.environment.Environment.loadAleLib();
        r0 = 0;
        r1 = new com.jumio.alejwt.swig.JWT;	 Catch:{ all -> 0x00bd }
        r1.<init>();	 Catch:{ all -> 0x00bd }
        r11.configureJWT(r1);	 Catch:{ all -> 0x00bb }
        r2 = com.jumio.alejwt.swig.JWSAlgorithm.PS256;	 Catch:{ all -> 0x00bb }
        r1.setAlgorithm(r2);	 Catch:{ all -> 0x00bb }
        r2 = publicKey;	 Catch:{ all -> 0x00bb }
        r1.setPublicKey(r2);	 Catch:{ all -> 0x00bb }
        r2 = r11.offlineToken;	 Catch:{ Exception -> 0x00b3 }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x00b3 }
        r1.parse(r2);	 Catch:{ Exception -> 0x00b3 }
        r2 = r1.getPayloadLength();	 Catch:{ Exception -> 0x00b3 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x00b3 }
        r3 = r1.getPayload(r2);	 Catch:{ Exception -> 0x00b3 }
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00ab }
        r5 = new java.lang.String;	 Catch:{ JSONException -> 0x00ab }
        r6 = 0;
        r5.<init>(r2, r6, r3);	 Catch:{ JSONException -> 0x00ab }
        r4.<init>(r5);	 Catch:{ JSONException -> 0x00ab }
        r2 = "android-id";
        r0 = r4.optString(r2, r0);	 Catch:{ all -> 0x00bb }
        if (r0 == 0) goto L_0x00a3;
    L_0x0048:
        r2 = r0.isEmpty();	 Catch:{ all -> 0x00bb }
        if (r2 != 0) goto L_0x00a3;
    L_0x004e:
        r2 = "android-id";
        r2 = r4.isNull(r2);	 Catch:{ all -> 0x00bb }
        if (r2 == 0) goto L_0x0057;
    L_0x0056:
        goto L_0x00a3;
    L_0x0057:
        r12 = r11.getCertificateSHA256Fingerprint(r12);	 Catch:{ all -> 0x00bb }
        r12 = r0.equals(r12);	 Catch:{ all -> 0x00bb }
        if (r12 != 0) goto L_0x0069;
    L_0x0061:
        r12 = new com.jumio.core.exceptions.PlatformNotSupportedException;	 Catch:{ all -> 0x00bb }
        r0 = "Certificate Fingerprint not verified";
        r12.<init>(r0);	 Catch:{ all -> 0x00bb }
        throw r12;	 Catch:{ all -> 0x00bb }
    L_0x0069:
        r12 = "expiry";
        r2 = 0;
        r7 = r4.optLong(r12, r2);	 Catch:{ all -> 0x00bb }
        r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = r7 * r9;
        r12 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1));
        if (r12 == 0) goto L_0x009b;
    L_0x0079:
        r12 = new java.util.Date;	 Catch:{ all -> 0x00bb }
        r12.<init>();	 Catch:{ all -> 0x00bb }
        r0 = new java.util.Date;	 Catch:{ all -> 0x00bb }
        r0.<init>(r7);	 Catch:{ all -> 0x00bb }
        r12 = r12.after(r0);	 Catch:{ all -> 0x00bb }
        if (r12 == 0) goto L_0x008a;
    L_0x0089:
        goto L_0x009b;
    L_0x008a:
        r12 = "branding";
        r12 = r4.optBoolean(r12, r6);	 Catch:{ all -> 0x00bb }
        r11.branding = r12;	 Catch:{ all -> 0x00bb }
        r11.parseJson(r4);	 Catch:{ all -> 0x00bb }
        if (r1 == 0) goto L_0x009a;
    L_0x0097:
        r1.delete();
    L_0x009a:
        return;
    L_0x009b:
        r12 = new com.jumio.sdk.SDKExpiredException;	 Catch:{ all -> 0x00bb }
        r0 = "SDK expired";
        r12.<init>(r0);	 Catch:{ all -> 0x00bb }
        throw r12;	 Catch:{ all -> 0x00bb }
    L_0x00a3:
        r12 = new com.jumio.core.exceptions.PlatformNotSupportedException;	 Catch:{ all -> 0x00bb }
        r0 = "Certificate Fingerprint not found";
        r12.<init>(r0);	 Catch:{ all -> 0x00bb }
        throw r12;	 Catch:{ all -> 0x00bb }
    L_0x00ab:
        r12 = new com.jumio.core.exceptions.PlatformNotSupportedException;	 Catch:{ all -> 0x00bb }
        r0 = "Token not valid";
        r12.<init>(r0);	 Catch:{ all -> 0x00bb }
        throw r12;	 Catch:{ all -> 0x00bb }
    L_0x00b3:
        r12 = new com.jumio.core.exceptions.PlatformNotSupportedException;	 Catch:{ all -> 0x00bb }
        r0 = "Token not verified";
        r12.<init>(r0);	 Catch:{ all -> 0x00bb }
        throw r12;	 Catch:{ all -> 0x00bb }
    L_0x00bb:
        r12 = move-exception;
        goto L_0x00bf;
    L_0x00bd:
        r12 = move-exception;
        r1 = r0;
    L_0x00bf:
        if (r1 == 0) goto L_0x00c4;
    L_0x00c1:
        r1.delete();
    L_0x00c4:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.models.OfflineCredentialsModel.verify(android.content.Context):void");
    }

    private String getCertificateSHA256Fingerprint(Context context) {
        try {
            return StringUtil.binToHex(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable e) {
            Log.printStackTrace(e);
            return null;
        }
    }
}
