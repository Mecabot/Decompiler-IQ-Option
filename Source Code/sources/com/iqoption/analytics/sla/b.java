package com.iqoption.analytics.sla;

final /* synthetic */ class b implements Runnable {
    private final String afd;
    private final Sla ajA;

    b(Sla sla, String str) {
        this.ajA = sla;
        this.afd = str;
    }

    public void run() {
        this.ajA.ed(this.afd);
    }
}
