package jumio.nv.core;

import android.support.annotation.Nullable;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import java.util.List;

/* compiled from: CountryDoctypeDatabase */
public interface l {
    @Nullable
    Country a(String str);

    List<DocumentType> a(Country country);

    List<Country> a(NVDocumentType... nVDocumentTypeArr);

    void a(Country country, DocumentType... documentTypeArr);

    boolean a();

    @Nullable
    Country b(String str);

    List<Country> b();

    boolean b(Country country);
}
