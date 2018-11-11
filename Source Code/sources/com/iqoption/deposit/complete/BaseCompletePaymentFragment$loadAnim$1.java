package com.iqoption.deposit.complete;

import com.airbnb.lottie.a;
import com.airbnb.lottie.g;
import io.reactivex.subjects.CompletableSubject;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "invoke"})
/* compiled from: BaseCompletePaymentFragment.kt */
final class BaseCompletePaymentFragment$loadAnim$1 extends Lambda implements b<g, l> {
    final /* synthetic */ CompletableSubject $callback;
    final /* synthetic */ a this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    /* renamed from: com.iqoption.deposit.complete.BaseCompletePaymentFragment$loadAnim$1$1 */
    static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ BaseCompletePaymentFragment$loadAnim$1 bWL;

        AnonymousClass1(BaseCompletePaymentFragment$loadAnim$1 baseCompletePaymentFragment$loadAnim$1) {
            this.bWL = baseCompletePaymentFragment$loadAnim$1;
        }

        public final void run() {
            this.bWL.this$0.abI().cU();
        }
    }

    BaseCompletePaymentFragment$loadAnim$1(a aVar, CompletableSubject completableSubject) {
        this.this$0 = aVar;
        this.$callback = completableSubject;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        h((g) obj);
        return l.etX;
    }

    public final void h(g gVar) {
        if (this.this$0.isAdded()) {
            if (gVar != null) {
                this.this$0.abI().setComposition(gVar);
                this.this$0.abI().cT();
                Long abJ = this.this$0.abJ();
                if (abJ != null) {
                    this.this$0.abI().cW();
                    this.this$0.abI().postDelayed(new AnonymousClass1(this), abJ.longValue());
                }
            }
            this.this$0.iZ = (a) null;
            this.$callback.onComplete();
        }
    }
}
