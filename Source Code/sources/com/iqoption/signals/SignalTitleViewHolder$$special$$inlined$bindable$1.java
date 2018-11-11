package com.iqoption.signals;

import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.d.ajk;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class SignalTitleViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<f, l> {
    final /* synthetic */ Object $context;

    public SignalTitleViewHolder$$special$$inlined$bindable$1(Object obj) {
        this.$context = obj;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(f fVar) {
        fVar = fVar;
        TextView textView = ((ajk) this.$context).agA;
        h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView.setText(fVar.getTitle());
    }
}
