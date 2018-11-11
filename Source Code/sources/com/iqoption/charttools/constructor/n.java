package com.iqoption.charttools.constructor;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.charttools.b.g;
import com.iqoption.charttools.o;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHostBottomSheet;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorBottomSheetInputSelectBinding;", "()V", "viewModel", "Lcom/iqoption/charttools/constructor/InputHostViewModel;", "onBottomSheetClosed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "OptionViewHolder", "OptionsAdapter", "techtools_release"})
/* compiled from: InputHostBottomSheet.kt */
public final class n extends com.iqoption.bottomsheet.a<g> {
    private static final String TAG = "com.iqoption.charttools.constructor.n";
    public static final a aux = new a();
    private HashMap atz;
    private InputHostViewModel auw;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHostBottomSheet$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "techtools_release"})
    /* compiled from: InputHostBottomSheet.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return n.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHostBottomSheet$OptionsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/charttools/constructor/InputHostBottomSheet$OptionViewHolder;", "items", "", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "onClick", "Lkotlin/Function1;", "", "([Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;Lkotlin/jvm/functions/Function1;)V", "getItems", "()[Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "[Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "techtools_release"})
    /* compiled from: InputHostBottomSheet.kt */
    private static final class c extends Adapter<b> {
        private final com.iqoption.charttools.model.indicator.constructor.b[] auA;
        private final kotlin.jvm.a.b<com.iqoption.charttools.model.indicator.constructor.b, l> auy;

        public c(com.iqoption.charttools.model.indicator.constructor.b[] bVarArr, kotlin.jvm.a.b<? super com.iqoption.charttools.model.indicator.constructor.b, l> bVar) {
            h.e(bVarArr, "items");
            h.e(bVar, "onClick");
            this.auA = bVarArr;
            this.auy = bVar;
        }

        public int getItemCount() {
            return this.auA.length;
        }

        /* renamed from: d */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            h.e(viewGroup, "parent");
            return new b(this.auy, viewGroup);
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            h.e(bVar, "holder");
            bVar.bo(this.auA[i]);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHostBottomSheet$OptionViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "onClick", "Lkotlin/Function1;", "", "parent", "Landroid/view/ViewGroup;", "(Lkotlin/jvm/functions/Function1;Landroid/view/ViewGroup;)V", "bind", "item", "techtools_release"})
    /* compiled from: InputHostBottomSheet.kt */
    private static final class b extends com.iqoption.core.ui.widget.recyclerview.a.b<com.iqoption.charttools.model.indicator.constructor.b> {
        private final kotlin.jvm.a.b<com.iqoption.charttools.model.indicator.constructor.b, l> auy;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/constructor/InputHostBottomSheet$OptionViewHolder$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
        /* compiled from: InputHostBottomSheet.kt */
        /* renamed from: com.iqoption.charttools.constructor.n$b$1 */
        public static final class AnonymousClass1 extends com.iqoption.core.ext.g {
            final /* synthetic */ b auz;

            AnonymousClass1(b bVar) {
                this.auz = bVar;
                super(0, 1, null);
            }

            public void q(View view) {
                h.e(view, "v");
                com.iqoption.charttools.model.indicator.constructor.b bVar = (com.iqoption.charttools.model.indicator.constructor.b) this.auz.ZU();
                if (bVar != null) {
                    this.auz.auy.invoke(bVar);
                }
            }
        }

        public b(kotlin.jvm.a.b<? super com.iqoption.charttools.model.indicator.constructor.b, l> bVar, ViewGroup viewGroup) {
            h.e(bVar, "onClick");
            h.e(viewGroup, "parent");
            super(com.iqoption.core.ext.a.b(viewGroup, o.h.indicator_constructor_bottom_sheet_input_select_item, null, false, 6, null));
            this.auy = bVar;
            this.itemView.setOnClickListener(new AnonymousClass1(this));
        }

        /* renamed from: a */
        public void bb(com.iqoption.charttools.model.indicator.constructor.b bVar) {
            h.e(bVar, "item");
            View view = this.itemView;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            ((TextView) view).setText(bVar.getTitle());
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ InputHostViewModel a(n nVar) {
        InputHostViewModel inputHostViewModel = nVar.auw;
        if (inputHostViewModel == null) {
            h.lS("viewModel");
        }
        return inputHostViewModel;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.auw = InputHostViewModel.auD.f(com.iqoption.core.ext.a.r(this));
    }

    /* renamed from: f */
    public g e(ViewGroup viewGroup) {
        h.e(viewGroup, "container");
        return (g) com.iqoption.core.ext.a.a(viewGroup, o.h.indicator_constructor_bottom_sheet_input_select, null, false, 6, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView = ((g) getBinding()).agA;
        h.d(textView, "binding.title");
        InputHostViewModel inputHostViewModel = this.auw;
        if (inputHostViewModel == null) {
            h.lS("viewModel");
        }
        textView.setText(inputHostViewModel.getTitle());
        RecyclerView recyclerView = ((g) getBinding()).axw;
        InputHostViewModel inputHostViewModel2 = this.auw;
        if (inputHostViewModel2 == null) {
            h.lS("viewModel");
        }
        recyclerView.setAdapter(new c(inputHostViewModel2.Lm(), new InputHostBottomSheet$onViewCreated$$inlined$apply$lambda$1(this)));
    }

    public void JP() {
        super.JP();
        InputHostViewModel inputHostViewModel = this.auw;
        if (inputHostViewModel == null) {
            h.lS("viewModel");
        }
        inputHostViewModel.destroy();
    }
}
