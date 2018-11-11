package com.iqoption.core.ui.viewmodel.composite;

import android.arch.lifecycle.ViewModel;
import android.util.SparseArray;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/composite/IntMapViewModel;", "T", "Landroid/arch/lifecycle/ViewModel;", "()V", "viewModels", "Landroid/util/SparseArray;", "create", "()Landroid/arch/lifecycle/ViewModel;", "get", "key", "", "(I)Landroid/arch/lifecycle/ViewModel;", "core_release"})
/* compiled from: IntMapViewModel.kt */
public abstract class IntMapViewModel<T extends ViewModel> extends ViewModel {
    private final SparseArray<T> bcp = new SparseArray();
}
