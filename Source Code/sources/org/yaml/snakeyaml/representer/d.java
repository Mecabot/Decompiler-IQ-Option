package org.yaml.snakeyaml.representer;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: SafeRepresenter */
class d extends a {
    public static Pattern fjD = Pattern.compile("\n|| | ");
    protected TimeZone fhq;
    protected Map<Class<? extends Object>, org.yaml.snakeyaml.nodes.h> fjC;

    /* compiled from: SafeRepresenter */
    protected class a implements b {
        protected a() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class b implements b {
        protected b() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class c implements b {
        protected c() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class d implements b {
        protected d() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class e implements b {
        protected e() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class f implements b {
        protected f() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class g implements b {
        protected g() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class h implements b {
        protected h() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class i implements b {
        protected i() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class j implements b {
        protected j() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class k implements b {
        protected k() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class l implements b {
        protected l() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class m implements b {
        protected m() {
        }
    }

    /* compiled from: SafeRepresenter */
    protected class n implements b {
        protected n() {
        }
    }

    public d() {
        this.fhq = null;
        this.fjx = new i();
        this.fjw.put(String.class, new m());
        this.fjw.put(Boolean.class, new b());
        this.fjw.put(Character.class, new m());
        this.fjw.put(UUID.class, new n());
        this.fjw.put(byte[].class, new c());
        k kVar = new k();
        this.fjw.put(short[].class, kVar);
        this.fjw.put(int[].class, kVar);
        this.fjw.put(long[].class, kVar);
        this.fjw.put(float[].class, kVar);
        this.fjw.put(double[].class, kVar);
        this.fjw.put(char[].class, kVar);
        this.fjw.put(boolean[].class, kVar);
        this.fjy.put(Number.class, new j());
        this.fjy.put(List.class, new g());
        this.fjy.put(Map.class, new h());
        this.fjy.put(Set.class, new l());
        this.fjy.put(Iterator.class, new f());
        this.fjy.put(new Object[0].getClass(), new a());
        this.fjy.put(Date.class, new d());
        this.fjy.put(Enum.class, new e());
        this.fjy.put(Calendar.class, new d());
        this.fjC = new HashMap();
    }

    public TimeZone getTimeZone() {
        return this.fhq;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.fhq = timeZone;
    }
}
