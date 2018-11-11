package androidx.work.impl;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomDatabase.Builder;
import android.arch.persistence.room.RoomDatabase.Callback;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.impl.b.b;
import androidx.work.impl.b.e;
import androidx.work.impl.b.h;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.f.a;
import java.util.concurrent.TimeUnit;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class WorkDatabase extends RoomDatabase {
    private static final long ev = TimeUnit.DAYS.toMillis(7);

    public abstract k bu();

    public abstract b bv();

    public abstract n bw();

    public abstract e bx();

    public abstract h by();

    public static WorkDatabase a(Context context, boolean z) {
        Builder as;
        if (z) {
            as = Room.a(context, WorkDatabase.class).as();
        } else {
            as = Room.a(context, WorkDatabase.class, "androidx.work.workdb");
        }
        return (WorkDatabase) as.a(br()).a(f.ew).a(new a(context, 2, 3)).a(f.ex).at().au();
    }

    static Callback br() {
        return new Callback() {
            public void c(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                super.c(supportSQLiteDatabase);
                supportSQLiteDatabase.beginTransaction();
                try {
                    supportSQLiteDatabase.execSQL("UPDATE workspec SET state=0, schedule_requested_at=-1 WHERE state=1");
                    supportSQLiteDatabase.execSQL(WorkDatabase.bs());
                    supportSQLiteDatabase.setTransactionSuccessful();
                } finally {
                    supportSQLiteDatabase.endTransaction();
                }
            }
        };
    }

    static String bs() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        stringBuilder.append(bt());
        stringBuilder.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return stringBuilder.toString();
    }

    static long bt() {
        return System.currentTimeMillis() - ev;
    }
}
