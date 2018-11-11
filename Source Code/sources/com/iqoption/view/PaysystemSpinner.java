package com.iqoption.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.iqoption.a.o;
import com.iqoption.b.b;
import com.iqoption.dto.PaymentSystem;
import com.iqoption.util.ay;
import com.iqoption.x.R;

public class PaysystemSpinner extends FrameLayout {
    private View aiE;
    private ImageView bmu;
    private TextView dDf;
    private int dDg;
    private int dDh;
    private int dDi;
    private PopupWindow dDj;
    private int dDk;
    private ListView dDl;
    private a dDm;
    private OnClickListener dDn;

    public interface a {
        void fi(int i);
    }

    public PaysystemSpinner(Context context) {
        this(context, null);
    }

    public PaysystemSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaysystemSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDn = new OnClickListener() {
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    PaysystemSpinner.this.aiE.setRotation(0.0f);
                    PaysystemSpinner.this.dDj.dismiss();
                    return;
                }
                view.setSelected(true);
                PaysystemSpinner.this.aiE.setRotation(180.0f);
                PaysystemSpinner.this.dDj.setWidth(PaysystemSpinner.this.getWidth());
                PaysystemSpinner.this.dDj.showAsDropDown(PaysystemSpinner.this);
            }
        };
        d(attributeSet);
        init();
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.AwesomeTextSpinner);
        this.dDg = obtainStyledAttributes.getResourceId(4, R.drawable.spinner_button_state);
        this.dDh = obtainStyledAttributes.getResourceId(3, R.drawable.hate_menu_arrow_up);
        this.dDi = obtainStyledAttributes.getColor(2, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.paysystem_spinner, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOnClickListener(this.dDn);
        this.dDf = (TextView) findViewById(R.id.name2);
        this.bmu = (ImageView) findViewById(R.id.icon);
        this.aiE = findViewById(R.id.arrow);
        ((ImageView) this.aiE).setImageResource(this.dDh);
        this.dDf.setTextColor(this.dDi);
        setBackgroundResource(this.dDg);
        aIB();
    }

    private void aIB() {
        this.dDj = new PopupWindow(getContext());
        this.dDj.setOutsideTouchable(true);
        this.dDl = new ListView(getContext());
        this.dDl.setDivider(null);
        this.dDl.setDividerHeight(0);
        this.dDl.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PaysystemSpinner.this.dDj.dismiss();
                PaysystemSpinner.this.dDk = i;
                PaymentSystem cu = ((o) PaysystemSpinner.this.dDl.getAdapter()).getItem(i);
                PaysystemSpinner.this.dDf.setText(cu.name);
                PaysystemSpinner.this.bmu.setImageResource(ay.jN(cu.className));
                if (PaysystemSpinner.this.dDm != null) {
                    PaysystemSpinner.this.dDm.fi(i);
                }
            }
        });
        this.dDj.setFocusable(true);
        this.dDj.setWidth(getResources().getDimensionPixelSize(R.dimen.dp140));
        this.dDj.setHeight(-2);
        this.dDj.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                PaysystemSpinner.this.setSelected(false);
                PaysystemSpinner.this.aiE.setRotation(0.0f);
            }
        });
        this.dDj.setContentView(this.dDl);
    }

    public void setItemSelectedListener(a aVar) {
        this.dDm = aVar;
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.dDl.setAdapter(baseAdapter);
    }

    public void setSelection(int i) {
        setSelection(i, false);
    }

    public void setSelection(int i, boolean z) {
        this.dDk = i;
        this.dDl.setSelection(i);
        PaymentSystem cu = ((o) this.dDl.getAdapter()).getItem(i);
        this.dDf.setText(cu.toString());
        this.bmu.setImageResource(ay.jN(cu.className));
        if (z && this.dDm != null) {
            this.dDm.fi(i);
        }
    }

    public int getSelection() {
        return this.dDk;
    }
}
