package com.iqoption.chat.component;

import com.iqoption.microservice.chat.ChatRoomType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class ak {
    public static final /* synthetic */ int[] aoS = new int[ChatRoomType.values().length];

    static {
        aoS[ChatRoomType.SUPPORT.ordinal()] = 1;
        aoS[ChatRoomType.FEEDBACK.ordinal()] = 2;
    }
}
