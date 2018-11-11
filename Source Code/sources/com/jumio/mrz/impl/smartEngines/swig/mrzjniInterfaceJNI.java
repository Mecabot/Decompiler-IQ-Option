package com.jumio.mrz.impl.smartEngines.swig;

public class mrzjniInterfaceJNI {
    public static final native long MrzDateField_SWIGUpcast(long j);

    public static final native long MrzDateField_getAsMrzDate(long j, MrzDateField mrzDateField);

    public static final native int MrzDate_getDay(long j, MrzDate mrzDate);

    public static final native int MrzDate_getMonth(long j, MrzDate mrzDate);

    public static final native int MrzDate_getYear(long j, MrzDate mrzDate);

    public static final native boolean MrzDate_isDayPresent(long j, MrzDate mrzDate);

    public static final native boolean MrzDate_isMonthPresent(long j, MrzDate mrzDate);

    public static final native boolean MrzDate_isYearPresent(long j, MrzDate mrzDate);

    public static final native void MrzDate_setDay(long j, MrzDate mrzDate, int i);

    public static final native void MrzDate_setMonth(long j, MrzDate mrzDate, int i);

    public static final native void MrzDate_setYear(long j, MrzDate mrzDate, int i);

    public static final native long MrzEngineInternalSettings_createFromFilesystem(String str);

    public static final native double MrzEngineSessionHelpers_get_optimal_aspect_ratio(long j, MrzEngineSessionHelpers mrzEngineSessionHelpers);

    public static final native void MrzEngineSessionHelpers_set_optimal_aspect_ratio(long j, MrzEngineSessionHelpers mrzEngineSessionHelpers, double d);

