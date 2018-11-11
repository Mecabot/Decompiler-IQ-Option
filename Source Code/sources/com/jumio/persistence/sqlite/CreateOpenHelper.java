package com.jumio.persistence.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteDatabaseParams;

public class CreateOpenHelper extends SQLiteOpenHelper {
    private CreateOpenHelperParams databaseParams;

    public static class CreateOpenHelperParams extends SQLiteDatabaseParams {
        public String[] create;
    }

    public CreateOpenHelper(CreateOpenHelperParams createOpenHelperParams) {
        super(createOpenHelperParams.context, createOpenHelperParams.databaseName, null, createOpenHelperParams.databaseVersion);
        this.databaseParams = createOpenHelperParams;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (String execSQL : this.databaseParams.create) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (this.databaseParams.callback != null && i < i2) {
            this.databaseParams.callback.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
