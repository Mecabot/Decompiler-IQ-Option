package com.iqoption.chat.viewmodel;

import com.iqoption.x.R;
import java.io.File;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0019"}, aXE = {"Lcom/iqoption/chat/viewmodel/FileItem;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "id", "", "getId", "()J", "modified", "", "getModified", "()Ljava/lang/String;", "size", "getSize", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FilePickerViewModel.kt */
public final class c {
    private final String aKj;
    private final String aKk;
    private final File file;
    private final long id = ((long) this.file.getPath().hashCode());

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.file, ((com.iqoption.chat.viewmodel.c) r2).file) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.chat.viewmodel.c;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.chat.viewmodel.c) r2;
        r0 = r1.file;
        r2 = r2.file;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.viewmodel.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        File file = this.file;
        return file != null ? file.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileItem(file=");
        stringBuilder.append(this.file);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(File file) {
        h.e(file, "file");
        this.file = file;
        String str;
        if (this.file.isDirectory()) {
            str = (String) null;
            this.aKj = str;
            this.aKk = str;
            return;
        }
        double length = (double) this.file.length();
        Object[] objArr;
        m mVar;
        Object[] objArr2;
        String format;
        if (length == 0.0d) {
            str = "";
        } else if (length > 1.099511627776E12d) {
            objArr = new Object[1];
            mVar = m.euz;
            objArr2 = new Object[]{Double.valueOf(length / 1.099511627776E12d)};
            format = String.format("%.1f", Arrays.copyOf(objArr2, objArr2.length));
            h.d(format, "java.lang.String.format(format, *args)");
            objArr[0] = format;
            str = d.getString(R.string.n1_tb, objArr);
        } else if (length > 1.073741824E9d) {
            objArr = new Object[1];
            mVar = m.euz;
            objArr2 = new Object[]{Double.valueOf(length / 1.073741824E9d)};
            format = String.format("%.1f", Arrays.copyOf(objArr2, objArr2.length));
            h.d(format, "java.lang.String.format(format, *args)");
            objArr[0] = format;
            str = d.getString(R.string.n1_gb, objArr);
        } else if (length > 1048576.0d) {
            objArr = new Object[1];
            mVar = m.euz;
            objArr2 = new Object[]{Double.valueOf(length / 1048576.0d)};
            format = String.format("%.1f", Arrays.copyOf(objArr2, objArr2.length));
            h.d(format, "java.lang.String.format(format, *args)");
            objArr[0] = format;
            str = d.getString(R.string.n1_mb, objArr);
        } else if (length > 1024.0d) {
            objArr = new Object[1];
            mVar = m.euz;
            objArr2 = new Object[]{Double.valueOf(length / 1024.0d)};
            format = String.format("%.1f", Arrays.copyOf(objArr2, objArr2.length));
            h.d(format, "java.lang.String.format(format, *args)");
            objArr[0] = format;
            str = d.getString(R.string.n1_kb, objArr);
        } else {
            str = d.getString(R.string.n1_bytes, Long.valueOf((long) length));
        }
        this.aKj = str;
        this.aKk = d.aKx.format(Long.valueOf(this.file.lastModified()));
    }

    public final File getFile() {
        return this.file;
    }

    public final long getId() {
        return this.id;
    }

    public final String getSize() {
        return this.aKj;
    }

    public final String QJ() {
        return this.aKk;
    }
}
