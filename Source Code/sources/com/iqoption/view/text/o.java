package com.iqoption.view.text;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH\u0002\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, aXE = {"addLinkSpan", "", "builder", "Landroid/text/SpannableStringBuilder;", "listener", "Lcom/iqoption/view/text/LinkClickListener;", "link", "Lcom/iqoption/view/text/Link;", "linkNormalColor", "", "linkPressedColor", "setTextWithLinks", "params", "Lcom/iqoption/view/text/LinkifyParams;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LinkUtils.kt */
public final class o {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/view/text/LinkUtilsKt$addLinkSpan$clickableSpan$1", "Lcom/iqoption/view/text/TouchableSpan;", "onClick", "", "textView", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LinkUtils.kt */
    public static final class a extends y {
        final /* synthetic */ int bhn;
        final /* synthetic */ int bho;
        final /* synthetic */ m dJs;
        final /* synthetic */ l dJt;

        a(m mVar, l lVar, int i, int i2, int i3, int i4) {
            this.dJs = mVar;
            this.dJt = lVar;
            this.bhn = i;
            this.bho = i2;
            super(i3, i4);
        }

        public void onClick(View view) {
            h.e(view, "textView");
            this.dJs.b(this.dJt);
        }
    }

    public static final void a(p pVar) {
        h.e(pVar, "params");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(pVar.getText());
        Context context = pVar.aah().getContext();
        for (l a : pVar.aJL()) {
            a(spannableStringBuilder, pVar.aJM(), a, ContextCompat.getColor(context, pVar.aai()), ContextCompat.getColor(context, pVar.aaj()));
        }
        TextView aah = pVar.aah();
        aah.setText(spannableStringBuilder);
        aah.setMovementMethod(new n());
        aah.setHighlightColor(0);
    }

    private static final void a(SpannableStringBuilder spannableStringBuilder, m mVar, l lVar, @ColorInt int i, @ColorInt int i2) {
        a aVar = new a(mVar, lVar, i, i2, i, i2);
        CharSequence text = lVar.getText();
        int a = v.a((CharSequence) spannableStringBuilder, text.toString(), 0, false, 6, null);
        int length = text.length() + a;
        spannableStringBuilder.setSpan(aVar, a, length, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), a, length, 33);
    }
}
