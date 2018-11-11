package jumio.bam;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView.BufferType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MaskedEditText */
public class r extends AppCompatEditText implements OnFocusChangeListener, OnTouchListener {
    private Context a;
    private String b;
    private Character[] c;
    private String d;
    private boolean e;
    private ArrayList<Integer> f = new ArrayList();
    private Integer g = Integer.valueOf(0);
    private Integer h = Integer.valueOf(0);
    private Drawable i;
    private OnFocusChangeListener j;
    private a k;
    private String l;
    private b m;

    /* compiled from: MaskedEditText */
    public interface a {
        void a();
    }

    /* compiled from: MaskedEditText */
    class b implements InputFilter {
        private boolean b = true;
        private boolean c = false;

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.c) {
                return charSequence;
            }
            StringBuilder stringBuilder = new StringBuilder();
            boolean c = c(i3);
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                String a = r.this.a(i3, String.valueOf(charAt), spanned.toString());
                if (a == null) {
                    return "";
                }
                if (c) {
                    this.b = false;
                    if (a.length() + i3 <= r.this.getText().length()) {
                        r.this.getText().replace(i3, a.length() + i3, "");
                    }
                    this.b = true;
                    stringBuilder.append(a);
                    int i5 = i3 + 1;
                    if (c(i5)) {
                        i5 = i3;
                    }
                    a(i5);
                } else if (i3 != r.this.b.length()) {
                    int a2 = a(!c(i3) ? i3 + 1 : i3);
                    r.this.getText().replace(a2, a2, Character.toString(charAt));
                }
                i++;
            }
            if (this.b && TextUtils.isEmpty(charSequence) && i4 != 0) {
                stringBuilder.append(r.this.b.charAt(i3));
                b(i3);
            }
            return stringBuilder.toString();
        }

        private int a(int i) {
            i = a(i, false);
            if (i > r.this.h.intValue()) {
                i = r.this.h.intValue();
            }
            r.this.setSelection(i);
            return i;
        }

        private void b(int i) {
            r.this.setSelection(a(i, true));
        }

        private int a(int i, boolean z) {
            if (!r.this.f.contains(Integer.valueOf(i))) {
                return b(i, z);
            }
            ListIterator listIterator = r.this.f.listIterator(r.this.f.indexOf(Integer.valueOf(i)));
            if (z) {
                if (listIterator.hasPrevious()) {
                    return ((Integer) listIterator.previous()).intValue() + 1;
                }
            } else if (listIterator.hasNext()) {
                return ((Integer) listIterator.next()).intValue();
            }
            return i;
        }

        private int b(int i, boolean z) {
            ListIterator listIterator;
            Integer num;
            if (z) {
                listIterator = r.this.f.listIterator(r.this.f.size() - 1);
                while (listIterator.hasPrevious()) {
                    num = (Integer) listIterator.previous();
                    if (num.intValue() <= i) {
                        return num.intValue() + 1;
                    }
                }
                return r.this.g.intValue();
            } else if (i <= r.this.g.intValue()) {
                return r.this.g.intValue();
            } else {
                listIterator = r.this.f.listIterator();
                while (listIterator.hasNext()) {
                    num = (Integer) listIterator.next();
                    if (num.intValue() >= i) {
                        return num.intValue() - 1;
                    }
                }
                return r.this.h.intValue();
            }
        }

        private boolean c(int i) {
            return i < r.this.b.length() && r.this.a(r.this.b.charAt(i), r.this.c);
        }

        public void a(boolean z) {
            this.c = z;
        }
    }

    public String a(int i, String str, String str2) {
        return null;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }

    public r(Context context) {
        super(context);
        a(context, "", new Character[0], null, null, null);
    }

    public r(Context context, String str, Character[] chArr) {
        super(context);
        a(context, str, chArr, null, null, null);
    }

    public r(Context context, String str, Character[] chArr, Drawable drawable) {
        super(context);
        a(context, str, chArr, null, drawable, null);
    }

    public r(Context context, String str, Character[] chArr, Drawable drawable, a aVar) {
        super(context);
        a(context, str, chArr, null, drawable, aVar);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    protected void a(Context context, AttributeSet attributeSet) {
        a(context, "", new Character[0], attributeSet, null, null);
    }

    private void a(Context context, String str, Character[] chArr, AttributeSet attributeSet, Drawable drawable, a aVar) {
        this.a = context;
        this.i = drawable;
        this.k = aVar;
        a(str, chArr);
        b();
        setLongClickable(false);
        setSingleLine(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void a(String str, Character[] chArr) {
        this.b = str;
        this.c = (Character[]) Arrays.copyOf(chArr, chArr.length);
        a();
    }

    private void a() {
        if (TextUtils.isEmpty(this.b) || this.c.length == 0) {
            System.err.println("Mask not correct initialised ");
            return;
        }
        this.d = "";
        b(this.b, this.c);
        this.l = this.b;
        setText(this.l, BufferType.NORMAL);
        this.m = new b();
        setFilters(new InputFilter[]{this.m, new LengthFilter(this.b.length())});
    }

    private void b() {
        if (this.i != null) {
            this.i.setBounds(0, 0, this.i.getIntrinsicHeight(), this.i.getIntrinsicHeight());
            Drawable[] compoundDrawables = getCompoundDrawables();
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], this.i, compoundDrawables[3]);
        }
        super.setOnFocusChangeListener(this);
        super.setOnTouchListener(this);
    }

    private void b(String str, Character[] chArr) {
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (a(toCharArray[i], chArr)) {
                this.f.add(Integer.valueOf(i));
            }
        }
        this.g = (Integer) this.f.get(0);
        this.h = (Integer) this.f.get(this.f.size() - 1);
    }

    public boolean a(char c, Character[] chArr) {
        for (Character charValue : chArr) {
            if (charValue.charValue() == c) {
                return true;
            }
        }
        return false;
    }

    public void setInputType(int i) {
        if (i == -1) {
            i = 524416;
        }
        if (i == 2 || i == 4096 || i == 8192 || i == 3) {
            String symbolExceptions = getSymbolExceptions();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0123456789.");
            stringBuilder.append(symbolExceptions);
            setKeyListener(DigitsKeyListener.getInstance(stringBuilder.toString()));
            return;
        }
        super.setInputType(i);
    }

    private String getSymbolExceptions() {
        if (TextUtils.isEmpty(this.l)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : this.l.toCharArray()) {
            if (!Character.isDigit(c) && stringBuilder.indexOf(String.valueOf(c)) == -1) {
                stringBuilder.append(c);
            }
        }
        stringBuilder.append("");
        return stringBuilder.toString();
    }

    public String getUnmaskedText() {
        Editable text = super.getText();
        if (this.b == null || this.b.isEmpty()) {
            return text.toString().trim();
        }
        Editable spannableStringBuilder = new SpannableStringBuilder();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (text != null && text.length() > 0 && num.intValue() < text.length()) {
                spannableStringBuilder.append(text.charAt(num.intValue()));
            }
        }
        if (this.d == null || this.d.isEmpty()) {
            return spannableStringBuilder.toString().trim();
        }
        return a(spannableStringBuilder.toString(), this.d);
    }

    public void setMaskedText(String str) {
        if (str != null) {
            CharSequence stringBuilder = new StringBuilder(str);
            if (stringBuilder.length() < this.f.size()) {
                while (stringBuilder.length() < this.f.size()) {
                    stringBuilder.append("");
                }
            } else if (stringBuilder.length() > this.f.size()) {
                stringBuilder.replace(this.f.size(), stringBuilder.length(), "");
            }
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
            if (getText() != null) {
                for (int i = 0; i < this.b.length(); i++) {
                    if (!this.f.contains(Integer.valueOf(i))) {
                        stringBuilder2.insert(i, String.valueOf(this.b.charAt(i)));
                    }
                }
                this.m.a(true);
                setText(stringBuilder2.toString());
                this.m.a(false);
            }
        }
    }

    private String a(String str, String str2) {
        Matcher matcher = Pattern.compile("(\\[[\\d]+\\])").matcher(str2);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, b(str, matcher.group()));
        }
        return stringBuffer.toString();
    }

    private String b(String str, String str2) {
        return String.valueOf(str.toCharArray()[Integer.valueOf(str2.replace("[", "").replace("]", "")).intValue() - 1]);
    }

    public void setFormat(String str) {
        this.d = str;
    }

    public void setRequired(boolean z) {
        this.e = z;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.j = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.j != null) {
            this.j.onFocusChange(view, z);
        }
        if (z) {
            setSelection(this.g.intValue());
            requestFocus();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        if (this.i != null && this.i.isVisible() && x > (getWidth() - getPaddingRight()) - this.i.getIntrinsicWidth()) {
            if (motionEvent.getAction() == 1) {
                this.k.a();
            }
            return true;
        } else if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 0) || !TextUtils.isEmpty(getUnmaskedText())) {
            return false;
        } else {
            setSelection(this.g.intValue());
            requestFocus();
            ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(this, 1);
            return true;
        }
    }

    public void setMaskIconCallback(a aVar) {
        this.k = aVar;
    }
}
