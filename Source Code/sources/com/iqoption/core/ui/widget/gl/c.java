package com.iqoption.core.ui.widget.gl;

import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fJ\u0016\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GraphFrame;", "", "()V", "<set-?>", "", "graphHeight", "getGraphHeight", "()I", "setGraphHeight", "(I)V", "graphWidth", "getGraphWidth", "setGraphWidth", "listeners", "", "Lcom/iqoption/core/ui/widget/gl/GraphFrame$OnFrameSizeChangedListener;", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "paddingLeft", "getPaddingLeft", "setPaddingLeft", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingTop", "getPaddingTop", "setPaddingTop", "viewHeight", "viewWidth", "addSizeChangedListener", "", "l", "onSizeChanged", "newWidth", "newHeight", "removeSizeChangedListener", "OnFrameSizeChangedListener", "core_release"})
/* compiled from: GraphFrame.kt */
public final class c {
    private int beH;
    private int beI;
    private final List<a> ln = new ArrayList();
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int viewHeight;
    private int viewWidth;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GraphFrame$OnFrameSizeChangedListener;", "", "onFrameSizeChanged", "", "paddingLeft", "", "paddingTop", "paddingRight", "paddingBottom", "width", "height", "core_release"})
    /* compiled from: GraphFrame.kt */
    public interface a {
        void b(int i, int i2, int i3, int i4, int i5, int i6);
    }

    public final int ZG() {
        return this.beH;
    }

    public final int ZH() {
        return this.beI;
    }

    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    public final void setPaddingLeft(int i) {
        this.paddingLeft = i;
        ak(this.viewWidth, this.viewHeight);
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final void setPaddingTop(int i) {
        this.paddingTop = i;
        ak(this.viewWidth, this.viewHeight);
    }

    public final int getPaddingRight() {
        return this.paddingRight;
    }

    public final void setPaddingRight(int i) {
        this.paddingRight = i;
        ak(this.viewWidth, this.viewHeight);
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final void setPaddingBottom(int i) {
        this.paddingBottom = i;
        ak(this.viewWidth, this.viewHeight);
    }

    public final void ak(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
        this.beH = (i - this.paddingLeft) - this.paddingRight;
        this.beI = (i2 - this.paddingTop) - this.paddingBottom;
        for (a b : this.ln) {
            b.b(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom, this.beH, this.beI);
        }
    }

    public final void a(a aVar) {
        h.e(aVar, "l");
        this.ln.add(aVar);
    }
}
