package com.iqoption.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.collect.Sets;
import com.google.common.collect.s;
import com.google.gson.reflect.TypeToken;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.b.d.b;
import com.iqoption.app.b.d.c;
import com.iqoption.app.managers.ae;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.configuration.Configuration;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.util.ah;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: Preferences */
public class af extends ae {
    private static final String TAG = "com.iqoption.app.af";
    private static volatile af alp;
    private volatile SharedPreferences alq;
    private volatile SharedPreferences alr;

    public static synchronized af aR(Context context) {
        af afVar;
        synchronized (af.class) {
            if (alp == null) {
                synchronized (af.class) {
                    if (alp == null) {
                        alp = new af(context);
                    }
                }
            }
            afVar = alp;
        }
        return afVar;
    }

    public static af DX() {
        return aR(IQApp.Dk());
    }

    private af(Context context) {
        this.alq = context.getApplicationContext().getSharedPreferences("IQOptions", 0);
        this.alr = context.getApplicationContext().getSharedPreferences("app_pref_name", 0);
    }

    public final SharedPreferences DY() {
        return this.alq;
    }

    @NonNull
    public final SharedPreferences Z(long j) {
        IQApp Dk = IQApp.Dk();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IQOptions-user-");
        stringBuilder.append(j);
        return Dk.getSharedPreferences(stringBuilder.toString(), 0);
    }

