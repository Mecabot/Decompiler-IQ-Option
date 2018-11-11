package com.iqoption.charttools.constructor.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.b.o;
import com.iqoption.charttools.constructor.widget.ColorPicker;
import com.iqoption.charttools.constructor.widget.ColorPicker.b;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputColorViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorInputColorBinding;", "Lcom/iqoption/charttools/constructor/InputColor;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: InputColorViewHolder.kt */
public final class h extends c<o, com.iqoption.charttools.constructor.i> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0002¨\u0006\r"}, aXE = {"com/iqoption/charttools/constructor/viewholder/InputColorViewHolder$listener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "Lcom/iqoption/charttools/constructor/widget/ColorPicker$OnSliderClickListener;", "Lcom/iqoption/charttools/constructor/widget/ColorPicker$OnColorChangeListener;", "onColorChange", "", "color", "", "onDelayClick", "v", "Landroid/view/View;", "onSliderClick", "toggleColorPicker", "techtools_release"})
    /* compiled from: InputColorViewHolder.kt */
    public static final class a extends g implements b, ColorPicker.c {
        final /* synthetic */ h avn;

        a(h hVar) {
            this.avn = hVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            Lx();
        }

        public void Lw() {
            Lx();
        }

        public void dk(int i) {
            com.iqoption.charttools.constructor.i iVar = (com.iqoption.charttools.constructor.i) this.avn.ZU();
            if (iVar != null) {
                iVar.setSelected(i);
            }
        }

        private final void Lx() {
            o oVar = (o) this.avn.getBinding();
            ColorPicker colorPicker = oVar.axC;
            kotlin.jvm.internal.h.d(colorPicker, "picker");
            if (!colorPicker.LJ()) {
                com.iqoption.charttools.constructor.i iVar = (com.iqoption.charttools.constructor.i) this.avn.ZU();
                if (iVar != null) {
                    ColorPicker colorPicker2 = oVar.axC;
                    kotlin.jvm.internal.h.d(colorPicker2, "picker");
                    iVar.setExpanded(colorPicker2.isExpanded() ^ 1);
                    colorPicker = oVar.axC;
                    kotlin.jvm.internal.h.d(colorPicker, "picker");
                    if (colorPicker.isExpanded()) {
                        oVar.axB.animate().rotation(0.0f).setDuration(250).setInterpolator(com.iqoption.core.graphics.animation.i.TI()).start();
                    } else {
                        oVar.axB.animate().rotation(180.0f).setDuration(250).setInterpolator(com.iqoption.core.graphics.animation.i.TI()).start();
                    }
                    oVar.axC.toggle();
                }
            }
        }
    }

    public h(ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        super(com.iqoption.charttools.o.h.indicator_constructor_input_color, viewGroup);
        a aVar = new a(this);
        o oVar = (o) getBinding();
        oVar.avm.setOnClickListener(aVar);
        oVar.axC.setOnSliderClickListener(aVar);
        oVar.axC.setOnColorChangeListener(aVar);
    }

    public void a(o oVar, com.iqoption.charttools.constructor.i iVar) {
        kotlin.jvm.internal.h.e(oVar, "$receiver");
        kotlin.jvm.internal.h.e(iVar, "item");
        TextView textView = oVar.avo;
        kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CALL_TO_ACTION_LABEL);
        textView.setText(iVar.getLabel());
        ImageView imageView = oVar.axB;
        kotlin.jvm.internal.h.d(imageView, "arrow");
        ColorPicker colorPicker = oVar.axC;
        kotlin.jvm.internal.h.d(colorPicker, "picker");
        imageView.setRotation(colorPicker.isExpanded() ? 180.0f : 0.0f);
        oVar.axC.setColor(iVar.Ld());
        ColorPicker colorPicker2 = oVar.axC;
        kotlin.jvm.internal.h.d(colorPicker2, "picker");
        colorPicker2.setExpanded(iVar.isExpanded());
    }
}
