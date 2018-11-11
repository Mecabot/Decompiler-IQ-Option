package com.iqoption.vip;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.d.als;
import com.iqoption.microservice.vip.d;
import com.iqoption.util.m;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0012\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/vip/VipAboutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "vipManager", "Lcom/iqoption/microservice/vip/VipManager;", "(Lcom/iqoption/microservice/vip/VipManager;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MainInfoViewHolder", "PhotoViewHolder", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipAboutAdapter.kt */
public final class g extends Adapter<ViewHolder> {
    public static final a dLf = new a();
    private final d dLe;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/vip/VipAboutAdapter$Companion;", "", "()V", "VIEW_TYPE_MAIN", "", "VIEW_TYPE_PHOTO", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipAboutAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, aXE = {"Lcom/iqoption/vip/VipAboutAdapter$MainInfoViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/VipAboutInfoBinding;", "(Lcom/iqoption/databinding/VipAboutInfoBinding;)V", "getBinding", "()Lcom/iqoption/databinding/VipAboutInfoBinding;", "bind", "", "vipManager", "Lcom/iqoption/microservice/vip/VipManager;", "getCalendar", "Ljava/util/Calendar;", "date", "Ljava/util/Date;", "getDiffYears", "", "first", "last", "workDurationFromDate", "", "managerWorkStartDate", "yearsOldFromDate", "managerBirthday", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipAboutAdapter.kt */
    public static final class b extends ViewHolder {
        private final als dLg;

        public b(als als) {
            h.e(als, "binding");
            super(als.getRoot());
            this.dLg = als;
        }

        public final void a(d dVar) {
            String stringBuilder;
            h.e(dVar, "vipManager");
            TextView textView = this.dLg.aig;
            h.d(textView, "binding.name");
            textView.setText(dVar.ati());
            if (TextUtils.isEmpty(dVar.atg())) {
                textView = this.dLg.bUn;
                h.d(textView, "binding.information");
                textView.setVisibility(8);
                textView = this.dLg.bUo;
                h.d(textView, "binding.informationTitle");
                textView.setVisibility(8);
            } else {
                textView = this.dLg.bUn;
                h.d(textView, "binding.information");
                textView.setText(dVar.atg());
            }
            textView = this.dLg.bUr;
            h.d(textView, "binding.languages");
            textView.setText(TextUtils.join(", ", dVar.ath()));
            textView = this.dLg.bUp;
            h.d(textView, "binding.iqWorkDuration");
            textView.setText(f(dVar.ato()));
            textView = this.dLg.bUu;
            h.d(textView, "binding.years");
            textView.setText(e(dVar.atf()));
            int aGd = m.aGd();
            TextView textView2 = this.dLg.bGg;
            h.d(textView2, "binding.workingHoursTitle");
            View view = this.itemView;
            h.d(view, "itemView");
            Context context = view.getContext();
            Object[] objArr = new Object[1];
            if (aGd >= 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append('+');
                stringBuilder2.append(aGd);
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder = String.valueOf(aGd);
            }
            objArr[0] = stringBuilder;
            textView2.setText(context.getString(R.string.working_hours_n1, objArr));
            textView = this.dLg.bGf;
            h.d(textView, "binding.workingHours");
            textView.setText(TextUtils.join("; ", dVar.atp()));
            if (TextUtils.isEmpty(dVar.atk())) {
                this.dLg.bmj.setImageResource(R.drawable.ic_avatar_placeholder);
                return;
            }
            View view2 = this.itemView;
            h.d(view2, "itemView");
            Picasso.with(view2.getContext()).load(dVar.atk()).transform((Transformation) new com.iqoption.core.ui.picasso.a()).into(this.dLg.bmj);
        }

        private final String e(Date date) {
            int a = a(date, new Date());
            View view = this.itemView;
            h.d(view, "itemView");
            Context context = view.getContext();
            h.d(context, "itemView.context");
            String quantityString = context.getResources().getQuantityString(R.plurals.years_old, a, new Object[]{Integer.valueOf(a)});
            h.d(quantityString, "itemView.context.resourc…ld, diffYears, diffYears)");
            return quantityString;
        }

        private final String f(Date date) {
            int a = a(date, new Date());
            View view = this.itemView;
            h.d(view, "itemView");
            Context context = view.getContext();
            h.d(context, "itemView.context");
            String quantityString = context.getResources().getQuantityString(R.plurals.years_with_iq, a, new Object[]{Integer.valueOf(a)});
            h.d(quantityString, "itemView.context.resourc…iq, diffYears, diffYears)");
            return quantityString;
        }

        private final int a(Date date, Date date2) {
            Calendar g = g(date);
            Calendar g2 = g(date2);
            int i = g2.get(1) - g.get(1);
            return (g.get(2) > g2.get(2) || (g.get(2) == g2.get(2) && g.get(5) > g2.get(5))) ? i - 1 : i;
        }

        private final Calendar g(Date date) {
            Calendar instance = Calendar.getInstance(Locale.US);
            h.d(instance, "calendar");
            instance.setTime(date);
            return instance;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lcom/iqoption/vip/VipAboutAdapter$PhotoViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "image", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "getImage", "()Landroid/widget/ImageView;", "bind", "", "imageUrl", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipAboutAdapter.kt */
    public static final class c extends ViewHolder {
        private final ImageView aEt;

        public c(ImageView imageView) {
            h.e(imageView, "image");
            super(imageView);
            this.aEt = imageView;
        }

        public final void fA(String str) {
            h.e(str, "imageUrl");
            View view = this.itemView;
            h.d(view, "itemView");
            Picasso.with(view.getContext()).load(str).into(this.aEt);
        }
    }

    public int getItemViewType(int i) {
        return i == 0 ? 1 : 2;
    }

    public g(d dVar) {
        h.e(dVar, "vipManager");
        this.dLe = dVar;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 1:
                ViewDataBinding inflate = DataBindingUtil.inflate(from, R.layout.vip_about_info, viewGroup, false);
                h.d(inflate, "DataBindingUtil.inflate(…bout_info, parent, false)");
                return new b((als) inflate);
            case 2:
                View inflate2 = from.inflate(R.layout.vip_image, viewGroup, false);
                if (inflate2 != null) {
                    return new c((ImageView) inflate2);
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unimplemented view type ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public int getItemCount() {
        return this.dLe.atl().size() + 1;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        h.e(viewHolder, "holder");
        if (i != 0) {
            ((c) viewHolder).fA((String) this.dLe.atl().get(i - 1));
        } else {
            ((b) viewHolder).a(this.dLe);
        }
    }
}
