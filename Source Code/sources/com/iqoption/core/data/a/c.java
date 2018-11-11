package com.iqoption.core.data.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.text.d;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/data/filestore/FolderFileStore;", "Lcom/iqoption/core/data/filestore/FileStore;", "folder", "Ljava/io/File;", "(Ljava/io/File;)V", "clear", "", "file", "key", "", "getKeys", "", "getReader", "Ljava/io/Reader;", "getText", "remove", "save", "reader", "contents", "Companion", "core_release"})
/* compiled from: FolderFileStore.kt */
public final class c implements a {
    private static final String TAG = "c";
    @Deprecated
    public static final a aOo = new a();
    private final File folder;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/data/filestore/FolderFileStore$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "core_release"})
    /* compiled from: FolderFileStore.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(File file) {
        h.e(file, "folder");
        this.folder = file;
        if (!this.folder.exists() && !this.folder.mkdirs()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create directory: ");
            stringBuilder.append(this.folder);
            throw new FileNotFoundException(stringBuilder.toString());
        }
    }

    private final File gk(String str) {
        return new File(this.folder, str);
    }

    public List<String> getKeys() {
        Object listFiles = this.folder.listFiles();
        h.d(listFiles, "folder.listFiles()");
        Collection arrayList = new ArrayList(listFiles.length);
        for (File file : listFiles) {
            h.d(file, "it");
            arrayList.add(file.getName());
        }
        return (List) arrayList;
    }

    public String getText(String str) {
        h.e(str, "key");
        try {
            File gk = gk(str);
            if (!gk.exists()) {
                gk = null;
            }
            return gk != null ? e.a(gk, null, 1, null) : null;
        } catch (IOException e) {
            com.iqoption.core.i.d(TAG, "Could not get text", e);
            return null;
        }
    }

    public Reader gi(String str) {
        h.e(str, "key");
        InputStreamReader inputStreamReader = null;
        try {
            File gk = gk(str);
            if (!gk.exists()) {
                gk = null;
            }
            if (gk != null) {
                inputStreamReader = new InputStreamReader(new FileInputStream(gk), d.UTF_8);
            }
        } catch (IOException e) {
            com.iqoption.core.i.d(TAG, "Could not get reader", e);
        }
        return inputStreamReader;
    }

    public void aa(String str, String str2) {
        h.e(str, "key");
        h.e(str2, "contents");
        try {
            e.a(gk(str), str2, null, 2, null);
        } catch (IOException e) {
            com.iqoption.core.i.d(TAG, "Could not write text", e);
        }
    }

    public void remove(String str) {
        h.e(str, "key");
        gk(str).delete();
    }

    public void clear() {
        Object listFiles = this.folder.listFiles();
        h.d(listFiles, "folder.listFiles()");
        for (File delete : listFiles) {
            delete.delete();
        }
    }
}
