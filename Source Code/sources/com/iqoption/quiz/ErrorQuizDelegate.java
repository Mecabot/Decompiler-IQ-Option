package com.iqoption.quiz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.core.ext.a;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.qp;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 H\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#H\u0001J\u0011\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, aXE = {"Lcom/iqoption/quiz/ErrorQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "binding", "Lcom/iqoption/databinding/FragmentQuizErrorDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizErrorDelegateBinding;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "toPixels", "dp", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ErrorQuizDelegate.kt */
public final class ErrorQuizDelegate extends QuizDelegate implements k {
    private final qp des;
    private final /* synthetic */ l det;
    private final View view;

    public CharSequence dA(int i) {
        return this.det.dA(i);
    }

    public ColorStateList dx(int i) {
        return this.det.dx(i);
    }

    public float dy(int i) {
        return this.det.dy(i);
    }

    public int dz(int i) {
        return this.det.dz(i);
    }

    public int getColor(int i) {
        return this.det.getColor(i);
    }

    public Drawable getDrawable(int i) {
        return this.det.getDrawable(i);
    }

    public Typeface getFont(int i) {
        return this.det.getFont(i);
    }

    public ErrorQuizDelegate(QuizFragment quizFragment, ViewGroup viewGroup) {
        h.e(quizFragment, "f");
        h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        h.d(from, "LayoutInflater.from(root.context)");
        this.des = (qp) a.a(from, (int) R.layout.fragment_quiz_error_delegate, viewGroup, false, 4, null);
        View root = this.des.getRoot();
        h.d(root, "binding.root");
        this.view = root;
    }

    public View getView() {
        return this.view;
    }
}
