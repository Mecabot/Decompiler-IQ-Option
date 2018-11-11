package com.jumio.commons.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class JumioBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static JumioBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList();
    private final HashMap<String, Intent> mPendingIntents = new HashMap();
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();

    private static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    private static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.receiver);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static JumioBroadcastManager getInstance(Context context) {
        JumioBroadcastManager jumioBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new JumioBroadcastManager(context.getApplicationContext());
            }
            jumioBroadcastManager = mInstance;
        }
        return jumioBroadcastManager;
    }

    public static synchronized void destroy() {
        synchronized (JumioBroadcastManager.class) {
            if (mInstance == null) {
                return;
            }
            if (mInstance.mActions != null) {
                mInstance.mActions.clear();
            }
            if (mInstance.mPendingIntents != null) {
                mInstance.mPendingIntents.clear();
            }
            mInstance = null;
        }
    }

    private JumioBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    JumioBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                if (this.mPendingIntents.containsKey(action)) {
                    arrayList2.add(action);
                }
                ArrayList arrayList3 = (ArrayList) this.mActions.get(action);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList(1);
                    this.mActions.put(action, arrayList3);
                }
                arrayList3.add(receiverRecord);
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                sendBroadcast((Intent) this.mPendingIntents.get(str));
                this.mPendingIntents.remove(str);
            }
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList arrayList = (ArrayList) this.mReceivers.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            if (((ReceiverRecord) arrayList2.get(i3)).receiver == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i3--;
                            }
                            i3++;
                        }
                        if (arrayList2.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        return sendBroadcast(intent, false);
    }

    /* JADX WARNING: Missing block: B:50:0x0170, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:56:0x0180, code:
            return r6;
     */
    public boolean sendBroadcast(android.content.Intent r24, boolean r25) {
        /*
        r23 = this;
        r1 = r23;
        r2 = r24;
        r3 = r1.mReceivers;
        monitor-enter(r3);
        r11 = r24.getAction();	 Catch:{ all -> 0x0181 }
        r4 = r1.mAppContext;	 Catch:{ all -> 0x0181 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x0181 }
        r12 = r2.resolveTypeIfNeeded(r4);	 Catch:{ all -> 0x0181 }
        r13 = r24.getData();	 Catch:{ all -> 0x0181 }
        r14 = r24.getScheme();	 Catch:{ all -> 0x0181 }
        r15 = r24.getCategories();	 Catch:{ all -> 0x0181 }
        r4 = r24.getFlags();	 Catch:{ all -> 0x0181 }
        r4 = r4 & 8;
        if (r4 == 0) goto L_0x002c;
    L_0x0029:
        r16 = 1;
        goto L_0x002e;
    L_0x002c:
        r16 = 0;
    L_0x002e:
        if (r16 == 0) goto L_0x0056;
    L_0x0030:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0181 }
        r5.<init>();	 Catch:{ all -> 0x0181 }
        r6 = "Resolving type ";
        r5.append(r6);	 Catch:{ all -> 0x0181 }
        r5.append(r12);	 Catch:{ all -> 0x0181 }
        r6 = " scheme ";
        r5.append(r6);	 Catch:{ all -> 0x0181 }
        r5.append(r14);	 Catch:{ all -> 0x0181 }
        r6 = " of intent ";
        r5.append(r6);	 Catch:{ all -> 0x0181 }
        r5.append(r2);	 Catch:{ all -> 0x0181 }
        r5 = r5.toString();	 Catch:{ all -> 0x0181 }
        com.jumio.commons.log.Log.v(r4, r5);	 Catch:{ all -> 0x0181 }
    L_0x0056:
        r4 = r1.mActions;	 Catch:{ all -> 0x0181 }
        r5 = r24.getAction();	 Catch:{ all -> 0x0181 }
        r4 = r4.get(r5);	 Catch:{ all -> 0x0181 }
        r8 = r4;
        r8 = (java.util.ArrayList) r8;	 Catch:{ all -> 0x0181 }
        if (r8 == 0) goto L_0x0173;
    L_0x0065:
        if (r16 == 0) goto L_0x007d;
    L_0x0067:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0181 }
        r5.<init>();	 Catch:{ all -> 0x0181 }
        r6 = "Action list: ";
        r5.append(r6);	 Catch:{ all -> 0x0181 }
        r5.append(r8);	 Catch:{ all -> 0x0181 }
        r5 = r5.toString();	 Catch:{ all -> 0x0181 }
        com.jumio.commons.log.Log.v(r4, r5);	 Catch:{ all -> 0x0181 }
    L_0x007d:
        r4 = 0;
        r6 = r4;
        r7 = 0;
    L_0x0080:
        r4 = r8.size();	 Catch:{ all -> 0x0181 }
        if (r7 >= r4) goto L_0x0141;
    L_0x0086:
        r4 = r8.get(r7);	 Catch:{ all -> 0x0181 }
        r5 = r4;
        r5 = (com.jumio.commons.utils.JumioBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0181 }
        if (r16 == 0) goto L_0x00a7;
    L_0x008f:
        r4 = "LocalBroadcastManager";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0181 }
        r9.<init>();	 Catch:{ all -> 0x0181 }
        r10 = "Matching against filter ";
        r9.append(r10);	 Catch:{ all -> 0x0181 }
        r10 = r5.filter;	 Catch:{ all -> 0x0181 }
        r9.append(r10);	 Catch:{ all -> 0x0181 }
        r9 = r9.toString();	 Catch:{ all -> 0x0181 }
        com.jumio.commons.log.Log.v(r4, r9);	 Catch:{ all -> 0x0181 }
    L_0x00a7:
        r4 = r5.broadcasting;	 Catch:{ all -> 0x0181 }
        if (r4 == 0) goto L_0x00c2;
    L_0x00ab:
        if (r16 == 0) goto L_0x00b4;
    L_0x00ad:
        r4 = "LocalBroadcastManager";
        r5 = "  Filter's target already added";
        com.jumio.commons.log.Log.v(r4, r5);	 Catch:{ all -> 0x0181 }
    L_0x00b4:
        r18 = r7;
        r19 = r8;
        r17 = r11;
        r20 = r12;
        r21 = r13;
        r13 = 1;
        r11 = r6;
        goto L_0x0134;
    L_0x00c2:
        r4 = r5.filter;	 Catch:{ all -> 0x0181 }
        r10 = "LocalBroadcastManager";
        r9 = r5;
        r5 = r11;
        r17 = r11;
        r11 = r6;
        r6 = r12;
        r18 = r7;
        r7 = r14;
        r19 = r8;
        r8 = r13;
        r20 = r12;
        r21 = r13;
        r13 = 1;
        r12 = r9;
        r9 = r15;
        r4 = r4.match(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0181 }
        if (r4 < 0) goto L_0x0109;
    L_0x00df:
        if (r16 == 0) goto L_0x00fb;
    L_0x00e1:
        r5 = "LocalBroadcastManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0181 }
        r6.<init>();	 Catch:{ all -> 0x0181 }
        r7 = "  Filter matched!  match=0x";
        r6.append(r7);	 Catch:{ all -> 0x0181 }
        r4 = java.lang.Integer.toHexString(r4);	 Catch:{ all -> 0x0181 }
        r6.append(r4);	 Catch:{ all -> 0x0181 }
        r4 = r6.toString();	 Catch:{ all -> 0x0181 }
        com.jumio.commons.log.Log.v(r5, r4);	 Catch:{ all -> 0x0181 }
    L_0x00fb:
        if (r11 != 0) goto L_0x0103;
    L_0x00fd:
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x0181 }
        r6.<init>();	 Catch:{ all -> 0x0181 }
        r11 = r6;
    L_0x0103:
        r11.add(r12);	 Catch:{ all -> 0x0181 }
        r12.broadcasting = r13;	 Catch:{ all -> 0x0181 }
        goto L_0x0134;
    L_0x0109:
        if (r16 == 0) goto L_0x0134;
    L_0x010b:
        switch(r4) {
            case -4: goto L_0x011c;
            case -3: goto L_0x0119;
            case -2: goto L_0x0116;
            case -1: goto L_0x0112;
            default: goto L_0x010e;
        };	 Catch:{ all -> 0x0181 }
    L_0x010e:
        r4 = "unknown reason";
        goto L_0x011e;
    L_0x0112:
        r4 = "type";
        goto L_0x011e;
    L_0x0116:
        r4 = "data";
        goto L_0x011e;
    L_0x0119:
        r4 = "action";
        goto L_0x011e;
    L_0x011c:
        r4 = "category";
    L_0x011e:
        r5 = "LocalBroadcastManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0181 }
        r6.<init>();	 Catch:{ all -> 0x0181 }
        r7 = "  Filter did not match: ";
        r6.append(r7);	 Catch:{ all -> 0x0181 }
        r6.append(r4);	 Catch:{ all -> 0x0181 }
        r4 = r6.toString();	 Catch:{ all -> 0x0181 }
        com.jumio.commons.log.Log.v(r5, r4);	 Catch:{ all -> 0x0181 }
    L_0x0134:
        r6 = r11;
        r7 = r18 + 1;
        r11 = r17;
        r8 = r19;
        r12 = r20;
        r13 = r21;
        goto L_0x0080;
    L_0x0141:
        r11 = r6;
        r13 = 1;
        if (r11 == 0) goto L_0x0171;
    L_0x0145:
        r4 = 0;
    L_0x0146:
        r5 = r11.size();	 Catch:{ all -> 0x0181 }
        if (r4 >= r5) goto L_0x0158;
    L_0x014c:
        r5 = r11.get(r4);	 Catch:{ all -> 0x0181 }
        r5 = (com.jumio.commons.utils.JumioBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0181 }
        r6 = 0;
        r5.broadcasting = r6;	 Catch:{ all -> 0x0181 }
        r4 = r4 + 1;
        goto L_0x0146;
    L_0x0158:
        r4 = r1.mPendingBroadcasts;	 Catch:{ all -> 0x0181 }
        r5 = new com.jumio.commons.utils.JumioBroadcastManager$BroadcastRecord;	 Catch:{ all -> 0x0181 }
        r5.<init>(r2, r11);	 Catch:{ all -> 0x0181 }
        r4.add(r5);	 Catch:{ all -> 0x0181 }
        r2 = r1.mHandler;	 Catch:{ all -> 0x0181 }
        r2 = r2.hasMessages(r13);	 Catch:{ all -> 0x0181 }
        if (r2 != 0) goto L_0x016f;
    L_0x016a:
        r2 = r1.mHandler;	 Catch:{ all -> 0x0181 }
        r2.sendEmptyMessage(r13);	 Catch:{ all -> 0x0181 }
    L_0x016f:
        monitor-exit(r3);	 Catch:{ all -> 0x0181 }
        return r13;
    L_0x0171:
        r6 = 0;
        goto L_0x017f;
    L_0x0173:
        r17 = r11;
        r6 = 0;
        if (r25 == 0) goto L_0x017f;
    L_0x0178:
        r4 = r1.mPendingIntents;	 Catch:{ all -> 0x0181 }
        r5 = r17;
        r4.put(r5, r2);	 Catch:{ all -> 0x0181 }
    L_0x017f:
        monitor-exit(r3);	 Catch:{ all -> 0x0181 }
        return r6;
    L_0x0181:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r3);	 Catch:{ all -> 0x0181 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.JumioBroadcastManager.sendBroadcast(android.content.Intent, boolean):boolean");
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001a, code:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:11:0x001d, code:
            if (r2 >= r1.length) goto L_0x0000;
     */
    /* JADX WARNING: Missing block: B:12:0x001f, code:
            r3 = r1[r2];
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x0028, code:
            if (r4 >= r3.receivers.size()) goto L_0x003e;
     */
    /* JADX WARNING: Missing block: B:15:0x002a, code:
            ((com.jumio.commons.utils.JumioBroadcastManager.ReceiverRecord) r3.receivers.get(r4)).receiver.onReceive(r8.mAppContext, r3.intent);
            r4 = r4 + 1;
     */
    /* JADX WARNING: Missing block: B:16:0x003e, code:
            r2 = r2 + 1;
     */
    private void executePendingBroadcasts() {
        /*
        r8 = this;
    L_0x0000:
        r0 = r8.mReceivers;
        monitor-enter(r0);
        r1 = r8.mPendingBroadcasts;	 Catch:{ all -> 0x0041 }
        r1 = r1.size();	 Catch:{ all -> 0x0041 }
        if (r1 > 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        return;
    L_0x000d:
        r1 = new com.jumio.commons.utils.JumioBroadcastManager.BroadcastRecord[r1];	 Catch:{ all -> 0x0041 }
        r2 = r8.mPendingBroadcasts;	 Catch:{ all -> 0x0041 }
        r2.toArray(r1);	 Catch:{ all -> 0x0041 }
        r2 = r8.mPendingBroadcasts;	 Catch:{ all -> 0x0041 }
        r2.clear();	 Catch:{ all -> 0x0041 }
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        r0 = 0;
        r2 = 0;
    L_0x001c:
        r3 = r1.length;
        if (r2 >= r3) goto L_0x0000;
    L_0x001f:
        r3 = r1[r2];
        r4 = 0;
    L_0x0022:
        r5 = r3.receivers;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x003e;
    L_0x002a:
        r5 = r3.receivers;
        r5 = r5.get(r4);
        r5 = (com.jumio.commons.utils.JumioBroadcastManager.ReceiverRecord) r5;
        r5 = r5.receiver;
        r6 = r8.mAppContext;
        r7 = r3.intent;
        r5.onReceive(r6, r7);
        r4 = r4 + 1;
        goto L_0x0022;
    L_0x003e:
        r2 = r2 + 1;
        goto L_0x001c;
    L_0x0041:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.JumioBroadcastManager.executePendingBroadcasts():void");
    }
}
