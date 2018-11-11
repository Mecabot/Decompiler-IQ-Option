package android.arch.persistence.room.migration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.support.annotation.NonNull;

public abstract class Migration {
    public final int dj;
    public final int dk;

    public abstract void o(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

    public Migration(int i, int i2) {
        this.dj = i;
        this.dk = i2;
    }
}
