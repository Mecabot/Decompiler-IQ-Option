package com.microblink.view.recognition;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.microblink.geometry.c;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognition.NativeRecognizerWrapper;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.secured.aa;
import com.microblink.secured.al.b;
import com.microblink.secured.f;
import com.microblink.secured.i;
import com.microblink.secured.l;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraView.CameraViewState;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: line */
public class RecognizerView extends f {
    protected RecognitionSettings dUc;
    private boolean dUf;
    private String dUh;
    private String dWk;
    private NativeRecognizerWrapper dZn;
    private RightsManager dZo;
    private c dZp;
    private a dZq;

    private static native long initializeNativeFrameSupport(long[] jArr, int i, int i2, double d);

    private static native void terminateNativeFrameSupport(long j);

    private static native void updateNativeFrameSupport(long j, long[] jArr, int i, int i2);

    static {
        i.aPu();
    }

    private long[] getRecognizerSettingses() {
        RecognizerSettings[] aPj = this.dUc.aPj();
        if (aPj == null || aPj.length == 0) {
            return null;
        }
        long[] jArr = new long[aPj.length];
        for (int i = 0; i < aPj.length; i++) {
            if (aPj[i] != null) {
                jArr[i] = aPj[i].getNativeContext();
            } else {
                jArr[i] = 0;
            }
        }
        return jArr;
    }

    private final void setRecognitionTimeout(int i) {
        NativeRecognizerWrapper nativeRecognizerWrapper = this.dZn;
        if (nativeRecognizerWrapper.IlIllIlIIl == null) {
            Log.a(nativeRecognizerWrapper, "Scheduling timeout after {} miliseconds", Integer.valueOf(i));
            nativeRecognizerWrapper.IlIllIlIIl = new Timer();
            nativeRecognizerWrapper.IIIlIIlIll = false;
            nativeRecognizerWrapper.IlIllIlIIl.schedule(new TimerTask() {
                public final void run() {
                    NativeRecognizerWrapper.this.IlllllIIIl = 0;
                    NativeRecognizerWrapper.this.IlllllIIIl = 0;
                }
            }, (long) i);
        }
    }

    private Orientation getOrientationForRecognition() {
        Orientation currentOrientation = getCurrentOrientation();
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            currentOrientation = getInitialOrientation();
        }
        if (aQc()) {
            currentOrientation = currentOrientation.rotate180();
        }
        Log.a(this, "Current orientation for recognition: {}", currentOrientation);
        return currentOrientation;
    }

    @UiThread
    public final void setLicenseKey(@NonNull String str) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("You must call setLicenseKey prior calling create()");
        } else if (aa.aPN()) {
            this.dWk = str;
            this.dUh = null;
            this.dZo = null;
            try {
                if (this.dZn == null) {
                    this.dZn = NativeRecognizerWrapper.IlIllIlIIl;
                }
                String llIIlIlIIl = this.dZn.llIIlIlIIl(this.dWk, getContext());
                this.dZo = this.dZn.llIIlIlIIl();
                if (llIIlIlIIl != null) {
                    StringBuilder stringBuilder = new StringBuilder("Failed to validate licence key. Reason: ");
                    stringBuilder.append(llIIlIlIIl);
                    throw new InvalidLicenceKeyException(stringBuilder.toString());
                } else if (NativeLibraryInfo.isProtectionEnabled() && this.dZo.a(Right.PING_USED)) {
                    this.dUf = true;
                    b.dYP.a(getContext().getApplicationContext(), new l(str, null, RightsManager.nativeGetPingInterval(this.dZo.IlIllIlIIl)));
                }
            } catch (Throwable th) {
                Log.a(this, th, "Failed to unlock library", new Object[0]);
                this.dWk = null;
                InvalidLicenceKeyException invalidLicenceKeyException = new InvalidLicenceKeyException("Failed to validate licence key because of inner exception.", th);
            }
        } else {
            throw new InvalidLicenceKeyException("Incompatible processor. This device is not supported!");
        }
    }

    public c getScanningRegion() {
        return this.dZp;
    }

    private RightsManager getRightsManager() {
        return this.dZo;
    }

    public static String getNativeLibraryVersionString() {
        return NativeLibraryInfo.getNativeBuildVersion();
    }

    public RecognitionSettings getRecognitionSettings() {
        return this.dUc;
    }

    @UiThread
    public void setRecognitionSettings(RecognitionSettings recognitionSettings) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setGenericRecognizerSettings must be called before calling create()");
        } else if (recognitionSettings != null) {
            this.dUc = recognitionSettings;
        }
    }

    @UiThread
    public void setScanResultListener(@NonNull a aVar) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setScanResultListener must be called before calling create()");
        }
        this.dZq = aVar;
    }

    public a getScanResultListener() {
        return this.dZq;
    }
}
