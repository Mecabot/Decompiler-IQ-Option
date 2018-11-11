package com.iqoption.core.ui.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import com.squareup.picasso.Transformation;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/ui/picasso/PathTransformation;", "Lcom/squareup/picasso/Transformation;", "factory", "Lkotlin/Function0;", "Landroid/graphics/Path;", "(Lkotlin/jvm/functions/Function0;)V", "onPostDraw", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "getOnPostDraw", "()Lkotlin/jvm/functions/Function1;", "setOnPostDraw", "(Lkotlin/jvm/functions/Function1;)V", "onPreDraw", "getOnPreDraw", "setOnPreDraw", "paint", "Landroid/graphics/Paint;", "path", "getPath", "()Landroid/graphics/Path;", "path$delegate", "Lkotlin/Lazy;", "key", "", "transform", "Landroid/graphics/Bitmap;", "source", "core_release"})
/* compiled from: PathTransformation.kt */
public final class b implements Transformation {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "path", "getPath()Landroid/graphics/Path;"))};
    private final d bbZ;
    private kotlin.jvm.a.b<? super Canvas, l> bca;
    private kotlin.jvm.a.b<? super Canvas, l> bcb;
    private final Paint kx = new Paint(1);

    private final Path getPath() {
        d dVar = this.bbZ;
        j jVar = apP[0];
        return (Path) dVar.getValue();
    }

    public String key() {
        return "path";
    }

    public b(a<? extends Path> aVar) {
        h.e(aVar, "factory");
        this.bbZ = g.f(new PathTransformation$path$2(aVar));
    }

    public final void i(kotlin.jvm.a.b<? super Canvas, l> bVar) {
        this.bcb = bVar;
    }

    public Bitmap transform(Bitmap bitmap) {
        h.e(bitmap, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        this.kx.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
        kotlin.jvm.a.b bVar = this.bca;
        if (bVar != null) {
            l lVar = (l) bVar.invoke(canvas);
        }
        canvas.drawPath(getPath(), this.kx);
        bVar = this.bcb;
        if (bVar != null) {
            l lVar2 = (l) bVar.invoke(canvas);
        }
        bitmap.recycle();
        h.d(createBitmap, "bitmap");
        return createBitmap;
    }
}
