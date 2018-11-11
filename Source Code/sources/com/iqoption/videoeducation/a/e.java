package com.iqoption.videoeducation.a;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.d.alk;
import com.iqoption.videoeducation.g;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoCatalogViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/VideoEducationSimpleCategoryItemBinding;", "Lcom/iqoption/videoeducation/VideoCatalogItem;", "callback", "Lcom/iqoption/videoeducation/component/VideoCatalogViewHolder$Callback;", "imageWidth", "", "imageHeight", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/videoeducation/component/VideoCatalogViewHolder$Callback;IILandroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoCatalogViewHolder.kt */
public final class e extends c<alk, g> {
    private final b dzH;
    private final int imageHeight;
    private final int imageWidth;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoCatalogViewHolder$Callback;", "", "onItemClick", "", "item", "Lcom/iqoption/videoeducation/VideoCatalogItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideoCatalogViewHolder.kt */
    public interface b {
        void a(g gVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends com.iqoption.core.ext.g {
        final /* synthetic */ e dzI;

        public a(e eVar) {
            this.dzI = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            g gVar = (g) this.dzI.ZU();
            if (gVar != null) {
                this.dzI.dzH.a(gVar);
            }
        }
    }

    public e(b bVar, int i, int i2, ViewGroup viewGroup) {
        h.e(bVar, "callback");
        h.e(viewGroup, "parent");
        super(R.layout.video_education_simple_category_item, viewGroup);
        this.dzH = bVar;
        this.imageWidth = i;
        this.imageHeight = i2;
        ConstraintLayout constraintLayout = ((alk) getBinding()).axL;
        h.d(constraintLayout, "binding.content");
        constraintLayout.setOnClickListener(new a(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008d  */
    public void a(com.iqoption.d.alk r4, com.iqoption.videoeducation.g r5) {
        /*
        r3 = this;
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r4, r0);
        r0 = "item";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = r5.arK();
        if (r0 == 0) goto L_0x0042;
    L_0x0010:
        r0 = (java.lang.CharSequence) r0;
        r0 = r0.length();
        if (r0 <= 0) goto L_0x001a;
    L_0x0018:
        r0 = 1;
        goto L_0x001b;
    L_0x001a:
        r0 = 0;
    L_0x001b:
        if (r0 == 0) goto L_0x0042;
    L_0x001d:
        r0 = r4.aEt;
        r1 = "image";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = r0.getContext();
        r0 = com.squareup.picasso.Picasso.with(r0);
        r1 = r5.arK();
        r0 = r0.load(r1);
        r1 = r3.imageWidth;
        r2 = r3.imageHeight;
        r0 = r0.resize(r1, r2);
        r1 = r4.aEt;
        r0.into(r1);
        goto L_0x0048;
    L_0x0042:
        r0 = r4.aEt;
        r1 = 0;
        r0.setImageDrawable(r1);
    L_0x0048:
        r0 = r4.agA;
        r1 = "title";
        kotlin.jvm.internal.h.d(r0, r1);
        r1 = r5.getTitle();
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        r0 = r5.aHx();
        if (r0 == 0) goto L_0x007a;
    L_0x005f:
        r1 = r4.bUg;
        r2 = "videoCount";
        kotlin.jvm.internal.h.d(r1, r2);
        r0 = (java.lang.CharSequence) r0;
        r1.setText(r0);
        r0 = r4.bUg;
        r1 = "videoCount";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (android.view.View) r0;
        com.iqoption.core.ext.a.L(r0);
        goto L_0x0087;
    L_0x007a:
        r0 = r4.bUg;
        r1 = "videoCount";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (android.view.View) r0;
        com.iqoption.core.ext.a.M(r0);
    L_0x0087:
        r5 = r5.aHy();
        if (r5 == 0) goto L_0x00a6;
    L_0x008d:
        r0 = r4.bUf;
        r1 = "newVideoCount";
        kotlin.jvm.internal.h.d(r0, r1);
        r5 = (java.lang.CharSequence) r5;
        r0.setText(r5);
        r4 = r4.bUf;
        r5 = "newVideoCount";
        kotlin.jvm.internal.h.d(r4, r5);
        r4 = (android.view.View) r4;
        com.iqoption.core.ext.a.L(r4);
        goto L_0x00b2;
    L_0x00a6:
        r4 = r4.bUf;
        r5 = "newVideoCount";
        kotlin.jvm.internal.h.d(r4, r5);
        r4 = (android.view.View) r4;
        com.iqoption.core.ext.a.M(r4);
    L_0x00b2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.videoeducation.a.e.a(com.iqoption.d.alk, com.iqoption.videoeducation.g):void");
    }
}
