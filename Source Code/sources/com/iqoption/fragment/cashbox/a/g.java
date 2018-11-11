package com.iqoption.fragment.cashbox.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.iqoption.core.microservices.billing.response.extraparams.d;
import java.util.regex.Pattern;

@SuppressLint({"ViewConstructor"})
/* compiled from: ExtraParamStringView */
public class g extends f {
    private final Pattern pattern;

    public g(Context context, String str, d dVar, boolean z, String str2) {
        Pattern pattern;
        super(context, str, dVar.getTitle(), z, str2);
        if (dVar.getPattern() == null) {
            pattern = null;
        } else {
            pattern = Pattern.compile(dVar.getPattern(), 2);
        }
        this.pattern = pattern;
    }

    public boolean isValid() {
        boolean z = false;
        if (!super.isValid()) {
            return false;
        }
        if (this.pattern == null) {
            return true;
        }
        CharSequence extraParamValue = getExtraParamValue();
        if (extraParamValue != null && this.pattern.matcher(extraParamValue).matches()) {
            z = true;
        }
        return z;
    }
}
