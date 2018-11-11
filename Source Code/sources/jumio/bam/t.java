package jumio.bam;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import com.jumio.bam.R;
import com.jumio.commons.adapter.ResetableArrayAdapter;
import com.jumio.commons.view.CompatibilityLayer;
import java.util.ArrayList;

/* compiled from: SelectionInputView */
public class t extends p {
    protected ArrayList<String> a;
    protected boolean b;
    protected boolean c = true;
    protected TextInputLayout d;
    protected AutoCompleteTextView e;
    private String f;

    public t(final Context context, final boolean z, String str) {
        super(context);
        this.b = z;
        this.f = str;
        setLayoutParams(new LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(16);
        this.e = (AutoCompleteTextView) LayoutInflater.from(getContext()).inflate(R.layout.bam_custom_field_auto_complete, null);
        this.e.setKeyListener(null);
        this.e.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(t.this.e.getWindowToken(), 0);
                }
                ((AutoCompleteTextView) view).showDropDown();
            }
        });
        this.e.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ((AutoCompleteTextView) view).showDropDown();
                return false;
            }
        });
        Drawable drawable = CompatibilityLayer.getDrawable(context.getResources(), R.drawable.abc_spinner_mtrl_am_alpha);
        drawable.setColorFilter(this.o, Mode.MULTIPLY);
        this.e.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        this.e.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!z && i == 0) {
                    t.this.e.setText(null);
                }
                if (t.this.getVisibility() == 0) {
                    t.this.b();
                }
            }
        });
        r3 = new int[2][];
        r3[0] = new int[]{16842908};
        r3[1] = new int[0];
        this.e.setTextColor(new ColorStateList(r3, new int[]{this.n, this.o}));
        this.e.setTextSize(2, 20.0f);
        ViewGroup.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        this.d = new TextInputLayout(context);
        this.d.setLayoutParams(layoutParams);
        this.d.addView(this.e);
        this.d.setHintTextAppearance(R.style.BamManualEntryTextInputLayoutHint);
        addView(this.d);
    }

    public void setLabelId(int i) {
        this.d.setId(i);
    }

    public void setValueId(int i) {
        this.e.setId(i);
    }

    public void setLabelText(CharSequence charSequence) {
        this.d.setHint(charSequence);
        this.e.setContentDescription(charSequence);
    }

    public void setValues(ArrayList<String> arrayList) {
        this.a = arrayList;
        ListAdapter resetableArrayAdapter = new ResetableArrayAdapter(getContext(), arrayList);
        resetableArrayAdapter.setResetable(this.b ^ 1);
        resetableArrayAdapter.setResetText(this.f);
        resetableArrayAdapter.setPromptColor(this.o);
        resetableArrayAdapter.setTextColor(this.o);
        this.e.setAdapter(resetableArrayAdapter);
        this.e.setSelection(0);
    }

    public boolean a() {
        return (this.b && (this.e.getText() == null || this.e.getText().length() == 0)) ? false : true;
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
        Object text = this.e.getText();
        if (text == null) {
            text = "";
        }
        return new SpannableStringBuilder(text.toString());
    }

    public void setEnabled(boolean z) {
        this.d.setEnabled(z);
        this.e.setEnabled(z);
    }
}
