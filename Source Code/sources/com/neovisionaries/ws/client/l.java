package com.neovisionaries.ws.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: HandshakeBuilder */
class l {
    private static final String[] dZA = new String[]{"Connection", "Upgrade"};
    private static final String[] dZB = new String[]{"Upgrade", "websocket"};
    private static final String[] dZC = new String[]{"Sec-WebSocket-Version", "13"};
    private boolean dZD;
    private String dZE;
    private final String dZF;
    private final URI dZG;
    private String dZH;
    private Set<String> dZI;
    private List<ah> dZJ;
    private List<String[]> dZK;
    private final String dZr;

    public l(boolean z, String str, String str2, String str3) {
        this.dZD = z;
        this.dZE = str;
        this.dZr = str2;
        this.dZF = str3;
        str = "%s://%s%s";
        Object[] objArr = new Object[3];
        objArr[0] = z ? "wss" : "ws";
        objArr[1] = str2;
        objArr[2] = str3;
        this.dZG = URI.create(String.format(str, objArr));
    }

    public boolean kG(String str) {
        synchronized (this) {
            if (this.dZI == null) {
                return false;
            }
            boolean contains = this.dZI.contains(str);
            return contains;
        }
    }

    public void a(ah ahVar) {
        if (ahVar != null) {
            synchronized (this) {
                if (this.dZJ == null) {
                    this.dZJ = new ArrayList();
                }
                this.dZJ.add(ahVar);
            }
        }
    }

    public void kH(String str) {
        a(ah.kS(str));
    }

    public boolean kI(String str) {
        if (str == null) {
            return false;
        }
        synchronized (this) {
            if (this.dZJ == null) {
                return false;
            }
            for (ah name : this.dZJ) {
                if (name.getName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void addHeader(String str, String str2) {
        if (str != null && str.length() != 0) {
            if (str2 == null) {
                str2 = "";
            }
            synchronized (this) {
                if (this.dZK == null) {
                    this.dZK = new ArrayList();
                }
                this.dZK.add(new String[]{str, str2});
            }
        }
    }

    public void setKey(String str) {
        this.dZH = str;
    }

    public String aQl() {
        return String.format("GET %s HTTP/1.1", new Object[]{this.dZF});
    }

    public List<String[]> aQm() {
        List<String[]> arrayList = new ArrayList();
        arrayList.add(new String[]{"Host", this.dZr});
        arrayList.add(dZA);
        arrayList.add(dZB);
        arrayList.add(dZC);
        arrayList.add(new String[]{"Sec-WebSocket-Key", this.dZH});
        if (!(this.dZI == null || this.dZI.size() == 0)) {
            arrayList.add(new String[]{"Sec-WebSocket-Protocol", p.d(this.dZI, ", ")});
        }
        if (!(this.dZJ == null || this.dZJ.size() == 0)) {
            arrayList.add(new String[]{"Sec-WebSocket-Extensions", p.d(this.dZJ, ", ")});
        }
        if (!(this.dZE == null || this.dZE.length() == 0)) {
            Object obj = new String[2];
            obj[0] = "Authorization";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Basic ");
            stringBuilder.append(b.encode(this.dZE));
            obj[1] = stringBuilder.toString();
            arrayList.add(obj);
        }
        if (!(this.dZK == null || this.dZK.size() == 0)) {
            arrayList.addAll(this.dZK);
        }
        return arrayList;
    }

    public static String d(String str, List<String[]> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\r\n");
        for (String[] strArr : list) {
            stringBuilder.append(strArr[0]);
            stringBuilder.append(": ");
            stringBuilder.append(strArr[1]);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }
}
