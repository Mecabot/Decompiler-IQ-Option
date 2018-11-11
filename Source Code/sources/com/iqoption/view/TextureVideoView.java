package com.iqoption.view;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.util.Map;

public class TextureVideoView extends TextureView implements MediaPlayerControl {
    private int dDV;
    private Surface dDW;
    private MediaPlayer dDX;
    private int dDY;
    private int dDZ;
    private int dEa;
    private MediaController dEb;
    private OnCompletionListener dEc;
    private OnPreparedListener dEd;
    private int dEe;
    private OnErrorListener dEf;
    private OnInfoListener dEg;
    private int dEh;
    private boolean dEi;
    private boolean dEj;
    private boolean dEk;
    private boolean dEl;
    OnVideoSizeChangedListener dEm;
    OnPreparedListener dEn;
    private OnCompletionListener dEo;
    private OnInfoListener dEp;
    private OnErrorListener dEq;
    private OnBufferingUpdateListener dEr;
    SurfaceTextureListener dEs;
    private Map<String, String> mHeaders;
    private int mTargetState;
    private Uri mUri;

    public TextureVideoView(Context context) {
        this(context, null);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDV = 0;
        this.mTargetState = 0;
        this.dDW = null;
        this.dDX = null;
        this.dEl = true;
        this.dEm = new OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                TextureVideoView.this.dDZ = mediaPlayer.getVideoWidth();
                TextureVideoView.this.dEa = mediaPlayer.getVideoHeight();
                if (TextureVideoView.this.dDZ != 0 && TextureVideoView.this.dEa != 0) {
                    TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.this.dDZ, TextureVideoView.this.dEa);
                    TextureVideoView.this.requestLayout();
                }
            }
        };
        this.dEn = new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                TextureVideoView.this.dDV = 2;
                TextureVideoView.this.dEi = TextureVideoView.this.dEj = TextureVideoView.this.dEk = true;
                if (TextureVideoView.this.dEd != null) {
                    TextureVideoView.this.dEd.onPrepared(TextureVideoView.this.dDX);
                }
                if (TextureVideoView.this.dEb != null) {
                    TextureVideoView.this.dEb.setEnabled(true);
                }
                TextureVideoView.this.dDZ = mediaPlayer.getVideoWidth();
                TextureVideoView.this.dEa = mediaPlayer.getVideoHeight();
                int f = TextureVideoView.this.dEh;
                if (f != 0) {
                    TextureVideoView.this.seekTo(f);
                }
                if (TextureVideoView.this.dDZ != 0 && TextureVideoView.this.dEa != 0) {
                    TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.this.dDZ, TextureVideoView.this.dEa);
                    if (TextureVideoView.this.mTargetState == 3) {
                        TextureVideoView.this.start();
                        if (TextureVideoView.this.dEb != null) {
                            TextureVideoView.this.dEb.show();
                        }
                    } else if (!TextureVideoView.this.isPlaying()) {
                        if ((f != 0 || TextureVideoView.this.getCurrentPosition() > 0) && TextureVideoView.this.dEb != null) {
                            TextureVideoView.this.dEb.show(0);
                        }
                    }
                } else if (TextureVideoView.this.mTargetState == 3) {
                    TextureVideoView.this.start();
                }
            }
        };
        this.dEo = new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                TextureVideoView.this.dDV = 5;
                TextureVideoView.this.mTargetState = 5;
                if (TextureVideoView.this.dEb != null) {
                    TextureVideoView.this.dEb.hide();
                }
                if (TextureVideoView.this.dEc != null) {
                    TextureVideoView.this.dEc.onCompletion(TextureVideoView.this.dDX);
                }
            }
        };
        this.dEp = new OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (TextureVideoView.this.dEg != null) {
                    TextureVideoView.this.dEg.onInfo(mediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.dEq = new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error: ");
                stringBuilder.append(i);
                stringBuilder.append(",");
                stringBuilder.append(i2);
                Log.d("TextureVideoView", stringBuilder.toString());
                TextureVideoView.this.dDV = -1;
                TextureVideoView.this.mTargetState = -1;
                if (TextureVideoView.this.dEb != null) {
                    TextureVideoView.this.dEb.hide();
                }
                if ((TextureVideoView.this.dEf == null || !TextureVideoView.this.dEf.onError(TextureVideoView.this.dDX, i, i2)) && TextureVideoView.this.getWindowToken() != null) {
                    TextureVideoView.this.getContext().getResources();
                    new Builder(TextureVideoView.this.getContext()).setMessage(i == 200 ? 17039381 : 17039377).setPositiveButton(17039376, new OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (TextureVideoView.this.dEc != null) {
                                TextureVideoView.this.dEc.onCompletion(TextureVideoView.this.dDX);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.dEr = new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                TextureVideoView.this.dEe = i;
            }
        };
        this.dEs = new SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Object obj = null;
                Object obj2 = TextureVideoView.this.mTargetState == 3 ? 1 : null;
                if (i > 0 && i2 > 0) {
                    obj = 1;
                }
                if (TextureVideoView.this.dDX != null && obj2 != null && obj != null) {
                    if (TextureVideoView.this.dEh != 0) {
                        TextureVideoView.this.seekTo(TextureVideoView.this.dEh);
                    }
                    TextureVideoView.this.start();
                }
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureVideoView.this.dDW = new Surface(surfaceTexture);
                TextureVideoView.this.aIG();
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TextureVideoView.this.dDW != null) {
                    TextureVideoView.this.dDW.release();
                    TextureVideoView.this.dDW = null;
                }
                if (TextureVideoView.this.dEb != null) {
                    TextureVideoView.this.dEb.hide();
                }
                TextureVideoView.this.fl(true);
                return true;
            }
        };
        this.dDZ = 0;
        this.dEa = 0;
        setSurfaceTextureListener(this.dEs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.dDV = 0;
        this.mTargetState = 0;
    }

    /* JADX WARNING: Missing block: B:22:0x006e, code:
            if (r1 > r6) goto L_0x0094;
     */
    protected void onMeasure(int r6, int r7) {
        /*
        r5 = this;
        r0 = r5.dDZ;
        r0 = getDefaultSize(r0, r6);
        r1 = r5.dEa;
        r1 = getDefaultSize(r1, r7);
        r2 = r5.dDZ;
        if (r2 <= 0) goto L_0x0092;
    L_0x0010:
        r2 = r5.dEa;
        if (r2 <= 0) goto L_0x0092;
    L_0x0014:
        r0 = android.view.View.MeasureSpec.getMode(r6);
        r6 = android.view.View.MeasureSpec.getSize(r6);
        r1 = android.view.View.MeasureSpec.getMode(r7);
        r7 = android.view.View.MeasureSpec.getSize(r7);
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r0 != r2) goto L_0x0051;
    L_0x0028:
        if (r1 != r2) goto L_0x0051;
    L_0x002a:
        r0 = r5.dDZ;
        r0 = r0 * r7;
        r1 = r5.dEa;
        r1 = r1 * r6;
        if (r0 >= r1) goto L_0x003e;
    L_0x0034:
        r6 = r5.dDZ;
        r6 = r6 * r7;
        r0 = r5.dEa;
        r0 = r6 / r0;
        r6 = r0;
        goto L_0x0094;
    L_0x003e:
        r0 = r5.dDZ;
        r0 = r0 * r7;
        r1 = r5.dEa;
        r1 = r1 * r6;
        if (r0 <= r1) goto L_0x0094;
    L_0x0048:
        r7 = r5.dEa;
        r7 = r7 * r6;
        r0 = r5.dDZ;
        r1 = r7 / r0;
        goto L_0x0093;
    L_0x0051:
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 != r2) goto L_0x0063;
    L_0x0055:
        r0 = r5.dEa;
        r0 = r0 * r6;
        r2 = r5.dDZ;
        r0 = r0 / r2;
        if (r1 != r3) goto L_0x0061;
    L_0x005e:
        if (r0 <= r7) goto L_0x0061;
    L_0x0060:
        goto L_0x0094;
    L_0x0061:
        r7 = r0;
        goto L_0x0094;
    L_0x0063:
        if (r1 != r2) goto L_0x0073;
    L_0x0065:
        r1 = r5.dDZ;
        r1 = r1 * r7;
        r2 = r5.dEa;
        r1 = r1 / r2;
        if (r0 != r3) goto L_0x0071;
    L_0x006e:
        if (r1 <= r6) goto L_0x0071;
    L_0x0070:
        goto L_0x0094;
    L_0x0071:
        r6 = r1;
        goto L_0x0094;
    L_0x0073:
        r2 = r5.dDZ;
        r4 = r5.dEa;
        if (r1 != r3) goto L_0x0083;
    L_0x0079:
        if (r4 <= r7) goto L_0x0083;
    L_0x007b:
        r1 = r5.dDZ;
        r1 = r1 * r7;
        r2 = r5.dEa;
        r1 = r1 / r2;
        goto L_0x0085;
    L_0x0083:
        r1 = r2;
        r7 = r4;
    L_0x0085:
        if (r0 != r3) goto L_0x0071;
    L_0x0087:
        if (r1 <= r6) goto L_0x0071;
    L_0x0089:
        r7 = r5.dEa;
        r7 = r7 * r6;
        r0 = r5.dDZ;
        r1 = r7 / r0;
        goto L_0x0093;
    L_0x0092:
        r6 = r0;
    L_0x0093:
        r7 = r1;
    L_0x0094:
        r5.setMeasuredDimension(r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.TextureVideoView.onMeasure(int, int):void");
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureVideoView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.dEh = 0;
        aIG();
        requestLayout();
        invalidate();
    }

    public void stopPlayback() {
        if (this.dDX != null) {
            this.dDX.stop();
            this.dDX.release();
            this.dDX = null;
            this.dDV = 0;
            this.mTargetState = 0;
            if (this.dEl) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
            }
        }
    }

    private void aIG() {
        StringBuilder stringBuilder;
        if (this.mUri != null && this.dDW != null) {
            fl(false);
            if (this.dEl) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
            }
            try {
                this.dDX = new MediaPlayer();
                if (this.dDY != 0) {
                    this.dDX.setAudioSessionId(this.dDY);
                } else {
                    this.dDY = this.dDX.getAudioSessionId();
                }
                this.dDX.setOnPreparedListener(this.dEn);
                this.dDX.setOnVideoSizeChangedListener(this.dEm);
                this.dDX.setOnCompletionListener(this.dEo);
                this.dDX.setOnErrorListener(this.dEq);
                this.dDX.setOnInfoListener(this.dEp);
                this.dDX.setOnBufferingUpdateListener(this.dEr);
                this.dEe = 0;
                this.dDX.setDataSource(getContext().getApplicationContext(), this.mUri, this.mHeaders);
                this.dDX.setSurface(this.dDW);
                this.dDX.setAudioStreamType(3);
                this.dDX.setScreenOnWhilePlaying(true);
                this.dDX.prepareAsync();
                this.dDV = 1;
                aIH();
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to open content: ");
                stringBuilder.append(this.mUri);
                Log.w("TextureVideoView", stringBuilder.toString(), e);
                this.dDV = -1;
                this.mTargetState = -1;
                this.dEq.onError(this.dDX, 1, 0);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to open content: ");
                stringBuilder.append(this.mUri);
                Log.w("TextureVideoView", stringBuilder.toString(), e2);
                this.dDV = -1;
                this.mTargetState = -1;
                this.dEq.onError(this.dDX, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.dEb != null) {
            this.dEb.hide();
        }
        this.dEb = mediaController;
        aIH();
    }

    private void aIH() {
        if (this.dDX != null && this.dEb != null) {
            this.dEb.setMediaPlayer(this);
            this.dEb.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.dEb.setEnabled(aIJ());
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.dEd = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.dEc = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.dEf = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.dEg = onInfoListener;
    }

    private void fl(boolean z) {
        if (this.dDX != null) {
            this.dDX.reset();
            this.dDX.release();
            this.dDX = null;
            this.dDV = 0;
            if (z) {
                this.mTargetState = 0;
            }
            if (this.dEl) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (aIJ() && this.dEb != null) {
            aII();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (aIJ() && this.dEb != null) {
            aII();
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Object obj = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? null : 1;
        if (!(!aIJ() || obj == null || this.dEb == null)) {
            if (i == 79 || i == 85) {
                if (this.dDX.isPlaying()) {
                    pause();
                    this.dEb.show();
                } else {
                    start();
                    this.dEb.hide();
                }
                return true;
            } else if (i == 126) {
                if (!this.dDX.isPlaying()) {
                    start();
                    this.dEb.hide();
                }
                return true;
            } else if (i == 86 || i == 127) {
                if (this.dDX.isPlaying()) {
                    pause();
                    this.dEb.show();
                }
                return true;
            } else {
                aII();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aII() {
        if (this.dEb.isShowing()) {
            this.dEb.hide();
        } else {
            this.dEb.show();
        }
    }

    public void start() {
        if (aIJ()) {
            this.dDX.start();
            this.dDV = 3;
        }
        this.mTargetState = 3;
    }

    public void pause() {
        if (aIJ() && this.dDX.isPlaying()) {
            this.dDX.pause();
            this.dDV = 4;
        }
        this.mTargetState = 4;
    }

    public void resume() {
        aIG();
    }

    public int getDuration() {
        return aIJ() ? this.dDX.getDuration() : -1;
    }

    public int getCurrentPosition() {
        return aIJ() ? this.dDX.getCurrentPosition() : 0;
    }

    public void seekTo(int i) {
        if (aIJ()) {
            this.dDX.seekTo(i);
            this.dEh = 0;
            return;
        }
        this.dEh = i;
    }

    public boolean isPlaying() {
        return aIJ() && this.dDX.isPlaying();
    }

    public int getBufferPercentage() {
        return this.dDX != null ? this.dEe : 0;
    }

    private boolean aIJ() {
        return (this.dDX == null || this.dDV == -1 || this.dDV == 0 || this.dDV == 1) ? false : true;
    }

    public boolean canPause() {
        return this.dEi;
    }

    public boolean canSeekBackward() {
        return this.dEj;
    }

    public boolean canSeekForward() {
        return this.dEk;
    }

    public int getAudioSessionId() {
        if (this.dDY == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.dDY = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.dDY;
    }

    public void setShouldRequestAudioFocus(boolean z) {
        this.dEl = z;
    }
}
