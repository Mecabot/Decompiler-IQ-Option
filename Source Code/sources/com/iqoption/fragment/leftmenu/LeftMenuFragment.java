package com.iqoption.fragment.leftmenu;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.b.e;
import com.iqoption.core.i;
import com.iqoption.d.xu;
import com.iqoption.fragment.base.f;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.system.a.d;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

public class LeftMenuFragment extends f implements com.iqoption.fragment.leftmenu.i.a {
    private static final String TAG = "com.iqoption.fragment.leftmenu.LeftMenuFragment";
    private com.iqoption.fragment.leftmenu.b.b cCA = new com.iqoption.fragment.leftmenu.b.b() {
        public void b(com.iqoption.fragment.leftmenu.content.a aVar) {
            String iK = LeftMenuFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("left menu item click ");
            stringBuilder.append(aVar);
            i.d(iK, stringBuilder.toString());
            if (LeftMenuFragment.this.cCu != null) {
                LeftMenuFragment.this.cCu.a(aVar);
            }
        }
    };
    @Nullable
    private b cCu;
    @Nullable
    private b cCv;
    public xu cCw;
    private final a cCx = new a(this, null);
    @NonNull
    private LeftMenuViewModel cCy;
    @Nullable
    private StatusType cCz;

    public interface b {
        void a(com.iqoption.fragment.leftmenu.content.a aVar);
    }

    private class a extends d {
        private a() {
        }

        /* synthetic */ a(LeftMenuFragment leftMenuFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        @e
        public void onMenuIsUpdated(com.iqoption.fragment.leftmenu.e.a aVar) {
            i.d(LeftMenuFragment.TAG, "event=MenuStateIsUpdated");
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    LeftMenuFragment.this.alG();
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cCy = LeftMenuViewModel.k(zzakw());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cCw = (xu) DataBindingUtil.inflate(layoutInflater, R.layout.left_menu_item_list, viewGroup, false);
        this.cCw.axw.setHasFixedSize(true);
        RecyclerView recyclerView = this.cCw.axw;
        Adapter bVar = new b(this.cCA, this);
        this.cCv = bVar;
        recyclerView.setAdapter(bVar);
        this.cCv.aF(alH());
        this.cCx.register();
        return this.cCw.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(this.cCy.alO().a(new f(this), g.cpR));
    }

    public void onDestroyView() {
        this.cCx.unregister();
        super.onDestroyView();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.cCu = (b) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cCu = null;
    }

    public void alE() {
        alG();
    }

    public void alF() {
        this.cCz = null;
        this.cCy.alP();
        alG();
    }

    private void alG() {
        if (this.cCv != null) {
            this.cCv.aF(alH());
        }
    }

    @NonNull
    private List<com.iqoption.fragment.leftmenu.content.a> alH() {
        List<com.iqoption.fragment.leftmenu.content.a> arrayList = new ArrayList();
        if (this.cCz != null) {
            arrayList.add(new com.iqoption.fragment.leftmenu.content.e(this.cCz));
        }
        return arrayList;
    }
}
