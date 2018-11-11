package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.zzdlc;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

@Hide
public final class zza extends zzdlc<zze> {
    private final zzc zzlhi;

    public zza(Context context, zzc zzc) {
        super(context, "FaceNativeHandle");
        this.zzlhi = zzc;
        zzblo();
    }

    private static Landmark[] zza(FaceParcel faceParcel) {
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzlhl;
        int i = 0;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        while (i < landmarkParcelArr.length) {
            LandmarkParcel landmarkParcel = landmarkParcelArr[i];
            landmarkArr[i] = new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
            i++;
        }
        return landmarkArr;
    }

    protected final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) {
        zzg zzg;
        IBinder zzhk = dynamiteModule.zzhk("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator");
        if (zzhk == null) {
            zzg = null;
        } else {
            IInterface queryLocalInterface = zzhk.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            zzg = queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zzh(zzhk);
        }
        return zzg.zza(zzn.zzz(context), this.zzlhi);
    }

    public final Face[] zzb(ByteBuffer byteBuffer, zzdld zzdld) {
        int i = 0;
        if (!isOperational()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = ((zze) zzblo()).zzc(zzn.zzz(byteBuffer), zzdld);
            Face[] faceArr = new Face[zzc.length];
            while (i < zzc.length) {
                FaceParcel faceParcel = zzc[i];
                faceArr[i] = new Face(faceParcel.id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzlhj, faceParcel.zzlhk, zza(faceParcel), faceParcel.zzlhm, faceParcel.zzlhn, faceParcel.zzlho);
                i++;
            }
            return faceArr;
        } catch (Throwable e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    protected final void zzbll() {
        ((zze) zzblo()).zzblm();
    }

    public final boolean zzfo(int i) {
        if (!isOperational()) {
            return false;
        }
        try {
            return ((zze) zzblo()).zzfo(i);
        } catch (Throwable e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return false;
        }
    }
}
