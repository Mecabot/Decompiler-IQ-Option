package com.iqoption.charttools.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.charttools.model.indicator.constructor.b;
import com.iqoption.charttools.o;
import com.iqoption.core.ext.c;
import com.iqoption.core.f;
import com.iqoption.dto.entity.position.Position;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BI\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\u0012\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHost;", "Lcom/iqoption/charttools/constructor/LabeledInput;", "item", "selected", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "(Lcom/iqoption/charttools/constructor/InputHost;Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;)V", "id", "", "gid", "input", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "default", "", "isEnabled", "", "hosts", "", "(IILcom/iqoption/charttools/model/indicator/constructor/InputItem;Ljava/lang/String;Z[Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;I)V", "defaultValue", "getHosts", "()[Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "[Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "isDefault", "()Z", "getSelected", "()I", "toDefault", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "toInput", "Companion", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public final class m extends w {
    private static final b auu = new b(-1, f.getString(o.i.chart));
    public static final a auv = new a();
    private final int auq;
    private final b[] aut;
    private final int defaultValue;
    private final boolean isEnabled;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHost$Companion;", "", "()V", "CHART_FIGURE_HOST", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "getCHART_FIGURE_HOST", "()Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "findSelected", "", "hosts", "", "index", "([Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;I)I", "techtools_release"})
    /* compiled from: InputAdapterItems.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b Lk() {
            return m.auu;
        }

        private final int a(b[] bVarArr, int i) {
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if ((bVarArr[i2].getIndex() == i ? 1 : null) != null) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public /* synthetic */ m(int i, int i2, InputItem inputItem, String str, boolean z, b[] bVarArr, int i3, int i4, f fVar) {
        boolean z2 = (i4 & 16) != 0 ? false : z;
        b[] bVarArr2 = (i4 & 32) != 0 ? new b[]{auu} : bVarArr;
        this(i, i2, inputItem, str, z2, bVarArr2, (i4 & 64) != 0 ? auv.a(bVarArr2, inputItem.getIntValue()) : i3);
    }

    public final b[] Li() {
        return this.aut;
    }

    public final int Ld() {
        return this.auq;
    }

    public m(int i, int i2, InputItem inputItem, String str, boolean z, b[] bVarArr, int i3) {
        String str2 = str;
        Object obj = bVarArr;
        InputItem inputItem2 = inputItem;
        h.e(inputItem2, "input");
        h.e(str2, Position.CLOSE_REASON_DEFAULT);
        h.e(obj, "hosts");
        super(i, i2, inputItem2, str2, null, 16, null);
        this.isEnabled = z;
        this.aut = obj;
        this.auq = i3;
        this.defaultValue = auv.a(this.aut, c.s(str2));
    }

    public m(m mVar, b bVar) {
        h.e(mVar, "item");
        h.e(bVar, "selected");
        this(mVar.Jf().intValue(), mVar.getGid(), mVar.Lr(), mVar.getDefault(), mVar.isEnabled, mVar.aut, auv.a(mVar.aut, bVar.getIndex()));
    }

    public boolean isDefault() {
        return this.defaultValue == this.auq;
    }

    public InputItem La() {
        return InputItem.a(Lr(), null, null, String.valueOf(this.aut[this.auq].getIndex()), null, null, null, null, false, 251, null);
    }

    public d Lb() {
        return new m(Jf().intValue(), getGid(), Lq(), getDefault(), this.isEnabled, this.aut, 0, 64, null);
    }
}
