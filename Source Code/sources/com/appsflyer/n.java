package com.appsflyer;

final class n {
    private String pJ;
    private boolean qn;
    private e re;

    enum e {
        GOOGLE(0),
        AMAZON(1);
        
        private int ॱ;

        private e(int i) {
            this.ॱ = i;
        }

        public final String toString() {
            return String.valueOf(this.ॱ);
        }
    }

    n(e eVar, String str, boolean z) {
        this.re = eVar;
        this.pJ = str;
        this.qn = z;
    }

    final String fN() {
        return this.pJ;
    }

    final boolean fZ() {
        return this.qn;
    }

    public final String toString() {
        return String.format("%s,%s", new Object[]{this.pJ, Boolean.valueOf(this.qn)});
    }
}
