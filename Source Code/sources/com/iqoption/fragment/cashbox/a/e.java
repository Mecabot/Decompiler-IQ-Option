package com.iqoption.fragment.cashbox.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner2;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.iqoption.core.microservices.billing.response.extraparams.c;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* compiled from: ExtraParamSelectView */
public class e extends b {
    private final c bXd;
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

    public e(Context context, String str, c cVar) {
        super(context);
        this.cyl = str;
        this.bXd = cVar;
        this.cyn = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_height);
        this.cym = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_width);
        this.textColor = ContextCompat.getColor(context, R.color.deposit_constructor_field_text);
        this.cyo = a(context, cVar);
        setOrientation(1);
        setLayoutParams(new LayoutParams(this.cym, -2));
        addView(v(context, cVar.getTitle()));
        addView(this.cyo);
    }

    protected AppCompatSpinner2 a(Context context, c cVar) {
        int dimension = (int) (context.getResources().getDimension(R.dimen.deposit_payment_constructor_field_height) * 4.6f);
        AppCompatSpinner2 appCompatSpinner2 = (AppCompatSpinner2) LayoutInflater.from(context).inflate(R.layout.constructor_spinner_field_old, this, false);
        appCompatSpinner2.setMaxHeight(dimension);
        appCompatSpinner2.setAdapter(a(cVar));
        appCompatSpinner2.setTag(getExtraParamName());
        return appCompatSpinner2;
    }

    @NonNull
    private ArrayAdapter<String> a(c cVar) {
        List arrayList = new ArrayList();
        arrayList.addAll(cVar.Vk().keySet());
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
        return (String) this.bXd.Vk().get(selectedItem.toString());
    }
}