    @SuppressLint({"ApplySharedPref"})
    public void et(String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "logout").setParameters(i.ZZ().l("reason", str).aab()).build());
        this.alr.edit().remove("dfa405f2049312ca").putLong("75ce4279b0ae", 0).putLong("time_request_two_step_auth_confirm", 0).putLong("time_request_phone_confirm", 0).putLong("time_request_two_step_auth_login", 0).putString("two_step_auth_user", "").putString("two_step_auth_password", "").putString("two_step_auth_phone_mask", "").putInt("security_tab", -1).putLong("time_install", 0).putBoolean("is_auto_subscribe_pricemovements_firebase_push_done", false).putBoolean("is_price_movements_attention_shown_and_confirmed", false).putString("3bab737a076b", null).putLong("a63e971afa3e", 0).putStringSet("price_movements_push_ids", Collections.emptySet()).putString("verify_card_statuses", null).putBoolean("features_from_socket", false).commit();
        this.alq.edit().remove("gdpr_accepted").remove("gdpr_email_accepted").remove("gdpr_push_accepted").remove("gdpr_call_accepted").remove("gdpr_third_party_accepted").remove("client_category_id").remove("forget_user_status").remove("forget_user_created").remove("forget_user_expired").commit();
    }

    public double DZ() {
        int i = this.alq.getInt("last_bet", 0);
        double d = (double) i;
        return i >= 100 ? d / 100.0d : d;
    }

    public void k(double d) {
        this.alq.edit().putString("last_amount", Double.toString(d)).apply();
    }

    public double Ea() {
        try {
            return Double.parseDouble(this.alq.getString("last_amount", ""));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public void l(double d) {
        if (d > 0.0d) {
            try {
                Object Eb = Eb();
                Iterator it = Eb.iterator();
                while (it.hasNext()) {
                    if (((Double) it.next()).equals(Double.valueOf(d))) {
                        return;
                    }
                }
                Eb.addFirst(Double.valueOf(d));
                if (Eb.size() > 10) {
                    Eb.removeLast();
                }
                this.alq.edit().putString("last_amounts", ah.aGh().toJson(Eb)).apply();
            } catch (Exception unused) {
            }
        }
    }

    public LinkedList<Double> Eb() {
        LinkedList<Double> linkedList = new LinkedList();
        try {
            LinkedList linkedList2 = (LinkedList) ah.aGh().fromJson(this.alq.getString("last_amounts", ""), new TypeToken<LinkedList<Double>>() {
            }.getType());
            if (linkedList2 != null) {
                linkedList.addAll(linkedList2);
            }
        } catch (Exception unused) {
            if (linkedList.size() == 0) {
                linkedList.add(Double.valueOf(Ea()));
            }
            return linkedList;
        }
    }

    public void cK(int i) {
        this.alq.edit().putInt("active_id", i).apply();
    }

    public int getActiveId() {
        return this.alq.getInt("active_id", 1);
    }

    public void b(InstrumentType instrumentType) {
        this.alq.edit().putString("option_type", instrumentType.getServerValue()).apply();
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        Object string = this.alq.getString("option_type", "");
        return !TextUtils.isEmpty(string) ? InstrumentType.fromServerValue(string) : null;
    }

    public String Ec() {
        return this.alq.getString("retarget_promo", "");
    }

    public void eu(String str) {
        this.alq.edit().putString("retarget_promo", str).apply();
    }

    public String Ed() {
        return this.alq.getString("retarget_message", "");
    }

    public void ev(String str) {
        this.alq.edit().putString("retarget_message", str).apply();
    }

    public void cL(int i) {
        this.alq.edit().putInt("loyal", i).apply();
    }

    public int Ee() {
        return this.alq.getInt("loyal", 0);
    }

    public boolean Ef() {
        return this.alq.getBoolean("first_training_bet_sent", false);
    }

    public void aM(boolean z) {
        this.alq.edit().putBoolean("first_training_bet_sent", z).apply();
    }

    public boolean Eg() {
        return this.alq.getBoolean("first_demo_bet_sent", false);
    }

    public void aN(boolean z) {
        this.alq.edit().putBoolean("first_demo_bet_sent", z).apply();
    }

    public boolean Eh() {
        return this.alq.getBoolean("first_real_bet_sent", false);
    }

    public void aO(boolean z) {
        this.alq.edit().putBoolean("first_real_bet_sent", z).apply();
    }

    public int Ei() {
        return this.alq.getInt("bet_count", 0);
    }

    public void cM(int i) {
        this.alq.edit().putInt("bet_count", i).apply();
    }

    public void aP(boolean z) {
        this.alq.edit().putBoolean("foreground_app_state", z).apply();
    }

    public boolean Ej() {
        return this.alq.getBoolean("foreground_app_state", false);
    }

    public void Ek() {
        this.alq.edit().putBoolean("trial_was_registration", true).apply();
    }

    public boolean El() {
        return this.alq.getBoolean("trial_was_registration", false);
    }

    public boolean Em() {
        return this.alq.getBoolean("one_click_buying", true);
    }

    public void aQ(boolean z) {
        this.alq.edit().putBoolean("one_click_buying", z).apply();
    }

    public static boolean a(af afVar) {
        if (afVar.Dh()) {
            return false;
        }
        return afVar.Es().booleanValue();
    }

    public boolean En() {
        return this.alq.getBoolean("margin_add_on", a(this));
    }

    public void aR(boolean z) {
        this.alq.edit().putBoolean("margin_add_on", z).apply();
    }

    public boolean Eo() {
        return this.alq.getBoolean("trailig_stop_setting", false);
    }

    public void aS(boolean z) {
        this.alq.edit().putBoolean("trailig_stop_setting", z).apply();
    }

    public boolean Ep() {
        return this.alq.getBoolean("hi_low_chart", true);
    }

    public void aT(boolean z) {
        this.alq.edit().putBoolean("hi_low_chart", z).apply();
    }

    public void aa(long j) {
        this.alq.edit().putLong("download_update_id", j).apply();
    }

    public long Eq() {
        return this.alq.getLong("download_update_id", -1);
    }

    public int Er() {
        return this.alq.getInt("countExpiratesFinished", 0);
    }

    public void cN(int i) {
        this.alq.edit().putInt("countExpiratesFinished", i).apply();
    }

    public Boolean Es() {
        return Boolean.valueOf(this.alq.getBoolean("isRegistrationLaunch", false));
    }

    public void Et() {
        if (!this.alq.contains("isRegistrationLaunch")) {
            this.alq.edit().putBoolean("isRegistrationLaunch", true).apply();
        }
    }

    public String getVersion() {
        return this.alq.getString("version", "");
    }

    public void setVersion(String str) {
        this.alq.edit().putString("version", str).apply();
    }

    public int Eu() {
        return this.alq.getInt("app_lounch_count", 0);
    }

    public boolean Ev() {
        return !Es().booleanValue() || Ex() > 1;
    }

    public void Ew() {
        this.alq.edit().putInt("app_lounch_count", Eu() + 1).apply();
    }

    public long Ex() {
        return this.alq.getLong("trade_room_launch_count", 0);
    }

    public void Ey() {
        this.alq.edit().putLong("trade_room_launch_count", Ex() + 1).apply();
    }

    public boolean Ez() {
        return this.alq.getBoolean("achieve_5000", false);
    }

    public void aU(boolean z) {
        this.alq.edit().putBoolean("achieve_5000", z).apply();
    }

    public boolean EA() {
        return this.alq.getBoolean("is_send_apps_flyer_device_id", false);
    }

    public void aV(boolean z) {
        this.alq.edit().putBoolean("is_send_apps_flyer_device_id", z).apply();
    }

    public boolean EB() {
        return this.alq.getInt("regulation_state", -1) != -1;
    }

    public boolean Dh() {
        int i = this.alq.getInt("regulation_state", -1);
        return i == alo || i == -1;
    }

    public void cO(int i) {
        this.alq.edit().putInt("regulation_state", i).apply();
    }

    public int ew(String str) {
        return this.alq.getInt(str, 0);
    }

    public void u(String str, int i) {
        this.alq.edit().putInt(str, i).apply();
    }

    public void aW(boolean z) {
        this.alr.edit().putBoolean("trade_now_was_invoked", z).apply();
    }

    public boolean EC() {
        return this.alr.getBoolean("trade_now_was_invoked", false);
    }

    public void aX(boolean z) {
        this.alr.edit().putBoolean("should_play_sound", z).apply();
    }

    public boolean ED() {
        return this.alr.getBoolean("should_play_sound", false);
    }

    public String DN() {
        return this.alr.getString("aff", null);
    }

    public void ex(String str) {
        this.alr.edit().putString("aff", str).apply();
    }

    public String EE() {
        return this.alr.getString("afftrack", null);
    }

    public void ey(String str) {
        this.alr.edit().putString("afftrack", str).apply();
    }

    public String EF() {
        return this.alr.getString("retrack", null);
    }

    public void ez(String str) {
        this.alr.edit().putString("retrack", str).apply();
    }

    public void ab(long j) {
        this.alr.edit().putLong("time_retrack", j).apply();
    }

    public long EG() {
        return this.alr.getLong("time_retrack", 0);
    }

    public String EH() {
        return this.alr.getString("login_email", "");
    }

    public void eA(String str) {
        this.alr.edit().putString("login_email", str).apply();
    }

    public void aY(boolean z) {
        this.alr.edit().putBoolean("is_education_popup_enabled", z).apply();
    }

    public boolean EI() {
        return this.alr.getBoolean("is_education_popup_enabled", true);
    }

    public void eB(String str) {
        this.alr.edit().putString("device_id", str).apply();
    }

    public String getDeviceId() {
        return this.alr.getString("device_id", "");
    }

    public void aZ(boolean z) {
        this.alq.edit().putBoolean("first_launch_after_update_app", z).apply();
    }

    public void ba(boolean z) {
        this.alq.edit().putBoolean("first_launch_after_install", z).apply();
    }

    public void setHost(String str) {
        this.alr.edit().putString("debug_host", str).apply();
    }

    public String getHost() {
        return this.alr.getString("debug_host", "https://iqoption.com/");
    }

    public void eC(String str) {
        this.alr.edit().putString("fcm_token", str).apply();
    }

    public void eD(String str) {
        if (!TextUtils.equals(str, EJ())) {
            this.alr.edit().putString("fcm_token", str).apply();
            IQApp.Dn().aE(new b().setValue(str));
        }
    }

    public String EJ() {
        return this.alr.getString("fcm_token", "");
    }

    public void ac(long j) {
        this.alr.edit().putLong("time_request_phone_confirm", j).apply();
    }

    public long EK() {
        return this.alr.getLong("time_request_phone_confirm", 0);
    }

    public void cP(int i) {
        this.alr.edit().putInt("phone_confirm_code", i).apply();
    }

    public int EL() {
        return this.alr.getInt("phone_confirm_code", 0);
    }

    public void ad(long j) {
        this.alr.edit().putLong("time_request_two_step_auth_confirm", j).apply();
    }

    public long EM() {
        return this.alr.getLong("time_request_two_step_auth_confirm", 0);
    }

    public void cQ(int i) {
        this.alr.edit().putInt("two_step_auth_confirm_code", i).apply();
    }

    public int EN() {
        return this.alr.getInt("two_step_auth_confirm_code", 0);
    }

    public void cR(int i) {
        this.alr.edit().putInt("security_tab", i).apply();
    }

    public int EO() {
        return this.alr.getInt("security_tab", -1);
    }

    public void ae(long j) {
        af(System.currentTimeMillis() + ((long) PasscodeFragment.cvl));
        long EP = EP();
        if (j != EP) {
            this.alr.edit().putLong("dfa405f2049312ca", j).apply();
            IQApp.Dn().aE(new c().setValue(Long.valueOf(j)));
            if (EP == -1) {
                Context Dk = IQApp.Dk();
                ae.d(Dk, 536870912);
                if (com.iqoption.system.b.c.bN(Dk)) {
                    ae.d(Dk, 1073741824);
                }
            }
        }
    }

    public long EP() {
        return this.alr.getLong("dfa405f2049312ca", -1);
    }

    public void af(long j) {
        this.alr.edit().putLong("75ce4279b0ae", j).apply();
    }

    public long EQ() {
        return this.alr.getLong("75ce4279b0ae", 0);
    }

    public void ag(long j) {
        this.alr.edit().putLong("time_request_two_step_auth_login", j).apply();
    }

    public long ER() {
        return this.alr.getLong("time_request_two_step_auth_login", 0);
    }

    public void eE(String str) {
        this.alr.edit().putString("two_step_auth_user", str).apply();
    }

    public String ES() {
        return this.alr.getString("two_step_auth_user", "");
    }

    public void eF(String str) {
        this.alr.edit().putString("two_step_auth_password", str).apply();
    }

    public String ET() {
        return this.alr.getString("two_step_auth_password", "");
    }

    public void eG(String str) {
        this.alr.edit().putString("two_step_auth_phone_mask", str).apply();
    }

    public String EU() {
        return this.alr.getString("two_step_auth_phone_mask", "");
    }

    public boolean EV() {
        return this.alq.getBoolean("first_deposit", false);
    }

    public void bb(boolean z) {
        this.alq.edit().putBoolean("first_deposit", z).apply();
    }

    public long EW() {
        return this.alq.getLong("time_install", 0);
    }

    public void ah(long j) {
        this.alq.edit().putLong("time_install", j).apply();
    }

    public boolean EX() {
        return this.alq.getBoolean("user_is_mql", false);
    }

    public void bc(boolean z) {
        this.alq.edit().putBoolean("user_is_mql", z).apply();
    }

    public void cS(int i) {
        this.alr.edit().putInt("count_use_feature", i).apply();
    }

    public int EY() {
        return this.alr.getInt("count_use_feature", 0);
    }

    public boolean EZ() {
        return this.alq.getBoolean("mode_amount_keyboard", false);
    }

    public void bd(boolean z) {
        this.alq.edit().putBoolean("mode_amount_keyboard", z).apply();
    }

    public boolean Fa() {
        return this.alq.getBoolean("first_launch_keyboard", true);
    }

    public void Fb() {
        this.alq.edit().putBoolean("first_launch_keyboard", false).apply();
    }

    public void eH(String str) {
        this.alr.edit().putString("coefficient_string", str).apply();
    }

    public String Fc() {
        return this.alr.getString("coefficient_string", "2.0");
    }

    public void cT(int i) {
        this.alr.edit().putInt("keyboard_preset_type", i).apply();
    }

    public int Fd() {
        return this.alr.getInt("keyboard_preset_type", 2000);
    }

    public boolean Fe() {
        return this.alq.getBoolean("is_price_movements_attention_shown_and_confirmed", false);
    }

    public void be(boolean z) {
        this.alq.edit().putBoolean("is_price_movements_attention_shown_and_confirmed", z).apply();
    }

    public void f(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer append : set) {
            stringBuilder.append(append);
            stringBuilder.append(",");
        }
        this.alr.edit().putString("favorite_asset_id", stringBuilder.toString()).apply();
    }

    public Set<Integer> Ff() {
        Object string = this.alr.getString("favorite_asset_id", "");
        if (TextUtils.isEmpty(string)) {
            return new TreeSet();
        }
        String[] split = string.split(",");
        Set<Integer> treeSet = new TreeSet();
        for (String parseInt : split) {
            treeSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
        }
        return treeSet;
    }

    @Deprecated
    public void Fg() {
        this.alr.edit().remove("tab_manager").apply();
    }

    @Nullable
    @Deprecated
    public String Fh() {
        return this.alr.getString("tab_manager", null);
    }

    public Set<Long> Fi() {
        return Sets.A(s.a(this.alq.getStringSet("price_movements_push_ids", Collections.emptySet()), ag.$instance));
    }

    public void a(long j, boolean z) {
        Iterable Fi = Fi();
        if (z) {
            Fi.add(Long.valueOf(j));
        } else {
            Fi.remove(Long.valueOf(j));
        }
        this.alq.edit().putStringSet("price_movements_push_ids", Sets.A(s.a(Fi, ah.$instance))).apply();
    }

    public void ai(long j) {
        this.alr.edit().putLong("app_close_time", j).apply();
    }

    public long Fj() {
        return this.alr.getLong("app_close_time", 0);
    }

    public void aj(long j) {
        this.alr.edit().putLong("app_suspend_time", j).apply();
    }

    public boolean eI(String str) {
        SharedPreferences sharedPreferences = this.alq;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showed_whats_new");
        stringBuilder.append(str);
        return sharedPreferences.getBoolean(stringBuilder.toString(), false);
    }

    public void c(boolean z, String str) {
        Editor edit = this.alq.edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showed_whats_new");
        stringBuilder.append(str);
        edit.putBoolean(stringBuilder.toString(), z).apply();
    }

    public boolean Fk() {
        return this.alq.getBoolean("more_opportunities_shown", false);
    }

    public void bf(boolean z) {
        this.alq.edit().putBoolean("more_opportunities_shown", z).apply();
    }

    public boolean Fl() {
        return this.alq.getBoolean("more_opportunities_button_clicked", false);
    }

    public void bg(boolean z) {
        this.alq.edit().putBoolean("more_opportunities_button_clicked", z).apply();
    }

    public boolean Fm() {
        return this.alq.getBoolean("more_opportunities_button_clicked", false);
    }

    public void bh(boolean z) {
        this.alq.edit().putBoolean("more_opportunities_button_clicked", z).apply();
    }

    public boolean Fn() {
        return this.alq.getBoolean("fx_button_clicked", false);
    }

    public void bi(boolean z) {
        this.alq.edit().putBoolean("fx_button_clicked", z).apply();
    }

    @Nullable
    public String Fo() {
        return this.alq.getString("verify_card_statuses", null);
    }

    public void eJ(@Nullable String str) {
        this.alq.edit().putString("verify_card_statuses", str).apply();
    }

    @Nullable
    public StatusType ak(long j) {
        String string = Z(j).getString("pro_trader_application_status", null);
        if (string != null) {
            return StatusType.fromServerValue(string);
        }
        return null;
    }

    public void a(long j, @Nullable StatusType statusType) {
        Z(j).edit().putString("pro_trader_application_status", statusType != null ? statusType.getServerValue() : null).apply();
    }

    public boolean al(long j) {
        SharedPreferences sharedPreferences = this.alq;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("is_us_reportable");
        stringBuilder.append(j);
        return sharedPreferences.getBoolean(stringBuilder.toString(), false);
    }

    public void b(long j, boolean z) {
        Editor edit = this.alq.edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("is_us_reportable");
        stringBuilder.append(j);
        edit.putBoolean(stringBuilder.toString(), z).apply();
    }

    public boolean Fp() {
        return this.alq.getBoolean("top_asset_state", false);
    }

    public void bj(boolean z) {
        this.alq.edit().putBoolean("top_asset_state", z).apply();
    }

    public boolean Fq() {
        return this.alq.getBoolean("sell_with_confirmation_forex", true);
    }

    public void bk(boolean z) {
        this.alq.edit().putBoolean("sell_with_confirmation_forex", z).apply();
    }

    public boolean Fr() {
        return this.alq.getBoolean("sharp_jump_state", true);
    }

    public void bl(boolean z) {
        this.alq.edit().putBoolean("sharp_jump_state", z).apply();
    }

    public boolean Fs() {
        return this.alq.getBoolean("latest_movements_state", true);
    }

    public void bm(boolean z) {
        this.alq.edit().putBoolean("latest_movements_state", z).apply();
    }

    public boolean Ft() {
        return this.alq.getBoolean("expiration_panel_state", true);
    }

    public void bn(boolean z) {
        this.alq.edit().putBoolean("expiration_panel_state", z).apply();
    }

    public boolean Fu() {
        return this.alq.getBoolean("investment_amount_state", false);
    }

    public void bo(boolean z) {
        this.alq.edit().putBoolean("investment_amount_state", z).apply();
    }

    public void h(Boolean bool) {
        this.alq.edit().putBoolean("isRegistrationLaunchKyc", bool.booleanValue()).apply();
    }

    public void bp(boolean z) {
        this.alq.edit().putBoolean("margin_add_on_was_enabled", z).apply();
    }

    public boolean Fv() {
        return this.alq.getBoolean("margin_add_on_was_enabled", false);
    }

    public void cU(int i) {
        this.alq.edit().putInt("margin_add_on_missed_deals", i).apply();
    }

    public int Fw() {
        return this.alq.getInt("margin_add_on_missed_deals", 0);
    }

    public void Fx() {
        this.alq.edit().putInt("margin_add_on_dialog_shown", Fy() + 1).apply();
    }

    public int Fy() {
        return this.alq.getInt("margin_add_on_dialog_shown", 0);
    }

    public void eK(String str) {
        this.alq.edit().putString("feature_identity", str).apply();
    }

    public void bq(boolean z) {
        this.alq.edit().putBoolean("features_from_socket", z).apply();
    }

    public boolean Fz() {
        return this.alq.getBoolean("features_from_socket", false);
    }

    public String FA() {
        return this.alq.getString("feature_identity", "");
    }

    public void eL(String str) {
        this.alq.edit().putString("welcome_feature_name", str).apply();
    }

    public void br(boolean z) {
        this.alr.edit().putBoolean("debug_show_web_socket_log", z).apply();
    }

    public boolean FB() {
        return this.alr.getBoolean("debug_show_web_socket_log", false);
    }

    public static boolean h(String str, boolean z) {
        return DX().alq.getBoolean(str, z);
    }

    public static boolean eM(String str) {
        return DX().alq.getBoolean(str, true);
    }

    public static boolean eN(String str) {
        return DX().alq.getBoolean(str, false);
    }

    public static boolean get(String str, boolean z) {
        return aR(IQApp.Dk()).alq.getBoolean(str, z);
    }

    public static boolean i(String str, boolean z) {
        DX().alq.edit().putBoolean(str, z).apply();
        return z;
    }

    public static int getInt(String str) {
        return DX().alq.getInt(str, 0);
    }

    public static void setInt(String str, int i) {
        DX().alq.edit().putInt(str, i).apply();
    }

    public static long getLong(String str) {
        return DX().alq.getLong(str, 0);
    }

    public static void setLong(String str, long j) {
        DX().alq.edit().putLong(str, j).apply();
    }

    public void a(Configuration configuration, boolean z) {
        try {
            this.alq.edit().putString(z ? "3bab737a076b" : "3bab737a076c", ah.aGg().toJson((Object) configuration)).apply();
        } catch (Exception unused) {
        }
    }

    public Configuration bs(boolean z) {
        try {
            return (Configuration) ah.aGg().fromJson(this.alq.getString(z ? "3bab737a076b" : "3bab737a076c", ""), Configuration.class);
        } catch (Exception unused) {
            return null;
        }
    }
}
