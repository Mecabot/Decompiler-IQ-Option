package com.iqoption.deposit;

import android.view.View;
import com.iqoption.core.ui.fragment.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&¨\u0006\u000e"}, aXE = {"Lcom/iqoption/deposit/PayFieldsContainerFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "collectParams", "", "", "", "paymentMethodId", "", "setFieldsEnabled", "", "enabled", "", "validate", "deposit_release"})
/* compiled from: PayFieldsContainerFragment.kt */
public abstract class q extends b {
    private HashMap atz;

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract Map<String, Object> aaR();

    public abstract long aaS();

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public abstract boolean validate();
}
