package com.iqoption.microservice.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, aXE = {"Lcom/iqoption/microservice/chat/ChatResponse;", "", "isSuccessful", "", "errorMessage", "", "(ZLjava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "()Z", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public class m {
    @SerializedName("isSuccessful")
    private final boolean aVB;
    @SerializedName("error")
    private final String errorMessage;

    public m() {
        this(false, null, 3, null);
    }

    public m(boolean z, String str) {
        this.aVB = z;
        this.errorMessage = str;
    }

    public final boolean isSuccessful() {
        return this.aVB;
    }

    public /* synthetic */ m(boolean z, String str, int i, f fVar) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = (String) null;
        }
        this(z, str);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
