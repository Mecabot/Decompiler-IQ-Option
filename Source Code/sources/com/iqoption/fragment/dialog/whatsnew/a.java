package com.iqoption.fragment.dialog.whatsnew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import com.iqoption.activity.VideoActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.aky;
import com.iqoption.d.alq;
import com.iqoption.d.ama;
import com.iqoption.d.ame;
import com.iqoption.d.amg;
import com.iqoption.d.vh;
import com.iqoption.dto.Event;
import com.iqoption.fragment.base.i;
import com.iqoption.fragment.cc;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.dialog.whatsnew.a.b;
import com.iqoption.util.be;
import com.iqoption.x.R;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: WhatsNewDialogFragment */
public class a extends i {
    private static final String TAG = "com.iqoption.fragment.dialog.whatsnew.a";
    private static final ImmutableMap<String, String> cBA = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/59/80/381ba4c10.png").r("xxhdpi", "https://files.iqoption.com/storage/public/59/80/3c4d37a48.png").r("xhdpi", "https://files.iqoption.com/storage/public/59/80/3c6378607.png").r("hdpi", "https://files.iqoption.com/storage/public/59/80/3c895bfbe.png").r("mdpi", "https://files.iqoption.com/storage/public/59/80/3c765aa11.png").tc();
    private static final ImmutableMap<String, String> cBB = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/59/80/4340b18ee.png").r("xxhdpi", "https://files.iqoption.com/storage/public/59/80/43715598d.png").r("xhdpi", "https://files.iqoption.com/storage/public/59/80/437fedc7b.png").r("hdpi", "https://files.iqoption.com/storage/public/59/80/43a5c357f.png").r("mdpi", "https://files.iqoption.com/storage/public/59/80/439581929.png").tc();
    private static final ImmutableMap<String, String> cBC = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/59/80/8f8457db2.png").r("xxhdpi", "https://files.iqoption.com/storage/public/59/80/8f60a2424.png").r("xhdpi", "https://files.iqoption.com/storage/public/59/80/8f48aaf61.png").r("hdpi", "https://files.iqoption.com/storage/public/59/80/8e9aa32df.png").r("mdpi", "https://files.iqoption.com/storage/public/59/80/8ed6cd64f.png").tc();
    private static final ImmutableMap<String, String> cBD = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/59/80/90a4e3b11.png").r("xxhdpi", "https://files.iqoption.com/storage/public/59/80/90957da7e.png").r("xhdpi", "https://files.iqoption.com/storage/public/59/80/9082ef9c4.png").r("hdpi", "https://files.iqoption.com/storage/public/59/80/906f2348d.png").r("mdpi", "https://files.iqoption.com/storage/public/59/80/90534db97.png").tc();
    private static final ImmutableMap<String, String> cBE = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/59/95/7cfdc8e8d.png").r("xxhdpi", "https://files.iqoption.com/storage/public/59/95/7cfda6b76.png").r("xhdpi", "https://files.iqoption.com/storage/public/59/95/7cfd86af8.png").r("hdpi", "https://files.iqoption.com/storage/public/59/95/7cfd76225.png").r("mdpi", "https://files.iqoption.com/storage/public/59/95/7cfd66ff6.png").tc();
    private static final ImmutableMap<String, String> cBF = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/5a/09/4aa7b7868.png").r("xxhdpi", "https://files.iqoption.com/storage/public/5a/09/4a85c6fd7.png").r("xhdpi", "https://files.iqoption.com/storage/public/5a/09/4a5e9f26d.png").r("hdpi", "https://files.iqoption.com/storage/public/5a/09/49428561f.png").r("mdpi", "https://files.iqoption.com/storage/public/5a/09/4a09413ec.png").tc();
    private static final ImmutableMap<String, String> cBG = ImmutableMap.sU().r("xxxhdpi", "https://files.iqoption.com/storage/public/5b/35/d8bcd8568.png").r("xxhdpi", "https://files.iqoption.com/storage/public/5b/35/d9288a635.png").r("xhdpi", "https://files.iqoption.com/storage/public/5b/35/d95a93d1b.png").r("hdpi", "https://files.iqoption.com/storage/public/5b/35/d9868e77a.png").r("mdpi", "https://files.iqoption.com/storage/public/5b/35/d9b97a7d0.png").tc();
    private static final ImmutableMap<String, String> cBH = ImmutableMap.sU().r("WHATS_NEW_DIALOG_TYPE_BINARY", "binary").r("WHATS_NEW_DIALOG_TYPE_DIGITAL", "digital").r("WHATS_NEW_DIALOG_TYPE_FOREX", "forex").r("WHATS_NEW_DIALOG_TYPE_FX_OPTION", "fx-option").r("WHATS_NEW_DIALOG_TYPE_NEW_INDICATORS2", "new-indicator2").r("WHATS_NEW_DIALOG_TYPE_PENDING", "pending").r("WHATS_NEW_DIALOG_TYPE_QUIZ", "quiz").r("WHATS_NEW_DIALOG_TYPE_TPSL", "tpsl").r("WHATS_NEW_DIALOG_TYPE_TRAILING_STOP", "trailing-stop").r("WHATS_NEW_DIALOG_TYPE_TEMPLATES", "templates").r("WHATS_NEW_DIALOG_TYPE_SPOT", "spot").tc();
    private static final ImmutableList<Pair<String, com.iqoption.util.a.a>> cBR = ImmutableList.sO().ae(Pair.create("WHATS_NEW_DIALOG_TYPE_SPOT", h.cBT)).sP();
    private alq cBI;
    private aky cBJ;
    private vh cBK;
    private amg cBL;
    private ame cBM;
    private ama cBN;
    private boolean cBO;
    @Nullable
    private String cBP;
    private String cBQ;

