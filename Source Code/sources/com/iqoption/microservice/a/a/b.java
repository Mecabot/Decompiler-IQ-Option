package com.iqoption.microservice.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0001*B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u0003J\b\u0010\"\u001a\u00020\fH\u0016J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003H\u0002J\u001e\u0010%\u001a\u00020\u001e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010&\u001a\u00020\fH\u0002J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\fH\u0016R9\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0003`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/KycQuestionnaireState;", "Landroid/os/Parcelable;", "questionnaires", "", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "(Ljava/util/List;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "answeredQuestions", "Ljava/util/LinkedHashMap;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "", "Lkotlin/collections/LinkedHashMap;", "getAnsweredQuestions", "()Ljava/util/LinkedHashMap;", "currentQuestionnaire", "currentQuestionnaireType", "getCurrentQuestionnaireType", "()Ljava/lang/Integer;", "isCurrentQuestionnaireFinish", "", "()Z", "isNextQuestionExist", "nextQuestion", "getNextQuestion", "()Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "questionsToDisplay", "", "answer", "", "questionType", "kycQuestionsItem", "answerIds", "describeContents", "getQuestionsWithoutDependAnswers", "questions", "initQuestionToDisplay", "questionnaire", "writeToParcel", "dest", "flags", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycQuestionnaireState.kt */
public final class b implements Parcelable {
    public static final Creator<b> CREATOR = new b();
    public static final a cRf = new a();
    private final List<com.iqoption.microservice.a.a.a.c> cRb;
    private List<com.iqoption.microservice.a.a.a.e> cRc = new ArrayList();
    private final LinkedHashMap<com.iqoption.microservice.a.a.a.e, List<Integer>> cRd = new LinkedHashMap();
    private int cRe;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/KycQuestionnaireState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/KycQuestionnaireState;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionnaireState.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, aXE = {"com/iqoption/microservice/kyc/questionnaire/KycQuestionnaireState$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/KycQuestionnaireState;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iqoption/microservice/kyc/questionnaire/KycQuestionnaireState;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionnaireState.kt */
    public static final class b implements Creator<b> {
        b() {
        }

        /* renamed from: M */
        public b createFromParcel(Parcel parcel) {
            h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            return new b(parcel);
        }

        /* renamed from: fl */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "questionsItem", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "apply"})
    /* compiled from: KycQuestionnaireState.kt */
    static final class c<T> implements j<com.iqoption.microservice.a.a.a.e> {
        final /* synthetic */ List cRg;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "dependedAnswer", "", "apply", "(Ljava/lang/Integer;)Z"})
        /* compiled from: KycQuestionnaireState.kt */
        /* renamed from: com.iqoption.microservice.a.a.b$c$1 */
        static final class AnonymousClass1<T> implements j<Integer> {
            final /* synthetic */ c cRh;

            AnonymousClass1(c cVar) {
                this.cRh = cVar;
            }

            /* renamed from: i */
            public final boolean apply(Integer num) {
                return u.b((Iterable) this.cRh.cRg, (Object) num);
            }
        }

        c(List list) {
            this.cRg = list;
        }

        /* renamed from: a */
        public final boolean apply(com.iqoption.microservice.a.a.a.e eVar) {
            return (eVar != null ? eVar.asB() : null) != null ? com.google.common.collect.i.c((Iterable) eVar.asB()).d((j) new AnonymousClass1(this)) : false;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "questionsItem", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "apply"})
    /* compiled from: KycQuestionnaireState.kt */
    static final class d<T> implements j<com.iqoption.microservice.a.a.a.e> {
        final /* synthetic */ b cRi;

        d(b bVar) {
            this.cRi = bVar;
        }

        /* renamed from: a */
        public final boolean apply(com.iqoption.microservice.a.a.a.e eVar) {
            return this.cRi.asf().containsKey(eVar) ^ 1;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "questionsItem", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "apply"})
    /* compiled from: KycQuestionnaireState.kt */
    static final class e<T> implements j<T> {
        public static final e cRj = new e();

        e() {
        }

        /* renamed from: a */
        public final boolean apply(com.iqoption.microservice.a.a.a.e eVar) {
            if (eVar != null) {
                List asB = eVar.asB();
                if (asB != null) {
                    return asB.isEmpty();
                }
            }
            return true;
        }
    }

    public int describeContents() {
        return 0;
    }

    public final LinkedHashMap<com.iqoption.microservice.a.a.a.e, List<Integer>> asf() {
        return this.cRd;
    }

    public final Integer asg() {
        return ((com.iqoption.microservice.a.a.a.c) this.cRb.get(this.cRe)).asr();
    }

    public final boolean ash() {
        return this.cRc.isEmpty();
    }

    public final boolean asi() {
        if (!this.cRc.isEmpty()) {
            return true;
        }
        if (this.cRe >= this.cRb.size() - 1 || aQ(((com.iqoption.microservice.a.a.a.c) this.cRb.get(this.cRe + 1)).ass()).isEmpty()) {
            return false;
        }
        return true;
    }

    public final com.iqoption.microservice.a.a.a.e asj() {
        com.google.common.base.i.a(asi(), "no any questions", new Object[0]);
        if (this.cRc.isEmpty()) {
            b(this.cRb, this.cRe + 1);
        }
        return (com.iqoption.microservice.a.a.a.e) this.cRc.get(0);
    }

    public b(List<com.iqoption.microservice.a.a.a.c> list) {
        h.e(list, "questionnaires");
        this.cRb = list;
        if (!list.isEmpty()) {
            b(list, 0);
        }
    }

    private final void b(List<com.iqoption.microservice.a.a.a.c> list, int i) {
        com.google.common.base.i.checkArgument(i < list.size());
        this.cRd.clear();
        this.cRe = i;
        this.cRc = aQ(((com.iqoption.microservice.a.a.a.c) list.get(this.cRe)).ast());
    }

    private final List<com.iqoption.microservice.a.a.a.e> aQ(List<com.iqoption.microservice.a.a.a.e> list) {
        if (list == null) {
            return new ArrayList();
        }
        list = com.iqoption.microservice.a.a.a.b.cRt.asp().sortedCopy(s.a((Iterable) list, (j) e.cRj));
        h.d(list, "KycQuestionUtil.question…ionsWithoutDependAnswers)");
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9  */
    public final void b(int r6, com.iqoption.microservice.a.a.a.e r7, java.util.List<java.lang.Integer> r8) {
        /*
        r5 = this;
        r0 = "kycQuestionsItem";
        kotlin.jvm.internal.h.e(r7, r0);
        r0 = "answerIds";
        kotlin.jvm.internal.h.e(r8, r0);
        r0 = r5.cRd;
        r0 = r0.containsKey(r7);
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0025;
    L_0x0014:
        r3 = r5.cRc;
        r3 = r3.get(r2);
        r3 = (com.iqoption.microservice.a.a.a.e) r3;
        r3 = kotlin.jvm.internal.h.E(r3, r7);
        if (r3 == 0) goto L_0x0023;
    L_0x0022:
        goto L_0x0025;
    L_0x0023:
        r3 = 0;
        goto L_0x0026;
    L_0x0025:
        r3 = 1;
    L_0x0026:
        com.google.common.base.i.checkArgument(r3);
        if (r0 != 0) goto L_0x0045;
    L_0x002b:
        r3 = r5.cRb;
        r4 = r5.cRe;
        r3 = r3.get(r4);
        r3 = (com.iqoption.microservice.a.a.a.c) r3;
        r3 = r3.asr();
        if (r3 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x0043;
    L_0x003c:
        r3 = r3.intValue();
        if (r6 != r3) goto L_0x0043;
    L_0x0042:
        goto L_0x0045;
    L_0x0043:
        r6 = 0;
        goto L_0x0046;
    L_0x0045:
        r6 = 1;
    L_0x0046:
        com.google.common.base.i.checkArgument(r6);
        if (r0 != 0) goto L_0x0051;
    L_0x004b:
        r6 = r5.cRc;
        r6.remove(r2);
        goto L_0x0094;
    L_0x0051:
        r6 = r5.cRd;
        r6 = r6.keySet();
        r0 = "answeredQuestions.keys";
        kotlin.jvm.internal.h.d(r6, r0);
        r6 = (java.lang.Iterable) r6;
        r6 = kotlin.collections.u.c(r6, r7);
        r0 = r5.cRd;
        r0 = r0.keySet();
        r0 = (java.lang.Iterable) r0;
        r0 = com.google.common.collect.i.c(r0);
        r6 = r6 + r1;
        r6 = r0.aM(r6);
        r6 = r6.sA();
        r0 = "questionToReanswer";
        kotlin.jvm.internal.h.d(r6, r0);
        r6 = (java.lang.Iterable) r6;
        r6 = r6.iterator();
    L_0x0082:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0094;
    L_0x0088:
        r0 = r6.next();
        r0 = (com.iqoption.microservice.a.a.a.e) r0;
        r1 = r5.cRd;
        r1.remove(r0);
        goto L_0x0082;
    L_0x0094:
        r6 = r5.cRd;
        r6.put(r7, r8);
        r6 = r5.cRb;
        r7 = r5.cRe;
        r6 = r6.get(r7);
        r6 = (com.iqoption.microservice.a.a.a.c) r6;
        r6 = r6.ast();
        if (r6 == 0) goto L_0x00d5;
    L_0x00a9:
        r6 = (java.lang.Iterable) r6;
        r6 = com.google.common.collect.i.c(r6);
        r7 = new com.iqoption.microservice.a.a.b$c;
        r7.<init>(r8);
        r7 = (com.google.common.base.j) r7;
        r6 = r6.c(r7);
        r7 = new com.iqoption.microservice.a.a.b$d;
        r7.<init>(r5);
        r7 = (com.google.common.base.j) r7;
        r6 = r6.c(r7);
        r6 = r6.sA();
        r7 = r5.cRc;
        r8 = "newQuestions";
        kotlin.jvm.internal.h.d(r6, r8);
        r6 = (java.util.Collection) r6;
        r7.addAll(r6);
    L_0x00d5:
        r6 = r5.cRc;
        r7 = com.iqoption.microservice.a.a.a.b.cRt;
        r7 = r7.asp();
        r7 = (java.util.Comparator) r7;
        java.util.Collections.sort(r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.a.a.b.b(int, com.iqoption.microservice.a.a.a.e, java.util.List):void");
    }

    public b(Parcel parcel) {
        h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
        ImmutableList m = ImmutableList.m(parcel.createTypedArrayList(com.iqoption.microservice.a.a.a.c.CREATOR));
        h.d(m, "ImmutableList.copyOf(sou…ycQuestionnaire.CREATOR))");
        this.cRb = m;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(com.iqoption.microservice.a.a.a.e.CREATOR);
        h.d(createTypedArrayList, "source.createTypedArrayL…KycQuestionsItem.CREATOR)");
        this.cRc = createTypedArrayList;
        int readInt = parcel.readInt();
        while (true) {
            int i = readInt - 1;
            if (readInt > 0) {
                LinkedHashMap linkedHashMap = this.cRd;
                Parcelable readParcelable = parcel.readParcelable(com.iqoption.microservice.a.a.a.e.class.getClassLoader());
                Object createIntArray = parcel.createIntArray();
                h.d(createIntArray, "source.createIntArray()");
                linkedHashMap.put(readParcelable, h.q(createIntArray));
                readInt = i;
            } else {
                this.cRe = parcel.readInt();
                return;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeTypedList(this.cRb);
        parcel.writeTypedList(this.cRc);
        parcel.writeInt(this.cRd.size());
        for (Entry entry : this.cRd.entrySet()) {
            parcel.writeParcelable((Parcelable) entry.getKey(), i);
            parcel.writeIntArray(u.N((Collection) entry.getValue()));
        }
        parcel.writeInt(this.cRe);
    }
}
