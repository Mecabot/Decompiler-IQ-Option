package com.iqoption.tutorial.dictionary;

import android.content.Context;
import com.google.common.util.concurrent.s;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iqoption.util.ab;
import com.iqoption.util.ah;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/tutorial/dictionary/TutorialDictionaryRepository;", "", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "getSteps", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialDictionaryRepository.kt */
public final class a {
    private static final Type duu;
    public static final a duv = new a();
    private final Context context;
    private final Gson gson;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/tutorial/dictionary/TutorialDictionaryRepository$Companion;", "", "()V", "TUTORIAL_LIST_TYPE", "Ljava/lang/reflect/Type;", "newInstance", "Lcom/iqoption/tutorial/dictionary/TutorialDictionaryRepository;", "context", "Landroid/content/Context;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialDictionaryRepository.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a bP(Context context) {
            h.e(context, "context");
            context = context.getApplicationContext();
            h.d(context, "context.applicationContext");
            Gson aGg = ah.aGg();
            h.d(aGg, "Gsons.app()");
            return new a(context, aGg, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "kotlin.jvm.PlatformType", "call"})
    /* compiled from: TutorialDictionaryRepository.kt */
    static final class c<V> implements Callable<List<? extends b>> {
        final /* synthetic */ a duw;

        c(a aVar) {
            this.duw = aVar;
        }

        /* renamed from: aFH */
        public final List<b> call() {
            return (List) this.duw.gson.fromJson(ab.F(this.duw.context, "tutorial.json"), a.duu);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, aXE = {"com/iqoption/tutorial/dictionary/TutorialDictionaryRepository$Companion$TUTORIAL_LIST_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "Lkotlin/collections/ArrayList;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialDictionaryRepository.kt */
    public static final class b extends TypeToken<ArrayList<b>> {
        b() {
        }
    }

    private a(Context context, Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    public /* synthetic */ a(Context context, Gson gson, f fVar) {
        this(context, gson);
    }

    static {
        Type type = new b().getType();
        if (type == null) {
            h.aXZ();
        }
        duu = type;
    }

    public final s<List<b>> aFF() {
        Future submit = com.iqoption.core.d.a.aSc.submit(new c(this));
        h.d(submit, "Schedulers.io.submit<Lis…RIAL_LIST_TYPE)\n        }");
        return (s) submit;
    }
}
