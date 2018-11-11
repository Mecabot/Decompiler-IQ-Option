package jumio.bam;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.content.LocalBroadcastManager;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.jumio.bam.BamCardInformation;
import com.jumio.bam.BamSDK;
import com.jumio.bam.custom.BamCustomScanInterface;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.gui.DrawView;
import com.jumio.gui.Images;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;

/* compiled from: InlineScanViewController */
public class g implements OnGlobalLayoutListener, ai {
    protected Bitmap a;
    int b = 0;
    int c = 0;
    private TextureView d = null;
    private DrawView e = null;
    private ImageView f = null;
    private BamCustomScanInterface g = null;
    private Activity h = null;
    private z i = null;
    private CredentialsModel j = null;
    private DeviceRotationManager k = null;
    private BroadcastReceiver l = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.jumio.bam.CLOSE_SDK")) {
                intent.setAction("");
                int intExtra = intent.getIntExtra("com.jumio.bam.RESULT", 0);
                intent.removeExtra("com.jumio.bam.RESULT");
                if (intExtra == -1) {
                    g.this.g.onBamExtractionFinished((BamCardInformation) intent.getParcelableExtra(BamSDK.EXTRA_CARD_INFORMATION), intent.getStringArrayListExtra(BamSDK.EXTRA_SCAN_ATTEMPTS));
                } else if (intExtra == 0) {
                    String stringExtra = intent.getStringExtra(BamSDK.EXTRA_ERROR_MESSAGE);
                    g.this.g.onBamError(intent.getIntExtra(BamSDK.EXTRA_ERROR_CODE, 0), intent.getIntExtra(BamSDK.EXTRA_DETAILED_ERROR_CODE, 0), stringExtra, false, intent.getStringArrayListExtra(BamSDK.EXTRA_SCAN_ATTEMPTS));
                }
            }
        }
    };

    public boolean a(y yVar, x xVar) {
        return false;
    }

    public void b(y yVar, x xVar) {
    }

    public void updateCameraControls(boolean z, boolean z2) {
    }

    public g(Activity activity, z zVar, RelativeLayout relativeLayout, BamCustomScanInterface bamCustomScanInterface, CredentialsModel credentialsModel) {
        this.h = activity;
        this.i = zVar;
        this.j = credentialsModel;
        this.k = new DeviceRotationManager(activity, Rotation.NATIVE);
        LocalBroadcastManager.getInstance(activity).registerReceiver(this.l, a.a());
        this.g = bamCustomScanInterface;
        int dipToPx = (int) ScreenUtil.dipToPx(this.h, 10.0f);
        int dipToPx2 = (int) ScreenUtil.dipToPx(this.h, 20.0f);
        int dipToPx3 = (int) ScreenUtil.dipToPx(this.h, 17.0f);
        relativeLayout.removeAllViews();
        this.d = new TextureView(this.h);
        this.d.setLayoutParams(new LayoutParams(-1, -1));
        relativeLayout.addView(this.d);
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.e = new DrawView(this.h);
        this.e.setLayoutParams(new LayoutParams(-1, -1));
        this.e.setDrawViewInterface(zVar);
        relativeLayout.addView(this.e);
        this.a = Images.getImage(this.h.getResources());
        this.f = new ImageView(this.h);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.f.setLayoutParams(layoutParams);
        this.f.setAdjustViewBounds(true);
        this.f.setPadding(dipToPx2, dipToPx, dipToPx2, dipToPx3);
        this.f.setImageBitmap(this.a);
        CompatibilityLayer.setImageViewAlpha(this.f, 0);
        relativeLayout.addView(this.f);
        zVar.attachView(this);
        zVar.activate();
    }

    public void a() {
        this.e.setVisibility(0);
    }

    public void b() {
        if (this.a != null) {
            this.f.setImageBitmap(null);
            this.a.recycle();
            this.a = null;
        }
        this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LocalBroadcastManager.getInstance(this.h).unregisterReceiver(this.l);
    }

    public TextureView getTextureView() {
        return this.d;
    }

    public DeviceRotationManager getRotationManager() {
        return this.k;
    }

    public void invalidateDrawView(final boolean z) {
        this.h.runOnUiThread(new Runnable() {
            public void run() {
                if (g.this.e != null) {
                    if (z) {
                        g.this.e.requestLayout();
                    }
                    g.this.e.invalidate();
                }
            }
        });
    }

    public void updateBranding(final boolean z) {
        this.h.runOnUiThread(new Runnable() {
            public void run() {
                g.this.a(z);
            }
        });
    }

    public void resetCameraControls(boolean z, boolean z2) {
        this.g.onBamCameraAvailable();
    }

    public void a(boolean z) {
        if (!z) {
            CompatibilityLayer.setImageViewAlpha(this.f, 0);
        } else if (CompatibilityLayer.getImageViewAlpha(this.f) == 0.0f) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f, "alpha", new int[]{0, 255});
            ofInt.setDuration(200);
            ofInt.start();
        }
    }

    public void c() {
        this.g.onBamExtractionStarted();
    }

    public CredentialsModel d() {
        return this.j;
    }

    public Context getContext() {
        return this.h;
    }

    public void onError(final Throwable th) {
        this.h.runOnUiThread(new Runnable() {
            public void run() {
                g.this.e.setVisibility(4);
                if (th instanceof JumioException) {
                    JumioErrorCase errorCase = ((JumioException) th).getErrorCase();
                    g.this.g.onBamError(errorCase.code(), ((JumioException) th).getDetailedErrorCase(), errorCase.localizedMessage(g.this.h), errorCase.retry(), g.this.i.b());
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!(this.d.getHeight() == this.c || this.d.getWidth() == this.b || this.e == null)) {
            this.e.requestLayout();
        }
        this.b = this.d.getWidth();
        this.c = this.d.getHeight();
    }
}
