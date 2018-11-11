package com.iqoption.chat.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.chat.component.ReadPermissionTracker;
import com.iqoption.chat.component.aw;
import com.iqoption.chat.viewmodel.AttachmentPickerViewModel;
import com.iqoption.chat.viewmodel.TransitionViewModel;
import com.iqoption.d.by;
import com.iqoption.d.cw;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.l;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u00020\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\"\u001a\u00020#H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0002J\"\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020#H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u0016H\u0016J\b\u0010=\u001a\u00020\u0016H\u0002J\b\u0010>\u001a\u00020\u0016H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188B@BX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000¨\u0006@"}, aXE = {"Lcom/iqoption/chat/fragment/AttachmentPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "args$delegate", "Lkotlin/Lazy;", "behavior", "Landroid/support/design/widget/BottomSheetBehavior;", "binding", "Lcom/iqoption/databinding/ChatFragmentAttachmentPickerBinding;", "chatName", "", "consumedSelectEventTime", "", "onSend", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "", "value", "", "savedInputMode", "getSavedInputMode", "()I", "setSavedInputMode", "(I)V", "successResult", "viewModel", "Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel;", "close", "animate", "", "closeSuccess", "result", "getPreviewView", "Landroid/widget/ImageView;", "preview", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "getSelectorView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDestroyView", "onDetach", "takeFile", "takeImage", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AttachmentPickerFragment.kt */
public final class a extends Fragment implements com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.chat.fragment.a";
    public static final a aFt = new a();
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "args", "getArgs()Landroid/os/Bundle;"))};
    private final kotlin.d aFm = g.f(new AttachmentPickerFragment$args$2(this));
    private AttachmentPickerViewModel aFn;
    private cw aFo;
    private String aFp = "";
    private kotlin.jvm.a.b<? super List<? extends Uri>, l> aFq;
    private List<? extends Uri> aFr;
    private long aFs;
    private BottomSheetBehavior<?> arB;
    private HashMap atz;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00120\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/fragment/AttachmentPickerFragment$Companion;", "", "()V", "ARG_SAVED_INPUT_MODE", "", "REQUEST_PICK", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/AttachmentPickerFragment;", "chatName", "onSend", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: AttachmentPickerFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }

        public final a b(String str, kotlin.jvm.a.b<? super List<? extends Uri>, l> bVar) {
            kotlin.jvm.internal.h.e(str, "chatName");
            kotlin.jvm.internal.h.e(bVar, "onSend");
            a aVar = new a();
            aVar.setRetainInstance(true);
            aVar.setArguments(new Bundle());
            aVar.aFp = str;
            aVar.aFq = bVar;
            return aVar;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$2"})
    /* compiled from: AttachmentPickerFragment.kt */
    static final class e implements Runnable {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ a this$0;

        e(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
        }

        public final void run() {
            a.a(this.this$0).setState(3);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$1", "Landroid/support/design/widget/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: AttachmentPickerFragment.kt */
    public static final class b extends BottomSheetCallback {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ com.iqoption.core.graphics.a.e aFu;
        final /* synthetic */ a this$0;

        b(com.iqoption.core.graphics.a.e eVar, a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.aFu = eVar;
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
        }

        public void onSlide(View view, float f) {
            kotlin.jvm.internal.h.e(view, "bottomSheet");
            this.aFu.dK(c.ae(((float) 255) * f));
        }

        public void onStateChanged(View view, int i) {
            kotlin.jvm.internal.h.e(view, "bottomSheet");
            if (i == 4 && this.this$0.isAdded()) {
                this.this$0.close(false);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/AttachmentPickerFragment$$special$$inlined$setOnDelayedClickListener$3"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends com.iqoption.core.ext.g {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ a this$0;

        public c(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.this$0.Pw();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$12", "Lcom/iqoption/chat/component/ReadPermissionTracker$Callback;", "onDenied", "", "onGranted", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: AttachmentPickerFragment.kt */
    public static final class d implements com.iqoption.chat.component.ReadPermissionTracker.a {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ a this$0;

        d(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
        }

        public void Pe() {
            a.b(this.this$0).QE();
        }

        public void Pf() {
            a.a(this.this$0, false, 1, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Integer;)V", "com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$5"})
    /* compiled from: AttachmentPickerFragment.kt */
    static final class f<T> implements Observer<Integer> {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ cw aFv;
        final /* synthetic */ a this$0;

        f(cw cwVar, a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.aFv = cwVar;
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
        }

        /* renamed from: b */
        public final void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            if (kotlin.jvm.internal.h.compare(num.intValue(), 0) > 0) {
                this.aFv.bmx.setImageResource(R.drawable.ic_send_crypto_black);
                TextView textView = this.aFv.bmy;
                kotlin.jvm.internal.h.d(textView, "labelAddSend");
                textView.setTypeface(com.iqoption.core.ext.a.d((ViewDataBinding) this.aFv, (int) R.font.medium));
                textView = this.aFv.bmy;
                kotlin.jvm.internal.h.d(textView, "labelAddSend");
                a aVar = this.this$0;
                Object[] objArr = new Object[1];
                String quantityString = this.this$0.getResources().getQuantityString(R.plurals.photos, num.intValue(), new Object[]{num});
                kotlin.jvm.internal.h.d(quantityString, "resources.getQuantityStr…R.plurals.photos, it, it)");
                if (quantityString == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                quantityString = quantityString.toLowerCase();
                kotlin.jvm.internal.h.d(quantityString, "(this as java.lang.String).toLowerCase()");
                objArr[0] = quantityString;
                textView.setText(aVar.getString(R.string.send_n1, objArr));
                return;
            }
            this.aFv.bmx.setImageResource(R.drawable.ic_library_add_white_24dp);
            TextView textView2 = this.aFv.bmy;
            kotlin.jvm.internal.h.d(textView2, "labelAddSend");
            textView2.setTypeface(com.iqoption.core.ext.a.d((ViewDataBinding) this.aFv, (int) R.font.regular));
            textView2 = this.aFv.bmy;
            kotlin.jvm.internal.h.d(textView2, "labelAddSend");
            textView2.setText(this.this$0.getString(R.string.add_photos));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/AttachmentPickerFragment$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class g extends com.iqoption.core.ext.g {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ a this$0;

        public g(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            a.a(this.this$0, false, 1, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/AttachmentPickerFragment$$special$$inlined$setOnDelayedClickListener$2"})
    /* compiled from: AndroidExtensions.kt */
    public static final class h extends com.iqoption.core.ext.g {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ a this$0;

        public h(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
            this.this$0 = aVar;
            this.$activity$inlined = fragmentActivity;
            this.$savedInstanceState$inlined = bundle;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            Integer num = (Integer) a.b(this.this$0).QC().getValue();
            if (num != null && num.intValue() == 0) {
                this.this$0.Pv();
                return;
            }
            List list = (List) a.b(this.this$0).QB().getValue();
            if (list != null) {
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    if (((com.iqoption.chat.viewmodel.a) next).isSelected()) {
                        arrayList.add(next);
                    }
                }
                Iterable<com.iqoption.chat.viewmodel.a> iterable = (List) arrayList;
                Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                for (com.iqoption.chat.viewmodel.a file : iterable) {
                    arrayList2.add(Uri.fromFile(file.getFile()));
                }
                list = (List) arrayList2;
            } else {
                list = null;
            }
            if (list != null) {
                a.a(this.this$0, list, false, 2, null);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "onChanged"})
    /* compiled from: AttachmentPickerFragment.kt */
    static final class i<T> implements Observer<List<? extends com.iqoption.chat.viewmodel.a>> {
        final /* synthetic */ com.iqoption.chat.component.c $adapter;

        i(com.iqoption.chat.component.c cVar) {
            this.$adapter = cVar;
        }

        /* renamed from: L */
        public final void onChanged(List<com.iqoption.chat.viewmodel.a> list) {
            if (list != null) {
                com.iqoption.chat.component.c.a(this.$adapter, list, null, 2, null);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/viewmodel/TransitionViewModel$Event;", "onChanged"})
    /* compiled from: AttachmentPickerFragment.kt */
    static final class j<T> implements Observer<com.iqoption.chat.viewmodel.TransitionViewModel.b> {
        final /* synthetic */ com.iqoption.chat.component.c $adapter;

        j(com.iqoption.chat.component.c cVar) {
            this.$adapter = cVar;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.chat.viewmodel.TransitionViewModel.b bVar) {
            if (bVar != null) {
                this.$adapter.b(bVar.Rw(), bVar.isHidden());
            }
        }
    }

    private final Bundle Pt() {
        kotlin.d dVar = this.aFm;
        kotlin.reflect.j jVar = apP[0];
        return (Bundle) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public static final /* synthetic */ BottomSheetBehavior a(a aVar) {
        BottomSheetBehavior bottomSheetBehavior = aVar.arB;
        if (bottomSheetBehavior == null) {
            kotlin.jvm.internal.h.lS("behavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ AttachmentPickerViewModel b(a aVar) {
        AttachmentPickerViewModel attachmentPickerViewModel = aVar.aFn;
        if (attachmentPickerViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return attachmentPickerViewModel;
    }

    private final int Pu() {
        return Pt().getInt("arg.savedInputMode");
    }

    private final void dw(int i) {
        Pt().putInt("arg.savedInputMode", i);
    }

    public void onAttach(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        super.onAttach(context);
        if (!(context instanceof com.iqoption.view.e)) {
            context = null;
        }
        com.iqoption.view.e eVar = (com.iqoption.view.e) context;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        Context context = getContext();
        if (!(context instanceof com.iqoption.view.e)) {
            context = null;
        }
        com.iqoption.view.e eVar = (com.iqoption.view.e) context;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    public boolean onBackPressed() {
        a(this, false, 1, null);
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        if (this.aFq == null) {
            close(false);
            return null;
        } else if (com.iqoption.core.ext.a.go("android.permission.READ_EXTERNAL_STORAGE")) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.h.d(requireActivity, "activity");
            Window window = requireActivity.getWindow();
            kotlin.jvm.internal.h.d(window, "activity.window");
            dw(window.getAttributes().softInputMode);
            requireActivity.getWindow().setSoftInputMode(32);
            cw cwVar = (cw) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_fragment_attachment_picker, viewGroup, false, 4, null);
            am.n(requireActivity);
            this.aFo = cwVar;
            CoordinatorLayout coordinatorLayout = cwVar.bmA;
            kotlin.jvm.internal.h.d(coordinatorLayout, "veil");
            Drawable background = coordinatorLayout.getBackground();
            kotlin.jvm.internal.h.d(background, "veil.background");
            com.iqoption.core.graphics.a.e eVar = new com.iqoption.core.graphics.a.e(background);
            coordinatorLayout = cwVar.bmA;
            kotlin.jvm.internal.h.d(coordinatorLayout, "veil");
            coordinatorLayout.setBackground(eVar);
            LinearLayout linearLayout = cwVar.bjl;
            kotlin.jvm.internal.h.d(linearLayout, "contentLayout");
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.design.widget.CoordinatorLayout.LayoutParams");
            }
            Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.design.widget.BottomSheetBehavior<android.view.View!>");
            }
            this.arB = (BottomSheetBehavior) behavior;
            BottomSheetBehavior bottomSheetBehavior = this.arB;
            if (bottomSheetBehavior == null) {
                kotlin.jvm.internal.h.lS("behavior");
            }
            bottomSheetBehavior.setBottomSheetCallback(new b(eVar, this, requireActivity, bundle));
            if (bundle == null) {
                eVar.dK(0);
                cwVar.bmA.postOnAnimation(new e(this, requireActivity, bundle));
            }
            AttachmentPickerViewModel QH = AttachmentPickerViewModel.aKc.QH();
            QH.setup();
            this.aFn = QH;
            com.iqoption.chat.component.c cVar = new com.iqoption.chat.component.c(new AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$3(this, requireActivity, bundle), new AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$4(this, requireActivity, bundle));
            AttachmentPickerViewModel attachmentPickerViewModel = this.aFn;
            if (attachmentPickerViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            LifecycleOwner lifecycleOwner = this;
            attachmentPickerViewModel.QB().observe(lifecycleOwner, new i(cVar));
            attachmentPickerViewModel = this.aFn;
            if (attachmentPickerViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            attachmentPickerViewModel.QC().observe(lifecycleOwner, new f(cwVar, this, requireActivity, bundle));
            attachmentPickerViewModel = this.aFn;
            if (attachmentPickerViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            attachmentPickerViewModel.QD().observe(lifecycleOwner, new aw(new AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$6(this, requireActivity, bundle), new AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$7(cVar, this, requireActivity, bundle)));
            TransitionViewModel.aLW.g(requireActivity).RF().observe(lifecycleOwner, new j(cVar));
            CoordinatorLayout coordinatorLayout2 = cwVar.bmA;
            kotlin.jvm.internal.h.d(coordinatorLayout2, "veil");
            coordinatorLayout2.setOnClickListener(new g(this, requireActivity, bundle));
            LinearLayout linearLayout2 = cwVar.bmw;
            kotlin.jvm.internal.h.d(linearLayout2, "btnGalleryOrSend");
            linearLayout2.setOnClickListener(new h(this, requireActivity, bundle));
            TextView textView = cwVar.bmv;
            kotlin.jvm.internal.h.d(textView, "btnChooseFile");
            textView.setOnClickListener(new c(this, requireActivity, bundle));
            RecyclerView recyclerView = cwVar.bmz;
            kotlin.jvm.internal.h.d(recyclerView, "previewList");
            com.iqoption.core.ext.a.b(recyclerView);
            cwVar.bmz.addItemDecoration(new com.iqoption.widget.h(com.iqoption.core.ext.a.c((ViewDataBinding) cwVar, (int) R.dimen.dp8)));
            recyclerView = cwVar.bmz;
            kotlin.jvm.internal.h.d(recyclerView, "previewList");
            recyclerView.setAdapter(cVar);
            getLifecycle().a(new ReadPermissionTracker(new d(this, requireActivity, bundle)));
            return cwVar.getRoot();
        } else {
            close(false);
            return null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (getView() != null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.h.d(requireActivity, "requireActivity()");
            requireActivity.getWindow().setSoftInputMode(Pu());
        }
        KH();
    }

    private final ImageView c(com.iqoption.chat.viewmodel.a aVar) {
        cw cwVar = this.aFo;
        if (cwVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View findViewWithTag = cwVar.bmz.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            by byVar = (by) com.iqoption.core.ext.a.findBinding(findViewWithTag);
            if (byVar != null) {
                return byVar.blY;
            }
        }
        return null;
    }

    private final ImageView d(com.iqoption.chat.viewmodel.a aVar) {
        cw cwVar = this.aFo;
        if (cwVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View findViewWithTag = cwVar.bmz.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            by byVar = (by) com.iqoption.core.ext.a.findBinding(findViewWithTag);
            if (byVar != null) {
                return byVar.blZ;
            }
        }
        return null;
    }

    static /* synthetic */ void a(a aVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        aVar.close(z);
    }

    private final void close(boolean z) {
        if (z) {
            BottomSheetBehavior bottomSheetBehavior = this.arB;
            if (bottomSheetBehavior == null) {
                kotlin.jvm.internal.h.lS("behavior");
            }
            bottomSheetBehavior.setState(4);
            return;
        }
        List list = this.aFr;
        if (list != null) {
            kotlin.jvm.a.b bVar = this.aFq;
            if (bVar != null) {
                l lVar = (l) bVar.invoke(list);
            }
        }
        com.iqoption.core.ext.a.p(this).popBackStack(TAG, 1);
    }

    static /* bridge */ /* synthetic */ void a(a aVar, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        aVar.a(list, z);
    }

    private final void a(List<? extends Uri> list, boolean z) {
        this.aFr = list;
        close(z);
    }

    private final void Pv() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI).setType("image/*");
        intent = Intent.createChooser(intent, getString(R.string.select_image));
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) new Intent[]{r1});
        startActivityForResult(intent, 1);
    }

    private final void Pw() {
        FragmentManager p = com.iqoption.core.ext.a.p(this);
        FragmentTransaction beginTransaction = p.beginTransaction();
        kotlin.jvm.internal.h.d(beginTransaction, "ft");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up_fast, R.anim.slide_out_down_fast, R.anim.slide_in_up_fast, R.anim.slide_out_down_fast);
        k f = k.aGl.f(new AttachmentPickerFragment$takeFile$$inlined$commitNow$lambda$1(this));
        String Ll = k.aGl.Ll();
        beginTransaction.add(R.id.dialogLayer, f, Ll);
        beginTransaction.addToBackStack(Ll);
        beginTransaction.commitAllowingStateLoss();
        p.executePendingTransactions();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1 && intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                a(this, l.cr(data), false, 2, null);
            }
        }
    }
}
