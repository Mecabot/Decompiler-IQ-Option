package com.iqoption.activity;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final /* synthetic */ class x implements OnErrorListener {
    private final VideoActivity afc;
    private final String afd;

    x(VideoActivity videoActivity, String str) {
        this.afc = videoActivity;
        this.afd = str;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this.afc.a(this.afd, mediaPlayer, i, i2);
    }
}
