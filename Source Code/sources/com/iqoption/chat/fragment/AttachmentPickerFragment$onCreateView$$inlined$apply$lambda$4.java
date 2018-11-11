package com.iqoption.chat.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import com.iqoption.chat.viewmodel.a;
import com.iqoption.d.by;
import com.iqoption.x.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.l;
import kotlin.reflect.d;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/iqoption/databinding/ChatAttachmentImageItemBinding;", "preview", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "invoke", "com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$adapter$2"})
/* compiled from: AttachmentPickerFragment.kt */
final class AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$4 extends Lambda implements m<by, a, l> {
    final /* synthetic */ FragmentActivity $activity$inlined;
    final /* synthetic */ Bundle $savedInstanceState$inlined;
    final /* synthetic */ a this$0;

    AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$4(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
        this.this$0 = aVar;
        this.$activity$inlined = fragmentActivity;
        this.$savedInstanceState$inlined = bundle;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        b((by) obj, (a) obj2);
        return l.etX;
    }

    public final void b(by byVar, final a aVar) {
        h.e(byVar, "<anonymous parameter 0>");
        h.e(aVar, "preview");
        final List list = (List) a.b(this.this$0).QB().getValue();
        if (list != null && (list.isEmpty() ^ 1) != 0) {
            FragmentManager requireFragmentManager = this.this$0.requireFragmentManager();
            h.d(requireFragmentManager, "requireFragmentManager()");
            FragmentTransaction beginTransaction = requireFragmentManager.beginTransaction();
            h.d(beginTransaction, "ft");
            m a = m.aGK.a(this.this$0.aFp, list, list.indexOf(aVar), new b<a, ImageView>(this.this$0) {
                public final d Py() {
                    return j.F(a.class);
                }

                public final String getName() {
                    return "getPreviewView";
                }

                public final String getSignature() {
                    return "getPreviewView(Lcom/iqoption/chat/viewmodel/AttachmentPreview;)Landroid/widget/ImageView;";
                }

                /* renamed from: e */
                public final ImageView invoke(a aVar) {
                    h.e(aVar, "p1");
                    return ((a) this.receiver).c(aVar);
                }
            }, new b<a, ImageView>(this.this$0) {
                public final d Py() {
                    return j.F(a.class);
                }

                public final String getName() {
                    return "getSelectorView";
                }

                public final String getSignature() {
                    return "getSelectorView(Lcom/iqoption/chat/viewmodel/AttachmentPreview;)Landroid/widget/ImageView;";
                }

                /* renamed from: e */
                public final ImageView invoke(a aVar) {
                    h.e(aVar, "p1");
                    return ((a) this.receiver).d(aVar);
                }
            }, new b<List<? extends File>, l>(this) {
                final /* synthetic */ AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$4 this$0;

                public /* synthetic */ Object invoke(Object obj) {
                    P((List) obj);
                    return l.etX;
                }

                public final void P(List<? extends File> list) {
                    h.e(list, "it");
                    a aVar = this.this$0.this$0;
                    Iterable<File> iterable = list;
                    Collection arrayList = new ArrayList(n.e(iterable, 10));
                    for (File fromFile : iterable) {
                        arrayList.add(Uri.fromFile(fromFile));
                    }
                    aVar.a((List) arrayList, false);
                }
            });
            String Ll = m.aGK.Ll();
            beginTransaction.add(R.id.dialogLayer, a, Ll);
            beginTransaction.addToBackStack(Ll);
            beginTransaction.commitAllowingStateLoss();
            requireFragmentManager.executePendingTransactions();
        }
    }
}
