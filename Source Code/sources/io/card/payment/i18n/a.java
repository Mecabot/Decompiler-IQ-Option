package io.card.payment.i18n;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: I18nManager */
public class a<E extends Enum<?>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "a";
    private static final Map<String, String> elo = new HashMap();
    private static final Set<String> elp = new HashSet();
    private Map<String, c<E>> elq = new LinkedHashMap();
    private c<E> elr;
    private Class<E> els;

    static {
        elo.put("zh_CN", "zh-Hans");
        elo.put("zh_TW", "zh-Hant_TW");
        elo.put("zh_HK", "zh-Hant");
        elo.put("en_UK", "en_GB");
        elo.put("en_IE", "en_GB");
        elo.put("iw_IL", "he");
        elo.put("no", "nb");
        elp.add("he");
        elp.add("ar");
    }

    public a(Class<E> cls, List<c<E>> list) {
        this.els = cls;
        for (c a : list) {
            a(a);
        }
        setLanguage(null);
    }

    private void lr(String str) {
        for (String i : ls(str)) {
            Log.i(TAG, i);
        }
    }

    private List<String> ls(String str) {
        c cVar = (c) this.elq.get(str);
        List<String> arrayList = new ArrayList();
        for (Enum enumR : (Enum[]) this.els.getEnumConstants()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(str);
            stringBuilder.append(",");
            stringBuilder.append(enumR);
            stringBuilder.append("]");
            String stringBuilder2 = stringBuilder.toString();
            if (cVar.a(enumR, null) == null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Missing ");
                stringBuilder3.append(stringBuilder2);
                arrayList.add(stringBuilder3.toString());
            }
        }
        return arrayList;
    }

    public void setLanguage(String str) {
        this.elr = null;
        this.elr = lt(str);
        str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setting locale to:");
        stringBuilder.append(this.elr.getName());
        Log.d(str, stringBuilder.toString());
    }

    public c<E> lt(String str) {
        c<E> lu = str != null ? lu(str) : null;
        if (lu == null) {
            String locale = Locale.getDefault().toString();
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" not found.  Attempting to look for ");
            stringBuilder.append(locale);
            Log.d(str2, stringBuilder.toString());
            lu = lu(locale);
        }
        if (lu != null) {
            return lu;
        }
        Log.d(TAG, "defaulting to english");
        return (c) this.elq.get("en");
    }

    private c<E> lu(String str) {
        c<E> cVar = null;
        if (str == null || str.length() < 2) {
            return null;
        }
        if (elo.containsKey(str)) {
            String str2 = (String) elo.get(str);
            c<E> cVar2 = (c) this.elq.get(str2);
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Overriding locale specifier ");
            stringBuilder.append(str);
            stringBuilder.append(" with ");
            stringBuilder.append(str2);
            Log.d(str3, stringBuilder.toString());
            cVar = cVar2;
        }
        if (cVar == null) {
            Object obj;
            if (str.contains("_")) {
                obj = str;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("_");
                stringBuilder2.append(Locale.getDefault().getCountry());
                obj = stringBuilder2.toString();
            }
            cVar = (c) this.elq.get(obj);
        }
        if (cVar == null) {
            cVar = (c) this.elq.get(str);
        }
        if (cVar == null) {
            cVar = (c) this.elq.get(str.substring(0, 2));
        }
        return cVar;
    }

    public String a(E e) {
        return a(e, this.elr);
    }

    public String a(E e, c<E> cVar) {
        String toUpperCase = Locale.getDefault().getCountry().toUpperCase(Locale.US);
        String a = cVar.a(e, toUpperCase);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing localized string for [");
            stringBuilder.append(this.elr.getName());
            stringBuilder.append(",Key.");
            stringBuilder.append(e.toString());
            stringBuilder.append("]");
            Log.i(TAG, stringBuilder.toString());
            a = ((c) this.elq.get("en")).a(e, toUpperCase);
        }
        if (a != null) {
            return a;
        }
        a = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Missing localized string for [en,Key.");
        stringBuilder2.append(e.toString());
        stringBuilder2.append("], so defaulting to keyname");
        Log.i(a, stringBuilder2.toString());
        return e.toString();
    }

    private void a(c<E> cVar) {
        String name = cVar.getName();
        if (name == null) {
            throw new RuntimeException("Null localeName");
        } else if (this.elq.containsKey(name)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Locale ");
            stringBuilder.append(name);
            stringBuilder.append(" already added");
            throw new RuntimeException(stringBuilder.toString());
        } else {
            this.elq.put(name, cVar);
            lr(name);
        }
    }
}
