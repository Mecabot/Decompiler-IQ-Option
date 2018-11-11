package com.iqoption.chat.viewmodel;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "invoke"})
/* compiled from: RoomViewModel.kt */
final class RoomViewModel$sendSuggestion$2 extends Lambda implements b<Throwable, l> {
    public static final RoomViewModel$sendSuggestion$2 aLz = new RoomViewModel$sendSuggestion$2();

    RoomViewModel$sendSuggestion$2() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return l.etX;
    }

    public final void q(Throwable th) {
        h.e(th, "it");
        com.iqoption.core.i.w(RoomViewModel.TAG, "Suggestion sending failed", th);
    }
}
