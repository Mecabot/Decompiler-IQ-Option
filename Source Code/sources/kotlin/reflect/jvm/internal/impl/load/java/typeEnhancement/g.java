package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.k.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;

/* compiled from: predefinedEnhancementInfo.kt */
public final class g {
    private static final d eIH = new d(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final d eII = new d(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    private static final d eIJ = new d(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);
    private static final Map<String, h> eIK;

    static {
        u uVar = u.eJX;
        String mu = uVar.mu("Object");
        String mw = uVar.mw("Predicate");
        String mw2 = uVar.mw("Function");
        String mw3 = uVar.mw("Consumer");
        String mw4 = uVar.mw("BiFunction");
        String mw5 = uVar.mw("BiConsumer");
        String mw6 = uVar.mw("UnaryOperator");
        String mv = uVar.mv("stream/Stream");
        String mv2 = uVar.mv("Optional");
        k kVar = new k();
        u uVar2 = uVar;
        String str = mw3;
        String str2 = mw;
        String str3 = mw;
        String str4 = mv;
        String str5 = mw3;
        a aVar = new a(kVar, uVar.mv("Iterator"));
        String str6 = mw6;
        String str7 = mw6;
        k kVar2 = kVar;
        String str8 = mw5;
        String str9 = mv2;
        mv2 = mu;
        String str10 = mw4;
        String str11 = mw2;
        String str12 = str9;
        aVar.f("forEachRemaining", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$1(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        str = str5;
        str2 = str3;
        str6 = str7;
        new a(kVar2, uVar.mu("Iterable")).f("spliterator", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$2(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar = new a(kVar2, uVar.mv("Collection"));
        aVar.f("removeIf", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$3(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("stream", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$4(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("parallelStream", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$5(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        new a(kVar2, uVar.mv("List")).f("replaceAll", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$6(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar = new a(kVar2, uVar.mv("Map"));
        aVar.f("forEach", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$7(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("putIfAbsent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$8(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("replace", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$9(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("replace", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$10(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("replaceAll", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$11(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("compute", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$12(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("computeIfAbsent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$13(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("computeIfPresent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$14(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar.f("merge", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$15(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        mw3 = str9;
        a aVar2 = new a(kVar2, mw3);
        k kVar3 = kVar2;
        mv2 = mu;
        str12 = mw3;
        aVar2.f("empty", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$16(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar2.f("of", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$17(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar2.f("ofNullable", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$18(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar2.f("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$19(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        aVar2.f("ifPresent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$20(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        k kVar4 = kVar3;
        String str13 = mw5;
        k kVar5 = kVar4;
        new a(kVar4, uVar.mu("ref/Reference")).f("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$21(uVar2, str, str2, str4, str6, str8, mu, str10, str11, str12));
        mw6 = str3;
        str2 = mw6;
        str8 = str13;
        String str14 = mw6;
        mv2 = mu;
        new a(kVar5, mw6).f("test", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$22(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        str2 = str14;
        new a(kVar5, uVar.mw("BiPredicate")).f("test", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$23(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        mw6 = str5;
        String str15 = mw6;
        new a(kVar5, mw6).f("accept", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$24(uVar2, mw6, str2, str4, str6, str8, mu, str10, str11, str12));
        mw6 = str13;
        str = str15;
        str8 = mw6;
        String str16 = mw6;
        mv2 = mu;
        new a(kVar5, mw6).f("accept", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$25(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        str8 = str16;
        new a(kVar5, mw2).f("apply", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$26(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        new a(kVar5, mw4).f("apply", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$27(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        new a(kVar5, uVar.mw("Supplier")).f("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$28(uVar2, str, str2, str4, str6, str8, mv2, str10, str11, str12));
        eIK = kVar5.build();
    }

    public static final Map<String, h> bhZ() {
        return eIK;
    }
}
