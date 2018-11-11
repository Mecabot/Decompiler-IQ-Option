package com.iqoption.trading.history.fragment.a;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.iqoption.d.be;
import com.iqoption.d.bg;
import com.iqoption.dto.Balance;
import com.iqoption.x.R;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: BalanceBottomSheet */
public final class a extends com.iqoption.fragment.base.a {
    private final Comparator<Balance> agu = b.$instance;
    private final j<Balance> agv = c.$instance;
    private final j<Balance> agw = d.$instance;
    private ImmutableList<b> dam;
    private be dtI;

    /* compiled from: BalanceBottomSheet */
    private static final class b {
        private Long balanceId;
        @StringRes
        private int dtK;
        private String dtL;

        public b(@StringRes int i, long j) {
            this.dtK = i;
            this.balanceId = Long.valueOf(j);
        }

        public b(String str, long j) {
            this.dtL = str;
            this.balanceId = Long.valueOf(j);
        }
    }

    /* compiled from: BalanceBottomSheet */
    private final class a extends Adapter<c> {
        private a() {
        }

        /* renamed from: Y */
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c(bg.b(LayoutInflater.from(a.this.getContext()), viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(c cVar, int i) {
            cVar.d((b) a.this.dam.get(i));
        }

        public int getItemCount() {
            return a.this.dam.size();
        }
    }

    /* compiled from: BalanceBottomSheet */
    private final class c extends ViewHolder implements OnClickListener {
        private final bg dtM;

        c(bg bgVar) {
            super(bgVar.getRoot());
            this.dtM = bgVar;
            this.itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (getAdapterPosition() != -1) {
                b bVar = (b) a.this.dam.get(getAdapterPosition());
                FragmentActivity activity = a.this.zzakw();
                if (!(bVar == null || activity == null || !(activity instanceof f))) {
                    ((f) activity).C(bVar.balanceId);
                }
                a.this.onClose();
            }
        }

        void d(b bVar) {
            if (TextUtils.isEmpty(bVar.dtL)) {
                this.dtM.blr.setText(bVar.dtK);
            } else {
                this.dtM.blr.setText(bVar.dtL);
            }
        }
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("BalanceBottomSheet") == null) {
            fragmentManager.beginTransaction().add(i, new a(), "BalanceBottomSheet").addToBackStack("BalanceBottomSheet").commit();
        }
    }

    protected View aeO() {
        return this.dtI.axw;
    }

    protected View aeP() {
        return this.dtI.blp;
    }

    static final /* synthetic */ int b(Balance balance, Balance balance2) {
        int balanceType = Balance.getBalanceType(balance);
        int balanceType2 = Balance.getBalanceType(balance2);
        if (balanceType == 2) {
            balanceType = 99;
        }
        Integer valueOf = Integer.valueOf(balanceType);
        if (balanceType2 == 2) {
            balanceType2 = 99;
        }
        return valueOf.compareTo(Integer.valueOf(balanceType2));
    }

    static final /* synthetic */ boolean e(Balance balance) {
        return Balance.getBalanceType(balance) != 5;
    }

    static final /* synthetic */ boolean d(Balance balance) {
        return Balance.getBalanceType(balance) == 4;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dtI = be.a(layoutInflater, viewGroup, false);
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        boolean ff = com.iqoption.app.managers.feature.b.HT().ff("show-crypto-balances");
        i c = i.c(aL.Cz().values());
        if (aL.CZ()) {
            c = c.c(this.agw);
        }
        if (!ff) {
            c = c.c(this.agv);
        }
        ImmutableList a = c.a(this.agu);
        com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
        Iterator sI = a.iterator();
        while (sI.hasNext()) {
            Balance balance = (Balance) sI.next();
            if (balance.id != null) {
                int balanceType = Balance.getBalanceType(balance);
                if (balanceType != 4) {
                    switch (balanceType) {
                        case 1:
                            sO.ae(new b((int) R.string.real_balance, balance.id.longValue()));
                            break;
                        case 2:
                            if (!TextUtils.isEmpty(balance.tournamentName) && !balance.tournamentName.equalsIgnoreCase("null")) {
                                sO.ae(new b(balance.tournamentName, balance.id.longValue()));
                                break;
                            }
                            sO.ae(new b((int) R.string.tournament, balance.id.longValue()));
                            break;
                        default:
                            break;
                    }
                }
                sO.ae(new b((int) R.string.practice, balance.id.longValue()));
            }
        }
        this.dam = sO.sP();
        this.dtI.axw.setHasFixedSize(true);
        this.dtI.axw.setAdapter(new a());
        return this.dtI.getRoot();
    }
}
