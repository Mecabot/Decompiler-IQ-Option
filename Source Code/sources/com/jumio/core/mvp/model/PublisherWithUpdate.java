package com.jumio.core.mvp.model;

import android.os.Handler;
import android.os.Looper;
import com.jumio.core.util.ReflectionUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class PublisherWithUpdate<Update, Result> {
    private List<SubscriberWithUpdate<Update, Result>> mSubscribers = new CopyOnWriteArrayList();

    protected final void publishUpdate(final Update update) {
        for (final SubscriberWithUpdate subscriberWithUpdate : getSubscribers()) {
            if (subscriberWithUpdate != null) {
                try {
                    String str = "onUpdate";
                    Class[] clsArr = new Class[1];
                    clsArr[0] = update != null ? update.getClass() : null;
                    InvokeOnUiThread invokeOnUiThread = (InvokeOnUiThread) ReflectionUtil.getMethod(subscriberWithUpdate, str, clsArr).getAnnotation(InvokeOnUiThread.class);
                    if (invokeOnUiThread == null || invokeOnUiThread.value()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                subscriberWithUpdate.onUpdate(update);
                            }
                        });
                    } else {
                        subscriberWithUpdate.onUpdate(update);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    subscriberWithUpdate.onUpdate(update);
                }
            }
        }
    }

    public boolean subscribe(SubscriberWithUpdate<Update, Result> subscriberWithUpdate) {
        return (subscriberWithUpdate == null || getSubscribers().contains(subscriberWithUpdate) || !getSubscribers().add(subscriberWithUpdate)) ? false : true;
    }

    protected List<SubscriberWithUpdate<Update, Result>> getSubscribers() {
        return this.mSubscribers;
    }

    public boolean unsubscribe(SubscriberWithUpdate<Update, Result> subscriberWithUpdate) {
        return getSubscribers().remove(subscriberWithUpdate);
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
