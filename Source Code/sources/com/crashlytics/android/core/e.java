package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: CLSUUID */
class e {
    private static final AtomicLong tq = new AtomicLong(0);
    private static String tr;

    public e(IdManager idManager) {
        r0 = new byte[10];
        g(r0);
        h(r0);
        i(r0);
        String lx = CommonUtils.lx(idManager.aUG());
        String Z = CommonUtils.Z(r0);
        tr = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{Z.substring(0, 12), Z.substring(12, 16), Z.subSequence(16, 20), lx.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void g(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] l = l(j);
        bArr[0] = l[0];
        bArr[1] = l[1];
        bArr[2] = l[2];
        bArr[3] = l[3];
        byte[] m = m(time);
        bArr[4] = m[0];
        bArr[5] = m[1];
    }

    private void h(byte[] bArr) {
        byte[] m = m(tq.incrementAndGet());
        bArr[6] = m[0];
        bArr[7] = m[1];
    }

    private void i(byte[] bArr) {
        byte[] m = m((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = m[0];
        bArr[9] = m[1];
    }

    private static byte[] l(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return tr;
    }
}
