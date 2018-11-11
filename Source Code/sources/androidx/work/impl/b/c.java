package androidx.work.impl.b;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DependencyDao_Impl */
public class c implements b {
    private final RoomDatabase ge;
    private final EntityInsertionAdapter gf;

    public c(RoomDatabase roomDatabase) {
        this.ge = roomDatabase;
        this.gf = new EntityInsertionAdapter<a>(roomDatabase) {
            public String aw() {
                return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            public void a(SupportSQLiteStatement supportSQLiteStatement, a aVar) {
                if (aVar.gc == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, aVar.gc);
                }
                if (aVar.gd == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, aVar.gd);
                }
            }
        };
    }

    public void a(a aVar) {
        this.ge.beginTransaction();
        try {
            this.gf.f(aVar);
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
        }
    }

    public boolean H(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            boolean z = false;
            if (a.moveToFirst() && a.getInt(0) != 0) {
                z = true;
            }
            a.close();
            c.release();
            return z;
        } catch (Throwable th) {
            a.close();
            c.release();
        }
    }

    public List<String> I(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    public boolean J(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c.bindNull(1);
        } else {
            c.bindString(1, str);
        }
        Cursor a = this.ge.a(c);
        try {
            boolean z = false;
            if (a.moveToFirst() && a.getInt(0) != 0) {
                z = true;
            }
            a.close();
            c.release();
            return z;
        } catch (Throwable th) {
            a.close();
            c.release();
        }
    }
}
