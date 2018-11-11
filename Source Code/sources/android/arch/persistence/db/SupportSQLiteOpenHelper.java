package android.arch.persistence.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.File;

public interface SupportSQLiteOpenHelper {

    public static abstract class Callback {
        public final int version;

        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void a(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);

        public abstract void b(SupportSQLiteDatabase supportSQLiteDatabase);

        public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public Callback(int i) {
            this.version = i;
        }

        public void b(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't downgrade database from version ");
            stringBuilder.append(i);
            stringBuilder.append(" to ");
            stringBuilder.append(i2);
            throw new SQLiteException(stringBuilder.toString());
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x002f A:{PHI: r0 , Splitter: B:5:0x0029, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002f A:{PHI: r0 , Splitter: B:5:0x0029, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:10:?, code:
            r4.close();
     */
        /* JADX WARNING: Missing block: B:11:0x0035, code:
            if (r0 != null) goto L_0x0037;
     */
        /* JADX WARNING: Missing block: B:12:0x0037, code:
            r4 = r0.iterator();
     */
        /* JADX WARNING: Missing block: B:14:0x003f, code:
            if (r4.hasNext() != false) goto L_0x0041;
     */
        /* JADX WARNING: Missing block: B:15:0x0041, code:
            k((java.lang.String) ((android.util.Pair) r4.next()).second);
     */
        /* JADX WARNING: Missing block: B:16:0x004f, code:
            k(r4.getPath());
     */
        public void d(android.arch.persistence.db.SupportSQLiteDatabase r4) {
            /*
            r3 = this;
            r0 = "SupportSQLite";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Corruption reported by sqlite on database: ";
            r1.append(r2);
            r2 = r4.getPath();
            r1.append(r2);
            r1 = r1.toString();
            android.util.Log.e(r0, r1);
            r0 = r4.isOpen();
            if (r0 != 0) goto L_0x0028;
        L_0x0020:
            r4 = r4.getPath();
            r3.k(r4);
            return;
        L_0x0028:
            r0 = 0;
            r1 = r4.getAttachedDbs();	 Catch:{ SQLiteException -> 0x0031, all -> 0x002f }
            r0 = r1;
            goto L_0x0031;
        L_0x002f:
            r1 = move-exception;
            goto L_0x0035;
        L_0x0031:
            r4.close();	 Catch:{ IOException -> 0x0057, all -> 0x002f }
            goto L_0x0057;
        L_0x0035:
            if (r0 == 0) goto L_0x004f;
        L_0x0037:
            r4 = r0.iterator();
        L_0x003b:
            r0 = r4.hasNext();
            if (r0 == 0) goto L_0x0056;
        L_0x0041:
            r0 = r4.next();
            r0 = (android.util.Pair) r0;
            r0 = r0.second;
            r0 = (java.lang.String) r0;
            r3.k(r0);
            goto L_0x003b;
        L_0x004f:
            r4 = r4.getPath();
            r3.k(r4);
        L_0x0056:
            throw r1;
        L_0x0057:
            if (r0 == 0) goto L_0x0071;
        L_0x0059:
            r4 = r0.iterator();
        L_0x005d:
            r0 = r4.hasNext();
            if (r0 == 0) goto L_0x0078;
        L_0x0063:
            r0 = r4.next();
            r0 = (android.util.Pair) r0;
            r0 = r0.second;
            r0 = (java.lang.String) r0;
            r3.k(r0);
            goto L_0x005d;
        L_0x0071:
            r4 = r4.getPath();
            r3.k(r4);
        L_0x0078:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.arch.persistence.db.SupportSQLiteOpenHelper.Callback.d(android.arch.persistence.db.SupportSQLiteDatabase):void");
        }

        private void k(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deleting the database file: ");
                stringBuilder.append(str);
                Log.w("SupportSQLite", stringBuilder.toString());
                try {
                    if (VERSION.SDK_INT >= 16) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } else {
                        try {
                            if (!new File(str).delete()) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Could not delete the database file ");
                                stringBuilder.append(str);
                                Log.e("SupportSQLite", stringBuilder.toString());
                            }
                        } catch (Throwable e) {
                            Log.e("SupportSQLite", "error while deleting corrupted database file", e);
                        }
                    }
                } catch (Throwable e2) {
                    Log.w("SupportSQLite", "delete failed: ", e2);
                }
            }
        }
    }

    public static class Configuration {
        @NonNull
        public final Callback bN;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;

        public static class Builder {
            Callback bO;
            Context mContext;
            String mName;

            public Configuration af() {
                if (this.bO == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.mContext != null) {
                    return new Configuration(this.mContext, this.mName, this.bO);
                } else {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
            }

            Builder(@NonNull Context context) {
                this.mContext = context;
            }

            public Builder l(@Nullable String str) {
                this.mName = str;
                return this;
            }

            public Builder a(@NonNull Callback callback) {
                this.bO = callback;
                return this;
            }
        }

        Configuration(@NonNull Context context, @Nullable String str, @NonNull Callback callback) {
            this.context = context;
            this.name = str;
            this.bN = callback;
        }

        public static Builder d(Context context) {
            return new Builder(context);
        }
    }

    public interface Factory {
        SupportSQLiteOpenHelper a(Configuration configuration);
    }

    SupportSQLiteDatabase ae();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
