package com.iqoption.deposit;

import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.iqoption.core.util.a.b;
import com.iqoption.core.util.a.d;
import com.iqoption.core.util.a.e;
import com.iqoption.deposit.r.c;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, aXE = {"Lcom/iqoption/deposit/DepositKycUtils;", "", "()V", "setKycVerifyText", "", "fragment", "Landroid/support/v4/app/Fragment;", "textView", "Landroid/widget/TextView;", "message", "", "red", "", "deposit_release"})
/* compiled from: DepositKycUtils.kt */
public final class k {
    public static final k bVt = new k();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/deposit/DepositKycUtils$setKycVerifyText$params$1", "Lcom/iqoption/core/util/link/LinkClickListener;", "onLinkClicked", "", "link", "Lcom/iqoption/core/util/link/Link;", "deposit_release"})
    /* compiled from: DepositKycUtils.kt */
    public static final class a implements b {
        final /* synthetic */ Fragment bVu;

        a(Fragment fragment) {
            this.bVu = fragment;
        }

        public void a(com.iqoption.core.util.a.a aVar) {
            h.e(aVar, "link");
            com.iqoption.deposit.navigator.b.cbG.b(this.bVu, true);
        }
    }

    private k() {
    }

    public final void a(Fragment fragment, TextView textView, CharSequence charSequence, boolean z) {
        h.e(fragment, "fragment");
        h.e(textView, "textView");
        h.e(charSequence, "message");
        String string = com.iqoption.core.ext.a.m(fragment).getString(r.h.kyc_verify_account);
        h.d(string, "ctx.getString(R.string.kyc_verify_account)");
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string = string.toUpperCase();
        h.d(string, "(this as java.lang.String).toUpperCase()");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append(".\n");
        spannableStringBuilder.append(string);
        d.a(new e(new com.iqoption.core.util.a.a[]{new com.iqoption.core.util.a.a(string, "")}, textView, spannableStringBuilder, z ? c.red : c.green, z ? c.red_50 : c.green_50, true, new a(fragment)));
    }
}
