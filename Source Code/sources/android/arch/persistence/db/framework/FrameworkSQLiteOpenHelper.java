package android.arch.persistence.db.framework;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.RequiresApi;

class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final OpenHelper bT;

    static class OpenHelper extends SQLiteOpenHelper {
        final Callback bO;
        final FrameworkSQLiteDatabase[] bU;
        private boolean bV;

        OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final Callback callback) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() {
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    SupportSQLiteDatabase supportSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
                    if (supportSQLiteDatabase != null) {
                        callback.d(supportSQLiteDatabase);
                    }
                }
            });
            this.bO = callback;
            this.bU = frameworkSQLiteDatabaseArr;
        }

        synchronized SupportSQLiteDatabase ag() {
            this.bV = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.bV) {
                close();
                return ag();
            }
            return a(writableDatabase);
        }

        FrameworkSQLiteDatabase a(SQLiteDatabase sQLiteDatabase) {
            if (this.bU[0] == null) {
                this.bU[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return this.bU[0];
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.bO.b(a(sQLiteDatabase));
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.bV = true;
            this.bO.a(a(sQLiteDatabase), i, i2);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.bO.a(a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.bV = true;
            this.bO.b(a(sQLiteDatabase), i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.bV) {
                this.bO.c(a(sQLiteDatabase));
            }
        }

        public synchronized void close() {
            super.close();
            this.bU[0] = null;
        }
    }

    FrameworkSQLiteOpenHelper(Context context, String str, Callback callback) {
        this.bT = a(context, str, callback);
    }

    private OpenHelper a(Context context, String str, Callback callback) {
        return new OpenHelper(context, str, new FrameworkSQLiteDatabase[1], callback);
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.bT.setWriteAheadLoggingEnabled(z);
    }

    public SupportSQLiteDatabase ae() {
        return this.bT.ag();
    }
}
