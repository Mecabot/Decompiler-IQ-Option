package io.fabric.sdk.android.services.common;

import com.iqoption.dto.ToastEntity;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: AbstractSpiCall */
public abstract class a {
    private static final Pattern emG = Pattern.compile("http(s?)://[^\\/]+", 2);
    private final HttpMethod emH;
    private final String emI;
    protected final h rR;
    private final c rU;
    private final String url;

    public a(h hVar, String str, String str2, c cVar, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (cVar == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.rR = hVar;
            this.emI = str;
            this.url = lw(str2);
            this.rU = cVar;
            this.emH = httpMethod;
        }
    }

    protected String getUrl() {
        return this.url;
    }

    protected HttpRequest aUt() {
        return J(Collections.emptyMap());
    }

    protected HttpRequest J(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Android SDK/");
        stringBuilder.append(this.rR.getVersion());
        return this.rU.a(this.emH, getUrl(), map).gs(false).ja(ToastEntity.ALERT_TOAST_DURATION).aS("User-Agent", stringBuilder.toString()).aS("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String lw(String str) {
        return !CommonUtils.bc(this.emI) ? emG.matcher(str).replaceFirst(this.emI) : str;
    }
}
