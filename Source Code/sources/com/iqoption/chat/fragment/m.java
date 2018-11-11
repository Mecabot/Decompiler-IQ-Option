package com.iqoption.chat.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.component.r;
import com.iqoption.chat.viewmodel.AttachmentPickerViewModel;
import com.iqoption.chat.viewmodel.TransitionViewModel;
import com.iqoption.d.dc;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+0\u000e2\b\b\u0002\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020/H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000¨\u0006?"}, aXE = {"Lcom/iqoption/chat/fragment/ImagePreviewSliderFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/ChatFragmentImagePreviewSliderBinding;", "chatName", "", "current", "Landroid/arch/lifecycle/MutableLiveData;", "", "getDestPreview", "Lkotlin/Function0;", "Landroid/widget/ImageView;", "getPreviewView", "Lkotlin/Function1;", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "getSelectorView", "getSourcePreview", "getSourceSelector", "images", "", "onSend", "Ljava/io/File;", "", "picasso", "Lcom/squareup/picasso/Picasso;", "skipSharedElements", "", "transition", "Lcom/iqoption/chat/component/ImagePreviewTransition;", "getTransition", "()Lcom/iqoption/chat/component/ImagePreviewTransition;", "transition$delegate", "Lkotlin/Lazy;", "transitionViewModel", "Lcom/iqoption/chat/viewmodel/TransitionViewModel;", "getTransitionViewModel", "()Lcom/iqoption/chat/viewmodel/TransitionViewModel;", "transitionViewModel$delegate", "viewModel", "Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel;", "close", "getDisplayer", "Lcom/squareup/picasso/RequestCreator;", "scale", "", "getHideAnimationDuration", "", "getPicasso", "getShowAnimationDuration", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "Companion", "ImagesAdapter", "Size", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ImagePreviewSliderFragment.kt */
public final class m extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.chat.fragment.m";
    public static final a aGK = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(m.class), "transitionViewModel", "getTransitionViewModel()Lcom/iqoption/chat/viewmodel/TransitionViewModel;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(m.class), "transition", "getTransition()Lcom/iqoption/chat/component/ImagePreviewTransition;"))};
    private dc aDy;
    private AttachmentPickerViewModel aFn;
    private String aFp = "";
    private kotlin.jvm.a.b<? super List<? extends File>, l> aFq;
    private final kotlin.d aGA = g.f(new ImagePreviewSliderFragment$transitionViewModel$2(this));
    private final kotlin.d aGB = g.f(new ImagePreviewSliderFragment$transition$2(this));
    private List<com.iqoption.chat.viewmodel.a> aGC = m.emptyList();
    private MutableLiveData<Integer> aGD = new MutableLiveData();
    private kotlin.jvm.a.b<? super com.iqoption.chat.viewmodel.a, ? extends ImageView> aGE;
    private kotlin.jvm.a.b<? super com.iqoption.chat.viewmodel.a, ? extends ImageView> aGF;
    private final kotlin.jvm.a.a<ImageView> aGG = new ImagePreviewSliderFragment$getSourcePreview$1(this);
    private final kotlin.jvm.a.a<ImageView> aGH = new ImagePreviewSliderFragment$getDestPreview$1(this);
    private final kotlin.jvm.a.a<ImageView> aGI = new ImagePreviewSliderFragment$getSourceSelector$1(this);
    private boolean aGJ;
    private HashMap atz;
    private Picasso picasso;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0012\u0004\u0012\u00020\u00160\u0011R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, aXE = {"Lcom/iqoption/chat/fragment/ImagePreviewSliderFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/ImagePreviewSliderFragment;", "chatName", "images", "", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "current", "", "getPreview", "Lkotlin/Function1;", "Landroid/widget/ImageView;", "getSelector", "onSend", "Ljava/io/File;", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return m.TAG;
        }

        public final m a(String str, List<com.iqoption.chat.viewmodel.a> list, int i, kotlin.jvm.a.b<? super com.iqoption.chat.viewmodel.a, ? extends ImageView> bVar, kotlin.jvm.a.b<? super com.iqoption.chat.viewmodel.a, ? extends ImageView> bVar2, kotlin.jvm.a.b<? super List<? extends File>, l> bVar3) {
            kotlin.jvm.internal.h.e(str, "chatName");
            kotlin.jvm.internal.h.e(list, "images");
            kotlin.jvm.internal.h.e(bVar, "getPreview");
            kotlin.jvm.internal.h.e(bVar2, "getSelector");
            kotlin.jvm.internal.h.e(bVar3, "onSend");
            m mVar = new m();
            mVar.setRetainInstance(true);
            mVar.aFp = str;
            mVar.aGC = list;
            mVar.aGD.setValue(Integer.valueOf(i));
            mVar.aGE = bVar;
            mVar.aGF = bVar2;
            mVar.aFq = bVar3;
            return mVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/chat/fragment/ImagePreviewSliderFragment$Size;", "", "w", "", "h", "(II)V", "getH", "()I", "getW", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    private static final class c {
        private final int h;
        private final int w;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if ((this.w == cVar.w ? 1 : null) != null) {
                    if ((this.h == cVar.h ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.w * 31) + this.h;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Size(w=");
            stringBuilder.append(this.w);
            stringBuilder.append(", h=");
            stringBuilder.append(this.h);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public c(int i, int i2) {
            this.w = i;
            this.h = i2;
        }

        public final int PP() {
            return this.w;
        }

        public final int PQ() {
            return this.h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/chat/fragment/ImagePreviewSliderFragment$ImagesAdapter;", "Landroid/support/v4/view/PagerAdapter;", "displayer", "Lkotlin/Function1;", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "Lcom/squareup/picasso/RequestCreator;", "images", "", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    private static final class b extends PagerAdapter {
        private final List<com.iqoption.chat.viewmodel.a> aGC;
        private final kotlin.jvm.a.b<com.iqoption.chat.viewmodel.a, RequestCreator> aGL;

        public b(kotlin.jvm.a.b<? super com.iqoption.chat.viewmodel.a, ? extends RequestCreator> bVar, List<com.iqoption.chat.viewmodel.a> list) {
            kotlin.jvm.internal.h.e(bVar, "displayer");
            kotlin.jvm.internal.h.e(list, "images");
            this.aGL = bVar;
            this.aGC = list;
        }

        public boolean isViewFromObject(View view, Object obj) {
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(obj, "object");
            return kotlin.jvm.internal.h.E(view, obj);
        }

        public int getCount() {
            return this.aGC.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            kotlin.jvm.internal.h.e(viewGroup, "container");
            AppCompatImageView appCompatImageView = new AppCompatImageView(viewGroup.getContext());
            appCompatImageView.setScaleType(ScaleType.CENTER_INSIDE);
            com.iqoption.chat.viewmodel.a aVar = (com.iqoption.chat.viewmodel.a) this.aGC.get(i);
            appCompatImageView.setTag(aVar);
            ((RequestCreator) this.aGL.invoke(aVar)).into((ImageView) appCompatImageView);
            viewGroup.addView(appCompatImageView);
            return appCompatImageView;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            kotlin.jvm.internal.h.e(viewGroup, "container");
            kotlin.jvm.internal.h.e(obj, "object");
            viewGroup.removeView((View) obj);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Integer;)V", "com/iqoption/chat/fragment/ImagePreviewSliderFragment$onCreateView$1$1"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    static final class d<T> implements Observer<Integer> {
        final /* synthetic */ dc aGN;
        final /* synthetic */ m this$0;

        d(dc dcVar, m mVar) {
            this.aGN = dcVar;
            this.this$0 = mVar;
        }

        /* renamed from: b */
        public final void onChanged(Integer num) {
            if (num != null) {
                if (num.intValue() == 0) {
                    num = Integer.valueOf(1);
                }
                TextView textView = this.aGN.agA;
                kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                m mVar = this.this$0;
                Object[] objArr = new Object[2];
                objArr[0] = this.this$0.getResources().getQuantityString(R.plurals.photos, num.intValue(), new Object[]{num});
                objArr[1] = this.this$0.aFp;
                textView.setText(mVar.getString(R.string.n1_photos_to_n2_chat, objArr));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/ImagePreviewSliderFragment$onCreateView$1$2", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    public static final class e implements OnPageChangeListener {
        final /* synthetic */ dc aGN;
        final /* synthetic */ m this$0;

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        e(dc dcVar, m mVar) {
            this.aGN = dcVar;
            this.this$0 = mVar;
        }

        public void onPageSelected(int i) {
            this.this$0.aGD.setValue(Integer.valueOf(i));
            ImageView imageView = this.aGN.blZ;
            kotlin.jvm.internal.h.d(imageView, "selector");
            imageView.setSelected(((com.iqoption.chat.viewmodel.a) this.this$0.aGC.get(i)).isSelected());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Integer;)V", "com/iqoption/chat/fragment/ImagePreviewSliderFragment$onCreateView$1$3"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    static final class f<T> implements Observer<Integer> {
        final /* synthetic */ dc aGN;
        final /* synthetic */ m this$0;

        f(dc dcVar, m mVar) {
            this.aGN = dcVar;
            this.this$0 = mVar;
        }

        /* renamed from: b */
        public final void onChanged(Integer num) {
            if (num != null) {
                ImageView imageView = this.aGN.blZ;
                kotlin.jvm.internal.h.d(imageView, "selector");
                imageView.setSelected(((com.iqoption.chat.viewmodel.a) this.this$0.aGC.get(num.intValue())).isSelected());
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/ImagePreviewSliderFragment$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class g extends com.iqoption.core.ext.g {
        final /* synthetic */ dc aGO;
        final /* synthetic */ m this$0;

        public g(dc dcVar, m mVar) {
            this.this$0 = mVar;
            this.aGO = dcVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            Integer num = (Integer) m.e(this.this$0).QC().getValue();
            kotlin.jvm.a.b f;
            l lVar;
            if (num != null && num.intValue() == 0) {
                f = this.this$0.aFq;
                if (f != null) {
                    List d = this.this$0.aGC;
                    ViewPager viewPager = this.aGO.bmI;
                    kotlin.jvm.internal.h.d(viewPager, "pager");
                    lVar = (l) f.invoke(l.cr(((com.iqoption.chat.viewmodel.a) d.get(viewPager.getCurrentItem())).getFile()));
                }
            } else {
                f = this.this$0.aFq;
                if (f != null) {
                    Collection arrayList = new ArrayList();
                    for (Object next : this.this$0.aGC) {
                        if (((com.iqoption.chat.viewmodel.a) next).isSelected()) {
                            arrayList.add(next);
                        }
                    }
                    Iterable<com.iqoption.chat.viewmodel.a> iterable = (List) arrayList;
                    Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                    for (com.iqoption.chat.viewmodel.a file : iterable) {
                        arrayList2.add(file.getFile());
                    }
                    lVar = (l) f.invoke((List) arrayList2);
                }
            }
            this.this$0.aGJ = true;
            this.this$0.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/ImagePreviewSliderFragment$$special$$inlined$setOnDelayedClickListener$2"})
    /* compiled from: AndroidExtensions.kt */
    public static final class h extends com.iqoption.core.ext.g {
        final /* synthetic */ dc aGO;
        final /* synthetic */ m this$0;

        public h(dc dcVar, m mVar) {
            this.this$0 = mVar;
            this.aGO = dcVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            List d = this.this$0.aGC;
            ViewPager viewPager = this.aGO.bmI;
            kotlin.jvm.internal.h.d(viewPager, "pager");
            com.iqoption.chat.viewmodel.a aVar = (com.iqoption.chat.viewmodel.a) d.get(viewPager.getCurrentItem());
            Integer num = (Integer) m.e(this.this$0).QC().getValue();
            if (num == null || num.intValue() != 3 || aVar.isSelected()) {
                m.e(this.this$0).g(aVar);
                ImageView imageView = this.aGO.blZ;
                imageView.setSelected(imageView.isSelected() ^ 1);
                kotlin.jvm.internal.h.d(imageView, "selector.apply { isSelected = !isSelected }");
                return;
            }
            com.iqoption.app.a.b.eQ(this.this$0.getString(R.string.you_can_send_maximum));
        }
    }

    private final TransitionViewModel PN() {
        kotlin.d dVar = this.aGA;
        j jVar = apP[0];
        return (TransitionViewModel) dVar.getValue();
    }

    private final r PO() {
        kotlin.d dVar = this.aGB;
        j jVar = apP[1];
        return (r) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ AttachmentPickerViewModel e(m mVar) {
        AttachmentPickerViewModel attachmentPickerViewModel = mVar.aFn;
        if (attachmentPickerViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return attachmentPickerViewModel;
    }

    public static final /* synthetic */ dc l(m mVar) {
        dc dcVar = mVar.aDy;
        if (dcVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return dcVar;
    }

    public void ND() {
        PO().TV();
    }

    public void NE() {
        PO().TW();
    }

    public long NF() {
        return PO().TQ();
    }

    public long NG() {
        return PO().TR();
    }

    private final Picasso getPicasso() {
        Picasso picasso = this.picasso;
        if (picasso != null) {
            return picasso;
        }
        picasso = Picasso.with(requireContext());
        this.picasso = picasso;
        kotlin.jvm.internal.h.d(picasso, "Picasso.with(requireCont…()).also { picasso = it }");
        return picasso;
    }

    static /* synthetic */ kotlin.jvm.a.b a(m mVar, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return mVar.q(f);
    }

    private final kotlin.jvm.a.b<com.iqoption.chat.viewmodel.a, RequestCreator> q(float f) {
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (c) null;
        ImagePreviewSliderFragment$getDisplayer$1 imagePreviewSliderFragment$getDisplayer$1 = new ImagePreviewSliderFragment$getDisplayer$1(this, objectRef, f);
        objectRef = new ObjectRef();
        objectRef.element = (Transformation) null;
        return new ImagePreviewSliderFragment$getDisplayer$3(this, imagePreviewSliderFragment$getDisplayer$1, f, new ImagePreviewSliderFragment$getDisplayer$2(objectRef, f, imagePreviewSliderFragment$getDisplayer$1));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        if (this.aGC.isEmpty()) {
            close();
            return null;
        } else if (this.aFq == null) {
            close();
            return null;
        } else {
            dc dcVar = (dc) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_fragment_image_preview_slider, viewGroup, false, 4, null);
            this.aDy = dcVar;
            this.aFn = AttachmentPickerViewModel.aKc.QH();
            AttachmentPickerViewModel attachmentPickerViewModel = this.aFn;
            if (attachmentPickerViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            LifecycleOwner lifecycleOwner = this;
            attachmentPickerViewModel.QC().observe(lifecycleOwner, new d(dcVar, this));
            View root = dcVar.getRoot();
            kotlin.jvm.internal.h.d(root, "root");
            View root2 = dcVar.getRoot();
            kotlin.jvm.internal.h.d(root2, "root");
            Drawable background = root2.getBackground();
            kotlin.jvm.internal.h.d(background, "root.background");
            root.setBackground(new com.iqoption.core.graphics.a.e(background));
            Object value = this.aGD.getValue();
            if (value == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            Integer num = (Integer) value;
            kotlin.jvm.a.b a = a(this, 0.0f, 1, null);
            q(0.25f);
            ViewPager viewPager = dcVar.bmI;
            kotlin.jvm.internal.h.d(viewPager, "pager");
            viewPager.setAdapter(new b(a, this.aGC));
            ViewPager viewPager2 = dcVar.bmI;
            kotlin.jvm.internal.h.d(viewPager2, "pager");
            kotlin.jvm.internal.h.d(num, "currentItem");
            viewPager2.setCurrentItem(num.intValue());
            dcVar.bmI.addOnPageChangeListener(new e(dcVar, this));
            this.aGD.observe(lifecycleOwner, new f(dcVar, this));
            ImageView imageView = dcVar.bmG;
            kotlin.jvm.internal.h.d(imageView, "btnSend");
            imageView.setOnClickListener(new g(dcVar, this));
            imageView = dcVar.blZ;
            kotlin.jvm.internal.h.d(imageView, "selector");
            imageView.setOnClickListener(new h(dcVar, this));
            return dcVar.getRoot();
        }
    }

    private final void close() {
        requireFragmentManager().popBackStack(TAG, 0);
    }
}
