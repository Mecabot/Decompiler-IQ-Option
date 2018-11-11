package com.iqoption.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iqoption.dto.SupportMessage;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: SupportOverviewAdapter */
public class v extends BaseAdapter {
    private Activity Cj;
    private List<SupportMessage> aij = new ArrayList();
    private SimpleDateFormat aiu = new SimpleDateFormat("HH:mm dd.MM.yyyy");

    /* compiled from: SupportOverviewAdapter */
    private static class a {
        private TextView aio;
        private TextView aip;
        private TextView aiq;

        public a(View view) {
            this.aip = (TextView) view.findViewById(R.id.supportText);
            this.aio = (TextView) view.findViewById(R.id.supportSubject);
            this.aiq = (TextView) view.findViewById(R.id.supportTime);
        }
    }

    public long getItemId(int i) {
        return 0;
    }

    public v(Activity activity, List<SupportMessage> list) {
        this.Cj = activity;
        y(list);
    }

    public void y(List<SupportMessage> list) {
        if (list != null) {
            this.aij = list;
        }
    }

    public int getCount() {
        return this.aij.size();
    }

    public Object getItem(int i) {
        return this.aij.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Cj.getLayoutInflater().inflate(R.layout.support_overview_item, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        SupportMessage supportMessage = (SupportMessage) this.aij.get(i);
        aVar.aip.setText(supportMessage.text);
        if (supportMessage.isIncoming(this.Cj)) {
            aVar.aip.setTextColor(this.Cj.getResources().getColor(R.color.blue));
        } else {
            aVar.aip.setTextColor(this.Cj.getResources().getColor(R.color.gray_color));
        }
        aVar.aio.setText(supportMessage.subject);
        aVar.aiq.setText(this.aiu.format(new Date(supportMessage.created.longValue())));
        return view;
    }
}
