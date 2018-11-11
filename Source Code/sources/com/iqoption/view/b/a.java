package com.iqoption.view.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLTextureView */
public class a extends TextureView implements SurfaceTextureListener, OnLayoutChangeListener {
    private static final j dGf = new j();
    private final WeakReference<a> bdq;
    private int bdx;
    private int bdy;
    private boolean bdz;
    private i dGg;
    private m dGh;
    private e dGi;
    private f dGj;
    private g dGk;
    private k dGl;
    private boolean mDetached;

    /* compiled from: GLTextureView */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView */
    public interface g {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLTextureView */
    private static class h {
        EGL10 bdK;
        EGLDisplay bdL;
        EGLSurface bdM;
        EGLConfig bdN;
        EGLContext bdO;
        private WeakReference<a> dER;

        public h(WeakReference<a> weakReference) {
            this.dER = weakReference;
        }

        public void start() {
            this.bdK = (EGL10) EGLContext.getEGL();
            this.bdL = this.bdK.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bdL == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (this.bdK.eglInitialize(this.bdL, new int[2])) {
                a aVar = (a) this.dER.get();
                if (aVar == null) {
                    this.bdN = null;
                    this.bdO = null;
                } else {
                    this.bdN = aVar.dGi.chooseConfig(this.bdK, this.bdL);
                    this.bdO = aVar.dGj.createContext(this.bdK, this.bdL, this.bdN);
                }
                if (this.bdO == null || this.bdO == EGL10.EGL_NO_CONTEXT) {
                    this.bdO = null;
                    gU("createContext");
                }
                this.bdM = null;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }

        public boolean Zn() {
            if (this.bdK == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.bdL == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.bdN == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                Zr();
                a aVar = (a) this.dER.get();
                if (aVar != null) {
                    this.bdM = aVar.dGk.createWindowSurface(this.bdK, this.bdL, this.bdN, aVar.getSurfaceTexture());
                } else {
                    this.bdM = null;
                }
                if (this.bdM == null || this.bdM == EGL10.EGL_NO_SURFACE) {
                    if (this.bdK.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.bdK.eglMakeCurrent(this.bdL, this.bdM, this.bdM, this.bdO)) {
                    return true;
                } else {
                    a("EGLHelper", "eglMakeCurrent", this.bdK.eglGetError());
                    return false;
                }
            }
        }

        GL Zo() {
            GL gl = this.bdO.getGL();
            a aVar = (a) this.dER.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.dGl != null) {
                gl = aVar.dGl.wrap(gl);
            }
            if ((aVar.bdx & 3) == 0) {
                return gl;
            }
            int i = 0;
            Writer writer = null;
            if ((aVar.bdx & 1) != 0) {
                i = 1;
            }
            if ((aVar.bdx & 2) != 0) {
                writer = new l();
            }
            return GLDebugHelper.wrap(gl, i, writer);
        }

        public int Zp() {
            return !this.bdK.eglSwapBuffers(this.bdL, this.bdM) ? this.bdK.eglGetError() : 12288;
        }

        public void Zq() {
            Zr();
        }

        private void Zr() {
            if (this.bdM != null && this.bdM != EGL10.EGL_NO_SURFACE) {
                this.bdK.eglMakeCurrent(this.bdL, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = (a) this.dER.get();
                if (aVar != null) {
                    aVar.dGk.destroySurface(this.bdK, this.bdL, this.bdM);
                }
                this.bdM = null;
            }
        }

        public void finish() {
            if (this.bdO != null) {
                a aVar = (a) this.dER.get();
                if (aVar != null) {
                    aVar.dGj.destroyContext(this.bdK, this.bdL, this.bdO);
                }
                this.bdO = null;
            }
            if (this.bdL != null) {
                this.bdK.eglTerminate(this.bdL);
                this.bdL = null;
            }
        }

        private void gU(String str) {
            G(str, this.bdK.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" failed: ");
            stringBuilder.append(i);
            return stringBuilder.toString();
        }
    }

    /* compiled from: GLTextureView */
    static class i extends Thread {
        private boolean bdP;
        private boolean bdQ;
        private boolean bdR;
        private boolean bdS;
        private boolean bdT;
        private boolean bdU;
        private boolean bdV;
        private boolean bdW;
        private boolean bdX;
        private int bdY = 1;
        private boolean bdZ = true;
        private boolean bea;
        private ArrayList<Runnable> beb = new ArrayList();
        private boolean bec = true;
        private WeakReference<a> dER;
        private boolean dGn;
        private h dGo;
        private int mHeight = 0;
        private boolean mPaused;
        private int mWidth = 0;

        i(WeakReference<a> weakReference) {
            this.dER = weakReference;
        }

        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GLThread ");
            stringBuilder.append(getId());
            setName(stringBuilder.toString());
            try {
                Zu();
            } catch (InterruptedException unused) {
                a.dGf.a(this);
            } catch (Throwable th) {
                a.dGf.a(this);
            }
        }

        private void Zs() {
            if (this.bdW) {
                this.bdW = false;
                this.dGo.Zq();
            }
        }

        private void Zt() {
            if (this.bdV) {
                this.dGo.finish();
                this.bdV = false;
                a.dGf.c(this);
            }
        }

        /* JADX WARNING: Missing block: B:95:0x0155, code:
            if (r10 == null) goto L_0x015e;
     */
        /* JADX WARNING: Missing block: B:97:?, code:
            r10.run();
     */
        /* JADX WARNING: Missing block: B:98:0x015e, code:
            if (r12 == null) goto L_0x0197;
     */
        /* JADX WARNING: Missing block: B:100:0x0166, code:
            if (r1.dGo.Zn() == false) goto L_0x017e;
     */
        /* JADX WARNING: Missing block: B:101:0x0168, code:
            r2 = com.iqoption.view.b.a.aJc();
     */
        /* JADX WARNING: Missing block: B:102:0x016c, code:
            monitor-enter(r2);
     */
        /* JADX WARNING: Missing block: B:105:?, code:
            r1.dGn = true;
            com.iqoption.view.b.a.aJc().notifyAll();
     */
        /* JADX WARNING: Missing block: B:106:0x0177, code:
            monitor-exit(r2);
     */
        /* JADX WARNING: Missing block: B:107:0x0178, code:
            r12 = null;
     */
        /* JADX WARNING: Missing block: B:113:0x017e, code:
            r2 = com.iqoption.view.b.a.aJc();
     */
        /* JADX WARNING: Missing block: B:114:0x0182, code:
            monitor-enter(r2);
     */
        /* JADX WARNING: Missing block: B:117:?, code:
            r1.dGn = true;
            r1.bdT = true;
            com.iqoption.view.b.a.aJc().notifyAll();
     */
        /* JADX WARNING: Missing block: B:118:0x018f, code:
            monitor-exit(r2);
     */
        /* JADX WARNING: Missing block: B:125:0x0197, code:
            if (r13 == null) goto L_0x01aa;
     */
        /* JADX WARNING: Missing block: B:126:0x0199, code:
            r2 = (javax.microedition.khronos.opengles.GL10) r1.dGo.Zo();
            com.iqoption.view.b.a.aJc().a(r2);
            r7 = r2;
            r13 = null;
     */
        /* JADX WARNING: Missing block: B:127:0x01aa, code:
            if (r11 == null) goto L_0x01c2;
     */
        /* JADX WARNING: Missing block: B:128:0x01ac, code:
            r2 = (com.iqoption.view.b.a) r1.dER.get();
     */
        /* JADX WARNING: Missing block: B:129:0x01b4, code:
            if (r2 == null) goto L_0x01c1;
     */
        /* JADX WARNING: Missing block: B:130:0x01b6, code:
            com.iqoption.view.b.a.h(r2).onSurfaceCreated(r7, r1.dGo.bdN);
     */
        /* JADX WARNING: Missing block: B:131:0x01c1, code:
            r11 = null;
     */
        /* JADX WARNING: Missing block: B:132:0x01c2, code:
            if (r14 == null) goto L_0x01d6;
     */
        /* JADX WARNING: Missing block: B:133:0x01c4, code:
            r2 = (com.iqoption.view.b.a) r1.dER.get();
     */
        /* JADX WARNING: Missing block: B:134:0x01cc, code:
            if (r2 == null) goto L_0x01d5;
     */
        /* JADX WARNING: Missing block: B:135:0x01ce, code:
            com.iqoption.view.b.a.h(r2).onSurfaceChanged(r7, r8, r9);
     */
        /* JADX WARNING: Missing block: B:136:0x01d5, code:
            r14 = null;
     */
        /* JADX WARNING: Missing block: B:137:0x01d6, code:
            r2 = (com.iqoption.view.b.a) r1.dER.get();
     */
        /* JADX WARNING: Missing block: B:138:0x01de, code:
            if (r2 == null) goto L_0x01e7;
     */
        /* JADX WARNING: Missing block: B:139:0x01e0, code:
            com.iqoption.view.b.a.h(r2).onDrawFrame(r7);
     */
        /* JADX WARNING: Missing block: B:140:0x01e7, code:
            r2 = r1.dGo.Zp();
     */
        /* JADX WARNING: Missing block: B:141:0x01ef, code:
            if (r2 == 12288) goto L_0x0218;
     */
        /* JADX WARNING: Missing block: B:143:0x01f3, code:
            if (r2 == 12302) goto L_0x0213;
     */
        /* JADX WARNING: Missing block: B:144:0x01f5, code:
            r17 = r4;
            com.iqoption.view.b.a.h.a("GLThread", "eglSwapBuffers", r2);
            r2 = com.iqoption.view.b.a.aJc();
     */
        /* JADX WARNING: Missing block: B:145:0x0202, code:
            monitor-enter(r2);
     */
        /* JADX WARNING: Missing block: B:148:?, code:
            r1.bdT = true;
            com.iqoption.view.b.a.aJc().notifyAll();
     */
        /* JADX WARNING: Missing block: B:149:0x020d, code:
            monitor-exit(r2);
     */
        /* JADX WARNING: Missing block: B:155:0x0213, code:
            r17 = r4;
            r6 = 1;
     */
        /* JADX WARNING: Missing block: B:156:0x0218, code:
            r17 = r4;
     */
        /* JADX WARNING: Missing block: B:157:0x021b, code:
            if (r15 == null) goto L_0x0220;
     */
        /* JADX WARNING: Missing block: B:158:0x021d, code:
            r4 = 1;
     */
        /* JADX WARNING: Missing block: B:159:0x0220, code:
            r4 = r17;
     */
        private void Zu() {
            /*
            r18 = this;
            r1 = r18;
            r2 = new com.iqoption.view.b.a$h;
            r3 = r1.dER;
            r2.<init>(r3);
            r1.dGo = r2;
            r2 = 0;
            r1.bdV = r2;
            r1.bdW = r2;
            r4 = 0;
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r8 = 0;
            r9 = 0;
            r10 = 0;
            r11 = 0;
            r12 = 0;
            r13 = 0;
            r14 = 0;
            r15 = 0;
        L_0x001c:
            r16 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0233 }
            monitor-enter(r16);	 Catch:{ all -> 0x0233 }
        L_0x0021:
            r3 = r1.bdP;	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x0037;
        L_0x0025:
            monitor-exit(r16);	 Catch:{ all -> 0x022f }
            r2 = com.iqoption.view.b.a.dGf;
            monitor-enter(r2);
            r18.Zs();	 Catch:{ all -> 0x0033 }
            r18.Zt();	 Catch:{ all -> 0x0033 }
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            return;
        L_0x0033:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            throw r3;
        L_0x0037:
            r3 = r1.beb;	 Catch:{ all -> 0x022f }
            r3 = r3.isEmpty();	 Catch:{ all -> 0x022f }
            if (r3 != 0) goto L_0x004c;
        L_0x003f:
            r3 = r1.beb;	 Catch:{ all -> 0x022f }
            r10 = 0;
            r3 = r3.remove(r10);	 Catch:{ all -> 0x022f }
            r3 = (java.lang.Runnable) r3;	 Catch:{ all -> 0x022f }
            r10 = r3;
            r3 = 0;
            goto L_0x0154;
        L_0x004c:
            r3 = r1.mPaused;	 Catch:{ all -> 0x022f }
            r2 = r1.bdR;	 Catch:{ all -> 0x022f }
            if (r3 == r2) goto L_0x0060;
        L_0x0052:
            r2 = r1.bdR;	 Catch:{ all -> 0x022f }
            r3 = r1.bdR;	 Catch:{ all -> 0x022f }
            r1.mPaused = r3;	 Catch:{ all -> 0x022f }
            r3 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r3.notifyAll();	 Catch:{ all -> 0x022f }
            goto L_0x0061;
        L_0x0060:
            r2 = 0;
        L_0x0061:
            r3 = r1.bdX;	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x006f;
        L_0x0065:
            r18.Zs();	 Catch:{ all -> 0x022f }
            r18.Zt();	 Catch:{ all -> 0x022f }
            r3 = 0;
            r1.bdX = r3;	 Catch:{ all -> 0x022f }
            r5 = 1;
        L_0x006f:
            if (r6 == 0) goto L_0x0078;
        L_0x0071:
            r18.Zs();	 Catch:{ all -> 0x022f }
            r18.Zt();	 Catch:{ all -> 0x022f }
            r6 = 0;
        L_0x0078:
            if (r2 == 0) goto L_0x0081;
        L_0x007a:
            r3 = r1.bdW;	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x0081;
        L_0x007e:
            r18.Zs();	 Catch:{ all -> 0x022f }
        L_0x0081:
            if (r2 == 0) goto L_0x00a6;
        L_0x0083:
            r3 = r1.bdV;	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x00a6;
        L_0x0087:
            r3 = r1.dER;	 Catch:{ all -> 0x022f }
            r3 = r3.get();	 Catch:{ all -> 0x022f }
            r3 = (com.iqoption.view.b.a) r3;	 Catch:{ all -> 0x022f }
            if (r3 != 0) goto L_0x0093;
        L_0x0091:
            r3 = 0;
            goto L_0x0097;
        L_0x0093:
            r3 = r3.bdz;	 Catch:{ all -> 0x022f }
        L_0x0097:
            if (r3 == 0) goto L_0x00a3;
        L_0x0099:
            r3 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r3 = r3.ZB();	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x00a6;
        L_0x00a3:
            r18.Zt();	 Catch:{ all -> 0x022f }
        L_0x00a6:
            if (r2 == 0) goto L_0x00b7;
        L_0x00a8:
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2 = r2.ZC();	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x00b7;
        L_0x00b2:
            r2 = r1.dGo;	 Catch:{ all -> 0x022f }
            r2.finish();	 Catch:{ all -> 0x022f }
        L_0x00b7:
            r2 = r1.bdS;	 Catch:{ all -> 0x022f }
            if (r2 != 0) goto L_0x00d3;
        L_0x00bb:
            r2 = r1.bdU;	 Catch:{ all -> 0x022f }
            if (r2 != 0) goto L_0x00d3;
        L_0x00bf:
            r2 = r1.bdW;	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x00c6;
        L_0x00c3:
            r18.Zs();	 Catch:{ all -> 0x022f }
        L_0x00c6:
            r2 = 1;
            r1.bdU = r2;	 Catch:{ all -> 0x022f }
            r2 = 0;
            r1.bdT = r2;	 Catch:{ all -> 0x022f }
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2.notifyAll();	 Catch:{ all -> 0x022f }
        L_0x00d3:
            r2 = r1.bdS;	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x00e5;
        L_0x00d7:
            r2 = r1.bdU;	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x00e5;
        L_0x00db:
            r2 = 0;
            r1.bdU = r2;	 Catch:{ all -> 0x022f }
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2.notifyAll();	 Catch:{ all -> 0x022f }
        L_0x00e5:
            if (r4 == 0) goto L_0x00f3;
        L_0x00e7:
            r2 = 1;
            r1.bea = r2;	 Catch:{ all -> 0x022f }
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2.notifyAll();	 Catch:{ all -> 0x022f }
            r4 = 0;
            r15 = 0;
        L_0x00f3:
            r2 = r18.Zw();	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x0225;
        L_0x00f9:
            r2 = r1.bdV;	 Catch:{ all -> 0x022f }
            if (r2 != 0) goto L_0x0126;
        L_0x00fd:
            if (r5 == 0) goto L_0x0101;
        L_0x00ff:
            r5 = 0;
            goto L_0x0126;
        L_0x0101:
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2 = r2.b(r1);	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x0126;
        L_0x010b:
            r2 = r1.dGo;	 Catch:{ RuntimeException -> 0x011c }
            r2.start();	 Catch:{ RuntimeException -> 0x011c }
            r2 = 1;
            r1.bdV = r2;	 Catch:{ all -> 0x022f }
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2.notifyAll();	 Catch:{ all -> 0x022f }
            r11 = 1;
            goto L_0x0126;
        L_0x011c:
            r0 = move-exception;
            r2 = r0;
            r3 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r3.c(r1);	 Catch:{ all -> 0x022f }
            throw r2;	 Catch:{ all -> 0x022f }
        L_0x0126:
            r2 = r1.bdV;	 Catch:{ all -> 0x022f }
            if (r2 == 0) goto L_0x0135;
        L_0x012a:
            r2 = r1.bdW;	 Catch:{ all -> 0x022f }
            if (r2 != 0) goto L_0x0135;
        L_0x012e:
            r2 = 1;
            r1.bdW = r2;	 Catch:{ all -> 0x022f }
            r2 = 1;
            r13 = 1;
            r14 = 1;
            goto L_0x0136;
        L_0x0135:
            r2 = r12;
        L_0x0136:
            r3 = r1.bdW;	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x0224;
        L_0x013a:
            r3 = r1.bec;	 Catch:{ all -> 0x022f }
            if (r3 == 0) goto L_0x0149;
        L_0x013e:
            r8 = r1.mWidth;	 Catch:{ all -> 0x022f }
            r9 = r1.mHeight;	 Catch:{ all -> 0x022f }
            r3 = 0;
            r1.bec = r3;	 Catch:{ all -> 0x022f }
            r2 = 1;
            r14 = 1;
            r15 = 1;
            goto L_0x014a;
        L_0x0149:
            r3 = 0;
        L_0x014a:
            r1.bdZ = r3;	 Catch:{ all -> 0x022f }
            r12 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r12.notifyAll();	 Catch:{ all -> 0x022f }
            r12 = r2;
        L_0x0154:
            monitor-exit(r16);	 Catch:{ all -> 0x022f }
            if (r10 == 0) goto L_0x015e;
        L_0x0157:
            r10.run();	 Catch:{ all -> 0x0233 }
            r2 = 0;
            r10 = 0;
            goto L_0x001c;
        L_0x015e:
            if (r12 == 0) goto L_0x0197;
        L_0x0160:
            r2 = r1.dGo;	 Catch:{ all -> 0x0233 }
            r2 = r2.Zn();	 Catch:{ all -> 0x0233 }
            if (r2 == 0) goto L_0x017e;
        L_0x0168:
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0233 }
            monitor-enter(r2);	 Catch:{ all -> 0x0233 }
            r12 = 1;
            r1.dGn = r12;	 Catch:{ all -> 0x017a }
            r12 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x017a }
            r12.notifyAll();	 Catch:{ all -> 0x017a }
            monitor-exit(r2);	 Catch:{ all -> 0x017a }
            r12 = 0;
            goto L_0x0197;
        L_0x017a:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x017a }
            throw r3;	 Catch:{ all -> 0x0233 }
        L_0x017e:
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0233 }
            monitor-enter(r2);	 Catch:{ all -> 0x0233 }
            r3 = 1;
            r1.dGn = r3;	 Catch:{ all -> 0x0193 }
            r1.bdT = r3;	 Catch:{ all -> 0x0193 }
            r3 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0193 }
            r3.notifyAll();	 Catch:{ all -> 0x0193 }
            monitor-exit(r2);	 Catch:{ all -> 0x0193 }
        L_0x0190:
            r2 = 0;
            goto L_0x001c;
        L_0x0193:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x0193 }
            throw r3;	 Catch:{ all -> 0x0233 }
        L_0x0197:
            if (r13 == 0) goto L_0x01aa;
        L_0x0199:
            r2 = r1.dGo;	 Catch:{ all -> 0x0233 }
            r2 = r2.Zo();	 Catch:{ all -> 0x0233 }
            r2 = (javax.microedition.khronos.opengles.GL10) r2;	 Catch:{ all -> 0x0233 }
            r3 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0233 }
            r3.a(r2);	 Catch:{ all -> 0x0233 }
            r7 = r2;
            r13 = 0;
        L_0x01aa:
            if (r11 == 0) goto L_0x01c2;
        L_0x01ac:
            r2 = r1.dER;	 Catch:{ all -> 0x0233 }
            r2 = r2.get();	 Catch:{ all -> 0x0233 }
            r2 = (com.iqoption.view.b.a) r2;	 Catch:{ all -> 0x0233 }
            if (r2 == 0) goto L_0x01c1;
        L_0x01b6:
            r2 = r2.dGh;	 Catch:{ all -> 0x0233 }
            r3 = r1.dGo;	 Catch:{ all -> 0x0233 }
            r3 = r3.bdN;	 Catch:{ all -> 0x0233 }
            r2.onSurfaceCreated(r7, r3);	 Catch:{ all -> 0x0233 }
        L_0x01c1:
            r11 = 0;
        L_0x01c2:
            if (r14 == 0) goto L_0x01d6;
        L_0x01c4:
            r2 = r1.dER;	 Catch:{ all -> 0x0233 }
            r2 = r2.get();	 Catch:{ all -> 0x0233 }
            r2 = (com.iqoption.view.b.a) r2;	 Catch:{ all -> 0x0233 }
            if (r2 == 0) goto L_0x01d5;
        L_0x01ce:
            r2 = r2.dGh;	 Catch:{ all -> 0x0233 }
            r2.onSurfaceChanged(r7, r8, r9);	 Catch:{ all -> 0x0233 }
        L_0x01d5:
            r14 = 0;
        L_0x01d6:
            r2 = r1.dER;	 Catch:{ all -> 0x0233 }
            r2 = r2.get();	 Catch:{ all -> 0x0233 }
            r2 = (com.iqoption.view.b.a) r2;	 Catch:{ all -> 0x0233 }
            if (r2 == 0) goto L_0x01e7;
        L_0x01e0:
            r2 = r2.dGh;	 Catch:{ all -> 0x0233 }
            r2.onDrawFrame(r7);	 Catch:{ all -> 0x0233 }
        L_0x01e7:
            r2 = r1.dGo;	 Catch:{ all -> 0x0233 }
            r2 = r2.Zp();	 Catch:{ all -> 0x0233 }
            r3 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;
            if (r2 == r3) goto L_0x0218;
        L_0x01f1:
            r3 = 12302; // 0x300e float:1.7239E-41 double:6.078E-320;
            if (r2 == r3) goto L_0x0213;
        L_0x01f5:
            r3 = "GLThread";
            r17 = r4;
            r4 = "eglSwapBuffers";
            com.iqoption.view.b.a.h.a(r3, r4, r2);	 Catch:{ all -> 0x0233 }
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0233 }
            monitor-enter(r2);	 Catch:{ all -> 0x0233 }
            r3 = 1;
            r1.bdT = r3;	 Catch:{ all -> 0x020f }
            r4 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x020f }
            r4.notifyAll();	 Catch:{ all -> 0x020f }
            monitor-exit(r2);	 Catch:{ all -> 0x020f }
            goto L_0x021b;
        L_0x020f:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x020f }
            throw r3;	 Catch:{ all -> 0x0233 }
        L_0x0213:
            r17 = r4;
            r3 = 1;
            r6 = 1;
            goto L_0x021b;
        L_0x0218:
            r17 = r4;
            r3 = 1;
        L_0x021b:
            if (r15 == 0) goto L_0x0220;
        L_0x021d:
            r4 = 1;
            goto L_0x0190;
        L_0x0220:
            r4 = r17;
            goto L_0x0190;
        L_0x0224:
            r12 = r2;
        L_0x0225:
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x022f }
            r2.wait();	 Catch:{ all -> 0x022f }
            r2 = 0;
            goto L_0x0021;
        L_0x022f:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r16);	 Catch:{ all -> 0x022f }
            throw r2;	 Catch:{ all -> 0x0233 }
        L_0x0233:
            r0 = move-exception;
            r2 = r0;
            r3 = com.iqoption.view.b.a.dGf;
            monitor-enter(r3);
            r18.Zs();	 Catch:{ all -> 0x0242 }
            r18.Zt();	 Catch:{ all -> 0x0242 }
            monitor-exit(r3);	 Catch:{ all -> 0x0242 }
            throw r2;
        L_0x0242:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r3);	 Catch:{ all -> 0x0242 }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.b.a.i.Zu():void");
        }

        public boolean Zv() {
            return this.bdV && this.bdW && Zw();
        }

        private boolean Zw() {
            return !this.mPaused && this.bdS && !this.bdT && this.mWidth > 0 && this.mHeight > 0 && (this.bdZ || this.bdY == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.dGf) {
                this.bdY = i;
                a.dGf.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.dGf) {
                i = this.bdY;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.dGf) {
                this.bdZ = true;
                a.dGf.notifyAll();
            }
        }

        /* JADX WARNING: Missing block: B:15:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void Zx() {
            /*
            r2 = this;
            r0 = com.iqoption.view.b.a.dGf;
            monitor-enter(r0);
            r1 = 1;
            r2.bdS = r1;	 Catch:{ all -> 0x0030 }
            r1 = 0;
            r2.dGn = r1;	 Catch:{ all -> 0x0030 }
            r1 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0030 }
            r1.notifyAll();	 Catch:{ all -> 0x0030 }
        L_0x0012:
            r1 = r2.bdU;	 Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e;
        L_0x0016:
            r1 = r2.dGn;	 Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e;
        L_0x001a:
            r1 = r2.bdQ;	 Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e;
        L_0x001e:
            r1 = com.iqoption.view.b.a.dGf;	 Catch:{ InterruptedException -> 0x0026 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0026 }
            goto L_0x0012;
        L_0x0026:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0030 }
            r1.interrupt();	 Catch:{ all -> 0x0030 }
            goto L_0x0012;
        L_0x002e:
            monitor-exit(r0);	 Catch:{ all -> 0x0030 }
            return;
        L_0x0030:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0030 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.b.a.i.Zx():void");
        }

        /* JADX WARNING: Missing block: B:13:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void Zy() {
            /*
            r2 = this;
            r0 = com.iqoption.view.b.a.dGf;
            monitor-enter(r0);
            r1 = 0;
            r2.bdS = r1;	 Catch:{ all -> 0x0029 }
            r1 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0029 }
            r1.notifyAll();	 Catch:{ all -> 0x0029 }
        L_0x000f:
            r1 = r2.bdU;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027;
        L_0x0013:
            r1 = r2.bdQ;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027;
        L_0x0017:
            r1 = com.iqoption.view.b.a.dGf;	 Catch:{ InterruptedException -> 0x001f }
            r1.wait();	 Catch:{ InterruptedException -> 0x001f }
            goto L_0x000f;
        L_0x001f:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0029 }
            r1.interrupt();	 Catch:{ all -> 0x0029 }
            goto L_0x000f;
        L_0x0027:
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            return;
        L_0x0029:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.b.a.i.Zy():void");
        }

        /* JADX WARNING: Missing block: B:16:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void aj(int r2, int r3) {
            /*
            r1 = this;
            r0 = com.iqoption.view.b.a.dGf;
            monitor-enter(r0);
            r1.mWidth = r2;	 Catch:{ all -> 0x003c }
            r1.mHeight = r3;	 Catch:{ all -> 0x003c }
            r2 = 1;
            r1.bec = r2;	 Catch:{ all -> 0x003c }
            r1.bdZ = r2;	 Catch:{ all -> 0x003c }
            r2 = 0;
            r1.bea = r2;	 Catch:{ all -> 0x003c }
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x003c }
            r2.notifyAll();	 Catch:{ all -> 0x003c }
        L_0x0018:
            r2 = r1.bdQ;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x001c:
            r2 = r1.mPaused;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x0020:
            r2 = r1.bea;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x0024:
            r2 = r1.Zv();	 Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x003a;
        L_0x002a:
            r2 = com.iqoption.view.b.a.dGf;	 Catch:{ InterruptedException -> 0x0032 }
            r2.wait();	 Catch:{ InterruptedException -> 0x0032 }
            goto L_0x0018;
        L_0x0032:
            r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x003c }
            r2.interrupt();	 Catch:{ all -> 0x003c }
            goto L_0x0018;
        L_0x003a:
            monitor-exit(r0);	 Catch:{ all -> 0x003c }
            return;
        L_0x003c:
            r2 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x003c }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.b.a.i.aj(int, int):void");
        }

        /* JADX WARNING: Missing block: B:11:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void Zz() {
            /*
            r2 = this;
            r0 = com.iqoption.view.b.a.dGf;
            monitor-enter(r0);
            r1 = 1;
            r2.bdP = r1;	 Catch:{ all -> 0x0025 }
            r1 = com.iqoption.view.b.a.dGf;	 Catch:{ all -> 0x0025 }
            r1.notifyAll();	 Catch:{ all -> 0x0025 }
        L_0x000f:
            r1 = r2.bdQ;	 Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0023;
        L_0x0013:
            r1 = com.iqoption.view.b.a.dGf;	 Catch:{ InterruptedException -> 0x001b }
            r1.wait();	 Catch:{ InterruptedException -> 0x001b }
            goto L_0x000f;
        L_0x001b:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0025 }
            r1.interrupt();	 Catch:{ all -> 0x0025 }
            goto L_0x000f;
        L_0x0023:
            monitor-exit(r0);	 Catch:{ all -> 0x0025 }
            return;
        L_0x0025:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0025 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.b.a.i.Zz():void");
        }

        public void ZA() {
            this.bdX = true;
            a.dGf.notifyAll();
        }
    }

    /* compiled from: GLTextureView */
    private static class j {
        private static String TAG = "GLThreadManager";
        private boolean bee;
        private int bef;
        private boolean beh;
        private boolean bei;
        private boolean bej;
        private i dGp;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bdQ = true;
            if (this.dGp == iVar) {
                this.dGp = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.dGp == iVar || this.dGp == null) {
                this.dGp = iVar;
                notifyAll();
                return true;
            }
            ZD();
            if (this.bei) {
                return true;
            }
            if (this.dGp != null) {
                this.dGp.ZA();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.dGp == iVar) {
                this.dGp = null;
            }
            notifyAll();
        }

        public synchronized boolean ZB() {
            return this.bej;
        }

        public synchronized boolean ZC() {
            ZD();
            return this.bei ^ 1;
        }

        public synchronized void a(GL10 gl10) {
            if (!this.beh) {
                ZD();
                String glGetString = gl10.glGetString(7937);
                if (this.bef < 131072) {
                    this.bei = glGetString.startsWith("Q3Dimension MSM7500 ") ^ true;
                    notifyAll();
                }
                this.bej = this.bei ^ true;
                this.beh = true;
            }
        }

        private void ZD() {
            if (!this.bee) {
                this.bee = true;
            }
        }
    }

    /* compiled from: GLTextureView */
    public interface k {
        GL wrap(GL gl);
    }

    /* compiled from: GLTextureView */
    static class l extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        l() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v("GLTextureView2", this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
            }
        }
    }

