package android.arch.persistence.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper.Factory;
import android.arch.persistence.room.RoomDatabase.Callback;
import android.arch.persistence.room.RoomDatabase.JournalMode;
import android.arch.persistence.room.RoomDatabase.MigrationContainer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.List;
import java.util.Set;

public class DatabaseConfiguration {
    @NonNull
    public final Factory ca;
    @NonNull
    public final MigrationContainer cb;
    @Nullable
    public final List<Callback> cc;
    public final boolean cd;
    public final JournalMode ce;
    public final boolean cf;
    private final Set<Integer> cg;
    @NonNull
    public final Context context;
    @Nullable
    public final String name;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull Factory factory, @NonNull MigrationContainer migrationContainer, @Nullable List<Callback> list, boolean z, JournalMode journalMode, boolean z2, @Nullable Set<Integer> set) {
        this.ca = factory;
        this.context = context;
        this.name = str;
        this.cb = migrationContainer;
        this.cc = list;
        this.cd = z;
        this.ce = journalMode;
        this.cf = z2;
        this.cg = set;
    }

    public boolean j(int i) {
        return this.cf && (this.cg == null || !this.cg.contains(Integer.valueOf(i)));
    }
}
