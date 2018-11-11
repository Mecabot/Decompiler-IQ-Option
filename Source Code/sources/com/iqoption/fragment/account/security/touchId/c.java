package com.iqoption.fragment.account.security.touchId;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.common.b.e;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.d.u;
import com.iqoption.dto.Event;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: TurnOnTouchIdViewHelper */
public class c implements OnCheckedChangeListener {
    public static final String TAG = "com.iqoption.fragment.account.security.touchId.c";
    private u cvD;
    private b cvE;
    private a cvF = new a();

    /* compiled from: TurnOnTouchIdViewHelper */
    private static class a {
        private final WeakReference<c> cvG;

        private a(c cVar) {
            this.cvG = new WeakReference(cVar);
        }

        @e
        public void onPasscode(com.iqoption.app.b.d.c cVar) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=");
            stringBuilder.append(cVar);
            i.d(str, stringBuilder.toString());
            c cVar2 = (c) this.cvG.get();
            if (cVar2 != null) {
                c.a(((Long) cVar.getValue()).longValue() >= 0, cVar2);
            }
        }
    }

    /* compiled from: TurnOnTouchIdViewHelper */
    public interface b {
        void ajg();

        s<Long> db(boolean z);
    }

    /* compiled from: TurnOnTouchIdViewHelper */
    private static class c extends com.iqoption.system.c.b<c, Long> {
        private final boolean cvk;

        public c(c cVar, boolean z) {
            super((Object) cVar);
            this.cvk = z;
        }

        /* renamed from: a */
        public void z(c cVar, Long l) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ResultCallback::onSuccess() ");
            stringBuilder.append(l);
            i.d(str, stringBuilder.toString());
            c(cVar);
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            i.d(c.TAG, "ResultCallback::onFailure()");
            c(cVar);
            c.a(af.aR(cVar.getView().getContext()).EP() >= 0, cVar);
        }

        private static void c(c cVar) {
            cVar.cvD.bip.f(false, false);
        }
    }

    public static c a(Context context, ViewGroup viewGroup, boolean z, b bVar) {
        c cVar = new c();
        cVar.cvE = bVar;
        cVar.a(context, viewGroup);
        cVar.cvD.getRoot().setTag(TAG);
        a(z, cVar);
        cVar.cvD.bip.setOnCheckedChangeListener(cVar);
        return cVar;
    }

    public Object ajQ() {
        return this.cvF;
    }

    private static void a(boolean z, c cVar) {
        cVar.cvD.bip.setOnCheckedChangeListener(null);
        cVar.cvD.bip.setChecked(z);
        cVar.cvD.biq.setText(z ? R.string.turn_passcode_off : R.string.turn_passcode_on);
        cVar.cvD.bit.setVisibility(z ? 0 : 8);
        cVar.cvD.bip.setOnCheckedChangeListener(cVar);
    }

    public View getView() {
        return this.cvD.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cvD = (u) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_turn_on_touch_id_fragment, viewGroup, viewGroup != null);
        this.cvD.a(this);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCheckedChanged, isChecked=");
        stringBuilder.append(z);
        i.d(str, stringBuilder.toString());
        this.cvD.bip.f(true, true);
        o.a(this.cvE.db(z), new c(this, z), com.iqoption.core.d.a.aSe);
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "security_touch-id-set").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }

    public void ajg() {
        i.d(TAG, "onChange...");
        this.cvE.ajg();
    }
}
