package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzdj;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class zzdkr implements zzdks {
    private HttpURLConnection zzlbw;
    private InputStream zzlbx = null;

    zzdkr() {
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzlbw;
        try {
            if (this.zzlbx != null) {
                this.zzlbx.close();
            }
        } catch (Throwable e) {
            String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ";
            String valueOf = String.valueOf(e.getMessage());
            zzdj.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final InputStream zzne(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzlbw = httpURLConnection;
        httpURLConnection = this.zzlbw;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            this.zzlbx = httpURLConnection.getInputStream();
            return this.zzlbx;
        }
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append("Bad response: ");
        stringBuilder.append(responseCode);
        str = stringBuilder.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(str);
        } else if (responseCode == 503) {
            throw new zzdku(str);
        } else {
            throw new IOException(str);
        }
    }
}
