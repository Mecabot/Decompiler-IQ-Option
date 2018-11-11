package com.iqoption.mobbtech.connect.response;

import com.google.common.base.e;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: SimpleResponseArrayMessage */
public class m extends n {
    @SerializedName("message")
    public List<String> message;

    public String toString() {
        return e.B(this).d("super", super.toString()).d("message", getMessage()).toString();
    }

    public String getMessage() {
        return (this.message == null || this.message.isEmpty()) ? null : (String) this.message.get(0);
    }
}
