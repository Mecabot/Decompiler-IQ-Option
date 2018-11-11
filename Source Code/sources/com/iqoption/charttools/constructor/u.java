package com.iqoption.charttools.constructor;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.core.ext.c;
import com.iqoption.dto.entity.position.Position;
import java.math.BigDecimal;
import java.math.MathContext;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u000bJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188V@VX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, aXE = {"Lcom/iqoption/charttools/constructor/InputStepField;", "Lcom/iqoption/charttools/constructor/InputField;", "id", "", "gid", "input", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "default", "", "onChanged", "Lkotlin/Function0;", "", "(IILcom/iqoption/charttools/model/indicator/constructor/InputItem;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "doubleDefaultValue", "", "doubleStep", "Ljava/math/BigDecimal;", "doubleValue", "intDefaultValue", "intValue", "isDefault", "", "()Z", "value", "", "strValue", "getStrValue", "()Ljava/lang/CharSequence;", "setStrValue", "(Ljava/lang/CharSequence;)V", "minusStep", "plusStep", "toDefault", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "updateNumValue", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public final class u extends j {
    private final int auR;
    private final Object auS;
    private BigDecimal auT;
    private final BigDecimal auU;
    private int intValue;

    public u(int i, int i2, InputItem inputItem, String str, a<l> aVar) {
        BigDecimal bigDecimal;
        h.e(inputItem, "input");
        h.e(str, Position.CLOSE_REASON_DEFAULT);
        super(i, i2, inputItem, str, aVar);
        Integer nf = t.nf(str);
        this.auR = nf != null ? nf.intValue() : 0;
        Object ne = s.ne(str);
        if (ne == null) {
            ne = Integer.valueOf(0);
        }
        this.auS = ne;
        this.intValue = inputItem.getIntValue();
        this.auT = new BigDecimal(inputItem.getValue(), MathContext.DECIMAL32);
        Double MB = inputItem.MB();
        if (MB != null) {
            bigDecimal = new BigDecimal(String.valueOf(MB.doubleValue()));
        } else {
            bigDecimal = BigDecimal.ZERO;
            h.d(bigDecimal, "BigDecimal.ZERO");
        }
        this.auU = bigDecimal;
    }

    public CharSequence Lf() {
        return Le();
    }

    public void k(CharSequence charSequence) {
        h.e(charSequence, b.VALUE);
        int i = 1;
        if ((h.E(Le(), charSequence) ^ 1) != 0) {
            j(charSequence);
            setError(l(charSequence));
            if (charSequence.length() <= 0) {
                i = 0;
            }
            if (i != 0) {
                Ln();
            }
            onChanged();
        }
    }

    public boolean isDefault() {
        switch (Lr().My()) {
            case INT:
                if (this.auR == this.intValue) {
                    return true;
                }
                return false;
            case DOUBLE:
                return h.E(this.auS, this.auT);
            default:
                return false;
        }
    }

    public d Lb() {
        return new u(Jf().intValue(), getGid(), Lq(), getDefault(), Ls());
    }

    private final void Ln() {
        switch (Lr().My()) {
            case INT:
                this.intValue = c.s(Le());
                return;
            case DOUBLE:
                this.auT = c.a(Le(), null, 1, null);
                return;
            default:
                return;
        }
    }

    public final void Lo() {
        switch (Lr().My()) {
            case INT:
                int i = this.intValue;
                Double MB = Lr().MB();
                this.intValue = i + (MB != null ? (int) MB.doubleValue() : 0);
                k(String.valueOf(this.intValue));
                return;
            case DOUBLE:
                BigDecimal stripTrailingZeros = this.auT.add(this.auU).stripTrailingZeros();
                h.d(stripTrailingZeros, "doubleValue.add(doubleStep).stripTrailingZeros()");
                this.auT = stripTrailingZeros;
                String toPlainString = this.auT.toPlainString();
                h.d(toPlainString, "doubleValue.toPlainString()");
                k(toPlainString);
                return;
            default:
                return;
        }
    }

    public final void Lp() {
        switch (Lr().My()) {
            case INT:
                int i = this.intValue;
                Double MB = Lr().MB();
                this.intValue = i - (MB != null ? (int) MB.doubleValue() : 0);
                k(String.valueOf(this.intValue));
                return;
            case DOUBLE:
                BigDecimal subtract = this.auT.subtract(this.auU);
                h.d(subtract, "this.subtract(other)");
                subtract = subtract.stripTrailingZeros();
                h.d(subtract, "doubleValue.minus(doubleStep).stripTrailingZeros()");
                this.auT = subtract;
                String toPlainString = this.auT.toPlainString();
                h.d(toPlainString, "doubleValue.toPlainString()");
                k(toPlainString);
                return;
            default:
                return;
        }
    }
}
