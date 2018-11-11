package android.arch.persistence.db.framework;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.database.sqlite.SQLiteStatement;

class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement bZ;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.bZ = sQLiteStatement;
    }

    public int executeUpdateDelete() {
        return this.bZ.executeUpdateDelete();
    }

    public long executeInsert() {
        return this.bZ.executeInsert();
    }
}
