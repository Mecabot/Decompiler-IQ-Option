package com.iqoption.chat.component;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import com.iqoption.core.ui.picasso.b;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/picasso/PathTransformation;", "invoke"})
/* compiled from: RoomsAdapter.kt */
final class RoomsAdapter$avatarTransformation$2 extends Lambda implements a<b> {
    final /* synthetic */ aj this$0;

    RoomsAdapter$avatarTransformation$2(aj ajVar) {
        this.this$0 = ajVar;
        super(0);
    }

    /* renamed from: Pp */
    public final b invoke() {
        Paint paint = new Paint(1);
        paint.setColor(this.this$0.getColor(R.color.green));
        float ds = this.this$0.ds(R.dimen.dp40);
        final float f = ds / 2.0f;
        float ds2 = this.this$0.ds(R.dimen.dp5);
        final float ds3 = this.this$0.ds(R.dimen.dp8);
        ds -= ds2;
        b bVar = new b(new a<Path>(ds) {
            final /* synthetic */ float $x0;

            /* renamed from: Pq */
            public final Path invoke() {
                Path path = new Path();
                Path path2 = new Path();
                path2.addCircle(this.$x0, ds, ds3, Direction.CW);
                path.addCircle(f, f, f, Direction.CW);
                path.op(path2, Op.DIFFERENCE);
                return path;
            }
        });
        bVar.i(new RoomsAdapter$avatarTransformation$2$$special$$inlined$apply$lambda$1(ds, ds, ds2, paint));
        return bVar;
    }
}
