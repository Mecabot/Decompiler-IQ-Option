package com.iqoption.fragment.leftmenu;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import com.google.common.collect.ImmutableMap;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.BackCall;
import com.iqoption.fragment.MenuFragment.MenuItem;
import com.iqoption.fragment.cb;
import com.iqoption.fragment.cc;
import com.iqoption.fragment.cm;
import com.iqoption.fragment.leftmenu.content.HistoryMenu;
import com.iqoption.fragment.leftmenu.content.MainMenu;
import com.iqoption.fragment.leftmenu.content.SettingsMenu;
import com.iqoption.fragment.leftmenu.content.VipMangerMenu;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.operations.OperationHistoryActivity;
import com.iqoption.quiz.QuizActivity;
import com.iqoption.sessions.ActiveSessionsActivity;
import com.iqoption.trading.history.TradingHistoryActivity;
import com.iqoption.widget.helper.SplashLogHelper;
import com.iqoption.x.R;

/* compiled from: LeftMenuAction */
public class a {
    private static final String TAG = "com.iqoption.fragment.leftmenu.a";
    private static ImmutableMap<com.iqoption.fragment.leftmenu.content.a, g> cCf = new com.google.common.collect.ImmutableMap.a().r(MainMenu.Profile, new m()).r(MainMenu.NotificationVerification, new j()).r(MainMenu.Debug, new c()).r(MainMenu.Deposit, new d()).r(MainMenu.WithdrawFunds, new x()).r(HistoryMenu.Operations, new k()).r(HistoryMenu.Trading, new w()).r(VipMangerMenu.about, new a()).r(VipMangerMenu.education, new e()).r(VipMangerMenu.request_call, new r()).r(SettingsMenu.General, new f()).r(SettingsMenu.Security, new s()).r(SettingsMenu.PushNotifications, new n()).r(SettingsMenu.NewsAndUpdates, new i()).r(SettingsMenu.ActiveSessions, new b()).r(SettingsMenu.TechnicalLog, new u()).r(MainMenu.LogOut, new h()).r(MainMenu.Support, new t()).r(MainMenu.CallBack, new q()).r(MainMenu.RateUs, new p()).r(MainMenu.Quiz, new o()).r(MainMenu.TermsAndConditions, new v()).tc();
    private static ImmutableMap<Integer, g> cCg = new com.google.common.collect.ImmutableMap.a().r(Integer.valueOf(R.layout.left_menu_item_pro_trader), new l()).tc();

