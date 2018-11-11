package com.microblink.directApi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.microblink.a.d;
import com.microblink.geometry.c;
import com.microblink.image.Image;
import com.microblink.image.ImageFrame;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognition.NativeRecognizerWrapper;
import com.microblink.recognition.NativeRecognizerWrapper.b;
import com.microblink.recognition.RecognizerError;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.recognition.callback.RecognitionProcessCallback;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.secured.aa;
import com.microblink.secured.al;
import com.microblink.secured.l;
import com.microblink.secured.m;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.Log;
import com.microblink.view.NotSupportedReason;
import com.microblink.view.recognition.a;

/* compiled from: line */
public class Recognizer {
    @SuppressLint({"StaticFieldLeak"})
    private static Recognizer dUk = new Recognizer();
    private NativeRecognizerWrapper dTZ = null;
    private a dUa = null;
    private a dUb = null;
    private RecognitionSettings dUc = new RecognitionSettings();
    private d dUd = null;
    private long dUe = 1000000;
    private boolean dUf = false;
    private String dUg = null;
    private String dUh = null;
    private RecognitionProcessCallback dUi = new RecognitionProcessCallback(null, null, null, 0);
    private State dUj = State.OFFLINE;
    private NativeRecognizerWrapper.a dUl = new NativeRecognizerWrapper.a() {
        public void a(BaseRecognitionResult[] baseRecognitionResultArr) {
            Recognizer.a(Recognizer.this, baseRecognitionResultArr);
        }

        public void b(BaseRecognitionResult[] baseRecognitionResultArr) {
            Recognizer.a(Recognizer.this, baseRecognitionResultArr);
        }
    };
    private b dUm = new b() {
        public void a(RecognizerError recognizerError) {
            Recognizer.this.dUb.onRecognizerError(recognizerError);
            synchronized (Recognizer.this) {
                if (Recognizer.this.dUj == State.WORKING) {
                    Recognizer.this.dUj = State.READY;
                }
            }
        }
    };
    private Context mContext = null;

    /* compiled from: line */
    public enum State {
        OFFLINE,
        UNLOCKED,
        READY,
        WORKING
    }

    private Recognizer() {
    }

    public static Recognizer aOD() {
        if (aa.aPN()) {
            return dUk;
        }
        throw new FeatureNotSupportedException(NotSupportedReason.UNSUPPORTED_PROCESSOR_ARCHITECTURE);
    }

