package com.jumio.persistence.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteDatabaseParams;
import com.jumio.persistence.sqlite.DatabaseAdapter.SQLiteTableParams;

public class MultiTableDB extends DatabaseAdapter {
    public MultiTableDB(DatabaseHelper databaseHelper) {
        super(databaseHelper);
    }

    public MultiTableDB(SQLiteDatabaseParams sQLiteDatabaseParams) {
        super(sQLiteDatabaseParams);
    }

    public long insert(SQLiteTableParams sQLiteTableParams, String[] strArr) {
        return insert(sQLiteTableParams.table, sQLiteTableParams.columns, strArr);
    }

    public long insert(String str, String[] strArr, String[] strArr2) {
        ContentValues contentValues = new ContentValues();
        if (strArr.length != strArr2.length) {
            throw new SQLException("Size of Columns is not equal to size of values!");
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr2[i].compareToIgnoreCase("NULL") == 0) {
                contentValues.putNull(strArr[i]);
            } else {
                contentValues.put(strArr[i], strArr2[i]);
            }
        }
        return this.database.insert(str, null, contentValues);
    }

    public long insert(String str, ContentValues contentValues) {
        return this.database.insert(str, null, contentValues);
    }

    public boolean update(SQLiteTableParams sQLiteTableParams, String[] strArr) {
        return update(sQLiteTableParams.table, sQLiteTableParams.columns, strArr);
    }

    public boolean update(SQLiteTableParams sQLiteTableParams, String[] strArr, String str) {
        return update(sQLiteTableParams.table, sQLiteTableParams.columns, strArr, str);
    }

    public boolean update(String str, String[] strArr, String[] strArr2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_id = ");
        stringBuilder.append(strArr2[0]);
        return update(str, strArr, strArr2, stringBuilder.toString());
    }

    public boolean update(String str, String[] strArr, String[] strArr2, String str2) {
        ContentValues contentValues = new ContentValues();
        if (strArr.length != strArr2.length) {
            throw new SQLException("Size of Columns is not equal to size of values!");
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr2[i].compareTo("") != 0) {
                if (strArr2[i].compareToIgnoreCase("NULL") == 0) {
                    contentValues.putNull(strArr[i]);
                }
                contentValues.put(strArr[i], strArr2[i]);
            }
        }
        if (this.database.update(str, contentValues, str2, null) > 0) {
            return true;
        }
        return false;
    }

    public boolean delete(SQLiteTableParams sQLiteTableParams, int i, String str) {
        String str2 = sQLiteTableParams.table;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sQLiteTableParams.columns[i]);
        stringBuilder.append("=");
        stringBuilder.append(str);
        return delete(str2, stringBuilder.toString());
    }

    public boolean delete(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("=");
        stringBuilder.append(str3);
        return delete(str, stringBuilder.toString());
    }

    public boolean delete(String str, String str2) {
        return this.database.delete(str, str2, null) > 0;
    }

    public boolean truncate(String str) {
        return this.database.delete(str, null, null) > 0;
    }

    public Cursor select(SQLiteTableParams sQLiteTableParams, String str, String str2, String str3) {
        return select(sQLiteTableParams.table, sQLiteTableParams.columns, str, null, null, null, str2, str3);
    }

    public Cursor select(String str, String[] strArr, String str2, String str3, String str4) {
        return select(str, strArr, str2, null, null, null, str3, str4);
    }

    public Cursor select(SQLiteTableParams sQLiteTableParams, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        SQLiteTableParams sQLiteTableParams2 = sQLiteTableParams;
        return select(sQLiteTableParams2.table, sQLiteTableParams2.columns, str, strArr, str2, str3, str4, str5);
    }

    public Cursor select(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor query = this.database.query(true, str, strArr, str2, strArr2, str3, str4, str5, str6);
        if (query != null) {
            query.moveToFirst();
        }
        return query;
    }

    public Cursor join(String[] strArr, String[] strArr2, String str, String str2, String str3) {
        return join(false, strArr, strArr2, str, null, null, null, str2, str3);
    }

    public Cursor join(boolean z, String[] strArr, String[] strArr2, String str, String str2, String str3) {
        return join(z, strArr, strArr2, str, null, null, null, str2, str3);
    }

    public Cursor join(String[] strArr, String[] strArr2, String str, String[] strArr3, String str2, String str3, String str4, String str5) {
        return join(false, strArr, strArr2, str, strArr3, str2, str3, str4, str5);
    }

    public Cursor join(boolean z, String[] strArr, String[] strArr2, String str, String[] strArr3, String str2, String str3, String str4, String str5) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("SELECT ");
        if (z) {
            stringBuilder2.append("DISTINCT ");
        }
        int i = 0;
        while (i < strArr2.length) {
            stringBuilder2.append(strArr2[i]);
            i++;
            if (i < strArr2.length) {
                stringBuilder2.append(", ");
            }
        }
        stringBuilder2.append(" FROM ");
        for (String append : strArr) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(append);
            stringBuilder3.append(" ");
            stringBuilder2.append(stringBuilder3.toString());
        }
        if (str != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" WHERE ");
            stringBuilder.append(str);
            stringBuilder2.append(stringBuilder.toString());
        }
        if (str2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" GROUP BY ");
            stringBuilder.append(str2);
            stringBuilder2.append(stringBuilder.toString());
        }
        if (str3 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" HAVING ");
            stringBuilder.append(str3);
            stringBuilder2.append(stringBuilder.toString());
        }
        if (str4 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(str4);
            stringBuilder2.append(stringBuilder.toString());
        }
        if (str5 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" LIMIT ");
            stringBuilder.append(str5);
            stringBuilder2.append(stringBuilder.toString());
        }
        Cursor rawQuery = this.database.rawQuery(stringBuilder2.toString(), strArr3);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
        }
        return rawQuery;
    }

    public Cursor raw(String str) {
        Cursor rawQuery = this.database.rawQuery(str, null);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
        }
        return rawQuery;
    }
}
