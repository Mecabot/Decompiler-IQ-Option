package jumio.nv.core;

import android.content.Context;
import com.jumio.nv.extraction.NfcController;

/* compiled from: NfcControllerFactory */
public class p {
    public static NfcController a(Context context) {
        try {
            return (NfcController) Class.forName("com.jumio.nv.nfc.core.NfcControllerImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (Exception unused) {
            return null;
        }
    }
}
