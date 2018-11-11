package com.iqoption.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.base.Predicates;
import com.google.common.collect.i;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.ae;
import com.iqoption.core.microservices.busapi.response.ForgetUserStatus;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.protrader.h;
import com.iqoption.system.a.b;
import com.iqoption.util.l;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: IQAccount */
public class a extends com.iqoption.app.a.a {
    private static final String TAG = "com.iqoption.app.a";
    private static volatile a ajS;
    private String address;
    private b<Boolean> ajT = new b(b.ajD, Boolean.valueOf(false));
    private b<String> ajU = new b(c.ajD, "");
    private String ajV;
    private String ajW;
    private String ajX;
    private int ajY;
    private String ajZ;
    public boolean akA;
    public boolean akB;
    public boolean akC;
    public boolean akD;
    public boolean akE;
    public boolean akF;
    public boolean akG;
    private b<Boolean> akH = new b(g.ajD, Boolean.valueOf(false));
    public boolean akI;
    public b<Boolean> akJ = new b(h.ajD, Boolean.valueOf(false));
    private String aka;
    private boolean akb;
    private b<Boolean> akc = new b(i.ajD, Boolean.valueOf(false));
    private String akd = "";
    private b<com.iqoption.core.microservices.avatar.a> ake = new b(j.ajD, null);
    private ConcurrentHashMap<Long, Balance> akf = new ConcurrentHashMap();
    private final ConcurrentHashMap<String, ConversionCurrency> akg = new ConcurrentHashMap();
    private b<Integer> akh = new b(k.ajD, Integer.valueOf(0));
    private long aki;
    private String akj;
    private b<String> akk = new b(l.ajD, "");
    private String akl;
    private String akm;
    private Long akn;
    private boolean ako;
    private int akp = 0;
    private b<Boolean> akq = new b(m.ajD, Boolean.valueOf(false));
    private b<Boolean> akr = new b(n.ajD, Boolean.valueOf(false));
    private b<com.iqoption.core.microservices.busapi.response.b> aks = new b(o.ajD, new com.iqoption.core.microservices.busapi.response.b());
    private b<com.iqoption.protrader.a> akt = new b(p.ajD, new h(null));
    private b<com.iqoption.core.microservices.busapi.response.a> aku = new b(d.ajD, null);
    public b<Integer> akv = new b(e.ajD, Integer.valueOf(0));
    public boolean akw;
    public b<Integer> akx = new b(f.ajD, Integer.valueOf(-1));
    private boolean aky;
    public boolean akz;
    private Long balanceId = null;
    private String city;
    private String firstName;
    private String flag;
    private String gender;
    public int kycStatus;
    private String lastName;
    private String locale;
    private String password;

    public static synchronized void initialize(Context context) {
        synchronized (a.class) {
            synchronized (a.class) {
                ajS = new a(context);
            }
        }
    }

    public static synchronized a aL(Context context) {
        a aVar;
        synchronized (a.class) {
            if (ajS == null) {
                synchronized (a.class) {
                    if (ajS == null) {
                        ajS = new a(context);
                    }
                }
            }
            aVar = ajS;
        }
        return aVar;
    }

    public static a Cw() {
        return aL(IQApp.Dk());
    }

    public Long getBalanceId() {
        return this.balanceId;
    }

    public Long X(long j) {
        Long l = null;
        if (j < 0) {
            return null;
        }
        if (!Objects.equals(this.balanceId, Long.valueOf(j))) {
            l = this.balanceId;
        }
        this.balanceId = Long.valueOf(j);
        return l;
    }

    public Double Cx() {
        return Double.valueOf(Balance.getBalanceValue(CC()));
    }

    public int Cy() {
        return Balance.getBalanceType(CC());
    }

    public String getBalanceText() {
        return l.q(Cx());
    }

    public void a(ConcurrentHashMap<Long, Balance> concurrentHashMap) {
        this.akf = concurrentHashMap;
    }

    public ConcurrentHashMap<Long, Balance> Cz() {
        return this.akf;
    }

    @Nullable
    public Balance cG(int i) {
        return this.akf != null ? (Balance) i.c(this.akf.values()).e(Predicates.a(Predicates.G(Integer.valueOf(i)), Balance.getBalanceType)).pq() : null;
    }

