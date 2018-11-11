package io.fabric.sdk.android.services.common;

/* compiled from: AdvertisingInfo */
class b {
    public final String emJ;
    public final boolean emK;

    b(String str, boolean z) {
        this.emJ = str;
        this.emK = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.emK != bVar.emK) {
            return false;
        }
        return this.emJ == null ? bVar.emJ == null : this.emJ.equals(bVar.emJ);
    }

    public int hashCode() {
        return ((this.emJ != null ? this.emJ.hashCode() : 0) * 31) + this.emK;
    }
}
