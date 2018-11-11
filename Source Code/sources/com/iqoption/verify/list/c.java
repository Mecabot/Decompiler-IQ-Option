package com.iqoption.verify.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.d.ala;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.mobbtech.connect.response.r;
import com.iqoption.x.R;
import io.card.payment.CardType;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/VerifyCardItemBinding;", "listener", "Lcom/iqoption/verify/list/VerifyCardListener;", "(Lcom/iqoption/databinding/VerifyCardItemBinding;Lcom/iqoption/verify/list/VerifyCardListener;)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "getBinding", "()Lcom/iqoption/databinding/VerifyCardItemBinding;", "defaultColor", "", "selectedColor", "animateItem", "view", "Landroid/view/View;", "animateSelection", "", "bind", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getSelectableBackgroundId", "setCardNumber", "setIcon", "setStatusIcon", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCardHolders.kt */
public final class c extends ViewHolder {
    private final int aup = ContextCompat.getColor(alR(), R.color.bg_second_level);
    private ValueAnimator awh;
    private final int dxD = ContextCompat.getColor(alR(), R.color.slate_grey_60);
    private final ala dxE;
    private final b dxF;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/iqoption/verify/list/VerifyCardViewHolder$animateItem$1$1"})
    /* compiled from: VerifyCardHolders.kt */
    static final class a implements AnimatorUpdateListener {
        final /* synthetic */ View bbd;
        final /* synthetic */ c dxG;

        a(c cVar, View view) {
            this.dxG = cVar;
            this.bbd = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.bbd;
            h.d(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            view.setBackgroundColor(((Integer) animatedValue).intValue());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/verify/list/VerifyCardViewHolder$animateItem$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCardHolders.kt */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ View bbd;
        final /* synthetic */ c dxG;

        b(c cVar, View view) {
            this.dxG = cVar;
            this.bbd = view;
        }

        public void onAnimationEnd(Animator animator) {
            View view = this.bbd;
            c cVar = this.dxG;
            Context c = this.dxG.alR();
            h.d(c, "context()");
            view.setBackgroundResource(cVar.bV(c));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyCardHolders.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ c dxG;
        final /* synthetic */ q dxH;
        final /* synthetic */ View dxI;

        c(c cVar, q qVar, View view) {
            this.dxG = cVar;
            this.dxH = qVar;
            this.dxI = view;
        }

        public final void onClick(View view) {
            this.dxG.dxF.f(this.dxH);
            this.dxI.setBackgroundColor(this.dxG.dxD);
        }
    }

    public c(ala ala, b bVar) {
        h.e(ala, "binding");
        h.e(bVar, "listener");
        super(ala.getRoot());
        this.dxE = ala;
        this.dxF = bVar;
    }

    public final void g(q qVar) {
        h.e(qVar, "card");
        i(qVar);
        h(qVar);
        e(qVar.auX());
        View root = this.dxE.getRoot();
        root.setOnClickListener(new c(this, qVar, root));
    }

    public final void aGS() {
        ValueAnimator valueAnimator = this.awh;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            View root = this.dxE.getRoot();
            h.d(root, "binding.root");
            this.awh = bW(root);
        }
    }

    private final void h(q qVar) {
        String number = qVar.getNumber();
        int length = number.length() - 4;
        if (number == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        number = number.substring(length);
        h.d(number, "(this as java.lang.String).substring(startIndex)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("•••• ");
        stringBuilder.append(number);
        number = stringBuilder.toString();
        TextView textView = this.dxE.bFt;
        h.d(textView, "binding.verifyCardNumber");
        textView.setText(number);
    }

    private final void i(q qVar) {
        int i;
        CardType gV = com.iqoption.core.util.a.gV(qVar.getNumber());
        ImageView imageView = this.dxE.bTT;
        h.d(imageView, "iconView");
        Context context = imageView.getContext();
        if (gV != null) {
            switch (gV) {
                case VISA:
                    i = R.drawable.ic_visa;
                    break;
                case MASTERCARD:
                    i = R.drawable.ic_mc;
                    break;
            }
        }
        i = R.drawable.ic_payment_method_placeholder;
        imageView.setImageDrawable(ContextCompat.getDrawable(context, i));
    }

    private final void e(CardStatus cardStatus) {
        Integer valueOf;
        if (r.auZ().contains(cardStatus)) {
            valueOf = Integer.valueOf(R.drawable.ic_progress);
        } else if (cardStatus == CardStatus.VERIFIED) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(R.drawable.ic_attention);
        }
        ImageView imageView = this.dxE.bFv;
        if (valueOf != null) {
            h.d(imageView, "imageView");
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), valueOf.intValue()));
            com.iqoption.core.ext.a.L(imageView);
            return;
        }
        h.d(imageView, "imageView");
        com.iqoption.core.ext.a.M(imageView);
    }

    private final Context alR() {
        View root = this.dxE.getRoot();
        h.d(root, "binding.root");
        return root.getContext();
    }

    private final ValueAnimator bW(View view) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(this.dxD), Integer.valueOf(this.aup)});
        ofObject.addUpdateListener(new a(this, view));
        ofObject.addListener(new b(this, view));
        ofObject.setDuration(300);
        ofObject.start();
        h.d(ofObject, "ValueAnimator.ofObject(a…        start()\n        }");
        return ofObject;
    }

    private final int bV(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843534, typedValue, true);
        return typedValue.resourceId;
    }
}
