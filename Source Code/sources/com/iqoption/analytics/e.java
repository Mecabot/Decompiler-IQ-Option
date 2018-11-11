package com.iqoption.analytics;

import com.iqoption.dto.Event;

final /* synthetic */ class e implements Runnable {
    private final EventManager ajc;
    private final Event ajd;

    e(EventManager eventManager, Event event) {
        this.ajc = eventManager;
        this.ajd = event;
    }

    public void run() {
        this.ajc.c(this.ajd);
    }
}
