package com.iqoption.charttools.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.core.ext.c;
import com.iqoption.dto.entity.position.Position;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B?\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelect;", "Lcom/iqoption/charttools/constructor/LabeledInput;", "item", "selected", "", "(Lcom/iqoption/charttools/constructor/InputSelect;I)V", "id", "gid", "input", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "default", "", "options", "", "(IILcom/iqoption/charttools/model/indicator/constructor/InputItem;Ljava/lang/String;[Ljava/lang/String;I)V", "defaultValue", "isDefault", "", "()Z", "getOptions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSelected", "()I", "toDefault", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "toInput", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public final class s extends w {
    private final String[] auK;
    private final int auq;
    private final int defaultValue;

    public /* synthetic */ s(int i, int i2, InputItem inputItem, String str, String[] strArr, int i3, int i4, f fVar) {
        if ((i4 & 16) != 0) {
            strArr = inputItem.getOptions();
            if (strArr == null) {
                h.aXZ();
            }
        }
        String[] strArr2 = strArr;
        if ((i4 & 32) != 0) {
            i3 = inputItem.getIntValue();
        }
        this(i, i2, inputItem, str, strArr2, i3);
    }

    public final String[] getOptions() {
        return this.auK;
    }

    public final int Ld() {
        return this.auq;
    }

    public s(int i, int i2, InputItem inputItem, String str, String[] strArr, int i3) {
        h.e(inputItem, "input");
        h.e(str, Position.CLOSE_REASON_DEFAULT);
        h.e(strArr, "options");
        super(i, i2, inputItem, str, null, 16, null);
        this.auK = strArr;
        this.auq = i3;
        this.defaultValue = c.s(str);
    }

    public s(s sVar, int i) {
        h.e(sVar, "item");
        this(sVar.Jf().intValue(), sVar.getGid(), sVar.Lr(), sVar.getDefault(), null, i, 16, null);
    }

    public boolean isDefault() {
        return this.defaultValue == this.auq;
    }

    public InputItem La() {
        return InputItem.a(Lr(), null, null, String.valueOf(this.auq), null, null, null, null, false, 251, null);
    }

    public d Lb() {
        return new s(Jf().intValue(), getGid(), Lq(), getDefault(), null, 0, 48, null);
    }
}
