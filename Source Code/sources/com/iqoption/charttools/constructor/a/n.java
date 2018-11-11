package com.iqoption.charttools.constructor.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.charttools.b.w;
import com.iqoption.charttools.o;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputStepFieldBinding;", "Lcom/iqoption/charttools/constructor/viewholder/InputBinding;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorInputStepFieldBinding;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "btnMinus", "Landroid/view/View;", "getBtnMinus", "()Landroid/view/View;", "btnPlus", "getBtnPlus", "input", "Landroid/widget/EditText;", "getInput", "()Landroid/widget/EditText;", "label", "Landroid/widget/TextView;", "getLabel", "()Landroid/widget/TextView;", "techtools_release"})
/* compiled from: InputFieldBindings.kt */
public final class n extends f<w> {
    private final TextView avo;
    private final EditText avp;
    private final View avv;
    private final View avw;

    public n(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_input_step_field, viewGroup);
        TextView textView = ((w) getBinding()).avo;
        h.d(textView, "binding.label");
        this.avo = textView;
        EditText editText = ((w) getBinding()).avp;
        h.d(editText, "binding.input");
        this.avp = editText;
        ImageView imageView = ((w) getBinding()).axF;
        h.d(imageView, "binding.btnMinus");
        this.avv = imageView;
        imageView = ((w) getBinding()).axG;
        h.d(imageView, "binding.btnPlus");
        this.avw = imageView;
    }

    public TextView Lu() {
        return this.avo;
    }

    public EditText Lv() {
        return this.avp;
    }

    public final View Ly() {
        return this.avv;
    }

    public final View Lz() {
        return this.avw;
    }
}
