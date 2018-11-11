package android.arch.persistence.room;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class SharedSQLiteStatement {
    private final RoomDatabase co;
    private final AtomicBoolean dh = new AtomicBoolean(false);
    private volatile SupportSQLiteStatement di;

    protected abstract String aw();

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.co = roomDatabase;
    }

    protected void aq() {
        this.co.aq();
    }

    private SupportSQLiteStatement ax() {
        return this.co.h(aw());
    }

    private SupportSQLiteStatement l(boolean z) {
        if (!z) {
            return ax();
        }
        if (this.di == null) {
            this.di = ax();
        }
        return this.di;
    }

    public SupportSQLiteStatement ay() {
        aq();
        return l(this.dh.compareAndSet(false, true));
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.di) {
            this.dh.set(false);
        }
    }
}
