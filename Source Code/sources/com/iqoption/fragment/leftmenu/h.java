package com.iqoption.fragment.leftmenu;

import android.content.Context;
import com.google.common.b.e;
import com.iqoption.app.IQApp;
import com.iqoption.app.b.b.j;
import com.iqoption.app.b.b.k;
import com.iqoption.app.b.b.p;
import com.iqoption.core.i;
import com.iqoption.dto.entity.BackCall;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.Feature.UpdateEvent;
import com.iqoption.fragment.leftmenu.content.MainMenu;
import com.iqoption.fragment.leftmenu.content.SettingsMenu;
import com.iqoption.service.e.n;
import com.iqoption.system.a.d;

/* compiled from: LeftMenuStateManager */
public class h {
    private static final String TAG = "com.iqoption.fragment.leftmenu.h";
    private static volatile h cCE;
    private boolean cCF;
    private final a cCG = new a();
    private final b cCH = new b();
    private volatile boolean cCI;
    private boolean cCJ;

    /* compiled from: LeftMenuStateManager */
    private class a extends d {
        private a() {
        }

        @e
        public void onAccountIsDemo(k kVar) {
            String jy = h.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=IQAccountEvents.IsTrial. ");
            stringBuilder.append(kVar);
            i.d(jy, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.alK();
                }
            });
        }

        @e
        public void onTickedNotReadCount(p pVar) {
            String jy = h.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=IQAccountEvents.TickedNotReadCount. ");
            stringBuilder.append(pVar);
            i.d(jy, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.alK();
                }
            });
        }

        @e
        public void onIsAnonymousUser(j jVar) {
            String jy = h.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=IQAccountEvents.IsAnonymousUser. ");
            stringBuilder.append(jVar);
            i.d(jy, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.alK();
                }
            });
        }

        @e
        public void onFeatureUpdateEvent(UpdateEvent updateEvent) {
            String jy = h.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=Feature.UpdateEvent. ");
            stringBuilder.append(updateEvent);
            i.d(jy, stringBuilder.toString());
            if (com.google.common.collect.i.c(updateEvent.features).e(new com.google.common.base.j<Feature>() {
                /* renamed from: c */
                public boolean apply(Feature feature) {
                    return "price-movements".equals(feature.name);
                }
            }).isPresent()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        h.this.alK();
                    }
                });
            }
        }

        @e
        public void onClientCategoryChanged(com.iqoption.app.b.b.e eVar) {
            String jy = h.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=IQAccountEvents.ClientCategoryChanged. ");
            stringBuilder.append(eVar);
            i.d(jy, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.alK();
                }
            });
        }
    }

    /* compiled from: LeftMenuStateManager */
    private class b extends com.iqoption.system.a.h {
        private b() {
        }

        @e
        public void onUpdateKYCEvent(n nVar) {
            String jy = h.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=WebSocketEvents.UpdateKYC. ");
            stringBuilder.append(nVar);
            i.d(jy, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.alK();
                }
            });
        }
    }

    private void alM() {
    }

    public static h alI() {
        if (cCE == null) {
            synchronized (com.iqoption.mobbtech.connect.response.a.a.class) {
                if (cCE == null) {
                    cCE = new h();
                }
            }
        }
        return cCE;
    }

    public void onStart() {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStart, isStart=");
        stringBuilder.append(this.cCF);
        i.d(str, stringBuilder.toString());
        if (!this.cCF) {
            this.cCG.register();
            this.cCH.register();
            this.cCF = true;
        }
    }

    public void onStop() {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStop, isStart=");
        stringBuilder.append(this.cCF);
        i.d(str, stringBuilder.toString());
        if (this.cCF) {
            this.cCG.unregister();
            this.cCH.unregister();
            alM();
            this.cCF = false;
        }
    }

    private static void alJ() {
        i.v(TAG, "postUpdate");
        IQApp.Dn().aE(new com.iqoption.fragment.leftmenu.e.a());
    }

    public void alK() {
        Context Dk = IQApp.Dk();
        com.iqoption.app.a aL = com.iqoption.app.a.aL(Dk);
        boolean z = true;
        Object obj = (aL.isVerified() || ((!aL.akB || aL.akF) && !(aL.akB && aL.akC))) ? null : 1;
        boolean CZ = aL.CZ() ^ true;
        boolean CZ2 = aL.CZ() ^ true;
        BackCall Gg = com.iqoption.app.managers.a.Gf().Gg();
        boolean z2 = (this.cCJ || Gg == null || !Gg.isEnabled()) ? false : true;
        boolean bs = com.iqoption.fragment.b.b.bs(Dk);
        boolean isAvailable = com.iqoption.fragment.a.a.isAvailable();
        MainMenu mainMenu = MainMenu.NotificationVerification;
        if ((obj == null && !this.cCI) || !com.iqoption.app.managers.feature.a.HR()) {
            z = false;
        }
        if ((((((SettingsMenu.PushNotifications.setVisible(bs) | (SettingsMenu.Security.setVisible(CZ2) | ((mainMenu.setVisible(z) | MainMenu.WithdrawFunds.setVisible(CZ)) | MainMenu.Debug.setVisible(isAvailable)))) | MainMenu.CallBack.setVisible(z2)) | MainMenu.RateUs.setVisible(false)) | MainMenu.VipManager.setVisible(this.cCJ)) | MainMenu.Quiz.setVisible(alL())) != 0) {
            alJ();
        }
    }

    private boolean alL() {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("iq-quiz");
        return fd != null && "enabled-left-menu".equals(fd.status);
    }

    public void setCardVerificationFailed(boolean z) {
        this.cCI = z;
        alK();
    }

    public void dl(boolean z) {
        this.cCJ = z;
        alK();
    }
}
