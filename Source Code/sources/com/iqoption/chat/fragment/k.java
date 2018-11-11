package com.iqoption.chat.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.chat.component.ReadPermissionTracker;
import com.iqoption.chat.viewmodel.FilePickerViewModel;
import com.iqoption.d.cy;
import com.iqoption.util.fragmentstack.e;
import com.iqoption.x.R;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006!"}, aXE = {"Lcom/iqoption/chat/fragment/FilePickerFragment;", "Lcom/iqoption/util/fragmentstack/VisibilityAwareFragment;", "Lcom/iqoption/chat/component/ReadPermissionTracker$Callback;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "binding", "Lcom/iqoption/databinding/ChatFragmentFilePickerBinding;", "onSelect", "Lkotlin/Function1;", "Ljava/io/File;", "", "viewModel", "Lcom/iqoption/chat/viewmodel/FilePickerViewModel;", "close", "closeSuccess", "file", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDenied", "onDetach", "onGranted", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FilePickerFragment.kt */
public final class k extends e implements com.iqoption.chat.component.ReadPermissionTracker.a, com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.chat.fragment.k";
    public static final a aGl = new a();
    private kotlin.jvm.a.b<? super File, l> aDe;
    private cy aGj;
    private FilePickerViewModel aGk;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/fragment/FilePickerFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/FilePickerFragment;", "onSelect", "Lkotlin/Function1;", "Ljava/io/File;", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FilePickerFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return k.TAG;
        }

        public final k f(kotlin.jvm.a.b<? super File, l> bVar) {
            h.e(bVar, "onSelect");
            k kVar = new k();
            kVar.setRetainInstance(true);
            kVar.aDe = bVar;
            return kVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/FilePickerFragment$onCreateView$1$3"})
    /* compiled from: FilePickerFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ k this$0;

        b(k kVar) {
            this.this$0 = kVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/chat/viewmodel/FileItem;", "onChanged"})
    /* compiled from: FilePickerFragment.kt */
    static final class c<T> implements Observer<List<? extends com.iqoption.chat.viewmodel.c>> {
        final /* synthetic */ com.iqoption.chat.component.i aGm;

        c(com.iqoption.chat.component.i iVar) {
            this.aGm = iVar;
        }

        /* renamed from: L */
        public final void onChanged(List<com.iqoption.chat.viewmodel.c> list) {
            if (list != null) {
                this.aGm.setItems(list);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: FilePickerFragment.kt */
    static final class d<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.chat.component.i aGm;

        d(com.iqoption.chat.component.i iVar) {
            this.aGm = iVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                this.aGm.ca(bool.booleanValue());
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public void Pe() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ FilePickerViewModel a(k kVar) {
        FilePickerViewModel filePickerViewModel = kVar.aGk;
        if (filePickerViewModel == null) {
            h.lS("viewModel");
        }
        return filePickerViewModel;
    }

    public void Pf() {
        close();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof com.iqoption.view.e)) {
            context = null;
        }
        com.iqoption.view.e eVar = (com.iqoption.view.e) context;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        Context context = getContext();
        if (!(context instanceof com.iqoption.view.e)) {
            context = null;
        }
        com.iqoption.view.e eVar = (com.iqoption.view.e) context;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    public boolean onBackPressed() {
        FilePickerViewModel filePickerViewModel = this.aGk;
        if (filePickerViewModel == null) {
            h.lS("viewModel");
        }
        if (!filePickerViewModel.QM()) {
            return false;
        }
        filePickerViewModel = this.aGk;
        if (filePickerViewModel == null) {
            h.lS("viewModel");
        }
        filePickerViewModel.QN();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        if (this.aDe == null) {
            close();
            return null;
        }
        cy cyVar = (cy) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_fragment_file_picker, viewGroup, false, 4, null);
        this.aGj = cyVar;
        FilePickerViewModel i = FilePickerViewModel.aKs.i(this);
        h.d(i, "FilePickerViewModel.get(this@FilePickerFragment)");
        this.aGk = i;
        com.iqoption.chat.component.i iVar = new com.iqoption.chat.component.i(new FilePickerFragment$onCreateView$$inlined$apply$lambda$1(this));
        FilePickerViewModel filePickerViewModel = this.aGk;
        if (filePickerViewModel == null) {
            h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        filePickerViewModel.QK().observe(lifecycleOwner, new c(iVar));
        filePickerViewModel = this.aGk;
        if (filePickerViewModel == null) {
            h.lS("viewModel");
        }
        filePickerViewModel.QL().observe(lifecycleOwner, new d(iVar));
        filePickerViewModel = this.aGk;
        if (filePickerViewModel == null) {
            h.lS("viewModel");
        }
        FilePickerViewModel.a(filePickerViewModel, null, 1, null);
        RecyclerView recyclerView = cyVar.bmB;
        h.d(recyclerView, "fileList");
        recyclerView.setAdapter(iVar);
        RecyclerView recyclerView2 = cyVar.bmB;
        h.d(recyclerView2, "fileList");
        com.iqoption.core.ext.a.b(recyclerView2);
        cyVar.awN.setOnClickListener(new b(this));
        getLifecycle().a(new ReadPermissionTracker(this));
        return cyVar.getRoot();
    }

    private final void close() {
        requireFragmentManager().popBackStack();
    }

    private final void q(File file) {
        kotlin.jvm.a.b bVar = this.aDe;
        if (bVar != null) {
            l lVar = (l) bVar.invoke(file);
        }
        requireFragmentManager().popBackStack();
    }
}
