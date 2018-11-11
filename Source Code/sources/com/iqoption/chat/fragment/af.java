package com.iqoption.chat.fragment;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.chat.repository.g;
import com.iqoption.chat.viewmodel.UserInfoViewModel;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.d.cg;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\bH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0006\u0010!\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006#"}, aXE = {"Lcom/iqoption/chat/fragment/UserInfoDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "animationController", "Lcom/iqoption/chat/fragment/DialogAnimationController;", "binding", "Lcom/iqoption/databinding/ChatDialogUserInfoBinding;", "value", "", "countryId", "getCountryId", "()J", "setCountryId", "(J)V", "countryTarget", "Lcom/squareup/picasso/Target;", "userId", "getUserId", "setUserId", "viewModel", "Lcom/iqoption/chat/viewmodel/UserInfoViewModel;", "getAnimationDuration", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "", "onShowAnimation", "update", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: UserInfoDialog.kt */
public final class af extends com.iqoption.fragment.base.b {
    private static final String TAG = "af";
    public static final a aJj = new a();
    private h aFD;
    private UserInfoViewModel aJg;
    private cg aJh;
    private Target aJi;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, aXE = {"Lcom/iqoption/chat/fragment/UserInfoDialog$Companion;", "", "()V", "ARG_COUNTRY_ID", "", "ARG_USER_ID", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/UserInfoDialog;", "userId", "", "countryId", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: UserInfoDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return af.TAG;
        }

