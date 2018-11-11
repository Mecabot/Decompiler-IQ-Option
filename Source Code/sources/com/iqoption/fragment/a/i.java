package com.iqoption.fragment.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.iqoption.dto.entity.debug.ContainerEntity;
import com.iqoption.dto.entity.debug.ContainerEntity.List;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SandboxFragment */
public class i extends Fragment {
    private EditText czO;
    private ToggleButton czP;
    private ToggleButton czQ;
    private ToggleButton czR;
    private View czS;
    private EditText czT;
    private TextView czU;
    private a czV;
    private View czW;
    private View czX;
    private ListView mList;

    /* compiled from: SandboxFragment */
    public class a extends BaseAdapter implements Filterable {
        private ArrayList<ContainerEntity> cAa;
        private ArrayList<ContainerEntity> cAb;

        public void b(List list) {
            this.cAa = list;
        }

        public int getCount() {
            if (this.cAb != null && this.cAb.size() > 0) {
                return this.cAb.size();
            }
            return this.cAa == null ? 0 : this.cAa.size();
        }

        /* renamed from: eU */
        public ContainerEntity getItem(int i) {
            if (this.cAb == null || this.cAb.size() <= 0) {
                return (ContainerEntity) this.cAa.get(i);
            }
            return (ContainerEntity) this.cAb.get(i);
        }

        public long getItemId(int i) {
            if (this.cAb == null || this.cAb.size() <= 0) {
                return ((ContainerEntity) this.cAa.get(i)).id.longValue();
            }
            return ((ContainerEntity) this.cAb.get(i)).id.longValue();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(i.this.getContext()).inflate(17367043, null);
            TextView textView = (TextView) view.findViewById(16908308);
            ContainerEntity eU = getItem(i);
            textView.setText(eU.container.hostname);
            textView.setEnabled(eU.isSuccess());
            return view;
        }

