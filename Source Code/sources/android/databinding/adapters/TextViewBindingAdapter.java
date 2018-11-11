package android.databinding.adapters;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TextKeyListener.Capitalize;
import android.util.Log;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.android.a.a.a.c.a;

@BindingMethods({@BindingMethod(attribute = "android:autoLink", method = "setAutoLinkMask", type = TextView.class), @BindingMethod(attribute = "android:drawablePadding", method = "setCompoundDrawablePadding", type = TextView.class), @BindingMethod(attribute = "android:editorExtras", method = "setInputExtras", type = TextView.class), @BindingMethod(attribute = "android:inputType", method = "setRawInputType", type = TextView.class), @BindingMethod(attribute = "android:scrollHorizontally", method = "setHorizontallyScrolling", type = TextView.class), @BindingMethod(attribute = "android:textAllCaps", method = "setAllCaps", type = TextView.class), @BindingMethod(attribute = "android:textColorHighlight", method = "setHighlightColor", type = TextView.class), @BindingMethod(attribute = "android:textColorHint", method = "setHintTextColor", type = TextView.class), @BindingMethod(attribute = "android:textColorLink", method = "setLinkTextColor", type = TextView.class), @BindingMethod(attribute = "android:onEditorAction", method = "setOnEditorActionListener", type = TextView.class)})
@RestrictTo({Scope.LIBRARY})
public class TextViewBindingAdapter {
    public static final int DECIMAL = 5;
    public static final int INTEGER = 1;
    public static final int SIGNED = 3;
    private static final String TAG = "TextViewBindingAdapters";

    public interface AfterTextChanged {
        void afterTextChanged(Editable editable);
    }

