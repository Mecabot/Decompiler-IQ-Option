package com.iqoption.charttools.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.charttools.o;
import com.iqoption.core.f;
import com.iqoption.dto.entity.position.Position;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, aXE = {"Lcom/iqoption/charttools/constructor/InputBool;", "Lcom/iqoption/charttools/constructor/LabeledInput;", "id", "", "gid", "input", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "default", "", "onChanged", "Lkotlin/Function0;", "", "(IILcom/iqoption/charttools/model/indicator/constructor/InputItem;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "value", "", "boolValue", "getBoolValue", "()Z", "setBoolValue", "(Z)V", "defaultValue", "isDefault", "label", "getLabel", "()Ljava/lang/String;", "toDefault", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "toInput", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public final class g extends w {
    private final boolean aun;
    private boolean auo;

    public g(int i, int i2, InputItem inputItem, String str, a<l> aVar) {
        h.e(inputItem, "input");
        h.e(str, Position.CLOSE_REASON_DEFAULT);
        super(i, i2, inputItem, str, aVar, null);
        this.aun = Boolean.parseBoolean(str);
        this.auo = Boolean.parseBoolean(inputItem.getValue());
    }

    public final boolean Lc() {
        return this.auo;
    }

    public final void bM(boolean z) {
        if (this.auo != z) {
            this.auo = z;
            onChanged();
        }
    }

    public String getLabel() {
        Object obj = 1;
        if (h.aoS[Lr().My().ordinal()] != 1) {
            return Lr().getName();
        }
        String name = Lr().getName();
        if (name.length() <= 0) {
            obj = null;
        }
        if (obj == null) {
            name = null;
        }
        return name != null ? name : f.getString(o.i.visible);
    }

    public boolean isDefault() {
        return this.aun == this.auo;
    }

    public InputItem La() {
        return InputItem.a(Lr(), null, null, String.valueOf(this.auo), null, null, null, null, false, 251, null);
    }

    public d Lb() {
        return new g(Jf().intValue(), getGid(), Lq(), getDefault(), Ls());
    }
}
