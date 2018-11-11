package android.arch.persistence.db.framework;

import android.arch.persistence.db.SimpleSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import java.util.List;

class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String[] bP = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private final SQLiteDatabase bQ;

    FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.bQ = sQLiteDatabase;
    }

    public SupportSQLiteStatement h(String str) {
        return new FrameworkSQLiteStatement(this.bQ.compileStatement(str));
    }

    public void beginTransaction() {
        this.bQ.beginTransaction();
    }

    public void endTransaction() {
        this.bQ.endTransaction();
    }

    public void setTransactionSuccessful() {
        this.bQ.setTransactionSuccessful();
    }

    public boolean inTransaction() {
        return this.bQ.inTransaction();
    }

    public Cursor j(String str) {
        return a(new SimpleSQLiteQuery(str));
    }

    public Cursor a(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.bQ.rawQueryWithFactory(new CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.a(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.ad(), EMPTY_STRING_ARRAY, null);
    }

    public void execSQL(String str) {
        this.bQ.execSQL(str);
    }

    public boolean isOpen() {
        return this.bQ.isOpen();
    }

    public String getPath() {
        return this.bQ.getPath();
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.bQ.getAttachedDbs();
    }

    public void close() {
        this.bQ.close();
    }
}
