package com.iqoption.core.util.a;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, aXE = {"addLinkSpan", "", "builder", "Landroid/text/SpannableStringBuilder;", "listener", "Lcom/iqoption/core/util/link/LinkClickListener;", "link", "Lcom/iqoption/core/util/link/Link;", "linkNormalColor", "", "linkPressedColor", "underline", "", "setTextWithLinks", "params", "Lcom/iqoption/core/util/link/LinkifyParams;", "core_release"})
/* compiled from: LinkUtils.kt */
public final class d {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/core/util/link/LinkUtilsKt$addLinkSpan$clickableSpan$1", "Lcom/iqoption/core/util/link/TouchableSpan;", "onClick", "", "textView", "Landroid/view/View;", "core_release"})
    /* compiled from: LinkUtils.kt */
    public static final class a extends g {
        final /* synthetic */ b bhl;
        final /* synthetic */ a bhm;
        final /* synthetic */ int bhn;
        final /* synthetic */ int bho;

        a(b bVar, a aVar, int i, int i2, int i3, int i4) {
            this.bhl = bVar;
            this.bhm = aVar;
            this.bhn = i;
            this.bho = i2;
            super(i3, i4);
        }

        public void onClick(View view) {
            h.e(view, "textView");
            this.bhl.a(this.bhm);
        }
    }

    public static final void a(e eVar) {
        h.e(eVar, "params");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(eVar.getText());
        Context context = eVar.aah().getContext();
        for (a a : eVar.aag()) {
            a(spannableStringBuilder, eVar.aal(), a, ContextCompat.getColor(context, eVar.aai()), ContextCompat.getColor(context, eVar.aaj()), eVar.aak());
        }
        TextView aah = eVar.aah();
        aah.setText(spannableStringBuilder);
        aah.setMovementMethod(new c());
        aah.setHighlightColor(0);
    }

    private static final void a(SpannableStringBuilder spannableStringBuilder, b bVar, a aVar, @ColorInt int i, @ColorInt int i2, boolean z) {
        a aVar2 = new a(bVar, aVar, i, i2, i, i2);
        CharSequence text = aVar.getText();
        int a = v.a((CharSequence) spannableStringBuilder, text.toString(), 0, false, 6, null);
        if (a != -1) {
            int length = text.length() + a;
            spannableStringBuilder.setSpan(aVar2, a, length, 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), a, length, 33);
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), a, length, 33);
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("link text not found. ");
        stringBuilder.append(text);
        com.iqoption.core.i.e("LinkUtils", stringBuilder.toString());
    }
}
