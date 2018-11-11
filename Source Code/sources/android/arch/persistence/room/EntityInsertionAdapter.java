package android.arch.persistence.room;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    protected abstract void a(SupportSQLiteStatement supportSQLiteStatement, T t);

    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public final void f(T t) {
        SupportSQLiteStatement ay = ay();
        try {
            a(ay, t);
            ay.executeInsert();
        } finally {
            a(ay);
        }
    }
}
