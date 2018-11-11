package com.iqoption.deposit.old;

import android.content.Context;
import android.support.v7.widget.IQListPopupWindow;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.d.wh;
import com.iqoption.d.wt;
import com.iqoption.view.rounded.RoundedFrameLayout;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\b\u0010;\u001a\u0004\u0018\u00010<J\b\u0010=\u001a\u000204H\u0002J\u0010\u0010>\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u000e\u0010?\u001a\u0002062\u0006\u00103\u001a\u000204J\u001d\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u000206H\u0002R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8B@BX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010)\u001a\u00020(2\u0006\u0010\n\u001a\u00020(8B@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0012\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, aXE = {"Lcom/iqoption/deposit/old/PayMethodSelector;", "Lcom/iqoption/view/rounded/RoundedFrameLayout;", "Lcom/iqoption/deposit/old/OnMethodClickListenerOld;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/iqoption/databinding/LayoutAmountSelectorCollapsedBinding;", "collapsedBinding", "getCollapsedBinding", "()Lcom/iqoption/databinding/LayoutAmountSelectorCollapsedBinding;", "setCollapsedBinding", "(Lcom/iqoption/databinding/LayoutAmountSelectorCollapsedBinding;)V", "collapsedBinding$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/deposit/old/MethodOldViewHolder;", "collapsedHolder", "getCollapsedHolder", "()Lcom/iqoption/deposit/old/MethodOldViewHolder;", "setCollapsedHolder", "(Lcom/iqoption/deposit/old/MethodOldViewHolder;)V", "collapsedHolder$delegate", "Landroid/view/View;", "collapsedView", "getCollapsedView", "()Landroid/view/View;", "setCollapsedView", "(Landroid/view/View;)V", "collapsedView$delegate", "expandedView", "listener", "Lcom/iqoption/deposit/old/OnMethodSelectorListenerOld;", "getListener", "()Lcom/iqoption/deposit/old/OnMethodSelectorListenerOld;", "setListener", "(Lcom/iqoption/deposit/old/OnMethodSelectorListenerOld;)V", "Lcom/iqoption/deposit/old/MethodsOldAdapter;", "methodsAdapter", "getMethodsAdapter", "()Lcom/iqoption/deposit/old/MethodsOldAdapter;", "setMethodsAdapter", "(Lcom/iqoption/deposit/old/MethodsOldAdapter;)V", "methodsAdapter$delegate", "popupWindow", "Landroid/support/v7/widget/IQListPopupWindow;", "selectedItemId", "", "unfolded", "", "bindSelected", "", "payMethodItem", "Lcom/iqoption/deposit/old/PayMethodItem;", "collapse", "expand", "getSelectedItem", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "isExpanded", "onMethodClicked", "prepare", "setData", "cashbox", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "initialMethodId", "", "(Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;Ljava/lang/Long;)V", "showPopup", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PayMethodSelector.kt */
public final class PayMethodSelector extends RoundedFrameLayout implements c {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(PayMethodSelector.class), "collapsedBinding", "getCollapsedBinding()Lcom/iqoption/databinding/LayoutAmountSelectorCollapsedBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(PayMethodSelector.class), "collapsedHolder", "getCollapsedHolder()Lcom/iqoption/deposit/old/MethodOldViewHolder;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(PayMethodSelector.class), "collapsedView", "getCollapsedView()Landroid/view/View;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(PayMethodSelector.class), "methodsAdapter", "getMethodsAdapter()Lcom/iqoption/deposit/old/MethodsOldAdapter;"))};
    private static final Comparator<e> caY = new c(new b(new a()));
    public static final d ccd = new d();
    private String caX;
    private d cbV;
    private final kotlin.e.d cbW;
    private final kotlin.e.d cbX;
    private final kotlin.e.d cbY;
    private final kotlin.e.d cbZ;
    private IQListPopupWindow cca;
    private View ccb;
    private boolean ccc;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Boolean.valueOf(((e) t2).getSelected()), Boolean.valueOf(((e) t).getSelected()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        final /* synthetic */ Comparator cba;

        public b(Comparator comparator) {
            this.cba = comparator;
        }

        public final int compare(T t, T t2) {
            int compare = this.cba.compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            boolean z = false;
            Comparable valueOf = Boolean.valueOf(((e) t2).aaT().UT() == PayMethodType.UserCard);
            if (((e) t).aaT().UT() == PayMethodType.UserCard) {
                z = true;
            }
            return b.c(valueOf, Boolean.valueOf(z));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T> {
        final /* synthetic */ Comparator cba;

        public c(Comparator comparator) {
            this.cba = comparator;
        }

        public final int compare(T t, T t2) {
            int compare = this.cba.compare(t, t2);
            return compare != 0 ? compare : b.c(Boolean.valueOf(com.iqoption.core.microservices.billing.response.deposit.e.a(((e) t2).aaT())), Boolean.valueOf(com.iqoption.core.microservices.billing.response.deposit.e.a(((e) t).aaT())));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/old/PayMethodSelector$Companion;", "", "()V", "METHOD_ITEMS_COMPARATOR", "Ljava/util/Comparator;", "Lcom/iqoption/deposit/old/PayMethodItem;", "Lkotlin/Comparator;", "getMETHOD_ITEMS_COMPARATOR", "()Ljava/util/Comparator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PayMethodSelector.kt */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: PayMethodSelector.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ PayMethodSelector this$0;

        e(PayMethodSelector payMethodSelector) {
            this.this$0 = payMethodSelector;
        }

        public final void onClick(View view) {
            if (this.this$0.ccc) {
                this.this$0.expand();
            } else {
                this.this$0.showPopup();
            }
        }
    }

    public PayMethodSelector(Context context) {
        this(context, null, 0, 6, null);
    }

    public PayMethodSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final wt getCollapsedBinding() {
        return (wt) this.cbW.b(this, apP[0]);
    }

    private final a getCollapsedHolder() {
        return (a) this.cbX.b(this, apP[1]);
    }

    private final View getCollapsedView() {
        return (View) this.cbY.b(this, apP[2]);
    }

    private final b getMethodsAdapter() {
        return (b) this.cbZ.b(this, apP[3]);
    }

    private final void setCollapsedBinding(wt wtVar) {
        this.cbW.a(this, apP[0], wtVar);
    }

    private final void setCollapsedHolder(a aVar) {
        this.cbX.a(this, apP[1], aVar);
    }

    private final void setCollapsedView(View view) {
        this.cbY.a(this, apP[2], view);
    }

    private final void setMethodsAdapter(b bVar) {
        this.cbZ.a(this, apP[3], bVar);
    }

    public /* synthetic */ PayMethodSelector(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public PayMethodSelector(Context context, AttributeSet attributeSet, int i) {
        h.e(context, "context");
        super(context, attributeSet, i);
        this.cbW = kotlin.e.a.euA.aYg();
        this.cbX = kotlin.e.a.euA.aYg();
        this.cbY = kotlin.e.a.euA.aYg();
        this.cbZ = kotlin.e.a.euA.aYg();
    }

    public final d getListener() {
        return this.cbV;
    }

    public final void setListener(d dVar) {
        this.cbV = dVar;
    }

    public final void cz(boolean z) {
        c cVar = this;
        setMethodsAdapter(new b(cVar));
        setCollapsedBinding((wt) com.iqoption.core.ext.a.a((ViewGroup) this, (int) R.layout.layout_amount_selector_collapsed, (ViewGroup) this, false, 4, null));
        wh whVar = getCollapsedBinding().bJS;
        h.d(whVar, "collapsedBinding.paymentMethodItem");
        setCollapsedHolder(new a(whVar, cVar, false));
        View root = getCollapsedBinding().getRoot();
        h.d(root, "collapsedBinding.root");
        setCollapsedView(root);
        addView(getCollapsedView());
        this.ccc = z;
    }

    public final void a(com.iqoption.core.microservices.billing.response.deposit.b bVar, Long l) {
        Object obj;
        h.e(bVar, "cashbox");
        ArrayList UG = bVar.UG();
        List b = u.b((Collection) UG != null ? UG : m.emptyList(), (Iterable) bVar.UH());
        PayMethod payMethod = (PayMethod) null;
        if (this.caX != null) {
            for (Object next : bVar.UH()) {
                if (h.E(com.iqoption.core.microservices.billing.response.deposit.e.e((g) next), this.caX)) {
                    break;
                }
            }
            Object next2 = null;
            payMethod = (PayMethod) next2;
        }
        if (payMethod == null && l != null) {
            for (Object obj2 : bVar.UH()) {
                Object obj3;
                long id = ((g) obj2).getId();
                if (l != null && id == l.longValue()) {
                    obj3 = 1;
                    continue;
                } else {
                    obj3 = null;
                    continue;
                }
                if (obj3 != null) {
                    break;
                }
            }
            obj2 = null;
            payMethod = (PayMethod) obj2;
        }
        if (payMethod == null) {
            ArrayList UG2 = bVar.UG();
            payMethod = UG2 != null ? (com.iqoption.core.microservices.billing.response.deposit.h) u.bV(UG2) : null;
        }
        if (payMethod == null) {
            boolean eW = com.iqoption.app.managers.feature.a.eW("kyc-deposit-limit");
            for (Object next3 : bVar.UH()) {
                g gVar = (g) next3;
                if (eW && gVar.UU()) {
                    obj2 = null;
                    continue;
                } else {
                    obj2 = 1;
                    continue;
                }
                if (obj2 != null) {
                    break;
                }
            }
            Object next32 = null;
            payMethod = (PayMethod) next32;
        }
        this.caX = payMethod != null ? com.iqoption.core.microservices.billing.response.deposit.e.e(payMethod) : null;
        List f = m.f(m.a(m.f(u.ac(b), new PayMethodSelector$setData$items$1(this)), caY));
        for (Object next4 : f) {
            if (((e) next4).getSelected()) {
                break;
            }
        }
        Object next42 = null;
        e eVar = (e) next42;
        if (eVar != null) {
            c(eVar);
        }
        getMethodsAdapter().ap(f);
        ImageView imageView;
        if (f.size() >= 2) {
            getCollapsedView().setEnabled(true);
            imageView = getCollapsedBinding().bpW;
            h.d(imageView, "collapsedBinding.paymentMethodCheck");
            com.iqoption.core.ext.a.L(imageView);
            getCollapsedView().setOnClickListener(new e(this));
        } else {
            imageView = getCollapsedBinding().bpW;
            h.d(imageView, "collapsedBinding.paymentMethodCheck");
            com.iqoption.core.ext.a.M(imageView);
            getCollapsedView().setEnabled(false);
        }
        if (this.ccc) {
            expand();
        }
    }

    private final void showPopup() {
        Context context = getContext();
        h.d(context, "context");
        int dimension = (int) (context.getResources().getDimension(R.dimen.deposit_currency_item_height) * 5.5f);
        IQListPopupWindow iQListPopupWindow = new IQListPopupWindow(getContext());
        iQListPopupWindow.setAdapter(getMethodsAdapter());
        iQListPopupWindow.setAnchorView(getCollapsedView());
        Context context2 = getContext();
        h.d(context2, "context");
        iQListPopupWindow.setBackgroundDrawable(com.iqoption.core.ext.a.l(context2, R.drawable.deposit_payment_method_spinner_border));
        iQListPopupWindow.setHeight(dimension);
        iQListPopupWindow.setOverlapAnchorPublic(true);
        iQListPopupWindow.access$701();
        ListView listView = iQListPopupWindow.getListView();
        if (listView != null) {
            listView.setChoiceMode(1);
        }
        this.cca = iQListPopupWindow;
    }

    public void b(e eVar) {
        h.e(eVar, "payMethodItem");
        if (isExpanded()) {
            collapse();
        }
        d dVar = this.cbV;
        if (dVar != null) {
            dVar.b(eVar);
        }
        IQListPopupWindow iQListPopupWindow = this.cca;
        if (iQListPopupWindow != null) {
            iQListPopupWindow.dismiss();
        }
        this.cca = (IQListPopupWindow) null;
        c(eVar);
        this.caX = com.iqoption.core.microservices.billing.response.deposit.e.e(eVar.aaT());
    }

    public final PayMethod getSelectedItem() {
        PayMethod payMethod = null;
        if (this.caX == null) {
            return null;
        }
        for (Object next : getMethodsAdapter().getItems()) {
            if (h.E(com.iqoption.core.microservices.billing.response.deposit.e.e(((e) next).aaT()), this.caX)) {
                break;
            }
        }
        Object next2 = null;
        e eVar = (e) next2;
        if (eVar != null) {
            payMethod = eVar.aaT();
        }
        return payMethod;
    }

    private final boolean isExpanded() {
        View view = this.ccb;
        return view != null && com.iqoption.core.ext.a.I(view);
    }

    public final void expand() {
        if (!isExpanded()) {
            d dVar = this.cbV;
            if (dVar != null) {
                dVar.adU();
            }
            View view;
            if (this.ccb != null) {
                view = this.ccb;
                if (view != null) {
                    com.iqoption.core.ext.a.L(view);
                }
            } else {
                view = LayoutInflater.from(getContext()).inflate(R.layout.layout_methods_selector_list, this, false);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.depositMethodsList);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(getMethodsAdapter());
                addView(view);
                this.ccb = view;
            }
            com.iqoption.core.ext.a.M(getCollapsedView());
        }
    }

    public final void collapse() {
        View view = this.ccb;
        if (view != null) {
            com.iqoption.core.ext.a.M(view);
        }
        com.iqoption.core.ext.a.L(getCollapsedView());
        d dVar = this.cbV;
        if (dVar != null) {
            dVar.adV();
        }
    }

    private final void c(e eVar) {
        getCollapsedHolder().a(eVar);
    }
}
