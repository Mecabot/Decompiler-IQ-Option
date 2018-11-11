package com.jumio.clientlib.impl.templatematcher;

public class jniTemplateMatcher {
    public static SWIGTYPE_p_FrameProcessorPtr make_async(SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr) {
        return new SWIGTYPE_p_FrameProcessorPtr(jniTemplateMatcherJNI.make_async(SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr)), true);
    }

    public static String GetCollectedPerformanceStatistics() {
        return jniTemplateMatcherJNI.GetCollectedPerformanceStatistics();
    }
}
