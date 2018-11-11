package com.iqoption.a;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.dialog.e;
import com.iqoption.dto.SupportMessage;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: SupportChatAdapter */
public class u extends BaseAdapter {
    private List<SupportMessage> aij = new ArrayList();
    private FragmentActivity aik;
    private DateFormat ail = bf.dwG;
    OnClickListener aim = new OnClickListener() {
        public void onClick(View view) {
            e.bg(((Long) view.getTag()).longValue()).show(u.this.aik.getSupportFragmentManager(), "RateTicketDialog");
        }
    };

    /* compiled from: SupportChatAdapter */
    private static class a {
        private TextView aio;
        private TextView aip;
        private TextView aiq;
        private TextView air;
        private View ais;
        private ImageView[] ait = new ImageView[5];

        public a(View view) {
            this.aip = (TextView) view.findViewById(R.id.supportText);
            this.aio = (TextView) view.findViewById(R.id.supportSubject);
            this.aiq = (TextView) view.findViewById(R.id.supportTime);
            this.air = (TextView) view.findViewById(R.id.rateLink);
            this.ais = view.findViewById(R.id.containerStar);
            this.ait[0] = (ImageView) view.findViewById(R.id.star1);
            this.ait[1] = (ImageView) view.findViewById(R.id.star2);
            this.ait[2] = (ImageView) view.findViewById(R.id.star3);
            this.ait[3] = (ImageView) view.findViewById(R.id.star4);
            this.ait[4] = (ImageView) view.findViewById(R.id.star5);
        }
    }

    public long getItemId(int i) {
        return 0;
    }

    public u(FragmentActivity fragmentActivity, List<SupportMessage> list) {
        this.aik = fragmentActivity;
        y(list);
    }

    public void y(List<SupportMessage> list) {
        if (list != null) {
            this.aij = list;
        }
    }

    public void b(long j, int i) {
        for (SupportMessage supportMessage : this.aij) {
            if (supportMessage.id == j) {
                supportMessage.canBeRated = false;
                supportMessage.rate = i;
                return;
            }
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
            view = this.aik.getLayoutInflater().inflate(R.layout.support_chat_item, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        SupportMessage supportMessage = (SupportMessage) this.aij.get(i);
        aVar.aio.setText(supportMessage.isIncoming(this.aik) ? R.string.support : R.string.you);
        aVar.aio.setTextColor(supportMessage.isIncoming(this.aik) ? Color.parseColor("#93a8c2") : this.aik.getResources().getColor(R.color.blue));
        aVar.aip.setText(supportMessage.text);
        aVar.aip.setBackgroundResource(supportMessage.isIncoming(this.aik) ? R.drawable.text_bubble : R.drawable.text_bubble2);
        aVar.aiq.setText(this.ail.format(new Date(supportMessage.created.longValue())));
        int i2 = 8;
        int i3 = 0;
        if (supportMessage.canBeRated) {
            TextView d = aVar.air;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<u>");
            stringBuilder.append(this.aik.getString(R.string.rate_the_answer));
            stringBuilder.append("</u>");
            d.setText(Html.fromHtml(stringBuilder.toString()));
            aVar.air.setVisibility(0);
            aVar.air.setOnClickListener(this.aim);
            aVar.air.setTag(Long.valueOf(supportMessage.id));
        } else {
            aVar.air.setVisibility(8);
            aVar.air.setOnClickListener(null);
        }
        View e = aVar.ais;
        if (supportMessage.rate > 0) {
            i2 = 0;
        }
        e.setVisibility(i2);
        while (i3 < aVar.ait.length) {
            if (i3 < supportMessage.rate) {
                aVar.ait[i3].setImageResource(R.drawable.rate_star_on);
            } else {
                aVar.ait[i3].setImageResource(R.drawable.rate_star_grey_off);
            }
            i3++;
        }
        return view;
    }
}
