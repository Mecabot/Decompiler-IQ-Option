package androidx.work.impl.b;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import androidx.work.Data;
import androidx.work.State;
import androidx.work.b;
import androidx.work.impl.b.j.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: WorkSpecDao_Impl */
public class l implements k {
    private final EntityInsertionAdapter gE;
    private final SharedSQLiteStatement gF;
    private final SharedSQLiteStatement gG;
    private final SharedSQLiteStatement gH;
    private final SharedSQLiteStatement gI;
    private final SharedSQLiteStatement gJ;
    private final SharedSQLiteStatement gK;
    private final SharedSQLiteStatement gL;
    private final SharedSQLiteStatement gM;
    private final RoomDatabase ge;

    public l(RoomDatabase roomDatabase) {
        this.ge = roomDatabase;
        this.gE = new EntityInsertionAdapter<j>(roomDatabase) {
            public String aw() {
                return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void a(SupportSQLiteStatement supportSQLiteStatement, j jVar) {
                if (jVar.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, jVar.id);
                }
                supportSQLiteStatement.bindLong(2, (long) p.a(jVar.gn));
                if (jVar.go == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, jVar.go);
                }
                if (jVar.gp == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, jVar.gp);
                }
                byte[] a = Data.a(jVar.gq);
                if (a == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, a);
                }
                a = Data.a(jVar.gr);
                if (a == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, a);
                }
                supportSQLiteStatement.bindLong(7, jVar.gs);
                supportSQLiteStatement.bindLong(8, jVar.gt);
                supportSQLiteStatement.bindLong(9, jVar.gu);
                supportSQLiteStatement.bindLong(10, (long) jVar.gw);
                supportSQLiteStatement.bindLong(11, (long) p.a(jVar.gx));
                supportSQLiteStatement.bindLong(12, jVar.gy);
                supportSQLiteStatement.bindLong(13, jVar.gz);
                supportSQLiteStatement.bindLong(14, jVar.gA);
                supportSQLiteStatement.bindLong(15, jVar.gB);
                b bVar = jVar.gv;
                if (bVar != null) {
                    supportSQLiteStatement.bindLong(16, (long) p.d(bVar.aH()));
                    supportSQLiteStatement.bindLong(17, (long) bVar.aI());
                    supportSQLiteStatement.bindLong(18, (long) bVar.aJ());
                    supportSQLiteStatement.bindLong(19, (long) bVar.aK());
                    supportSQLiteStatement.bindLong(20, (long) bVar.aL());
                    byte[] b = p.b(bVar.aM());
                    if (b == null) {
                        supportSQLiteStatement.bindNull(21);
                        return;
                    } else {
                        supportSQLiteStatement.bindBlob(21, b);
                        return;
                    }
                }
                supportSQLiteStatement.bindNull(16);
                supportSQLiteStatement.bindNull(17);
                supportSQLiteStatement.bindNull(18);
                supportSQLiteStatement.bindNull(19);
                supportSQLiteStatement.bindNull(20);
                supportSQLiteStatement.bindNull(21);
            }
        };
        this.gF = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.gG = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.gH = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.gI = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.gJ = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.gK = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.gL = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.gM = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    public void k(j jVar) {
        this.ge.beginTransaction();
        try {
            this.gE.f(jVar);
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
        }
    }

    public void delete(String str) {
        SupportSQLiteStatement ay = this.gF.ay();
        this.ge.beginTransaction();
        if (str == null) {
            try {
                ay.bindNull(1);
            } catch (Throwable th) {
                this.ge.endTransaction();
                this.gF.a(ay);
            }
        } else {
            ay.bindString(1, str);
        }
        ay.executeUpdateDelete();
        this.ge.setTransactionSuccessful();
        this.ge.endTransaction();
        this.gF.a(ay);
    }

    public void a(String str, Data data) {
        SupportSQLiteStatement ay = this.gG.ay();
        this.ge.beginTransaction();
        try {
            byte[] a = Data.a(data);
            if (a == null) {
                ay.bindNull(1);
            } else {
                ay.bindBlob(1, a);
            }
            if (str == null) {
                ay.bindNull(2);
            } else {
                ay.bindString(2, str);
            }
            ay.executeUpdateDelete();
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
            this.gG.a(ay);
        }
    }

    public void b(String str, long j) {
        SupportSQLiteStatement ay = this.gH.ay();
        this.ge.beginTransaction();
        try {
            ay.bindLong(1, j);
            if (str == null) {
                ay.bindNull(2);
            } else {
                ay.bindString(2, str);
            }
            ay.executeUpdateDelete();
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
            this.gH.a(ay);
        }
    }

    public int O(String str) {
        SupportSQLiteStatement ay = this.gI.ay();
        this.ge.beginTransaction();
        if (str == null) {
            try {
                ay.bindNull(1);
            } catch (Throwable th) {
                this.ge.endTransaction();
                this.gI.a(ay);
            }
        } else {
            ay.bindString(1, str);
        }
        int executeUpdateDelete = ay.executeUpdateDelete();
        this.ge.setTransactionSuccessful();
        this.ge.endTransaction();
        this.gI.a(ay);
        return executeUpdateDelete;
    }

    public int P(String str) {
        SupportSQLiteStatement ay = this.gJ.ay();
        this.ge.beginTransaction();
        if (str == null) {
            try {
                ay.bindNull(1);
            } catch (Throwable th) {
                this.ge.endTransaction();
                this.gJ.a(ay);
            }
        } else {
            ay.bindString(1, str);
        }
        int executeUpdateDelete = ay.executeUpdateDelete();
        this.ge.setTransactionSuccessful();
        this.ge.endTransaction();
        this.gJ.a(ay);
        return executeUpdateDelete;
    }

    public int c(String str, long j) {
        SupportSQLiteStatement ay = this.gK.ay();
        this.ge.beginTransaction();
        try {
            ay.bindLong(1, j);
            if (str == null) {
                ay.bindNull(2);
            } else {
                ay.bindString(2, str);
            }
            int executeUpdateDelete = ay.executeUpdateDelete();
            this.ge.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.ge.endTransaction();
            this.gK.a(ay);
        }
    }

    public int cx() {
        SupportSQLiteStatement ay = this.gL.ay();
        this.ge.beginTransaction();
        try {
            int executeUpdateDelete = ay.executeUpdateDelete();
            this.ge.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.ge.endTransaction();
            this.gL.a(ay);
        }
    }

    public j M(String str) {
        Throwable th;
        Throwable th2;
        String str2 = str;
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str2);
        }
        Cursor a = this.ge.a((SupportSQLiteQuery) c);
        try {
            int columnIndexOrThrow = a.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = a.getColumnIndexOrThrow("state");
            int columnIndexOrThrow3 = a.getColumnIndexOrThrow("worker_class_name");
            int columnIndexOrThrow4 = a.getColumnIndexOrThrow("input_merger_class_name");
            int columnIndexOrThrow5 = a.getColumnIndexOrThrow("input");
            int columnIndexOrThrow6 = a.getColumnIndexOrThrow("output");
            int columnIndexOrThrow7 = a.getColumnIndexOrThrow("initial_delay");
            int columnIndexOrThrow8 = a.getColumnIndexOrThrow("interval_duration");
            int columnIndexOrThrow9 = a.getColumnIndexOrThrow("flex_duration");
            int columnIndexOrThrow10 = a.getColumnIndexOrThrow("run_attempt_count");
            int columnIndexOrThrow11 = a.getColumnIndexOrThrow("backoff_policy");
            int columnIndexOrThrow12 = a.getColumnIndexOrThrow("backoff_delay_duration");
            int columnIndexOrThrow13 = a.getColumnIndexOrThrow("period_start_time");
            SupportSQLiteQuery supportSQLiteQuery = c;
            try {
                j jVar;
                int columnIndexOrThrow14 = a.getColumnIndexOrThrow("minimum_retention_duration");
                int columnIndexOrThrow15 = a.getColumnIndexOrThrow("schedule_requested_at");
                int columnIndexOrThrow16 = a.getColumnIndexOrThrow("required_network_type");
                int i = columnIndexOrThrow13;
                columnIndexOrThrow13 = a.getColumnIndexOrThrow("requires_charging");
                int i2 = columnIndexOrThrow12;
                columnIndexOrThrow12 = a.getColumnIndexOrThrow("requires_device_idle");
                int i3 = columnIndexOrThrow11;
                columnIndexOrThrow11 = a.getColumnIndexOrThrow("requires_battery_not_low");
                int i4 = columnIndexOrThrow10;
                columnIndexOrThrow10 = a.getColumnIndexOrThrow("requires_storage_not_low");
                int i5 = columnIndexOrThrow9;
                columnIndexOrThrow9 = a.getColumnIndexOrThrow("content_uri_triggers");
                if (a.moveToFirst()) {
                    try {
                        String string = a.getString(columnIndexOrThrow);
                        String string2 = a.getString(columnIndexOrThrow3);
                        int i6 = columnIndexOrThrow8;
                        b bVar = new b();
                        bVar.a(p.o(a.getInt(columnIndexOrThrow16)));
                        boolean z = false;
                        bVar.m(a.getInt(columnIndexOrThrow13) != 0);
                        bVar.n(a.getInt(columnIndexOrThrow12) != 0);
                        bVar.o(a.getInt(columnIndexOrThrow11) != 0);
                        if (a.getInt(columnIndexOrThrow10) != 0) {
                            z = true;
                        }
                        bVar.p(z);
                        bVar.a(p.e(a.getBlob(columnIndexOrThrow9)));
                        jVar = new j(string, string2);
                        jVar.gn = p.m(a.getInt(columnIndexOrThrow2));
                        jVar.gp = a.getString(columnIndexOrThrow4);
                        jVar.gq = Data.d(a.getBlob(columnIndexOrThrow5));
                        jVar.gr = Data.d(a.getBlob(columnIndexOrThrow6));
                        jVar.gs = a.getLong(columnIndexOrThrow7);
                        jVar.gt = a.getLong(i6);
                        jVar.gu = a.getLong(i5);
                        jVar.gw = a.getInt(i4);
                        jVar.gx = p.n(a.getInt(i3));
                        jVar.gy = a.getLong(i2);
                        jVar.gz = a.getLong(i);
                        jVar.gA = a.getLong(columnIndexOrThrow14);
                        jVar.gB = a.getLong(columnIndexOrThrow15);
                        jVar.gv = bVar;
                    } catch (Throwable th22) {
                        th = th22;
                        c = supportSQLiteQuery;
                        a.close();
                        c.release();
                        throw th;
                    }
                }
                jVar = null;
                a.close();
                supportSQLiteQuery.release();
                return jVar;
            } catch (Throwable th3) {
                th22 = th3;
                c = supportSQLiteQuery;
                th = th22;
                a.close();
                c.release();
                throw th;
            }
        } catch (Throwable th4) {
            th22 = th4;
            th = th22;
            a.close();
            c.release();
            throw th;
        }
    }

    public List<a> N(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            int columnIndexOrThrow = a.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = a.getColumnIndexOrThrow("state");
            List<a> arrayList = new ArrayList(a.getCount());
            while (a.moveToNext()) {
                a aVar = new a();
                aVar.id = a.getString(columnIndexOrThrow);
                aVar.gn = p.m(a.getInt(columnIndexOrThrow2));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            a.close();
            c.release();
        }
    }

    public State Q(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            State m = a.moveToFirst() ? p.m(a.getInt(0)) : null;
            a.close();
            c.release();
            return m;
        } catch (Throwable th) {
            a.close();
            c.release();
        }
    }

    public LiveData<List<j.b>> n(List<String> list) {
        StringBuilder az = StringUtil.az();
        az.append("SELECT id, state, output FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.a(az, size);
        az.append(")");
        final RoomSQLiteQuery c = RoomSQLiteQuery.c(az.toString(), size + 0);
        size = 1;
        for (String str : list) {
            if (str == null) {
                c.bindNull(size);
            } else {
                c.bindString(size, str);
            }
            size++;
        }
        return new ComputableLiveData<List<j.b>>() {
            private Observer gO;

            /* renamed from: cy */
            protected List<j.b> compute() {
                if (this.gO == null) {
                    this.gO = new Observer("WorkTag", "workspec") {
                        public void a(@NonNull Set<String> set) {
                            AnonymousClass2.this.invalidate();
                        }
                    };
                    l.this.ge.ar().b(this.gO);
                }
                l.this.ge.beginTransaction();
                Cursor a;
                try {
                    a = l.this.ge.a(c);
                    ArrayMap arrayMap = new ArrayMap();
                    int columnIndexOrThrow = a.getColumnIndexOrThrow("id");
                    int columnIndexOrThrow2 = a.getColumnIndexOrThrow("state");
                    int columnIndexOrThrow3 = a.getColumnIndexOrThrow("output");
                    List<j.b> arrayList = new ArrayList(a.getCount());
                    while (a.moveToNext()) {
                        j.b bVar = new j.b();
                        bVar.id = a.getString(columnIndexOrThrow);
                        bVar.gn = p.m(a.getInt(columnIndexOrThrow2));
                        bVar.gr = Data.d(a.getBlob(columnIndexOrThrow3));
                        if (!a.isNull(columnIndexOrThrow)) {
                            String string = a.getString(columnIndexOrThrow);
                            List list = (ArrayList) arrayMap.get(string);
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(string, list);
                            }
                            bVar.gD = list;
                        }
                        arrayList.add(bVar);
                    }
                    l.this.a(arrayMap);
                    l.this.ge.setTransactionSuccessful();
                    a.close();
                    l.this.ge.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    l.this.ge.endTransaction();
                }
            }

            protected void finalize() {
                c.release();
            }
        }.H();
    }

    public List<Data> R(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            List<Data> arrayList = new ArrayList(a.getCount());
            while (a.moveToNext()) {
                arrayList.add(Data.d(a.getBlob(0)));
            }
            return arrayList;
        } finally {
            a.close();
            c.release();
        }
    }

    public List<String> S(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            List<String> arrayList = new ArrayList(a.getCount());
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            return arrayList;
        } finally {
            a.close();
            c.release();
        }
    }

    public List<String> cw() {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        Cursor a = this.ge.a(c);
        try {
            List<String> arrayList = new ArrayList(a.getCount());
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            return arrayList;
        } finally {
            a.close();
            c.release();
        }
    }

    public List<j> l(int i) {
        Throwable th;
        Throwable th2;
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * from workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT ?-COUNT(*) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        c.bindLong(1, (long) i);
        Cursor a = this.ge.a((SupportSQLiteQuery) c);
        try {
            int columnIndexOrThrow = a.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = a.getColumnIndexOrThrow("state");
            int columnIndexOrThrow3 = a.getColumnIndexOrThrow("worker_class_name");
            int columnIndexOrThrow4 = a.getColumnIndexOrThrow("input_merger_class_name");
            int columnIndexOrThrow5 = a.getColumnIndexOrThrow("input");
            int columnIndexOrThrow6 = a.getColumnIndexOrThrow("output");
            int columnIndexOrThrow7 = a.getColumnIndexOrThrow("initial_delay");
            int columnIndexOrThrow8 = a.getColumnIndexOrThrow("interval_duration");
            int columnIndexOrThrow9 = a.getColumnIndexOrThrow("flex_duration");
            int columnIndexOrThrow10 = a.getColumnIndexOrThrow("run_attempt_count");
            int columnIndexOrThrow11 = a.getColumnIndexOrThrow("backoff_policy");
            int columnIndexOrThrow12 = a.getColumnIndexOrThrow("backoff_delay_duration");
            int columnIndexOrThrow13 = a.getColumnIndexOrThrow("period_start_time");
            SupportSQLiteQuery supportSQLiteQuery = c;
            try {
                ArrayList arrayList;
                int columnIndexOrThrow14 = a.getColumnIndexOrThrow("minimum_retention_duration");
                int columnIndexOrThrow15 = a.getColumnIndexOrThrow("schedule_requested_at");
                int columnIndexOrThrow16 = a.getColumnIndexOrThrow("required_network_type");
                int i2 = columnIndexOrThrow13;
                columnIndexOrThrow13 = a.getColumnIndexOrThrow("requires_charging");
                int i3 = columnIndexOrThrow12;
                columnIndexOrThrow12 = a.getColumnIndexOrThrow("requires_device_idle");
                int i4 = columnIndexOrThrow11;
                columnIndexOrThrow11 = a.getColumnIndexOrThrow("requires_battery_not_low");
                int i5 = columnIndexOrThrow10;
                columnIndexOrThrow10 = a.getColumnIndexOrThrow("requires_storage_not_low");
                int i6 = columnIndexOrThrow9;
                columnIndexOrThrow9 = a.getColumnIndexOrThrow("content_uri_triggers");
                int i7 = columnIndexOrThrow8;
                int i8 = columnIndexOrThrow7;
                ArrayList arrayList2 = new ArrayList(a.getCount());
                while (a.moveToNext()) {
                    try {
                        String string = a.getString(columnIndexOrThrow);
                        int i9 = columnIndexOrThrow;
                        String string2 = a.getString(columnIndexOrThrow3);
                        int i10 = columnIndexOrThrow3;
                        b bVar = new b();
                        ArrayList arrayList3 = arrayList2;
                        bVar.a(p.o(a.getInt(columnIndexOrThrow16)));
                        bVar.m(a.getInt(columnIndexOrThrow13) != 0);
                        bVar.n(a.getInt(columnIndexOrThrow12) != 0);
                        bVar.o(a.getInt(columnIndexOrThrow11) != 0);
                        bVar.p(a.getInt(columnIndexOrThrow10) != 0);
                        bVar.a(p.e(a.getBlob(columnIndexOrThrow9)));
                        j jVar = new j(string, string2);
                        jVar.gn = p.m(a.getInt(columnIndexOrThrow2));
                        jVar.gp = a.getString(columnIndexOrThrow4);
                        jVar.gq = Data.d(a.getBlob(columnIndexOrThrow5));
                        jVar.gr = Data.d(a.getBlob(columnIndexOrThrow6));
                        int i11 = columnIndexOrThrow16;
                        int i12 = columnIndexOrThrow12;
                        columnIndexOrThrow = i8;
                        jVar.gs = a.getLong(columnIndexOrThrow);
                        int i13 = columnIndexOrThrow13;
                        columnIndexOrThrow16 = i7;
                        jVar.gt = a.getLong(columnIndexOrThrow16);
                        int i14 = columnIndexOrThrow;
                        int i15 = columnIndexOrThrow2;
                        columnIndexOrThrow12 = i6;
                        jVar.gu = a.getLong(columnIndexOrThrow12);
                        columnIndexOrThrow13 = i5;
                        jVar.gw = a.getInt(columnIndexOrThrow13);
                        columnIndexOrThrow = i4;
                        jVar.gx = p.n(a.getInt(columnIndexOrThrow));
                        int i16 = columnIndexOrThrow16;
                        int i17 = columnIndexOrThrow12;
                        columnIndexOrThrow2 = i3;
                        jVar.gy = a.getLong(columnIndexOrThrow2);
                        int i18 = columnIndexOrThrow13;
                        columnIndexOrThrow16 = i2;
                        jVar.gz = a.getLong(columnIndexOrThrow16);
                        int i19 = columnIndexOrThrow;
                        int i20 = columnIndexOrThrow2;
                        columnIndexOrThrow12 = columnIndexOrThrow14;
                        jVar.gA = a.getLong(columnIndexOrThrow12);
                        columnIndexOrThrow13 = columnIndexOrThrow15;
                        jVar.gB = a.getLong(columnIndexOrThrow13);
                        jVar.gv = bVar;
                        arrayList = arrayList3;
                        arrayList.add(jVar);
                        i2 = columnIndexOrThrow16;
                        columnIndexOrThrow14 = columnIndexOrThrow12;
                        columnIndexOrThrow15 = columnIndexOrThrow13;
                        arrayList2 = arrayList;
                        columnIndexOrThrow = i9;
                        columnIndexOrThrow3 = i10;
                        columnIndexOrThrow16 = i11;
                        columnIndexOrThrow12 = i12;
                        columnIndexOrThrow13 = i13;
                        columnIndexOrThrow2 = i15;
                        i8 = i14;
                        i7 = i16;
                        i6 = i17;
                        i5 = i18;
                        i4 = i19;
                        i3 = i20;
                    } catch (Throwable th22) {
                        th = th22;
                        c = supportSQLiteQuery;
                        a.close();
                        c.release();
                        throw th;
                    }
                }
                arrayList = arrayList2;
                a.close();
                supportSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th3) {
                th22 = th3;
                c = supportSQLiteQuery;
                th = th22;
                a.close();
                c.release();
                throw th;
            }
        } catch (Throwable th4) {
            th22 = th4;
            th = th22;
            a.close();
            c.release();
            throw th;
        }
    }

    public int a(State state, String... strArr) {
        int executeUpdateDelete;
        StringBuilder az = StringUtil.az();
        az.append("UPDATE workspec SET state=");
        az.append("?");
        az.append(" WHERE id IN (");
        StringUtil.a(az, strArr.length);
        az.append(")");
        SupportSQLiteStatement h = this.ge.h(az.toString());
        h.bindLong(1, (long) p.a(state));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                h.bindNull(i);
            } else {
                h.bindString(i, str);
            }
            i++;
        }
        this.ge.beginTransaction();
        try {
            executeUpdateDelete = h.executeUpdateDelete();
            this.ge.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.ge.endTransaction();
        }
    }

    private void a(ArrayMap<String, ArrayList<String>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            int size;
            if (arrayMap.size() > 999) {
                int i;
                ArrayMap arrayMap2 = new ArrayMap(999);
                size = arrayMap.size();
                ArrayMap arrayMap3 = arrayMap2;
                int i2 = 0;
                while (true) {
                    i = 0;
                    while (i2 < size) {
                        arrayMap3.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                        i2++;
                        i++;
                        if (i == 999) {
                            a(arrayMap3);
                            arrayMap3 = new ArrayMap(999);
                        }
                    }
                    break;
                }
                if (i > 0) {
                    a(arrayMap3);
                }
                return;
            }
            StringBuilder az = StringUtil.az();
            az.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.a(az, size2);
            az.append(")");
            SupportSQLiteQuery c = RoomSQLiteQuery.c(az.toString(), size2 + 0);
            size2 = 1;
            for (String str : keySet) {
                if (str == null) {
                    c.bindNull(size2);
                } else {
                    c.bindString(size2, str);
                }
                size2++;
            }
            Cursor a = this.ge.a(c);
            try {
                size = a.getColumnIndex("work_spec_id");
                if (size != -1) {
                    while (a.moveToNext()) {
                        if (!a.isNull(size)) {
                            ArrayList arrayList = (ArrayList) arrayMap.get(a.getString(size));
                            if (arrayList != null) {
                                arrayList.add(a.getString(0));
                            }
                        }
                    }
                    a.close();
                }
            } finally {
                a.close();
            }
        }
    }
}
