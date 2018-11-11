package jumio.nv.core;

import android.content.Context;
import com.jumio.commons.log.Log;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.Publisher;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall;
import com.jumio.core.util.MultiHashMap;
import com.jumio.nv.models.BackendModel;
import com.jumio.persistence.DataAccess;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: QueueProcessor */
public class j<T extends Callable> implements Subscriber {
    private MultiHashMap<Class<T>, Subscriber> a = new MultiHashMap();
    private final Object b = new Object();
    private AtomicBoolean c = new AtomicBoolean(false);
    private ConcurrentLinkedQueue<T> d = new ConcurrentLinkedQueue();
    private final Object e = new Object();
    private ExecutorService f;
    private Future<T> g;
    private Context h;

    /* compiled from: QueueProcessor */
    public interface a {
        boolean a(Throwable th, Context context);
    }

    /* compiled from: QueueProcessor */
    static class b extends Publisher<Object> {
        private b() {
        }

        void a(Subscriber subscriber, Object obj) {
            add(subscriber);
            publishResult(obj);
            remove(subscriber);
        }

        void a(Subscriber subscriber, Throwable th) {
            add(subscriber);
            publishError(th);
            remove(subscriber);
        }
    }

    public j(ExecutorService executorService) {
        this.f = executorService;
    }

