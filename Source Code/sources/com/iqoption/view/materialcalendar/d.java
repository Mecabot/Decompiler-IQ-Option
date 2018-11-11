package com.iqoption.view.materialcalendar;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.view.materialcalendar.a.e;
import com.iqoption.view.materialcalendar.a.g;
import com.iqoption.view.materialcalendar.a.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: CalendarPagerAdapter */
abstract class d<V extends e> extends PagerAdapter {
    private final b dGA;
    private g dGB = null;
    private Integer dGC = null;
    private Integer dGD = null;
    private Integer dGE = null;
    private int dGF = 4;
    private b dGG = null;
    private b dGH = null;
    private g dGI;
    private List<b> dGJ = new ArrayList();
    private h dGK = h.dIe;
    private e dGL = e.dIc;
    private List<i> dGM = new ArrayList();
    private List<k> dGN = null;
    private boolean dGO = true;
    private final ArrayDeque<V> dGy;
    protected final MaterialCalendarView dGz;

    protected abstract int a(V v);

    protected abstract boolean bO(Object obj);

    protected abstract g d(b bVar, b bVar2);

    protected abstract V he(int i);

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    d(MaterialCalendarView materialCalendarView) {
        this.dGz = materialCalendarView;
        this.dGA = b.aJd();
        this.dGy = new ArrayDeque();
        this.dGy.iterator();
        e(null, null);
    }

    public void aJe() {
        this.dGN = new ArrayList();
        for (i iVar : this.dGM) {
            j jVar = new j();
            iVar.b(jVar);
            if (jVar.aJp()) {
                this.dGN.add(new k(iVar, jVar));
            }
        }
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setDayViewDecorators(this.dGN);
        }
    }

    public int getCount() {
        return this.dGI.getCount();
    }

    public CharSequence getPageTitle(int i) {
        return this.dGB == null ? "" : this.dGB.o(hf(i));
    }

    public d<?> a(d<?> dVar) {
        dVar.dGB = this.dGB;
        dVar.dGC = this.dGC;
        dVar.dGD = this.dGD;
        dVar.dGE = this.dGE;
        dVar.dGF = this.dGF;
        dVar.dGG = this.dGG;
        dVar.dGH = this.dGH;
        dVar.dGJ = this.dGJ;
        dVar.dGK = this.dGK;
        dVar.dGL = this.dGL;
        dVar.dGM = this.dGM;
        dVar.dGN = this.dGN;
        dVar.dGO = this.dGO;
        return dVar;
    }

    public int c(b bVar) {
        if (bVar == null) {
            return getCount() / 2;
        }
        if (this.dGG != null && bVar.a(this.dGG)) {
            return 0;
        }
        if (this.dGH == null || !bVar.b(this.dGH)) {
            return this.dGI.e(bVar);
        }
        return getCount() - 1;
    }

    public int getItemPosition(Object obj) {
        if (!bO(obj)) {
            return -2;
        }
        e eVar = (e) obj;
        if (eVar.getFirstViewDay() == null) {
            return -2;
        }
        int a = a(eVar);
        if (a < 0) {
            return -2;
        }
        return a;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View he = he(i);
        he.setContentDescription(this.dGz.getCalendarContentDescription());
        he.setAlpha(0.0f);
        he.setSelectionEnabled(this.dGO);
        he.setWeekDayFormatter(this.dGK);
        he.setDayFormatter(this.dGL);
        if (this.dGC != null) {
            he.setSelectionColor(this.dGC.intValue());
        }
        if (this.dGD != null) {
            he.setDateTextAppearance(this.dGD.intValue());
        }
        if (this.dGE != null) {
            he.setWeekDayTextAppearance(this.dGE.intValue());
        }
        he.setShowOtherDates(this.dGF);
        he.setMinimumDate(this.dGG);
        he.setMaximumDate(this.dGH);
        he.setSelectedDates(this.dGJ);
        viewGroup.addView(he);
        this.dGy.add(he);
        he.setDayViewDecorators(this.dGN);
        return he;
    }

    public void setSelectionEnabled(boolean z) {
        this.dGO = z;
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setSelectionEnabled(this.dGO);
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        e eVar = (e) obj;
        this.dGy.remove(eVar);
        viewGroup.removeView(eVar);
    }

    public void setTitleFormatter(@NonNull g gVar) {
        this.dGB = gVar;
    }

    public void setSelectionColor(int i) {
        this.dGC = Integer.valueOf(i);
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setSelectionColor(i);
        }
    }

    public void setDateTextAppearance(int i) {
        if (i != 0) {
            this.dGD = Integer.valueOf(i);
            Iterator it = this.dGy.iterator();
            while (it.hasNext()) {
                ((e) it.next()).setDateTextAppearance(i);
            }
        }
    }

    public void setShowOtherDates(int i) {
        this.dGF = i;
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setShowOtherDates(i);
        }
    }

    public void setWeekDayFormatter(h hVar) {
        this.dGK = hVar;
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setWeekDayFormatter(hVar);
        }
    }

    public void setDayFormatter(e eVar) {
        this.dGL = eVar;
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setDayFormatter(eVar);
        }
    }

    public int getShowOtherDates() {
        return this.dGF;
    }

    public void setWeekDayTextAppearance(int i) {
        if (i != 0) {
            this.dGE = Integer.valueOf(i);
            Iterator it = this.dGy.iterator();
            while (it.hasNext()) {
                ((e) it.next()).setWeekDayTextAppearance(i);
            }
        }
    }

    public void e(b bVar, b bVar2) {
        this.dGG = bVar;
        this.dGH = bVar2;
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            eVar.setMinimumDate(bVar);
            eVar.setMaximumDate(bVar2);
        }
        if (bVar == null) {
            bVar = b.q(this.dGA.getYear() - 200, this.dGA.getMonth(), this.dGA.getDay());
        }
        if (bVar2 == null) {
            bVar2 = b.q(this.dGA.getYear() + 200, this.dGA.getMonth(), this.dGA.getDay());
        }
        this.dGI = d(bVar, bVar2);
        notifyDataSetChanged();
        aJh();
    }

    public g aJf() {
        return this.dGI;
    }

    public void aJg() {
        this.dGJ.clear();
        aJh();
    }

    public void a(b bVar, boolean z) {
        if (z) {
            if (!this.dGJ.contains(bVar)) {
                this.dGJ.add(bVar);
                aJh();
            }
        } else if (this.dGJ.contains(bVar)) {
            this.dGJ.remove(bVar);
            aJh();
        }
    }

    private void aJh() {
        aJi();
        Iterator it = this.dGy.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setSelectedDates(this.dGJ);
        }
    }

    private void aJi() {
        int i = 0;
        while (i < this.dGJ.size()) {
            b bVar = (b) this.dGJ.get(i);
            if ((this.dGG != null && this.dGG.b(bVar)) || (this.dGH != null && this.dGH.a(bVar))) {
                this.dGJ.remove(i);
                this.dGz.i(bVar);
                i--;
            }
            i++;
        }
    }

    public b hf(int i) {
        return this.dGI.hf(i);
    }

    @NonNull
    public List<b> getSelectedDates() {
        return Collections.unmodifiableList(this.dGJ);
    }

    protected int getDateTextAppearance() {
        return this.dGD == null ? 0 : this.dGD.intValue();
    }

    protected int getWeekDayTextAppearance() {
        return this.dGE == null ? 0 : this.dGE.intValue();
    }
}
