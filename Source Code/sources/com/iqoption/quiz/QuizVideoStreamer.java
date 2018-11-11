package com.iqoption.quiz;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import com.iqoption.view.TextureVideoView;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0007J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0007J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0007J\b\u0010\u001f\u001a\u00020\u0019H\u0007R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/quiz/QuizVideoStreamer;", "Landroid/arch/lifecycle/LifecycleObserver;", "videoView", "Lcom/iqoption/view/TextureVideoView;", "(Lcom/iqoption/view/TextureVideoView;)V", "value", "", "isMuted", "()Z", "setMuted", "(Z)V", "isOnAir", "setOnAir", "isPlaying", "Landroid/media/MediaPlayer;", "mediaPlayer", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "", "streamUrl", "getStreamUrl", "()Ljava/lang/String;", "setStreamUrl", "(Ljava/lang/String;)V", "initializePlayer", "", "pausePlayer", "releaseVideoView", "resumePlayer", "scheduleRestartPlayer", "startStream", "stopStream", "Companion", "RestartPlayerRunnable", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizVideoStreamer.kt */
public final class QuizVideoStreamer implements LifecycleObserver {
    private static final String TAG = "com.iqoption.quiz.QuizVideoStreamer";
    public static final a dhm = new a();
    private MediaPlayer dfR;
    private String dgb;
    private boolean dhj;
    private boolean dhk = true;
    private final TextureVideoView dhl;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/QuizVideoStreamer$Companion;", "", "()V", "MEDIA_INFO_BUFFERING_END", "", "MEDIA_INFO_BUFFERING_START", "MEDIA_INFO_NETWORK_BANDWIDTH", "MEDIA_INFO_VIDEO_TRACK_LAGGING", "TAG", "", "kotlin.jvm.PlatformType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizVideoStreamer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/quiz/QuizVideoStreamer$RestartPlayerRunnable;", "Ljava/lang/Runnable;", "streamer", "Lcom/iqoption/quiz/QuizVideoStreamer;", "(Lcom/iqoption/quiz/QuizVideoStreamer;)V", "ref", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "run", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizVideoStreamer.kt */
    private static final class b implements Runnable {
        private final WeakReference<QuizVideoStreamer> aSh;

        public b(QuizVideoStreamer quizVideoStreamer) {
            h.e(quizVideoStreamer, "streamer");
            this.aSh = new WeakReference(quizVideoStreamer);
        }

        public void run() {
            QuizVideoStreamer quizVideoStreamer = (QuizVideoStreamer) this.aSh.get();
            if (quizVideoStreamer != null && quizVideoStreamer.isPlaying()) {
                quizVideoStreamer.aza();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
    /* compiled from: QuizVideoStreamer.kt */
    static final class c implements OnPreparedListener {
        final /* synthetic */ QuizVideoStreamer dhn;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
        /* compiled from: QuizVideoStreamer.kt */
        /* renamed from: com.iqoption.quiz.QuizVideoStreamer$c$1 */
        static final class AnonymousClass1 implements OnInfoListener {
            final /* synthetic */ c dho;

            AnonymousClass1(c cVar) {
                this.dho = cVar;
            }

            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                String Ki = QuizVideoStreamer.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("player warning ");
                stringBuilder.append(i);
                stringBuilder.append("/");
                stringBuilder.append(i2);
                com.iqoption.core.i.e(Ki, stringBuilder.toString());
                if (i == 701) {
                    this.dho.dhn.azb();
                }
                return false;
            }
        }

        c(QuizVideoStreamer quizVideoStreamer) {
            this.dhn = quizVideoStreamer;
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            this.dhn.c(mediaPlayer);
            mediaPlayer.setOnInfoListener(new AnonymousClass1(this));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "<anonymous parameter 2>", "onError"})
    /* compiled from: QuizVideoStreamer.kt */
    static final class d implements OnErrorListener {
        final /* synthetic */ QuizVideoStreamer dhn;

        d(QuizVideoStreamer quizVideoStreamer) {
            this.dhn = quizVideoStreamer;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String Ki = QuizVideoStreamer.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("player error ");
            stringBuilder.append(i);
            com.iqoption.core.i.e(Ki, stringBuilder.toString());
            this.dhn.azb();
            return true;
        }
    }

    public QuizVideoStreamer(TextureVideoView textureVideoView) {
        h.e(textureVideoView, "videoView");
        this.dhl = textureVideoView;
        String str = com.iqoption.quiz.model.d.dlw;
        h.d(str, "QuizConstant.STREAM_URL");
        this.dgb = str;
    }

    public final void jb(String str) {
        h.e(str, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        if ((h.E(this.dgb, str) ^ 1) != 0) {
            this.dgb = str;
            if (isPlaying()) {
                aza();
            }
        }
    }

    public final void ep(boolean z) {
        if (this.dhj != z) {
            this.dhj = z;
            if (!z) {
                ayZ();
            } else if (!isPlaying()) {
                aza();
            }
        }
    }

    public final boolean isMuted() {
        return this.dhk;
    }

    public final void setMuted(boolean z) {
        this.dhk = z;
        float f = z ? 0.0f : 1.0f;
        try {
            MediaPlayer mediaPlayer = this.dfR;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f, f);
            }
        } catch (Exception e) {
            com.iqoption.core.i.e(TAG, "media player set volume error", e);
        }
    }

    public final boolean isPlaying() {
        return this.dhl.isPlaying();
    }

    private final void c(MediaPlayer mediaPlayer) {
        this.dfR = mediaPlayer;
        if (mediaPlayer != null) {
            float f = this.dhk ? 0.0f : 1.0f;
            mediaPlayer.setVolume(f, f);
        }
    }

    @OnLifecycleEvent(R = Event.ON_START)
    public final void startStream() {
        aza();
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public final void stopStream() {
        ayZ();
    }

    @OnLifecycleEvent(R = Event.ON_RESUME)
    public final void resumePlayer() {
        this.dhl.resume();
    }

    @OnLifecycleEvent(R = Event.ON_PAUSE)
    public final void pausePlayer() {
        this.dhl.pause();
    }

    private final void aza() {
        if (this.dhl.isPlaying()) {
            ayZ();
        }
        com.iqoption.core.i.d(TAG, "start play");
        this.dhl.setOnPreparedListener(new c(this));
        this.dhl.setOnErrorListener(new d(this));
        this.dhl.setVideoURI(Uri.parse(this.dgb));
        this.dhl.start();
    }

    private final void ayZ() {
        if (this.dhl.isPlaying()) {
            this.dhl.stopPlayback();
        }
        c((MediaPlayer) null);
    }

    private final void azb() {
        com.iqoption.core.h.i.Yp().b(new b(this), 3000, TimeUnit.MILLISECONDS);
    }
}
