package jumio.bam;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.InputFilter.LengthFilter;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TableLayout;
import com.jumio.bam.R;
import com.jumio.bam.enums.CreditCardType;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.Strings;
import java.util.ArrayList;

/* compiled from: ManualEntryView */
public class q extends TableLayout implements o {
    private n a;
    private m b;
    private m c;
    private a d;
    private ArrayList<CreditCardType> e;

    /* compiled from: ManualEntryView */
    public interface a {
        void a(boolean z);
    }

    /* compiled from: ManualEntryView */
    /* renamed from: jumio.bam.q$2 */
    class AnonymousClass2 extends jumio.bam.m.a {
        final /* synthetic */ CreditCardType b;
        private boolean d = true;

        AnonymousClass2(m mVar, CreditCardType creditCardType) {
            this.b = creditCardType;
            mVar.getClass();
            super();
        }

        public void afterTextChanged(Editable editable) {
            if (((this.b == CreditCardType.AMERICAN_EXPRESS && editable.length() == 4) || (this.b != CreditCardType.AMERICAN_EXPRESS && editable.length() == 3)) && this.d) {
                for (int i = 0; i < q.this.getChildCount(); i++) {
                    if (q.this.getChildAt(i) == q.this.b) {
                        int i2 = i + 1;
                        if (i2 < q.this.getChildCount() && (q.this.getChildAt(i2) instanceof m)) {
                            q.this.c(q.this.b);
                        }
                    }
                    this.d = false;
                }
            }
            super.afterTextChanged(editable);
        }
    }

