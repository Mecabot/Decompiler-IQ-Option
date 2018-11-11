package com.iqoption.fragment.cashbox.a;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.iqoption.fragment.cashbox.o;
import com.iqoption.view.text.x;
import com.iqoption.widget.helper.ErrorBubbleHelper;
import com.iqoption.widget.helper.ErrorBubbleHelper.BubbleGravity;
import com.iqoption.x.R;

/* compiled from: ExtraParamStringBaseView */
public abstract class f extends b {
    protected final EditText aMM;
    private final boolean bXe;
    private final ErrorBubbleHelper cxj;
    private String cyh = "";
    protected final String cyl;
    protected final int cym;
    protected final int cyn;
    private o cyp;
    private String cyq = "";
    protected final int textColor;

    public f(Context context, String str, String str2, boolean z, String str3) {
        super(context);
        this.cyl = str;
        this.cyn = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_height);
        this.cym = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_width);
        this.textColor = ContextCompat.getColor(context, R.color.deposit_constructor_field_text);
        this.aMM = bp(context);
        this.bXe = z;
        if (str == null) {
            str = "";
        } else {
            str = str.toLowerCase();
        }
        this.cyq = str;
        this.cyh = str3;
        setOrientation(1);
        setLayoutParams(new LayoutParams(this.cym, -2));
        addView(v(context, str2));
        addView(this.aMM);
        this.cxj = new ErrorBubbleHelper(getContext(), (LayoutInflater) context.getSystemService("layout_inflater"));
    }

    protected EditText bp(Context context) {
        EditText editText = (EditText) LayoutInflater.from(context).inflate(R.layout.constructor_text_edit_field_old, this, false);
        editText.addTextChangedListener(new x() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.dj(false);
                super.beforeTextChanged(charSequence, i, i2, i3);
            }
        });
        editText.setTag(getExtraParamName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deposit-by-");
        stringBuilder.append(this.cyh);
        stringBuilder.append("_");
        stringBuilder.append(this.cyq);
        this.cyp = new o(editText, stringBuilder.toString());
        return editText;
    }

    public String getExtraParamName() {
        return this.cyl;
    }

    public String getExtraParamValue() {
        return this.aMM == null ? null : this.aMM.getText().toString();
    }

    public void dj(boolean z) {
        if ((z && !Boolean.TRUE.equals(this.aMM.getTag(R.id.errorTag))) || (!z && Boolean.TRUE.equals(this.aMM.getTag(R.id.errorTag)))) {
            int paddingLeft = this.aMM.getPaddingLeft();
            int paddingTop = this.aMM.getPaddingTop();
            int paddingRight = this.aMM.getPaddingRight();
            int paddingBottom = this.aMM.getPaddingBottom();
            this.aMM.setBackgroundResource(z ? R.drawable.deposit_card_red_border : R.drawable.deposit_card_white_border);
            this.aMM.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            this.aMM.setTag(R.id.errorTag, Boolean.valueOf(z));
        }
    }

    public boolean isValid() {
        return (this.bXe && TextUtils.isEmpty(getExtraParamValue())) ? false : true;
    }

    public boolean f(boolean z, String str) {
        if (z) {
            return this.cxj.a(this.aMM, this.cxj.e(getContext(), this.aMM) ? BubbleGravity.bottom : BubbleGravity.top, str);
        }
        this.cxj.akr();
        return false;
    }
}
