package com.iqoption.feed.feedlist;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.youtube.player.YouTubePlayer;
import com.iqoption.core.microservices.feed.response.a;
import com.iqoption.feed.b.b;
import com.iqoption.feed.b.c;

/* compiled from: YouTubeHolderPlayer */
public class k implements j {
    private final FrameLayout bLo;
    private final c clM;
    @Nullable
    private a cmR;
    @Nullable
    private com.google.android.youtube.player.c cmS;

    public k(FrameLayout frameLayout, c cVar) {
        this.bLo = frameLayout;
        this.clM = cVar;
    }

    public void agx() {
        final String agz = agz();
        if (!TextUtils.isEmpty(agz) && !this.clM.hu(agz)) {
            agy();
            this.clM.a(new b() {
                public void onError() {
                }

                public void a(com.google.android.youtube.player.c cVar, YouTubePlayer youTubePlayer) {
                    ViewGroup viewGroup = (ViewGroup) cVar.getParent();
                    Object obj = k.this.bLo == viewGroup ? 1 : null;
                    if (viewGroup != null && obj == null) {
                        viewGroup.removeView(cVar);
                    }
                    k.this.cmS = cVar;
                    if (viewGroup == null || obj == null) {
                        k.this.bLo.addView(k.this.cmS);
                    }
                    try {
                        if (!k.this.clM.hu(agz)) {
                            k.this.clM.cy(agz);
                        } else if (!youTubePlayer.isPlaying()) {
                            if (youTubePlayer.oY() == youTubePlayer.oX()) {
                                youTubePlayer.au(0);
                            }
                            youTubePlayer.play();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void agy() {
        String agz = agz();
        if (agz != null) {
            this.clM.ht(agz);
        }
        if (this.cmS != null) {
            this.bLo.removeView(this.cmS);
        }
    }

    public void h(a aVar) {
        this.cmR = aVar;
    }

    @Nullable
    private String agz() {
        if (this.cmR == null || !"YouTube".equals(this.cmR.getSource())) {
            return null;
        }
        String path = Uri.parse(this.cmR.VN()).getPath();
        int indexOf = path.indexOf("embed/");
        if (indexOf >= 0) {
            return path.substring(indexOf + "embed/".length());
        }
        return (!path.startsWith("/") || path.length() <= 1) ? path : path.substring(1);
    }
}