    public q(Context context, a aVar) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.d = aVar;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.bam_manualEntryBackgroundColor, typedValue, true);
        setBackgroundColor(typedValue.data);
    }

    public void a(boolean z, boolean z2, boolean z3, ArrayList<ac> arrayList, ArrayList<CreditCardType> arrayList2, boolean z4) {
        if (arrayList2 != null) {
            this.e = new ArrayList(arrayList2);
        } else {
            this.e = null;
        }
        if (z) {
            a();
            this.a.setAutoShowNextView(z4);
            this.a.setAutoFocusNextView(z4 ^ 1);
        }
        if (z3) {
            c();
            this.c.setAutoShowNextView(z4);
        }
        if (z2) {
            b();
            this.b.setAutoShowNextView(z4);
            this.b.setAutoFocusNextView(z4 ^ 1);
        }
        if (arrayList != null) {
            int i = 1;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ac acVar = (ac) arrayList.get(i2);
                z4 = acVar instanceof ae;
                if (z4 || (acVar instanceof ad)) {
                    int i3;
                    p a;
                    if (z4) {
                        ae aeVar = (ae) acVar;
                        int i4 = i + 1;
                        i3 = i4 + 1;
                        a = a(i, i4, acVar.b(), aeVar.c(), aeVar.d(), aeVar.e());
                    } else {
                        ad adVar = (ad) acVar;
                        i3 = i + 1;
                        p a2 = a(i, acVar.b());
                        if (adVar.c() != -1) {
                            ((m) a2).setInputType(adVar.c());
                        }
                        m mVar = (m) a2;
                        mVar.setValidationPattern(adVar.d());
                        mVar.c();
                        a = a2;
                    }
                    a.setTag(acVar.a());
                    a.setAutoFocusNextView(false);
                    a.setAutoShowNextView(true);
                    if (i2 == 0) {
                        a.a(0, ScreenUtil.dpToPx(getContext(), 10), 0, 0);
                    }
                    i = i3;
                }
            }
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.setVisibility(0);
            childAt.post(new Runnable() {
                public void run() {
                    View childAt = q.this.getChildAt(0);
                    if (q.this.c(childAt)) {
                        ((InputMethodManager) q.this.getContext().getSystemService("input_method")).toggleSoftInputFromWindow(q.this.getApplicationWindowToken(), 1, 0);
                    }
                    if ((childAt instanceof m) && ((m) childAt).getAutoShowNextView()) {
                        q.this.d(childAt);
                    }
                }
            });
        }
    }

    public void a() {
        this.a = new n(getContext());
        this.a.setLabelText(Strings.getExternalString(getContext(), "manual_entry_valid_through"));
        this.a.setValidationCallback(this);
        this.a.setVisibility(4);
        addView(this.a);
    }

    public void a(char[] cArr, char[] cArr2) {
        if (this.a != null) {
            this.a.a(cArr, cArr2);
        }
    }

    public void b() {
        this.b = a(R.id.cvvInputEditText, Strings.getExternalString(getContext(), "manual_entry_cvv"));
        this.b.setInputType(0);
        this.b.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        this.b.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.b.setFilters(new InputFilter[]{new LengthFilter(3)});
        this.b.setValidationPattern("[0-9]{3}");
        this.b.setValidationCallback(this);
        this.b.c();
    }

    public void c() {
        this.c = a(R.id.nameInputEditText, Strings.getExternalString(getContext(), "manual_entry_cardholder_name"));
        this.c.setAutoFocusNextView(false);
        this.c.setInputType(4096);
        this.c.setValidationPattern("^.+$");
        this.c.setValidationCallback(this);
        this.c.setFilters(new InputFilter[]{new AllCaps()});
        this.c.setInputType(4096);
        this.c.c();
    }

    public void a(CharSequence charSequence) {
        if (this.c != null) {
            this.c.setValueText(charSequence);
        }
    }

    public void a(CreditCardType creditCardType) {
        if (this.b != null) {
            m mVar = this.b;
            m mVar2 = this.b;
            mVar2.getClass();
            mVar.a(new AnonymousClass2(mVar2, creditCardType));
            String str = "[0-9]{3}";
            int i = 3;
            String str2 = "manual_entry_cvv";
            switch (creditCardType) {
                case UNKNOWN:
                case VISA:
                case DINERS_CLUB:
                    str2 = "manual_entry_cvv";
                    break;
                case MASTER_CARD:
                    str2 = "manual_entry_cvc";
                    break;
                case DISCOVER:
                    str2 = "manual_entry_cid";
                    break;
                case AMERICAN_EXPRESS:
                    str = "[0-9]{3,}";
                    i = 4;
                    this.b.setAutoFocusNextView(false);
                    str2 = "manual_entry_cid";
                    break;
                case CHINA_UNIONPAY:
                case JCB:
                    str2 = "manual_entry_cav";
                    break;
            }
            this.b.setFilters(new InputFilter[]{new LengthFilter(i)});
            this.b.setValidationPattern(str);
            this.b.setLabelText(Strings.getExternalString(getContext(), str2));
        }
    }

    public t a(int i, int i2, String str, ArrayList<String> arrayList, boolean z, String str2) {
        View tVar = new t(getContext(), z, str2);
        tVar.setLabelId(i);
        tVar.setValueId(i2);
        tVar.setLabelText(str);
        tVar.setValues(arrayList);
        tVar.setVisibility(4);
        tVar.setValidationCallback(this);
        addView(tVar);
        return tVar;
    }

    public m a(int i, String str) {
        View mVar = new m(getContext());
        mVar.setValueId(i);
        mVar.setLabelText(str);
        mVar.setVisibility(4);
        mVar.setValidationCallback(this);
        addView(mVar);
        return mVar;
    }

    public void a(y yVar) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.equals(this.a)) {
                yVar.e(new StringBuilder(this.a.getMonthText()));
                yVar.f(new StringBuilder(this.a.getYearText()));
            } else if (childAt.equals(this.b)) {
                yVar.g(new StringBuilder(this.b.getValueText()));
            } else if (childAt.equals(this.c)) {
                yVar.b(new StringBuilder(this.c.getValueText()));
            } else if ((childAt instanceof m) || (childAt instanceof t)) {
                yVar.a((String) childAt.getTag(), ((p) childAt).getValueText().toString());
            }
        }
    }

    public boolean d() {
        boolean z = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 0) {
                z = false;
            } else if (childAt instanceof n) {
                z = ((n) childAt).a();
            } else if ((childAt instanceof m) || (childAt instanceof t)) {
                z = ((p) childAt).a();
            }
            if (!z) {
                break;
            }
        }
        return z;
    }

    private boolean c(View view) {
        View focusSearch = view.focusSearch(130);
        if (focusSearch == null) {
            focusSearch = view.focusSearch(2);
        }
        if (view == focusSearch) {
            focusSearch = null;
        }
        if (focusSearch != null) {
            if (focusSearch.getParent() != null && focusSearch.getParent().getParent() == this.c && this.c.getValueText() != null && this.c.getValueText().length() != 0) {
                return c(focusSearch);
            }
            focusSearch.requestFocus();
        }
        return focusSearch != null;
    }

    public void a(View view) {
        d(view);
        if (this.d != null) {
            this.d.a(d());
        }
    }

    private void d(View view) {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == view) {
                int i2 = i + 1;
                if (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    if (childAt.getVisibility() != 0) {
                        childAt.setVisibility(0);
                        if ((childAt instanceof m) || (childAt instanceof t)) {
                            childAt = (p) childAt;
                            if (childAt.getValueText().length() != 0) {
                                childAt.b();
                            }
                            if (((view instanceof m) || (view instanceof t)) && ((p) view).getAutoFocusNextView()) {
                                c(view);
                            }
                            if (childAt.getAutoShowNextView()) {
                                a(childAt);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public void b(View view) {
        if (this.d != null) {
            this.d.a(false);
        }
    }
}
