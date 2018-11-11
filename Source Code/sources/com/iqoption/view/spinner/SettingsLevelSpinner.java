package com.iqoption.view.spinner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.iqoption.util.z;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

public class SettingsLevelSpinner extends FrameLayout {
    private View aiE;
    private TextView dDf;
    private PopupWindow dIJ;
    private a dIK;
    private PopupWindow dIL;
    private ArrayAdapter<String> dIM;
    private b dIN;
    private c dIO;
    private final int dIP;
    private final int dIQ;
    private final int dIR;
    private final int dIS;
    z dIT;
    private OnClickListener dIU;
    private List<b> nj;

    public static class OutOfUniverseDimensionsError extends Error {
    }

    static class a extends ArrayAdapter<b> {
        public a(Context context, int i, int i2) {
            super(context, i, i2);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = super.getView(i, view, viewGroup);
            ((TextView) view.findViewById(R.id.name)).setText(((b) getItem(i)).name);
            if (((b) getItem(i)).nj.size() == 0) {
                view.findViewById(R.id.arrow).setVisibility(8);
            } else {
                view.findViewById(R.id.arrow).setVisibility(0);
            }
            return view;
        }
    }

    public static class b {
        public String name;
        public List<b> nj;
    }

    public interface c {
        void a(b bVar);
    }

    public SettingsLevelSpinner(Context context) {
        this(context, null);
    }

    public SettingsLevelSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingsLevelSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nj = new ArrayList();
        this.dIP = getResources().getDimensionPixelSize(R.dimen.dp140);
        this.dIQ = getResources().getDimensionPixelSize(R.dimen.dp170);
        this.dIR = getResources().getDimensionPixelSize(R.dimen.dp40);
        this.dIS = getResources().getDimensionPixelSize(R.dimen.dp48);
        this.dIU = new OnClickListener() {
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    SettingsLevelSpinner.this.aiE.setRotation(0.0f);
                    SettingsLevelSpinner.this.aJD();
                    return;
                }
                view.setSelected(true);
                SettingsLevelSpinner.this.aiE.setRotation(180.0f);
                SettingsLevelSpinner.this.aJC();
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.settings_level_spinner, this, true);
        this.dIT = new z(context);
        init();
    }

    private void init() {
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnClickListener(this.dIU);
        this.dDf = (TextView) findViewById(R.id.name);
        this.aiE = findViewById(R.id.arrow);
        aJz();
    }

    private void aJz() {
        aJA();
        aJB();
    }

    private void aJA() {
        this.dIJ = new PopupWindow(getContext());
        this.dIJ.setOutsideTouchable(true);
        View listView = new ListView(getContext());
        listView.setDivider(new ColorDrawable(Color.parseColor("#2b313a")));
        listView.setDividerHeight(this.dIT.L(1.0f));
        this.dIK = new a(getContext(), R.layout.first_level_item, R.id.name);
        listView.setAdapter(this.dIK);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (((b) SettingsLevelSpinner.this.nj.get(i)).nj.size() > 0) {
                    SettingsLevelSpinner.this.a((b) SettingsLevelSpinner.this.nj.get(i), view, i);
                    return;
                }
                SettingsLevelSpinner.this.setupSelectedItem((b) SettingsLevelSpinner.this.nj.get(i));
                if (SettingsLevelSpinner.this.dIO != null) {
                    SettingsLevelSpinner.this.dIO.a((b) SettingsLevelSpinner.this.nj.get(i));
                }
                SettingsLevelSpinner.this.aJD();
            }
        });
        this.dIJ.setFocusable(true);
        this.dIJ.setWidth(this.dIP);
        this.dIJ.setHeight(-2);
        this.dIJ.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                SettingsLevelSpinner.this.setSelected(false);
                SettingsLevelSpinner.this.aiE.setRotation(0.0f);
            }
        });
        this.dIJ.setContentView(listView);
    }

    private void aJB() {
        this.dIL = new PopupWindow(getContext());
        this.dIL.setOutsideTouchable(true);
        View listView = new ListView(getContext());
        listView.setDivider(new ColorDrawable(Color.parseColor("#bf2b313a")));
        listView.setDividerHeight(this.dIT.L(1.0f));
        this.dIM = new ArrayAdapter(getContext(), R.layout.second_level_item, R.id.name);
        listView.setAdapter(this.dIM);
        this.dIL.setFocusable(true);
        this.dIL.setWidth(this.dIQ);
        this.dIL.setHeight(-2);
        this.dIL.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                SettingsLevelSpinner.this.dIM.clear();
                SettingsLevelSpinner.this.dIM.notifyDataSetChanged();
            }
        });
        this.dIL.setContentView(listView);
    }

    private void aJC() {
        this.dIJ.showAsDropDown(this);
    }

    private void a(final b bVar, View view, int i) {
        for (b bVar2 : bVar.nj) {
            this.dIM.add(bVar2.name);
        }
        this.dIM.notifyDataSetChanged();
        ((ListView) this.dIL.getContentView()).setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (((b) bVar.nj.get(i)).nj.size() > 0) {
                    throw new OutOfUniverseDimensionsError();
                }
                SettingsLevelSpinner.this.setupSelectedItem((b) bVar.nj.get(i));
                if (SettingsLevelSpinner.this.dIO != null) {
                    SettingsLevelSpinner.this.dIO.a((b) bVar.nj.get(i));
                }
                SettingsLevelSpinner.this.aJD();
            }
        });
        view.getLocationOnScreen(new int[2]);
        getLocationOnScreen(new int[2]);
        this.dIL.showAsDropDown(this, this.dIP, i * (this.dIS + this.dIT.L(1.0f)));
    }

    private void aJD() {
        this.dIJ.dismiss();
        if (this.dIL.isShowing()) {
            this.dIL.dismiss();
        }
    }

    public void setItems(List<b> list) {
        this.nj.clear();
        this.nj.addAll(list);
        this.dIK.clear();
        this.dIK.addAll(list);
        this.dIK.notifyDataSetChanged();
        this.dIJ.setHeight(-2);
    }

    public void setSelectedItem(b bVar) {
        for (b bVar2 : this.nj) {
            if (bVar2.equals(bVar)) {
                setupSelectedItem(bVar2);
                return;
            } else if (bVar2.nj.size() > 0 && bVar2.nj.contains(bVar)) {
                setupSelectedItem(bVar);
                return;
            }
        }
    }

    public b getSelectedItem() {
        return this.dIN;
    }

    private void setupSelectedItem(b bVar) {
        this.dIN = bVar;
        this.dDf.setText(bVar.name);
    }

    public List<b> getItems() {
        return this.nj;
    }

    public void setSelectListener(c cVar) {
        this.dIO = cVar;
    }
}
