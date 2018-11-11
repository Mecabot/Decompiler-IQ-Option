package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

@Hide
public final class zzdkx extends zzdlc<zzdky> {
    private final zzdkv zzlgp;

    public zzdkx(Context context, zzdkv zzdkv) {
        super(context, "BarcodeNativeHandle");
        this.zzlgp = zzdkv;
        zzblo();
    }

    public final Barcode[] zza(Bitmap bitmap, zzdld zzdld) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzdky) zzblo()).zzb(zzn.zzz(bitmap), zzdld);
        } catch (Throwable e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzdld zzdld) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzdky) zzblo()).zza(zzn.zzz(byteBuffer), zzdld);
        } catch (Throwable e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    protected final void zzbll() {
        if (isOperational()) {
            ((zzdky) zzblo()).zzblm();
        }
    }
}