    public final synchronized void G(@NonNull Context context, @NonNull String str) {
        StringBuilder stringBuilder;
        if (this.dUj != State.OFFLINE) {
            stringBuilder = new StringBuilder("Cannot unlock recognizer when not in offline state! State is ");
            stringBuilder.append(this.dUj.name());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.dUg = str;
        try {
            if (this.dTZ == null) {
                this.dTZ = NativeRecognizerWrapper.IlIllIlIIl;
            }
            String llIIlIlIIl = this.dTZ.llIIlIlIIl(str, context);
            if (llIIlIlIIl != null) {
                stringBuilder = new StringBuilder("Failed to validate licence key. Reason: ");
                stringBuilder.append(llIIlIlIIl);
                llIIlIlIIl = stringBuilder.toString();
            } else if (this.dTZ.llIIlIlIIl().a(Right.ALLOW_CUSTOM_UI)) {
                this.dUj = State.UNLOCKED;
            } else {
                this.dTZ.IIIllIlIIl();
                Log.b(this, "Direct API requires license key that allows creation of custom UI!", new Object[0]);
                llIIlIlIIl = "Direct API requires license key that allows creation of custom UI!";
            }
            throw new InvalidLicenceKeyException(llIIlIlIIl);
        } catch (Throwable th) {
            th.printStackTrace();
            InvalidLicenceKeyException invalidLicenceKeyException = new InvalidLicenceKeyException("Failed to validate licence key because of inner exception.", th);
        }
    }

    public final synchronized void aJ(@NonNull String str, @NonNull String str2) {
        StringBuilder stringBuilder;
        if (this.dUj != State.OFFLINE) {
            stringBuilder = new StringBuilder("Cannot unlock recognizer when not in offline state! State is ");
            stringBuilder.append(this.dUj.name());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.dUg = str;
        this.dUh = str2;
        try {
            if (this.dTZ == null) {
                this.dTZ = NativeRecognizerWrapper.IlIllIlIIl;
            }
            str = this.dTZ.llIIlIlIIl(str, str2);
            if (str != null) {
                stringBuilder = new StringBuilder("Failed to validate licence key. Reason: ");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            } else if (this.dTZ.llIIlIlIIl().a(Right.ALLOW_CUSTOM_UI)) {
                this.dUj = State.UNLOCKED;
            } else {
                this.dTZ.IIIllIlIIl();
                Log.b(this, "Direct API requires license key that allows creation of custom UI!", new Object[0]);
                str = "Direct API requires license key that allows creation of custom UI!";
            }
            throw new InvalidLicenceKeyException(str);
        } catch (Throwable th) {
            th.printStackTrace();
            InvalidLicenceKeyException invalidLicenceKeyException = new InvalidLicenceKeyException("Failed to validate licence key because of inner exception.", th);
        }
    }

    public final synchronized void a(@NonNull Context context, @NonNull RecognitionSettings recognitionSettings, @NonNull a aVar) {
        if (this.dUj != State.OFFLINE && this.dUj != State.UNLOCKED) {
            throw new IllegalStateException("Cannot initialize already initialized recognizer!");
        } else if (context == null) {
            throw new NullPointerException("Context cannot be null");
        } else if (aVar == null) {
            throw new NullPointerException("Error listener cannot be null!");
        } else {
            if (recognitionSettings == null) {
                recognitionSettings = new RecognitionSettings();
            }
            RecognizerSettings[] aPj = recognitionSettings.aPj();
            if (aPj == null || aPj.length == 0) {
                throw new NullPointerException("Recognizer settings array inside Recognition settings cannot be null nor empty!");
            } else if (this.dUj == State.OFFLINE && NativeLibraryInfo.isProtectionEnabled()) {
                throw new RuntimeException("Failed to initialize recognizer: invalid license key!");
            } else {
                this.dUc = recognitionSettings;
                this.dUb = aVar;
                this.dTZ = NativeRecognizerWrapper.IlIllIlIIl;
                aa aaVar = new aa(context, true);
                this.mContext = context;
                if (NativeLibraryInfo.isProtectionEnabled()) {
                    RightsManager llIIlIlIIl = this.dTZ.llIIlIlIIl();
                    if (llIIlIlIIl.a(Right.PING_USED)) {
                        this.dUf = true;
                        al.b.dYP.a(this.mContext, new l(this.dUg, this.dUh, RightsManager.nativeGetPingInterval(llIIlIlIIl.IlIllIlIIl)));
                    }
                }
                this.dTZ.llIIlIlIIl(aaVar, recognitionSettings, this.dUm);
                this.dUj = State.READY;
            }
        }
    }

    @UiThread
    public final void a(@NonNull Image image, @NonNull a aVar) {
        a(image, aVar, this.dUc);
    }

    @UiThread
    public final void a(@NonNull Image image, @NonNull a aVar, RecognitionSettings recognitionSettings) {
        if (this.dUj != State.READY) {
            throw new IllegalStateException("Cannot recognize image. Recognizer not ready!");
        } else if (aVar == null) {
            throw new NullPointerException("Result listener cannot be null!");
        } else {
            if (recognitionSettings != this.dUc) {
                if (recognitionSettings == null) {
                    recognitionSettings = new RecognitionSettings();
                }
                RecognizerSettings[] aPj = recognitionSettings.aPj();
                if (aPj == null || aPj.length == 0) {
                    throw new NullPointerException("Recognizer settings array inside Recognition settings cannot be null nor empty!");
                }
            }
            RecognitionSettings recognitionSettings2 = recognitionSettings;
            this.dUa = aVar;
            this.dUi.fK(false);
            if (this.dUd != null) {
                Rect aOO = image.aOO();
                this.dUi.a(new c(((float) aOO.left) / ((float) image.getWidth()), ((float) aOO.top) / ((float) image.getHeight()), ((float) aOO.width()) / ((float) image.getWidth()), ((float) aOO.height()) / ((float) image.getHeight())));
            }
            NativeRecognizerWrapper nativeRecognizerWrapper = this.dTZ;
            if (image.isDisposed()) {
                throw new IllegalStateException("Cannot recognize disposed image!");
            }
            long j = this.dUe;
            this.dUe = j + 1;
            m imageFrame = new ImageFrame(image, j);
            if (imageFrame.cC(0)) {
                nativeRecognizerWrapper.llIIlIlIIl(imageFrame, recognitionSettings2, this.dUi, this.dUl, this.dUm, true);
                this.dUj = State.WORKING;
                return;
            }
            imageFrame.recycle();
            throw new RuntimeException("Failed to process given image. See ADB log for more info.");
        }
    }

    public synchronized void terminate() {
        if (this.dUj != State.OFFLINE) {
            this.dUi.fK(true);
            this.dTZ.terminate();
            this.dUj = State.OFFLINE;
            this.dTZ = null;
            this.dUc = null;
            this.dUa = null;
            this.dUb = null;
            this.dUd = null;
            this.mContext = null;
            this.dUi = new RecognitionProcessCallback(null, null, null, 0);
        }
    }
}
