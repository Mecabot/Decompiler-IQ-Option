package com.iqoption.app.managers;

import android.support.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.w;
import com.google.gson.stream.JsonReader;
import com.iqoption.analytics.sla.Sla;
import com.iqoption.core.connect.d;
import com.iqoption.core.connect.e;
import com.iqoption.core.connect.f;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.service.WebSocketHandler;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: SubscribeManager */
public class y implements e {
    private static final String TAG = "com.iqoption.app.managers.y";
    private static final n<y> anD = Suppliers.a(z.ajD);
    private final w<b> anE = ConcurrentHashMultiset.sr();

    /* compiled from: SubscribeManager */
    public static class a<T> implements d<T> {
        private Class<T> anF;
        private kotlin.jvm.a.b<? super JsonReader, ? extends T> anG;
        private Map<String, Object> anH;
        private String anI = null;
        private boolean anJ = true;
        private String name;
        private Type type;
        private String version = "1.0";

        public a(String str, Class<T> cls) {
            this.name = str;
            this.anF = cls;
        }

        public a(String str, Type type) {
            this.name = str;
            this.type = type;
        }

        @NonNull
        public d<T> eT(@NonNull String str) {
            this.version = str;
            return this;
        }

        @NonNull
        public d<T> h(@NonNull String str, Object obj) {
            if (obj != null) {
                if (this.anH == null) {
                    this.anH = new HashMap();
                }
                this.anH.put(str, obj);
            } else if (this.anH != null) {
                this.anH.remove(str);
            }
            return this;
        }

        public d<T> eU(String str) {
            this.anI = str;
            return this;
        }

        @NonNull
        public io.reactivex.e<T> Hr() {
            f Hs = Hs();
            io.reactivex.e<T> d = WebSocketHandler.aDm().aDA().a(new aa(this)).aWd().d(new ab(this));
            return this.anJ ? d.b(new ac(Hs)).e(new ad(Hs)) : d;
        }

        final /* synthetic */ boolean b(com.iqoption.core.connect.n nVar) {
            return nVar.getName().equals(this.name);
        }

        public f Hs() {
            return new b(this.name, this.version, this.anH, this.anI);
        }
    }

    /* compiled from: SubscribeManager */
    private static class b implements f {
        final String anI;
        final HashMap<String, Object> anM;
        final String name;
        final String version;

        /* compiled from: SubscribeManager */
        static class a {
            private String anI;
            private HashMap<String, Object> anM;
            private final String name;
            private String version;

            a(@NonNull String str, String str2) {
                this.name = str;
                this.anI = str2;
            }

            a(@NonNull String str) {
                this(str, null);
            }

            @NonNull
            a eV(@NonNull String str) {
                this.version = str;
                return this;
            }

            @NonNull
            a i(@NonNull String str, Object obj) {
                if (obj != null) {
                    if (this.anM == null) {
                        this.anM = new HashMap();
                    }
                    this.anM.put(str, obj);
                } else if (this.anM != null) {
                    this.anM.remove(str);
                }
                return this;
            }

            @NonNull
            a a(HashMap<String, Object> hashMap) {
                this.anM = hashMap;
                return this;
            }

            @NonNull
            b Ht() {
                return new b(this);
            }
        }

        b(@NonNull String str, @NonNull String str2, Map<String, Object> map, String str3) {
            this.name = str;
            this.version = str2;
            if (map != null) {
                this.anM = new HashMap();
                this.anM.putAll(map);
            } else {
                this.anM = null;
            }
            this.anI = str3;
        }

        b(@NonNull a aVar) {
            this(aVar.name, aVar.version, aVar.anM, aVar.anI);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!(Objects.equals(this.name, bVar.name) && Objects.equals(this.version, bVar.version) && Objects.equals(this.anM, bVar.anM) && Objects.equals(this.anI, bVar.anI))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.name, this.version, this.anM, this.anI});
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SubscribeKey{name='");
            stringBuilder.append(this.name);
            stringBuilder.append('\'');
            stringBuilder.append(", version='");
            stringBuilder.append(this.version);
            stringBuilder.append('\'');
            stringBuilder.append(", params=");
            stringBuilder.append(this.anM);
            stringBuilder.append(", microService='");
            stringBuilder.append(this.anI);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public boolean bv(boolean z) {
            if (z) {
                return y.Hp().a(this);
            }
            return y.Hp().b(this);
        }
    }

    public static y Hp() {
        return (y) anD.get();
    }

    public boolean a(b bVar) {
        int count = this.anE.count(bVar);
        if (count != 0) {
            this.anE.add(bVar);
        } else if (com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz(bVar.name).g(bVar.anM).iA(bVar.version).iB(bVar.anI).exec()) {
            this.anE.add(bVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(" subscribe: ");
        stringBuilder.append(this.anE.toString());
        i.d(stringBuilder.toString());
        return count == 0;
    }

    public boolean b(b bVar) {
        int count = this.anE.count(bVar);
        if (count != 1) {
            this.anE.remove(bVar);
        } else if (com.iqoption.mobbtech.connect.request.api.f.iy("unsubscribeMessage").iz(bVar.name).g(bVar.anM).iA(bVar.version).iB(bVar.anI).exec()) {
            this.anE.remove(bVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(" unsubscribe: ");
        stringBuilder.append(this.anE.toString());
        i.d(stringBuilder.toString());
        if (count == 1) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.anE.clear();
    }

    public void Hq() {
        for (b bVar : this.anE.se()) {
            com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz(bVar.name).g(bVar.anM).iA(bVar.version).iB(bVar.anI).exec();
        }
    }

    public <T> d<T> c(String str, Class<T> cls) {
        return new a(str, (Class) cls);
    }

    public <T> d<T> b(String str, Type type) {
        return new a(str, type);
    }

    public static boolean a(boolean z, HashMap<String, Object> hashMap, String str) {
        return new a("expiration-list-changed", str).eV("4.0").a((HashMap) hashMap).Ht().bv(z);
    }

    public static boolean a(boolean z, int i, String str, InstrumentType instrumentType) {
        return new a("instrument-quotes-generated").i("active", Integer.valueOf(i)).i("underlying", str).i("kind", instrumentType).Ht().bv(z);
    }

    public static boolean a(boolean z, String str, InstrumentType instrumentType, int i) {
        b Ht = (InstrumentType.FX_INSTRUMENT == instrumentType ? new a("option-quote", "instruments-quotes-fx-option") : new a("option-quote")).i("instrument_type", instrumentType).i("user_group_id", Integer.valueOf(i)).i("instrument_id_escape", Position.getInstrumentIdEscape(str)).Ht();
        boolean bv = Ht.bv(z);
        if (bv) {
            Sla.Ci().a("quotes-digital", z, Ht);
        }
        return bv;
    }

    public static boolean a(boolean z, InstrumentType instrumentType) {
        return new a("top-assets-updated").eV("1.2").i("instrument_type", instrumentType).Ht().bv(z);
    }

    public static boolean a(boolean z, com.iqoption.mobbtech.connect.response.d.a aVar) {
        b Ht = new a("spot-buyback-quote-generated").i("active", aVar.activeId).i(Param.TIMESTAMP, aVar.expiration).Ht();
        boolean bv = Ht.bv(z);
        if (bv) {
            Sla.Ci().a("pricing", z, Ht);
        }
        return bv;
    }

    public static boolean bu(boolean z) {
        return new a("balance-created").eV("1.0").Ht().bv(z) && new a("balance-changed").eV("1.0").Ht().bv(z);
    }
}
