package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Environment;
import android.support.v4.app.Fragment;
import com.google.common.collect.Ordering;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/chat/viewmodel/FilePickerViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "currentFolder", "Ljava/io/File;", "kotlin.jvm.PlatformType", "fileItems", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/chat/viewmodel/FileItem;", "getFileItems", "()Landroid/arch/lifecycle/LiveData;", "fileItemsData", "Landroid/arch/lifecycle/MutableLiveData;", "isEmpty", "", "isEmptyData", "openFolderTask", "Lio/reactivex/disposables/Disposable;", "canGoUp", "goUp", "", "openFolder", "folder", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FilePickerViewModel.kt */
public final class FilePickerViewModel extends ViewModel {
    private static final Ordering<File> ORDERING = Ordering.from((Comparator) b.aKt).compound((Comparator) Ordering.natural());
    private static final String TAG = "FilePickerViewModel";
    private static final File aKr = Environment.getExternalStorageDirectory();
    public static final a aKs = new a();
    private File aKl = aKr;
    private final MutableLiveData<List<c>> aKm;
    private final MutableLiveData<Boolean> aKn;
    private io.reactivex.disposables.b aKo;
    private final LiveData<List<c>> aKp;
    private final LiveData<Boolean> aKq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, aXE = {"Lcom/iqoption/chat/viewmodel/FilePickerViewModel$Companion;", "", "()V", "ORDERING", "Lcom/google/common/collect/Ordering;", "Ljava/io/File;", "kotlin.jvm.PlatformType", "ROOT_FOLDER", "TAG", "", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/chat/viewmodel/FilePickerViewModel;", "f", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FilePickerViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return FilePickerViewModel.TAG;
        }

        public final FilePickerViewModel i(Fragment fragment) {
            h.e(fragment, "f");
            return (FilePickerViewModel) ViewModelProviders.d(fragment).h(FilePickerViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "f1", "Ljava/io/File;", "kotlin.jvm.PlatformType", "f2", "compare"})
    /* compiled from: FilePickerViewModel.kt */
    static final class b<T> implements Comparator<T> {
        public static final b aKt = new b();

        b() {
        }

        public final int compare(File file, File file2) {
            h.d(file, "f1");
            if (file.isDirectory()) {
                h.d(file2, "f2");
                if (!file2.isDirectory()) {
                    return -1;
                }
            }
            if (!file.isDirectory()) {
                h.d(file2, "f2");
                if (file2.isDirectory()) {
                    return 1;
                }
            }
            return 0;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "it", "Lio/reactivex/SingleEmitter;", "", "Lcom/iqoption/chat/viewmodel/FileItem;", "kotlin.jvm.PlatformType", "subscribe"})
    /* compiled from: FilePickerViewModel.kt */
    static final class c<T> implements r<T> {
        final /* synthetic */ File aKu;

        c(File file) {
            this.aKu = file;
        }

        public final void a(p<List<c>> pVar) {
            h.e(pVar, "it");
            if (com.iqoption.core.ext.a.go("android.permission.READ_EXTERNAL_STORAGE")) {
                Object listFiles = this.aKu.listFiles();
                h.d(listFiles, "folder\n                 …             .listFiles()");
                Ordering QO = FilePickerViewModel.ORDERING;
                h.d(QO, "ORDERING");
                Iterable<File> c = i.c((Object[]) listFiles, (Comparator) QO);
                Collection arrayList = new ArrayList(n.e(c, 10));
                for (File file : c) {
                    h.d(file, "it");
                    arrayList.add(new c(file));
                }
                pVar.onSuccess((List) arrayList);
                return;
            }
            pVar.onError(new SecurityException("Permission android.permission.READ_EXTERNAL_STORAGE is denied"));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/chat/viewmodel/FileItem;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FilePickerViewModel.kt */
    static final class d<T> implements io.reactivex.c.e<List<? extends c>> {
        final /* synthetic */ FilePickerViewModel aKv;

        d(FilePickerViewModel filePickerViewModel) {
            this.aKv = filePickerViewModel;
        }

        /* renamed from: C */
        public final void accept(List<c> list) {
            this.aKv.aKm.setValue(list);
            this.aKv.aKn.setValue(Boolean.valueOf(list.isEmpty()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FilePickerViewModel.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        public static final e aKw = new e();

        e() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(FilePickerViewModel.aKs.Ll(), th.getMessage(), th);
        }
    }

    public FilePickerViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(m.emptyList());
        this.aKm = mutableLiveData;
        mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Boolean.valueOf(false));
        this.aKn = mutableLiveData;
        this.aKp = this.aKm;
        this.aKq = this.aKn;
    }

    public final LiveData<List<c>> QK() {
        return this.aKp;
    }

    public final LiveData<Boolean> QL() {
        return this.aKq;
    }

    public final boolean QM() {
        File file = this.aKl;
        h.d(file, "currentFolder");
        String path = file.getPath();
        File file2 = aKr;
        h.d(file2, "ROOT_FOLDER");
        return h.E(path, file2.getPath()) ^ 1;
    }

    public final void QN() {
        File file = this.aKl;
        h.d(file, "currentFolder");
        file = file.getParentFile();
        h.d(file, "currentFolder.parentFile");
        r(file);
    }

    public static /* synthetic */ void a(FilePickerViewModel filePickerViewModel, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            file = aKr;
            h.d(file, "ROOT_FOLDER");
        }
        filePickerViewModel.r(file);
    }

    public final void r(File file) {
        h.e(file, "folder");
        this.aKl = file;
        this.aKm.setValue(m.emptyList());
        this.aKn.setValue(Boolean.valueOf(false));
        io.reactivex.disposables.b bVar = this.aKo;
        if (bVar != null) {
            bVar.dispose();
        }
        this.aKo = o.a((r) new c(file)).g(com.iqoption.core.h.i.Yp()).h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new d(this), (io.reactivex.c.e) e.aKw);
    }
}
