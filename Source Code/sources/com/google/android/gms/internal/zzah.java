package com.google.android.gms.internal;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

final class zzah extends zzai {
    private final zzar zzbo;

    zzah(zzar zzar) {
        this.zzbo = zzar;
    }

    public final zzaq zza(zzr<?> zzr, Map<String, String> map) {
        try {
            HttpResponse zzb = this.zzbo.zzb(zzr, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            List arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new zzaq(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new zzaq(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
            }
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Response too large: ");
            stringBuilder.append(contentLength);
            throw new IOException(stringBuilder.toString());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
