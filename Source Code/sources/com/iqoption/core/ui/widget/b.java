package com.iqoption.core.ui.widget;

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
public class b extends TextureView implements SurfaceTextureListener, OnLayoutChangeListener {
    private static final j bdp = new j();
    private final WeakReference<b> bdq;
    private i bdr;
    private m bds;
    private e bdt;
    private f bdu;
    private g bdv;
    private k bdw;
    private int bdx;
    private int bdy;
    private boolean bdz;
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
        private WeakReference<b> bdJ;
        EGL10 bdK;
        EGLDisplay bdL;
        EGLSurface bdM;
        EGLConfig bdN;
        EGLContext bdO;

        public h(WeakReference<b> weakReference) {
            this.bdJ = weakReference;
        }

        public void start() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("start() tid=");
            stringBuilder.append(Thread.currentThread().getId());
            Log.w("EglHelper", stringBuilder.toString());
            this.bdK = (EGL10) EGLContext.getEGL();
            this.bdL = this.bdK.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bdL == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (this.bdK.eglInitialize(this.bdL, new int[2])) {
                b bVar = (b) this.bdJ.get();
                if (bVar == null) {
                    this.bdN = null;
                    this.bdO = null;
                } else {
                    this.bdN = bVar.bdt.chooseConfig(this.bdK, this.bdL);
                    this.bdO = bVar.bdu.createContext(this.bdK, this.bdL, this.bdN);
                }
                if (this.bdO == null || this.bdO == EGL10.EGL_NO_CONTEXT) {
                    this.bdO = null;
                    gU("createContext");
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("createContext ");
                stringBuilder2.append(this.bdO);
                stringBuilder2.append(" tid=");
                stringBuilder2.append(Thread.currentThread().getId());
                Log.w("EglHelper", stringBuilder2.toString());
                this.bdM = null;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }

        public boolean Zn() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("createSurface()  tid=");
            stringBuilder.append(Thread.currentThread().getId());
            Log.w("EglHelper", stringBuilder.toString());
            if (this.bdK == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.bdL == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.bdN == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                Zr();
                b bVar = (b) this.bdJ.get();
                if (bVar != null) {
                    this.bdM = bVar.bdv.createWindowSurface(this.bdK, this.bdL, this.bdN, bVar.getSurfaceTexture());
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
            b bVar = (b) this.bdJ.get();
            if (bVar == null) {
                return gl;
            }
            if (bVar.bdw != null) {
                gl = bVar.bdw.wrap(gl);
            }
            if ((bVar.bdx & 3) == 0) {
                return gl;
            }
            int i = 0;
            Writer writer = null;
            if ((bVar.bdx & 1) != 0) {
                i = 1;
            }
            if ((bVar.bdx & 2) != 0) {
                writer = new l();
            }
            return GLDebugHelper.wrap(gl, i, writer);
        }

        public int Zp() {
            return !this.bdK.eglSwapBuffers(this.bdL, this.bdM) ? this.bdK.eglGetError() : 12288;
        }

        public void Zq() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("destroySurface()  tid=");
            stringBuilder.append(Thread.currentThread().getId());
            Log.w("EglHelper", stringBuilder.toString());
            Zr();
        }

        private void Zr() {
            if (this.bdM != null && this.bdM != EGL10.EGL_NO_SURFACE) {
                this.bdK.eglMakeCurrent(this.bdL, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                b bVar = (b) this.bdJ.get();
                if (bVar != null) {
                    bVar.bdv.destroySurface(this.bdK, this.bdL, this.bdM);
                }
                this.bdM = null;
            }
        }

        public void finish() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("finish() tid=");
            stringBuilder.append(Thread.currentThread().getId());
            Log.w("EglHelper", stringBuilder.toString());
            if (this.bdO != null) {
                b bVar = (b) this.bdJ.get();
                if (bVar != null) {
                    bVar.bdu.destroyContext(this.bdK, this.bdL, this.bdO);
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
            str = H(str, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("throwEglException tid=");
            stringBuilder.append(Thread.currentThread().getId());
            stringBuilder.append(" ");
            stringBuilder.append(str);
            Log.e("EglHelper", stringBuilder.toString());
            throw new RuntimeException(str);
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
        private WeakReference<b> bdJ;
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
        private h bed;
        private int mHeight = 0;
        private boolean mPaused;
        private int mWidth = 0;

        /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
            jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 18, insn: 0x00bb: MOVE  (r2 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:26:0x00bb, method: com.iqoption.core.ui.widget.b.i.Zu():void
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:162)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:133)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.util.ArrayList.forEach(ArrayList.java:1257)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.util.ArrayList.forEach(ArrayList.java:1257)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
            */
        private void Zu() {
            /*
            r24 = this;
            r1 = r24;
            r2 = new com.iqoption.core.ui.widget.b$h;
            r3 = r1.bdJ;
            r2.<init>(r3);
            r1.bed = r2;
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
            r16 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            monitor-enter(r16);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0021:
            r3 = r1.bdP;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0037;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0025:
            monitor-exit(r16);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r2);
            r24.Zs();	 Catch:{ all -> 0x0033 }
            r24.Zt();	 Catch:{ all -> 0x0033 }
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            return;	 Catch:{ all -> 0x0033 }
        L_0x0033:
            r0 = move-exception;	 Catch:{ all -> 0x0033 }
            r3 = r0;	 Catch:{ all -> 0x0033 }
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            throw r3;
        L_0x0037:
            r3 = r1.beb;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.isEmpty();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 != 0) goto L_0x004e;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x003f:
            r3 = r1.beb;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r8 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.remove(r8);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = (java.lang.Runnable) r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r8 = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r20 = r6;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0262;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x004e:
            r3 = r1.mPaused;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = r1.bdR;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == r2) goto L_0x008c;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0054:
            r2 = r1.bdR;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r1.bdR;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.mPaused = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.notifyAll();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r17 = r2;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r18 = r4;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = "mPaused is now ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2.append(r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r1.mPaused;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2.append(r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = " tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2.append(r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r19 = r5;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2.append(r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = r2.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r2);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0092;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x008c:
            r18 = r4;
            r19 = r5;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r17 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0092:
            r2 = r1.bdX;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r2 == 0) goto L_0x00bb;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0096:
            r2 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = "releasing EGL context because asked to tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r2, r3);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r24.Zs();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r24.Zt();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bdX = r2;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x00bd;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00bb:
            r2 = r18;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00bd:
            if (r12 == 0) goto L_0x00c6;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00bf:
            r24.Zs();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r24.Zt();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r12 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00c6:
            if (r17 == 0) goto L_0x00ec;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00c8:
            r3 = r1.bdW;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x00ec;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00cc:
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "releasing EGL surface because paused tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r20 = r6;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r24.Zs();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x00ee;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00ec:
            r20 = r6;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00ee:
            if (r17 == 0) goto L_0x0130;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00f0:
            r3 = r1.bdV;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0130;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00f4:
            r3 = r1.bdJ;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.get();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = (com.iqoption.core.ui.widget.b) r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0106;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x00fe:
            r3 = r3.bdz;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0106;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0104:
            r3 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0107;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0106:
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0107:
            if (r3 == 0) goto L_0x0113;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0109:
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.ZB();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0130;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0113:
            r24.Zt();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "releasing EGL context because paused tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0130:
            if (r17 == 0) goto L_0x015c;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0132:
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.ZC();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x015c;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x013c:
            r3 = r1.bed;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.finish();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "terminating EGL because paused tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x015c:
            r3 = r1.bdS;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 != 0) goto L_0x0192;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0160:
            r3 = r1.bdU;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 != 0) goto L_0x0192;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0164:
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "noticed surfaceView surface lost tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r1.bdW;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0185;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0182:
            r24.Zs();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0185:
            r3 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bdU = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bdT = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.notifyAll();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0192:
            r3 = r1.bdS;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x01be;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0196:
            r3 = r1.bdU;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x01be;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x019a:
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "noticed surfaceView surface acquired tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bdU = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.notifyAll();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01be:
            if (r15 == 0) goto L_0x01e6;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01c0:
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "sending render notification tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bea = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.notifyAll();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r14 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r15 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01e6:
            r3 = r24.Zw();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x037b;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01ec:
            r3 = r1.bdV;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 != 0) goto L_0x0219;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01f0:
            if (r2 == 0) goto L_0x01f4;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01f2:
            r2 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0219;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x01f4:
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.b(r1);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0219;
        L_0x01fe:
            r3 = r1.bed;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.start();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 1;
            r1.bdV = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.notifyAll();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r9 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0219;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x020f:
            r0 = move-exception;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = r0;
            r3 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.c(r1);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            throw r2;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0219:
            r3 = r1.bdV;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0227;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x021d:
            r3 = r1.bdW;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 != 0) goto L_0x0227;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0221:
            r3 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bdW = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r10 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r11 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r13 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0227:
            r3 = r1.bdW;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x037b;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x022b:
            r3 = r1.bec;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r3 == 0) goto L_0x0255;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x022f:
            r5 = r1.mWidth;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r7 = r1.mHeight;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r6 = "noticing that we want render notification tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r6);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r13 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.append(r13);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r4.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r3, r4);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r1.bec = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r10 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r13 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r14 = 1;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0258;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0255:
            r5 = r19;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0258:
            r1.bdZ = r3;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4.notifyAll();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r4 = r2;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0262:
            monitor-exit(r16);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            if (r8 == 0) goto L_0x026e;
        L_0x0265:
            r8.run();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = r20;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = 0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r8 = 0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            goto L_0x001c;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x026e:
            if (r10 == 0) goto L_0x0298;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0270:
            r2 = "GLThread";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = "egl createSurface";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            android.util.Log.w(r2, r6);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r1.bed;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r2.Zn();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            if (r2 != 0) goto L_0x0297;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x027f:
            r2 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            monitor-enter(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = 1;
            r1.bdT = r6;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6.notifyAll();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            monitor-exit(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = r20;
            goto L_0x0378;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0293:
            r0 = move-exception;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = r0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            monitor-exit(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            throw r3;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0297:
            r10 = 0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0298:
            if (r11 == 0) goto L_0x02ac;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x029a:
            r2 = r1.bed;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r2.Zo();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = (javax.microedition.khronos.opengles.GL10) r2;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6.a(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r6 = r2;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r11 = 0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            goto L_0x02ae;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02ac:
            r6 = r20;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02ae:
            if (r9 == 0) goto L_0x02cd;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02b0:
            r2 = "GLThread";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r9 = "onSurfaceCreated";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            android.util.Log.w(r2, r9);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r1.bdJ;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r2.get();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = (com.iqoption.core.ui.widget.b) r2;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            if (r2 == 0) goto L_0x02cc;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02c1:
            r2 = r2.bds;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r9 = r1.bed;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r9 = r9.bdN;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2.onSurfaceCreated(r6, r9);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02cc:
            r9 = 0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02cd:
            if (r13 == 0) goto L_0x0304;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02cf:
            r2 = "GLThread";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13.<init>();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = "onSurfaceChanged(";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13.append(r3);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13.append(r5);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = ", ";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13.append(r3);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13.append(r7);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = ")";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r13.append(r3);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = r13.toString();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            android.util.Log.w(r2, r3);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r1.bdJ;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r2.get();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = (com.iqoption.core.ui.widget.b) r2;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            if (r2 == 0) goto L_0x0303;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x02fc:
            r2 = r2.bds;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2.onSurfaceChanged(r6, r5, r7);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0303:
            r13 = 0;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0304:
            r2 = r1.bdJ;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r2.get();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = (com.iqoption.core.ui.widget.b) r2;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            if (r2 == 0) goto L_0x0315;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x030e:
            r2 = r2.bds;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2.onDrawFrame(r6);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0315:
            r2 = r1.bed;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = r2.Zp();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            if (r2 == r3) goto L_0x0368;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x031f:
            r3 = 12302; // 0x300e float:1.7239E-41 double:6.078E-320;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            if (r2 == r3) goto L_0x0345;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0323:
            r3 = "GLThread";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r21 = r4;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4 = "eglSwapBuffers";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            com.iqoption.core.ui.widget.b.h.a(r3, r4, r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            monitor-enter(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = 1;
            r1.bdT = r3;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4.notifyAll();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            monitor-exit(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r22 = r5;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r23 = r6;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            goto L_0x036f;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0341:
            r0 = move-exception;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            throw r3;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x0345:
            r21 = r4;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r3 = 1;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r2 = "GLThread";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4.<init>();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r12 = "egl context lost tid=";	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4.append(r12);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r22 = r5;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r23 = r6;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r5 = r24.getId();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4.append(r5);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r4 = r4.toString();	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            android.util.Log.i(r2, r4);	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
            r12 = 1;
            goto L_0x036f;
        L_0x0368:
            r21 = r4;
            r22 = r5;
            r23 = r6;
            r3 = 1;
        L_0x036f:
            if (r14 == 0) goto L_0x0372;
        L_0x0371:
            r15 = 1;
        L_0x0372:
            r4 = r21;
            r5 = r22;
            r6 = r23;
        L_0x0378:
            r2 = 0;
            goto L_0x001c;
        L_0x037b:
            r4 = r2;
            r2 = "GLThread";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.<init>();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = "waiting tid=";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r24.getId();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mHaveEglContext: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdV;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mHaveEglSurface: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdW;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mPaused: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.mPaused;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mHasSurface: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdS;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mSurfaceIsBad: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdT;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mWaitingForSurface: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdU;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mWidth: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.mWidth;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mHeight: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.mHeight;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mRequestRender: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdZ;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = " mRenderMode: ";	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r1.bdY;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3.append(r5);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r3 = r3.toString();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            android.util.Log.i(r2, r3);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2.wait();	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r5 = r19;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r6 = r20;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = 0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            goto L_0x0021;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
        L_0x0409:
            r0 = move-exception;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            r2 = r0;	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            monitor-exit(r16);	 Catch:{ RuntimeException -> 0x020f, all -> 0x0409 }
            throw r2;	 Catch:{ all -> 0x0341, all -> 0x0293, all -> 0x040d }
        L_0x040d:
            r0 = move-exception;
            r2 = r0;
            r3 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r3);
            r24.Zs();	 Catch:{ all -> 0x041c }
            r24.Zt();	 Catch:{ all -> 0x041c }
            monitor-exit(r3);	 Catch:{ all -> 0x041c }
            throw r2;
        L_0x041c:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r3);	 Catch:{ all -> 0x041c }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.Zu():void");
        }

        i(WeakReference<b> weakReference) {
            this.bdJ = weakReference;
        }

        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GLThread ");
            stringBuilder.append(getId());
            setName(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("starting tid=");
            stringBuilder2.append(getId());
            Log.i("GLThread", stringBuilder2.toString());
            try {
                Zu();
            } catch (InterruptedException unused) {
                b.bdp.a(this);
            } catch (Throwable th) {
                b.bdp.a(this);
            }
        }

        private void Zs() {
            if (this.bdW) {
                this.bdW = false;
                this.bed.Zq();
            }
        }

        private void Zt() {
            if (this.bdV) {
                this.bed.finish();
                this.bdV = false;
                b.bdp.c(this);
            }
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
            synchronized (b.bdp) {
                this.bdY = i;
                b.bdp.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (b.bdp) {
                i = this.bdY;
            }
            return i;
        }

        public void requestRender() {
            synchronized (b.bdp) {
                this.bdZ = true;
                b.bdp.notifyAll();
            }
        }

        /* JADX WARNING: Missing block: B:12:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void Zx() {
            /*
            r5 = this;
            r0 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r0);
            r1 = "GLThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0044 }
            r2.<init>();	 Catch:{ all -> 0x0044 }
            r3 = "surfaceCreated tid=";
            r2.append(r3);	 Catch:{ all -> 0x0044 }
            r3 = r5.getId();	 Catch:{ all -> 0x0044 }
            r2.append(r3);	 Catch:{ all -> 0x0044 }
            r2 = r2.toString();	 Catch:{ all -> 0x0044 }
            android.util.Log.i(r1, r2);	 Catch:{ all -> 0x0044 }
            r1 = 1;
            r5.bdS = r1;	 Catch:{ all -> 0x0044 }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0044 }
            r1.notifyAll();	 Catch:{ all -> 0x0044 }
        L_0x002a:
            r1 = r5.bdU;	 Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0042;
        L_0x002e:
            r1 = r5.bdQ;	 Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0042;
        L_0x0032:
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ InterruptedException -> 0x003a }
            r1.wait();	 Catch:{ InterruptedException -> 0x003a }
            goto L_0x002a;
        L_0x003a:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0044 }
            r1.interrupt();	 Catch:{ all -> 0x0044 }
            goto L_0x002a;
        L_0x0042:
            monitor-exit(r0);	 Catch:{ all -> 0x0044 }
            return;
        L_0x0044:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0044 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.Zx():void");
        }

        /* JADX WARNING: Missing block: B:12:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void Zy() {
            /*
            r5 = this;
            r0 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r0);
            r1 = "GLThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0044 }
            r2.<init>();	 Catch:{ all -> 0x0044 }
            r3 = "surfaceDestroyed tid=";
            r2.append(r3);	 Catch:{ all -> 0x0044 }
            r3 = r5.getId();	 Catch:{ all -> 0x0044 }
            r2.append(r3);	 Catch:{ all -> 0x0044 }
            r2 = r2.toString();	 Catch:{ all -> 0x0044 }
            android.util.Log.i(r1, r2);	 Catch:{ all -> 0x0044 }
            r1 = 0;
            r5.bdS = r1;	 Catch:{ all -> 0x0044 }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0044 }
            r1.notifyAll();	 Catch:{ all -> 0x0044 }
        L_0x002a:
            r1 = r5.bdU;	 Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0042;
        L_0x002e:
            r1 = r5.bdQ;	 Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0042;
        L_0x0032:
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ InterruptedException -> 0x003a }
            r1.wait();	 Catch:{ InterruptedException -> 0x003a }
            goto L_0x002a;
        L_0x003a:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0044 }
            r1.interrupt();	 Catch:{ all -> 0x0044 }
            goto L_0x002a;
        L_0x0042:
            monitor-exit(r0);	 Catch:{ all -> 0x0044 }
            return;
        L_0x0044:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0044 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.Zy():void");
        }

        /* JADX WARNING: Missing block: B:13:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void onPause() {
            /*
            r5 = this;
            r0 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r0);
            r1 = "GLThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004a }
            r2.<init>();	 Catch:{ all -> 0x004a }
            r3 = "onPause tid=";
            r2.append(r3);	 Catch:{ all -> 0x004a }
            r3 = r5.getId();	 Catch:{ all -> 0x004a }
            r2.append(r3);	 Catch:{ all -> 0x004a }
            r2 = r2.toString();	 Catch:{ all -> 0x004a }
            android.util.Log.i(r1, r2);	 Catch:{ all -> 0x004a }
            r1 = 1;
            r5.bdR = r1;	 Catch:{ all -> 0x004a }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x004a }
            r1.notifyAll();	 Catch:{ all -> 0x004a }
        L_0x0029:
            r1 = r5.bdQ;	 Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0048;
        L_0x002d:
            r1 = r5.mPaused;	 Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0048;
        L_0x0031:
            r1 = "Main thread";
            r2 = "onPause waiting for mPaused.";
            android.util.Log.i(r1, r2);	 Catch:{ all -> 0x004a }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ InterruptedException -> 0x0040 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0040 }
            goto L_0x0029;
        L_0x0040:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x004a }
            r1.interrupt();	 Catch:{ all -> 0x004a }
            goto L_0x0029;
        L_0x0048:
            monitor-exit(r0);	 Catch:{ all -> 0x004a }
            return;
        L_0x004a:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x004a }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.onPause():void");
        }

        /* JADX WARNING: Missing block: B:15:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void onResume() {
            /*
            r5 = this;
            r0 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r0);
            r1 = "GLThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0053 }
            r2.<init>();	 Catch:{ all -> 0x0053 }
            r3 = "onResume tid=";
            r2.append(r3);	 Catch:{ all -> 0x0053 }
            r3 = r5.getId();	 Catch:{ all -> 0x0053 }
            r2.append(r3);	 Catch:{ all -> 0x0053 }
            r2 = r2.toString();	 Catch:{ all -> 0x0053 }
            android.util.Log.i(r1, r2);	 Catch:{ all -> 0x0053 }
            r1 = 0;
            r5.bdR = r1;	 Catch:{ all -> 0x0053 }
            r2 = 1;
            r5.bdZ = r2;	 Catch:{ all -> 0x0053 }
            r5.bea = r1;	 Catch:{ all -> 0x0053 }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0053 }
            r1.notifyAll();	 Catch:{ all -> 0x0053 }
        L_0x002e:
            r1 = r5.bdQ;	 Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0051;
        L_0x0032:
            r1 = r5.mPaused;	 Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0051;
        L_0x0036:
            r1 = r5.bea;	 Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0051;
        L_0x003a:
            r1 = "Main thread";
            r2 = "onResume waiting for !mPaused.";
            android.util.Log.i(r1, r2);	 Catch:{ all -> 0x0053 }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ InterruptedException -> 0x0049 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0049 }
            goto L_0x002e;
        L_0x0049:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0053 }
            r1.interrupt();	 Catch:{ all -> 0x0053 }
            goto L_0x002e;
        L_0x0051:
            monitor-exit(r0);	 Catch:{ all -> 0x0053 }
            return;
        L_0x0053:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0053 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.onResume():void");
        }

        /* JADX WARNING: Missing block: B:17:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void aj(int r4, int r5) {
            /*
            r3 = this;
            r0 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r0);
            r3.mWidth = r4;	 Catch:{ all -> 0x0056 }
            r3.mHeight = r5;	 Catch:{ all -> 0x0056 }
            r4 = 1;
            r3.bec = r4;	 Catch:{ all -> 0x0056 }
            r3.bdZ = r4;	 Catch:{ all -> 0x0056 }
            r4 = 0;
            r3.bea = r4;	 Catch:{ all -> 0x0056 }
            r4 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0056 }
            r4.notifyAll();	 Catch:{ all -> 0x0056 }
        L_0x0018:
            r4 = r3.bdQ;	 Catch:{ all -> 0x0056 }
            if (r4 != 0) goto L_0x0054;
        L_0x001c:
            r4 = r3.mPaused;	 Catch:{ all -> 0x0056 }
            if (r4 != 0) goto L_0x0054;
        L_0x0020:
            r4 = r3.bea;	 Catch:{ all -> 0x0056 }
            if (r4 != 0) goto L_0x0054;
        L_0x0024:
            r4 = r3.Zv();	 Catch:{ all -> 0x0056 }
            if (r4 == 0) goto L_0x0054;
        L_0x002a:
            r4 = "Main thread";
            r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0056 }
            r5.<init>();	 Catch:{ all -> 0x0056 }
            r1 = "onWindowResize waiting for render complete from tid=";
            r5.append(r1);	 Catch:{ all -> 0x0056 }
            r1 = r3.getId();	 Catch:{ all -> 0x0056 }
            r5.append(r1);	 Catch:{ all -> 0x0056 }
            r5 = r5.toString();	 Catch:{ all -> 0x0056 }
            android.util.Log.i(r4, r5);	 Catch:{ all -> 0x0056 }
            r4 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ InterruptedException -> 0x004c }
            r4.wait();	 Catch:{ InterruptedException -> 0x004c }
            goto L_0x0018;
        L_0x004c:
            r4 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0056 }
            r4.interrupt();	 Catch:{ all -> 0x0056 }
            goto L_0x0018;
        L_0x0054:
            monitor-exit(r0);	 Catch:{ all -> 0x0056 }
            return;
        L_0x0056:
            r4 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0056 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.aj(int, int):void");
        }

        /* JADX WARNING: Missing block: B:11:?, code:
            java.lang.Thread.currentThread().interrupt();
     */
        public void Zz() {
            /*
            r2 = this;
            r0 = com.iqoption.core.ui.widget.b.bdp;
            monitor-enter(r0);
            r1 = 1;
            r2.bdP = r1;	 Catch:{ all -> 0x0025 }
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ all -> 0x0025 }
            r1.notifyAll();	 Catch:{ all -> 0x0025 }
        L_0x000f:
            r1 = r2.bdQ;	 Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0023;
        L_0x0013:
            r1 = com.iqoption.core.ui.widget.b.bdp;	 Catch:{ InterruptedException -> 0x001b }
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
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.b.i.Zz():void");
        }

        public void ZA() {
            this.bdX = true;
            b.bdp.notifyAll();
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
        private i bek;

        private j() {
        }

        public synchronized void a(i iVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exiting tid=");
            stringBuilder.append(iVar.getId());
            Log.i("GLThread", stringBuilder.toString());
            iVar.bdQ = true;
            if (this.bek == iVar) {
                this.bek = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bek == iVar || this.bek == null) {
                this.bek = iVar;
                notifyAll();
                return true;
            }
            ZD();
            if (this.bei) {
                return true;
            }
            if (this.bek != null) {
                this.bek.ZA();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bek == iVar) {
                this.bek = null;
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
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("checkGLDriver renderer = \"");
                stringBuilder.append(glGetString);
                stringBuilder.append("\" multipleContextsAllowed = ");
                stringBuilder.append(this.bei);
                stringBuilder.append(" mLimitedGLESContexts = ");
                stringBuilder.append(this.bej);
                Log.w(str, stringBuilder.toString());
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
                Log.v("GLTextureView", this.mBuilder.toString());
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
            if (b.this.bdy != 2) {
                return iArr;
            }
            int length = iArr.length;
            Object obj = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, obj, 0, i);
            obj[i] = 12352;
            obj[length] = 4;
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
            int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, b.this.bdy, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (b.this.bdy == 0) {
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
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("tid=");
                stringBuilder2.append(Thread.currentThread().getId());
                Log.i("DefaultContextFactory", stringBuilder2.toString());
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
            if (this.bdr != null) {
                this.bdr.Zz();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bdw = kVar;
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
        if (this.bdt == null) {
            this.bdt = new n(true);
        }
        if (this.bdu == null) {
            this.bdu = new c();
        }
        if (this.bdv == null) {
            this.bdv = new d();
        }
        this.bds = mVar;
        this.bdr = new i(this.bdq);
        this.bdr.start();
    }

    public void setEGLContextFactory(f fVar) {
        Zl();
        this.bdu = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Zl();
        this.bdv = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Zl();
        this.bdt = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i) {
        Zl();
        this.bdy = i;
    }

    public void setRenderMode(int i) {
        this.bdr.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.bdr.getRenderMode();
    }

    public void requestRender() {
        this.bdr.requestRender();
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.bdr.Zx();
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.bdr.Zy();
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.bdr.aj(i2, i3);
    }

    public void onPause() {
        this.bdr.onPause();
    }

    public void onResume() {
        this.bdr.onResume();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAttachedToWindow reattach =");
        stringBuilder.append(this.mDetached);
        Log.d("GLTextureView", stringBuilder.toString());
        if (this.mDetached && this.bds != null) {
            int renderMode = this.bdr != null ? this.bdr.getRenderMode() : 1;
            this.bdr = new i(this.bdq);
            if (renderMode != 1) {
                this.bdr.setRenderMode(renderMode);
            }
            this.bdr.start();
        }
        this.mDetached = false;
    }

    protected void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        if (this.bdr != null) {
            this.bdr.Zz();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        a(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture);
        a(surfaceTexture, 0, i, i2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture, 0, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b(surfaceTexture);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    private void Zl() {
        if (this.bdr != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
