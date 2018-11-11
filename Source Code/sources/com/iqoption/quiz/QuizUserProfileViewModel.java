package com.iqoption.quiz;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0016H\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/quiz/QuizUserProfileViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "country", "Landroid/arch/lifecycle/LiveData;", "", "getCountry", "()Landroid/arch/lifecycle/LiveData;", "countryData", "Landroid/arch/lifecycle/MutableLiveData;", "dateFormatter", "Ljava/text/SimpleDateFormat;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "isOnline", "", "isOnlineData", "profile", "Lcom/iqoption/quiz/QuizUserProfileViewModel$Profile;", "getProfile", "profileData", "load", "", "userId", "", "onCleared", "Companion", "Profile", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizUserProfileViewModel.kt */
public final class QuizUserProfileViewModel extends ViewModel {
    private static final String TAG = "QuizUserProfileViewModel";
    public static final a dhd = new a();
    private final io.reactivex.disposables.a bco = new io.reactivex.disposables.a();
    private final SimpleDateFormat dgW = new SimpleDateFormat("dd MMM yyyy", Locale.US);
    private final MutableLiveData<b> dgX = new MutableLiveData();
    private final LiveData<b> dgY = this.dgX;
    private final MutableLiveData<String> dgZ = new MutableLiveData();
    private final LiveData<String> dha = this.dgZ;
    private final MutableLiveData<Boolean> dhb = new MutableLiveData();
    private final LiveData<Boolean> dhc = this.dhb;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/quiz/QuizUserProfileViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/quiz/QuizUserProfileViewModel;", "f", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizUserProfileViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return QuizUserProfileViewModel.TAG;
        }

        public final QuizUserProfileViewModel V(Fragment fragment) {
            kotlin.jvm.internal.h.e(fragment, "f");
            return (QuizUserProfileViewModel) ViewModelProviders.d(fragment).h(QuizUserProfileViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, aXE = {"Lcom/iqoption/quiz/QuizUserProfileViewModel$Profile;", "", "name", "", "flagUrl", "avatarUrl", "isVip", "", "registrationDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getFlagUrl", "()Z", "getName", "getRegistrationDate", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizUserProfileViewModel.kt */
    public static final class b {
        private final String aJN;
        private final boolean ako;
        private final String avatarUrl;
        private final String dhe;
        private final String name;

        public b(String str, String str2, String str3, boolean z, String str4) {
            kotlin.jvm.internal.h.e(str, "name");
            kotlin.jvm.internal.h.e(str4, "registrationDate");
            this.name = str;
            this.aJN = str2;
            this.avatarUrl = str3;
            this.ako = z;
            this.dhe = str4;
        }

        public final boolean Dd() {
            return this.ako;
        }

        public final String Qv() {
            return this.avatarUrl;
        }

        public final String Qx() {
            return this.aJN;
        }

        public final String azu() {
            return this.dhe;
        }

        public final String getName() {
            return this.name;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/QuizUserProfileViewModel$Profile;", "client", "Lcom/iqoption/core/microservices/socialuserprofile/response/UserProfileClient;", "apply"})
    /* compiled from: QuizUserProfileViewModel.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ QuizUserProfileViewModel dhf;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/configuration/response/Country;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: QuizUserProfileViewModel.kt */
        /* renamed from: com.iqoption.quiz.QuizUserProfileViewModel$c$1 */
        static final class AnonymousClass1<T> implements io.reactivex.c.e<com.iqoption.core.microservices.configuration.a.c> {
            final /* synthetic */ c dhg;

            AnonymousClass1(c cVar) {
                this.dhg = cVar;
            }

            /* renamed from: e */
            public final void accept(com.iqoption.core.microservices.configuration.a.c cVar) {
                this.dhg.dhf.dgZ.setValue(cVar.getName());
            }
        }

        c(QuizUserProfileViewModel quizUserProfileViewModel) {
            this.dhf = quizUserProfileViewModel;
        }

        /* renamed from: a */
        public final b apply(final com.iqoption.core.microservices.e.a.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "client");
            if (aVar.Db() != -1) {
                this.dhf.bco.e(com.iqoption.core.data.repository.c.aOM.aP(aVar.Db()).f(com.iqoption.core.h.i.Yo()).e(com.iqoption.core.h.i.Yp()).a(new AnonymousClass1(this), new io.reactivex.c.e<Throwable>() {
                    /* renamed from: o */
                    public final void accept(Throwable th) {
                        String Ll = QuizUserProfileViewModel.dhd.Ll();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Couldn't load country by id: ");
                        stringBuilder.append(aVar.Db());
                        com.iqoption.core.i.w(Ll, stringBuilder.toString(), th);
                    }
                }));
            }
            String aA = com.iqoption.core.util.f.bgP.aA(aVar.getFlag());
            long Qw = aVar.Qw() * ((long) 1000);
            String userName = aVar.getUserName();
            String Wj = aVar.Wj();
            boolean Dd = aVar.Dd();
            String format = this.dhf.dgW.format(Long.valueOf(Qw));
            kotlin.jvm.internal.h.d(format, "dateFormatter.format(regTime)");
            return new b(userName, aA, Wj, Dd, format);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/QuizUserProfileViewModel$Profile;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: QuizUserProfileViewModel.kt */
    static final class d<T> implements io.reactivex.c.e<b> {
        final /* synthetic */ QuizUserProfileViewModel dhf;

        d(QuizUserProfileViewModel quizUserProfileViewModel) {
            this.dhf = quizUserProfileViewModel;
        }

        /* renamed from: b */
        public final void accept(b bVar) {
            this.dhf.dgX.setValue(bVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: QuizUserProfileViewModel.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ long $userId;

        e(long j) {
            this.$userId = j;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ll = QuizUserProfileViewModel.dhd.Ll();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't load user client profile by id: ");
            stringBuilder.append(this.$userId);
            com.iqoption.core.i.w(Ll, stringBuilder.toString(), th);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/core/microservices/useronline/response/UserAvailability;", "apply"})
    /* compiled from: QuizUserProfileViewModel.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        public static final f dhi = new f();

        f() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return Boolean.valueOf(aJ((List) obj));
        }

        public final boolean aJ(List<com.iqoption.core.microservices.g.a.a> list) {
            kotlin.jvm.internal.h.e(list, "it");
            return kotlin.jvm.internal.h.E(((com.iqoption.core.microservices.g.a.a) u.bU(list)).getStatus(), "online");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"})
    /* compiled from: QuizUserProfileViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<Boolean> {
        final /* synthetic */ QuizUserProfileViewModel dhf;

        g(QuizUserProfileViewModel quizUserProfileViewModel) {
            this.dhf = quizUserProfileViewModel;
        }

        /* renamed from: j */
        public final void accept(Boolean bool) {
            this.dhf.dhb.setValue(bool);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: QuizUserProfileViewModel.kt */
    static final class h<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ long $userId;

        h(long j) {
            this.$userId = j;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ll = QuizUserProfileViewModel.dhd.Ll();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't load user's availability by id: ");
            stringBuilder.append(this.$userId);
            com.iqoption.core.i.w(Ll, stringBuilder.toString(), th);
        }
    }

    public final LiveData<b> azr() {
        return this.dgY;
    }

    public final LiveData<String> azs() {
        return this.dha;
    }

    public final LiveData<Boolean> azt() {
        return this.dhc;
    }

    public final void bP(long j) {
        this.bco.e(com.iqoption.core.microservices.e.a.aXK.aZ(j).n(new c(this)).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new d(this), (io.reactivex.c.e) new e(j)));
        this.bco.e(com.iqoption.core.microservices.g.a.aZo.c(j).n(f.dhi).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new g(this), (io.reactivex.c.e) new h(j)));
    }

    protected void onCleared() {
        super.onCleared();
        this.bco.clear();
    }
}
