package android.arch.persistence.db;

import android.database.Cursor;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

public interface SupportSQLiteDatabase extends Closeable {
    Cursor a(SupportSQLiteQuery supportSQLiteQuery);

    void beginTransaction();

    void endTransaction();

    void execSQL(String str);

    List<Pair<String, String>> getAttachedDbs();

    String getPath();

    SupportSQLiteStatement h(String str);

    boolean inTransaction();

    boolean isOpen();

    Cursor j(String str);

    void setTransactionSuccessful();
}
