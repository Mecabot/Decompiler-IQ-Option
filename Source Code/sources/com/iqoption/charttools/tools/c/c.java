package com.iqoption.charttools.tools.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.tools.data.m;
import com.iqoption.core.ext.g;
import com.iqoption.d.vr;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0014\u0010\f\u001a\u00020\n*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/IndicatorTitleViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/IndicatorTitleItemBinding;", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "callback", "Lcom/iqoption/charttools/tools/viewholder/IndicatorTitleViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/tools/viewholder/IndicatorTitleViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "bindImage", "Landroid/widget/ImageView;", "icon", "Lcom/iqoption/core/data/model/UrlOrRes;", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IndicatorTitleViewHolder.kt */
public final class c extends com.iqoption.core.ui.widget.recyclerview.a.c<vr, m> {
    private final a aCy;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/IndicatorTitleViewHolder$Callback;", "", "onItemClick", "", "item", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "onItemFavoriteButtonClick", "onItemInfoButtonClick", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorTitleViewHolder.kt */
    public interface a {
        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/tools/viewholder/IndicatorTitleViewHolder$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorTitleViewHolder.kt */
    public static final class b extends g {
        final /* synthetic */ c aCz;

        b(c cVar) {
            this.aCz = cVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            m mVar = (m) this.aCz.ZU();
            if (mVar != null) {
                int id = view.getId();
                if (id == R.id.btnFavorites) {
                    this.aCz.aCy.e(mVar);
                } else if (id == R.id.btnInfo) {
                    this.aCz.aCy.d(mVar);
                } else if (id == R.id.content) {
                    this.aCz.aCy.c(mVar);
                }
            }
        }
    }

    public c(a aVar, ViewGroup viewGroup) {
        h.e(aVar, "callback");
        h.e(viewGroup, "parent");
        super(R.layout.indicator_title_item, viewGroup);
        this.aCy = aVar;
        OnClickListener bVar = new b(this);
        ((vr) getBinding()).avm.setOnClickListener(bVar);
        ((vr) getBinding()).bIp.setOnClickListener(bVar);
        ((vr) getBinding()).bIo.setOnClickListener(bVar);
    }

    public void a(vr vrVar, m mVar) {
        h.e(vrVar, "$receiver");
        h.e(mVar, "item");
        ImageView imageView = vrVar.bmu;
        h.d(imageView, "icon");
        a(imageView, mVar.Mj());
        TextView textView = vrVar.agA;
        h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView.setText(mVar.getTitle());
        LinearLayout linearLayout = vrVar.avm;
        h.d(linearLayout, com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
        linearLayout.setEnabled(mVar.isAvailable());
        imageView = vrVar.bIp;
        h.d(imageView, "btnInfo");
        imageView.setSelected(mVar.isExpanded());
        imageView = vrVar.bIo;
        h.d(imageView, "btnFavorites");
        imageView.setSelected(mVar.Ok());
        ImageView imageView2;
        if (mVar.getInfo() != null) {
            imageView2 = vrVar.bIp;
            h.d(imageView2, "btnInfo");
            com.iqoption.core.ext.a.L(imageView2);
            return;
        }
        imageView2 = vrVar.bIp;
        h.d(imageView2, "btnInfo");
        com.iqoption.core.ext.a.M(imageView2);
    }

    private final void a(ImageView imageView, com.iqoption.core.data.model.c cVar) {
        if (cVar.getUrl() != null) {
            Picasso.with(imageView.getContext()).load(cVar.getUrl()).placeholder((int) R.drawable.circle_grey_blur_10).into(imageView);
            return;
        }
        Picasso.with(imageView.getContext()).cancelRequest(imageView);
        imageView.setImageResource(cVar.getResId());
    }
}
