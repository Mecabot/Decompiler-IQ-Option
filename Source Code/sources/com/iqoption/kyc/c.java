package com.iqoption.kyc;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.common.base.e;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.v;
import com.google.common.util.concurrent.s;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.app.af;
import com.iqoption.core.f;
import com.iqoption.core.i;
import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.util.ag;
import com.iqoption.x.R;
import java.util.Date;
import java.util.Locale;

/* compiled from: KycInfoProvider */
public class c {
    private static final String TAG = "com.iqoption.kyc.c";
    private static final ImmutableSet<Integer> cJk = ImmutableSet.s(Integer.valueOf(50), Integer.valueOf(51));
    private static final ImmutableMultimap<Integer, Integer> cJl = ImmutableMultimap.tf().q(Integer.valueOf(12), Integer.valueOf(49)).q(Integer.valueOf(10), Integer.valueOf(37)).q(Integer.valueOf(10), Integer.valueOf(38)).q(Integer.valueOf(13), Integer.valueOf(52)).q(Integer.valueOf(13), Integer.valueOf(53)).sS();
    private static final ImmutableMultimap<Integer, Integer> cJm = ImmutableMultimap.tf().q(Integer.valueOf(21), Integer.valueOf(89)).q(Integer.valueOf(21), Integer.valueOf(90)).q(Integer.valueOf(22), Integer.valueOf(93)).q(Integer.valueOf(22), Integer.valueOf(94)).q(Integer.valueOf(23), Integer.valueOf(97)).q(Integer.valueOf(23), Integer.valueOf(98)).q(Integer.valueOf(24), Integer.valueOf(101)).q(Integer.valueOf(24), Integer.valueOf(102)).q(Integer.valueOf(25), Integer.valueOf(105)).q(Integer.valueOf(25), Integer.valueOf(106)).q(Integer.valueOf(26), Integer.valueOf(108)).q(Integer.valueOf(27), Integer.valueOf(111)).sS();
    @Nullable
    private KycState cJn;
    private final Context context;
    private final com.iqoption.fragment.account.security.sms.a cuL;

    /* compiled from: KycInfoProvider */
    private static class a {
        private final v<Integer, Integer> cJo;
        private final v<Integer, Integer> cJp;

        private a() {
            this.cJo = HashMultimap.b(c.cJl);
            this.cJp = HashMultimap.b(c.cJm);
        }

        public void av(int i, int i2) {
            if (!a(i, i2, this.cJo)) {
                a(i, i2, this.cJp);
            }
        }

        private static boolean a(int i, int i2, v<Integer, Integer> vVar) {
            if (!vVar.R(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
                return false;
            }
            vVar.S(Integer.valueOf(i));
            return true;
        }

        public boolean aoN() {
            return (this.cJo.isEmpty() || this.cJp.isEmpty()) ? false : true;
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, @Nullable KycState kycState) {
        this.context = context;
        this.cuL = new com.iqoption.fragment.account.security.sms.a(context);
        this.cJn = kycState;
    }

    public void b(@Nullable KycState kycState) {
        this.cJn = kycState;
    }

    public boolean De() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.akw) {
            return aL.De();
        }
        return ((Boolean) e.h(this.cJn != null ? this.cJn.isPhoneConfirmed : null, Boolean.valueOf(false))).booleanValue();
    }

