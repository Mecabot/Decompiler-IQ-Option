package com.iqoption.core.ui.widget.nps;

final /* synthetic */ class a implements Runnable {
    private final NpsRatingBar bfP;

    a(NpsRatingBar npsRatingBar) {
        this.bfP = npsRatingBar;
    }

    public void run() {
        this.bfP.invalidate();
    }
}
