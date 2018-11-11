package com.iqoption.analytics;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import androidx.work.BackoffPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.b;
import androidx.work.f;
import androidx.work.g;
import androidx.work.j;
import androidx.work.l;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.app.IQApp;
import com.iqoption.app.db.a;
import com.iqoption.core.i;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EventManager implements LifecycleObserver {
    private static final String TAG = "com.iqoption.analytics.EventManager";
    private static Condition aiX = initLock.newCondition();
    private static AtomicBoolean aiY = new AtomicBoolean();
    private static volatile EventManager aja;
    private static Lock initLock = new ReentrantLock();
    private final ExecutorService aiW = Executors.newSingleThreadExecutor();
    private a aiZ;
    private UUID ajb = null;
    private final b gv = new b.a().b(NetworkType.CONNECTED).aO();

    public static synchronized EventManager Bm() {
        EventManager eventManager;
        synchronized (EventManager.class) {
            if (aja == null) {
                synchronized (EventManager.class) {
                    if (aja == null) {
                        aja = new EventManager();
                    }
                }
            }
            eventManager = aja;
        }
        return eventManager;
    }

    private EventManager() {
        Bn();
    }

    private void Bn() {
        this.aiW.execute(new d(this));
    }

    final /* synthetic */ void Bq() {
        try {
            initLock.lock();
            this.aiZ = new a(IQApp.Dk());
            aiY.set(true);
            aiX.signalAll();
        } finally {
            initLock.unlock();
        }
    }

    public static void Bo() {
        try {
            initLock.lock();
            if (!aiY.get()) {
                aiX.await();
            }
        } catch (Throwable e) {
            i.d(TAG, "Creation of DG Event", e);
        } catch (Throwable th) {
            initLock.unlock();
        }
        initLock.unlock();
    }

    @OnLifecycleEvent(R = Event.ON_START)
    void onStart() {
        this.ajb = ((g) ((g.a) ((g.a) ((g.a) new g.a(EventsSendWorker.class, 900000, TimeUnit.MILLISECONDS).a(BackoffPolicy.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(this.gv)).p("PERIODIC")).be()).getId();
        j.aZ().a(r0);
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    void onStop() {
        this.ajb = null;
        f fVar = (f) ((f.a) ((f.a) ((f.a) new f.a(EventsSendWorker.class).a(BackoffPolicy.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(this.gv)).p("SEND_EVENTS_BEFOR_EXIT")).be();
        j.aZ().ba();
        j.aZ().a(fVar);
    }

    @WorkerThread
    public void f(ArrayList<com.iqoption.dto.Event> arrayList) {
        this.aiZ.f(arrayList);
    }

    @WorkerThread
    public ArrayList<com.iqoption.dto.Event> aw(boolean z) {
        return this.aiZ.aw(z);
    }

    @WorkerThread
    public Long Bp() {
        return this.aiZ.Bp();
    }

    public void a(com.iqoption.dto.Event event) {
        if (event != null) {
            this.aiW.execute(new e(this, event));
            if (!com.iqoption.dto.Event.MICROSERVICE_EVENT.equals(event.name)) {
                b(event);
            }
        }
    }

    final /* synthetic */ void c(com.iqoption.dto.Event event) {
        Bo();
        long d = this.aiZ.d(event);
        UUID uuid = this.ajb;
        if (d > 10 && uuid != null) {
            l lVar = (l) j.aZ().a(uuid).getValue();
            if (lVar == null || lVar.bf().isFinished()) {
                f fVar = (f) ((f.a) ((f.a) ((f.a) new f.a(EventsSendWorker.class).a(BackoffPolicy.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(this.gv)).p("ONESHOT")).be();
                j.aZ().a("ONESHOT", ExistingWorkPolicy.KEEP, fVar).aY();
            }
        }
    }

    public void b(com.iqoption.dto.Event event) {
        Context Dk = IQApp.Dk();
        if (Dk != null) {
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.b.ITEM_CATEGORY, event.category);
            bundle.putString(FirebaseAnalytics.b.ITEM_NAME, event.name);
            if (event.value.doubleValue() != Double.MIN_VALUE) {
                bundle.putDouble(FirebaseAnalytics.b.VALUE, event.value.doubleValue());
            }
            FirebaseAnalytics.getInstance(Dk).logEvent(event.name.replaceAll("[-\\.\\$\\[\\]#\\/]", ""), bundle);
        }
    }

    public void a(Double d, String str) {
        Context Dk = IQApp.Dk();
        if (Dk != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble(FirebaseAnalytics.b.VALUE, d.doubleValue());
            bundle.putString(FirebaseAnalytics.b.CURRENCY, str);
            FirebaseAnalytics.getInstance(Dk).logEvent(FirebaseAnalytics.a.ECOMMERCE_PURCHASE, bundle);
        }
    }
}
