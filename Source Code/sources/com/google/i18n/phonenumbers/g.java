package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MultiFileMetadataSourceImpl */
final class g implements f {
    private final String aaj;
    private final d aak;
    private final ConcurrentHashMap<String, PhoneMetadata> aal;
    private final ConcurrentHashMap<Integer, PhoneMetadata> aam;

    g(String str, d dVar) {
        this.aal = new ConcurrentHashMap();
        this.aam = new ConcurrentHashMap();
        this.aaj = str;
        this.aak = dVar;
    }

    g(d dVar) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", dVar);
    }

    public PhoneMetadata de(String str) {
        return e.a(str, this.aal, this.aaj, this.aak);
    }

    public PhoneMetadata bD(int i) {
        if (bE(i)) {
            return e.a(Integer.valueOf(i), this.aam, this.aaj, this.aak);
        }
        return null;
    }

    private boolean bE(int i) {
        List list = (List) c.xm().get(Integer.valueOf(i));
        if (list.size() == 1 && "001".equals(list.get(0))) {
            return true;
        }
        return false;
    }
}
