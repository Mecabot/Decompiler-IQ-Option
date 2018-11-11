package com.jumio.clientlib.impl.templatematcher;

public class jniTemplateMatcherJNI {
    public static final native void FrameProcessingCallbackTemplateMatcher_change_ownership(FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j, boolean z);

    public static final native void FrameProcessingCallbackTemplateMatcher_director_connect(FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j, boolean z, boolean z2);

    public static final native void FrameProcessingCallbackTemplateMatcher_finalResult(long j, FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j2, FrameQueue frameQueue, long j3, TemplateInfo templateInfo);

    public static final native void FrameProcessingCallbackTemplateMatcher_intermediateResult(long j, FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j2, FrameQueue frameQueue, long j3, TemplateInfo templateInfo);

    public static final native void FrameProcessingCallbackTemplateMatcher_noResult(long j, FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j2, FrameQueue frameQueue);

    public static final native void FrameProcessingCallbackTemplateMatcher_noResultSwigExplicitFrameProcessingCallbackTemplateMatcher(long j, FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j2, FrameQueue frameQueue);

    public static final native long FrameProcessingSettingsTemplateMatcher_getClusteringSettings(long j, FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher);

    public static final native int FrameProcessingSettingsTemplateMatcher_getMaxKeyPointsToDetect(long j, FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher);

    public static final native int FrameProcessingSettingsTemplateMatcher_getNumImagesToKeep(long j, FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher);

    public static final native int FrameProcessingSettingsTemplateMatcher_getNumSuccessMatchesToComplete(long j, FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher);

    public static final native boolean FrameProcessingSettingsTemplateMatcher_getUseClustring(long j, FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher);

