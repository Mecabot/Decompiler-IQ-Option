package com.iqoption.chat.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.iqoption.chat.fragment.o.b;
import com.iqoption.core.ext.a;
import com.iqoption.x.R;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.a.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, aXE = {"openMessageOptions", "", "T", "arg", "options", "", "Lkotlin/Pair;", "", "interactor", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;", "invoke", "(Ljava/lang/Object;Ljava/util/List;Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;)V", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$1"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$3 extends Lambda implements q<T, List<? extends Pair<? extends String, ? extends String>>, b<? super T>, l> {
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$3(x xVar) {
        this.this$0 = xVar;
        super(3);
    }

    public /* synthetic */ Object c(Object obj, Object obj2, Object obj3) {
        b(obj, (List) obj2, (b) obj3);
        return l.etX;
    }

    public final <T> void b(T t, List<Pair<String, String>> list, b<? super T> bVar) {
        h.e(list, "options");
        h.e(bVar, "interactor");
        FragmentManager p = a.p(this.this$0);
        FragmentTransaction beginTransaction = p.beginTransaction();
        h.d(beginTransaction, "ft");
        o a = o.aHg.a(t, list, bVar);
        String Ll = o.aHg.Ll();
        beginTransaction.add(R.id.dialogLayer, a, Ll);
        beginTransaction.addToBackStack(Ll);
        beginTransaction.commitAllowingStateLoss();
        p.executePendingTransactions();
    }
}
