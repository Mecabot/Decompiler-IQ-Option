package com.iqoption.core.ui.widget.nps;

final /* synthetic */ class b implements Runnable {
    private final NpsRatingBar bfP;

    b(NpsRatingBar npsRatingBar) {
        this.bfP = npsRatingBar;
    }

    public void run() {
        this.bfP.invalidate();
    }
}
