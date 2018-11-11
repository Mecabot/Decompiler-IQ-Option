package com.iqoption.view.text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.iqoption.b.b;
import com.iqoption.core.i;
import com.iqoption.util.am;
import com.iqoption.util.am.a;

public class SoftKeyboardEditText extends EditText implements a {
    private static final String TAG = SoftKeyboardEditText.class.getCanonicalName();
    private boolean dJD;
    private boolean dJE;
    @Nullable
    private a dJF;
    @Nullable
    private h dJG;

    private enum Formatter {
        none,
        phone,
        phoneWithPlusSign,
        date
    }

    public void setValidationListener(z zVar) {
    }

    public SoftKeyboardEditText(Context context) {
        super(context);
    }

    public SoftKeyboardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public SoftKeyboardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public SoftKeyboardEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(context, attributeSet);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dJE) {
            this.dJF = new a() {
                public void cp(boolean z) {
                    if (z && SoftKeyboardEditText.this.dJE) {
                        SoftKeyboardEditText.this.fq(false);
                    }
                }
            };
            am.a(this.dJF);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dJF != null) {
            am.b(this.dJF);
            this.dJF = null;
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.SoftKeyboardEditText, 0, 0);
        try {
            setFormatter(Formatter.values()[obtainStyledAttributes.getInt(0, 0)]);
            this.dJE = obtainStyledAttributes.getBoolean(1, false);
            if (this.dJE) {
                am.b((EditText) this, false);
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setHideKeyboard(boolean z) {
        this.dJE = z;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onFocusChanged focused=");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        fq(z);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.dJD) {
            clearFocus();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void fq(boolean z) {
        j(z, false);
    }

    private void j(boolean z, boolean z2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showKeyboard showAnimation=");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        if (!z) {
            am.a(getContext(), this);
            if (!z2) {
                clearFocus();
            }
        } else if (!this.dJE) {
            am.b(getContext(), (View) this);
        }
        this.dJD = z;
    }

    public void clearFocus() {
        super.clearFocus();
        j(false, true);
    }

    public void onEditorAction(int i) {
        if (i == 6) {
            fq(false);
        } else {
            super.onEditorAction(i);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            fq(false);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            if (i == 23) {
                fq(true);
            } else if (i == 66) {
                fq(false);
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void cp(boolean z) {
        if (!z) {
            clearFocus();
        }
        this.dJD = z;
    }

    private void setFormatter(Formatter formatter) {
        switch (formatter) {
            case phone:
                aJO();
                return;
            case phoneWithPlusSign:
                addTextChangedListener(new a());
                aJO();
                return;
            case date:
                aJP();
                return;
            default:
                return;
        }
    }

    private void aJO() {
        if (!isInEditMode()) {
            if (VERSION.SDK_INT >= 21) {
                addTextChangedListener(new PhoneNumberFormattingTextWatcher());
            } else {
                addTextChangedListener(new t());
            }
        }
    }

    private void aJP() {
        if (!isInEditMode()) {
            this.dJG = new h();
            addTextChangedListener(this.dJG);
        }
    }

    @Nullable
    public w getTextDateValidator() {
        return this.dJG;
    }
}
