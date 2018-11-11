package com.iqoption.charttools.constructor.a;

import android.support.v4.view.InputDeviceCompat;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.iqoption.charttools.constructor.j;
import com.iqoption.core.ext.g;
import com.iqoption.core.f;
import com.iqoption.core.util.r;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \r*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001\rB\r\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t*\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t*\u00028\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0004¢\u0006\u0002\u0010\u000b¨\u0006\u000e"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/AbsInputFieldViewHolder;", "Binding", "Lcom/iqoption/charttools/constructor/viewholder/InputBinding;", "Item", "Lcom/iqoption/charttools/constructor/InputField;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQBindingHolder;", "binding", "(Lcom/iqoption/charttools/constructor/viewholder/InputBinding;)V", "bind", "", "item", "(Lcom/iqoption/charttools/constructor/viewholder/InputBinding;Lcom/iqoption/charttools/constructor/InputField;)V", "bindLabel", "Companion", "techtools_release"})
/* compiled from: AbsInputFieldViewHolder.kt */
public abstract class a<Binding extends f<?>, Item extends j> extends com.iqoption.core.ui.widget.recyclerview.a.a<Binding, Item> {
    private static final int avc = f.getColor(com.iqoption.charttools.o.c.red);
    private static final int avd = f.getColor(com.iqoption.charttools.o.c.grey_blue_70);
    @Deprecated
    public static final c ave = new c();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b¨\u0006\f"}, aXE = {"<anonymous>", "", "Binding", "Lcom/iqoption/charttools/constructor/viewholder/InputBinding;", "Item", "Lcom/iqoption/charttools/constructor/InputField;", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/iqoption/charttools/constructor/viewholder/AbsInputFieldViewHolder$2$1"})
    /* compiled from: AbsInputFieldViewHolder.kt */
    static final class a implements OnFocusChangeListener {
        final /* synthetic */ EditText avf;
        final /* synthetic */ d avg;

        a(EditText editText, d dVar) {
            this.avf = editText;
            this.avg = dVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                this.avf.addTextChangedListener(this.avg);
            } else {
                this.avf.removeTextChangedListener(this.avg);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, aXE = {"<anonymous>", "", "Binding", "Lcom/iqoption/charttools/constructor/viewholder/InputBinding;", "Item", "Lcom/iqoption/charttools/constructor/InputField;", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* compiled from: AbsInputFieldViewHolder.kt */
    static final class b implements OnEditorActionListener {
        final /* synthetic */ EditText avf;

        b(EditText editText) {
            this.avf = editText;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.avf.clearFocus();
            h.d(textView, "v");
            com.iqoption.core.util.j.a(textView.getContext(), this.avf);
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/AbsInputFieldViewHolder$Companion;", "", "()V", "ERROR_COLOR", "", "LABEL_COLOR", "techtools_release"})
    /* compiled from: AbsInputFieldViewHolder.kt */
    private static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/constructor/viewholder/AbsInputFieldViewHolder$textWatcher$1", "Lcom/iqoption/core/util/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "techtools_release"})
    /* compiled from: AbsInputFieldViewHolder.kt */
    public static final class d extends r {
        final /* synthetic */ f avh;
        final /* synthetic */ a avi;

        d(a aVar, f fVar) {
            this.avi = aVar;
            this.avh = fVar;
        }

        public void afterTextChanged(Editable editable) {
            h.e(editable, "s");
            j jVar = (j) this.avi.ZU();
            if (jVar != null) {
                jVar.k(editable);
                this.avi.b(this.avh, jVar);
            }
        }
    }

    public a(final Binding binding) {
        h.e(binding, "binding");
        super((com.iqoption.core.ui.widget.a.a) binding);
        binding.Lt().setOnClickListener(new g() {
            public void q(View view) {
                h.e(view, "v");
                binding.Lv().requestFocus();
                com.iqoption.core.ext.a.c(binding.Lv());
                com.iqoption.core.util.j.b(view.getContext(), binding.Lv());
            }
        });
        d dVar = new d(this, binding);
        EditText Lv = binding.Lv();
        Lv.setOnFocusChangeListener(new a(Lv, dVar));
        Lv.setOnEditorActionListener(new b(Lv));
    }

    public void a(Binding binding, Item item) {
        h.e(binding, "$receiver");
        h.e(item, "item");
        int i = 1;
        Double Mz;
        switch (item.Lr().My()) {
            case INT:
                Mz = item.Lr().Mz();
                if (Mz != null && Mz.doubleValue() >= ((double) null)) {
                    i = 0;
                }
                if (i == 0) {
                    i = 2;
                    break;
                } else {
                    i = InputDeviceCompat.SOURCE_TOUCHSCREEN;
                    break;
                }
            case DOUBLE:
                Mz = item.Lr().Mz();
                if (Mz != null && Mz.doubleValue() >= ((double) null)) {
                    i = 0;
                }
                if (i == 0) {
                    i = 8194;
                    break;
                } else {
                    i = 12290;
                    break;
                }
        }
        if (binding.Lv().getInputType() != i) {
            binding.Lv().setInputType(i);
        }
        binding.Lv().setTextKeepState(item.Lf());
        b(binding, item);
    }

    protected final void b(Binding binding, j jVar) {
        h.e(binding, "$receiver");
        h.e(jVar, "item");
        if (jVar.getError() != null) {
            binding.Lu().setText(jVar.getError());
            binding.Lu().setTextColor(avc);
            return;
        }
        binding.Lu().setText(jVar.getLabel());
        binding.Lu().setTextColor(avd);
    }
}
