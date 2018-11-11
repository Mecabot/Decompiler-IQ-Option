package com.iqoption.core.ui.widget.gl;

import android.opengl.GLSurfaceView.Renderer;
import com.iqoption.core.ext.c;
import com.iqoption.core.f;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.ui.widget.b.m;
import com.iqoption.core.ui.widget.gl.c.a;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J8\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\"\u0010\u0018\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u001c\u0010\u0019\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u001eJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u001eJ\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u001eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GraphRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "Lcom/iqoption/core/ui/widget/GLTextureView$Renderer;", "Lcom/iqoption/core/ui/widget/gl/GraphFrame$OnFrameSizeChangedListener;", "graph", "Lcom/iqoption/core/gl/Graph;", "frame", "Lcom/iqoption/core/ui/widget/gl/GraphFrame;", "color", "", "(Lcom/iqoption/core/gl/Graph;Lcom/iqoption/core/ui/widget/gl/GraphFrame;I)V", "duration", "", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onFrameSizeChanged", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "width", "height", "onSurfaceChanged", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "setBottomPadding", "padding", "", "setLeftPadding", "setRightPadding", "setTopPadding", "core_release"})
/* compiled from: GraphRenderer.kt */
public final class e implements Renderer, m, a {
    private final Graph asq;
    private final c beO;
    private float beR;
    private final int color;

    public e(Graph graph, c cVar, int i) {
        h.e(graph, "graph");
        h.e(cVar, "frame");
        this.asq = graph;
        this.beO = cVar;
        this.color = i;
        this.beO.a(this);
    }

    public /* synthetic */ e(Graph graph, c cVar, int i, int i2, f fVar) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(graph, cVar, i);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Graph.init(f.RR());
        this.asq.onSurfaceCreated(c.ad(this.color, 8));
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.beO.ak(i, i2);
            c cVar = this.beO;
            this.asq.onSurfaceChanged(cVar.getPaddingLeft(), cVar.getPaddingTop(), cVar.getPaddingRight(), cVar.getPaddingBottom(), i, i2, this.color == 0);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        this.asq.onDrawFrame();
    }

    public void b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.asq.glchTabSetFrame((float) i, (float) i2, (float) i5, (float) i6, this.beR);
        this.beR = 0.0f;
    }

    public static /* synthetic */ void a(e eVar, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        eVar.f(i, j);
    }

    public final void f(int i, long j) {
        this.beR = ((float) j) / 1000.0f;
        this.beO.setPaddingTop(i);
    }

    public static /* synthetic */ void b(e eVar, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        eVar.g(i, j);
    }

    public final void g(int i, long j) {
        this.beR = ((float) j) / 1000.0f;
        this.beO.setPaddingLeft(i);
    }

    public static /* synthetic */ void c(e eVar, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        eVar.h(i, j);
    }

    public final void h(int i, long j) {
        this.beR = ((float) j) / 1000.0f;
        this.beO.setPaddingRight(i);
    }

    public static /* synthetic */ void d(e eVar, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        eVar.i(i, j);
    }

    public final void i(int i, long j) {
        this.beR = ((float) j) / 1000.0f;
        this.beO.setPaddingBottom(i);
    }
}
