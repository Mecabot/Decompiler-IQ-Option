package com.iqoption.fragment.account.security.touchId;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.d.lf;
import com.iqoption.x.R;

/* compiled from: PasscodesErrorFragment */
public class a extends Fragment {
    public static final String TAG = "com.iqoption.fragment.account.security.touchId.a";
    private static final String cvA;
    private lf cvB;

    /* compiled from: PasscodesErrorFragment */
    public interface a {
        void zO();

        void zQ();
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_ERROR_TEXT");
        cvA = stringBuilder.toString();
    }

    public static a hH(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString(cvA, str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cvB = (lf) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security_passcode_error, viewGroup, false);
        this.cvB.a(this);
        if (!((getTargetFragment() instanceof a) || (zzakw() instanceof a))) {
            Log.e(TAG, "OnFragmentInteractionListener is not implemented by target fragment or activity");
        }
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getString(cvA) == null)) {
            this.cvB.bwI.setText(arguments.getString(cvA));
        }
        return this.cvB.getRoot();
    }

    public void ajM() {
        a ajO = ajO();
        if (ajO != null) {
            ajO.zO();
        }
    }

    public void onBackPressed() {
        ajM();
    }

    public void ajN() {
        a ajO = ajO();
        if (ajO != null) {
            ajO.zQ();
        }
    }

    private a ajO() {
        Fragment targetFragment = getTargetFragment();
        if (zzakw() instanceof a) {
            return (a) zzakw();
        }
        return targetFragment instanceof a ? (a) targetFragment : null;
    }
}
