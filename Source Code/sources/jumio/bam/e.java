package jumio.bam;

import android.content.Context;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.SimpleApiCall;

/* compiled from: ResultCall */
class e extends SimpleApiCall<String> {
    private final String a;
    private final y b;
    private final x c;

    public e(Context context, DynamicProvider dynamicProvider, x xVar, y yVar, String str, Subscriber<String> subscriber) {
        super(context, dynamicProvider, subscriber);
        this.c = xVar;
        this.b = yVar;
        this.a = str;
    }

    public String getUri() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("/");
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -37, (byte) -73, (byte) -57, (byte) -11, (byte) 111, (byte) 113, (byte) -37}, -7026069298207849224L));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected String parseResponse(String str) {
        return this.a;
    }

    protected String getRequest() {
        JumioJSONObject jumioJSONObject = new JumioJSONObject();
        JumioJSONObject jumioJSONObject2 = new JumioJSONObject();
        if (this.b.getCardNumber().length != 0) {
            jumioJSONObject2.put("cardNumber", this.b.getCardNumber());
        }
        if (this.b.getCardExpiryDateMonth().length != 0) {
            jumioJSONObject2.put("cardExpiryMonth", this.b.getCardExpiryDateMonth());
        }
        if (this.b.getCardExpiryDateYear().length != 0) {
            jumioJSONObject2.put("cardExpiryYear", this.b.getCardExpiryDateYear());
        }
        jumioJSONObject2.put("cardHolderName", this.b.getCardHolderName());
        jumioJSONObject2.put("cardSortCode", this.b.getCardSortCode());
        jumioJSONObject2.put("cardAccountNumber", this.b.getCardAccountNumber());
        jumioJSONObject2.put("cardUMP", this.b.b());
        JumioJSONObject jumioJSONObject3 = new JumioJSONObject();
        jumioJSONObject3.put("recognitionResult", a());
        if (!(this.b.c() == null || this.b.c().length() == 0)) {
            jumioJSONObject3.put("digitCoordinates", this.b.c());
        }
        if (!(this.b.d() == null || this.b.d().length() == 0)) {
            jumioJSONObject3.put("cvvCoordinates", this.b.d());
        }
        jumioJSONObject.put("cardData", jumioJSONObject2);
        jumioJSONObject.put("ocrResult", jumioJSONObject3);
        jumioJSONObject.put("timings", this.b.e());
        return jumioJSONObject.toString();
    }

    private String a() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.c.f()) {
            stringBuilder.append("3");
        } else if (this.b.getCardSortCode().length == 0 || this.b.getCardAccountNumber().length == 0) {
            stringBuilder.append("2");
        } else {
            stringBuilder.append("1");
        }
        if (!this.c.d()) {
            stringBuilder.append("3");
        } else if (this.b.getCardHolderName().length == 0) {
            stringBuilder.append("2");
        } else {
            stringBuilder.append("1");
        }
        if (!this.c.a()) {
            stringBuilder.append("3");
        } else if (this.b.getCardExpiryDateMonth().length == 0 || this.b.getCardExpiryDateYear().length == 0) {
            stringBuilder.append("2");
        } else {
            stringBuilder.append("1");
        }
        if (this.b.getCardNumber().length == 0) {
            stringBuilder.append("2");
        } else {
            stringBuilder.append("1");
        }
        return stringBuilder.toString();
    }
}
