package jumio.nv.core;

import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

/* compiled from: SimpleCountryDoctypeDatabase */
public class m implements Serializable, l {
    private HashMap<Country, List<DocumentType>> a = new LinkedHashMap();

    public void a(Country country, DocumentType... documentTypeArr) {
        this.a.put(country, Arrays.asList(documentTypeArr));
    }

    public List<DocumentType> a(Country country) {
        return (List) this.a.get(a(country.getIsoCode()));
    }

    public Country a(String str) {
        for (Country country : this.a.keySet()) {
            if (country.getIsoCode().equals(str)) {
                return country;
            }
        }
        return null;
    }

    public List<Country> a(NVDocumentType... nVDocumentTypeArr) {
        List<Country> linkedList = new LinkedList();
        for (Entry entry : this.a.entrySet()) {
            for (DocumentType documentType : (List) entry.getValue()) {
                int length = nVDocumentTypeArr.length;
                int i = 0;
                while (i < length) {
                    if (!documentType.getId().equals(nVDocumentTypeArr[i])) {
                        i++;
                    } else if (!linkedList.contains(entry.getKey())) {
                        linkedList.add(entry.getKey());
                    }
                }
            }
        }
        return linkedList;
    }

    public Country b(String str) {
        return a(new Locale("", str).getISO3Country());
    }

    public boolean b(Country country) {
        return this.a.containsKey(a(country.getIsoCode()));
    }

    public boolean a() {
        return this.a.isEmpty();
    }

    public List<Country> b() {
        return new ArrayList(this.a.keySet());
    }
}
