package com.iqoption.quiz.chat;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import kotlin.i;
import kotlin.jvm.internal.h;

@TargetApi(21)
@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/quiz/chat/ChatMaskDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "count", "", "paint", "Landroid/graphics/Paint;", "topShaderHolder", "Lcom/iqoption/quiz/chat/ChatMaskDecoration$ShaderHolder;", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "Companion", "ShaderHolder", "quiz_release"})
/* compiled from: ChatMaskDecoration.kt */
public final class e extends ItemDecoration {
    private static final int djI = Color.rgb(255, 255, 255);
    private static final int djJ = Color.argb(0, 255, 255, 255);
    public static final a djK = new a();
    private int count;
    private final b djH = new b(ChatMaskDecoration$topShaderHolder$1.djN);
    private final Paint kx;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/quiz/chat/ChatMaskDecoration$Companion;", "", "()V", "COLOR_END", "", "COLOR_START", "quiz_release"})
    /* compiled from: ChatMaskDecoration.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/chat/ChatMaskDecoration$ShaderHolder;", "", "factory", "Lkotlin/Function1;", "", "Landroid/graphics/Shader;", "(Lkotlin/jvm/functions/Function1;)V", "height", "shader", "get", "h", "quiz_release"})
    /* compiled from: ChatMaskDecoration.kt */
    private static final class b {
        private Shader djL;
        private final kotlin.jvm.a.b<Float, Shader> djM;
        private float height;

        public b(kotlin.jvm.a.b<? super Float, ? extends Shader> bVar) {
            h.e(bVar, "factory");
            this.djM = bVar;
        }

        public final Shader J(float f) {
            Shader shader = this.djL;
            if (shader != null && this.height == f) {
                return shader;
            }
            shader = (Shader) this.djM.invoke(Float.valueOf(f));
            this.djL = shader;
            this.height = f;
            return shader;
        }
    }

    public e() {
        Paint paint = new Paint(1);
        paint.setFilterBitmap(false);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        this.kx = paint;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        h.e(canvas, "c");
        h.e(recyclerView, "parent");
        this.count = canvas.saveLayerAlpha(0.0f, 0.0f, (float) recyclerView.getWidth(), (float) recyclerView.getHeight(), 255);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        h.e(canvas, "c");
        h.e(recyclerView, "parent");
        this.kx.setShader(this.djH.J((float) recyclerView.getHeight()));
        canvas.drawPaint(this.kx);
        canvas.restoreToCount(this.count);
    }
}
