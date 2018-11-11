package android.arch.persistence.db;

import android.support.annotation.Nullable;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    @Nullable
    private final Object[] bM;
    private final String mQuery;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.mQuery = str;
        this.bM = objArr;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }

    public String ad() {
        return this.mQuery;
    }

    public void a(SupportSQLiteProgram supportSQLiteProgram) {
        a(supportSQLiteProgram, this.bM);
    }

    public static void a(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                a(supportSQLiteProgram, i, obj);
            }
        }
    }

    private static void a(SupportSQLiteProgram supportSQLiteProgram, int i, Object obj) {
        if (obj == null) {
            supportSQLiteProgram.bindNull(i);
        } else if (obj instanceof byte[]) {
            supportSQLiteProgram.bindBlob(i, (byte[]) obj);
        } else if (obj instanceof Float) {
            supportSQLiteProgram.bindDouble(i, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            supportSQLiteProgram.bindDouble(i, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            supportSQLiteProgram.bindLong(i, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            supportSQLiteProgram.bindLong(i, (long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            supportSQLiteProgram.bindLong(i, (long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            supportSQLiteProgram.bindLong(i, (long) ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            supportSQLiteProgram.bindString(i, (String) obj);
        } else if (obj instanceof Boolean) {
            supportSQLiteProgram.bindLong(i, ((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot bind ");
            stringBuilder.append(obj);
            stringBuilder.append(" at index ");
            stringBuilder.append(i);
            stringBuilder.append(" Supported types: null, byte[], float, double, long, int, short, byte,");
            stringBuilder.append(" string");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
