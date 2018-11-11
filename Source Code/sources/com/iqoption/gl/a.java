package com.iqoption.gl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.iqoption.analytics.sla.Sla;
import com.iqoption.app.af;
import com.iqoption.core.f;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.ui.widget.gl.c;
import com.iqoption.core.ui.widget.gl.d;
import com.iqoption.core.ui.widget.gl.e;
import com.iqoption.settings.b;
import com.iqoption.x.R;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020!J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020'J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020'J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020'J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, aXE = {"Lcom/iqoption/gl/GraphController;", "Lcom/iqoption/core/ui/widget/gl/GLGraphView$Controller;", "Lcom/iqoption/core/ui/widget/gl/GLGraphSurfaceView$Controller;", "context", "Landroid/content/Context;", "graph", "Lcom/iqoption/core/gl/Graph;", "(Landroid/content/Context;Lcom/iqoption/core/gl/Graph;)V", "graphFrame", "Lcom/iqoption/core/ui/widget/gl/GraphFrame;", "graphGestureDetector", "Lcom/iqoption/core/ui/widget/gl/GraphGestureDetector;", "graphRenderer", "Lcom/iqoption/core/ui/widget/gl/GraphRenderer;", "initPadding", "", "rect", "Landroid/graphics/Rect;", "initScaleFactor", "factor", "", "initTexts", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setBottomPadding", "padding", "duration", "", "setInvestmentAmountEnabled", "enabled", "setLeftPadding", "setRightPadding", "setTopPadding", "startDrawing", "stopDrawing", "IqOption-5.5.1_optionXRelease"})
/* compiled from: GraphController.kt */
public final class a implements com.iqoption.core.ui.widget.gl.GLGraphSurfaceView.a, com.iqoption.core.ui.widget.gl.b.a {
    private final Graph asq;
    private final c cIA = new c();
    private final d cIB;
    private final e cIC;

    public a(Context context, Graph graph) {
        h.e(context, "context");
        h.e(graph, "graph");
        this.asq = graph;
        this.cIB = new d(context, this.asq, this.cIA);
        this.cIC = new e(this.asq, this.cIA, 0, 4, null);
        final double j = (double) com.iqoption.core.ext.a.j(context, R.dimen.dp100);
        final double j2 = (double) com.iqoption.core.ext.a.j(context, R.dimen.time_scale_bar_height);
        float j3 = com.iqoption.core.ext.a.j(context, R.dimen.dp10) / ((float) 20);
        Rect rect = new Rect(com.iqoption.core.ext.a.k(context, R.dimen.dp48), com.iqoption.core.ext.a.k(context, R.dimen.dp48), com.iqoption.core.ext.a.k(context, R.dimen.dp130), 0);
        H(j3);
        f(rect);
        aov();
        com.iqoption.core.h.i.Yr().q(new Runnable(this) {
            final /* synthetic */ a cID;

            public final void run() {
                b aDQ = b.aDQ();
                com.iqoption.app.managers.feature.b HT = com.iqoption.app.managers.feature.b.HT();
                this.cID.asq.glchTabSetSmallDealsEnabled(1);
                Graph a = this.cID.asq;
                h.d(aDQ, "settingsManager");
                a.glchSetBetTickerExtendedView(aDQ.aDW());
                this.cID.asq.glchTabSetHighLowVisible(aDQ.Ep());
                this.cID.asq.glchTabSetTimeScaleBarXOffsetAndPadding(j, 0.0d, j2);
                this.cID.asq.glchSetFirstDOSellExperience(af.eM("first_do_sell_experience"));
                this.cID.asq.glchSetFeatureState("take-profit", "enabled");
                this.cID.asq.glchSetFeatureState("profit-loss-limits", HT.eY("profit-loss-limits"));
                this.cID.asq.glchSetFeatureState("strikes-display-mode", HT.eY("strikes-display-mode"));
                this.cID.asq.glchSetFeatureState("fx-option-strikes-display-mode", HT.eY("fx-option-strikes-display-mode"));
                this.cID.asq.glchSetFeatureState("show-itm-on-chart", HT.eY("show-itm-on-chart"));
            }
        });
    }

    private final void H(float f) {
        this.asq.glchCommonSetScaleFactor(f);
    }

    private final void f(Rect rect) {
        e eVar = this.cIC;
        e.b(eVar, rect.left, 0, 2, null);
        e.a(eVar, rect.top, 0, 2, null);
        e.c(eVar, rect.right, 0, 2, null);
        e.d(eVar, rect.bottom, 0, 2, null);
    }

    private final void aov() {
        Graph graph = this.asq;
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        h.d(Cw, "IQAccount.instance()");
        graph.glchSetProfitMaskText(Cw.CD());
        this.asq.glchSetPurchaseTexts(f.RT(), f.getString(R.string.purchase_deadline), f.getString(R.string.expiry_time));
        this.asq.glchProviderTexts(f.getString(R.string.expiration_level_provided_by), f.getString(R.string.thomson_reuters));
        String string = f.getString(R.string.put);
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string = string.toUpperCase();
        h.d(string, "(this as java.lang.String).toUpperCase()");
        String string2 = f.getString(R.string.call);
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string2 = string2.toUpperCase();
        h.d(string2, "(this as java.lang.String).toUpperCase()");
        this.asq.glchSetTradersMoodTexts(string, string2);
        this.asq.glchSetTopTradersProfitMaskText("$%s");
        this.asq.glchSetText("profit_text", f.getString(R.string.profit));
        graph = this.asq;
        string2 = "best_deals";
        String string3 = f.getString(R.string.best_deals);
        if (string3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string3 = string3.toUpperCase();
        h.d(string3, "(this as java.lang.String).toUpperCase()");
        graph.glchSetText(string2, string3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.e(motionEvent, "event");
        return this.cIB.onTouchEvent(motionEvent);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.cIC.onSurfaceCreated(gl10, eGLConfig);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.cIC.onSurfaceChanged(gl10, i, i2);
    }

    public void onDrawFrame(GL10 gl10) {
        this.cIC.onDrawFrame(gl10);
    }

    public void ZE() {
        this.asq.glchOnAppUnfolding();
        this.asq.glchCommonSetDrawEnabled(1);
        Sla.Ci().Cl();
    }

    public void ZF() {
        Sla.Ci().Cm();
        this.asq.glchCommonSetDrawEnabled(0);
    }

    public final void f(int i, long j) {
        this.cIC.f(i, j);
    }

    public final void dI(boolean z) {
        this.asq.glchSetBetTickerExtendedView(z);
    }
}
