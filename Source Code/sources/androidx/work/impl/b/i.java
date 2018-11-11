package androidx.work.impl.b;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;

/* compiled from: WorkNameDao_Impl */
public class i implements h {
    private final RoomDatabase ge;
    private final EntityInsertionAdapter gl;

    public i(RoomDatabase roomDatabase) {
        this.ge = roomDatabase;
        this.gl = new EntityInsertionAdapter<g>(roomDatabase) {
            public String aw() {
                return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
            }

            public void a(SupportSQLiteStatement supportSQLiteStatement, g gVar) {
                if (gVar.name == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, gVar.name);
                }
                if (gVar.gc == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, gVar.gc);
                }
            }
        };
    }

    public void a(g gVar) {
        this.ge.beginTransaction();
        try {
            this.gl.f(gVar);
            this.ge.setTransactionSuccessful();
        } finally {
            this.ge.endTransaction();
        }
    }
}
