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
import com.iqoption.d.mh;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycCysecFragment */
public class b extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.b";
    @Nullable
    private am adG;
    private boolean cJZ;
    private d cKB;
    private a cKD;
    private mh cKE;
    private boolean cKF;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && b.this.isAdded() && ac.c(b.this.getFragmentManager(), b.TAG)) {
                am.n(b.this.zzakw());
            }
        }
    };
    private boolean isInProgress;

    /* compiled from: KycCysecFragment */
    public interface a {
        s<?> apF();

        void apG();
    }

    /* compiled from: KycCysecFragment */
    private static class b extends com.iqoption.system.c.b<b, Object> {
        b(b bVar) {
            super((Object) bVar);
        }

        /* renamed from: a */
        public void z(b bVar, Object obj) {
            super.z(bVar, obj);
            bVar.dK(false);
        }

        /* renamed from: a */
        public void c(b bVar, Throwable th) {
            super.c(bVar, th);
            bVar.dK(false);
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

    public static b dU(boolean z) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_IS_HIDE_SKIP", z);
        bVar.setArguments(bundle);
        return bVar;
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
        this.cKE = (mh) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_cysec, viewGroup, false);
        this.cKE.bxH.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                b.this.dK(true);
                o.a(b.this.cKD.apF(), new b(b.this), com.iqoption.core.d.a.aSe);
            }
        });
        apX();
        this.cKB = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ b cKH;

            protected void apV() {
                super.apV();
                this.cKH.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKB);
        this.adG = new am(zzakw());
        return this.cKE.getRoot();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (!this.cJZ) {
            menuInflater.inflate(R.menu.kyc_continue_later_cysec_menu, menu);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_continue_later_cysec);
        if (findItem != null) {
            boolean z = false;
            if (this.cKF) {
                findItem.setVisible(false);
                return;
            }
            if (!this.isInProgress && ac.c(getFragmentManager(), TAG)) {
                z = true;
            }
            findItem.setVisible(z);
            this.cKF = z ^ 1;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!ac.c(getFragmentManager(), TAG) || menuItem.getItemId() != R.id.action_continue_later_cysec || this.isInProgress) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.cKD.apG();
        return true;
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw(), this.cKE.bxz.toolbar);
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
            this.cKD = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cKD = null;
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
        this.cKE.bxH.f(z, false);
        zzakw().invalidateOptionsMenu();
    }
}
