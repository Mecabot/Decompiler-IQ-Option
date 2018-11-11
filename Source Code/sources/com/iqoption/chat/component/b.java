package com.iqoption.chat.component;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.core.ext.g;
import com.iqoption.d.by;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0002\u0010\fJ\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/chat/component/AttachmentPreviewViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "picasso", "Lcom/squareup/picasso/Picasso;", "binding", "Lcom/iqoption/databinding/ChatAttachmentImageItemBinding;", "onSelectorClick", "Lkotlin/Function2;", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "", "onPreviewClick", "", "(Lcom/squareup/picasso/Picasso;Lcom/iqoption/databinding/ChatAttachmentImageItemBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "<set-?>", "boundPreview", "getBoundPreview", "()Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "setBoundPreview", "(Lcom/iqoption/chat/viewmodel/AttachmentPreview;)V", "boundPreview$delegate", "Lkotlin/properties/ReadWriteProperty;", "bind", "preview", "isHidden", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AttachmentPreviewsAdapter.kt */
public final class b extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "boundPreview", "getBoundPreview()Lcom/iqoption/chat/viewmodel/AttachmentPreview;"))};
    private final d aCU = kotlin.e.a.euA.aYg();
    private final by aCV;
    private final m<by, com.iqoption.chat.viewmodel.a, Boolean> aCW;
    private final m<by, com.iqoption.chat.viewmodel.a, l> aCX;
    private final Picasso picasso;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ b aCY;

        public a(b bVar) {
            this.aCY = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            if (((Boolean) this.aCY.aCW.B(this.aCY.aCV, this.aCY.OA())).booleanValue()) {
                ImageView imageView = this.aCY.aCV.blZ;
                imageView.setSelected(imageView.isSelected() ^ 1);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ b aCY;

        public b(b bVar) {
            this.aCY = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.aCY.aCX.B(this.aCY.aCV, this.aCY.OA());
        }
    }

    private final com.iqoption.chat.viewmodel.a OA() {
        return (com.iqoption.chat.viewmodel.a) this.aCU.b(this, apP[0]);
    }

    private final void a(com.iqoption.chat.viewmodel.a aVar) {
        this.aCU.a(this, apP[0], aVar);
    }

    public b(Picasso picasso, by byVar, m<? super by, ? super com.iqoption.chat.viewmodel.a, Boolean> mVar, m<? super by, ? super com.iqoption.chat.viewmodel.a, l> mVar2) {
        h.e(picasso, "picasso");
        h.e(byVar, "binding");
        h.e(mVar, "onSelectorClick");
        h.e(mVar2, "onPreviewClick");
        super(byVar.getRoot());
        this.picasso = picasso;
        this.aCV = byVar;
        this.aCW = mVar;
        this.aCX = mVar2;
        ImageView imageView = this.aCV.blZ;
        h.d(imageView, "binding.selector");
        imageView.setOnClickListener(new a(this));
        imageView = this.aCV.blY;
        h.d(imageView, "binding.preview");
        imageView.setOnClickListener(new b(this));
    }

    public final void a(com.iqoption.chat.viewmodel.a aVar, boolean z) {
        h.e(aVar, "preview");
        a(aVar);
        View view = this.itemView;
        h.d(view, "itemView");
        view.setTag(aVar);
        ImageView imageView;
        if (z) {
            imageView = this.aCV.blY;
            h.d(imageView, "binding.preview");
            com.iqoption.core.ext.a.hide(imageView);
            imageView = this.aCV.blZ;
            h.d(imageView, "binding.selector");
            com.iqoption.core.ext.a.hide(imageView);
        } else {
            imageView = this.aCV.blY;
            h.d(imageView, "binding.preview");
            com.iqoption.core.ext.a.L(imageView);
            imageView = this.aCV.blZ;
            h.d(imageView, "binding.selector");
            com.iqoption.core.ext.a.L(imageView);
        }
        this.picasso.load(aVar.getFile()).resizeDimen(R.dimen.dp106, R.dimen.dp106).centerCrop().into(this.aCV.blY);
        ImageView imageView2 = this.aCV.blZ;
        h.d(imageView2, "binding.selector");
        imageView2.setSelected(OA().isSelected());
    }
}
