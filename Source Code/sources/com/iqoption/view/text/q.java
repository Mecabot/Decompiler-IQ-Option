package com.iqoption.view.text;

import android.content.Context;
import android.support.annotation.StringRes;
import com.iqoption.app.af;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\f"}, aXE = {"getAMPolicyLink", "", "context", "Landroid/content/Context;", "getLocale", "getLocalizedLink", "linkResId", "", "getPrivacyPolicyLink", "getPrivacyPolicyLinkMobile", "getTermsLink", "getTermsLinkRegulatedMobile", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Links.kt */
public final class q {
    public static final String bY(Context context) {
        h.e(context, "context");
        String string = context.getString(R.string.aml_policy_link_n1, new Object[]{cd(context)});
        h.d(string, "context.getString(R.stri…k_n1, getLocale(context))");
        return string;
    }

    public static final String bZ(Context context) {
        h.e(context, "context");
        af DX = af.DX();
        h.d(DX, "Preferences.instance()");
        String string = context.getString(DX.Dh() ? R.string.terms_and_conditions_link_regulated_n1 : R.string.terms_and_conditions_link_common_n1, new Object[]{cd(context)});
        h.d(string, "context.getString(linkResId, getLocale(context))");
        return string;
    }

    public static final String ca(Context context) {
        h.e(context, "context");
        String string = context.getString(R.string.privacy_policy_link_n1, new Object[]{cd(context)});
        h.d(string, "context.getString(R.stri…k_n1, getLocale(context))");
        return string;
    }

    public static final String cb(Context context) {
        h.e(context, "context");
        String string = context.getString(R.string.terms_and_conditions_link_regulated_mobile_n1, new Object[]{cd(context)});
        h.d(string, "context.getString(R.stri…e_n1, getLocale(context))");
        return string;
    }

    public static final String cc(Context context) {
        h.e(context, "context");
        String string = context.getString(R.string.privacy_policy_link_mobile_n1, new Object[]{cd(context)});
        h.d(string, "context.getString(R.stri…e_n1, getLocale(context))");
        return string;
    }

    public static final String o(Context context, @StringRes int i) {
        h.e(context, "context");
        String string = context.getString(i, new Object[]{cd(context)});
        h.d(string, "context.getString(linkResId, getLocale(context))");
        return string;
    }

    private static final String cd(Context context) {
        String string = context.getString(R.string.link_language_key);
        h.d(string, "locale");
        if ((((CharSequence) string).length() > 0 ? 1 : null) == null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
