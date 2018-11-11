package android.arch.persistence.room;

import android.arch.persistence.db.SimpleSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class RoomOpenHelper extends Callback {
    @Nullable
    private DatabaseConfiguration cV;
    @NonNull
    private final Delegate cW;
    @NonNull
    private final String cX;
    @NonNull
    private final String cY;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static abstract class Delegate {
        public final int version;

        protected abstract void b(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void c(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void l(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void m(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void n(SupportSQLiteDatabase supportSQLiteDatabase);

        public Delegate(int i) {
            this.version = i;
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str, @NonNull String str2) {
        super(delegate.version);
        this.cV = databaseConfiguration;
        this.cW = delegate;
        this.cX = str;
        this.cY = str2;
    }

    public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.a(supportSQLiteDatabase);
    }

    public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        i(supportSQLiteDatabase);
        this.cW.m(supportSQLiteDatabase);
        this.cW.b(supportSQLiteDatabase);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    public void a(android.arch.persistence.db.SupportSQLiteDatabase r3, int r4, int r5) {
        /*
        r2 = this;
        r0 = r2.cV;
        if (r0 == 0) goto L_0x002c;
    L_0x0004:
        r0 = r2.cV;
        r0 = r0.cb;
        r0 = r0.g(r4, r5);
        if (r0 == 0) goto L_0x002c;
    L_0x000e:
        r0 = r0.iterator();
    L_0x0012:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0022;
    L_0x0018:
        r1 = r0.next();
        r1 = (android.arch.persistence.room.migration.Migration) r1;
        r1.o(r3);
        goto L_0x0012;
    L_0x0022:
        r0 = r2.cW;
        r0.n(r3);
        r2.i(r3);
        r0 = 1;
        goto L_0x002d;
    L_0x002c:
        r0 = 0;
    L_0x002d:
        if (r0 != 0) goto L_0x007e;
    L_0x002f:
        r0 = r2.cV;
        if (r0 == 0) goto L_0x0046;
    L_0x0033:
        r0 = r2.cV;
        r0 = r0.j(r4);
        if (r0 != 0) goto L_0x0046;
    L_0x003b:
        r4 = r2.cW;
        r4.l(r3);
        r4 = r2.cW;
        r4.m(r3);
        goto L_0x007e;
    L_0x0046:
        r3 = new java.lang.IllegalStateException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "A migration from ";
        r0.append(r1);
        r0.append(r4);
        r4 = " to ";
        r0.append(r4);
        r0.append(r5);
        r4 = " was required but not found. Please provide the ";
        r0.append(r4);
        r4 = "necessary Migration path via ";
        r0.append(r4);
        r4 = "RoomDatabase.Builder.addMigration(Migration ...) or allow for ";
        r0.append(r4);
        r4 = "destructive migrations via one of the ";
        r0.append(r4);
        r4 = "RoomDatabase.Builder.fallbackToDestructiveMigration* methods.";
        r0.append(r4);
        r4 = r0.toString();
        r3.<init>(r4);
        throw r3;
    L_0x007e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.persistence.room.RoomOpenHelper.a(android.arch.persistence.db.SupportSQLiteDatabase, int, int):void");
    }

    public void b(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        a(supportSQLiteDatabase, i, i2);
    }

    public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.c(supportSQLiteDatabase);
        h(supportSQLiteDatabase);
        this.cW.c(supportSQLiteDatabase);
        this.cV = null;
    }

    private void h(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object obj = null;
        if (k(supportSQLiteDatabase)) {
            Cursor a = supportSQLiteDatabase.a(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (a.moveToFirst()) {
                    obj = a.getString(0);
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        if (!this.cX.equals(obj) && !this.cY.equals(obj)) {
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
    }

    private void i(SupportSQLiteDatabase supportSQLiteDatabase) {
        j(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.m(this.cX));
    }

    private void j(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean k(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor j = supportSQLiteDatabase.j("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (j.moveToFirst() && j.getInt(0) != 0) {
                z = true;
            }
            j.close();
            return z;
        } catch (Throwable th) {
            j.close();
        }
    }
}
