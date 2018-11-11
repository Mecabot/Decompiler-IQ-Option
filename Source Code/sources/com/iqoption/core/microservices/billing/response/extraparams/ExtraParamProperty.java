package com.iqoption.core.microservices.billing.response.extraparams;

import android.os.Parcelable;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\b"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "Landroid/os/Parcelable;", "getTitle", "", "getType", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty$PropertyType;", "getTypeName", "PropertyType", "core_release"})
/* compiled from: ExtraParamProperty.kt */
public interface ExtraParamProperty extends Parcelable {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty$PropertyType;", "", "(Ljava/lang/String;I)V", "enumType", "stringType", "integerType", "selectType", "core_release"})
    /* compiled from: ExtraParamProperty.kt */
    public enum PropertyType {
        enumType,
        stringType,
        integerType,
        selectType
    }

    PropertyType Vh();

    String getTitle();
}
