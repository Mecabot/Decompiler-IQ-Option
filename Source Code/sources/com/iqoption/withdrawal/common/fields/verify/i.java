package com.iqoption.withdrawal.common.fields.verify;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.iqoption.core.ext.c;
import com.iqoption.d.uu;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyWarningHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/FragmentWithdrawVerifyPageBinding;", "listener", "Lcom/iqoption/withdrawal/common/fields/verify/WarningListener;", "(Lcom/iqoption/databinding/FragmentWithdrawVerifyPageBinding;Lcom/iqoption/withdrawal/common/fields/verify/WarningListener;)V", "bind", "", "warning", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "screenWidth", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getCardDigits", "", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "getVerifyButton", "Landroid/view/View;", "hasDeclined", "", "cards", "", "showCardsWarning", "showDocWarning", "state", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawVerifyWarningHolder.kt */
public final class i extends ViewHolder {
    private final f dQX;
    private final uu dQY;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawVerifyWarningHolder.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ i dQZ;
        final /* synthetic */ List dRa;

        a(i iVar, List list) {
            this.dQZ = iVar;
            this.dRa = list;
        }

        public final void onClick(View view) {
            if (this.dRa.size() == 1) {
                this.dQZ.dQX.m((q) u.bU(this.dRa));
            } else {
                this.dQZ.dQX.aNt();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawVerifyWarningHolder.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ i dQZ;

        b(i iVar) {
            this.dQZ = iVar;
        }

        public final void onClick(View view) {
            this.dQZ.dQX.aNs();
        }
    }

    public i(uu uuVar, f fVar) {
        h.e(uuVar, "binding");
        h.e(fVar, "listener");
        super(uuVar.getRoot());
        this.dQY = uuVar;
        this.dQX = fVar;
        View root = this.dQY.getRoot();
        h.d(root, "binding.root");
        root = root.findViewById(com.iqoption.b.a.withdrawVerifyButtonContainerRight);
        h.d(root, "binding.root.withdrawVerifyButtonContainerRight");
        com.iqoption.core.ext.a.M(root);
        root = this.dQY.getRoot();
        h.d(root, "binding.root");
        root = root.findViewById(com.iqoption.b.a.withdrawVerifyButtonContainerBottom);
        h.d(root, "binding.root.withdrawVerifyButtonContainerBottom");
        com.iqoption.core.ext.a.M(root);
        com.iqoption.core.ext.a.L(aNC());
    }

    public final void a(d dVar, int i) {
        h.e(dVar, "warning");
        View root = this.dQY.getRoot();
        h.d(root, "binding.root");
        LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        marginLayoutParams.width = (i - marginLayoutParams.getMarginStart()) - marginLayoutParams.getMarginEnd();
        marginLayoutParams.height = -2;
        View root2 = this.dQY.getRoot();
        h.d(root2, "binding.root");
        root2.setLayoutParams(marginLayoutParams);
        VerificationWarningType aNr = dVar.aNr();
        switch (aNr) {
            case DOCUMENTS_WARNING:
                kq(((c) dVar).getState());
                return;
            case CARDS_WARNING:
                bD(((a) dVar).atB());
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case: ");
                stringBuilder.append(aNr);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    private final void kq(java.lang.String r5) {
        /*
        r4 = this;
        r0 = r5.hashCode();
        r1 = 1350822958; // 0x5083ec2e float:1.77063485E10 double:6.67395217E-315;
        r2 = 1090724009; // 0x410320a9 float:8.195474 double:5.38889262E-315;
        if (r0 == r2) goto L_0x001b;
    L_0x000c:
        if (r0 == r1) goto L_0x000f;
    L_0x000e:
        goto L_0x0027;
    L_0x000f:
        r0 = "DECLINED";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x0017:
        r0 = 2131821076; // 0x7f110214 float:1.9274885E38 double:1.0532595567E-314;
        goto L_0x002a;
    L_0x001b:
        r0 = "VERIFYING";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x0023:
        r0 = 2131821075; // 0x7f110213 float:1.9274883E38 double:1.053259556E-314;
        goto L_0x002a;
    L_0x0027:
        r0 = 2131821077; // 0x7f110215 float:1.9274887E38 double:1.053259557E-314;
    L_0x002a:
        r3 = r4.dQY;
        r3 = r3.bHx;
        r3.setText(r0);
        r0 = r5.hashCode();
        if (r0 == r2) goto L_0x0046;
    L_0x0037:
        if (r0 == r1) goto L_0x003a;
    L_0x0039:
        goto L_0x0052;
    L_0x003a:
        r0 = "DECLINED";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0052;
    L_0x0042:
        r0 = 2131822890; // 0x7f11092a float:1.9278564E38 double:1.053260453E-314;
        goto L_0x0055;
    L_0x0046:
        r0 = "VERIFYING";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0052;
    L_0x004e:
        r0 = 2131822892; // 0x7f11092c float:1.9278568E38 double:1.053260454E-314;
        goto L_0x0055;
    L_0x0052:
        r0 = 2131822891; // 0x7f11092b float:1.9278566E38 double:1.0532604535E-314;
    L_0x0055:
        r1 = r4.dQY;
        r1 = r1.bHw;
        r1.setText(r0);
        r0 = r5.hashCode();
        if (r0 == r2) goto L_0x0063;
    L_0x0062:
        goto L_0x0073;
    L_0x0063:
        r0 = "VERIFYING";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x0073;
    L_0x006b:
        r5 = r4.aNC();
        com.iqoption.core.ext.a.M(r5);
        goto L_0x007a;
    L_0x0073:
        r5 = r4.aNC();
        com.iqoption.core.ext.a.L(r5);
    L_0x007a:
        r5 = r4.dQY;
        r5 = r5.getRoot();
        r0 = new com.iqoption.withdrawal.common.fields.verify.i$b;
        r0.<init>(r4);
        r0 = (android.view.View.OnClickListener) r0;
        r5.setOnClickListener(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.fields.verify.i.kq(java.lang.String):void");
    }

    private final void bD(List<q> list) {
        TextView textView = this.dQY.bHw;
        TextView textView2 = this.dQY.bHx;
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if ((c.b(((q) next).auX(), CardStatus.VERIFY_PENDING, CardStatus.DECLINED) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        int size = ((List) arrayList).size();
        if (bE(list)) {
            textView2.setText(R.string.card_verification_declined);
            textView.setText(R.string.you_need_to_verify_your_bank_cards_declined);
            com.iqoption.core.ext.a.L(aNC());
        } else if (size > 1 || (size > 0 && list.size() > 1)) {
            textView2.setText(R.string.card_verification);
            textView.setText(R.string.you_need_to_verify_your_bank_cards);
            com.iqoption.core.ext.a.L(aNC());
        } else if (size > 0) {
            textView2.setText(R.string.card_verification);
            String string = alR().getString(R.string.you_need_to_verify_your_bank_card_n1, new Object[]{n((q) u.bU(list))});
            h.d(textView, "descriptionTextView");
            textView.setText(string);
            com.iqoption.core.ext.a.L(aNC());
        } else {
            textView2.setText(R.string.card_being_verified);
            textView.setText(R.string.you_need_to_verify_your_bank_cards_progress);
            com.iqoption.core.ext.a.M(aNC());
        }
        this.dQY.getRoot().setOnClickListener(new a(this, list));
    }

    private final boolean bE(List<q> list) {
        for (Object next : list) {
            Object obj;
            if (((q) next).auX() == CardStatus.DECLINED) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        return next2 != null;
    }

    private final String n(q qVar) {
        String number = qVar.getNumber();
        int length = number.length() - 4;
        if (number == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        number = number.substring(length);
        h.d(number, "(this as java.lang.String).substring(startIndex)");
        return number;
    }

    private final Context alR() {
        View root = this.dQY.getRoot();
        h.d(root, "binding.root");
        return root.getContext();
    }

    private final View aNC() {
        Context alR = alR();
        h.d(alR, "context()");
        View root;
        if (alR.getResources().getBoolean(R.bool.isLand)) {
            root = this.dQY.getRoot();
            h.d(root, "binding.root");
            root = root.findViewById(com.iqoption.b.a.withdrawVerifyButtonContainerRight);
            h.d(root, "binding.root.withdrawVerifyButtonContainerRight");
            return root;
        }
        root = this.dQY.getRoot();
        h.d(root, "binding.root");
        root = root.findViewById(com.iqoption.b.a.withdrawVerifyButtonContainerBottom);
        h.d(root, "binding.root.withdrawVerifyButtonContainerBottom");
        return root;
    }
}
