package com.iqoption.core.ui.viewmodel.composite;

import android.util.SparseArray;
import com.iqoption.core.ui.viewmodel.InstanceStateViewModel;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0011*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/composite/IntMapInstanceStateViewModel;", "T", "Lcom/iqoption/core/ui/viewmodel/InstanceStateViewModel;", "()V", "viewModels", "Landroid/util/SparseArray;", "createViewModel", "key", "", "(I)Lcom/iqoption/core/ui/viewmodel/InstanceStateViewModel;", "get", "onCleared", "", "restore", "state", "Landroid/os/Bundle;", "save", "Companion", "core_release"})
/* compiled from: IntMapInstanceStateViewModel.kt */
public abstract class IntMapInstanceStateViewModel<T extends InstanceStateViewModel> extends InstanceStateViewModel {
    public static final a bcq = new a();
    private final SparseArray<T> bcp = new SparseArray();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/composite/IntMapInstanceStateViewModel$Companion;", "", "()V", "KEY", "", "SIZE", "STATE", "core_release"})
    /* compiled from: IntMapInstanceStateViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }
}
