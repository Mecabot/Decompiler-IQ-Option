package jumio.bam;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.jumio.bam.BamCardInformation;
import com.jumio.bam.BamSDK;
import java.util.ArrayList;

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
        super("com.jumio.bam.CLOSE_SDK");
    }

    public a(BamCardInformation bamCardInformation, ArrayList<String> arrayList) {
        super("com.jumio.bam.CLOSE_SDK");
        putStringArrayListExtra(BamSDK.EXTRA_SCAN_ATTEMPTS, arrayList);
        putExtra(BamSDK.EXTRA_CARD_INFORMATION, bamCardInformation);
        putExtra("com.jumio.bam.RESULT", -1);
    }

    public a(int i, int i2, String str, ArrayList<String> arrayList) {
        super("com.jumio.bam.CLOSE_SDK");
        putStringArrayListExtra(BamSDK.EXTRA_SCAN_ATTEMPTS, arrayList);
        putExtra(BamSDK.EXTRA_ERROR_CODE, i);
        putExtra(BamSDK.EXTRA_DETAILED_ERROR_CODE, i2);
        putExtra(BamSDK.EXTRA_ERROR_MESSAGE, str);
        putExtra("com.jumio.bam.RESULT", 0);
    }

    public static IntentFilter a() {
        return new IntentFilter("com.jumio.bam.CLOSE_SDK");
    }
}
