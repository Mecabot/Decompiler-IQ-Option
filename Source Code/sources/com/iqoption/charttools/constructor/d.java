package com.iqoption.charttools.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, aXE = {"Lcom/iqoption/charttools/constructor/InputAdapterItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "id", "(I)V", "hasValue", "", "getHasValue", "()Z", "getId", "()Ljava/lang/Integer;", "isDefault", "isValid", "toDefault", "toInput", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "Lcom/iqoption/charttools/constructor/LoadingItem;", "Lcom/iqoption/charttools/constructor/ErrorItem;", "Lcom/iqoption/charttools/constructor/InputGroupTitle;", "Lcom/iqoption/charttools/constructor/InputGroupDescription;", "Lcom/iqoption/charttools/constructor/LabeledInput;", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public abstract class d implements com.iqoption.core.ui.widget.recyclerview.adapter.a.d<Integer> {
    private final int id;

    public boolean KZ() {
        return false;
    }

    public d Lb() {
        return this;
    }

    public boolean isDefault() {
        return true;
    }

    public boolean isValid() {
        return false;
    }

    private d(int i) {
        this.id = i;
    }

    public /* synthetic */ d(int i, f fVar) {
        this(i);
    }

    /* renamed from: Je */
    public Integer Jf() {
        return Integer.valueOf(this.id);
    }

    public InputItem La() {
        throw new UnsupportedOperationException("This item does not have value");
    }
}
