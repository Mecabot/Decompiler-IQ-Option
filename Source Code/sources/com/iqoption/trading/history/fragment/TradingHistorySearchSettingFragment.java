package com.iqoption.trading.history.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.e;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.iqoption.d.sv;
import com.iqoption.dto.Balance;
import com.iqoption.fragment.base.f;
import com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel;
import com.iqoption.trading.history.fragment.viewmodel.a;
import com.iqoption.trading.history.fragment.viewmodel.b;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TradingHistorySearchSettingFragment extends f implements com.iqoption.trading.history.fragment.a.f, a, b {
    private Set<Integer> dtA;
    private InstrumentTypeViewModel.b dtB;
    private long dtC;
    private com.iqoption.view.materialcalendar.b dtD;
    private com.iqoption.view.materialcalendar.b dtE;
    private InstrumentTypeViewModel dtF;
    private Map<Integer, Pair<com.iqoption.view.materialcalendar.b, com.iqoption.view.materialcalendar.b>> dtv;
    private sv dtz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtF = InstrumentTypeViewModel.C(zzakw());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dtz = (sv) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_trading_history_search_setting, viewGroup, false);
        this.dtC = ((Long) e.h(com.iqoption.app.a.Cw().getBalanceId(), Long.valueOf(-1))).longValue();
        this.dtF.aFg().observe(this, new q(this));
        this.dtA = Sets.uI();
        this.dtv = m.aEY();
        Pair pair = (Pair) this.dtv.get(Integer.valueOf(R.id.lastSevenDay));
        this.dtD = (com.iqoption.view.materialcalendar.b) pair.first;
        this.dtE = (com.iqoption.view.materialcalendar.b) pair.second;
        this.dtz.biw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                TradingHistorySearchSettingFragment.this.aEZ();
            }
        });
        this.dtz.bEq.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                com.iqoption.trading.history.fragment.a.e.a(R.id.stackFrame, TradingHistorySearchSettingFragment.this.getFragmentManager());
            }
        });
        this.dtz.bEk.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                com.iqoption.trading.history.fragment.a.a.a(R.id.stackFrame, TradingHistorySearchSettingFragment.this.getFragmentManager());
            }
        });
        this.dtz.bEm.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g.a(R.id.stackFrame, TradingHistorySearchSettingFragment.this.getFragmentManager(), TradingHistorySearchSettingFragment.this.dtB.Jk(), Ints.s(TradingHistorySearchSettingFragment.this.dtA));
            }
        });
        this.dtz.bEo.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                m.a(R.id.stackFrame, TradingHistorySearchSettingFragment.this.getFragmentManager(), TradingHistorySearchSettingFragment.this.dtD, TradingHistorySearchSettingFragment.this.dtE);
            }
        });
        this.dtz.bEs.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                c.a(R.id.stackFrame, TradingHistorySearchSettingFragment.this.getFragmentManager(), TradingHistorySearchSettingFragment.this.dtC, TradingHistorySearchSettingFragment.this.dtB.Jk(), Ints.s(TradingHistorySearchSettingFragment.this.dtA), TradingHistorySearchSettingFragment.this.aFa(), TradingHistorySearchSettingFragment.this.aFb());
            }
        });
        aFe();
        aFc();
        aFf();
        return this.dtz.getRoot();
    }

    private void aEZ() {
        ajV().onBackPressed();
    }

    private long aFa() {
        return (this.dtD == null ? com.iqoption.view.materialcalendar.b.aJd() : this.dtD).getDate().getTime() / 1000;
    }

    private long aFb() {
        long currentTimeMillis;
        com.iqoption.view.materialcalendar.b aJd = com.iqoption.view.materialcalendar.b.aJd();
        com.iqoption.view.materialcalendar.b bVar = this.dtE == null ? aJd : this.dtE;
        if (bVar.equals(aJd)) {
            currentTimeMillis = System.currentTimeMillis() - bVar.getDate().getTime();
        } else {
            currentTimeMillis = TimeUnit.DAYS.toMillis(1);
        }
        return ((bVar.getDate().getTime() + currentTimeMillis) / 1000) - 1;
    }

    private void aFc() {
        com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
        StringBuilder stringBuilder = new StringBuilder();
        int size = this.dtA.size();
        if (size == 0) {
            stringBuilder.append(getString(R.string.all_assets));
        } else {
            int i = 0;
            for (Integer num : this.dtA) {
                if (i == 3) {
                    stringBuilder.append(' ');
                    stringBuilder.append('&');
                    stringBuilder.append(' ');
                    stringBuilder.append(size - 3);
                    stringBuilder.append(' ');
                    stringBuilder.append(getString(R.string.more));
                    break;
                }
                com.iqoption.core.microservices.tradingengine.response.active.a cZ = FI.cZ(num.intValue());
                if (cZ != null) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                        stringBuilder.append(' ');
                    }
                    stringBuilder.append(com.iqoption.util.e.a.s(cZ));
                }
                i++;
            }
        }
        this.dtz.bEn.setText(stringBuilder.toString());
    }

    private void aFd() {
        this.dtz.bEr.setText(this.dtB.aFh());
    }

    private void aFe() {
        Balance d = com.iqoption.app.a.Cw().d(Long.valueOf(this.dtC));
        if (d != null) {
            int balanceType = Balance.getBalanceType(d);
            if (balanceType != 4) {
                switch (balanceType) {
                    case 1:
                        this.dtz.bEl.setText(R.string.real_balance);
                        break;
                    case 2:
                        if (!TextUtils.isEmpty(d.tournamentName) && !d.tournamentName.equalsIgnoreCase("null")) {
                            this.dtz.bEl.setText(d.tournamentName);
                            break;
                        } else {
                            this.dtz.bEl.setText(R.string.tournament);
                            break;
                        }
                        break;
                }
            }
            this.dtz.bEl.setText(R.string.practice);
        }
    }

    private void aFf() {
        int intValue;
        CharSequence string;
        Pair pair = new Pair(this.dtD, this.dtE);
        for (Entry entry : this.dtv.entrySet()) {
            if (((Pair) entry.getValue()).equals(pair)) {
                intValue = ((Integer) entry.getKey()).intValue();
                break;
            }
        }
        intValue = -1;
        switch (intValue) {
            case R.id.last30days:
                string = getString(R.string.last_30_days);
                break;
            case R.id.lastSevenDay:
                string = getString(R.string.last_7_days);
                break;
            case R.id.threeMonths:
                string = getString(R.string.month_3);
                break;
            case R.id.today:
                string = getString(R.string.today);
                break;
            case R.id.yestarday:
                string = getString(R.string.yesterday);
                break;
            default:
                if (!this.dtD.equals(this.dtE)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(bf.cgq.format(this.dtD.getDate()));
                    stringBuilder.append(" - ");
                    stringBuilder.append(bf.cgq.format(this.dtE.getDate()));
                    string = stringBuilder.toString();
                    break;
                }
                string = bf.cgq.format(this.dtD.getDate());
                break;
        }
        this.dtz.bEp.setText(string);
    }

    public void i(Set<Integer> set) {
        this.dtA.clear();
        this.dtA.addAll(set);
        aFc();
    }

    public void a(com.iqoption.view.materialcalendar.b bVar, com.iqoption.view.materialcalendar.b bVar2) {
        if (bVar != null && bVar2 != null) {
            this.dtD = bVar;
            this.dtE = bVar2;
            aFf();
        }
    }

    public void C(Long l) {
        if (l != null) {
            this.dtC = l.longValue();
            aFe();
        }
    }
}
