package com.iqoption.charttools.tools.c;

import android.support.v7.widget.SwitchCompat;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.iqoption.charttools.tools.data.j;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.d.aka;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/SwitcherViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/StringBasketSwitchItemBinding;", "Lcom/iqoption/charttools/tools/data/SettingItem;", "callback", "Lcom/iqoption/charttools/tools/viewholder/SwitcherViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/tools/viewholder/SwitcherViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SwitcherViewHolder.kt */
public final class d extends c<aka, j> {
    private final a aCA;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    /* compiled from: SwitcherViewHolder.kt */
    /* renamed from: com.iqoption.charttools.tools.c.d$1 */
    static final class AnonymousClass1 implements OnCheckedChangeListener {
        final /* synthetic */ d aCB;

        AnonymousClass1(d dVar) {
            this.aCB = dVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            j jVar = (j) this.aCB.ZU();
            if (!(jVar == null || z == jVar.isEnabled())) {
                this.aCB.aCA.b(jVar);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/SwitcherViewHolder$Callback;", "", "onItemToggled", "", "item", "Lcom/iqoption/charttools/tools/data/SettingItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SwitcherViewHolder.kt */
    public interface a {
        void b(j jVar);
    }

    public d(a aVar, ViewGroup viewGroup) {
        h.e(aVar, "callback");
        h.e(viewGroup, "parent");
        super(R.layout.string_basket_switch_item, viewGroup);
        this.aCA = aVar;
        ((aka) getBinding()).axA.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    public void a(aka aka, j jVar) {
        h.e(aka, "$receiver");
        h.e(jVar, "item");
        aka.axA.setText(jVar.Og().getText());
        SwitchCompat switchCompat = aka.axA;
        h.d(switchCompat, "switcher");
        if (switchCompat.isChecked() != jVar.isEnabled()) {
            aka.axA.toggle();
        }
    }
}
