package com.iqoption.asset.repository;

import android.content.Context;
import android.content.SharedPreferences;
import com.iqoption.core.f;
import io.reactivex.BackpressureStrategy;
import io.reactivex.e;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;
import org.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00132\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00152\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/asset/repository/AssetFavoritesRepository;", "", "()V", "FAVORITES_IDS", "", "updatesStream", "Lcom/iqoption/asset/repository/AssetFavoritesRepository$UpdatesStream;", "addToFavorites", "", "userId", "", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getFavorites", "", "", "getPreferences", "Landroid/content/SharedPreferences;", "getUpdatesSubject", "Lio/reactivex/subjects/PublishSubject;", "observeFavorites", "Lio/reactivex/Flowable;", "removeFromFavorites", "saveIds", "ids", "UpdatesStream", "asset_release"})
/* compiled from: AssetFavoritesRepository.kt */
public final class a {
    private static a aqn;
    public static final a aqo = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/asset/repository/AssetFavoritesRepository$UpdatesStream;", "", "userId", "", "subject", "Lio/reactivex/subjects/PublishSubject;", "", "", "(JLio/reactivex/subjects/PublishSubject;)V", "getSubject", "()Lio/reactivex/subjects/PublishSubject;", "getUserId", "()J", "asset_release"})
    /* compiled from: AssetFavoritesRepository.kt */
    private static final class a {
        private final PublishSubject<Set<Integer>> aqp;
        private final long userId;

        public a(long j, PublishSubject<Set<Integer>> publishSubject) {
            h.e(publishSubject, "subject");
            this.userId = j;
            this.aqp = publishSubject;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final PublishSubject<Set<Integer>> Jp() {
            return this.aqp;
        }
    }

    private a() {
    }

    public final e<Set<Integer>> az(long j) {
        e<Set<Integer>> c = e.bW(aB(j)).c((b) aA(j).a(BackpressureStrategy.LATEST));
        h.d(c, "Flowable.just(getFavorit…pressureStrategy.LATEST))");
        return c;
    }

    private final PublishSubject<Set<Integer>> aA(long j) {
        a aVar = aqn;
        if (aVar != null && aVar.getUserId() == j) {
            return aVar.Jp();
        }
        PublishSubject<Set<Integer>> aXA = PublishSubject.aXA();
        h.d(aXA, "subject");
        aqn = new a(j, aXA);
        return aXA;
    }

    private final Set<Integer> aB(long j) {
        Set stringSet = aC(j).getStringSet("FAVORITES_IDS", aj.emptySet());
        h.d(stringSet, "getPreferences(userId).g…AVORITES_IDS, emptySet())");
        Iterable<String> iterable = stringSet;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (String str : iterable) {
            h.d(str, "it");
            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
        return u.Y((List) arrayList);
    }

    private final SharedPreferences aC(long j) {
        Context context = f.RQ().getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AssetFavorites[");
        stringBuilder.append(j);
        stringBuilder.append(']');
        SharedPreferences sharedPreferences = context.getSharedPreferences(stringBuilder.toString(), 0);
        h.d(sharedPreferences, "core.context.getSharedPr…]\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
