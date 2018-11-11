package org.yaml.snakeyaml;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.e;
import org.yaml.snakeyaml.introspector.f;
import org.yaml.snakeyaml.introspector.g;
import org.yaml.snakeyaml.nodes.d;
import org.yaml.snakeyaml.nodes.h;

/* compiled from: TypeDescription */
public class b {
    private static final Logger log = Logger.getLogger(b.class.getPackage().getName());
    protected String[] fhA;
    protected BeanAccess fhB;
    private Class<?> fhv;
    private h fhw;
    private transient g fhx;
    private transient boolean fhy;
    protected Set<String> fhz;
    private Map<String, f> properties;
    private final Class<? extends Object> type;

    public boolean a(Object obj, String str, Object obj2) {
        return false;
    }

    public boolean a(String str, d dVar) {
        return false;
    }

    public Object b(String str, d dVar) {
        return null;
    }

    public Object ds(Object obj) {
        return obj;
    }

    public b(Class<? extends Object> cls, h hVar, Class<?> cls2) {
        this.properties = Collections.emptyMap();
        this.fhz = Collections.emptySet();
        this.fhA = null;
        this.type = cls;
        this.fhw = hVar;
        this.fhv = cls2;
        this.fhB = null;
    }

    public b(Class<? extends Object> cls) {
        this(cls, (h) null, null);
    }

    public h bDJ() {
        return this.fhw;
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TypeDescription for ");
        stringBuilder.append(getType());
        stringBuilder.append(" (tag='");
        stringBuilder.append(bDJ());
        stringBuilder.append("')");
        return stringBuilder.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for R(6:3|4|5|6|12|1) */
    /* JADX WARNING: Missing block: B:2:0x000e, code:
            if (r0.hasNext() != false) goto L_0x0010;
     */
    /* JADX WARNING: Missing block: B:3:0x0010, code:
            r1 = (org.yaml.snakeyaml.introspector.f) r0.next();
     */
    /* JADX WARNING: Missing block: B:5:?, code:
            r1.b(nU(r1.getName()));
     */
    /* JADX WARNING: Missing block: B:7:0x0022, code:
            r3.fhy = true;
     */
    /* JADX WARNING: Missing block: B:8:0x0025, code:
            return;
     */
    private void bDK() {
        /*
        r3 = this;
        r0 = r3.properties;
        r0 = r0.values();
        r0 = r0.iterator();
    L_0x000a:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0022;
    L_0x0010:
        r1 = r0.next();
        r1 = (org.yaml.snakeyaml.introspector.f) r1;
        r2 = r1.getName();	 Catch:{ YAMLException -> 0x000a }
        r2 = r3.nU(r2);	 Catch:{ YAMLException -> 0x000a }
        r1.b(r2);	 Catch:{ YAMLException -> 0x000a }
        goto L_0x000a;
    L_0x0022:
        r0 = 1;
        r3.fhy = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.b.bDK():void");
    }

    private e nU(String str) {
        if (this.fhx == null) {
            return null;
        }
        if (this.fhB == null) {
            return this.fhx.f(this.type, str);
        }
        return this.fhx.a(this.type, str, this.fhB);
    }

    public e nV(String str) {
        if (!this.fhy) {
            bDK();
        }
        return this.properties.containsKey(str) ? (e) this.properties.get(str) : nU(str);
    }

    public void a(g gVar) {
        this.fhx = gVar;
    }

    public Object a(d dVar) {
        if (this.fhv != null) {
            try {
                Constructor declaredConstructor = this.fhv.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e) {
                log.fine(e.getLocalizedMessage());
                this.fhv = null;
            }
        }
        return null;
    }
}
