package com.jumio.nv.custom;

import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class NetverifyCountry {
    private Map<NVDocumentType, Boolean> documentTypes;
    private String isoCode;

    public NetverifyCountry(String str, Map<NVDocumentType, Boolean> map) {
        this.isoCode = str;
        this.documentTypes = map;
    }

    public String getIsoCode() {
        return this.isoCode;
    }

    public Set<NVDocumentType> getDocumentTypes() {
        return this.documentTypes.keySet();
    }

    public Set<NVDocumentVariant> getDocumentVariants(NVDocumentType nVDocumentType) {
        Set<NVDocumentVariant> hashSet = new HashSet();
        hashSet.add(NVDocumentVariant.PLASTIC);
        if (((Boolean) this.documentTypes.get(nVDocumentType)).booleanValue()) {
            hashSet.add(NVDocumentVariant.PAPER);
        }
        return hashSet;
    }
}
