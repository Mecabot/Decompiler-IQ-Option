package com.microblink.recognition;

import android.content.Context;
import android.support.annotation.Nullable;
import com.microblink.hardware.NativeDeviceManager;
import com.microblink.recognition.callback.RecognitionProcessCallback;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.secured.IlllllIIll;
import com.microblink.secured.aa;
import com.microblink.secured.ag;
import com.microblink.secured.i;
import com.microblink.secured.m;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.Log;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: line */
public enum NativeRecognizerWrapper {
    ;
    
    public volatile boolean IIIlIIlIll;
    private long IlIllIlIIl;
    public Timer IlIllIlIIl;
    private AtomicReference<IlllllIIll> IlIllIlIIl;
    private int IlllllIIIl;
    private NativeDeviceManager llIIlIlIIl;
    private RecognitionSettings llIIlIlIIl;
    public ag llIIlIlIIl;
    public com.microblink.secured.b llIIlIlIIl;
    private volatile NativeLibraryInfo llIIlIlIIl;

    /* compiled from: line */
    public interface a {
        void a(@Nullable BaseRecognitionResult[] baseRecognitionResultArr);

        void b(@Nullable BaseRecognitionResult[] baseRecognitionResultArr);
    }

    /* compiled from: line */
    public interface b {
        void a(RecognizerError recognizerError);
    }

    private static native long initNativeRecognizers(long j, long[] jArr, boolean z, long j2, long j3, String str);

    private static native void invalidateLicense(long j);

    private static native String nativeCheckLibraryLicenseKey(long j, String str, String str2);

    private static native String nativeCheckLicenseKey(long j, String str, Context context);

    private static native long nativeConstruct();

    private static native void nativeDestruct(long j);

    private static native long nativeObtainRights(long j);

    private static native BaseRecognitionResult[] recognize(long j, long j2, long j3);

    private static native void resetRecognizers(long j, boolean z);

    private static native void terminateNativeRecognizers(long j);

    private static native String updateRecognizers(long j, long[] jArr, boolean z);

    static {
        i.aPu();
    }

    private NativeRecognizerWrapper(String str) {
        this.IlIllIlIIl = new AtomicReference(IlllllIIll.UNINITIALIZED);
        this.IIIlIIlIll = false;
        this.IlIllIlIIl = null;
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = null;
        this.IlllllIIIl = 0;
        this.IlIllIlIIl = 0;
        this.llIIlIlIIl = new ag("Recognition");
        this.llIIlIlIIl.start();
    }

    private static long[] llIIlIlIIl(RecognizerSettings[] recognizerSettingsArr) {
        if (recognizerSettingsArr == null || recognizerSettingsArr.length == 0) {
            return null;
        }
        long[] jArr = new long[recognizerSettingsArr.length];
        for (int i = 0; i < recognizerSettingsArr.length; i++) {
            if (recognizerSettingsArr[i] != null) {
                jArr[i] = recognizerSettingsArr[i].getNativeContext();
            } else {
                jArr[i] = 0;
            }
        }
        return jArr;
    }

