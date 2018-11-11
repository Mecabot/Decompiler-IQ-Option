package com.iqoption.tutorial.a;

import com.iqoption.tutorial.dictionary.TutorialAction;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] aoS = new int[TutorialAction.values().length];

    static {
        aoS[TutorialAction.PRACTICE_BALANCE.ordinal()] = 1;
        aoS[TutorialAction.TIME_SCALE.ordinal()] = 2;
        aoS[TutorialAction.CALL_PUT.ordinal()] = 3;
        aoS[TutorialAction.CALL_PUT_ANOTHER_INSTRUMENT.ordinal()] = 4;
        aoS[TutorialAction.ADD_TAB.ordinal()] = 5;
        aoS[TutorialAction.CHOOSE_INSTRUMENT.ordinal()] = 6;
        aoS[TutorialAction.CHOOSE_ASSET.ordinal()] = 7;
        aoS[TutorialAction.CHART_TYPE.ordinal()] = 8;
        aoS[TutorialAction.EDUCATIONAL_VIDEOS.ordinal()] = 9;
    }
}
