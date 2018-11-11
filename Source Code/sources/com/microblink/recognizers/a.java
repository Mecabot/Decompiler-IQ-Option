package com.microblink.recognizers;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;

/* compiled from: line */
public interface a {
    void ai(Parcel parcel);

    Object getObject(String str);

    Parcelable getParcelable(String str);

    String getString(String str);

    boolean isEmpty();

    boolean isValid();

    Set<String> keySet();
}
