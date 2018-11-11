package com.iqoption.operations;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.d.acq;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, aXE = {"Lcom/iqoption/operations/OperationSearchResultAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/operations/OperationSearchResultAdapter$OperationViewHolder;", "items", "", "Lcom/iqoption/microservice/operation/Transaction;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OperationViewHolder", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationSearchResultAdapter.kt */
public final class e extends Adapter<b> {
    private static final SimpleDateFormat cXm = new SimpleDateFormat("dd/MM/yy, HH:mm", Locale.getDefault());
    public static final a cXn = new a();
    private final List<com.iqoption.microservice.b.b> nj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/operations/OperationSearchResultAdapter$Companion;", "", "()V", "dateTimeFormat", "Ljava/text/SimpleDateFormat;", "getDateTimeFormat", "()Ljava/text/SimpleDateFormat;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationSearchResultAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final SimpleDateFormat avt() {
            return e.cXm;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, aXE = {"Lcom/iqoption/operations/OperationSearchResultAdapter$OperationViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/OperationSearchResultItemBinding;", "(Lcom/iqoption/databinding/OperationSearchResultItemBinding;)V", "getBinding", "()Lcom/iqoption/databinding/OperationSearchResultItemBinding;", "bind", "", "transition", "Lcom/iqoption/microservice/operation/Transaction;", "imageResourceFromTransaction", "", "operationNameFromTransaction", "", "operationStatusFromTransaction", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationSearchResultAdapter.kt */
    public static final class b extends ViewHolder {
        private final acq cXo;

        public b(acq acq) {
            h.e(acq, "binding");
            super(acq.getRoot());
            this.cXo = acq;
        }

        public final void a(com.iqoption.microservice.b.b bVar) {
            h.e(bVar, "transition");
            acq acq = this.cXo;
            acq.bmu.setImageResource(b(bVar));
            TextView textView = acq.bNP;
            h.d(textView, "operationName");
            textView.setText(d(bVar));
            textView = acq.bNO;
            h.d(textView, "operationDate");
            textView.setText(e.cXn.avt().format(new Date(bVar.Vs() * ((long) 1000))));
            textView = acq.btG;
            h.d(textView, "amount");
            textView.setText(l.s(Double.valueOf((double) bVar.asE())));
            TextView textView2 = acq.bNQ;
            h.d(textView2, "operationStatus");
            textView2.setText(c(bVar));
        }

        private final int b(com.iqoption.microservice.b.b bVar) {
            String type = bVar.getType();
            return (type.hashCode() == -1629586251 && type.equals("withdrawal")) ? R.drawable.ic_wathdraw : R.drawable.ic_history_add;
        }

        private final CharSequence c(com.iqoption.microservice.b.b bVar) {
            int color;
            SpannableString spannableString;
            String str = "";
            String status = bVar.getStatus();
            int hashCode = status.hashCode();
            View view;
            if (hashCode != -1402931637) {
                if (hashCode != -1281977283) {
                    if (hashCode != -123173735) {
                        if (hashCode == 1638128981 && status.equals("in_process")) {
                            view = this.itemView;
                            h.d(view, "itemView");
                            str = view.getResources().getString(R.string.in_process);
                            h.d(str, "itemView.resources.getString(R.string.in_process)");
                            view = this.itemView;
                            h.d(view, "itemView");
                            color = ContextCompat.getColor(view.getContext(), R.color.grey_blur);
                            spannableString = new SpannableString(str);
                            spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 17);
                            return spannableString;
                        }
                    } else if (status.equals("canceled")) {
                        view = this.itemView;
                        h.d(view, "itemView");
                        str = view.getResources().getString(R.string.canceled);
                        h.d(str, "itemView.resources.getString(R.string.canceled)");
                        view = this.itemView;
                        h.d(view, "itemView");
                        color = ContextCompat.getColor(view.getContext(), R.color.red);
                        spannableString = new SpannableString(str);
                        spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 17);
                        return spannableString;
                    }
                } else if (status.equals("failed")) {
                    view = this.itemView;
                    h.d(view, "itemView");
                    str = view.getResources().getString(R.string.failed);
                    h.d(str, "itemView.resources.getString(R.string.failed)");
                    view = this.itemView;
                    h.d(view, "itemView");
                    color = ContextCompat.getColor(view.getContext(), R.color.red);
                    spannableString = new SpannableString(str);
                    spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 17);
                    return spannableString;
                }
            } else if (status.equals("completed")) {
                view = this.itemView;
                h.d(view, "itemView");
                str = view.getResources().getString(R.string.completed);
                h.d(str, "itemView.resources.getString(R.string.completed)");
                view = this.itemView;
                h.d(view, "itemView");
                color = ContextCompat.getColor(view.getContext(), R.color.green);
                spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 17);
                return spannableString;
            }
            color = -1;
            spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 17);
            return spannableString;
        }

        private final String d(com.iqoption.microservice.b.b bVar) {
            String type = bVar.getType();
            int hashCode = type.hashCode();
            View view;
            if (hashCode != -1629586251) {
                if (hashCode != 467257757) {
                    if (hashCode != 1554454174) {
                        if (hashCode == 1600694853 && type.equals("tournament_reward")) {
                            view = this.itemView;
                            h.d(view, "itemView");
                            type = view.getResources().getString(R.string.tournament_reward);
                            h.d(type, "itemView.resources.getSt…string.tournament_reward)");
                            return type;
                        }
                    } else if (type.equals("deposit")) {
                        view = this.itemView;
                        h.d(view, "itemView");
                        type = view.getResources().getString(R.string.deposit);
                        h.d(type, "itemView.resources.getString(R.string.deposit)");
                        return type;
                    }
                } else if (type.equals("tournament_rebuy")) {
                    view = this.itemView;
                    h.d(view, "itemView");
                    type = view.getResources().getString(R.string.tournament_rebuy);
                    h.d(type, "itemView.resources.getSt….string.tournament_rebuy)");
                    return type;
                }
            } else if (type.equals("withdrawal")) {
                view = this.itemView;
                h.d(view, "itemView");
                type = view.getResources().getString(R.string.withdrawal);
                h.d(type, "itemView.resources.getString(R.string.withdrawal)");
                return type;
            }
            return "";
        }
    }

    public e(List<com.iqoption.microservice.b.b> list) {
        h.e(list, "items");
        this.nj = list;
        setHasStableIds(true);
    }

    /* renamed from: N */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return new b((acq) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.operation_search_result_item, null, false, 2, null));
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        h.e(bVar, "holder");
        bVar.a((com.iqoption.microservice.b.b) this.nj.get(i));
    }

    public long getItemId(int i) {
        return ((com.iqoption.microservice.b.b) this.nj.get(i)).getId();
    }
}
