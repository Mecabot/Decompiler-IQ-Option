package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
@Hide
public final class DataHolder extends zzbgl implements Closeable {
    public static final Creator<DataHolder> CREATOR = new zzf();
    private static final zza zzgcs = new zze(new String[0], null);
    private boolean mClosed;
    private final int zzcc;
    private int zzehz;
    private final String[] zzgcl;
    private Bundle zzgcm;
    private final CursorWindow[] zzgcn;
    private final Bundle zzgco;
    private int[] zzgcp;
    int zzgcq;
    private boolean zzgcr;

    public static class zza {
        private final String[] zzgcl;
        private final ArrayList<HashMap<String, Object>> zzgct;
        private final String zzgcu;
        private final HashMap<Object, Integer> zzgcv;
        private boolean zzgcw;
        private String zzgcx;

        private zza(String[] strArr, String str) {
            this.zzgcl = (String[]) zzbq.checkNotNull(strArr);
            this.zzgct = new ArrayList();
            this.zzgcu = str;
            this.zzgcv = new HashMap();
            this.zzgcw = false;
            this.zzgcx = null;
        }

        /* synthetic */ zza(String[] strArr, String str, zze zze) {
            this(strArr, null);
        }

        public zza zza(ContentValues contentValues) {
            zzc.zzv(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Entry entry : contentValues.valueSet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            return zza(hashMap);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
        public com.google.android.gms.common.data.DataHolder.zza zza(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
            r4 = this;
            com.google.android.gms.common.internal.zzc.zzv(r5);
            r0 = r4.zzgcu;
            r1 = -1;
            if (r0 != 0) goto L_0x000a;
        L_0x0008:
            r0 = -1;
            goto L_0x0031;
        L_0x000a:
            r0 = r4.zzgcu;
            r0 = r5.get(r0);
            if (r0 != 0) goto L_0x0013;
        L_0x0012:
            goto L_0x0008;
        L_0x0013:
            r2 = r4.zzgcv;
            r2 = r2.get(r0);
            r2 = (java.lang.Integer) r2;
            if (r2 != 0) goto L_0x002d;
        L_0x001d:
            r2 = r4.zzgcv;
            r3 = r4.zzgct;
            r3 = r3.size();
            r3 = java.lang.Integer.valueOf(r3);
            r2.put(r0, r3);
            goto L_0x0008;
        L_0x002d:
            r0 = r2.intValue();
        L_0x0031:
            if (r0 != r1) goto L_0x0039;
        L_0x0033:
            r0 = r4.zzgct;
            r0.add(r5);
            goto L_0x0043;
        L_0x0039:
            r1 = r4.zzgct;
            r1.remove(r0);
            r1 = r4.zzgct;
            r1.add(r0, r5);
        L_0x0043:
            r5 = 0;
            r4.zzgcw = r5;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.zza.zza(java.util.HashMap):com.google.android.gms.common.data.DataHolder$zza");
        }

        public final DataHolder zzca(int i) {
            return new DataHolder(this, 0, null, null);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzgcr = true;
        this.zzehz = i;
        this.zzgcl = strArr;
        this.zzgcn = cursorWindowArr;
        this.zzcc = i2;
        this.zzgco = bundle;
    }

    private DataHolder(zza zza, int i, Bundle bundle) {
        this(zza.zzgcl, zza(zza, -1), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzgcr = true;
        this.zzehz = 1;
        this.zzgcl = (String[]) zzbq.checkNotNull(strArr);
        this.zzgcn = (CursorWindow[]) zzbq.checkNotNull(cursorWindowArr);
        this.zzcc = i;
        this.zzgco = bundle;
        zzali();
    }

    private static CursorWindow[] zza(zza zza, int i) {
        int i2 = 0;
        if (zza.zzgcl.length == 0) {
            return new CursorWindow[0];
        }
        List zzb = zza.zzgct;
        int size = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(zza.zzgcl.length);
        CursorWindow cursorWindow2 = cursorWindow;
        int i3 = 0;
        Object obj = null;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    StringBuilder stringBuilder = new StringBuilder(72);
                    stringBuilder.append("Allocating additional cursor window for large data set (row ");
                    stringBuilder.append(i3);
                    stringBuilder.append(")");
                    Log.d("DataHolder", stringBuilder.toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza.zzgcl.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zzb.get(i3);
                boolean z = true;
                for (int i4 = 0; i4 < zza.zzgcl.length && z; i4++) {
                    String str = zza.zzgcl[i4];
                    Object obj2 = map.get(str);
                    if (obj2 == null) {
                        z = cursorWindow2.putNull(i3, i4);
                    } else if (obj2 instanceof String) {
                        z = cursorWindow2.putString((String) obj2, i3, i4);
                    } else {
                        long longValue;
                        if (obj2 instanceof Long) {
                            longValue = ((Long) obj2).longValue();
                        } else if (obj2 instanceof Integer) {
                            z = cursorWindow2.putLong((long) ((Integer) obj2).intValue(), i3, i4);
                        } else if (obj2 instanceof Boolean) {
                            longValue = ((Boolean) obj2).booleanValue() ? 1 : 0;
                        } else if (obj2 instanceof byte[]) {
                            z = cursorWindow2.putBlob((byte[]) obj2, i3, i4);
                        } else if (obj2 instanceof Double) {
                            z = cursorWindow2.putDouble(((Double) obj2).doubleValue(), i3, i4);
                        } else if (obj2 instanceof Float) {
                            z = cursorWindow2.putDouble((double) ((Float) obj2).floatValue(), i3, i4);
                        } else {
                            String valueOf = String.valueOf(obj2);
                            StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length());
                            stringBuilder2.append("Unsupported object for column ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(": ");
                            stringBuilder2.append(valueOf);
                            throw new IllegalArgumentException(stringBuilder2.toString());
                        }
                        z = cursorWindow2.putLong(longValue, i3, i4);
                    }
                }
                if (z) {
                    obj = null;
                } else if (obj != null) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    StringBuilder stringBuilder3 = new StringBuilder(74);
                    stringBuilder3.append("Couldn't populate window data for row ");
                    stringBuilder3.append(i3);
                    stringBuilder3.append(" - allocating new window.");
                    Log.d("DataHolder", stringBuilder3.toString());
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza.zzgcl.length);
                    arrayList.add(cursorWindow2);
                    i3--;
                    obj = 1;
                }
                i3++;
            } catch (RuntimeException e) {
                i = arrayList.size();
                while (i2 < i) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static zza zzb(String[] strArr) {
        return new zza(strArr, null, null);
    }

    public static DataHolder zzbz(int i) {
        return new DataHolder(zzgcs, i, null);
    }

    private final void zzh(String str, int i) {
        if (this.zzgcm == null || !this.zzgcm.containsKey(str)) {
            String str2 = "No such column: ";
            str = String.valueOf(str);
            throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzgcq) {
            throw new CursorIndexOutOfBoundsException(i, this.zzgcq);
        }
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzgcn) {
                    close.close();
                }
            }
        }
    }