        public Filter getFilter() {
            return new Filter() {
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    a.this.cAb = (ArrayList) filterResults.values;
                    a.this.notifyDataSetChanged();
                }

                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults = new FilterResults();
                    ArrayList arrayList = new ArrayList();
                    charSequence = charSequence.toString().toLowerCase();
                    Iterator it = a.this.cAa.iterator();
                    while (it.hasNext()) {
                        ContainerEntity containerEntity = (ContainerEntity) it.next();
                        if (containerEntity.container.hostname.toLowerCase().contains(charSequence.toString())) {
                            arrayList.add(containerEntity);
                        }
                    }
                    filterResults.count = arrayList.size();
                    filterResults.values = arrayList;
                    return filterResults;
                }
            };
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.debug_console_sandbox, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c6  */
    public void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
        r3 = this;
        super.onViewCreated(r4, r5);
        r5 = 2131363810; // 0x7f0a07e2 float:1.834744E38 double:1.0530336373E-314;
        r5 = r4.findViewById(r5);
        r3.czS = r5;
        r5 = 2131362818; // 0x7f0a0402 float:1.8345427E38 double:1.053033147E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.EditText) r5;
        r3.czT = r5;
        r5 = 2131363167; // 0x7f0a055f float:1.8346135E38 double:1.0530333196E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.ListView) r5;
        r3.mList = r5;
        r5 = 2131363664; // 0x7f0a0750 float:1.8347143E38 double:1.053033565E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.TextView) r5;
        r3.czU = r5;
        r5 = 2131362722; // 0x7f0a03a2 float:1.8345233E38 double:1.0530331E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.EditText) r5;
        r3.czO = r5;
        r5 = 2131362539; // 0x7f0a02eb float:1.8344861E38 double:1.0530330094E-314;
        r5 = r4.findViewById(r5);
        r3.czX = r5;
        r5 = com.iqoption.app.IQApp.Dl();
        r0 = "host edit in debug menu";
        r5 = r5.in(r0);
        r0 = r3.czO;
        r0.setText(r5);
        r5 = 2131362151; // 0x7f0a0167 float:1.8344074E38 double:1.0530328177E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.ToggleButton) r5;
        r3.czP = r5;
        r5 = r3.czP;
        r0 = new com.iqoption.fragment.a.i$1;
        r0.<init>();
        r5.setOnClickListener(r0);
        r5 = 2131362154; // 0x7f0a016a float:1.834408E38 double:1.053032819E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.ToggleButton) r5;
        r3.czQ = r5;
        r5 = r3.czQ;
        r0 = new com.iqoption.fragment.a.i$2;
        r0.<init>();
        r5.setOnClickListener(r0);
        r5 = 2131362161; // 0x7f0a0171 float:1.8344095E38 double:1.0530328226E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.ToggleButton) r5;
        r3.czR = r5;
        r5 = r3.czR;
        r0 = new com.iqoption.fragment.a.i$3;
        r0.<init>();
        r5.setOnClickListener(r0);
        r5 = com.iqoption.app.IQApp.Dl();
        r0 = "sandbox fragment on create";
        r5 = r5.in(r0);
        r0 = r5.hashCode();
        r1 = -1276401648; // 0xffffffffb3eba810 float:-1.09736106E-7 double:NaN;
        if (r0 == r1) goto L_0x00b2;
    L_0x00a2:
        r1 = -898614319; // 0xffffffffca703bd1 float:-3935988.2 double:NaN;
        if (r0 == r1) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00bc;
    L_0x00a8:
        r0 = "https://int.iqoption.com/";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x00bc;
    L_0x00b0:
        r5 = 1;
        goto L_0x00bd;
    L_0x00b2:
        r0 = "https://iqoption.com/";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x00bc;
    L_0x00ba:
        r5 = 0;
        goto L_0x00bd;
    L_0x00bc:
        r5 = -1;
    L_0x00bd:
        switch(r5) {
            case 0: goto L_0x00cc;
            case 1: goto L_0x00c6;
            default: goto L_0x00c0;
        };
    L_0x00c0:
        r5 = r3.czR;
        r5.callOnClick();
        goto L_0x00d1;
    L_0x00c6:
        r5 = r3.czP;
        r5.callOnClick();
        goto L_0x00d1;
    L_0x00cc:
        r5 = r3.czQ;
        r5.callOnClick();
    L_0x00d1:
        r5 = 2131361938; // 0x7f0a0092 float:1.8343642E38 double:1.0530327124E-314;
        r4 = r4.findViewById(r5);
        r3.czW = r4;
        r4 = r3.czW;
        r5 = new com.iqoption.fragment.a.i$4;
        r5.<init>();
        r4.setOnClickListener(r5);
        r4 = r3.czO;
        r5 = new com.iqoption.fragment.a.i$5;
        r5.<init>();
        r4.addTextChangedListener(r5);
        r4 = r3.czT;
        r5 = new com.iqoption.fragment.a.i$6;
        r5.<init>();
        r4.addTextChangedListener(r5);
        r4 = new com.iqoption.fragment.a.i$a;
        r4.<init>();
        r3.czV = r4;
        r4 = r3.mList;
        r5 = r3.czV;
        r4.setAdapter(r5);
        r4 = r3.mList;
        r5 = new com.iqoption.fragment.a.i$7;
        r5.<init>();
        r4.setOnItemClickListener(r5);
        r4 = r3.mList;
        r5 = new com.iqoption.fragment.a.i$8;
        r5.<init>();
        r4.setOnTouchListener(r5);
        r4 = new com.iqoption.mobbtech.connect.request.a.a.h;
        r5 = com.iqoption.dto.entity.debug.ContainerEntity.List.class;
        r0 = "http://sandbox.mobbtech.com/builds/?access-token=DxaNVwQiPwmRSx28AZY2bTlGlAKbdKBb";
        r1 = 0;
        r2 = r3.getContext();
        r0 = com.iqoption.mobbtech.connect.RequestManager.a(r0, r1, r2);
        r1 = new com.iqoption.fragment.a.i$9;
        r1.<init>();
        r2 = "http://sandbox.mobbtech.com/builds";
        r4.<init>(r5, r0, r1, r2);
        r4.auF();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.a.i.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    private void akX() {
        this.czS.setVisibility(8);
        this.czP.setChecked(false);
        this.czQ.setChecked(false);
        this.czR.setChecked(false);
    }
}
