package com.iqoption.core.data.a;

import java.io.Reader;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/data/filestore/FileStore;", "", "clear", "", "getKeys", "", "", "getReader", "Ljava/io/Reader;", "key", "getText", "remove", "save", "reader", "contents", "core_release"})
/* compiled from: FileStore.kt */
public interface a {
    void aa(String str, String str2);

    void clear();

    List<String> getKeys();

    String getText(String str);

    Reader gi(String str);

    void remove(String str);
}
