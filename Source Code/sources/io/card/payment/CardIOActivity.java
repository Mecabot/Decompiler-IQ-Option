package io.card.payment;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import io.card.payment.a.a;
import io.card.payment.a.c;
import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.b;
import java.io.ByteArrayInputStream;
import java.util.Date;

public final class CardIOActivity extends Activity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String EXTRA_CAPTURED_CARD_IMAGE = "io.card.payment.capturedCardImage";
    public static final String EXTRA_GUIDE_COLOR = "io.card.payment.guideColor";
    public static final String EXTRA_HIDE_CARDIO_LOGO = "io.card.payment.hideLogo";
    public static final String EXTRA_KEEP_APPLICATION_THEME = "io.card.payment.keepApplicationTheme";
    public static final String EXTRA_LANGUAGE_OR_LOCALE = "io.card.payment.languageOrLocale";
    public static final String EXTRA_NO_CAMERA = "io.card.payment.noCamera";
    public static final String EXTRA_REQUIRE_CARDHOLDER_NAME = "io.card.payment.requireCardholderName";
    public static final String EXTRA_REQUIRE_CVV = "io.card.payment.requireCVV";
    public static final String EXTRA_REQUIRE_EXPIRY = "io.card.payment.requireExpiry";
    public static final String EXTRA_REQUIRE_POSTAL_CODE = "io.card.payment.requirePostalCode";
    public static final String EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY = "io.card.payment.restrictPostalCodeToNumericOnly";
    public static final String EXTRA_RETURN_CARD_IMAGE = "io.card.payment.returnCardImage";
    public static final String EXTRA_SCAN_EXPIRY = "io.card.payment.scanExpiry";
    public static final String EXTRA_SCAN_INSTRUCTIONS = "io.card.payment.scanInstructions";
    public static final String EXTRA_SCAN_OVERLAY_LAYOUT_ID = "io.card.payment.scanOverlayLayoutId";
    public static final String EXTRA_SCAN_RESULT = "io.card.payment.scanResult";
    public static final String EXTRA_SUPPRESS_CONFIRMATION = "io.card.payment.suppressConfirmation";
    public static final String EXTRA_SUPPRESS_MANUAL_ENTRY = "io.card.payment.suppressManual";
    public static final String EXTRA_SUPPRESS_SCAN = "io.card.payment.suppressScan";
    public static final String EXTRA_UNBLUR_DIGITS = "io.card.payment.unblurDigits";
    public static final String EXTRA_USE_CARDIO_LOGO = "io.card.payment.useCardIOLogo";
    public static final String EXTRA_USE_PAYPAL_ACTIONBAR_ICON = "io.card.payment.intentSenderIsPayPal";
    public static final int RESULT_CARD_INFO;
    public static final int RESULT_CONFIRMATION_SUPPRESSED;
    public static final int RESULT_ENTRY_CANCELED;
    public static final int RESULT_SCAN_NOT_AVAILABLE;
    public static final int RESULT_SCAN_SUPPRESSED;
    private static final String TAG = "CardIOActivity";
    private static int ejE = 13274384;
    private static final long[] ejF = new long[]{0, 70, 10, 40};
    private static int ejU;
    static Bitmap ejX;
    private i ejG;
    private OrientationEventListener ejH;
    j ejI;
    private CreditCard ejJ;
    private Rect ejK;
    private int ejL;
    private int ejM;
    private boolean ejN;
    private boolean ejO;
    private LinearLayout ejP;
    private boolean ejQ;
    private RelativeLayout ejR;
    private FrameLayout ejS;
    private boolean ejT;
    private CardScanner ejV;
    private boolean ejW = false;

    public static String sdkVersion() {
        return BuildConfig.PRODUCT_VERSION;
    }

    static {
        int i = ejE;
        ejE = i + 1;
        RESULT_CARD_INFO = i;
        i = ejE;
        ejE = i + 1;
        RESULT_ENTRY_CANCELED = i;
        i = ejE;
        ejE = i + 1;
        RESULT_SCAN_NOT_AVAILABLE = i;
        i = ejE;
        ejE = i + 1;
        RESULT_SCAN_SUPPRESSED = i;
        i = ejE;
        ejE = i + 1;
        RESULT_CONFIRMATION_SUPPRESSED = i;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ejU++;
        if (ejU != 1) {
            Log.i(TAG, String.format("INTERNAL WARNING: There are %d (not 1) CardIOActivity allocations!", new Object[]{Integer.valueOf(ejU)}));
        }
        Intent intent = getIntent();
        this.ejT = getIntent().getBooleanExtra(EXTRA_KEEP_APPLICATION_THEME, false);
        a.a((Activity) this, this.ejT);
        b.y(intent);
        this.ejO = intent.getBooleanExtra(EXTRA_SUPPRESS_SCAN, false);
        String a = m.a(getPackageManager().resolveActivity(intent, 65536), CardIOActivity.class);
        if (a != null) {
            throw new RuntimeException(a);
        }
        this.ejN = intent.getBooleanExtra(EXTRA_SUPPRESS_MANUAL_ENTRY, false);
        if (bundle != null) {
            this.ejQ = bundle.getBoolean("io.card.payment.waitingForPermission");
        }
        if (intent.getBooleanExtra(EXTRA_NO_CAMERA, false)) {
            Log.i("card.io", "EXTRA_NO_CAMERA set to true. Skipping camera.");
            this.ejW = true;
        } else if (CardScanner.aTD()) {
            try {
                if (VERSION.SDK_INT < 23) {
                    aTv();
                    aTt();
                } else if (!this.ejQ) {
                    if (checkSelfPermission("android.permission.CAMERA") == -1) {
                        Log.d(TAG, "permission denied to camera - requesting it");
                        String[] strArr = new String[]{"android.permission.CAMERA"};
                        this.ejQ = true;
                        requestPermissions(strArr, 11);
                        return;
                    }
                    aTv();
                    aTs();
                }
            } catch (Exception e) {
                d(e);
            }
        } else {
            Log.i("card.io", "Processor not Supported. Skipping camera.");
            this.ejW = true;
        }
    }

    private void aTs() {
        if (this.ejW) {
            aTu();
        } else {
            aTw();
        }
    }

    private void aTt() {
        if (this.ejW) {
            aTu();
            return;
        }
        requestWindowFeature(1);
        aTw();
    }

    private void aTu() {
        if (this.ejN) {
            Log.i("card.io", "Camera not available and manual entry suppressed.");
            d(RESULT_SCAN_NOT_AVAILABLE, null);
        }
    }

    private void aTv() {
        StringKey stringKey;
        StringBuilder stringBuilder;
        try {
            if (!m.aTV()) {
                stringKey = StringKey.ERROR_NO_DEVICE_SUPPORT;
                String a = b.a(stringKey);
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringKey);
                stringBuilder.append(": ");
                stringBuilder.append(a);
                Log.w("card.io", stringBuilder.toString());
                this.ejW = true;
            }
        } catch (CameraUnavailableException unused) {
            stringKey = StringKey.ERROR_CAMERA_CONNECT_FAIL;
            CharSequence a2 = b.a(stringKey);
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringKey);
            stringBuilder.append(": ");
            stringBuilder.append(a2);
            Log.e("card.io", stringBuilder.toString());
            Toast makeText = Toast.makeText(this, a2, 1);
            makeText.setGravity(17, 0, -75);
            makeText.show();
            this.ejW = true;
        }
    }

    private void aTw() {
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(4);
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }
        try {
            this.ejK = new Rect();
            this.ejM = 1;
            if (!getIntent().getBooleanExtra("io.card.payment.cameraBypassTestMode", false)) {
                this.ejV = new CardScanner(this, this.ejM);
            } else if (getPackageName().contentEquals("io.card.development")) {
                this.ejV = (CardScanner) Class.forName("io.card.payment.CardScannerTester").getConstructor(new Class[]{getClass(), Integer.TYPE}).newInstance(new Object[]{this, Integer.valueOf(this.ejM)});
            } else {
                throw new IllegalStateException("Illegal access of private extra");
            }
            this.ejV.aTE();
            aTA();
            this.ejH = new OrientationEventListener(this, 2) {
                public void onOrientationChanged(int i) {
                    CardIOActivity.this.iL(i);
                }
            };
        } catch (Exception e) {
            d(e);
        }
    }

    private void d(Exception exception) {
        CharSequence a = b.a(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL);
        Log.e("card.io", "Unknown exception, please post the stack trace as a GitHub issue", exception);
        Toast makeText = Toast.makeText(this, a, 1);
        makeText.setGravity(17, 0, -75);
        makeText.show();
        this.ejW = true;
    }

    private void iL(int i) {
        if (i >= 0 && this.ejV != null) {
            i += this.ejV.aTI();
            if (i > 360) {
                i -= 360;
            }
            int i2 = -1;
            if (i < 15 || i > 345) {
                i2 = 0;
                this.ejM = 1;
            } else if (i > 75 && i < 105) {
                this.ejM = 4;
                i2 = 90;
            } else if (i > 165 && i < 195) {
                i2 = 180;
                this.ejM = 2;
            } else if (i > 255 && i < 285) {
                this.ejM = 3;
                i2 = 270;
            }
            if (i2 >= 0 && i2 != this.ejL) {
                this.ejV.setDeviceOrientation(this.ejM);
                iN(i2);
                if (i2 == 90) {
                    ad(270.0f);
                } else if (i2 == 270) {
                    ad(90.0f);
                } else {
                    ad((float) i2);
                }
            }
        }
    }

    protected void onResume() {
        super.onResume();
        if (!this.ejQ) {
            if (this.ejW) {
                aTx();
                return;
            }
            m.aTY();
            getWindow().addFlags(1024);
            getWindow().addFlags(128);
            a.y(this);
            setRequestedOrientation(1);
            this.ejH.enable();
            if (aTy()) {
                gj(false);
            } else {
                Log.e(TAG, "Could not connect to camera.");
                lk(b.a(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL));
                aTx();
            }
            iL(this.ejL);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("io.card.payment.waitingForPermission", this.ejQ);
    }

    protected void onPause() {
        super.onPause();
        if (this.ejH != null) {
            this.ejH.disable();
        }
        gj(false);
        if (this.ejV != null) {
            this.ejV.aTF();
        }
    }

    protected void onDestroy() {
        this.ejG = null;
        ejU--;
        if (this.ejH != null) {
            this.ejH.disable();
        }
        gj(false);
        if (this.ejV != null) {
            this.ejV.aTG();
            this.ejV = null;
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 11) {
            this.ejQ = false;
            if (iArr.length <= 0 || iArr[0] != 0) {
                this.ejW = true;
            } else {
                aTw();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10) {
            if (i2 == 0) {
                Log.d(TAG, "ignoring onActivityResult(RESULT_CANCELED) caused only when Camera Permissions are Denied in Android 23");
            } else if (i2 == RESULT_CARD_INFO || i2 == RESULT_ENTRY_CANCELED || this.ejW) {
                if (intent == null || !intent.hasExtra(EXTRA_SCAN_RESULT)) {
                    Log.d(TAG, "no data in EXTRA_SCAN_RESULT");
                } else {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("EXTRA_SCAN_RESULT: ");
                    stringBuilder.append(intent.getParcelableExtra(EXTRA_SCAN_RESULT));
                    Log.v(str, stringBuilder.toString());
                }
                d(i2, intent);
            } else if (this.ejR != null) {
                this.ejR.setVisibility(0);
            }
        }
    }

    public void onBackPressed() {
        if (!this.ejW && this.ejG.isAnimating()) {
            try {
                aTy();
            } catch (RuntimeException e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*** could not return to preview: ");
                stringBuilder.append(e);
                Log.w(str, stringBuilder.toString());
            }
        } else if (this.ejV != null) {
            super.onBackPressed();
        }
    }

    public static boolean canReadCardWithCamera() {
        try {
            return m.aTV();
        } catch (CameraUnavailableException unused) {
            return false;
        } catch (RuntimeException unused2) {
            Log.w(TAG, "RuntimeException accessing Util.hardwareSupported()");
            return false;
        }
    }

    public static Date sdkBuildDate() {
        return new Date(BuildConfig.BUILD_TIME);
    }

    public static Bitmap getCapturedCardImage(Intent intent) {
        if (intent == null || !intent.hasExtra(EXTRA_CAPTURED_CARD_IMAGE)) {
            return null;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(intent.getByteArrayExtra(EXTRA_CAPTURED_CARD_IMAGE)), null, new Options());
    }

    void iM(int i) {
        SurfaceView aTT = this.ejI.aTT();
        if (this.ejG != null) {
            this.ejG.j(new Rect(aTT.getLeft(), aTT.getTop(), aTT.getRight(), aTT.getBottom()));
        }
        this.ejM = 1;
        iN(0);
        if (i != this.ejM) {
            Log.wtf("card.io", "the orientation of the scanner doesn't match the orientation of the activity");
        }
        onEdgeUpdate(new DetectionInfo());
    }

    void onEdgeUpdate(DetectionInfo detectionInfo) {
        this.ejG.b(detectionInfo);
    }

    void a(Bitmap bitmap, DetectionInfo detectionInfo) {
        float f;
        try {
            ((Vibrator) getSystemService("vibrator")).vibrate(ejF, -1);
        } catch (SecurityException unused) {
            Log.e("card.io", "Could not activate vibration feedback. Please add <uses-permission android:name=\"android.permission.VIBRATE\" /> to your application's manifest.");
        } catch (Throwable e) {
            Log.w("card.io", "Exception while attempting to vibrate: ", e);
        }
        this.ejV.aTF();
        this.ejR.setVisibility(4);
        if (detectionInfo.aTN()) {
            this.ejJ = detectionInfo.aTO();
            this.ejG.a(this.ejJ);
        }
        if (this.ejM == 1 || this.ejM == 2) {
            f = (((float) this.ejK.right) / 428.0f) * 0.95f;
        } else {
            f = (((float) this.ejK.right) / 428.0f) * 1.15f;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        this.ejG.setBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false));
        if (this.ejO) {
            Intent intent = new Intent();
            m.a(getIntent(), intent, this.ejG);
            d(RESULT_SCAN_SUPPRESSED, intent);
            return;
        }
        aTx();
    }

    private void aTx() {
        final Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra(EXTRA_SUPPRESS_CONFIRMATION, false)) {
            new Handler().post(new Runnable() {
                public void run() {
                    CardIOActivity.this.getWindow().clearFlags(1024);
                    CardIOActivity.this.getWindow().addFlags(512);
                    Intent intent = new Intent(CardIOActivity.this, DataEntryActivity.class);
                    m.a(intent, intent, CardIOActivity.this.ejG);
                    if (CardIOActivity.this.ejG != null) {
                        CardIOActivity.this.ejG.aTS();
                        if (!(CardIOActivity.ejX == null || CardIOActivity.ejX.isRecycled())) {
                            CardIOActivity.ejX.recycle();
                        }
                        CardIOActivity.ejX = CardIOActivity.this.ejG.aTQ();
                    }
                    if (CardIOActivity.this.ejJ != null) {
                        intent.putExtra(CardIOActivity.EXTRA_SCAN_RESULT, CardIOActivity.this.ejJ);
                        CardIOActivity.this.ejJ = null;
                    } else {
                        intent.putExtra("io.card.payment.manualEntryScanResult", true);
                    }
                    intent.putExtras(CardIOActivity.this.getIntent());
                    intent.addFlags(1082195968);
                    CardIOActivity.this.startActivityForResult(intent, 10);
                }
            });
            return;
        }
        Intent intent2 = new Intent(this, DataEntryActivity.class);
        if (this.ejJ != null) {
            intent2.putExtra(EXTRA_SCAN_RESULT, this.ejJ);
            this.ejJ = null;
        }
        m.a(intent, intent2, this.ejG);
        d(RESULT_CONFIRMATION_SUPPRESSED, intent2);
    }

    private void lk(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("error display: ");
        stringBuilder.append(str);
        Log.e("card.io", stringBuilder.toString());
        Toast.makeText(this, str, 1).show();
    }

    private boolean aTy() {
        this.ejJ = null;
        boolean b = this.ejV.b(this.ejI.getSurfaceHolder());
        if (b) {
            this.ejR.setVisibility(0);
        }
        return b;
    }

    private void iN(int i) {
        View aTT = this.ejI.aTT();
        if (aTT == null) {
            Log.wtf("card.io", "surface view is null.. recovering... rotation might be weird.");
            return;
        }
        this.ejK = this.ejV.aT(aTT.getWidth(), aTT.getHeight());
        Rect rect = this.ejK;
        rect.top += aTT.getTop();
        rect = this.ejK;
        rect.bottom += aTT.getTop();
        this.ejG.a(this.ejK, i);
        this.ejL = i;
    }

    void toggleFlash() {
        gj(this.ejV.isFlashOn() ^ 1);
    }

    void gj(boolean z) {
        Object obj = (this.ejI == null || this.ejG == null || !this.ejV.gl(z)) ? null : 1;
        if (obj != null) {
            this.ejG.go(z);
        }
    }

    void aTz() {
        this.ejV.gk(true);
    }

    private void aTA() {
        int i;
        this.ejS = new FrameLayout(this);
        this.ejS.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.ejS.setLayoutParams(new LayoutParams(-1, -1));
        View frameLayout = new FrameLayout(this);
        frameLayout.setId(1);
        this.ejV.getClass();
        this.ejV.getClass();
        this.ejI = new j(this, null, 640, 480);
        this.ejI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 48));
        frameLayout.addView(this.ejI);
        this.ejG = new i(this, null, m.cl(this));
        this.ejG.setLayoutParams(new LayoutParams(-1, -1));
        if (getIntent() != null) {
            this.ejG.gp(getIntent().getBooleanExtra(EXTRA_USE_CARDIO_LOGO, false));
            int intExtra = getIntent().getIntExtra(EXTRA_GUIDE_COLOR, 0);
            if (intExtra != 0) {
                i = ViewCompat.MEASURED_STATE_MASK | intExtra;
                if (intExtra != i) {
                    Log.w("card.io", "Removing transparency from provided guide color.");
                }
                this.ejG.iQ(i);
            } else {
                this.ejG.iQ(-16711936);
            }
            this.ejG.gn(getIntent().getBooleanExtra(EXTRA_HIDE_CARDIO_LOGO, false));
            String stringExtra = getIntent().getStringExtra(EXTRA_SCAN_INSTRUCTIONS);
            if (stringExtra != null) {
                this.ejG.lp(stringExtra);
            }
        }
        frameLayout.addView(this.ejG);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        layoutParams.addRule(2, 2);
        this.ejS.addView(frameLayout, layoutParams);
        this.ejR = new RelativeLayout(this);
        this.ejR.setGravity(80);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ejR.setLayoutParams(layoutParams2);
        this.ejR.setId(2);
        this.ejR.setGravity(85);
        if (!this.ejN) {
            frameLayout = new Button(this);
            frameLayout.setId(3);
            frameLayout.setText(b.a(StringKey.KEYBOARD));
            frameLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    CardIOActivity.this.aTx();
                }
            });
            this.ejR.addView(frameLayout);
            c.a(frameLayout, false, this, this.ejT);
            if (!this.ejT) {
                frameLayout.setTextSize(14.0f);
            }
            frameLayout.setMinimumHeight(c.f("42dip", this));
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.addRule(12);
            c.a(frameLayout, "16dip", null, "16dip", null);
            c.b(frameLayout, "4dip", "4dip", "4dip", "4dip");
        }
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        i = (int) ((getResources().getDisplayMetrics().density * 15.0f) + 0.5f);
        layoutParams2.setMargins(0, i, 0, i);
        this.ejS.addView(this.ejR, layoutParams2);
        if (getIntent() != null) {
            if (this.ejP != null) {
                this.ejS.removeView(this.ejP);
                this.ejP = null;
            }
            int intExtra2 = getIntent().getIntExtra(EXTRA_SCAN_OVERLAY_LAYOUT_ID, -1);
            if (intExtra2 != -1) {
                this.ejP = new LinearLayout(this);
                this.ejP.setLayoutParams(new LayoutParams(-1, -1));
                getLayoutInflater().inflate(intExtra2, this.ejP);
                this.ejS.addView(this.ejP);
            }
        }
        setContentView(this.ejS);
    }

    private void ad(float f) {
        if (this.ejP != null) {
            Animation rotateAnimation = new RotateAnimation(0.0f, f, (float) (this.ejP.getWidth() / 2), (float) (this.ejP.getHeight() / 2));
            rotateAnimation.setDuration(0);
            rotateAnimation.setRepeatCount(0);
            rotateAnimation.setFillAfter(true);
            this.ejP.setAnimation(rotateAnimation);
        }
    }

    private void d(int i, Intent intent) {
        setResult(i, intent);
        ejX = null;
        finish();
    }

    public Rect getTorchRect() {
        if (this.ejG == null) {
            return null;
        }
        return this.ejG.getTorchRect();
    }
}
