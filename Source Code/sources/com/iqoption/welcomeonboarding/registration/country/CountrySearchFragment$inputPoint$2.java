package com.iqoption.welcomeonboarding.registration.country;

import android.graphics.Point;
import android.os.Parcelable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/graphics/Point;", "invoke"})
/* compiled from: CountrySearchFragment.kt */
final class CountrySearchFragment$inputPoint$2 extends Lambda implements a<Point> {
    final /* synthetic */ d this$0;

    CountrySearchFragment$inputPoint$2(d dVar) {
        this.this$0 = dVar;
        super(0);
    }

    /* renamed from: aMx */
    public final Point invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_INPUT_POINT");
        if (parcelable != null) {
            return (Point) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Point");
    }
}
