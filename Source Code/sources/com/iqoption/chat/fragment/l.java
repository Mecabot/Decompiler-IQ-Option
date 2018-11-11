package com.iqoption.chat.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.d.da;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.x.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\u000f¨\u0006\""}, aXE = {"Lcom/iqoption/chat/fragment/ImagePreviewFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/ChatFragmentImagePreviewBinding;", "picasso", "Lcom/squareup/picasso/Picasso;", "kotlin.jvm.PlatformType", "getPicasso", "()Lcom/squareup/picasso/Picasso;", "picasso$delegate", "Lkotlin/Lazy;", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "subTitle$delegate", "url", "getUrl", "url$delegate", "close", "", "download", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEnterAnimation", "onExitAnimation", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ImagePreviewFragment.kt */
public final class l extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "com.iqoption.chat.fragment.l";
    public static final a aGr = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(l.class), PlusShare.KEY_CALL_TO_ACTION_URL, "getUrl()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(l.class), "subTitle", "getSubTitle()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(l.class), "picasso", "getPicasso()Lcom/squareup/picasso/Picasso;"))};
    private final kotlin.d aGn = g.f(new ImagePreviewFragment$url$2(this));
    private final kotlin.d aGo = g.f(new ImagePreviewFragment$subTitle$2(this));
    private final kotlin.d aGp = g.f(new ImagePreviewFragment$picasso$2(this));
    private da aGq;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/fragment/ImagePreviewFragment$Companion;", "", "()V", "ARG_SUBTITLE", "", "ARG_URL", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/ImagePreviewFragment;", "url", "subTitle", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return l.TAG;
        }

        public final l Y(String str, String str2) {
            h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            h.e(str2, "subTitle");
            l lVar = new l();
            Bundle bundle = new Bundle();
            bundle.putString("arg.url", str);
            bundle.putString("arg.subTitle", str2);
            lVar.setArguments(bundle);
            return lVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/ImagePreviewFragment$onCreateView$1$1"})
    /* compiled from: ImagePreviewFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ l this$0;

        b(l lVar) {
            this.this$0 = lVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/ImagePreviewFragment$onCreateView$1$2"})
    /* compiled from: ImagePreviewFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ l this$0;

        c(l lVar) {
            this.this$0 = lVar;
        }

        public final void onClick(View view) {
            this.this$0.PK();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0012¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/ImagePreviewFragment$onCreateView$1$3", "Landroid/view/View$OnTouchListener;", "background", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "edge", "", "skip", "", "startY", "viewsToMoveUp", "", "Landroid/view/View;", "[Landroid/view/View;", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewFragment.kt */
    public static final class d implements OnTouchListener {
        private final Drawable aGs;
        private final float aGt = com.iqoption.core.ext.a.b((ViewDataBinding) this.aGx, (int) R.dimen.dp100);
        private final View[] aGu;
        private float aGv;
        private boolean aGw;
        final /* synthetic */ da aGx;
        final /* synthetic */ l this$0;

        d(da daVar, l lVar) {
            this.aGx = daVar;
            this.this$0 = lVar;
            View root = this.aGx.getRoot();
            h.d(root, "root");
            this.aGs = root.getBackground();
            View[] viewArr = new View[4];
            ImageView imageView = this.aGx.awN;
            h.d(imageView, "btnBack");
            viewArr[0] = imageView;
            imageView = this.aGx.bmD;
            h.d(imageView, "btnDownload");
            viewArr[1] = imageView;
            TextView textView = this.aGx.agA;
            h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            viewArr[2] = textView;
            textView = this.aGx.bmE;
            h.d(textView, "subtitle");
            viewArr[3] = textView;
            this.aGu = viewArr;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.e(view, "v");
            h.e(motionEvent, "event");
            boolean z = false;
            float y;
            int length;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    y = motionEvent.getY();
                    ImageView imageView = this.aGx.blY;
                    h.d(imageView, "preview");
                    if (y < ((float) imageView.getTop())) {
                        z = true;
                    }
                    this.aGw = z;
                    this.aGv = motionEvent.getY();
                    break;
                case 1:
                case 3:
                    if (!this.aGw) {
                        if (Math.abs(motionEvent.getY() - this.aGv) < this.aGt) {
                            this.aGx.blY.animate().translationY(0.0f).start();
                            for (View animate : this.aGu) {
                                animate.animate().translationY(0.0f).start();
                            }
                            ObjectAnimator.ofInt(this.aGs, com.iqoption.core.graphics.animation.b.aQM.TD(), new int[]{255}).start();
                            break;
                        }
                        this.this$0.close();
                        break;
                    }
                    return true;
                case 2:
                    if (!this.aGw) {
                        y = motionEvent.getY() - this.aGv;
                        ImageView imageView2 = this.aGx.blY;
                        h.d(imageView2, "preview");
                        imageView2.setTranslationY(y);
                        View[] viewArr = this.aGu;
                        length = viewArr.length;
                        int i;
                        while (i < length) {
                            viewArr[i].setTranslationY(-Math.abs(y));
                            i++;
                        }
                        Drawable drawable = this.aGs;
                        h.d(drawable, "background");
                        drawable.setAlpha(c.ae(((float) 255) * (((float) 1) - com.iqoption.core.ext.c.a(Math.abs(y), this.aGt, 0.0f, 2, null))));
                        break;
                    }
                    return true;
            }
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core_release", "com/iqoption/chat/fragment/ImagePreviewFragment$$special$$inlined$doOnPreDraw$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class e implements OnPreDrawListener {
        final /* synthetic */ da aGy;
        final /* synthetic */ View aGz;
        final /* synthetic */ l this$0;

        public e(View view, da daVar, l lVar) {
            this.aGz = view;
            this.this$0 = lVar;
            this.aGy = daVar;
        }

        public boolean onPreDraw() {
            this.aGz.getViewTreeObserver().removeOnPreDrawListener(this);
            this.this$0.getPicasso().load(this.this$0.getUrl()).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(this.aGy.blY);
            return true;
        }
    }

    private final String PJ() {
        kotlin.d dVar = this.aGo;
        j jVar = apP[1];
        return (String) dVar.getValue();
    }

    private final Picasso getPicasso() {
        kotlin.d dVar = this.aGp;
        j jVar = apP[2];
        return (Picasso) dVar.getValue();
    }

    private final String getUrl() {
        kotlin.d dVar = this.aGn;
        j jVar = apP[0];
        return (String) dVar.getValue();
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

    @SuppressLint({"ClickableViewAccessibility"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        da daVar = (da) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_fragment_image_preview, viewGroup, false, 4, null);
        this.aGq = daVar;
        daVar.awN.setOnClickListener(new b(this));
        daVar.bmD.setOnClickListener(new c(this));
        TextView textView = daVar.bmE;
        h.d(textView, "subtitle");
        textView.setText(PJ());
        daVar.getRoot().setOnTouchListener(new d(daVar, this));
        View root = daVar.getRoot();
        h.d(root, "root");
        root.getViewTreeObserver().addOnPreDrawListener(new e(root, daVar, this));
        return daVar.getRoot();
    }

    private final void close() {
        com.iqoption.core.ext.a.p(this).popBackStack();
    }

    private final void PK() {
        Uri parse = Uri.parse(getUrl());
        DownloadManager bd = com.iqoption.core.ext.a.bd(com.iqoption.core.ext.a.m(this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ssid=");
        RequestManager atO = RequestManager.atO();
        h.d(atO, "RequestManager.getInstance()");
        stringBuilder.append(atO.atS());
        Request addRequestHeader = new Request(parse).addRequestHeader("Cookie", stringBuilder.toString());
        Context context = getContext();
        String str = Environment.DIRECTORY_DOWNLOADS;
        h.d(parse, "uri");
        bd.enqueue(addRequestHeader.setDestinationInExternalFilesDir(context, str, parse.getLastPathSegment()).setNotificationVisibility(1));
    }

    public void KF() {
        super.KF();
        AnimatorSet animatorSet = new AnimatorSet();
        List arrayList = new ArrayList();
        da daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        View root = daVar.getRoot();
        h.d(root, "binding.root");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(root.getBackground(), com.iqoption.core.graphics.animation.b.aQM.TD(), new int[]{0, 255});
        h.d(ofInt, "ObjectAnimator.ofInt(bin… Drawables.ALPHA, 0, 255)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.awN, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…Back, View.ALPHA, 0f, 1f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.bmD, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…load, View.ALPHA, 0f, 1f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.agA, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…itle, View.ALPHA, 0f, 1f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.bmE, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…itle, View.ALPHA, 0f, 1f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.blY, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…view, View.ALPHA, 0f, 1f)");
        arrayList.add(ofInt);
        animatorSet.playTogether(arrayList);
        com.iqoption.core.ext.a.a((Animator) animatorSet, Yw());
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        animatorSet.start();
    }

    public void KG() {
        super.KG();
        AnimatorSet animatorSet = new AnimatorSet();
        List arrayList = new ArrayList();
        da daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        View root = daVar.getRoot();
        h.d(root, "binding.root");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(root.getBackground(), com.iqoption.core.graphics.animation.b.aQM.TD(), new int[]{0});
        h.d(ofInt, "ObjectAnimator.ofInt(bin…ound, Drawables.ALPHA, 0)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.awN, View.ALPHA, new float[]{0.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b….btnBack, View.ALPHA, 0f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.bmD, View.ALPHA, new float[]{0.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…Download, View.ALPHA, 0f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.agA, View.ALPHA, new float[]{0.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…ng.title, View.ALPHA, 0f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ofInt = ObjectAnimator.ofFloat(daVar.bmE, View.ALPHA, new float[]{0.0f});
        h.d(ofInt, "ObjectAnimator.ofFloat(b…subtitle, View.ALPHA, 0f)");
        arrayList.add(ofInt);
        daVar = this.aGq;
        if (daVar == null) {
            h.lS("binding");
        }
        ImageView imageView = daVar.blY;
        r3 = new PropertyValuesHolder[3];
        r3[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        r3[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{2.0f});
        r3[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{2.0f});
        ofInt = ObjectAnimator.ofPropertyValuesHolder(imageView, r3);
        h.d(ofInt, "ObjectAnimator.ofPropert…fFloat(View.SCALE_Y, 2f))");
        arrayList.add(ofInt);
        animatorSet.playTogether(arrayList);
        com.iqoption.core.ext.a.a((Animator) animatorSet, Yx());
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        animatorSet.start();
    }
}
