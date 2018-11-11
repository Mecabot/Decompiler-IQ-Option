package com.iqoption.fragment.leftmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.xy;
import com.iqoption.dto.Event;
import com.iqoption.fragment.leftmenu.b.c;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.util.at;
import com.iqoption.view.text.e;
import com.iqoption.x.R;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/fragment/leftmenu/ProTraderHolder;", "Lcom/iqoption/fragment/leftmenu/LeftMenuAdapter$ViewHolder;", "binding", "Lcom/iqoption/databinding/LeftMenuItemProTraderBinding;", "listener", "Lcom/iqoption/fragment/leftmenu/ProTraderHolder$OnProTraderClickListener;", "(Lcom/iqoption/databinding/LeftMenuItemProTraderBinding;Lcom/iqoption/fragment/leftmenu/ProTraderHolder$OnProTraderClickListener;)V", "bind", "", "statusType", "Lcom/iqoption/microservice/regulators/response/StatusType;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "prepareBackground", "prepareButtons", "prepareText", "prepareTitle", "reportClose", "OnProTraderClickListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderHolder.kt */
public final class i extends c {
    private final xy cCR;
    private final a cCS;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/fragment/leftmenu/ProTraderHolder$OnProTraderClickListener;", "", "onProTraderClose", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderHolder.kt */
    public interface a {
        void alF();
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderHolder.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ i cCU;
        final /* synthetic */ StatusType cCV;

        b(i iVar, StatusType statusType) {
            this.cCU = iVar;
            this.cCV = statusType;
        }

        public final void onClick(View view) {
            this.cCU.cCS.alF();
            this.cCU.h(this.cCV);
        }
    }

    public i(xy xyVar, a aVar) {
        h.e(xyVar, "binding");
        h.e(aVar, "listener");
        super(xyVar, R.layout.left_menu_item_pro_trader);
        this.cCR = xyVar;
        this.cCS = aVar;
    }

    public final void c(StatusType statusType) {
        h.e(statusType, "statusType");
        d(statusType);
        e(statusType);
        f(statusType);
        g(statusType);
        LinearLayout linearLayout = this.cCR.bKA;
        h.d(linearLayout, "container");
        linearLayout.setEnabled(statusType != StatusType.PENDING);
    }

    private final void d(StatusType statusType) {
        CharSequence string;
        Context alR = alR();
        switch (statusType) {
            case DECLINED:
                string = alR.getString(R.string.application_declined);
                break;
            case PENDING:
                string = alR.getString(R.string.account_category);
                break;
            case APPROVED:
                at.bJ(statusType);
                throw null;
            default:
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(alR.getString(R.string.become_a));
                spannableStringBuilder.append("  ");
                Drawable drawable = ContextCompat.getDrawable(alR, R.drawable.ic_pro_badge);
                if (drawable == null) {
                    h.aXZ();
                }
                Context alR2 = alR();
                h.d(alR2, "context()");
                Resources resources = alR2.getResources();
                h.d(drawable, "drawable");
                e eVar = new e(drawable, resources.getDimensionPixelSize(R.dimen.dp32), resources.getDimensionPixelSize(R.dimen.dp14));
                int length = spannableStringBuilder.length();
                spannableStringBuilder.setSpan(eVar, length - 1, length, 17);
                string = spannableStringBuilder;
                break;
        }
        TextView textView = this.cCR.bKD;
        h.d(textView, "binding.itemProTitle");
        textView.setText(string);
    }

    private final void e(StatusType statusType) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Context alR = alR();
        h.d(alR, "ctx");
        Resources resources = alR.getResources();
        String str;
        switch (statusType) {
            case DECLINED:
                str = "*PRO_BADGE_ANCHOR*";
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(alR.getString(R.string.your_application_for_n1_declined, new Object[]{str}));
                Drawable drawable = ContextCompat.getDrawable(alR, R.drawable.ic_pro_badge);
                if (drawable == null) {
                    h.aXZ();
                }
                h.d(drawable, "drawable");
                e eVar = new e(drawable, resources.getDimensionPixelSize(R.dimen.dp23), resources.getDimensionPixelSize(R.dimen.dp10));
                charSequence = spannableStringBuilder;
                int a = v.a(charSequence, str, 0, false, 6, null);
                spannableStringBuilder.setSpan(eVar, a, str.length() + a, 17);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(alR.getString(R.string.learn_more));
                spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 17);
                spannableStringBuilder.append(" ");
                spannableStringBuilder.append(spannableStringBuilder2);
                break;
            case PENDING:
                str = "*PRO_BADGE_ANCHOR*";
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(alR.getString(R.string.your_application_for_n1_progress, new Object[]{str}));
                Drawable drawable2 = ContextCompat.getDrawable(alR, R.drawable.ic_pro_badge);
                if (drawable2 == null) {
                    h.aXZ();
                }
                h.d(drawable2, "drawable");
                e eVar2 = new e(drawable2, resources.getDimensionPixelSize(R.dimen.dp23), resources.getDimensionPixelSize(R.dimen.dp10));
                charSequence2 = spannableStringBuilder3;
                int a2 = v.a(charSequence2, str, 0, false, 6, null);
                spannableStringBuilder3.setSpan(eVar2, a2, str.length() + a2, 17);
                break;
            case APPROVED:
                at.bJ(statusType);
                throw null;
            default:
                charSequence2 = alR.getString(R.string.learn_more_about_account_categories);
                break;
        }
        charSequence = charSequence2;
        TextView textView = this.cCR.bKC;
        h.d(textView, "binding.itemProText");
        textView.setText(charSequence);
    }

    private final void f(StatusType statusType) {
        switch (statusType) {
            case PENDING:
            case DECLINED:
                ImageView imageView = this.cCR.bKB;
                h.d(imageView, "binding.itemProRightArrow");
                com.iqoption.core.ext.a.M(imageView);
                imageView = this.cCR.bKz;
                h.d(imageView, "binding.itemProClose");
                com.iqoption.core.ext.a.L(imageView);
                this.cCR.bKz.setOnClickListener(new b(this, statusType));
                return;
            default:
                ImageView imageView2 = this.cCR.bKB;
                h.d(imageView2, "binding.itemProRightArrow");
                com.iqoption.core.ext.a.L(imageView2);
                imageView2 = this.cCR.bKz;
                h.d(imageView2, "binding.itemProClose");
                com.iqoption.core.ext.a.M(imageView2);
                return;
        }
    }

    private final void g(StatusType statusType) {
        LinearLayout linearLayout = this.cCR.bKA;
        if (j.auW[statusType.ordinal()] != 1) {
            linearLayout.setBackgroundColor(ContextCompat.getColor(alR(), R.color.grey_blur_05));
        } else {
            linearLayout.setBackgroundResource(R.drawable.bg_grey_blur_05_boredr_red);
        }
    }

    private final Context alR() {
        View root = this.cCR.getRoot();
        h.d(root, "binding.root");
        return root.getContext();
    }

    private final void h(StatusType statusType) {
        String str;
        switch (statusType) {
            case PENDING:
                str = "menu_on-review-close";
                break;
            case DECLINED:
                str = "menu_declined-close";
                break;
            default:
                at.bJ(statusType);
                throw null;
        }
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, str));
    }
}
