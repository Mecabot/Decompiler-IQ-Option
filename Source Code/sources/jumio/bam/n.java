package jumio.bam;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.jumio.bam.R;
import com.jumio.bam.gui.ExpiryEditText;
import com.jumio.commons.log.Log;
import com.jumio.core.data.Strings;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;

/* compiled from: ExpiryDetailView */
public class n extends m {
    private boolean q = false;
    private OnFocusChangeListener r = new OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                n.this.q = false;
            } else if (!n.this.q) {
                n.this.q = true;
            }
        }
    };

    public void setValueId(int i) {
    }

    public void setValueText(CharSequence charSequence) {
    }

    public n(Context context) {
        super(context, R.layout.bam_custom_field_expiry_edit_text);
        String externalString = Strings.getExternalString(context, "manual_entry_hint_month");
        String externalString2 = Strings.getExternalString(context, "manual_entry_hint_year");
        if (externalString.length() > 2) {
            externalString = externalString.substring(0, 2);
        }
        if (externalString2.length() > 2) {
            externalString2 = externalString2.substring(0, 2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(externalString);
        stringBuilder.append("/");
        stringBuilder.append(externalString2);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(externalString);
        stringBuilder3.append(externalString2);
        ((ExpiryEditText) this.d).a(stringBuilder2, a(stringBuilder3.toString()));
        this.b = false;
        this.d.setId(R.id.expiryValueEditText);
        this.d.setInputType(2);
        setValidationPattern(ab.a());
    }

    private Character[] a(String str) {
        Set linkedHashSet = new LinkedHashSet();
        for (char valueOf : str.toCharArray()) {
            linkedHashSet.add(Character.valueOf(valueOf));
        }
        return (Character[]) linkedHashSet.toArray(new Character[linkedHashSet.size()]);
    }

    public boolean a() {
        if (this.a == null) {
            return true;
        }
        Matcher matcher = this.a.matcher(this.d.getText());
        if (this.b) {
            a(true ^ matcher.matches());
        }
        boolean matches = matcher.matches();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isExpiryValid: ");
        stringBuilder.append(matches);
        Log.d(stringBuilder.toString());
        return matches;
    }

    public void a(char[] cArr, char[] cArr2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cArr);
        stringBuilder.append(cArr2);
        ((r) this.d).setMaskedText(stringBuilder.toString());
    }

    public Editable getMonthText() {
        return new SpannableStringBuilder(this.d.getText().toString().substring(0, 2));
    }

    public Editable getYearText() {
        return new SpannableStringBuilder(this.d.getText().toString().substring(3, 5));
    }
}
