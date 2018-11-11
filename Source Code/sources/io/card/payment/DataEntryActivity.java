package io.card.payment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DateKeyListener;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jumio.gui.Drawables;
import io.card.payment.a.a;
import io.card.payment.a.c;
import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.b;

public final class DataEntryActivity extends Activity implements TextWatcher {
    private static final String TAG = "DataEntryActivity";
    private boolean ejT;
    private n ekA;
    private EditText ekB;
    private n ekC;
    private EditText ekD;
    private n ekE;
    private EditText ekF;
    private n ekG;
    private ImageView ekH;
    private Button ekI;
    private Button ekJ;
    private CreditCard ekK;
    private boolean ekL;
    private String ekM;
    private int ekN;
    private int eku = 1;
    private int ekv = 100;
    private TextView ekw;
    private EditText ekx;
    private n eky;
    private EditText ekz;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            onBackPressed();
            return;
        }
        View linearLayout;
        View view;
        LayoutParams layoutParams;
        View textView;
        LayoutParams layoutParams2;
        this.ejT = getIntent().getBooleanExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME, false);
        a.a(this, this.ejT);
        this.ekN = new TextView(this).getTextColors().getDefaultColor();
        this.ekM = a.aUa() ? "12dip" : "2dip";
        b.y(getIntent());
        int f = c.f("4dip", this);
        View relativeLayout = new RelativeLayout(this);
        if (!this.ejT) {
            relativeLayout.setBackgroundColor(io.card.payment.a.b.elF);
        }
        View scrollView = new ScrollView(this);
        int i = this.eku;
        this.eku = i + 1;
        scrollView.setId(i);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10);
        relativeLayout.addView(scrollView, layoutParams3);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        scrollView.addView(linearLayout2, -1, -1);
        scrollView = new LinearLayout(this);
        scrollView.setOrientation(1);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        this.ekK = (CreditCard) getIntent().getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
        this.ekL = getIntent().getBooleanExtra("debug_autoAcceptResult", false);
        if (this.ekK != null) {
            this.eky = new b(this.ekK.cardNumber);
            this.ekH = new ImageView(this);
            LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            this.ekH.setPadding(0, 0, 0, f);
            layoutParams5.weight = 1.0f;
            this.ekH.setImageBitmap(CardIOActivity.ejX);
            scrollView.addView(this.ekH, layoutParams5);
            c.b(this.ekH, null, null, null, "8dip");
        } else {
            this.ekw = new TextView(this);
            this.ekw.setTextSize(24.0f);
            if (!this.ejT) {
                this.ekw.setTextColor(io.card.payment.a.b.elB);
            }
            scrollView.addView(this.ekw);
            c.a(this.ekw, null, null, null, "8dip");
            c.h(this.ekw, -2, -2);
            linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            c.a(linearLayout, null, "4dip", null, "4dip");
            View textView2 = new TextView(this);
            c.a(textView2, this.ekM, null, null, null);
            textView2.setText(b.a(StringKey.ENTRY_CARD_NUMBER));
            if (!this.ejT) {
                textView2.setTextColor(io.card.payment.a.b.elQ);
            }
            linearLayout.addView(textView2, -2, -2);
            this.ekx = new EditText(this);
            EditText editText = this.ekx;
            int i2 = this.ekv;
            this.ekv = i2 + 1;
            editText.setId(i2);
            this.ekx.setMaxLines(1);
            this.ekx.setImeOptions(6);
            this.ekx.setTextAppearance(getApplicationContext(), 16842816);
            this.ekx.setInputType(3);
            this.ekx.setHint("1234 5678 1234 5678");
            if (!this.ejT) {
                this.ekx.setHintTextColor(Drawables.DEFAULT_LIST_ROW_COLOR_PRESSED);
            }
            this.eky = new b();
            this.ekx.addTextChangedListener(this.eky);
            this.ekx.addTextChangedListener(this);
            this.ekx.setFilters(new InputFilter[]{new DigitsKeyListener(), this.eky});
            linearLayout.addView(this.ekx, -1, -2);
            scrollView.addView(linearLayout, -1, -1);
        }
        linearLayout = new LinearLayout(this);
        LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        c.a(linearLayout, null, "4dip", null, "4dip");
        linearLayout.setOrientation(0);
        boolean booleanExtra = getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false);
        boolean booleanExtra3 = getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false);
        if (booleanExtra) {
            View linearLayout3 = new LinearLayout(this);
            view = relativeLayout;
            layoutParams = layoutParams3;
            LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            linearLayout3.setOrientation(1);
            textView = new TextView(this);
            if (!this.ejT) {
                textView.setTextColor(io.card.payment.a.b.elQ);
            }
            textView.setText(b.a(StringKey.ENTRY_EXPIRES));
            c.a(textView, this.ekM, null, null, null);
            linearLayout3.addView(textView, -2, -2);
            this.ekz = new EditText(this);
            EditText editText2 = this.ekz;
            i = this.ekv;
            this.ekv = i + 1;
            editText2.setId(i);
            this.ekz.setMaxLines(1);
            this.ekz.setImeOptions(6);
            this.ekz.setTextAppearance(getApplicationContext(), 16842816);
            this.ekz.setInputType(3);
            this.ekz.setHint(b.a(StringKey.EXPIRES_PLACEHOLDER));
            if (!this.ejT) {
                this.ekz.setHintTextColor(Drawables.DEFAULT_LIST_ROW_COLOR_PRESSED);
            }
            if (this.ekK != null) {
                this.ekA = new d(this.ekK.expiryMonth, this.ekK.expiryYear);
            } else {
                this.ekA = new d();
            }
            if (this.ekA.abl()) {
                this.ekz.setText(this.ekA.getValue());
            }
            this.ekz.addTextChangedListener(this.ekA);
            this.ekz.addTextChangedListener(this);
            this.ekz.setFilters(new InputFilter[]{new DateKeyListener(), this.ekA});
            linearLayout3.addView(this.ekz, -1, -2);
            linearLayout.addView(linearLayout3, layoutParams7);
            String str = (booleanExtra2 || booleanExtra3) ? "4dip" : null;
            c.b(linearLayout3, null, null, str, null);
        } else {
            view = relativeLayout;
            layoutParams = layoutParams3;
            this.ekA = new a();
        }
        if (booleanExtra2) {
            relativeLayout = new LinearLayout(this);
            layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            relativeLayout.setOrientation(1);
            textView = new TextView(this);
            if (!this.ejT) {
                textView.setTextColor(io.card.payment.a.b.elQ);
            }
            c.a(textView, this.ekM, null, null, null);
            textView.setText(b.a(StringKey.ENTRY_CVV));
            relativeLayout.addView(textView, -2, -2);
            this.ekB = new EditText(this);
            EditText editText3 = this.ekB;
            int i3 = this.ekv;
            this.ekv = i3 + 1;
            editText3.setId(i3);
            this.ekB.setMaxLines(1);
            this.ekB.setImeOptions(6);
            this.ekB.setTextAppearance(getApplicationContext(), 16842816);
            this.ekB.setInputType(3);
            this.ekB.setHint("123");
            if (!this.ejT) {
                this.ekB.setHintTextColor(Drawables.DEFAULT_LIST_ROW_COLOR_PRESSED);
            }
            i = 4;
            if (this.ekK != null) {
                i = CardType.fromCardNumber(this.eky.getValue()).cvvLength();
            }
            this.ekC = new e(i);
            this.ekB.setFilters(new InputFilter[]{new DigitsKeyListener(), this.ekC});
            this.ekB.addTextChangedListener(this.ekC);
            this.ekB.addTextChangedListener(this);
            relativeLayout.addView(this.ekB, -1, -2);
            linearLayout.addView(relativeLayout, layoutParams2);
            c.b(relativeLayout, booleanExtra ? "4dip" : null, null, booleanExtra3 ? "4dip" : null, null);
        } else {
            this.ekC = new a();
        }
        if (booleanExtra3) {
            String str2;
            String str3;
            relativeLayout = new LinearLayout(this);
            layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            relativeLayout.setOrientation(1);
            textView = new TextView(this);
            if (!this.ejT) {
                textView.setTextColor(io.card.payment.a.b.elQ);
            }
            c.a(textView, this.ekM, null, null, null);
            textView.setText(b.a(StringKey.ENTRY_POSTAL_CODE));
            relativeLayout.addView(textView, -2, -2);
            boolean booleanExtra4 = getIntent().getBooleanExtra(CardIOActivity.EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY, false);
            this.ekD = new EditText(this);
            EditText editText4 = this.ekD;
            int i4 = this.ekv;
            this.ekv = i4 + 1;
            editText4.setId(i4);
            this.ekD.setMaxLines(1);
            this.ekD.setImeOptions(6);
            this.ekD.setTextAppearance(getApplicationContext(), 16842816);
            if (booleanExtra4) {
                this.ekD.setInputType(3);
            } else {
                this.ekD.setInputType(1);
            }
            if (!this.ejT) {
                this.ekD.setHintTextColor(Drawables.DEFAULT_LIST_ROW_COLOR_PRESSED);
            }
            this.ekE = new g(20);
            this.ekD.addTextChangedListener(this.ekE);
            this.ekD.addTextChangedListener(this);
            relativeLayout.addView(this.ekD, -1, -2);
            linearLayout.addView(relativeLayout, layoutParams2);
            if (booleanExtra || booleanExtra2) {
                str2 = "4dip";
                str3 = null;
            } else {
                str3 = null;
                str2 = null;
            }
            c.b(relativeLayout, str2, str3, str3, str3);
        } else {
            this.ekE = new a();
        }
        scrollView.addView(linearLayout, layoutParams6);
        s(scrollView);
        linearLayout2.addView(scrollView, layoutParams4);
        c.b(scrollView, "16dip", "20dip", "16dip", "20dip");
        relativeLayout = new LinearLayout(this);
        int i5 = this.eku;
        this.eku = i5 + 1;
        relativeLayout.setId(i5);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        relativeLayout.setPadding(0, f, 0, 0);
        relativeLayout.setBackgroundColor(0);
        layoutParams.addRule(2, relativeLayout.getId());
        this.ekI = new Button(this);
        LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        this.ekI.setText(b.a(StringKey.DONE));
        this.ekI.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DataEntryActivity.this.aTJ();
            }
        });
        this.ekI.setEnabled(false);
        relativeLayout.addView(this.ekI, layoutParams8);
        c.a(this.ekI, true, this, this.ejT);
        c.a(this.ekI, "5dip", null, "5dip", null);
        c.b(this.ekI, "8dip", "8dip", "8dip", "8dip");
        if (!this.ejT) {
            this.ekI.setTextSize(16.0f);
        }
        this.ekJ = new Button(this);
        layoutParams8 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        this.ekJ.setText(b.a(StringKey.CANCEL));
        this.ekJ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DataEntryActivity.this.onBackPressed();
            }
        });
        relativeLayout.addView(this.ekJ, layoutParams8);
        c.a(this.ekJ, false, this, this.ejT);
        c.a(this.ekJ, "5dip", null, "5dip", null);
        c.b(this.ekJ, "4dip", "8dip", "8dip", "8dip");
        if (!this.ejT) {
            this.ekJ.setTextSize(16.0f);
        }
        View view2 = view;
        view2.addView(relativeLayout, layoutParams2);
        a.w(this);
        setContentView(view2);
        Drawable drawable = getIntent().getBooleanExtra(CardIOActivity.EXTRA_USE_PAYPAL_ACTIONBAR_ICON, true) ? getResources().getDrawable(R.drawable.cio_ic_paypal_monogram) : null;
        if (booleanExtra && this.ekA.isValid()) {
            afterTextChanged(this.ekz.getEditableText());
        }
        a.a(this, this.ekw, b.a(StringKey.MANUAL_ENTRY_TITLE), "card.io - ", drawable);
    }

    private void aTJ() {
        if (this.ekK == null) {
            this.ekK = new CreditCard();
        }
        if (this.ekz != null) {
            this.ekK.expiryMonth = ((d) this.ekA).month;
            this.ekK.expiryYear = ((d) this.ekA).year;
        }
        Parcelable creditCard = new CreditCard(this.eky.getValue(), this.ekK.expiryMonth, this.ekK.expiryYear, this.ekC.getValue(), this.ekE.getValue(), this.ekG.getValue());
        Intent intent = new Intent();
        intent.putExtra(CardIOActivity.EXTRA_SCAN_RESULT, creditCard);
        if (getIntent().hasExtra(CardIOActivity.EXTRA_CAPTURED_CARD_IMAGE)) {
            intent.putExtra(CardIOActivity.EXTRA_CAPTURED_CARD_IMAGE, getIntent().getByteArrayExtra(CardIOActivity.EXTRA_CAPTURED_CARD_IMAGE));
        }
        setResult(CardIOActivity.RESULT_CARD_INFO, intent);
        finish();
    }

    public void onBackPressed() {
        setResult(CardIOActivity.RESULT_ENTRY_CANCELED);
        finish();
    }

    protected void onResume() {
        super.onResume();
        getWindow().setFlags(0, 1024);
        a.y(this);
        aTL();
        if (this.ekx != null || this.ekz == null || this.ekA.isValid()) {
            aTK();
        } else {
            this.ekz.requestFocus();
        }
        if (this.ekx != null || this.ekz != null || this.ekB != null || this.ekD != null || this.ekF != null) {
            getWindow().setSoftInputMode(5);
        }
    }

    private EditText aTK() {
        int i = 100;
        while (true) {
            int i2 = i + 1;
            EditText editText = (EditText) findViewById(i);
            if (editText == null) {
                return null;
            }
            if (editText.getText().length() == 0 && editText.requestFocus()) {
                return editText;
            }
            i = i2;
        }
    }

    private void aTL() {
        Button button = this.ekI;
        boolean z = this.eky.isValid() && this.ekA.isValid() && this.ekC.isValid() && this.ekE.isValid() && this.ekG.isValid();
        button.setEnabled(z);
        if (this.ekL && this.eky.isValid() && this.ekA.isValid() && this.ekC.isValid() && this.ekE.isValid() && this.ekG.isValid()) {
            aTJ();
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.ekx != null && editable == this.ekx.getText()) {
            if (!this.eky.abl()) {
                h(this.ekx);
            } else if (this.eky.isValid()) {
                h(this.ekx);
                aTK();
            } else {
                this.ekx.setTextColor(io.card.payment.a.b.elP);
            }
            if (this.ekB != null) {
                e eVar = (e) this.ekC;
                int cvvLength = CardType.fromCardNumber(this.eky.getValue().toString()).cvvLength();
                eVar.ekQ = cvvLength;
                this.ekB.setHint(cvvLength == 4 ? "1234" : "123");
            }
        } else if (this.ekz == null || editable != this.ekz.getText()) {
            if (this.ekB == null || editable != this.ekB.getText()) {
                if (this.ekD == null || editable != this.ekD.getText()) {
                    if (this.ekF != null && editable == this.ekF.getText()) {
                        if (!this.ekG.abl()) {
                            h(this.ekF);
                        } else if (this.ekG.isValid()) {
                            h(this.ekF);
                        } else {
                            this.ekF.setTextColor(io.card.payment.a.b.elP);
                        }
                    }
                } else if (!this.ekE.abl()) {
                    h(this.ekD);
                } else if (this.ekE.isValid()) {
                    h(this.ekD);
                } else {
                    this.ekD.setTextColor(io.card.payment.a.b.elP);
                }
            } else if (!this.ekC.abl()) {
                h(this.ekB);
            } else if (this.ekC.isValid()) {
                h(this.ekB);
                aTK();
            } else {
                this.ekB.setTextColor(io.card.payment.a.b.elP);
            }
        } else if (!this.ekA.abl()) {
            h(this.ekz);
        } else if (this.ekA.isValid()) {
            h(this.ekz);
            aTK();
        } else {
            this.ekz.setTextColor(io.card.payment.a.b.elP);
        }
        aTL();
    }

    private void h(EditText editText) {
        if (this.ejT) {
            editText.setTextColor(this.ekN);
        } else {
            editText.setTextColor(-12303292);
        }
    }

    private void s(ViewGroup viewGroup) {
        if (getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, false)) {
            View linearLayout = new LinearLayout(this);
            c.a(linearLayout, null, "4dip", null, null);
            linearLayout.setOrientation(1);
            View textView = new TextView(this);
            if (!this.ejT) {
                textView.setTextColor(io.card.payment.a.b.elQ);
            }
            c.a(textView, this.ekM, null, null, null);
            textView.setText(b.a(StringKey.ENTRY_CARDHOLDER_NAME));
            linearLayout.addView(textView, -2, -2);
            this.ekF = new EditText(this);
            EditText editText = this.ekF;
            int i = this.ekv;
            this.ekv = i + 1;
            editText.setId(i);
            this.ekF.setMaxLines(1);
            this.ekF.setImeOptions(6);
            this.ekF.setTextAppearance(getApplicationContext(), 16842816);
            this.ekF.setInputType(1);
            if (!this.ejT) {
                this.ekF.setHintTextColor(Drawables.DEFAULT_LIST_ROW_COLOR_PRESSED);
            }
            this.ekG = new g(175);
            this.ekF.addTextChangedListener(this.ekG);
            this.ekF.addTextChangedListener(this);
            linearLayout.addView(this.ekF, -1, -2);
            viewGroup.addView(linearLayout, -1, -2);
            return;
        }
        this.ekG = new a();
    }
}
