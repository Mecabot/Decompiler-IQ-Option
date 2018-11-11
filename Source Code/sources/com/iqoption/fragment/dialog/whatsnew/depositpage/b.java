package com.iqoption.fragment.dialog.whatsnew.depositpage;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.d.aly;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/fragment/dialog/whatsnew/depositpage/WhatsNewDepositHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "callback", "Lcom/iqoption/fragment/dialog/whatsnew/depositpage/WhatsNewDepositHolder$Callback;", "binding", "Lcom/iqoption/databinding/WhatsNewDepositItemBinding;", "(Lcom/iqoption/fragment/dialog/whatsnew/depositpage/WhatsNewDepositHolder$Callback;Lcom/iqoption/databinding/WhatsNewDepositItemBinding;)V", "<set-?>", "Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "bound", "getBound", "()Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "setBound", "(Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WhatsNewDepositHolder.kt */
public final class b extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "bound", "getBound()Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;"))};
    private final d bXV;
    private final b cCb;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/fragment/dialog/whatsnew/depositpage/WhatsNewDepositHolder$Callback;", "", "onItemClick", "", "item", "Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WhatsNewDepositHolder.kt */
    public interface b {
        void f(BankItem bankItem);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ b this$0;

        public a(b bVar) {
            this.this$0 = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.this$0.cCb.f(this.this$0.alB());
        }
    }

    public final BankItem alB() {
        return (BankItem) this.bXV.b(this, apP[0]);
    }

    public final void e(BankItem bankItem) {
        h.e(bankItem, "<set-?>");
        this.bXV.a(this, apP[0], bankItem);
    }

    public b(b bVar, aly aly) {
        h.e(bVar, "callback");
        h.e(aly, "binding");
        super(aly.getRoot());
        this.cCb = bVar;
        LinearLayout linearLayout = aly.bUx;
        h.d(linearLayout, "binding.container");
        linearLayout.setOnClickListener(new a(this));
        this.bXV = c.h(new WhatsNewDepositHolder$$special$$inlined$bindable$1(aly, this, aly));
    }
}
