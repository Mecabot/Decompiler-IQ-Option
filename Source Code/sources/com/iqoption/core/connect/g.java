package com.iqoption.core.connect;

import com.iqoption.core.connect.bus.IQBusState;
import io.reactivex.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/connect/IQBus;", "", "state", "Lcom/iqoption/core/connect/bus/IQBusState;", "getState", "()Lcom/iqoption/core/connect/bus/IQBusState;", "stateStream", "Lio/reactivex/Flowable;", "getStateStream", "()Lio/reactivex/Flowable;", "connect", "Lio/reactivex/Completable;", "ssid", "", "disconnect", "core_release"})
/* compiled from: IQBus.kt */
public interface g {
    e<IQBusState> RY();

    IQBusState RZ();
}
