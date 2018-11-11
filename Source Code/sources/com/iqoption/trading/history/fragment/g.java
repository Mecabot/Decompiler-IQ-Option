package com.iqoption.trading.history.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.l;
import com.iqoption.d.sx;
import com.iqoption.view.d.d;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: TradingHistorySearchSetAssetFragment */
public class g extends a {
    private com.iqoption.chat.b aIP;
    private sx dte;
    private a dtf;

    /* compiled from: TradingHistorySearchSetAssetFragment */
    private interface c {
        b b(ViewGroup viewGroup, a aVar);
    }

    /* compiled from: TradingHistorySearchSetAssetFragment */
    private static final class a extends Adapter<b> implements Filterable {
        final a dti;
        private final c dtj;
        private final Set<Integer> dtk;
        private final ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> dtl;
        private ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> dtm;
        private final a dtn;

        /* compiled from: TradingHistorySearchSetAssetFragment */
        private class a extends Filter {
            /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
                this();
            }

            private a() {
            }

            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
                if (charSequence.length() == 0) {
                    sO.f(a.this.dtl);
                } else {
                    charSequence = charSequence.toString().toLowerCase().trim();
                    Iterator sI = a.this.dtl.iterator();
                    while (sI.hasNext()) {
                        com.iqoption.core.microservices.tradingengine.response.active.a aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) sI.next();
                        if (com.iqoption.util.e.a.E(aVar).toLowerCase().trim().contains(charSequence)) {
                            sO.ae(aVar);
                        }
                    }
                }
                ImmutableList sP = sO.sP();
                filterResults.values = sP;
                filterResults.count = sP.size();
                return filterResults;
            }

            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                a.this.dtm = (ImmutableList) filterResults.values;
                a.this.notifyDataSetChanged();
            }
        }

        public Filter getFilter() {
            return null;
        }

        /* synthetic */ a(c cVar, Collection collection, AnonymousClass1 anonymousClass1) {
            this(cVar, collection);
        }

        private a(c cVar, Collection<com.iqoption.core.microservices.tradingengine.response.active.a> collection) {
            this.dti = new j(this);
            this.dtk = Sets.uI();
            this.dtn = new a(this, null);
            this.dtj = cVar;
            this.dtl = ImmutableList.m(collection);
            this.dtm = ImmutableList.m(collection);
        }

        /* renamed from: X */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.dtj.b(viewGroup, this.dti);
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            com.iqoption.core.microservices.tradingengine.response.active.a gB = gB(i);
            if (gB != null) {
                bVar.a(gB, this.dtk.contains(Integer.valueOf(gB.getActiveId())));
            }
        }

        @Nullable
        public com.iqoption.core.microservices.tradingengine.response.active.a gB(int i) {
            return (i < 0 || i >= this.dtm.size()) ? null : (com.iqoption.core.microservices.tradingengine.response.active.a) this.dtm.get(i);
        }

        public int getItemCount() {
            return this.dtm.size();
        }

        public long getItemId(int i) {
            if (gB(i) == null) {
                return 0;
            }
            return (long) f.hashCode(Integer.valueOf(gB(i).getActiveId()), gB(i).getInstrumentType());
        }

        public void n(int[] iArr) {
            if (iArr != null) {
                for (int valueOf : iArr) {
                    this.dtk.add(Integer.valueOf(valueOf));
                }
            }
        }

        public void r(int i, boolean z) {
            if (z) {
                this.dtk.add(Integer.valueOf(i));
            } else {
                this.dtk.remove(Integer.valueOf(i));
            }
        }

        public Set<Integer> aEV() {
            return this.dtk;
        }

        public void aEW() {
            this.dtk.clear();
            notifyDataSetChanged();
        }

        public void filter(CharSequence charSequence) {
            this.dtn.filter(charSequence);
        }
    }

    /* compiled from: TradingHistorySearchSetAssetFragment */
    private static final class b extends ViewHolder {
        private final TextView agA;
        private final CheckBox bNM;
        final a dti;
        private int dtq;

        /* compiled from: TradingHistorySearchSetAssetFragment */
        interface a {
            void s(int i, boolean z);
        }

        public b(View view, a aVar) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            this.bNM = (CheckBox) viewGroup.findViewById(R.id.checker);
            this.agA = (TextView) viewGroup.findViewById(R.id.title);
            this.dti = aVar;
            this.itemView.setOnClickListener(new k(this));
            this.bNM.setOnTouchListener(new d());
            this.bNM.setOnCheckedChangeListener(new l(this));
        }

        final /* synthetic */ void bP(View view) {
            this.bNM.setChecked(this.bNM.isChecked() ^ 1);
        }

        final /* synthetic */ void f(CompoundButton compoundButton, boolean z) {
            if (getAdapterPosition() != -1) {
                this.dti.s(this.dtq, z);
            }
        }

        void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, boolean z) {
            if (aVar != null) {
                this.dtq = aVar.getActiveId();
                this.agA.setText(com.iqoption.util.e.a.s(aVar));
                this.bNM.setChecked(z);
            }
        }
    }

    @NonNull
    private static g b(List<InstrumentType> list, int[] iArr) {
        g gVar = new g();
        gVar.setArguments(new com.iqoption.util.g().b("arg.option.type", InstrumentType.convertToStringArray((List) list)).a("arg.actives.ids", iArr).toBundle());
        return gVar;
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, List<InstrumentType> list, int[] iArr) {
        if (fragmentManager.findFragmentByTag("TradingHistorySearchSetAssetFragment") == null) {
            fragmentManager.beginTransaction().add(i, b(list, iArr), "TradingHistorySearchSetAssetFragment").addToBackStack("TradingHistorySearchSetAssetFragment").commit();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int[] intArray;
        InstrumentType[] convertToInstrumentTypeArray;
        this.dte = (sx) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_trading_history_set_asset, viewGroup, false);
        this.dte.biw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g.this.aN();
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            intArray = arguments.getIntArray("arg.actives.ids");
            convertToInstrumentTypeArray = InstrumentType.convertToInstrumentTypeArray(arguments.getStringArray("arg.option.type"));
        } else {
            convertToInstrumentTypeArray = null;
            intArray = convertToInstrumentTypeArray;
        }
        this.dte.bEv.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                g.this.dtf.aEW();
            }
        });
        Collection a = a(convertToInstrumentTypeArray);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        ItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line_divider_black20_1px));
        this.dte.bEu.setLayoutManager(linearLayoutManager);
        this.dte.bEu.setHasFixedSize(true);
        this.dte.bEu.addItemDecoration(dividerItemDecoration);
        this.dtf = new a(new h(this), a, null);
        this.dtf.n(intArray);
        this.dtf.setHasStableIds(true);
        this.dte.bEu.setAdapter(this.dtf);
        this.dte.bEu.addItemDecoration(new com.iqoption.widget.g(getContext().getResources().getDimensionPixelOffset(R.dimen.dp16), false, true));
        this.dte.bmJ.setSpeed(2.0f);
        this.aIP = new com.iqoption.chat.c(this.dte.bmJ, new float[]{0.0f, 0.5f, 1.0f});
        this.dte.bmJ.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (g.this.dte.bjX.length() == 0 && g.this.dte.bjX.isFocused()) {
                    g.this.dte.bEu.requestFocus();
                    g.this.bO(g.this.dte.bjX);
                } else if (g.this.dte.bjX.length() != 0 || g.this.dte.bjX.isFocused()) {
                    g.this.dte.bjX.setText(null);
                } else {
                    g.this.dte.bjX.requestFocus();
                }
            }
        });
        final com.iqoption.videoeducation.c cVar = new com.iqoption.videoeducation.c(new i(this));
        this.dte.bjX.addTextChangedListener(new x() {
            private String aIV;

            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                Object obj = editable.toString();
                if (this.aIV == null || !TextUtils.equals(this.aIV, obj)) {
                    cVar.a(editable, 150);
                    this.aIV = obj;
                }
            }
        });
        this.dte.bjX.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    if (g.this.aIP.Ou()) {
                        g.this.aIP.Os();
                    } else {
                        g.this.aIP.Or();
                    }
                } else if (g.this.aIP.Ot()) {
                    g.this.aIP.Or();
                } else {
                    g.this.aIP.Os();
                }
            }
        });
        return this.dte.getRoot();
    }

    final /* synthetic */ b a(ViewGroup viewGroup, a aVar) {
        return new b(LayoutInflater.from(getContext()).inflate(R.layout.search_active_list_item, viewGroup, false), aVar);
    }

    final /* synthetic */ void A(CharSequence charSequence) {
        this.dtf.filter(charSequence);
    }

    protected View aeO() {
        return this.dte.getRoot();
    }

    protected View aeP() {
        FragmentActivity activity = zzakw();
        return activity instanceof com.iqoption.trading.history.fragment.a.a ? ((com.iqoption.trading.history.fragment.a.a) activity).aeP() : null;
    }

    public boolean onClose() {
        com.iqoption.activity.b ajV = ajV();
        if (ajV != null && ajV.zN()) {
            bO(this.dte.bjX);
        } else if ((ajV instanceof com.iqoption.trading.history.fragment.viewmodel.a) && this.dtf != null) {
            ((com.iqoption.trading.history.fragment.viewmodel.a) ajV).i(this.dtf.aEV());
        }
        return super.onClose();
    }

    private Collection<com.iqoption.core.microservices.tradingengine.response.active.a> a(@Nullable InstrumentType[] instrumentTypeArr) {
        com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
        Object hashMap = new HashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(null));
        if (instrumentTypeArr != null) {
            for (InstrumentType c : instrumentTypeArr) {
                l.a(hashMap, FI.c(c), FI.alE);
            }
        }
        return hashMap.values();
    }
}
