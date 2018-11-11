package com.iqoption.charttools.tools.data;

import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/charttools/tools/data/SettingType;", "", "text", "", "(Ljava/lang/String;II)V", "getText", "()I", "TRADERS_MOOD", "LIVE_DEALS", "APPLY_TO_ALL_ASSETS", "VOLUME", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SettingType.kt */
public enum SettingType {
    TRADERS_MOOD(R.string.traders_mood),
    LIVE_DEALS(R.string.live_deals),
    APPLY_TO_ALL_ASSETS(R.string.apply_indicators_to_all_title),
    VOLUME(R.string.volume);
    
    private final int text;

    protected SettingType(int i) {
        this.text = i;
    }

    public final int getText() {
        return this.text;
    }
}
