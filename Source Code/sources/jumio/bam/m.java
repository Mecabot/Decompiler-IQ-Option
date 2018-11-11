package jumio.bam;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.TransformationMethod;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import com.jumio.bam.R;
import com.jumio.commons.utils.ScreenUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CardDetailView */
public class m extends p {
    protected Pattern a;
    protected boolean b;
    protected TextInputLayout c;
    protected EditText d;
    protected a e;
    protected ColorStateList f;

    /* compiled from: CardDetailView */
    public class a implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (m.this.getVisibility() == 0) {
                m.this.b();
            }
        }
    }

    public m(Context context) {
        this(context, -1);
    }

    public m(Context context, int i) {
        super(context);
        this.e = null;
        this.b = true;
        setLayoutParams(new LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(16);
        this.e = new a();
        r6 = new int[2][];
        r6[0] = new int[]{16842908};
        r6[1] = new int[0];
        this.f = new ColorStateList(r6, new int[]{this.n, this.o});
        LayoutInflater from = LayoutInflater.from(getContext());
        if (i == -1) {
            i = R.layout.bam_custom_field_edit_text;
        }
        this.d = (EditText) from.inflate(i, null);
        this.d.setTextSize(2, 20.0f);
        this.d.addTextChangedListener(this.e);
        this.d.setPadding(this.d.getPaddingLeft(), ScreenUtil.dpToPx(context, 2), this.d.getRight(), this.d.getPaddingBottom());
        a(false);
        ViewGroup.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        this.c = new TextInputLayout(context);
        this.c.setLayoutParams(layoutParams);
        this.c.addView(this.d);
        this.c.setHintTextAppearance(R.style.BamManualEntryTextInputLayoutHint);
        addView(this.c);
    }

    public void setValueId(int i) {
        this.d.setId(i);
    }

    public void setLabelText(CharSequence charSequence) {
        this.c.setHint(charSequence);
        this.d.setContentDescription(charSequence);
    }

    public void setValueText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    public void setTypeface(Typeface typeface) {
        this.d.setTypeface(typeface);
    }

    public void setValidationPattern(String str) {
        if (str == null || str.length() == 0) {
            this.a = null;
        } else {
            this.a = Pattern.compile(str);
        }
    }

    public void setValidationPattern(Pattern pattern) {
        this.a = pattern;
    }

    public boolean a() {
        if (this.a == null) {
            return true;
        }
        Matcher matcher = this.a.matcher(this.d.getText());
        if (this.b) {
            a(true ^ matcher.matches());
        }
        return matcher.matches();
    }

    protected void b() {
        boolean a = a();
        if (this.p == null) {
            return;
        }
        if (a) {
            this.p.a(this);
        } else {
            this.p.b(this);
        }
    }

    public Editable getValueText() {
        return this.d.getText();
    }

    public void setTransformationMethod(TransformationMethod transformationMethod) {
        this.d.setTransformationMethod(transformationMethod);
    }

    public void setKeyListener(KeyListener keyListener) {
        this.d.setKeyListener(keyListener);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.d.setFilters(inputFilterArr);
    }

    public void setInputType(int i) {
        this.d.setInputType(i);
    }

    public void a(TextWatcher textWatcher) {
        this.d.addTextChangedListener(textWatcher);
    }

    public void setEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    public void c() {
        a(this.d);
    }

    protected void a(EditText editText) {
        editText.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        editText.setCustomSelectionActionModeCallback(new Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
    }

    protected void a(boolean z) {
        if (z) {
            this.d.setTextColor(this.m);
        } else {
            this.d.setTextColor(this.f);
        }
    }
}
