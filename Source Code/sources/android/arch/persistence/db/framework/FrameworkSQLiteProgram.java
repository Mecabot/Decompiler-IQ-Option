package android.arch.persistence.db.framework;

import android.arch.persistence.db.SupportSQLiteProgram;
import android.database.sqlite.SQLiteProgram;

class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram bY;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.bY = sQLiteProgram;
    }

    public void bindNull(int i) {
        this.bY.bindNull(i);
    }

    public void bindLong(int i, long j) {
        this.bY.bindLong(i, j);
    }

    public void bindDouble(int i, double d) {
        this.bY.bindDouble(i, d);
    }

    public void bindString(int i, String str) {
        this.bY.bindString(i, str);
    }

    public void bindBlob(int i, byte[] bArr) {
        this.bY.bindBlob(i, bArr);
    }

    public void close() {
        this.bY.close();
    }
}
