package com.iqoption.trading.history.fragment.a;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.d.be;
import com.iqoption.d.vt;
import com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel;

/* compiled from: InstrumentTypeBottomSheet */
public final class e extends com.iqoption.fragment.base.a {
    private be dtI;
    private InstrumentTypeViewModel dtN;

    /* compiled from: InstrumentTypeBottomSheet */
    private final class a extends Adapter<b> {
        private a() {
        }

        /* renamed from: Z */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(vt.J(LayoutInflater.from(e.this.getContext()), viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            bVar.b((com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel.b) e.this.dtN.getItems().get(i));
        }

        public int getItemCount() {
            return e.this.dtN.getItems().size();
        }
    }

    /* compiled from: InstrumentTypeBottomSheet */
    private final class b extends ViewHolder implements OnClickListener {
        private final vt dtP;

        b(vt vtVar) {
            super(vtVar.getRoot());
            this.dtP = vtVar;
            this.itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (getAdapterPosition() != -1) {
                com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel.b bVar = (com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel.b) u.h(e.this.dtN.getItems(), getAdapterPosition());
                if (bVar != null) {
                    e.this.dtN.c(bVar);
                }
                e.this.onClose();
            }
        }

        void b(com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel.b bVar) {
            this.dtP.blr.setText(bVar.aFh());
        }
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("InstrumentTypeBottomSheet") == null) {
            fragmentManager.beginTransaction().add(i, new e(), "InstrumentTypeBottomSheet").addToBackStack("InstrumentTypeBottomSheet").commit();
        }
    }

    protected View aeO() {
        return this.dtI.axw;
    }

    protected View aeP() {
        return this.dtI.blp;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dtI = be.a(layoutInflater, viewGroup, false);
        this.dtN = InstrumentTypeViewModel.C(zzakw());
        this.dtI.axw.setHasFixedSize(true);
        this.dtI.axw.setAdapter(new a());
        return this.dtI.getRoot();
    }
}