    protected final void finalize() {
        try {
            if (this.zzgcr && this.zzgcn.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(obj).length() + 178);
                stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                stringBuilder.append(obj);
                stringBuilder.append(")");
                Log.e("DataBuffer", stringBuilder.toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final int getCount() {
        return this.zzgcq;
    }

    public final int getStatusCode() {
        return this.zzcc;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.zzgcl, false);
        zzbgo.zza(parcel, 2, this.zzgcn, i, false);
        zzbgo.zzc(parcel, 3, this.zzcc);
        zzbgo.zza(parcel, 4, this.zzgco, false);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zzai(parcel, zze);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzh(str, i);
        this.zzgcn[i2].copyStringToBuffer(i, this.zzgcm.getInt(str), charArrayBuffer);
    }

    @Hide
    public final Bundle zzahs() {
        return this.zzgco;
    }

    public final void zzali() {
        int i;
        this.zzgcm = new Bundle();
        for (i = 0; i < this.zzgcl.length; i++) {
            this.zzgcm.putInt(this.zzgcl[i], i);
        }
        this.zzgcp = new int[this.zzgcn.length];
        i = 0;
        for (int i2 = 0; i2 < this.zzgcn.length; i2++) {
            this.zzgcp[i2] = i;
            i += this.zzgcn[i2].getNumRows() - (i - this.zzgcn[i2].getStartPosition());
        }
        this.zzgcq = i;
    }

    public final long zzb(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getLong(i, this.zzgcm.getInt(str));
    }

    @Hide
    public final int zzby(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzgcq;
        zzbq.checkState(z);
        while (i2 < this.zzgcp.length) {
            if (i < this.zzgcp[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzgcp.length ? i2 - 1 : i2;
    }

    public final int zzc(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getInt(i, this.zzgcm.getInt(str));
    }

    public final String zzd(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getString(i, this.zzgcm.getInt(str));
    }

    public final boolean zze(String str, int i, int i2) {
        zzh(str, i);
        return Long.valueOf(this.zzgcn[i2].getLong(i, this.zzgcm.getInt(str))).longValue() == 1;
    }

    public final float zzf(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getFloat(i, this.zzgcm.getInt(str));
    }

    public final byte[] zzg(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getBlob(i, this.zzgcm.getInt(str));
    }

    public final boolean zzgj(String str) {
        return this.zzgcm.containsKey(str);
    }

    public final boolean zzh(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].isNull(i, this.zzgcm.getInt(str));
    }
}