    @Nullable
    public Balance CA() {
        return this.akf != null ? (Balance) i.c(this.akf.values()).e(Balance.getOtnBalance).pq() : null;
    }

    public double CB() {
        return Balance.getBalanceValue(cG(1));
    }

    @Nullable
    public Balance d(Long l) {
        return l == null ? null : (Balance) this.akf.get(l);
    }

    @Nullable
    public Balance CC() {
        return this.balanceId == null ? null : (Balance) this.akf.get(this.balanceId);
    }

    @Nullable
    private String e(Long l) {
        return Balance.getCurrency(d(l));
    }

    public String f(Long l) {
        return eg(e(l));
    }

    public String CD() {
        return f(getBalanceId());
    }

    public String eg(String str) {
        return l.d(eh(str));
    }

    public boolean CE() {
        return this.akg.isEmpty();
    }

    public void z(List<ConversionCurrency> list) {
        if (!com.iqoption.util.i.H(list)) {
            for (ConversionCurrency conversionCurrency : list) {
                this.akg.put(conversionCurrency.name, conversionCurrency);
            }
        }
    }

    public void b(ConversionCurrency conversionCurrency) {
        if (conversionCurrency != null) {
            this.akg.put(conversionCurrency.name, conversionCurrency);
        }
    }

    @Nullable
    public ConversionCurrency eh(String str) {
        Object str2;
        ConcurrentHashMap concurrentHashMap = this.akg;
        if (str2 == null) {
            str2 = "";
        }
        return (ConversionCurrency) concurrentHashMap.get(str2);
    }

    @Nullable
    public ConversionCurrency CF() {
        return eh(e(this.balanceId));
    }

    private a(Context context) {
        super(context);
        init(context);
    }

    public void aM(Context context) {
        clear();
        aN(context);
    }

    public boolean isVerified() {
        if (this.aky) {
            return ((Boolean) this.akJ.getValue()).booleanValue();
        }
        return ((Boolean) this.akH.getValue()).booleanValue();
    }

    protected void clear() {
        super.clear();
        this.ajU.aEs();
        this.akk.aEs();
        this.ajX = "";
        this.ajW = "";
        this.akq.aEs();
        this.password = "";
        this.ajY = 0;
        this.ajZ = "";
        this.aka = "";
        this.akc.aEs();
        this.akb = false;
        this.firstName = "";
        this.lastName = "";
        this.akd = "";
        this.ake.bG(null);
        this.ajT.bG(Boolean.valueOf(false));
    }

    public synchronized void aN(Context context) {
        super.aN(context);
        Editor edit = af.aR(context).DY().edit();
        edit.putString("email", (String) this.ajU.getValue()).putString("password", this.password).putString("auth_code", this.ajV).putString("autologin_token", this.ajW).putString("tin", this.akd).putInt("social_id", this.ajY).putString("user_social_id", this.ajZ).putString("social_token", this.aka).putBoolean("is_trial", ((Boolean) this.akc.getValue()).booleanValue()).putString("first_name", this.firstName).putString("last_name", this.lastName).putBoolean("is_activated", ((Boolean) this.akq.getValue()).booleanValue()).putBoolean("auth_two_factor", ((Boolean) this.akr.getValue()).booleanValue()).putString("new_email", this.ajX).putBoolean("is_account_init_from_server", ((Boolean) this.ajT.getValue()).booleanValue());
        com.iqoption.core.microservices.busapi.response.b bVar = (com.iqoption.core.microservices.busapi.response.b) this.aks.getValue();
        a(edit, "gdpr_accepted", bVar.Vu());
        a(edit, "gdpr_email_accepted", bVar.Vv());
        a(edit, "gdpr_push_accepted", bVar.Vw());
        a(edit, "gdpr_call_accepted", bVar.Vx());
        a(edit, "gdpr_third_party_accepted", bVar.Vy());
        com.iqoption.core.ext.a.a(edit, "client_category_id", CT().ays());
        com.iqoption.core.microservices.busapi.response.a CV = CV();
        if (CV != null) {
            edit.putString("forget_user_status", CV.Vr().getServerValue()).putLong("forget_user_created", CV.Vs()).putLong("forget_user_expired", CV.Vt());
        } else {
            edit.remove("forget_user_status").remove("forget_user_created").remove("forget_user_expired");
        }
        edit.apply();
    }

