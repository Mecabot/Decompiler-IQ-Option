package com.jumio.commons.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.jumio.commons.utils.ScreenUtil;
import java.util.ArrayList;

public class SpinnerAdapterWithHintAndSelectionReset extends ArrayAdapter<String> {
    protected int EXTRA;
    protected Context context;
    private boolean isSelectionResettable;
    protected LayoutInflater layoutInflater;
    private int promptColor;
    private String promptText;
    private String resetSelectionText;
    private int textColor;

    public SpinnerAdapterWithHintAndSelectionReset(Context context, ArrayList<String> arrayList, String str, boolean z, String str2, int i, int i2) {
        super(context, 17367048, arrayList);
        this.EXTRA = 1;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.promptText = str;
        this.resetSelectionText = str2;
        this.isSelectionResettable = z;
        this.textColor = i;
        this.promptColor = i2;
        this.EXTRA = z;
    }

    public SpinnerAdapterWithHintAndSelectionReset(Context context, ArrayList<String> arrayList, String str, boolean z) {
        this(context, arrayList, str, z, "", 0, 0);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            int dpToPx = ScreenUtil.dpToPx(this.context, 1);
            int dpToPx2 = ScreenUtil.dpToPx(this.context, 23);
            View view2 = (TextView) this.layoutInflater.inflate(17367048, viewGroup, false);
            TextView textView = (TextView) view2;
            textView.setGravity(5);
            textView.setTextSize(2, 20.0f);
            textView.setPadding(dpToPx, dpToPx, dpToPx2, dpToPx);
            view = view2;
        }
        if (i == 0 && this.isSelectionResettable) {
            TextView textView2 = (TextView) view;
            textView2.setText(this.promptText);
            textView2.setTextColor(this.promptColor);
        } else {
            TextView textView3 = (TextView) view;
            textView3.setText(getItem(i));
            textView3.setTextColor(this.textColor);
        }
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null || !(view instanceof TextView)) {
            view = this.layoutInflater.inflate(17367049, viewGroup, false);
            TextView textView = (TextView) view;
            textView.setTextSize(2, 18.0f);
            textView.setTextColor(this.textColor);
        }
        if (i == 0 && this.isSelectionResettable) {
            ((TextView) view).setText(this.resetSelectionText);
        } else {
            ((TextView) view).setText(getItem(i));
        }
        return view;
    }

    public int getCount() {
        return super.getCount() + this.EXTRA;
    }

    public String getItem(int i) {
        return (i == 0 && this.isSelectionResettable) ? null : (String) super.getItem(i - this.EXTRA);
    }

    public long getItemId(int i) {
        return (i == 0 && this.isSelectionResettable) ? 0 : super.getItemId(i - this.EXTRA);
    }
}
