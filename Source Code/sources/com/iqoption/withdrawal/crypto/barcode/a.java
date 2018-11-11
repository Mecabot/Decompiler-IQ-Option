package com.iqoption.withdrawal.crypto.barcode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.MultiProcessor.Factory;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector.Builder;
import com.iqoption.core.i;
import com.iqoption.withdrawal.crypto.barcode.camera.CameraSourcePreview;
import com.iqoption.x.R;

/* compiled from: BarcodeCaptureFragment */
public final class a extends Fragment {
    public static final String TAG = "com.iqoption.withdrawal.crypto.barcode.a";
    private com.iqoption.withdrawal.crypto.barcode.camera.a dSa;
    private CameraSourcePreview dSb;
    private boolean dSc = true;
    private boolean dSd;
    private a dSe;

    /* compiled from: BarcodeCaptureFragment */
    public interface a {
        void a(Barcode barcode);
    }

    public static a l(boolean z, boolean z2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("AutoFocus", z);
        bundle.putBoolean("UseFlash", z2);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.dSc = getArguments().getBoolean("AutoFocus");
            this.dSd = getArguments().getBoolean("UseFlash");
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.barcode_capture, viewGroup, false);
        this.dSb = (CameraSourcePreview) inflate.findViewById(R.id.preview);
        if (ContextCompat.checkSelfPermission(zzakw(), "android.permission.CAMERA") == 0) {
            m(this.dSc, this.dSd);
        } else {
            aOb();
        }
        return inflate;
    }

    private void aOb() {
        i.w(TAG, "Camera permission is not granted. Requesting permission");
        ActivityCompat.requestPermissions(zzakw(), new String[]{"android.permission.CAMERA"}, 2);
    }

    @SuppressLint({"InlinedApi"})
    private void m(boolean z, boolean z2) {
        Detector build = new Builder(getContext().getApplicationContext()).build();
        build.setProcessor(new MultiProcessor.Builder(new Factory<Barcode>() {
            /* renamed from: b */
            public Tracker<Barcode> create(Barcode barcode) {
                return new Tracker<Barcode>() {
                    /* renamed from: a */
                    public void onUpdate(Detections<Barcode> detections, Barcode barcode) {
                        a.this.dSe.a(barcode);
                    }
                };
            }
        }).build());
        String str = null;
        if (!build.isOperational()) {
            i.w(TAG, "Detector dependencies are not yet available.");
            if ((zzakw().registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null ? 1 : null) != null) {
                Toast.makeText(getContext(), R.string.low_storage_error, 1).show();
                i.w(TAG, getString(R.string.low_storage_error));
            }
        }
        com.iqoption.withdrawal.crypto.barcode.camera.a.a P = new com.iqoption.withdrawal.crypto.barcode.camera.a.a(getContext().getApplicationContext(), build).hC(0).aG(1600, 1024).P(15.0f);
        if (VERSION.SDK_INT >= 14) {
            P = P.kv(z ? "continuous-picture" : null);
        }
        if (z2) {
            str = "torch";
        }
        this.dSa = P.kw(str).aOe();
    }

    public void onResume() {
        super.onResume();
        aOc();
    }

    public void onPause() {
        super.onPause();
        if (this.dSb != null) {
            this.dSb.stop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.dSb != null) {
            this.dSb.release();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 2) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got unexpected permission result: ");
            stringBuilder.append(i);
            i.d(str, stringBuilder.toString());
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr.length == 0 || iArr[0] != 0) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Permission not granted: results len = ");
            stringBuilder2.append(iArr.length);
            stringBuilder2.append(" Result code = ");
            stringBuilder2.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "(empty)");
            i.e(str2, stringBuilder2.toString());
        } else {
            i.d(TAG, "Camera permission granted - initialize the camera source");
            m(this.dSc, this.dSd);
        }
    }

    private void aOc() {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext().getApplicationContext());
        if (isGooglePlayServicesAvailable != 0) {
            GoogleApiAvailability.getInstance().getErrorDialog(zzakw(), isGooglePlayServicesAvailable, 9001).show();
        }
        if (this.dSa != null) {
            try {
                this.dSb.a(this.dSa, null);
            } catch (Throwable e) {
                i.e(TAG, "Unable to start camera source.", e);
                this.dSa.release();
                this.dSa = null;
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof a) {
            this.dSe = (a) getParentFragment();
        } else if (context instanceof a) {
            this.dSe = (a) context;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement OnFragmentInteractionListener");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.dSe = null;
    }
}
