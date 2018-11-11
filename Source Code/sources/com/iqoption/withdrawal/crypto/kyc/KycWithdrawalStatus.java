package com.iqoption.withdrawal.crypto.kyc;

public enum KycWithdrawalStatus {
    Done,
    NotFilled,
    DocumentsNotUploaded,
    UploadIsNotFinishingByUser,
    DocumentOnVerification,
    DocumentsIsDeclined
}
