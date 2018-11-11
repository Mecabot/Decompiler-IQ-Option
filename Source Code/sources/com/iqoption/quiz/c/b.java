package com.iqoption.quiz.c;

import android.support.v7.util.DiffUtil.Callback;
import java.util.List;
import kotlin.e.a;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dR7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, aXE = {"Lcom/iqoption/quiz/util/DiffCallback;", "T", "Lcom/iqoption/quiz/util/Identifiable;", "Landroid/support/v7/util/DiffUtil$Callback;", "()V", "<set-?>", "", "new", "getNew", "()Ljava/util/List;", "setNew", "(Ljava/util/List;)V", "new$delegate", "Lkotlin/properties/ReadWriteProperty;", "old", "getOld", "setOld", "old$delegate", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "init", "", "request", "Lcom/iqoption/quiz/util/DiffRequest;", "quiz_release"})
/* compiled from: DiffCallback.kt */
public final class b<T extends e<?>> extends Callback {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "old", "getOld()Ljava/util/List;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "new", "getNew()Ljava/util/List;"))};
    private final d bgo = a.euA.aYg();
    private final d bgp = a.euA.aYg();

    public final List<T> ZP() {
        return (List) this.bgo.b(this, apP[0]);
    }

    public final List<T> ZQ() {
        return (List) this.bgp.b(this, apP[1]);
    }

    public final void aq(List<? extends T> list) {
        h.e(list, "<set-?>");
        this.bgo.a(this, apP[0], list);
    }

    public final void ar(List<? extends T> list) {
        h.e(list, "<set-?>");
        this.bgp.a(this, apP[1], list);
    }

    public int getOldListSize() {
        return ZP().size();
    }

    public int getNewListSize() {
        return ZQ().size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return h.E(((e) ZP().get(i)).Jf(), ((e) ZQ().get(i2)).Jf());
    }

    public boolean areContentsTheSame(int i, int i2) {
        return h.E((e) ZP().get(i), (e) ZQ().get(i2));
    }

    public final void a(c<T> cVar) {
        h.e(cVar, "request");
        aq(cVar.ZP());
        ar(cVar.ZQ());
    }
}
