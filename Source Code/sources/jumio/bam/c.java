package jumio.bam;

import android.content.Context;
import android.support.annotation.Nullable;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.ImageData.CameraPosition;
import com.jumio.commons.camera.Size;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.PreconditionNotSatisfiedException;
import com.jumio.core.network.multipart.MultipartApiCall;
import com.jumio.nv.data.NVStrings;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: ImageCall */
class c extends MultipartApiCall<String> {
    private final String a;
    private ImageData b;
    private byte[] c;

    public c(Context context, DynamicProvider dynamicProvider, ImageData imageData, byte[] bArr, String str, Subscriber<String> subscriber) {
        super(context, dynamicProvider, subscriber);
        this.a = str;
        this.c = bArr;
        this.b = imageData;
    }

    @Nullable
    /* renamed from: a */
    public String execute() {
        if (this.c != null) {
            return (String) super.execute();
        }
        throw new PreconditionNotSatisfiedException("image data cannot be null!");
    }

    public String getUri() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("/");
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) 1, (byte) -114, (byte) -15, (byte) 83, (byte) -71, (byte) 50}, -5263286210864610361L));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected String parseResponse(String str) {
        return this.a;
    }

    protected void prepareData() {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        switch (this.b.getOrientationMode()) {
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
        jSONObject.put("cameraPosition", this.b.getCameraPosition().equals(CameraPosition.FRONT) ? NVStrings.FRONT : NVStrings.BACK);
        jSONObject.put("orientationMode", obj);
        Size imageSize = this.b.getImageSize();
        jSONObject.put("imageSize", String.format(Locale.GERMAN, "%dx%d", new Object[]{Integer.valueOf(imageSize.width), Integer.valueOf(imageSize.height)}));
        jSONObject.put("flashMode", Boolean.toString(this.b.isFlashMode()));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cameraDeviceDetail", jSONObject);
        String jSONObject3 = jSONObject2.toString();
        String[] strArr = new String[3];
        strArr[0] = "Content-Disposition: form-data; name=\"cameraDeviceDetail\"";
        strArr[1] = "Content-Type: application/json; charset=UTF-8";
        strArr[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(jSONObject3.length())});
        addPart(strArr, jSONObject3);
        String[] strArr2 = new String[3];
        strArr2[0] = "Content-Disposition: form-data; name=\"image\"; filename=\"rawImage\"";
        strArr2[1] = "Content-Type: image/webp";
        strArr2[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(this.c.length)});
        addPart(strArr2, this.c);
    }
}
