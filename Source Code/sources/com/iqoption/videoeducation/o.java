package com.iqoption.videoeducation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.MainThread;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.reactivex.c.k;
import io.reactivex.processors.PublishProcessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002)*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0007J\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020 H\u0007J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0017H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001a0\u001a0\u0016X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00100\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\nR\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00100\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, aXE = {"Lcom/iqoption/videoeducation/VideosHelper;", "Lio/reactivex/disposables/Disposable;", "categoryId", "", "(J)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "isSearchShown", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isSearchShownData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "searchDebouncer", "Lcom/iqoption/videoeducation/SearchDebouncer;", "tagItems", "", "Lcom/iqoption/videoeducation/VideoTagItem;", "getTagItems", "tagItemsData", "Landroid/arch/lifecycle/MutableLiveData;", "tagQueryProcessor", "Lio/reactivex/processors/PublishProcessor;", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "kotlin.jvm.PlatformType", "textQueryProcessor", "", "videoItems", "Lcom/iqoption/videoeducation/VideoAdapterItem;", "getVideoItems", "videoItemsData", "dispose", "", "hideSearch", "isDisposed", "search", "constraint", "", "showSearch", "toggleTag", "tag", "Companion", "Update", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideosHelper.kt */
public final class o implements io.reactivex.disposables.b {
    private static final String TAG = "o";
    public static final a dzs = new a();
    private final io.reactivex.disposables.a bco = new io.reactivex.disposables.a();
    private final long cSO;
    private final com.iqoption.core.data.b.c<Boolean> dzj = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> dzk = this.dzj;
    private final MutableLiveData<List<d>> dzl = new MutableLiveData();
    private final LiveData<List<d>> dzm = this.dzl;
    private final MutableLiveData<List<n>> dzn = new MutableLiveData();
    private final LiveData<List<n>> dzo = this.dzn;
    private final c dzp = new c(new f(this));
    private final PublishProcessor<String> dzq = PublishProcessor.aXq();
    private final PublishProcessor<com.iqoption.core.microservices.videoeducation.response.f> dzr = PublishProcessor.aXq();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/videoeducation/VideosHelper$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\b\u0018\u0000 )2\u00020\u0001:\u0001)Bi\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012*\b\u0002\u0010\n\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u000b\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u001b\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u000b\u0018\u00010\u000bHÆ\u0003Jm\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042*\b\u0002\u0010\n\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u000b\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00002\u0006\u0010#\u001a\u00020\bJ\t\u0010$\u001a\u00020\bHÖ\u0001J\u0010\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR3\u0010\n\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u000b\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006*"}, aXE = {"Lcom/iqoption/videoeducation/VideosHelper$Update;", "", "tags", "", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "videos", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "constraint", "", "tag", "index", "", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/iqoption/core/microservices/videoeducation/response/Tag;Ljava/util/Map;)V", "getConstraint", "()Ljava/lang/String;", "getIndex", "()Ljava/util/Map;", "getTag", "()Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "getTags", "()Ljava/util/List;", "getVideos", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "search", "text", "toString", "toggleTag", "newTag", "update", "new", "Companion", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosHelper.kt */
    private static final class b {
        public static final a dzx = new a();
        private final List<com.iqoption.core.microservices.videoeducation.response.g> dyQ;
        private final com.iqoption.core.microservices.videoeducation.response.f dzi;
        private final String dzv;
        private final Map<com.iqoption.core.microservices.videoeducation.response.f, Map<Character, List<com.iqoption.core.microservices.videoeducation.response.g>>> dzw;
        private final List<com.iqoption.core.microservices.videoeducation.response.f> gD;

        @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J6\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002JH\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u0012"}, aXE = {"Lcom/iqoption/videoeducation/VideosHelper$Update$Companion;", "", "()V", "buildCharIndex", "", "", "", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "videos", "", "createIndex", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "data", "search", "index", "searchText", "", "searchTag", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: VideosHelper.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            private final Map<com.iqoption.core.microservices.videoeducation.response.f, Map<Character, List<com.iqoption.core.microservices.videoeducation.response.g>>> bx(List<com.iqoption.core.microservices.videoeducation.response.g> list) {
                HashMap us = Maps.us();
                for (com.iqoption.core.microservices.videoeducation.response.g gVar : list) {
                    for (com.iqoption.core.microservices.videoeducation.response.f fVar : gVar.XX()) {
                        List list2 = (List) us.get(fVar);
                        if (list2 == null) {
                            list2 = Lists.tM();
                            kotlin.jvm.internal.h.d(us, "tagVideoMap");
                            us.put(fVar, list2);
                        }
                        if (list2 != null) {
                            list2.add(gVar);
                        }
                    }
                }
                HashMap us2 = Maps.us();
                Set<Entry> entrySet = us.entrySet();
                kotlin.jvm.internal.h.d(entrySet, "tagVideoMap.entries");
                for (Entry entry : entrySet) {
                    com.iqoption.core.microservices.videoeducation.response.f fVar2 = (com.iqoption.core.microservices.videoeducation.response.f) entry.getKey();
                    List list3 = (List) entry.getValue();
                    kotlin.jvm.internal.h.d(us2, com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
                    Map map = us2;
                    a aVar = b.dzx;
                    kotlin.jvm.internal.h.d(list3, "videos");
                    map.put(fVar2, aVar.by(list3));
                }
                kotlin.jvm.internal.h.d(us2, com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
                Map<com.iqoption.core.microservices.videoeducation.response.f, Map<Character, List<com.iqoption.core.microservices.videoeducation.response.g>>> map2 = us2;
                map2.put(null, by(u.O((Collection) list)));
                return map2;
            }

            private final Map<Character, List<com.iqoption.core.microservices.videoeducation.response.g>> by(List<com.iqoption.core.microservices.videoeducation.response.g> list) {
                HashMap us = Maps.us();
                for (com.iqoption.core.microservices.videoeducation.response.g gVar : list) {
                    List b = v.b((CharSequence) gVar.Mi(), new char[]{' '}, false, 0, 6, null);
                    if (!b.isEmpty()) {
                        ListIterator listIterator = b.listIterator(b.size());
                        while (listIterator.hasPrevious()) {
                            Object obj;
                            if (((String) listIterator.previous()).length() == 0) {
                                obj = 1;
                                continue;
                            } else {
                                obj = null;
                                continue;
                            }
                            if (obj == null) {
                                b = u.g(b, listIterator.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    b = m.emptyList();
                    for (String charAt : r4) {
                        char toLowerCase = Character.toLowerCase(charAt.charAt(0));
                        List list2 = (List) us.get(Character.valueOf(toLowerCase));
                        if (list2 == null) {
                            list2 = Lists.tM();
                            kotlin.jvm.internal.h.d(us, com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
                            us.put(Character.valueOf(toLowerCase), list2);
                        }
                        if (list2 != null) {
                            int i = 0;
                            for (com.iqoption.core.microservices.videoeducation.response.g id : list2) {
                                if ((id.getId() == gVar.getId() ? 1 : null) != null) {
                                    break;
                                }
                                i++;
                            }
                            i = -1;
                            if (i == -1) {
                                list2.add(gVar);
                            }
                        }
                    }
                }
                kotlin.jvm.internal.h.d(us, com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
                Map<Character, List<com.iqoption.core.microservices.videoeducation.response.g>> map = us;
                map.put(null, list);
                return map;
            }

            private final List<com.iqoption.core.microservices.videoeducation.response.g> a(Map<com.iqoption.core.microservices.videoeducation.response.f, ? extends Map<Character, ? extends List<com.iqoption.core.microservices.videoeducation.response.g>>> map, String str, com.iqoption.core.microservices.videoeducation.response.f fVar) {
                Map map2 = (Map) map.get(fVar);
                if (map2 == null) {
                    return m.emptyList();
                }
                CharSequence charSequence = str;
                if ((charSequence.length() == 0 ? 1 : null) != null) {
                    List<com.iqoption.core.microservices.videoeducation.response.g> list = (List) map2.get(null);
                    if (list == null) {
                        list = m.emptyList();
                    }
                    return list;
                }
                List list2 = (List) map2.get(Character.valueOf(str.charAt(0)));
                if (list2 == null) {
                    return m.emptyList();
                }
                Collection arrayList = new ArrayList();
                for (Object next : list2) {
                    if (v.b((CharSequence) ((com.iqoption.core.microservices.videoeducation.response.g) next).Mi(), charSequence, true)) {
                        arrayList.add(next);
                    }
                }
                return (List) arrayList;
            }
        }

        public b() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* bridge */ /* synthetic */ b a(b bVar, List list, List list2, String str, com.iqoption.core.microservices.videoeducation.response.f fVar, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                list = bVar.gD;
            }
            if ((i & 2) != 0) {
                list2 = bVar.dyQ;
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                str = bVar.dzv;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                fVar = bVar.dzi;
            }
            com.iqoption.core.microservices.videoeducation.response.f fVar2 = fVar;
            if ((i & 16) != 0) {
                map = bVar.dzw;
            }
            return bVar.a(list, list3, str2, fVar2, map);
        }

        public final b a(List<com.iqoption.core.microservices.videoeducation.response.f> list, List<com.iqoption.core.microservices.videoeducation.response.g> list2, String str, com.iqoption.core.microservices.videoeducation.response.f fVar, Map<com.iqoption.core.microservices.videoeducation.response.f, ? extends Map<Character, ? extends List<com.iqoption.core.microservices.videoeducation.response.g>>> map) {
            kotlin.jvm.internal.h.e(list, "tags");
            kotlin.jvm.internal.h.e(list2, "videos");
            return new b(list, list2, str, fVar, map);
        }

        /* JADX WARNING: Missing block: B:12:0x0038, code:
            if (kotlin.jvm.internal.h.E(r2.dzw, r3.dzw) != false) goto L_0x003d;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x003d;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.videoeducation.o.b;
            if (r0 == 0) goto L_0x003b;
        L_0x0006:
            r3 = (com.iqoption.videoeducation.o.b) r3;
            r0 = r2.gD;
            r1 = r3.gD;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x003b;
        L_0x0012:
            r0 = r2.dyQ;
            r1 = r3.dyQ;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x003b;
        L_0x001c:
            r0 = r2.dzv;
            r1 = r3.dzv;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x003b;
        L_0x0026:
            r0 = r2.dzi;
            r1 = r3.dzi;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x003b;
        L_0x0030:
            r0 = r2.dzw;
            r3 = r3.dzw;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x003b;
        L_0x003a:
            goto L_0x003d;
        L_0x003b:
            r3 = 0;
            return r3;
        L_0x003d:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.videoeducation.o.b.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            List list = this.gD;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List list2 = this.dyQ;
            hashCode = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            String str = this.dzv;
            hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            com.iqoption.core.microservices.videoeducation.response.f fVar = this.dzi;
            hashCode = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 31;
            Map map = this.dzw;
            if (map != null) {
                i = map.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Update(tags=");
            stringBuilder.append(this.gD);
            stringBuilder.append(", videos=");
            stringBuilder.append(this.dyQ);
            stringBuilder.append(", constraint=");
            stringBuilder.append(this.dzv);
            stringBuilder.append(", tag=");
            stringBuilder.append(this.dzi);
            stringBuilder.append(", index=");
            stringBuilder.append(this.dzw);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public b(List<com.iqoption.core.microservices.videoeducation.response.f> list, List<com.iqoption.core.microservices.videoeducation.response.g> list2, String str, com.iqoption.core.microservices.videoeducation.response.f fVar, Map<com.iqoption.core.microservices.videoeducation.response.f, ? extends Map<Character, ? extends List<com.iqoption.core.microservices.videoeducation.response.g>>> map) {
            kotlin.jvm.internal.h.e(list, "tags");
            kotlin.jvm.internal.h.e(list2, "videos");
            this.gD = list;
            this.dyQ = list2;
            this.dzv = str;
            this.dzi = fVar;
            this.dzw = map;
        }

        public /* synthetic */ b(List list, List list2, String str, com.iqoption.core.microservices.videoeducation.response.f fVar, Map map, int i, f fVar2) {
            if ((i & 1) != 0) {
                list = m.emptyList();
            }
            if ((i & 2) != 0) {
                list2 = m.emptyList();
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                str = (String) null;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                fVar = (com.iqoption.core.microservices.videoeducation.response.f) null;
            }
            com.iqoption.core.microservices.videoeducation.response.f fVar3 = fVar;
            if ((i & 16) != 0) {
                map = (((Collection) list3).isEmpty() ^ 1) != 0 ? dzx.bx(list3) : null;
            }
            this(list, list3, str2, fVar3, map);
        }

        public final List<com.iqoption.core.microservices.videoeducation.response.f> XX() {
            return this.gD;
        }

        public final List<com.iqoption.core.microservices.videoeducation.response.g> aHD() {
            return this.dyQ;
        }

        public final com.iqoption.core.microservices.videoeducation.response.f aHO() {
            return this.dzi;
        }

        public final b b(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "new");
            b jS;
            if (bVar.dzv != null) {
                jS = jS(bVar.dzv);
                if (jS != null) {
                    return jS;
                }
            } else if (bVar.dzi != null) {
                jS = b(bVar.dzi);
                if (jS != null) {
                    return jS;
                }
            }
            return bVar;
        }

        public final b jS(String str) {
            kotlin.jvm.internal.h.e(str, "text");
            Map map = this.dzw;
            if (map == null) {
                return null;
            }
            b bVar;
            if (kotlin.jvm.internal.h.E(str, this.dzv)) {
                bVar = this;
            } else {
                bVar = a(this, null, dzx.a(map, str, this.dzi), str, null, null, 25, null);
            }
            return bVar;
        }

        public final b b(com.iqoption.core.microservices.videoeducation.response.f fVar) {
            kotlin.jvm.internal.h.e(fVar, "newTag");
            Map map = this.dzw;
            if (map == null) {
                return null;
            }
            com.iqoption.core.microservices.videoeducation.response.f fVar2 = (kotlin.jvm.internal.h.E(fVar, this.dzi) ^ 1) != 0 ? fVar : null;
            a aVar = dzx;
            String str = this.dzv;
            if (str == null) {
                str = "";
            }
            return a(this, null, aVar.a(map, str, fVar2), null, fVar2, null, 21, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "update", "Lcom/iqoption/videoeducation/VideosHelper$Update;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: VideosHelper.kt */
    /* renamed from: com.iqoption.videoeducation.o$2 */
    static final class AnonymousClass2<T> implements io.reactivex.c.e<b> {
        final /* synthetic */ o dzu;

        AnonymousClass2(o oVar) {
            this.dzu = oVar;
        }

        /* renamed from: a */
        public final void accept(b bVar) {
            MutableLiveData c;
            Collection arrayList;
            if ((bVar.aHD().isEmpty() ^ 1) != 0) {
                c = this.dzu.dzl;
                Iterable<com.iqoption.core.microservices.videoeducation.response.g> aHD = bVar.aHD();
                arrayList = new ArrayList(n.e(aHD, 10));
                for (com.iqoption.core.microservices.videoeducation.response.g mVar : aHD) {
                    arrayList.add(new m(mVar));
                }
                c.postValue((List) arrayList);
            } else {
                this.dzu.dzl.postValue(l.cr(new l()));
            }
            c = this.dzu.dzn;
            Iterable<com.iqoption.core.microservices.videoeducation.response.f> XX = bVar.XX();
            arrayList = new ArrayList(n.e(XX, 10));
            for (com.iqoption.core.microservices.videoeducation.response.f fVar : XX) {
                arrayList.add(new n(fVar, kotlin.jvm.internal.h.E(fVar, bVar.aHO())));
            }
            c.postValue((List) arrayList);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: VideosHelper.kt */
    /* renamed from: com.iqoption.videoeducation.o$3 */
    static final class AnonymousClass3<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ o dzu;

        AnonymousClass3(o oVar) {
            this.dzu = oVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ki = o.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error during observing updates of video catalog with category ID: ");
            stringBuilder.append(this.dzu.cSO);
            com.iqoption.core.i.e(Ki, stringBuilder.toString());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/videoeducation/VideosHelper$Update;", "it", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "apply"})
    /* compiled from: VideosHelper.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, R> {
        public static final c dzy = new c();

        c() {
        }

        /* renamed from: b */
        public final b apply(com.iqoption.videoeducation.b.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "it");
            return new b(aVar.XX(), aVar.aHD(), null, null, null, 28, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/videoeducation/VideoEducationEvent;", "test"})
    /* compiled from: VideosHelper.kt */
    static final class d<T> implements k<i> {
        final /* synthetic */ o dzu;

        d(o oVar) {
            this.dzu = oVar;
        }

        /* renamed from: c */
        public final boolean test(i iVar) {
            kotlin.jvm.internal.h.e(iVar, "it");
            if (iVar instanceof k) {
                int i = 0;
                for (com.iqoption.core.microservices.videoeducation.response.a id : ((k) iVar).aHM().Kj()) {
                    if ((id.getId() == this.dzu.cSO ? 1 : null) != null) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    return true;
                }
            }
            return false;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/videoeducation/VideosHelper$Update;", "it", "Lcom/iqoption/videoeducation/VideoEducationEvent;", "apply"})
    /* compiled from: VideosHelper.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ o dzu;

        e(o oVar) {
            this.dzu = oVar;
        }

        /* renamed from: d */
        public final b apply(i iVar) {
            kotlin.jvm.internal.h.e(iVar, "it");
            for (Object next : iVar.aHz()) {
                Object obj;
                if (((com.iqoption.videoeducation.b.a) next).aHW().getId() == this.dzu.cSO) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            Object next2 = null;
            com.iqoption.videoeducation.b.a aVar = (com.iqoption.videoeducation.b.a) next2;
            if (aVar != null) {
                return new b(aVar.XX(), aVar.aHD(), null, null, null, 28, null);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Catalog with category ID ");
            stringBuilder.append(this.dzu.cSO);
            stringBuilder.append(" is not found");
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onPerformSearch"})
    /* compiled from: VideosHelper.kt */
    static final class f implements com.iqoption.videoeducation.c.a {
        final /* synthetic */ o dzu;

        f(o oVar) {
            this.dzu = oVar;
        }

        public final void p(CharSequence charSequence) {
            PublishProcessor a = this.dzu.dzq;
            String obj = charSequence.toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            obj = v.trim(obj).toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            obj = obj.toLowerCase();
            kotlin.jvm.internal.h.d(obj, "(this as java.lang.String).toLowerCase()");
            a.e(obj);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/videoeducation/VideosHelper$Update;", "it", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "apply"})
    /* compiled from: VideosHelper.kt */
    static final class g<T, R> implements io.reactivex.c.f<T, R> {
        public static final g dzz = new g();

        g() {
        }

        /* renamed from: c */
        public final b apply(com.iqoption.core.microservices.videoeducation.response.f fVar) {
            kotlin.jvm.internal.h.e(fVar, "it");
            return new b(null, null, null, fVar, null, 23, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/videoeducation/VideosHelper$Update;", "it", "", "apply"})
    /* compiled from: VideosHelper.kt */
    static final class h<T, R> implements io.reactivex.c.f<T, R> {
        public static final h dzA = new h();

        h() {
        }

        /* renamed from: jT */
        public final b apply(String str) {
            kotlin.jvm.internal.h.e(str, "it");
            return new b(null, null, str, null, null, 27, null);
        }
    }

    public o(long j) {
        this.cSO = j;
        this.bco.e(j.dyP.cp(this.cSO).n(c.dzy).aWk().c((org.a.b) io.reactivex.e.a((org.a.b) this.dzq.d((io.reactivex.c.f) h.dzA), (org.a.b) this.dzr.d((io.reactivex.c.f) g.dzz), (org.a.b) j.dyP.aDA().a((k) new d(this)).d((io.reactivex.c.f) new e(this)))).a((io.reactivex.c.b) AnonymousClass1.dzt).d(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass2(this), (io.reactivex.c.e) new AnonymousClass3(this)));
    }

    public final LiveData<Boolean> aHH() {
        return this.dzk;
    }

    public final LiveData<List<d>> aHI() {
        return this.dzm;
    }

    public final LiveData<List<n>> aHJ() {
        return this.dzo;
    }

    public boolean isDisposed() {
        return this.bco.isDisposed();
    }

    public void dispose() {
        this.bco.clear();
    }

    @MainThread
    public final void aHP() {
        this.dzj.setValue(Boolean.valueOf(true));
        com.iqoption.analytics.o.T(this.cSO);
    }

    @MainThread
    public final void aHL() {
        this.dzj.setValue(Boolean.valueOf(false));
    }

    @MainThread
    public final void r(CharSequence charSequence) {
        kotlin.jvm.internal.h.e(charSequence, "constraint");
        this.dzp.a(charSequence, 250);
    }

    @MainThread
    public final void a(com.iqoption.core.microservices.videoeducation.response.f fVar) {
        kotlin.jvm.internal.h.e(fVar, "tag");
        this.dzr.e(fVar);
        List list = (List) this.dzo.getValue();
        if (list != null) {
            for (Object next : list) {
                Object obj;
                if (((n) next).aHO().getId() == fVar.getId()) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            Object next2 = null;
            n nVar = (n) next2;
            if (nVar != null && !nVar.isSelected()) {
                com.iqoption.analytics.o.S(fVar.getId());
            }
        }
    }
}
