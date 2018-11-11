package com.iqoption.core.ui.widget.nps;

final /* synthetic */ class d implements Runnable {
    private final NpsRatingBar bfP;

    d(NpsRatingBar npsRatingBar) {
        this.bfP = npsRatingBar;
    }

    public void run() {
        this.bfP.invalidate();
    }
}
