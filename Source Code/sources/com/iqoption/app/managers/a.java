package com.iqoption.app.managers;

import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.dto.PushSetting;
import com.iqoption.dto.entity.BackCall;
import com.iqoption.dto.entity.SpecialOffer;
import com.iqoption.dto.entity.TopFeedTrader.List;
import com.iqoption.dto.entity.Tournament;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DataManager */
public class a {
    private static final String TAG = "com.iqoption.app.managers.a";
    private static final n<a> amh = Suppliers.a(new n<a>() {
        /* renamed from: Gk */
        public a get() {
            return new a();
        }
    });
    private final ArrayList<SpecialOffer> ami;
    private BackCall amj;
    private final ArrayList<Tournament> amk;
    private final HashMap<Integer, List> aml;
    private volatile long amm;
    private final Map<Integer, Set<Integer>> amn;
    private final ArrayList<Integer> feedTopTradersPostUssrCountries;
    private final ArrayList<PushSetting> pushSettings;

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private a() {
        this.ami = new ArrayList();
        this.pushSettings = new ArrayList();
        this.feedTopTradersPostUssrCountries = new ArrayList();
        this.amk = new ArrayList();
        this.aml = new HashMap();
        this.amn = new ConcurrentHashMap();
    }

    public static a Gf() {
        return (a) amh.get();
    }

    public void clear() {
        this.amk.clear();
        this.pushSettings.clear();
        this.feedTopTradersPostUssrCountries.clear();
        this.aml.clear();
        this.ami.clear();
        this.amn.clear();
    }

    public BackCall Gg() {
        return this.amj;
    }

    public void a(BackCall backCall) {
        this.amj = backCall;
    }

    public ArrayList<PushSetting> Gh() {
        return this.pushSettings;
    }

    public void x(Collection<PushSetting> collection) {
        this.pushSettings.clear();
        this.pushSettings.addAll(collection);
    }

    public ArrayList<Integer> Gi() {
        return this.feedTopTradersPostUssrCountries;
    }

    public void y(Collection<Integer> collection) {
        if (collection != null) {
            this.feedTopTradersPostUssrCountries.clear();
            this.feedTopTradersPostUssrCountries.addAll(collection);
        }
    }

    public ArrayList<Tournament> Gj() {
        return this.amk;
    }

    public void a(HashMap<Integer, List> hashMap, long j) {
        if (hashMap != null) {
            this.aml.clear();
            this.aml.putAll(hashMap);
            this.amm = j;
        }
    }

    public void a(Integer num, Set<Integer> set) {
        this.amn.put(num, set);
    }

    public boolean a(Integer num, int i) {
        Set set = (Set) this.amn.get(num);
        return set == null || set.contains(Integer.valueOf(i));
    }
}
