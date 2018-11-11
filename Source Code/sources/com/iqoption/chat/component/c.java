package com.iqoption.chat.component;

import android.content.Context;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.iqoption.chat.viewmodel.a;
import com.iqoption.d.by;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\u0016\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0006R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, aXE = {"Lcom/iqoption/chat/component/AttachmentPreviewsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/chat/component/AttachmentPreviewViewHolder;", "onSelectorClick", "Lkotlin/Function2;", "Lcom/iqoption/databinding/ChatAttachmentImageItemBinding;", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "", "onPreviewClick", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "hidden", "picasso", "Lcom/squareup/picasso/Picasso;", "previews", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemCount", "", "getItemId", "", "position", "getPicasso", "context", "Landroid/content/Context;", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "setData", "new", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "setHidden", "preview", "isHidden", "update", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AttachmentPreviewsAdapter.kt */
public final class c extends Adapter<b> {
    private final m<by, a, Boolean> aCW;
    private final m<by, a, l> aCX;
    private final List<a> aCZ = new ArrayList();
    private a aDa;
    private RecyclerView ahx;
    private Picasso picasso;

    public c(m<? super by, ? super a, Boolean> mVar, m<? super by, ? super a, l> mVar2) {
        h.e(mVar, "onSelectorClick");
        h.e(mVar2, "onPreviewClick");
        this.aCW = mVar;
        this.aCX = mVar2;
    }

    private final Picasso bb(Context context) {
        Picasso picasso = this.picasso;
        if (picasso != null) {
            return picasso;
        }
        picasso = Picasso.with(context);
        this.picasso = picasso;
        h.d(picasso, "Picasso.with(context).also { picasso = it }");
        return picasso;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.ahx = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = (RecyclerView) null;
    }

    public long getItemId(int i) {
        return (long) ((a) this.aCZ.get(i)).getFile().hashCode();
    }

    public int getItemCount() {
        return this.aCZ.size();
    }

    /* renamed from: k */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        Context context = viewGroup.getContext();
        h.d(context, "parent.context");
        return new b(bb(context), (by) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.chat_attachment_image_item, null, false, 6, null), this.aCW, this.aCX);
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        h.e(bVar, "holder");
        a aVar = (a) this.aCZ.get(i);
        bVar.a(aVar, h.E(aVar, this.aDa));
    }

    public static /* bridge */ /* synthetic */ void a(c cVar, List list, DiffResult diffResult, int i, Object obj) {
        if ((i & 2) != 0) {
            diffResult = (DiffResult) null;
        }
        cVar.a(list, diffResult);
    }

    public final void a(List<a> list, DiffResult diffResult) {
        h.e(list, "new");
        com.iqoption.core.ext.c.b((Collection) this.aCZ, (Collection) list);
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo((Adapter) this);
        } else {
            notifyDataSetChanged();
        }
    }

    public final void b(a aVar) {
        h.e(aVar, "preview");
        int indexOf = this.aCZ.indexOf(aVar);
        if (indexOf != -1) {
            notifyItemChanged(indexOf);
        }
    }

    public final void b(a aVar, boolean z) {
        h.e(aVar, "preview");
        this.aDa = z ? aVar : null;
        b(aVar);
    }
}
