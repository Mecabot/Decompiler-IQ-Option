package com.iqoption.charttools.constructor.a;

import android.support.v7.widget.SwitchCompat;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.iqoption.charttools.b.m;
import com.iqoption.charttools.o;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputBoolViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorInputBoolBinding;", "Lcom/iqoption/charttools/constructor/InputBool;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "bind", "item", "techtools_release"})
/* compiled from: InputBoolViewHolder.kt */
public final class g extends c<m, com.iqoption.charttools.constructor.g> implements OnCheckedChangeListener {
    public g(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_input_bool, viewGroup);
        ((m) getBinding()).axA.setOnCheckedChangeListener(this);
    }

    public void a(m mVar, com.iqoption.charttools.constructor.g gVar) {
        h.e(mVar, "$receiver");
        h.e(gVar, "item");
        SwitchCompat switchCompat = mVar.axA;
        h.d(switchCompat, "switcher");
        switchCompat.setText(gVar.getLabel());
        switchCompat = mVar.axA;
        h.d(switchCompat, "switcher");
        if (switchCompat.isChecked() != gVar.Lc()) {
            mVar.axA.toggle();
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        com.iqoption.charttools.constructor.g gVar = (com.iqoption.charttools.constructor.g) ZU();
        if (gVar != null) {
            gVar.bM(z);
        }
    }
}
