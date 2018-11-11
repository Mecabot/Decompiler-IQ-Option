package com.iqoption.service;

import com.iqoption.microservice.quotes.history.response.c;

final /* synthetic */ class s implements Runnable {
    private final d dqs;
    private final c dqt;

    s(d dVar, c cVar) {
        this.dqs = dVar;
        this.dqt = cVar;
    }

    public void run() {
        this.dqs.b(this.dqt);
    }
}
