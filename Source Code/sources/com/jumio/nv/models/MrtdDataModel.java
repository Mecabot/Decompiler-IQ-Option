package com.jumio.nv.models;

import android.support.annotation.Nullable;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.enums.EMRTDStatus;
import java.util.Date;
import java.util.Map;

public interface MrtdDataModel extends StaticModel {
    int getActiveAuthResult();

    int getBacCheckResult();

    int getDscCheckResult();

    int[] getEncodedDataItems();

    Map<String, Integer> getHtCheckResults();

    @Nullable
    Date getIssuingDate();

    String getMrzFirstName();

    String getMrzIdNumber();

    String getMrzIssuingCountry();

    String getMrzLastName();

    String getMrzOriginatingCountry();

    String getMrzPersonalNumber();

    String getMrzString();

    @Nullable
    String getPlaceOfBirth();

    int getRootCertCheck();

    EMRTDStatus getVerificationStatus();
}
