package com.iqoption.view.text;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.widget.TextView;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, aXE = {"Lcom/iqoption/view/text/LinkifyParams;", "", "links", "", "Lcom/iqoption/view/text/Link;", "textView", "Landroid/widget/TextView;", "text", "", "linkNormalResId", "", "linkPressedResId", "listener", "Lcom/iqoption/view/text/LinkClickListener;", "([Lcom/iqoption/view/text/Link;Landroid/widget/TextView;Ljava/lang/CharSequence;IILcom/iqoption/view/text/LinkClickListener;)V", "getLinkNormalResId", "()I", "getLinkPressedResId", "getLinks", "()[Lcom/iqoption/view/text/Link;", "[Lcom/iqoption/view/text/Link;", "getListener", "()Lcom/iqoption/view/text/LinkClickListener;", "getText", "()Ljava/lang/CharSequence;", "getTextView", "()Landroid/widget/TextView;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LinkUtils.kt */
public final class p {
    private final TextView bhq;
    private final int bhr;
    private final int bhs;
    private final l[] dJu;
    private final m dJv;
    private final CharSequence text;

    public p(l[] lVarArr, TextView textView, CharSequence charSequence, @ColorRes int i, @ColorRes int i2, m mVar) {
        h.e(lVarArr, "links");
        h.e(textView, "textView");
        h.e(charSequence, "text");
        h.e(mVar, "listener");
        this.dJu = lVarArr;
        this.bhq = textView;
        this.text = charSequence;
        this.bhr = i;
        this.bhs = i2;
        this.dJv = mVar;
    }

    public final l[] aJL() {
        return this.dJu;
    }

    public final TextView aah() {
        return this.bhq;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final int aai() {
        return this.bhr;
    }

    public final int aaj() {
        return this.bhs;
    }

    public /* synthetic */ p(l[] lVarArr, TextView textView, CharSequence charSequence, int i, int i2, m mVar, int i3, f fVar) {
        int i4 = (i3 & 8) != 0 ? R.color.white : i;
        int i5 = (i3 & 16) != 0 ? R.color.white_60 : i2;
        if ((i3 & 32) != 0) {
            Context context = textView.getContext();
            h.d(context, "textView.context");
            mVar = new s(context);
        }
        this(lVarArr, textView, charSequence, i4, i5, mVar);
    }

    public final m aJM() {
        return this.dJv;
    }
}
