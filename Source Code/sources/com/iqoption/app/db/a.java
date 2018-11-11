package com.iqoption.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.dto.Event;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: EventDbHelper */
public class a extends SQLiteOpenHelper {
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public a(Context context) {
        super(context, "com.iqoption.db.event", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table events (_id integer primary key autoincrement, category text not null, name text not null, value real,time integer, duration integer, technical_logs integer, parameters text, platform_id integer, app_version text);");
    }

    @WorkerThread
    public long d(Event event) {
        return e(event);
    }

    private long e(Event event) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("category", event.category);
            contentValues.put("name", event.name);
            contentValues.put(b.VALUE, event.value);
            contentValues.put("time", event.time);
            contentValues.put("duration", event.duration);
            contentValues.put("technical_logs", Integer.valueOf(event.technical_logs.booleanValue()));
            if (event.parameters != null) {
                contentValues.put("parameters", event.parameters.toString());
            }
            contentValues.put("platform_id", event.platform_id);
            contentValues.put("app_version", event.app_version);
            writableDatabase.insert("events", null, contentValues);
            writableDatabase.setTransactionSuccessful();
            long b = b(writableDatabase);
            if (b > 5000) {
                event = FH();
                Event event2 = new Event(Event.CATEGORY_SYSTEM, "error_reached_limits_stored_events");
                event2.duration = Long.valueOf(event.time.longValue() - SystemClock.elapsedRealtime());
                gA();
                d(event2);
            }
            return b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    private long b(SQLiteDatabase sQLiteDatabase) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "events");
    }

    @WorkerThread
    public Long Bp() {
        return Long.valueOf(b(getReadableDatabase()));
    }

    private void gA() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.delete("events", null, null);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public void f(ArrayList<Event> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Event event = (Event) it.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("_id='");
                stringBuilder.append(event.id);
                stringBuilder.append("'");
                writableDatabase.delete("events", stringBuilder.toString(), null);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public Event FH() {
        ArrayList W = W("1", null);
        if (W.isEmpty()) {
            return null;
        }
        return (Event) W.get(0);
    }

    @WorkerThread
    public ArrayList<Event> aw(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("technical_logs='");
        stringBuilder.append(z);
        stringBuilder.append("'");
        return W("100", stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    @android.support.annotation.WorkerThread
    private java.util.ArrayList<com.iqoption.dto.Event> W(java.lang.String r14, java.lang.String r15) {
        /*
        r13 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = r13.getReadableDatabase();	 Catch:{ all -> 0x00f9 }
        r3 = "_id";
        r4 = "category";
        r5 = "name";
        r6 = "value";
        r7 = "time";
        r8 = "duration";
        r9 = "technical_logs";
        r10 = "parameters";
        r11 = "platform_id";
        r12 = "app_version";
        r4 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11, r12};	 Catch:{ all -> 0x00f9 }
        r3 = "events";
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r5 = r15;
        r10 = r14;
        r14 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x00f9 }
        if (r14 == 0) goto L_0x00ee;
    L_0x0033:
        r15 = r14.moveToLast();	 Catch:{ all -> 0x00ec }
        if (r15 != 0) goto L_0x0042;
    L_0x0039:
        r14.close();	 Catch:{ all -> 0x00ec }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r15 = 2;
        r15 = r14.getString(r15);	 Catch:{ all -> 0x00ec }
        r2 = new com.iqoption.dto.Event;	 Catch:{ all -> 0x00ec }
        r3 = 0;
        r4 = r14.getLong(r3);	 Catch:{ all -> 0x00ec }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x00ec }
        r5 = 1;
        r6 = r14.getString(r5);	 Catch:{ all -> 0x00ec }
        r2.<init>(r4, r6, r15);	 Catch:{ all -> 0x00ec }
        r4 = 3;
        r6 = r14.getDouble(r4);	 Catch:{ all -> 0x00ec }
        r4 = java.lang.Double.valueOf(r6);	 Catch:{ all -> 0x00ec }
        r2.value = r4;	 Catch:{ all -> 0x00ec }
        r4 = 4;
        r6 = r14.getLong(r4);	 Catch:{ all -> 0x00ec }
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00ec }
        r2.time = r4;	 Catch:{ all -> 0x00ec }
        r4 = 5;
        r6 = r14.getLong(r4);	 Catch:{ all -> 0x00ec }
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00ec }
        r2.duration = r4;	 Catch:{ all -> 0x00ec }
        r4 = 6;
        r4 = r14.getInt(r4);	 Catch:{ all -> 0x00ec }
        if (r4 != r5) goto L_0x0083;
    L_0x0082:
        r3 = 1;
    L_0x0083:
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x00ec }
        r2.technical_logs = r3;	 Catch:{ all -> 0x00ec }
        r3 = 7;
        r3 = r14.getString(r3);	 Catch:{ all -> 0x00ec }
        if (r3 == 0) goto L_0x00c6;
    L_0x0090:
        r4 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x009b }
        r4 = r4.parse(r3);	 Catch:{ Exception -> 0x009b }
        r2.parameters = r4;	 Catch:{ Exception -> 0x009b }
        goto L_0x00c6;
    L_0x009b:
        r4 = move-exception;
        if (r1 != 0) goto L_0x00a3;
    L_0x009e:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00ec }
        r1.<init>();	 Catch:{ all -> 0x00ec }
    L_0x00a3:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ec }
        r5.<init>();	 Catch:{ all -> 0x00ec }
        r6 = "unable to parse event ";
        r5.append(r6);	 Catch:{ all -> 0x00ec }
        r5.append(r15);	 Catch:{ all -> 0x00ec }
        r15 = ", params=";
        r5.append(r15);	 Catch:{ all -> 0x00ec }
        r5.append(r3);	 Catch:{ all -> 0x00ec }
        r15 = r5.toString();	 Catch:{ all -> 0x00ec }
        com.iqoption.util.k.log(r15);	 Catch:{ all -> 0x00ec }
        com.iqoption.util.k.c(r4);	 Catch:{ all -> 0x00ec }
        r1.add(r2);	 Catch:{ all -> 0x00ec }
    L_0x00c6:
        r15 = 8;
        r15 = r14.getInt(r15);	 Catch:{ all -> 0x00ec }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ all -> 0x00ec }
        r2.platform_id = r15;	 Catch:{ all -> 0x00ec }
        r15 = 9;
        r15 = r14.getString(r15);	 Catch:{ all -> 0x00ec }
        r2.app_version = r15;	 Catch:{ all -> 0x00ec }
        r15 = r2.app_version;	 Catch:{ all -> 0x00ec }
        if (r15 != 0) goto L_0x00e2;
    L_0x00de:
        r15 = "5.5.1";
        r2.app_version = r15;	 Catch:{ all -> 0x00ec }
    L_0x00e2:
        r0.add(r2);	 Catch:{ all -> 0x00ec }
        r15 = r14.moveToPrevious();	 Catch:{ all -> 0x00ec }
        if (r15 != 0) goto L_0x0042;
    L_0x00eb:
        goto L_0x00ee;
    L_0x00ec:
        r15 = move-exception;
        goto L_0x00fb;
    L_0x00ee:
        if (r14 == 0) goto L_0x00f3;
    L_0x00f0:
        r14.close();
    L_0x00f3:
        if (r1 == 0) goto L_0x00f8;
    L_0x00f5:
        r13.f(r1);
    L_0x00f8:
        return r0;
    L_0x00f9:
        r15 = move-exception;
        r14 = r1;
    L_0x00fb:
        if (r14 == 0) goto L_0x0100;
    L_0x00fd:
        r14.close();
    L_0x0100:
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.db.a.W(java.lang.String, java.lang.String):java.util.ArrayList<com.iqoption.dto.Event>");
    }
}
