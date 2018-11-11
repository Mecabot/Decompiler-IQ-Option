package com.jumio.commons.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ResetableArrayAdapter extends ArrayAdapter<String> {
    protected int EXTRA = 1;
    protected Context context;
    private int gravity = 3;
    protected LayoutInflater layoutInflater;
    private int promptColor;
    private String resetText;
    private boolean resetable;
    private int textColor;

    public ResetableArrayAdapter(Context context, ArrayList<String> arrayList) {
        super(context, 17367048, arrayList);
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            view = this.layoutInflater.inflate(17367049, viewGroup, false);
            textView = (TextView) view;
            textView.setTextSize(2, 18.0f);
            textView.setTextColor(this.textColor);
            textView.setGravity(this.gravity);
        }
        if (i == 0 && this.resetable) {
            TextView textView2 = (TextView) view;
            textView2.setText(this.resetText);
            textView2.setTextColor(this.promptColor);
        } else {
            textView = (TextView) view;
            textView.setText(getItem(i));
            textView.setTextColor(this.textColor);
        }
        return view;
    }

    public int getCount() {
        return super.getCount() + this.EXTRA;
    }

    public String getItem(int i) {
        return (i == 0 && this.resetable) ? this.resetText : (String) super.getItem(i - this.EXTRA);
    }

    public long getItemId(int i) {
        return (i == 0 && this.resetable) ? 0 : super.getItemId(i - this.EXTRA);
    }

    public void setGravity(int i) {
        this.gravity = i;
    }

    public void setResetable(boolean z) {
        this.resetable = z;
        this.EXTRA = z;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void setPromptColor(int i) {
        this.promptColor = i;
    }

    public void setResetText(String str) {
        this.resetText = str;
    }
}