    /* compiled from: WhatsNewDialogFragment */
    public class a extends FragmentStatePagerAdapter {
        public int getCount() {
            return 2;
        }

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return b.alD();
                case 1:
                    return com.iqoption.fragment.dialog.whatsnew.a.a.alC();
                default:
                    throw new RuntimeException("Unsupported position");
            }
        }
    }

    @Nullable
    private static String alt() {
        return "https://files.iqoption.com/storage/public/59/95/7cfd39ccb.mp4";
    }

    @Nullable
    private static String alu() {
        return "https://files.iqoption.com/storage/public/5a/05/bd7469b37.mp4";
    }

    public String gF() {
        return "whats-new_show-popup";
    }

    public static boolean e(FragmentActivity fragmentActivity, FragmentManager fragmentManager) {
        if (af.DX().Ev()) {
            Iterator sI = cBR.iterator();
            while (sI.hasNext()) {
                Pair pair = (Pair) sI.next();
                if (((com.iqoption.util.a.a) pair.second).aaf() && y(fragmentActivity, (String) pair.first)) {
                    return a(fragmentActivity, fragmentManager, (String) pair.first);
                }
            }
        }
        return false;
    }

    private static boolean a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, String str) {
        PopupViewModel.j(fragmentActivity).a(new b(fragmentManager, str), str);
        return true;
    }

    public static boolean b(FragmentActivity fragmentActivity, FragmentManager fragmentManager, String str) {
        if (!y(fragmentActivity, str) || hR(str) == null) {
            return false;
        }
        PopupViewModel.j(fragmentActivity).a(new c(fragmentManager, str), str);
        return true;
    }

    private static void show(FragmentManager fragmentManager, String str) {
        fragmentManager.beginTransaction().add(R.id.fragment, hQ(str), TAG).addToBackStack(TAG).commitAllowingStateLoss();
        af.DX().c(true, str);
    }

    public static boolean y(Context context, String str) {
        af aR = af.aR(context);
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("what's new enabled=truedialogType=");
        stringBuilder.append(str);
        stringBuilder.append(", isShowedWhatsNew=");
        stringBuilder.append(aR.eI(str));
        com.iqoption.core.i.d(str2, stringBuilder.toString());
        return aR.eI(str) ^ 1;
    }

    private static a hQ(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_DIALOG_TYPE", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cBP = bundle.getString("ARG_DIALOG_TYPE");
        }
        this.cBQ = be.bi(getContext());
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cBP == null) {
            return null;
        }
        String str = this.cBP;
        Object obj = -1;
        switch (str.hashCode()) {
            case -2102316932:
                if (str.equals("WHATS_NEW_DIALOG_TYPE_TEMPLATES")) {
                    obj = 3;
                    break;
                }
                break;
            case -1752503470:
                if (str.equals("WHATS_NEW_DIALOG_TYPE_NEW_INDICATORS2")) {
                    obj = null;
                    break;
                }
                break;
            case -748315163:
                if (str.equals("WHATS_NEW_DIALOG_TYPE_FX_OPTION")) {
                    obj = 2;
                    break;
                }
                break;
            case -135626305:
                if (str.equals("WHATS_NEW_DIALOG_TYPE_SPOT")) {
                    obj = 4;
                    break;
                }
                break;
            case 781536808:
                if (str.equals("WHATS_NEW_DIALOG_TYPE_TRAILING_STOP")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return h(layoutInflater, viewGroup, bundle);
            case 1:
                return g(layoutInflater, viewGroup, bundle);
            case 2:
                return d(layoutInflater, viewGroup, bundle);
            case 3:
                return e(layoutInflater, viewGroup, bundle);
            case 4:
                return f(layoutInflater, viewGroup, bundle);
            default:
                return c(layoutInflater, viewGroup, bundle);
        }
    }

    /* JADX WARNING: Missing block: B:6:0x002b, code:
            if (r2.equals("WHATS_NEW_DIALOG_TYPE_FOREX") != false) goto L_0x0057;
     */
    private android.view.View c(android.view.LayoutInflater r2, android.view.ViewGroup r3, android.os.Bundle r4) {
        /*
        r1 = this;
        r4 = 0;
        r0 = 2131559305; // 0x7f0d0389 float:1.874395E38 double:1.0531302247E-314;
        r2 = android.databinding.DataBindingUtil.inflate(r2, r0, r3, r4);
        r2 = (com.iqoption.d.ama) r2;
        r1.cBN = r2;
        r2 = r1.cBN;
        r2.a(r1);
        r2 = r1.cBP;
        r3 = r2.hashCode();
        switch(r3) {
            case -1981065858: goto L_0x004c;
            case -1857785958: goto L_0x0042;
            case -135681262: goto L_0x0038;
            case -135596398: goto L_0x002e;
            case 78518783: goto L_0x0025;
            case 485282843: goto L_0x001b;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x0056;
    L_0x001b:
        r3 = "WHATS_NEW_DIALOG_TYPE_DIGITAL";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0056;
    L_0x0023:
        r4 = 1;
        goto L_0x0057;
    L_0x0025:
        r3 = "WHATS_NEW_DIALOG_TYPE_FOREX";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0056;
    L_0x002d:
        goto L_0x0057;
    L_0x002e:
        r3 = "WHATS_NEW_DIALOG_TYPE_TPSL";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0056;
    L_0x0036:
        r4 = 3;
        goto L_0x0057;
    L_0x0038:
        r3 = "WHATS_NEW_DIALOG_TYPE_QUIZ";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0056;
    L_0x0040:
        r4 = 5;
        goto L_0x0057;
    L_0x0042:
        r3 = "WHATS_NEW_DIALOG_TYPE_PENDING";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0056;
    L_0x004a:
        r4 = 4;
        goto L_0x0057;
    L_0x004c:
        r3 = "WHATS_NEW_DIALOG_TYPE_BINARY";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0056;
    L_0x0054:
        r4 = 2;
        goto L_0x0057;
    L_0x0056:
        r4 = -1;
    L_0x0057:
        switch(r4) {
            case 0: goto L_0x01a6;
            case 1: goto L_0x016b;
            case 2: goto L_0x0136;
            case 3: goto L_0x00fa;
            case 4: goto L_0x00be;
            case 5: goto L_0x005c;
            default: goto L_0x005a;
        };
    L_0x005a:
        goto L_0x01e0;
    L_0x005c:
        r2 = com.iqoption.app.a.Cw();
        r2 = r2.Dh();
        if (r2 == 0) goto L_0x00a2;
    L_0x0066:
        r2 = r1.cBN;
        r2 = r2.bUC;
        r3 = 2131822762; // 0x7f1108aa float:1.9278305E38 double:1.0532603897E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bHT;
        r3 = 2131821339; // 0x7f11031b float:1.9275418E38 double:1.0532596867E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bUi;
        r3 = "00:54";
        r2.setText(r3);
        r2 = r1.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r3 = cBG;
        r4 = r1.cBQ;
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r2 = r2.load(r3);
        r3 = r1.cBN;
        r3 = r3.bUA;
        r2.into(r3);
        goto L_0x01e0;
    L_0x00a2:
        r2 = com.iqoption.quiz.model.TriviaSplashViewModel.dnm;
        r3 = r1.zzakw();
        r2 = r2.y(r3);
        r2 = r2.aBE();
        r3 = r1.zzakw();
        r4 = new com.iqoption.fragment.dialog.whatsnew.d;
        r4.<init>(r1);
        r2.observe(r3, r4);
        goto L_0x01e0;
    L_0x00be:
        r2 = r1.cBN;
        r2 = r2.bUC;
        r3 = 2131822017; // 0x7f1105c1 float:1.9276794E38 double:1.0532600216E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bHT;
        r3 = 2131822836; // 0x7f1108f4 float:1.9278455E38 double:1.0532604263E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bUi;
        r3 = "00:37";
        r2.setText(r3);
        r2 = r1.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r3 = cBF;
        r4 = r1.cBQ;
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r2 = r2.load(r3);
        r3 = r1.cBN;
        r3 = r3.bUA;
        r2.into(r3);
        goto L_0x01e0;
    L_0x00fa:
        r2 = r1.cBN;
        r2 = r2.bUC;
        r3 = 2131822411; // 0x7f11074b float:1.9277593E38 double:1.0532602163E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bHT;
        r3 = 2131821513; // 0x7f1103c9 float:1.9275771E38 double:1.0532597726E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bUi;
        r3 = "00:47";
        r2.setText(r3);
        r2 = r1.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r3 = cBE;
        r4 = r1.cBQ;
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r2 = r2.load(r3);
        r3 = r1.cBN;
        r3 = r3.bUA;
        r2.into(r3);
        goto L_0x01e0;
    L_0x0136:
        r2 = r1.cBN;
        r2 = r2.bUC;
        r3 = 2131820731; // 0x7f1100bb float:1.9274185E38 double:1.0532593863E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bHT;
        r3 = 2131821944; // 0x7f110578 float:1.9276645E38 double:1.0532599856E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bUi;
        r3 = "00:49";
        r2.setText(r3);
        r2 = r1.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r3 = r1.alq();
        r2 = r2.load(r3);
        r3 = r1.cBN;
        r3 = r3.bUA;
        r2.into(r3);
        goto L_0x01e0;
    L_0x016b:
        r2 = r1.cBN;
        r2 = r2.bUC;
        r3 = 2131821222; // 0x7f1102a6 float:1.9275181E38 double:1.053259629E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bHT;
        r3 = 2131821175; // 0x7f110277 float:1.9275086E38 double:1.0532596056E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bUi;
        r3 = "01:27";
        r2.setText(r3);
        r2 = r1.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r3 = cBB;
        r4 = r1.cBQ;
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r2 = r2.load(r3);
        r3 = r1.cBN;
        r3 = r3.bUA;
        r2.into(r3);
        goto L_0x01e0;
    L_0x01a6:
        r2 = r1.cBN;
        r2 = r2.bUC;
        r3 = 2131821198; // 0x7f11028e float:1.9275132E38 double:1.053259617E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bHT;
        r3 = 2131821512; // 0x7f1103c8 float:1.927577E38 double:1.053259772E-314;
        r2.setText(r3);
        r2 = r1.cBN;
        r2 = r2.bUi;
        r3 = "00:49";
        r2.setText(r3);
        r2 = r1.getContext();
        r2 = com.squareup.picasso.Picasso.with(r2);
        r3 = cBA;
        r4 = r1.cBQ;
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r2 = r2.load(r3);
        r3 = r1.cBN;
        r3 = r3.bUA;
        r2.into(r3);
    L_0x01e0:
        r2 = r1.cBN;
        r2 = r2.bUz;
        r3 = new com.iqoption.fragment.dialog.whatsnew.a$1;
        r3.<init>();
        r2.setOnClickListener(r3);
        r2 = r1.cBN;
        r2 = r2.getRoot();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.dialog.whatsnew.a.c(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public static void d(Activity activity, String str) {
        String hR = hR(str);
        if (hR != null) {
            Intent intent = new Intent(activity, VideoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("path", hR);
            bundle.putString("RETURN_PARAM", str);
            if (((String) cBH.get(str)) != null) {
                bundle.putString("ARG_SCREEN_OPENED_EVENT", String.format(Locale.US, "whats-new_play-%s-video", new Object[]{(String) cBH.get(str)}));
            }
            intent.putExtra("params", bundle);
            activity.startActivityForResult(intent, 101);
            activity.overridePendingTransition(R.anim.fast_fade_in, R.anim.fast_fade_out);
        }
    }

    protected int ahd() {
        return getResources().getDimensionPixelSize(R.dimen.dp439);
    }

    private View d(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cBK = (vh) DataBindingUtil.inflate(layoutInflater, R.layout.fx_whats_new_dialog, viewGroup, false);
        this.cBK.a(this);
        this.cBK.blk.setOnClickListener(new e(this));
        return this.cBK.getRoot();
    }

    final /* synthetic */ void bf(View view) {
        onClose();
        com.iqoption.core.microservices.tradingengine.response.active.a f = com.iqoption.app.helpers.a.FI().f(InstrumentType.FX_INSTRUMENT);
        if (f != null) {
            com.iqoption.app.managers.tab.a.Il().d(f.getActiveId(), InstrumentType.FX_INSTRUMENT);
        }
    }

    private View e(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cBL = (amg) DataBindingUtil.inflate(layoutInflater, R.layout.whats_new_dialog_templates, viewGroup, false);
        this.cBL.a(this);
        return this.cBL.getRoot();
    }

    private View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cBM = (ame) DataBindingUtil.inflate(layoutInflater, R.layout.whats_new_dialog_spot, viewGroup, false);
        this.cBM.a(this);
        return this.cBM.getRoot();
    }

    private View g(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cBJ = (aky) DataBindingUtil.inflate(layoutInflater, R.layout.trailing_whats_new_dialog, viewGroup, false);
        this.cBJ.a(this);
        this.cBJ.bTR.setOnClickListener(new f(this));
        return this.cBJ.getRoot();
    }

    final /* synthetic */ void be(View view) {
        cc.j(requireFragmentManager());
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "whats-new_activate-feature").build());
    }

    @Nullable
    public JsonObject ajZ() {
        String str = (String) cBH.get(this.cBP);
        if (str == null) {
            return null;
        }
        return com.iqoption.core.util.i.ZZ().l(Param.TYPE, str).aab();
    }

    public void alo() {
        onClose();
    }

    public boolean onClose() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "whats-new_close").build());
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO(this.cBP);
        return true;
    }

    public void alp() {
        onClose();
        if ("WHATS_NEW_DIALOG_TYPE_SPOT".equals(this.cBP)) {
            com.iqoption.app.managers.tab.a.Il().p(InstrumentType.DIGITAL_INSTRUMENT);
        }
    }

    private String alq() {
        String language = Locale.getDefault().getLanguage();
        Object obj = (language.hashCode() == 3651 && language.equals("ru")) ? null : -1;
        if (obj != null) {
            return (String) cBD.get(this.cBQ);
        }
        return (String) cBC.get(this.cBQ);
    }

    @android.support.annotation.Nullable
    private static java.lang.String hR(java.lang.String r2) {
        /*
        r0 = r2.hashCode();
        switch(r0) {
            case -1981065858: goto L_0x003a;
            case -1857785958: goto L_0x0030;
            case -135681262: goto L_0x0026;
            case -135596398: goto L_0x001c;
            case 78518783: goto L_0x0012;
            case 485282843: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0044;
    L_0x0008:
        r0 = "WHATS_NEW_DIALOG_TYPE_DIGITAL";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0044;
    L_0x0010:
        r2 = 1;
        goto L_0x0045;
    L_0x0012:
        r0 = "WHATS_NEW_DIALOG_TYPE_FOREX";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0044;
    L_0x001a:
        r2 = 0;
        goto L_0x0045;
    L_0x001c:
        r0 = "WHATS_NEW_DIALOG_TYPE_TPSL";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0044;
    L_0x0024:
        r2 = 3;
        goto L_0x0045;
    L_0x0026:
        r0 = "WHATS_NEW_DIALOG_TYPE_QUIZ";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0044;
    L_0x002e:
        r2 = 5;
        goto L_0x0045;
    L_0x0030:
        r0 = "WHATS_NEW_DIALOG_TYPE_PENDING";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0044;
    L_0x0038:
        r2 = 4;
        goto L_0x0045;
    L_0x003a:
        r0 = "WHATS_NEW_DIALOG_TYPE_BINARY";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0044;
    L_0x0042:
        r2 = 2;
        goto L_0x0045;
    L_0x0044:
        r2 = -1;
    L_0x0045:
        r0 = 0;
        switch(r2) {
            case 0: goto L_0x008f;
            case 1: goto L_0x0078;
            case 2: goto L_0x0059;
            case 3: goto L_0x0054;
            case 4: goto L_0x004f;
            case 5: goto L_0x004a;
            default: goto L_0x0049;
        };
    L_0x0049:
        return r0;
    L_0x004a:
        r2 = alv();
        return r2;
    L_0x004f:
        r2 = alu();
        return r2;
    L_0x0054:
        r2 = alt();
        return r2;
    L_0x0059:
        r2 = java.util.Locale.getDefault();
        r2 = r2.getLanguage();
        r1 = "en";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x006c;
    L_0x0069:
        r2 = "https://new.static.iqoption.com/video/how_to_trade_on_mobile_app_en.mp4";
        return r2;
    L_0x006c:
        r1 = "ru";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x0077;
    L_0x0074:
        r2 = "https://new.static.iqoption.com/video/how_to_trade_on_mobile_app_ru.mp4";
        return r2;
    L_0x0077:
        return r0;
    L_0x0078:
        r2 = com.iqoption.app.managers.feature.b.HT();
        r0 = "use-cdn-storage";
        r2 = r2.ff(r0);
        if (r2 == 0) goto L_0x008a;
    L_0x0085:
        r2 = alx();
        return r2;
    L_0x008a:
        r2 = alw();
        return r2;
    L_0x008f:
        r2 = com.iqoption.app.managers.feature.b.HT();
        r0 = "use-cdn-storage";
        r2 = r2.ff(r0);
        if (r2 == 0) goto L_0x00a1;
    L_0x009c:
        r2 = als();
        return r2;
    L_0x00a1:
        r2 = alr();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.dialog.whatsnew.a.hR(java.lang.String):java.lang.String");
    }

    @android.support.annotation.Nullable
    private static java.lang.String alr() {
        /*
        r0 = java.util.Locale.getDefault();
        r0 = r0.getLanguage();
        r1 = r0.hashCode();
        switch(r1) {
            case 3201: goto L_0x0093;
            case 3246: goto L_0x0088;
            case 3276: goto L_0x007d;
            case 3355: goto L_0x0073;
            case 3365: goto L_0x0069;
            case 3371: goto L_0x005e;
            case 3428: goto L_0x0054;
            case 3588: goto L_0x0049;
            case 3651: goto L_0x003f;
            case 3666: goto L_0x0035;
            case 3683: goto L_0x0029;
            case 3710: goto L_0x001d;
            case 3886: goto L_0x0011;
            default: goto L_0x000f;
        };
    L_0x000f:
        goto L_0x009e;
    L_0x0011:
        r1 = "zh";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x001a:
        r0 = 1;
        goto L_0x009f;
    L_0x001d:
        r1 = "tr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0026:
        r0 = 2;
        goto L_0x009f;
    L_0x0029:
        r1 = "sv";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0032:
        r0 = 5;
        goto L_0x009f;
    L_0x0035:
        r1 = "se";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x003d:
        r0 = 4;
        goto L_0x009f;
    L_0x003f:
        r1 = "ru";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0047:
        r0 = 0;
        goto L_0x009f;
    L_0x0049:
        r1 = "pt";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0051:
        r0 = 11;
        goto L_0x009f;
    L_0x0054:
        r1 = "ko";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x005c:
        r0 = 3;
        goto L_0x009f;
    L_0x005e:
        r1 = "it";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0066:
        r0 = 10;
        goto L_0x009f;
    L_0x0069:
        r1 = "in";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0071:
        r0 = 6;
        goto L_0x009f;
    L_0x0073:
        r1 = "id";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x007b:
        r0 = 7;
        goto L_0x009f;
    L_0x007d:
        r1 = "fr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0085:
        r0 = 12;
        goto L_0x009f;
    L_0x0088:
        r1 = "es";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0090:
        r0 = 9;
        goto L_0x009f;
    L_0x0093:
        r1 = "de";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x009b:
        r0 = 8;
        goto L_0x009f;
    L_0x009e:
        r0 = -1;
    L_0x009f:
        switch(r0) {
            case 0: goto L_0x00c3;
            case 1: goto L_0x00c0;
            case 2: goto L_0x00bd;
            case 3: goto L_0x00ba;
            case 4: goto L_0x00b7;
            case 5: goto L_0x00b7;
            case 6: goto L_0x00b4;
            case 7: goto L_0x00b4;
            case 8: goto L_0x00b1;
            case 9: goto L_0x00ae;
            case 10: goto L_0x00ab;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00a5;
            default: goto L_0x00a2;
        };
    L_0x00a2:
        r0 = "https://player.vimeo.com/external/224643209.hd.mp4?s=91108dd3927e28b83e94ae5f72ffccd73b15abe0&profile_id=174";
        return r0;
    L_0x00a5:
        r0 = "https://player.vimeo.com/external/225852221.hd.mp4?s=dd0fab17c8845aedb2d3fff30426efda8b93cecd&profile_id=174";
        return r0;
    L_0x00a8:
        r0 = "https://player.vimeo.com/external/224703968.hd.mp4?s=5985a9df9cb96f47b085f8bd8cc1c9077abf5874&profile_id=174";
        return r0;
    L_0x00ab:
        r0 = "https://player.vimeo.com/external/224692886.hd.mp4?s=b2cea06c4404770ca9e7f8f706b8bd910b1aea77&profile_id=174";
        return r0;
    L_0x00ae:
        r0 = "https://player.vimeo.com/external/224704718.hd.mp4?s=81146cbe08fff0f121d24b255f0f13d8177eaa76&profile_id=174";
        return r0;
    L_0x00b1:
        r0 = "https://player.vimeo.com/external/224687261.hd.mp4?s=a28bdf42a526f2c9f85f7ad912d16e85dc2feddb&profile_id=174";
        return r0;
    L_0x00b4:
        r0 = "https://player.vimeo.com/external/224704328.hd.mp4?s=b3078455279f5e37f130100a8a9f8b0f031ebe78&profile_id=174";
        return r0;
    L_0x00b7:
        r0 = "https://player.vimeo.com/external/224704564.hd.mp4?s=364c677605410cb41d5ffb0af99e55e81c563285&profile_id=174";
        return r0;
    L_0x00ba:
        r0 = "https://player.vimeo.com/external/224745985.hd.mp4?s=dd609897098eb24493549030956c95c9ae487437&profile_id=174";
        return r0;
    L_0x00bd:
        r0 = "https://player.vimeo.com/external/224747307.hd.mp4?s=39f10f4831e4718feeb4088aaa9bdd1039e25f26&profile_id=174";
        return r0;
    L_0x00c0:
        r0 = "https://player.vimeo.com/external/224745988.hd.mp4?s=faab3c4690bed3f73a0d992c474e33a46160bf08&profile_id=174";
        return r0;
    L_0x00c3:
        r0 = "https://player.vimeo.com/external/224683317.hd.mp4?s=a09d480dc4b32e68ff377556f61c497e28f4459c&profile_id=174";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.dialog.whatsnew.a.alr():java.lang.String");
    }

    @Nullable
    private static String als() {
        String language = Locale.getDefault().getLanguage();
        Object obj = (language.hashCode() == 3886 && language.equals("zh")) ? null : -1;
        return obj != null ? "http://files.iqoption.com/storage/public/59/63/83b4c166d.mp4" : "http://files.iqoption.com/storage/public/59/63/84c40ff18.mp4";
    }

    @android.support.annotation.Nullable
    private static java.lang.String alv() {
        /*
        r0 = java.util.Locale.getDefault();
        r0 = r0.getLanguage();
        r1 = r0.hashCode();
        switch(r1) {
            case 3201: goto L_0x007b;
            case 3246: goto L_0x0071;
            case 3276: goto L_0x0067;
            case 3355: goto L_0x005d;
            case 3365: goto L_0x0053;
            case 3371: goto L_0x0049;
            case 3428: goto L_0x003f;
            case 3588: goto L_0x0034;
            case 3651: goto L_0x0029;
            case 3710: goto L_0x001d;
            case 3886: goto L_0x0011;
            default: goto L_0x000f;
        };
    L_0x000f:
        goto L_0x0085;
    L_0x0011:
        r1 = "zh";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x001a:
        r0 = 0;
        goto L_0x0086;
    L_0x001d:
        r1 = "tr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0026:
        r0 = 10;
        goto L_0x0086;
    L_0x0029:
        r1 = "ru";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0031:
        r0 = 9;
        goto L_0x0086;
    L_0x0034:
        r1 = "pt";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x003c:
        r0 = 8;
        goto L_0x0086;
    L_0x003f:
        r1 = "ko";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0047:
        r0 = 7;
        goto L_0x0086;
    L_0x0049:
        r1 = "it";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0051:
        r0 = 6;
        goto L_0x0086;
    L_0x0053:
        r1 = "in";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x005b:
        r0 = 4;
        goto L_0x0086;
    L_0x005d:
        r1 = "id";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0065:
        r0 = 5;
        goto L_0x0086;
    L_0x0067:
        r1 = "fr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x006f:
        r0 = 3;
        goto L_0x0086;
    L_0x0071:
        r1 = "es";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0079:
        r0 = 2;
        goto L_0x0086;
    L_0x007b:
        r1 = "de";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0085;
    L_0x0083:
        r0 = 1;
        goto L_0x0086;
    L_0x0085:
        r0 = -1;
    L_0x0086:
        switch(r0) {
            case 0: goto L_0x00a7;
            case 1: goto L_0x00a4;
            case 2: goto L_0x00a1;
            case 3: goto L_0x009e;
            case 4: goto L_0x009b;
            case 5: goto L_0x009b;
            case 6: goto L_0x0098;
            case 7: goto L_0x0095;
            case 8: goto L_0x0092;
            case 9: goto L_0x008f;
            case 10: goto L_0x008c;
            default: goto L_0x0089;
        };
    L_0x0089:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d7bcbc52f.mp4";
        return r0;
    L_0x008c:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d9c35f524.mp4";
        return r0;
    L_0x008f:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d98b7f449.mp4";
        return r0;
    L_0x0092:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d95bcd5b3.mp4";
        return r0;
    L_0x0095:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d92f1f011.mp4";
        return r0;
    L_0x0098:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d8f96cd46.mp4";
        return r0;
    L_0x009b:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d894d9da8.mp4";
        return r0;
    L_0x009e:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d842628d3.mp4";
        return r0;
    L_0x00a1:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d80c9ab73.mp4";
        return r0;
    L_0x00a4:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d761dc129.mp4";
        return r0;
    L_0x00a7:
        r0 = "https://files.iqoption.com/storage/public/5b/39/d686718d8.mp4";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.dialog.whatsnew.a.alv():java.lang.String");
    }

    private static java.lang.String alw() {
        /*
        r0 = java.util.Locale.getDefault();
        r0 = r0.getLanguage();
        r1 = r0.hashCode();
        switch(r1) {
            case 3201: goto L_0x0093;
            case 3246: goto L_0x0088;
            case 3276: goto L_0x007d;
            case 3355: goto L_0x0073;
            case 3365: goto L_0x0069;
            case 3371: goto L_0x005e;
            case 3428: goto L_0x0054;
            case 3588: goto L_0x0049;
            case 3651: goto L_0x003f;
            case 3666: goto L_0x0035;
            case 3683: goto L_0x0029;
            case 3710: goto L_0x001d;
            case 3886: goto L_0x0011;
            default: goto L_0x000f;
        };
    L_0x000f:
        goto L_0x009e;
    L_0x0011:
        r1 = "zh";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x001a:
        r0 = 1;
        goto L_0x009f;
    L_0x001d:
        r1 = "tr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0026:
        r0 = 2;
        goto L_0x009f;
    L_0x0029:
        r1 = "sv";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0032:
        r0 = 5;
        goto L_0x009f;
    L_0x0035:
        r1 = "se";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x003d:
        r0 = 4;
        goto L_0x009f;
    L_0x003f:
        r1 = "ru";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0047:
        r0 = 0;
        goto L_0x009f;
    L_0x0049:
        r1 = "pt";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0051:
        r0 = 11;
        goto L_0x009f;
    L_0x0054:
        r1 = "ko";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x005c:
        r0 = 3;
        goto L_0x009f;
    L_0x005e:
        r1 = "it";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0066:
        r0 = 10;
        goto L_0x009f;
    L_0x0069:
        r1 = "in";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0071:
        r0 = 6;
        goto L_0x009f;
    L_0x0073:
        r1 = "id";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x007b:
        r0 = 7;
        goto L_0x009f;
    L_0x007d:
        r1 = "fr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0085:
        r0 = 12;
        goto L_0x009f;
    L_0x0088:
        r1 = "es";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x0090:
        r0 = 9;
        goto L_0x009f;
    L_0x0093:
        r1 = "de";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x009b:
        r0 = 8;
        goto L_0x009f;
    L_0x009e:
        r0 = -1;
    L_0x009f:
        switch(r0) {
            case 0: goto L_0x00c3;
            case 1: goto L_0x00c0;
            case 2: goto L_0x00bd;
            case 3: goto L_0x00ba;
            case 4: goto L_0x00b7;
            case 5: goto L_0x00b7;
            case 6: goto L_0x00b4;
            case 7: goto L_0x00b4;
            case 8: goto L_0x00b1;
            case 9: goto L_0x00ae;
            case 10: goto L_0x00ab;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00a5;
            default: goto L_0x00a2;
        };
    L_0x00a2:
        r0 = "https://player.vimeo.com/external/222076227.hd.mp4?s=09146791b4eaea00e964919c0c8658511a5ea00c&profile_id=174";
        return r0;
    L_0x00a5:
        r0 = "https://player.vimeo.com/external/224912713.hd.mp4?s=043b52a0ab28c45de6c47e3bbba14a3eefea3e37&profile_id=174";
        return r0;
    L_0x00a8:
        r0 = "https://player.vimeo.com/external/224042741.hd.mp4?s=c7d46030f684c11045034e74101e69e83d71c87e&profile_id=174";
        return r0;
    L_0x00ab:
        r0 = "https://player.vimeo.com/external/224035522.hd.mp4?s=e7f92f4564ac4a4e7b89d289d034aefe203379c0&profile_id=174";
        return r0;
    L_0x00ae:
        r0 = "https://player.vimeo.com/external/224035698.hd.mp4?s=8f73347d642f3e44cab0a7377d150fb925920f0c&profile_id=174";
        return r0;
    L_0x00b1:
        r0 = "https://player.vimeo.com/external/223796903.hd.mp4?s=107ca54ea89349450e3aa67a9fb19a921758e7bb&profile_id=174";
        return r0;
    L_0x00b4:
        r0 = "https://player.vimeo.com/external/223795924.hd.mp4?s=c003c449ff88591742a126a9ae1c2929e8d427ab&profile_id=174";
        return r0;
    L_0x00b7:
        r0 = "https://player.vimeo.com/external/223795096.hd.mp4?s=49e06b3018a603bc2ed440b34e00dfa05d7be0c8&profile_id=174";
        return r0;
    L_0x00ba:
        r0 = "https://player.vimeo.com/external/223794980.hd.mp4?s=d4a40bd36a60467185fa8f70c14e7ac16106b58b&profile_id=174";
        return r0;
    L_0x00bd:
        r0 = "https://player.vimeo.com/external/223794879.hd.mp4?s=042c3c5fad7f5f94462c90ea9c0fd75db0079dc3&profile_id=174";
        return r0;
    L_0x00c0:
        r0 = "https://player.vimeo.com/external/223793486.hd.mp4?s=570cf3a7781533cbbc3e8ced7b8aaeb0d5107383&profile_id=174";
        return r0;
    L_0x00c3:
        r0 = "https://player.vimeo.com/external/223791732.hd.mp4?s=c903ba902e4196cffe188a40a6fbc1de7c9ef0d6&profile_id=174";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.dialog.whatsnew.a.alw():java.lang.String");
    }

    private static String alx() {
        String language = Locale.getDefault().getLanguage();
        Object obj = (language.hashCode() == 3886 && language.equals("zh")) ? null : -1;
        return obj != null ? "http://files.iqoption.com/storage/public/59/5c/f4a1daa00.mp4" : "http://files.iqoption.com/storage/public/59/5c/f5bd95881.mp4";
    }

    private View h(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cBI = (alq) DataBindingUtil.inflate(layoutInflater, R.layout.view_pager_whats_new_dialog, viewGroup, false);
        this.cBI.a(this);
        this.cBI.bwm.setAdapter(new a(getChildFragmentManager()));
        this.cBI.bwm.setOffscreenPageLimit(1);
        this.cBI.bUl.setOnClickListener(new g(this));
        k(0, true);
        k(1, false);
        this.cBI.bwm.addOnPageChangeListener(new SimpleOnPageChangeListener() {
            public void onPageSelected(int i) {
                a.this.k(i, true);
                switch (i) {
                    case 0:
                        a.this.k(1, false);
                        a.this.cBI.bUl.setText(R.string.next);
                        return;
                    case 1:
                        a.this.k(0, false);
                        a.this.cBI.bUl.setText(R.string.trade);
                        return;
                    default:
                        throw new RuntimeException("Unsupported position");
                }
            }
        });
        return this.cBI.getRoot();
    }

    final /* synthetic */ void bd(View view) {
        int currentItem = this.cBI.bwm.getCurrentItem();
        if (currentItem == 0) {
            this.cBI.bwm.setCurrentItem(currentItem + 1, true);
        } else {
            onClose();
        }
    }

    private void k(int i, boolean z) {
        float f = 0.3f;
        ViewPropertyAnimator animate;
        switch (i) {
            case 0:
                animate = this.cBI.bvZ.animate();
                if (z) {
                    f = 1.0f;
                }
                animate.alpha(f);
                return;
            case 1:
                animate = this.cBI.bwa.animate();
                if (z) {
                    f = 1.0f;
                }
                animate.alpha(f);
                return;
            default:
                throw new RuntimeException("Unsupported position");
        }
    }
}
