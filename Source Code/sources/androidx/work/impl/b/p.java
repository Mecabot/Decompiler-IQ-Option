package androidx.work.impl.b;

import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.State;

/* compiled from: WorkTypeConverters */
public class p {
    public static int a(State state) {
        switch (state) {
            case ENQUEUED:
                return 0;
            case RUNNING:
                return 1;
            case SUCCEEDED:
                return 2;
            case FAILED:
                return 3;
            case BLOCKED:
                return 4;
            case CANCELLED:
                return 5;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(state);
                stringBuilder.append(" to int");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static State m(int i) {
        switch (i) {
            case 0:
                return State.ENQUEUED;
            case 1:
                return State.RUNNING;
            case 2:
                return State.SUCCEEDED;
            case 3:
                return State.FAILED;
            case 4:
                return State.BLOCKED;
            case 5:
                return State.CANCELLED;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(i);
                stringBuilder.append(" to State");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static int a(BackoffPolicy backoffPolicy) {
        switch (backoffPolicy) {
            case EXPONENTIAL:
                return 0;
            case LINEAR:
                return 1;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(backoffPolicy);
                stringBuilder.append(" to int");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static BackoffPolicy n(int i) {
        switch (i) {
            case 0:
                return BackoffPolicy.EXPONENTIAL;
            case 1:
                return BackoffPolicy.LINEAR;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(i);
                stringBuilder.append(" to BackoffPolicy");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static int d(NetworkType networkType) {
        switch (networkType) {
            case NOT_REQUIRED:
                return 0;
            case CONNECTED:
                return 1;
            case UNMETERED:
                return 2;
            case NOT_ROAMING:
                return 3;
            case METERED:
                return 4;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(networkType);
                stringBuilder.append(" to int");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static NetworkType o(int i) {
        switch (i) {
            case 0:
                return NetworkType.NOT_REQUIRED;
            case 1:
                return NetworkType.CONNECTED;
            case 2:
                return NetworkType.UNMETERED;
            case 3:
                return NetworkType.NOT_ROAMING;
            case 4:
                return NetworkType.METERED;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(i);
                stringBuilder.append(" to NetworkType");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A:{SYNTHETIC, Splitter: B:28:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006f A:{SYNTHETIC, Splitter: B:39:0x006f} */
    public static byte[] b(androidx.work.c r4) {
        /*
        r0 = r4.size();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x0052 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0052 }
        r1 = r4.size();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r2.writeInt(r1);	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r4 = r4.iterator();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
    L_0x001d:
        r1 = r4.hasNext();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        if (r1 == 0) goto L_0x003c;
    L_0x0023:
        r1 = r4.next();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r1 = (androidx.work.c.a) r1;	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r3 = r1.getUri();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r3 = r3.toString();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r2.writeUTF(r3);	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r1 = r1.aP();	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        r2.writeBoolean(r1);	 Catch:{ IOException -> 0x004c, all -> 0x004a }
        goto L_0x001d;
    L_0x003c:
        if (r2 == 0) goto L_0x0046;
    L_0x003e:
        r2.close();	 Catch:{ IOException -> 0x0042 }
        goto L_0x0046;
    L_0x0042:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0068;
    L_0x004a:
        r4 = move-exception;
        goto L_0x006d;
    L_0x004c:
        r4 = move-exception;
        r1 = r2;
        goto L_0x0053;
    L_0x004f:
        r4 = move-exception;
        r2 = r1;
        goto L_0x006d;
    L_0x0052:
        r4 = move-exception;
    L_0x0053:
        r4.printStackTrace();	 Catch:{ all -> 0x004f }
        if (r1 == 0) goto L_0x0060;
    L_0x0058:
        r1.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0060;
    L_0x005c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0060:
        r0.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0068;
    L_0x0064:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0068:
        r4 = r0.toByteArray();
        return r4;
    L_0x006d:
        if (r2 == 0) goto L_0x0077;
    L_0x006f:
        r2.close();	 Catch:{ IOException -> 0x0073 }
        goto L_0x0077;
    L_0x0073:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0077:
        r0.close();	 Catch:{ IOException -> 0x007b }
        goto L_0x007f;
    L_0x007b:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x007f:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.b.p.b(androidx.work.c):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A:{SYNTHETIC, Splitter: B:26:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005c A:{SYNTHETIC, Splitter: B:37:0x005c} */
    public static androidx.work.c e(byte[] r6) {
        /*
        r0 = new androidx.work.c;
        r0.<init>();
        if (r6 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = new java.io.ByteArrayInputStream;
        r1.<init>(r6);
        r6 = 0;
        r2 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x003f, all -> 0x003b }
        r2.<init>(r1);	 Catch:{ IOException -> 0x003f, all -> 0x003b }
        r6 = r2.readInt();	 Catch:{ IOException -> 0x0039 }
    L_0x0017:
        if (r6 <= 0) goto L_0x002b;
    L_0x0019:
        r3 = r2.readUTF();	 Catch:{ IOException -> 0x0039 }
        r3 = android.net.Uri.parse(r3);	 Catch:{ IOException -> 0x0039 }
        r4 = r2.readBoolean();	 Catch:{ IOException -> 0x0039 }
        r0.a(r3, r4);	 Catch:{ IOException -> 0x0039 }
        r6 = r6 + -1;
        goto L_0x0017;
    L_0x002b:
        if (r2 == 0) goto L_0x0035;
    L_0x002d:
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0035;
    L_0x0031:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0035:
        r1.close();	 Catch:{ IOException -> 0x0054 }
        goto L_0x0058;
    L_0x0039:
        r6 = move-exception;
        goto L_0x0043;
    L_0x003b:
        r0 = move-exception;
        r2 = r6;
        r6 = r0;
        goto L_0x005a;
    L_0x003f:
        r2 = move-exception;
        r5 = r2;
        r2 = r6;
        r6 = r5;
    L_0x0043:
        r6.printStackTrace();	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0050;
    L_0x0048:
        r2.close();	 Catch:{ IOException -> 0x004c }
        goto L_0x0050;
    L_0x004c:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0050:
        r1.close();	 Catch:{ IOException -> 0x0054 }
        goto L_0x0058;
    L_0x0054:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0058:
        return r0;
    L_0x0059:
        r6 = move-exception;
    L_0x005a:
        if (r2 == 0) goto L_0x0064;
    L_0x005c:
        r2.close();	 Catch:{ IOException -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0064:
        r1.close();	 Catch:{ IOException -> 0x0068 }
        goto L_0x006c;
    L_0x0068:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x006c:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.b.p.e(byte[]):androidx.work.c");
    }
}
