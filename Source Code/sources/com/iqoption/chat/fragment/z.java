package com.iqoption.chat.fragment;

import com.iqoption.microservice.chat.ChatRoomType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class z {
    public static final /* synthetic */ int[] aoS = new int[ChatRoomType.values().length];

    static {
        aoS[ChatRoomType.GLOBAL.ordinal()] = 1;
        aoS[ChatRoomType.SUPPORT.ordinal()] = 2;
        aoS[ChatRoomType.VIP.ordinal()] = 3;
    }
}
