package com.iqoption.service;

final /* synthetic */ class o implements Runnable {
    private final String alY;

    o(String str) {
        this.alY = str;
    }

    public void run() {
        WebSocketHandler.jI(this.alY);
    }
}
