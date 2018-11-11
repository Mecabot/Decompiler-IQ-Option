package com.iqoption.sessions;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.d.aiy;
import com.iqoption.d.aja;
import com.iqoption.d.ajc;
import com.iqoption.x.R;
import io.card.payment.BuildConfig;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001b\u001c\u001d\u001eBQ\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012<\u0010\u0006\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000RD\u0010\u0006\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/iqoption/core/microservices/auth/response/Session;", "terminateListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sessions", "", "all", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MainItemViewHolder", "OtherItemViewHolder", "TitleViewHolder", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveSessionsAdapter.kt */
public final class a extends Adapter<ViewHolder> {
    private static final DateFormat cgq = new SimpleDateFormat("HH:mm, dd.MM", Locale.getDefault());
    private static final Map<Integer, Integer> dqC = ad.a(new Pair(Integer.valueOf(14), Integer.valueOf(R.drawable.ic_android_24dp)), new Pair(Integer.valueOf(16), Integer.valueOf(R.drawable.ic_laptop_24dp)), new Pair(Integer.valueOf(13), Integer.valueOf(R.drawable.ic_apple)), new Pair(Integer.valueOf(2), Integer.valueOf(R.drawable.ic_android_24dp)), new Pair(Integer.valueOf(17), Integer.valueOf(R.drawable.ic_android_24dp)), new Pair(Integer.valueOf(3), Integer.valueOf(R.drawable.ic_apple)), new Pair(Integer.valueOf(12), Integer.valueOf(R.drawable.ic_apple)), new Pair(Integer.valueOf(4), Integer.valueOf(R.drawable.ic_laptop_24dp)), new Pair(Integer.valueOf(8), Integer.valueOf(R.drawable.ic_laptop_24dp)), new Pair(Integer.valueOf(15), Integer.valueOf(R.drawable.ic_laptop_24dp)), new Pair(Integer.valueOf(5), Integer.valueOf(R.drawable.ic_smartphone_24dp)), new Pair(Integer.valueOf(9), Integer.valueOf(R.drawable.ic_laptop_24dp)), new Pair(Integer.valueOf(7), Integer.valueOf(R.drawable.ic_laptop_24dp)), new Pair(Integer.valueOf(11), Integer.valueOf(R.drawable.ic_laptop_24dp)));
    private static final Map<Integer, String> dqD = ad.a(new Pair(Integer.valueOf(14), "Hodly Android"), new Pair(Integer.valueOf(16), "Hodly Web"), new Pair(Integer.valueOf(13), "Hodly IOS"), new Pair(Integer.valueOf(2), "IQ Option Android"), new Pair(Integer.valueOf(17), "IQ Option X Android"), new Pair(Integer.valueOf(3), "IQ Option IOS"), new Pair(Integer.valueOf(12), "IQ Broker IOS"), new Pair(Integer.valueOf(4), "IQ Option Web"), new Pair(Integer.valueOf(8), "IQ Option Win GL"), new Pair(Integer.valueOf(5), "IQ Option Web Mobile"), new Pair(Integer.valueOf(9), "IQ Option WEB"), new Pair(Integer.valueOf(15), "IQ Option WEB"), new Pair(Integer.valueOf(7), "IQ Option Mac OS"), new Pair(Integer.valueOf(11), "IQ Option Linux"));
    public static final a dqE = new a();
    private final m<List<com.iqoption.core.microservices.a.a.b>, Boolean, l> dqB;
    private final List<com.iqoption.core.microservices.a.a.b> nj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsAdapter$Companion;", "", "()V", "VIEW_TYPE_MAIN_ITEM", "", "VIEW_TYPE_OTHER_ITEM", "VIEW_TYPE_TITLE", "dateFormat", "Ljava/text/DateFormat;", "iconPlatformMap", "", "namePlatformMap", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ActiveSessionsAdapter.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ a dqL;

        e(a aVar) {
            this.dqL = aVar;
        }

