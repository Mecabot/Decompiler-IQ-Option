package jumio.nv.nfc;

import java.lang.reflect.Array;
import java.util.Vector;

/* compiled from: Decoder */
public class cf {
    private static final char[] e = new char[]{'B', 'C', 'R', 'Q', 'M', 'H', 'I'};
    private static final String[][] f = new String[][]{new String[]{"res", "<resolution level index>", "", null}, new String[]{"rate", "<decoding rate in bpp>", "", "-1"}, new String[]{"nbytes", "<decoding rate in bytes>", "", "-1"}, new String[]{"parsing", null, "", "on"}, new String[]{"ncb_quit", "<max number of code blocks>", "", "-1"}, new String[]{"l_quit", "<max number of layers>", "", "-1"}, new String[]{"m_quit", "<max number of bit planes>", "", "-1"}, new String[]{"poc_quit", null, "", "off"}, new String[]{"comp_transf", null, "", "on"}, new String[]{"nocolorspace", null, "", "off"}};
    private y a = null;
    private int b;
    private dt c;
    private bw d;

    public cf(dt dtVar) {
        this.c = dtVar;
    }

    public static String[][] a() {
        return f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ee A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.Error (r14_67 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02ec A:{Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }, Splitter: B:4:0x0005, ExcHandler: java.lang.RuntimeException (r14_63 'e' java.lang.RuntimeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02f9 A:{Splitter: B:4:0x0005, ExcHandler: all (unused java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00c9, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:37:?, code:
            r2 = new java.lang.StringBuilder();
            r2.append("error processing jp2 colorspace information");
     */
    /* JADX WARNING: Missing block: B:38:0x00d8, code:
            if (r14.getMessage() != null) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:39:0x00da, code:
            r4 = new java.lang.StringBuilder();
            r4.append(": ");
            r4.append(r14.getMessage());
            r4 = r4.toString();
     */
    /* JADX WARNING: Missing block: B:40:0x00f0, code:
            r4 = "    ";
     */
    /* JADX WARNING: Missing block: B:41:0x00f2, code:
            r2.append(r4);
            a(r2.toString(), 1, r14);
     */
    /* JADX WARNING: Missing block: B:42:0x00fc, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:43:0x00fd, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:44:0x00fe, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Could not instantiate ICC profiler");
     */
    /* JADX WARNING: Missing block: B:45:0x010c, code:
            if (r14.getMessage() != null) goto L_0x010e;
     */
    /* JADX WARNING: Missing block: B:46:0x010e, code:
            r4 = new java.lang.StringBuilder();
            r4.append(":\n");
            r4.append(r14.getMessage());
            r4 = r4.toString();
     */
    /* JADX WARNING: Missing block: B:47:0x0124, code:
            r4 = "";
     */
    /* JADX WARNING: Missing block: B:48:0x0126, code:
            r2.append(r4);
            a(r2.toString(), 1, r14);
     */
    /* JADX WARNING: Missing block: B:49:0x0130, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:74:0x01ad, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:75:0x01ae, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Cannot instantiate inverse wavelet transform");
     */
    /* JADX WARNING: Missing block: B:76:0x01bc, code:
            if (r14.getMessage() != null) goto L_0x01be;
     */
    /* JADX WARNING: Missing block: B:77:0x01be, code:
            r3 = new java.lang.StringBuilder();
            r3.append(":\n");
            r3.append(r14.getMessage());
            r14 = r3.toString();
     */
    /* JADX WARNING: Missing block: B:78:0x01d4, code:
            r14 = "";
     */
    /* JADX WARNING: Missing block: B:79:0x01d6, code:
            r2.append(r14);
            a(r2.toString(), 2);
     */
    /* JADX WARNING: Missing block: B:80:0x01e0, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:81:0x01e1, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:82:0x01e2, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Cannot instantiate dequantizer");
     */
    /* JADX WARNING: Missing block: B:83:0x01f0, code:
            if (r14.getMessage() != null) goto L_0x01f2;
     */
    /* JADX WARNING: Missing block: B:84:0x01f2, code:
            r3 = new java.lang.StringBuilder();
            r3.append(":\n");
            r3.append(r14.getMessage());
            r14 = r3.toString();
     */
    /* JADX WARNING: Missing block: B:85:0x0208, code:
            r14 = "";
     */
    /* JADX WARNING: Missing block: B:86:0x020a, code:
            r2.append(r14);
            a(r2.toString(), 2);
     */
    /* JADX WARNING: Missing block: B:87:0x0214, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:88:0x0215, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:89:0x0216, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Cannot instantiate roi de-scaler.");
     */
    /* JADX WARNING: Missing block: B:90:0x0224, code:
            if (r14.getMessage() != null) goto L_0x0226;
     */
    /* JADX WARNING: Missing block: B:91:0x0226, code:
            r3 = new java.lang.StringBuilder();
            r3.append(":\n");
            r3.append(r14.getMessage());
            r14 = r3.toString();
     */
    /* JADX WARNING: Missing block: B:92:0x023c, code:
            r14 = "";
     */
    /* JADX WARNING: Missing block: B:93:0x023e, code:
            r2.append(r14);
            a(r2.toString(), 2);
     */
    /* JADX WARNING: Missing block: B:94:0x0248, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:95:0x0249, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:96:0x024a, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Cannot instantiate entropy decoder");
     */
    /* JADX WARNING: Missing block: B:97:0x0258, code:
            if (r14.getMessage() != null) goto L_0x025a;
     */
    /* JADX WARNING: Missing block: B:98:0x025a, code:
            r3 = new java.lang.StringBuilder();
            r3.append(":\n");
            r3.append(r14.getMessage());
            r14 = r3.toString();
     */
    /* JADX WARNING: Missing block: B:99:0x0270, code:
            r14 = "";
     */
    /* JADX WARNING: Missing block: B:100:0x0272, code:
            r2.append(r14);
            a(r2.toString(), 2);
     */
    /* JADX WARNING: Missing block: B:101:0x027c, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:102:0x027d, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:103:0x027e, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Cannot instantiate bit stream reader");
     */
    /* JADX WARNING: Missing block: B:104:0x028c, code:
            if (r14.getMessage() != null) goto L_0x028e;
     */
    /* JADX WARNING: Missing block: B:105:0x028e, code:
            r3 = new java.lang.StringBuilder();
            r3.append(":\n");
            r3.append(r14.getMessage());
            r14 = r3.toString();
     */
    /* JADX WARNING: Missing block: B:106:0x02a4, code:
            r14 = "";
     */
    /* JADX WARNING: Missing block: B:107:0x02a6, code:
            r2.append(r14);
            a(r2.toString(), 2);
     */
    /* JADX WARNING: Missing block: B:108:0x02b0, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:109:0x02b1, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:110:0x02b2, code:
            r2 = new java.lang.StringBuilder();
            r2.append("Error while reading bit stream header or parsing packets");
     */
    /* JADX WARNING: Missing block: B:111:0x02c0, code:
            if (r14.getMessage() != null) goto L_0x02c2;
     */
    /* JADX WARNING: Missing block: B:112:0x02c2, code:
            r3 = new java.lang.StringBuilder();
            r3.append(":\n");
            r3.append(r14.getMessage());
            r14 = r3.toString();
     */
    /* JADX WARNING: Missing block: B:113:0x02d8, code:
            r14 = "";
     */
    /* JADX WARNING: Missing block: B:114:0x02da, code:
            r2.append(r14);
            a(r2.toString(), 4);
     */
    /* JADX WARNING: Missing block: B:115:0x02e5, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:118:0x02ec, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:119:0x02ee, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:120:0x02f0, code:
            r14 = move-exception;
     */
    /* JADX WARNING: Missing block: B:121:0x02f1, code:
            a(r14.getMessage(), 2);
     */
    /* JADX WARNING: Missing block: B:122:0x02f8, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:123:0x02f9, code:
            a("An uncaught exception has occurred.", 2);
     */
    /* JADX WARNING: Missing block: B:124:0x02fe, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:126:0x0303, code:
            if (r14.getMessage() != null) goto L_0x0305;
     */
    /* JADX WARNING: Missing block: B:127:0x0305, code:
            r2 = new java.lang.StringBuilder();
            r2.append("An uncaught runtime exception has occurred:\n");
            r2.append(r14.getMessage());
            a(r2.toString(), 2);
     */
    /* JADX WARNING: Missing block: B:128:0x031e, code:
            a("An uncaught runtime exception has occurred.", 2);
     */
    /* JADX WARNING: Missing block: B:129:0x0323, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:131:0x0328, code:
            if (r14.getMessage() != null) goto L_0x032a;
     */
    /* JADX WARNING: Missing block: B:132:0x032a, code:
            a(r14.getMessage(), 2);
     */
    /* JADX WARNING: Missing block: B:133:0x0332, code:
            a("An error has occured during decoding.", 2);
     */
    /* JADX WARNING: Missing block: B:134:0x0337, code:
            return null;
     */
    public android.graphics.Bitmap a(byte[] r14) {
        /*
        r13 = this;
        r0 = 0;
        if (r14 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 2;
        r2 = r13.c;	 Catch:{ IllegalArgumentException -> 0x02f0, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = e;	 Catch:{ IllegalArgumentException -> 0x02f0, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r13.c;	 Catch:{ IllegalArgumentException -> 0x02f0, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = f;	 Catch:{ IllegalArgumentException -> 0x02f0, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = jumio.nv.nfc.dt.a(r4);	 Catch:{ IllegalArgumentException -> 0x02f0, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.a(r3, r4);	 Catch:{ IllegalArgumentException -> 0x02f0, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = new jumio.nv.nfc.dr;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = new jumio.nv.nfc.cr;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.a();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r2.a;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x0031;
    L_0x002a:
        r3 = r2.c();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14.a(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
    L_0x0031:
        r3 = new jumio.nv.nfc.bw;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.d = r3;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r9 = new jumio.nv.nfc.cb;	 Catch:{ EOFException -> 0x02e6 }
        r3 = r13.c;	 Catch:{ EOFException -> 0x02e6 }
        r4 = r13.d;	 Catch:{ EOFException -> 0x02e6 }
        r9.<init>(r14, r3, r4);	 Catch:{ EOFException -> 0x02e6 }
        r3 = r9.i();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r13.d;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r4.a;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.c();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r10 = r9.m();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r11 = new int[r3];	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r12 = 0;
        r4 = 0;
    L_0x0054:
        if (r4 >= r3) goto L_0x005f;
    L_0x0056:
        r5 = r9.a(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r11[r4] = r5;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r4 + 1;
        goto L_0x0054;
    L_0x005f:
        r5 = r13.c;	 Catch:{ IOException -> 0x02b1, IllegalArgumentException -> 0x027d, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r7 = 0;
        r8 = r13.d;	 Catch:{ IOException -> 0x02b1, IllegalArgumentException -> 0x027d, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14;
        r4 = r9;
        r6 = r10;
        r3 = jumio.nv.nfc.by.a(r3, r4, r5, r6, r7, r8);	 Catch:{ IOException -> 0x02b1, IllegalArgumentException -> 0x027d, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r13.c;	 Catch:{ IllegalArgumentException -> 0x0249, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r9.a(r3, r4);	 Catch:{ IllegalArgumentException -> 0x0249, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = r13.c;	 Catch:{ IllegalArgumentException -> 0x0215, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r9.a(r4, r5, r10);	 Catch:{ IllegalArgumentException -> 0x0215, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r9.a(r4, r11, r10);	 Catch:{ IllegalArgumentException -> 0x01e1, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = jumio.nv.nfc.ed.a(r4, r10);	 Catch:{ IllegalArgumentException -> 0x01ad, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r3.g();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.i(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = new jumio.nv.nfc.da;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>(r4, r12);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = new jumio.nv.nfc.db;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = r13.c;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.<init>(r3, r10, r11, r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = r2.a;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = 1;
        if (r2 == 0) goto L_0x0131;
    L_0x0097:
        r2 = r13.c;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = "nocolorspace";
        r2 = r2.a(r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = "off";
        r2 = r2.equals(r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r2 == 0) goto L_0x0131;
    L_0x00a7:
        r2 = new jumio.nv.nfc.y;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = r13.c;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>(r14, r9, r5);	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a = r2;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r13.a;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r9.b(r4, r14);	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = r13.a;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r9.d(r14, r2);	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = r13.a;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r9.c(r14, r2);	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = r13.a;	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r9.a(r14, r2);	 Catch:{ IllegalArgumentException -> 0x00fd, z -> 0x00c9, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x0132;
    L_0x00c9:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = "error processing jp2 colorspace information";
        r2.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r4 == 0) goto L_0x00f0;
    L_0x00da:
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = ": ";
        r4.append(r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.append(r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r4.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x00f2;
    L_0x00f0:
        r4 = "    ";
    L_0x00f2:
        r2.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r2, r3, r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x00fd:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = "Could not instantiate ICC profiler";
        r2.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r4 == 0) goto L_0x0124;
    L_0x010e:
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = ":\n";
        r4.append(r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r5 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4.append(r5);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = r4.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x0126;
    L_0x0124:
        r4 = "";
    L_0x0126:
        r2.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r2, r3, r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x0131:
        r14 = r4;
    L_0x0132:
        if (r14 != 0) goto L_0x0135;
    L_0x0134:
        r14 = r4;
    L_0x0135:
        r14.b();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = new jumio.nv.nfc.dd;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>(r14, r12, r3, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.c();	 Catch:{ IOException -> 0x0179 }
        r14 = r2.a();	 Catch:{ IOException -> 0x0145 }
        return r14;
    L_0x0145:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "I/O error while closing output file (data may be corrupted";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x016c;
    L_0x0156:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x016e;
    L_0x016c:
        r14 = "";
    L_0x016e:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x0179:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "I/O error while writing output file";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x01a0;
    L_0x018a:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x01a2;
    L_0x01a0:
        r14 = "";
    L_0x01a2:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x01ad:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "Cannot instantiate inverse wavelet transform";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x01d4;
    L_0x01be:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x01d6;
    L_0x01d4:
        r14 = "";
    L_0x01d6:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x01e1:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "Cannot instantiate dequantizer";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x0208;
    L_0x01f2:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x020a;
    L_0x0208:
        r14 = "";
    L_0x020a:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x0215:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "Cannot instantiate roi de-scaler.";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x023c;
    L_0x0226:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x023e;
    L_0x023c:
        r14 = "";
    L_0x023e:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x0249:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "Cannot instantiate entropy decoder";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x0270;
    L_0x025a:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x0272;
    L_0x0270:
        r14 = "";
    L_0x0272:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x027d:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "Cannot instantiate bit stream reader";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x02a4;
    L_0x028e:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x02a6;
    L_0x02a4:
        r14 = "";
    L_0x02a6:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x02b1:
        r14 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = "Error while reading bit stream header or parsing packets";
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        if (r3 == 0) goto L_0x02d8;
    L_0x02c2:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r4 = ":\n";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r3.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        goto L_0x02da;
    L_0x02d8:
        r14 = "";
    L_0x02da:
        r2.append(r14);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r14 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r2 = 4;
        r13.a(r14, r2);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x02e6:
        r14 = "Codestream too short or bad header, unable to decode.";
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x02ec:
        r14 = move-exception;
        goto L_0x02ff;
    L_0x02ee:
        r14 = move-exception;
        goto L_0x0324;
    L_0x02f0:
        r14 = move-exception;
        r14 = r14.getMessage();	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        r13.a(r14, r1);	 Catch:{ IllegalArgumentException -> 0x0338, Error -> 0x02ee, RuntimeException -> 0x02ec, Throwable -> 0x02f9 }
        return r0;
    L_0x02f9:
        r14 = "An uncaught exception has occurred.";
        r13.a(r14, r1);
        return r0;
    L_0x02ff:
        r2 = r14.getMessage();
        if (r2 == 0) goto L_0x031e;
    L_0x0305:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "An uncaught runtime exception has occurred:\n";
        r2.append(r3);
        r14 = r14.getMessage();
        r2.append(r14);
        r14 = r2.toString();
        r13.a(r14, r1);
        goto L_0x0323;
    L_0x031e:
        r14 = "An uncaught runtime exception has occurred.";
        r13.a(r14, r1);
    L_0x0323:
        return r0;
    L_0x0324:
        r2 = r14.getMessage();
        if (r2 == 0) goto L_0x0332;
    L_0x032a:
        r14 = r14.getMessage();
        r13.a(r14, r1);
        goto L_0x0337;
    L_0x0332:
        r14 = "An error has occured during decoding.";
        r13.a(r14, r1);
    L_0x0337:
        return r0;
    L_0x0338:
        r14 = move-exception;
        r14 = r14.getMessage();
        r13.a(r14, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.cf.a(byte[]):android.graphics.Bitmap");
    }

    private void a(String str, int i) {
        this.b = i;
    }

    private void a(String str, int i, Throwable th) {
        this.b = i;
    }

    public static String[][] b() {
        int length;
        Vector vector = new Vector();
        String[][] f = by.f();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = co.a();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = dp.a();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = dk.a();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = db.a();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = cb.o();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = aa.a();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = a();
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                vector.addElement(f[length]);
            }
        }
        f = (String[][]) Array.newInstance(String.class, new int[]{vector.size(), 4});
        if (f != null) {
            for (length = f.length - 1; length >= 0; length--) {
                f[length] = (String[]) vector.elementAt(length);
            }
        }
        return f;
    }
}
