package com.iqoption.deposit.menu.method;

import android.os.Parcelable;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\bR\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/menu/method/BaseMethodAdapterItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "Landroid/os/Parcelable;", "viewType", "", "getViewType", "()I", "Companion", "deposit_release"})
/* compiled from: BaseMethodAdapterItem.kt */
public interface a extends Parcelable, d<String> {
    public static final a cbs = a.cbt;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/deposit/menu/method/BaseMethodAdapterItem$Companion;", "", "()V", "TYPE_METHOD", "", "TYPE_TITLE", "deposit_release"})
    /* compiled from: BaseMethodAdapterItem.kt */
    public static final class a {
        static final /* synthetic */ a cbt = new a();

        private a() {
        }
    }

    int getViewType();
}
