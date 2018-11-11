package com.iqoption.util;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.iqoption.util.fragmentstack.d;
import com.iqoption.util.fragmentstack.e;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\b\u001a,\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\u001a9\u0010\r\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\b\u001a,\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\t\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f¨\u0006\u0010"}, aXE = {"observe", "", "T", "Landroid/arch/lifecycle/LiveData;", "lifecycleOwner", "Landroid/arch/lifecycle/LifecycleOwner;", "onChange", "Lkotlin/Function1;", "observeFragment", "fragment", "Landroid/support/v4/app/Fragment;", "observer", "Landroid/arch/lifecycle/Observer;", "observeNullable", "observeSubFragment", "Lcom/iqoption/util/fragmentstack/VisibilityAwareFragment;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LiveDatas.kt */
public final class ar {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V"})
    /* compiled from: LiveDatas.kt */
    public static final class a<T> implements Observer<T> {
        final /* synthetic */ kotlin.jvm.a.b dwd;

        public a(kotlin.jvm.a.b bVar) {
            this.dwd = bVar;
        }

        public final void onChanged(T t) {
            if (t != null) {
                this.dwd.invoke(t);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, aXE = {"com/iqoption/util/LiveDatasKt$observeFragment$1", "Lcom/iqoption/util/fragmentstack/FragmentAwareLiveDataObserver;", "onCustomChange", "", "t", "(Ljava/lang/Object;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LiveDatas.kt */
    public static final class b extends com.iqoption.util.fragmentstack.b<T> {
        final /* synthetic */ Observer aOs;
        final /* synthetic */ Fragment bVu;

        b(Observer observer, Fragment fragment, Fragment fragment2) {
            this.aOs = observer;
            this.bVu = fragment;
            super(fragment2);
        }

        public void bI(T t) {
            this.aOs.onChanged(t);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, aXE = {"com/iqoption/util/LiveDatasKt$observeSubFragment$1", "Lcom/iqoption/util/fragmentstack/SubFragmentAwareLiveDataObserver;", "onCustomChange", "", "t", "(Ljava/lang/Object;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LiveDatas.kt */
    public static final class c extends d<T> {
        final /* synthetic */ Observer aOs;

        c(Observer observer) {
            this.aOs = observer;
        }

        public void bI(T t) {
            this.aOs.onChanged(t);
        }
    }

    public static final <T> void a(LiveData<T> liveData, Fragment fragment, Observer<T> observer) {
        h.e(liveData, "$receiver");
        h.e(fragment, "fragment");
        h.e(observer, "observer");
        LifecycleOwner lifecycleOwner = fragment;
        b bVar = new b(observer, fragment, fragment);
        FragmentActivity activity = fragment.zzakw();
        if (activity instanceof com.iqoption.activity.b) {
            ((com.iqoption.activity.b) activity).zG().a(fragment, bVar);
        }
        liveData.observe(lifecycleOwner, bVar);
    }

    public static final <T> void a(LiveData<T> liveData, e eVar, Observer<T> observer) {
        h.e(liveData, "$receiver");
        h.e(eVar, "fragment");
        h.e(observer, "observer");
        LifecycleOwner lifecycleOwner = eVar;
        c cVar = new c(observer);
        eVar.a(cVar);
        liveData.observe(lifecycleOwner, cVar);
    }

    public static final <T> void a(LiveData<T> liveData, LifecycleOwner lifecycleOwner, kotlin.jvm.a.b<? super T, l> bVar) {
        h.e(liveData, "$receiver");
        h.e(lifecycleOwner, "lifecycleOwner");
        h.e(bVar, "onChange");
        liveData.observe(lifecycleOwner, new a(bVar));
    }
}
