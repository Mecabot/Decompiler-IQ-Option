package com.iqoption.videoeducation.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.d.alo;
import com.iqoption.videoeducation.m;
import com.iqoption.x.R;
import com.squareup.picasso.Transformation;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoItemViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/VideoEducationVideoItemBinding;", "Lcom/iqoption/videoeducation/VideoItem;", "callback", "Lcom/iqoption/videoeducation/component/VideoItemViewHolder$Callback;", "imageSize", "Lcom/iqoption/core/graphics/Size;", "transformation", "Lcom/squareup/picasso/Transformation;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/videoeducation/component/VideoItemViewHolder$Callback;Lcom/iqoption/core/graphics/Size;Lcom/squareup/picasso/Transformation;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoItemViewHolder.kt */
public final class h extends c<alo, m> {
    private final b dzL;
    private final com.iqoption.core.graphics.b dzM;
    private final Transformation dzN;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoItemViewHolder$Callback;", "", "onItemClick", "", "item", "Lcom/iqoption/videoeducation/VideoItem;", "position", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideoItemViewHolder.kt */
    public interface b {
        void a(m mVar, int i);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ h dzO;

        public a(h hVar) {
            this.dzO = hVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            Integer valueOf = Integer.valueOf(this.dzO.getAdapterPosition());
            if ((((Number) valueOf).intValue() != -1 ? 1 : null) == null) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                m mVar = (m) this.dzO.ZU();
                if (mVar != null) {
                    this.dzO.dzL.a(mVar, intValue);
                }
            }
        }
    }

    public h(b bVar, com.iqoption.core.graphics.b bVar2, Transformation transformation, ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(bVar, "callback");
        kotlin.jvm.internal.h.e(bVar2, "imageSize");
        kotlin.jvm.internal.h.e(transformation, "transformation");
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        super(R.layout.video_education_video_item, viewGroup);
        this.dzL = bVar;
        this.dzM = bVar2;
        this.dzN = transformation;
        ImageView imageView = ((alo) getBinding()).aEt;
        kotlin.jvm.internal.h.d(imageView, "binding.image");
        LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = this.dzM.getWidth();
        layoutParams.height = this.dzM.getHeight();
        View view = this.itemView;
        kotlin.jvm.internal.h.d(view, "itemView");
        view.setOnClickListener(new a(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009a  */
    public void a(com.iqoption.d.alo r5, com.iqoption.videoeducation.m r6) {
        /*
        r4 = this;
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = "item";
        kotlin.jvm.internal.h.e(r6, r0);
        r0 = r6.aHM();
        r1 = r0.XQ();
        if (r1 == 0) goto L_0x0055;
    L_0x0014:
        r2 = r1;
        r2 = (java.lang.CharSequence) r2;
        r2 = r2.length();
        if (r2 <= 0) goto L_0x001f;
    L_0x001d:
        r2 = 1;
        goto L_0x0020;
    L_0x001f:
        r2 = 0;
    L_0x0020:
        if (r2 == 0) goto L_0x0055;
    L_0x0022:
        r2 = r5.aEt;
        r3 = "image";
        kotlin.jvm.internal.h.d(r2, r3);
        r2 = r2.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r1 = r2.load(r1);
        r2 = r4.dzM;
        r2 = r2.getWidth();
        r3 = r4.dzM;
        r3 = r3.getHeight();
        r1 = r1.resize(r2, r3);
        r1 = r1.centerCrop();
        r2 = r4.dzN;
        r1 = r1.transform(r2);
        r2 = r5.aEt;
        r1.into(r2);
        goto L_0x005b;
    L_0x0055:
        r1 = r5.aEt;
        r2 = 0;
        r1.setImageDrawable(r2);
    L_0x005b:
        r1 = r0.XW();
        if (r1 == 0) goto L_0x007b;
    L_0x0061:
        r1 = r5.bjl;
        r2 = "contentLayout";
        kotlin.jvm.internal.h.d(r1, r2);
        r2 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r1.setAlpha(r2);
        r1 = r5.bUk;
        r2 = "watchedLabel";
        kotlin.jvm.internal.h.d(r1, r2);
        r1 = (android.view.View) r1;
        com.iqoption.core.ext.a.L(r1);
        goto L_0x0094;
    L_0x007b:
        r1 = r5.bjl;
        r2 = "contentLayout";
        kotlin.jvm.internal.h.d(r1, r2);
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.setAlpha(r2);
        r1 = r5.bUk;
        r2 = "watchedLabel";
        kotlin.jvm.internal.h.d(r1, r2);
        r1 = (android.view.View) r1;
        com.iqoption.core.ext.a.M(r1);
    L_0x0094:
        r1 = r0.XV();
        if (r1 == 0) goto L_0x00a7;
    L_0x009a:
        r1 = r5.bUj;
        r2 = "newLabel";
        kotlin.jvm.internal.h.d(r1, r2);
        r1 = (android.view.View) r1;
        com.iqoption.core.ext.a.L(r1);
        goto L_0x00b3;
    L_0x00a7:
        r1 = r5.bUj;
        r2 = "newLabel";
        kotlin.jvm.internal.h.d(r1, r2);
        r1 = (android.view.View) r1;
        com.iqoption.core.ext.a.M(r1);
    L_0x00b3:
        r1 = r5.agA;
        r2 = "title";
        kotlin.jvm.internal.h.d(r1, r2);
        r0 = r0.Mi();
        r0 = (java.lang.CharSequence) r0;
        r1.setText(r0);
        r5 = r5.bUi;
        r0 = "duration";
        kotlin.jvm.internal.h.d(r5, r0);
        r6 = r6.aHN();
        r6 = (java.lang.CharSequence) r6;
        r5.setText(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.videoeducation.a.h.a(com.iqoption.d.alo, com.iqoption.videoeducation.m):void");
    }
}
