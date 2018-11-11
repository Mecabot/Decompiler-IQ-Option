package com.iqoption.microservice.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0003\u001a\u00028\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEvent;", "Data", "", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Events.kt */
public class c<Data> {
    @SerializedName("data")
    private final Data data;

    public final Data getData() {
        return this.data;
    }
}
