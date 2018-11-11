package com.iqoption.deposit.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.iqoption.core.ui.b;
import com.iqoption.core.util.c;
import com.iqoption.deposit.r;
import com.iqoption.deposit.r.e;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H&R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/deposit/presets/BasePresetViewHolder;", "BindingType", "Landroid/databinding/ViewDataBinding;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "listener", "Lcom/iqoption/deposit/presets/OnPresetClickListener;", "(Landroid/databinding/ViewDataBinding;Lcom/iqoption/deposit/presets/OnPresetClickListener;)V", "getBinding", "()Landroid/databinding/ViewDataBinding;", "Landroid/databinding/ViewDataBinding;", "bound", "Lcom/iqoption/deposit/presets/PresetItem;", "bind", "", "item", "presetAmount", "Landroid/widget/TextView;", "deposit_release"})
/* compiled from: BasePresetViewHolder.kt */
public abstract class a<BindingType extends ViewDataBinding> extends ViewHolder {
    private final BindingType ahp;
    private c cbj;

    public abstract TextView adW();

    public final BindingType getBinding() {
        return this.ahp;
    }

    public a(BindingType bindingType, final b bVar) {
        h.e(bindingType, "binding");
        h.e(bVar, "listener");
        super(bindingType.getRoot());
        this.ahp = bindingType;
        View root = this.ahp.getRoot();
        h.d(root, "binding.root");
        Context context = root.getContext();
        h.d(context, "binding.root.context");
        Resources resources = context.getResources();
        String string = resources.getString(r.h.spec_states_deposit_preset);
        h.d(string, "resources.getString(R.st…ec_states_deposit_preset)");
        int[][] gS = b.gS(string);
        TypedArray obtainTypedArray = resources.obtainTypedArray(r.b.spec_values_deposit_preset);
        final TextView adW = adW();
        View view = adW;
        h.d(obtainTypedArray, "alphas");
        com.iqoption.core.ui.a.a(view, gS, obtainTypedArray, null, null);
        this.ahp.getRoot().setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a cce;

            public final void onClick(View view) {
                b bVar = bVar;
                c a = this.cce.cbj;
                if (a == null) {
                    h.aXZ();
                }
                bVar.a(a);
                adW.setSelected(true);
            }
        });
    }

    public final void b(c cVar) {
        h.e(cVar, "item");
        this.cbj = cVar;
        TextView adW = adW();
        adW.setText(c.a(new BigDecimal(cVar.adX().UO()), 0, cVar.aaH().getMask(), true, false, null, 25, null));
        Context context = adW.getContext();
        h.d(context, "context");
        adW.setBackground(com.iqoption.core.ext.a.l(context, e.bg_grey_blue_5_rounded));
        adW.setSelected(cVar.getSelected());
    }
}
