package com.iqoption.popup;

import java.util.Comparator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, aXE = {"Lcom/iqoption/popup/Popup;", "", "tag", "", "priority", "Lcom/iqoption/popup/PopupPriority;", "addTime", "", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/String;Lcom/iqoption/popup/PopupPriority;JLjava/lang/Runnable;)V", "getAddTime", "()J", "getPriority", "()Lcom/iqoption/popup/PopupPriority;", "getRunnable", "()Ljava/lang/Runnable;", "getTag", "()Ljava/lang/String;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Popup.kt */
public final class a {
    public static final Comparator<a> cXT = new b(new a());
    public static final c cXU = new c();
    private final PopupPriority cXR;
    private final long cXS;
    private final Runnable runnable;
    private final String tag;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Integer.valueOf(((a) t2).avE().getWeight()), Integer.valueOf(((a) t).avE().getWeight()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        final /* synthetic */ Comparator cba;

        public b(Comparator comparator) {
            this.cba = comparator;
        }

        public final int compare(T t, T t2) {
            int compare = this.cba.compare(t, t2);
            return compare != 0 ? compare : b.c(Long.valueOf(((a) t2).avF()), Long.valueOf(((a) t).avF()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/popup/Popup$Companion;", "", "()V", "POPUP_COMPARATOR", "Ljava/util/Comparator;", "Lcom/iqoption/popup/Popup;", "Lkotlin/Comparator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Popup.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }
    }

    public a(String str, PopupPriority popupPriority, long j, Runnable runnable) {
        h.e(str, "tag");
        h.e(popupPriority, "priority");
        h.e(runnable, "runnable");
        this.tag = str;
        this.cXR = popupPriority;
        this.cXS = j;
        this.runnable = runnable;
    }

    public final String getTag() {
        return this.tag;
    }

    public final PopupPriority avE() {
        return this.cXR;
    }

    public final long avF() {
        return this.cXS;
    }

    public final Runnable avG() {
        return this.runnable;
    }
}
