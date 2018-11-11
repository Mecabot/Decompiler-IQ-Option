package com.iqoption.core.microservices;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\f\rB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/microservices/Event;", "T", "", "type", "", "data", "(ILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getType", "()I", "Companion", "Type", "core_release"})
/* compiled from: Event.kt */
public final class a<T> {
    public static final a aSJ = new a();
    private final T data;
    private final int type;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/Event$Companion;", "", "()V", "TYPE_CREATED", "", "TYPE_DELETED", "TYPE_UPDATED", "core_release"})
    /* compiled from: Event.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public a(int i, T t) {
        this.type = i;
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }
}
