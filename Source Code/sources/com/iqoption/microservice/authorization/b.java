package com.iqoption.microservice.authorization;

import com.iqoption.core.i;
import com.iqoption.microservice.authorization.a.d;
import com.jumio.analytics.MobileEvents;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: RedirectRequestTask */
public class b extends com.iqoption.mobbtech.connect.request.a.a.b<d> {
    private static final String TAG = "com.iqoption.microservice.authorization.b";
    private static final Pattern cPm = Pattern.compile("(\\?|\\&)(error_code)\\=([\\d]+)\\\"");
    private d cPn = new d();

    protected boolean are() {
        return false;
    }

    public b(Request request, String str) {
        super(d.class, request, str);
    }

    protected String b(Response response) {
        try {
            this.responseCode = response.code();
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("responseCode: ");
            stringBuilder.append(this.responseCode);
            i.i(str, stringBuilder.toString());
            ResponseBody body = response.body();
            this.cPn.body = body != null ? body.string() : "";
            if (this.responseCode == MobileEvents.EVENTTYPE_SDKLIFECYCLE) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("responseBody: ");
                stringBuilder.append(this.cPn.body);
                i.i(str, stringBuilder.toString());
                Matcher matcher = cPm.matcher(this.cPn.body);
                if (matcher.find() && matcher.groupCount() >= 3) {
                    this.cPn.cPx = Integer.valueOf(matcher.group(3)).intValue();
                }
                str = this.cPn.body;
                return str;
            }
            response.close();
            return null;
        } finally {
            response.close();
        }
    }

    /* renamed from: if */
    protected d ig(String str) {
        return this.cPn;
    }
}
