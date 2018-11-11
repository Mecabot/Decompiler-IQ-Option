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
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.of;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycStartNonRegulatedFragment */
public class c extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.c";
    @Nullable
    private am adG;
    private boolean cJZ;
    private d cKB;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && c.this.isAdded() && ac.c(c.this.getFragmentManager(), c.TAG)) {
                am.n(c.this.zzakw());
            }
        }
    };
    private a cKI;
    private of cKJ;
    private boolean isInProgress;

    /* compiled from: KycStartNonRegulatedFragment */
    public interface a {
        s<?> apH();

        void apI();
    }

    /* compiled from: KycStartNonRegulatedFragment */
    private static class b extends com.iqoption.system.c.b<c, Object> {
        b(c cVar) {
            super((Object) cVar);
        }

        /* renamed from: a */
        public void z(c cVar, Object obj) {
            super.z(cVar, obj);
            cVar.dK(false);
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            super.c(cVar, th);
            cVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "Welcome";
    }

    @NonNull
    public String apS() {
        return "VerifyAccountAfterSignUp";
    }

    public boolean apT() {
        return true;
    }

    public static c dV(boolean z) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_IS_HIDE_SKIP", z);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJZ = bundle.getBoolean("ARG_IS_HIDE_SKIP");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(this.cJZ ^ 1);
        this.cKJ = (of) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_start_non_regulated, viewGroup, false);
        this.cKJ.bxH.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                c.this.dK(true);
                o.a(c.this.cKI.apH(), new b(c.this), com.iqoption.core.d.a.aSe);
            }
        });
        apX();
        this.cKB = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new com.iqoption.kyc.c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ c cKK;

            protected void apV() {
                super.apV();
                this.cKK.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKB);
        this.adG = new am(zzakw());
        return this.cKJ.getRoot();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (!this.cJZ) {
            menuInflater.inflate(R.menu.kyc_continue_later_start_non_regulated_menu, menu);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_continue_later_start_non_regulated);
        if (findItem != null) {
            boolean z = !this.isInProgress && ac.c(getFragmentManager(), TAG);
            findItem.setVisible(z);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!ac.c(getFragmentManager(), TAG) || menuItem.getItemId() != R.id.action_continue_later_start_non_regulated || this.isInProgress) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.cKI.apI();
        return true;
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw(), this.cKJ.bxz.toolbar);
        zzakw().invalidateOptionsMenu();
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cKI = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cKI = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        if (this.cKB != null) {
            this.cKB.apU();
        }
        getFragmentManager().removeOnBackStackChangedListener(this.cKB);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.isInProgress = z;
        this.cKJ.bxH.f(z, false);
        if (z) {
            zzakw().invalidateOptionsMenu();
        }
    }
}
