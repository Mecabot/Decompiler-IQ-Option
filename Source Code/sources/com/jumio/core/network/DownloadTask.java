package com.jumio.core.network;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.jumio.commons.log.Log;
import java.util.Timer;
import java.util.TimerTask;

public class DownloadTask extends AsyncTask<Void, Integer, byte[]> {
    private static final int NO_TIMEOUT = -1;
    private static final String TAG = "DownloadTask";
    private byte[] certificateKey;
    private ProgressListener mListener;
    private Timer mTaskKiller;
    private int mTimeout;
    private String mUrl;

    public interface ProgressListener {
        void onProgressDone(byte[] bArr);

        void onProgressException(Exception exception);

        void onProgressUpdate(float f);
    }

    private class TimeoutTimerTask extends TimerTask {
        private final AsyncTask mTask;

        public TimeoutTimerTask(AsyncTask asyncTask) {
            this.mTask = asyncTask;
        }

        public void run() {
            if (this.mTask != null && this.mTask.getStatus() != Status.FINISHED && !this.mTask.isCancelled()) {
                this.mTask.cancel(true);
                Log.v(DownloadTask.TAG, "timer fired - killing task");
            }
        }
    }

    public DownloadTask(String str, byte[] bArr) {
        this(str, bArr, -1);
    }

    public DownloadTask(String str, byte[] bArr, int i) {
        this.mTaskKiller = null;
        this.certificateKey = null;
        this.mUrl = str;
        this.certificateKey = bArr;
        if (i != -1) {
            this.mTaskKiller = new Timer("TimoutTaskKiller");
            this.mTimeout = i;
        }
    }

    public void start() {
        execute(new Void[0]);
    }

