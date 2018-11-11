package com.iqoption.fragment.cashbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.iqoption.core.c.c.a;
import com.iqoption.core.i;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.core.microservices.billing.response.deposit.d;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.d.hl;
import com.iqoption.dto.Currencies;
import com.iqoption.fragment.cashbox.AmountFrameViewSwitcher.BorderType;
import com.iqoption.kyc.activity.KycActivity;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: DepositHelper */
public class f {
    private static final String TAG = "com.iqoption.fragment.cashbox.f";
    private final ArrayList<c> aPF;
    @Nullable
    private g aTK;
    private final double aTw;
    @Nullable
    private String bXz;
    private final AmountFrameViewSwitcher bpg;
    private final EditText bpl;
    private final RecyclerView bqm;
    @Nullable
    private c cbp;
    private final Context context;
    private final hl cwD;
    private final View cwE;
    private final View cwF;
    private final TextView cwG;
    private final TextView cwH;
    private final View cwI;
    private final HashMap<String, ArrayList<d>> cwJ;
    private final double cwK;
    private final o cwL;
    @Nullable
    private ArrayList<a> cwM;
    @Nullable
    private ArrayList<d> cwN;
    @Nullable
    private c cwO;
    @Nullable
    private com.iqoption.widget.c cwP;

    public f(Context context, b bVar, EditText editText, RecyclerView recyclerView, hl hlVar, View view, View view2, TextView textView, View view3, AmountFrameViewSwitcher amountFrameViewSwitcher, @Nullable ArrayList<a> arrayList, double d, double d2, TextView textView2) {
        final EditText editText2 = editText;
        TextView textView3 = textView;
        TextView textView4 = textView2;
        this.context = context;
        this.aPF = bVar.Td();
        this.bpl = editText2;
        this.bqm = recyclerView;
        this.cwD = hlVar;
        this.cwE = view;
        this.cwF = view2;
        this.cwG = textView3;
        this.cwH = textView4;
        this.cwM = arrayList;
        this.cwL = new o(editText2, "deposit-page_amount");
        this.cwI = view3;
        this.bpg = amountFrameViewSwitcher;
        this.aTw = d;
        this.cwK = d2;
        c UI = bVar.UI();
        ArrayList Td = bVar.Td();
        this.cwJ = bVar.UJ();
        if (this.cwJ == null || this.cwJ.isEmpty()) {
            i.w(TAG, "cashbox counting doesn't have deposits");
            return;
        }
        Pair a = a(UI, Td, this.cwJ);
        if (a != null) {
            this.cwN = b((ArrayList) a.first, ((c) a.second).getName());
            this.cbp = (c) a.second;
            textView3.setVisibility(8);
            textView4.setVisibility(8);
            editText2.addTextChangedListener(new x() {
                String cwR;

                public void afterTextChanged(Editable editable) {
                    super.afterTextChanged(editable);
                    if (!editable.toString().equals(this.cwR)) {
                        this.cwR = editable.toString();
                        f.this.akg();
                        if (editable.length() != 0) {
                            editText2.setSelection(editable.length());
                        }
                    }
                }
            });
            akh();
            akn();
        }
    }

