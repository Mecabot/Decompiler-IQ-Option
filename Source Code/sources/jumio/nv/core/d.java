package jumio.nv.core;

import android.content.Context;
import android.support.annotation.Nullable;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.ImageData.CameraPosition;
import com.jumio.commons.camera.Size;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.PreconditionNotSatisfiedException;
import com.jumio.core.network.multipart.MultipartApiCall;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.models.InitiateModel;
import com.jumio.persistence.DataAccess;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: AddPartCall */
public class d extends MultipartApiCall<Void> {
    private static int a;
    private final ScanSide b;
    private String c = null;
    private ImageData d;
    private byte[] e;

    /* renamed from: a */
    protected Void parseResponse(String str) {
        return null;
    }

    public d(Context context, DynamicProvider dynamicProvider, ScanSide scanSide, ImageData imageData, byte[] bArr, Subscriber<Void> subscriber) {
        super(context, dynamicProvider, subscriber);
        this.b = scanSide;
        this.e = bArr;
        this.d = imageData;
    }

    @Nullable
    /* renamed from: a */
    public Void execute() {
        if (this.e != null) {
            return (Void) super.execute();
        }
        throw new PreconditionNotSatisfiedException("image data cannot be null!");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6 A:{Catch:{ Exception -> 0x00bd }} */
    /* renamed from: b */
    protected java.lang.Void offlineResponse() {
        /*
        r7 = this;
        r0 = r7.context;
        r1 = com.jumio.nv.models.SelectionModel.class;
        r0 = com.jumio.persistence.DataAccess.load(r0, r1);
        r0 = (com.jumio.nv.models.SelectionModel) r0;
        r1 = 0;
        if (r0 == 0) goto L_0x00c3;
    L_0x000d:
        r0 = r0.isVerificationRequired();
        if (r0 == 0) goto L_0x00c3;
    L_0x0013:
        r0 = r7.context;
        r2 = com.jumio.nv.models.MerchantSettingsModel.class;
        r0 = com.jumio.persistence.DataAccess.load(r0, r2);
        r0 = (com.jumio.nv.models.MerchantSettingsModel) r0;
        r2 = r7.e;
        r3 = 0;
        r4 = r7.e;
        r4 = r4.length;
        r2 = android.graphics.BitmapFactory.decodeByteArray(r2, r3, r4);
        if (r2 == 0) goto L_0x00c3;
    L_0x0029:
        if (r0 == 0) goto L_0x00c3;
    L_0x002b:
        r3 = r0.getOutputDirectory();
        if (r3 == 0) goto L_0x00c3;
    L_0x0031:
        r3 = r0.getOutputFormat();
        if (r3 == 0) goto L_0x00c3;
    L_0x0037:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b2 }
        r3.<init>();	 Catch:{ all -> 0x00b2 }
        r4 = r7.b;	 Catch:{ all -> 0x00b2 }
        r4 = r4.name();	 Catch:{ all -> 0x00b2 }
        r3.append(r4);	 Catch:{ all -> 0x00b2 }
        r4 = ".";
        r3.append(r4);	 Catch:{ all -> 0x00b2 }
        r4 = r0.getOutputFormat();	 Catch:{ all -> 0x00b2 }
        r4 = r4.name();	 Catch:{ all -> 0x00b2 }
        r4 = r4.toLowerCase();	 Catch:{ all -> 0x00b2 }
        r3.append(r4);	 Catch:{ all -> 0x00b2 }
        r3 = r3.toString();	 Catch:{ all -> 0x00b2 }
        r4 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00b2 }
        r5 = new java.io.File;	 Catch:{ all -> 0x00b2 }
        r6 = r0.getOutputDirectory();	 Catch:{ all -> 0x00b2 }
        r5.<init>(r6, r3);	 Catch:{ all -> 0x00b2 }
        r4.<init>(r5);	 Catch:{ all -> 0x00b2 }
        r5 = r0.getOutputFormat();	 Catch:{ all -> 0x00b0 }
        r0 = r0.getOutputLevel();	 Catch:{ all -> 0x00b0 }
        r2.compress(r5, r0, r4);	 Catch:{ all -> 0x00b0 }
        r0 = r7.context;	 Catch:{ all -> 0x00b0 }
        r2 = com.jumio.nv.models.OfflineDataModel.class;
        r0 = com.jumio.persistence.DataAccess.load(r0, r2);	 Catch:{ all -> 0x00b0 }
        r0 = (com.jumio.nv.models.OfflineDataModel) r0;	 Catch:{ all -> 0x00b0 }
        if (r0 != 0) goto L_0x0087;
    L_0x0082:
        r0 = new com.jumio.nv.models.OfflineDataModel;	 Catch:{ all -> 0x00b0 }
        r0.<init>();	 Catch:{ all -> 0x00b0 }
    L_0x0087:
        r2 = jumio.nv.core.d.AnonymousClass1.a;	 Catch:{ all -> 0x00b0 }
        r5 = r7.b;	 Catch:{ all -> 0x00b0 }
        r5 = r5.ordinal();	 Catch:{ all -> 0x00b0 }
        r2 = r2[r5];	 Catch:{ all -> 0x00b0 }
        switch(r2) {
            case 1: goto L_0x009d;
            case 2: goto L_0x0099;
            case 3: goto L_0x0095;
            default: goto L_0x0094;
        };	 Catch:{ all -> 0x00b0 }
    L_0x0094:
        goto L_0x00a0;
    L_0x0095:
        r0.setFaceImage(r3);	 Catch:{ all -> 0x00b0 }
        goto L_0x00a0;
    L_0x0099:
        r0.setBackImage(r3);	 Catch:{ all -> 0x00b0 }
        goto L_0x00a0;
    L_0x009d:
        r0.setFrontImage(r3);	 Catch:{ all -> 0x00b0 }
    L_0x00a0:
        r2 = r7.context;	 Catch:{ all -> 0x00b0 }
        r3 = com.jumio.nv.models.OfflineDataModel.class;
        com.jumio.persistence.DataAccess.update(r2, r3, r0);	 Catch:{ all -> 0x00b0 }
        if (r4 == 0) goto L_0x00c3;
    L_0x00a9:
        r4.flush();	 Catch:{ Exception -> 0x00bd }
        r4.close();	 Catch:{ Exception -> 0x00bd }
        goto L_0x00c3;
    L_0x00b0:
        r0 = move-exception;
        goto L_0x00b4;
    L_0x00b2:
        r0 = move-exception;
        r4 = r1;
    L_0x00b4:
        if (r4 == 0) goto L_0x00bf;
    L_0x00b6:
        r4.flush();	 Catch:{ Exception -> 0x00bd }
        r4.close();	 Catch:{ Exception -> 0x00bd }
        goto L_0x00bf;
    L_0x00bd:
        r0 = move-exception;
        goto L_0x00c0;
    L_0x00bf:
        throw r0;	 Catch:{ Exception -> 0x00bd }
    L_0x00c0:
        com.jumio.commons.log.Log.printStackTrace(r0);
    L_0x00c3:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.d.b():java.lang.Void");
    }

    public String getUri() {
        String classifier = this.b.getClassifier();
        if (this.c == null) {
            InitiateModel initiateModel = (InitiateModel) DataAccess.load(this.context, InitiateModel.class);
            if (initiateModel == null) {
                throw new IllegalStateException("SelectionModel cannot be null!");
            }
            this.c = initiateModel.getJumioScanRef();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -15, (byte) 42, (byte) 43, (byte) 27, (byte) 67, (byte) 85}, 983068124891981253L));
        stringBuilder.append(this.c);
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -40, (byte) -15, (byte) -72, (byte) -59, (byte) -38, (byte) 20, (byte) -54, (byte) 48}, -3512380628637652580L));
        stringBuilder.append(classifier);
        return stringBuilder.toString();
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
        JumioAnalytics.add(MobileEvents.networkRequest(JumioAnalytics.getSessionId(), getClass().getName(), i, str, j));
    }

    protected void prepareData() {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        ImageData imageData = this.d;
        switch (imageData.getOrientationMode()) {
            case PORTRAIT:
                obj = "portrait";
                break;
            case INVERTED_PORTRAIT:
                obj = "reversePortrait";
                break;
            case LANDSCAPE:
                obj = "landscape";
                break;
            case INVERTED_LANDSCAPE:
                obj = "reverseLandscape";
                break;
            default:
                obj = null;
                break;
        }
        jSONObject.put("cameraPosition", imageData.getCameraPosition().equals(CameraPosition.FRONT) ? NVStrings.FRONT : NVStrings.BACK);
        jSONObject.put("orientationMode", obj);
        Size imageSize = imageData.getImageSize();
        jSONObject.put("imageSize", String.format(Locale.GERMAN, "%dx%d", new Object[]{Integer.valueOf(imageSize.width), Integer.valueOf(imageSize.height)}));
        jSONObject.put("flashMode", Boolean.toString(imageData.isFlashMode()));
        jSONObject.put("focusConfidence", Float.toString(imageData.getFocusConfidence()));
        String jSONObject2 = jSONObject.toString();
        String[] strArr = new String[3];
        strArr[0] = "Content-Disposition: form-data; name=\"cameraDeviceDetail\"";
        strArr[1] = "Content-Type: application/json; charset=UTF-8";
        strArr[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(jSONObject2.length())});
        addPart(strArr, jSONObject2);
        String[] strArr2 = new String[3];
        strArr2[0] = "Content-Disposition: form-data; name=\"image\"; filename=\"image.webp\"";
        strArr2[1] = "Content-Type: image/webp";
        strArr2[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(this.e.length)});
        addPart(strArr2, this.e);
    }

    protected int networkErrorMock() {
        return a;
    }
}
