package com.jumio.nv.custom;

import com.jumio.nv.NetverifyDocumentData;
import java.util.HashMap;

public interface NetverifyCustomSDKInterface {
    void onNetverifyCountriesReceived(HashMap<String, NetverifyCountry> hashMap, String str);

    void onNetverifyError(int i, int i2, String str, boolean z, String str2);

    void onNetverifyFinished(NetverifyDocumentData netverifyDocumentData, String str);

    void onNetverifyResourcesLoaded();
}
