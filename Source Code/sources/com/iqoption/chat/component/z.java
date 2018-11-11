package com.iqoption.chat.component;

import com.iqoption.a.t;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, aXE = {"Lcom/iqoption/chat/component/MessageIdSupplier;", "", "()V", "get", "", "item", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageIdSupplier.kt */
public final class z {
    public static final a aDA = new a();
    private static final t aDz = new t();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/chat/component/MessageIdSupplier$Companion;", "", "()V", "STABLE_ID_STORE", "Lcom/iqoption/adapter/StableIdStore;", "getSTABLE_ID_STORE$IqOption_5_5_1_optionXRelease", "()Lcom/iqoption/adapter/StableIdStore;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageIdSupplier.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final long a(y yVar) {
        String str;
        h.e(yVar, "item");
        t tVar = aDz;
        StringBuilder stringBuilder;
        if (yVar instanceof e) {
            str = "empty";
        } else if (yVar instanceof w) {
            str = "loading";
        } else if (yVar instanceof u) {
            str = "loadMore";
        } else if (yVar instanceof aa) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("msg:");
            stringBuilder.append(((aa) yVar).Ox().getId());
            str = stringBuilder.toString();
        } else if (yVar instanceof a) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("msg:");
            a aVar = (a) yVar;
            stringBuilder.append(aVar.Ox().getId());
            stringBuilder.append("|att:");
            stringBuilder.append(aVar.Oy().getId());
            str = stringBuilder.toString();
        } else if (yVar instanceof am) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("suggestion:");
            stringBuilder.append(((am) yVar).Pr().getId());
            str = stringBuilder.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return tVar.dU(str);
    }
}
