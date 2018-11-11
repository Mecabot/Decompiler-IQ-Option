package com.iqoption.withdrawal.crypto.fragment.a;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.vision.barcode.Barcode;
import com.iqoption.core.i;
import com.iqoption.d.vc;
import com.iqoption.dto.Event;
import com.iqoption.fragment.cashbox.o;
import com.iqoption.util.ag;
import com.iqoption.withdrawal.crypto.barcode.BarcodeActivity;
import com.iqoption.withdrawal.crypto.fragment.d;
import com.iqoption.x.R;

/* compiled from: WithdrawalCryptoWalletDelegate */
public abstract class b {
    private static final String TAG = "com.iqoption.withdrawal.crypto.fragment.a.b";
    private String assetName;
    private a dTD;
    private final OnClickListener dTE = new OnClickListener() {
        public void onClick(View view) {
            if (b.this.dTr != null) {
                b.this.dK(true);
                ag.b(b.this.dTr.g(b.this.dTs.bHE.getText().toString(), b.this.aOs()), new b(b.this));
            }
        }
    };
    private final OnClickListener dTF = new OnClickListener() {
        public void onClick(View view) {
            d c = b.this.dTu;
            if (b.this.aOv()) {
                b.this.aOw();
            } else {
                c.requestPermissions(new String[]{"android.permission.CAMERA"}, 701);
            }
        }
    };
    private com.iqoption.withdrawal.crypto.fragment.d.a dTr;
    private final vc dTs;
    private final d dTu;

    /* compiled from: WithdrawalCryptoWalletDelegate */
    private class a extends o {
        public a(EditText editText) {
            super(editText, "crypto_withdraw-popup-change-wallet");
        }

        protected void RW() {
            com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_TEXT_CHANGED, "crypto_withdraw-popup-change-wallet").ks(b.this.assetName).fD(com.iqoption.withdrawal.crypto.a.aF(b.this.dTs.bHE.getText().toString(), b.this.assetName)).send();
        }
    }

    /* compiled from: WithdrawalCryptoWalletDelegate */
    private static class b extends com.iqoption.system.c.b<b, Object> {
        public b(b bVar) {
            super((Object) bVar);
        }

        /* renamed from: a */
        public void z(@NonNull b bVar, Object obj) {
            super.z(bVar, obj);
            bVar.dK(false);
        }

        /* renamed from: a */
        public void c(@NonNull b bVar, Throwable th) {
            super.c(bVar, th);
            bVar.dK(false);
        }
    }

    protected abstract double aOs();

    public b(d dVar, vc vcVar, String str) {
        this.dTu = dVar;
        this.dTs = vcVar;
        this.assetName = str;
        vcVar.bHK.setOnClickListener(this.dTE);
        vcVar.bHD.setOnClickListener(this.dTF);
        aOu();
        this.dTD = new a(vcVar.bHE);
    }

    private void aOu() {
        if (this.dTs.bHB != null) {
            final BottomSheetBehavior from = BottomSheetBehavior.from(this.dTs.bHB);
            if (aOv()) {
                this.dTu.getFragmentManager().beginTransaction().add((int) R.id.cameraView, com.iqoption.withdrawal.crypto.barcode.a.l(true, false)).commit();
                from.setBottomSheetCallback(null);
                return;
            }
            from.setBottomSheetCallback(new BottomSheetCallback() {
                public void onSlide(@NonNull View view, float f) {
                }

                public void onStateChanged(@NonNull View view, int i) {
                    if (i == 1) {
                        from.setState(4);
                    }
                }
            });
        }
    }

    public void b(com.iqoption.withdrawal.crypto.fragment.d.a aVar) {
        this.dTr = aVar;
    }

    public boolean a(int i, String[] strArr, int[] iArr) {
        StringBuilder stringBuilder;
        if (i != 701) {
            String str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Got unexpected permission result: ");
            stringBuilder.append(i);
            i.d(str, stringBuilder.toString());
            return false;
        }
        if (iArr.length != 0 && iArr[0] == 0) {
            i.d(TAG, "Camera permission granted - initialize the camera source");
            aOu();
            aOw();
        }
        String str2 = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Permission not granted: results len = ");
        stringBuilder.append(iArr.length);
        stringBuilder.append(" Result code = ");
        stringBuilder.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "(empty)");
        i.e(str2, stringBuilder.toString());
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 700 && i2 == -1 && intent != null) {
            a((Barcode) intent.getParcelableExtra("EXTRA_BARCODE"));
        }
    }

    public void a(final Barcode barcode) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnBarcodeDetected ");
        stringBuilder.append(barcode == null ? "null" : barcode.rawValue);
        i.v(str, stringBuilder.toString());
        if (barcode != null) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    if (b.this.dTs.bHB == null) {
                        b.this.ky(barcode.rawValue);
                        return;
                    }
                    BottomSheetBehavior from = BottomSheetBehavior.from(b.this.dTs.bHB);
                    if (from.getState() == 3) {
                        i.v(b.TAG, "OnBarcodeDetected STATE_EXPANDED");
                        b.this.ky(barcode.rawValue);
                        from.setState(4);
                    }
                }
            });
        }
    }

    protected void ky(String str) {
        com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_PRESSED, "crypto_withdraw-popup-scan-wallet").fB(com.iqoption.withdrawal.crypto.a.aF(str, this.assetName)).ks(this.assetName).send();
    }

    private boolean aOv() {
        return ContextCompat.checkSelfPermission(this.dTu.zzakw(), "android.permission.CAMERA") == 0;
    }

    private void dK(boolean z) {
        int i = 0;
        this.dTs.bly.setVisibility(z ? 0 : 8);
        TextView textView = this.dTs.bHK;
        if (z) {
            i = 4;
        }
        textView.setVisibility(i);
    }

    private void aOw() {
        if (this.dTs.bHB != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(this.dTs.bHB);
            if (from.getState() == 3) {
                from.setState(4);
                return;
            } else {
                from.setState(3);
                return;
            }
        }
        this.dTu.startActivityForResult(BarcodeActivity.aI(this.dTu.getContext()), 700);
        this.dTu.zzakw().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_down);
    }

    protected void fH(boolean z) {
        this.dTs.bHK.setEnabled(z);
        com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_STATE, "crypto_withdraw-popup-withdraw-enable").fC(z).ks(this.assetName).send();
    }
}
