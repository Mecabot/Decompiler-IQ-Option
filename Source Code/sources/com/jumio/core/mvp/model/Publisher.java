package com.jumio.core.mvp.model;

import android.os.Handler;
import android.os.Looper;
import com.jumio.core.util.ReflectionUtil;
import java.util.ArrayList;
import java.util.List;

public class Publisher<Result> {
    private List<Subscriber<Result>> mSubscribers = new ArrayList();

    public boolean add(Subscriber<Result> subscriber) {
        return !getSubscribers().contains(subscriber) && getSubscribers().add(subscriber);
    }

    protected List<Subscriber<Result>> getSubscribers() {
        return this.mSubscribers;
    }

    public boolean remove(Subscriber<Result> subscriber) {
        return getSubscribers().remove(subscriber);
    }

    protected final void publishResult(final Result result) {
        for (final Subscriber subscriber : getSubscribers()) {
            if (subscriber != null) {
                try {
                    String str = "onResult";
                    Class[] clsArr = new Class[1];
                    clsArr[0] = result != null ? result.getClass() : null;
                    InvokeOnUiThread invokeOnUiThread = (InvokeOnUiThread) ReflectionUtil.getMethod(subscriber, str, clsArr).getAnnotation(InvokeOnUiThread.class);
                    if (invokeOnUiThread == null || invokeOnUiThread.value()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                subscriber.onResult(result);
                            }
                        });
                    } else {
                        subscriber.onResult(result);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    subscriber.onResult(result);
                }
            }
        }
    }

    protected final void publishError(final Throwable th) {
        for (final Subscriber subscriber : getSubscribers()) {
            if (subscriber != null) {
                try {
                    InvokeOnUiThread invokeOnUiThread = (InvokeOnUiThread) ReflectionUtil.getMethod(subscriber, "onError", Throwable.class).getAnnotation(InvokeOnUiThread.class);
                    if (invokeOnUiThread == null || invokeOnUiThread.value()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                subscriber.onError(th);
                            }
                        });
                    } else {
                        subscriber.onError(th);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    subscriber.onError(th);
                }
            }
        }
    }
}
