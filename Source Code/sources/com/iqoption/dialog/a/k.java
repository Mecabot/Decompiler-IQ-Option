package com.iqoption.dialog.a;

import com.iqoption.util.ah;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class k implements Callable {
    private final String alY;
    private final Type cgJ;

    k(String str, Type type) {
        this.alY = str;
        this.cgJ = type;
    }

    public Object call() {
        return ((List) ah.aGg().fromJson(this.alY, this.cgJ));
    }
}
