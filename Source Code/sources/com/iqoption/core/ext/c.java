package com.iqoption.core.ext;

import android.text.format.DateUtils;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.dto.entity.position.Position;
import io.reactivex.c.f;
import io.reactivex.o;
import io.reactivex.s;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000ú\u0001\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.H\u0002\u001a/\u0010/\u001a\u00020\"\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\"03H\b\u001a*\u00104\u001a\u0002H0\"\u0004\b\u0000\u001002\u0006\u00105\u001a\u0002062\f\u00102\u001a\b\u0012\u0004\u0012\u0002H007H\b¢\u0006\u0002\u00108\u001a6\u00109\u001a\u0004\u0018\u0001H0\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\"03H\b¢\u0006\u0002\u0010:\u001a<\u0010;\u001a\u0002H0\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0006\u0010<\u001a\u0002H02\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\"03H\b¢\u0006\u0002\u0010=\u001a4\u0010>\u001a\u0002H0\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\"03H\b¢\u0006\u0002\u0010:\u001a&\u0010?\u001a\b\u0012\u0004\u0012\u0002H00@\"\u0004\b\u0000\u001002\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00A07\u001a\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00112\b\b\u0002\u0010E\u001a\u00020\u0011\u001a&\u0010F\u001a\b\u0012\u0004\u0012\u0002H00G\"\u0004\b\u0000\u001002\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00A07\u001a0\u0010H\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H0H0 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H0H0\u0018\u00010J0I\"\u0004\b\u0000\u00100\u001a*\u0010K\u001a\u0004\u0018\u0001H0\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0006\u0010L\u001a\u00020\u0011H\b¢\u0006\u0002\u0010M\u001a0\u0010N\u001a\u0002H0\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0006\u0010L\u001a\u00020\u00112\u0006\u0010<\u001a\u0002H0H\b¢\u0006\u0002\u0010O\u001a(\u0010P\u001a\u0002H0\"\u0010\b\u0000\u00100\u0018\u0001*\b\u0012\u0004\u0012\u0002H0012\u0006\u0010L\u001a\u00020\u0011H\b¢\u0006\u0002\u0010M\u001a1\u0010Q\u001a\b\u0012\u0004\u0012\u0002H00J\"\u0004\b\u0000\u00100*\b\u0012\u0004\u0012\u0002H00J2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u0002H0¢\u0006\u0002\u0010T\u001a4\u0010/\u001a\u00020\"\"\u0004\b\u0000\u00100*\n\u0012\u0006\b\u0001\u0012\u0002H00U2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\"03H\b¢\u0006\u0002\u0010W\u001a\u0015\u0010X\u001a\u00020\u0011*\u00020\u00112\u0006\u0010Y\u001a\u00020\u0011H\u0004\u001a\n\u0010Z\u001a\u00020[*\u00020[\u001a\u0015\u0010\\\u001a\u00020\u0011*\u00020\u00112\u0006\u0010Y\u001a\u00020\u0011H\u0004\u001a\n\u0010]\u001a\u00020^*\u00020[\u001a\n\u0010_\u001a\u00020^*\u00020[\u001a\u0012\u0010`\u001a\u00020^*\u00020[2\u0006\u0010a\u001a\u00020^\u001a\u0012\u0010a\u001a\u00020^*\u00020&2\u0006\u0010b\u001a\u00020\u0011\u001a\u0012\u0010a\u001a\u00020^*\u00020c2\u0006\u0010b\u001a\u00020\u0011\u001a\n\u0010d\u001a\u00020^*\u00020[\u001a)\u0010e\u001a\u00020\"\"\u0004\b\u0000\u00100*\u0002H02\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H00U\"\u0002H0¢\u0006\u0002\u0010g\u001a\n\u0010h\u001a\u00020\"*\u00020[\u001a\u0012\u0010i\u001a\u00020\"*\u00020[2\u0006\u0010j\u001a\u00020[\u001a\n\u0010k\u001a\u00020\"*\u00020[\u001a\n\u0010l\u001a\u00020\"*\u00020[\u001a\n\u0010m\u001a\u00020\"*\u00020[\u001a\n\u0010n\u001a\u00020\"*\u00020[\u001a\u001c\u0010o\u001a\u00020c*\u00020c2\u0006\u0010p\u001a\u00020c2\b\b\u0002\u0010q\u001a\u00020c\u001a\u001c\u0010o\u001a\u00020c*\u00020\u00112\u0006\u0010p\u001a\u00020\u00112\b\b\u0002\u0010q\u001a\u00020\u0011\u001a#\u0010r\u001a\u0002H0\"\b\b\u0000\u00100*\u00020s*\u0004\u0018\u0001H02\u0006\u0010S\u001a\u0002H0¢\u0006\u0002\u0010t\u001a\u0014\u0010u\u001a\n \u0017*\u0004\u0018\u00010\r0\r*\u0004\u0018\u00010\r\u001a\u0014\u0010v\u001a\u00020&*\u00020w2\u0006\u0010D\u001a\u00020\u0011H\u0002\u001a\u0014\u0010x\u001a\u00020\u0011*\u00020w2\u0006\u0010D\u001a\u00020\u0011H\u0002\u001a\u0012\u0010y\u001a\u00020\r*\u00020\r2\u0006\u0010z\u001a\u00020\r\u001a\u001b\u0010{\u001a\u00020|*\u00020}2\f\u00102\u001a\b\u0012\u0004\u0012\u00020|07H\b\u001a$\u0010~\u001a\b\u0012\u0004\u0012\u0002H00J\"\u0004\b\u0000\u00100*\b\u0012\u0004\u0012\u0002H00J2\u0006\u0010R\u001a\u00020\u0011\u001a3\u0010\u001a\b\u0012\u0004\u0012\u0002H00J\"\u0004\b\u0000\u00100*\b\u0012\u0004\u0012\u0002H00J2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u0002H0H\u0007¢\u0006\u0002\u0010T\u001a2\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H00J\"\u0004\b\u0000\u00100*\b\u0012\u0004\u0012\u0002H00J2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u0002H0¢\u0006\u0002\u0010T\u001a\u000b\u0010\u0001\u001a\u00020|*\u00020\u0016\u001a'\u0010\u0001\u001a\u00020|\"\u0004\b\u0000\u00100*\t\u0012\u0004\u0012\u0002H00\u00012\r\u0010-\u001a\t\u0012\u0004\u0012\u0002H00\u0001\u001a\u0017\u0010\u0001\u001a\u00020\r*\u00020w2\n\b\u0002\u0010\u0001\u001a\u00030\u0001\u001a\u0017\u0010\u0001\u001a\u00020\r*\u00020^2\n\b\u0002\u0010\u0001\u001a\u00030\u0001\u001a\u000b\u0010\u0001\u001a\u00020&*\u00020w\u001a\u000b\u0010\u0001\u001a\u00020\u0011*\u00020w\u001a\u000b\u0010\u0001\u001a\u00020[*\u00020\u0011\u001a\u0014\u0010\u0001\u001a\u00020^*\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0011\u001a\u0017\u0010\u0001\u001a\u00020^*\u0004\u0018\u00010^2\b\b\u0002\u0010<\u001a\u00020^\u001a\r\u0010\u0001\u001a\u00020^*\u0004\u0018\u00010^\u001a\u000f\u0010\u0001\u001a\u0004\u0018\u00010^*\u0004\u0018\u00010^\u001a<\u0010\u0001\u001a\u0003H\u0001\"\t\b\u0000\u00100*\u00030\u0001\"\u0005\b\u0001\u0010\u0001*\u0002H02\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u0002H0\u0012\u0005\u0012\u0003H\u000103H\b¢\u0006\u0003\u0010\u0001\u001a&\u0010\u0001\u001a\u0011\u0012\f\u0012\n \u0017*\u0004\u0018\u0001H0H00\u0001\"\u0004\b\u0000\u00100*\u0002H0¢\u0006\u0003\u0010\u0001\u001a\u001c\u0010\u0001\u001a\u00020|*\u00020}2\f\u00102\u001a\b\u0012\u0004\u0012\u00020|07H\b\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\"\u0016\u0010 \u001a\u00020!*\u00020\"8Æ\u0002¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0016\u0010%\u001a\u00020&*\u00020\"8Æ\u0002¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0016\u0010)\u001a\u00020\u0011*\u00020\"8Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006\u0001"}, aXE = {"EMPTY_DOUBLE_ARRAY", "", "getEMPTY_DOUBLE_ARRAY", "()[D", "EMPTY_INT_ARRAY", "", "getEMPTY_INT_ARRAY", "()[I", "EMPTY_LONG_ARRAY", "", "getEMPTY_LONG_ARRAY", "()[J", "HUNDRED", "Ljava/math/BigDecimal;", "getHUNDRED", "()Ljava/math/BigDecimal;", "INT_BITS", "", "NUM_CHARS", "", "NUM_INTS", "REUSABLE_CALENDAR", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getREUSABLE_CALENDAR", "()Ljava/util/Calendar;", "TIME_FORMAT", "Ljava/text/SimpleDateFormat;", "getTIME_FORMAT", "()Ljava/text/SimpleDateFormat;", "TIME_FORMAT$delegate", "Lkotlin/Lazy;", "asByte", "", "", "getAsByte", "(Z)B", "asDouble", "", "getAsDouble", "(Z)D", "asInt", "getAsInt", "(Z)I", "charNumToInt", "c", "", "contains", "T", "", "block", "Lkotlin/Function1;", "doLocking", "lock", "Ljava/util/concurrent/locks/Lock;", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "find", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Enum;", "findOrDefault", "default", "(Ljava/lang/Enum;Lkotlin/jvm/functions/Function1;)Ljava/lang/Enum;", "findOrFirst", "fromFutureSupplier", "Lio/reactivex/Flowable;", "Ljava/util/concurrent/Future;", "intRange", "Lkotlin/ranges/IntRange;", "start", "end", "singleFromFutureSupplier", "Lio/reactivex/Single;", "synchronizedList", "", "", "withOrdinal", "ordinal", "(I)Ljava/lang/Enum;", "withOrdinalOrDefault", "(ILjava/lang/Enum;)Ljava/lang/Enum;", "withOrdinalOrFirst", "addAt", "index", "value", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", "", "predicate", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "cshl", "bits", "currentTimeDiff", "", "cushr", "durationFormatHHMMSS", "", "durationFormatMMSS", "durationFormatSeconds", "format", "digits", "", "formatTime", "isOneOf", "objects", "(Ljava/lang/Object;[Ljava/lang/Object;)Z", "isPastTime", "isTheSameDay", "another", "isThisDay", "isThisWeek", "isThisYear", "isYesterday", "norm", "max", "min", "or", "", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;", "orZero", "parseUnsignedDouble", "", "parseUnsignedInt", "percentOf", "b", "readBlock", "", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "removeAt", "set", "setAt", "setDayStartTime", "swapBy", "", "", "toBigDecimal", "mc", "Ljava/math/MathContext;", "toDouble", "toInt", "toUnsignedLong", "toUnsignedString", "radix", "translate", "translateOrKey", "translateOrNull", "using", "R", "Lcom/iqoption/core/util/Recyclable;", "(Lcom/iqoption/core/util/Recyclable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "weak", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/Object;)Ljava/lang/ref/WeakReference;", "writeBlock", "core_release"})
/* compiled from: CoreExtensions.kt */
public final class c {
    private static final BigDecimal aPe = new BigDecimal("100");
    private static final d aPf = g.f(CoreExtensionsKt$TIME_FORMAT$2.aPm);
    private static final Calendar aPg = Calendar.getInstance();
    private static final double[] aPh = new double[0];
    private static final long[] aPi = new long[0];
    private static final int[] aPj = new int[0];
    private static final char[] aPk = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int[] aPl = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference0Impl(kotlin.jvm.internal.j.e(c.class, "core_release"), "TIME_FORMAT", "getTIME_FORMAT()Ljava/text/SimpleDateFormat;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "T", "call"})
    /* compiled from: CoreExtensions.kt */
    static final class a<V> implements Callable<T> {
        public static final a aPn = new a();

        a() {
        }

        public final void SW() {
        }

        public /* synthetic */ Object call() {
            SW();
            return l.etX;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "T", "kotlin.jvm.PlatformType", "it", "", "apply", "(Lkotlin/Unit;)Lio/reactivex/Single;"})
    /* compiled from: CoreExtensions.kt */
    static final class b<T, R> implements f<T, s<? extends R>> {
        final /* synthetic */ kotlin.jvm.a.a aPo;

        b(kotlin.jvm.a.a aVar) {
            this.aPo = aVar;
        }

        /* renamed from: a */
        public final o<T> apply(l lVar) {
            h.e(lVar, "it");
            return o.f((Future) this.aPo.invoke());
        }
    }

    public static final SimpleDateFormat SR() {
        d dVar = aPf;
        j jVar = apP[0];
        return (SimpleDateFormat) dVar.getValue();
    }

    public static final int ad(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public static final int ae(int i, int i2) {
        return (i << (32 - i2)) | (i >>> i2);
    }

    public static final float c(float f, float f2, float f3) {
        return f < f3 ? 0.0f : f < f2 ? (f - f3) / (f2 - f3) : 1.0f;
    }

    public static final long toUnsignedLong(int i) {
        return i < 0 ? ((long) (i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)) | 2147483648L : (long) i;
    }

    public static /* synthetic */ float a(float f, float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        return c(f, f2, f3);
    }

    public static final String b(double d, int i) {
        m mVar = m.euz;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.");
        stringBuilder.append(i);
        stringBuilder.append('f');
        String stringBuilder2 = stringBuilder.toString();
        Object[] objArr = new Object[]{Double.valueOf(d)};
        String format = String.format(stringBuilder2, Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final <T> void b(Collection<T> collection, Collection<? extends T> collection2) {
        h.e(collection, "$receiver");
        h.e(collection2, "c");
        collection.clear();
        collection.addAll(collection2);
    }

    public static final <T> boolean b(T t, T... tArr) {
        h.e(tArr, "objects");
        for (Object obj : tArr) {
            if (h.E(t, obj)) {
                break;
            }
        }
        Object obj2 = null;
        return obj2 != null;
    }

    public static final <T> WeakReference<T> bf(T t) {
        return new WeakReference(t);
    }

    private static final Calendar SS() {
        Calendar calendar = aPg;
        h.d(calendar, "field");
        calendar.setTimeInMillis(System.currentTimeMillis());
        return aPg;
    }

    public static final boolean aQ(long j) {
        return DateUtils.isToday(j);
    }

    public static final boolean aL(long j) {
        Calendar SS = SS();
        SS.set(6, 1);
        SS.set(11, 0);
        SS.clear(12);
        SS.clear(13);
        SS.clear(14);
        h.d(SS, "c");
        long timeInMillis = SS.getTimeInMillis();
        SS.add(1, 1);
        long timeInMillis2 = SS.getTimeInMillis() - 1;
        if (timeInMillis <= j && timeInMillis2 >= j) {
            return true;
        }
        return false;
    }

    public static final boolean aK(long j) {
        boolean z = false;
        if (aQ(j)) {
            return false;
        }
        Calendar SS = SS();
        SS.set(11, 0);
        SS.clear(12);
        SS.clear(13);
        SS.clear(14);
        SS.add(6, -1);
        h.d(SS, "c");
        if (j >= SS.getTimeInMillis()) {
            z = true;
        }
        return z;
    }

    public static final String aR(long j) {
        String format = SR().format(Long.valueOf(j));
        h.d(format, "TIME_FORMAT.format(this)");
        return format;
    }

    public static final boolean l(long j, long j2) {
        Calendar SS = SS();
        h.d(SS, "c1");
        SS.setTimeInMillis(j);
        a(SS);
        int i = SS.get(1);
        int i2 = SS.get(6);
        Calendar SS2 = SS();
        h.d(SS2, "c2");
        SS2.setTimeInMillis(j2);
        a(SS2);
        int i3 = SS2.get(1);
        int i4 = SS2.get(6);
        if (i == i3 && i2 == i4) {
            return true;
        }
        return false;
    }

    public static final boolean aS(long j) {
        return j - System.currentTimeMillis() < 0;
    }

    public static final void a(Calendar calendar) {
        h.e(calendar, "$receiver");
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
    }

    public static final long aT(long j) {
        return j - System.currentTimeMillis();
    }

    public static final String aU(long j) {
        long toHours = TimeUnit.MILLISECONDS.toHours(j);
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1);
        j = TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1);
        m mVar = m.euz;
        Object[] objArr = new Object[]{Long.valueOf(toHours), Long.valueOf(toMinutes), Long.valueOf(j)};
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String aV(long j) {
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(j);
        j = TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1);
        m mVar = m.euz;
        Object[] objArr = new Object[]{Long.valueOf(toMinutes), Long.valueOf(j)};
        String format = String.format("%02d:%02d", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final <T> o<T> b(kotlin.jvm.a.a<? extends Future<T>> aVar) {
        h.e(aVar, "block");
        o<T> k = o.h((Callable) a.aPn).k(new b(aVar));
        h.d(k, "Single.fromCallable {}\n …re(block())\n            }");
        return k;
    }

    public static final long[] ST() {
        return aPi;
    }

    public static final int[] SU() {
        return aPj;
    }

    public static final <T> List<T> a(List<? extends T> list, int i, T t) {
        h.e(list, "$receiver");
        List<T> O = u.O((Collection) list);
        O.set(i, t);
        return O;
    }

    public static final <T> List<T> b(List<? extends T> list, int i, T t) {
        h.e(list, "$receiver");
        List<T> O = u.O((Collection) list);
        O.set(i, t);
        return O;
    }

    public static final <T> List<T> a(List<? extends T> list, int i) {
        h.e(list, "$receiver");
        List<T> O = u.O((Collection) list);
        O.remove(i);
        return O;
    }

    public static final int s(CharSequence charSequence) {
        h.e(charSequence, "$receiver");
        if (charSequence.length() == 0) {
            throw new NumberFormatException("CharSequence is empty");
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '+') {
            return h(charSequence, 1);
        }
        if (charAt != '-') {
            return h(charSequence, 0);
        }
        return -h(charSequence, 1);
    }

    public static final double t(CharSequence charSequence) {
        h.e(charSequence, "$receiver");
        if (charSequence.length() == 0) {
            throw new NumberFormatException("CharSequence is empty");
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '+') {
            return i(charSequence, 1);
        }
        if (charAt != '-') {
            return i(charSequence, 0);
        }
        return -i(charSequence, 1);
    }

    private static final int A(char c) {
        return aPl[i.b(aPk, c)];
    }

    private static final int h(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (Character.isDigit(charAt)) {
                if (i2 != 0) {
                    i2 *= 10;
                }
                i2 += A(charAt);
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong char sequence: ");
                stringBuilder.append(charSequence);
                throw new NumberFormatException(stringBuilder.toString());
            }
        }
        return i2;
    }

    /* JADX WARNING: Missing block: B:32:0x009b, code:
            r7 = 2;
     */
    private static final double i(java.lang.CharSequence r19, int r20) {
        /*
        r0 = r19;
        r1 = r19.length();
        r4 = 0;
        r6 = r20;
        r9 = r4;
        r11 = r9;
        r13 = r11;
        r7 = 0;
        r8 = 1;
        r15 = 0;
        r16 = 0;
    L_0x0012:
        if (r6 == r1) goto L_0x00e1;
    L_0x0014:
        r2 = r0.charAt(r6);
        r17 = 2;
        r3 = 10;
        switch(r7) {
            case 0: goto L_0x009d;
            case 1: goto L_0x0061;
            case 2: goto L_0x0021;
            default: goto L_0x001f;
        };
    L_0x001f:
        goto L_0x00db;
    L_0x0021:
        r17 = java.lang.Character.isDigit(r2);
        if (r17 == 0) goto L_0x0036;
    L_0x0027:
        r17 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r17 == 0) goto L_0x002e;
    L_0x002b:
        r4 = (double) r3;
        r9 = r9 * r4;
    L_0x002e:
        r2 = A(r2);
        r2 = (double) r2;
        r9 = r9 + r2;
        goto L_0x00db;
    L_0x0036:
        r3 = 45;
        if (r2 != r3) goto L_0x0041;
    L_0x003a:
        if (r16 != 0) goto L_0x0041;
    L_0x003c:
        r8 = 0;
    L_0x003d:
        r16 = 1;
        goto L_0x00db;
    L_0x0041:
        r3 = 43;
        if (r2 != r3) goto L_0x0048;
    L_0x0045:
        if (r16 != 0) goto L_0x0048;
    L_0x0047:
        goto L_0x003d;
    L_0x0048:
        r1 = new java.lang.NumberFormatException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Wrong char sequence: ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
    L_0x0061:
        r4 = java.lang.Character.isDigit(r2);
        if (r4 == 0) goto L_0x0079;
    L_0x0067:
        r4 = 0;
        r17 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1));
        if (r17 == 0) goto L_0x0070;
    L_0x006d:
        r3 = (double) r3;
        r11 = r11 * r3;
    L_0x0070:
        r2 = A(r2);
        r2 = (double) r2;
        r11 = r11 + r2;
        r15 = r15 + 1;
        goto L_0x00db;
    L_0x0079:
        r3 = 69;
        if (r2 == r3) goto L_0x009b;
    L_0x007d:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r2 != r3) goto L_0x0082;
    L_0x0081:
        goto L_0x009b;
    L_0x0082:
        r1 = new java.lang.NumberFormatException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Wrong char sequence: ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
    L_0x009b:
        r7 = 2;
        goto L_0x00db;
    L_0x009d:
        r4 = java.lang.Character.isDigit(r2);
        if (r4 == 0) goto L_0x00b3;
    L_0x00a3:
        r4 = 0;
        r17 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1));
        if (r17 == 0) goto L_0x00ac;
    L_0x00a9:
        r3 = (double) r3;
        r13 = r13 * r3;
    L_0x00ac:
        r2 = A(r2);
        r2 = (double) r2;
        r13 = r13 + r2;
        goto L_0x00db;
    L_0x00b3:
        r3 = 46;
        if (r2 != r3) goto L_0x00b9;
    L_0x00b7:
        r7 = 1;
        goto L_0x00db;
    L_0x00b9:
        r3 = 69;
        if (r2 == r3) goto L_0x009b;
    L_0x00bd:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r2 != r3) goto L_0x00c2;
    L_0x00c1:
        goto L_0x009b;
    L_0x00c2:
        r1 = new java.lang.NumberFormatException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Wrong char sequence: ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
    L_0x00db:
        r6 = r6 + 1;
        r4 = 0;
        goto L_0x0012;
    L_0x00e1:
        if (r8 != 0) goto L_0x00e4;
    L_0x00e3:
        r9 = -r9;
    L_0x00e4:
        r0 = 0;
        r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        r3 = 4621819117588971520; // 0x4024000000000000 float:0.0 double:10.0;
        if (r2 == 0) goto L_0x0114;
    L_0x00ec:
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 == 0) goto L_0x0112;
    L_0x00f0:
        r0 = 0;
        r0 = (double) r0;
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0104;
    L_0x00f6:
        r0 = (double) r15;
        r0 = java.lang.Math.pow(r3, r0);
        r11 = r11 / r0;
        r13 = r13 + r11;
        r0 = java.lang.Math.pow(r3, r9);
        r13 = r13 * r0;
        goto L_0x013f;
    L_0x0104:
        r0 = (double) r15;
        r0 = java.lang.Math.pow(r3, r0);
        r11 = r11 / r0;
        r13 = r13 + r11;
        r0 = -r9;
        r0 = java.lang.Math.pow(r3, r0);
        r13 = r13 / r0;
        goto L_0x013f;
    L_0x0112:
        r0 = 0;
    L_0x0114:
        r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r2 == 0) goto L_0x0124;
    L_0x0118:
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 != 0) goto L_0x0124;
    L_0x011c:
        r0 = (double) r15;
        r0 = java.lang.Math.pow(r3, r0);
        r11 = r11 / r0;
        r13 = r13 + r11;
        goto L_0x013f;
    L_0x0124:
        r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r2 != 0) goto L_0x013f;
    L_0x0128:
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 == 0) goto L_0x013f;
    L_0x012c:
        r0 = 0;
        r0 = (double) r0;
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0139;
    L_0x0132:
        r0 = java.lang.Math.pow(r3, r9);
        r13 = r13 * r0;
        goto L_0x013f;
    L_0x0139:
        r0 = -r9;
        r0 = java.lang.Math.pow(r3, r0);
        r13 = r13 / r0;
    L_0x013f:
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ext.c.i(java.lang.CharSequence, int):double");
    }

    public static final String gq(String str) {
        return str != null ? LocalizationUtil.translate(str) : null;
    }

    public static final String ab(String str, String str2) {
        h.e(str2, Position.CLOSE_REASON_DEFAULT);
        str = gq(str);
        return str != null ? str : str2;
    }

    public static final String gr(String str) {
        String gq = gq(str);
        if (gq != null) {
            return gq;
        }
        return str != null ? str : "";
    }

    public static final BigDecimal a(CharSequence charSequence, MathContext mathContext) {
        h.e(charSequence, "$receiver");
        h.e(mathContext, "mc");
        return new BigDecimal(t(charSequence), mathContext);
    }
}
