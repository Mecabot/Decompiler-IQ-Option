package com.jumio.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jumio.commons.log.Log;
import com.jumio.persistence.sqlite.CreateOpenHelper.CreateOpenHelperParams;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteDatabaseCallback;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteTableParams;
import com.jumio.persistence.sqlite.SQLiteDB;

public class SqliteSink implements PersistenceTarget {
    private static final String COLUMN_BINARY_DATA = "binaryData";
    private static final String COLUMN_KEY = "key";
    private static final String DATABASE_NAME = "JMSDK 2.10.0 (0-63)_objectpool";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "objects";
    private static final String TAG = "SqliteSink";
    private String key = null;
    private SQLiteDB mDatabase;
    private CreateOpenHelperParams mDatabaseParams;

    public SqliteSink(Context context, String str) {
        if (this.mDatabaseParams == null) {
            this.mDatabaseParams = createDatabaseParams(context);
        }
        this.key = str;
        SQLiteTableParams sQLiteTableParams = new SQLiteTableParams();
        sQLiteTableParams.table = TABLE_NAME;
        sQLiteTableParams.columns = new String[]{"_id", COLUMN_BINARY_DATA, COLUMN_KEY};
        this.mDatabase = new SQLiteDB(sQLiteTableParams, this.mDatabaseParams);
    }

    private static CreateOpenHelperParams createDatabaseParams(Context context) {
        CreateOpenHelperParams createOpenHelperParams = new CreateOpenHelperParams();
        createOpenHelperParams.databaseName = DATABASE_NAME;
        createOpenHelperParams.databaseVersion = 1;
        createOpenHelperParams.context = context;
        Object[] objArr = new Object[]{TABLE_NAME};
        createOpenHelperParams.create = new String[]{String.format("CREATE TABLE IF NOT EXISTS `%s` (`_id` integer primary key autoincrement NOT NULL , `binaryData` BLOB NOT NULL, `key` TEXT NOT NULL );", objArr)};
        createOpenHelperParams.callback = new SQLiteDatabaseCallback() {
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Upgrading database from version ");
                stringBuilder.append(i);
                stringBuilder.append(" to ");
                stringBuilder.append(i2);
                stringBuilder.append(", which will destroy all old data");
                Log.w("Persistor", stringBuilder.toString());
            }
        };
        return createOpenHelperParams;
    }

    public long storeBlob(byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        if (bArr != null) {
            try {
                contentValues.put(COLUMN_BINARY_DATA, bArr);
                if (this.key != null) {
                    contentValues.put(COLUMN_KEY, this.key);
                }
                if (this.mDatabase.open()) {
                    this.mDatabase.beginTransaction();
                    long insert = this.mDatabase.insert(contentValues);
                    this.mDatabase.commitTransaction();
                    this.mDatabase.endTransaction();
                    this.mDatabase.close();
                    return insert;
                }
                this.mDatabase.endTransaction();
                this.mDatabase.close();
            } catch (Exception e) {
                Log.w("Persistor", "error in storeAsBlob()", (Throwable) e);
                throw new PersistenceException(e);
            } catch (Exception e2) {
                Log.w("Persistor", "error in storeAsBlob()", (Throwable) e2);
                throw new PersistenceException(e2);
            } catch (Throwable th) {
                this.mDatabase.endTransaction();
                this.mDatabase.close();
            }
        }
        return -1;
    }

    public byte[] readBlob() {
        Cursor select;
        try {
            byte[] bArr = null;
            if (this.mDatabase.open()) {
                String str;
                this.mDatabase.beginTransaction();
                if (this.key == null) {
                    str = "_id > -1";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("key = '");
                    stringBuilder.append(this.key);
                    stringBuilder.append("'");
                    str = stringBuilder.toString();
                }
                select = this.mDatabase.select(new String[]{"*"}, str, "_id DESC", null);
                if (select.getCount() > 0) {
                    bArr = select.getBlob(select.getColumnIndex(COLUMN_BINARY_DATA));
                    this.mDatabase.commitTransaction();
                }
                if (select != null) {
                    select.close();
                }
            }
            this.mDatabase.endTransaction();
            this.mDatabase.close();
            return bArr;
        } catch (Exception e) {
            try {
                Log.w("Persistor", "error in restoreFromBlob()", (Throwable) e);
                throw new PersistenceException(e);
            } catch (Throwable th) {
                this.mDatabase.endTransaction();
                this.mDatabase.close();
            }
        } catch (Throwable th2) {
            if (select != null) {
                select.close();
            }
        }
    }

    public boolean delete() {
        try {
            boolean z;
            if (this.mDatabase.open()) {
                this.mDatabase.beginTransaction();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("key = '");
                stringBuilder.append(this.key);
                stringBuilder.append("'");
                this.mDatabase.delete(stringBuilder.toString());
                this.mDatabase.commitTransaction();
                z = true;
            } else {
                z = false;
            }
            this.mDatabase.endTransaction();
            this.mDatabase.close();
            return z;
        } catch (Exception e) {
            Log.w("Persistor", "error in delete()", (Throwable) e);
            throw new PersistenceException(e);
        } catch (Throwable th) {
            this.mDatabase.endTransaction();
            this.mDatabase.close();
        }
    }
}
