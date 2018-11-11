package com.iqoption.withdrawal.common.fields;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.iqoption.d.amk;
import com.iqoption.microservice.withdraw.response.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/FieldHolder;", "", "binding", "Lcom/iqoption/databinding/WithdrawFieldConstructorBinding;", "field", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "(Lcom/iqoption/databinding/WithdrawFieldConstructorBinding;Lcom/iqoption/microservice/withdraw/response/PayoutField;)V", "edit", "Landroid/widget/EditText;", "getEdit", "()Landroid/widget/EditText;", "error", "Landroid/widget/TextView;", "getError", "()Landroid/widget/TextView;", "getField", "()Lcom/iqoption/microservice/withdraw/response/PayoutField;", "title", "getTitle", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsFragment.kt */
public final class a {
    private final TextView agA;
    private final TextView bAU;
    private final EditText dQc;
    private final f dQd;

    public a(amk amk, f fVar) {
        h.e(amk, "binding");
        h.e(fVar, "field");
        this.dQd = fVar;
        View root = amk.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.withdrawFieldTitle);
        if (textView == null) {
            h.aXZ();
        }
        this.agA = textView;
        root = amk.getRoot();
        h.d(root, "binding.root");
        EditText editText = (EditText) root.findViewById(com.iqoption.b.a.withdrawFieldEditText);
        if (editText == null) {
            h.aXZ();
        }
        this.dQc = editText;
        View root2 = amk.getRoot();
        h.d(root2, "binding.root");
        TextView textView2 = (TextView) root2.findViewById(com.iqoption.b.a.withdrawFieldError);
        if (textView2 == null) {
            h.aXZ();
        }
        this.bAU = textView2;
    }

    public final f aMY() {
        return this.dQd;
    }

    public final EditText aMW() {
        return this.dQc;
    }

    public final TextView aMX() {
        return this.bAU;
    }
}
