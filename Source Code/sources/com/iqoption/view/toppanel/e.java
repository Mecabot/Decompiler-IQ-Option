package com.iqoption.view.toppanel;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.fragment.base.f;
import com.iqoption.mobbtech.connect.response.options.b;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: PanelDelegate */
public abstract class e {
    @ColorInt
    protected int ahg;
    @ColorInt
    protected int ahh;
    private final f dKe;
    protected b dKf;
    @ColorInt
    protected int dKg;
    protected String dKh;
    protected String mask = l.CD();

    /* compiled from: PanelDelegate */
    static class a extends com.iqoption.system.c.b<e, List<Parcelable>> {
        final String assetName;
        final double cnV;
        final double cnW;
        final Position position;

        public a(e eVar, double d, double d2, String str, Position position) {
            super((Object) eVar);
            this.cnV = d;
            this.cnW = d2;
            this.assetName = str;
            this.position = position;
        }

        /* renamed from: a */
        public void z(@NonNull e eVar, List<Parcelable> list) {
            List<Parcelable> list2 = list;
            super.z(eVar, list);
            KycState kycState = (KycState) list2.get(0);
            com.iqoption.microservice.a.b.a aVar = (com.iqoption.microservice.a.b.a) list2.get(1);
            com.iqoption.mobbtech.connect.response.e eVar2 = (com.iqoption.mobbtech.connect.response.e) list2.get(2);
            com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_PRESSED, "traderoom_withdraw-crypto").O(this.cnW).ks(this.assetName).Q(eVar2.cVJ.doubleValue()).o(this.position).send();
            com.iqoption.withdrawal.crypto.a.a(eVar.getSupportFragmentManager(), R.id.fragment, kycState, aVar, eVar2, this.cnV, this.cnW, this.assetName, this.position, R.id.fragment, false);
            eVar.eg(false);
        }

        /* renamed from: a */
        public void c(@NonNull e eVar, Throwable th) {
            super.c(eVar, th);
            eVar.eg(false);
            com.iqoption.app.a.b.aT(eVar.getContext());
        }
    }

    public void cw(long j) {
    }

    public void destroy() {
    }

    public void eg(boolean z) {
    }

    @NonNull
    public abstract View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    public void fr(boolean z) {
    }

    public e(f fVar, b bVar) {
        this.dKe = fVar;
        this.dKf = bVar;
        this.ahg = ContextCompat.getColor(getContext(), R.color.green);
        this.ahh = ContextCompat.getColor(getContext(), R.color.red);
        this.dKg = ContextCompat.getColor(getContext(), R.color.grey_blur_50);
        this.dKh = getContext().getResources().getString(R.string.n_a);
    }

    public void a(b bVar, Position position) {
        this.dKf = bVar;
    }

    public final f aKa() {
        return this.dKe;
    }

    public final Context getContext() {
        return this.dKe.getContext();
    }

    public final FragmentManager getSupportFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    public final FragmentActivity getActivity() {
        return this.dKe.zzakw();
    }
}
