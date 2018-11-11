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

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelectBottomSheet;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorBottomSheetInputSelectBinding;", "()V", "viewModel", "Lcom/iqoption/charttools/constructor/InputSelectViewModel;", "onBottomSheetClosed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "OptionViewHolder", "OptionsAdapter", "techtools_release"})
/* compiled from: InputSelectBottomSheet.kt */
public final class t extends com.iqoption.bottomsheet.a<g> {
    private static final String TAG = "com.iqoption.charttools.constructor.t";
    public static final a auM = new a();
    private HashMap atz;
    private InputSelectViewModel auL;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelectBottomSheet$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "techtools_release"})
    /* compiled from: InputSelectBottomSheet.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return t.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelectBottomSheet$OptionsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/charttools/constructor/InputSelectBottomSheet$OptionViewHolder;", "items", "", "", "onClick", "Lkotlin/Function1;", "", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getItems", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "techtools_release"})
    /* compiled from: InputSelectBottomSheet.kt */
    private static final class c extends Adapter<b> {
        private final String[] auO;
        private final kotlin.jvm.a.b<String, l> auy;

        public c(String[] strArr, kotlin.jvm.a.b<? super String, l> bVar) {
            h.e(strArr, "items");
            h.e(bVar, "onClick");
            this.auO = strArr;
            this.auy = bVar;
        }

        public int getItemCount() {
            return this.auO.length;
        }

        /* renamed from: f */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            h.e(viewGroup, "parent");
            return new b(this.auy, viewGroup);
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            h.e(bVar, "holder");
            bVar.bo(this.auO[i]);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelectBottomSheet$OptionViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "", "onClick", "Lkotlin/Function1;", "", "parent", "Landroid/view/ViewGroup;", "(Lkotlin/jvm/functions/Function1;Landroid/view/ViewGroup;)V", "bind", "item", "techtools_release"})
    /* compiled from: InputSelectBottomSheet.kt */
    private static final class b extends com.iqoption.core.ui.widget.recyclerview.a.b<String> {
        private final kotlin.jvm.a.b<String, l> auy;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/constructor/InputSelectBottomSheet$OptionViewHolder$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
        /* compiled from: InputSelectBottomSheet.kt */
        /* renamed from: com.iqoption.charttools.constructor.t$b$1 */
        public static final class AnonymousClass1 extends com.iqoption.core.ext.g {
            final /* synthetic */ b auN;

            AnonymousClass1(b bVar) {
                this.auN = bVar;
                super(0, 1, null);
            }

            public void q(View view) {
                h.e(view, "v");
                String str = (String) this.auN.ZU();
                if (str != null) {
                    this.auN.auy.invoke(str);
                }
            }
        }

        public b(kotlin.jvm.a.b<? super String, l> bVar, ViewGroup viewGroup) {
            h.e(bVar, "onClick");
            h.e(viewGroup, "parent");
            super(com.iqoption.core.ext.a.b(viewGroup, o.h.indicator_constructor_bottom_sheet_input_select_item, null, false, 6, null));
            this.auy = bVar;
            this.itemView.setOnClickListener(new AnonymousClass1(this));
        }

        /* renamed from: fA */
        public void bb(String str) {
            h.e(str, "item");
            View view = this.itemView;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            ((TextView) view).setText(str);
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

    public static final /* synthetic */ InputSelectViewModel a(t tVar) {
        InputSelectViewModel inputSelectViewModel = tVar.auL;
        if (inputSelectViewModel == null) {
            h.lS("viewModel");
        }
        return inputSelectViewModel;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.auL = InputSelectViewModel.auQ.g(com.iqoption.core.ext.a.r(this));
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
        InputSelectViewModel inputSelectViewModel = this.auL;
        if (inputSelectViewModel == null) {
            h.lS("viewModel");
        }
        textView.setText(inputSelectViewModel.getTitle());
        RecyclerView recyclerView = ((g) getBinding()).axw;
        InputSelectViewModel inputSelectViewModel2 = this.auL;
        if (inputSelectViewModel2 == null) {
            h.lS("viewModel");
        }
        recyclerView.setAdapter(new c(inputSelectViewModel2.getItems(), new InputSelectBottomSheet$onViewCreated$$inlined$apply$lambda$1(this)));
    }

    public void JP() {
        super.JP();
        InputSelectViewModel inputSelectViewModel = this.auL;
        if (inputSelectViewModel == null) {
            h.lS("viewModel");
        }
        inputSelectViewModel.destroy();
    }
}
