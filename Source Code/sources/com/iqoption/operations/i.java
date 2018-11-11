package com.iqoption.operations;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import com.iqoption.d.acm;
import com.iqoption.d.aco;
import com.iqoption.x.R;
import java.util.List;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/operations/SelectOperationsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/operations/SelectOperationsAdapter$SelectOperationViewHolder;", "items", "", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "multiSelection", "", "listener", "Lkotlin/Function1;", "", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MultiSelectionViewHolder", "SelectOperationViewHolder", "SingleSelectionViewHolder", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SelectOperationsAdapter.kt */
public final class i extends Adapter<b> {
    private final boolean cXH;
    private final kotlin.jvm.a.b<com.iqoption.operations.OperationViewModel.c, Object> cXI;
    private final List<com.iqoption.operations.OperationViewModel.c> nj;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H&R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, aXE = {"Lcom/iqoption/operations/SelectOperationsAdapter$SelectOperationViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Landroid/databinding/ViewDataBinding;", "listener", "Lkotlin/Function1;", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "", "(Landroid/databinding/ViewDataBinding;Lkotlin/jvm/functions/Function1;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "bind", "", "filterItem", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SelectOperationsAdapter.kt */
    public static abstract class b extends ViewHolder {
        private final kotlin.jvm.a.b<com.iqoption.operations.OperationViewModel.c, Object> cXI;

        public abstract void b(com.iqoption.operations.OperationViewModel.c cVar);

        public final kotlin.jvm.a.b<com.iqoption.operations.OperationViewModel.c, Object> avD() {
            return this.cXI;
        }

        public b(ViewDataBinding viewDataBinding, kotlin.jvm.a.b<? super com.iqoption.operations.OperationViewModel.c, ? extends Object> bVar) {
            h.e(viewDataBinding, "binding");
            h.e(bVar, "listener");
            super(viewDataBinding.getRoot());
            this.cXI = bVar;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, aXE = {"Lcom/iqoption/operations/SelectOperationsAdapter$MultiSelectionViewHolder;", "Lcom/iqoption/operations/SelectOperationsAdapter$SelectOperationViewHolder;", "binding", "Lcom/iqoption/databinding/OperationHistoryMultiSelectionBinding;", "listener", "Lkotlin/Function1;", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "", "(Lcom/iqoption/databinding/OperationHistoryMultiSelectionBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/iqoption/databinding/OperationHistoryMultiSelectionBinding;", "bind", "", "filterItem", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SelectOperationsAdapter.kt */
    public static final class a extends b {
        private final acm cXJ;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: SelectOperationsAdapter.kt */
        static final class a implements OnClickListener {
            final /* synthetic */ a cXK;
            final /* synthetic */ com.iqoption.operations.OperationViewModel.c cXL;

            a(a aVar, com.iqoption.operations.OperationViewModel.c cVar) {
                this.cXK = aVar;
                this.cXL = cVar;
            }

            public final void onClick(View view) {
                this.cXK.avD().invoke(this.cXL);
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"})
        /* compiled from: SelectOperationsAdapter.kt */
        static final class b implements OnCheckedChangeListener {
            final /* synthetic */ a cXK;
            final /* synthetic */ com.iqoption.operations.OperationViewModel.c cXL;

            b(a aVar, com.iqoption.operations.OperationViewModel.c cVar) {
                this.cXK = aVar;
                this.cXL = cVar;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.cXK.avD().invoke(this.cXL);
            }
        }

        public a(acm acm, kotlin.jvm.a.b<? super com.iqoption.operations.OperationViewModel.c, ? extends Object> bVar) {
            h.e(acm, "binding");
            h.e(bVar, "listener");
            super(acm, bVar);
            this.cXJ = acm;
        }

        public void b(com.iqoption.operations.OperationViewModel.c cVar) {
            h.e(cVar, "filterItem");
            this.cXJ.agA.setText(cVar.avB());
            this.cXJ.getRoot().setOnClickListener(new a(this, cVar));
            this.cXJ.bNM.setOnCheckedChangeListener(null);
            CheckBox checkBox = this.cXJ.bNM;
            h.d(checkBox, "binding.checker");
            checkBox.setChecked(cVar.getSelected());
            this.cXJ.bNM.setOnCheckedChangeListener(new b(this, cVar));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, aXE = {"Lcom/iqoption/operations/SelectOperationsAdapter$SingleSelectionViewHolder;", "Lcom/iqoption/operations/SelectOperationsAdapter$SelectOperationViewHolder;", "binding", "Lcom/iqoption/databinding/OperationHistorySingleSelectionBinding;", "listener", "Lkotlin/Function1;", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "", "(Lcom/iqoption/databinding/OperationHistorySingleSelectionBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/iqoption/databinding/OperationHistorySingleSelectionBinding;", "bind", "", "filterItem", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SelectOperationsAdapter.kt */
    public static final class c extends b {
        private final aco cXM;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: SelectOperationsAdapter.kt */
        static final class a implements OnClickListener {
            final /* synthetic */ com.iqoption.operations.OperationViewModel.c cXL;
            final /* synthetic */ c cXN;

            a(c cVar, com.iqoption.operations.OperationViewModel.c cVar2) {
                this.cXN = cVar;
                this.cXL = cVar2;
            }

            public final void onClick(View view) {
                this.cXN.avD().invoke(this.cXL);
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"})
        /* compiled from: SelectOperationsAdapter.kt */
        static final class b implements OnCheckedChangeListener {
            final /* synthetic */ com.iqoption.operations.OperationViewModel.c cXL;
            final /* synthetic */ c cXN;

            b(c cVar, com.iqoption.operations.OperationViewModel.c cVar2) {
                this.cXN = cVar;
                this.cXL = cVar2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.cXN.avD().invoke(this.cXL);
            }
        }

        public c(aco aco, kotlin.jvm.a.b<? super com.iqoption.operations.OperationViewModel.c, ? extends Object> bVar) {
            h.e(aco, "binding");
            h.e(bVar, "listener");
            super(aco, bVar);
            this.cXM = aco;
        }

        public void b(com.iqoption.operations.OperationViewModel.c cVar) {
            h.e(cVar, "filterItem");
            this.cXM.agA.setText(cVar.avB());
            this.cXM.getRoot().setOnClickListener(new a(this, cVar));
            this.cXM.bNN.setOnCheckedChangeListener(null);
            RadioButton radioButton = this.cXM.bNN;
            h.d(radioButton, "binding.checker");
            radioButton.setChecked(cVar.getSelected());
            this.cXM.bNN.setOnCheckedChangeListener(new b(this, cVar));
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public i(List<com.iqoption.operations.OperationViewModel.c> list, boolean z, kotlin.jvm.a.b<? super com.iqoption.operations.OperationViewModel.c, ? extends Object> bVar) {
        h.e(list, "items");
        h.e(bVar, "listener");
        this.nj = list;
        this.cXH = z;
        this.cXI = bVar;
        setHasStableIds(true);
    }

    /* renamed from: O */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding inflate;
        if (this.cXH) {
            inflate = DataBindingUtil.inflate(from, R.layout.operation_history_multi_selection, viewGroup, false);
            h.d(inflate, "DataBindingUtil\n        …selection, parent, false)");
            return new a((acm) inflate, this.cXI);
        }
        inflate = DataBindingUtil.inflate(from, R.layout.operation_history_single_selection, viewGroup, false);
        h.d(inflate, "DataBindingUtil\n        …selection, parent, false)");
        return new c((aco) inflate, this.cXI);
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        h.e(bVar, "holder");
        bVar.b((com.iqoption.operations.OperationViewModel.c) this.nj.get(i));
    }
}
