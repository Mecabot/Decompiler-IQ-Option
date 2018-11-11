package com.jumio.core.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.iqoption.dto.ToastEntity;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.mvp.model.Publisher;
import com.jumio.core.mvp.model.Subscriber;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;

public abstract class ApiCall<T> extends Publisher<T> implements Callable<T> {
    private static String mTrackingId;
    public final String TAG;
    private int connectTimeout = ToastEntity.ALERT_TOAST_DURATION;
    protected Context context;
    protected DynamicProvider dynamicProvider;
    protected int ioTimeout = ToastEntity.ALERT_TOAST_DURATION;
    protected EncryptionProvider mEncryptionProvider;
    protected String urlPrefix;
    private String userAgent;

    public interface DynamicProvider {
        EncryptionProvider getEncryptionProvider();

        byte[][] getPublicKeys();

        boolean isOffline();
    }

    protected abstract void fillRequest(OutputStream outputStream);

    protected abstract String getBoundary();

    protected String getMethod() {
        return "POST";
    }

    protected abstract String getUri();

    protected int networkErrorMock() {
        return 0;
    }

    protected T offlineResponse() {
        return null;
    }

    protected abstract T parseResponse(String str);

    protected abstract int prepareRequest();

    public ApiCall(Context context, DynamicProvider dynamicProvider, Subscriber<T> subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Network/");
        stringBuilder.append(getClass().getSimpleName());
        this.TAG = stringBuilder.toString();
        init(context, dynamicProvider);
        if (subscriber != null) {
            add(subscriber);
        }
    }

    protected static synchronized void setTrackingId(String str) {
        synchronized (ApiCall.class) {
            mTrackingId = str;
        }
    }

