package com.neovisionaries.ws.client;

/* compiled from: CounterPayloadGenerator */
class d implements r {
    private long dZw;

    d() {
    }

    public byte[] aQe() {
        return p.kK(String.valueOf(aQf()));
    }

    private long aQf() {
        this.dZw = Math.max(this.dZw + 1, 1);
        return this.dZw;
    }
}
