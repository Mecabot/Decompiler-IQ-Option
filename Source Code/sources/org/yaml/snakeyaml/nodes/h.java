package org.yaml.snakeyaml.nodes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.d.c;
import org.yaml.snakeyaml.error.YAMLException;

/* compiled from: Tag */
public final class h {
    public static final h fiR = new h("tag:yaml.org,2002:yaml");
    public static final h fiS = new h("tag:yaml.org,2002:merge");
    public static final h fiT = new h("tag:yaml.org,2002:set");
    public static final h fiU = new h("tag:yaml.org,2002:pairs");
    public static final h fiV = new h("tag:yaml.org,2002:omap");
    public static final h fiW = new h("tag:yaml.org,2002:binary");
    public static final h fiX = new h("tag:yaml.org,2002:int");
    public static final h fiY = new h("tag:yaml.org,2002:float");
    public static final h fiZ = new h("tag:yaml.org,2002:timestamp");
    public static final h fja = new h("tag:yaml.org,2002:bool");
    public static final h fjb = new h("tag:yaml.org,2002:null");
    public static final h fjc = new h("tag:yaml.org,2002:str");
    public static final h fjd = new h("tag:yaml.org,2002:seq");
    public static final h fje = new h("tag:yaml.org,2002:map");
    public static final Map<h, Set<Class<?>>> fjf = new HashMap();
    private boolean fjg = false;
    private final String value;

    static {
        Set hashSet = new HashSet();
        hashSet.add(Double.class);
        hashSet.add(Float.class);
        hashSet.add(BigDecimal.class);
        fjf.put(fiY, hashSet);
        hashSet = new HashSet();
        hashSet.add(Integer.class);
        hashSet.add(Long.class);
        hashSet.add(BigInteger.class);
        fjf.put(fiX, hashSet);
        hashSet = new HashSet();
        hashSet.add(Date.class);
        hashSet.add(java.sql.Date.class);
        hashSet.add(Timestamp.class);
        fjf.put(fiZ, hashSet);
    }

    public h(String str) {
        if (str == null) {
            throw new NullPointerException("Tag must be provided.");
        } else if (str.length() == 0) {
            throw new IllegalArgumentException("Tag must not be empty.");
        } else if (str.trim().length() != str.length()) {
            throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
        } else {
            this.value = c.encode(str);
            this.fjg = str.startsWith("tag:yaml.org,2002:") ^ 1;
        }
    }

    public h(Class<? extends Object> cls) {
        if (cls == null) {
            throw new NullPointerException("Class for tag must be provided.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag:yaml.org,2002:");
        stringBuilder.append(c.encode(cls.getName()));
        this.value = stringBuilder.toString();
    }

    public boolean bEp() {
        return this.fjg;
    }

    public String getValue() {
        return this.value;
    }

    public boolean startsWith(String str) {
        return this.value.startsWith(str);
    }

    public String getClassName() {
        if (this.value.startsWith("tag:yaml.org,2002:")) {
            return c.decode(this.value.substring("tag:yaml.org,2002:".length()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid tag: ");
        stringBuilder.append(this.value);
        throw new YAMLException(stringBuilder.toString());
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return obj instanceof h ? this.value.equals(((h) obj).getValue()) : false;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean ah(Class<?> cls) {
        Set set = (Set) fjf.get(this);
        return set != null ? set.contains(cls) : false;
    }
}