    @VisibleForTesting
    protected ApiCall(Context context, DynamicProvider dynamicProvider) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Network/");
        stringBuilder.append(getClass().getSimpleName());
        this.TAG = stringBuilder.toString();
        init(context, dynamicProvider);
    }

    private void init(Context context, DynamicProvider dynamicProvider) {
        this.context = context;
        this.dynamicProvider = dynamicProvider;
    }

    public void configure(String str, String str2) {
        this.urlPrefix = str;
        this.userAgent = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0167 A:{Catch:{ all -> 0x0182 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0164 A:{Catch:{ all -> 0x0182 }} */
    @android.support.annotation.Nullable
    public T execute() {
        /*
        r13 = this;
        r1 = 0;
        r2 = r13.networkErrorMock();	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        com.jumio.core.network.ApiError.onMock(r2);	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r2.<init>();	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r3 = r13.urlPrefix;	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r2.append(r3);	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r3 = r13.getUri();	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r2.append(r3);	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r7 = r13.createClient(r2);	 Catch:{ Exception -> 0x015d, all -> 0x0159 }
        r2 = r13.dynamicProvider;	 Catch:{ Exception -> 0x0157 }
        r2 = r2.getEncryptionProvider();	 Catch:{ Exception -> 0x0157 }
        r13.mEncryptionProvider = r2;	 Catch:{ Exception -> 0x0157 }
        r2 = r13.prepareRequest();	 Catch:{ Exception -> 0x0157 }
        r3 = r13.TAG;	 Catch:{ Exception -> 0x0157 }
        r4 = "Sending request %s";
        r5 = 1;
        r6 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0157 }
        r8 = r7.getURL();	 Catch:{ Exception -> 0x0157 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0157 }
        r9 = 0;
        r6[r9] = r8;	 Catch:{ Exception -> 0x0157 }
        r4 = java.lang.String.format(r4, r6);	 Catch:{ Exception -> 0x0157 }
        com.jumio.commons.log.Log.d(r3, r4);	 Catch:{ Exception -> 0x0157 }
        r3 = com.jumio.commons.log.Log.LogLevel.VERBOSE;	 Catch:{ Exception -> 0x0157 }
        r3 = com.jumio.commons.log.Log.isLogEnabledForLevel(r3);	 Catch:{ Exception -> 0x0157 }
        if (r3 == 0) goto L_0x008f;
    L_0x004e:
        r3 = r7.getRequestProperties();	 Catch:{ Exception -> 0x0157 }
        r3 = r3.entrySet();	 Catch:{ Exception -> 0x0157 }
        r3 = r3.iterator();	 Catch:{ Exception -> 0x0157 }
    L_0x005a:
        r4 = r3.hasNext();	 Catch:{ Exception -> 0x0157 }
        if (r4 == 0) goto L_0x008f;
    L_0x0060:
        r4 = r3.next();	 Catch:{ Exception -> 0x0157 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Exception -> 0x0157 }
        r6 = r13.TAG;	 Catch:{ Exception -> 0x0157 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0157 }
        r8.<init>();	 Catch:{ Exception -> 0x0157 }
        r10 = "Headers: ";
        r8.append(r10);	 Catch:{ Exception -> 0x0157 }
        r10 = r4.getKey();	 Catch:{ Exception -> 0x0157 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0157 }
        r8.append(r10);	 Catch:{ Exception -> 0x0157 }
        r10 = "=";
        r8.append(r10);	 Catch:{ Exception -> 0x0157 }
        r4 = r4.getValue();	 Catch:{ Exception -> 0x0157 }
        r8.append(r4);	 Catch:{ Exception -> 0x0157 }
        r4 = r8.toString();	 Catch:{ Exception -> 0x0157 }
        com.jumio.commons.log.Log.v(r6, r4);	 Catch:{ Exception -> 0x0157 }
        goto L_0x005a;
    L_0x008f:
        r3 = r13.mEncryptionProvider;	 Catch:{ all -> 0x0150 }
        r4 = r7.getOutputStream();	 Catch:{ all -> 0x0150 }
        r6 = r13.getBoundary();	 Catch:{ all -> 0x0150 }
        r2 = r3.createRequest(r4, r2, r6);	 Catch:{ all -> 0x0150 }
        r13.fillRequest(r2);	 Catch:{ all -> 0x014e }
        r2.flush();	 Catch:{ all -> 0x014e }
        com.jumio.commons.utils.IOUtils.closeQuietly(r2);	 Catch:{ Exception -> 0x0157 }
        r1 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x0157 }
        r3 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x0157 }
        r6 = 0;
        r10 = r3 - r1;
        r1 = (double) r10;	 Catch:{ Exception -> 0x0157 }
        r3 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r1 = r1 / r3;
        r8 = r7.getResponseCode();	 Catch:{ Exception -> 0x0157 }
        r3 = r13.TAG;	 Catch:{ Exception -> 0x0157 }
        r4 = java.util.Locale.ENGLISH;	 Catch:{ Exception -> 0x0157 }
        r6 = "Response was %d, %s";
        r10 = 2;
        r11 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0157 }
        r12 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0157 }
        r11[r9] = r12;	 Catch:{ Exception -> 0x0157 }
        r12 = r7.getResponseMessage();	 Catch:{ Exception -> 0x0157 }
        r11[r5] = r12;	 Catch:{ Exception -> 0x0157 }
        r4 = java.lang.String.format(r4, r6, r11);	 Catch:{ Exception -> 0x0157 }
        com.jumio.commons.log.Log.d(r3, r4);	 Catch:{ Exception -> 0x0157 }
        r3 = r13.TAG;	 Catch:{ Exception -> 0x0157 }
        r4 = java.util.Locale.ENGLISH;	 Catch:{ Exception -> 0x0157 }
        r6 = "Received response for %s in %.1fms";
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0157 }
        r11 = r7.getURL();	 Catch:{ Exception -> 0x0157 }
        r11 = r11.toString();	 Catch:{ Exception -> 0x0157 }
        r10[r9] = r11;	 Catch:{ Exception -> 0x0157 }
        r9 = java.lang.Double.valueOf(r1);	 Catch:{ Exception -> 0x0157 }
        r10[r5] = r9;	 Catch:{ Exception -> 0x0157 }
        r4 = java.lang.String.format(r4, r6, r10);	 Catch:{ Exception -> 0x0157 }
        com.jumio.commons.log.Log.v(r3, r4);	 Catch:{ Exception -> 0x0157 }
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 != r9) goto L_0x0100;
    L_0x00fb:
        r3 = r7.getInputStream();	 Catch:{ Exception -> 0x0157 }
        goto L_0x0104;
    L_0x0100:
        r3 = r7.getErrorStream();	 Catch:{ Exception -> 0x0157 }
    L_0x0104:
        r4 = r13.mEncryptionProvider;	 Catch:{ Exception -> 0x0157 }
        r10 = r4.getResponse(r3);	 Catch:{ Exception -> 0x0157 }
        r3 = r7.getResponseMessage();	 Catch:{ Exception -> 0x0157 }
        r4 = (long) r1;	 Catch:{ Exception -> 0x0157 }
        r1 = r13;
        r2 = r8;
        r6 = r10;
        r1.responseReceived(r2, r3, r4, r6);	 Catch:{ Exception -> 0x0157 }
        if (r8 != r9) goto L_0x0144;
    L_0x0117:
        r1 = r13.TAG;	 Catch:{ Exception -> 0x0157 }
        r2 = "parsing response";
        com.jumio.commons.log.Log.d(r1, r2);	 Catch:{ Exception -> 0x0157 }
        r1 = r13.TAG;	 Catch:{ Exception -> 0x0157 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0157 }
        r2.<init>();	 Catch:{ Exception -> 0x0157 }
        r3 = "Response: ";
        r2.append(r3);	 Catch:{ Exception -> 0x0157 }
        if (r10 == 0) goto L_0x012e;
    L_0x012c:
        r3 = r10;
        goto L_0x0130;
    L_0x012e:
        r3 = "null";
    L_0x0130:
        r2.append(r3);	 Catch:{ Exception -> 0x0157 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0157 }
        com.jumio.commons.log.Log.v(r1, r2);	 Catch:{ Exception -> 0x0157 }
        r1 = r13.parseResponse(r10);	 Catch:{ Exception -> 0x0157 }
        if (r7 == 0) goto L_0x0143;
    L_0x0140:
        r7.disconnect();
    L_0x0143:
        return r1;
    L_0x0144:
        r1 = new com.jumio.commons.remote.exception.UnexpectedResponseException;	 Catch:{ Exception -> 0x0157 }
        r2 = r7.getResponseMessage();	 Catch:{ Exception -> 0x0157 }
        r1.<init>(r8, r2);	 Catch:{ Exception -> 0x0157 }
        throw r1;	 Catch:{ Exception -> 0x0157 }
    L_0x014e:
        r0 = move-exception;
        goto L_0x0152;
    L_0x0150:
        r0 = move-exception;
        r2 = r1;
    L_0x0152:
        r1 = r0;
        com.jumio.commons.utils.IOUtils.closeQuietly(r2);	 Catch:{ Exception -> 0x0157 }
        throw r1;	 Catch:{ Exception -> 0x0157 }
    L_0x0157:
        r0 = move-exception;
        goto L_0x015f;
    L_0x0159:
        r0 = move-exception;
        r7 = r1;
    L_0x015b:
        r1 = r0;
        goto L_0x0184;
    L_0x015d:
        r0 = move-exception;
        r7 = r1;
    L_0x015f:
        r1 = r0;
        r2 = r1 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0182 }
        if (r2 == 0) goto L_0x0167;
    L_0x0164:
        r1 = (java.net.SocketTimeoutException) r1;	 Catch:{ all -> 0x0182 }
        throw r1;	 Catch:{ all -> 0x0182 }
    L_0x0167:
        r2 = r1 instanceof com.jumio.core.network.ale.AleKeyUpdateException;	 Catch:{ all -> 0x0182 }
        if (r2 == 0) goto L_0x016e;
    L_0x016b:
        r1 = (com.jumio.core.network.ale.AleKeyUpdateException) r1;	 Catch:{ all -> 0x0182 }
        throw r1;	 Catch:{ all -> 0x0182 }
    L_0x016e:
        r2 = r1 instanceof com.jumio.commons.remote.exception.UnexpectedResponseException;	 Catch:{ all -> 0x0182 }
        if (r2 == 0) goto L_0x0175;
    L_0x0172:
        r1 = (com.jumio.commons.remote.exception.UnexpectedResponseException) r1;	 Catch:{ all -> 0x0182 }
        throw r1;	 Catch:{ all -> 0x0182 }
    L_0x0175:
        r2 = r1 instanceof javax.net.ssl.SSLException;	 Catch:{ all -> 0x0182 }
        if (r2 == 0) goto L_0x017c;
    L_0x0179:
        r1 = (javax.net.ssl.SSLException) r1;	 Catch:{ all -> 0x0182 }
        throw r1;	 Catch:{ all -> 0x0182 }
    L_0x017c:
        r2 = new com.jumio.core.network.NetworkException;	 Catch:{ all -> 0x0182 }
        r2.<init>(r1);	 Catch:{ all -> 0x0182 }
        throw r2;	 Catch:{ all -> 0x0182 }
    L_0x0182:
        r0 = move-exception;
        goto L_0x015b;
    L_0x0184:
        if (r7 == 0) goto L_0x0189;
    L_0x0186:
        r7.disconnect();
    L_0x0189:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.ApiCall.execute():T");
    }

    @NonNull
    private HttpURLConnection createClient(String str) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        if (str.contains("https://")) {
            httpURLConnection = (HttpsURLConnection) url.openConnection();
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new TLSSocketFactory(new TrustManager[]{new MultiPinningTrustManager(this.dynamicProvider.getPublicKeys(), url.getHost())}));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (getMethod() != null) {
            httpURLConnection.setRequestMethod(getMethod());
            if (!httpURLConnection.getRequestMethod().equals(getMethod())) {
                throw new AssertionError();
            }
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/ale");
        httpURLConnection.setRequestProperty("Content-Encoding", "identity");
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
        httpURLConnection.setRequestProperty("X-TrackingId", mTrackingId != null ? mTrackingId : "");
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.ioTimeout);
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059 A:{Splitter: B:1:0x0008, ExcHandler: java.net.SocketTimeoutException (r1_13 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:18:0x0059, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:0x005a, code:
            com.jumio.commons.log.Log.i(r4.TAG, "<- call(failed)");
            publishError(r1);
     */
    /* JADX WARNING: Missing block: B:20:?, code:
            return null;
     */
    public final T call() {
        /*
        r4 = this;
        r0 = r4.TAG;
        r1 = "-> call()";
        com.jumio.commons.log.Log.i(r0, r1);
        r0 = 0;
        r1 = r4.dynamicProvider;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r1 = r1.isOffline();	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        if (r1 != 0) goto L_0x003d;
    L_0x0010:
        r1 = r4.isDeviceOffline();	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        if (r1 == 0) goto L_0x0025;
    L_0x0016:
        r1 = r4.TAG;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r2 = "Device is offline";
        com.jumio.commons.log.Log.w(r1, r2);	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r1 = new java.lang.Exception;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r2 = "Device is offline";
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        throw r1;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
    L_0x0025:
        r1 = r4.TAG;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r2 = "execute()";
        com.jumio.commons.log.Log.v(r1, r2);	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r1 = r4.execute();	 Catch:{ AleKeyUpdateException -> 0x0031 }
        goto L_0x0041;
    L_0x0031:
        r1 = r4.TAG;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r2 = "### ALE key update required. Re-execute call";
        com.jumio.commons.log.Log.i(r1, r2);	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r1 = r4.execute();	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        goto L_0x0041;
    L_0x003d:
        r1 = r4.offlineResponse();	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
    L_0x0041:
        r4.publishResult(r1);	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r2 = r4.TAG;	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r3 = "<- call(success)";
        com.jumio.commons.log.Log.i(r2, r3);	 Catch:{ SocketTimeoutException -> 0x0059, SocketTimeoutException -> 0x0059, Exception -> 0x004d }
        r0 = r1;
        goto L_0x0064;
    L_0x004d:
        r1 = move-exception;
        r2 = r4.TAG;
        r3 = "<- call(failed general error)";
        com.jumio.commons.log.Log.w(r2, r3, r1);
        r4.publishError(r1);
        goto L_0x0064;
    L_0x0059:
        r1 = move-exception;
        r2 = r4.TAG;
        r3 = "<- call(failed)";
        com.jumio.commons.log.Log.i(r2, r3);
        r4.publishError(r1);
    L_0x0064:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.ApiCall.call():T");
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        LogUtils.logServerResponse(getClass().getSimpleName(), i, j, str2);
    }

    public void setTimeout(int i) {
        this.connectTimeout = i;
        this.ioTimeout = i;
    }

    protected boolean isDeviceOffline() {
        return ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo() == null;
    }
}