    public interface BeforeTextChanged {
        void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public interface OnTextChanged {
        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    @BindingAdapter({"android:text"})
    public static void setText(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text && (charSequence != null || text.length() != 0)) {
            if (charSequence instanceof Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!haveContentsChanged(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static String getTextString(TextView textView) {
        return textView.getText().toString();
    }

    @BindingAdapter({"android:autoText"})
    public static void setAutoText(TextView textView, boolean z) {
        KeyListener keyListener = textView.getKeyListener();
        Capitalize capitalize = Capitalize.NONE;
        int inputType = keyListener != null ? keyListener.getInputType() : 0;
        if ((inputType & 4096) != 0) {
            capitalize = Capitalize.CHARACTERS;
        } else if ((inputType & 8192) != 0) {
            capitalize = Capitalize.WORDS;
        } else if ((inputType & 16384) != 0) {
            capitalize = Capitalize.SENTENCES;
        }
        textView.setKeyListener(TextKeyListener.getInstance(z, capitalize));
    }

    @BindingAdapter({"android:capitalize"})
    public static void setCapitalize(TextView textView, Capitalize capitalize) {
        textView.setKeyListener(TextKeyListener.getInstance((textView.getKeyListener().getInputType() & 32768) != 0, capitalize));
    }

    @BindingAdapter({"android:bufferType"})
    public static void setBufferType(TextView textView, BufferType bufferType) {
        textView.setText(textView.getText(), bufferType);
    }

    @BindingAdapter({"android:digits"})
    public static void setDigits(TextView textView, CharSequence charSequence) {
        if (charSequence != null) {
            textView.setKeyListener(DigitsKeyListener.getInstance(charSequence.toString()));
        } else if (textView.getKeyListener() instanceof DigitsKeyListener) {
            textView.setKeyListener(null);
        }
    }

    @BindingAdapter({"android:numeric"})
    public static void setNumeric(TextView textView, int i) {
        boolean z = false;
        boolean z2 = (i & 3) != 0;
        if ((i & 5) != 0) {
            z = true;
        }
        textView.setKeyListener(DigitsKeyListener.getInstance(z2, z));
    }

    @BindingAdapter({"android:phoneNumber"})
    public static void setPhoneNumber(TextView textView, boolean z) {
        if (z) {
            textView.setKeyListener(DialerKeyListener.getInstance());
        } else if (textView.getKeyListener() instanceof DialerKeyListener) {
            textView.setKeyListener(null);
        }
    }

    private static void setIntrinsicBounds(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @BindingAdapter({"android:drawableBottom"})
    public static void setDrawableBottom(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], drawable);
    }

    @BindingAdapter({"android:drawableLeft"})
    public static void setDrawableLeft(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    @BindingAdapter({"android:drawableRight"})
    public static void setDrawableRight(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    @BindingAdapter({"android:drawableTop"})
    public static void setDrawableTop(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
    }

    @BindingAdapter({"android:drawableStart"})
    public static void setDrawableStart(TextView textView, Drawable drawable) {
        if (VERSION.SDK_INT < 17) {
            setDrawableLeft(textView, drawable);
            return;
        }
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    @BindingAdapter({"android:drawableEnd"})
    public static void setDrawableEnd(TextView textView, Drawable drawable) {
        if (VERSION.SDK_INT < 17) {
            setDrawableRight(textView, drawable);
            return;
        }
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], drawable, compoundDrawablesRelative[3]);
    }

    @BindingAdapter({"android:imeActionLabel"})
    public static void setImeActionLabel(TextView textView, CharSequence charSequence) {
        textView.setImeActionLabel(charSequence, textView.getImeActionId());
    }

    @BindingAdapter({"android:imeActionId"})
    public static void setImeActionLabel(TextView textView, int i) {
        textView.setImeActionLabel(textView.getImeActionLabel(), i);
    }

    @BindingAdapter({"android:inputMethod"})
    public static void setInputMethod(TextView textView, CharSequence charSequence) {
        String str;
        StringBuilder stringBuilder;
        try {
            textView.setKeyListener((KeyListener) Class.forName(charSequence.toString()).newInstance());
        } catch (Throwable e) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create input method: ");
            stringBuilder.append(charSequence);
            Log.e(str, stringBuilder.toString(), e);
        } catch (Throwable e2) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create input method: ");
            stringBuilder.append(charSequence);
            Log.e(str, stringBuilder.toString(), e2);
        } catch (Throwable e22) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create input method: ");
            stringBuilder.append(charSequence);
            Log.e(str, stringBuilder.toString(), e22);
        }
    }

    @BindingAdapter({"android:lineSpacingExtra"})
    public static void setLineSpacingExtra(TextView textView, float f) {
        if (VERSION.SDK_INT >= 16) {
            textView.setLineSpacing(f, textView.getLineSpacingMultiplier());
        } else {
            textView.setLineSpacing(f, 1.0f);
        }
    }

    @BindingAdapter({"android:lineSpacingMultiplier"})
    public static void setLineSpacingMultiplier(TextView textView, float f) {
        if (VERSION.SDK_INT >= 16) {
            textView.setLineSpacing(textView.getLineSpacingExtra(), f);
        } else {
            textView.setLineSpacing(0.0f, f);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    @android.databinding.BindingAdapter({"android:maxLength"})
    public static void setMaxLength(android.widget.TextView r7, int r8) {
        /*
        r0 = r7.getFilters();
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0012;
    L_0x0008:
        r0 = new android.text.InputFilter[r2];
        r2 = new android.text.InputFilter$LengthFilter;
        r2.<init>(r8);
        r0[r1] = r2;
        goto L_0x0051;
    L_0x0012:
        r3 = 0;
    L_0x0013:
        r4 = r0.length;
        if (r3 >= r4) goto L_0x003c;
    L_0x0016:
        r4 = r0[r3];
        r5 = r4 instanceof android.text.InputFilter.LengthFilter;
        if (r5 == 0) goto L_0x0039;
    L_0x001c:
        r5 = android.os.Build.VERSION.SDK_INT;
        r6 = 21;
        if (r5 < r6) goto L_0x002d;
    L_0x0022:
        r4 = (android.text.InputFilter.LengthFilter) r4;
        r4 = r4.getMax();
        if (r4 == r8) goto L_0x002b;
    L_0x002a:
        goto L_0x002d;
    L_0x002b:
        r4 = 0;
        goto L_0x002e;
    L_0x002d:
        r4 = 1;
    L_0x002e:
        if (r4 == 0) goto L_0x0037;
    L_0x0030:
        r4 = new android.text.InputFilter$LengthFilter;
        r4.<init>(r8);
        r0[r3] = r4;
    L_0x0037:
        r3 = 1;
        goto L_0x003d;
    L_0x0039:
        r3 = r3 + 1;
        goto L_0x0013;
    L_0x003c:
        r3 = 0;
    L_0x003d:
        if (r3 != 0) goto L_0x0051;
    L_0x003f:
        r3 = r0.length;
        r3 = r3 + r2;
        r3 = new android.text.InputFilter[r3];
        r4 = r0.length;
        java.lang.System.arraycopy(r0, r1, r3, r1, r4);
        r0 = r3.length;
        r0 = r0 - r2;
        r1 = new android.text.InputFilter$LengthFilter;
        r1.<init>(r8);
        r3[r0] = r1;
        r0 = r3;
    L_0x0051:
        r7.setFilters(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.databinding.adapters.TextViewBindingAdapter.setMaxLength(android.widget.TextView, int):void");
    }

    @BindingAdapter({"android:password"})
    public static void setPassword(TextView textView, boolean z) {
        if (z) {
            textView.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textView.setTransformationMethod(null);
        }
    }

    @BindingAdapter({"android:shadowColor"})
    public static void setShadowColor(TextView textView, int i) {
        if (VERSION.SDK_INT >= 16) {
            textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), textView.getShadowDy(), i);
        }
    }

    @BindingAdapter({"android:shadowDx"})
    public static void setShadowDx(TextView textView, float f) {
        if (VERSION.SDK_INT >= 16) {
            int shadowColor = textView.getShadowColor();
            textView.setShadowLayer(textView.getShadowRadius(), f, textView.getShadowDy(), shadowColor);
        }
    }

    @BindingAdapter({"android:shadowDy"})
    public static void setShadowDy(TextView textView, float f) {
        if (VERSION.SDK_INT >= 16) {
            int shadowColor = textView.getShadowColor();
            textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), f, shadowColor);
        }
    }

    @BindingAdapter({"android:shadowRadius"})
    public static void setShadowRadius(TextView textView, float f) {
        if (VERSION.SDK_INT >= 16) {
            textView.setShadowLayer(f, textView.getShadowDx(), textView.getShadowDy(), textView.getShadowColor());
        }
    }

    @BindingAdapter({"android:textSize"})
    public static void setTextSize(TextView textView, float f) {
        textView.setTextSize(0, f);
    }

    private static boolean haveContentsChanged(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null ? 1 : null) != (charSequence2 == null ? 1 : null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    @BindingAdapter(requireAll = false, value = {"android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged", "android:textAttrChanged"})
    public static void setTextWatcher(TextView textView, final BeforeTextChanged beforeTextChanged, final OnTextChanged onTextChanged, final AfterTextChanged afterTextChanged, final InverseBindingListener inverseBindingListener) {
        TextWatcher textWatcher;
        if (beforeTextChanged == null && afterTextChanged == null && onTextChanged == null && inverseBindingListener == null) {
            textWatcher = null;
        } else {
            textWatcher = new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (beforeTextChanged != null) {
                        beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                    }
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (onTextChanged != null) {
                        onTextChanged.onTextChanged(charSequence, i, i2, i3);
                    }
                    if (inverseBindingListener != null) {
                        inverseBindingListener.onChange();
                    }
                }

                public void afterTextChanged(Editable editable) {
                    if (afterTextChanged != null) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            };
        }
        TextWatcher textWatcher2 = (TextWatcher) ListenerUtil.trackListener(textView, textWatcher, a.textWatcher);
        if (textWatcher2 != null) {
            textView.removeTextChangedListener(textWatcher2);
        }
        if (textWatcher != null) {
            textView.addTextChangedListener(textWatcher);
        }
    }
}
