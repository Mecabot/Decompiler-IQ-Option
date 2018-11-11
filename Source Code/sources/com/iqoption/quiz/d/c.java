package com.iqoption.quiz.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.ui.picasso.a;
import com.iqoption.quiz.ae;
import com.iqoption.quiz.b.y;
import com.iqoption.quiz.m;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, aXE = {"Lcom/iqoption/quiz/winners/WinnerViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/quiz/databinding/WinnerItemBinding;", "(Lcom/iqoption/quiz/databinding/WinnerItemBinding;)V", "avatarTransformation", "Lcom/iqoption/core/ui/picasso/CircleTransformation;", "value", "Lcom/iqoption/quiz/winners/WinnerInfo;", "bound", "getBound", "()Lcom/iqoption/quiz/winners/WinnerInfo;", "setBound", "(Lcom/iqoption/quiz/winners/WinnerInfo;)V", "", "pos", "getPos", "()I", "setPos", "(I)V", "bindAvatar", "", "avatar", "Landroid/widget/ImageView;", "winnerInfo", "quiz_release"})
/* compiled from: WinnerViewHolder.kt */
public final class c extends ViewHolder {
    private final a aDH = new a();
    private b dpj = b.dpi.aDj();
    private final y dpk;
    private int pos = -1;

    public c(y yVar) {
        h.e(yVar, "binding");
        super(yVar.getRoot());
        this.dpk = yVar;
    }

    public final void gv(int i) {
        this.pos = i;
        LinearLayout linearLayout = this.dpk.bUx;
        h.d(linearLayout, "container");
        linearLayout.setGravity((i % 2 == 0 ? 48 : 80) | 1);
    }

    public final void a(b bVar) {
        h.e(bVar, b.VALUE);
        this.dpj = bVar;
        y yVar = this.dpk;
        ImageView imageView = yVar.bmj;
        h.d(imageView, "avatar");
        a(imageView, bVar);
        TextView textView = yVar.aig;
        h.d(textView, "name");
        textView.setText(bVar.getName());
        if ((((CharSequence) bVar.getSurname()).length() == 0 ? 1 : null) != null) {
            textView = yVar.dle;
            h.d(textView, "surname");
            textView.setVisibility(8);
        } else {
            textView = yVar.dle;
            h.d(textView, "surname");
            textView.setVisibility(0);
            textView = yVar.dle;
            h.d(textView, "surname");
            textView.setText(bVar.getSurname());
        }
        TextView textView2 = yVar.btG;
        h.d(textView2, "amount");
        textView2.setText(bVar.Sz());
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
}