    /* JADX WARNING: Missing block: B:15:0x005d, code:
            return;
     */
    public void a() {
        /*
        r5 = this;
        r0 = r5.e;
        monitor-enter(r0);
        r1 = r5.d;	 Catch:{ all -> 0x005e }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x005e }
        if (r1 != 0) goto L_0x005c;
    L_0x000b:
        r1 = r5.c;	 Catch:{ all -> 0x005e }
        r1 = r1.get();	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0014;
    L_0x0013:
        goto L_0x005c;
    L_0x0014:
        r1 = r5.c;	 Catch:{ all -> 0x005e }
        r2 = 1;
        r1.set(r2);	 Catch:{ all -> 0x005e }
        r1 = r5.d;	 Catch:{ all -> 0x005e }
        r1 = r1.peek();	 Catch:{ all -> 0x005e }
        r1 = (java.util.concurrent.Callable) r1;	 Catch:{ all -> 0x005e }
        r2 = "QueueProcessor";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r3.<init>();	 Catch:{ all -> 0x005e }
        r4 = "proceed() starting ";
        r3.append(r4);	 Catch:{ all -> 0x005e }
        r4 = r1.getClass();	 Catch:{ all -> 0x005e }
        r4 = r4.getSimpleName();	 Catch:{ all -> 0x005e }
        r3.append(r4);	 Catch:{ all -> 0x005e }
        r3 = r3.toString();	 Catch:{ all -> 0x005e }
        com.jumio.commons.log.Log.i(r2, r3);	 Catch:{ all -> 0x005e }
        r2 = r1 instanceof com.jumio.core.mvp.model.Publisher;	 Catch:{ all -> 0x005e }
        if (r2 == 0) goto L_0x0054;
    L_0x0044:
        r2 = r1;
        r2 = (com.jumio.core.mvp.model.Publisher) r2;	 Catch:{ all -> 0x005e }
        r2.add(r5);	 Catch:{ all -> 0x005e }
        r2 = r5.f;	 Catch:{ all -> 0x005e }
        r1 = r2.submit(r1);	 Catch:{ all -> 0x005e }
        r5.g = r1;	 Catch:{ all -> 0x005e }
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0054:
        r1 = new java.lang.RuntimeException;	 Catch:{ all -> 0x005e }
        r2 = "all objects submitted to the QueueProcessor must extend Publisher!";
        r1.<init>(r2);	 Catch:{ all -> 0x005e }
        throw r1;	 Catch:{ all -> 0x005e }
    L_0x005c:
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x005e:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.j.a():void");
    }

    @InvokeOnUiThread(false)
    public void onResult(Object obj) {
        Callable callable;
        synchronized (this.e) {
            this.c.set(false);
            callable = (Callable) this.d.poll();
            this.g = null;
        }
        if (callable != null) {
            synchronized (this.b) {
                List<Subscriber> remove = this.a.remove(callable.getClass());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onResult() call succeeded: ");
                stringBuilder.append(callable.getClass().getSimpleName());
                Log.i("QueueProcessor", stringBuilder.toString());
                if (remove != null && remove.size() != 0) {
                    for (Subscriber subscriber : remove) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("  notifying ");
                        stringBuilder2.append(subscriber.getClass().getSimpleName());
                        Log.i("QueueProcessor", stringBuilder2.toString());
                        new b().a(subscriber, obj);
                    }
                    Serializable serializable = (BackendModel) DataAccess.load(this.h, BackendModel.class);
                    if (serializable != null) {
                        serializable.remove(callable.getClass());
                        DataAccess.update(this.h, BackendModel.class, serializable);
                    }
                } else if ((obj instanceof Serializable) || obj == null) {
                    Serializable serializable2 = (BackendModel) DataAccess.load(this.h, BackendModel.class);
                    if (serializable2 == null) {
                        serializable2 = new BackendModel();
                    }
                    serializable2.add(callable.getClass(), (Serializable) obj);
                    DataAccess.update(this.h, BackendModel.class, serializable2);
                }
            }
            a();
        }
    }

    public void a(Context context, Class<?> cls, Subscriber subscriber) {
        Serializable serializable = (BackendModel) DataAccess.load(context, BackendModel.class);
        if (serializable != null && serializable.has(cls)) {
            Object obj = serializable.get(cls);
            if (obj instanceof Throwable) {
                new b().a(subscriber, (Throwable) obj);
            } else {
                new b().a(subscriber, obj);
            }
            serializable.remove(cls);
            DataAccess.update(context, BackendModel.class, serializable);
        }
    }

    @InvokeOnUiThread(false)
    public void onError(Throwable th) {
        Callable callable;
        synchronized (this.e) {
            this.c.set(false);
            callable = (Callable) this.d.peek();
            this.g = null;
        }
        if (callable != null) {
            if ((callable instanceof a) && ((a) callable).a(th, this.h)) {
                Log.i("QueueProcessor", "onError() call ignored");
                return;
            }
            synchronized (this.b) {
                List<Subscriber> list = (List) this.a.get(callable.getClass());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onError() call failed: ");
                stringBuilder.append(callable.getClass().getSimpleName());
                Log.i("QueueProcessor", stringBuilder.toString());
                if (list == null || list.size() == 0) {
                    Serializable serializable = (BackendModel) DataAccess.load(this.h, BackendModel.class);
                    if (serializable == null) {
                        serializable = new BackendModel();
                    }
                    serializable.add(callable.getClass(), th);
                    DataAccess.update(this.h, BackendModel.class, serializable);
                } else {
                    for (Subscriber subscriber : list) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("  notifying ");
                        stringBuilder2.append(subscriber.getClass().getSimpleName());
                        Log.i("QueueProcessor", stringBuilder2.toString());
                        new b().a(subscriber, th);
                    }
                    Serializable serializable2 = (BackendModel) DataAccess.load(this.h, BackendModel.class);
                    if (serializable2 != null) {
                        serializable2.remove(callable.getClass());
                        DataAccess.update(this.h, BackendModel.class, serializable2);
                    }
                }
            }
        }
    }

    public void b(Context context, Class<T> cls, Subscriber subscriber) {
        this.h = context;
        if (cls == null || subscriber == null) {
            Log.i("QueueProcessor", "register(): not registering, null-constraint not satisfied");
            return;
        }
        synchronized (this.b) {
            a(context, cls, subscriber);
            this.a.putOne(cls, subscriber);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("register() registering ");
        stringBuilder.append(subscriber.getClass().getSimpleName());
        stringBuilder.append(" for ");
        stringBuilder.append(cls.getSimpleName());
        stringBuilder.append(". new count = ");
        stringBuilder.append(this.a.count(cls));
        stringBuilder.append(", overall count = ");
        stringBuilder.append(this.a.size());
        Log.i("QueueProcessor", stringBuilder.toString());
    }

    public void a(T t) {
        synchronized (this.e) {
            this.d.add(t);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  item added! ");
            stringBuilder.append(t.getClass().getSimpleName());
            Log.i("QueueProcessor", stringBuilder.toString());
            if (this.c.get()) {
                Log.i("QueueProcessor", "  don't proceed, a call is executing");
            } else {
                a();
            }
        }
    }

    public int b() {
        int size;
        synchronized (this.e) {
            size = this.d.size();
        }
        return size;
    }

    public void c() {
        try {
            if (this.g != null) {
                this.g.cancel(true);
            }
        } catch (Exception unused) {
            synchronized (this.e) {
                this.d.clear();
                this.f.shutdownNow();
                synchronized (this.b) {
                    this.a.clear();
                    this.c.set(false);
                }
            }
        }
    }

    public void a(Class<? extends ApiCall> cls, Subscriber subscriber) {
        synchronized (this.b) {
            if (this.a.containsKey(cls)) {
                Log.i("QueueProcessor", String.format("unregister(): removing %s (previously registered for %s)", new Object[]{subscriber.getClass().getSimpleName(), cls.getSimpleName()}));
                ((List) this.a.get(cls)).remove(subscriber);
            }
        }
    }
}
