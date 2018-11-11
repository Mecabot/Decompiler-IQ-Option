package com.jumio.persistence;

import android.support.annotation.Nullable;

public interface PersistenceTarget {
    boolean delete();

    @Nullable
    byte[] readBlob();

    long storeBlob(byte[] bArr);
}
