package com.iqoption.quiz;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.jn;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\u001a\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00178F@BX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d8F@BX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, aXE = {"Lcom/iqoption/quiz/QuizUserProfileDialog;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "animatorFactory", "Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "getAnimatorFactory", "()Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "animatorFactory$delegate", "Lkotlin/Lazy;", "binding", "Lcom/iqoption/databinding/DialogQuizUserProfileBinding;", "countryTarget", "Lcom/squareup/picasso/Target;", "isCustomAnimationsEnabled", "", "()Z", "value", "", "place", "getPlace", "()I", "setPlace", "(I)V", "", "userId", "getUserId", "()J", "setUserId", "(J)V", "", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEnterAnimation", "", "onExitAnimation", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizUserProfileDialog.kt */
public final class ac extends com.iqoption.core.ui.fragment.b {
    private static final String LOG_TAG = "ac";
    private static final String TAG = "com.iqoption.quiz.ac";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(ac.class), "animatorFactory", "getAnimatorFactory()Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;"))};
    public static final a dgV = new a();
    private Target aJi;
    private HashMap atz;
    private final boolean bbw = true;
    private final kotlin.d ckE = g.f(new QuizUserProfileDialog$animatorFactory$2(this));
    private jn dgU;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0015"}, aXE = {"Lcom/iqoption/quiz/QuizUserProfileDialog$Companion;", "", "()V", "ARG_PLACE", "", "ARG_USER_ID", "ARG_USER_NAME", "LOG_TAG", "kotlin.jvm.PlatformType", "getLOG_TAG", "()Ljava/lang/String;", "PLACE_NONE", "", "TAG", "getTAG", "newInstance", "Lcom/iqoption/quiz/QuizUserProfileDialog;", "userId", "", "userName", "place", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizUserProfileDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return ac.TAG;
        }

        public final String azq() {
            return ac.LOG_TAG;
        }

        public final ac a(long j, String str, int i) {
            h.e(str, "userName");
            ac acVar = new ac();
            acVar.setArguments(new Bundle());
            acVar.aN(j);
            acVar.setUserName(str);
            acVar.gk(i);
            return acVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: QuizUserProfileDialog.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ ac this$0;

        f(ac acVar) {
            this.this$0 = acVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.p(this.this$0).popBackStack();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, aXE = {"com/iqoption/quiz/QuizUserProfileDialog$onCreateView$1", "Lcom/squareup/picasso/Target;", "onBitmapFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "from", "Lcom/squareup/picasso/Picasso$LoadedFrom;", "onPrepareLoad", "placeHolderDrawable", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizUserProfileDialog.kt */
    public static final class b implements Target {
        final /* synthetic */ WeakReference aJr;
        final /* synthetic */ ac this$0;

        b(ac acVar, WeakReference weakReference) {
            this.this$0 = acVar;
            this.aJr = weakReference;
        }

        public void onBitmapFailed(Drawable drawable) {
            com.iqoption.core.i.w(ac.dgV.azq(), "failed");
        }

        public void onPrepareLoad(Drawable drawable) {
            h.e(drawable, "placeHolderDrawable");
            int c = com.iqoption.core.ext.a.c(this.this$0, (int) R.dimen.dp14);
            drawable.setBounds(0, 0, c, c);
            jn jnVar = (jn) this.aJr.get();
            if (jnVar != null) {
                TextView textView = jnVar.bml;
                h.d(textView, "country");
                com.iqoption.core.ext.a.c(textView, drawable);
            }
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            h.e(bitmap, "bitmap");
            h.e(loadedFrom, "from");
            com.iqoption.core.i.w(ac.dgV.azq(), "loaded");
            jn jnVar = (jn) this.aJr.get();
            if (jnVar != null) {
                TextView textView = jnVar.bml;
                h.d(textView, "country");
                View root = jnVar.getRoot();
                h.d(root, "root");
                com.iqoption.core.ext.a.a(textView, (Drawable) new BitmapDrawable(root.getResources(), bitmap));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/QuizUserProfileViewModel$Profile;", "onChanged"})
    /* compiled from: QuizUserProfileDialog.kt */
    static final class c<T> implements Observer<com.iqoption.quiz.QuizUserProfileViewModel.b> {
        final /* synthetic */ Drawable aJm;
        final /* synthetic */ Picasso aJn;
        final /* synthetic */ com.iqoption.core.ui.picasso.a aJo;
        final /* synthetic */ Drawable aJp;
        final /* synthetic */ ac this$0;

        c(ac acVar, Drawable drawable, Picasso picasso, com.iqoption.core.ui.picasso.a aVar, Drawable drawable2) {
            this.this$0 = acVar;
            this.aJm = drawable;
            this.aJn = picasso;
            this.aJo = aVar;
            this.aJp = drawable2;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.quiz.QuizUserProfileViewModel.b bVar) {
            if (bVar != null) {
                CharSequence userName;
                CharSequence Qv = bVar.Qv();
                int i = 1;
                Object obj = (Qv == null || Qv.length() == 0) ? 1 : null;
                if (obj != null) {
                    ac.a(this.this$0).bmj.setImageDrawable(this.aJm);
                } else {
                    this.aJn.load(bVar.Qv()).placeholder(this.aJm).resizeDimen(R.dimen.dp44, R.dimen.dp44).centerCrop().transform((Transformation) this.aJo).into(ac.a(this.this$0).bmj);
                }
                TextView textView = ac.a(this.this$0).bmp;
                h.d(textView, "binding.vipBadge");
                textView.setVisibility(bVar.Dd() ? 0 : 8);
                textView = ac.a(this.this$0).aig;
                h.d(textView, "binding.name");
                if ((u.M(this.this$0.getUserName()) ^ 1) != 0) {
                    userName = this.this$0.getUserName();
                } else {
                    userName = bVar.getName();
                }
                textView.setText(userName);
                Qv = bVar.Qx();
                if (!(Qv == null || Qv.length() == 0)) {
                    i = 0;
                }
                if (i != 0) {
                    textView = ac.a(this.this$0).bml;
                    h.d(textView, "binding.country");
                    com.iqoption.core.ext.a.c(textView, (Drawable) null);
                } else {
                    this.aJn.load(bVar.Qx()).placeholder(this.aJp).resizeDimen(R.dimen.dp14, R.dimen.dp14).centerCrop().transform((Transformation) this.aJo).into(ac.b(this.this$0));
                }
                textView = ac.a(this.this$0).aiF;
                h.d(textView, "binding.date");
                textView.setText(bVar.azu());
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onChanged"})
    /* compiled from: QuizUserProfileDialog.kt */
    static final class d<T> implements Observer<String> {
        final /* synthetic */ ac this$0;

        d(ac acVar) {
            this.this$0 = acVar;
        }

        /* renamed from: fz */
        public final void onChanged(String str) {
            if (str != null) {
                TextView textView = ac.a(this.this$0).bml;
                h.d(textView, "binding.country");
                textView.setText(str);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: QuizUserProfileDialog.kt */
    static final class e<T> implements Observer<Boolean> {
        final /* synthetic */ int aJq;
        final /* synthetic */ ac this$0;

        e(ac acVar, int i) {
            this.this$0 = acVar;
            this.aJq = i;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                TextView textView = ac.a(this.this$0).aig;
                h.d(textView, "binding.name");
                Drawable drawable = null;
                if (bool.booleanValue()) {
                    drawable = com.iqoption.core.ext.a.a((Drawable) com.iqoption.core.graphics.a.c.b(R.dimen.dp8, 0, 2, null), this.aJq);
                }
                com.iqoption.core.ext.a.b(textView, drawable);
            }
        }
    }

    private final com.iqoption.core.ui.d.a afA() {
        kotlin.d dVar = this.ckE;
        j jVar = apP[0];
        return (com.iqoption.core.ui.d.a) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ jn a(ac acVar) {
        jn jnVar = acVar.dgU;
        if (jnVar == null) {
            h.lS("binding");
        }
        return jnVar;
    }

    public static final /* synthetic */ Target b(ac acVar) {
        Target target = acVar.aJi;
        if (target == null) {
            h.lS("countryTarget");
        }
        return target;
    }

    public final long getUserId() {
        return com.iqoption.core.ext.a.o(this).getLong("arg.userId");
    }

    private final void aN(long j) {
        com.iqoption.core.ext.a.o(this).putLong("arg.userId", j);
    }

    public final String getUserName() {
        String string = com.iqoption.core.ext.a.o(this).getString("arg.userName");
        h.d(string, "args.getString(ARG_USER_NAME)");
        return string;
    }

    private final void setUserName(String str) {
        com.iqoption.core.ext.a.o(this).putString("arg.userName", str);
    }

    public final void gk(int i) {
        com.iqoption.core.ext.a.o(this).putInt("arg.place", i);
    }

    public boolean KE() {
        return this.bbw;
    }

    public void KF() {
        afA().bd(Yw()).start();
    }

    public void KG() {
        afA().be(Yx()).start();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        com.iqoption.quiz.a.a.did.azY();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dgU = (jn) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_quiz_user_profile, viewGroup, false, 4, null);
        QuizUserProfileViewModel V = QuizUserProfileViewModel.dhd.V(this);
        V.bP(getUserId());
        OnClickListener fVar = new f(this);
        jn jnVar = this.dgU;
        if (jnVar == null) {
            h.lS("binding");
        }
        jnVar.awS.setOnClickListener(fVar);
        jnVar = this.dgU;
        if (jnVar == null) {
            h.lS("binding");
        }
        jnVar.bmk.setOnClickListener(fVar);
        Picasso with = Picasso.with(com.iqoption.core.ext.a.m(this));
        com.iqoption.core.ui.picasso.a aVar = new com.iqoption.core.ui.picasso.a();
        jn jnVar2 = this.dgU;
        if (jnVar2 == null) {
            h.lS("binding");
        }
        this.aJi = new b(this, com.iqoption.core.ext.c.bf(jnVar2));
        int a = com.iqoption.core.ext.a.a((Fragment) this, (int) R.color.green);
        Drawable d = com.iqoption.core.ext.a.d((Fragment) this, (int) R.drawable.chat_dialog_user_info_country_placeholder);
        LifecycleOwner lifecycleOwner = this;
        V.azr().observe(lifecycleOwner, new c(this, com.iqoption.core.ext.a.d((Fragment) this, (int) R.drawable.chat_message_avatar_placeholder), with, aVar, d));
        V.azs().observe(lifecycleOwner, new d(this));
        V.azt().observe(lifecycleOwner, new e(this, a));
        jn jnVar3 = this.dgU;
        if (jnVar3 == null) {
            h.lS("binding");
        }
        return jnVar3.getRoot();
    }
}
