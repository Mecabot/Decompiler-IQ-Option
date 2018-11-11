package com.iqoption.charttools.constructor;

import android.view.ViewGroup;
import com.iqoption.charttools.constructor.a.c;
import com.iqoption.charttools.constructor.a.d;
import com.iqoption.charttools.constructor.a.e;
import com.iqoption.charttools.constructor.a.g;
import com.iqoption.charttools.constructor.a.j;
import com.iqoption.charttools.constructor.a.k;
import com.iqoption.charttools.constructor.a.l;
import com.iqoption.charttools.constructor.a.m;
import com.iqoption.charttools.constructor.a.p;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/constructor/InputItemsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "Lcom/iqoption/charttools/constructor/InputItemsDecoration$ViewTypeProvider;", "callbacks", "Lcom/iqoption/charttools/constructor/InputItemsAdapter$Callbacks;", "(Lcom/iqoption/charttools/constructor/InputItemsAdapter$Callbacks;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Companion", "techtools_release"})
/* compiled from: InputItemsAdapter.kt */
public final class o extends com.iqoption.core.ui.widget.recyclerview.adapter.a<com.iqoption.core.ui.widget.recyclerview.a.b<?>, d> implements com.iqoption.charttools.constructor.p.a {
    public static final b auF = new b();
    private final a auE;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/charttools/constructor/InputItemsAdapter$Companion;", "", "()V", "VIEW_TYPE_ERROR", "", "VIEW_TYPE_GROUP_DESCRIPTION", "VIEW_TYPE_GROUP_TITLE", "VIEW_TYPE_INPUT_BOOL", "VIEW_TYPE_INPUT_COLOR", "VIEW_TYPE_INPUT_FIELD", "VIEW_TYPE_INPUT_HOST", "VIEW_TYPE_INPUT_LINE_WIDTH", "VIEW_TYPE_INPUT_SELECT", "VIEW_TYPE_INPUT_STEP_FIELD", "VIEW_TYPE_LOADING", "techtools_release"})
    /* compiled from: InputItemsAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, aXE = {"Lcom/iqoption/charttools/constructor/InputItemsAdapter$Callbacks;", "Lcom/iqoption/charttools/constructor/viewholder/GroupTitleViewHolder$Callback;", "Lcom/iqoption/charttools/constructor/viewholder/InputSelectViewHolder$Callback;", "Lcom/iqoption/charttools/constructor/viewholder/InputHostViewHolder$Callback;", "techtools_release"})
    /* compiled from: InputItemsAdapter.kt */
    public interface a extends com.iqoption.charttools.constructor.a.e.a, com.iqoption.charttools.constructor.a.k.a, com.iqoption.charttools.constructor.a.m.a {
    }

    public o(a aVar) {
        h.e(aVar, "callbacks");
        this.auE = aVar;
    }

    /* renamed from: e */
    public com.iqoption.core.ui.widget.recyclerview.a.b<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        switch (i) {
            case -2:
                return new c(viewGroup);
            case -1:
                return new p(viewGroup);
            case 1:
                return new e(this.auE, viewGroup);
            case 2:
                return new d(viewGroup);
            case 3:
                return new g(viewGroup);
            case 4:
                return new com.iqoption.charttools.constructor.a.o(viewGroup);
            case 5:
                return new j(viewGroup);
            case 6:
                return new m(this.auE, viewGroup);
            case 7:
                return new com.iqoption.charttools.constructor.a.h(viewGroup);
            case 8:
                return new l(viewGroup);
            case 9:
                return new k(this.auE, viewGroup);
            default:
                com.iqoption.core.ui.widget.recyclerview.adapter.a.bgj.unsupportedViewType(i);
                throw null;
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(com.iqoption.core.ui.widget.recyclerview.a.b<?> bVar, int i) {
        h.e(bVar, "holder");
        com.iqoption.core.ui.widget.recyclerview.adapter.a.d dW;
        switch (bVar.getItemViewType()) {
            case 1:
                e eVar = (e) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputGroupTitle");
                }
                eVar.bo((l) dW);
                return;
            case 2:
                d dVar = (d) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputGroupDescription");
                }
                dVar.bo((k) dW);
                return;
            case 3:
                g gVar = (g) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputBool");
                }
                gVar.bo((g) dW);
                return;
            case 4:
                com.iqoption.charttools.constructor.a.o oVar = (com.iqoption.charttools.constructor.a.o) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputStepField");
                }
                oVar.bo((u) dW);
                return;
            case 5:
                j jVar = (j) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputField");
                }
                jVar.bo((j) dW);
                return;
            case 6:
                m mVar = (m) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputSelect");
                }
                mVar.bo((s) dW);
                return;
            case 7:
                com.iqoption.charttools.constructor.a.h hVar = (com.iqoption.charttools.constructor.a.h) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputColor");
                }
                hVar.bo((i) dW);
                return;
            case 8:
                l lVar = (l) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputLineWidth");
                }
                lVar.bo((r) dW);
                return;
            case 9:
                k kVar = (k) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.constructor.InputHost");
                }
                kVar.bo((m) dW);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        d dVar = (d) getItem(i);
        if (dVar instanceof x) {
            return -1;
        }
        if (dVar instanceof a) {
            return -2;
        }
        if (dVar instanceof l) {
            return 1;
        }
        if (dVar instanceof k) {
            return 2;
        }
        if (dVar instanceof g) {
            return 3;
        }
        if (dVar instanceof u) {
            return 4;
        }
        if (dVar instanceof j) {
            return 5;
        }
        if (dVar instanceof s) {
            return 6;
        }
        if (dVar instanceof i) {
            return 7;
        }
        if (dVar instanceof r) {
            return 8;
        }
        if (dVar instanceof m) {
            return 9;
        }
        throw new NoWhenBranchMatchedException();
    }
}
