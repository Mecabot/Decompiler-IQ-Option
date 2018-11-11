package com.iqoption.chat.fragment;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.chat.component.ac;
import com.iqoption.core.k;
import com.iqoption.core.microservices.b.a.a;
import com.iqoption.microservice.chat.g;
import com.iqoption.x.R;
import kotlin.f.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0011\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0001J\u0011\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\fH\u0001J\u0011\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\fH\u0001J\u0011\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020\fH\u0001J(\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016J\u0011\u00100\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\fH\u0001J\u0011\u00101\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0001J\u0011\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\fH\u0001J*\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\f2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020605\"\u000206H\u0001¢\u0006\u0002\u00107J\t\u00108\u001a\u000209H\u0001J\"\u0010:\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0011\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011H\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, aXE = {"Lcom/iqoption/chat/fragment/MessageDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Lcom/iqoption/core/Resourcer;", "resourcer", "dateComparator", "Lcom/iqoption/chat/fragment/DateComparator;", "adapter", "Lcom/iqoption/chat/component/MessagesAdapter;", "dateBadge", "Lcom/iqoption/chat/fragment/BadgeView;", "(Lcom/iqoption/core/Resourcer;Lcom/iqoption/chat/fragment/DateComparator;Lcom/iqoption/chat/component/MessagesAdapter;Lcom/iqoption/chat/fragment/BadgeView;)V", "dateBadgeOffset", "", "dateBadgeTopOffset", "dateDrawable", "Lcom/iqoption/chat/fragment/DateDrawable;", "dateOffsetBottom", "", "dateOffsetTop", "gapMsgBetweenDays", "gapMsgBetweenSenders", "gapMsgOneSender", "gapMsgSuggest", "gapOther", "gapSuggest", "drawDateAbove", "", "c", "Landroid/graphics/Canvas;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "date", "", "getColor", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "getPixels", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "onDrawOver", "toPixels", "dp", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageDecoration.kt */
public final class n extends ItemDecoration implements k {
    private final e aFV;
    private final /* synthetic */ k aFY;
    private final int aGP = dz(R.dimen.dp2);
    private final int aGQ = dz(R.dimen.dp12);
    private final int aGR = dz(R.dimen.dp50);
    private final int aGS = dz(R.dimen.dp12);
    private final int aGT = dz(R.dimen.dp6);
    private final int aGU = dz(R.dimen.dp8);
    private final float aGV = dy(R.dimen.dp8);
    private final float aGW = dy(R.dimen.dp12);
    private final int aGX = dz(R.dimen.dp54);
    private final int aGY = dz(R.dimen.dp46);
    private final f aGZ;
    private final ac aHa;
    private final BadgeView aHb;

    public CharSequence dA(int i) {
        return this.aFY.dA(i);
    }

    public ColorStateList dx(int i) {
        return this.aFY.dx(i);
    }

    public float dy(int i) {
        return this.aFY.dy(i);
    }

    public int dz(int i) {
        return this.aFY.dz(i);
    }

    public int getColor(int i) {
        return this.aFY.getColor(i);
    }

    public Drawable getDrawable(int i) {
        return this.aFY.getDrawable(i);
    }

    public Typeface getFont(int i) {
        return this.aFY.getFont(i);
    }

    public n(k kVar, e eVar, ac acVar, BadgeView badgeView) {
        h.e(kVar, "resourcer");
        h.e(eVar, "dateComparator");
        h.e(acVar, "adapter");
        h.e(badgeView, "dateBadge");
        this.aFY = kVar;
        this.aFV = eVar;
        this.aHa = acVar;
        this.aHb = badgeView;
        this.aGZ = new f(kVar, this.aFV);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        h.e(rect, "outRect");
        h.e(view, Promotion.ACTION_VIEW);
        h.e(recyclerView, "parent");
        h.e(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        g dt = this.aHa.dt(childAdapterPosition);
        if (childAdapterPosition != this.aHa.getItemCount() - 1 || dt == null) {
            if (dt != null) {
                g dt2 = this.aHa.dt(childAdapterPosition + 1);
                if (dt2 != null) {
                    if (dt.aro() == dt2.aro()) {
                        if (this.aFV.l(dt.getDate(), dt2.getDate())) {
                            rect.top = this.aGP;
                        } else {
                            rect.top = this.aGR;
                        }
                    } else if (this.aFV.l(dt.getDate(), dt2.getDate())) {
                        rect.top = this.aGQ;
                    } else {
                        rect.top = this.aGR;
                    }
                }
            } else if (this.aHa.du(childAdapterPosition) != null) {
                childAdapterPosition++;
                dt = this.aHa.dt(childAdapterPosition);
                a du = this.aHa.du(childAdapterPosition);
                if (dt != null) {
                    rect.top = this.aGS;
                } else if (du != null) {
                    rect.top = this.aGT;
                }
            } else {
                rect.top = this.aGU;
                rect.bottom = this.aGU;
            }
            return;
        }
        rect.top = this.aGR;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        RecyclerView recyclerView2 = recyclerView;
        Canvas canvas2 = canvas;
        h.e(canvas2, "c");
        h.e(recyclerView2, "parent");
        if (recyclerView.getChildCount() >= 2) {
            int i;
            this.aGZ.setBounds(0, 0, 0, 0);
            g gVar = (g) null;
            int childCount = recyclerView.getChildCount();
            g gVar2 = gVar;
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                int i4;
                int a = com.iqoption.core.ext.a.a(recyclerView2, i3);
                g dt = this.aHa.dt(a);
                int i5 = a + 1;
                gVar = this.aHa.dt(i5);
                if (dt != null) {
                    View childAt;
                    if (gVar != null) {
                        i = i2;
                        i4 = a;
                        if (!this.aFV.l(dt.getDate(), gVar.getDate())) {
                            childAt = recyclerView2.getChildAt(i3);
                            h.d(childAt, "parent.getChildAt(i)");
                            a(canvas2, childAt, recyclerView2, dt.getDate());
                        }
                    } else {
                        i = i2;
                        i4 = a;
                    }
                    if (i5 == this.aHa.getItemCount()) {
                        childAt = recyclerView2.getChildAt(i3);
                        h.d(childAt, "parent.getChildAt(i)");
                        a(canvas2, childAt, recyclerView2, dt.getDate());
                    }
                } else {
                    i = i2;
                    i4 = a;
                }
                if (dt != null) {
                    gVar2 = dt;
                    i2 = i4;
                } else {
                    i2 = i;
                }
            }
            i = i2;
            if (gVar2 != null) {
                this.aHb.setDate(gVar2.getDate());
            }
            Rect bounds = this.aGZ.getBounds();
            BadgeView badgeView = this.aHb;
            float f = 0.0f;
            if (!bounds.isEmpty()) {
                if (i != this.aHa.getItemCount() - 1) {
                    if (bounds.top < this.aGY) {
                        f = (float) (bounds.top - this.aGY);
                    }
                } else if (bounds.top < this.aGX) {
                    f = (float) (bounds.top - this.aGX);
                }
            }
            badgeView.setTranslationY(f);
        }
    }

    private final void a(Canvas canvas, View view, RecyclerView recyclerView, long j) {
        this.aGZ.setDate(j);
        int intrinsicWidth = this.aGZ.getIntrinsicWidth();
        int intrinsicHeight = this.aGZ.getIntrinsicHeight();
        int ae = c.ae(((float) (recyclerView.getWidth() - this.aGZ.getIntrinsicWidth())) / 2.0f);
        int top = view.getTop();
        intrinsicWidth += ae;
        float intrinsicHeight2 = (float) this.aGZ.getIntrinsicHeight();
        float f = (this.aGV + this.aGW) + intrinsicHeight2;
        if (j.a((c) h.l(this.aGW, f), top)) {
            top = c.ae(this.aGV);
        } else {
            float f2 = (float) top;
            top = f2 > f ? c.ae((this.aGV + f2) - ((this.aGV + this.aGW) + intrinsicHeight2)) : -1;
        }
        if (top != -1) {
            this.aGZ.setBounds(ae, top, intrinsicWidth, intrinsicHeight + top);
            this.aGZ.draw(canvas);
        }
    }
}
