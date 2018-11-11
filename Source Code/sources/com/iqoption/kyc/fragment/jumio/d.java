package com.iqoption.kyc.fragment.jumio;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.mn;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycDocumentsIntroFragment */
public class d extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.d";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && d.this.isAdded() && ac.c(d.this.getFragmentManager(), d.TAG)) {
                am.n(d.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private a cLm;
    private mn cLn;
    private boolean isInProgress;

    /* compiled from: KycDocumentsIntroFragment */
    public interface a {
        s<?> apu();

        s<?> apv();
    }

    /* compiled from: KycDocumentsIntroFragment */
    private static class b extends com.iqoption.system.c.b<d, Object> {
        public b(d dVar) {
            super(dVar, Object.class);
        }

        /* renamed from: a */
        public void z(d dVar, Object obj) {
            super.z(dVar, obj);
            dVar.dK(false);
        }

        /* renamed from: a */
        public void c(d dVar, Throwable th) {
            super.c(dVar, th);
            dVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "IdentityProving";
    }

    @NonNull
    public String apS() {
        return "IdentityProvingWelcome";
    }

    public boolean apT() {
        return true;
    }

    public static d aqh() {
        return new d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu((((Integer) com.iqoption.app.a.aL(getContext()).akx.getValue()).intValue() == 0 ? 1 : 0) ^ true);
        this.cLn = (mn) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_documents_intro, viewGroup, false);
        this.cLn.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                d.this.dK(true);
                o.a(d.this.cLm.apu(), new b(d.this));
            }
        });
        apX();
        this.cKO = new com.iqoption.kyc.a.d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ d cLo;

            protected void apV() {
                super.apV();
                this.cLo.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cLn.getRoot();
    }

    private void dK(boolean z) {
        this.isInProgress = z;
        this.cLn.bxH.f(z, false);
        zzakw().invalidateOptionsMenu();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.kyc_continue_later_documents_intro_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!ac.c(getFragmentManager(), TAG) || menuItem.getItemId() != R.id.action_continue_later_documents_intro) {
            return super.onOptionsItemSelected(menuItem);
        }
        dK(true);
        o.a(this.cLm.apv(), new b(this));
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_continue_later_documents_intro);
        if (findItem != null) {
            findItem.setEnabled(this.isInProgress ^ 1);
            findItem.setVisible(ac.c(getFragmentManager(), TAG));
        }
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cLn.bxz.toolbar);
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
            this.cLm = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLm = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
