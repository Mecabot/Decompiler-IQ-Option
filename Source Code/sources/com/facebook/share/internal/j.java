package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.w;
import com.facebook.share.a.a;
import com.facebook.share.a.b;
import com.facebook.share.a.c;
import com.facebook.share.a.g;
import org.json.JSONObject;

/* compiled from: WebDialogParameters */
public class j {
    public static Bundle a(c cVar) {
        Bundle b = b((a) cVar);
        w.a(b, "href", cVar.ol());
        w.b(b, "quote", cVar.op());
        return b;
    }

    public static Bundle b(g gVar) {
        Bundle b = b((a) gVar);
        w.b(b, "action_type", gVar.os().oq());
        try {
            JSONObject a = i.a(i.a(gVar), false);
            if (a != null) {
                w.b(b, "action_properties", a.toString());
            }
            return b;
        } catch (Throwable e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    public static Bundle b(a aVar) {
        Bundle bundle = new Bundle();
        b om = aVar.om();
        if (om != null) {
            w.b(bundle, "hashtag", om.on());
        }
        return bundle;
    }
}
