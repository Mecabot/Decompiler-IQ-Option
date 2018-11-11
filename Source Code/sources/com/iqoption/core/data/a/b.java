package com.iqoption.core.data.a;

import com.iqoption.core.f;
import java.io.File;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, aXE = {"newFolderFileStore", "Lcom/iqoption/core/data/filestore/FileStore;", "name", "", "core_release"})
/* compiled from: FileStore.kt */
public final class b {
    public static final a gj(String str) {
        h.e(str, "name");
        return new c(new File(f.RR().getFilesDir(), str));
    }
}
