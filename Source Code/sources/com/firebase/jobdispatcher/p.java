package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.jobdispatcher.u.a;
import com.firebase.jobdispatcher.u.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JobCoder */
final class p {
    private final String prefix;

    p(String str) {
        this.prefix = str;
    }

    @NonNull
    Bundle e(@NonNull r rVar, @NonNull Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        Bundle extras = rVar.getExtras();
        if (extras != null) {
            bundle.putAll(extras);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("persistent");
        bundle.putInt(stringBuilder.toString(), rVar.getLifetime());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("recurring");
        bundle.putBoolean(stringBuilder.toString(), rVar.oM());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("replace_current");
        bundle.putBoolean(stringBuilder.toString(), rVar.oK());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("tag");
        bundle.putString(stringBuilder.toString(), rVar.getTag());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append(NotificationCompat.CATEGORY_SERVICE);
        bundle.putString(stringBuilder.toString(), rVar.oN());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("constraints");
        bundle.putInt(stringBuilder.toString(), a.f(rVar.oI()));
        a(rVar.oL(), bundle);
        a(rVar.oJ(), bundle);
        return bundle;
    }

    q C(@NonNull Bundle bundle) {
        if (bundle == null) {
            Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
            return null;
        }
        Bundle bundle2 = bundle.getBundle("extras");
        if (bundle2 == null) {
            return null;
        }
        a D = D(bundle2);
        List parcelableArrayList = bundle.getParcelableArrayList("triggered_uris");
        if (parcelableArrayList != null) {
            D.a(new z(parcelableArrayList));
        }
        return D.oP();
    }

    @Nullable
    public a D(@NonNull Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        Bundle bundle2 = new Bundle(bundle);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("recurring");
        boolean z = bundle2.getBoolean(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.prefix);
        stringBuilder2.append("replace_current");
        boolean z2 = bundle2.getBoolean(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.prefix);
        stringBuilder3.append("persistent");
        int i = bundle2.getInt(stringBuilder3.toString());
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.prefix);
        stringBuilder4.append("constraints");
        int[] am = a.am(bundle2.getInt(stringBuilder4.toString()));
        u E = E(bundle2);
        x F = F(bundle2);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(this.prefix);
        stringBuilder5.append("tag");
        String string = bundle2.getString(stringBuilder5.toString());
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(this.prefix);
        stringBuilder6.append(NotificationCompat.CATEGORY_SERVICE);
        String string2 = bundle2.getString(stringBuilder6.toString());
        if (string == null || string2 == null || E == null || F == null) {
            return null;
        }
        a aVar = new a();
        aVar.cw(string);
        aVar.cx(string2);
        aVar.c(E);
        aVar.c(F);
        aVar.X(z);
        aVar.as(i);
        aVar.h(am);
        aVar.Y(z2);
        if (!TextUtils.isEmpty(this.prefix)) {
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next()).startsWith(this.prefix)) {
                    it.remove();
                }
            }
        }
        aVar.G(bundle2);
        return aVar;
    }

    @NonNull
    private u E(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("trigger_type");
        switch (bundle.getInt(stringBuilder.toString())) {
            case 1:
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.prefix);
                stringBuilder.append("window_start");
                int i = bundle.getInt(stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.prefix);
                stringBuilder2.append("window_end");
                return y.r(i, bundle.getInt(stringBuilder2.toString()));
            case 2:
                return y.KT;
            case 3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.prefix);
                stringBuilder.append("observed_uris");
                return y.t(Collections.unmodifiableList(cv(bundle.getString(stringBuilder.toString()))));
            default:
                if (Log.isLoggable("FJD.ExternalReceiver", 3)) {
                    Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
                }
                return null;
        }
    }

    private void a(u uVar, Bundle bundle) {
        StringBuilder stringBuilder;
        if (uVar == y.KT) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.prefix);
            stringBuilder2.append("trigger_type");
            bundle.putInt(stringBuilder2.toString(), 2);
        } else if (uVar instanceof b) {
            b bVar = (b) uVar;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.prefix);
            stringBuilder.append("trigger_type");
            bundle.putInt(stringBuilder.toString(), 1);
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.prefix);
            stringBuilder.append("window_start");
            bundle.putInt(stringBuilder.toString(), bVar.oS());
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.prefix);
            stringBuilder.append("window_end");
            bundle.putInt(stringBuilder.toString(), bVar.oT());
        } else if (uVar instanceof a) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.prefix);
            stringBuilder.append("trigger_type");
            bundle.putInt(stringBuilder.toString(), 3);
            String s = s(((a) uVar).oR());
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.prefix);
            stringBuilder.append("observed_uris");
            bundle.putString(stringBuilder.toString(), s);
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
    }

    private x F(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("retry_policy");
        int i = bundle.getInt(stringBuilder.toString());
        if (i != 1 && i != 2) {
            return x.KK;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.prefix);
        stringBuilder2.append("initial_backoff_seconds");
        int i2 = bundle.getInt(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.prefix);
        stringBuilder3.append("maximum_backoff_seconds");
        return new x(i, i2, bundle.getInt(stringBuilder3.toString()));
    }

    private void a(x xVar, Bundle bundle) {
        if (xVar == null) {
            xVar = x.KK;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("retry_policy");
        bundle.putInt(stringBuilder.toString(), xVar.oU());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("initial_backoff_seconds");
        bundle.putInt(stringBuilder.toString(), xVar.oV());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefix);
        stringBuilder.append("maximum_backoff_seconds");
        bundle.putInt(stringBuilder.toString(), xVar.oW());
    }

    @NonNull
    private static String s(@NonNull List<w> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (w wVar : list) {
            jSONArray.put(wVar.getFlags());
            jSONArray2.put(wVar.getUri());
        }
        try {
            jSONObject.put("uri_flags", jSONArray);
            jSONObject.put("uris", jSONArray2);
            return jSONObject.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    private static List<w> cv(@NonNull String str) {
        List<w> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("uri_flags");
            JSONArray jSONArray2 = jSONObject.getJSONArray("uris");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(new w(Uri.parse(jSONArray2.getString(i)), jSONArray.getInt(i)));
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
