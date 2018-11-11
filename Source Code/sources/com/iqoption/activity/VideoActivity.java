package com.iqoption.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.ae;
import com.iqoption.core.a.d;
import com.iqoption.dto.ToastEntity;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.x.R;

public class VideoActivity extends d {
    public static final String TAG = "com.iqoption.activity.VideoActivity";
    private VideoView aeV;
    private WebView aeW;
    private ProgressBar aeX;
    private boolean aeY;
    private String aeZ;
    private String afa;
    private d afb;
    private int mProgress = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.videoview_activity);
        Bundle bundleExtra = getIntent().getBundleExtra("params");
        String string = bundleExtra.getString("path");
        String string2 = bundleExtra.getString("id");
        bundleExtra.getInt("REQUEST_CODE", 0);
        this.aeZ = bundleExtra.getString("RETURN_PARAM");
        this.afa = bundleExtra.getString("ARG_SCREEN_OPENED_EVENT");
        this.mProgress = bundleExtra.getInt("PROGRESS");
        if (bundle != null) {
            this.mProgress = bundle.getInt("PROGRESS");
        }
        this.aeY = bundleExtra.getBoolean("IS_EDUCATION_VIDEO", false);
        this.aeW = (WebView) findViewById(R.id.webViewHolder);
        this.aeW.setWebChromeClient(new WebChromeClient());
        this.aeW.getSettings().setJavaScriptEnabled(true);
        this.aeW.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.aeW.setLayerType(1, null);
        this.aeX = (ProgressBar) findViewById(R.id.progressBarVideo);
        this.aeV = (VideoView) findViewById(R.id.videoHolder);
        this.aeV.setMediaController(new MediaController(this));
        this.aeV.setOnErrorListener(new x(this, string2));
        this.aeV.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoActivity.this.aeX.setVisibility(8);
            }
        });
        this.aeV.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (VideoActivity.this.aeY) {
                    ae.d(VideoActivity.this.getApplicationContext(), 16);
                }
                VideoActivity.this.finish();
            }
        });
        this.aeV.setVideoPath(string);
        this.aeV.seekTo(this.mProgress);
        this.aeV.start();
    }

    final /* synthetic */ boolean a(String str, MediaPlayer mediaPlayer, int i, int i2) {
        if (this.aeY) {
            this.aeX.setVisibility(8);
            this.aeV.setVisibility(8);
            this.aeW.setVisibility(0);
            this.aeW.loadData(dR(str), "text/html", "UTF-8");
        } else {
            finish();
        }
        return true;
    }

    protected void AF() {
        this.mProgress = this.aeV.getCurrentPosition() > 0 ? this.aeV.getCurrentPosition() : this.mProgress;
        Intent intent = new Intent();
        intent.putExtra("IS_EDUCATION_VIDEO", this.aeY);
        intent.putExtra("PROGRESS", this.mProgress);
        intent.putExtra("RETURN_PARAM", this.aeZ);
        setResult(-1, intent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("PROGRESS", this.aeV.getCurrentPosition() > 0 ? this.aeV.getCurrentPosition() : this.mProgress);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mProgress = bundle.getInt("PROGRESS");
    }

    public void onPause() {
        super.onPause();
        if (this.afb != null) {
            this.afb.Bs();
        }
        AF();
        this.aeV.pause();
        PasscodeFragment.bn(this);
    }

    public void onResume() {
        super.onResume();
        if (this.afa != null) {
            this.afb = IQApp.Dk().Ds().dZ(this.afa);
        }
        this.aeV.seekTo(this.mProgress);
    }

    public void onBackPressed() {
        AF();
        super.onBackPressed();
    }

    public void finish() {
        AF();
        super.finish();
    }

    protected void onStart() {
        super.onStart();
        WebSocketHandler.aDm().bE(TAG);
    }

    protected void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
    }

    public String dR(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<iframe class=\"youtube-player\" style=\"border: 0; width: 100%; height: 95%;padding:0px; margin:0px\" id=\"ytplayer\" type=\"text/html\" src=\"http://www.youtube.com/embed/");
        stringBuilder.append(str);
        stringBuilder.append("?fs=0\" frameborder=\"0\" allowfullscreen autobuffer controls onclick=\"this.play()\">\n</iframe>\n");
        return stringBuilder.toString();
    }
}