    public boolean aoA() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.akw) {
            return aL.akG;
        }
        return ((Boolean) e.h(this.cJn != null ? this.cJn.isPhoneConfirmationSkipped : null, Boolean.valueOf(false))).booleanValue();
    }

    public PhoneNumber aoB() {
        return com.iqoption.app.a.aL(this.context).CM();
    }

    public PhoneNumber aoC() {
        return De() ? com.iqoption.app.a.aL(this.context).CM() : new PhoneNumber();
    }

    public String a(@Nullable Country country) {
        String country2;
        PhoneNumberUtil xo = PhoneNumberUtil.xo();
        if (country == null) {
            country2 = Locale.getDefault().getCountry();
        } else {
            country2 = xo.bG(country.phoneCode.intValue());
        }
        PhoneNumber a = xo.a(country2, PhoneNumberType.MOBILE);
        if (a == null) {
            return this.context.getString(R.string.phone_number);
        }
        return xo.a(a, PhoneNumberFormat.INTERNATIONAL);
    }

    public long aoD() {
        return this.cuL.bl(af.aR(this.context).EK());
    }

    public boolean aoE() {
        return this.cuL.bk(aoD());
    }

    public boolean aoF() {
        return this.cuL.bm(af.aR(this.context).EK());
    }

    public void ac(long j) {
        af.aR(this.context).ac(j);
    }

    public long EK() {
        return af.aR(this.context).EK();
    }

    public String a(@Nullable e eVar) {
        String firstName;
        if (eVar == null || TextUtils.isEmpty(eVar.firstName)) {
            firstName = com.iqoption.app.a.aL(this.context).getFirstName();
        } else {
            firstName = eVar.firstName;
        }
        return this.context.getString(R.string.name).equals(firstName) ? "" : firstName;
    }

    public String b(@Nullable e eVar) {
        String lastName;
        if (eVar == null || TextUtils.isEmpty(eVar.lastName)) {
            lastName = com.iqoption.app.a.aL(this.context).getLastName();
        } else {
            lastName = eVar.lastName;
        }
        return this.context.getString(R.string.surname).equals(lastName) ? "" : lastName;
    }

    public Date c(@Nullable e eVar) {
        if (eVar != null && eVar.cJq != null) {
            return eVar.cJq;
        }
        Long CL = com.iqoption.app.a.aL(this.context).CL();
        if (CL == null || CL.longValue() == 0) {
            return null;
        }
        Date date = new Date(CL.longValue() * 1000);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("birthDate from account: ");
        stringBuilder.append(CL);
        stringBuilder.append(", date:");
        stringBuilder.append(date);
        i.v(str, stringBuilder.toString());
        return date;
    }

    public boolean hW(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 30;
    }

    public long d(@Nullable e eVar) {
        return (eVar == null || eVar.cJs == null) ? com.iqoption.app.a.aL(this.context).Db() : eVar.cJs.longValue();
    }

    public long e(@Nullable e eVar) {
        return (eVar == null || eVar.cJt == null) ? com.iqoption.app.a.aL(this.context).Db() : eVar.cJt.longValue();
    }

    public String f(@Nullable e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.address)) {
            return com.iqoption.app.a.aL(this.context).getAddress();
        }
        return eVar.address;
    }

    public String g(@Nullable e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.city)) {
            return com.iqoption.app.a.aL(this.context).getCity();
        }
        return eVar.city;
    }

    public String h(@Nullable e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.cJu)) {
            return com.iqoption.app.a.aL(this.context).CN();
        }
        return eVar.cJu;
    }

    public s<Pair<String, String>> aoG() {
        return ag.a(Requests.f(this.context, "risk-disclosure", f.getLocale()), d.$instance);
    }

    public static boolean bu(Context context) {
        return af.aR(context).al(com.iqoption.app.a.aL(context).getUserId());
    }

    public boolean eZ(int i) {
        return cJk.contains(Integer.valueOf(i));
    }

    public boolean i(e eVar) {
        a aVar = new a();
        for (Integer num : eVar.cJv.keySet()) {
            for (Integer intValue : eVar.cJv.get(num)) {
                aVar.av(num.intValue(), intValue.intValue());
            }
        }
        return aVar.aoN();
    }

    public long getUserId() {
        return com.iqoption.app.a.aL(this.context).getUserId();
    }

    public String aoH() {
        String locale = com.iqoption.app.a.aL(this.context).getLocale();
        locale = (TextUtils.isEmpty(locale) || locale.length() < 2) ? Locale.getDefault().getLanguage() : locale.substring(0, 2);
        return locale.toLowerCase();
    }

    public boolean Dh() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.akw) {
            return aL.Dh();
        }
        return ((Boolean) e.h(this.cJn != null ? this.cJn.isRegulatedUser : null, Boolean.valueOf(false))).booleanValue();
    }

    public boolean aoI() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.akw) {
            return aL.akF;
        }
        return ((Boolean) e.h(this.cJn != null ? this.cJn.isDocumentsUploaded : null, Boolean.valueOf(false))).booleanValue();
    }

    public boolean aoJ() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.akw) {
            return aL.akD;
        }
        return ((Boolean) e.h(this.cJn != null ? this.cJn.isProfileFilled : null, Boolean.valueOf(false))).booleanValue();
    }

    public int aoK() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.akw) {
            return ((Integer) aL.akx.getValue()).intValue();
        }
        return ((Integer) e.h(this.cJn != null ? this.cJn.daysLeftToVerify : null, Integer.valueOf(0))).intValue();
    }
}
