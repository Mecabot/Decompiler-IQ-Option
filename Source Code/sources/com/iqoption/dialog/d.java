package com.iqoption.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: ProcessingDialog */
public class d extends DialogFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog progressDialog = new ProgressDialog(zzakw(), getTheme());
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(0);
        return progressDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setFlags(8, 8);
        getDialog().setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                d.this.getDialog().getWindow().clearFlags(8);
                am.bS(d.this.getDialog().getWindow().getDecorView());
            }
        });
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