    /* compiled from: LeftMenuAction */
    private interface g {
        void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar);
    }

    /* compiled from: LeftMenuAction */
    private static class a implements g {
        private a() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            com.iqoption.vip.a.dKM.u(tradeRoomActivity);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class b implements g {
        private b() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_active_sessions"));
            ActiveSessionsActivity.dqA.l(tradeRoomActivity);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class c implements g {
        private c() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            tradeRoomActivity.getSupportFragmentManager().beginTransaction().add(R.id.other_fragment, com.iqoption.fragment.a.b.akW(), "DebugMenuFragment").addToBackStack("DebugMenuFragment").commit();
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class d implements g {
        private d() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_deposit"));
            if (com.iqoption.app.a.aL((Context) tradeRoomActivity).CZ()) {
                a.e(tradeRoomActivity);
                return;
            }
            tradeRoomActivity.Aq();
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class e implements g {
        private e() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            com.iqoption.vip.i.dLv.u(tradeRoomActivity);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class f implements g {
        private f() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_settings"));
            cc.i(tradeRoomActivity.getSupportFragmentManager());
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class h implements g {
        private h() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            com.iqoption.util.v.h(tradeRoomActivity);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class i implements g {
        private i() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            com.iqoption.newsandupdates.d.a(tradeRoomActivity.getSupportFragmentManager(), (int) R.id.other_fragment);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class j implements g {
        private j() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            if (!com.iqoption.app.a.aL((Context) tradeRoomActivity).CZ()) {
                a.a(tradeRoomActivity, "verification");
                tradeRoomActivity.a(MenuItem.PERSONAL_INFO);
            }
        }
    }

    /* compiled from: LeftMenuAction */
    private static class k implements g {
        private k() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_operation-history"));
            OperationHistoryActivity.cXh.l(tradeRoomActivity);
        }
    }

    /* compiled from: LeftMenuAction */
    private static class l implements g {
        private l() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            com.iqoption.fragment.leftmenu.content.e eVar = (com.iqoption.fragment.leftmenu.content.e) aVar;
            tradeRoomActivity.a(eVar.alY());
            LeftMenuViewModel.k(tradeRoomActivity).close();
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, eVar.alY() == StatusType.DECLINED ? "menu_declined-learn-more" : "menu_become-pro"));
        }
    }

    /* compiled from: LeftMenuAction */
    private static class m implements g {
        private m() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_personal-data"));
            if (com.iqoption.app.a.aL((Context) tradeRoomActivity).CZ()) {
                com.iqoption.welcomeonboarding.registration.f.a(tradeRoomActivity, tradeRoomActivity.getSupportFragmentManager());
                LeftMenuViewModel.k(tradeRoomActivity).close();
                return;
            }
            tradeRoomActivity.a(MenuItem.PERSONAL_INFO);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class n implements g {
        private n() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_push_settings"));
            cb.i(tradeRoomActivity.getSupportFragmentManager());
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class o implements g {
        private o() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_quiz"));
            if (com.iqoption.app.a.Cw().CZ()) {
                com.iqoption.welcomeonboarding.registration.f.a(tradeRoomActivity, tradeRoomActivity.getSupportFragmentManager());
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_open-account").build());
                return;
            }
            tradeRoomActivity.startActivity(new Intent(tradeRoomActivity, QuizActivity.class));
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class p implements g {
        private p() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_rate-app"));
            com.iqoption.dialog.f.a((FragmentActivity) tradeRoomActivity, tradeRoomActivity.getSupportFragmentManager());
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class q implements g {
        private q() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            BackCall Ar = tradeRoomActivity.Ar();
            if (Ar != null) {
                new com.iqoption.dialog.b(tradeRoomActivity, Ar).show();
                LeftMenuViewModel.k(tradeRoomActivity).close();
            }
        }
    }

    /* compiled from: LeftMenuAction */
    private static class r implements g {
        private r() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            com.iqoption.vip.e.dLc.I(tradeRoomActivity);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class s implements g {
        private s() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_security"));
            tradeRoomActivity.Al();
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class t implements g {
        private t() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            a.a(tradeRoomActivity, "support");
            tradeRoomActivity.a(MenuItem.SUPPORT);
        }
    }

    /* compiled from: LeftMenuAction */
    private static class u implements g {
        private u() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_technical_log"));
            tradeRoomActivity.getSupportFragmentManager().beginTransaction().add(R.id.other_fragment, cm.hA(SplashLogHelper.cf(tradeRoomActivity)), cm.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(cm.TAG).commit();
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class v implements g {
        private v() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_terms"));
            tradeRoomActivity.getSupportFragmentManager().beginTransaction().add(R.id.other_fragment, com.iqoption.dialog.s.hm(com.iqoption.app.a.Cw().Dh() ? "terms-regulated" : "terms-conditions"), "TermsDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("TermsDialog").commit();
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class w implements g {
        private w() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_trading-history"));
            TradingHistoryActivity.l(tradeRoomActivity);
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    /* compiled from: LeftMenuAction */
    private static class x implements g {
        private x() {
        }

        public void a(TradeRoomActivity tradeRoomActivity, com.iqoption.fragment.leftmenu.content.a aVar) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "menu_withdrawals"));
            tradeRoomActivity.Am();
            LeftMenuViewModel.k(tradeRoomActivity).close();
        }
    }

    public static void a(com.iqoption.fragment.leftmenu.content.a aVar, TradeRoomActivity tradeRoomActivity) {
        g gVar = (g) cCf.get(aVar);
        if (gVar == null) {
            gVar = (g) cCg.get(Integer.valueOf(aVar.layoutResId()));
        }
        if (gVar != null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Handle action ");
            stringBuilder.append(aVar);
            com.iqoption.core.i.v(str, stringBuilder.toString());
            gVar.a(tradeRoomActivity, aVar);
            return;
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unhandled action ");
        stringBuilder2.append(aVar);
        com.iqoption.core.i.w(str2, stringBuilder2.toString());
    }

    private static void a(TradeRoomActivity tradeRoomActivity, String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "menu_open-notification").setParameters(com.iqoption.core.util.i.ZZ().l("notification_type", str).aab()).build());
    }

    private static void e(TradeRoomActivity tradeRoomActivity) {
        com.iqoption.welcomeonboarding.registration.f.a(tradeRoomActivity, tradeRoomActivity.getSupportFragmentManager());
        LeftMenuViewModel.k(tradeRoomActivity).close();
    }
}
