package com.iqoption.fragment.cashbox.deppage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.graphics.Bitmap;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.iqoption.dto.entity.billing.CryptoPaymentMethod;
import com.iqoption.dto.entity.billing.CryptoPaymentMethods;
import com.iqoption.util.ag;
import com.iqoption.util.ag.e;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0004¢\u0006\u0002\n\u0000R%\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\"\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/CryptoViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "paymentMethods", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/dto/entity/billing/CryptoPaymentMethod;", "getPaymentMethods", "()Landroid/arch/lifecycle/LiveData;", "paymentMethodsData", "Landroid/arch/lifecycle/MutableLiveData;", "qrCode", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "getQrCode", "qrCodeData", "qrCodeGenerator", "Lcom/iqoption/fragment/cashbox/deppage/CryptoViewModel$Companion$QRCodeGenerator;", "selectedMethod", "getSelectedMethod", "selectedMethodData", "generateQRCode", "", "address", "size", "", "selectPayment", "paymentId", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CryptoViewModel.kt */
public final class CryptoViewModel extends ViewModel {
    private static final String TAG = "CryptoViewModel";
    public static final a cyw = new a();
    private final MutableLiveData<List<CryptoPaymentMethod>> cys = new MutableLiveData();
    private final MutableLiveData<CryptoPaymentMethod> cyt = new MutableLiveData();
    private final MutableLiveData<Pair<String, Bitmap>> cyu = new MutableLiveData();
    private final a cyv = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/CryptoViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "QRCodeGenerator", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CryptoViewModel.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/CryptoViewModel$Companion$QRCodeGenerator;", "", "()V", "task", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroid/graphics/Bitmap;", "encode", "text", "", "size", "", "generate", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: CryptoViewModel.kt */
        public static final class a {
            private volatile s<Bitmap> cyz;

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/fragment/cashbox/deppage/CryptoViewModel$Companion$QRCodeGenerator$generate$1$1"})
            /* compiled from: CryptoViewModel.kt */
            static final class a implements Runnable {
                final /* synthetic */ y cyA;
                final /* synthetic */ a cyB;
                final /* synthetic */ String cyC;
                final /* synthetic */ int cyD;

                a(y yVar, a aVar, String str, int i) {
                    this.cyA = yVar;
                    this.cyB = aVar;
                    this.cyC = str;
                    this.cyD = i;
                }

                public final void run() {
                    this.cyA.P(this.cyB.L(this.cyC, this.cyD));
                    this.cyB.cyz = (s) null;
                }
            }

            private final Bitmap L(String str, int i) {
                try {
                    return new com.iqoption.util.c.b(str, null, "TEXT_TYPE", BarcodeFormat.QR_CODE.toString(), i).aGJ();
                } catch (WriterException e) {
                    com.iqoption.core.i.w(CryptoViewModel.TAG, e.getMessage(), e);
                    return null;
                }
            }

            public final s<Bitmap> M(String str, int i) {
                h.e(str, "text");
                s<Bitmap> sVar = this.cyz;
                if (sVar != null) {
                    return sVar;
                }
                y wb = y.wb();
                s<Bitmap> sVar2 = wb;
                this.cyz = sVar2;
                com.iqoption.core.d.a.aSc.submit(new a(wb, this, str, i));
                return sVar2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "call"})
    /* compiled from: CryptoViewModel.kt */
    /* renamed from: com.iqoption.fragment.cashbox.deppage.CryptoViewModel$1 */
    static final class AnonymousClass1<T> implements e<V> {
        final /* synthetic */ CryptoViewModel cyx;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/dto/entity/billing/CryptoPaymentMethods;", "call"})
        /* compiled from: CryptoViewModel.kt */
        /* renamed from: com.iqoption.fragment.cashbox.deppage.CryptoViewModel$1$1 */
        static final class AnonymousClass1<T> implements e<V> {
            final /* synthetic */ AnonymousClass1 cyy;

            AnonymousClass1(AnonymousClass1 anonymousClass1) {
                this.cyy = anonymousClass1;
            }

            /* renamed from: a */
            public final void aU(CryptoPaymentMethods cryptoPaymentMethods) {
                h.e(cryptoPaymentMethods, "it");
                this.cyy.cyx.cys.postValue(cryptoPaymentMethods);
            }
        }

        AnonymousClass1(CryptoViewModel cryptoViewModel) {
            this.cyx = cryptoViewModel;
        }

        /* renamed from: e */
        public final void aU(com.iqoption.core.microservices.billing.response.b.a aVar) {
            h.e(aVar, "it");
            ag.a(com.iqoption.mobbtech.connect.request.api.b.as(aVar.getHost(), aVar.Uy()), (e) new AnonymousClass1(this));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "call"})
    /* compiled from: CryptoViewModel.kt */
    static final class b<T> implements e<Bitmap> {
        final /* synthetic */ String cyE;
        final /* synthetic */ CryptoViewModel cyx;

        b(CryptoViewModel cryptoViewModel, String str) {
            this.cyx = cryptoViewModel;
            this.cyE = str;
        }

        /* renamed from: a */
        public final void aU(Bitmap bitmap) {
            h.e(bitmap, "it");
            this.cyx.cyu.postValue(new Pair(this.cyE, bitmap));
        }
    }

    public CryptoViewModel() {
        ag.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM(a.TAG), (e) new AnonymousClass1(this));
    }

    public final LiveData<List<CryptoPaymentMethod>> akG() {
        return this.cys;
    }

    public final LiveData<CryptoPaymentMethod> akH() {
        return this.cyt;
    }

    public final LiveData<Pair<String, Bitmap>> akI() {
        return this.cyu;
    }

    public final void K(String str, int i) {
        h.e(str, "address");
        this.cyu.setValue(null);
        ag.a(this.cyv.M(str, i), (e) new b(this, str));
    }

    public final void bo(long j) {
        List list = (List) this.cys.getValue();
        Object obj = null;
        if (list != null) {
            for (Object next : list) {
                Object obj2;
                if (((CryptoPaymentMethod) next).getId() == j) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    obj = next;
                    break;
                }
            }
            obj = (CryptoPaymentMethod) obj;
        }
        this.cyt.setValue(obj);
    }
}
