package com.iqoption.core.ui.widget.gl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;

public final class GLGraphSurfaceView extends GLSurfaceView {
    private a beF;

    public interface a extends Renderer {
        void ZE();

        void ZF();

        boolean onTouchEvent(@NonNull MotionEvent motionEvent);
    }

    public GLGraphSurfaceView(Context context) {
        this(context, null);
    }

    public GLGraphSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            setEGLContextClientVersion(2);
            setEGLContextFactory(a.beA);
            setPreserveEGLContextOnPause(true);
        }
    }

    public void setController(@NonNull a aVar) {
        this.beF = aVar;
        setRenderer(aVar);
        setRenderMode(1);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.beF == null) {
            return false;
        }
        if (this.beF.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent)) {
            z = true;
        }
        return z;
    }

    public void onResume() {
        super.onResume();
        if (this.beF != null) {
            this.beF.ZE();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.beF != null) {
            this.beF.ZF();
        }
    }
}
