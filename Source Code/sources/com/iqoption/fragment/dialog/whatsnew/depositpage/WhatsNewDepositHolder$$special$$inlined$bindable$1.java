package com.iqoption.fragment.dialog.whatsnew.depositpage;

import android.view.View;
import com.iqoption.d.aly;
import com.iqoption.view.RobotoTextView;
import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class WhatsNewDepositHolder$$special$$inlined$bindable$1 extends Lambda implements b<BankItem, l> {
    final /* synthetic */ aly $binding$inlined;
    final /* synthetic */ Object $context;
    final /* synthetic */ b this$0;

    public WhatsNewDepositHolder$$special$$inlined$bindable$1(Object obj, b bVar, aly aly) {
        this.$context = obj;
        this.this$0 = bVar;
        this.$binding$inlined = aly;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(BankItem bankItem) {
        bankItem = bankItem;
        aly aly = (aly) this.$context;
        RobotoTextView robotoTextView = this.$binding$inlined.brQ;
        h.d(robotoTextView, "binding.title");
        robotoTextView.setText(bankItem.getTitle());
        View view = this.this$0.itemView;
        h.d(view, "itemView");
        Picasso.with(view.getContext()).load(bankItem.getUrl()).into(this.$binding$inlined.bmu);
    }
}
