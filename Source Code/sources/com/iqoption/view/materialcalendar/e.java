package com.iqoption.view.materialcalendar;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.iqoption.view.materialcalendar.a.h;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: CalendarPagerView */
abstract class e extends ViewGroup implements OnClickListener {
    private static final Calendar dGP = f.getInstance();
    protected int dGF = 4;
    private b dGG = null;
    private b dGH = null;
    private final ArrayList<s> dGQ = new ArrayList();
    private final ArrayList<k> dGR = new ArrayList();
    private b dGS;
    private final Collection<h> dGT = new ArrayList();
    private MaterialCalendarView dGz;
    private int firstDayOfWeek;

    /* compiled from: CalendarPagerView */
    protected static class a extends MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    protected abstract void b(Collection<h> collection, Calendar calendar);

    protected abstract boolean d(b bVar);

    protected abstract int getRows();

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public e(@NonNull MaterialCalendarView materialCalendarView, b bVar, int i) {
        super(materialCalendarView.getContext());
        this.dGz = materialCalendarView;
        this.dGS = bVar;
        this.firstDayOfWeek = i;
        setClipChildren(false);
        setClipToPadding(false);
        d(aJj());
        b(this.dGT, aJj());
    }

    private void d(Calendar calendar) {
        for (int i = 0; i < 7; i++) {
            View sVar = new s(getContext(), f.h(calendar));
            this.dGQ.add(sVar);
            addView(sVar);
            calendar.add(5, 1);
        }
    }

    protected void a(Collection<h> collection, Calendar calendar) {
        View hVar = new h(getContext(), b.b(calendar));
        hVar.setOnClickListener(this);
        collection.add(hVar);
        addView(hVar, new a());
        calendar.add(5, 1);
    }

    @SuppressLint({"WrongConstant"})
    protected Calendar aJj() {
        getFirstViewDay().c(dGP);
        dGP.setFirstDayOfWeek(getFirstDayOfWeek());
        int firstDayOfWeek = getFirstDayOfWeek() - f.h(dGP);
        Object obj = null;
        if (MaterialCalendarView.hh(this.dGF) ? firstDayOfWeek < 0 : firstDayOfWeek <= 0) {
            obj = 1;
        }
        if (obj != null) {
            firstDayOfWeek -= 7;
        }
        dGP.add(5, firstDayOfWeek);
        return dGP;
    }

    protected int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    void setDayViewDecorators(List<k> list) {
        this.dGR.clear();
        if (list != null) {
            this.dGR.addAll(list);
        }
        aJe();
    }

    public void setWeekDayTextAppearance(int i) {
        Iterator it = this.dGQ.iterator();
        while (it.hasNext()) {
            ((s) it.next()).setTextAppearance(getContext(), i);
        }
    }

    public void setDateTextAppearance(int i) {
        for (h textAppearance : this.dGT) {
            textAppearance.setTextAppearance(getContext(), i);
        }
    }

    public void setShowOtherDates(int i) {
        this.dGF = i;
        aJk();
    }

    public void setSelectionEnabled(boolean z) {
        for (h hVar : this.dGT) {
            hVar.setOnClickListener(z ? this : null);
            hVar.setClickable(z);
        }
    }

    public void setSelectionColor(int i) {
        for (h selectionColor : this.dGT) {
            selectionColor.setSelectionColor(i);
        }
    }

    public void setWeekDayFormatter(h hVar) {
        Iterator it = this.dGQ.iterator();
        while (it.hasNext()) {
            ((s) it.next()).setWeekDayFormatter(hVar);
        }
    }

    public void setDayFormatter(com.iqoption.view.materialcalendar.a.e eVar) {
        for (h dayFormatter : this.dGT) {
            dayFormatter.setDayFormatter(eVar);
        }
    }

    public void setMinimumDate(b bVar) {
        this.dGG = bVar;
        aJk();
    }

    public void setMaximumDate(b bVar) {
        this.dGH = bVar;
        aJk();
    }

    public void setSelectedDates(Collection<b> collection) {
        for (h hVar : this.dGT) {
            boolean z = collection != null && collection.contains(hVar.aJm());
            hVar.setChecked(z);
        }
        postInvalidate();
    }

    protected void aJk() {
        for (h hVar : this.dGT) {
            b aJm = hVar.aJm();
            hVar.b(this.dGF, aJm.c(this.dGG, this.dGH), d(aJm));
        }
        postInvalidate();
    }

    protected void aJe() {
        j jVar = new j();
        for (h hVar : this.dGT) {
            jVar.reset();
            Iterator it = this.dGR.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar.dHk.g(hVar.aJm())) {
                    kVar.dHl.c(jVar);
                }
            }
            hVar.a(jVar);
        }
    }

    public void onClick(View view) {
        if (view instanceof h) {
            this.dGz.a((h) view);
        }
    }

    /* renamed from: aJl */
    protected a generateDefaultLayoutParams() {
        return new a();
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        i = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        if (MeasureSpec.getMode(i2) == 0 || i == 0) {
            throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
        }
        i = size / 7;
        i2 = size2 / getRows();
        setMeasuredDimension(size, size2);
        size = getChildCount();
        for (size2 = 0; size2 < size; size2++) {
            getChildAt(size2).measure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        i3 = 0;
        i4 = 0;
        for (i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int measuredWidth = childAt.getMeasuredWidth() + i3;
            int measuredHeight = childAt.getMeasuredHeight() + i4;
            childAt.layout(i3, i4, measuredWidth, measuredHeight);
            if (i2 % 7 == 6) {
                i4 = measuredHeight;
                i3 = 0;
            } else {
                i3 = measuredWidth;
            }
        }
    }

    /* renamed from: e */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new a();
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(e.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(e.class.getName());
    }

    protected b getFirstViewDay() {
        return this.dGS;
    }
}
