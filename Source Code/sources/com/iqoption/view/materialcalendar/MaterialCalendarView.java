package com.iqoption.view.materialcalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.iqoption.view.materialcalendar.a.e;
import com.iqoption.view.materialcalendar.a.f;
import com.iqoption.view.materialcalendar.a.g;
import com.iqoption.view.materialcalendar.a.h;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MaterialCalendarView extends ViewGroup {
    private static final g dHm = new com.iqoption.view.materialcalendar.a.d();
    private final TextView agA;
    private final OnClickListener cww;
    private b dGG;
    private b dGH;
    private q dHA;
    CharSequence dHB;
    private int dHC;
    private int dHD;
    private Drawable dHE;
    private Drawable dHF;
    private boolean dHG;
    private c dHH;
    private final r dHn;
    private final l dHo;
    private final l dHp;
    private final c dHq;
    private d<?> dHr;
    private b dHs;
    private LinearLayout dHt;
    private CalendarMode dHu;
    private boolean dHv;
    private final ArrayList<i> dHw;
    private final OnPageChangeListener dHx;
    private o dHy;
    private p dHz;
    private int firstDayOfWeek;
    private int selectionMode;
    private int tileHeight;
    private int tileWidth;

    protected static class a extends MarginLayoutParams {
        public a(int i) {
            super(-1, i);
        }
    }

    public static class b extends BaseSavedState {
        public static final Creator<b> CREATOR = new Creator<b>() {
            /* renamed from: ab */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* renamed from: hk */
            public b[] newArray(int i) {
                return new b[i];
            }
        };
        int color;
        int dGF;
        b dGG;
        b dGH;
        List<b> dGJ;
        boolean dHG;
        int dHK;
        int dHL;
        boolean dHM;
        boolean dHN;
        boolean dHO;
        b dHs;
        CalendarMode dHu;
        int dateTextAppearance;
        int firstDayOfWeek;
        int orientation;
        int selectionMode;
        int weekDayTextAppearance;

        /* synthetic */ b(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        b(Parcelable parcelable) {
            super(parcelable);
            this.color = 0;
            this.dateTextAppearance = 0;
            this.weekDayTextAppearance = 0;
            this.dGF = 4;
            this.dHG = true;
            this.dGG = null;
            this.dGH = null;
            this.dGJ = new ArrayList();
            this.firstDayOfWeek = 1;
            this.orientation = 0;
            this.dHK = -1;
            this.dHL = -1;
            this.dHM = true;
            this.selectionMode = 1;
            this.dHN = false;
            this.dHu = CalendarMode.MONTHS;
            this.dHs = null;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.color);
            parcel.writeInt(this.dateTextAppearance);
            parcel.writeInt(this.weekDayTextAppearance);
            parcel.writeInt(this.dGF);
            parcel.writeByte((byte) this.dHG);
            parcel.writeParcelable(this.dGG, 0);
            parcel.writeParcelable(this.dGH, 0);
            parcel.writeTypedList(this.dGJ);
            parcel.writeInt(this.firstDayOfWeek);
            parcel.writeInt(this.orientation);
            parcel.writeInt(this.dHK);
            parcel.writeInt(this.dHL);
            parcel.writeInt(this.dHM);
            parcel.writeInt(this.selectionMode);
            parcel.writeInt(this.dHN);
            parcel.writeInt(this.dHu == CalendarMode.WEEKS ? 1 : 0);
            parcel.writeParcelable(this.dHs, 0);
            parcel.writeByte((byte) this.dHO);
        }

        private b(Parcel parcel) {
            super(parcel);
            boolean z = false;
            this.color = 0;
            this.dateTextAppearance = 0;
            this.weekDayTextAppearance = 0;
            this.dGF = 4;
            this.dHG = true;
            this.dGG = null;
            this.dGH = null;
            this.dGJ = new ArrayList();
            this.firstDayOfWeek = 1;
            this.orientation = 0;
            this.dHK = -1;
            this.dHL = -1;
            this.dHM = true;
            this.selectionMode = 1;
            this.dHN = false;
            this.dHu = CalendarMode.MONTHS;
            this.dHs = null;
            this.color = parcel.readInt();
            this.dateTextAppearance = parcel.readInt();
            this.weekDayTextAppearance = parcel.readInt();
            this.dGF = parcel.readInt();
            this.dHG = parcel.readByte() != (byte) 0;
            ClassLoader classLoader = b.class.getClassLoader();
            this.dGG = (b) parcel.readParcelable(classLoader);
            this.dGH = (b) parcel.readParcelable(classLoader);
            parcel.readTypedList(this.dGJ, b.CREATOR);
            this.firstDayOfWeek = parcel.readInt();
            this.orientation = parcel.readInt();
            this.dHK = parcel.readInt();
            this.dHL = parcel.readInt();
            this.dHM = parcel.readInt() == 1;
            this.selectionMode = parcel.readInt();
            this.dHN = parcel.readInt() == 1;
            this.dHu = parcel.readInt() == 1 ? CalendarMode.WEEKS : CalendarMode.MONTHS;
            this.dHs = (b) parcel.readParcelable(classLoader);
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.dHO = z;
        }
    }

    public class c {
        private final b dGG;
        private final b dGH;
        private final boolean dHO;
        private final CalendarMode dHu;
        private final int firstDayOfWeek;

        /* synthetic */ c(MaterialCalendarView materialCalendarView, d dVar, AnonymousClass1 anonymousClass1) {
            this(dVar);
        }

        private c(d dVar) {
            this.dHu = dVar.dHu;
            this.firstDayOfWeek = dVar.firstDayOfWeek;
            this.dGG = dVar.dGG;
            this.dGH = dVar.dGH;
            this.dHO = dVar.dHO;
        }

        public d aJx() {
            return new d(MaterialCalendarView.this, this, null);
        }
    }

    public class d {
        private b dGG;
        private b dGH;
        private boolean dHO;
        private CalendarMode dHu;
        private int firstDayOfWeek;

        /* synthetic */ d(MaterialCalendarView materialCalendarView, c cVar, AnonymousClass1 anonymousClass1) {
            this(cVar);
        }

        public d() {
            this.dHu = CalendarMode.MONTHS;
            this.firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
            this.dHO = false;
            this.dGG = null;
            this.dGH = null;
        }

        private d(c cVar) {
            this.dHu = CalendarMode.MONTHS;
            this.firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
            this.dHO = false;
            this.dGG = null;
            this.dGH = null;
            this.dHu = cVar.dHu;
            this.firstDayOfWeek = cVar.firstDayOfWeek;
            this.dGG = cVar.dGG;
            this.dGH = cVar.dGH;
            this.dHO = cVar.dHO;
        }

        public d hl(int i) {
            this.firstDayOfWeek = i;
            return this;
        }

        public d a(CalendarMode calendarMode) {
            this.dHu = calendarMode;
            return this;
        }

        public d j(@Nullable b bVar) {
            this.dGG = bVar;
            return this;
        }

        public d k(@Nullable b bVar) {
            this.dGH = bVar;
            return this;
        }

        public d fp(boolean z) {
            this.dHO = z;
            return this;
        }

        public void commit() {
            MaterialCalendarView.this.a(new c(MaterialCalendarView.this, this, null));
        }
    }

    public static boolean hh(int i) {
        return (i & 1) != 0;
    }

    public static boolean hi(int i) {
        return (i & 2) != 0;
    }

    public static boolean hj(int i) {
        return (i & 4) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public MaterialCalendarView(Context context) {
        this(context, null);
    }

    public MaterialCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHw = new ArrayList();
        this.cww = new OnClickListener() {
            public void onClick(View view) {
                if (view == MaterialCalendarView.this.dHp) {
                    MaterialCalendarView.this.dHq.setCurrentItem(MaterialCalendarView.this.dHq.getCurrentItem() + 1, true);
                } else if (view == MaterialCalendarView.this.dHo) {
                    MaterialCalendarView.this.dHq.setCurrentItem(MaterialCalendarView.this.dHq.getCurrentItem() - 1, true);
                }
            }
        };
        this.dHx = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                MaterialCalendarView.this.dHn.m(MaterialCalendarView.this.dHs);
                MaterialCalendarView.this.dHs = MaterialCalendarView.this.dHr.hf(i);
                MaterialCalendarView.this.aJk();
                MaterialCalendarView.this.h(MaterialCalendarView.this.dHs);
            }
        };
        this.dGG = null;
        this.dGH = null;
        this.dHC = 0;
        this.dHD = ViewCompat.MEASURED_STATE_MASK;
        this.tileHeight = -10;
        this.tileWidth = -10;
        this.selectionMode = 1;
        this.dHG = true;
        if (VERSION.SDK_INT >= 19) {
            setClipToPadding(false);
            setClipChildren(false);
        } else {
            setClipChildren(true);
            setClipToPadding(true);
        }
        this.dHo = new l(getContext());
        this.dHo.setContentDescription("Previous");
        this.agA = new TextView(getContext());
        this.dHp = new l(getContext());
        this.dHp.setContentDescription("Next");
        this.dHq = new c(getContext());
        this.dHo.setOnClickListener(this.cww);
        this.dHp.setOnClickListener(this.cww);
        this.dHn = new r(this.agA);
        this.dHn.setTitleFormatter(dHm);
        this.dHq.setOnPageChangeListener(this.dHx);
        this.dHq.setPageTransformer(false, new PageTransformer() {
            public void transformPage(View view, float f) {
                view.setAlpha((float) Math.sqrt((double) (1.0f - Math.abs(f))));
            }
        });
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.iqoption.b.b.MaterialCalendarView, 0, 0);
        try {
            int integer = obtainStyledAttributes.getInteger(2, 0);
            this.firstDayOfWeek = obtainStyledAttributes.getInteger(4, -1);
            this.dHn.setOrientation(obtainStyledAttributes.getInteger(14, 0));
            if (this.firstDayOfWeek < 0) {
                this.firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
            }
            aJw().hl(this.firstDayOfWeek).a(CalendarMode.values()[integer]).commit();
            integer = obtainStyledAttributes.getLayoutDimension(12, -10);
            if (integer > -10) {
                setTileSize(integer);
            }
            integer = obtainStyledAttributes.getLayoutDimension(13, -10);
            if (integer > -10) {
                setTileWidth(integer);
            }
            integer = obtainStyledAttributes.getLayoutDimension(11, -10);
            if (integer > -10) {
                setTileHeight(integer);
            }
            setArrowColor(obtainStyledAttributes.getColor(1, ViewCompat.MEASURED_STATE_MASK));
            Drawable drawable = obtainStyledAttributes.getDrawable(6);
            if (drawable == null) {
                drawable = getResources().getDrawable(R.drawable.ic_arrow_calendar_left);
            }
            setLeftArrowMask(drawable);
            drawable = obtainStyledAttributes.getDrawable(8);
            if (drawable == null) {
                drawable = getResources().getDrawable(R.drawable.ic_arrow_calendar_right);
            }
            setRightArrowMask(drawable);
            setSelectionColor(obtainStyledAttributes.getColor(9, ContextCompat.getColor(context, R.color.grey_blur_50)));
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(15);
            if (textArray != null) {
                setWeekDayFormatter(new com.iqoption.view.materialcalendar.a.a(textArray));
            }
            textArray = obtainStyledAttributes.getTextArray(7);
            if (textArray != null) {
                setTitleFormatter(new f(textArray));
            }
            setHeaderTextAppearance(obtainStyledAttributes.getResourceId(5, R.style.TextAppearance.MaterialCalendarWidget.Header));
            setWeekDayTextAppearance(obtainStyledAttributes.getResourceId(16, R.style.TextAppearance.MaterialCalendarWidget.WeekDay));
            setDateTextAppearance(obtainStyledAttributes.getResourceId(3, R.style.TextAppearance.MaterialCalendarWidget.Date));
            setShowOtherDates(obtainStyledAttributes.getInteger(10, 4));
            setAllowClickDaysOutsideCurrentMonth(obtainStyledAttributes.getBoolean(0, true));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes.recycle();
        this.dHr.setTitleFormatter(dHm);
        aJq();
        this.dHs = b.aJd();
        setCurrentDate(this.dHs);
        if (isInEditMode()) {
            removeView(this.dHq);
            View nVar = new n(this, this.dHs, getFirstDayOfWeek());
            nVar.setSelectionColor(getSelectionColor());
            nVar.setDateTextAppearance(this.dHr.getDateTextAppearance());
            nVar.setWeekDayTextAppearance(this.dHr.getWeekDayTextAppearance());
            nVar.setShowOtherDates(getShowOtherDates());
            addView(nVar, new a(this.dHu.visibleWeeksCount + 1));
        }
    }

    private void aJq() {
        this.dHt = new LinearLayout(getContext());
        this.dHt.setOrientation(0);
        this.dHt.setClipChildren(false);
        this.dHt.setClipToPadding(false);
        addView(this.dHt, new a(1));
        this.dHo.setScaleType(ScaleType.CENTER_INSIDE);
        this.dHt.addView(this.dHo, new LayoutParams(0, -1, 1.0f));
        this.agA.setGravity(17);
        this.dHt.addView(this.agA, new LayoutParams(0, -1, 5.0f));
        this.dHp.setScaleType(ScaleType.CENTER_INSIDE);
        this.dHt.addView(this.dHp, new LayoutParams(0, -1, 1.0f));
        this.dHq.setId(R.id.mcv_pager);
        this.dHq.setOffscreenPageLimit(1);
        addView(this.dHq, new a(this.dHu.visibleWeeksCount + 1));
    }

    private void aJk() {
        this.dHn.l(this.dHs);
        this.dHo.setEnabled(canGoBack());
        this.dHp.setEnabled(canGoForward());
    }

    public void setSelectionMode(int i) {
        int i2 = this.selectionMode;
        this.selectionMode = i;
        boolean z = false;
        switch (i) {
            case 1:
                if ((i2 == 2 || i2 == 3) && !getSelectedDates().isEmpty()) {
                    setSelectedDate(getSelectedDate());
                    break;
                }
            case 2:
                break;
            case 3:
                clearSelection();
                break;
            default:
                this.selectionMode = 0;
                if (i2 != 0) {
                    clearSelection();
                    break;
                }
                break;
        }
        d dVar = this.dHr;
        if (this.selectionMode != 0) {
            z = true;
        }
        dVar.setSelectionEnabled(z);
    }

    public void aJr() {
        if (canGoBack()) {
            this.dHq.setCurrentItem(this.dHq.getCurrentItem() - 1, true);
        }
    }

    public void aJs() {
        if (canGoForward()) {
            this.dHq.setCurrentItem(this.dHq.getCurrentItem() + 1, true);
        }
    }

    public int getSelectionMode() {
        return this.selectionMode;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.tileHeight, this.tileWidth);
    }

    public void setTileSize(int i) {
        this.tileWidth = i;
        this.tileHeight = i;
        requestLayout();
    }

    public void setTileSizeDp(int i) {
        setTileSize(dpToPx(i));
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public void setTileHeight(int i) {
        this.tileHeight = i;
        requestLayout();
    }

    public void setTileHeightDp(int i) {
        setTileHeight(dpToPx(i));
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public void setTileWidth(int i) {
        this.tileWidth = i;
        requestLayout();
    }

    public void setTileWidthDp(int i) {
        setTileWidth(dpToPx(i));
    }

    private int dpToPx(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public boolean canGoForward() {
        return this.dHq.getCurrentItem() < this.dHr.getCount() - 1;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dHq.dispatchTouchEvent(motionEvent);
    }

    public boolean canGoBack() {
        return this.dHq.getCurrentItem() > 0;
    }

    public int getSelectionColor() {
        return this.dHC;
    }

    public void setSelectionColor(int i) {
        if (i == 0) {
            if (isInEditMode()) {
                i = -7829368;
            } else {
                return;
            }
        }
        this.dHC = i;
        this.dHr.setSelectionColor(i);
        invalidate();
    }

    public int getArrowColor() {
        return this.dHD;
    }

    public void setArrowColor(int i) {
        if (i != 0) {
            this.dHD = i;
            this.dHo.setColor(i);
            this.dHp.setColor(i);
            invalidate();
        }
    }

    public void setContentDescriptionArrowPast(CharSequence charSequence) {
        this.dHo.setContentDescription(charSequence);
    }

    public void setContentDescriptionArrowFuture(CharSequence charSequence) {
        this.dHp.setContentDescription(charSequence);
    }

    public void setContentDescriptionCalendar(CharSequence charSequence) {
        this.dHB = charSequence;
    }

    public CharSequence getCalendarContentDescription() {
        return this.dHB != null ? this.dHB : "Calendar";
    }

    public Drawable getLeftArrowMask() {
        return this.dHE;
    }

    public void setLeftArrowMask(Drawable drawable) {
        this.dHE = drawable;
        this.dHo.setImageDrawable(drawable);
    }

    public Drawable getRightArrowMask() {
        return this.dHF;
    }

    public void setRightArrowMask(Drawable drawable) {
        this.dHF = drawable;
        this.dHp.setImageDrawable(drawable);
    }

    public void setHeaderTextAppearance(int i) {
        this.agA.setTextAppearance(getContext(), i);
    }

    public void setDateTextAppearance(int i) {
        this.dHr.setDateTextAppearance(i);
    }

    public void setWeekDayTextAppearance(int i) {
        this.dHr.setWeekDayTextAppearance(i);
    }

    public b getSelectedDate() {
        List selectedDates = this.dHr.getSelectedDates();
        if (selectedDates.isEmpty()) {
            return null;
        }
        return (b) selectedDates.get(selectedDates.size() - 1);
    }

    @NonNull
    public List<b> getSelectedDates() {
        return this.dHr.getSelectedDates();
    }

    public void clearSelection() {
        List<b> selectedDates = getSelectedDates();
        this.dHr.aJg();
        for (b c : selectedDates) {
            c(c, false);
        }
    }

    public void setSelectedDate(@Nullable Calendar calendar) {
        setSelectedDate(b.b(calendar));
    }

    public void setSelectedDate(@Nullable Date date) {
        setSelectedDate(b.c(date));
    }

    public void setSelectedDate(@Nullable b bVar) {
        clearSelection();
        if (bVar != null) {
            a(bVar, true);
        }
    }

    public void a(@Nullable b bVar, boolean z) {
        if (bVar != null) {
            this.dHr.a(bVar, z);
        }
    }

    public void setCurrentDate(@Nullable Calendar calendar) {
        setCurrentDate(b.b(calendar));
    }

    public void setCurrentDate(@Nullable Date date) {
        setCurrentDate(b.c(date));
    }

    public b getCurrentDate() {
        return this.dHr.hf(this.dHq.getCurrentItem());
    }

    public void setCurrentDate(@Nullable b bVar) {
        b(bVar, true);
    }

    public void b(@Nullable b bVar, boolean z) {
        if (bVar != null) {
            this.dHq.setCurrentItem(this.dHr.c(bVar), z);
            aJk();
        }
    }

    public b getMinimumDate() {
        return this.dGG;
    }

    public b getMaximumDate() {
        return this.dGH;
    }

    public void setShowOtherDates(int i) {
        this.dHr.setShowOtherDates(i);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean z) {
        this.dHG = z;
    }

    public void setWeekDayFormatter(h hVar) {
        d dVar = this.dHr;
        if (hVar == null) {
            hVar = h.dIe;
        }
        dVar.setWeekDayFormatter(hVar);
    }

    public void setDayFormatter(e eVar) {
        d dVar = this.dHr;
        if (eVar == null) {
            eVar = e.dIc;
        }
        dVar.setDayFormatter(eVar);
    }

    public void setWeekDayLabels(CharSequence[] charSequenceArr) {
        setWeekDayFormatter(new com.iqoption.view.materialcalendar.a.a(charSequenceArr));
    }

    public void setWeekDayLabels(@ArrayRes int i) {
        setWeekDayLabels(getResources().getTextArray(i));
    }

    public int getShowOtherDates() {
        return this.dHr.getShowOtherDates();
    }

    public boolean aJt() {
        return this.dHG;
    }

    public void setTitleFormatter(g gVar) {
        if (gVar == null) {
            gVar = dHm;
        }
        this.dHn.setTitleFormatter(gVar);
        this.dHr.setTitleFormatter(gVar);
        aJk();
    }

    public void setTitleMonths(CharSequence[] charSequenceArr) {
        setTitleFormatter(new f(charSequenceArr));
    }

    public void setTitleMonths(@ArrayRes int i) {
        setTitleMonths(getResources().getTextArray(i));
    }

    public void setTitleAnimationOrientation(int i) {
        this.dHn.setOrientation(i);
    }

    public int getTitleAnimationOrientation() {
        return this.dHn.getOrientation();
    }

    public void setTopbarVisible(boolean z) {
        this.dHt.setVisibility(z ? 0 : 8);
        requestLayout();
    }

    public boolean getTopbarVisible() {
        return this.dHt.getVisibility() == 0;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bVar = new b(super.onSaveInstanceState());
        bVar.color = getSelectionColor();
        bVar.dateTextAppearance = this.dHr.getDateTextAppearance();
        bVar.weekDayTextAppearance = this.dHr.getWeekDayTextAppearance();
        bVar.dGF = getShowOtherDates();
        bVar.dHG = aJt();
        bVar.dGG = getMinimumDate();
        bVar.dGH = getMaximumDate();
        bVar.dGJ = getSelectedDates();
        bVar.firstDayOfWeek = getFirstDayOfWeek();
        bVar.orientation = getTitleAnimationOrientation();
        bVar.selectionMode = getSelectionMode();
        bVar.dHK = getTileWidth();
        bVar.dHL = getTileHeight();
        bVar.dHM = getTopbarVisible();
        bVar.dHu = this.dHu;
        bVar.dHN = this.dHv;
        bVar.dHs = this.dHs;
        bVar.dHO = this.dHH.dHO;
        return bVar;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        aJw().hl(bVar.firstDayOfWeek).a(bVar.dHu).j(bVar.dGG).k(bVar.dGH).fp(bVar.dHO).commit();
        setSelectionColor(bVar.color);
        setDateTextAppearance(bVar.dateTextAppearance);
        setWeekDayTextAppearance(bVar.weekDayTextAppearance);
        setShowOtherDates(bVar.dGF);
        setAllowClickDaysOutsideCurrentMonth(bVar.dHG);
        setCurrentDate(bVar.dHs);
        setSelectionMode(bVar.selectionMode);
        clearSelection();
        for (b a : bVar.dGJ) {
            a(a, true);
        }
        setTitleAnimationOrientation(bVar.orientation);
        setTopbarVisible(bVar.dHM);
        setDynamicHeightEnabled(bVar.dHN);
    }

    protected void dispatchSaveInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void e(b bVar, b bVar2) {
        b bVar3 = this.dHs;
        this.dHr.e(bVar, bVar2);
        this.dHs = bVar3;
        if (bVar != null) {
            if (!bVar.b(this.dHs)) {
                bVar = this.dHs;
            }
            this.dHs = bVar;
        }
        this.dHq.setCurrentItem(this.dHr.c(bVar3), false);
        aJk();
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public void setDynamicHeightEnabled(boolean z) {
        this.dHv = z;
    }

    public void aJe() {
        this.dHr.aJe();
    }

    public void setOnDateChangedListener(o oVar) {
        this.dHy = oVar;
    }

    public void setOnMonthChangedListener(p pVar) {
        this.dHz = pVar;
    }

    public void setOnRangeSelectedListener(q qVar) {
        this.dHA = qVar;
    }

    public void setOnTitleClickListener(OnClickListener onClickListener) {
        this.agA.setOnClickListener(onClickListener);
    }

    protected void c(b bVar, boolean z) {
        o oVar = this.dHy;
        if (oVar != null) {
            oVar.b(this, bVar, z);
        }
    }

    protected void f(b bVar, b bVar2) {
        q qVar = this.dHA;
        List arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        instance.setTime(bVar.getDate());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(bVar2.getDate());
        while (true) {
            if (!instance.before(instance2) && !instance.equals(instance2)) {
                break;
            }
            bVar2 = b.b(instance);
            this.dHr.a(bVar2, true);
            arrayList.add(bVar2);
            instance.add(5, 1);
        }
        if (qVar != null) {
            qVar.b(this, arrayList);
        }
    }

    protected void h(b bVar) {
        p pVar = this.dHz;
        if (pVar != null) {
            pVar.b(this, bVar);
        }
    }

    protected void d(@NonNull b bVar, boolean z) {
        switch (this.selectionMode) {
            case 2:
                this.dHr.a(bVar, z);
                c(bVar, z);
                return;
            case 3:
                this.dHr.a(bVar, z);
                if (this.dHr.getSelectedDates().size() > 2) {
                    this.dHr.aJg();
                    this.dHr.a(bVar, z);
                    c(bVar, z);
                    return;
                } else if (this.dHr.getSelectedDates().size() == 2) {
                    List selectedDates = this.dHr.getSelectedDates();
                    if (((b) selectedDates.get(0)).b((b) selectedDates.get(1))) {
                        f((b) selectedDates.get(1), (b) selectedDates.get(0));
                        return;
                    } else {
                        f((b) selectedDates.get(0), (b) selectedDates.get(1));
                        return;
                    }
                } else {
                    this.dHr.a(bVar, z);
                    c(bVar, z);
                    return;
                }
            default:
                this.dHr.aJg();
                this.dHr.a(bVar, true);
                c(bVar, true);
                return;
        }
    }

    public void g(b bVar, b bVar2) {
        clearSelection();
        if (bVar != null && bVar2 != null) {
            if (bVar.b(bVar2)) {
                f(bVar2, bVar);
            } else {
                f(bVar, bVar2);
            }
        }
    }

    protected void a(h hVar) {
        b currentDate = getCurrentDate();
        b aJm = hVar.aJm();
        int month = currentDate.getMonth();
        int month2 = aJm.getMonth();
        if (this.dHu == CalendarMode.MONTHS && this.dHG && month != month2) {
            if (currentDate.b(aJm)) {
                aJr();
            } else if (currentDate.a(aJm)) {
                aJs();
            }
        }
        d(hVar.aJm(), hVar.isChecked() ^ 1);
    }

    protected void i(b bVar) {
        c(bVar, false);
    }

    /* renamed from: aJu */
    protected a generateDefaultLayoutParams() {
        return new a(1);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        size = (size - getPaddingLeft()) - getPaddingRight();
        size2 = (size2 - getPaddingTop()) - getPaddingBottom();
        int weekCountBasedOnMode = getWeekCountBasedOnMode();
        if (getTopbarVisible()) {
            weekCountBasedOnMode++;
        }
        size /= 7;
        size2 /= weekCountBasedOnMode;
        int i3 = -1;
        if (this.tileWidth == -10 && this.tileHeight == -10) {
            if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
                if (mode2 == 1073741824) {
                    size = Math.min(size, size2);
                }
                i3 = size;
            } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
                i3 = size2;
            }
            size = -1;
            size2 = -1;
        } else {
            if (this.tileWidth > 0) {
                size = this.tileWidth;
            }
            if (this.tileHeight > 0) {
                size2 = this.tileHeight;
            }
        }
        if (i3 > 0) {
            size2 = i3;
        } else if (i3 <= 0) {
            if (size <= 0) {
                size = dpToPx(44);
            }
            i3 = size;
            if (size2 <= 0) {
                size2 = dpToPx(44);
            }
        } else {
            i3 = size;
        }
        size = i3 * 7;
        setMeasuredDimension(aF((getPaddingLeft() + getPaddingRight()) + size, i), aF((weekCountBasedOnMode * size2) + (getPaddingTop() + getPaddingBottom()), i2));
        i = getChildCount();
        for (i2 = 0; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            if (i3 > 0 && size2 > 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(aVar.height * size2, 1073741824));
            }
        }
    }

    private int getWeekCountBasedOnMode() {
        int i = this.dHu.visibleWeeksCount;
        if (this.dHu.equals(CalendarMode.MONTHS) && this.dHv && this.dHr != null && this.dHq != null) {
            Calendar calendar = (Calendar) this.dHr.hf(this.dHq.getCurrentItem()).getCalendar().clone();
            calendar.set(5, calendar.getActualMaximum(5));
            calendar.setFirstDayOfWeek(getFirstDayOfWeek());
            i = calendar.get(4);
        }
        return i + 1;
    }

    private static int aF(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i : i2;
        } else {
            return Math.min(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        i2 = getPaddingLeft();
        i3 = ((i3 - i) - i2) - getPaddingRight();
        i = getPaddingTop();
        for (i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int i5 = ((i3 - measuredWidth) / 2) + i2;
                int measuredHeight = childAt.getMeasuredHeight() + i;
                childAt.layout(i5, i, measuredWidth + i5, measuredHeight);
                i = measuredHeight;
            }
        }
    }

    /* renamed from: f */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(1);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(1);
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MaterialCalendarView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MaterialCalendarView.class.getName());
    }

    public void setPagingEnabled(boolean z) {
        this.dHq.setPagingEnabled(z);
        aJk();
    }

    public c aJv() {
        return this.dHH;
    }

    public d aJw() {
        return new d();
    }

    /* JADX WARNING: Missing block: B:14:0x0047, code:
            if (r2.a(r3) == false) goto L_0x007c;
     */
    private void a(com.iqoption.view.materialcalendar.MaterialCalendarView.c r7) {
        /*
        r6 = this;
        r0 = r6.dHr;
        r1 = 1;
        if (r0 == 0) goto L_0x007b;
    L_0x0005:
        r0 = r7.dHO;
        if (r0 == 0) goto L_0x007b;
    L_0x000b:
        r0 = r6.dHr;
        r2 = r6.dHq;
        r2 = r2.getCurrentItem();
        r0 = r0.hf(r2);
        r2 = r6.dHu;
        r3 = r7.dHu;
        if (r2 == r3) goto L_0x007c;
    L_0x001f:
        r2 = r6.getSelectedDate();
        r3 = r6.dHu;
        r4 = com.iqoption.view.materialcalendar.CalendarMode.MONTHS;
        if (r3 != r4) goto L_0x004a;
    L_0x0029:
        if (r2 == 0) goto L_0x004a;
    L_0x002b:
        r3 = r0.getCalendar();
        r4 = 2;
        r3.add(r4, r1);
        r3 = com.iqoption.view.materialcalendar.b.b(r3);
        r4 = r2.equals(r0);
        if (r4 != 0) goto L_0x0077;
    L_0x003d:
        r4 = r2.b(r0);
        if (r4 == 0) goto L_0x007c;
    L_0x0043:
        r3 = r2.a(r3);
        if (r3 == 0) goto L_0x007c;
    L_0x0049:
        goto L_0x0077;
    L_0x004a:
        r3 = r6.dHu;
        r4 = com.iqoption.view.materialcalendar.CalendarMode.WEEKS;
        if (r3 != r4) goto L_0x007c;
    L_0x0050:
        r3 = r0.getCalendar();
        r4 = 7;
        r5 = 6;
        r3.add(r4, r5);
        r3 = com.iqoption.view.materialcalendar.b.b(r3);
        if (r2 == 0) goto L_0x0079;
    L_0x005f:
        r4 = r2.equals(r0);
        if (r4 != 0) goto L_0x0077;
    L_0x0065:
        r4 = r2.equals(r3);
        if (r4 != 0) goto L_0x0077;
    L_0x006b:
        r0 = r2.b(r0);
        if (r0 == 0) goto L_0x0079;
    L_0x0071:
        r0 = r2.a(r3);
        if (r0 == 0) goto L_0x0079;
    L_0x0077:
        r0 = r2;
        goto L_0x007c;
    L_0x0079:
        r0 = r3;
        goto L_0x007c;
    L_0x007b:
        r0 = 0;
    L_0x007c:
        r6.dHH = r7;
        r2 = r7.dHu;
        r6.dHu = r2;
        r2 = r7.firstDayOfWeek;
        r6.firstDayOfWeek = r2;
        r2 = r7.dGG;
        r6.dGG = r2;
        r7 = r7.dGH;
        r6.dGH = r7;
        r7 = com.iqoption.view.materialcalendar.MaterialCalendarView.AnonymousClass4.dHJ;
        r2 = r6.dHu;
        r2 = r2.ordinal();
        r7 = r7[r2];
        switch(r7) {
            case 1: goto L_0x00b1;
            case 2: goto L_0x00ab;
            default: goto L_0x00a3;
        };
    L_0x00a3:
        r7 = new java.lang.IllegalArgumentException;
        r0 = "Provided display mode which is not yet implemented";
        r7.<init>(r0);
        throw r7;
    L_0x00ab:
        r7 = new com.iqoption.view.materialcalendar.t;
        r7.<init>(r6);
        goto L_0x00b6;
    L_0x00b1:
        r7 = new com.iqoption.view.materialcalendar.m;
        r7.<init>(r6);
    L_0x00b6:
        r2 = r6.dHr;
        if (r2 != 0) goto L_0x00bd;
    L_0x00ba:
        r6.dHr = r7;
        goto L_0x00c5;
    L_0x00bd:
        r2 = r6.dHr;
        r7 = r2.a(r7);
        r6.dHr = r7;
    L_0x00c5:
        r7 = r6.dHq;
        r2 = r6.dHr;
        r7.setAdapter(r2);
        r7 = r6.dGG;
        r2 = r6.dGH;
        r6.e(r7, r2);
        r7 = r6.dHq;
        r2 = new com.iqoption.view.materialcalendar.MaterialCalendarView$a;
        r3 = r6.dHu;
        r3 = r3.visibleWeeksCount;
        r3 = r3 + r1;
        r2.<init>(r3);
        r7.setLayoutParams(r2);
        r7 = r6.selectionMode;
        if (r7 != r1) goto L_0x0100;
    L_0x00e6:
        r7 = r6.dHr;
        r7 = r7.getSelectedDates();
        r7 = r7.isEmpty();
        if (r7 != 0) goto L_0x0100;
    L_0x00f2:
        r7 = r6.dHr;
        r7 = r7.getSelectedDates();
        r1 = 0;
        r7 = r7.get(r1);
        r7 = (com.iqoption.view.materialcalendar.b) r7;
        goto L_0x0104;
    L_0x0100:
        r7 = com.iqoption.view.materialcalendar.b.aJd();
    L_0x0104:
        r6.setCurrentDate(r7);
        if (r0 == 0) goto L_0x0114;
    L_0x0109:
        r7 = r6.dHq;
        r1 = r6.dHr;
        r0 = r1.c(r0);
        r7.setCurrentItem(r0);
    L_0x0114:
        r6.aJe();
        r6.aJk();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.materialcalendar.MaterialCalendarView.a(com.iqoption.view.materialcalendar.MaterialCalendarView$c):void");
    }
}
