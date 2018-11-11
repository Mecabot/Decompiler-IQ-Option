package com.iqoption.chat.viewmodel;

import java.io.File;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, aXE = {"Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "value", "", "isSelected", "()Z", "setSelected", "(Z)V", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AttachmentPickerViewModel.kt */
public final class a {
    private final File file;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.file, ((com.iqoption.chat.viewmodel.a) r2).file) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.chat.viewmodel.a;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.chat.viewmodel.a) r2;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.viewmodel.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        File file = this.file;
        return file != null ? file.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttachmentPreview(file=");
        stringBuilder.append(this.file);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(File file) {
        h.e(file, "file");
        this.file = file;
    }

    public final File getFile() {
        return this.file;
    }

    public final boolean isSelected() {
        return g.aLK.s(this.file);
    }

    public final void setSelected(boolean z) {
        g.aLK.a(this.file, z);
    }
}
