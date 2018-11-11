package com.jumio.ocr.impl.smartEngines.swig;

import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName;

public class jniInterfaceJNI {
    public static final native int ConversionUtils_convertImage(byte[] bArr, int i, byte[] bArr2);

    public static final native long DetectionEngine_processRawImage(long j, DetectionEngine detectionEngine, byte[] bArr, int i, int i2, int i3, int i4);

    public static final native long DetectionEngine_processRawYUVImage(long j, DetectionEngine detectionEngine, byte[] bArr, int i, int i2, int i3, int i4);

    public static final native void DetectionEngine_resetSession(long j, DetectionEngine detectionEngine);

    public static final native long DetectionInternalSettingsFactory_createFromFileSystem(String str);

    public static final native void DetectionInternalSettings_change_ownership(DetectionInternalSettings detectionInternalSettings, long j, boolean z);

    public static final native void DetectionInternalSettings_director_connect(DetectionInternalSettings detectionInternalSettings, long j, boolean z, boolean z2);

    public static final native int DetectionResult_getCardImageQualityScore(long j, DetectionResult detectionResult);

    public static final native long DetectionResult_getCardQuadrangle(long j, DetectionResult detectionResult);

    public static final native long DetectionResult_getExposurePointOfInterest(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_getFlashTurnOn(long j, DetectionResult detectionResult);

    public static final native long DetectionResult_getFocusPointOfInterest(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasBottomOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasLeftOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasRightOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasTopOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_isCardImageOfGoodQuality(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_isCardInRoi(long j, DetectionResult detectionResult);

    public static final native double DetectionSettings_getRoiBottomMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiHorizontalDeviation(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiLeftMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiRightMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiTopMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiVerticalDeviation(long j, DetectionSettings detectionSettings);

    public static final native void DetectionSettings_setRoiBottomMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiHorizontalDeviation(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiLeftMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiRightMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiTopMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiVerticalDeviation(long j, DetectionSettings detectionSettings, double d);

    public static final native float ImageCheck_computeFlashConfidence(byte[] bArr, int i, int i2, int i3, int i4);

    public static final native int ImageCheck_computeFocusConfidence(byte[] bArr, int i, int i2, int i3, int i4);

    public static final native boolean ImageCheck_isFlashNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native boolean ImageCheck_isRefocusNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native int OcrCardTypeAirplus_get();

    public static final native int OcrCardTypeAmericanExpress_get();

    public static final native int OcrCardTypeAtosPrivateLabel_get();

    public static final native int OcrCardTypeAura_get();

    public static final native int OcrCardTypeBpFuelCard_get();

    public static final native int OcrCardTypeChinaUnionPay_get();

    public static final native int OcrCardTypeChjonesFuelCard_get();

    public static final native int OcrCardTypeDankort_get();

    public static final native int OcrCardTypeDinersClubInternational_get();

    public static final native int OcrCardTypeDiscover_get();

    public static final native int OcrCardTypeElo_get();

    public static final native int OcrCardTypeEuroshellFuelCard_get();

    public static final native int OcrCardTypeGeCapital_get();

    public static final native int OcrCardTypeGlobalBc_get();

    public static final native int OcrCardTypeHipercard_get();

    public static final native int OcrCardTypeJcb_get();

    public static final native int OcrCardTypeLocalBrand_get();

    public static final native int OcrCardTypeLoyaltyCard_get();

    public static final native int OcrCardTypeLukoilFuelCard_get();

    public static final native int OcrCardTypeMaestro_get();

    public static final native int OcrCardTypeMastercard_get();

    public static final native int OcrCardTypeNspkMir_get();

    public static final native int OcrCardTypePhhFuelCard_get();

    public static final native int OcrCardTypePrivateLabelCard_get();

    public static final native int OcrCardTypePrvateLabelCard_get();

    public static final native int OcrCardTypeRbsGiftCard_get();

    public static final native int OcrCardTypeRedFuelCard_get();

    public static final native int OcrCardTypeRedLiquidFuelCard_get();

    public static final native int OcrCardTypeRupay_get();

    public static final native int OcrCardTypeSodexo_get();

    public static final native int OcrCardTypeStarRewards_get();

    public static final native int OcrCardTypeStarbucks_get();

    public static final native int OcrCardTypeTroy_get();

    public static final native int OcrCardTypeUkFuelCard_get();

    public static final native int OcrCardTypeUnknown_get();

    public static final native int OcrCardTypeVisa_get();

    public static final native void OcrCharStringVector_add(long j, OcrCharStringVector ocrCharStringVector, long j2, OcrCharVariants ocrCharVariants);

    public static final native long OcrCharStringVector_capacity(long j, OcrCharStringVector ocrCharStringVector);

    public static final native void OcrCharStringVector_clear(long j, OcrCharStringVector ocrCharStringVector);

    public static final native long OcrCharStringVector_get(long j, OcrCharStringVector ocrCharStringVector, int i);

    public static final native boolean OcrCharStringVector_isEmpty(long j, OcrCharStringVector ocrCharStringVector);

    public static final native void OcrCharStringVector_reserve(long j, OcrCharStringVector ocrCharStringVector, long j2);

    public static final native void OcrCharStringVector_set(long j, OcrCharStringVector ocrCharStringVector, int i, long j2, OcrCharVariants ocrCharVariants);

    public static final native long OcrCharStringVector_size(long j, OcrCharStringVector ocrCharStringVector);

    public static final native void OcrCharVariants_add(long j, OcrCharVariants ocrCharVariants, long j2, OcrChar ocrChar);

    public static final native long OcrCharVariants_get(long j, OcrCharVariants ocrCharVariants);

    public static final native int OcrCharVariants_getHighlightingMask(long j, OcrCharVariants ocrCharVariants);

    public static final native long OcrCharVariants_getQuadrangle(long j, OcrCharVariants ocrCharVariants);

    public static final native void OcrCharVector_add(long j, OcrCharVector ocrCharVector, long j2, OcrChar ocrChar);

    public static final native long OcrCharVector_capacity(long j, OcrCharVector ocrCharVector);

    public static final native void OcrCharVector_clear(long j, OcrCharVector ocrCharVector);

    public static final native long OcrCharVector_get(long j, OcrCharVector ocrCharVector, int i);

    public static final native boolean OcrCharVector_isEmpty(long j, OcrCharVector ocrCharVector);

    public static final native void OcrCharVector_reserve(long j, OcrCharVector ocrCharVector, long j2);

    public static final native void OcrCharVector_set(long j, OcrCharVector ocrCharVector, int i, long j2, OcrChar ocrChar);

    public static final native long OcrCharVector_size(long j, OcrCharVector ocrCharVector);

    public static final native char OcrChar_getCharacter(long j, OcrChar ocrChar);

    public static final native double OcrChar_getProbability(long j, OcrChar ocrChar);

    public static final native double OcrConfidence_getAverage(long j, OcrConfidence ocrConfidence);

    public static final native double OcrConfidence_getMinimum(long j, OcrConfidence ocrConfidence);

    public static final native void OcrEngineBaseSession_change_ownership(OcrEngineBaseSession ocrEngineBaseSession, long j, boolean z);

    public static final native float OcrEngineBaseSession_computeFlashConfidence(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3, int i4);

    public static final native int OcrEngineBaseSession_computeFocusConfidence(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3, int i4);

    public static final native void OcrEngineBaseSession_director_connect(OcrEngineBaseSession ocrEngineBaseSession, long j, boolean z, boolean z2);

    public static final native boolean OcrEngineBaseSession_isFlashRequired(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native boolean OcrEngineBaseSession_isRefocusRequired(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native long OcrEngineBaseSession_processUncompressedImageData__SWIG_0(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3, long j2, OcrEngineSettings ocrEngineSettings);

    public static final native long OcrEngineBaseSession_processUncompressedImageData__SWIG_1(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3);

    public static final native long OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3, long j2, OcrEngineSettings ocrEngineSettings);

    public static final native long OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1(long j, OcrEngineBaseSession ocrEngineBaseSession, byte[] bArr, int i, int i2, int i3);

    public static final native void OcrEngineBaseSession_resetSession(long j, OcrEngineBaseSession ocrEngineBaseSession);

    public static final native void OcrEngineBase_change_ownership(OcrEngineBase ocrEngineBase, long j, boolean z);

    public static final native long OcrEngineBase_createSession__SWIG_0(long j, OcrEngineBase ocrEngineBase, long j2, ResultAcceptorInterface resultAcceptorInterface);

    public static final native long OcrEngineBase_createSession__SWIG_1(long j, OcrEngineBase ocrEngineBase);

    public static final native void OcrEngineBase_director_connect(OcrEngineBase ocrEngineBase, long j, boolean z, boolean z2);

    public static final native int OcrEngineBase_getBuildNumber();

    public static final native long OcrEngineBase_getTimingStats();

    public static final native long OcrEngineInternalSettings_createFromFilesystem(String str);

    public static final native long OcrEngineSession_SWIGUpcast(long j);

    public static final native void OcrEngineSession_change_ownership(OcrEngineSession ocrEngineSession, long j, boolean z);

    public static final native void OcrEngineSession_director_connect(OcrEngineSession ocrEngineSession, long j, boolean z, boolean z2);

    public static final native long OcrEngineSession_processImageData__SWIG_0(long j, OcrEngineSession ocrEngineSession, byte[] bArr, long j2, OcrEngineSettings ocrEngineSettings);

    public static final native long OcrEngineSession_processImageData__SWIG_1(long j, OcrEngineSession ocrEngineSession, byte[] bArr);

    public static final native long OcrEngineSession_processImageFile__SWIG_0(long j, OcrEngineSession ocrEngineSession, String str, long j2, OcrEngineSettings ocrEngineSettings);

    public static final native long OcrEngineSession_processImageFile__SWIG_1(long j, OcrEngineSession ocrEngineSession, String str);

    public static final native boolean OcrEngineSettings_getAmexCVVRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getCheckChinaUnionPayLuhnCodeFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getCheckStarbucksFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getCheckUmpFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getExpiryContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getExpiryRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native int OcrEngineSettings_getFocusThreshold(long j, OcrEngineSettings ocrEngineSettings);

    public static final native int OcrEngineSettings_getIntensityThreshold(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getLogoAnalysisFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getNameContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getNameRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getNumberContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native int OcrEngineSettings_getNumberOfQuadranglesToProcess(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getNumberRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native long OcrEngineSettings_getPreDetectedQuadrangles(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getRawSecondLineRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getSbcodeRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getUkSortCodeAccountNumberContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getUkSortCodeAccountNumberRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getUpturnedCardDetectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_getUseAdvAcceptDictFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenAmexCVVRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenCheckChinaUnionPayLuhnCodeFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenCheckStarbucksFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenCheckUmpFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenExpiryContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenExpiryRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenFocusThreshold(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenIntensityThreshold(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenLogoAnalysisFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenNameContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenNameRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenNumberContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenNumberOfQuadranglesToProcess(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenNumberRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenPreDetectedQuadrangles(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenRawSecondLineRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenSbcodeRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenUkSortCodeAccountNumberContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenUkSortCodeAccountNumberRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenUpturnedCardDetectionFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native boolean OcrEngineSettings_isOverridenUseAdvAcceptDictFlag(long j, OcrEngineSettings ocrEngineSettings);

    public static final native void OcrEngineSettings_setAmexCVVRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setCheckChinaUnionPayLuhnCodeFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setCheckStarbucksFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setCheckUmpFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setExpiryContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setExpiryRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setFocusThreshold(long j, OcrEngineSettings ocrEngineSettings, int i);

    public static final native void OcrEngineSettings_setIntensityThreshold(long j, OcrEngineSettings ocrEngineSettings, int i);

    public static final native void OcrEngineSettings_setLogoAnalysisFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setNameContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setNameRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setNumberContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setNumberOfQuadranglesToProcess(long j, OcrEngineSettings ocrEngineSettings, int i);

    public static final native void OcrEngineSettings_setNumberRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setPreDetectedQuadrangles(long j, OcrEngineSettings ocrEngineSettings, long j2, OcrQuadrangleVector ocrQuadrangleVector);

    public static final native void OcrEngineSettings_setRawSecondLineRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setSbcodeRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setUkSortCodeAccountNumberContextCorrectionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setUkSortCodeAccountNumberRecognitionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setUpturnedCardDetectionFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native void OcrEngineSettings_setUseAdvAcceptDictFlag(long j, OcrEngineSettings ocrEngineSettings, boolean z);

    public static final native long OcrEngine_SWIGUpcast(long j);

    public static final native void OcrEngine_change_ownership(OcrEngine ocrEngine, long j, boolean z);

    public static final native long OcrEngine_createSession__SWIG_0(long j, OcrEngine ocrEngine, long j2, ResultAcceptorInterface resultAcceptorInterface);

    public static final native long OcrEngine_createSession__SWIG_1(long j, OcrEngine ocrEngine);

    public static final native void OcrEngine_director_connect(OcrEngine ocrEngine, long j, boolean z, boolean z2);

    public static final native String OcrField_getAsString(long j, OcrField ocrField);

    public static final native long OcrField_getConfidence(long j, OcrField ocrField);

    public static final native long OcrField_getLength(long j, OcrField ocrField);

    public static final native long OcrField_getOcrCharVariants(long j, OcrField ocrField);

    public static final native boolean OcrField_getToAcceptFlag(long j, OcrField ocrField);

    public static final native int OcrLogoTypeUnknown_get();

    public static final native int OcrPoint_getX(long j, OcrPoint ocrPoint);

    public static final native int OcrPoint_getY(long j, OcrPoint ocrPoint);

    public static final native void OcrQuadrangleVector_add(long j, OcrQuadrangleVector ocrQuadrangleVector, long j2, OcrQuadrangle ocrQuadrangle);

    public static final native long OcrQuadrangleVector_capacity(long j, OcrQuadrangleVector ocrQuadrangleVector);

    public static final native void OcrQuadrangleVector_clear(long j, OcrQuadrangleVector ocrQuadrangleVector);

    public static final native long OcrQuadrangleVector_get(long j, OcrQuadrangleVector ocrQuadrangleVector, int i);

    public static final native boolean OcrQuadrangleVector_isEmpty(long j, OcrQuadrangleVector ocrQuadrangleVector);

    public static final native void OcrQuadrangleVector_reserve(long j, OcrQuadrangleVector ocrQuadrangleVector, long j2);

    public static final native void OcrQuadrangleVector_set(long j, OcrQuadrangleVector ocrQuadrangleVector, int i, long j2, OcrQuadrangle ocrQuadrangle);

    public static final native long OcrQuadrangleVector_size(long j, OcrQuadrangleVector ocrQuadrangleVector);

    public static final native long OcrQuadrangle_getBottomLeft(long j, OcrQuadrangle ocrQuadrangle);

    public static final native long OcrQuadrangle_getBottomRight(long j, OcrQuadrangle ocrQuadrangle);

    public static final native long OcrQuadrangle_getTopLeft(long j, OcrQuadrangle ocrQuadrangle);

    public static final native long OcrQuadrangle_getTopRight(long j, OcrQuadrangle ocrQuadrangle);

    public static final native long OcrResult_getAmexCVV(long j, OcrResult ocrResult);

    public static final native long OcrResult_getCardExpiry(long j, OcrResult ocrResult);

    public static final native long OcrResult_getCardName(long j, OcrResult ocrResult);

    public static final native long OcrResult_getCardNumber(long j, OcrResult ocrResult);

    public static final native long OcrResult_getCardQuadrangle(long j, OcrResult ocrResult);

    public static final native int OcrResult_getCardType(long j, OcrResult ocrResult);

    public static final native int OcrResult_getLogoType(long j, OcrResult ocrResult);

    public static final native int OcrResult_getOrientation(long j, OcrResult ocrResult);

    public static final native long OcrResult_getRawSecondLine(long j, OcrResult ocrResult);

    public static final native long OcrResult_getSbCode(long j, OcrResult ocrResult);

    public static final native boolean OcrResult_getShouldBeDiscardedFlag(long j, OcrResult ocrResult);

    public static final native boolean OcrResult_getStbCardFlag(long j, OcrResult ocrResult);

    public static final native long OcrResult_getUkAccountNumber(long j, OcrResult ocrResult);

    public static final native long OcrResult_getUkSortCode(long j, OcrResult ocrResult);

    public static final native boolean OcrResult_getUmpCardFlag(long j, OcrResult ocrResult);

    public static final native boolean OcrResult_getUpturnedCardFlag(long j, OcrResult ocrResult);

    public static final native void OcrTimingRecordVector_add(long j, OcrTimingRecordVector ocrTimingRecordVector, long j2, OcrTimingRecord ocrTimingRecord);

    public static final native long OcrTimingRecordVector_capacity(long j, OcrTimingRecordVector ocrTimingRecordVector);

    public static final native void OcrTimingRecordVector_clear(long j, OcrTimingRecordVector ocrTimingRecordVector);

    public static final native long OcrTimingRecordVector_get(long j, OcrTimingRecordVector ocrTimingRecordVector, int i);

    public static final native boolean OcrTimingRecordVector_isEmpty(long j, OcrTimingRecordVector ocrTimingRecordVector);

    public static final native void OcrTimingRecordVector_reserve(long j, OcrTimingRecordVector ocrTimingRecordVector, long j2);

    public static final native void OcrTimingRecordVector_set(long j, OcrTimingRecordVector ocrTimingRecordVector, int i, long j2, OcrTimingRecord ocrTimingRecord);

    public static final native long OcrTimingRecordVector_size(long j, OcrTimingRecordVector ocrTimingRecordVector);

    public static final native long OcrTimingRecord_getCallCount(long j, OcrTimingRecord ocrTimingRecord);

    public static final native String OcrTimingRecord_getComment(long j, OcrTimingRecord ocrTimingRecord);

    public static final native String OcrTimingRecord_getName(long j, OcrTimingRecord ocrTimingRecord);

    public static final native double OcrTimingRecord_getTotalTime(long j, OcrTimingRecord ocrTimingRecord);

    public static final native boolean ResultAcceptorInterfaceSettings_getOcrEnabledFlag(long j, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings, int i);

    public static final native void ResultAcceptorInterfaceSettings_setAllOcrEnabledFlag(long j, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings, boolean z);

    public static final native void ResultAcceptorInterfaceSettings_setOcrEnabledFlag(long j, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings, int i, boolean z);

    public static final native void ResultAcceptorInterface_accept(long j, ResultAcceptorInterface resultAcceptorInterface, int i, long j2, OcrCharStringVector ocrCharStringVector, int i2, int i3, long j3, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings, boolean z);

    public static final native void ResultAcceptorInterface_acceptSwigExplicitResultAcceptorInterface(long j, ResultAcceptorInterface resultAcceptorInterface, int i, long j2, OcrCharStringVector ocrCharStringVector, int i2, int i3, long j3, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings, boolean z);

    public static final native void ResultAcceptorInterface_change_ownership(ResultAcceptorInterface resultAcceptorInterface, long j, boolean z);

    public static final native void ResultAcceptorInterface_director_connect(ResultAcceptorInterface resultAcceptorInterface, long j, boolean z, boolean z2);

    public static final native int YuvUtils_yuv2rgb(byte[] bArr, byte[] bArr2, int i, int i2);

    public static final native int YuvUtils_yuvCutRotateScale2rgb(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int i7, int i8, int i9);

    public static final native void delete_ConversionUtils(long j);

    public static final native void delete_DetectionEngine(long j);

    public static final native void delete_DetectionInternalSettings(long j);

    public static final native void delete_DetectionInternalSettingsFactory(long j);

    public static final native void delete_DetectionResult(long j);

    public static final native void delete_DetectionSettings(long j);

    public static final native void delete_ImageCheck(long j);

    public static final native void delete_OcrChar(long j);

    public static final native void delete_OcrCharStringVector(long j);

    public static final native void delete_OcrCharVariants(long j);

    public static final native void delete_OcrCharVector(long j);

    public static final native void delete_OcrConfidence(long j);

    public static final native void delete_OcrEngine(long j);

    public static final native void delete_OcrEngineBase(long j);

    public static final native void delete_OcrEngineBaseSession(long j);

    public static final native void delete_OcrEngineInternalSettings(long j);

    public static final native void delete_OcrEngineSession(long j);

    public static final native void delete_OcrEngineSettings(long j);

    public static final native void delete_OcrField(long j);

    public static final native void delete_OcrPoint(long j);

    public static final native void delete_OcrQuadrangle(long j);

    public static final native void delete_OcrQuadrangleVector(long j);

    public static final native void delete_OcrResult(long j);

    public static final native void delete_OcrTimingRecord(long j);

    public static final native void delete_OcrTimingRecordVector(long j);

    public static final native void delete_ResultAcceptorInterface(long j);

    public static final native void delete_ResultAcceptorInterfaceSettings(long j);

    public static final native void delete_YuvUtils(long j);

    public static final native long new_ConversionUtils();

    public static final native long new_DetectionEngine(long j, DetectionSettings detectionSettings, long j2, DetectionInternalSettings detectionInternalSettings);

    public static final native long new_DetectionInternalSettings();

    public static final native long new_DetectionInternalSettingsFactory();

    public static final native long new_DetectionResult__SWIG_0();

    public static final native long new_DetectionResult__SWIG_1(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, long j, OcrPoint ocrPoint, long j2, OcrPoint ocrPoint2, boolean z7, long j3, OcrQuadrangle ocrQuadrangle);

    public static final native long new_DetectionSettings();

    public static final native long new_ImageCheck();

    public static final native long new_OcrCharStringVector__SWIG_0();

    public static final native long new_OcrCharStringVector__SWIG_1(long j);

    public static final native long new_OcrCharVariants__SWIG_0();

    public static final native long new_OcrCharVariants__SWIG_1(long j, OcrQuadrangle ocrQuadrangle, int i);

    public static final native long new_OcrCharVector__SWIG_0();

    public static final native long new_OcrCharVector__SWIG_1(long j);

    public static final native long new_OcrChar__SWIG_0();

    public static final native long new_OcrChar__SWIG_1(char c, double d);

    public static final native long new_OcrConfidence(double d, double d2);

    public static final native long new_OcrEngine(long j, OcrEngineInternalSettings ocrEngineInternalSettings);

    public static final native long new_OcrEngineBase(long j, OcrEngineInternalSettings ocrEngineInternalSettings);

    public static final native long new_OcrEngineSettings__SWIG_0();

    public static final native long new_OcrEngineSettings__SWIG_1(long j, OcrEngineSettings ocrEngineSettings);

    public static final native long new_OcrField__SWIG_0(long j, OcrCharStringVector ocrCharStringVector, boolean z);

    public static final native long new_OcrField__SWIG_1(long j, OcrField ocrField);

    public static final native long new_OcrPoint__SWIG_0(int i, int i2);

    public static final native long new_OcrPoint__SWIG_1(int i);

    public static final native long new_OcrPoint__SWIG_2();

    public static final native long new_OcrQuadrangleVector__SWIG_0();

    public static final native long new_OcrQuadrangleVector__SWIG_1(long j);

    public static final native long new_OcrQuadrangle__SWIG_0();

    public static final native long new_OcrQuadrangle__SWIG_1(long j, OcrPoint ocrPoint, long j2, OcrPoint ocrPoint2, long j3, OcrPoint ocrPoint3, long j4, OcrPoint ocrPoint4);

    public static final native long new_OcrResult(long j, OcrField ocrField, long j2, OcrField ocrField2, long j3, OcrField ocrField3, long j4, OcrField ocrField4, long j5, OcrField ocrField5, long j6, OcrField ocrField6, long j7, OcrField ocrField7, long j8, OcrField ocrField8, long j9, OcrQuadrangle ocrQuadrangle, boolean z, boolean z2, int i, int i2, boolean z3, boolean z4);

    public static final native long new_OcrTimingRecordVector__SWIG_0();

    public static final native long new_OcrTimingRecordVector__SWIG_1(long j);

    public static final native long new_OcrTimingRecord__SWIG_0();

    public static final native long new_OcrTimingRecord__SWIG_1(double d, long j, String str, String str2);

    public static final native long new_ResultAcceptorInterface();

    public static final native long new_ResultAcceptorInterfaceSettings__SWIG_0();

    public static final native long new_ResultAcceptorInterfaceSettings__SWIG_1(long j, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings);

    public static final native long new_YuvUtils();

    private static final native void swig_module_init();

    public static void SwigDirector_ResultAcceptorInterface_accept(ResultAcceptorInterface resultAcceptorInterface, int i, long j, int i2, int i3, long j2, boolean z) {
        resultAcceptorInterface.accept(FieldName.swigToEnum(i), new OcrCharStringVector(j, false), i2, i3, new ResultAcceptorInterfaceSettings(j2, false), z);
    }

    static {
        swig_module_init();
    }
}
