package io.card.payment.i18n;

import android.content.Intent;
import io.card.payment.CardIOActivity;
import io.card.payment.i18n.a.o;

/* compiled from: LocalizedStrings */
public final class b {
    private static final a<StringKey> elt = new a(StringKey.class, o.elw);

    public static String a(StringKey stringKey) {
        return elt.a((Enum) stringKey);
    }

    public static String a(StringKey stringKey, String str) {
        return elt.a(stringKey, elt.lt(str));
    }

    public static void y(Intent intent) {
        elt.setLanguage(intent.getStringExtra(CardIOActivity.EXTRA_LANGUAGE_OR_LOCALE));
    }
}
