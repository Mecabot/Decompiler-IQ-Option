package com.iqoption.tutorial;

import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.tutorial.utils.PointerRotation;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] aoS = new int[PointerRotation.values().length];
    public static final /* synthetic */ int[] auk = new int[TutorialAction.values().length];

    static {
        aoS[PointerRotation.TOP_TO_BOTTOM.ordinal()] = 1;
        aoS[PointerRotation.BOTTOM_TO_TOP.ordinal()] = 2;
        auk[TutorialAction.PRACTICE_BALANCE.ordinal()] = 1;
        auk[TutorialAction.TIME_SCALE.ordinal()] = 2;
        auk[TutorialAction.ADD_TAB.ordinal()] = 3;
        auk[TutorialAction.CHOOSE_INSTRUMENT.ordinal()] = 4;
        auk[TutorialAction.CHOOSE_ASSET.ordinal()] = 5;
        auk[TutorialAction.CALL_PUT.ordinal()] = 6;
        auk[TutorialAction.CALL_PUT_ANOTHER_INSTRUMENT.ordinal()] = 7;
        auk[TutorialAction.CHART_TYPE.ordinal()] = 8;
        auk[TutorialAction.EDUCATIONAL_VIDEOS.ordinal()] = 9;
    }
}
