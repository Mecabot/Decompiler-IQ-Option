package com.iqoption.withdrawal.common.history;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.d.amn;
import com.iqoption.microservice.withdraw.response.Status;
import com.iqoption.microservice.withdraw.response.e;
import com.iqoption.microservice.withdraw.response.l;
import com.iqoption.portfolio.component.o;
import com.iqoption.util.q;
import com.iqoption.x.R;
import io.card.payment.CardType;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/withdrawal/common/history/PayoutViewHolder;", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewHolder;", "binding", "Lcom/iqoption/databinding/WithdrawHistoryPayoutItemBinding;", "uiConfig", "Lcom/iqoption/portfolio/component/UIConfig;", "cancelClickListener", "Lcom/iqoption/withdrawal/common/history/CancelClickListener;", "(Lcom/iqoption/databinding/WithdrawHistoryPayoutItemBinding;Lcom/iqoption/portfolio/component/UIConfig;Lcom/iqoption/withdrawal/common/history/CancelClickListener;)V", "getBinding", "()Lcom/iqoption/databinding/WithdrawHistoryPayoutItemBinding;", "bind", "", "item", "Lcom/iqoption/withdrawal/common/history/PayoutItem;", "getCardData", "Lcom/iqoption/withdrawal/common/history/CardData;", "payout", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "setCloseButton", "setIcon", "setName", "cardData", "setStatus", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryHolders.kt */
public final class f extends n {
    private final o cYW;
    private final amn dRg;
    private final b dRh;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawHistoryHolders.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ f dRi;
        final /* synthetic */ l dRj;

        a(f fVar, l lVar) {
            this.dRi = fVar;
            this.dRj = lVar;
        }

