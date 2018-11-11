package com.iqoption.analytics.sla;

final /* synthetic */ class a implements Runnable {
    private final String afd;
    private final Sla ajA;
    private final boolean ajB;
    private final Object ajC;

    a(Sla sla, String str, boolean z, Object obj) {
        this.ajA = sla;
        this.afd = str;
        this.ajB = z;
        this.ajC = obj;
    }

    public void run() {
        this.ajA.b(this.afd, this.ajB, this.ajC);
    }
}
