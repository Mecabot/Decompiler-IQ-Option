package com.iqoption.charttools.constructor.a;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.a.a;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nR\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputBinding;", "Binding", "Landroid/databinding/ViewDataBinding;", "Lcom/iqoption/core/ui/widget/binding/IQBinding;", "layout", "", "parent", "Landroid/view/ViewGroup;", "(ILandroid/view/ViewGroup;)V", "binding", "(Landroid/databinding/ViewDataBinding;)V", "getBinding", "()Landroid/databinding/ViewDataBinding;", "Landroid/databinding/ViewDataBinding;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "input", "Landroid/widget/EditText;", "getInput", "()Landroid/widget/EditText;", "label", "Landroid/widget/TextView;", "getLabel", "()Landroid/widget/TextView;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "techtools_release"})
/* compiled from: InputFieldBindings.kt */
public abstract class f<Binding extends ViewDataBinding> implements a {
    private final Binding ahp;
    private final View avl;
    private final LinearLayout avm;

    public abstract TextView Lu();

    public abstract EditText Lv();

    public f(Binding binding) {
        h.e(binding, "binding");
        this.ahp = binding;
        View root = this.ahp.getRoot();
        h.d(root, "binding.root");
        this.avl = root;
        root = this.ahp.getRoot();
        if (root == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        this.avm = (LinearLayout) root;
    }

    public final Binding getBinding() {
        return this.ahp;
    }

    public f(int i, ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        this(com.iqoption.core.ext.a.a(viewGroup, i, null, false, 6, null));
    }

    public View getRoot() {
        return this.avl;
    }

    public final LinearLayout Lt() {
        return this.avm;
    }
}
