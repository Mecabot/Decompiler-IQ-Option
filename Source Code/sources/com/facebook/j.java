package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.w;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: GraphRequestAsyncTask */
public class j extends AsyncTask<Void, Void, List<l>> {
    private static final String TAG = j.class.getCanonicalName();
    private Exception exception;
    private final HttpURLConnection xz;
    private final k yt;

    public j(k kVar) {
        this(null, kVar);
    }

    public j(HttpURLConnection httpURLConnection, k kVar) {
        this.yt = kVar;
        this.xz = httpURLConnection;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{RequestAsyncTask: ");
        stringBuilder.append(" connection: ");
        stringBuilder.append(this.xz);
        stringBuilder.append(", requests: ");
        stringBuilder.append(this.yt);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (h.isDebugEnabled()) {
            w.E(TAG, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.yt.jD() == null) {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.yt.a(handler);
        }
    }

    /* renamed from: r */
    protected void onPostExecute(List<l> list) {
        super.onPostExecute(list);
        if (this.exception != null) {
            w.E(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.exception.getMessage()}));
        }
    }

    /* renamed from: a */
    protected List<l> doInBackground(Void... voidArr) {
        try {
            if (this.xz == null) {
                return this.yt.jG();
            }
            return i.a(this.xz, this.yt);
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }
}
