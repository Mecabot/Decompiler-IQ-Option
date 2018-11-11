package com.iqoption.deposit.light;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.iqoption.deposit.r.c;
import com.iqoption.deposit.r.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, aXE = {"setErrorCustom", "", "Landroid/widget/EditText;", "message", "", "deposit_release"})
/* compiled from: LightFieldExtensions.kt */
public final class a {
    public static final void b(EditText editText, String str) {
        int i;
        Context context;
        h.e(editText, "$receiver");
        if (str == null) {
            editText.setError((CharSequence) null);
            i = c.black;
        } else {
            editText.requestFocus();
            context = editText.getContext();
            h.d(context, "context");
            Drawable l = com.iqoption.core.ext.a.l(context, e.ic_error_red);
            l.setBounds(0, 0, l.getIntrinsicWidth(), l.getIntrinsicHeight());
            editText.setError(str, l);
            i = c.deposit_red;
        }
        context = editText.getContext();
        h.d(context, "context");
        editText.setTextColor(com.iqoption.core.ext.a.i(context, i));
    }
}