        public final void onClick(View view) {
            if (this.dqL.nj.size() > 1) {
                this.dqL.dqB.B(this.dqL.nj.subList(1, this.dqL.nj.size()), Boolean.valueOf(true));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsAdapter$MainItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/SessionMainItemBinding;", "listener", "Landroid/view/View$OnClickListener;", "(Lcom/iqoption/databinding/SessionMainItemBinding;Landroid/view/View$OnClickListener;)V", "getBinding", "()Lcom/iqoption/databinding/SessionMainItemBinding;", "getListener", "()Landroid/view/View$OnClickListener;", "bind", "", "session", "Lcom/iqoption/core/microservices/auth/response/Session;", "count", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsAdapter.kt */
    public static final class b extends ViewHolder {
        private final OnClickListener aim;
        private final aiy dqF;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: ActiveSessionsAdapter.kt */
        /* renamed from: com.iqoption.sessions.a$b$1 */
        static final class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ b dqG;

            AnonymousClass1(b bVar) {
                this.dqG = bVar;
            }

            public final void onClick(View view) {
                this.dqG.aDM().onClick(view);
            }
        }

        public b(aiy aiy, OnClickListener onClickListener) {
            h.e(aiy, "binding");
            h.e(onClickListener, "listener");
            super(aiy.getRoot());
            this.dqF = aiy;
            this.aim = onClickListener;
            this.dqF.bTo.setOnClickListener(new AnonymousClass1(this));
        }

        public final OnClickListener aDM() {
            return this.aim;
        }

        public final void a(com.iqoption.core.microservices.a.a.b bVar, int i) {
            h.e(bVar, "session");
            this.dqF.bmu.setImageResource(R.drawable.ic_android_24dp);
            TextView textView = this.dqF.bTn;
            h.d(textView, "binding.platformApp");
            kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.euz;
            Locale locale = Locale.US;
            h.d(locale, "Locale.US");
            Object[] objArr = new Object[]{BuildConfig.PRODUCT_VERSION};
            String format = String.format(locale, "IQ Option Android %s", Arrays.copyOf(objArr, objArr.length));
            h.d(format, "java.lang.String.format(locale, format, *args)");
            textView.setText(format);
            int i2 = 8;
            if (TextUtils.isEmpty(bVar.Up())) {
                textView = this.dqF.bTp;
                h.d(textView, "binding.userAgent");
                textView.setVisibility(8);
            } else {
                textView = this.dqF.bTp;
                h.d(textView, "binding.userAgent");
                textView.setText(bVar.Up());
            }
            textView = this.dqF.bTm;
            h.d(textView, "binding.ip");
            textView.setText(bVar.Uq().Us());
            TextView textView2 = this.dqF.bTo;
            h.d(textView2, "binding.terminateButton");
            if (i > 1) {
                i2 = 0;
            }
            textView2.setVisibility(i2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012<\u0010\u0004\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010RG\u0010\u0004\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsAdapter$OtherItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/SessionOtherItemBinding;", "terminateListener", "Lkotlin/Function2;", "", "Lcom/iqoption/core/microservices/auth/response/Session;", "Lkotlin/ParameterName;", "name", "sessions", "", "all", "", "(Lcom/iqoption/databinding/SessionOtherItemBinding;Lkotlin/jvm/functions/Function2;)V", "getBinding", "()Lcom/iqoption/databinding/SessionOtherItemBinding;", "getTerminateListener", "()Lkotlin/jvm/functions/Function2;", "bind", "session", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsAdapter.kt */
    public static final class c extends ViewHolder {
        private final m<List<com.iqoption.core.microservices.a.a.b>, Boolean, l> dqB;
        private final aja dqH;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: ActiveSessionsAdapter.kt */
        static final class a implements OnClickListener {
            final /* synthetic */ c dqI;
            final /* synthetic */ com.iqoption.core.microservices.a.a.b dqJ;

            a(c cVar, com.iqoption.core.microservices.a.a.b bVar) {
                this.dqI = cVar;
                this.dqJ = bVar;
            }

            public final void onClick(View view) {
                m aDN = this.dqI.aDN();
                List singletonList = Collections.singletonList(this.dqJ);
                h.d(singletonList, "Collections.singletonList(session)");
                aDN.B(singletonList, Boolean.valueOf(false));
            }
        }

        public c(aja aja, m<? super List<com.iqoption.core.microservices.a.a.b>, ? super Boolean, l> mVar) {
            h.e(aja, "binding");
            h.e(mVar, "terminateListener");
            super(aja.getRoot());
            this.dqH = aja;
            this.dqB = mVar;
        }

        public final m<List<com.iqoption.core.microservices.a.a.b>, Boolean, l> aDN() {
            return this.dqB;
        }

        public final void a(com.iqoption.core.microservices.a.a.b bVar) {
            h.e(bVar, "session");
            Integer num = (Integer) a.dqC.get(Integer.valueOf(bVar.Uq().Ur()));
            this.dqH.bmu.setImageResource(num != null ? num.intValue() : 0);
            TextView textView = this.dqH.bTn;
            h.d(textView, "binding.platformApp");
            String str = (String) a.dqD.get(Integer.valueOf(bVar.Uq().Ur()));
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            if (TextUtils.isEmpty(bVar.Up())) {
                textView = this.dqH.bTp;
                h.d(textView, "binding.userAgent");
                textView.setVisibility(8);
            } else {
                textView = this.dqH.bTp;
                h.d(textView, "binding.userAgent");
                textView.setText(bVar.Up());
            }
            textView = this.dqH.bTm;
            h.d(textView, "binding.ip");
            textView.setText(bVar.Uq().Us());
            textView = this.dqH.aiF;
            h.d(textView, "binding.date");
            textView.setText(a.cgq.format(new Date(bVar.Uq().ma() * ((long) 1000))));
            this.dqH.bTq.setOnClickListener(new a(this, bVar));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsAdapter$TitleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/SessionTitleBinding;", "(Lcom/iqoption/databinding/SessionTitleBinding;)V", "getBinding", "()Lcom/iqoption/databinding/SessionTitleBinding;", "bind", "", "stringRes", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsAdapter.kt */
    public static final class d extends ViewHolder {
        private final ajc dqK;

        public d(ajc ajc) {
            h.e(ajc, "binding");
            super(ajc.getRoot());
            this.dqK = ajc;
        }

        public final void eC(int i) {
            this.dqK.agA.setText(i);
        }
    }

    public int getItemViewType(int i) {
        switch (i) {
            case 0:
            case 2:
                return 1;
            case 1:
                return 2;
            default:
                return 3;
        }
    }

    public a(List<com.iqoption.core.microservices.a.a.b> list, m<? super List<com.iqoption.core.microservices.a.a.b>, ? super Boolean, l> mVar) {
        h.e(list, "items");
        h.e(mVar, "terminateListener");
        this.nj = list;
        this.dqB = mVar;
        setHasStableIds(true);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding inflate;
        switch (i) {
            case 1:
                inflate = DataBindingUtil.inflate(from, R.layout.session_title, viewGroup, false);
                h.d(inflate, "DataBindingUtil.inflate(…ion_title, parent, false)");
                return new d((ajc) inflate);
            case 2:
                inflate = DataBindingUtil.inflate(from, R.layout.session_main_item, viewGroup, false);
                h.d(inflate, "DataBindingUtil.inflate(…main_item, parent, false)");
                return new b((aiy) inflate, new e(this));
            case 3:
                inflate = DataBindingUtil.inflate(from, R.layout.session_other_item, viewGroup, false);
                h.d(inflate, "DataBindingUtil.inflate(…ther_item, parent, false)");
                return new c((aja) inflate, this.dqB);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unimplemented view type ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public long getItemId(int i) {
        return getItemViewType(i) == 1 ? -((long) i) : (long) i;
    }

    public int getItemCount() {
        if (this.nj.isEmpty()) {
            return 0;
        }
        if (this.nj.size() == 1) {
            return 2;
        }
        return this.nj.size() + 2;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        h.e(viewHolder, "holder");
        switch (i) {
            case 0:
                ((d) viewHolder).eC(R.string.current_session);
                return;
            case 1:
                ((b) viewHolder).a((com.iqoption.core.microservices.a.a.b) this.nj.get(0), this.nj.size());
                return;
            case 2:
                ((d) viewHolder).eC(R.string.active_sessions);
                return;
            default:
                ((c) viewHolder).a((com.iqoption.core.microservices.a.a.b) this.nj.get(i - 2));
                return;
        }
    }
}
