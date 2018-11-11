package com.iqoption.chat.component;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.viewmodel.c;
import com.iqoption.core.ext.g;
import com.iqoption.d.cu;
import com.iqoption.x.R;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/component/FileItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/ChatFilePickerItemBinding;", "onSelect", "Lkotlin/Function1;", "Lcom/iqoption/chat/viewmodel/FileItem;", "", "(Lcom/iqoption/databinding/ChatFilePickerItemBinding;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "boundItem", "getBoundItem", "()Lcom/iqoption/chat/viewmodel/FileItem;", "setBoundItem", "(Lcom/iqoption/chat/viewmodel/FileItem;)V", "boundItem$delegate", "Lkotlin/properties/ReadWriteProperty;", "bind", "item", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FileItemsAdapter.kt */
public final class h extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "boundItem", "getBoundItem()Lcom/iqoption/chat/viewmodel/FileItem;"))};
    private final d aDc = kotlin.e.a.euA.aYg();
    private final cu aDd;
    private final b<c, l> aDe;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ h aDf;

        public a(h hVar) {
            this.aDf = hVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.aDf.aDe.invoke(this.aDf.OB());
        }
    }

    private final c OB() {
        return (c) this.aDc.b(this, apP[0]);
    }

    private final void a(c cVar) {
        this.aDc.a(this, apP[0], cVar);
    }

    public h(cu cuVar, b<? super c, l> bVar) {
        kotlin.jvm.internal.h.e(cuVar, "binding");
        kotlin.jvm.internal.h.e(bVar, "onSelect");
        super(cuVar.getRoot());
        this.aDd = cuVar;
        this.aDe = bVar;
        View root = this.aDd.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.root");
        root.setOnClickListener(new a(this));
    }

    public final void b(c cVar) {
        kotlin.jvm.internal.h.e(cVar, "item");
        a(cVar);
        cu cuVar = this.aDd;
        if (cVar.getFile().isDirectory()) {
            cuVar.bmu.setImageResource(R.drawable.chat_file_picker_item_folder_icon);
            cuVar.biD.setText(R.string.folder);
        } else {
            CharSequence stringBuilder;
            cuVar.bmu.setImageResource(R.drawable.chat_file_picker_item_file_icon);
            String size = cVar.getSize();
            if (size == null) {
                size = "";
            }
            String QJ = cVar.QJ();
            if (QJ == null) {
                QJ = "";
            }
            TextView textView = cuVar.biD;
            kotlin.jvm.internal.h.d(textView, "snippet");
            CharSequence charSequence = size;
            Object obj = null;
            if ((charSequence.length() > 0 ? 1 : null) != null) {
                if ((((CharSequence) QJ).length() > 0 ? 1 : null) != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(size);
                    stringBuilder2.append(", ");
                    stringBuilder2.append(QJ);
                    stringBuilder = stringBuilder2.toString();
                    textView.setText(stringBuilder);
                }
            }
            if (charSequence.length() > 0) {
                obj = 1;
            }
            if (obj == null) {
                size = QJ;
            }
            stringBuilder = size;
            textView.setText(stringBuilder);
        }
        TextView textView2 = cuVar.agA;
        kotlin.jvm.internal.h.d(textView2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView2.setText(cVar.getFile().getName());
    }
}
