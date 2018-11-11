package com.jumio.persistence.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jumio.persistence.sqlite.CreateOpenHelper.CreateOpenHelperParams;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteDatabaseParams;
import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseHelper {
    private static DatabaseHelper instance;
    AtomicInteger count;
    SQLiteDatabaseParams databaseParams;
    SQLiteOpenHelper openHelper;

    public static synchronized DatabaseHelper getInstance(SQLiteDatabaseParams sQLiteDatabaseParams) {
        DatabaseHelper databaseHelper;
        synchronized (DatabaseHelper.class) {
            if (instance == null) {
                instance = new DatabaseHelper(sQLiteDatabaseParams);
            }
            databaseHelper = instance;
        }
        return databaseHelper;
    }

    private DatabaseHelper(SQLiteDatabaseParams sQLiteDatabaseParams) {
        this.openHelper = null;
        this.count = null;
        this.count = new AtomicInteger();
        this.databaseParams = sQLiteDatabaseParams;
    }

    public synchronized SQLiteOpenHelper openHelper() {
        this.count.getAndIncrement();
        if (this.openHelper == null) {
            this.openHelper = new CreateOpenHelper((CreateOpenHelperParams) this.databaseParams);
        }
        return this.openHelper;
    }

    public synchronized void closeHelper(SQLiteDatabase sQLiteDatabase) {
        if (this.count.decrementAndGet() == 0 && this.openHelper != null) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            this.openHelper.close();
            this.openHelper = null;
        }
    }
}
