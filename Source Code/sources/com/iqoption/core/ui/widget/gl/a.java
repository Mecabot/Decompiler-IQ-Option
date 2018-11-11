package com.iqoption.core.ui.widget.gl;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.ui.widget.b.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001e\u0010\u0017\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010\u0019\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GLContextProvider;", "Lcom/iqoption/core/ui/widget/GLTextureView$EGLContextFactory;", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "()V", "EGL_CONTEXT_ATTR_VERSION", "", "EGL_CONTEXT_VERSION", "TAG", "", "kotlin.jvm.PlatformType", "shared", "Ljavax/microedition/khronos/egl/EGLContext;", "createContext", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "destroyContext", "", "context", "makeContext", "check", "", "release", "core_release"})
/* compiled from: GLContextProvider.kt */
public final class a implements EGLContextFactory, f {
    private static final String TAG = "a";
    public static final a beA = new a();
    private static EGLContext bez;

    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
    }

    private a() {
    }

    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        h.e(egl10, "egl");
        EGLContext eGLContext = bez;
        if (eGLContext == null) {
            return a(egl10, eGLDisplay, eGLConfig);
        }
        if (b(eGLContext, egl10, eGLDisplay)) {
            return eGLContext;
        }
        a(eGLContext, egl10, eGLDisplay);
        return a(egl10, eGLDisplay, eGLConfig);
    }

    private final void a(EGLContext eGLContext, EGL10 egl10, EGLDisplay eGLDisplay) {
        try {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        } catch (Exception unused) {
            com.iqoption.core.i.w(TAG, "Could not release EGL Context");
        }
    }

    private final boolean b(EGLContext eGLContext, EGL10 egl10, EGLDisplay eGLDisplay) {
        return egl10.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, eGLContext) || egl10.eglGetError() != 12294;
    }

    private final EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        bez = eglCreateContext;
        Graph.setRequiresInit();
        h.d(eglCreateContext, "egl.eglCreateContext(\n  …tRequiresInit()\n        }");
        return eglCreateContext;
    }
}