    public static final native boolean MrzEngineSessionSettings_get_cnis_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_m3z_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_mrp_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_mrva_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_mrvb_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_mrvrus_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native int MrzEngineSessionSettings_get_number_of_threads(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_postprocess(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_recognize_in_parallel(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_reject_by_focus(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_reject_by_output(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_reject_by_segmentation(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_segment_best_effort(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_should_segment_in_parallel(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_td1_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native boolean MrzEngineSessionSettings_get_td2_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native void MrzEngineSessionSettings_set_cnis_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_m3z_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_mrp_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_mrva_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_mrvb_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_mrvrus_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_number_of_threads(long j, MrzEngineSessionSettings mrzEngineSessionSettings, int i);

    public static final native void MrzEngineSessionSettings_set_should_postprocess(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_should_recognize_in_parallel(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_should_reject_by_focus(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_should_reject_by_output(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_should_reject_by_segmentation(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_should_segment_best_effort(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_should_segment_in_parallel(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_td1_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngineSessionSettings_set_td2_support_enabled(long j, MrzEngineSessionSettings mrzEngineSessionSettings, boolean z);

    public static final native void MrzEngine_FeedImageFile__SWIG_0(long j, MrzEngine mrzEngine, String str, int i);

    public static final native void MrzEngine_FeedImageFile__SWIG_1(long j, MrzEngine mrzEngine, String str);

    public static final native void MrzEngine_FeedUncompressedImageData__SWIG_0(long j, MrzEngine mrzEngine, byte[] bArr, int i, int i2, int i3, int i4, long j2, MrzRect mrzRect, int i5);

    public static final native void MrzEngine_FeedUncompressedImageData__SWIG_1(long j, MrzEngine mrzEngine, byte[] bArr, int i, int i2, int i3, int i4, long j2, MrzRect mrzRect);

    public static final native void MrzEngine_FeedUncompressedYUVImageData__SWIG_0(long j, MrzEngine mrzEngine, byte[] bArr, int i, int i2, int i3, long j2, MrzRect mrzRect, int i4);

    public static final native void MrzEngine_FeedUncompressedYUVImageData__SWIG_1(long j, MrzEngine mrzEngine, byte[] bArr, int i, int i2, int i3, long j2, MrzRect mrzRect);

    public static final native void MrzEngine_InitializeSession__SWIG_0(long j, MrzEngine mrzEngine, long j2, StreamReporterInterface streamReporterInterface, long j3, MrzEngineSessionHelpers mrzEngineSessionHelpers, long j4, MrzEngineSessionSettings mrzEngineSessionSettings);

    public static final native void MrzEngine_InitializeSession__SWIG_1(long j, MrzEngine mrzEngine, long j2, StreamReporterInterface streamReporterInterface, long j3, MrzEngineSessionHelpers mrzEngineSessionHelpers);

    public static final native void MrzEngine_InitializeSession__SWIG_2(long j, MrzEngine mrzEngine, long j2, StreamReporterInterface streamReporterInterface);

    public static final native void MrzEngine_TerminateSession(long j, MrzEngine mrzEngine);

    public static final native int MrzField_calculateChecksum(long j, MrzField mrzField);

    public static final native String MrzField_getAsString(long j, MrzField mrzField);

    public static final native long MrzField_getChecksumOcrChar(long j, MrzField mrzField);

    public static final native double MrzField_getConfidence(long j, MrzField mrzField);

    public static final native long MrzField_getOcrString(long j, MrzField mrzField);

    public static final native boolean MrzField_hasChecksumOcrChar(long j, MrzField mrzField);

    public static final native boolean MrzField_hasCorrectChecksum(long j, MrzField mrzField);

    public static final native boolean MrzField_isAccepted(long j, MrzField mrzField);

    public static final native float MrzImageCheck_computeFlashConfidence(byte[] bArr, int i, int i2, int i3, int i4);

    public static final native int MrzImageCheck_computeFocusConfidence(byte[] bArr, int i, int i2, int i3, int i4);

    public static final native boolean MrzImageCheck_isFlashNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native boolean MrzImageCheck_isRefocusNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native void MrzOcrCharVariantVector_add(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector, long j2, MrzOcrCharVariant mrzOcrCharVariant);

    public static final native long MrzOcrCharVariantVector_capacity(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector);

    public static final native void MrzOcrCharVariantVector_clear(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector);

    public static final native long MrzOcrCharVariantVector_get(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector, int i);

    public static final native boolean MrzOcrCharVariantVector_isEmpty(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector);

    public static final native void MrzOcrCharVariantVector_reserve(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector, long j2);

    public static final native void MrzOcrCharVariantVector_set(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector, int i, long j2, MrzOcrCharVariant mrzOcrCharVariant);

    public static final native long MrzOcrCharVariantVector_size(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector);

    public static final native char MrzOcrCharVariant_getCharacter(long j, MrzOcrCharVariant mrzOcrCharVariant);

    public static final native double MrzOcrCharVariant_getConfidence(long j, MrzOcrCharVariant mrzOcrCharVariant);

    public static final native void MrzOcrCharVector_add(long j, MrzOcrCharVector mrzOcrCharVector, long j2, MrzOcrChar mrzOcrChar);

    public static final native long MrzOcrCharVector_capacity(long j, MrzOcrCharVector mrzOcrCharVector);

    public static final native void MrzOcrCharVector_clear(long j, MrzOcrCharVector mrzOcrCharVector);

    public static final native long MrzOcrCharVector_get(long j, MrzOcrCharVector mrzOcrCharVector, int i);

    public static final native boolean MrzOcrCharVector_isEmpty(long j, MrzOcrCharVector mrzOcrCharVector);

    public static final native void MrzOcrCharVector_reserve(long j, MrzOcrCharVector mrzOcrCharVector, long j2);

    public static final native void MrzOcrCharVector_set(long j, MrzOcrCharVector mrzOcrCharVector, int i, long j2, MrzOcrChar mrzOcrChar);

    public static final native long MrzOcrCharVector_size(long j, MrzOcrCharVector mrzOcrCharVector);

    public static final native char MrzOcrChar_GetChar(long j, MrzOcrChar mrzOcrChar);

    public static final native long MrzOcrChar_getOcrCharVariants(long j, MrzOcrChar mrzOcrChar);

    public static final native boolean MrzOcrChar_isCorrected(long j, MrzOcrChar mrzOcrChar);

    public static final native boolean MrzOcrChar_isFoundInDictionary(long j, MrzOcrChar mrzOcrChar);

    public static final native boolean MrzOcrChar_isHighlighted(long j, MrzOcrChar mrzOcrChar);

    public static final native void MrzOcrStringVector_add(long j, MrzOcrStringVector mrzOcrStringVector, long j2, MrzOcrString mrzOcrString);

    public static final native long MrzOcrStringVector_capacity(long j, MrzOcrStringVector mrzOcrStringVector);

    public static final native void MrzOcrStringVector_clear(long j, MrzOcrStringVector mrzOcrStringVector);

    public static final native long MrzOcrStringVector_get(long j, MrzOcrStringVector mrzOcrStringVector, int i);

    public static final native boolean MrzOcrStringVector_isEmpty(long j, MrzOcrStringVector mrzOcrStringVector);

    public static final native void MrzOcrStringVector_reserve(long j, MrzOcrStringVector mrzOcrStringVector, long j2);

    public static final native void MrzOcrStringVector_set(long j, MrzOcrStringVector mrzOcrStringVector, int i, long j2, MrzOcrString mrzOcrString);

    public static final native long MrzOcrStringVector_size(long j, MrzOcrStringVector mrzOcrStringVector);

    public static final native long MrzOcrString_getOcrChars(long j, MrzOcrString mrzOcrString);

    public static final native void MrzRectMatrix_add(long j, MrzRectMatrix mrzRectMatrix, long j2, MrzRectVector mrzRectVector);

    public static final native long MrzRectMatrix_capacity(long j, MrzRectMatrix mrzRectMatrix);

    public static final native void MrzRectMatrix_clear(long j, MrzRectMatrix mrzRectMatrix);

    public static final native long MrzRectMatrix_get(long j, MrzRectMatrix mrzRectMatrix, int i);

    public static final native boolean MrzRectMatrix_isEmpty(long j, MrzRectMatrix mrzRectMatrix);

    public static final native void MrzRectMatrix_reserve(long j, MrzRectMatrix mrzRectMatrix, long j2);

    public static final native void MrzRectMatrix_set(long j, MrzRectMatrix mrzRectMatrix, int i, long j2, MrzRectVector mrzRectVector);

    public static final native long MrzRectMatrix_size(long j, MrzRectMatrix mrzRectMatrix);

    public static final native void MrzRectVector_add(long j, MrzRectVector mrzRectVector, long j2, MrzRect mrzRect);

    public static final native long MrzRectVector_capacity(long j, MrzRectVector mrzRectVector);

    public static final native void MrzRectVector_clear(long j, MrzRectVector mrzRectVector);

    public static final native long MrzRectVector_get(long j, MrzRectVector mrzRectVector, int i);

    public static final native boolean MrzRectVector_isEmpty(long j, MrzRectVector mrzRectVector);

    public static final native void MrzRectVector_reserve(long j, MrzRectVector mrzRectVector, long j2);

    public static final native void MrzRectVector_set(long j, MrzRectVector mrzRectVector, int i, long j2, MrzRect mrzRect);

    public static final native long MrzRectVector_size(long j, MrzRectVector mrzRectVector);

    public static final native int MrzRect_getHeight(long j, MrzRect mrzRect);

    public static final native int MrzRect_getWidth(long j, MrzRect mrzRect);

    public static final native int MrzRect_getX(long j, MrzRect mrzRect);

    public static final native int MrzRect_getY(long j, MrzRect mrzRect);

    public static final native void MrzRect_setHeight(long j, MrzRect mrzRect, int i);

    public static final native void MrzRect_setWidth(long j, MrzRect mrzRect, int i);

    public static final native void MrzRect_setX(long j, MrzRect mrzRect, int i);

    public static final native void MrzRect_setY(long j, MrzRect mrzRect, int i);

    public static final native long MrzResult_getBirthdate(long j, MrzResult mrzResult);

    public static final native long MrzResult_getCountry(long j, MrzResult mrzResult);

    public static final native long MrzResult_getDepartmentCode(long j, MrzResult mrzResult);

    public static final native long MrzResult_getDocNum(long j, MrzResult mrzResult);

    public static final native long MrzResult_getDocNumFormatted(long j, MrzResult mrzResult);

    public static final native long MrzResult_getDocType(long j, MrzResult mrzResult);

    public static final native long MrzResult_getDocTypeCode(long j, MrzResult mrzResult);

    public static final native long MrzResult_getExpidate(long j, MrzResult mrzResult);

    public static final native long MrzResult_getFirstName(long j, MrzResult mrzResult);

    public static final native long MrzResult_getIssuedate(long j, MrzResult mrzResult);

    public static final native long MrzResult_getMrzCompositeCheckDigit(long j, MrzResult mrzResult);

    public static final native long MrzResult_getMrzLines(long j, MrzResult mrzResult);

    public static final native long MrzResult_getMrzOcrLines(long j, MrzResult mrzResult);

    public static final native long MrzResult_getNationality(long j, MrzResult mrzResult);

    public static final native long MrzResult_getOptData1(long j, MrzResult mrzResult);

    public static final native long MrzResult_getOptData2(long j, MrzResult mrzResult);

    public static final native long MrzResult_getSecondName(long j, MrzResult mrzResult);

    public static final native long MrzResult_getSex(long j, MrzResult mrzResult);

    public static final native boolean MrzResult_hasCorrectCompositeChecksum(long j, MrzResult mrzResult);

    public static final native void MrzResult_setBirthdate(long j, MrzResult mrzResult, long j2, MrzDateField mrzDateField);

    public static final native void MrzResult_setCountry(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setDepartmentCode(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setDocNum(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setDocNumFormatted(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setDocType(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setDocTypeCode(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setExpidate(long j, MrzResult mrzResult, long j2, MrzDateField mrzDateField);

    public static final native void MrzResult_setFirstName(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setIssuedate(long j, MrzResult mrzResult, long j2, MrzDateField mrzDateField);

    public static final native void MrzResult_setMrzCompositeCheckDigit(long j, MrzResult mrzResult, long j2, MrzOcrChar mrzOcrChar);

    public static final native void MrzResult_setMrzLines(long j, MrzResult mrzResult, long j2, StringVector stringVector);

    public static final native void MrzResult_setMrzOcrLines(long j, MrzResult mrzResult, long j2, MrzOcrStringVector mrzOcrStringVector);

    public static final native void MrzResult_setNationality(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setOptData1(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setOptData2(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setSecondName(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void MrzResult_setSex(long j, MrzResult mrzResult, long j2, MrzField mrzField);

    public static final native void StreamReporterInterface_SnapshotProcessed(long j, StreamReporterInterface streamReporterInterface, long j2, MrzResult mrzResult, boolean z);

    public static final native void StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_0(long j, StreamReporterInterface streamReporterInterface);

    public static final native void StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_1(long j, StreamReporterInterface streamReporterInterface, String str);

    public static final native void StreamReporterInterface_SnapshotRejected__SWIG_0(long j, StreamReporterInterface streamReporterInterface);

    public static final native void StreamReporterInterface_SnapshotRejected__SWIG_1(long j, StreamReporterInterface streamReporterInterface, String str);

    public static final native void StreamReporterInterface_SymbolRectsFound(long j, StreamReporterInterface streamReporterInterface, long j2, MrzRectMatrix mrzRectMatrix);

    public static final native void StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(long j, StreamReporterInterface streamReporterInterface, long j2, MrzRectMatrix mrzRectMatrix);

    public static final native void StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessedSwigExplicitStreamReporterInterface(long j, StreamReporterInterface streamReporterInterface, long j2, MrzRectMatrix mrzRectMatrix);

    public static final native void StreamReporterInterface_SymbolRectsFoundSwigExplicitStreamReporterInterface(long j, StreamReporterInterface streamReporterInterface, long j2, MrzRectMatrix mrzRectMatrix);

    public static final native void StreamReporterInterface_change_ownership(StreamReporterInterface streamReporterInterface, long j, boolean z);

    public static final native void StreamReporterInterface_director_connect(StreamReporterInterface streamReporterInterface, long j, boolean z, boolean z2);

    public static final native void StringVector_add(long j, StringVector stringVector, String str);

    public static final native long StringVector_capacity(long j, StringVector stringVector);

    public static final native void StringVector_clear(long j, StringVector stringVector);

    public static final native String StringVector_get(long j, StringVector stringVector, int i);

    public static final native boolean StringVector_isEmpty(long j, StringVector stringVector);

    public static final native void StringVector_reserve(long j, StringVector stringVector, long j2);

    public static final native void StringVector_set(long j, StringVector stringVector, int i, String str);

    public static final native long StringVector_size(long j, StringVector stringVector);

    public static final native void delete_MrzDate(long j);

    public static final native void delete_MrzDateField(long j);

    public static final native void delete_MrzEngine(long j);

    public static final native void delete_MrzEngineInternalSettings(long j);

    public static final native void delete_MrzEngineSessionHelpers(long j);

    public static final native void delete_MrzEngineSessionSettings(long j);

    public static final native void delete_MrzField(long j);

    public static final native void delete_MrzImageCheck(long j);

    public static final native void delete_MrzOcrChar(long j);

    public static final native void delete_MrzOcrCharVariant(long j);

    public static final native void delete_MrzOcrCharVariantVector(long j);

    public static final native void delete_MrzOcrCharVector(long j);

    public static final native void delete_MrzOcrString(long j);

    public static final native void delete_MrzOcrStringVector(long j);

    public static final native void delete_MrzRect(long j);

    public static final native void delete_MrzRectMatrix(long j);

    public static final native void delete_MrzRectVector(long j);

    public static final native void delete_MrzResult(long j);

    public static final native void delete_StreamReporterInterface(long j);

    public static final native void delete_StringVector(long j);

    public static final native long new_MrzDateField__SWIG_0();

    public static final native long new_MrzDateField__SWIG_1(long j, MrzDate mrzDate, boolean z, double d);

    public static final native long new_MrzDateField__SWIG_2(long j, MrzDate mrzDate, boolean z);

    public static final native long new_MrzDateField__SWIG_3(long j, MrzDate mrzDate);

    public static final native long new_MrzDateField__SWIG_4(long j, MrzDate mrzDate, boolean z, double d, long j2, MrzOcrString mrzOcrString, long j3, MrzOcrChar mrzOcrChar);

    public static final native long new_MrzDate__SWIG_0(int i, int i2, int i3);

    public static final native long new_MrzDate__SWIG_1(int i, int i2);

    public static final native long new_MrzDate__SWIG_2(int i);

    public static final native long new_MrzDate__SWIG_3();

    public static final native long new_MrzDate__SWIG_4(long j, MrzDate mrzDate);

    public static final native long new_MrzEngine(long j, MrzEngineInternalSettings mrzEngineInternalSettings);

    public static final native long new_MrzEngineSessionHelpers();

    public static final native long new_MrzEngineSessionSettings();

    public static final native long new_MrzField__SWIG_0();

    public static final native long new_MrzField__SWIG_1(String str, boolean z, double d);

    public static final native long new_MrzField__SWIG_2(String str, boolean z);

    public static final native long new_MrzField__SWIG_3(String str);

    public static final native long new_MrzField__SWIG_4(String str, boolean z, double d, long j, MrzOcrString mrzOcrString, long j2, MrzOcrChar mrzOcrChar);

    public static final native long new_MrzImageCheck();

    public static final native long new_MrzOcrCharVariantVector__SWIG_0();

    public static final native long new_MrzOcrCharVariantVector__SWIG_1(long j);

    public static final native long new_MrzOcrCharVariant__SWIG_0();

    public static final native long new_MrzOcrCharVariant__SWIG_1(char c, double d);

    public static final native long new_MrzOcrCharVector__SWIG_0();

    public static final native long new_MrzOcrCharVector__SWIG_1(long j);

    public static final native long new_MrzOcrChar__SWIG_0();

    public static final native long new_MrzOcrChar__SWIG_1(long j, MrzOcrCharVariantVector mrzOcrCharVariantVector, boolean z, boolean z2, boolean z3);

    public static final native long new_MrzOcrStringVector__SWIG_0();

    public static final native long new_MrzOcrStringVector__SWIG_1(long j);

    public static final native long new_MrzOcrString__SWIG_0();

    public static final native long new_MrzOcrString__SWIG_1(long j, MrzOcrCharVector mrzOcrCharVector);

    public static final native long new_MrzRectMatrix__SWIG_0();

    public static final native long new_MrzRectMatrix__SWIG_1(long j);

    public static final native long new_MrzRectVector__SWIG_0();

    public static final native long new_MrzRectVector__SWIG_1(long j);

    public static final native long new_MrzRect__SWIG_0(int i, int i2, int i3, int i4);

    public static final native long new_MrzRect__SWIG_1(int i, int i2, int i3);

    public static final native long new_MrzRect__SWIG_2(int i, int i2);

    public static final native long new_MrzRect__SWIG_3(int i);

    public static final native long new_MrzRect__SWIG_4();

    public static final native long new_MrzResult__SWIG_0();

    public static final native long new_MrzResult__SWIG_1(long j, MrzResult mrzResult);

    public static final native long new_StreamReporterInterface();

    public static final native long new_StringVector__SWIG_0();

    public static final native long new_StringVector__SWIG_1(long j);

    private static final native void swig_module_init();

    public static void SwigDirector_StreamReporterInterface_SymbolRectsFound(StreamReporterInterface streamReporterInterface, long j) {
        streamReporterInterface.SymbolRectsFound(new MrzRectMatrix(j, false));
    }

    public static void SwigDirector_StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(StreamReporterInterface streamReporterInterface, long j) {
        streamReporterInterface.SymbolRectsFoundAfterSnapshotProcessed(new MrzRectMatrix(j, false));
    }

    public static void SwigDirector_StreamReporterInterface_SnapshotRejected__SWIG_0(StreamReporterInterface streamReporterInterface) {
        streamReporterInterface.SnapshotRejected();
    }

    public static void SwigDirector_StreamReporterInterface_SnapshotRejected__SWIG_1(StreamReporterInterface streamReporterInterface, String str) {
        streamReporterInterface.SnapshotRejected(str);
    }

    public static void SwigDirector_StreamReporterInterface_SnapshotProcessed(StreamReporterInterface streamReporterInterface, long j, boolean z) {
        streamReporterInterface.SnapshotProcessed(new MrzResult(j, false), z);
    }

    static {
        swig_module_init();
    }
}