        public final void onClick(View view) {
            this.dRi.dRh.a(this.dRj);
        }
    }

    public f(amn amn, o oVar, b bVar) {
        h.e(amn, "binding");
        h.e(oVar, "uiConfig");
        h.e(bVar, "cancelClickListener");
        super(amn);
        this.dRg = amn;
        this.cYW = oVar;
        this.dRh = bVar;
    }

    public final void a(e eVar) {
        h.e(eVar, "item");
        l aNG = eVar.aNG();
        c b = b(aNG);
        c(aNG);
        a(aNG, b);
        View root = this.dRg.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.withdrawTime);
        h.d(textView, "binding.root.withdrawTime");
        textView.setText(this.cYW.aM(aNG.atL().getTime()));
        String a = com.iqoption.util.l.a(eVar.getMask(), Double.valueOf(aNG.VZ().doubleValue()), q.dY(eVar.getMinorUnits()));
        View root2 = this.dRg.getRoot();
        h.d(root2, "binding.root");
        TextView textView2 = (TextView) root2.findViewById(com.iqoption.b.a.withdrawValue);
        h.d(textView2, "binding.root.withdrawValue");
        textView2.setText(a);
        a = aNG.getMessage();
        textView2 = this.dRg.bUU;
        CharSequence charSequence = a;
        Object obj = (charSequence == null || u.M(charSequence)) ? 1 : null;
        if (obj == null) {
            h.d(textView2, "commentView");
            textView2.setVisibility(0);
            String string = textView2.getContext().getString(R.string.comment_suffix);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, string.length(), 33);
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(charSequence);
            textView2.setText(spannableStringBuilder);
        } else {
            h.d(textView2, "commentView");
            textView2.setVisibility(8);
        }
        d(aNG);
        b(eVar);
    }

    private final c b(l lVar) {
        e atN = lVar.atN();
        if (atN == null) {
            return null;
        }
        String atD = atN.atD();
        CardType gV = com.iqoption.core.util.a.gV(atD);
        if (gV == null) {
            gV = CardType.UNKNOWN;
        }
        int length = atD.length() - 4;
        if (atD == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        atD = atD.substring(length);
        h.d(atD, "(this as java.lang.String).substring(startIndex)");
        return new c(gV, atD);
    }

    private final void c(l lVar) {
        ImageView imageView = this.dRg.bUV;
        h.d(imageView, "withdrawIcon");
        Context context = imageView.getContext();
        h.d(context, "context");
        if (context.getResources().getBoolean(R.bool.isLand)) {
            Status atK = lVar.atK();
            int i = m.dRs.contains(atK) ? R.drawable.ic_withdraw_success : m.dRu.contains(atK) ? R.drawable.ic_withdraw_error : R.drawable.ic_withdraw_progress;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, i));
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    private final void a(l lVar, c cVar) {
        String stringBuilder;
        if (cVar != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(cVar.getCardType());
            stringBuilder2.append(" **");
            stringBuilder2.append(cVar.aNF());
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = lVar.atM();
        }
        TextView textView = this.dRg.bUX;
        h.d(textView, "binding.withdrawTitle");
        textView.setText(stringBuilder);
    }

    private final void d(l lVar) {
        int i;
        View root = this.dRg.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.withdrawStatus);
        h.d(textView, "statusView");
        Context context = textView.getContext();
        Status atK = lVar.atK();
        int i2 = m.dRs.contains(atK) ? R.color.green : m.dRt.contains(atK) ? R.color.red : R.color.grey_blur;
        textView.setTextColor(ContextCompat.getColor(context, i2));
        switch (lVar.atK()) {
            case STATUS_NEW:
            case OP_CREATING:
            case PROCESSING_READY:
            case CALLBACK_WAIT:
            case ANSWER_RECEIVED:
                i = R.string.in_progress;
                break;
            case KYC_CHECKING:
                i = R.string.kyc_checking;
                break;
            case APPROVE_REQUIRED:
                i = R.string.approval_required;
                break;
            case APPROVE_PROCESSING:
                i = R.string.approval_processing;
                break;
            case PENDING:
                i = R.string.pending;
                break;
            case PROCESSING_STARTED:
                i = R.string.processing_started;
                break;
            case FAILED:
            case PROCESSING_FAILED:
                i = R.string.failed;
                break;
            case SUCCESS:
            case SUCCESS_PROCESSING:
                i = R.string.funds_sent;
                break;
            case DECLINED:
                i = R.string.declined;
                break;
            case CANCELED:
            case CANCEL_PROCESSING:
                i = R.string.canceled;
                break;
            default:
                i = R.string.unknown;
                break;
        }
        textView.setText(i);
    }

    private final void b(e eVar) {
        int i = 8;
        if (eVar.aNH()) {
            ContentLoadingProgressBar contentLoadingProgressBar = this.dRg.bUS;
            h.d(contentLoadingProgressBar, "binding.withdrawCancelProgress");
            contentLoadingProgressBar.setVisibility(0);
            ImageView imageView = this.dRg.bUR;
            h.d(imageView, "binding.withdrawCancel");
            imageView.setVisibility(8);
            return;
        }
        ContentLoadingProgressBar contentLoadingProgressBar2 = this.dRg.bUS;
        h.d(contentLoadingProgressBar2, "binding.withdrawCancelProgress");
        contentLoadingProgressBar2.setVisibility(8);
        l aNG = eVar.aNG();
        ImageView imageView2;
        if (m.dRv.contains(aNG.atK())) {
            imageView2 = this.dRg.bUR;
            h.d(imageView2, "binding.withdrawCancel");
            imageView2.setVisibility(0);
            this.dRg.bUR.setOnClickListener(new a(this, aNG));
            return;
        }
        View root = this.dRg.getRoot();
        h.d(root, "binding.root");
        Context context = root.getContext();
        h.d(context, "context");
        boolean z = context.getResources().getBoolean(R.bool.isLand);
        imageView2 = this.dRg.bUR;
        h.d(imageView2, "binding.withdrawCancel");
        if (z) {
            i = 4;
        }
        imageView2.setVisibility(i);
    }
}
