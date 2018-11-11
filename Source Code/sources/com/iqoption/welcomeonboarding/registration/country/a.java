package com.iqoption.welcomeonboarding.registration.country;

import android.view.ViewGroup;
import com.iqoption.d.vx;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/country/CountryAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/welcomeonboarding/registration/country/CountryHolder;", "Lcom/iqoption/welcomeonboarding/registration/country/CountryItem;", "clickListener", "Lcom/iqoption/welcomeonboarding/registration/country/OnCountryClickListener;", "(Lcom/iqoption/welcomeonboarding/registration/country/OnCountryClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CountryAdapter.kt */
public final class a extends com.iqoption.core.ui.widget.recyclerview.adapter.a<b, c> {
    private final e cEm;

    public a(e eVar) {
        h.e(eVar, "clickListener");
        this.cEm = eVar;
    }

    /* renamed from: ad */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return new b((vx) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.item_country_suggest, null, false, 6, null), this.cEm);
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        h.e(bVar, "holder");
        bVar.a((c) getItem(i));
    }
}
