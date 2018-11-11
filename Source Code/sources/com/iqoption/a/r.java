package com.iqoption.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.d.ahc;
import com.iqoption.d.ahe;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.x.R;
import java.util.ArrayList;

/* compiled from: PushSettingsAdapter */
public class r extends Adapter<ViewHolder> {
    private ArrayList<c> ahW = new ArrayList();

    /* compiled from: PushSettingsAdapter */
    public static class c {
        public boolean aia = false;
        public String description;
        public boolean enabled;
        public Long id;
        public String title;
        public int type;
    }

    /* compiled from: PushSettingsAdapter */
    public static class a extends ViewHolder {
        ahc ahX;

        private a(ahc ahc) {
            super(ahc.getRoot());
            this.ahX = ahc;
        }

        public void a(c cVar) {
            this.ahX.bQs.setText(cVar.title);
        }
    }

    /* compiled from: PushSettingsAdapter */
    public static class b extends ViewHolder implements OnCheckedChangeListener {
        private c ahY;
        private ahe ahZ;

        b(ahe ahe) {
            super(ahe.getRoot());
            this.ahZ = ahe;
            ahe.bQv.setOnCheckedChangeListener(this);
        }

        public void a(c cVar) {
            this.ahY = cVar;
            this.ahZ.bQs.setText(this.ahY.title);
            this.ahZ.bQu.setText(this.ahY.description);
            this.ahZ.bQv.setOnCheckedChangeListener(null);
            this.ahZ.bQv.setChecked(this.ahY.enabled);
            this.ahZ.bQv.setOnCheckedChangeListener(this);
            if (this.ahY.aia) {
                this.ahZ.bQw.setVisibility(0);
                this.ahZ.bQv.setEnabled(false);
                return;
            }
            this.ahZ.bQw.setVisibility(4);
            this.ahZ.bQv.setEnabled(true);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Context context = this.itemView.getContext();
            EventManager Bm = EventManager.Bm();
            String str = Event.CATEGORY_BUTTON_PRESSED;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("push-settings_");
            stringBuilder.append(this.ahY.id);
            Bm.a(Event.Builder(str, stringBuilder.toString()).setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
            this.ahY.enabled = z;
            af.aR(context).a(this.ahY.id.longValue(), this.ahY.enabled);
            f.a(this.ahY.id, Boolean.valueOf(this.ahY.enabled));
        }

        public View AY() {
            return this.ahZ.bQu;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 0:
                return new a((ahc) DataBindingUtil.inflate(from, R.layout.push_settings_category_item, viewGroup, false));
            case 1:
                return new b((ahe) DataBindingUtil.inflate(from, R.layout.push_settings_group_item, viewGroup, false));
            default:
                return null;
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        c cVar = (c) this.ahW.get(i);
        switch (cVar.type) {
            case 0:
                ((a) viewHolder).a(cVar);
                return;
            case 1:
                ((b) viewHolder).a(cVar);
                return;
            default:
                return;
        }
    }

    public int getItemCount() {
        return this.ahW == null ? 0 : this.ahW.size();
    }

    public final int getItemViewType(int i) {
        return ((c) this.ahW.get(i)).type;
    }

    public long getItemId(int i) {
        return ((c) this.ahW.get(i)).id.longValue();
    }

    public void a(Long l, String str) {
        c cVar = new c();
        cVar.type = 0;
        cVar.id = l;
        cVar.title = str;
        this.ahW.add(cVar);
    }

    public void a(Long l, String str, String str2, boolean z) {
        c cVar = new c();
        cVar.type = 1;
        cVar.id = l;
        cVar.title = str;
        cVar.description = str2;
        cVar.enabled = z;
        this.ahW.add(cVar);
    }

    public void AX() {
        this.ahW.clear();
    }
}
