package com.jumio.commons.remote.task;

import android.os.AsyncTask;
import android.os.Handler;
import com.jumio.commons.remote.exception.UnexpectedResponseException;
import java.net.HttpURLConnection;

public abstract class TimeoutAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    protected String boundary;
    private Handler handler = new Handler();
    protected final String lineEnd = "\r\n";
    protected HttpURLConnection mConnection;
    private boolean timeout = false;
    private Runnable timeoutRunnable;
    protected final String twoHyphens = "--";

    public interface OnCompleteHandler {
        void onTaskComplete(boolean z);
    }

    public TimeoutAsyncTask() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+++Android_JMSDK_mobile_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("+++");
        this.boundary = stringBuilder.toString();
        this.timeoutRunnable = new Runnable() {
            public void run() {
                TimeoutAsyncTask.this.timeout = true;
                try {
                    if (TimeoutAsyncTask.this.mConnection != null) {
                        TimeoutAsyncTask.this.mConnection.disconnect();
                    }
                } catch (Exception unused) {
                    TimeoutAsyncTask.this.cancel(true);
                }
            }
        };
    }

    protected void onCancelled(Result result) {
        onPostExecute(result);
    }

    protected void stopTimeout() {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.timeoutRunnable);
        }
    }

    protected void checkHttpStatusAndStopTimeout(int i) {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.timeoutRunnable);
        }
        if (isTimeout()) {
            throw new UnexpectedResponseException(0, "Timed out");
        } else if (isCancelled()) {
            throw new UnexpectedResponseException(0, "Cancelled");
        } else if (i != 200) {
            throw new UnexpectedResponseException(i, this.mConnection.getResponseMessage());
        }
    }

    protected void startTimeout(int i) {
        this.handler.postDelayed(this.timeoutRunnable, (long) i);
    }

    public boolean isTimeout() {
        return this.timeout;
    }

    public void cancelHttpRequest() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (TimeoutAsyncTask.this.mConnection != null) {
                        TimeoutAsyncTask.this.mConnection.disconnect();
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }
}
