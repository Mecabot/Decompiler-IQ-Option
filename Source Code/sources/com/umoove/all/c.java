package com.umoove.all;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import com.iqoption.dto.Currencies;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: FrameProccesor */
public class c extends Thread {
    private boolean a = true;
    private int b;
    private int c;
    private int d;
    private byte[] e;
    private float[] eja;
    private g ejb;
    private LinkedBlockingQueue<d> ejc = new LinkedBlockingQueue();
    private LinkedBlockingQueue<byte[]> ejd = new LinkedBlockingQueue();
    private LinkedBlockingQueue<Long> eje = new LinkedBlockingQueue();
    private int h = -1;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private int n;
    private int o = 3;
    private int p = 1;
    private boolean t = true;

    public c(int i) {
        this.eja = new float[i];
    }

    public void a(g gVar, int i, int i2) {
        setPriority(10);
        this.ejb = gVar;
        this.h = 0;
        this.b = (int) ((((double) i2) * 1.5d) * ((double) i));
        this.c = i2;
        this.d = i;
    }

    public void a(d dVar) {
        this.ejc.add(dVar);
        interrupt();
    }

    /* JADX WARNING: Can't wrap try/catch for R(4:3|4|(2:(2:8|6)|15)(3:9|10|16)|1) */
    /* JADX WARNING: Missing block: B:2:0x000b, code:
            if (r2.a != false) goto L_0x000d;
     */
    /* JADX WARNING: Missing block: B:5:0x0013, code:
            if (r2.ejc.isEmpty() == false) goto L_0x0015;
     */
    /* JADX WARNING: Missing block: B:7:0x001b, code:
            if (r2.ejc.isEmpty() == false) goto L_0x001d;
     */
    /* JADX WARNING: Missing block: B:8:0x001d, code:
            b((com.umoove.all.d) r2.ejc.poll());
     */
    /* JADX WARNING: Missing block: B:9:0x0029, code:
            a((byte[]) r2.ejd.take(), (java.lang.Long) r2.eje.take());
     */
    /* JADX WARNING: Missing block: B:11:0x003d, code:
            com.umoove.all.UMNativeCore.Destroy();
     */
    /* JADX WARNING: Missing block: B:12:0x0040, code:
            return;
     */
    public void run() {
        /*
        r2 = this;
        r0 = java.lang.Thread.currentThread();
        r1 = 10;
        r0.setPriority(r1);
    L_0x0009:
        r0 = r2.a;
        if (r0 == 0) goto L_0x003d;
    L_0x000d:
        r0 = r2.ejc;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0009 }
        if (r0 != 0) goto L_0x0029;
    L_0x0015:
        r0 = r2.ejc;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0009 }
        if (r0 != 0) goto L_0x0009;
    L_0x001d:
        r0 = r2.ejc;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = r0.poll();	 Catch:{ InterruptedException -> 0x0009 }
        r0 = (com.umoove.all.d) r0;	 Catch:{ InterruptedException -> 0x0009 }
        r2.b(r0);	 Catch:{ InterruptedException -> 0x0009 }
        goto L_0x0015;
    L_0x0029:
        r0 = r2.ejd;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x0009 }
        r0 = (byte[]) r0;	 Catch:{ InterruptedException -> 0x0009 }
        r1 = r2.eje;	 Catch:{ InterruptedException -> 0x0009 }
        r1 = r1.take();	 Catch:{ InterruptedException -> 0x0009 }
        r1 = (java.lang.Long) r1;	 Catch:{ InterruptedException -> 0x0009 }
        r2.a(r0, r1);	 Catch:{ InterruptedException -> 0x0009 }
        goto L_0x0009;
    L_0x003d:
        com.umoove.all.UMNativeCore.Destroy();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umoove.all.c.run():void");
    }

    public void l(byte[] bArr, int i) {
        this.n = i;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (bArr.length < this.b || this.k) {
            boolean z = this.k;
            return;
        }
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        this.e = new byte[this.b];
        System.arraycopy(bArr, 0, this.e, 0, this.b);
        this.ejd.offer(this.e);
        this.eje.offer(valueOf);
        Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() - valueOf2.longValue()).toString();
    }

    void a(byte[] bArr, Long l) {
        try {
            Object obj;
            switch (this.h) {
                case 2:
                    UMNativeCore.Start();
                    this.k = true;
                    UMNativeCore.Process(bArr, this.eja, this.n, l.longValue());
                    if (this.eja[0] == 1.0f) {
                        this.h = 4;
                    } else {
                        if (this.m && this.p == 1) {
                            YuvImage yuvImage = new YuvImage(bArr, 17, this.d, this.c, null);
                            Rect rect = new Rect(0, 0, this.d, this.c);
                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                            try {
                                String str = Currencies.REPLACE_CURRENCY_MASK;
                                Object[] objArr = new Object[1];
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
                                stringBuilder.append("/unDetect_");
                                stringBuilder.append(System.currentTimeMillis());
                                stringBuilder.append(".jpg");
                                objArr[0] = stringBuilder.toString();
                                FileOutputStream fileOutputStream = new FileOutputStream(String.format(str, objArr));
                                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (FileNotFoundException unused) {
                                System.out.println("Saving to file failed");
                            } catch (IOException unused2) {
                                System.out.println("Saving to file failed");
                            } catch (Exception unused3) {
                                System.out.println("Saving to file failed");
                            }
                        }
                        this.ejd.clear();
                        this.eje.clear();
                        if (!(this.j && this.h == 2)) {
                            if (this.p < this.o) {
                                this.p++;
                                obj = 1;
                                this.k = false;
                                break;
                            }
                            this.h = 0;
                        }
                    }
                    obj = null;
                    this.k = false;
                case 3:
                    this.l = true;
                    UMNativeCore.Process(bArr, this.eja, this.n, l.longValue());
                    if (this.eja[0] == -1.0f) {
                        this.ejd.clear();
                        this.eje.clear();
                        if (this.i && this.h == 3) {
                            this.h = 2;
                        } else {
                            this.h = 0;
                        }
                    } else {
                        this.h = 4;
                    }
                    this.l = false;
                    break;
                case 4:
                    this.l = true;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    UMNativeCore.Process(bArr, this.eja, this.n, l.longValue());
                    Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() - valueOf.longValue()).toString();
                    if (this.eja[0] == -1.0f) {
                        if (this.i && this.h == 4) {
                            this.h = 2;
                        } else {
                            this.h = 0;
                        }
                    }
                    this.l = false;
                    break;
            }
            obj = null;
            this.eja[1] = (float) this.h;
            if (obj == null) {
                this.ejb.f(this.eja);
            }
        } catch (Exception unused4) {
            this.h = 2;
            this.eja[1] = (float) this.h;
            this.ejb.f(this.eja);
        }
    }

    private void b(d dVar) {
        d dVar2 = dVar;
        switch (dVar.a()) {
            case 0:
                UMNativeCore.InitNative(dVar2.a, dVar2.b, dVar2.c, dVar2.d, dVar2.o, dVar2.e, dVar2.f, dVar2.g, dVar2.h, dVar2.i, dVar2.ejf, dVar2.ejg, dVar2.m, dVar2.n, dVar2.p);
                return;
            case 1:
                UMNativeCore.Reset();
                return;
            case 2:
                this.i = dVar2.q;
                this.j = dVar2.q;
                if (this.h == 0 || this.t) {
                    this.h = 2;
                    this.p = 1;
                    return;
                } else if (this.h == 4) {
                    UMNativeCore.Reset();
                    return;
                } else {
                    return;
                }
            case 3:
                this.i = false;
                this.ejd.clear();
                this.eje.clear();
                if (this.h != 0) {
                    this.h = 0;
                    UMNativeCore.Stop();
                    UMNativeCore.Reset();
                    return;
                }
                return;
            case 4:
                UMNativeCore.SetDisplayWindow(dVar2.c, dVar2.d);
                return;
            case 5:
                UMNativeCore.Destroy();
                return;
            case 7:
                UMNativeCore.setInitEyeMovement();
                return;
            case 8:
                UMNativeCore.setInitHeadCenter();
                return;
            case 9:
                UMNativeCore.setInitHeadMovement();
                return;
            case 10:
                UMNativeCore.setInitIris();
                return;
            case 11:
                UMNativeCore.setIrisTrackingMode(dVar2.u);
                return;
            case 12:
                UMNativeCore.setIrisRadius(dVar2.ejh);
                return;
            case 13:
                UMNativeCore.setEyeBallRadius(dVar2.s);
                return;
            case 14:
                UMNativeCore.setDistanceBetweenEyes(dVar2.t);
                return;
            case 15:
                UMNativeCore.setStrictEyeMovement(dVar2.eji);
                return;
            default:
                return;
        }
    }
}
