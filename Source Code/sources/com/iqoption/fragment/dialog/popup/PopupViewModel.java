package com.iqoption.fragment.dialog.popup;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.iqoption.core.microservices.popupserver.response.PopupAnchor;
import com.iqoption.core.microservices.popupserver.response.PopupFormat;
import com.iqoption.popup.PopupPriority;
import io.reactivex.processors.PublishProcessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import org.json.JSONObject;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0004J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0004J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0006\u0010$\u001a\u00020%J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020%J(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u00020%0\u0015J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0006\u0010+\u001a\u00020'J\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u0015J\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020%0\u0015J\b\u0010/\u001a\u00020 H\u0014J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u0010!\u001a\u00020\u0004H\u0002J\u0010\u00103\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\u0016\u00104\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u000eJ\u0016\u00104\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u00104\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00107\u001a\u000208J \u00109\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006>"}, aXE = {"Lcom/iqoption/fragment/dialog/popup/PopupViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "CLOSE_EVENT", "", "LOGGING_CONSUMER", "Lio/reactivex/functions/Consumer;", "", "SHOW_EVENT", "SUBMIT_EVENT", "TAG", "kotlin.jvm.PlatformType", "deleteSubject", "Lio/reactivex/processors/FlowableProcessor;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "popupManager", "Lcom/iqoption/popup/PopupManager;", "popupStream", "Lio/reactivex/Flowable;", "", "getPopupStream", "()Lio/reactivex/Flowable;", "popupStream$delegate", "Lkotlin/Lazy;", "isShowing", "", "isShown", "popup", "tag", "notifyPopupHidden", "", "event", "observePopup", "Landroid/arch/lifecycle/LiveData;", "anchor", "Lcom/iqoption/core/microservices/popupserver/response/PopupAnchor;", "format", "Lcom/iqoption/core/microservices/popupserver/response/PopupFormat;", "formats", "anchors", "observePopupFormat", "formatName", "observePopupFormats", "formatNames", "observePopups", "onCleared", "sendEventClosedPopup", "popupId", "", "sendEventShowedPopup", "showPopup", "runnable", "Ljava/lang/Runnable;", "priority", "Lcom/iqoption/popup/PopupPriority;", "submitNps", "score", "", "comment", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PopupViewModel.kt */
public final class PopupViewModel extends ViewModel {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(PopupViewModel.class), "popupStream", "getPopupStream()Lio/reactivex/Flowable;"))};
    public static final a cBp = new a();
    private final String TAG = PopupViewModel.class.getSimpleName();
    private final io.reactivex.c.e<Throwable> aBj = new b(this);
    private final kotlin.d aWS;
    private final io.reactivex.disposables.a asp = new io.reactivex.disposables.a();
    private final String cBk = "show";
    private final String cBl = "close";
    private final String cBm = "send";
    private final com.iqoption.popup.b cBn = new com.iqoption.popup.b();
    private final io.reactivex.processors.a<com.iqoption.core.microservices.popupserver.response.a> cBo;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/dialog/popup/PopupViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/fragment/dialog/popup/PopupViewModel;", "a", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PopupViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final PopupViewModel j(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, com.iqoption.fragment.cashbox.deppage.a.TAG);
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(PopupViewModel.class);
            h.d(h, "ViewModelProviders.of(a)…pupViewModel::class.java)");
            return (PopupViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: PopupViewModel.kt */
    static final class f implements Runnable {
        final /* synthetic */ com.iqoption.core.microservices.popupserver.response.a cBi;
        final /* synthetic */ Runnable cBz;
        final /* synthetic */ PopupViewModel this$0;

        f(PopupViewModel popupViewModel, com.iqoption.core.microservices.popupserver.response.a aVar, Runnable runnable) {
            this.this$0 = popupViewModel;
            this.cBi = aVar;
            this.cBz = runnable;
        }

        public final void run() {
            this.this$0.bq(this.cBi.Jf().longValue());
            this.cBz.run();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: PopupViewModel.kt */
    static final class b<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ PopupViewModel this$0;

        b(PopupViewModel popupViewModel) {
            this.this$0 = popupViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(this.this$0.TAG, "Error occurred", th);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, aXE = {"com/iqoption/fragment/dialog/popup/PopupViewModel$observePopup$1", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PopupViewModel.kt */
    public static final class c extends MutableLiveData<com.iqoption.core.microservices.popupserver.response.a> {
        final /* synthetic */ List cBq;
        final /* synthetic */ List cBr;
        final /* synthetic */ PopupViewModel this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "popups", "apply"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$c$1 */
        static final class AnonymousClass1<T, R> implements io.reactivex.c.f<T, R> {
            final /* synthetic */ c cBs;

            AnonymousClass1(c cVar) {
                this.cBs = cVar;
            }

            /* renamed from: m */
            public final List<com.iqoption.core.microservices.popupserver.response.a> apply(List<com.iqoption.core.microservices.popupserver.response.a> list) {
                h.e(list, "popups");
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    com.iqoption.core.microservices.popupserver.response.a aVar = (com.iqoption.core.microservices.popupserver.response.a) next;
                    Object obj = null;
                    if (this.cBs.cBq.contains(aVar.Wt())) {
                        PopupAnchor Wr = aVar.Wr();
                        Object obj2 = (Wr == null || !this.cBs.cBr.contains(Wr)) ? null : 1;
                        if (obj2 != null) {
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        arrayList.add(next);
                    }
                }
                return (List) arrayList;
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "popups", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$c$2 */
        static final class AnonymousClass2<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.popupserver.response.a>> {
            final /* synthetic */ c cBs;

            AnonymousClass2(c cVar) {
                this.cBs = cVar;
            }

            /* renamed from: C */
            public final void accept(List<com.iqoption.core.microservices.popupserver.response.a> list) {
                h.d(list, "popups");
                for (com.iqoption.core.microservices.popupserver.response.a postValue : list) {
                    this.cBs.postValue(postValue);
                }
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$c$3 */
        static final class AnonymousClass3<T> implements io.reactivex.c.e<Throwable> {
            final /* synthetic */ c cBs;

            AnonymousClass3(c cVar) {
                this.cBs = cVar;
            }

            /* renamed from: o */
            public final void accept(Throwable th) {
                com.iqoption.core.i.e(this.cBs.this$0.TAG, th);
            }
        }

        c(PopupViewModel popupViewModel, List list, List list2) {
            this.this$0 = popupViewModel;
            this.cBq = list;
            this.cBr = list2;
            popupViewModel.aln().d((io.reactivex.c.f) new AnonymousClass1(this)).d(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass2(this), (io.reactivex.c.e) new AnonymousClass3(this));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, aXE = {"com/iqoption/fragment/dialog/popup/PopupViewModel$observePopupFormats$1", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PopupViewModel.kt */
    public static final class d extends MutableLiveData<com.iqoption.core.microservices.popupserver.response.a> {
        final /* synthetic */ List cBt;
        final /* synthetic */ PopupViewModel this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "popups", "apply"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$d$1 */
        static final class AnonymousClass1<T, R> implements io.reactivex.c.f<T, R> {
            final /* synthetic */ d cBu;

            AnonymousClass1(d dVar) {
                this.cBu = dVar;
            }

            /* renamed from: m */
            public final List<com.iqoption.core.microservices.popupserver.response.a> apply(List<com.iqoption.core.microservices.popupserver.response.a> list) {
                h.e(list, "popups");
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    if (this.cBu.cBt.contains(((com.iqoption.core.microservices.popupserver.response.a) next).Wt())) {
                        arrayList.add(next);
                    }
                }
                return (List) arrayList;
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "popups", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$d$2 */
        static final class AnonymousClass2<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.popupserver.response.a>> {
            final /* synthetic */ d cBu;

            AnonymousClass2(d dVar) {
                this.cBu = dVar;
            }

            /* renamed from: C */
            public final void accept(List<com.iqoption.core.microservices.popupserver.response.a> list) {
                h.d(list, "popups");
                for (com.iqoption.core.microservices.popupserver.response.a postValue : list) {
                    this.cBu.postValue(postValue);
                }
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$d$3 */
        static final class AnonymousClass3<T> implements io.reactivex.c.e<Throwable> {
            final /* synthetic */ d cBu;

            AnonymousClass3(d dVar) {
                this.cBu = dVar;
            }

            /* renamed from: o */
            public final void accept(Throwable th) {
                com.iqoption.core.i.e(this.cBu.this$0.TAG, th);
            }
        }

        d(PopupViewModel popupViewModel, List list) {
            this.this$0 = popupViewModel;
            this.cBt = list;
            popupViewModel.aln().d((io.reactivex.c.f) new AnonymousClass1(this)).d(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass2(this), (io.reactivex.c.e) new AnonymousClass3(this));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, aXE = {"com/iqoption/fragment/dialog/popup/PopupViewModel$observePopups$1", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PopupViewModel.kt */
    public static final class e extends MutableLiveData<com.iqoption.core.microservices.popupserver.response.a> {
        final /* synthetic */ List cBr;
        final /* synthetic */ PopupViewModel this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "apply"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$e$1 */
        static final class AnonymousClass1<T, R> implements io.reactivex.c.f<T, R> {
            final /* synthetic */ e cBv;

            AnonymousClass1(e eVar) {
                this.cBv = eVar;
            }

            /* renamed from: m */
            public final List<com.iqoption.core.microservices.popupserver.response.a> apply(List<com.iqoption.core.microservices.popupserver.response.a> list) {
                h.e(list, "it");
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    if (u.b((Iterable) this.cBv.cBr, (Object) ((com.iqoption.core.microservices.popupserver.response.a) next).Wr())) {
                        arrayList.add(next);
                    }
                }
                return (List) arrayList;
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "popups", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$e$2 */
        static final class AnonymousClass2<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.popupserver.response.a>> {
            final /* synthetic */ e cBv;

            AnonymousClass2(e eVar) {
                this.cBv = eVar;
            }

            /* renamed from: C */
            public final void accept(List<com.iqoption.core.microservices.popupserver.response.a> list) {
                h.d(list, "popups");
                for (com.iqoption.core.microservices.popupserver.response.a postValue : list) {
                    this.cBv.postValue(postValue);
                }
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: PopupViewModel.kt */
        /* renamed from: com.iqoption.fragment.dialog.popup.PopupViewModel$e$3 */
        static final class AnonymousClass3<T> implements io.reactivex.c.e<Throwable> {
            final /* synthetic */ e cBv;

            AnonymousClass3(e eVar) {
                this.cBv = eVar;
            }

            /* renamed from: o */
            public final void accept(Throwable th) {
                com.iqoption.core.i.e(this.cBv.this$0.TAG, th);
            }
        }

        e(PopupViewModel popupViewModel, List list) {
            this.this$0 = popupViewModel;
            this.cBr = list;
            popupViewModel.aln().d((io.reactivex.c.f) new AnonymousClass1(this)).d(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass2(this), (io.reactivex.c.e) new AnonymousClass3(this));
        }
    }

    private final io.reactivex.e<List<com.iqoption.core.microservices.popupserver.response.a>> aln() {
        kotlin.d dVar = this.aWS;
        j jVar = apP[0];
        return (io.reactivex.e) dVar.getValue();
    }

    public static final PopupViewModel j(FragmentActivity fragmentActivity) {
        return cBp.j(fragmentActivity);
    }

    public final void i(com.iqoption.core.microservices.popupserver.response.a aVar) {
        a(this, aVar, null, 2, null);
    }

    public PopupViewModel() {
        io.reactivex.processors.a aXp = PublishProcessor.aXq().aXp();
        h.d(aXp, "PublishProcessor.create<Popup>().toSerialized()");
        this.cBo = aXp;
        this.aWS = g.f(new PopupViewModel$popupStream$2(this));
    }

    public final LiveData<com.iqoption.core.microservices.popupserver.response.a> a(PopupAnchor popupAnchor) {
        h.e(popupAnchor, "anchor");
        return aD(l.cr(popupAnchor));
    }

    public final LiveData<com.iqoption.core.microservices.popupserver.response.a> aD(List<? extends PopupAnchor> list) {
        h.e(list, "anchors");
        return new e(this, list);
    }

    public final LiveData<com.iqoption.core.microservices.popupserver.response.a> a(PopupFormat popupFormat) {
        h.e(popupFormat, "formatName");
        return aE(l.cr(popupFormat));
    }

    public final LiveData<com.iqoption.core.microservices.popupserver.response.a> aE(List<? extends PopupFormat> list) {
        h.e(list, "formatNames");
        return new d(this, list);
    }

    public final LiveData<com.iqoption.core.microservices.popupserver.response.a> a(PopupFormat popupFormat, PopupAnchor popupAnchor) {
        h.e(popupFormat, "format");
        h.e(popupAnchor, "anchor");
        return f(l.cr(popupFormat), l.cr(popupAnchor));
    }

    public final LiveData<com.iqoption.core.microservices.popupserver.response.a> f(List<? extends PopupFormat> list, List<? extends PopupAnchor> list2) {
        h.e(list, "formats");
        h.e(list2, "anchors");
        return new c(this, list, list2);
    }

    public final void a(Runnable runnable, com.iqoption.core.microservices.popupserver.response.a aVar) {
        h.e(runnable, "runnable");
        h.e(aVar, "popup");
        List list = (List) aln().aVW();
        if (list != null && list.contains(aVar) && !j(aVar)) {
            this.cBo.e(aVar);
            this.cBn.a(new f(this, aVar, runnable), String.valueOf(aVar.Jf().longValue()));
        }
    }

    public static /* bridge */ /* synthetic */ void a(PopupViewModel popupViewModel, com.iqoption.core.microservices.popupserver.response.a aVar, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = popupViewModel.cBl;
        }
        popupViewModel.a(aVar, str);
    }

    public final void a(com.iqoption.core.microservices.popupserver.response.a aVar, String str) {
        h.e(aVar, "popup");
        h.e(str, "event");
        f(aVar.Jf().longValue(), str);
        this.cBn.hO(String.valueOf(aVar.Jf().longValue()));
    }

    public final boolean j(com.iqoption.core.microservices.popupserver.response.a aVar) {
        h.e(aVar, "popup");
        return this.cBn.hP(String.valueOf(aVar.Jf().longValue()));
    }

    public final void a(com.iqoption.core.microservices.popupserver.response.a aVar, int i, String str) {
        Object str2;
        h.e(aVar, "popup");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.google.firebase.analytics.FirebaseAnalytics.b.SCORE, i);
        String str3 = "comment";
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put(str3, str2);
        this.asp.e(com.iqoption.core.microservices.popupserver.a.aWT.a(aVar.Jf().longValue(), this.cBm, jSONObject).b(com.iqoption.core.h.i.Yo()).a(io.reactivex.internal.a.a.aBl, this.aBj));
    }

    private final void bq(long j) {
        this.asp.e(com.iqoption.core.microservices.popupserver.a.a(com.iqoption.core.microservices.popupserver.a.aWT, j, this.cBk, null, 4, null).b(com.iqoption.core.h.i.Yo()).a(io.reactivex.internal.a.a.aBl, this.aBj));
    }

    private final void f(long j, String str) {
        this.asp.e(com.iqoption.core.microservices.popupserver.a.a(com.iqoption.core.microservices.popupserver.a.aWT, j, str, null, 4, null).b(com.iqoption.core.h.i.Yo()).a(io.reactivex.internal.a.a.aBl, this.aBj));
    }

    protected void onCleared() {
        super.onCleared();
        this.asp.clear();
        this.cBn.onStop();
    }

    public final boolean isShowing() {
        return this.cBn.isShowing();
    }

    public final void a(Runnable runnable, String str) {
        h.e(runnable, "runnable");
        h.e(str, "tag");
        this.cBn.a(runnable, str);
    }

    public final void a(Runnable runnable, String str, PopupPriority popupPriority) {
        h.e(runnable, "runnable");
        h.e(str, "tag");
        h.e(popupPriority, "priority");
        this.cBn.a(runnable, str, popupPriority);
    }

    public final void hO(String str) {
        h.e(str, "tag");
        this.cBn.hO(str);
    }

    public final boolean hP(String str) {
        h.e(str, "tag");
        return this.cBn.hP(str);
    }
}
