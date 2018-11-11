package com.iqoption.util;

import android.app.Activity;
import android.content.Context;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;
import com.iqoption.app.af;
import com.iqoption.x.R;

public class MusicUtil {
    private static int dwe;
    private static int dwf;
    private static int dwg;
    private static int dwh;
    private static int dwi;
    private static SoundPool dwj;
    private static boolean dwk;

    public enum Sound {
        WIN,
        LOSE,
        GAME_WIN,
        GAME_LOSE,
        DO_BUY
    }

    public static boolean bR(Context context) {
        return af.aR(context).ED();
    }

    public static void v(Activity activity) {
        activity.setVolumeControlStream(3);
        if (VERSION.SDK_INT >= 21) {
            dwj = new Builder().build();
        } else {
            dwj = new SoundPool(2, 3, 0);
        }
        dwj.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                MusicUtil.dwk = true;
            }
        });
        dwf = dwj.load(activity, R.raw.win, 1);
        dwg = dwj.load(activity, R.raw.lose, 1);
        dwh = dwj.load(activity, R.raw.game_win, 1);
        dwi = dwj.load(activity, R.raw.game_lose, 1);
        dwe = dwj.load(activity, R.raw.do_buy, 1);
    }

    public static void a(Context context, Sound sound) {
        if (bR(context) && dwk) {
            dwj.play(a(sound), 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    private static int a(Sound sound) {
        switch (sound) {
            case WIN:
                return dwf;
            case LOSE:
                return dwg;
            case GAME_WIN:
                return dwh;
            case GAME_LOSE:
                return dwi;
            case DO_BUY:
                return dwe;
            default:
                return 0;
        }
    }
}
