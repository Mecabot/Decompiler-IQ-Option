package com.jumio.nv.models;

import android.support.annotation.NonNull;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import java.util.LinkedList;
import java.util.List;
import jumio.nv.core.l;
import jumio.nv.core.m;

public class CountryDocumentModel implements StaticModel {
    private l a;

    public CountryDocumentModel() {
        this.a = new m();
    }

    public CountryDocumentModel(l lVar) {
        this.a = lVar;
    }

    public void add(Country country, DocumentType... documentTypeArr) {
        this.a.a(country, documentTypeArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x000f A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Missing block: B:6:0x002a, code:
            if (r2.getParts() == 0) goto L_0x002c;
     */
    public java.util.List<com.jumio.nv.data.document.DocumentType> getDocumentTypesFor(com.jumio.nv.data.country.Country r8, boolean r9, boolean r10, java.util.List<com.jumio.nv.data.document.NVDocumentType> r11, @android.support.annotation.Nullable com.jumio.nv.data.document.NVDocumentVariant r12) {
        /*
        r7 = this;
        r0 = new java.util.LinkedList;
        r0.<init>();
        r1 = r7.a;
        r1 = r1.a(r8);
        r1 = r1.iterator();
    L_0x000f:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0092;
    L_0x0015:
        r2 = r1.next();
        r2 = (com.jumio.nv.data.document.DocumentType) r2;
        r3 = r2.getId();
        r3 = r11.contains(r3);
        r4 = 0;
        if (r9 == 0) goto L_0x002e;
    L_0x0026:
        r5 = r2.getParts();
        if (r5 != 0) goto L_0x007a;
    L_0x002c:
        r3 = 0;
        goto L_0x007a;
    L_0x002e:
        r5 = r2.hasExtractionMethod();
        if (r5 == 0) goto L_0x002c;
    L_0x0034:
        r5 = new com.jumio.nv.data.document.DocumentType;
        r5.<init>(r2);
        r2 = "DEU";
        r6 = r8.getIsoCode();
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0067;
    L_0x0045:
        r2 = r5.getId();
        r6 = com.jumio.nv.data.document.NVDocumentType.IDENTITY_CARD;
        if (r2 != r6) goto L_0x0067;
    L_0x004d:
        if (r10 == 0) goto L_0x005d;
    L_0x004f:
        r2 = com.jumio.core.data.document.DocumentScanMode.TD1;
        r5.setDocumentScanMode(r2);
        r2 = com.jumio.core.plugins.PluginRegistry.PluginMode.MRZ;
        r2 = com.jumio.core.plugins.PluginRegistry.hasPlugin(r2);
        if (r2 != 0) goto L_0x005d;
    L_0x005c:
        r3 = 0;
    L_0x005d:
        r2 = com.jumio.core.plugins.PluginRegistry.PluginMode.MRZ;
        r2 = com.jumio.core.plugins.PluginRegistry.hasPlugin(r2);
        r5.setPaperVariant(r2);
        goto L_0x006a;
    L_0x0067:
        r5.setPaperVariant(r4);
    L_0x006a:
        if (r10 == 0) goto L_0x0079;
    L_0x006c:
        r2 = r5.getDocumentScanMode();
        r6 = com.jumio.core.data.document.DocumentScanMode.CSSN;
        if (r2 != r6) goto L_0x0076;
    L_0x0074:
        r2 = r5;
        goto L_0x002c;
    L_0x0076:
        r5.setFallbackScan(r4);
    L_0x0079:
        r2 = r5;
    L_0x007a:
        if (r12 == 0) goto L_0x008b;
    L_0x007c:
        r5 = com.jumio.nv.data.document.NVDocumentVariant.PAPER;
        r5 = r12.equals(r5);
        if (r5 == 0) goto L_0x008b;
    L_0x0084:
        r5 = r2.hasPaperVariant();
        if (r5 != 0) goto L_0x008b;
    L_0x008a:
        r3 = 0;
    L_0x008b:
        if (r3 == 0) goto L_0x000f;
    L_0x008d:
        r0.add(r2);
        goto L_0x000f;
    L_0x0092:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.models.CountryDocumentModel.getDocumentTypesFor(com.jumio.nv.data.country.Country, boolean, boolean, java.util.List, com.jumio.nv.data.document.NVDocumentVariant):java.util.List<com.jumio.nv.data.document.DocumentType>");
    }

    public DocumentType getDocumentTypeFor(@NonNull String str, @NonNull NVDocumentType nVDocumentType) {
        Country countryForIso3 = getCountryForIso3(str);
        if (countryForIso3 == null) {
            return null;
        }
        for (DocumentType documentType : this.a.a(countryForIso3)) {
            if (nVDocumentType.equals(documentType.getId())) {
                return documentType;
            }
        }
        return null;
    }

    public List<Country> getCountriesFor(boolean z, boolean z2, List<NVDocumentType> list, NVDocumentVariant nVDocumentVariant) {
        List<Country> linkedList = new LinkedList();
        for (Country country : this.a.a((NVDocumentType[]) list.toArray(new NVDocumentType[list.size()]))) {
            if (getDocumentTypesFor(country, z, z2, list, nVDocumentVariant).size() > 0) {
                linkedList.add(country);
            }
        }
        return linkedList;
    }

    public Country getCountryForIso3(String str) {
        return this.a.a(str);
    }

    public Country getCountryForIso2(String str) {
        return this.a.b(str);
    }

    public boolean contains(Country country) {
        return this.a.b(country);
    }

    public boolean isEmpty() {
        return this.a.a();
    }

    public List<Country> getCountries() {
        return this.a.b();
    }
}
