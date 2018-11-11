package com.iqoption.fragment.base;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final /* synthetic */ class n implements OnCompletionListener {
    private final j cwi;

    n(j jVar) {
        this.cwi = jVar;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.cwi.a(mediaPlayer);
    }
}
