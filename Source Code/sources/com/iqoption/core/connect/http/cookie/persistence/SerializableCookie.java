package com.iqoption.core.connect.http.cookie.persistence;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;
import okhttp3.Cookie.Builder;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/persistence/SerializableCookie;", "Ljava/io/Serializable;", "()V", "cookie", "Lokhttp3/Cookie;", "decode", "encodedCookie", "", "encode", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "writeObject", "out", "Ljava/io/ObjectOutputStream;", "Companion", "core_release"})
/* compiled from: SerializableCookie.kt */
public final class SerializableCookie implements Serializable {
    private static final String TAG = "SerializableCookie";
    public static final a aOd = new a();
    private static final long serialVersionUID = -8594045714036645534L;
    private transient Cookie aOa;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/persistence/SerializableCookie$Companion;", "", "()V", "NON_VALID_EXPIRES_AT", "", "TAG", "", "kotlin.jvm.PlatformType", "serialVersionUID", "byteArrayToHexString", "bytes", "", "hexStringToByteArray", "hexString", "core_release"})
    /* compiled from: SerializableCookie.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final String q(byte[] bArr) {
            StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                int i = b & 255;
                if (i < 16) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(Integer.toHexString(i));
            }
            String stringBuilder2 = stringBuilder.toString();
            h.d(stringBuilder2, "sb.toString()");
            return stringBuilder2;
        }

        private final byte[] gh(String str) {
            int length = str.length();
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            }
            return bArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d A:{SYNTHETIC, Splitter: B:20:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A:{SYNTHETIC, Splitter: B:26:0x005e} */
    public final java.lang.String d(okhttp3.Cookie r5) {
        /*
        r4 = this;
        r0 = "cookie";
        kotlin.jvm.internal.h.e(r5, r0);
        r4.aOa = r5;
        r5 = new java.io.ByteArrayOutputStream;
        r5.<init>();
        r0 = 0;
        r1 = r0;
        r1 = (java.io.ObjectOutputStream) r1;
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x0041 }
        r3 = r5;
        r3 = (java.io.OutputStream) r3;	 Catch:{ IOException -> 0x0041 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0041 }
        r2.writeObject(r4);	 Catch:{ IOException -> 0x003c, all -> 0x0039 }
        r2.close();	 Catch:{ IOException -> 0x001f }
        goto L_0x0029;
    L_0x001f:
        r0 = move-exception;
        r1 = TAG;
        r2 = "Stream not closed in encodeCookie";
        r0 = (java.lang.Throwable) r0;
        com.iqoption.core.i.d(r1, r2, r0);
    L_0x0029:
        r0 = aOd;
        r5 = r5.toByteArray();
        r1 = "byteArrayOutputStream.toByteArray()";
        kotlin.jvm.internal.h.d(r5, r1);
        r5 = r0.q(r5);
        return r5;
    L_0x0039:
        r5 = move-exception;
        r1 = r2;
        goto L_0x005c;
    L_0x003c:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0042;
    L_0x003f:
        r5 = move-exception;
        goto L_0x005c;
    L_0x0041:
        r5 = move-exception;
    L_0x0042:
        r2 = TAG;	 Catch:{ all -> 0x003f }
        r3 = "IOException in encodeCookie";
        r5 = (java.lang.Throwable) r5;	 Catch:{ all -> 0x003f }
        com.iqoption.core.i.d(r2, r3, r5);	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x005b;
    L_0x004d:
        r1.close();	 Catch:{ IOException -> 0x0051 }
        goto L_0x005b;
    L_0x0051:
        r5 = move-exception;
        r1 = TAG;
        r2 = "Stream not closed in encodeCookie";
        r5 = (java.lang.Throwable) r5;
        com.iqoption.core.i.d(r1, r2, r5);
    L_0x005b:
        return r0;
    L_0x005c:
        if (r1 == 0) goto L_0x006c;
    L_0x005e:
        r1.close();	 Catch:{ IOException -> 0x0062 }
        goto L_0x006c;
    L_0x0062:
        r0 = move-exception;
        r1 = TAG;
        r2 = "Stream not closed in encodeCookie";
        r0 = (java.lang.Throwable) r0;
        com.iqoption.core.i.d(r1, r2, r0);
    L_0x006c:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.http.cookie.persistence.SerializableCookie.d(okhttp3.Cookie):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A:{SYNTHETIC, Splitter: B:31:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A:{SYNTHETIC, Splitter: B:22:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079 A:{SYNTHETIC, Splitter: B:36:0x0079} */
    public final okhttp3.Cookie gg(java.lang.String r5) {
        /*
        r4 = this;
        r0 = "encodedCookie";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = aOd;
        r5 = r0.gh(r5);
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r5);
        r5 = 0;
        r1 = r5;
        r1 = (okhttp3.Cookie) r1;
        r5 = (java.io.ObjectInputStream) r5;
        r2 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0063, ClassNotFoundException -> 0x0046, all -> 0x0042 }
        r0 = (java.io.InputStream) r0;	 Catch:{ IOException -> 0x0063, ClassNotFoundException -> 0x0046, all -> 0x0042 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0063, ClassNotFoundException -> 0x0046, all -> 0x0042 }
        r5 = r2.readObject();	 Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
        if (r5 != 0) goto L_0x002b;
    L_0x0023:
        r5 = new kotlin.TypeCastException;	 Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
        r0 = "null cannot be cast to non-null type com.iqoption.core.connect.http.cookie.persistence.SerializableCookie";
        r5.<init>(r0);	 Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
        throw r5;	 Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
    L_0x002b:
        r5 = (com.iqoption.core.connect.http.cookie.persistence.SerializableCookie) r5;	 Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
        r5 = r5.aOa;	 Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
        r2.close();	 Catch:{ IOException -> 0x0033 }
        goto L_0x0075;
    L_0x0033:
        r0 = move-exception;
        r1 = TAG;
        r2 = "Stream not closed in decodeCookie";
        r0 = (java.lang.Throwable) r0;
        com.iqoption.core.i.d(r1, r2, r0);
        goto L_0x0075;
    L_0x003e:
        r5 = move-exception;
        goto L_0x0049;
    L_0x0040:
        r5 = move-exception;
        goto L_0x0066;
    L_0x0042:
        r0 = move-exception;
        r2 = r5;
        r5 = r0;
        goto L_0x0077;
    L_0x0046:
        r0 = move-exception;
        r2 = r5;
        r5 = r0;
    L_0x0049:
        r0 = TAG;	 Catch:{ all -> 0x0076 }
        r3 = "ClassNotFoundException in decodeCookie";
        r5 = (java.lang.Throwable) r5;	 Catch:{ all -> 0x0076 }
        com.iqoption.core.i.d(r0, r3, r5);	 Catch:{ all -> 0x0076 }
        if (r2 == 0) goto L_0x0074;
    L_0x0054:
        r2.close();	 Catch:{ IOException -> 0x0058 }
        goto L_0x0074;
    L_0x0058:
        r5 = move-exception;
        r0 = TAG;
        r2 = "Stream not closed in decodeCookie";
        r5 = (java.lang.Throwable) r5;
        com.iqoption.core.i.d(r0, r2, r5);
        goto L_0x0074;
    L_0x0063:
        r0 = move-exception;
        r2 = r5;
        r5 = r0;
    L_0x0066:
        r0 = TAG;	 Catch:{ all -> 0x0076 }
        r3 = "IOException in decodeCookie";
        r5 = (java.lang.Throwable) r5;	 Catch:{ all -> 0x0076 }
        com.iqoption.core.i.d(r0, r3, r5);	 Catch:{ all -> 0x0076 }
        if (r2 == 0) goto L_0x0074;
    L_0x0071:
        r2.close();	 Catch:{ IOException -> 0x0058 }
    L_0x0074:
        r5 = r1;
    L_0x0075:
        return r5;
    L_0x0076:
        r5 = move-exception;
    L_0x0077:
        if (r2 == 0) goto L_0x0087;
    L_0x0079:
        r2.close();	 Catch:{ IOException -> 0x007d }
        goto L_0x0087;
    L_0x007d:
        r0 = move-exception;
        r1 = TAG;
        r2 = "Stream not closed in decodeCookie";
        r0 = (java.lang.Throwable) r0;
        com.iqoption.core.i.d(r1, r2, r0);
    L_0x0087:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.http.cookie.persistence.SerializableCookie.gg(java.lang.String):okhttp3.Cookie");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) {
        long expiresAt;
        Cookie cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeObject(cookie.name());
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeObject(cookie.value());
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        if (cookie.persistent()) {
            cookie = this.aOa;
            if (cookie == null) {
                h.aXZ();
            }
            expiresAt = cookie.expiresAt();
        } else {
            expiresAt = -1;
        }
        objectOutputStream.writeLong(expiresAt);
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeObject(cookie.domain());
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeObject(cookie.path());
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeBoolean(cookie.secure());
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeBoolean(cookie.httpOnly());
        cookie = this.aOa;
        if (cookie == null) {
            h.aXZ();
        }
        objectOutputStream.writeBoolean(cookie.hostOnly());
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        Builder builder = new Builder();
        Object readObject = objectInputStream.readObject();
        if (readObject == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        builder.name((String) readObject);
        readObject = objectInputStream.readObject();
        if (readObject == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        builder.value((String) readObject);
        long readLong = objectInputStream.readLong();
        if (readLong != -1) {
            builder.expiresAt(readLong);
        }
        readObject = objectInputStream.readObject();
        if (readObject == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) readObject;
        builder.domain(str);
        Object readObject2 = objectInputStream.readObject();
        if (readObject2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        builder.path((String) readObject2);
        if (objectInputStream.readBoolean()) {
            builder.secure();
        }
        if (objectInputStream.readBoolean()) {
            builder.httpOnly();
        }
        if (objectInputStream.readBoolean()) {
            builder.hostOnlyDomain(str);
        }
        this.aOa = builder.build();
    }
}
