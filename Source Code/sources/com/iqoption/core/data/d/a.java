package com.iqoption.core.data.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.core.data.d.b.b;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR(\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R(\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR0\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040,2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040,8F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0002022\u0006\u0010\u0012\u001a\u0002028F@FX\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0002022\u0006\u0010\u0012\u001a\u0002028F@FX\u000e¢\u0006\f\u001a\u0004\b9\u00105\"\u0004\b:\u00107R$\u0010;\u001a\u0002022\u0006\u0010\u0012\u001a\u0002028F@FX\u000e¢\u0006\f\u001a\u0004\b<\u00105\"\u0004\b=\u00107R$\u0010>\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001d¨\u0006A"}, aXE = {"Lcom/iqoption/core/data/prefs/AppPrefs;", "", "()V", "ACTIVE_INDICATOR_INCREMENT", "", "AFF", "DEVICE_ID", "LOCALIZATION_VERSION", "LOGIN_EMAIL", "PASSCODE", "PASSCODE_EXPIRATION_TIME", "PREF_NAME_APP", "RECOVERY_CONFIG_ADDRESSES", "RETRACK", "STANDARD_LIBRARY_VERSION", "TIME_REQUEST_TWO_STEP_AUTH_LOGIN", "TIME_RETRACK", "TWO_STEP_AUTH_PHONE_MASK", "value", "", "activeIndicatorIncrement", "getActiveIndicatorIncrement", "()I", "setActiveIndicatorIncrement", "(I)V", "aff", "getAff", "()Ljava/lang/String;", "setAff", "(Ljava/lang/String;)V", "deviceId", "getDeviceId", "setDeviceId", "localizationVersion", "getLocalizationVersion", "setLocalizationVersion", "loginEmail", "getLoginEmail", "setLoginEmail", "prefs", "Lcom/iqoption/core/data/prefs/Prefs;", "reTrack", "getReTrack", "setReTrack", "", "recoveryConfigAddresses", "getRecoveryConfigAddresses", "()Ljava/util/List;", "setRecoveryConfigAddresses", "(Ljava/util/List;)V", "", "standardLibraryVersion", "getStandardLibraryVersion", "()J", "setStandardLibraryVersion", "(J)V", "timeReTrack", "getTimeReTrack", "setTimeReTrack", "timeRequestTwoStepAuthLogin", "getTimeRequestTwoStepAuthLogin", "setTimeRequestTwoStepAuthLogin", "twoStepAuthPhoneMask", "getTwoStepAuthPhoneMask", "setTwoStepAuthPhoneMask", "core_release"})
/* compiled from: AppPrefs.kt */
public final class a {
    private static final b aOy = b.aOA.gm("app_pref_name");
    public static final a aOz = new a();

    static {
        aOy.remove("two_step_auth_user");
        aOy.remove("two_step_auth_password");
    }

    private a() {
    }

    public final String DN() {
        return b.a(aOy, "aff", null, 2, null);
    }

    public final String DO() {
        return b.a(aOy, "retrack", null, 2, null);
    }

    public final long SC() {
        return b.a(aOy, "time_retrack", 0, 2, null);
    }

    public final String EH() {
        String a = b.a(aOy, "login_email", null, 2, null);
        return a != null ? a : "";
    }

    public final long ER() {
        return b.a(aOy, "time_request_two_step_auth_login", 0, 2, null);
    }

    public final String SD() {
        return b.a(aOy, "localization_version", null, 2, null);
    }

    public final void gl(String str) {
        if (str != null) {
            aOy.put("localization_version", str);
        } else {
            aOy.remove("localization_version");
        }
    }

    public final long SE() {
        return b.a(aOy, "standard_library_version", 0, 2, null);
    }

    public final void aO(long j) {
        aOy.put("standard_library_version", j);
    }

    public final List<String> SF() {
        String a = b.a(aOy, "recovery_config_addresses", null, 2, null);
        if (a != null) {
            List<String> b = v.b((CharSequence) a, new String[]{","}, false, 0, 6, null);
            if (b != null) {
                return b;
            }
        }
        return m.emptyList();
    }

    public final void ag(List<String> list) {
        h.e(list, FirebaseAnalytics.b.VALUE);
        aOy.put("recovery_config_addresses", u.a(list, ",", null, null, 0, null, null, 62, null));
    }
}
