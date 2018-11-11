package jumio.bam;

import android.content.Context;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.SimpleApiCall;

/* compiled from: UpdateCall */
class f extends SimpleApiCall<Void> {
    private final String a;
    private final y b;

    /* renamed from: a */
    protected Void parseResponse(String str) {
        return null;
    }

    public f(Context context, DynamicProvider dynamicProvider, y yVar, String str) {
        super(context, dynamicProvider);
        this.a = str;
        this.b = yVar;
    }

    public String getUri() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("/");
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -98, (byte) -66, (byte) 73, (byte) -47, (byte) 98, (byte) 31}, -3640786553150147589L));
        return stringBuilder.toString();
    }

    protected String getRequest() {
        JumioJSONObject jumioJSONObject = new JumioJSONObject();
        jumioJSONObject.put("changedCardExpiryMonth", this.b.getCardExpiryDateMonth());
        jumioJSONObject.put("changedCardExpiryYear", this.b.getCardExpiryDateYear());
        jumioJSONObject.put("changedCardHolderName", this.b.getCardHolderName());
        return jumioJSONObject.toString();
    }
}
