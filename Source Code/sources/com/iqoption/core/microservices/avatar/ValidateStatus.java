package com.iqoption.core.microservices.avatar;

public enum ValidateStatus {
    def,
    inProgress,
    validatedAuto,
    validatedHand,
    invalidatedAuto,
    needHandValidate,
    invalidatedHand
}
