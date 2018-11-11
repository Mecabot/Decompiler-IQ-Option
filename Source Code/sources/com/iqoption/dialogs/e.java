package com.iqoption.dialogs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001a\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/dialogs/SimpleDialog;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "animatorFactory", "Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "getAnimatorFactory", "()Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "animatorFactory$delegate", "Lkotlin/Lazy;", "binding", "Lcom/iqoption/dialogs/databinding/DialogSimpleBinding;", "config", "Lcom/iqoption/dialogs/SimpleDialog$Config;", "close", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEnterAnimation", "onExitAnimation", "ActionConfig", "Companion", "Config", "dialogs_release"})
/* compiled from: SimpleDialog.kt */
public final class e extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = d.class.getSimpleName();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "animatorFactory", "getAnimatorFactory()Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;"))};
    public static final b ckL = new b();
    private final kotlin.d ckE = g.f(new SimpleDialog$animatorFactory$2(this));
    private c ckJ;
    private com.iqoption.dialogs.a.c ckK;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, aXE = {"Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "onClick", "", "dialog", "Lcom/iqoption/dialogs/SimpleDialog;", "dialogs_release"})
    /* compiled from: SimpleDialog.kt */
    public interface a {
        void a(e eVar);

        CharSequence getLabel();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/dialogs/SimpleDialog$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/dialogs/SimpleDialog;", "config", "Lcom/iqoption/dialogs/SimpleDialog$Config;", "dialogs_release"})
    /* compiled from: SimpleDialog.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final String Ll() {
            return e.TAG;
        }

        public final e a(c cVar) {
            h.e(cVar, "config");
            e eVar = new e();
            eVar.setRetainInstance(true);
            eVar.ckJ = cVar;
            return eVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, aXE = {"Lcom/iqoption/dialogs/SimpleDialog$Config;", "", "actionConfig1", "Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "getActionConfig1", "()Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "actionConfig2", "getActionConfig2", "info", "", "getInfo", "()Ljava/lang/CharSequence;", "text", "getText", "title", "getTitle", "onDismiss", "", "dialogs_release"})
    /* compiled from: SimpleDialog.kt */
    public interface c {

        @i(aXC = {1, 1, 11})
        /* compiled from: SimpleDialog.kt */
        public static final class a {
            public static CharSequence b(c cVar) {
                return null;
            }

            public static void c(c cVar) {
            }
        }

        a abv();

        a abw();

        CharSequence abx();

        CharSequence getText();

        CharSequence getTitle();

        void onDismiss();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/dialogs/SimpleDialog$onCreateView$1$1"})
    /* compiled from: SimpleDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ c ckM;
        final /* synthetic */ e this$0;

        d(e eVar, c cVar) {
            this.this$0 = eVar;
            this.ckM = cVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/dialogs/SimpleDialog$onCreateView$1$3$1", "com/iqoption/dialogs/SimpleDialog$$special$$inlined$apply$lambda$1"})
    /* compiled from: SimpleDialog.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ c ckM;
        final /* synthetic */ com.iqoption.dialogs.a.c ckN;
        final /* synthetic */ a ckO;
        final /* synthetic */ e this$0;

        e(a aVar, com.iqoption.dialogs.a.c cVar, e eVar, c cVar2) {
            this.ckO = aVar;
            this.this$0 = eVar;
            this.ckM = cVar2;
            this.ckN = cVar;
        }

        public final void onClick(View view) {
            this.ckO.a(this.this$0);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/dialogs/SimpleDialog$onCreateView$1$4$1", "com/iqoption/dialogs/SimpleDialog$$special$$inlined$let$lambda$1"})
    /* compiled from: SimpleDialog.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ c ckM;
        final /* synthetic */ com.iqoption.dialogs.a.c ckN;
        final /* synthetic */ a ckP;
        final /* synthetic */ e this$0;

        f(a aVar, com.iqoption.dialogs.a.c cVar, e eVar, c cVar2) {
            this.ckP = aVar;
            this.this$0 = eVar;
            this.ckM = cVar2;
            this.ckN = cVar;
        }

        public final void onClick(View view) {
            this.ckP.a(this.this$0);
        }
    }

    private final com.iqoption.core.ui.d.a afA() {
        kotlin.d dVar = this.ckE;
        j jVar = apP[0];
        return (com.iqoption.core.ui.d.a) dVar.getValue();
    }

    public static final /* synthetic */ com.iqoption.dialogs.a.c b(e eVar) {
        com.iqoption.dialogs.a.c cVar = eVar.ckK;
        if (cVar == null) {
            h.lS("binding");
        }
        return cVar;
    }

    public void KF() {
        afA().bd(Yw()).start();
    }

    public void KG() {
        afA().be(Yx()).start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        c cVar = this.ckJ;
        if (cVar == null) {
            com.iqoption.core.i.d(TAG, "Config is null -> closing");
            return null;
        }
        TextView textView;
        com.iqoption.dialogs.a.c cVar2 = (com.iqoption.dialogs.a.c) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.dialogs.c.d.dialog_simple, viewGroup, false, 4, null);
        this.ckK = cVar2;
        cVar2.awS.setOnClickListener(new d(this, cVar));
        TextView textView2 = cVar2.agA;
        h.d(textView2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView2.setText(cVar.getTitle());
        textView2 = cVar2.aip;
        h.d(textView2, "text");
        textView2.setText(cVar.getText());
        CharSequence abx = cVar.abx();
        if (abx != null) {
            textView = cVar2.blj;
            h.d(textView, "info");
            textView.setText(abx);
        } else {
            textView2 = cVar2.blj;
            h.d(textView2, "info");
            com.iqoption.core.ext.a.M(textView2);
        }
        a abv = cVar.abv();
        textView = cVar2.ckR;
        h.d(textView, "btnAction1");
        textView.setText(abv.getLabel());
        cVar2.ckR.setOnClickListener(new e(abv, cVar2, this, cVar));
        abv = cVar.abw();
        if (abv != null) {
            textView = cVar2.ckS;
            h.d(textView, "btnAction2");
            textView.setText(abv.getLabel());
            cVar2.ckS.setOnClickListener(new f(abv, cVar2, this, cVar));
        } else {
            TextView textView3 = cVar2.ckS;
            h.d(textView3, "btnAction2");
            com.iqoption.core.ext.a.M(textView3);
        }
        return cVar2.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (isRemoving()) {
            c cVar = this.ckJ;
            if (cVar != null) {
                cVar.onDismiss();
            }
        }
    }

    public final void close() {
        com.iqoption.core.ext.a.p(this).popBackStack();
    }
}
