package com.iqoption.core.microservices.techinstruments.a;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/microservices/techinstruments/response/StandardLibrary;", "", "()V", "version", "", "library", "Lcom/iqoption/core/microservices/techinstruments/response/StandardLibrary$Data;", "(JLcom/iqoption/core/microservices/techinstruments/response/StandardLibrary$Data;)V", "getLibrary", "()Lcom/iqoption/core/microservices/techinstruments/response/StandardLibrary$Data;", "getVersion", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Data", "core_release"})
/* compiled from: StandardLibrary.kt */
public final class d {
    @SerializedName("version")
    private final long aYa;
    @SerializedName("library")
    private final a aYb;

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/techinstruments/response/StandardLibrary$Data;", "", "()V", "categories", "", "Lcom/iqoption/core/microservices/techinstruments/response/Category;", "indicators", "Lcom/iqoption/core/microservices/techinstruments/response/Indicator;", "([Lcom/iqoption/core/microservices/techinstruments/response/Category;[Lcom/iqoption/core/microservices/techinstruments/response/Indicator;)V", "getCategories", "()[Lcom/iqoption/core/microservices/techinstruments/response/Category;", "[Lcom/iqoption/core/microservices/techinstruments/response/Category;", "getIndicators", "()[Lcom/iqoption/core/microservices/techinstruments/response/Indicator;", "[Lcom/iqoption/core/microservices/techinstruments/response/Indicator;", "component1", "component2", "copy", "([Lcom/iqoption/core/microservices/techinstruments/response/Category;[Lcom/iqoption/core/microservices/techinstruments/response/Indicator;)Lcom/iqoption/core/microservices/techinstruments/response/StandardLibrary$Data;", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
    /* compiled from: StandardLibrary.kt */
    public static final class a {
        @SerializedName("categories")
        private final a[] aYc;
        @SerializedName("indicators")
        private final b[] aYd;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Data(categories=");
            stringBuilder.append(Arrays.toString(this.aYc));
            stringBuilder.append(", indicators=");
            stringBuilder.append(Arrays.toString(this.aYd));
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(a[] aVarArr, b[] bVarArr) {
            h.e(aVarArr, "categories");
            h.e(bVarArr, "indicators");
            this.aYc = aVarArr;
            this.aYd = bVarArr;
        }

        public /* synthetic */ a(a[] aVarArr, b[] bVarArr, int i, f fVar) {
            if ((i & 1) != 0) {
                aVarArr = new a[0];
            }
            if ((i & 2) != 0) {
                bVarArr = new b[0];
            }
            this(aVarArr, bVarArr);
        }

        public final a[] WT() {
            return this.aYc;
        }

        public final b[] WU() {
            return this.aYd;
        }

        public a() {
            this(new a[0], null, 2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
                return false;
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.microservices.techinstruments.response.StandardLibrary.Data");
            }
            a aVar = (a) obj;
            if (Arrays.equals(this.aYc, aVar.aYc) && Arrays.equals(this.aYd, aVar.aYd)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.aYc) * 31) + Arrays.hashCode(this.aYd);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return ((this.aYa > dVar.aYa ? 1 : (this.aYa == dVar.aYa ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.aYb, dVar.aYb);
        }
    }

    public int hashCode() {
        long j = this.aYa;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        a aVar = this.aYb;
        return i + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StandardLibrary(version=");
        stringBuilder.append(this.aYa);
        stringBuilder.append(", library=");
        stringBuilder.append(this.aYb);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(long j, a aVar) {
        this.aYa = j;
        this.aYb = aVar;
    }

    public final long Kn() {
        return this.aYa;
    }

    public /* synthetic */ d(long j, a aVar, int i, f fVar) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            aVar = (a) null;
        }
        this(j, aVar);
    }

    public final a WS() {
        return this.aYb;
    }

    public d() {
        this(0, null, 2, null);
    }
}
