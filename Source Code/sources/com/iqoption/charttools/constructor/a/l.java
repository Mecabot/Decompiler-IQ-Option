package com.iqoption.charttools.constructor.a;

import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.charttools.b.s;
import com.iqoption.charttools.constructor.r;
import com.iqoption.charttools.constructor.widget.WidthPicker;
import com.iqoption.charttools.constructor.widget.WidthPicker.a;
import com.iqoption.charttools.o;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputLineWidthViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorInputLineWidthBinding;", "Lcom/iqoption/charttools/constructor/InputLineWidth;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: InputLineWidthViewHolder.kt */
public final class l extends c<s, r> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onChange"})
    /* compiled from: InputLineWidthViewHolder.kt */
    /* renamed from: com.iqoption.charttools.constructor.a.l$1 */
    static final class AnonymousClass1 implements a {
        final /* synthetic */ l avs;

        AnonymousClass1(l lVar) {
            this.avs = lVar;
        }

        public final void dl(int i) {
            r rVar = (r) this.avs.ZU();
            if (rVar != null) {
                rVar.setSelected(i);
            }
        }
    }

    public l(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_input_line_width, viewGroup);
        ((s) getBinding()).axD.setOnWidthChangeListener(new AnonymousClass1(this));
    }

    public void a(s sVar, r rVar) {
        h.e(sVar, "$receiver");
        h.e(rVar, "item");
        sVar.axD.setTitle(rVar.getLabel());
        WidthPicker widthPicker = sVar.axD;
        h.d(widthPicker, b.CONTENT);
        widthPicker.setSelectedWidth(rVar.Ld());
    }
}
