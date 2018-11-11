package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.common.base.e;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.authorization.RegistrationException;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.util.ag;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RegisterRequest */
public class n {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.n";

    /* compiled from: RegisterRequest */
    public interface a {
        void a(RegistrationException registrationException);

        void onSuccess();
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, Integer num, @Nullable Long l, a aVar) {
        a(false, false, z, str, str2, str3, str4, null, null, null, num, l, aVar);
    }

    public static void a(String str, String str2, String str3, String str4, int i, String str5, a aVar) {
        a(true, true, false, str, str2, null, str3, str4, Integer.valueOf(i), str5, null, null, aVar);
    }

    public static void b(String str, String str2, String str3, String str4, int i, String str5, a aVar) {
        a(true, false, false, str, str2, null, str3, str4, Integer.valueOf(i), str5, null, null, aVar);
    }

    private static void a(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5, Integer num, String str6, Integer num2, @Nullable Long l, a aVar) {
        Integer num3;
        String str7;
        String str8;
        String str9;
        Integer num4 = num2;
        HashMap hashMap = new HashMap();
        String str10 = str;
        hashMap.put("first_name", e.h(str10, ""));
        String str11 = str2;
        hashMap.put("last_name", e.h(str11, ""));
        String str12 = str4;
        hashMap.put("email", str12);
        hashMap.put("tz", TimeZone.getDefault().getID());
        if (z) {
            num3 = num;
            hashMap.put("social_id", e.h(num3, ""));
            str7 = str5;
            hashMap.put("user_social_id", e.h(str7, ""));
            str8 = str6;
            hashMap.put("token", e.h(str8, ""));
            str9 = str3;
        } else {
            str7 = str5;
            num3 = num;
            str8 = str6;
            str9 = str3;
            hashMap.put("password", str9);
        }
        if (!z2) {
            hashMap.put("is_demo", Integer.valueOf(0));
            if (num4 != null) {
                hashMap.put("currency_id", num4);
            }
        }
        a(z, z2, z3, str10, str11, str9, str12, l, str7, num3, str8, aVar, hashMap);
    }

    private static void a(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4, @Nullable Long l, String str5, Integer num, String str6, a aVar, HashMap<String, Object> hashMap) {
        String str7;
        String str8;
        String str9;
        HashMap hashMap2;
        Long l2 = l;
        final Builder Builder = Event.Builder(Event.CATEGORY_SYSTEM, "registration_request");
        boolean CZ = com.iqoption.app.a.aL(IQApp.Dk()).CZ();
        if (z2 || !CZ) {
            str7 = str3;
            str8 = str4;
            str9 = z2 ? "api/register/check" : z3 ? "api/register/gdpr" : "api/register";
            hashMap2 = hashMap;
        } else {
            i.i(TAG, "end trial");
            hashMap2 = new HashMap();
            str8 = str4;
            hashMap2.put("email", str8);
            str7 = str3;
            hashMap2.put("password", str7);
            str9 = z3 ? "api/do-end-trial/gdpr" : "api/do-end-trial";
        }
        String str10 = str9;
        if (z3) {
            hashMap2.put("is_gdpr_accepted", Integer.valueOf(1));
        }
        if (l2 != null) {
            hashMap2.put("country_id", l2);
        }
        String in = IQApp.Dl().in("api/do-end-trial/gdpr");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(in);
        stringBuilder.append(str10);
        Request b = RequestManager.b(stringBuilder.toString(), hashMap2, IQApp.Dk());
        final boolean z4 = z2;
        final String str11 = str8;
        final Integer num2 = num;
        final boolean z5 = z;
        str8 = str5;
        final String str12 = str6;
        final a aVar2 = aVar;
        final String str13 = str;
        final String str14 = str2;
        com.iqoption.mobbtech.connect.request.a.a.a.a(b, new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                af DX = af.DX();
                com.iqoption.app.a.aL(IQApp.Dk()).FE();
                if (!z4) {
                    DX.eA(str11);
                    DX.Et();
                    DX.h(Boolean.valueOf(true));
                    DX.cN(0);
                    DX.ah(System.currentTimeMillis());
                    n.a(IQApp.Dk(), num2, z5, false);
                    EventManager.Bm().a(Builder.setValue(Double.valueOf(1.0d)).calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                }
                if (!z5) {
                    s a;
                    if (z4) {
                        a = com.iqoption.c.a.Jw().a(str11, str7, null, false, false, 3);
                    } else {
                        com.iqoption.c.a.Jw().h(str11, str7, null);
                        a = com.iqoption.c.a.Jw().i();
                    }
                    ag.a(a, new com.google.common.util.concurrent.n<Boolean>() {
                        /* renamed from: f */
                        public void onSuccess(Boolean bool) {
                            aVar2.onSuccess();
                        }

                        public void l(Throwable th) {
                            aVar2.a(null);
                        }
                    });
                } else if (z4) {
                    try {
                        switch (hVar.auV().getJSONObject("result").getInt(NotificationCompat.CATEGORY_STATUS)) {
                            case 0:
                                b.b(IQApp.Dk().getString(R.string.user_is_not_registered), IQApp.Dk());
                                a(null);
                                return;
                            case 1:
                                b.b(IQApp.Dk().getString(R.string.user_not_activated), IQApp.Dk());
                                a(null);
                                return;
                            case 2:
                                n.a(IQApp.Dk(), num2);
                                DX.aW(true);
                                com.iqoption.app.a aL = com.iqoption.app.a.aL(IQApp.Dk());
                                aL.cH(num2.intValue());
                                aL.ei(str8);
                                aL.ej(str12);
                                aL.aN(IQApp.Dk());
                                if (aVar2 != null) {
                                    aVar2.onSuccess();
                                }
                                return;
                            case 3:
                                b.b(IQApp.Dk().getString(R.string.user_registered_but_not_authorized), IQApp.Dk());
                                a(null);
                                return;
                        }
                    } catch (JSONException unused) {
                        b.aT(IQApp.Dk());
                    }
                } else {
                    n.a(str13, str14, str11, str8, num2.intValue(), str12, aVar2);
                }
            }

            public void a(g gVar) {
                i.e(n.TAG, gVar == null ? "registration error" : gVar.toString());
                EventManager.Bm().a(Builder.setValue(Double.valueOf(0.0d)).calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                RegistrationException registrationException = new RegistrationException();
                if (gVar != null) {
                    try {
                        JSONObject auS = gVar.auS();
                        if (auS != null) {
                            registrationException.code = auS.optInt("code");
                            Object errorMessage = gVar.getErrorMessage();
                            if (auS.optJSONObject("message") != null) {
                                auS = auS.getJSONObject("message");
                                if (TextUtils.isEmpty(registrationException.text) && auS.optJSONArray("password") != null) {
                                    registrationException.text = auS.optJSONArray("password").getString(0);
                                }
                                if (TextUtils.isEmpty(registrationException.text) && auS.optJSONArray("email") != null) {
                                    registrationException.text = auS.optJSONArray("email").getString(0);
                                }
                                if (TextUtils.isEmpty(registrationException.text) && auS.optJSONArray("first_name") != null) {
                                    registrationException.text = auS.optJSONArray("first_name").getString(0);
                                }
                                if (TextUtils.isEmpty(registrationException.text) && auS.optJSONArray("last_name") != null) {
                                    registrationException.text = auS.optJSONArray("last_name").getString(0);
                                }
                            }
                            if (TextUtils.isEmpty(registrationException.text) && !TextUtils.isEmpty(errorMessage)) {
                                registrationException.text = errorMessage;
                            }
                        }
                    } catch (JSONException unused) {
                        if (TextUtils.isEmpty(registrationException.text)) {
                            registrationException.text = gVar.getErrorMessage();
                        }
                    }
                    if (registrationException.code != RegistrationException.cPo) {
                        if (TextUtils.isEmpty(registrationException.text)) {
                            b.aT(IQApp.Dk());
                        } else {
                            b.b(registrationException.text, IQApp.Dk());
                        }
                    }
                }
                CharSequence charSequence = registrationException.text;
                Map hashMap = new HashMap();
                String str = "error";
                int code = (gVar == null || gVar.getCode() < 0) ? TextUtils.isEmpty(charSequence) ? -100 : -1 : gVar.getCode();
                hashMap.put(str, Integer.valueOf(code));
                com.appsflyer.h.fA().a(IQApp.Dk().getApplicationContext(), "registration_failed", hashMap);
                if (aVar2 != null) {
                    aVar2.a(registrationException);
                }
            }
        }, str10);
    }

