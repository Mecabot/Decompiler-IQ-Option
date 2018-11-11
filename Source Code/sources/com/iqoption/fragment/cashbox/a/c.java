package com.iqoption.fragment.cashbox.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner2;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.iqoption.core.microservices.billing.response.extraparams.a;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* compiled from: ExtraParamEnumView */
public class c extends b {
    protected final String cyl;
    protected final int cym;
    protected final int cyn;
    protected final AppCompatSpinner2 cyo;
    protected final int textColor;

    public void dj(boolean z) {
    }

    public boolean f(boolean z, String str) {
        return false;
    }

    public boolean isValid() {
        return true;
    }

    public c(Context context, String str, a aVar) {
        super(context);
        this.cyl = str;
        this.cyn = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_height);
        this.cym = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_width);
        this.textColor = ContextCompat.getColor(context, R.color.deposit_constructor_field_text);
        this.cyo = a(context, aVar);
        setOrientation(1);
        setLayoutParams(new LayoutParams(this.cym, -2));
        addView(v(context, aVar.getTitle()));
        addView(this.cyo);
    }

    protected AppCompatSpinner2 a(Context context, a aVar) {
        int dimension = (int) (context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_height) * 4.6f);
        AppCompatSpinner2 appCompatSpinner2 = (AppCompatSpinner2) LayoutInflater.from(context).inflate(R.layout.constructor_spinner_field_old, this, false);
        appCompatSpinner2.setMaxHeight(dimension);
        appCompatSpinner2.setAdapter(a(aVar));
        appCompatSpinner2.setTag(getExtraParamName());
        return appCompatSpinner2;
    }

    @NonNull
    private ArrayAdapter<String> a(a aVar) {
        List arrayList = new ArrayList();
        Object obj = (aVar.getTitle() == null || !aVar.getTitle().toLowerCase().contains("year")) ? null : 1;
        if (obj != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (Integer num : aVar.Vi()) {
                if (num.intValue() < 100) {
                    arrayList2.add(num.toString());
                } else {
                    arrayList3.add(num.toString());
                }
                arrayList.add(num.toString());
            }
            if (!(arrayList2.isEmpty() || arrayList3.isEmpty())) {
                arrayList = arrayList3;
            }
        } else {
            for (Integer num2 : aVar.Vi()) {
                arrayList.add(num2.toString());
            }
        }
        return new ArrayAdapter(getContext(), R.layout.constructor_spinner_item, arrayList);
    }

    public String getExtraParamName() {
        return this.cyl;
    }

    public String getExtraParamValue() {
        Object selectedItem = this.cyo == null ? null : this.cyo.getSelectedItem();
        if (selectedItem == null) {
            return null;
        }
        return selectedItem.toString();
    }
}
