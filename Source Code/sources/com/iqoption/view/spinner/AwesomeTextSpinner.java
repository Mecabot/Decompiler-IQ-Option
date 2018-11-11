package com.iqoption.view.spinner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.iqoption.b.b;
import com.iqoption.core.i;
import com.iqoption.x.R;

public class AwesomeTextSpinner extends FrameLayout {
    private static final String TAG = "com.iqoption.view.spinner.AwesomeTextSpinner";
    private ImageView axB;
    private TextView dDf;
    private int dDg;
    private int dDh;
    private int dDi;
    private PopupWindow dDj;
    private int dDk;
    private ListView dDl;
    private OnClickListener dDn;
    private TextView dIF;
    private String dIG;
    private a dIH;

    public interface a {
        void fi(int i);
    }

    public AwesomeTextSpinner(Context context) {
        this(context, null);
    }

    public AwesomeTextSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AwesomeTextSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDn = new OnClickListener() {
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    AwesomeTextSpinner.this.axB.setRotation(0.0f);
                    AwesomeTextSpinner.this.dDj.dismiss();
                    return;
                }
                view.setSelected(true);
                AwesomeTextSpinner.this.axB.setRotation(180.0f);
                AwesomeTextSpinner.this.dDj.setWidth(AwesomeTextSpinner.this.getWidth());
                AwesomeTextSpinner.this.dDj.showAsDropDown(AwesomeTextSpinner.this);
            }
        };
        d(attributeSet);
        init();
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.AwesomeTextSpinner);
        this.dIG = obtainStyledAttributes.getString(0);
        this.dDg = obtainStyledAttributes.getResourceId(4, R.drawable.spinner_button_state);
        this.dDh = obtainStyledAttributes.getResourceId(3, R.drawable.hate_menu_arrow_up);
        this.dDi = obtainStyledAttributes.getColor(2, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.awesome_text_spinner, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOnClickListener(this.dDn);
        this.dIF = (TextView) findViewById(R.id.hintView);
        if (TextUtils.isEmpty(this.dIG)) {
            this.dIF.setVisibility(8);
        } else {
            this.dIF.setVisibility(0);
            this.dIF.setTextColor(this.dDi);
            this.dIF.setText(this.dIG.toLowerCase());
        }
        this.dDf = (TextView) findViewById(R.id.title);
        this.dDf.setTextColor(this.dDi);
        this.axB = (ImageView) findViewById(R.id.arrow);
        this.axB.setImageDrawable(AppCompatResources.getDrawable(getContext(), this.dDh));
        setBackgroundResource(this.dDg);
        aIB();
    }

    private void aIB() {
        this.dDj = new PopupWindow(getContext());
        this.dDj.setOutsideTouchable(true);
        this.dDl = new ListView(getContext());
        this.dDl.setDivider(new ColorDrawable(Color.parseColor("#2b313a")));
        this.dDl.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.dp1));
        this.dDl.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AwesomeTextSpinner.this.dDj.dismiss();
                AwesomeTextSpinner.this.dDk = i;
                AwesomeTextSpinner.this.dDf.setText(AwesomeTextSpinner.this.dDl.getAdapter().getItem(i).toString());
                if (AwesomeTextSpinner.this.dIH != null) {
                    AwesomeTextSpinner.this.dIH.fi(i);
                }
            }
        });
        this.dDj.setFocusable(true);
        this.dDj.setWidth(getResources().getDimensionPixelSize(R.dimen.dp140));
        this.dDj.setHeight(-2);
        this.dDj.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                AwesomeTextSpinner.this.setSelected(false);
                AwesomeTextSpinner.this.axB.setRotation(0.0f);
            }
        });
        this.dDj.setContentView(this.dDl);
    }

    public void setItemSelectedListener(a aVar) {
        this.dIH = aVar;
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.dDl.setAdapter(baseAdapter);
    }

    public void setSelection(int i) {
        setSelection(i, false);
    }

    public void setSelection(int i, boolean z) {
        ListAdapter adapter = this.dDl.getAdapter();
        if (i < 0 || i >= adapter.getCount()) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IndexOutOfBounds position=");
            stringBuilder.append(i);
            i.e(str, stringBuilder.toString());
            return;
        }
        this.dDk = i;
        this.dDl.setSelection(i);
        this.dDf.setText(adapter.getItem(i).toString());
        if (z && this.dIH != null) {
            this.dIH.fi(i);
        }
    }

    public int getSelection() {
        return this.dDk;
    }
}
