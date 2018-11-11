package com.iqoption.kyc.fragment.f;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.iqoption.d.nz;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.x.R;

/* compiled from: KycReportableErrorFragment */
public class a extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.f.a";
    private OnBackStackChangedListener cKO;
    private a cNx;
    private nz cNy;
    private boolean cNz;

    /* compiled from: KycReportableErrorFragment */
    public interface a {
        void apo();

        void app();
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "USRestricted";
    }

    public boolean apT() {
        return false;
    }

    public static a ea(boolean z) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_IS_BLOCK", z);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.cNz = getArguments().getBoolean("ARG_IS_BLOCK");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cNy = (nz) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_reportable_error, viewGroup, false);
        setHasOptionsMenu(this.cNz);
        this.cNy.byI.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.cNx.apo();
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cNA;

            protected void apV() {
                super.apV();
                this.cNA.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cNy.getRoot();
    }

    private void apX() {
        if (this.cNz) {
            i.b((AppCompatActivity) zzakw(), this.cNy.bxz.toolbar);
        } else {
            i.a((AppCompatActivity) zzakw(), this.cNy.bxz.toolbar);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.cNz) {
            menuInflater.inflate(R.menu.kyc_made_mistake_menu, menu);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_made_mistake) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.cNx.app();
        return true;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cNx = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cNx = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
