package com.microblink.recognizers.blinkbarcode.bardecoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import com.microblink.recognizers.BaseRecognitionResult;

/* compiled from: line */
public class BarDecoderScanResult extends BaseRecognitionResult {
    public static final Creator<BarDecoderScanResult> CREATOR = new Creator<BarDecoderScanResult>() {
        /* renamed from: hP */
        public final BarDecoderScanResult[] newArray(int i) {
            return new BarDecoderScanResult[i];
        }

        /* renamed from: ak */
        public final BarDecoderScanResult createFromParcel(Parcel parcel) {
            return new BarDecoderScanResult(parcel);
        }
    };

    @Keep
    public BarDecoderScanResult(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    protected BarDecoderScanResult(Parcel parcel) {
        super(parcel);
    }

    private String aPg() {
        return aPd().getString("PaymentDataType");
    }

    @Nullable
    public String getStringData() {
        return aPd().getString("BarcodeData");
    }

    public String toString() {
        return getStringData();
    }

    public String getTitle() {
        String aPg = aPg();
        if (aPg == null) {
            return "1D barcode scan result";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aPg);
        stringBuilder.append(" scan result");
        return stringBuilder.toString();
    }
}
