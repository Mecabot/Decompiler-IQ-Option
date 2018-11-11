package com.iqoption.util;

import android.support.v4.app.NotificationCompat;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, aXE = {"Lcom/iqoption/util/Resource;", "T", "", "status", "Lcom/iqoption/util/Status;", "data", "message", "", "throwable", "", "(Lcom/iqoption/util/Status;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getStatus", "()Lcom/iqoption/util/Status;", "getThrowable", "()Ljava/lang/Throwable;", "equals", "", "o", "hashCode", "", "toString", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Resource.kt */
public final class ba<T> {
    public static final a dww = new a();
    private final Throwable baX;
    private final T data;
    private final Status dwv;
    private final String message;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\u000bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\rJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\r¨\u0006\u000f"}, aXE = {"Lcom/iqoption/util/Resource$Companion;", "", "()V", "error", "Lcom/iqoption/util/Resource;", "T", "throwable", "", "message", "", "data", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Object;)Lcom/iqoption/util/Resource;", "loading", "(Ljava/lang/Object;)Lcom/iqoption/util/Resource;", "success", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Resource.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* synthetic */ ba a(a aVar, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return aVar.bK(obj);
        }

        public final <T> ba<T> bK(T t) {
            return new ba(Status.SUCCESS, t, null, null, 8, null);
        }

        public static /* synthetic */ ba a(a aVar, Throwable th, String str, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                th = (Throwable) null;
            }
            if ((i & 2) != 0) {
                str = (String) null;
            }
            if ((i & 4) != 0) {
                obj = null;
            }
            return aVar.b(th, str, obj);
        }

        public final <T> ba<T> b(Throwable th, String str, T t) {
            return new ba(Status.ERROR, t, str, th);
        }

        public static /* synthetic */ ba b(a aVar, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return aVar.bL(obj);
        }

        public final <T> ba<T> bL(T t) {
            return new ba(Status.LOADING, t, null, null, 8, null);
        }
    }

    public ba(Status status, T t, String str, Throwable th) {
        h.e(status, NotificationCompat.CATEGORY_STATUS);
        this.dwv = status;
        this.data = t;
        this.message = str;
        this.baX = th;
    }

    public /* synthetic */ ba(Status status, Object obj, String str, Throwable th, int i, f fVar) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            str = (String) null;
        }
        if ((i & 8) != 0) {
            th = (Throwable) null;
        }
        this(status, obj, str, th);
    }

    public final Status aGv() {
        return this.dwv;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || (h.E(getClass(), obj.getClass()) ^ 1) != 0) {
            return false;
        }
        ba baVar = (ba) obj;
        if (this.dwv != baVar.dwv) {
            return false;
        }
        int E = this.message != null ? h.E(this.message, baVar.message) ^ 1 : baVar.message != null ? 1 : 0;
        if (E != 0) {
            return false;
        }
        if (this.data != null) {
            z = h.E(this.data, baVar.data);
        } else if (baVar.data != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int hashCode = this.dwv.hashCode() * 31;
        String str = this.message;
        int i = 0;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.data;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource{status=");
        stringBuilder.append(this.dwv);
        stringBuilder.append(", message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", data=");
        stringBuilder.append(this.data);
        stringBuilder.append(", throwable=");
        stringBuilder.append(this.baX);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
