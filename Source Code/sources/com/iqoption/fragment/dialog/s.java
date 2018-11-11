package com.iqoption.fragment.dialog;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.JsonObject;
import com.iqoption.analytics.h;
import com.iqoption.app.managers.r;
import com.iqoption.core.util.i.b;
import com.iqoption.d.ix;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.fragment.base.i;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.l;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/* compiled from: OtnEmissionStatisticsDialog */
public final class s extends i {
    private static final String TAG = "com.iqoption.fragment.dialog.s";
    private double aVl;
    private r cAI;
    private String cAJ;
    private String cAK;
    private ix cAL;
    private r cAM;
    private Double cAN;
    private Double cAO;
    private BigDecimal cAP;
    private BigDecimal cAQ;
    private DecimalFormat crm;

    /* compiled from: OtnEmissionStatisticsDialog */
    private static class a {
        private final double cAS;
        private final double cAT;
        private final double cAU;

        public a(double d, double d2, double d3) {
            this.cAS = d;
            this.cAT = d2;
            this.cAU = d3;
        }

        private Bundle toBundle() {
            return new g().e("arg.totalCommission", this.cAS).e("arg.yourCommission", this.cAT).e("arg.otnAmount", this.cAU).toBundle();
        }
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager) {
        a(i, fragmentManager, null);
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, double d, double d2, double d3) {
        a(i, fragmentManager, new a(d, d2, d3));
    }

    private static void a(@IdRes int i, FragmentManager fragmentManager, @Nullable a aVar) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            fragmentManager.beginTransaction().add(i, a(aVar), TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(TAG).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private static s a(@Nullable a aVar) {
        if (aVar == null) {
            return new s();
        }
        s sVar = new s();
        sVar.setArguments(aVar.toBundle());
        return sVar;
    }

    public String gF() {
        return this.cAM.gF();
    }

    public JsonObject ajZ() {
        return b.aaa().l("total_com_paid", this.cAN).l("your_com", this.cAO).l("tokens_to_distr", this.cAP).l("you_receive", this.cAQ).aab();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cAI = r.GT();
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        this.cAJ = Cw.CD();
        this.aVl = l.c(Cw.CF()).doubleValue();
        this.crm = l.aGc();
        ConversionCurrency eh = Cw.eh(Currencies.OTN_CURRENCY);
        if (eh == null) {
            com.iqoption.core.i.w(TAG, "OTN currency is null");
            onClose();
            return null;
        }
        this.cAK = eh.mask;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cAL = ix.x(layoutInflater, viewGroup, false);
        this.cAL.bjl.setLayoutTransition(bg.aGE());
        this.cAL.bsZ.setLayoutTransition(bg.aGE());
        this.cAI.Hm().size();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cAM = new u(this, arguments);
        } else {
            this.cAM = new t(this);
        }
        this.cAL.agA.setText(this.cAM.getTitle());
        this.cAN = this.cAM.ale();
        if (this.cAN != null) {
            this.cAL.bsV.setText(l.e(this.cAJ, l.d(this.cAN, Double.valueOf(this.aVl))));
        }
        this.cAO = this.cAM.alf();
        if (this.cAO != null) {
            this.cAL.bta.setText(l.e(this.cAJ, l.d(this.cAO, Double.valueOf(this.aVl))));
        }
        this.cAL.bsS.setText(this.cAM.ald());
        this.cAP = this.cAM.alg();
        if (this.cAP != null) {
            this.cAL.bsU.setText(l.a(this.cAK, Double.valueOf(this.cAP.doubleValue()), this.crm));
        }
        this.cAQ = this.cAM.alh();
        if (this.cAQ != null) {
            this.cAL.bsX.setText(l.a(this.cAK, Double.valueOf(this.cAQ.doubleValue()), this.crm));
        }
        this.cAL.blw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                s.this.onClose();
            }
        });
        this.cAL.bsP.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                h.a(s.c(view, s.this.cAL.bsW), "total_com_paid");
            }
        });
        this.cAL.bsR.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                h.a(s.c(view, s.this.cAL.btb), "your_com");
            }
        });
        this.cAL.bsO.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                h.a(s.c(view, s.this.cAL.bsT), "tokens_to_distr");
            }
        });
        this.cAL.bsQ.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                h.a(s.c(view, s.this.cAL.bsY), "you_receive");
            }
        });
        return this.cAL.getRoot();
    }

    private static boolean c(View view, View view2) {
        boolean isSelected = view.isSelected();
        if (isSelected) {
            view2.setVisibility(8);
        } else {
            view2.setVisibility(0);
        }
        view.setSelected(isSelected ^ 1);
        return isSelected;
    }
}
