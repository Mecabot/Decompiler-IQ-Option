package android.arch.persistence.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.arch.core.executor.ArchTaskExecutor;
import android.arch.persistence.db.SimpleSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Factory;
import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class RoomDatabase {
    protected volatile SupportSQLiteDatabase cG;
    private SupportSQLiteOpenHelper cH;
    private final InvalidationTracker cI = ap();
    private boolean cJ;
    boolean cK;
    private final ReentrantLock cL = new ReentrantLock();
    @Nullable
    protected List<Callback> mCallbacks;

    public static class Builder<T extends RoomDatabase> {
        private boolean cJ;
        private final Class<T> cM;
        private ArrayList<Callback> cN;
        private Factory cO;
        private JournalMode cP = JournalMode.AUTOMATIC;
        private boolean cQ = true;
        private final MigrationContainer cR = new MigrationContainer();
        private Set<Integer> cS;
        private Set<Integer> cT;
        private final Context mContext;
        private final String mName;

        Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
            this.mContext = context;
            this.cM = cls;
            this.mName = str;
        }

        @NonNull
        public Builder<T> a(@NonNull Migration... migrationArr) {
            if (this.cT == null) {
                this.cT = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.cT.add(Integer.valueOf(migration.dj));
                this.cT.add(Integer.valueOf(migration.dk));
            }
            this.cR.b(migrationArr);
            return this;
        }

        @NonNull
        public Builder<T> as() {
            this.cJ = true;
            return this;
        }

        @NonNull
        public Builder<T> at() {
            this.cQ = false;
            return this;
        }

        @NonNull
        public Builder<T> a(@NonNull Callback callback) {
            if (this.cN == null) {
                this.cN = new ArrayList();
            }
            this.cN.add(callback);
            return this;
        }

        @NonNull
        public T au() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.cM == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            } else {
                if (!(this.cT == null || this.cS == null)) {
                    for (Integer num : this.cT) {
                        if (this.cS.contains(num)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                            stringBuilder.append(num);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                }
                if (this.cO == null) {
                    this.cO = new FrameworkSQLiteOpenHelperFactory();
                }
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(this.mContext, this.mName, this.cO, this.cR, this.cN, this.cJ, this.cP.resolve(this.mContext), this.cQ, this.cS);
                RoomDatabase roomDatabase = (RoomDatabase) Room.a(this.cM, "_Impl");
                roomDatabase.a(databaseConfiguration);
                return roomDatabase;
            }
        }
    }

    public static abstract class Callback {
        public void b(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void c(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        @SuppressLint({"NewApi"})
        JournalMode resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            if (VERSION.SDK_INT >= 16) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (!(activityManager == null || ActivityManagerCompat.isLowRamDevice(activityManager))) {
                    return WRITE_AHEAD_LOGGING;
                }
            }
            return TRUNCATE;
        }
    }

    public static class MigrationContainer {
        private SparseArrayCompat<SparseArrayCompat<Migration>> cU = new SparseArrayCompat();

        public void b(@NonNull Migration... migrationArr) {
            for (Migration a : migrationArr) {
                a(a);
            }
        }

        private void a(Migration migration) {
            int i = migration.dj;
            int i2 = migration.dk;
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.cU.get(i);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat();
                this.cU.put(i, sparseArrayCompat);
            }
            Migration migration2 = (Migration) sparseArrayCompat.get(i2);
            if (migration2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Overriding migration ");
                stringBuilder.append(migration2);
                stringBuilder.append(" with ");
                stringBuilder.append(migration);
                Log.w("ROOM", stringBuilder.toString());
            }
            sparseArrayCompat.append(i2, migration);
        }

        @Nullable
        public List<Migration> g(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return a(new ArrayList(), i2 > i, i, i2);
        }

        private List<Migration> a(List<Migration> list, boolean z, int i, int i2) {
            int i3 = z ? -1 : 1;
            Object obj;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                } else if (i <= i2) {
                    return list;
                }
                SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.cU.get(i);
                if (sparseArrayCompat == null) {
                    return null;
                }
                int i4;
                int size = sparseArrayCompat.size();
                obj = null;
                if (z) {
                    size--;
                    i4 = -1;
                } else {
                    i4 = size;
                    size = 0;
                }
                while (size != i4) {
                    int keyAt = sparseArrayCompat.keyAt(size);
                    Object obj2 = (z ? keyAt > i2 || keyAt <= i : keyAt < i2 || keyAt >= i) ? null : 1;
                    if (obj2 != null) {
                        list.add(sparseArrayCompat.valueAt(size));
                        i = keyAt;
                        obj = 1;
                        continue;
                        break;
                    }
                    size += i3;
                }
            } while (obj != null);
            return null;
        }
    }

    @NonNull
    protected abstract InvalidationTracker ap();

    @NonNull
    protected abstract SupportSQLiteOpenHelper b(DatabaseConfiguration databaseConfiguration);

    Lock an() {
        return this.cL;
    }

    @CallSuper
    public void a(@NonNull DatabaseConfiguration databaseConfiguration) {
        this.cH = b(databaseConfiguration);
        boolean z = false;
        if (VERSION.SDK_INT >= 16) {
            if (databaseConfiguration.ce == JournalMode.WRITE_AHEAD_LOGGING) {
                z = true;
            }
            this.cH.setWriteAheadLoggingEnabled(z);
        }
        this.mCallbacks = databaseConfiguration.cc;
        this.cJ = databaseConfiguration.cd;
        this.cK = z;
    }

    @NonNull
    public SupportSQLiteOpenHelper ao() {
        return this.cH;
    }

    public boolean isOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.cG;
        return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void aq() {
        if (!this.cJ && ArchTaskExecutor.A().C()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public Cursor a(String str, @Nullable Object[] objArr) {
        return this.cH.ae().a(new SimpleSQLiteQuery(str, objArr));
    }

    public Cursor a(SupportSQLiteQuery supportSQLiteQuery) {
        aq();
        return this.cH.ae().a(supportSQLiteQuery);
    }

    public SupportSQLiteStatement h(@NonNull String str) {
        aq();
        return this.cH.ae().h(str);
    }

    public void beginTransaction() {
        aq();
        SupportSQLiteDatabase ae = this.cH.ae();
        this.cI.f(ae);
        ae.beginTransaction();
    }

    public void endTransaction() {
        this.cH.ae().endTransaction();
        if (!inTransaction()) {
            this.cI.ai();
        }
    }

    public void setTransactionSuccessful() {
        this.cH.ae().setTransactionSuccessful();
    }

    protected void g(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.cI.e(supportSQLiteDatabase);
    }

    @NonNull
    public InvalidationTracker ar() {
        return this.cI;
    }

    public boolean inTransaction() {
        return this.cH.ae().inTransaction();
    }
}