    private void init(Context context) {
        SharedPreferences DY = af.aR(context).DY();
        this.ajU.bH(DY.getString("email", ""));
        this.akd = DY.getString("tin", "");
        this.password = DY.getString("password", "");
        this.ajV = DY.getString("auth_code", "");
        this.ajW = DY.getString("autologin_token", "");
        this.ajY = DY.getInt("social_id", 0);
        this.ajZ = DY.getString("user_social_id", "");
        this.aka = DY.getString("social_token", "");
        this.akc.bH(Boolean.valueOf(DY.getBoolean("is_trial", false)));
        this.akb = DY.getBoolean("is_demo", false);
        this.firstName = DY.getString("first_name", "");
        this.lastName = DY.getString("last_name", "");
        this.ajX = DY.getString("new_email", "");
        this.akq.bH(Boolean.valueOf(DY.getBoolean("is_activated", false)));
        this.akr.bH(Boolean.valueOf(DY.getBoolean("auth_two_factor", false)));
        this.ajT.bG(Boolean.valueOf(DY.getBoolean("is_account_init_from_server", false)));
        this.aks.bH(new com.iqoption.core.microservices.busapi.response.b(a(DY, "gdpr_accepted"), a(DY, "gdpr_email_accepted"), a(DY, "gdpr_push_accepted"), a(DY, "gdpr_call_accepted"), a(DY, "gdpr_third_party_accepted")));
        this.akt.bH(com.iqoption.protrader.a.j(com.iqoption.core.ext.a.b(DY, "client_category_id")));
        String string = DY.getString("forget_user_status", null);
        Long c = com.iqoption.core.ext.a.c(DY, "forget_user_created");
        Long c2 = com.iqoption.core.ext.a.c(DY, "forget_user_expired");
        if (!(string == null || c == null || c2 == null)) {
            this.aku.bH(new com.iqoption.core.microservices.busapi.response.a(ForgetUserStatus.fromServerValue(string), c.longValue(), c2.longValue()));
        }
        if (!TextUtils.isEmpty(FC()) && !CW() && TextUtils.isEmpty(CI())) {
            RequestManager.atO().ir(FC());
            FD();
            aS(context);
        }
    }

    public boolean isAuthorized() {
        return CG() || CH() || CZ();
    }

    public boolean CG() {
        return (CW() || TextUtils.isEmpty(CI())) ? false : true;
    }