    public static final native void FrameProcessorManager_pushFrame(long j, FrameProcessorManager frameProcessorManager, byte[] bArr, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static final native void FrameProcessorManager_reset(long j, FrameProcessorManager frameProcessorManager);

    public static final native long FrameProcessorTemplateMatcher_SWIGSmartPtrUpcast(long j);

    public static final native boolean FrameProcessorTemplateMatcher_addTemplatesFromBinaryFile(long j, FrameProcessorTemplateMatcher frameProcessorTemplateMatcher, String str);

    public static final native void FrameProcessorTemplateMatcher_clearAllTemplates(long j, FrameProcessorTemplateMatcher frameProcessorTemplateMatcher);

    public static final native boolean FrameProcessorTemplateMatcher_detectSingleFrame(long j, FrameProcessorTemplateMatcher frameProcessorTemplateMatcher, long j2, LibImage libImage, long j3, TemplateInfo templateInfo);

    public static final native void FrameProcessorTemplateMatcher_discardFrameByID(long j, FrameProcessorTemplateMatcher frameProcessorTemplateMatcher, int i);

    public static final native void FrameProcessor_pushFrame(long j, FrameProcessor frameProcessor, long j2, LibImage libImage);

    public static final native void FrameProcessor_reset(long j, FrameProcessor frameProcessor);

    public static final native void FrameQueue_clear(long j, FrameQueue frameQueue);

    public static final native void FrameQueue_getAllFrames(long j, FrameQueue frameQueue, long j2, FramesVector framesVector);

    public static final native long FrameQueue_getFrameByID(long j, FrameQueue frameQueue, int i);

    public static final native void FrameQueue_getFramesInRange(long j, FrameQueue frameQueue, int i, int i2, long j2, FramesVector framesVector);

    public static final native long FrameQueue_lastFrame(long j, FrameQueue frameQueue);

    public static final native void FrameQueue_pushFrame(long j, FrameQueue frameQueue, long j2, LibImage libImage);

    public static final native boolean FrameQueue_removeFrameByID(long j, FrameQueue frameQueue, int i);

    public static final native long FrameQueue_size(long j, FrameQueue frameQueue);

    public static final native void FramesVector_add(long j, FramesVector framesVector, long j2, LibImage libImage);

    public static final native long FramesVector_capacity(long j, FramesVector framesVector);

    public static final native void FramesVector_clear(long j, FramesVector framesVector);

    public static final native long FramesVector_get(long j, FramesVector framesVector, int i);

    public static final native boolean FramesVector_isEmpty(long j, FramesVector framesVector);

    public static final native void FramesVector_reserve(long j, FramesVector framesVector, long j2);

    public static final native void FramesVector_set(long j, FramesVector framesVector, int i, long j2, LibImage libImage);

    public static final native long FramesVector_size(long j, FramesVector framesVector);

    public static final native String GetCollectedPerformanceStatistics();

    public static final native int HierarchicalClusteringSettings_getBranching(long j, HierarchicalClusteringSettings hierarchicalClusteringSettings);

    public static final native int HierarchicalClusteringSettings_getLeafMaxSize(long j, HierarchicalClusteringSettings hierarchicalClusteringSettings);

    public static final native int HierarchicalClusteringSettings_getMaxChecks(long j, HierarchicalClusteringSettings hierarchicalClusteringSettings);

    public static final native int HierarchicalClusteringSettings_getTrees(long j, HierarchicalClusteringSettings hierarchicalClusteringSettings);

    public static final native void ImgWarp_warp(byte[] bArr, long j, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, byte[] bArr2, int i4, int i5);

    public static final native int LibImage_getChannelDepth(long j, LibImage libImage);

    public static final native int LibImage_getChannels(long j, LibImage libImage);

    public static final native int LibImage_getFormat(long j, LibImage libImage);

    public static final native long LibImage_getFrameBuffer__SWIG_0(long j, LibImage libImage);

    public static final native void LibImage_getFrameBuffer__SWIG_1(long j, LibImage libImage, byte[] bArr);

    public static final native int LibImage_getFrameIndex(long j, LibImage libImage);

    public static final native int LibImage_getHeight(long j, LibImage libImage);

    public static final native long LibImage_getStride(long j, LibImage libImage);

    public static final native int LibImage_getTimeStamp(long j, LibImage libImage);

    public static final native int LibImage_getWidth(long j, LibImage libImage);

    public static final native void StringVector_add(long j, StringVector stringVector, String str);

    public static final native long StringVector_capacity(long j, StringVector stringVector);

    public static final native void StringVector_clear(long j, StringVector stringVector);

    public static final native String StringVector_get(long j, StringVector stringVector, int i);

    public static final native boolean StringVector_isEmpty(long j, StringVector stringVector);

    public static final native void StringVector_reserve(long j, StringVector stringVector, long j2);

    public static final native void StringVector_set(long j, StringVector stringVector, int i, String str);

    public static final native long StringVector_size(long j, StringVector stringVector);

    public static final native void TemplateInfo_change_ownership(TemplateInfo templateInfo, long j, boolean z);

    public static final native void TemplateInfo_director_connect(TemplateInfo templateInfo, long j, boolean z, boolean z2);

    public static final native String TemplateInfo_getCountry(long j, TemplateInfo templateInfo);

    public static final native String TemplateInfo_getDocumentSubType(long j, TemplateInfo templateInfo);

    public static final native String TemplateInfo_getDocumentType(long j, TemplateInfo templateInfo);

    public static final native int TemplateInfo_getFrameIndex(long j, TemplateInfo templateInfo);

    public static final native int TemplateInfo_getMatchesCount(long j, TemplateInfo templateInfo);

    public static final native long TemplateInfo_getPolygon(long j, TemplateInfo templateInfo);

    public static final native String TemplateInfo_getRegion(long j, TemplateInfo templateInfo);

    public static final native String TemplateInfo_getState(long j, TemplateInfo templateInfo);

    public static final native int TemplateInfo_getTemplateHeight(long j, TemplateInfo templateInfo);

    public static final native int TemplateInfo_getTemplateWidth(long j, TemplateInfo templateInfo);

    public static final native int TemplateInfo_getTrainImageIndex(long j, TemplateInfo templateInfo);

    public static final native double TemplateInfo_getTransformError(long j, TemplateInfo templateInfo);

    public static final native void TemplateInfo_setCountry(long j, TemplateInfo templateInfo, String str);

    public static final native void TemplateInfo_setDocumentSubType(long j, TemplateInfo templateInfo, String str);

    public static final native void TemplateInfo_setDocumentType(long j, TemplateInfo templateInfo, String str);

    public static final native void TemplateInfo_setFrameIndex(long j, TemplateInfo templateInfo, int i);

    public static final native void TemplateInfo_setHomography(long j, TemplateInfo templateInfo, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static final native void TemplateInfo_setMatchesCount(long j, TemplateInfo templateInfo, int i);

    public static final native void TemplateInfo_setPolygon(long j, TemplateInfo templateInfo, long j2, TemplatePolygon templatePolygon);

    public static final native void TemplateInfo_setRegion(long j, TemplateInfo templateInfo, String str);

    public static final native void TemplateInfo_setState(long j, TemplateInfo templateInfo, String str);

    public static final native void TemplateInfo_setTemplateHeight(long j, TemplateInfo templateInfo, int i);

    public static final native void TemplateInfo_setTemplateWidth(long j, TemplateInfo templateInfo, int i);

    public static final native void TemplateInfo_setTrainImageIndex(long j, TemplateInfo templateInfo, int i);

    public static final native void TemplateInfo_setTransformError(long j, TemplateInfo templateInfo, double d);

    public static final native float TemplatePolygon_getBLx(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getBLy(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getBRx(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getBRy(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getTLx(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getTLy(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getTRx(long j, TemplatePolygon templatePolygon);

    public static final native float TemplatePolygon_getTRy(long j, TemplatePolygon templatePolygon);

    public static final native void TemplatePolygon_setBLx(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setBLy(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setBRx(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setBRy(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setTLx(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setTLy(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setTRx(long j, TemplatePolygon templatePolygon, float f);

    public static final native void TemplatePolygon_setTRy(long j, TemplatePolygon templatePolygon, float f);

    public static final native long Uint8Array_cast(long j, Uint8Array uint8Array);

    public static final native long Uint8Array_frompointer(long j);

    public static final native short Uint8Array_getitem(long j, Uint8Array uint8Array, int i);

    public static final native void Uint8Array_setitem(long j, Uint8Array uint8Array, int i, short s);

    public static final native void delete_FrameProcessingSettingsTemplateMatcher(long j);

    public static final native void delete_FrameProcessor(long j);

    public static final native void delete_FrameProcessorManager(long j);

    public static final native void delete_FrameProcessorTemplateMatcher(long j);

    public static final native void delete_FrameQueue(long j);

    public static final native void delete_FramesVector(long j);

    public static final native void delete_HierarchicalClusteringSettings(long j);

    public static final native void delete_ImgWarp(long j);

    public static final native void delete_LibImage(long j);

    public static final native void delete_StringVector(long j);

    public static final native void delete_TemplateInfo(long j);

    public static final native void delete_TemplatePolygon(long j);

    public static final native void delete_Uint8Array(long j);

    public static final native long make_async(long j);

    public static final native long new_FrameProcessingCallbackTemplateMatcher();

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_0(int i, boolean z, long j, HierarchicalClusteringSettings hierarchicalClusteringSettings, int i2, int i3);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_1(int i, boolean z, long j, HierarchicalClusteringSettings hierarchicalClusteringSettings, int i2);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_2(int i, boolean z, long j, HierarchicalClusteringSettings hierarchicalClusteringSettings);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_3(int i, boolean z);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_4(int i);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_5();

    public static final native long new_FrameProcessorManager__SWIG_0(long j);

    public static final native long new_FrameProcessorManager__SWIG_1(long j, long j2);

    public static final native long new_FrameProcessorManager__SWIG_2(long j, long j2, long j3);

    public static final native long new_FrameProcessorTemplateMatcher(long j, FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher, long j2, FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher);

    public static final native long new_FrameQueue(long j);

    public static final native long new_FramesVector__SWIG_0();

    public static final native long new_FramesVector__SWIG_1(long j);

    public static final native long new_HierarchicalClusteringSettings__SWIG_0(int i, int i2, int i3, int i4);

    public static final native long new_HierarchicalClusteringSettings__SWIG_1(int i, int i2, int i3);

    public static final native long new_HierarchicalClusteringSettings__SWIG_2(int i, int i2);

    public static final native long new_HierarchicalClusteringSettings__SWIG_3(int i);

    public static final native long new_HierarchicalClusteringSettings__SWIG_4();

    public static final native long new_ImgWarp();

    public static final native long new_LibImage__SWIG_0(byte[] bArr, int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, boolean z);

    public static final native long new_LibImage__SWIG_1(byte[] bArr, int i, int i2, int i3, long j, int i4, int i5, int i6, int i7);

    public static final native long new_StringVector__SWIG_0();

    public static final native long new_StringVector__SWIG_1(long j);

    public static final native long new_TemplateInfo__SWIG_0();

    public static final native long new_TemplateInfo__SWIG_1(int i, String str, String str2, String str3, String str4, long j, TemplatePolygon templatePolygon, int i2, double d);

    public static final native long new_TemplatePolygon__SWIG_0();

    public static final native long new_TemplatePolygon__SWIG_1(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    public static final native long new_Uint8Array(int i);

    private static final native void swig_module_init();

    public static void SwigDirector_FrameProcessingCallbackTemplateMatcher_intermediateResult(FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j, long j2) {
        frameProcessingCallbackTemplateMatcher.intermediateResult(new FrameQueue(j, false), new TemplateInfo(j2, false));
    }

    public static void SwigDirector_FrameProcessingCallbackTemplateMatcher_finalResult(FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j, long j2) {
        frameProcessingCallbackTemplateMatcher.finalResult(new FrameQueue(j, false), new TemplateInfo(j2, false));
    }

    public static void SwigDirector_FrameProcessingCallbackTemplateMatcher_noResult(FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher, long j) {
        frameProcessingCallbackTemplateMatcher.noResult(new FrameQueue(j, false));
    }

    static {
        swig_module_init();
    }
}
