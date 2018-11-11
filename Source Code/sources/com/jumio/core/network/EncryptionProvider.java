package com.jumio.core.network;

import android.support.annotation.Nullable;
import java.io.InputStream;
import java.io.OutputStream;

public interface EncryptionProvider {
    OutputStream createRequest(OutputStream outputStream, int i, @Nullable String str);

    String getResponse(InputStream inputStream);
}
