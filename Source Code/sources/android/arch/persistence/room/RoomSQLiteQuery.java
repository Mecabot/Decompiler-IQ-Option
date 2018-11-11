package android.arch.persistence.room;

import android.arch.persistence.db.SupportSQLiteProgram;
import android.arch.persistence.db.SupportSQLiteQuery;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

@RestrictTo({Scope.LIBRARY_GROUP})
public class RoomSQLiteQuery implements SupportSQLiteProgram, SupportSQLiteQuery {
    @VisibleForTesting
    static final TreeMap<Integer, RoomSQLiteQuery> dg = new TreeMap();
    @VisibleForTesting
    final long[] cZ;
    @VisibleForTesting
    final double[] da;
    @VisibleForTesting
    final String[] db;
    @VisibleForTesting
    final byte[][] dc;
    private final int[] dd;
    @VisibleForTesting
    final int de;
    @VisibleForTesting
    int df;
    private volatile String mQuery;

    public void close() {
    }

    public static RoomSQLiteQuery c(String str, int i) {
        synchronized (dg) {
            Entry ceilingEntry = dg.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                dg.remove(ceilingEntry.getKey());
                RoomSQLiteQuery roomSQLiteQuery = (RoomSQLiteQuery) ceilingEntry.getValue();
                roomSQLiteQuery.d(str, i);
                return roomSQLiteQuery;
            }
            RoomSQLiteQuery roomSQLiteQuery2 = new RoomSQLiteQuery(i);
            roomSQLiteQuery2.d(str, i);
            return roomSQLiteQuery2;
        }
    }

    private RoomSQLiteQuery(int i) {
        this.de = i;
        i++;
        this.dd = new int[i];
        this.cZ = new long[i];
        this.da = new double[i];
        this.db = new String[i];
        this.dc = new byte[i][];
    }

    void d(String str, int i) {
        this.mQuery = str;
        this.df = i;
    }

    public void release() {
        synchronized (dg) {
            dg.put(Integer.valueOf(this.de), this);
            av();
        }
    }

    private static void av() {
        if (dg.size() > 15) {
            int size = dg.size() - 10;
            Iterator it = dg.descendingKeySet().iterator();
            while (true) {
                int i = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i;
                } else {
                    return;
                }
            }
        }
    }

    public String ad() {
        return this.mQuery;
    }

    public void a(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i = 1; i <= this.df; i++) {
            switch (this.dd[i]) {
                case 1:
                    supportSQLiteProgram.bindNull(i);
                    break;
                case 2:
                    supportSQLiteProgram.bindLong(i, this.cZ[i]);
                    break;
                case 3:
                    supportSQLiteProgram.bindDouble(i, this.da[i]);
                    break;
                case 4:
                    supportSQLiteProgram.bindString(i, this.db[i]);
                    break;
                case 5:
                    supportSQLiteProgram.bindBlob(i, this.dc[i]);
                    break;
                default:
                    break;
            }
        }
    }

    public void bindNull(int i) {
        this.dd[i] = 1;
    }

    public void bindLong(int i, long j) {
        this.dd[i] = 2;
        this.cZ[i] = j;
    }

    public void bindDouble(int i, double d) {
        this.dd[i] = 3;
        this.da[i] = d;
    }

    public void bindString(int i, String str) {
        this.dd[i] = 4;
        this.db[i] = str;
    }

    public void bindBlob(int i, byte[] bArr) {
        this.dd[i] = 5;
        this.dc[i] = bArr;
    }
}
