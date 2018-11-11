package com.iqoption.vip;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.microservice.vip.VipManagerDeserializer;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t\u00126\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\u0010\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R>\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\tX\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, aXE = {"Lcom/iqoption/vip/ChooseTimeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/vip/ChooseTimeAdapter$TimePeriodViewHolder;", "date", "", "periods", "", "Lcom/iqoption/vip/WorkingPeriod;", "periodSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "period", "", "isPeriodSelected", "", "(JLjava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getDate", "()J", "getPeriods", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TimePeriodViewHolder", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChooseTimeAdapter.kt */
public final class b extends Adapter<a> {
    private final long aFN;
    private final List<j> dKO;
    private final m<Long, j, l> dKP;
    private final m<Long, j, Boolean> dKQ;

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RA\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012RA\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, aXE = {"Lcom/iqoption/vip/ChooseTimeAdapter$TimePeriodViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/widget/TextView;", "date", "", "periodSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/iqoption/vip/WorkingPeriod;", "period", "", "isPeriodSelected", "", "(Landroid/widget/TextView;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getDate", "()J", "()Lkotlin/jvm/functions/Function2;", "getPeriodSelected", "getView", "()Landroid/widget/TextView;", "bind", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChooseTimeAdapter.kt */
    public static final class a extends ViewHolder {
        private final long aFN;
        private final TextView aSa;
        private final m<Long, j, l> dKP;
        private final m<Long, j, Boolean> dKQ;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: ChooseTimeAdapter.kt */
        static final class a implements OnClickListener {
            final /* synthetic */ a dKR;
            final /* synthetic */ j dKS;

            a(a aVar, j jVar) {
                this.dKR = aVar;
                this.dKS = jVar;
            }

            public final void onClick(View view) {
                this.dKR.aKq().B(Long.valueOf(this.dKR.getDate()), this.dKS);
            }
        }

        public final m<Long, j, l> aKq() {
            return this.dKP;
        }

        public final long getDate() {
            return this.aFN;
        }

        public a(TextView textView, long j, m<? super Long, ? super j, l> mVar, m<? super Long, ? super j, Boolean> mVar2) {
            h.e(textView, Promotion.ACTION_VIEW);
            h.e(mVar, "periodSelected");
            h.e(mVar2, "isPeriodSelected");
            super(textView);
            this.aSa = textView;
            this.aFN = j;
            this.dKP = mVar;
            this.dKQ = mVar2;
        }

        public final void a(j jVar) {
            h.e(jVar, "period");
            TextView textView = this.aSa;
            kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.euz;
            Locale locale = Locale.US;
            h.d(locale, "Locale.US");
            Object[] objArr = new Object[]{VipManagerDeserializer.cTi.format(jVar.getStartDate()), VipManagerDeserializer.cTi.format(jVar.getEndDate())};
            String format = String.format(locale, "%s - %s", Arrays.copyOf(objArr, objArr.length));
            h.d(format, "java.lang.String.format(locale, format, *args)");
            textView.setText(format);
            this.aSa.setSelected(((Boolean) this.dKQ.B(Long.valueOf(this.aFN), jVar)).booleanValue());
            this.aSa.setOnClickListener(new a(this, jVar));
        }
    }

    public b(long j, List<j> list, m<? super Long, ? super j, l> mVar, m<? super Long, ? super j, Boolean> mVar2) {
        h.e(list, "periods");
        h.e(mVar, "periodSelected");
        h.e(mVar2, "isPeriodSelected");
        this.aFN = j;
        this.dKO = list;
        this.dKP = mVar;
        this.dKQ = mVar2;
    }

    /* renamed from: ac */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.choose_time_item_view, viewGroup, false);
        if (inflate != null) {
            return new a((TextView) inflate, this.aFN, this.dKP, this.dKQ);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    public int getItemCount() {
        return this.dKO.size();
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        h.e(aVar, "holder");
        aVar.a((j) this.dKO.get(i));
    }
}
