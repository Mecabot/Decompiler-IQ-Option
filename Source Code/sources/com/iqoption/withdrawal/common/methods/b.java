package com.iqoption.withdrawal.common.methods;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.d.amv;
import com.iqoption.microservice.withdraw.response.WithdrawMethodType;
import com.iqoption.microservice.withdraw.response.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, aXE = {"Lcom/iqoption/withdrawal/common/methods/MethodHolder;", "", "binding", "Lcom/iqoption/databinding/WithdrawMethodCardLayoutBinding;", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "mask", "", "(Lcom/iqoption/databinding/WithdrawMethodCardLayoutBinding;Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;Ljava/lang/String;)V", "getBinding", "()Lcom/iqoption/databinding/WithdrawMethodCardLayoutBinding;", "getMask", "()Ljava/lang/String;", "getMethod", "()Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MethodHolders.kt */
public final class b {
    private final a dQe;
    private final amv dRz;
    private final String mask;

    public b(amv amv, a aVar, String str) {
        h.e(amv, "binding");
        h.e(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        h.e(str, "mask");
        this.dRz = amv;
        this.dQe = aVar;
        this.mask = str;
        View root = this.dRz.getRoot();
        h.d(root, "binding.root");
        ImageView imageView = (ImageView) root.findViewById(com.iqoption.b.a.withdrawMethodIcon);
        h.d(imageView, "binding.root.withdrawMethodIcon");
        c.a(imageView, this.dQe);
        root = this.dRz.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.withdrawMethodName);
        h.d(textView, "binding.root.withdrawMethodName");
        View root2 = this.dRz.getRoot();
        h.d(root2, "binding.root");
        ImageView imageView2 = (ImageView) root2.findViewById(com.iqoption.b.a.withdrawMethodIcon);
        h.d(imageView2, "binding.root.withdrawMethodIcon");
        c.a(textView, imageView2, this.dQe);
        root = this.dRz.getRoot();
        h.d(root, "binding.root");
        textView = (TextView) root.findViewById(com.iqoption.b.a.withdrawMethodLimit);
        if (this.dQe.att() == WithdrawMethodType.CARD) {
            h.d(textView, "limitTextView");
            c.a(textView, this.dQe, this.mask);
            textView.setVisibility(0);
            return;
        }
        h.d(textView, "limitTextView");
        textView.setVisibility(8);
    }

    public final amv aNQ() {
        return this.dRz;
    }

    public final a aNc() {
        return this.dQe;
    }
}
