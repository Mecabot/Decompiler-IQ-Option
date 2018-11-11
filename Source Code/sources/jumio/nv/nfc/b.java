package jumio.nv.nfc;

/* compiled from: DefaultLDSProvider */
public class b implements d {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0057 A:{Splitter: B:1:0x0020, ExcHandler: java.io.IOException (r0_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0054 A:{Splitter: B:3:0x0039, ExcHandler: java.io.IOException (r0_0 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:5:0x0054, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:6:0x0055, code:
            r5 = r0;
     */
    /* JADX WARNING: Missing block: B:7:0x0057, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x0058, code:
            r5 = r0;
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:9:0x005a, code:
            r5.printStackTrace();
            jumio.nv.nfc.f.a("DefaultLDSProvider", "Could not read file", r5);
            r3.a(jumio.nv.nfc.q.ERROR, r5);
     */
    public jumio.nv.nfc.o a(org.jmrtd.PassportService r18, java.util.Collection<java.lang.Integer> r19, boolean r20) {
        /*
        r17 = this;
        r1 = r18;
        r2 = r19;
        r3 = new jumio.nv.nfc.o;
        r4 = jumio.nv.nfc.p.READ_LDS;
        r5 = jumio.nv.nfc.q.SUCCESSFUL;
        r3.<init>(r4, r5);
        r4 = "DefaultLDSProvider";
        r5 = "setting up LDS";
        jumio.nv.nfc.f.a(r4, r5);
        r4 = new jumio.nv.nfc.c;
        r4.<init>();
        r3.a(r4);
        r5 = 286; // 0x11e float:4.01E-43 double:1.413E-321;
        r6 = 1;
        r7 = 0;
        r8 = r1.e(r5);	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r9 = r8.getLength();	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r4.a(r5, r8, r9);	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r4.a();	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r5 = 285; // 0x11d float:4.0E-43 double:1.41E-321;
        r5 = r1.e(r5);	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r8 = new org.jmrtd.lds.SODFile;	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r8.<init>(r5);	 Catch:{ IOException -> 0x0057, IOException -> 0x0057 }
        r4.a(r8);	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        r5 = 257; // 0x101 float:3.6E-43 double:1.27E-321;
        r7 = r1.e(r5);	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        r9 = r7.getLength();	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        r4.a(r5, r7, r9);	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        r4.c();	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        r2.add(r5);	 Catch:{ IOException -> 0x0054, IOException -> 0x0054 }
        goto L_0x0069;
    L_0x0054:
        r0 = move-exception;
        r5 = r0;
        goto L_0x005a;
    L_0x0057:
        r0 = move-exception;
        r5 = r0;
        r8 = r7;
    L_0x005a:
        r5.printStackTrace();
        r7 = "DefaultLDSProvider";
        r9 = "Could not read file";
        jumio.nv.nfc.f.a(r7, r9, r5);
        r7 = jumio.nv.nfc.q.ERROR;
        r3.a(r7, r5);
    L_0x0069:
        r5 = new java.util.ArrayList;
        r5.<init>();
        if (r8 != 0) goto L_0x007d;
    L_0x0070:
        r1 = jumio.nv.nfc.q.ERROR;
        r2 = new java.lang.Throwable;
        r4 = "SOD file could not be read";
        r2.<init>(r4);
        r3.a(r1, r2);
        return r3;
    L_0x007d:
        r7 = r8.bAT();
        r7 = r7.keySet();
        r5.addAll(r7);
        java.util.Collections.sort(r5);
        r7 = "DefaultLDSProvider";
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "prefetching DGs: ";
        r8.append(r9);
        r8.append(r5);
        r8 = r8.toString();
        jumio.nv.nfc.f.a(r7, r8);
        r7 = new java.util.ArrayList;
        r7.<init>();
        r8 = 5;
        r8 = new java.lang.Integer[r8];
        r9 = 8;
        r9 = java.lang.Integer.valueOf(r9);
        r10 = 0;
        r8[r10] = r9;
        r9 = 9;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r6] = r9;
        r9 = 10;
        r9 = java.lang.Integer.valueOf(r9);
        r11 = 2;
        r8[r11] = r9;
        r9 = 13;
        r9 = java.lang.Integer.valueOf(r9);
        r12 = 3;
        r8[r12] = r9;
        r9 = 16;
        r9 = java.lang.Integer.valueOf(r9);
        r13 = 4;
        r8[r13] = r9;
        java.util.Collections.addAll(r7, r8);
        r5 = r5.iterator();
    L_0x00dc:
        r8 = r5.hasNext();
        if (r8 == 0) goto L_0x01cd;
    L_0x00e2:
        r8 = r5.next();
        r8 = (java.lang.Integer) r8;
        r8 = r8.intValue();
        r9 = java.lang.Integer.valueOf(r8);
        r9 = r7.contains(r9);
        if (r9 == 0) goto L_0x010a;
    L_0x00f6:
        r9 = "DefaultLDSProvider";
        r14 = "DG%d is not valid - skipping!";
        r15 = new java.lang.Object[r6];
        r8 = java.lang.Integer.valueOf(r8);
        r15[r10] = r8;
        r8 = java.lang.String.format(r14, r15);
        jumio.nv.nfc.f.b(r9, r8);
        goto L_0x00dc;
    L_0x010a:
        r9 = java.lang.Integer.valueOf(r8);
        r9 = r2.contains(r9);
        if (r9 == 0) goto L_0x0115;
    L_0x0114:
        goto L_0x00dc;
    L_0x0115:
        if (r20 != 0) goto L_0x011a;
    L_0x0117:
        if (r8 != r11) goto L_0x011a;
    L_0x0119:
        goto L_0x00dc;
    L_0x011a:
        if (r8 == r12) goto L_0x00dc;
    L_0x011c:
        if (r8 != r13) goto L_0x011f;
    L_0x011e:
        goto L_0x00dc;
    L_0x011f:
        r14 = "DefaultLDSProvider";
        r15 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r15.<init>();	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r6 = "reading DG";
        r15.append(r6);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r15.append(r8);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r6 = r15.toString();	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        jumio.nv.nfc.f.a(r14, r6);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r6 = org.jmrtd.lds.a.mv(r8);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r14 = r1.e(r6);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r15 = r14.getLength();	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r4.a(r6, r14, r15);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r6 = r4.b(r6);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r6.getEncoded();	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r14.close();	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r6 = java.lang.Integer.valueOf(r8);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        r2.add(r6);	 Catch:{ IOException -> 0x01a4, CardServiceException -> 0x0177, NumberFormatException -> 0x0156 }
        goto L_0x01a0;
    L_0x0156:
        r0 = move-exception;
        r6 = r0;
        r14 = "DefaultLDSProvider";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r10 = "NumberFormatException trying to get FID for DG";
        r15.append(r10);
        r15.append(r8);
        r8 = r15.toString();
        jumio.nv.nfc.f.c(r14, r8);
        r6.printStackTrace();
        r8 = jumio.nv.nfc.q.ERROR;
        r3.a(r8, r6);
        goto L_0x01a0;
    L_0x0177:
        r0 = move-exception;
        r6 = r0;
        r10 = "DefaultLDSProvider";
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = "Could not read DG";
        r14.append(r15);
        r14.append(r8);
        r8 = ": ";
        r14.append(r8);
        r8 = r6.getMessage();
        r14.append(r8);
        r8 = r14.toString();
        jumio.nv.nfc.f.c(r10, r8);
        r8 = jumio.nv.nfc.q.ERROR;
        r3.a(r8, r6);
    L_0x01a0:
        r6 = 1;
        r10 = 0;
        goto L_0x00dc;
    L_0x01a4:
        r0 = move-exception;
        r1 = r0;
        r2 = "DefaultLDSProvider";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Error reading DG";
        r4.append(r5);
        r4.append(r8);
        r5 = ": ";
        r4.append(r5);
        r5 = r1.getMessage();
        r4.append(r5);
        r4 = r4.toString();
        jumio.nv.nfc.f.c(r2, r4);
        r2 = jumio.nv.nfc.q.ERROR;
        r3.a(r2, r1);
    L_0x01cd:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.b.a(org.jmrtd.PassportService, java.util.Collection, boolean):jumio.nv.nfc.o");
    }
}
