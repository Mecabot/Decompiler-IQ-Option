package com.iqoption.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.iqoption.a.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.ae;
import com.iqoption.app.managers.tab.a;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.app.managers.tab.a.h;
import com.iqoption.core.util.i;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.Event;
import com.iqoption.fragment.base.b;
import com.iqoption.util.bg;
import com.iqoption.view.ClippedInMiddleRecyclerViewPager;
import com.iqoption.view.d.d;
import com.iqoption.view.drumview.recyclerviewpager.ScrolledToPositionInZoneLinearLayoutManager;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: ChartTypeToolsFragment */
public class aj extends b {
    public static final String TAG = "com.iqoption.fragment.aj";
    private LinearLayout aOX;
    private SwitchCompat axp;
    private View coi;
    private View coj;
    private View cok;
    private View col;
    private View com;
    private View con;
    private View coo;
    private View cop;
    private SwitchCompat coq;
    private View cor;
    private View cos;
    private ClippedInMiddleRecyclerViewPager cot;
    private s cou;
    private ClippedInMiddleRecyclerViewPager cov;
    private s cow;
    private OnCheckedChangeListener cox;
    private int coy = -1;

    private boolean ey(int i) {
        return i == 1 || i == 3;
    }

    public static aj ahg() {
        return new aj();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.chart_type_tools_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g IC = a.Il().IC();
        if (IC == null) {
            aP();
            return;
        }
        final h IX = IC.IX();
        view.findViewById(R.id.everything).setOnClickListener(new ak(this));
        this.aOX = (LinearLayout) view.findViewById(R.id.mainContent);
        this.com = view.findViewById(R.id.contentLayout);
        this.aOX.setLayoutTransition(bg.aGE());
        this.coq = (SwitchCompat) view.findViewById(R.id.switchAutoScalling);
        this.coi = view.findViewById(R.id.zoneChart);
        this.coj = view.findViewById(R.id.linerChart);
        this.cok = view.findViewById(R.id.candleChart);
        this.col = view.findViewById(R.id.barChart);
        this.coi.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g IC = a.Il().IC();
                if (IC != null) {
                    IC.setChartType(0);
                    aj.this.ex(0);
                    aj.this.e(false, IX.apC);
                    aj.this.ahi();
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "chart_chart-type-changed").setValue(Double.valueOf(0.0d)).build());
                }
            }
        });
        this.coj.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g IC = a.Il().IC();
                if (IC != null) {
                    IC.setChartType(2);
                    aj.this.ex(2);
                    aj.this.e(false, IX.apC);
                    aj.this.ahi();
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "chart_chart-type-changed").setValue(Double.valueOf(1.0d)).build());
                    ae.h(aj.this.getContext(), 32);
                }
            }
        });
        this.cok.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g IC = a.Il().IC();
                if (IC != null) {
                    IC.setChartType(1);
                    aj.this.ex(1);
                    aj.this.e(true, IX.apC);
                    aj.this.ahi();
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "chart_chart-type-changed").setValue(Double.valueOf(2.0d)).build());
                    ae.h(aj.this.getContext(), 32);
                }
            }
        });
        this.col.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g IC = a.Il().IC();
                if (IC != null) {
                    IC.setChartType(3);
                    aj.this.ex(3);
                    aj.this.e(true, IX.apC);
                    aj.this.ahi();
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "chart_chart-type-changed").setValue(Double.valueOf(3.0d)).build());
                    ae.h(aj.this.getContext(), 32);
                }
            }
        });
        this.con = view.findViewById(R.id.colorCandleContainer);
        this.coo = this.con.findViewById(R.id.grayCandle);
        this.cop = this.con.findViewById(R.id.colorCandle);
        this.coo.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                aj.this.d(true, false);
            }
        });
        this.cop.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                aj.this.d(false, false);
            }
        });
        int ef = ef(R.dimen.dp43);
        this.cot = (ClippedInMiddleRecyclerViewPager) view.findViewById(R.id.timerIntervalList);
        boolean z = false;
        this.cot.t(ef, false);
        this.cov = (ClippedInMiddleRecyclerViewPager) view.findViewById(R.id.timerIntervalListWhite);
        this.cov.t(ef, true);
        LayoutManager scrolledToPositionInZoneLinearLayoutManager = new ScrolledToPositionInZoneLinearLayoutManager(getContext(), 0);
        LayoutManager scrolledToPositionInZoneLinearLayoutManager2 = new ScrolledToPositionInZoneLinearLayoutManager(getContext(), 0);
        this.cot.setLayoutManager(scrolledToPositionInZoneLinearLayoutManager);
        this.cov.setLayoutManager(scrolledToPositionInZoneLinearLayoutManager2);
        ef *= 2;
        this.cot.addItemDecoration(new com.iqoption.widget.g(ef, true, true));
        this.cov.addItemDecoration(new com.iqoption.widget.g(ef, true, true));
        this.cou = new s(getContext(), ContextCompat.getColor(getContext(), R.color.orange), true, new com.iqoption.a.b.a() {
            public void a(View view, int i) {
                aj.this.cot.smoothScrollToPosition(aj.this.cot.aD(i, aj.this.cou.getItemCount()));
            }
        });
        this.cou.setHasStableIds(true);
        this.cow = new s(getContext(), ContextCompat.getColor(getContext(), R.color.white), false, null);
        this.cow.setHasStableIds(true);
        this.cot.setAdapter(this.cou);
        this.cov.setAdapter(this.cow);
        this.cot.a(new al(this));
        this.cot.addOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                aj.this.cov.scrollBy(i, i2);
            }
        });
        this.axp = (SwitchCompat) view.findViewById(R.id.switchHeikenAshi);
        this.axp.setChecked(IX.apB);
        ((LinearLayout) view.findViewById(R.id.heikenAshiContainer)).setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                boolean isChecked = aj.this.axp.isChecked() ^ 1;
                g IC = a.Il().IC();
                if (IC != null) {
                    IC.bC(isChecked);
                    aj.this.axp.setChecked(isChecked);
                    aj.this.ahi();
                }
            }
        });
        this.cos = view.findViewById(R.id.infoTextHeikenAshi);
        this.cor = view.findViewById(R.id.infoIconHeikenAshi);
        this.cor.setOnTouchListener(new d());
        this.cor.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                boolean isSelected = aj.this.cor.isSelected() ^ 1;
                aj.this.cor.setSelected(isSelected);
                aj.this.cos.setVisibility(isSelected ? 0 : 8);
            }
        });
        if (!(IX.chartType == 0 || IX.chartType == 2)) {
            z = true;
        }
        this.cox = am.coA;
        this.coq.setOnCheckedChangeListener(this.cox);
        e(z, IX.apC);
        ex(IX.chartType);
        d(IX.apA, true);
        ez(IX.candleSize);
    }

    final /* synthetic */ void am(int i, int i2) {
        if (isAdded() && i != i2) {
            ChartTimeInterval chartTimeInterval = (ChartTimeInterval) this.cou.getItems().get(i2);
            g IC = a.Il().IC();
            if (IC != null) {
                IC.di(chartTimeInterval.value);
                ahi();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "chart_chart-scale-changed").setParameters(i.ZZ().l("instrument_type", IC.getInstrumentType()).aab()).setValue(Double.valueOf((double) chartTimeInterval.value)).build());
            }
        }
    }

    static final /* synthetic */ void c(CompoundButton compoundButton, boolean z) {
        g IC = a.Il().IC();
        if (IC != null) {
            IC.bD(z);
        }
    }

    private void d(boolean z, boolean z2) {
        g IC = a.Il().IC();
        if (!(IC == null || z2)) {
            IC.bB(z);
        }
        if (z) {
            this.coo.setSelected(true);
            this.cop.setSelected(false);
            return;
        }
        this.coo.setSelected(false);
        this.cop.setSelected(true);
    }

    private void ex(int i) {
        this.coi.setSelected(false);
        this.coj.setSelected(false);
        this.cok.setSelected(false);
        this.col.setSelected(false);
        this.con.setVisibility(8);
        int cP = cP(ey(i));
        switch (i) {
            case 0:
                this.coi.setSelected(true);
                break;
            case 1:
                this.cok.setSelected(true);
                this.con.setVisibility(0);
                break;
            case 2:
                this.coj.setSelected(true);
                break;
            case 3:
                this.col.setSelected(true);
                break;
        }
        this.cou.cy(cP);
        this.cow.cy(cP);
        this.cot.setMinPosition(cP);
        this.cou.notifyItemRangeChanged(0, cP);
        this.cow.notifyItemRangeChanged(0, cP);
    }

    private int cP(boolean z) {
        int ahh = ahh();
        return (ahh == 0 && z) ? ahh + 1 : ahh;
    }

    private int ahh() {
        if (this.coy == -1) {
            this.coy = 0;
            int It = a.Il().It();
            for (ChartTimeInterval chartTimeInterval : this.cow.getItems()) {
                if (!com.iqoption.app.managers.a.Gf().a(Integer.valueOf(It), chartTimeInterval.value)) {
                    this.coy++;
                }
            }
        }
        return this.coy;
    }

    public void ahi() {
        cr ajW = ajW();
        if (ajW != null) {
            ajW.ahZ();
        }
    }

    private void ez(int i) {
        if (this.cot != null && this.cou != null) {
            List items = this.cou.getItems();
            for (int i2 = 0; i2 < items.size(); i2++) {
                if (((ChartTimeInterval) items.get(i2)).value == i) {
                    this.cot.postDelayed(new an(this, i2), 50);
                    break;
                }
            }
        }
    }

    final /* synthetic */ void eA(int i) {
        this.cot.smoothScrollToPosition(this.cot.aD(i, this.cou.getItemCount()));
    }

    /* renamed from: onClose */
    public boolean aP() {
        a.Il().In();
        cr ajW = ajW();
        if (!(ajW == null || ajW.crO == null)) {
            ajW.crO.setSelected(false);
        }
        getFragmentManager().popBackStack();
        return true;
    }

    private void e(boolean z, boolean z2) {
        this.coq.setClickable(z);
        if (z) {
            this.coq.animate().alpha(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
            this.coq.setChecked(z2);
            cQ(z2);
            return;
        }
        this.coq.setChecked(true);
        this.coq.animate().alpha(0.5f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        cQ(true);
    }

    private void cQ(boolean z) {
        g IC = a.Il().IC();
        if (IC == null) {
            aP();
        } else {
            IC.bD(z);
        }
    }

    public void ND() {
        this.com.setAlpha(0.0f);
        this.aOX.setAlpha(0.0f);
        this.com.setAlpha(1.0f);
        int ef = ef(R.dimen.dp12);
        float f = (float) (-ef);
        this.aOX.setTranslationX(f);
        float f2 = (float) ef;
        this.aOX.setTranslationY(f2);
        this.com.setTranslationX(f);
        this.com.setTranslationY(f2);
        this.com.setPivotX(1.0f);
        this.com.setPivotY((float) this.com.getHeight());
        this.com.setScaleX(0.3f);
        this.com.setScaleY(0.3f);
        this.aOX.animate().alpha(1.0f).translationX(0.0f).translationY(0.0f).setDuration(250).setStartDelay(100).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        this.com.animate().scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(250).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        if (this.com != null) {
            this.com.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(250).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        }
    }
}
