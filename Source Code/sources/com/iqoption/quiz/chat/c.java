package com.iqoption.quiz.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView.BufferType;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.ui.picasso.a;
import com.iqoption.quiz.ae;
import com.iqoption.quiz.b.q;
import com.iqoption.quiz.m;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0011\u0010$\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003R\u0012\u0010\u0007\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0015X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\n¨\u0006%"}, aXE = {"Lcom/iqoption/quiz/chat/ChatItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/iqoption/quiz/chat/ChatStyles;", "styles", "binding", "Lcom/iqoption/quiz/databinding/QuizChatItemBinding;", "(Lcom/iqoption/quiz/chat/ChatStyles;Lcom/iqoption/quiz/databinding/QuizChatItemBinding;)V", "avatarSize", "", "getAvatarSize", "()I", "avatarTransformation", "Lcom/iqoption/core/ui/picasso/CircleTransformation;", "value", "Lcom/iqoption/quiz/chat/ChatItem;", "bound", "getBound", "()Lcom/iqoption/quiz/chat/ChatItem;", "setBound", "(Lcom/iqoption/quiz/chat/ChatItem;)V", "largeTextSize", "", "getLargeTextSize", "()F", "smallTextSize", "getSmallTextSize", "textColor", "getTextColor", "bindAvatar", "", "avatar", "Landroid/widget/ImageView;", "chatItem", "formatText", "", "item", "invoke", "quiz_release"})
/* compiled from: ChatItemViewHolder.kt */
public final class c extends ViewHolder implements f {
    private final a aDH = new a();
    private b djv;
    private final f djw;
    private final q djx;

    public void a(q qVar) {
        h.e(qVar, "binding");
        this.djw.a(qVar);
    }

    public int ayT() {
        return this.djw.ayT();
    }

    public float ayU() {
        return this.djw.ayU();
    }

    public float ayV() {
        return this.djw.ayV();
    }

    public int getTextColor() {
        return this.djw.getTextColor();
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((q) obj);
        return l.etX;
    }

    public c(f fVar, q qVar) {
        h.e(fVar, "styles");
        h.e(qVar, "binding");
        super(qVar.getRoot());
        this.djw = fVar;
        this.djx = qVar;
        this.djw.a(this.djx);
        this.djv = b.dju.aAY();
    }

    public final void a(b bVar) {
        h.e(bVar, b.VALUE);
        this.djv = bVar;
        q qVar = this.djx;
        ImageView imageView = qVar.bmj;
        h.d(imageView, "avatar");
        a(imageView, bVar);
        qVar.aip.setText(b(bVar), BufferType.SPANNABLE);
        qVar.aip.setTextSize(0, bVar.aAW() ? ayV() : ayU());
    }

    private final void a(ImageView imageView, b bVar) {
        Picasso azl = m.ayY().azl();
        azl.cancelRequest(imageView);
        if (TextUtils.isEmpty(bVar.Wj())) {
            com.iqoption.quiz.widget.a.a aVar = com.iqoption.quiz.widget.a.doT;
            View view = this.itemView;
            h.d(view, "itemView");
            Context context = view.getContext();
            h.d(context, "itemView.context");
            com.iqoption.quiz.widget.b bVar2 = new com.iqoption.quiz.widget.b(context);
            bVar2.setName(bVar.getInitials());
            bVar2.gt(bVar.aAV());
            imageView.setImageDrawable(aVar.a(bVar2));
            return;
        }
        RequestCreator load = azl.load(bVar.Wj());
        Drawable drawable = AppCompatResources.getDrawable(imageView.getContext(), ae.b.ic_quiz_avatar_placeholder);
        if (drawable != null) {
            load.placeholder(drawable);
        }
        load.transform((Transformation) this.aDH).fit().into(imageView);
    }

    private final CharSequence b(b bVar) {
        CharSequence aCT = new com.iqoption.quiz.c.h().bD(new ForegroundColorSpan(getTextColor())).jE(bVar.VP()).aCS().jE(" ").jE(bVar.getMessage()).aCT();
        h.d(aCT, "Spanner()\n              …\n                .build()");
        return aCT;
    }
}
