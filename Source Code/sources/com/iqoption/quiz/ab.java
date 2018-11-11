package com.iqoption.quiz;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/quiz/QuizSplashPagerAdapter;", "Landroid/support/v4/view/PagerAdapter;", "quizDelegates", "", "Lcom/iqoption/quiz/QuizDelegate;", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizSplashPagerAdapter.kt */
public final class ab extends PagerAdapter {
    private final List<QuizDelegate> dgT;

    public ab(List<? extends QuizDelegate> list) {
        h.e(list, "quizDelegates");
        this.dgT = list;
    }

    public boolean isViewFromObject(View view, Object obj) {
        h.e(view, Promotion.ACTION_VIEW);
        h.e(obj, "object");
        if (obj instanceof QuizDelegate) {
            return h.E(view, ((QuizDelegate) obj).getView());
        }
        return h.E(view, obj);
    }

    public int getCount() {
        return this.dgT.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "container");
        Object obj = this.dgT.get(i);
        viewGroup.addView(((QuizDelegate) obj).getView());
        return obj;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        h.e(viewGroup, "container");
        h.e(obj, "object");
        View view = null;
        if (!(obj instanceof QuizDelegate)) {
            obj = null;
        }
        QuizDelegate quizDelegate = (QuizDelegate) obj;
        if (quizDelegate != null) {
            view = quizDelegate.getView();
        }
        viewGroup.removeView(view);
    }

    public int getItemPosition(Object obj) {
        h.e(obj, "object");
        return u.i(this.dgT, obj);
    }
}
