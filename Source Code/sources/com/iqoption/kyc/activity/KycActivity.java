package com.iqoption.kyc.activity;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.iqbus.NetverifyConfig;
import com.iqoption.dto.entity.iqbus.NetverifyConfig.NetverifyConfigData;
import com.iqoption.dto.entity.iqbus.NetverifyToken;
import com.iqoption.dto.entity.result.KycQuestionsResult;
import com.iqoption.dto.entity.result.KycQuestionsResult.Answer;
import com.iqoption.dto.entity.result.KycQuestionsResult.Question;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.dto.entity.result.NetverifyUploadStatus;
import com.iqoption.dto.entity.result.ProofDocsResult;
import com.iqoption.fragment.MenuFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ac;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.x.R;
import com.jumio.MobileSDK;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.exceptions.MissingPermissionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class KycActivity extends com.iqoption.core.ui.a.a implements com.iqoption.kyc.fragment.a.a.a, com.iqoption.kyc.fragment.b.a, com.iqoption.kyc.fragment.b.a.b, com.iqoption.kyc.fragment.b.b.a, com.iqoption.kyc.fragment.b.c.b, com.iqoption.kyc.fragment.c.a, com.iqoption.kyc.fragment.c.a.a, com.iqoption.kyc.fragment.c.b.a, com.iqoption.kyc.fragment.c.c.b, com.iqoption.kyc.fragment.c.d.a, com.iqoption.kyc.fragment.c.e.a, com.iqoption.kyc.fragment.c.f.a, com.iqoption.kyc.fragment.d.a.a, com.iqoption.kyc.fragment.d.b.a, com.iqoption.kyc.fragment.d.c.a, com.iqoption.kyc.fragment.d.e.a, com.iqoption.kyc.fragment.e.a.a.a, com.iqoption.kyc.fragment.e.a.e.a, com.iqoption.kyc.fragment.e.a.h.a, com.iqoption.kyc.fragment.e.a.m.a, com.iqoption.kyc.fragment.f.a.a, com.iqoption.kyc.fragment.f.b.a, com.iqoption.kyc.fragment.gdpr.a.b, com.iqoption.kyc.fragment.jumio.b.a, com.iqoption.kyc.fragment.jumio.c.a, com.iqoption.kyc.fragment.jumio.d.a, com.iqoption.kyc.fragment.jumio.e.a, com.iqoption.kyc.fragment.jumio.f.a, com.iqoption.kyc.fragment.jumio.g.a, com.iqoption.kyc.fragment.jumio.h.a, com.iqoption.kyc.g, com.iqoption.view.e {
    private static final String TAG = "com.iqoption.kyc.activity.KycActivity";
    private static String cJA;
    private static String cJB;
    private static String cJC;
    private static String cJD;
    private static String cJE;
    private static String cJF;
    private boolean adF;
    private final com.iqoption.view.f aen = new com.iqoption.view.f();
    private j cJG = new j();
    private d cJH = new d(this, null);
    @Nullable
    private com.iqoption.kyc.c cJI;
    @Nullable
    private com.iqoption.kyc.f cJJ;
    @Nullable
    private MobileSDK cJK;
    private String cJL = "";
    private boolean cJM;
    private s<?> cJN;
    private View czX;

    public static final class a {
        private final Activity Cj;
        private String cJL;
        private boolean cJM;
        private boolean cJY;
        private boolean cJZ;
        private KycState cJn;
        private boolean cKa = true;

        public a(Activity activity) {
            this.Cj = activity;
        }

        public a d(KycState kycState) {
            this.cJn = kycState;
            return this;
        }

        public a ic(String str) {
            this.cJL = str;
            return this;
        }

        public a dO(boolean z) {
            this.cJM = z;
            return this;
        }

        public a dP(boolean z) {
            this.cJY = z;
            return this;
        }

        public a dQ(boolean z) {
            this.cJZ = z;
            return this;
        }

        public a dR(boolean z) {
            this.cKa = z;
            return this;
        }

        public void start() {
            this.Cj.startActivity(KycActivity.a(this.Cj, this.cJn, this.cJL, this.cJM, this.cJY, this.cJZ, this.cKa));
        }

        public void f(@NonNull Fragment fragment, int i) {
            fragment.startActivityForResult(KycActivity.a(this.Cj, this.cJn, this.cJL, this.cJM, this.cJY, this.cJZ, this.cKa), i);
        }
    }

    private static class j implements Parcelable {
        public static final Creator<j> CREATOR = new Creator<j>() {
            /* renamed from: L */
            public j createFromParcel(Parcel parcel) {
                return new j(parcel);
            }

            /* renamed from: fd */
            public j[] newArray(int i) {
                return new j[i];
            }
        };
        private boolean cJY;
        private boolean cJZ;
        @Nullable
        private KycState cJn;
        private boolean cKa;
        private com.iqoption.kyc.e cKi = new com.iqoption.kyc.e();
        @Nullable
        com.iqoption.microservice.a.a.b cKj;
        @Nullable
        private List<Integer> cKk;
        @Nullable
        private NetverifyConfig cKl;
        private boolean cKm;
        private boolean cKn;
        private boolean cKo;
        @Nullable
        private HashMap<Integer, Question> questionMap;

        public int describeContents() {
            return 0;
        }

        j() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.cKi, i);
            parcel.writeLong(this.questionMap == null ? 0 : (long) this.questionMap.size());
            if (this.questionMap != null) {
                for (Entry entry : this.questionMap.entrySet()) {
                    parcel.writeValue(entry.getKey());
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
            parcel.writeList(this.cKk);
            if (this.cKj == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeParcelable(this.cKj, 0);
            }
            parcel.writeParcelable(this.cKl, i);
            parcel.writeParcelable(this.cJn, i);
            parcel.writeByte(this.cKm);
            parcel.writeByte(this.cKn);
            parcel.writeByte(this.cKo);
            parcel.writeByte(this.cJY);
            parcel.writeByte(this.cJZ);
            parcel.writeByte(this.cKa);
        }

        protected j(Parcel parcel) {
            this.cKi = (com.iqoption.kyc.e) parcel.readParcelable(com.iqoption.kyc.e.class.getClassLoader());
            this.questionMap = new HashMap();
            long readLong = parcel.readLong();
            for (long j = 0; j < readLong; j++) {
                this.questionMap.put((Integer) parcel.readValue(Integer.class.getClassLoader()), parcel.readParcelable(Question.class.getClassLoader()));
            }
            this.cKk = new ArrayList();
            parcel.readList(this.cKk, Integer.class.getClassLoader());
            if (parcel.readInt() != 0) {
                this.cKj = (com.iqoption.microservice.a.a.b) parcel.readParcelable(com.iqoption.microservice.a.a.b.class.getClassLoader());
            }
            this.cKl = (NetverifyConfig) parcel.readParcelable(NetverifyConfig.class.getClassLoader());
            this.cJn = (KycState) parcel.readParcelable(KycState.class.getClassLoader());
            boolean z = false;
            this.cKm = parcel.readByte() != (byte) 0;
            this.cKn = parcel.readByte() != (byte) 0;
            this.cKo = parcel.readByte() != (byte) 0;
            this.cJY = parcel.readByte() != (byte) 0;
            this.cJZ = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.cKa = z;
        }
    }

    private static class b extends com.iqoption.system.c.b<KycActivity, com.iqoption.mobbtech.connect.response.l> {
        public b(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, com.iqoption.mobbtech.connect.response.l lVar) {
            super.z(kycActivity, lVar);
            String apM = KycActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ConfirmPhoneCallback result: ");
            stringBuilder.append(lVar);
            com.iqoption.core.i.v(apM, stringBuilder.toString());
            kycActivity.b(com.iqoption.kyc.fragment.b.b.f(kycActivity.cJG.cJn), com.iqoption.kyc.fragment.b.b.TAG);
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            com.iqoption.core.i.e(KycActivity.TAG, th.toString(), th);
            MobbErrorException.D(th);
        }
    }

    private static class c extends com.iqoption.system.c.b<KycActivity, ProofDocsResult> {
        public c(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, ProofDocsResult proofDocsResult) {
            super.z(kycActivity, proofDocsResult);
            boolean z = kycActivity.cJI == null || kycActivity.cJI.Dh();
            kycActivity.b(com.iqoption.kyc.fragment.jumio.e.a(proofDocsResult, com.iqoption.app.managers.feature.b.HT().ff("close-kyc-docs"), z), com.iqoption.kyc.fragment.jumio.e.TAG);
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            MobbErrorException.D(th);
        }
    }

    private class d extends com.iqoption.system.a.d {
        private d() {
        }

        /* synthetic */ d(KycActivity kycActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.common.b.e
        public void onAccountActivated(com.iqoption.app.b.b.a aVar) {
            String apM = KycActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IQAccountEvents.AccountIsActivated: ");
            stringBuilder.append(aVar);
            com.iqoption.core.i.d(apM, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    if (KycActivity.this.adF) {
                        KycActivity.this.aoZ();
                    }
                }
            });
        }
    }

    private static class e extends com.iqoption.system.c.b<KycActivity, KycState> {
        private final String cKc;

        public e(KycActivity kycActivity, String str) {
            super((Object) kycActivity);
            this.cKc = str;
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, KycState kycState) {
            super.z(kycActivity, kycState);
            kycActivity.cJI.b(kycState);
            kycActivity.apj();
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            com.iqoption.core.i.e(KycActivity.TAG, "unable to get kyc state", th);
            kycActivity.apj();
        }
    }

    private static class f extends com.iqoption.system.c.b<KycActivity, ProofDocsResult> {
        public f(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, ProofDocsResult proofDocsResult) {
            super.z(kycActivity, proofDocsResult);
            Fragment h = kycActivity.apJ();
            if (h instanceof com.iqoption.kyc.fragment.jumio.e) {
                com.iqoption.core.d.a.aSe.postDelayed(new q(h, proofDocsResult), 200);
            }
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            final Fragment h = kycActivity.apJ();
            if (h instanceof com.iqoption.kyc.fragment.jumio.e) {
                com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                    public void run() {
                        ((com.iqoption.kyc.fragment.jumio.e) h).dK(false);
                    }
                }, 200);
            }
            MobbErrorException.D(th);
        }
    }

    private static class g extends com.iqoption.system.c.b<KycActivity, KycQuestionsResult> {
        public g(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, KycQuestionsResult kycQuestionsResult) {
            super.z(kycActivity, kycQuestionsResult);
            kycActivity.dK(false);
            if (kycQuestionsResult.isSuccessful() && kycQuestionsResult.questionMap != null) {
                String apM = KycActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("questionMap=");
                stringBuilder.append(kycQuestionsResult.questionMap);
                com.iqoption.core.i.v(apM, stringBuilder.toString());
                kycActivity.cJG.questionMap = kycQuestionsResult.questionMap;
                kycActivity.cJG.cKk = Ordering.natural().sortedCopy(kycActivity.cJG.questionMap.keySet());
                kycActivity.fc(((Integer) com.google.common.base.e.h(com.google.common.collect.s.a(kycActivity.cJG.cKk, Integer.valueOf(0)), Integer.valueOf(0))).intValue());
            }
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            com.iqoption.core.i.e(KycActivity.TAG, th.toString(), th);
            kycActivity.dK(false);
            MobbErrorException.D(th);
        }
    }

    private static class h extends com.iqoption.system.c.b<KycActivity, com.iqoption.mobbtech.connect.response.l> {
        private final boolean cKg;
        private final long cKh;

        public h(KycActivity kycActivity, long j, boolean z) {
            super((Object) kycActivity);
            this.cKg = z;
            this.cKh = j;
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, com.iqoption.mobbtech.connect.response.l lVar) {
            super.z(kycActivity, lVar);
            String apM = KycActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RequestConfirmPhoneCodeCallback result: ");
            stringBuilder.append(lVar);
            com.iqoption.core.i.v(apM, stringBuilder.toString());
            if (kycActivity.cJI != null) {
                kycActivity.cJI.ac(this.cKh);
            }
            if (this.cKg) {
                kycActivity.b(com.iqoption.kyc.fragment.b.a.e(kycActivity.cJG.cJn), com.iqoption.kyc.fragment.b.a.TAG);
            }
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            com.iqoption.core.i.e(KycActivity.TAG, th.toString(), th);
            MobbErrorException.D(th);
        }
    }

    private static class i extends com.iqoption.system.c.b<KycActivity, Void> {
        public i(KycActivity kycActivity) {
            super(kycActivity, Void.class);
        }

        /* renamed from: b */
        public void z(@NonNull KycActivity kycActivity, @NonNull Void voidR) {
            super.z(kycActivity, voidR);
            kycActivity.dK(false);
            kycActivity.cJN = null;
            com.iqoption.core.i.d(KycActivity.TAG, "socket is restored");
        }

        /* renamed from: d */
        public void c(@NonNull KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            kycActivity.dK(false);
            kycActivity.cJN = null;
            com.iqoption.core.i.e(KycActivity.TAG, "socket is not restored", th);
            kycActivity.aoX();
        }
    }

    private static class k extends com.iqoption.system.c.b<KycActivity, Object> {
        private final Runnable cKp;

        public k(KycActivity kycActivity, Runnable runnable) {
            super(kycActivity, Object.class);
            this.cKp = runnable;
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, Object obj) {
            super.z(kycActivity, obj);
            String apM = KycActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SaveProfileCallback result: ");
            stringBuilder.append(obj);
            com.iqoption.core.i.v(apM, stringBuilder.toString());
            if (kycActivity.cJI != null) {
                com.iqoption.kyc.a.a.b((Context) kycActivity, true, null, kycActivity.cJI.Dh());
            }
            this.cKp.run();
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            com.iqoption.core.i.e(KycActivity.TAG, th.toString(), th);
            String D = MobbErrorException.D(th);
            if (kycActivity.cJI != null) {
                com.iqoption.kyc.a.a.b((Context) kycActivity, false, D, kycActivity.cJI.Dh());
            }
        }
    }

    private static class l extends com.iqoption.system.c.b<KycActivity, ProofDocsResult> {
        public l(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, ProofDocsResult proofDocsResult) {
            super.z(kycActivity, proofDocsResult);
            boolean z = false;
            kycActivity.dK(false);
            boolean ff = com.iqoption.app.managers.feature.b.HT().ff("close-kyc-docs");
            if (kycActivity.cJI == null || kycActivity.cJI.Dh()) {
                z = true;
            }
            kycActivity.b(com.iqoption.kyc.fragment.jumio.e.a(proofDocsResult, ff, z), com.iqoption.kyc.fragment.jumio.e.TAG);
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            MobbErrorException.D(th);
            kycActivity.aoX();
        }
    }

    private static class m extends com.iqoption.system.c.b<KycActivity, KycState> {
        public m(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, KycState kycState) {
            super.z(kycActivity, kycState);
            kycActivity.cJG.cJn = kycState;
            kycActivity.apg();
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            kycActivity.apg();
        }
    }

    private static class n extends com.iqoption.system.c.b<KycActivity, KycState> {
        public n(KycActivity kycActivity) {
            super((Object) kycActivity);
        }

        /* renamed from: a */
        public void z(KycActivity kycActivity, KycState kycState) {
            super.z(kycActivity, kycState);
            com.iqoption.app.a.aL((Context) kycActivity).a(kycState);
            kycActivity.aoX();
        }

        /* renamed from: d */
        public void c(KycActivity kycActivity, Throwable th) {
            super.c(kycActivity, th);
            kycActivity.aoX();
        }
    }

    private void aoZ() {
    }

    private boolean apa() {
        return false;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KycActivity.class.getName());
        stringBuilder.append(".ARG_KYC_STATE");
        cJA = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(KycActivity.class.getName());
        stringBuilder.append(".ARG_KYC_START_SCREEN_TAG");
        cJB = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(KycActivity.class.getName());
        stringBuilder.append(".ARG_KYC_SHOW_DEPOSIT_PAGE_WHEN_FINISH");
        cJC = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(KycActivity.class.getName());
        stringBuilder.append(".ARG_IS_CRYPTO_WITHDRAW");
        cJD = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(KycActivity.class.getName());
        stringBuilder.append(".ARG_IS_HIDE_SKIP");
        cJE = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(KycActivity.class.getName());
        stringBuilder.append(".ARG_RETURN_TO_PARENT");
        cJF = stringBuilder.toString();
    }

    public void a(@NonNull com.iqoption.view.e.a aVar) {
        this.aen.a(aVar);
    }

    public void b(@NonNull com.iqoption.view.e.a aVar) {
        this.aen.b(aVar);
    }

    @NonNull
    private static Intent a(Activity activity, @Nullable KycState kycState, @Nullable String str, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent(activity, KycActivity.class);
        Bundle bundle = new Bundle();
        if (kycState != null) {
            bundle.putParcelable(cJA, kycState);
        }
        if (str != null) {
            bundle.putString(cJB, str);
        }
        bundle.putBoolean(cJC, z);
        bundle.putBoolean(cJD, z2);
        bundle.putBoolean(cJE, z3);
        bundle.putBoolean(cJF, z4);
        intent.putExtras(bundle);
        return intent;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_kyc);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.cJL = extras.getString(cJB, "");
            this.cJM = extras.getBoolean(cJC);
            this.cJG.cJn = (KycState) extras.getParcelable(cJA);
            this.cJG.cJY = extras.getBoolean(cJD);
            this.cJG.cJZ = extras.getBoolean(cJE);
            this.cJG.cKa = extras.getBoolean(cJF);
        }
        FragmentManager.enableDebugLogging(false);
        this.cJI = new com.iqoption.kyc.c(this, this.cJG.cJn);
        this.cJJ = new com.iqoption.kyc.f(this);
        this.czX = findViewById(R.id.progress);
        if (bundle == null) {
            aoU();
        } else if (bundle.containsKey("KEY_KYC_RESTORED_VALUES")) {
            com.iqoption.core.i.d(TAG, "restore kyc state");
            this.cJG = (j) bundle.getParcelable("KEY_KYC_RESTORED_VALUES");
        }
    }

    private void aoU() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        boolean z = true;
        if (com.iqoption.kyc.fragment.jumio.e.TAG.equals(this.cJL)) {
            dK(true);
            ag.b(this.cJJ.g(null), new l(this));
        } else if (com.iqoption.kyc.fragment.jumio.d.TAG.equals(this.cJL)) {
            beginTransaction.replace(R.id.kycFrame, com.iqoption.kyc.fragment.jumio.d.aqh(), com.iqoption.kyc.fragment.jumio.d.TAG).commit();
        } else if (com.iqoption.kyc.fragment.b.TAG.equals(this.cJL)) {
            this.cJG.cKm = true;
            if (this.cJI.aoK() == 0) {
                this.cJG.cKn = true;
            } else {
                Feature fd = com.iqoption.app.managers.feature.b.HT().fd("kyc-show-after-registration");
                j jVar = this.cJG;
                if (fd == null || !"enabled-without-skip".equals(fd.status)) {
                    z = false;
                }
                jVar.cKn = z;
            }
            beginTransaction.replace(R.id.kycFrame, com.iqoption.kyc.fragment.b.dU(this.cJG.cKn), com.iqoption.kyc.fragment.b.TAG).commit();
        } else if (com.iqoption.kyc.fragment.b.c.TAG.equals(this.cJL)) {
            Pair dL = dL(false);
            if (((Boolean) dL.first).booleanValue()) {
                this.cJL = (String) dL.second;
            } else {
                com.iqoption.core.d.a.aSe.post(new a(this));
            }
        } else {
            beginTransaction.replace(R.id.kycFrame, com.iqoption.kyc.fragment.c.dV(this.cJG.cJZ), com.iqoption.kyc.fragment.c.TAG).commit();
        }
    }

    private void dK(boolean z) {
        this.czX.setVisibility(z ? 0 : 8);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("KEY_KYC_RESTORED_VALUES", this.cJG);
        super.onSaveInstanceState(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOptionsItemSelected, id=");
        stringBuilder.append(menuItem.getItemId());
        com.iqoption.core.i.v(str, stringBuilder.toString());
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        aoV();
        return true;
    }

    private void aoV() {
        aoY();
        am.n(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (ac.c(supportFragmentManager, this.cJL)) {
            aoX();
        } else if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStackImmediate();
            com.iqoption.core.i.c(getSupportFragmentManager());
        } else {
            this.cJM = false;
            aoX();
        }
    }

    public void aoW() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            supportFragmentManager.popBackStackImmediate();
        }
    }

    private void aoX() {
        Fragment s = ac.s(getSupportFragmentManager());
        if (!(s == null || !(s instanceof com.iqoption.kyc.a.b) || this.cJI == null)) {
            com.iqoption.kyc.a.b bVar = (com.iqoption.kyc.a.b) s;
            com.iqoption.kyc.a.a.a((Context) this, bVar.apR(), bVar.apS(), this.cJI.Dh());
        }
        if (this.cJG.cKa) {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this);
            Bundle extras = parentActivityIntent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(TradeRoomActivity.aea, true);
            extras.putBoolean(TradeRoomActivity.adY, true);
            extras.putBoolean(TradeRoomActivity.adZ, this.cJM);
            parentActivityIntent.putExtras(extras);
            if (NavUtils.shouldUpRecreateTask(this, parentActivityIntent) || isTaskRoot()) {
                com.iqoption.core.i.v(TAG, "create activity stack");
                com.iqoption.util.a.s(this);
                TaskStackBuilder.create(this).addNextIntentWithParentStack(parentActivityIntent).startActivities();
            } else {
                parentActivityIntent.setFlags(67108864);
                NavUtils.navigateUpTo(this, parentActivityIntent);
            }
            return;
        }
        finish();
    }

    public void onResume() {
        super.onResume();
        this.adF = true;
    }

    protected void onStart() {
        super.onStart();
        dK(true);
        ag.b(WebSocketHandler.aDm().bE(TAG), new i(this));
        this.cJH.register();
    }

    protected void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        PasscodeFragment.bn(this);
        this.cJH.unregister();
        this.adF = false;
    }

    protected void onDestroy() {
        FragmentManager.enableDebugLogging(false);
        super.onDestroy();
    }

    public void onBackPressed() {
        am.n(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (!this.aen.onBackPressed()) {
            if ((!this.cJG.cKn || !ac.c(supportFragmentManager, com.iqoption.kyc.fragment.b.TAG)) && !ac.c(supportFragmentManager, com.iqoption.kyc.fragment.e.a.h.TAG) && !ac.c(supportFragmentManager, com.iqoption.kyc.fragment.e.a.a.TAG) && !ac.c(supportFragmentManager, com.iqoption.kyc.fragment.e.a.e.TAG) && !ac.c(supportFragmentManager, com.iqoption.kyc.fragment.e.a.l.TAG) && !ac.c(supportFragmentManager, com.iqoption.kyc.fragment.e.a.m.TAG)) {
                aoY();
                if (ac.c(supportFragmentManager, this.cJL)) {
                    this.cJM = false;
                    aoX();
                    return;
                }
                if (supportFragmentManager.getBackStackEntryCount() > 0) {
                    supportFragmentManager.popBackStackImmediate();
                } else {
                    this.cJM = false;
                    aoX();
                }
            }
        }
    }

    private void b(Fragment fragment, String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment s = ac.s(supportFragmentManager);
        if (s != null && (s instanceof com.iqoption.kyc.a.b) && (fragment instanceof com.iqoption.kyc.a.b)) {
            com.iqoption.kyc.a.b bVar = (com.iqoption.kyc.a.b) s;
            if (bVar.apT()) {
                com.iqoption.kyc.a.a.b((Context) this, bVar.apR(), bVar.apS(), ((com.iqoption.kyc.a.b) fragment).apS(), this.cJI.Dh());
            }
        }
        am.n(this);
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_right_short, R.anim.alpha_out_short, R.anim.alpha_in_short, R.anim.slide_out_right_short).replace(R.id.kycFrame, fragment, str).addToBackStack(str).commitAllowingStateLoss();
    }

    private void aoY() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment s = ac.s(supportFragmentManager);
        Fragment t = ac.t(supportFragmentManager);
        if (s instanceof com.iqoption.kyc.a.b) {
            String apS = t instanceof com.iqoption.kyc.a.b ? ((com.iqoption.kyc.a.b) t).apS() : t == null ? "Traderoom" : "";
            com.iqoption.kyc.a.b bVar = (com.iqoption.kyc.a.b) s;
            com.iqoption.kyc.a.a.a((Context) this, bVar.apR(), bVar.apS(), apS, this.cJI.Dh());
        }
    }

    private Pair<Boolean, String> dL(boolean z) {
        if (z && this.cJI.aoA()) {
            return Pair.create(Boolean.valueOf(false), null);
        }
        if (this.cJI.De() || this.cJG.cKm) {
            return Pair.create(Boolean.valueOf(false), null);
        }
        Object obj;
        if (this.cJI.aoE()) {
            obj = com.iqoption.kyc.fragment.b.c.TAG;
            b(com.iqoption.kyc.fragment.b.c.g(this.cJG.cJn), com.iqoption.kyc.fragment.b.c.TAG);
        } else {
            obj = com.iqoption.kyc.fragment.b.a.TAG;
            b(com.iqoption.kyc.fragment.b.a.e(this.cJG.cJn), com.iqoption.kyc.fragment.b.a.TAG);
        }
        return Pair.create(Boolean.valueOf(true), obj);
    }

    private boolean apb() {
        if (this.cJI.aoJ()) {
            return false;
        }
        b(com.iqoption.kyc.fragment.c.e.d(this.cJG.cJn, this.cJG.cKi), com.iqoption.kyc.fragment.c.e.TAG);
        return true;
    }

    private boolean apc() {
        boolean Dh = this.cJI.Dh();
        if ((!Dh || this.cJG.cKm) && (Dh || !this.cJG.cJY)) {
            return false;
        }
        if (this.cJI.aoI()) {
            b(com.iqoption.kyc.fragment.jumio.e.a(null, com.iqoption.app.managers.feature.b.HT().ff("close-kyc-docs"), Dh), com.iqoption.kyc.fragment.jumio.e.TAG);
            ag.b(this.cJJ.g(null), new f(this));
        } else {
            b(com.iqoption.kyc.fragment.jumio.d.aqh(), com.iqoption.kyc.fragment.jumio.d.TAG);
        }
        return true;
    }

    private boolean apd() {
        if (com.iqoption.app.managers.feature.b.HT().ff("DEPRECATED-kyc-questionnaire-microservice") || !this.cJI.Dh() || this.cJI.aoJ()) {
            return false;
        }
        com.iqoption.core.i.v(TAG, "open trading experience, question request...");
        dK(true);
        o.a(this.cJJ.aoQ(), new g(this), com.iqoption.core.d.a.aSe);
        return true;
    }

    private boolean ape() {
        if (!com.iqoption.app.managers.feature.b.HT().ff("DEPRECATED-kyc-questionnaire-microservice") || !this.cJI.Dh() || this.cJI.aoJ()) {
            return false;
        }
        com.iqoption.core.i.v(TAG, "open trading experience, question request via ms...");
        dK(true);
        ag.a(ag.a(ag.a(com.iqoption.microservice.a.a.a.cRa.asd(), b.ari), i.ari), (Object) this, j.cgR, k.cgS, com.iqoption.core.d.a.aSe);
        return true;
    }

    static final /* synthetic */ s aL(List list) {
        com.google.common.collect.i c = com.google.common.collect.i.c((Iterable) list).c(Predicates.a(e.$instance, f.$instance)).b(g.$instance).c(Predicates.pS());
        com.iqoption.microservice.a.a.a aVar = com.iqoption.microservice.a.a.a.cRa;
        aVar.getClass();
        return o.E(c.b(h.a(aVar)).sA());
    }

    static final /* synthetic */ s aK(List list) {
        List<com.iqoption.microservice.a.a.a.c> sortedCopy = com.iqoption.microservice.a.a.a.b.cRt.aso().sortedCopy(list);
        for (com.iqoption.microservice.a.a.a.c ass : sortedCopy) {
            for (com.iqoption.microservice.a.a.a.e asA : ass.ass()) {
                Collections.sort(asA.asA(), com.iqoption.microservice.a.a.a.b.cRt.asq());
            }
        }
        return o.aR(sortedCopy);
    }

    static final /* synthetic */ void c(KycActivity kycActivity, Throwable th) {
        com.iqoption.core.i.e(TAG, th.toString(), th);
        kycActivity.dK(false);
        MobbErrorException.D(th);
    }

    private void apf() {
        com.iqoption.microservice.a.a.b bVar = this.cJG.cKj;
        if (bVar.asi()) {
            a(bVar.asj(), bVar.asg());
            return;
        }
        s ase = com.iqoption.microservice.a.a.a.cRa.ase();
        dK(true);
        ag.a(ase, (Object) this, new l(this), m.cgS, com.iqoption.core.d.a.aSe);
    }

    public void a(int i, com.iqoption.microservice.a.a.a.e eVar, List<Integer> list) {
        com.google.common.base.i.checkNotNull(this.cJG.cKj);
        com.iqoption.microservice.a.a.b bVar = this.cJG.cKj;
        bVar.b(i, eVar, list);
        if (bVar.ash()) {
            s b = com.iqoption.microservice.a.a.a.cRa.b(i, com.google.common.collect.i.c(bVar.asf().entrySet()).b(n.$instance).sA());
            dK(true);
            ag.a(b, (Object) this, o.cgR, p.cgS, com.iqoption.core.d.a.aSe);
            return;
        }
        apf();
    }

    @NonNull
    private s<? extends com.iqoption.mobbtech.connect.response.l> a(int i, long j, boolean z) {
        if (this.cJJ == null) {
            return o.vT();
        }
        Pair a = this.cJJ.a(i, j, this.cJG.cJn);
        o.a((s) a.first, new h(this, ((Long) a.second).longValue(), z), com.iqoption.core.d.a.aSe);
        return (s) a.first;
    }

    private s<List<Object>> fb(final int i) {
        s auv = com.iqoption.mobbtech.connect.request.api.e.auv();
        s by = com.iqoption.mobbtech.connect.request.api.d.by(this.cJI.d(this.cJG.cKi));
        s[] sVarArr = new s[]{auv, by};
        return o.a(o.a(o.a(sVarArr), new com.google.common.util.concurrent.g<List<Object>, NetverifyToken>() {
            /* renamed from: aG */
            public s<NetverifyToken> aP(List<Object> list) {
                KycActivity.this.cJG.cKl = (NetverifyConfig) list.get(0);
                Country country = (Country) list.get(1);
                String apM = KycActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("netFerifyConfig: ");
                stringBuilder.append(KycActivity.this.cJG.cKl);
                com.iqoption.core.i.d(apM, stringBuilder.toString());
                apM = KycActivity.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("country: ");
                stringBuilder.append(country);
                com.iqoption.core.i.d(apM, stringBuilder.toString());
                return com.iqoption.mobbtech.connect.request.api.e.b(i, KycActivity.this.cJI.getUserId(), KycActivity.this.cJI.aoH());
            }
        }), by);
    }

    private void apg() {
        if (this.cJI != null && !apa() && !apb() && !apc() && !((Boolean) dL(true).first).booleanValue()) {
            apj();
        }
    }

    private int aph() {
        if (this.cJG.cKo) {
            return 1;
        }
        return this.cJM ? 2 : 0;
    }

    private void apj() {
        boolean Dh = this.cJI.Dh();
        if (Dh && !Boolean.TRUE.equals(com.iqoption.app.a.aL((Context) this).CS().Vu()) && com.iqoption.gdpr.a.bt(this)) {
            b(com.iqoption.kyc.fragment.gdpr.a.aqd(), com.iqoption.kyc.fragment.gdpr.a.TAG);
        } else {
            apk();
        }
        com.iqoption.mobbtech.connect.response.a.a ava = com.iqoption.mobbtech.connect.response.a.a.ava();
        if (ava.ef(Dh ^ 1)) {
            ava.restart();
        }
    }

    public void apk() {
        b(com.iqoption.kyc.fragment.a.a.l(aph(), this.cJI.Dh()), com.iqoption.kyc.fragment.a.a.TAG);
    }

    public s<? extends com.iqoption.mobbtech.connect.response.l> v(int i, long j) {
        com.iqoption.core.i.v(TAG, "onPhoneContinue");
        return a(i, j, true);
    }

    public s<? extends com.iqoption.mobbtech.connect.response.l> apl() {
        com.iqoption.core.i.v(TAG, "onPhoneConfirmResend");
        PhoneNumber aoB = this.cJI != null ? this.cJI.aoB() : null;
        if (aoB == null) {
            return o.vT();
        }
        return a(aoB.xE(), aoB.ye(), false);
    }

    public s<? extends com.iqoption.mobbtech.connect.response.l> hZ(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPhoneConfirmContinue, confirmCode: ");
        stringBuilder.append(str);
        com.iqoption.core.i.v(str2, stringBuilder.toString());
        if (this.cJJ == null) {
            return o.vT();
        }
        s<? extends com.iqoption.mobbtech.connect.response.l> hY = this.cJJ.hY(str);
        o.a(hY, new b(this), com.iqoption.core.d.a.aSe);
        return hY;
    }

    public void apm() {
        com.iqoption.core.i.v(TAG, "onPhoneConfirmSkip");
        this.cJM = false;
        this.cJJ.aoS();
        apj();
    }

    public void apn() {
        com.iqoption.core.i.v(TAG, "onPhoneConfirmedContinue");
        apj();
    }

    public void ai(String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLegalNameContinue firstName=");
        stringBuilder.append(str);
        stringBuilder.append(", lastName=");
        stringBuilder.append(str2);
        com.iqoption.core.i.v(str3, stringBuilder.toString());
        this.cJG.cKi.firstName = str;
        this.cJG.cKi.lastName = str2;
        b(com.iqoption.kyc.fragment.c.f.k(this.cJG.cKi), com.iqoption.kyc.fragment.c.f.TAG);
    }

    public void dM(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSexContinue, isMale=");
        stringBuilder.append(z);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        this.cJG.cKi.cJr = Boolean.valueOf(z);
        if (getFragmentManager().findFragmentByTag(com.iqoption.kyc.fragment.c.d.TAG) == null) {
            b(com.iqoption.kyc.fragment.c.d.c(this.cJG.cJn, this.cJG.cKi), com.iqoption.kyc.fragment.c.d.TAG);
        }
    }

    public void b(Date date) {
        boolean z;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDateOfBirthDayContinue, birthDay=");
        stringBuilder.append(date);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        this.cJG.cKi.cJq = date;
        if (com.iqoption.kyc.a.aoz()) {
            z = false;
        } else {
            this.cJG.cKi.cJs = Long.valueOf(com.iqoption.app.a.Cw().Db());
            z = true;
        }
        b(com.iqoption.kyc.fragment.c.c.a(this.cJG.cJn, this.cJG.cKi, z), com.iqoption.kyc.fragment.c.c.dX(z));
    }

    public void a(Country country, boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCountryContinue, isCitizenshipCountry=");
        stringBuilder.append(z);
        stringBuilder.append(", country=");
        stringBuilder.append(country);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        if (z) {
            this.cJG.cKi.cJs = country.id;
            this.cJG.cKi.cJt = country.id;
            this.cJG.cKi.nationality = country.name;
            b(com.iqoption.kyc.fragment.c.b.b(this.cJG.cJn, this.cJG.cKi), com.iqoption.kyc.fragment.c.b.TAG);
            return;
        }
        this.cJG.cKi.cJs = country.id;
        b(com.iqoption.kyc.fragment.c.c.a(this.cJG.cJn, this.cJG.cKi, true), com.iqoption.kyc.fragment.c.c.dX(true));
    }

    public void b(Country country) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCitizenshipCountryContinue, country=");
        stringBuilder.append(country);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        this.cJG.cKi.cJt = country.id;
        this.cJG.cKi.nationality = country.name;
        b(com.iqoption.kyc.fragment.c.b.b(this.cJG.cJn, this.cJG.cKi), com.iqoption.kyc.fragment.c.b.TAG);
    }

    public void aj(String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCityContinue, city=");
        stringBuilder.append(str);
        stringBuilder.append(", postalCode=");
        stringBuilder.append(str2);
        com.iqoption.core.i.v(str3, stringBuilder.toString());
        this.cJG.cKi.city = str;
        this.cJG.cKi.cJu = str2;
        b(com.iqoption.kyc.fragment.c.a.a(this.cJG.cJn, this.cJG.cKi), com.iqoption.kyc.fragment.c.a.TAG);
    }

    public s<? extends com.iqoption.mobbtech.connect.response.l> ak(String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCountryContinue, addressLine1=");
        stringBuilder.append(str);
        stringBuilder.append(", addressLine2=");
        stringBuilder.append(str2);
        com.iqoption.core.i.v(str3, stringBuilder.toString());
        com.iqoption.kyc.e f = this.cJG.cKi;
        if (!TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                str = str2;
            } else {
                str = Joiner.on(", ").join(str, str2, new Object[0]);
            }
        }
        f.address = str;
        b(com.iqoption.kyc.fragment.f.b.l(this.cJG.cKi), com.iqoption.kyc.fragment.f.b.TAG);
        return o.aR(null);
    }

    public s<?> dN(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onReportableContinue, isReportable=");
        stringBuilder.append(z);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        if (this.cJJ != null) {
            this.cJJ.dJ(z);
        }
        if (z) {
            b(com.iqoption.kyc.fragment.f.a.ea(false), com.iqoption.kyc.fragment.f.a.TAG);
            return o.aR(null);
        }
        s j = this.cJJ.j(this.cJG.cKi);
        o.a(o.a(o.a(j, new com.google.common.util.concurrent.g<com.iqoption.mobbtech.connect.response.j, KycState>() {
            /* renamed from: a */
            public s<KycState> aP(com.iqoption.mobbtech.connect.response.j jVar) {
                return KycActivity.this.cJJ.aoR();
            }
        }), new com.google.common.base.d<KycState, KycState>() {
            /* renamed from: c */
            public KycState apply(KycState kycState) {
                String apM = KycActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("profile is saved. isRegulatedUser=");
                stringBuilder.append(kycState.isRegulatedUser);
                com.iqoption.core.i.d(apM, stringBuilder.toString());
                com.iqoption.app.a.aL(KycActivity.this).aL(kycState.isRegulatedUser.booleanValue());
                com.iqoption.app.a.aL(KycActivity.this).akD = kycState.isProfileFilled.booleanValue();
                return kycState;
            }
        }), new k(this, new Runnable() {
            public void run() {
                boolean z = KycActivity.this.cJI != null && KycActivity.this.cJI.Dh();
                String apM = KycActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isRegulated=");
                stringBuilder.append(z);
                stringBuilder.append(", countryId=");
                stringBuilder.append(KycActivity.this.cJG.cKi.cJs);
                com.iqoption.core.i.v(apM, stringBuilder.toString());
                if (!KycActivity.this.apd() && !KycActivity.this.ape() && !KycActivity.this.apc() && !((Boolean) KycActivity.this.dL(true).first).booleanValue()) {
                    KycActivity.this.apj();
                }
            }
        }), com.iqoption.core.d.a.aSe);
        return j;
    }

    public void apo() {
        com.iqoption.core.i.v(TAG, "onReportableErrorContactSupport");
        b(MenuFragment.ahz(), MenuFragment.TAG);
    }

    public void app() {
        com.iqoption.core.i.v(TAG, "onReportableErrorMadeMistake");
    }

    private int aw(int i, int i2) {
        return ((Integer) com.google.common.base.e.h(((Answer) ((Question) this.cJG.questionMap.get(Integer.valueOf(i))).answers.get(Integer.valueOf(i2))).nextQuestion, Integer.valueOf(0))).intValue();
    }

    private void fc(int i) {
        if (this.cJG.questionMap != null) {
            if (i != 0) {
                Question question = (Question) this.cJG.questionMap.get(Integer.valueOf(i));
                if (!question.isMultipleChoiceAllowed.booleanValue() && question.answers.size() == 2) {
                    this.cJG.cKi.cJv.Q(Integer.valueOf(i));
                    Iterable sortedCopy = Ordering.natural().sortedCopy(question.answers.keySet());
                    int intValue = ((Integer) com.google.common.base.e.h(com.google.common.collect.s.a(sortedCopy, Integer.valueOf(0)), Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) com.google.common.base.e.h(com.google.common.collect.s.u(sortedCopy), Integer.valueOf(0))).intValue();
                    String str = (String) com.google.common.base.e.h(((Answer) question.answers.get(Integer.valueOf(intValue))).name, "");
                    String str2 = (String) com.google.common.base.e.h(((Answer) question.answers.get(Integer.valueOf(intValue2))).name, "");
                    if (str.length() > 15 || str2.length() > 15) {
                        b(com.iqoption.kyc.fragment.d.b.a(i, question.name, question.answers), com.iqoption.kyc.fragment.d.b.TAG);
                    } else {
                        b(com.iqoption.kyc.fragment.d.c.a(i, intValue, intValue2, question.name, str, str2), com.iqoption.kyc.fragment.d.c.TAG);
                    }
                } else if (question.isMultipleChoiceAllowed.booleanValue()) {
                    this.cJG.cKi.cJv.Q(Integer.valueOf(i));
                    b(com.iqoption.kyc.fragment.d.a.a(this.cJG.cJn, i, question.name, question.answers), com.iqoption.kyc.fragment.d.a.TAG);
                } else {
                    this.cJG.cKi.cJv.Q(Integer.valueOf(i));
                    b(com.iqoption.kyc.fragment.d.b.a(i, question.name, question.answers), com.iqoption.kyc.fragment.d.b.TAG);
                }
            } else if (this.cJI == null || !this.cJI.i(this.cJG.cKi)) {
                this.cJJ.j(this.cJG.cKi);
                if (!apc()) {
                    apj();
                }
            } else {
                b(com.iqoption.kyc.fragment.d.e.aqw(), com.iqoption.kyc.fragment.d.e.TAG);
            }
        }
    }

    private void a(com.iqoption.microservice.a.a.a.e eVar, Integer num) {
        if (!eVar.asw() && eVar.asA() != null && eVar.asA().size() == 2) {
            com.iqoption.microservice.a.a.a.a aVar = (com.iqoption.microservice.a.a.a.a) eVar.asA().get(1);
            Object gW = LocalizationUtil.gW(((com.iqoption.microservice.a.a.a.a) eVar.asA().get(0)).asm());
            Object gW2 = LocalizationUtil.gW(aVar.asm());
            if (!TextUtils.isEmpty(gW) && !TextUtils.isEmpty(gW2)) {
                if (gW.length() > 15 || gW2.length() > 15) {
                    b(com.iqoption.kyc.fragment.e.a.e.b(num, eVar), com.iqoption.kyc.fragment.e.a.e.TAG);
                } else {
                    b(com.iqoption.kyc.fragment.e.a.h.c(num, eVar), com.iqoption.kyc.fragment.e.a.h.TAG);
                }
            }
        } else if (eVar.asw()) {
            b(com.iqoption.kyc.fragment.e.a.a.a(num, eVar), com.iqoption.kyc.fragment.e.a.a.TAG);
        } else {
            b(com.iqoption.kyc.fragment.e.a.e.b(num, eVar), com.iqoption.kyc.fragment.e.a.e.TAG);
        }
    }

    public void a(int i, String str, int i2, String str2, com.iqoption.kyc.a.b bVar) {
        com.iqoption.kyc.a.a.a(this, bVar.apR(), bVar.apS(), str, i, ImmutableList.af(Integer.valueOf(i2)), ImmutableList.af(str2));
        this.cJG.cKi.cJv.Q(Integer.valueOf(i));
        this.cJG.cKi.cJv.j(Integer.valueOf(i), Integer.valueOf(i2));
        fc(aw(i, i2));
    }

    public void b(int i, String str, int i2, String str2, com.iqoption.kyc.a.b bVar) {
        a(i, str, i2, str2, bVar);
    }

    public void a(int i, String str, Collection<Integer> collection, HashMap<Integer, Answer> hashMap, com.iqoption.kyc.a.b bVar) {
        com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
        for (Integer num : collection) {
            sO.ae(((Answer) hashMap.get(num)).name);
        }
        com.iqoption.kyc.a.a.a(this, bVar.apR(), bVar.apS(), str, i, ImmutableList.m(collection), sO.sP());
        this.cJG.cKi.cJv.Q(Integer.valueOf(i));
        this.cJG.cKi.cJv.a(Integer.valueOf(i), collection);
        fc(aw(i, ((Integer) com.google.common.collect.s.a((Iterable) collection, Integer.valueOf(0))).intValue()));
    }

    public void a(int i, com.iqoption.microservice.a.a.a.e eVar, int i2, com.iqoption.kyc.a.b bVar) {
        a(i, eVar, ImmutableList.af(Integer.valueOf(i2)));
    }

    public void b(int i, com.iqoption.microservice.a.a.a.e eVar, int i2, com.iqoption.kyc.a.b bVar) {
        a(i, eVar, ImmutableList.af(Integer.valueOf(i2)));
    }

    public void a(int i, com.iqoption.microservice.a.a.a.e eVar, List<Integer> list, com.iqoption.kyc.a.b bVar) {
        a(i, eVar, (List) list);
    }

    public s<? extends com.iqoption.mobbtech.connect.response.l> apq() {
        com.iqoption.core.i.v(TAG, "onQuestionWarningUnderstood");
        s<? extends com.iqoption.mobbtech.connect.response.l> j = this.cJJ.j(this.cJG.cKi);
        o.a(j, new k(this, new Runnable() {
            public void run() {
                if (!KycActivity.this.apc() && !((Boolean) KycActivity.this.dL(true).first).booleanValue()) {
                    KycActivity.this.apj();
                }
            }
        }), com.iqoption.core.d.a.aSe);
        return j;
    }

    public s<? extends com.iqoption.mobbtech.connect.response.l> ia(@Nullable String str) {
        com.iqoption.core.i.v(TAG, "onQuestionWarningUnderstood");
        s h = com.iqoption.microservice.a.a.a.cRa.h(true, str);
        o.a(h, new k(this, new c(this)), com.iqoption.core.d.a.aSe);
        return ag.a(h, new d(this));
    }

    final /* synthetic */ void apK() {
        aoW();
        if (!apc() && !((Boolean) dL(true).first).booleanValue()) {
            apj();
        }
    }

    public void apr() {
        com.iqoption.core.i.v(TAG, "onQuestionWarningRiskDisclosure");
        b(com.iqoption.kyc.fragment.d.d.h(this.cJG.cJn), com.iqoption.kyc.fragment.d.d.TAG);
    }

    public void aps() {
        apk();
    }

    public s<?> apt() {
        com.iqoption.core.i.v(TAG, "onFinishStartTrading");
        s aoR = this.cJJ.aoR();
        o.a(aoR, new n(this));
        return aoR;
    }

    public s<?> apu() {
        s<?> g = this.cJJ.g(null);
        o.a(g, new c(this), com.iqoption.core.d.a.aSe);
        return g;
    }

    public s<?> apv() {
        s<?> a = o.a(this.cJJ.aoT(), new com.google.common.util.concurrent.g<com.iqoption.mobbtech.connect.response.l, KycState>() {
            /* renamed from: a */
            public s<KycState> aP(com.iqoption.mobbtech.connect.response.l lVar) {
                return KycActivity.this.cJJ.aoR();
            }
        });
        o.a(a, new e(this, com.iqoption.kyc.fragment.jumio.d.TAG), com.iqoption.core.d.a.aSe);
        return a;
    }

    public s<?> apw() {
        s<?> fb = fb(com.iqoption.mobbtech.connect.request.api.e.cUL);
        o.a(fb, new com.iqoption.system.c.b<KycActivity, List<Object>>(this) {
            /* renamed from: b */
            public void z(KycActivity kycActivity, List<Object> list) {
                super.z(kycActivity, list);
                NetverifyToken netverifyToken = (NetverifyToken) list.get(0);
                NetverifyConfigData decrypt = KycActivity.this.cJG.cKl.decrypt();
                String apM = KycActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("netVerifyConfigData: ");
                stringBuilder.append(decrypt);
                com.iqoption.core.i.d(apM, stringBuilder.toString());
                apM = KycActivity.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("netVerifyToken: ");
                stringBuilder.append(netverifyToken);
                com.iqoption.core.i.d(apM, stringBuilder.toString());
                KycActivity.this.b(com.iqoption.kyc.fragment.jumio.h.a(decrypt.token, decrypt.secret, decrypt.callback, netverifyToken.merchantScanReference, Long.valueOf(KycActivity.this.cJI.getUserId())), com.iqoption.kyc.fragment.jumio.h.TAG);
            }

            /* renamed from: d */
            public void c(KycActivity kycActivity, Throwable th) {
                super.c(kycActivity, th);
                com.iqoption.core.i.e(KycActivity.TAG, "error token request", th);
                MobbErrorException.D(th);
            }
        }, com.iqoption.core.d.a.aSe);
        return fb;
    }

    public s<?> apx() {
        b(com.iqoption.kyc.fragment.jumio.c.aqf(), com.iqoption.kyc.fragment.jumio.c.TAG);
        return o.aR(null);
    }

    public s<?> apy() {
        s<?> g = this.cJJ.g(null);
        o.a(g, new com.iqoption.system.c.b<KycActivity, ProofDocsResult>(this) {
            /* renamed from: a */
            public void z(KycActivity kycActivity, ProofDocsResult proofDocsResult) {
                super.z(kycActivity, proofDocsResult);
                KycActivity.this.b(com.iqoption.kyc.fragment.jumio.f.c(proofDocsResult), com.iqoption.kyc.fragment.jumio.f.TAG);
            }

            /* renamed from: d */
            public void c(KycActivity kycActivity, Throwable th) {
                super.c(kycActivity, th);
                MobbErrorException.D(th);
            }
        }, com.iqoption.core.d.a.aSe);
        return g;
    }

    public s<?> apz() {
        s<?> g = this.cJJ.g(null);
        o.a(g, new com.iqoption.system.c.b<KycActivity, ProofDocsResult>(this) {
            /* renamed from: a */
            public void z(KycActivity kycActivity, ProofDocsResult proofDocsResult) {
                super.z(kycActivity, proofDocsResult);
                KycActivity.this.b(com.iqoption.kyc.fragment.jumio.b.a(proofDocsResult), com.iqoption.kyc.fragment.jumio.b.TAG);
            }

            /* renamed from: d */
            public void c(KycActivity kycActivity, Throwable th) {
                super.c(kycActivity, th);
                MobbErrorException.D(th);
            }
        }, com.iqoption.core.d.a.aSe);
        return g;
    }

    public s<?> apA() {
        return apv();
    }

    public s<?> apB() {
        s<?> a = o.a(this.cJJ.aoT(), new com.google.common.util.concurrent.g<com.iqoption.mobbtech.connect.response.l, KycState>() {
            /* renamed from: a */
            public s<KycState> aP(com.iqoption.mobbtech.connect.response.l lVar) {
                return KycActivity.this.cJJ.aoR();
            }
        });
        o.a(a, new e(this, com.iqoption.kyc.fragment.jumio.e.TAG), com.iqoption.core.d.a.aSe);
        return a;
    }

    public void apC() {
        b(com.iqoption.kyc.fragment.jumio.a.dW(this.cJI.Dh()), com.iqoption.kyc.fragment.jumio.a.TAG);
    }

    public s<?> ib(final String str) {
        s<?> fb = fb(com.iqoption.mobbtech.connect.request.api.e.cUM);
        o.a(fb, new com.iqoption.system.c.b<KycActivity, List<Object>>(this) {
            /* renamed from: b */
            public void z(KycActivity kycActivity, List<Object> list) {
                super.z(kycActivity, list);
                try {
                    NetverifyToken netverifyToken = (NetverifyToken) list.get(0);
                    String str = ((Country) list.get(1)).nameIso;
                    NetverifyConfigData decrypt = KycActivity.this.cJG.cKl.decrypt();
                    String apM = KycActivity.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("netVerifyConfigData: ");
                    stringBuilder.append(decrypt);
                    com.iqoption.core.i.d(apM, stringBuilder.toString());
                    apM = KycActivity.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("netVerifyToken: ");
                    stringBuilder.append(netverifyToken);
                    com.iqoption.core.i.d(apM, stringBuilder.toString());
                    apM = KycActivity.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("isoCountry: ");
                    stringBuilder.append(str);
                    com.iqoption.core.i.d(apM, stringBuilder.toString());
                    if (decrypt != null) {
                        KycActivity.this.b(com.iqoption.kyc.fragment.jumio.g.a(decrypt.token, decrypt.secret, decrypt.callback, str, str, netverifyToken.merchantScanReference, Long.valueOf(KycActivity.this.cJI.getUserId())), com.iqoption.kyc.fragment.jumio.g.TAG);
                    } else {
                        com.iqoption.core.i.e(KycActivity.TAG, "netVerifyConfigData is null");
                    }
                } catch (Throwable e) {
                    com.iqoption.core.i.e(KycActivity.TAG, "token and country request error", e);
                }
            }

            /* renamed from: d */
            public void c(KycActivity kycActivity, Throwable th) {
                super.c(kycActivity, th);
                MobbErrorException.D(th);
            }
        }, com.iqoption.core.d.a.aSe);
        return fb;
    }

    public void a(String str, String str2, boolean z, int i) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onNetverifyResult scanReference=");
        stringBuilder.append(str2);
        com.iqoption.core.i.d(str3, stringBuilder.toString());
        a(str, str2, z, i, true);
    }

    private void a(String str, String str2, final boolean z, int i, final boolean z2) {
        getSupportFragmentManager().b(com.iqoption.kyc.fragment.jumio.e.TAG, 0);
        final Fragment apJ = apJ();
        if (apJ instanceof com.iqoption.kyc.fragment.jumio.e) {
            com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                public void run() {
                    ((com.iqoption.kyc.fragment.jumio.e) apJ).f(true, z2);
                }
            }, 200);
        }
        o.a(o.a(o.a(com.iqoption.mobbtech.connect.request.api.e.c(str, str2, z, i), new com.google.common.util.concurrent.g<NetverifyUploadStatus, NetverifyUploadStatus>() {
            /* renamed from: a */
            public s<NetverifyUploadStatus> aP(NetverifyUploadStatus netverifyUploadStatus) {
                return ag.a((Object) netverifyUploadStatus, z ? 0 : 6000, TimeUnit.MILLISECONDS);
            }
        }), new com.google.common.util.concurrent.g<NetverifyUploadStatus, ProofDocsResult>() {
            /* renamed from: a */
            public s<ProofDocsResult> aP(NetverifyUploadStatus netverifyUploadStatus) {
                if (netverifyUploadStatus.isSuccessful()) {
                    com.iqoption.microservice.a.a.asa();
                    return KycActivity.this.cJJ.g(null);
                }
                Object message = netverifyUploadStatus.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    com.iqoption.app.a.b.b(message, KycActivity.this);
                }
                return o.vT();
            }
        }), new com.iqoption.system.c.b<KycActivity, ProofDocsResult>(this) {
            /* renamed from: a */
            public void z(KycActivity kycActivity, final ProofDocsResult proofDocsResult) {
                super.z(kycActivity, proofDocsResult);
                String apM = KycActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("proofDocsResult: ");
                stringBuilder.append(proofDocsResult);
                com.iqoption.core.i.d(apM, stringBuilder.toString());
                final Fragment h = KycActivity.this.apJ();
                if (h instanceof com.iqoption.kyc.fragment.jumio.e) {
                    com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                        public void run() {
                            com.iqoption.kyc.fragment.jumio.e eVar = (com.iqoption.kyc.fragment.jumio.e) h;
                            eVar.f(false, z2);
                            eVar.b(proofDocsResult);
                        }
                    }, 200);
                    j a = KycActivity.this.cJG;
                    boolean z = (proofDocsResult.isVerified(1) || proofDocsResult.isUnderReview(1)) && (proofDocsResult.isVerified(2) || proofDocsResult.isUnderReview(2));
                    a.cKo = z;
                    if (KycActivity.this.cJG.cKo && !((Boolean) KycActivity.this.dL(true).first).booleanValue()) {
                        KycActivity.this.apj();
                    }
                }
            }

            /* renamed from: d */
            public void c(KycActivity kycActivity, Throwable th) {
                super.c(kycActivity, th);
                MobbErrorException.D(th);
                final Fragment h = KycActivity.this.apJ();
                if (h instanceof com.iqoption.kyc.fragment.jumio.e) {
                    com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                        public void run() {
                            ((com.iqoption.kyc.fragment.jumio.e) h).f(false, z2);
                        }
                    }, 200);
                }
            }
        }, com.iqoption.core.d.a.aSe);
    }

    public void b(String str, String str2, boolean z, int i) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onMultiDocumentResult scanReference=");
        stringBuilder.append(str2);
        com.iqoption.core.i.d(str3, stringBuilder.toString());
        a(str, str2, z, i, false);
    }

    public s<?> apD() {
        return apw();
    }

    public s<?> apE() {
        return apx();
    }

    public s<?> apF() {
        s<?> aoR = this.cJJ.aoR();
        ag.b(aoR, new m(this));
        return aoR;
    }

    public void apG() {
        this.cJM = false;
        aoX();
    }

    public s<?> apH() {
        s<?> aoR = this.cJJ.aoR();
        ag.b(aoR, new m(this));
        return aoR;
    }

    public void apI() {
        this.cJM = false;
        aoX();
    }

    public void a(MobileSDK mobileSDK, int i) {
        if (MobileSDK.hasAllRequiredPermissions(this)) {
            a(mobileSDK);
            return;
        }
        this.cJK = mobileSDK;
        ActivityCompat.requestPermissions(this, MobileSDK.getMissingPermissions(this), i);
    }

    private void a(MobileSDK mobileSDK) {
        try {
            com.iqoption.kyc.a.a.e(this, true);
            mobileSDK.start();
        } catch (MissingPermissionException e) {
            com.iqoption.app.a.b.b(e.getMessage(), this);
            com.iqoption.kyc.a.a.a((Context) this, false, e.getMessage(), true);
            com.iqoption.kyc.a.a.a(this, e.getMessage(), true);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment apJ = apJ();
        if (apJ instanceof com.iqoption.kyc.b) {
            ((com.iqoption.kyc.b) apJ).d(i, i2, intent);
        }
    }

    @Nullable
    private Fragment apJ() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        return supportFragmentManager.getBackStackEntryCount() > 0 ? supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName()) : null;
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == MobileEvents.EVENTTYPE_ANDROID_LIFECYCLE || i == MobileEvents.EVENTTYPE_USERACTION) {
            if (iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 != 0) {
                        com.iqoption.app.a.b.aT(this);
                        return;
                    }
                }
                if (this.cJK != null) {
                    a(this.cJK);
                    this.cJK = null;
                }
            } else {
                com.iqoption.app.a.b.aT(this);
            }
        }
    }
}
