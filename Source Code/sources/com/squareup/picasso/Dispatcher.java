package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class Dispatcher {
    static final int AIRPLANE_MODE_CHANGE = 10;
    private static final int AIRPLANE_MODE_OFF = 0;
    private static final int AIRPLANE_MODE_ON = 1;
    private static final int BATCH_DELAY = 200;
    private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
    static final int HUNTER_BATCH_COMPLETE = 8;
    static final int HUNTER_COMPLETE = 4;
    static final int HUNTER_DECODE_FAILED = 6;
    static final int HUNTER_DELAY_NEXT_BATCH = 7;
    static final int HUNTER_RETRY = 5;
    static final int NETWORK_STATE_CHANGE = 9;
    static final int REQUEST_BATCH_RESUME = 13;
    static final int REQUEST_CANCEL = 2;
    static final int REQUEST_GCED = 3;
    static final int REQUEST_SUBMIT = 1;
    private static final int RETRY_DELAY = 500;
    static final int TAG_PAUSE = 11;
    static final int TAG_RESUME = 12;
    boolean airplaneMode;
    final List<BitmapHunter> batch;
    final Cache cache;
    final Context context;
    final DispatcherThread dispatcherThread = new DispatcherThread();
    final Downloader downloader;
    final Map<Object, Action> failedActions;
    final Handler handler;
    final Map<String, BitmapHunter> hunterMap;
    final Handler mainThreadHandler;
    final Map<Object, Action> pausedActions;
    final Set<Object> pausedTags;
    final NetworkBroadcastReceiver receiver;
    final boolean scansNetworkChanges;
    final ExecutorService service;
    final Stats stats;

    private static class DispatcherHandler extends Handler {
        private final Dispatcher dispatcher;

        public DispatcherHandler(Looper looper, Dispatcher dispatcher) {
            super(looper);
            this.dispatcher = dispatcher;
        }

        public void handleMessage(final Message message) {
            boolean z = false;
            switch (message.what) {
                case 1:
                    this.dispatcher.performSubmit((Action) message.obj);
                    return;
                case 2:
                    this.dispatcher.performCancel((Action) message.obj);
                    return;
                case 4:
                    this.dispatcher.performComplete((BitmapHunter) message.obj);
                    return;
                case 5:
                    this.dispatcher.performRetry((BitmapHunter) message.obj);
                    return;
                case 6:
                    this.dispatcher.performError((BitmapHunter) message.obj, false);
                    return;
                case 7:
                    this.dispatcher.performBatchComplete();
                    return;
                case 9:
                    this.dispatcher.performNetworkStateChange((NetworkInfo) message.obj);
                    return;
                case 10:
                    Dispatcher dispatcher = this.dispatcher;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    dispatcher.performAirplaneModeChange(z);
                    return;
                case 11:
                    this.dispatcher.performPauseTag(message.obj);
                    return;
                case 12:
                    this.dispatcher.performResumeTag(message.obj);
                    return;
                default:
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown handler message received: ");
                            stringBuilder.append(message.what);
                            throw new AssertionError(stringBuilder.toString());
                        }
                    });
                    return;
            }
        }
    }

    static class DispatcherThread extends HandlerThread {
        DispatcherThread() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class NetworkBroadcastReceiver extends BroadcastReceiver {
        static final String EXTRA_AIRPLANE_STATE = "state";
        private final Dispatcher dispatcher;

        NetworkBroadcastReceiver(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        void register() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.dispatcher.scansNetworkChanges) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.dispatcher.context.registerReceiver(this, intentFilter);
        }

        void unregister() {
            this.dispatcher.context.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra(EXTRA_AIRPLANE_STATE)) {
                        this.dispatcher.dispatchAirplaneModeChange(intent.getBooleanExtra(EXTRA_AIRPLANE_STATE, false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.dispatcher.dispatchNetworkStateChange(((ConnectivityManager) Utils.getService(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    Dispatcher(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, Stats stats) {
        this.dispatcherThread.start();
        Utils.flushStackLocalLeaks(this.dispatcherThread.getLooper());
        this.context = context;
        this.service = executorService;
        this.hunterMap = new LinkedHashMap();
        this.failedActions = new WeakHashMap();
        this.pausedActions = new WeakHashMap();
        this.pausedTags = new HashSet();
        this.handler = new DispatcherHandler(this.dispatcherThread.getLooper(), this);
        this.downloader = downloader;
        this.mainThreadHandler = handler;
        this.cache = cache;
        this.stats = stats;
        this.batch = new ArrayList(4);
        this.airplaneMode = Utils.isAirplaneModeOn(this.context);
        this.scansNetworkChanges = Utils.hasPermission(context, "android.permission.ACCESS_NETWORK_STATE");
        this.receiver = new NetworkBroadcastReceiver(this);
        this.receiver.register();
    }

    void shutdown() {
        if (this.service instanceof PicassoExecutorService) {
            this.service.shutdown();
        }
        this.downloader.shutdown();
        this.dispatcherThread.quit();
        Picasso.HANDLER.post(new Runnable() {
            public void run() {
                Dispatcher.this.receiver.unregister();
            }
        });
    }

    void dispatchSubmit(Action action) {
        this.handler.sendMessage(this.handler.obtainMessage(1, action));
    }

    void dispatchCancel(Action action) {
        this.handler.sendMessage(this.handler.obtainMessage(2, action));
    }

    void dispatchPauseTag(Object obj) {
        this.handler.sendMessage(this.handler.obtainMessage(11, obj));
    }

    void dispatchResumeTag(Object obj) {
        this.handler.sendMessage(this.handler.obtainMessage(12, obj));
    }

    void dispatchComplete(BitmapHunter bitmapHunter) {
        this.handler.sendMessage(this.handler.obtainMessage(4, bitmapHunter));
    }

    void dispatchRetry(BitmapHunter bitmapHunter) {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(5, bitmapHunter), 500);
    }

    void dispatchFailed(BitmapHunter bitmapHunter) {
        this.handler.sendMessage(this.handler.obtainMessage(6, bitmapHunter));
    }

    void dispatchNetworkStateChange(NetworkInfo networkInfo) {
        this.handler.sendMessage(this.handler.obtainMessage(9, networkInfo));
    }

    void dispatchAirplaneModeChange(boolean z) {
        this.handler.sendMessage(this.handler.obtainMessage(10, z, 0));
    }

    void performSubmit(Action action) {
        performSubmit(action, true);
    }

    void performSubmit(Action action, boolean z) {
        if (this.pausedTags.contains(action.getTag())) {
            this.pausedActions.put(action.getTarget(), action);
            if (action.getPicasso().loggingEnabled) {
                String logId = action.request.logId();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("because tag '");
                stringBuilder.append(action.getTag());
                stringBuilder.append("' is paused");
                Utils.log(DISPATCHER_THREAD_NAME, "paused", logId, stringBuilder.toString());
            }
            return;
        }
        BitmapHunter bitmapHunter = (BitmapHunter) this.hunterMap.get(action.getKey());
        if (bitmapHunter != null) {
            bitmapHunter.attach(action);
        } else if (this.service.isShutdown()) {
            if (action.getPicasso().loggingEnabled) {
                Utils.log(DISPATCHER_THREAD_NAME, "ignored", action.request.logId(), "because shut down");
            }
        } else {
            Object forRequest = BitmapHunter.forRequest(action.getPicasso(), this, this.cache, this.stats, action);
            forRequest.future = this.service.submit(forRequest);
            this.hunterMap.put(action.getKey(), forRequest);
            if (z) {
                this.failedActions.remove(action.getTarget());
            }
            if (action.getPicasso().loggingEnabled) {
                Utils.log(DISPATCHER_THREAD_NAME, "enqueued", action.request.logId());
            }
        }
    }

    void performCancel(Action action) {
        String key = action.getKey();
        BitmapHunter bitmapHunter = (BitmapHunter) this.hunterMap.get(key);
        if (bitmapHunter != null) {
            bitmapHunter.detach(action);
            if (bitmapHunter.cancel()) {
                this.hunterMap.remove(key);
                if (action.getPicasso().loggingEnabled) {
                    Utils.log(DISPATCHER_THREAD_NAME, "canceled", action.getRequest().logId());
                }
            }
        }
        if (this.pausedTags.contains(action.getTag())) {
            this.pausedActions.remove(action.getTarget());
            if (action.getPicasso().loggingEnabled) {
                Utils.log(DISPATCHER_THREAD_NAME, "canceled", action.getRequest().logId(), "because paused request got canceled");
            }
        }
        action = (Action) this.failedActions.remove(action.getTarget());
        if (action != null && action.getPicasso().loggingEnabled) {
            Utils.log(DISPATCHER_THREAD_NAME, "canceled", action.getRequest().logId(), "from replaying");
        }
    }

    void performPauseTag(Object obj) {
        if (this.pausedTags.add(obj)) {
            Iterator it = this.hunterMap.values().iterator();
            while (it.hasNext()) {
                BitmapHunter bitmapHunter = (BitmapHunter) it.next();
                boolean z = bitmapHunter.getPicasso().loggingEnabled;
                Action action = bitmapHunter.getAction();
                List actions = bitmapHunter.getActions();
                Object obj2 = (actions == null || actions.isEmpty()) ? null : 1;
                if (action != null || obj2 != null) {
                    if (action != null && action.getTag().equals(obj)) {
                        bitmapHunter.detach(action);
                        this.pausedActions.put(action.getTarget(), action);
                        if (z) {
                            String logId = action.request.logId();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("because tag '");
                            stringBuilder.append(obj);
                            stringBuilder.append("' was paused");
                            Utils.log(DISPATCHER_THREAD_NAME, "paused", logId, stringBuilder.toString());
                        }
                    }
                    if (obj2 != null) {
                        for (int size = actions.size() - 1; size >= 0; size--) {
                            Action action2 = (Action) actions.get(size);
                            if (action2.getTag().equals(obj)) {
                                bitmapHunter.detach(action2);
                                this.pausedActions.put(action2.getTarget(), action2);
                                if (z) {
                                    String logId2 = action2.request.logId();
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("because tag '");
                                    stringBuilder2.append(obj);
                                    stringBuilder2.append("' was paused");
                                    Utils.log(DISPATCHER_THREAD_NAME, "paused", logId2, stringBuilder2.toString());
                                }
                            }
                        }
                    }
                    if (bitmapHunter.cancel()) {
                        it.remove();
                        if (z) {
                            Utils.log(DISPATCHER_THREAD_NAME, "canceled", Utils.getLogIdsForHunter(bitmapHunter), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void performResumeTag(Object obj) {
        if (this.pausedTags.remove(obj)) {
            Object obj2 = null;
            Iterator it = this.pausedActions.values().iterator();
            while (it.hasNext()) {
                Action action = (Action) it.next();
                if (action.getTag().equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(action);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.mainThreadHandler.sendMessage(this.mainThreadHandler.obtainMessage(13, obj2));
            }
        }
    }

    void performRetry(BitmapHunter bitmapHunter) {
        if (!bitmapHunter.isCancelled()) {
            boolean z = false;
            if (this.service.isShutdown()) {
                performError(bitmapHunter, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.scansNetworkChanges) {
                networkInfo = ((ConnectivityManager) Utils.getService(this.context, "connectivity")).getActiveNetworkInfo();
            }
            if (bitmapHunter.shouldRetry(this.airplaneMode, networkInfo)) {
                if (bitmapHunter.getPicasso().loggingEnabled) {
                    Utils.log(DISPATCHER_THREAD_NAME, "retrying", Utils.getLogIdsForHunter(bitmapHunter));
                }
                if (bitmapHunter.getException() instanceof ContentLengthException) {
                    bitmapHunter.networkPolicy |= NetworkPolicy.NO_CACHE.index;
                }
                bitmapHunter.future = this.service.submit(bitmapHunter);
            } else {
                if (this.scansNetworkChanges && bitmapHunter.supportsReplay()) {
                    z = true;
                }
                performError(bitmapHunter, z);
                if (z) {
                    markForReplay(bitmapHunter);
                }
            }
        }
    }

    void performComplete(BitmapHunter bitmapHunter) {
        if (MemoryPolicy.shouldWriteToMemoryCache(bitmapHunter.getMemoryPolicy())) {
            this.cache.set(bitmapHunter.getKey(), bitmapHunter.getResult());
        }
        this.hunterMap.remove(bitmapHunter.getKey());
        batch(bitmapHunter);
        if (bitmapHunter.getPicasso().loggingEnabled) {
            Utils.log(DISPATCHER_THREAD_NAME, "batched", Utils.getLogIdsForHunter(bitmapHunter), "for completion");
        }
    }

    void performBatchComplete() {
        List arrayList = new ArrayList(this.batch);
        this.batch.clear();
        this.mainThreadHandler.sendMessage(this.mainThreadHandler.obtainMessage(8, arrayList));
        logBatch(arrayList);
    }

    void performError(BitmapHunter bitmapHunter, boolean z) {
        if (bitmapHunter.getPicasso().loggingEnabled) {
            String str = DISPATCHER_THREAD_NAME;
            String str2 = "batched";
            String logIdsForHunter = Utils.getLogIdsForHunter(bitmapHunter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("for error");
            stringBuilder.append(z ? " (will replay)" : "");
            Utils.log(str, str2, logIdsForHunter, stringBuilder.toString());
        }
        this.hunterMap.remove(bitmapHunter.getKey());
        batch(bitmapHunter);
    }

    void performAirplaneModeChange(boolean z) {
        this.airplaneMode = z;
    }

    void performNetworkStateChange(NetworkInfo networkInfo) {
        if (this.service instanceof PicassoExecutorService) {
            ((PicassoExecutorService) this.service).adjustThreadCount(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            flushFailedActions();
        }
    }

    private void flushFailedActions() {
        if (!this.failedActions.isEmpty()) {
            Iterator it = this.failedActions.values().iterator();
            while (it.hasNext()) {
                Action action = (Action) it.next();
                it.remove();
                if (action.getPicasso().loggingEnabled) {
                    Utils.log(DISPATCHER_THREAD_NAME, "replaying", action.getRequest().logId());
                }
                performSubmit(action, false);
            }
        }
    }

    private void markForReplay(BitmapHunter bitmapHunter) {
        Action action = bitmapHunter.getAction();
        if (action != null) {
            markForReplay(action);
        }
        List actions = bitmapHunter.getActions();
        if (actions != null) {
            int size = actions.size();
            for (int i = 0; i < size; i++) {
                markForReplay((Action) actions.get(i));
            }
        }
    }

    private void markForReplay(Action action) {
        Object target = action.getTarget();
        if (target != null) {
            action.willReplay = true;
            this.failedActions.put(target, action);
        }
    }

    private void batch(BitmapHunter bitmapHunter) {
        if (!bitmapHunter.isCancelled()) {
            this.batch.add(bitmapHunter);
            if (!this.handler.hasMessages(7)) {
                this.handler.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    /* JADX WARNING: Missing block: B:14:0x004c, code:
            return;
     */
    private void logBatch(java.util.List<com.squareup.picasso.BitmapHunter> r4) {
        /*
        r3 = this;
        if (r4 == 0) goto L_0x004c;
    L_0x0002:
        r0 = r4.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x004c;
    L_0x0009:
        r0 = 0;
        r0 = r4.get(r0);
        r0 = (com.squareup.picasso.BitmapHunter) r0;
        r0 = r0.getPicasso();
        r0 = r0.loggingEnabled;
        if (r0 == 0) goto L_0x004b;
    L_0x0018:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = r4.iterator();
    L_0x0021:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x0040;
    L_0x0027:
        r1 = r4.next();
        r1 = (com.squareup.picasso.BitmapHunter) r1;
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0038;
    L_0x0033:
        r2 = ", ";
        r0.append(r2);
    L_0x0038:
        r1 = com.squareup.picasso.Utils.getLogIdsForHunter(r1);
        r0.append(r1);
        goto L_0x0021;
    L_0x0040:
        r4 = "Dispatcher";
        r1 = "delivered";
        r0 = r0.toString();
        com.squareup.picasso.Utils.log(r4, r1, r0);
    L_0x004b:
        return;
    L_0x004c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Dispatcher.logBatch(java.util.List):void");
    }
}
