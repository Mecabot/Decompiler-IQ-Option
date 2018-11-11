package com.iqoption.core.ui.widget.gl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.iqoption.core.gl.Graph;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector;", "", "context", "Landroid/content/Context;", "graph", "Lcom/iqoption/core/gl/Graph;", "frame", "Lcom/iqoption/core/ui/widget/gl/GraphFrame;", "(Landroid/content/Context;Lcom/iqoption/core/gl/Graph;Lcom/iqoption/core/ui/widget/gl/GraphFrame;)V", "gestureListener", "Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector$GestureListener;", "isInstrumentSelected", "", "isScaling", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollDetector", "Landroid/view/GestureDetector;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "GestureListener", "ScaleListener", "core_release"})
/* compiled from: GraphGestureDetector.kt */
public final class d {
    private final Graph asq;
    private final a beJ = new a();
    private final GestureDetector beK;
    private final ScaleGestureDetector beL;
    private boolean beM;
    private boolean beN;
    private final c beO;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016J(\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector;)V", "isMoveStarted", "", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDown", "e1", "onFling", "e2", "velocityX", "", "velocityY", "onScroll", "distanceX", "distanceY", "onUp", "core_release"})
    /* compiled from: GraphGestureDetector.kt */
    private final class a extends SimpleOnGestureListener {
        private boolean beP;

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            h.e(motionEvent, "e1");
            h.e(motionEvent2, "e2");
            if (d.this.beM) {
                d.this.asq.glchActionTouchMovedToPoint((motionEvent2.getX() - ((float) d.this.beO.getPaddingLeft())) / ((float) d.this.beO.ZG()), (motionEvent2.getY() - ((float) d.this.beO.getPaddingTop())) / ((float) d.this.beO.ZH()));
            } else {
                d.this.asq.glchActionMove(f / ((float) d.this.beO.ZG()), f2 / ((float) d.this.beO.ZH()), 0.0f);
                this.beP = true;
            }
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            h.e(motionEvent, "e1");
            h.e(motionEvent2, "e2");
            d.this.asq.glchActionMove(0.0f, 0.0f, (((float) -1) * (f / ((float) 2))) / ((float) d.this.beO.ZG()));
            this.beP = true;
            c(motionEvent2);
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            h.e(motionEvent, "e1");
            d.this.beM = d.this.asq.glchActionTouchBegin((motionEvent.getX() - ((float) d.this.beO.getPaddingLeft())) / ((float) d.this.beO.ZG()), (motionEvent.getY() - ((float) d.this.beO.getPaddingTop())) / ((float) d.this.beO.ZH())) == 1;
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            h.e(motionEvent, "e");
            d.this.asq.glchActionScale(2.0f);
            return true;
        }

        public final boolean c(MotionEvent motionEvent) {
            h.e(motionEvent, "e");
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (this.beP) {
                d.this.asq.glchActionMoveEnded();
                this.beP = false;
            }
            d.this.asq.glchActionTouchEnd((motionEvent.getX() - ((float) d.this.beO.getPaddingLeft())) / ((float) d.this.beO.ZG()), (motionEvent.getY() - ((float) d.this.beO.getPaddingTop())) / ((float) d.this.beO.ZH()));
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector$ScaleListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "(Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "core_release"})
    /* compiled from: GraphGestureDetector.kt */
    private final class b extends SimpleOnScaleGestureListener {
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            h.e(scaleGestureDetector, "detector");
            d.this.asq.glchActionScale(scaleGestureDetector.getScaleFactor());
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            d.this.beN = true;
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            d.this.beN = false;
        }
    }

    public d(Context context, Graph graph, c cVar) {
        h.e(context, "context");
        h.e(graph, "graph");
        h.e(cVar, "frame");
        this.asq = graph;
        this.beO = cVar;
        GestureDetector gestureDetector = new GestureDetector(context, this.beJ);
        gestureDetector.setIsLongpressEnabled(false);
        this.beK = gestureDetector;
        this.beL = new ScaleGestureDetector(context, new b());
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        h.e(motionEvent, "event");
        boolean z = true;
        if (this.beL.onTouchEvent(motionEvent) && this.beN) {
            return true;
        }
        if (!(this.beK.onTouchEvent(motionEvent) || this.beJ.c(motionEvent))) {
            z = false;
        }
        return z;
    }
}
