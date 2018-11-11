package com.iqoption.videoeducation.a;

import android.content.res.ColorStateList;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.ext.g;
import com.iqoption.core.f;
import com.iqoption.d.alm;
import com.iqoption.videoeducation.n;
import com.iqoption.x.R;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/videoeducation/component/TagItemViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/VideoEducationTagItemBinding;", "Lcom/iqoption/videoeducation/VideoTagItem;", "callback", "Lcom/iqoption/videoeducation/component/TagItemViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/videoeducation/component/TagItemViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TagItemViewHolder.kt */
public final class a extends com.iqoption.core.ui.widget.recyclerview.a.c<alm, n> {
    private static final ColorStateList dzC = ColorStateList.valueOf(f.getColor(R.color.green));
    private static final ColorStateList dzD = ColorStateList.valueOf(f.getColor(R.color.grey_blue_50));
    @Deprecated
    public static final c dzE = new c();
    private final b dzB;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/videoeducation/component/TagItemViewHolder$Callback;", "", "onItemClick", "", "item", "Lcom/iqoption/videoeducation/VideoTagItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TagItemViewHolder.kt */
    public interface b {
        void a(n nVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, aXE = {"Lcom/iqoption/videoeducation/component/TagItemViewHolder$Companion;", "", "()V", "COLOR_ACTIVATED", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "getCOLOR_ACTIVATED", "()Landroid/content/res/ColorStateList;", "COLOR_DEACTIVATED", "getCOLOR_DEACTIVATED", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TagItemViewHolder.kt */
    private static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ a dzF;

        public a(a aVar) {
            this.dzF = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            n nVar = (n) this.dzF.ZU();
            if (nVar != null) {
                this.dzF.dzB.a(nVar);
            }
        }
    }

    public a(b bVar, ViewGroup viewGroup) {
        h.e(bVar, "callback");
        h.e(viewGroup, "parent");
        super(R.layout.video_education_tag_item, viewGroup);
        this.dzB = bVar;
        View view = this.itemView;
        h.d(view, "itemView");
        view.setOnClickListener(new a(this));
    }

    public void a(alm alm, n nVar) {
        h.e(alm, "$receiver");
        h.e(nVar, "item");
        TextView textView = alm.aip;
        h.d(textView, "text");
        m mVar = m.euz;
        Object[] objArr = new Object[]{nVar.aHO().Mi()};
        String format = String.format("# %s", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        TextView textView2;
        if (nVar.isSelected()) {
            textView2 = alm.aip;
            h.d(textView2, "text");
            textView2.setAlpha(1.0f);
            ViewCompat.setBackgroundTintList(alm.aip, dzC);
            return;
        }
        textView2 = alm.aip;
        h.d(textView2, "text");
        textView2.setAlpha(0.7f);
        ViewCompat.setBackgroundTintList(alm.aip, dzD);
    }
}
