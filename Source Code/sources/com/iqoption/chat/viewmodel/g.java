package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/chat/viewmodel/Selection;", "", "()V", "count", "Landroid/arch/lifecycle/LiveData;", "", "getCount", "()Landroid/arch/lifecycle/LiveData;", "countData", "Landroid/arch/lifecycle/MutableLiveData;", "selection", "", "Ljava/io/File;", "clear", "", "isSelected", "", "f", "setSelected", "selected", "toggle", "updateCountData", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AttachmentPickerViewModel.kt */
final class g {
    private static final MutableLiveData<Integer> aLI;
    private static final Set<File> aLJ = new LinkedHashSet();
    public static final g aLK = new g();

    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Integer.valueOf(0));
        aLI = mutableLiveData;
    }

    private g() {
    }

    public final LiveData<Integer> Rx() {
        return aLI;
    }

    public final boolean s(File file) {
        h.e(file, "f");
        return aLJ.contains(file);
    }

    public final void a(File file, boolean z) {
        h.e(file, "f");
        if (z) {
            aLJ.add(file);
        } else {
            aLJ.remove(file);
        }
        Ry();
    }

    public final void clear() {
        aLJ.clear();
        Ry();
    }

    private final void Ry() {
        aLI.setValue(Integer.valueOf(aLJ.size()));
    }
}
