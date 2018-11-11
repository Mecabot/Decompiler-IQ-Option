package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerPoolFactory */
public final class h {
    public static final boolean esF;
    public static final int esG;
    static final AtomicReference<ScheduledExecutorService> esH = new AtomicReference();
    static final Map<ScheduledThreadPoolExecutor, Object> esI = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory */
    static final class a {
        boolean esJ;
        int esK;

        a() {
        }

        void b(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.esJ = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.esJ = true;
            }
            if (this.esJ && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.esK = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                    this.esK = 1;
                    return;
                }
            }
            this.esK = 1;
        }
    }

    /* compiled from: SchedulerPoolFactory */
    static final class b implements Runnable {
        b() {
        }

        public void run() {
            Iterator it = new ArrayList(h.esI.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    h.esI.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.b(properties);
        esF = aVar.esJ;
        esG = aVar.esK;
        start();
    }

    public static void start() {
        gt(esF);
    }

    static void gt(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) esH.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (esH.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        newScheduledThreadPool.scheduleAtFixedRate(new b(), (long) esG, (long) esG, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(esF, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            esI.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
