package androidx.work.impl.b;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;

/* compiled from: SystemIdInfoDao_Impl */
public class f implements e {
    private final RoomDatabase ge;
    private final EntityInsertionAdapter gi;
    private final SharedSQLiteStatement gj;

    public f(RoomDatabase roomDatabase) {
        this.ge = roomDatabase;
        this.gi = new EntityInsertionAdapter<d>(roomDatabase) {
            public String aw() {
                return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            public void a(SupportSQLiteStatement supportSQLiteStatement, d dVar) {
                if (dVar.gc == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, dVar.gc);
                }
                supportSQLiteStatement.bindLong(2, (long) dVar.gh);
            }
        };
        this.gj = new SharedSQLiteStatement(roomDatabase) {
            public String aw() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public void a(d dVar) {
        this.ge.beginTransaction();
        try {
            this.gi.f(dVar);
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
        }
    }

    public void L(String str) {
        SupportSQLiteStatement ay = this.gj.ay();
        this.ge.beginTransaction();
        if (str == null) {
            try {
                ay.bindNull(1);
            } catch (Throwable th) {
                this.ge.endTransaction();
                this.gj.a(ay);
            }
        } else {
            ay.bindString(1, str);
        }
        ay.executeUpdateDelete();
        this.ge.setTransactionSuccessful();
        this.ge.endTransaction();
        this.gj.a(ay);
    }

    public d K(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            d dVar = a.moveToFirst() ? new d(a.getString(a.getColumnIndexOrThrow("work_spec_id")), a.getInt(a.getColumnIndexOrThrow("system_id"))) : null;
            a.close();
            c.release();
            return dVar;
        } catch (Throwable th) {
            a.close();
            c.release();
        }
    }
}
