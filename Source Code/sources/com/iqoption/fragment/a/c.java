package com.iqoption.fragment.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.iqoption.app.managers.feature.b;
import com.iqoption.dto.entity.Feature;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: FeatureFragment */
public class c extends Fragment {
    private Switch czu;
    private ListView czv;
    private a czw;

    /* compiled from: FeatureFragment */
    public class a extends BaseAdapter implements OnClickListener {
        private ImmutableList<Feature> czA;
        private final String[] czy = new String[]{"enabled", "disabled"};
        private SparseArray<WeakReference<AutoCompleteTextView>> czz = new SparseArray();

        public a(ImmutableList<Feature> immutableList) {
            this.czA = immutableList;
        }

        public int getCount() {
            return this.czA == null ? 0 : this.czA.size();
        }

        /* renamed from: eT */
        public Feature getItem(int i) {
            return (Feature) this.czA.get(i);
        }

        public long getItemId(int i) {
            return (long) ((Feature) this.czA.get(i)).name.hashCode();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(c.this.getContext()).inflate(R.layout.switcher_item, null);
            TextView textView = (TextView) view.findViewById(R.id.title);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.edit);
            View findViewById = view.findViewById(R.id.apply);
            Feature eT = getItem(i);
            autoCompleteTextView.setAdapter(new ArrayAdapter(c.this.getContext(), 17367050, this.czy));
            autoCompleteTextView.setTag(Integer.valueOf(i));
            this.czz.put(i, new WeakReference(autoCompleteTextView));
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            autoCompleteTextView.setText(eT.status);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(eT.name);
            stringBuilder.append(" - v");
            stringBuilder.append(eT.version);
            textView.setText(stringBuilder.toString());
            return view;
        }

        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.czz.get(intValue) != null) {
                Object obj = ((AutoCompleteTextView) ((WeakReference) this.czz.get(intValue)).get()).getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    getItem(intValue).status = obj;
                    b.HT().a(new Feature[]{r4});
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.debug_console_feature, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.clearFeature).setOnClickListener(new d(this));
        this.czu = (Switch) view.findViewById(R.id.switcherDebugFeature);
        this.czu.setChecked(b.HW());
        this.czu.setOnClickListener(new e(this));
        this.czv = (ListView) view.findViewById(R.id.listFeature);
        this.czw = new a(b.HT().HX());
        this.czv.setAdapter(this.czw);
        this.czv.setOnTouchListener(f.ckx);
    }

    final /* synthetic */ void aZ(View view) {
        this.czw.czA = null;
        this.czw.notifyDataSetChanged();
        b.HT().HV();
        b.HZ();
    }

    final /* synthetic */ void aY(View view) {
        b.bx(this.czu.isChecked());
    }
}
