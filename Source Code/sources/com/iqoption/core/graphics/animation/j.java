package com.iqoption.core.graphics.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/graphics/animation/MatrixEvaluator;", "Landroid/animation/TypeEvaluator;", "Landroid/graphics/Matrix;", "()V", "tempEndValues", "", "tempMatrix", "tempStartValues", "evaluate", "fraction", "", "startValue", "endValue", "Companion", "core_release"})
/* compiled from: Evaluators.kt */
public final class j implements TypeEvaluator<Matrix> {
    private static final j aRh = new j();
    public static final a aRi = new a();
    private final float[] aRe = new float[9];
    private final float[] aRf = new float[9];
    private final Matrix aRg = new Matrix();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/graphics/animation/MatrixEvaluator$Companion;", "", "()V", "instance", "Lcom/iqoption/core/graphics/animation/MatrixEvaluator;", "instance$annotations", "getInstance", "()Lcom/iqoption/core/graphics/animation/MatrixEvaluator;", "core_release"})
    /* compiled from: Evaluators.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        h.e(matrix, "startValue");
        h.e(matrix2, "endValue");
        matrix.getValues(this.aRe);
        matrix2.getValues(this.aRf);
        for (int i = 0; i <= 8; i++) {
            this.aRf[i] = this.aRe[i] + ((this.aRf[i] - this.aRe[i]) * f);
        }
        this.aRg.setValues(this.aRf);
        return this.aRg;
    }
}