    public boolean CH() {
        return CW() && !TextUtils.isEmpty(getEmail());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String CI() {
        return this.ajZ;
    }

    public void ei(String str) {
        this.ajZ = str;
    }

    public int CJ() {
        return this.ajY;
    }

    public void cH(int i) {
        this.ajY = i;
    }

    public void ej(String str) {
        this.aka = str;
    }

    public String CK() {
        return this.gender;
    }

    public void ek(String str) {
        this.gender = str;
    }

    public String getCountryCode() {
        return this.akj;
    }

    public void setCountryCode(String str) {
        this.akj = str;
    }

    public void a(com.iqoption.core.microservices.avatar.a aVar) {
        this.ake.bG(aVar);
    }

    public com.iqoption.core.microservices.avatar.a getAvatar() {
        return (com.iqoption.core.microservices.avatar.a) this.ake.getValue();
    }

    public Long CL() {
        return this.akn;
    }

    public void g(Long l) {
        this.akn = l;
    }

    public String getPhone() {
        return (String) this.akk.getValue();
    }

    public void setPhone(String str) {
        if (((Boolean) this.ajT.getValue()).booleanValue()) {
            this.akk.bG(str);
        } else {
            this.akk.bH(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0060 A:{Splitter: B:0:0x0000, ExcHandler: com.google.i18n.phonenumbers.NumberParseException (unused com.google.i18n.phonenumbers.NumberParseException)} */
    /* JADX WARNING: Missing block: B:12:0x0065, code:
            return new com.google.i18n.phonenumbers.Phonenumber.PhoneNumber();
     */
    public com.google.i18n.phonenumbers.Phonenumber.PhoneNumber CM() {
        /*
        r4 = this;
        r0 = r4.akk;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = r0.getValue();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = (java.lang.CharSequence) r0;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r0 = new com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0.<init>();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        return r0;
    L_0x0014:
        r0 = r4.akj;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        if (r0 == 0) goto L_0x0035;
    L_0x001c:
        r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.xo();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r1 = r4.akk;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r1 = r1.getValue();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r2 = java.util.Locale.getDefault();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r2 = r2.getCountry();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = r0.b(r1, r2);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        return r0;
    L_0x0035:
        r0 = r4.akj;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = r0.trim();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = r0.intValue();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.xo();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r2 = r4.akk;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r2 = r2.getValue();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r2 = (java.lang.CharSequence) r2;	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r3 = com.google.i18n.phonenumbers.PhoneNumberUtil.xo();	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r3 = r3.bG(r0);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r1 = r1.b(r2, r3);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        r0 = r1.bK(r0);	 Catch:{ NumberParseException -> 0x0060, NumberParseException -> 0x0060 }
        return r0;
    L_0x0060:
        r0 = new com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
        r0.<init>();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.a.CM():com.google.i18n.phonenumbers.Phonenumber$PhoneNumber");
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String CN() {
        return this.akl;
    }

    public void el(String str) {
        this.akl = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    @NonNull
    public String getEmail() {
        return (String) this.ajU.getValue();
    }

    public String CO() {
        return this.akd;
    }

    public void em(String str) {
        this.akd = str;
    }

    public void en(String str) {
        if (((Boolean) this.ajT.getValue()).booleanValue()) {
            this.ajU.bG(str);
        } else {
            this.ajU.bH(str);
        }
    }

    public String CP() {
        return this.ajX;
    }

    public void eo(String str) {
        this.ajX = str;
    }

    public String CQ() {
        if (isActivated()) {
            return getEmail();
        }
        return TextUtils.isEmpty(CP()) ? getEmail() : CP();
    }

    public boolean isActivated() {
        return ((Boolean) this.akq.getValue()).booleanValue();
    }

    public void setActivated(boolean z) {
        if (!((Boolean) this.ajT.getValue()).booleanValue()) {
            this.akq.bH(Boolean.valueOf(z));
        } else if (this.akq.bG(Boolean.valueOf(z)) && z) {
            ae.d(IQApp.Dk(), 134217728);
            EventManager.Bm().a(new Event(Event.CATEGORY_SYSTEM, "security_email-confirmed"));
        }
    }

    public boolean CR() {
        return ((Boolean) this.akr.getValue()).booleanValue();
    }

    public void aG(boolean z) {
        if (!((Boolean) this.ajT.getValue()).booleanValue()) {
            this.akr.bH(Boolean.valueOf(z));
        } else if (this.akr.bG(Boolean.valueOf(z)) && z) {
            ae.d(IQApp.Dk(), Integer.MIN_VALUE);
        }
    }

    @NonNull
    public com.iqoption.core.microservices.busapi.response.b CS() {
        return (com.iqoption.core.microservices.busapi.response.b) this.aks.getValue();
    }

    public void a(@Nullable com.iqoption.core.microservices.busapi.response.b bVar) {
        this.aks.bH(bVar);
    }

    @NonNull
    public com.iqoption.protrader.a CT() {
        return (com.iqoption.protrader.a) this.akt.getValue();
    }

    public void a(@Nullable com.iqoption.protrader.a aVar) {
        this.akt.bH(aVar);
    }

    public boolean CU() {
        return CT() instanceof com.iqoption.protrader.b;
    }

    @Nullable
    public com.iqoption.core.microservices.busapi.response.a CV() {
        return (com.iqoption.core.microservices.busapi.response.a) this.aku.getValue();
    }

    public void c(@Nullable com.iqoption.core.microservices.busapi.response.a aVar) {
        this.aku.bG(aVar);
    }

    public boolean CW() {
        return TextUtils.isEmpty(this.password) ^ 1;
    }

    public void setPassword(String str) {
        if (TextUtils.isEmpty(str)) {
            this.password = str;
        } else {
            this.password = "-ZJh(!@3dGfQ9W86";
        }
    }

    public void ep(String str) {
        this.ajV = str;
    }

    public void eq(String str) {
        this.ajW = str;
    }

    public String CX() {
        return this.ajW;
    }

    public void CY() {
        eq("");
        aN(IQApp.Dk());
    }

    public boolean CZ() {
        return ((Boolean) this.akc.getValue()).booleanValue();
    }

    public boolean Da() {
        return this.akb;
    }

    public void aO(Context context) {
        this.akb = false;
        af.aR(context).DY().edit().putBoolean("is_demo", false).apply();
    }

    public boolean aH(boolean z) {
        return this.akc.bG(Boolean.valueOf(z));
    }

    public int getGroupId() {
        return ((Integer) this.akh.getValue()).intValue();
    }

    public void cI(int i) {
        this.akh.bG(Integer.valueOf(i));
    }

    public String getLocale() {
        return this.locale;
    }

    public void er(String str) {
        this.locale = str;
    }

    public long Db() {
        return this.aki;
    }

    public void Y(long j) {
        this.aki = j;
    }

    public String Dc() {
        return this.akm;
    }

    public void es(String str) {
        this.akm = str;
    }

    public boolean Dd() {
        return this.ako;
    }

    public void aI(boolean z) {
        this.ako = z;
    }

    public boolean De() {
        return ((Boolean) this.akH.getValue()).booleanValue();
    }

    public void aJ(boolean z) {
        if (!((Boolean) this.ajT.getValue()).booleanValue()) {
            this.akH.bH(Boolean.valueOf(z));
        } else if (this.akH.bG(Boolean.valueOf(z)) && z) {
            ae.d(IQApp.Dk(), 268435456);
        }
    }

    public void aK(boolean z) {
        this.ajT.bG(Boolean.valueOf(z));
    }

    public String Df() {
        if (TextUtils.isEmpty(this.lastName)) {
            return this.firstName;
        }
        if (TextUtils.isEmpty(this.firstName)) {
            return this.lastName;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.firstName);
        stringBuilder.append(" ");
        stringBuilder.append(this.lastName);
        return stringBuilder.toString();
    }

    public boolean Dg() {
        return isActivated();
    }

    public void a(KycState kycState) {
        this.akx.bH(kycState.daysLeftToVerify);
        aL(kycState.isRegulatedUser.booleanValue());
        this.akz = kycState.isProfileNeeded.booleanValue();
        this.akA = kycState.isPhoneNeeded.booleanValue();
        this.akB = kycState.isDocumentsNeeded.booleanValue();
        this.akC = kycState.isDocumentsDeclined.booleanValue();
        this.akD = kycState.isProfileFilled.booleanValue();
        this.akE = kycState.isPhoneFilled.booleanValue();
        this.akF = kycState.isDocumentsUploaded.booleanValue();
        this.akG = kycState.isPhoneConfirmationSkipped.booleanValue();
        this.akF = kycState.isDocumentsUploaded.booleanValue();
        this.akG = kycState.isPhoneConfirmationSkipped.booleanValue();
        this.akH.bG(kycState.isPhoneConfirmed);
        this.akI = kycState.isDocumentsUploadSkipped.booleanValue();
        this.akJ.bG(kycState.isDocumentsApproved);
    }

    public void aL(boolean z) {
        this.aky = z;
        if (z) {
            af.DX().cO(alo);
        }
    }

    public boolean Dh() {
        return this.aky;
    }

    public void cJ(int i) {
        this.akp = i;
    }

    public int Di() {
        return this.akp;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void a(@NonNull Editor editor, @NonNull String str, @Nullable Boolean bool) {
        if (bool != null) {
            editor.putBoolean(str, bool.booleanValue()).apply();
        }
    }

    @Nullable
    public Boolean a(@NonNull SharedPreferences sharedPreferences, @NonNull String str) {
        return sharedPreferences.contains(str) ? Boolean.valueOf(sharedPreferences.getBoolean(str, false)) : null;
    }

    public long Dj() {
        return (long) getGroupId();
    }
}
