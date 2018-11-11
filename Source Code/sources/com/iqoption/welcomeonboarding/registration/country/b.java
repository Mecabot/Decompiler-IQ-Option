package com.iqoption.welcomeonboarding.registration.country;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.d.vx;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/country/CountryHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/ItemCountrySuggestBinding;", "clickListener", "Lcom/iqoption/welcomeonboarding/registration/country/OnCountryClickListener;", "(Lcom/iqoption/databinding/ItemCountrySuggestBinding;Lcom/iqoption/welcomeonboarding/registration/country/OnCountryClickListener;)V", "<set-?>", "Lcom/iqoption/welcomeonboarding/registration/country/CountryItem;", "bound", "getBound", "()Lcom/iqoption/welcomeonboarding/registration/country/CountryItem;", "setBound", "(Lcom/iqoption/welcomeonboarding/registration/country/CountryItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CountryHolder.kt */
public final class b extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "bound", "getBound()Lcom/iqoption/welcomeonboarding/registration/country/CountryItem;"))};
    private final d bXV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ e cEn;
        final /* synthetic */ b dNe;

        public a(b bVar, e eVar) {
            this.dNe = bVar;
            this.cEn = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.cEn.c(this.dNe.aMp().amw());
        }
    }

    public final void a(c cVar) {
        h.e(cVar, "<set-?>");
        this.bXV.a(this, apP[0], cVar);
    }

    public final c aMp() {
        return (c) this.bXV.b(this, apP[0]);
    }

    public b(vx vxVar, e eVar) {
        h.e(vxVar, "binding");
        h.e(eVar, "clickListener");
        super(vxVar.getRoot());
        View view = this.itemView;
        h.d(view, "itemView");
        view.setOnClickListener(new a(this, eVar));
        this.bXV = c.h(new CountryHolder$$special$$inlined$bindable$1(vxVar, vxVar));
    }
}
