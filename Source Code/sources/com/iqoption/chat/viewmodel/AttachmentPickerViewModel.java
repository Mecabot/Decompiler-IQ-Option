package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import io.reactivex.c.e;
import io.reactivex.c.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\b¨\u0006\u0018"}, aXE = {"Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "previews", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "getPreviews", "()Landroid/arch/lifecycle/LiveData;", "previewsData", "Landroid/arch/lifecycle/MutableLiveData;", "selectEvent", "Lcom/iqoption/chat/viewmodel/SelectEvent;", "getSelectEvent", "selectEventData", "selectedCount", "", "getSelectedCount", "loadPreviews", "", "setup", "toggle", "preview", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AttachmentPickerViewModel.kt */
public final class AttachmentPickerViewModel extends ViewModel {
    private static final String TAG = "AttachmentPickerViewModel";
    private static final kotlin.d aKb = g.f(AttachmentPickerViewModel$Companion$instance$2.aKd);
    public static final a aKc = new a();
    private final MutableLiveData<List<a>> aJZ;
    private final MutableLiveData<f> aKa;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, aXE = {"Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel$Companion;", "", "()V", "SELECTED_MAX", "", "TAG", "", "kotlin.jvm.PlatformType", "instance", "Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel;", "getInstance", "()Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel;", "instance$delegate", "Lkotlin/Lazy;", "get", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: AttachmentPickerViewModel.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "instance", "getInstance()Lcom/iqoption/chat/viewmodel/AttachmentPickerViewModel;"))};

        private final AttachmentPickerViewModel QG() {
            kotlin.d QF = AttachmentPickerViewModel.aKb;
            j jVar = apP[0];
            return (AttachmentPickerViewModel) QF.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final AttachmentPickerViewModel QH() {
            return QG();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "it", "Ljava/io/File;", "apply"})
    /* compiled from: AttachmentPickerViewModel.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aKe = new b();

        b() {
        }

        /* renamed from: m */
        public final List<a> apply(List<? extends File> list) {
            h.e(list, "it");
            Iterable<File> g = u.g(list, 10);
            Collection arrayList = new ArrayList(n.e(g, 10));
            for (File aVar : g) {
                arrayList.add(new a(aVar));
            }
            return (List) arrayList;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: AttachmentPickerViewModel.kt */
    static final class c<T> implements e<List<? extends a>> {
        final /* synthetic */ AttachmentPickerViewModel aKf;

        c(AttachmentPickerViewModel attachmentPickerViewModel) {
            this.aKf = attachmentPickerViewModel;
        }

        /* renamed from: C */
        public final void accept(List<a> list) {
            this.aKf.aJZ.postValue(list);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: AttachmentPickerViewModel.kt */
    static final class d<T> implements e<Throwable> {
        public static final d aKg = new d();

        d() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(AttachmentPickerViewModel.TAG, th.getMessage(), th);
        }
    }

    private AttachmentPickerViewModel() {
        this.aJZ = new MutableLiveData();
        this.aKa = new MutableLiveData();
    }

    public /* synthetic */ AttachmentPickerViewModel(f fVar) {
        this();
    }

    public final void setup() {
        g.aLK.clear();
    }

    public final LiveData<List<a>> QB() {
        return this.aJZ;
    }

    public final LiveData<Integer> QC() {
        return g.aLK.Rx();
    }

    public final LiveData<f> QD() {
        return this.aKa;
    }

    public final void g(a aVar) {
        h.e(aVar, "preview");
        aVar.setSelected(aVar.isSelected() ^ 1);
        this.aKa.setValue(new f(aVar, 0, 2, null));
    }

    public final void QE() {
        com.iqoption.chat.e.aCP.Ow().n(b.aKe).g(com.iqoption.core.h.i.Yp()).h(com.iqoption.core.h.i.Yo()).a((e) new c(this), (e) d.aKg);
    }
}