    public static void a(Context context, Integer num, boolean z, boolean z2) {
        if (z2) {
            try {
                af.aR(context).Ek();
                AppEventsLogger.T(context).bq("trial");
                Tracker aP = IQApp.aP(context);
                aP.send(((EventBuilder) new EventBuilder().setCategory("Android").setAction("Registration_Trial").setLabel("Registration_Trial").setCustomDimension(2, aP.get("&cid"))).build());
            } catch (Exception unused) {
                return;
            }
        }
        Bundle bundle = new Bundle();
        String str = "EMAIL";
        String str2 = "Form";
        if (z) {
            switch (num.intValue()) {
                case 4:
                    str = "FACEBOOK";
                    str2 = "Facebook";
                    break;
                case 5:
                    str = "GOOGLE";
                    str2 = "Google";
                    break;
            }
        }
        Tracker aP2 = IQApp.aP(context);
        aP2.send(((EventBuilder) new EventBuilder().setCategory("Android").setAction("Registration_Real").setLabel(str2).setCustomDimension(2, aP2.get("&cid"))).build());
        EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_Real_Registration"));
        bundle.putString("fb_registration_method", str);
        AppEventsLogger.T(context).logEvent("fb_mobile_complete_registration", bundle);
        if (!af.aR(context).El()) {
            aP2 = IQApp.aP(context);
            aP2.send(((EventBuilder) new EventBuilder().setCategory("Android").setAction("Welcomescreen_Registration").setLabel(str2).setCustomDimension(2, aP2.get("&cid"))).build());
            bundle.putString("fb_registration_method", str);
            AppEventsLogger.T(context).logEvent("fb_mobile_complete_registration", bundle);
        }
        IQApp.a(z2 ? "trial" : "registration", null);
    }

    public static void a(Context context, Integer num) {
        String str;
        switch (num.intValue()) {
            case 4:
                str = "Facebook";
                break;
            case 5:
                str = "Google";
                break;
            default:
                str = null;
                break;
        }
        Tracker aP = IQApp.aP(context);
        aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) com.iqoption.app.a.aL(context).getUserId())).setCategory("Android").setAction("Login").setLabel(str).setCustomDimension(2, aP.get("&cid"))).build());
    }
}
