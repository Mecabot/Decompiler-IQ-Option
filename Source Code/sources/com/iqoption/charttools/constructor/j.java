package com.iqoption.charttools.constructor;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.charttools.model.indicator.constructor.InputItem.Type;
import com.iqoption.charttools.o;
import com.iqoption.core.ext.c;
import com.iqoption.core.f;
import com.iqoption.dto.entity.position.Position;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0004J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006$"}, aXE = {"Lcom/iqoption/charttools/constructor/InputField;", "Lcom/iqoption/charttools/constructor/LabeledInput;", "id", "", "gid", "input", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "default", "", "onChanged", "Lkotlin/Function0;", "", "(IILcom/iqoption/charttools/model/indicator/constructor/InputItem;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "_strValue", "", "get_strValue", "()Ljava/lang/CharSequence;", "set_strValue", "(Ljava/lang/CharSequence;)V", "<set-?>", "error", "getError", "setError", "isDefault", "", "()Z", "isValid", "value", "strValue", "getStrValue", "setStrValue", "numValue", "", "toDefault", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "toInput", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public class j extends w {
    private CharSequence aur;
    private CharSequence error;

    protected CharSequence a(CharSequence charSequence, double d) {
        h.e(charSequence, b.VALUE);
        return null;
    }

    public j(int i, int i2, InputItem inputItem, String str, a<l> aVar) {
        h.e(inputItem, "input");
        h.e(str, Position.CLOSE_REASON_DEFAULT);
        super(i, i2, inputItem, str, aVar, null);
        this.aur = inputItem.getValue();
    }

    protected final CharSequence Le() {
        return this.aur;
    }

    protected final void j(CharSequence charSequence) {
        h.e(charSequence, "<set-?>");
        this.aur = charSequence;
    }

    public CharSequence Lf() {
        return this.aur;
    }

    public void k(CharSequence charSequence) {
        h.e(charSequence, b.VALUE);
        if ((h.E(this.aur, charSequence) ^ 1) != 0) {
            this.aur = charSequence;
            this.error = l(charSequence);
            onChanged();
        }
    }

    public final CharSequence getError() {
        return this.error;
    }

    protected final void setError(CharSequence charSequence) {
        this.error = charSequence;
    }

    public boolean isValid() {
        return this.error == null;
    }

    public boolean isDefault() {
        return h.E(getDefault(), this.aur.toString());
    }

    public InputItem La() {
        return InputItem.a(Lr(), null, null, this.aur.toString(), null, null, null, null, false, 251, null);
    }

    public d Lb() {
        return new j(Jf().intValue(), getGid(), Lq(), getDefault(), Ls());
    }

    protected final CharSequence l(CharSequence charSequence) {
        h.e(charSequence, b.VALUE);
        Type My = Lr().My();
        Object obj = (My == Type.INT || My == Type.DOUBLE) ? null : 1;
        if (obj != null) {
            return null;
        }
        if ((charSequence.length() == 0 ? 1 : null) != null) {
            return f.getString(o.i.value_is_empty);
        }
        double t = c.t(charSequence);
        Double Mz = Lr().Mz();
        if (Mz == null || t >= Mz.doubleValue()) {
            Mz = Lr().MA();
            if (Mz == null || t <= Mz.doubleValue()) {
                return a(charSequence, t);
            }
            return f.getString(o.i.max_n1, Lr().Mx());
        }
        return f.getString(o.i.min_n1, Lr().Mw());
    }
}
