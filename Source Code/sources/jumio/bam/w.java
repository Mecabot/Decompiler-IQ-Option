package jumio.bam;

import com.jumio.commons.PersistWith;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.log.Log;
import com.jumio.core.mvp.model.StaticModel;

@PersistWith("BamServerSettingsModel")
/* compiled from: BamServerSettingsModel */
public class w implements StaticModel {
    private String a = null;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    public void a(String str) {
        try {
            JumioJSONObject jumioJSONObject = new JumioJSONObject(str);
            this.a = jumioJSONObject.optString("requestReference");
            this.b = jumioJSONObject.optBoolean("dataTransferEnabled", true);
            this.c = jumioJSONObject.optBoolean("highResImageTransmissionEnabled", false);
            this.d = jumioJSONObject.optBoolean("brandingEnabled", false);
        } catch (Throwable e) {
            Log.w("BamServerSettingsModel", "JSONException ", e);
        }
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public boolean d() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }
}
