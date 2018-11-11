package android.arch.persistence.room;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class InvalidationTracker {
    private static final String[] ch = new String[]{"UPDATE", "DELETE", "INSERT"};
    @VisibleForTesting
    Runnable aH;
    @VisibleForTesting
    @NonNull
    ArrayMap<String, Integer> ci;
    private String[] cj;
    @VisibleForTesting
    @NonNull
    long[] ck;
    private Object[] cl = new Object[1];
    private long cm = 0;
    private final RoomDatabase co;
    AtomicBoolean cp;
    private volatile SupportSQLiteStatement cq;
    private ObservedTableTracker cr;
    @VisibleForTesting
    final SafeIterableMap<Observer, ObserverWrapper> cs;
    private volatile boolean mInitialized;

    static class ObservedTableTracker {
        final long[] cu;
        final boolean[] cv;
        final int[] cw;
        boolean cx;
        boolean cy;

        ObservedTableTracker(int i) {
            this.cu = new long[i];
            this.cv = new boolean[i];
            this.cw = new int[i];
            Arrays.fill(this.cu, 0);
            Arrays.fill(this.cv, false);
        }

        boolean c(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.cu[i];
                    this.cu[i] = j + 1;
                    if (j == 0) {
                        this.cx = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        boolean d(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.cu[i];
                    this.cu[i] = j - 1;
                    if (j == 1) {
                        this.cx = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        @Nullable
        int[] al() {
            synchronized (this) {
                if (!this.cx || this.cy) {
                    return null;
                }
                int length = this.cu.length;
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i < length) {
                        boolean z2 = this.cu[i] > 0;
                        if (z2 != this.cv[i]) {
                            int[] iArr = this.cw;
                            if (!z2) {
                                z = true;
                            }
                            iArr[i] = z;
                        } else {
                            this.cw[i] = 0;
                        }
                        this.cv[i] = z2;
                        i++;
                    } else {
                        this.cy = true;
                        this.cx = false;
                        int[] iArr2 = this.cw;
                        return iArr2;
                    }
                }
            }
        }

        void am() {
            synchronized (this) {
                this.cy = false;
            }
        }
    }

    public static abstract class Observer {
        final String[] cz;

        public abstract void a(@NonNull Set<String> set);

        protected Observer(@NonNull String str, String... strArr) {
            this.cz = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.cz[strArr.length] = str;
        }

        public Observer(@NonNull String[] strArr) {
            this.cz = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    static class ObserverWrapper {
        final int[] cA;
        private final long[] cB;
        final Observer cC;
        private final Set<String> cD;
        private final String[] cj;

        ObserverWrapper(Observer observer, int[] iArr, String[] strArr, long[] jArr) {
            this.cC = observer;
            this.cA = iArr;
            this.cj = strArr;
            this.cB = jArr;
            if (iArr.length == 1) {
                Set arraySet = new ArraySet();
                arraySet.add(this.cj[0]);
                this.cD = Collections.unmodifiableSet(arraySet);
                return;
            }
            this.cD = null;
        }

        void a(long[] jArr) {
            int length = this.cA.length;
            Set set = null;
            for (int i = 0; i < length; i++) {
                long j = jArr[this.cA[i]];
                if (this.cB[i] < j) {
                    this.cB[i] = j;
                    if (length == 1) {
                        set = this.cD;
                    } else {
                        if (set == null) {
                            set = new ArraySet(length);
                        }
                        set.add(this.cj[i]);
                    }
                }
            }
            if (set != null) {
                this.cC.a(set);
            }
        }
    }

    static class WeakObserver extends Observer {
        final InvalidationTracker cE;
        final WeakReference<Observer> cF;

        WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.cz);
            this.cE = invalidationTracker;
            this.cF = new WeakReference(observer);
        }

        public void a(@NonNull Set<String> set) {
            Observer observer = (Observer) this.cF.get();
            if (observer == null) {
                this.cE.c((Observer) this);
            } else {
                observer.a(set);
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        int i = 0;
        this.cp = new AtomicBoolean(false);
        this.mInitialized = false;
        this.cs = new SafeIterableMap();
        this.aH = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A:{Splitter: B:1:0x000b, ExcHandler: java.lang.IllegalStateException (e java.lang.IllegalStateException)} */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A:{Splitter: B:24:0x0076, ExcHandler: java.lang.IllegalStateException (r1_1 'e' java.lang.Throwable)} */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x009f  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0087 A:{Splitter: B:31:0x0083, ExcHandler: java.lang.IllegalStateException (e java.lang.IllegalStateException)} */
            /* JADX WARNING: Missing block: B:26:0x007a, code:
            r1 = move-exception;
     */
            /* JADX WARNING: Missing block: B:27:0x007b, code:
            r2 = r1;
     */
            /* JADX WARNING: Missing block: B:34:0x0087, code:
            r2 = e;
     */
            /* JADX WARNING: Missing block: B:35:0x0088, code:
            r3 = r1;
     */
            /* JADX WARNING: Missing block: B:39:0x0091, code:
            r2 = e;
     */
            /* JADX WARNING: Missing block: B:40:0x0092, code:
            r3 = false;
     */
            /* JADX WARNING: Missing block: B:42:?, code:
            android.util.Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", r2);
     */
            /* JADX WARNING: Missing block: B:57:0x00cc, code:
            r0.unlock();
     */
            public void run() {
                /*
                r6 = this;
                r0 = android.arch.persistence.room.InvalidationTracker.this;
                r0 = r0.co;
                r0 = r0.an();
                r1 = 0;
                r0.lock();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.ah();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                if (r2 != 0) goto L_0x001a;
            L_0x0016:
                r0.unlock();
                return;
            L_0x001a:
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.cp;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r3 = 1;
                r2 = r2.compareAndSet(r3, r1);	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                if (r2 != 0) goto L_0x0029;
            L_0x0025:
                r0.unlock();
                return;
            L_0x0029:
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.co;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.inTransaction();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                if (r2 == 0) goto L_0x0039;
            L_0x0035:
                r0.unlock();
                return;
            L_0x0039:
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.cq;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2.executeUpdateDelete();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.cl;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r3 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r3 = r3.cm;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r3 = java.lang.Long.valueOf(r3);	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2[r1] = r3;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.co;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.cK;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                if (r2 == 0) goto L_0x008a;
            L_0x005e:
                r2 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.co;	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.ao();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2 = r2.ae();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                r2.beginTransaction();	 Catch:{ all -> 0x0082 }
                r3 = r6.ak();	 Catch:{ all -> 0x0082 }
                r2.setTransactionSuccessful();	 Catch:{ all -> 0x007d }
                r2.endTransaction();	 Catch:{ IllegalStateException -> 0x007a, IllegalStateException -> 0x007a }
                goto L_0x009a;
            L_0x007a:
                r1 = move-exception;
                r2 = r1;
                goto L_0x0093;
            L_0x007d:
                r1 = move-exception;
                r5 = r3;
                r3 = r1;
                r1 = r5;
                goto L_0x0083;
            L_0x0082:
                r3 = move-exception;
            L_0x0083:
                r2.endTransaction();	 Catch:{ IllegalStateException -> 0x0087, IllegalStateException -> 0x0087 }
                throw r3;	 Catch:{ IllegalStateException -> 0x0087, IllegalStateException -> 0x0087 }
            L_0x0087:
                r2 = move-exception;
                r3 = r1;
                goto L_0x0093;
            L_0x008a:
                r3 = r6.ak();	 Catch:{ IllegalStateException -> 0x0091, IllegalStateException -> 0x0091 }
                goto L_0x009a;
            L_0x008f:
                r1 = move-exception;
                goto L_0x00cc;
            L_0x0091:
                r2 = move-exception;
                r3 = 0;
            L_0x0093:
                r1 = "ROOM";
                r4 = "Cannot run invalidation tracker. Is the db closed?";
                android.util.Log.e(r1, r4, r2);	 Catch:{ all -> 0x008f }
            L_0x009a:
                r0.unlock();
                if (r3 == 0) goto L_0x00cb;
            L_0x009f:
                r0 = android.arch.persistence.room.InvalidationTracker.this;
                r0 = r0.cs;
                monitor-enter(r0);
                r1 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ all -> 0x00c8 }
                r1 = r1.cs;	 Catch:{ all -> 0x00c8 }
                r1 = r1.iterator();	 Catch:{ all -> 0x00c8 }
            L_0x00ac:
                r2 = r1.hasNext();	 Catch:{ all -> 0x00c8 }
                if (r2 == 0) goto L_0x00c6;
            L_0x00b2:
                r2 = r1.next();	 Catch:{ all -> 0x00c8 }
                r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x00c8 }
                r2 = r2.getValue();	 Catch:{ all -> 0x00c8 }
                r2 = (android.arch.persistence.room.InvalidationTracker.ObserverWrapper) r2;	 Catch:{ all -> 0x00c8 }
                r3 = android.arch.persistence.room.InvalidationTracker.this;	 Catch:{ all -> 0x00c8 }
                r3 = r3.ck;	 Catch:{ all -> 0x00c8 }
                r2.a(r3);	 Catch:{ all -> 0x00c8 }
                goto L_0x00ac;
            L_0x00c6:
                monitor-exit(r0);	 Catch:{ all -> 0x00c8 }
                goto L_0x00cb;
            L_0x00c8:
                r1 = move-exception;
                monitor-exit(r0);	 Catch:{ all -> 0x00c8 }
                throw r1;
            L_0x00cb:
                return;
            L_0x00cc:
                r0.unlock();
                throw r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.arch.persistence.room.InvalidationTracker.1.run():void");
            }

            private boolean ak() {
                Cursor a = InvalidationTracker.this.co.a("SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;", InvalidationTracker.this.cl);
                boolean z = false;
                while (a.moveToNext()) {
                    try {
                        long j = a.getLong(0);
                        InvalidationTracker.this.ck[a.getInt(1)] = j;
                        InvalidationTracker.this.cm = j;
                        z = true;
                    } finally {
                        a.close();
                    }
                }
                return z;
            }
        };
        this.co = roomDatabase;
        this.cr = new ObservedTableTracker(strArr.length);
        this.ci = new ArrayMap();
        int length = strArr.length;
        this.cj = new String[length];
        while (i < length) {
            String toLowerCase = strArr[i].toLowerCase(Locale.US);
            this.ci.put(toLowerCase, Integer.valueOf(i));
            this.cj[i] = toLowerCase;
            i++;
        }
        this.ck = new long[strArr.length];
        Arrays.fill(this.ck, 0);
    }

    void e(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
                supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
                supportSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log(version INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER)");
                supportSQLiteDatabase.setTransactionSuccessful();
                f(supportSQLiteDatabase);
                this.cq = supportSQLiteDatabase.h("DELETE FROM room_table_modification_log WHERE version NOT IN( SELECT MAX(version) FROM room_table_modification_log GROUP BY table_id)");
                this.mInitialized = true;
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("`");
        stringBuilder.append("room_table_modification_trigger_");
        stringBuilder.append(str);
        stringBuilder.append("_");
        stringBuilder.append(str2);
        stringBuilder.append("`");
    }

    private void a(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.cj[i];
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : ch) {
            stringBuilder.setLength(0);
            stringBuilder.append("DROP TRIGGER IF EXISTS ");
            a(stringBuilder, str, str2);
            supportSQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    private void b(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.cj[i];
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : ch) {
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a(stringBuilder, str, str2);
            stringBuilder.append(" AFTER ");
            stringBuilder.append(str2);
            stringBuilder.append(" ON `");
            stringBuilder.append(str);
            stringBuilder.append("` BEGIN INSERT OR REPLACE INTO ");
            stringBuilder.append("room_table_modification_log");
            stringBuilder.append(" VALUES(null, ");
            stringBuilder.append(i);
            stringBuilder.append("); END");
            supportSQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    @WorkerThread
    public void a(@NonNull Observer observer) {
        ObserverWrapper observerWrapper;
        String[] strArr = observer.cz;
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        long[] jArr = new long[strArr.length];
        for (int i = 0; i < length; i++) {
            Integer num = (Integer) this.ci.get(strArr[i].toLowerCase(Locale.US));
            if (num == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("There is no table with name ");
                stringBuilder.append(strArr[i]);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            iArr[i] = num.intValue();
            jArr[i] = this.cm;
        }
        ObserverWrapper observerWrapper2 = new ObserverWrapper(observer, iArr, strArr, jArr);
        synchronized (this.cs) {
            observerWrapper = (ObserverWrapper) this.cs.putIfAbsent(observer, observerWrapper2);
        }
        if (observerWrapper == null && this.cr.c(iArr)) {
            aj();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void b(Observer observer) {
        a(new WeakObserver(this, observer));
    }

    @WorkerThread
    public void c(@NonNull Observer observer) {
        ObserverWrapper observerWrapper;
        synchronized (this.cs) {
            observerWrapper = (ObserverWrapper) this.cs.remove(observer);
        }
        if (observerWrapper != null && this.cr.d(observerWrapper.cA)) {
            aj();
        }
    }

    private boolean ah() {
        if (!this.co.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.co.ao().ae();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void ai() {
        if (this.cp.compareAndSet(false, true)) {
            ArchTaskExecutor.A().a(this.aH);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x004c A:{Splitter: B:3:0x0007, ExcHandler: java.lang.IllegalStateException (r6_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:35:0x004c, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:36:0x004d, code:
            android.util.Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", r6);
     */
    /* JADX WARNING: Missing block: B:37:0x0054, code:
            return;
     */
    void f(android.arch.persistence.db.SupportSQLiteDatabase r6) {
        /*
        r5 = this;
        r0 = r6.inTransaction();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r5.co;	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
        r0 = r0.an();	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
        r0.lock();	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
        r1 = r5.cr;	 Catch:{ all -> 0x0047 }
        r1 = r1.al();	 Catch:{ all -> 0x0047 }
        if (r1 != 0) goto L_0x001c;
    L_0x0018:
        r0.unlock();	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
        return;
    L_0x001c:
        r2 = r1.length;	 Catch:{ all -> 0x0047 }
        r6.beginTransaction();	 Catch:{ all -> 0x0042 }
        r3 = 0;
    L_0x0021:
        if (r3 >= r2) goto L_0x0033;
    L_0x0023:
        r4 = r1[r3];	 Catch:{ all -> 0x0042 }
        switch(r4) {
            case 1: goto L_0x002d;
            case 2: goto L_0x0029;
            default: goto L_0x0028;
        };	 Catch:{ all -> 0x0042 }
    L_0x0028:
        goto L_0x0030;
    L_0x0029:
        r5.a(r6, r3);	 Catch:{ all -> 0x0042 }
        goto L_0x0030;
    L_0x002d:
        r5.b(r6, r3);	 Catch:{ all -> 0x0042 }
    L_0x0030:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0033:
        r6.setTransactionSuccessful();	 Catch:{ all -> 0x0042 }
        r6.endTransaction();	 Catch:{ all -> 0x0047 }
        r1 = r5.cr;	 Catch:{ all -> 0x0047 }
        r1.am();	 Catch:{ all -> 0x0047 }
        r0.unlock();	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
        goto L_0x0007;
    L_0x0042:
        r1 = move-exception;
        r6.endTransaction();	 Catch:{ all -> 0x0047 }
        throw r1;	 Catch:{ all -> 0x0047 }
    L_0x0047:
        r6 = move-exception;
        r0.unlock();	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
        throw r6;	 Catch:{ IllegalStateException -> 0x004c, IllegalStateException -> 0x004c }
    L_0x004c:
        r6 = move-exception;
        r0 = "ROOM";
        r1 = "Cannot run invalidation tracker. Is the db closed?";
        android.util.Log.e(r0, r1, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.persistence.room.InvalidationTracker.f(android.arch.persistence.db.SupportSQLiteDatabase):void");
    }

    void aj() {
        if (this.co.isOpen()) {
            f(this.co.ao().ae());
        }
    }
}
