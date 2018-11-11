package com.iqoption.fragment;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/TabLocalAsset;", "Lcom/iqoption/fragment/AssetTab;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TabTypes.kt */
public final class ck extends ac {
    private final String tag;

    public ck(String str) {
        h.e(str, "tag");
        super(TabType.LOCALE_ASSET_TAB, null);
        this.tag = str;
    }

    public final String getTag() {
        return this.tag;
    }
}