    public byte[] startSync() {
        return doInBackground(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A:{SYNTHETIC, Splitter: B:26:0x006c} */
    protected byte[] doInBackground(java.lang.Void... r9) {
        /*
        r8 = this;
        r9 = 0;
        java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0068 }
        r0 = new java.net.URL;	 Catch:{ all -> 0x0068 }
        r1 = r8.mUrl;	 Catch:{ all -> 0x0068 }
        r0.<init>(r1);	 Catch:{ all -> 0x0068 }
        r1 = r0.openConnection();	 Catch:{ all -> 0x0068 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ all -> 0x0068 }
        r2 = "https";
        r3 = r0.getProtocol();	 Catch:{ all -> 0x0066 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0066 }
        r3 = 1;
        if (r2 == 0) goto L_0x0039;
    L_0x001e:
        r2 = new javax.net.ssl.TrustManager[r3];	 Catch:{ all -> 0x0066 }
        r4 = 0;
        r5 = new com.jumio.core.network.MultiPinningTrustManager;	 Catch:{ all -> 0x0066 }
        r6 = r8.certificateKey;	 Catch:{ all -> 0x0066 }
        r0 = r0.getHost();	 Catch:{ all -> 0x0066 }
        r5.<init>(r6, r0);	 Catch:{ all -> 0x0066 }
        r2[r4] = r5;	 Catch:{ all -> 0x0066 }
        r0 = r1;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ all -> 0x0066 }
        r4 = new com.jumio.core.network.TLSSocketFactory;	 Catch:{ all -> 0x0066 }
        r4.<init>(r2);	 Catch:{ all -> 0x0066 }
        r0.setSSLSocketFactory(r4);	 Catch:{ all -> 0x0066 }
    L_0x0039:
        r1.setDoInput(r3);	 Catch:{ all -> 0x0066 }
        r1.connect();	 Catch:{ all -> 0x0066 }
        r0 = r1.getResponseCode();	 Catch:{ all -> 0x0066 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r2) goto L_0x004d;
    L_0x0047:
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.disconnect();	 Catch:{ Exception -> 0x0070 }
    L_0x004c:
        return r9;
    L_0x004d:
        r0 = r1.getInputStream();	 Catch:{ all -> 0x0066 }
        r2 = r1.getContentLength();	 Catch:{ all -> 0x0066 }
        r0 = r8.processInputStream(r0, r2);	 Catch:{ all -> 0x0066 }
        if (r1 == 0) goto L_0x0064;
    L_0x005b:
        r1.disconnect();	 Catch:{ Exception -> 0x005f }
        goto L_0x0064;
    L_0x005f:
        r9 = move-exception;
        r7 = r0;
        r0 = r9;
        r9 = r7;
        goto L_0x0073;
    L_0x0064:
        r9 = r0;
        goto L_0x0083;
    L_0x0066:
        r0 = move-exception;
        goto L_0x006a;
    L_0x0068:
        r0 = move-exception;
        r1 = r9;
    L_0x006a:
        if (r1 == 0) goto L_0x0072;
    L_0x006c:
        r1.disconnect();	 Catch:{ Exception -> 0x0070 }
        goto L_0x0072;
    L_0x0070:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0072:
        throw r0;	 Catch:{ Exception -> 0x0070 }
    L_0x0073:
        r1 = "DownloadTask";
        r2 = "";
        com.jumio.commons.log.Log.e(r1, r2, r0);
        r1 = r8.mListener;
        if (r1 == 0) goto L_0x0083;
    L_0x007e:
        r1 = r8.mListener;
        r1.onProgressException(r0);
    L_0x0083:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.DownloadTask.doInBackground(java.lang.Void[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A:{SYNTHETIC, Splitter: B:24:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A:{SYNTHETIC, Splitter: B:29:0x005b} */
    protected byte[] processInputStream(java.io.InputStream r7, int r8) {
        /*
        r6 = this;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = 0;
        r0 = new byte[r0];	 Catch:{ all -> 0x0049 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0049 }
        r2.<init>();	 Catch:{ all -> 0x0049 }
        r1 = 0;
        r3 = 0;
    L_0x000c:
        r4 = r7.read(r0);	 Catch:{ all -> 0x0047 }
        if (r4 <= 0) goto L_0x0026;
    L_0x0012:
        r2.write(r0, r1, r4);	 Catch:{ all -> 0x0047 }
        r3 = r3 + r4;
        r4 = 1;
        r4 = new java.lang.Integer[r4];	 Catch:{ all -> 0x0047 }
        r5 = r3 * 100;
        r5 = r5 / r8;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0047 }
        r4[r1] = r5;	 Catch:{ all -> 0x0047 }
        r6.publishProgress(r4);	 Catch:{ all -> 0x0047 }
        goto L_0x000c;
    L_0x0026:
        r8 = r2.toByteArray();	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x0038;
    L_0x002c:
        r2.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0038;
    L_0x0030:
        r0 = move-exception;
        r1 = "DownloadTask";
        r2 = "";
        com.jumio.commons.log.Log.e(r1, r2, r0);
    L_0x0038:
        if (r7 == 0) goto L_0x0046;
    L_0x003a:
        r7.close();	 Catch:{ IOException -> 0x003e }
        goto L_0x0046;
    L_0x003e:
        r7 = move-exception;
        r0 = "DownloadTask";
        r1 = "";
        com.jumio.commons.log.Log.e(r0, r1, r7);
    L_0x0046:
        return r8;
    L_0x0047:
        r8 = move-exception;
        goto L_0x004b;
    L_0x0049:
        r8 = move-exception;
        r2 = r1;
    L_0x004b:
        if (r2 == 0) goto L_0x0059;
    L_0x004d:
        r2.close();	 Catch:{ IOException -> 0x0051 }
        goto L_0x0059;
    L_0x0051:
        r0 = move-exception;
        r1 = "DownloadTask";
        r2 = "";
        com.jumio.commons.log.Log.e(r1, r2, r0);
    L_0x0059:
        if (r7 == 0) goto L_0x0067;
    L_0x005b:
        r7.close();	 Catch:{ IOException -> 0x005f }
        goto L_0x0067;
    L_0x005f:
        r7 = move-exception;
        r0 = "DownloadTask";
        r1 = "";
        com.jumio.commons.log.Log.e(r0, r1, r7);
    L_0x0067:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.DownloadTask.processInputStream(java.io.InputStream, int):byte[]");
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.mTaskKiller != null) {
            this.mTaskKiller.schedule(new TimeoutTimerTask(this), (long) this.mTimeout);
        }
    }

    protected void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.mListener != null) {
            this.mListener.onProgressUpdate((float) numArr[0].intValue());
        }
    }

    protected void onPostExecute(byte[] bArr) {
        super.onPostExecute(bArr);
        if (this.mListener != null) {
            this.mListener.onProgressDone(bArr);
        }
        if (this.mTaskKiller != null) {
            this.mTaskKiller.cancel();
            this.mTaskKiller.purge();
        }
    }

    protected void onCancelled(byte[] bArr) {
        super.onCancelled(bArr);
    }

    public void setListener(ProgressListener progressListener) {
        this.mListener = progressListener;
    }
}
