package com.iqoption.fragment.base;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final /* synthetic */ class m implements OnPreparedListener {
    private final j cwi;

    m(j jVar) {
        this.cwi = jVar;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.cwi.b(mediaPlayer);
    }
}