    public final synchronized void llIIlIlIIl(final aa aaVar, final RecognitionSettings recognitionSettings, final b bVar) {
        if (recognitionSettings == null) {
            throw new NullPointerException("Generic recognizer settings cannot be null");
        } else if (bVar == null) {
            throw new NullPointerException("Error callback cannot be null");
        } else {
            this.IlllllIIIl++;
            Log.a(this, "Active instances: {}", Integer.valueOf(this.IlllllIIIl));
            if (this.IlIllIlIIl.compareAndSet(IlllllIIll.UNINITIALIZED, IlllllIIll.PRE_INIT)) {
                i.aPx();
                if (this.IlIllIlIIl == 0) {
                    this.IlIllIlIIl = nativeConstruct();
                }
                Log.a(this, "Posting init task to RecognitionQueue...", new Object[0]);
                this.llIIlIlIIl.o(new Runnable() {
                    public final void run() {
                        Log.a(NativeRecognizerWrapper.this, "Initializing library from state: {}", ((IlllllIIll) NativeRecognizerWrapper.this.IlllllIIIl = 0.get()).name());
                        if (NativeRecognizerWrapper.this.IlllllIIIl = 0.compareAndSet(IlllllIIll.PRE_INIT, IlllllIIll.INITIALIZING)) {
                            ResourceProvider.dVo.ci(aaVar.mContext);
                            Log.e(NativeRecognizerWrapper.this, "Calling native init...", new Object[0]);
                            NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                            aa aaVar = aaVar;
                            if (aaVar.dXT == null) {
                                throw new RuntimeException("Device lists have to be loaded to build native device manager");
                            }
                            nativeRecognizerWrapper.llIIlIlIIl = new NativeDeviceManager(aaVar);
                            Log.f(this, "Native context ptr: {}", Long.valueOf(NativeRecognizerWrapper.this.IlllllIIIl = 0));
                            NativeRecognizerWrapper.this.llIIlIlIIl = new NativeLibraryInfo(NativeRecognizerWrapper.initNativeRecognizers(NativeRecognizerWrapper.this.IlllllIIIl = 0, NativeRecognizerWrapper.llIIlIlIIl(recognitionSettings.aPj()), recognitionSettings.aPi(), ResourceProvider.dVo.IlIllIlIIl, NativeRecognizerWrapper.this.IlllllIIIl = 0.IlIllIlIIl, com.microblink.util.a.ck(aaVar.mContext)));
                            NativeRecognizerWrapper.this.llIIlIlIIl = recognitionSettings;
                            if (NativeRecognizerWrapper.this.IlllllIIIl = 0.aPY()) {
                                Log.a(NativeRecognizerWrapper.this, "Native library has initialized.", new Object[0]);
                                NativeRecognizerWrapper.this.IlllIIIllI();
                                return;
                            }
                            Log.b(NativeRecognizerWrapper.this, "Failed to initialize native library!", new Object[0]);
                            Log.b(NativeRecognizerWrapper.this, "Reason: {}", NativeRecognizerWrapper.this.IlllllIIIl = 0.aPZ());
                            synchronized (NativeRecognizerWrapper.this) {
                                NativeRecognizerWrapper.this.IlllllIIIl = 0;
                            }
                            NativeRecognizerWrapper.this.IlllllIIIl = 0;
                            bVar.a(new RecognizerError(NativeRecognizerWrapper.this.IlllllIIIl = 0.aPZ()));
                            return;
                        }
                        Log.c(NativeRecognizerWrapper.this, "Library is already initialized (state: {})", ((IlllllIIll) NativeRecognizerWrapper.this.IlllllIIIl = 0.get()).name());
                    }
                });
                return;
            }
            Log.c(this, "Will not initialize native recognizer because it is already initialized, state is {}", this.IlIllIlIIl);
        }
    }

    private void IlllIIIllI() {
        if (this.llIIlIlIIl != null) {
            m aPo = this.llIIlIlIIl.aPo();
            if (aPo != null) {
                Log.a(this, "Obtained already best frame ID {} from provider. Starting recognition...", Long.valueOf(aPo.aOM()));
                this.IlIllIlIIl.set(IlllllIIll.DISPATCH_READY);
                llIIlIlIIl(aPo, this.llIIlIlIIl.getRecognitionSettings(), this.llIIlIlIIl.aPq(), this.llIIlIlIIl.aPp(), this.llIIlIlIIl.aPr(), false);
                return;
            }
            Log.a(this, "Provider still does not have best frame available. Will wait for it to dispatch a frame", new Object[0]);
        }
        Log.a(this, "Transitioned to state READY", new Object[0]);
        this.IlIllIlIIl.set(IlllllIIll.READY);
    }

    private void IlIlIlIIlI() {
        Log.e(this, "Terminating native library, state was: {}", ((IlllllIIll) this.IlIllIlIIl.get()).name());
        this.llIIlIlIIl = null;
        if (this.IlIllIlIIl.get() != IlllllIIll.UNINITIALIZED) {
            Log.e(this, "Calling native terminate...", new Object[0]);
            terminateNativeRecognizers(this.IlIllIlIIl);
            this.IlIllIlIIl = 0;
            this.llIIlIlIIl = null;
            this.IlIllIlIIl.set(IlllllIIll.UNINITIALIZED);
        }
    }

