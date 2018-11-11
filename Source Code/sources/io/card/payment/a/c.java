package io.card.payment.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ViewUtil */
public class c {
    private static final Map<String, Integer> elS = aUc();
    static Pattern elT = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");
    static HashMap<String, Float> elU = new HashMap();

    @TargetApi(16)
    public static void setBackground(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    static Map<String, Integer> aUc() {
        Map hashMap = new HashMap();
        hashMap.put("px", Integer.valueOf(0));
        hashMap.put("dip", Integer.valueOf(1));
        hashMap.put("dp", Integer.valueOf(1));
        hashMap.put("sp", Integer.valueOf(2));
        hashMap.put("pt", Integer.valueOf(3));
        hashMap.put("in", Integer.valueOf(4));
        hashMap.put("mm", Integer.valueOf(5));
        return Collections.unmodifiableMap(hashMap);
    }

    public static int f(String str, Context context) {
        return str == null ? 0 : (int) g(str, context);
    }

    @SuppressLint({"DefaultLocale"})
    public static float g(String str, Context context) {
        if (str == null) {
            return 0.0f;
        }
        CharSequence toLowerCase = str.toLowerCase();
        if (elU.containsKey(toLowerCase)) {
            return ((Float) elU.get(toLowerCase)).floatValue();
        }
        Matcher matcher = elT.matcher(toLowerCase);
        if (matcher.matches()) {
            float parseFloat = Float.parseFloat(matcher.group(1));
            Integer num = (Integer) elS.get(matcher.group(3).toLowerCase());
            if (num == null) {
                num = Integer.valueOf(1);
            }
            float applyDimension = TypedValue.applyDimension(num.intValue(), parseFloat, context.getResources().getDisplayMetrics());
            elU.put(toLowerCase, Float.valueOf(applyDimension));
            return applyDimension;
        }
        throw new NumberFormatException();
    }

    public static void a(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        view.setPadding(f(str, context), f(str2, context), f(str3, context), f(str4, context));
    }

    public static void b(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins(f(str, context), f(str2, context), f(str3, context), f(str4, context));
        }
    }

    public static void h(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public static void a(Button button, boolean z, Context context, boolean z2) {
        h(button, -1, -2);
        button.setFocusable(true);
        a(button, "10dip", "0dip", "10dip", "0dip");
        if (!z2) {
            Drawable cm;
            if (z) {
                cm = b.cm(context);
            } else {
                cm = b.cq(context);
            }
            setBackground(button, cm);
            button.setGravity(17);
            button.setMinimumHeight(f("54dip", context));
            button.setTextColor(-1);
            button.setTextSize(20.0f);
            button.setTypeface(b.elR);
        }
    }
}
