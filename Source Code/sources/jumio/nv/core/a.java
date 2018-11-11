package jumio.nv.core;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.NetverifySDK;

/* compiled from: CloseSdkIntent */
public class a extends Intent {
    public static final Creator<a> CREATOR = new Creator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a();
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    public a() {
        super("com.jumio.nv.CLOSE_SDK");
    }

    public a(NetverifyDocumentData netverifyDocumentData, String str) {
        super("com.jumio.nv.CLOSE_SDK");
        putExtra(NetverifySDK.EXTRA_SCAN_DATA, netverifyDocumentData);
        putExtra(NetverifySDK.EXTRA_SCAN_REFERENCE, str);
        putExtra("com.jumio.nv.RESULT", -1);
    }

    public a(int i, int i2, String str, String str2) {
        super("com.jumio.nv.CLOSE_SDK");
        putExtra(NetverifySDK.EXTRA_SCAN_REFERENCE, str2);
        putExtra(NetverifySDK.EXTRA_ERROR_CODE, i);
        putExtra(NetverifySDK.EXTRA_DETAILED_ERROR_CODE, i2);
        putExtra(NetverifySDK.EXTRA_ERROR_MESSAGE, str);
        putExtra("com.jumio.nv.RESULT", 0);
    }

    public static IntentFilter a() {
        return new IntentFilter("com.jumio.nv.CLOSE_SDK");
    }
}
