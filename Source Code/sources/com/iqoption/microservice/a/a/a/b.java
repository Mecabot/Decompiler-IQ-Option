package com.iqoption.microservice.a.a.a;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionUtil;", "", "()V", "answerOrdering", "Lcom/google/common/collect/Ordering;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "getAnswerOrdering", "()Lcom/google/common/collect/Ordering;", "orderQuestionById", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "orderQuestionByOrder", "questionOrdering", "getQuestionOrdering", "questionnaireOrdering", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "getQuestionnaireOrdering", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycQuestionUtil.kt */
public final class b {
    private static final Ordering<e> cRo;
    private static final Ordering<e> cRp;
    private static final Ordering<c> cRq;
    private static final Ordering<e> cRr;
    private static final Ordering<a> cRs;
    public static final b cRt = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "answer", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "apply", "(Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;)Ljava/lang/Integer;"})
    /* compiled from: KycQuestionUtil.kt */
    static final class a<F, T> implements com.google.common.base.d<a, Integer> {
        public static final a cRu = new a();

        a() {
        }

        /* renamed from: b */
        public final Integer apply(a aVar) {
            return aVar == null ? null : aVar.asn();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "question", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "apply", "(Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;)Ljava/lang/Integer;"})
    /* compiled from: KycQuestionUtil.kt */
    static final class b<F, T> implements com.google.common.base.d<e, Integer> {
        public static final b cRv = new b();

        b() {
        }

        /* renamed from: b */
        public final Integer apply(e eVar) {
            return eVar == null ? null : Integer.valueOf(eVar.asx());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "question", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "apply", "(Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;)Ljava/lang/Integer;"})
    /* compiled from: KycQuestionUtil.kt */
    static final class c<F, T> implements com.google.common.base.d<e, Integer> {
        public static final c cRw = new c();

        c() {
        }

        /* renamed from: b */
        public final Integer apply(e eVar) {
            return eVar == null ? null : eVar.asn();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "questionnaire", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "apply", "(Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;)Ljava/lang/Integer;"})
    /* compiled from: KycQuestionUtil.kt */
    static final class d<F, T> implements com.google.common.base.d<c, Integer> {
        public static final d cRx = new d();

        d() {
        }

        /* renamed from: a */
        public final Integer apply(c cVar) {
            if ((cVar != null ? cVar.asr() : null) == null) {
                return null;
            }
            return cVar.asr();
        }
    }

    static {
        Ordering onResultOf = Ordering.natural().nullsFirst().onResultOf(c.cRw);
        h.d(onResultOf, "Ordering\n            .na…tion.order\n            })");
        cRo = onResultOf;
        onResultOf = Ordering.natural().onResultOf(b.cRv);
        h.d(onResultOf, "Ordering\n            .na…questionId\n            })");
        cRp = onResultOf;
        onResultOf = Ordering.natural().nullsFirst().onResultOf(d.cRx);
        h.d(onResultOf, "Ordering\n            .na…naire.type\n            })");
        cRq = onResultOf;
        onResultOf = cRo.compound((Comparator) cRp);
        h.d(onResultOf, "orderQuestionByOrder\n   …mpound(orderQuestionById)");
        cRr = onResultOf;
        onResultOf = Ordering.natural().nullsFirst().onResultOf(a.cRu);
        h.d(onResultOf, "Ordering\n            .na…swer.order\n            })");
        cRs = onResultOf;
    }

    private b() {
    }

    public final Ordering<c> aso() {
        return cRq;
    }

    public final Ordering<e> asp() {
        return cRr;
    }

    public final Ordering<a> asq() {
        return cRs;
    }
}
