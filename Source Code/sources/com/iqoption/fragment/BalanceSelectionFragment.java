package com.iqoption.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.iqoption.d.lj;
import com.iqoption.fragment.base.i;
import com.iqoption.util.bg;
import com.iqoption.x.R;

public class BalanceSelectionFragment extends i {
    public static final String TAG = "com.iqoption.fragment.BalanceSelectionFragment";
    private lj coa;
    private SelectedBalance cob = SelectedBalance.none;

    public enum SelectedBalance {
        none,
        practice,
        real
    }

    public String gF() {
        return "balance-selection";
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.coa = (lj) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_balance_selection, viewGroup, false);
        this.coa.a(this);
        this.coa.bwU.setText(this.coa.bwU.getText().toString().toUpperCase());
        this.coa.bwX.setText(this.coa.bwX.getText().toString().toUpperCase());
        bg.a(getContext(), this.coa.bwU, (int) R.color.dark_orange);
        bg.a(getContext(), this.coa.bwX, (int) R.color.green_balance_selection_menu);
        this.coa.bwT.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_right, 0);
        this.coa.bwW.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_right, 0);
        ahe();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.coa.getRoot();
    }

    protected int ahd() {
        return getResources().getDimensionPixelOffset(R.dimen.iq_smart_fragment_width);
    }

    private void ahe() {
        View root = this.coa.getRoot();
        root.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                BalanceSelectionFragment.this.onClose();
                return true;
            }
        });
        root.setFocusableInTouchMode(true);
    }

    public boolean onClose() {
        return super.onClose();
    }

    public void aO(View view) {
        this.cob = view.getId() == R.id.depositNowButton ? SelectedBalance.real : SelectedBalance.practice;
        super.onClose();
    }

    public void onDetach() {
        super.onDetach();
    }
}
