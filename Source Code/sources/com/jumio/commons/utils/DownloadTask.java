package com.jumio.commons.utils;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.jumio.commons.log.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class DownloadTask extends AsyncTask<Void, Integer, byte[]> {
    private static final int DEFAULT_TIMEOUT = 5000;
    private static final String TAG = "DownloadTask";
    private ProgressListener mListener;
    private final Timer mTaskKiller;
    private int mTimeout;
    private final String mUrl;

    public interface ProgressListener {
        void onProgressDone(byte[] bArr);

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

    public DownloadTask(String str) {
        this(str, DEFAULT_TIMEOUT);
    }

    public DownloadTask(String str, int i) {
        this.mUrl = str;
        if (this.mUrl == null || !this.mUrl.startsWith("http")) {
            str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("URL ");
            stringBuilder.append(this.mUrl);
            stringBuilder.append(" might not be valid");
            Log.w(str, stringBuilder.toString());
        }
        this.mTaskKiller = new Timer("TimoutTaskKiller");
        this.mTimeout = i;
    }

    public void start() {
        execute(new Void[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A:{SYNTHETIC, Splitter: B:53:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cb A:{SYNTHETIC, Splitter: B:61:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d9 A:{Catch:{ IOException -> 0x00c6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A:{SYNTHETIC, Splitter: B:53:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cb A:{SYNTHETIC, Splitter: B:61:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d9 A:{Catch:{ IOException -> 0x00c6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A:{SYNTHETIC, Splitter: B:53:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cb A:{SYNTHETIC, Splitter: B:61:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d9 A:{Catch:{ IOException -> 0x00c6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A:{SYNTHETIC, Splitter: B:53:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cb A:{SYNTHETIC, Splitter: B:61:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d9 A:{Catch:{ IOException -> 0x00c6 }} */
    protected byte[] doInBackground(java.lang.Void... r11) {
        /*
        r10 = this;
        r11 = 0;
        java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00b3 }
        r0 = new java.net.URL;	 Catch:{ all -> 0x00b3 }
        r1 = r10.mUrl;	 Catch:{ all -> 0x00b3 }
        r0.<init>(r1);	 Catch:{ all -> 0x00b3 }
        r1 = r0.openConnection();	 Catch:{ all -> 0x00b3 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ all -> 0x00b3 }
        r2 = 1;
        r1.setDoInput(r2);	 Catch:{ all -> 0x00b0 }
        r1.connect();	 Catch:{ all -> 0x00b0 }
        r3 = r1.getContentLength();	 Catch:{ all -> 0x00b0 }
        r4 = r1.getResponseCode();	 Catch:{ all -> 0x00b0 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 == r5) goto L_0x0050;
    L_0x0024:
        r2 = "DownloadTask";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r3.<init>();	 Catch:{ all -> 0x00b0 }
        r4 = "Requesting file ";
        r3.append(r4);	 Catch:{ all -> 0x00b0 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b0 }
        r3.append(r0);	 Catch:{ all -> 0x00b0 }
        r0 = " returned ";
        r3.append(r0);	 Catch:{ all -> 0x00b0 }
        r0 = r1.getResponseCode();	 Catch:{ all -> 0x00b0 }
        r3.append(r0);	 Catch:{ all -> 0x00b0 }
        r0 = r3.toString();	 Catch:{ all -> 0x00b0 }
        com.jumio.commons.log.Log.e(r2, r0);	 Catch:{ all -> 0x00b0 }
        if (r1 == 0) goto L_0x004f;
    L_0x004c:
        r1.disconnect();	 Catch:{ IOException -> 0x008b }
    L_0x004f:
        return r11;
    L_0x0050:
        r0 = r1.getInputStream();	 Catch:{ all -> 0x00b0 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r4];	 Catch:{ all -> 0x00aa }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x00a7 }
        r5.<init>();	 Catch:{ all -> 0x00a7 }
        r11 = 0;
        r6 = 0;
    L_0x005f:
        r7 = r0.read(r4);	 Catch:{ all -> 0x00a2 }
        if (r7 <= 0) goto L_0x0078;
    L_0x0065:
        r5.write(r4, r11, r7);	 Catch:{ all -> 0x00a2 }
        r6 = r6 + r7;
        r7 = new java.lang.Integer[r2];	 Catch:{ all -> 0x00a2 }
        r8 = r6 * 100;
        r8 = r8 / r3;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x00a2 }
        r7[r11] = r8;	 Catch:{ all -> 0x00a2 }
        r10.publishProgress(r7);	 Catch:{ all -> 0x00a2 }
        goto L_0x005f;
    L_0x0078:
        r11 = r5.toByteArray();	 Catch:{ all -> 0x00a2 }
        if (r0 == 0) goto L_0x008e;
    L_0x007e:
        r0.close();	 Catch:{ IOException -> 0x0082 }
        goto L_0x008e;
    L_0x0082:
        r0 = move-exception;
        r2 = "DownloadTask";
        r3 = "";
        com.jumio.commons.log.Log.e(r2, r3, r0);	 Catch:{ IOException -> 0x008b }
        goto L_0x008e;
    L_0x008b:
        r0 = move-exception;
        goto L_0x00dd;
    L_0x008e:
        if (r5 == 0) goto L_0x009c;
    L_0x0090:
        r5.close();	 Catch:{ IOException -> 0x0094 }
        goto L_0x009c;
    L_0x0094:
        r0 = move-exception;
        r2 = "DownloadTask";
        r3 = "";
        com.jumio.commons.log.Log.e(r2, r3, r0);	 Catch:{ IOException -> 0x008b }
    L_0x009c:
        if (r1 == 0) goto L_0x00e4;
    L_0x009e:
        r1.disconnect();	 Catch:{ IOException -> 0x008b }
        goto L_0x00e4;
    L_0x00a2:
        r11 = move-exception;
        r9 = r0;
        r0 = r11;
        r11 = r9;
        goto L_0x00b7;
    L_0x00a7:
        r2 = move-exception;
        r5 = r11;
        goto L_0x00ad;
    L_0x00aa:
        r2 = move-exception;
        r4 = r11;
        r5 = r4;
    L_0x00ad:
        r11 = r0;
        r0 = r2;
        goto L_0x00b7;
    L_0x00b0:
        r0 = move-exception;
        r4 = r11;
        goto L_0x00b6;
    L_0x00b3:
        r0 = move-exception;
        r1 = r11;
        r4 = r1;
    L_0x00b6:
        r5 = r4;
    L_0x00b7:
        if (r11 == 0) goto L_0x00c9;
    L_0x00b9:
        r11.close();	 Catch:{ IOException -> 0x00bd }
        goto L_0x00c9;
    L_0x00bd:
        r11 = move-exception;
        r2 = "DownloadTask";
        r3 = "";
        com.jumio.commons.log.Log.e(r2, r3, r11);	 Catch:{ IOException -> 0x00c6 }
        goto L_0x00c9;
    L_0x00c6:
        r0 = move-exception;
        r11 = r4;
        goto L_0x00dd;
    L_0x00c9:
        if (r5 == 0) goto L_0x00d7;
    L_0x00cb:
        r5.close();	 Catch:{ IOException -> 0x00cf }
        goto L_0x00d7;
    L_0x00cf:
        r11 = move-exception;
        r2 = "DownloadTask";
        r3 = "";
        com.jumio.commons.log.Log.e(r2, r3, r11);	 Catch:{ IOException -> 0x00c6 }
    L_0x00d7:
        if (r1 == 0) goto L_0x00dc;
    L_0x00d9:
        r1.disconnect();	 Catch:{ IOException -> 0x00c6 }
    L_0x00dc:
        throw r0;	 Catch:{ IOException -> 0x00c6 }
    L_0x00dd:
        r1 = "DownloadTask";
        r2 = "";
        com.jumio.commons.log.Log.e(r1, r2, r0);
    L_0x00e4:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.DownloadTask.doInBackground(java.lang.Void[]):byte[]");
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.mTaskKiller.schedule(new TimeoutTimerTask(this), (long) this.mTimeout);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("started timer at ");
        stringBuilder.append(this.mTimeout);
        stringBuilder.append(" s");
        Log.v(str, stringBuilder.toString());
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

    public byte[] getData() {
        try {
            if (this.mUrl != null) {
                return (byte[]) execute(new Void[0]).get();
            }
            throw new IllegalStateException("no Url was specified!");
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException unused2) {
            return null;
        } catch (CancellationException unused3) {
            return null;
        }
    }

    public void setListener(ProgressListener progressListener) {
        this.mListener = progressListener;
    }

    public boolean exists() {
        boolean booleanValue;
        final Exception[] exceptionArr = new Exception[1];
        try {
            booleanValue = ((Boolean) new AsyncTask<String, Integer, Boolean>() {
                protected void onPreExecute() {
                    DownloadTask.this.mTaskKiller.schedule(new TimeoutTimerTask(this), (long) DownloadTask.this.mTimeout);
                    String str = DownloadTask.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("started timer at ");
                    stringBuilder.append(DownloadTask.this.mTimeout);
                    stringBuilder.append(" s");
                    Log.v(str, stringBuilder.toString());
                    super.onPreExecute();
                }

                protected Boolean doInBackground(String... strArr) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                        boolean z = true;
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() != 200) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    } catch (Throwable e) {
                        exceptionArr[0] = e;
                        Log.e(DownloadTask.TAG, "", e);
                        return Boolean.valueOf(false);
                    }
                }

                protected void onPostExecute(Boolean bool) {
                    if (DownloadTask.this.mTaskKiller != null) {
                        Log.v(DownloadTask.TAG, "killing timer");
                        DownloadTask.this.mTaskKiller.cancel();
                        DownloadTask.this.mTaskKiller.purge();
                    }
                }
            }.execute(new String[]{this.mUrl}).get()).booleanValue();
        } catch (Throwable e) {
            Log.e(TAG, "", e);
            exceptionArr[0] = e;
            booleanValue = false;
        }
        if (exceptionArr[0] == null) {
            return booleanValue;
        }
        throw new Exception(exceptionArr[0]);
    }
}
