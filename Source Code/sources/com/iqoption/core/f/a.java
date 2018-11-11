package com.iqoption.core.f;

import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/manager/LogoutClearList;", "", "()V", "items", "", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "add", "", "item", "clear", "remove", "Clearable", "core_release"})
/* compiled from: LogoutClearList.kt */
public final class a {
    public static final a aSi = new a();
    private static final List<a> nj = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "", "clearOnLogout", "", "core_release"})
    /* compiled from: LogoutClearList.kt */
    public interface a {
        void Js();
    }

    private a() {
    }

    public static final void a(a aVar) {
        h.e(aVar, "item");
        nj.add(aVar);
    }

    public static final void clear() {
        for (a Js : nj) {
            Js.Js();
        }
    }
}
