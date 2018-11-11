package androidx.work.impl.b;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WorkTagDao_Impl */
public class o implements n {
    private final EntityInsertionAdapter gR;
    private final RoomDatabase ge;

    public o(RoomDatabase roomDatabase) {
        this.ge = roomDatabase;
        this.gR = new EntityInsertionAdapter<m>(roomDatabase) {
            public String aw() {
                return "INSERT OR IGNORE INTO `WorkTag`(`tag`,`work_spec_id`) VALUES (?,?)";
            }

            public void a(SupportSQLiteStatement supportSQLiteStatement, m mVar) {
                if (mVar.tag == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, mVar.tag);
                }
                if (mVar.gc == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, mVar.gc);
                }
            }
        };
    }

    public void a(m mVar) {
        this.ge.beginTransaction();
        try {
            this.gR.f(mVar);
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
        }
    }

    public List<String> T(String str) {
        SupportSQLiteQuery c = RoomSQLiteQuery.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
}