        public final af m(long j, long j2) {
            af afVar = new af();
            afVar.setArguments(new Bundle());
            afVar.aN(j);
            afVar.Y(j2);
            return afVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/UserInfoDialog$onCreateView$1$closeClickListener$1"})
    /* compiled from: UserInfoDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ af aJk;

        b(af afVar) {
            this.aJk = afVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.p(this.aJk).popBackStack();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/repository/UserInfo;", "onChanged", "com/iqoption/chat/fragment/UserInfoDialog$onCreateView$1$3"})
    /* compiled from: UserInfoDialog.kt */
    static final class c<T> implements Observer<g> {
        final /* synthetic */ af aJk;
        final /* synthetic */ cg aJl;
        final /* synthetic */ Drawable aJm;
        final /* synthetic */ Picasso aJn;
        final /* synthetic */ com.iqoption.core.ui.picasso.a aJo;
        final /* synthetic */ Drawable aJp;
        final /* synthetic */ int aJq;

        c(cg cgVar, Drawable drawable, Picasso picasso, com.iqoption.core.ui.picasso.a aVar, Drawable drawable2, int i, af afVar) {
            this.aJl = cgVar;
            this.aJm = drawable;
            this.aJn = picasso;
            this.aJo = aVar;
            this.aJp = drawable2;
            this.aJq = i;
            this.aJk = afVar;
        }

        /* renamed from: a */
        public final void onChanged(g gVar) {
            if (gVar != null) {
                CharSequence charSequence;
                CharSequence Qv = gVar.Qv();
                int i = 1;
                Object obj = (Qv == null || Qv.length() == 0) ? 1 : null;
                if (obj != null) {
                    this.aJl.bmj.setImageDrawable(this.aJm);
                } else {
                    this.aJn.load(gVar.Qv()).placeholder(this.aJm).resizeDimen(R.dimen.dp44, R.dimen.dp44).centerCrop().transform((Transformation) this.aJo).into(this.aJl.bmj);
                }
                TextView textView = this.aJl.bmp;
                h.d(textView, "vipBadge");
                textView.setVisibility(gVar.Dd() ? 0 : 8);
                textView = this.aJl.aig;
                h.d(textView, "name");
                List b = v.b((CharSequence) gVar.getName(), new String[]{" "}, false, 0, 6, null);
                switch (b.size()) {
                    case 0:
                        charSequence = "";
                        break;
                    case 1:
                        charSequence = (CharSequence) b.get(0);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((String) b.get(0));
                        stringBuilder.append(' ');
                        stringBuilder.append(x.P((CharSequence) b.get(1)));
                        stringBuilder.append('.');
                        charSequence = stringBuilder.toString();
                        break;
                }
                textView.setText(charSequence);
                Qv = gVar.Qx();
                if (!(Qv == null || Qv.length() == 0)) {
                    i = 0;
                }
                if (i != 0) {
                    bg.setDrawableLeft(this.aJl.bml, null);
                } else {
                    this.aJn.load(gVar.Qx()).placeholder(this.aJp).resizeDimen(R.dimen.dp14, R.dimen.dp14).centerCrop().transform((Transformation) this.aJo).into(af.a(this.aJk));
                }
                TextView textView2 = this.aJl.bml;
                h.d(textView2, "country");
                textView2.setText(gVar.getCountry());
                textView2 = this.aJl.aiF;
                h.d(textView2, "date");
                textView2.setText(new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Long.valueOf(gVar.Qw())));
                if (gVar.Do()) {
                    bg.setDrawableRight(this.aJl.aig, com.iqoption.core.ext.a.a((Drawable) com.iqoption.core.graphics.a.c.b(R.dimen.dp8, 0, 2, null), this.aJq));
                } else {
                    bg.setDrawableRight(this.aJl.aig, null);
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, aXE = {"com/iqoption/chat/fragment/UserInfoDialog$onCreateView$1$1", "Lcom/squareup/picasso/Target;", "onBitmapFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "from", "Lcom/squareup/picasso/Picasso$LoadedFrom;", "onPrepareLoad", "placeHolderDrawable", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: UserInfoDialog.kt */
    public static final class d implements Target {
        final /* synthetic */ cg aJl;
        final /* synthetic */ WeakReference aJr;

        d(cg cgVar, WeakReference weakReference) {
            this.aJl = cgVar;
            this.aJr = weakReference;
        }

        public void onBitmapFailed(Drawable drawable) {
            com.iqoption.core.i.w(af.aJj.Ll(), "failed");
        }

        public void onPrepareLoad(Drawable drawable) {
            h.e(drawable, "placeHolderDrawable");
            int c = com.iqoption.core.ext.a.c((ViewDataBinding) this.aJl, (int) R.dimen.dp14);
            drawable.setBounds(0, 0, c, c);
            cg cgVar = (cg) this.aJr.get();
            if (cgVar != null) {
                TextView textView = cgVar.bml;
                h.d(textView, "country");
                com.iqoption.core.ext.a.c(textView, drawable);
            }
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            h.e(bitmap, "bitmap");
            h.e(loadedFrom, "from");
            com.iqoption.core.i.w(af.aJj.Ll(), "loaded");
            cg cgVar = (cg) this.aJr.get();
            if (cgVar != null) {
                TextView textView = cgVar.bml;
                h.d(textView, "country");
                View root = cgVar.getRoot();
                h.d(root, "root");
                com.iqoption.core.ext.a.a(textView, (Drawable) new BitmapDrawable(root.getResources(), bitmap));
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long getAnimationDuration() {
        return 250;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ Target a(af afVar) {
        Target target = afVar.aJi;
        if (target == null) {
            h.lS("countryTarget");
        }
        return target;
    }

    public final long getUserId() {
        return com.iqoption.core.ext.a.o(this).getLong("arg.userId");
    }

    public final void aN(long j) {
        com.iqoption.core.ext.a.o(this).putLong("arg.userId", j);
    }

    public final long Db() {
        return com.iqoption.core.ext.a.o(this).getLong("arg.countryId");
    }

    public final void Y(long j) {
        com.iqoption.core.ext.a.o(this).putLong("arg.countryId", j);
    }

    public void ND() {
        h hVar = this.aFD;
        if (hVar == null) {
            h.lS("animationController");
        }
        hVar.PF();
    }

    public void NE() {
        h hVar = this.aFD;
        if (hVar == null) {
            h.lS("animationController");
        }
        hVar.PG();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.chat_dialog_user_info, viewGroup, false);
        cg cgVar = (cg) inflate;
        am.n(com.iqoption.core.ext.a.n(this));
        h.d(cgVar, "this");
        this.aJh = cgVar;
        com.iqoption.fragment.base.b bVar = this;
        View root = cgVar.getRoot();
        h.d(root, "root");
        MaxSizeCardViewLayout maxSizeCardViewLayout = cgVar.bmb;
        h.d(maxSizeCardViewLayout, "frame");
        this.aFD = new h(bVar, root, maxSizeCardViewLayout);
        OnClickListener bVar2 = new b(this);
        cgVar.awS.setOnClickListener(bVar2);
        cgVar.bmk.setOnClickListener(bVar2);
        Picasso with = Picasso.with(com.iqoption.core.ext.a.m(this));
        com.iqoption.core.ui.picasso.a aVar = new com.iqoption.core.ui.picasso.a();
        cg cgVar2 = this.aJh;
        if (cgVar2 == null) {
            h.lS("binding");
        }
        this.aJi = new d(cgVar, com.iqoption.core.ext.c.bf(cgVar2));
        ViewDataBinding viewDataBinding = cgVar;
        int a = com.iqoption.core.ext.a.a(viewDataBinding, (int) R.color.green);
        Drawable e = com.iqoption.core.ext.a.e(viewDataBinding, (int) R.drawable.chat_dialog_user_info_country_placeholder);
        Drawable e2 = com.iqoption.core.ext.a.e(viewDataBinding, (int) R.drawable.chat_message_avatar_placeholder);
        UserInfoViewModel l = UserInfoViewModel.aLZ.l(this);
        h.d(l, "this");
        this.aJg = l;
        update();
        l.RG().observe(this, new c(cgVar, e2, with, aVar, e, a, this));
        h.d(inflate, "DataBindingUtil.inflate<…\n            })\n        }");
        return cgVar.getRoot();
    }

    public final void update() {
        UserInfoViewModel userInfoViewModel = this.aJg;
        if (userInfoViewModel == null) {
            h.lS("viewModel");
        }
        userInfoViewModel.o(getUserId(), Db());
    }
}
