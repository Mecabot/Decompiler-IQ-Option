package jumio.bam;

import android.support.annotation.NonNull;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.sdk.models.BaseScanPartModel;

@PersistWith("BamScanPartModel")
/* compiled from: BamScanPartModel */
public class v extends BaseScanPartModel {
    public v(@NonNull ScanSide scanSide, @NonNull DocumentScanMode documentScanMode) {
        super(scanSide, documentScanMode, documentScanMode.getFormat());
    }
}
