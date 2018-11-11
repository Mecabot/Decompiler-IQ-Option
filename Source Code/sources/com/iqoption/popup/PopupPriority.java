package com.iqoption.popup;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/popup/PopupPriority;", "", "weight", "", "(Ljava/lang/String;II)V", "getWeight", "()I", "VERY_HIGH", "HIGH", "NORMAL", "LOW", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PopupPriority.kt */
public enum PopupPriority {
    VERY_HIGH(100),
    HIGH(70),
    NORMAL(50),
    LOW(10);
    
    private final int weight;

    protected PopupPriority(int i) {
        this.weight = i;
    }

    public final int getWeight() {
        return this.weight;
    }
}
