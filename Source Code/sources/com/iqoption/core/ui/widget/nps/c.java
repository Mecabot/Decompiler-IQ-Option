package com.iqoption.core.ui.widget.nps;

final /* synthetic */ class c implements Runnable {
    private final NpsRatingBar bfP;

    c(NpsRatingBar npsRatingBar) {
        this.bfP = npsRatingBar;
    }

    public void run() {
        this.bfP.invalidate();
    }
}
