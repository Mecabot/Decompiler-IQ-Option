package com.iqoption.kyc.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.n;
import com.google.common.util.concurrent.s;
import com.iqoption.d.mb;
import com.iqoption.dto.Event.Builder;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ag;
import com.iqoption.x.R;

/* compiled from: KycBlockFragment */
public class a extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.a";
    private boolean cKA;
    private d cKB;
    private boolean cKq;
    private a cKy;
    private mb cKz;

    /* compiled from: KycBlockFragment */
    public interface a {
        void apN();

        s<?> apO();
    }

    /* compiled from: KycBlockFragment */
    private static class b extends com.iqoption.system.c.b<a, Object> {
        public b(a aVar) {
            super(aVar, Object.class);
        }

        /* renamed from: a */
        public void z(a aVar, Object obj) {
            super.z(aVar, obj);
            aVar.dK(false);
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            super.c(aVar, th);
            aVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "TraderoomBlocked";
    }

    @NonNull
    public String apS() {
        return "kyc_traderoom-blocked";
    }

    public boolean apT() {
        return false;
    }

    public static a dT(boolean z) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_SHOW_BACK", z);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cKq = bundle.getBoolean("ARG_SHOW_BACK");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cKz = (mb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_block, viewGroup, false);
        setHasOptionsMenu(true);
        this.cKz.bxI.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                a.this.dK(true);
                ag.b(a.this.cKy.apO(), new b(a.this));
            }
        });
        apX();
        this.cKB = new d(this, getContext(), com.iqoption.kyc.a.a.apQ(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cKC;

            protected void apV() {
                super.apV();
                this.cKC.apX();
            }
        };
        this.cKB.b(new n<Builder>() {
            /* renamed from: apY */
            public Builder get() {
                return com.iqoption.kyc.a.a.apQ();
            }
        });
        getFragmentManager().addOnBackStackChangedListener(this.cKB);
        return this.cKz.getRoot();
    }

    public void onStop() {
        super.onStop();
        if (this.cKB != null) {
            this.cKB.apU();
        }
    }

    private void apX() {
        if (this.cKq) {
            i.a((AppCompatActivity) zzakw(), this.cKz.bxz.toolbar);
        } else {
            i.b((AppCompatActivity) zzakw());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.kyc_block_contact_support_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.kyc_block_action_contact_support || this.cKA) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.cKy.apN();
        return true;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cKy = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cKy = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKB);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.cKA = z;
        this.cKz.bxI.f(z, false);
    }
}