    public final void llIIlIlIIl(m mVar, RecognitionSettings recognitionSettings, RecognitionProcessCallback recognitionProcessCallback, a aVar, b bVar, boolean z) {
        if (this.llIIlIlIIl != null) {
            final boolean z2 = z;
            final RecognitionSettings recognitionSettings2 = recognitionSettings;
            final b bVar2 = bVar;
            final m mVar2 = mVar;
            final RecognitionProcessCallback recognitionProcessCallback2 = recognitionProcessCallback;
            final a aVar2 = aVar;
            this.llIIlIlIIl.o(new Runnable() {
                public final void run() {
                    IlllllIIll illlllIIll = (IlllllIIll) NativeRecognizerWrapper.this.IlllllIIIl = 0.get();
                    if (illlllIIll == IlllllIIll.READY || illlllIIll == IlllllIIll.DISPATCH_READY || (z2 && illlllIIll == IlllllIIll.DONE)) {
                        if (!recognitionSettings2.equals(NativeRecognizerWrapper.this.IlllllIIIl = 0)) {
                            NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, recognitionSettings2, bVar2);
                            if (!mVar2.aOK()) {
                                NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.IlllllIIIl = 0, true);
                            }
                        }
                        if (mVar2.aOK()) {
                            NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.IlllllIIIl = 0, true);
                        }
                        NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, mVar2, recognitionProcessCallback2, aVar2);
                    }
                }
            });
            return;
        }
        Log.d(this, "Processing thread is null! Unable to perform recognition!", new Object[0]);
    }

    public final void IlIIIIIlll() {
        if (this.llIIlIlIIl != null) {
            this.llIIlIlIIl.o(new Runnable() {
                public final void run() {
                    if (NativeRecognizerWrapper.this.IlllllIIIl = 0.get() == IlllllIIll.DONE) {
                        NativeRecognizerWrapper.this.IlllIIIllI();
                    }
                }
            });
        } else {
            Log.d(this, "Processing thread is null! Unable to prepare for next recognition!", new Object[0]);
        }
    }

    public final void IllIIIllII(final boolean z) {
        if (this.llIIlIlIIl != null) {
            this.llIIlIlIIl.o(new Runnable() {
                public final void run() {
                    NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.IlllllIIIl = 0, z);
                    NativeRecognizerWrapper.this.IIlIlllIIl();
                }
            });
        } else {
            Log.d(this, "Unable to reset recognizers: processing thread is null", new Object[0]);
        }
    }

    public final void IIIIIIIIII() {
        if (this.llIIlIlIIl != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.llIIlIlIIl.o(new Runnable() {
                public final void run() {
                    countDownLatch.countDown();
                }
            });
            try {
                Log.f(this, "Waiting for recognition...", new Object[0]);
                countDownLatch.await();
                return;
            } catch (Throwable e) {
                Log.b((Object) this, e, "Interrupted while waiting for recognition", new Object[0]);
                return;
            }
        }
        Log.d(this, "Cannot wait for recognition, processing thread is null", new Object[0]);
    }

    public final void IIlIlllIIl() {
        if (this.IlIllIlIIl != null) {
            this.IlIllIlIIl.cancel();
        }
        this.IIIlIIlIll = false;
        this.IlIllIlIIl = null;
    }

    public final synchronized void terminate() {
        this.IlllllIIIl--;
        if (this.IlllllIIIl > 0) {
            Log.f(this, "Still having {} instances running, will not terminate native recognizer", Integer.valueOf(this.IlllllIIIl));
            return;
        }
        IIlIlllIIl();
        if (this.llIIlIlIIl != null) {
            Log.e(this, "Dispatching termination task. State was: {}", this.IlIllIlIIl);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.llIIlIlIIl.o(new Runnable() {
                public final void run() {
                    NativeRecognizerWrapper.this.IlllllIIIl = 0;
                    countDownLatch.countDown();
                }
            });
            Log.f(this, "Waiting for native library to terminate...", new Object[0]);
            try {
                countDownLatch.await();
                Log.f(this, "Native library has terminated.", new Object[0]);
                return;
            } catch (Throwable e) {
                Log.b((Object) this, e, "Interrupted while waiting for native library to terminate.", new Object[0]);
                return;
            }
        }
        Log.c(this, "Library is already terminated or is terminating. State: {}", this.IlIllIlIIl);
    }

    public final RightsManager llIIlIlIIl() {
        return new RightsManager(nativeObtainRights(this.IlIllIlIIl));
    }

    public final String llIIlIlIIl(String str, Context context) {
        if (i.aPv()) {
            synchronized (this) {
                if (this.IlIllIlIIl == 0) {
                    Log.a(this, "Constructing native part", new Object[0]);
                    this.IlIllIlIIl = nativeConstruct();
                }
                str = nativeCheckLicenseKey(this.IlIllIlIIl, str, context.getApplicationContext());
            }
            return str;
        }
        throw i.aPw();
    }

    public final String llIIlIlIIl(String str, String str2) {
        if (i.aPv()) {
            synchronized (this) {
                if (this.IlIllIlIIl == 0) {
                    Log.a(this, "Constructing native part", new Object[0]);
                    this.IlIllIlIIl = nativeConstruct();
                }
                str = nativeCheckLibraryLicenseKey(this.IlIllIlIIl, str, str2);
            }
            return str;
        }
        throw i.aPw();
    }

    public final void IIIllIlIIl() {
        if (i.aPv()) {
            synchronized (this) {
                invalidateLicense(this.IlIllIlIIl);
                nativeDestruct(this.IlIllIlIIl);
                this.IlIllIlIIl = 0;
            }
            return;
        }
        throw i.aPw();
    }

    public final IlllllIIll llIIlIlIIl() {
        return (IlllllIIll) this.IlIllIlIIl.get();
    }
}
