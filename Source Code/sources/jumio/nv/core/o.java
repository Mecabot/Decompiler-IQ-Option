package jumio.nv.core;

import com.jumio.core.data.document.ScanSide;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.NVDocumentType;
import java.io.Serializable;
import java.util.List;

/* compiled from: TemplateMatcherStorage */
public interface o extends Serializable {
    void a(String str, byte[] bArr);

    boolean a(Country country, NVDocumentType nVDocumentType, ScanSide scanSide);

    boolean a(String str);

    List<String> b(Country country, NVDocumentType nVDocumentType, ScanSide scanSide);
}
