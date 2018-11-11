package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.facebook.internal.w;
import com.google.android.gms.plus.PlusShare;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewHierarchy */
public class d {
    private static final String TAG = d.class.getCanonicalName();

    @Nullable
    public static ViewGroup f(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) parent;
    }

    public static List<View> g(View view) {
        List arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    public static JSONObject a(View view, JSONObject jSONObject) {
        try {
            String l = l(view);
            String m = m(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put("classname", view.getClass().getCanonicalName());
            jSONObject.put("classtypebitmask", i(view));
            jSONObject.put("id", view.getId());
            if (b.e(view)) {
                jSONObject.put("text", "");
            } else {
                jSONObject.put("text", l);
            }
            jSONObject.put("hint", m);
            if (tag != null) {
                jSONObject.put("tag", tag.toString());
            }
            if (contentDescription != null) {
                jSONObject.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, contentDescription.toString());
            }
            jSONObject.put("dimension", n(view));
        } catch (Exception e) {
            w.a(TAG, e);
        }
        return jSONObject;
    }

    public static JSONObject a(View view, JSONObject jSONObject, float f) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Typeface typeface = textView.getTypeface();
                if (typeface != null) {
                    jSONObject2.put("font_size", (double) textView.getTextSize());
                    jSONObject2.put("is_bold", typeface.isBold());
                    jSONObject2.put("is_italic", typeface.isItalic());
                    jSONObject.put("text_style", jSONObject2);
                }
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f <= 44.0f && ((float) view.getWidth()) / f <= 44.0f) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put("icon_image", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (Exception e) {
            w.a(TAG, e);
        }
        return jSONObject;
    }

    public static JSONObject h(View view) {
        JSONObject a;
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            a = a(view, jSONObject);
            try {
                JSONArray jSONArray = new JSONArray();
                List g = g(view);
                for (int i = 0; i < g.size(); i++) {
                    jSONArray.put(h((View) g.get(i)));
                }
                a.put("childviews", jSONArray);
            } catch (JSONException e2) {
                e = e2;
                Log.e(TAG, "Failed to create JSONObject for view.", e);
                return a;
            }
        } catch (JSONException e3) {
            e = e3;
            a = jSONObject;
            Log.e(TAG, "Failed to create JSONObject for view.", e);
            return a;
        }
        return a;
    }

    private static int i(View view) {
        int i = view instanceof ImageView ? 2 : 0;
        if (j(view)) {
            i |= 32;
        }
        if (k(view)) {
            i |= 512;
        }
        if (view instanceof TextView) {
            i = (i | 1024) | 1;
            if (view instanceof Button) {
                i |= 4;
                if (view instanceof Switch) {
                    i |= 8192;
                } else if (view instanceof CheckBox) {
                    i |= 32768;
                }
            }
            if (view instanceof EditText) {
                return i | 2048;
            }
            return i;
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return i | 4096;
        } else {
            if (view instanceof RatingBar) {
                return i | 65536;
            }
            if (view instanceof RadioGroup) {
                return i | 16384;
            }
            return ((view instanceof ViewGroup) && view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup") && o(view) != null) ? i | 64 : i;
        }
    }

    public static boolean j(View view) {
        boolean z = false;
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return false;
            }
            OnClickListener onClickListener = null;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                onClickListener = (OnClickListener) declaredField2.get(obj);
            }
            if (onClickListener != null) {
                z = true;
            }
            return z;
        } catch (Throwable e) {
            Log.e(TAG, "Failed to check if the view is clickable.", e);
            return false;
        }
    }

    private static boolean k(View view) {
        ViewParent parent = view.getParent();
        return parent != null && ((parent instanceof AdapterView) || (parent instanceof NestedScrollingChild));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    public static java.lang.String l(android.view.View r7) {
        /*
        r0 = r7 instanceof android.widget.TextView;
        r1 = 0;
        if (r0 == 0) goto L_0x0020;
    L_0x0005:
        r0 = r7;
        r0 = (android.widget.TextView) r0;
        r1 = r0.getText();
        r0 = r7 instanceof android.widget.Switch;
        if (r0 == 0) goto L_0x00c5;
    L_0x0010:
        r7 = (android.widget.Switch) r7;
        r7 = r7.isChecked();
        if (r7 == 0) goto L_0x001d;
    L_0x0018:
        r7 = "1";
    L_0x001a:
        r1 = r7;
        goto L_0x00c5;
    L_0x001d:
        r7 = "0";
        goto L_0x001a;
    L_0x0020:
        r0 = r7 instanceof android.widget.Spinner;
        if (r0 == 0) goto L_0x0032;
    L_0x0024:
        r7 = (android.widget.Spinner) r7;
        r7 = r7.getSelectedItem();
        if (r7 == 0) goto L_0x00c5;
    L_0x002c:
        r1 = r7.toString();
        goto L_0x00c5;
    L_0x0032:
        r0 = r7 instanceof android.widget.DatePicker;
        r2 = 2;
        r3 = 1;
        r4 = 0;
        if (r0 == 0) goto L_0x0063;
    L_0x0039:
        r7 = (android.widget.DatePicker) r7;
        r0 = r7.getYear();
        r1 = r7.getMonth();
        r7 = r7.getDayOfMonth();
        r5 = "%04d-%02d-%02d";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r0 = java.lang.Integer.valueOf(r0);
        r6[r4] = r0;
        r0 = java.lang.Integer.valueOf(r1);
        r6[r3] = r0;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r2] = r7;
        r1 = java.lang.String.format(r5, r6);
        goto L_0x00c5;
    L_0x0063:
        r0 = r7 instanceof android.widget.TimePicker;
        if (r0 == 0) goto L_0x008e;
    L_0x0067:
        r7 = (android.widget.TimePicker) r7;
        r0 = r7.getCurrentHour();
        r0 = r0.intValue();
        r7 = r7.getCurrentMinute();
        r7 = r7.intValue();
        r1 = "%02d:%02d";
        r2 = new java.lang.Object[r2];
        r0 = java.lang.Integer.valueOf(r0);
        r2[r4] = r0;
        r7 = java.lang.Integer.valueOf(r7);
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x00c5;
    L_0x008e:
        r0 = r7 instanceof android.widget.RadioGroup;
        if (r0 == 0) goto L_0x00b7;
    L_0x0092:
        r7 = (android.widget.RadioGroup) r7;
        r0 = r7.getCheckedRadioButtonId();
        r2 = r7.getChildCount();
    L_0x009c:
        if (r4 >= r2) goto L_0x00c5;
    L_0x009e:
        r3 = r7.getChildAt(r4);
        r5 = r3.getId();
        if (r5 != r0) goto L_0x00b4;
    L_0x00a8:
        r5 = r3 instanceof android.widget.RadioButton;
        if (r5 == 0) goto L_0x00b4;
    L_0x00ac:
        r3 = (android.widget.RadioButton) r3;
        r7 = r3.getText();
        goto L_0x001a;
    L_0x00b4:
        r4 = r4 + 1;
        goto L_0x009c;
    L_0x00b7:
        r0 = r7 instanceof android.widget.RatingBar;
        if (r0 == 0) goto L_0x00c5;
    L_0x00bb:
        r7 = (android.widget.RatingBar) r7;
        r7 = r7.getRating();
        r1 = java.lang.String.valueOf(r7);
    L_0x00c5:
        if (r1 != 0) goto L_0x00ca;
    L_0x00c7:
        r7 = "";
        goto L_0x00ce;
    L_0x00ca:
        r7 = r1.toString();
    L_0x00ce:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.d.l(android.view.View):java.lang.String");
    }

    public static String m(View view) {
        Object hint = view instanceof TextView ? ((TextView) view).getHint() : view instanceof EditText ? ((EditText) view).getHint() : null;
        if (hint == null) {
            return "";
        }
        return hint.toString();
    }

    private static JSONObject n(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("scrollx", view.getScrollX());
            jSONObject.put("scrolly", view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (Throwable e) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e);
        }
        return jSONObject;
    }

    @Nullable
    public static AccessibilityDelegate o(View view) {
        try {
            return (AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (NullPointerException unused2) {
            return null;
        } catch (SecurityException unused3) {
            return null;
        } catch (IllegalAccessException unused4) {
            return null;
        } catch (InvocationTargetException unused5) {
            return null;
        }
    }
}
