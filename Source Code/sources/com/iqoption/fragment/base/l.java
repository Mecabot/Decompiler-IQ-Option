package com.iqoption.fragment.base;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final /* synthetic */ class l implements OnErrorListener {
    private final j cwi;

    l(j jVar) {
        this.cwi = jVar;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this.cwi.a(mediaPlayer, i, i2);
    }
}
