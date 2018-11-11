package android.arch.persistence.room.util;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@RestrictTo({Scope.LIBRARY_GROUP})
public class TableInfo {
    public final Map<String, Column> dl;
    public final Set<ForeignKey> dm;
    @Nullable
    public final Set<Index> do;
    public final String name;

    public static class Column {
        public final int dp;
        public final boolean dq;
        public final int dr;
        public final String name;
        public final String type;

        public Column(String str, String str2, boolean z, int i) {
            this.name = str;
            this.type = str2;
            this.dq = z;
            this.dr = i;
            this.dp = n(str2);
        }

        private static int n(@Nullable String str) {
            if (str == null) {
                return 5;
            }
            str = str.toUpperCase(Locale.US);
            if (str.contains("INT")) {
                return 3;
            }
            if (str.contains("CHAR") || str.contains("CLOB") || str.contains("TEXT")) {
                return 2;
            }
            if (str.contains("BLOB")) {
                return 5;
            }
            return (str.contains("REAL") || str.contains("FLOA") || str.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (VERSION.SDK_INT >= 20) {
                if (this.dr != column.dr) {
                    return false;
                }
            } else if (aA() != column.aA()) {
                return false;
            }
            if (!this.name.equals(column.name) || this.dq != column.dq) {
                return false;
            }
            if (this.dp != column.dp) {
                z = false;
            }
            return z;
        }

        public boolean aA() {
            return this.dr > 0;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.dp) * 31) + (this.dq ? 1231 : 1237)) * 31) + this.dr;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Column{name='");
            stringBuilder.append(this.name);
            stringBuilder.append('\'');
            stringBuilder.append(", type='");
            stringBuilder.append(this.type);
            stringBuilder.append('\'');
            stringBuilder.append(", affinity='");
            stringBuilder.append(this.dp);
            stringBuilder.append('\'');
            stringBuilder.append(", notNull=");
            stringBuilder.append(this.dq);
            stringBuilder.append(", primaryKeyPosition=");
            stringBuilder.append(this.dr);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class ForeignKey {
        @NonNull
        public final String ds;
        @NonNull
        public final String dt;
        @NonNull
        public final String du;
        @NonNull
        public final List<String> dw;
        @NonNull
        public final List<String> dx;

        public ForeignKey(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<String> list, @NonNull List<String> list2) {
            this.ds = str;
            this.dt = str2;
            this.du = str3;
            this.dw = Collections.unmodifiableList(list);
            this.dx = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.ds.equals(foreignKey.ds) && this.dt.equals(foreignKey.dt) && this.du.equals(foreignKey.du) && this.dw.equals(foreignKey.dw)) {
                return this.dx.equals(foreignKey.dx);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.ds.hashCode() * 31) + this.dt.hashCode()) * 31) + this.du.hashCode()) * 31) + this.dw.hashCode()) * 31) + this.dx.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ForeignKey{referenceTable='");
            stringBuilder.append(this.ds);
            stringBuilder.append('\'');
            stringBuilder.append(", onDelete='");
            stringBuilder.append(this.dt);
            stringBuilder.append('\'');
            stringBuilder.append(", onUpdate='");
            stringBuilder.append(this.du);
            stringBuilder.append('\'');
            stringBuilder.append(", columnNames=");
            stringBuilder.append(this.dw);
            stringBuilder.append(", referenceColumnNames=");
            stringBuilder.append(this.dx);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        final String dA;
        final int dy;
        final String dz;
        final int mId;

        ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.mId = i;
            this.dy = i2;
            this.dz = str;
            this.dA = str2;
        }

        /* renamed from: a */
        public int compareTo(@NonNull ForeignKeyWithSequence foreignKeyWithSequence) {
            int i = this.mId - foreignKeyWithSequence.mId;
            return i == 0 ? this.dy - foreignKeyWithSequence.dy : i;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class Index {
        public final boolean dB;
        public final List<String> dC;
        public final String name;

        public Index(String str, boolean z, List<String> list) {
            this.name = str;
            this.dB = z;
            this.dC = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.dB != index.dB || !this.dC.equals(index.dC)) {
                return false;
            }
            if (this.name.startsWith("index_")) {
                return index.name.startsWith("index_");
            }
            return this.name.equals(index.name);
        }

        public int hashCode() {
            int hashCode;
            if (this.name.startsWith("index_")) {
                hashCode = "index_".hashCode();
            } else {
                hashCode = this.name.hashCode();
            }
            return (((hashCode * 31) + this.dB) * 31) + this.dC.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index{name='");
            stringBuilder.append(this.name);
            stringBuilder.append('\'');
            stringBuilder.append(", unique=");
            stringBuilder.append(this.dB);
            stringBuilder.append(", columns=");
            stringBuilder.append(this.dC);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set set3;
        this.name = str;
        this.dl = Collections.unmodifiableMap(map);
        this.dm = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.do = set3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!this.name == null ? this.name.equals(tableInfo.name) : tableInfo.name == null) {
            return false;
        }
        if (!this.dl == null ? this.dl.equals(tableInfo.dl) : tableInfo.dl == null) {
            return false;
        }
        if (!this.dm == null ? this.dm.equals(tableInfo.dm) : tableInfo.dm == null) {
            return false;
        }
        if (this.do == null || tableInfo.do == null) {
            return true;
        }
        return this.do.equals(tableInfo.do);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.name != null ? this.name.hashCode() : 0) * 31) + (this.dl != null ? this.dl.hashCode() : 0)) * 31;
        if (this.dm != null) {
            i = this.dm.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TableInfo{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        stringBuilder.append(this.dl);
        stringBuilder.append(", foreignKeys=");
        stringBuilder.append(this.dm);
        stringBuilder.append(", indices=");
        stringBuilder.append(this.do);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static TableInfo a(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return new TableInfo(str, c(supportSQLiteDatabase, str), b(supportSQLiteDatabase, str), d(supportSQLiteDatabase, str));
    }

    private static Set<ForeignKey> b(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Set<ForeignKey> hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA foreign_key_list(`");
        stringBuilder.append(str);
        stringBuilder.append("`)");
        Cursor j = supportSQLiteDatabase.j(stringBuilder.toString());
        try {
            int columnIndex = j.getColumnIndex("id");
            int columnIndex2 = j.getColumnIndex("seq");
            int columnIndex3 = j.getColumnIndex("table");
            int columnIndex4 = j.getColumnIndex("on_delete");
            int columnIndex5 = j.getColumnIndex("on_update");
            List<ForeignKeyWithSequence> a = a(j);
            int count = j.getCount();
            int i = 0;
            while (i < count) {
                int i2;
                j.moveToPosition(i);
                if (j.getInt(columnIndex2) != 0) {
                    i2 = columnIndex;
                } else {
                    int i3 = j.getInt(columnIndex);
                    List arrayList = new ArrayList();
                    List arrayList2 = new ArrayList();
                    for (ForeignKeyWithSequence foreignKeyWithSequence : a) {
                        i2 = columnIndex;
                        if (foreignKeyWithSequence.mId == i3) {
                            arrayList.add(foreignKeyWithSequence.dz);
                            arrayList2.add(foreignKeyWithSequence.dA);
                        }
                        columnIndex = i2;
                    }
                    i2 = columnIndex;
                    List list = arrayList2;
                    hashSet.add(new ForeignKey(j.getString(columnIndex3), j.getString(columnIndex4), j.getString(columnIndex5), arrayList, list));
                }
                i++;
                columnIndex = i2;
            }
            j.close();
            return hashSet;
        } catch (Throwable th) {
            Throwable th2 = th;
            j.close();
        }
    }

    private static List<ForeignKeyWithSequence> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        List<ForeignKeyWithSequence> arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Map<String, Column> c(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA table_info(`");
        stringBuilder.append(str);
        stringBuilder.append("`)");
        Cursor j = supportSQLiteDatabase.j(stringBuilder.toString());
        Map<String, Column> hashMap = new HashMap();
        try {
            if (j.getColumnCount() > 0) {
                int columnIndex = j.getColumnIndex("name");
                int columnIndex2 = j.getColumnIndex(Param.TYPE);
                int columnIndex3 = j.getColumnIndex("notnull");
                int columnIndex4 = j.getColumnIndex("pk");
                while (j.moveToNext()) {
                    String string = j.getString(columnIndex);
                    hashMap.put(string, new Column(string, j.getString(columnIndex2), j.getInt(columnIndex3) != 0, j.getInt(columnIndex4)));
                }
            }
            j.close();
            return hashMap;
        } catch (Throwable th) {
            j.close();
        }
    }

    @Nullable
    private static Set<Index> d(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA index_list(`");
        stringBuilder.append(str);
        stringBuilder.append("`)");
        Cursor j = supportSQLiteDatabase.j(stringBuilder.toString());
        try {
            int columnIndex = j.getColumnIndex("name");
            int columnIndex2 = j.getColumnIndex(b.ORIGIN);
            int columnIndex3 = j.getColumnIndex("unique");
            Set<Index> set = null;
            if (columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1) {
                j.close();
                return set;
            }
            Set hashSet = new HashSet();
            while (j.moveToNext()) {
                if ("c".equals(j.getString(columnIndex2))) {
                    String string = j.getString(columnIndex);
                    boolean z = true;
                    if (j.getInt(columnIndex3) != 1) {
                        z = false;
                    }
                    Index a = a(supportSQLiteDatabase, string, z);
                    if (a == null) {
                        return set;
                    }
                    hashSet.add(a);
                }
            }
            j.close();
            return hashSet;
        } finally {
            j.close();
        }
    }

    @Nullable
    private static Index a(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA index_xinfo(`");
        stringBuilder.append(str);
        Index index = "`)";
        stringBuilder.append(index);
        Cursor j = supportSQLiteDatabase.j(stringBuilder.toString());
        try {
            int columnIndex = j.getColumnIndex("seqno");
            int columnIndex2 = j.getColumnIndex("cid");
            int columnIndex3 = j.getColumnIndex("name");
            if (columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1) {
                j.close();
                return null;
            }
            TreeMap treeMap = new TreeMap();
            while (j.moveToNext()) {
                if (j.getInt(columnIndex2) >= 0) {
                    int i = j.getInt(columnIndex);
                    treeMap.put(Integer.valueOf(i), j.getString(columnIndex3));
                }
            }
            List arrayList = new ArrayList(treeMap.size());
            arrayList.addAll(treeMap.values());
            index = new Index(str, z, arrayList);
            return index;
        } finally {
            j.close();
        }
    }
}