    public void s(Long l) {
        Iterator it = this.aPF.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (com.google.common.base.f.equal(Long.valueOf(cVar.getId()), l)) {
                this.cbp = cVar;
                this.cwN = b((ArrayList) this.cwJ.get(cVar.getName()), cVar.getName());
                akh();
            }
        }
    }

    @Nullable
    public Double akf() {
        Double d = d(this.bpl);
        return (d == null || (this.cbp != null && (d.doubleValue() < this.cbp.UM() || d.doubleValue() > this.cbp.UN()))) ? null : d;
    }

    private static Double d(EditText editText) {
        Editable text = editText.getText();
        if (text.length() == 0) {
            return null;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(text.toString());
            if (bigDecimal.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) == -1) {
                return Double.valueOf(bigDecimal.doubleValue());
            }
            return Double.valueOf(Double.MAX_VALUE);
        } catch (Throwable e) {
            i.e(TAG, "error when getting deposit amount", e);
            return null;
        }
    }

    private void akg() {
        if (this.cbp != null) {
            d dVar = null;
            this.cwG.setOnClickListener(null);
            Double d = d(this.bpl);
            int i = 8;
            if (abQ() && this.aTK != null && this.aTK.UU()) {
                a(this.cwH, this.context.getString(R.string.unavailable_for_the_non_verified_accounts));
                this.cwH.setVisibility(0);
                this.cwG.setVisibility(8);
                this.cwI.setVisibility(8);
                this.cwE.setEnabled(false);
                this.cwF.setEnabled(false);
                b(BorderType.transparentBorder);
            } else if (d == null) {
                b(BorderType.transparentBorder);
                this.cwI.setVisibility(8);
                this.cwE.setEnabled(false);
                this.cwF.setEnabled(false);
                this.cwG.setVisibility(8);
                this.cwH.setVisibility(8);
                this.cwG.setText("");
            } else {
                boolean z = true;
                if (d.doubleValue() < akk()) {
                    this.cwG.setText(this.context.getString(R.string.amount_is_less_than_min_amount, new Object[]{b.h(Double.valueOf(akk()))}));
                    this.cwG.setVisibility(0);
                    this.cwI.setVisibility(8);
                    this.cwH.setVisibility(8);
                    b(BorderType.redBorder);
                    this.cwE.setEnabled(false);
                    this.cwF.setEnabled(false);
                } else if (d.doubleValue() > akl()) {
                    if (abQ()) {
                        a(this.cwG, this.context.getString(R.string.max_deposit_amount_for_the_non_verified, new Object[]{this.cbp.getMask().replace(Currencies.REPLACE_CURRENCY_MASK, b.h(Double.valueOf(akl())))}));
                    } else {
                        this.cwG.setText(this.context.getString(R.string.amount_is_more_than_max_amount, new Object[]{b.h(Double.valueOf(akl()))}));
                    }
                    this.cwG.setVisibility(0);
                    this.cwI.setVisibility(8);
                    this.cwH.setVisibility(8);
                    b(BorderType.redBorder);
                    this.cwE.setEnabled(false);
                    this.cwF.setEnabled(false);
                } else if (!abQ() || this.aPF == null || this.aPF.size() != 1 || this.cwK + d.doubleValue() <= this.aTw) {
                    this.bpl.setActivated(true);
                    this.cwE.setEnabled(ako());
                    this.cwF.setEnabled(true);
                    this.cwG.setVisibility(8);
                    this.cwH.setVisibility(8);
                    this.cwG.setText("");
                    dVar = i(d);
                    if (dVar == null || !"vip".equals(dVar.UP())) {
                        z = false;
                    }
                    View view = this.cwI;
                    if (z) {
                        i = 0;
                    }
                    view.setVisibility(i);
                    b(z ? BorderType.orangeBorder : BorderType.greenBorder);
                } else {
                    a(this.cwG, this.context.getString(R.string.max_deposit_total_amount_for_the_non_verified, new Object[]{this.cbp.getMask().replace(Currencies.REPLACE_CURRENCY_MASK, b.h(Double.valueOf(this.aTw)))}));
                    this.cwG.setVisibility(0);
                    this.cwI.setVisibility(8);
                    this.cwH.setVisibility(8);
                    b(BorderType.redBorder);
                    this.cwE.setEnabled(false);
                    this.cwF.setEnabled(false);
                }
            }
            if (this.cwO != null) {
                this.cwO.b(dVar);
            }
        }
    }

    private void a(TextView textView, String str) {
        String format = String.format(Locale.US, "%s. %s", new Object[]{str, this.context.getString(R.string.kyc_verify_account)});
        final int color = this.context.getResources().getColor(R.color.deposit_page_green);
        r7 = new int[3][];
        r7[0] = new int[]{16842919};
        r7[1] = new int[]{16842913};
        r7[2] = new int[0];
        final ColorStateList colorStateList = new ColorStateList(r7, new int[]{this.context.getResources().getColor(R.color.deposit_page_green_selected), this.context.getResources().getColor(R.color.deposit_page_green_selected), color});
        CharSequence spannableString = new SpannableString(format);
        spannableString.setSpan(new UnderlineSpan() {
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(colorStateList.getColorForState(textPaint.drawableState, color));
            }
        }, format.length() - r0.length(), format.length(), 33);
        textView.setText(spannableString);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                new KycActivity.a((Activity) f.this.context).start();
            }
        });
    }

    private boolean abQ() {
        return com.iqoption.app.managers.feature.a.eW("kyc-deposit-limit") && this.aTw > -1.0d;
    }

    private void b(BorderType borderType) {
        this.bpg.a(borderType);
    }

    @Nullable
    private d i(Double d) {
        if (this.cwN == null) {
            return null;
        }
        Iterator it = this.cwN.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (com.google.common.base.f.equal(Double.valueOf(dVar.UO()), d)) {
                return dVar;
            }
        }
        return null;
    }

    private void akh() {
        int max = Math.max(1, (int) Math.floor((double) ((this.context.getResources().getDimension(R.dimen.deposit_page_payment_method_width) / akj()) - 0.3f)));
        int dimension = (int) this.context.getResources().getDimension(R.dimen.deposit_page_amount_item_margin);
        ItemDecoration cVar;
        if (this.bqm.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) this.bqm.getLayoutManager();
            if (gridLayoutManager.getSpanCount() != max) {
                cVar = new com.iqoption.widget.c(max, dimension, false);
                gridLayoutManager.setSpanCount(max);
                this.bqm.removeItemDecoration(this.cwP);
                this.bqm.addItemDecoration(cVar);
                this.cwP = cVar;
            }
        } else {
            cVar = new com.iqoption.widget.c(max, dimension, false);
            this.bqm.setLayoutManager(new GridLayoutManager(this.context, max, 1, false));
            this.bqm.removeItemDecoration(this.cwP);
            this.bqm.addItemDecoration(cVar);
            this.cwP = cVar;
        }
        if (this.cwN == null || this.cwN.isEmpty()) {
            this.bqm.setVisibility(8);
        } else {
            if (this.cwO == null) {
                this.cwO = new c(this.context, this.cwN, this.cbp.getSymbol(), this.cbp.getName(), new g(this));
                this.bqm.setAdapter(this.cwO);
            } else {
                this.cwO.a(this.cwN, this.cbp.getSymbol(), this.cbp.getName());
            }
            this.bqm.setVisibility(0);
        }
        aki();
    }

    private void aki() {
        if (this.bXz == null || this.bpl.getText().toString().equals(this.bXz)) {
            Double d = null;
            c cVar = this.cbp;
            if (!(this.cwM == null || cVar == null)) {
                Iterator it = this.cwM.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.getName().equals(cVar.getName())) {
                        d = Double.valueOf(Math.min(Double.valueOf(Math.max(aVar.Tb().doubleValue(), cVar.UM())).doubleValue(), cVar.UN()));
                        Double hK = e.hK(cVar.getName());
                        if (hK != null) {
                            d = Double.valueOf(Math.max(d.doubleValue(), hK.doubleValue()));
                        }
                    }
                }
            }
            CharSequence h = (d == null || d.doubleValue() <= 0.0d) ? (this.cwN == null || this.cwN.isEmpty()) ? "" : b.h(Double.valueOf(((d) this.cwN.get(0)).UO())) : b.h(d);
            this.bXz = h;
            this.bpl.setText(h);
            this.bpl.setSelection(this.bpl.getText().length());
        }
        akg();
    }

    private float akj() {
        float dimension = this.context.getResources().getDimension(R.dimen.deposit_page_amount_item_text_size);
        float dimension2 = this.context.getResources().getDimension(R.dimen.deposit_page_amount_item_padding);
        float f = 0.0f;
        if (!(this.cwN == null || this.cwN.isEmpty())) {
            Iterator it = this.cwN.iterator();
            while (it.hasNext()) {
                String c = c(((d) it.next()).UO(), this.cbp.getMask());
                Paint paint = new Paint();
                paint.setTypeface(Typeface.SANS_SERIF);
                paint.setTextSize(dimension);
                f = Math.max(f, paint.measureText(c) + (2.0f * dimension2));
            }
        }
        return f;
    }

    private static String c(double d, String str) {
        try {
            return String.format(Locale.US, str, new Object[]{b.h(Double.valueOf(d))});
        } catch (Exception unused) {
            return b.h(Double.valueOf(d));
        }
    }

    private Pair<ArrayList<d>, c> a(c cVar, ArrayList<c> arrayList, HashMap<String, ArrayList<d>> hashMap) {
        Object cVar2;
        Object obj = (ArrayList) hashMap.get(cVar2.getName());
        if (obj == null) {
            cVar2 = a((ArrayList) arrayList, "USD");
            obj = (ArrayList) hashMap.get("USD");
            if (obj == null || cVar2 == null) {
                String str = (String) hashMap.keySet().iterator().next();
                obj = (ArrayList) hashMap.get(str);
                cVar2 = a((ArrayList) arrayList, str);
                if (obj == null || cVar2 == null) {
                    return null;
                }
            }
        }
        return Pair.create(obj, cVar2);
    }

    private c a(ArrayList<c> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (TextUtils.equals(cVar.getName(), str)) {
                return cVar;
            }
        }
        return null;
    }

    public void a(g gVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set paymentMethod ");
        stringBuilder.append(gVar);
        i.v(str, stringBuilder.toString());
        this.aTK = gVar;
        akg();
    }

    private double akk() {
        g.b akm = akm();
        double d = 0.0d;
        if (akm == null && this.cbp == null) {
            return 0.0d;
        }
        double d2;
        if (akm == null || akm.Mz() == null || akm.Mz().doubleValue() == 0.0d) {
            if (this.cbp != null) {
                d = this.cbp.UM();
            }
            d2 = d;
        } else if (this.cbp == null) {
            d2 = akm.Mz().doubleValue();
        } else {
            d2 = Math.max(this.cbp.UM(), akm.Mz().doubleValue());
        }
        Double hK = this.cbp != null ? e.hK(this.cbp.getName()) : null;
        if (hK != null) {
            d2 = Math.max(d2, hK.doubleValue());
        }
        return d2;
    }

    private double akl() {
        g.b akm = akm();
        if (akm == null && this.cbp == null) {
            return 9.223372036854776E18d;
        }
        double d = Double.MAX_VALUE;
        if (akm == null || akm.MA() == null || akm.MA().doubleValue() == 0.0d) {
            if (this.cbp != null) {
                d = this.cbp.UN();
            }
            return d;
        } else if (this.cbp == null) {
            return akm.MA().doubleValue();
        } else {
            double min = Math.min(this.cbp.UN(), akm.MA().doubleValue());
            if (min != 0.0d) {
                d = min;
            }
            return d;
        }
    }

    @Nullable
    private g.b akm() {
        if (this.cbp == null || this.aTK == null || this.aTK.Vb() == null) {
            return null;
        }
        return (g.b) this.aTK.Vb().get(this.cbp.getName());
    }

    private void akn() {
        this.cwD.brb.setOnCheckedChangeListener(new h(this));
    }

    final /* synthetic */ void e(CompoundButton compoundButton, boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("terms isChecked=");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        akg();
    }

    private boolean ako() {
        if (this.cwD.bra.getVisibility() == 0 && !com.iqoption.app.managers.feature.a.eW("hide-deposit-check")) {
            return this.cwD.brb.isChecked();
        }
        return true;
    }

    @NonNull
    private ArrayList<d> b(@NonNull ArrayList<d> arrayList, @NonNull String str) {
        Double hK = e.hK(str);
        if (hK == null) {
            return arrayList;
        }
        ArrayList<d> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.UO() >= hK.doubleValue()) {
                arrayList2.add(dVar);
            }
        }
        return arrayList2;
    }
}