    /* compiled from: GLTextureView */
    public interface m {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* compiled from: GLTextureView */
    private abstract class a implements e {
        protected int[] bdA;

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bdA = l(iArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.bdA, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.bdA, eGLConfigArr, i, iArr)) {
                    EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] l(int[] iArr) {
            if (a.this.bdy != 2 && a.this.bdy != 3) {
                return iArr;
            }
            int length = iArr.length;
            Object obj = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, obj, 0, i);
            obj[i] = 12352;
            if (a.this.bdy == 2) {
                obj[length] = 4;
            } else {
                obj[length] = 64;
            }
            obj[length + 1] = 12344;
            return obj;
        }
    }

    /* compiled from: GLTextureView */
    private class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, a.this.bdy, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bdy == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("display:");
                stringBuilder.append(eGLDisplay);
                stringBuilder.append(" context: ");
                stringBuilder.append(eGLContext);
                Log.e("DefaultContextFactory", stringBuilder.toString());
                h.G("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: GLTextureView */
    private static class d implements g {
        private d() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (Throwable e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLTextureView */
    private class b extends a {
        private int[] bdC = new int[1];
        protected int bdD;
        protected int bdE;
        protected int bdF;
        protected int bdG;
        protected int bdH;
        protected int bdI;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.bdD = i;
            this.bdE = i2;
            this.bdF = i3;
            this.bdG = i4;
            this.bdH = i5;
            this.bdI = i6;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int a = a(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int a2 = a(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (a >= this.bdH && a2 >= this.bdI) {
                    egl102 = egl10;
                    eGLDisplay2 = eGLDisplay;
                    eGLConfig2 = eGLConfig;
                    a = a(egl102, eGLDisplay2, eGLConfig2, 12324, 0);
                    int a3 = a(egl102, eGLDisplay2, eGLConfig2, 12323, 0);
                    int a4 = a(egl102, eGLDisplay2, eGLConfig2, 12322, 0);
                    a2 = a(egl102, eGLDisplay2, eGLConfig2, 12321, 0);
                    if (a == this.bdD && a3 == this.bdE && a4 == this.bdF && a2 == this.bdG) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.bdC) ? this.bdC[0] : i2;
        }
    }

    /* compiled from: GLTextureView */
    private class n extends b {
        public n(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    protected void finalize() {
        try {
            if (this.dGg != null) {
                this.dGg.Zz();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.dGl = kVar;
    }

    public void setDebugFlags(int i) {
        this.bdx = i;
    }

    public int getDebugFlags() {
        return this.bdx;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bdz = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bdz;
    }

    public void setRenderer(m mVar) {
        Zl();
        if (this.dGi == null) {
            this.dGi = new n(true);
        }
        if (this.dGj == null) {
            this.dGj = new c();
        }
        if (this.dGk == null) {
            this.dGk = new d();
        }
        this.dGh = mVar;
        this.dGg = new i(this.bdq);
        this.dGg.start();
    }

    public void setEGLContextFactory(f fVar) {
        Zl();
        this.dGj = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Zl();
        this.dGk = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Zl();
        this.dGi = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i) {
        Zl();
        this.bdy = i;
    }

    public void setRenderMode(int i) {
        this.dGg.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.dGg.getRenderMode();
    }

    public void requestRender() {
        this.dGg.requestRender();
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.dGg.Zx();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture);
        a(surfaceTexture, 0, i, i2);
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.dGg.Zy();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b(surfaceTexture);
        return true;
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.dGg.aj(i2, i3);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture, 0, i, i2);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        a(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.dGh != null) {
            int renderMode = this.dGg != null ? this.dGg.getRenderMode() : 1;
            this.dGg = new i(this.bdq);
            if (renderMode != 1) {
                this.dGg.setRenderMode(renderMode);
            }
            this.dGg.start();
        }
        this.mDetached = false;
    }

    protected void onDetachedFromWindow() {
        if (this.dGg != null) {
            this.dGg.Zz();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    private void Zl() {
        if (this.dGg != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
