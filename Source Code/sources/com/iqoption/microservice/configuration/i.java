package com.iqoption.microservice.configuration;

import com.google.common.collect.Lists;
import com.iqoption.core.connect.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultProdConfig */
public class i implements a {
    private static List<String> cQS = Lists.n("https://iqoption.com/", "https://qoption.co/");
    private static List<String> cQT = Collections.emptyList();
    private List<String> cQU = cQT;
    private Iterator<String> cQV = this.cQU.iterator();
    private String cQW = ((String) this.cQV.next());

    public String getAuthApi() {
        return "https://auth.iqoption.com/";
    }

    public String getAvatarsApi() {
        return "https://avatars.iqoption.com/";
    }

    public String getChatApi() {
        return "https://chat.iqoption.com/";
    }

    public String getClusterWebsocket() {
        return "https://iqoption.com/";
    }

    public String getEventApi() {
        return "event.iqoption.com/";
    }

    public void setTc(Boolean bool) {
    }

    static {
        arX();
    }

    static void arX() {
        cQT = u.b(com.iqoption.core.data.d.a.aOz.SF(), cQS);
    }

    static int arY() {
        return cQT.size();
    }

    public String getClusterApi() {
        return this.cQW;
    }

    synchronized void arZ() {
        if (!(this.cQV.hasNext() && this.cQU == cQT)) {
            this.cQU = cQT;
            this.cQV = this.cQU.iterator();
        }
        this.cQW = (String) this.cQV.next();
    }
}
