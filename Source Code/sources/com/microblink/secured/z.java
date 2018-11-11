package com.microblink.secured;

/* compiled from: line */
public final class z {
    String dUh = "licensee";
    String dVN = "productVersion";
    String dWk = "licenseKey";
    String dXL = "product";
    String dXM = "ANDROID";
    String dXN = "osVersion";
    String dXO = "userId";
    long dXP = 0;
    boolean dXQ = false;
    String dXa = "device";
    String mPackageName = "packageName";

    /* compiled from: line */
    public static class a {
        String dUh = null;
        String dWk = null;
        String dXO = null;
        boolean dXQ = false;
        e dXR = null;
        Long dXS = null;
        String mPackageName = null;

        static String kE(String str) {
            return str == null ? "" : str;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product: ");
        stringBuilder.append(this.dXL);
        stringBuilder.append("\nVersion: ");
        stringBuilder.append(this.dVN);
        stringBuilder.append("\nLicensee: ");
        stringBuilder.append(this.dUh);
        stringBuilder.append("\nPlatform: ");
        stringBuilder.append(this.dXM);
        stringBuilder.append("\nOS version: ");
        stringBuilder.append(this.dXN);
        stringBuilder.append("\nDevice: ");
        stringBuilder.append(this.dXa);
        stringBuilder.append("\nLicense key: ");
        stringBuilder.append(this.dWk);
        stringBuilder.append("\nUserId: ");
        stringBuilder.append(this.dXO);
        stringBuilder.append("\nScans: ");
        stringBuilder.append(this.dXP);
        stringBuilder.append("\nPackageName: ");
        stringBuilder.append(this.mPackageName);
        stringBuilder.append("\nRefresh key: ");
        stringBuilder.append(this.dXQ);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
