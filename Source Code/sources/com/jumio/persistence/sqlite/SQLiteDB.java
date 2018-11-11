package com.jumio.persistence.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteDatabaseParams;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteTableParams;

public class SQLiteDB extends DatabaseAdapter {
    private SQLiteTableParams tableParams;

    public SQLiteDB(SQLiteTableParams sQLiteTableParams, DatabaseHelper databaseHelper) {
        super(databaseHelper);
        this.tableParams = sQLiteTableParams;
    }

    public SQLiteDB(SQLiteTableParams sQLiteTableParams, SQLiteDatabaseParams sQLiteDatabaseParams) {
        super(sQLiteDatabaseParams);
        this.tableParams = sQLiteTableParams;
    }

    public long insert(String[] strArr) {
        ContentValues contentValues = new ContentValues();
        if (this.database == null) {
            throw new IllegalStateException("call open() before insert()!");
        }
        int i = 0;
        if (this.tableParams.columns[0].equals("_id")) {
            i = 1;
            if (this.tableParams.columns.length - 1 != strArr.length) {
                throw new SQLException("Size of Columns is not equal to size of values!");
            }
            while (i < this.tableParams.columns.length) {
                int i2 = i - 1;
                if (strArr[i2].compareToIgnoreCase("NULL") == 0) {
                    contentValues.putNull(this.tableParams.columns[i]);
                } else {
                    contentValues.put(this.tableParams.columns[i], strArr[i2]);
                }
                i++;
            }
        } else if (this.tableParams.columns.length != strArr.length) {
            throw new SQLException("Size of Columns is not equal to size of values!");
        } else {
            while (i < this.tableParams.columns.length) {
                if (strArr[i].compareToIgnoreCase("NULL") == 0) {
                    contentValues.putNull(this.tableParams.columns[i]);
                } else {
                    contentValues.put(this.tableParams.columns[i], strArr[i]);
                }
                i++;
            }
        }
        return this.database.insert(this.tableParams.table, null, contentValues);
    }

    public long insert(ContentValues contentValues) {
        return this.database.insert(this.tableParams.table, null, contentValues);
    }

    public boolean update(String[] strArr) {
        String[] strArr2 = this.tableParams.columns;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_id = ");
        stringBuilder.append(strArr[0]);
        return update(strArr2, strArr, stringBuilder.toString());
    }

    public boolean update(String[] strArr, String str) {
        return update(this.tableParams.columns, strArr, str);
    }

    public boolean update(String[] strArr, String[] strArr2, String str) {
        ContentValues contentValues = new ContentValues();
        if (strArr.length != strArr2.length) {
            throw new SQLException("Size of Columns is not equal to size of values!");
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr2[i].compareTo("") != 0) {
                if (strArr2[i].compareToIgnoreCase("NULL") == 0) {
                    contentValues.putNull(this.tableParams.columns[i]);
                }
                contentValues.put(strArr[i], strArr2[i]);
            }
        }
        if (this.database.update(this.tableParams.table, contentValues, str, null) > 0) {
            return true;
        }
        return false;
    }

    public boolean deleteID(String str) {
        SQLiteDatabase sQLiteDatabase = this.database;
        String str2 = this.tableParams.table;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.tableParams.columns[0]);
        stringBuilder.append("=");
        stringBuilder.append(str);
        return sQLiteDatabase.delete(str2, stringBuilder.toString(), null) > 0;
    }

    public boolean delete(String str) {
        return this.database.delete(this.tableParams.table, str, null) > 0;
    }

    public boolean truncate() {
        return this.database.delete(this.tableParams.table, null, null) > 0;
    }

    public Cursor select(String[] strArr, String str, String str2, String str3) {
        return select(strArr, str, null, null, str2, str3);
    }

    public Cursor select(String[] strArr, String str, String str2, String str3, String str4, String str5) {
        Cursor query = this.database.query(true, this.tableParams.table, strArr, str, null, str2, str3, str4, str5);
        if (query != null) {
            query.moveToFirst();
        }
        return query;
    }

    public boolean dropTable() {
        SQLiteDatabase sQLiteDatabase = this.database;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DROP TABLE `");
        stringBuilder.append(this.tableParams.table);
        stringBuilder.append("`;");
        sQLiteDatabase.execSQL(stringBuilder.toString());
        return true;
    }
}
