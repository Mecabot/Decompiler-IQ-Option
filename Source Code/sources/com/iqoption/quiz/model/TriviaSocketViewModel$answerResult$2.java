package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import com.iqoption.core.ui.c;
import com.iqoption.quiz.api.response.e;
import io.reactivex.c.f;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/model/AnswerInfo;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$answerResult$2 extends Lambda implements a<LiveData<c<a>>> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/model/AnswerInfo;", "answerResponse", "Lcom/iqoption/quiz/api/response/AnswerResponse;", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$answerResult$2$1 */
    static final class AnonymousClass1<T, R> implements f<T, R> {
        final /* synthetic */ TriviaSocketViewModel$answerResult$2 dmK;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, aXE = {"com/iqoption/quiz/model/TriviaSocketViewModel$answerResult$2$1$a$1", "Lcom/iqoption/quiz/model/AnswerInfo;", "canAnswer", "", "getAnswerCounters", "", "", "getAnswers", "", "getCorrectAnswer", "getLastAnsweredQuestion", "getQuestion", "getQuestionCount", "getQuestionNumber", "getTotalUsers", "getUserAnswer", "isCorrectAnswer", "isLastQuestion", "quiz_release"})
        /* compiled from: TriviaSocketViewModel.kt */
        public static final class a implements a {
            final /* synthetic */ com.iqoption.quiz.api.response.a dmL;

            a(com.iqoption.quiz.api.response.a aVar) {
                this.dmL = aVar;
            }

            public List<Integer> aAe() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                List<Integer> aAe = aVar.aAe();
                h.d(aAe, "answerResponse.answerCounters");
                return aAe;
            }

            public int aBb() {
                Integer num = this.dmL.dif;
                h.d(num, "answerResponse.correctAnswer");
                return num.intValue();
            }

            public int aBc() {
                Integer num = this.dmL.dig;
                h.d(num, "answerResponse.userAnswer");
                return num.intValue();
            }

            public int aBd() {
                Integer num = this.dmL.dih;
                h.d(num, "answerResponse.totalUsers");
                return num.intValue();
            }

            public boolean aBe() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                return aVar.aAf().diq && h.E(this.dmL.dig, this.dmL.dif);
            }

            public int aBf() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                return aVar.aAf().number;
            }

            public int aBg() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                return aVar.aAf().total;
            }

            public int aBh() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                return aVar.aAf().dis;
            }

            public String aBi() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                String str = aVar.aAf().question;
                h.d(str, "answerResponse.question.question");
                return str;
            }

            public List<String> asA() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                e aAf = aVar.aAf();
                h.d(aAf, "answerResponse.question");
                List<String> asA = aAf.asA();
                h.d(asA, "answerResponse.question.answers");
                return asA;
            }

            public boolean aBj() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                return aVar.aAf().diq;
            }

            public boolean aBk() {
                com.iqoption.quiz.api.response.a aVar = this.dmL;
                h.d(aVar, "answerResponse");
                int i = aVar.aAf().number;
                com.iqoption.quiz.api.response.a aVar2 = this.dmL;
                h.d(aVar2, "answerResponse");
                return i == aVar2.aAf().total - 1;
            }
        }

        AnonymousClass1(TriviaSocketViewModel$answerResult$2 triviaSocketViewModel$answerResult$2) {
            this.dmK = triviaSocketViewModel$answerResult$2;
        }

        /* renamed from: a */
        public final c<a> apply(com.iqoption.quiz.api.response.a aVar) {
            h.e(aVar, "answerResponse");
            if (h.E(aVar, com.iqoption.quiz.api.response.a.die)) {
                this.dmK.this$0.dmb = -1;
                return c.baY.bm(a.dlh);
            } else if (aVar.aAf().number == this.dmK.this$0.dmb) {
                return c.baY.bm(a.dlh);
            } else {
                return c.baY.bm(new a(aVar));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/model/AnswerInfo;", "t", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$answerResult$2$2 */
    static final class AnonymousClass2<T, R> implements f<Throwable, c<a>> {
        final /* synthetic */ TriviaSocketViewModel$answerResult$2 dmK;

        AnonymousClass2(TriviaSocketViewModel$answerResult$2 triviaSocketViewModel$answerResult$2) {
            this.dmK = triviaSocketViewModel$answerResult$2;
        }

        /* renamed from: t */
        public final c<a> apply(Throwable th) {
            h.e(th, "t");
            this.dmK.this$0.a(th, "getAnswer");
            return c.a.a(c.baY, th, null, null, 6, null);
        }
    }

    TriviaSocketViewModel$answerResult$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<c<a>> invoke() {
        return LiveDataReactiveStreams.a(this.this$0.dli.ji("").d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).d((f) new AnonymousClass1(this)).f(new AnonymousClass2(this)));
    }
}
