package com.iqoption.view.timer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.base.a;
import com.iqoption.view.timer.component.FlowerView;
import com.iqoption.x.R;
import java.util.concurrent.TimeUnit;

public class TimerView extends a {
    private long dAB;
    private String dJJ;
    private String dJK;
    private String dJL;
    private String dJM;
    private TextView dJN;
    private FlowerView dJO;

    public TimerView(Context context) {
        this(context, null);
    }

    public TimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAB = 0;
        aIa();
    }

    private void aIa() {
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.timer_view, this, true);
        this.dJO = (FlowerView) inflate.findViewById(R.id.flowerView);
        this.dJN = (TextView) inflate.findViewById(R.id.countDownTime);
        this.dJJ = context.getString(R.string.seconds_one_char);
        this.dJK = context.getString(R.string.minutes_one_char);
        this.dJL = context.getString(R.string.hour_one_char);
        this.dJM = context.getString(R.string.day_one_char);
    }

    public void setTextSize(float f) {
        this.dJN.setTextSize(0, f);
    }

    public void reset() {
        this.dAB = 0;
        this.dJN.setTag(R.id.id_count_down_time, null);
    }

    public void setMaxValue(long j) {
        this.dAB = j;
    }

    public long getMaxValue() {
        return this.dAB;
    }

    public void cu(long j) {
        i(j, this.dAB);
    }

    public void i(long j, long j2) {
        if (j > 0) {
            Long l = (Long) this.dJN.getTag(R.id.id_count_down_time);
            if (l == null || l.longValue() >= j) {
                Object cv = cv(j);
                if (!(TextUtils.isEmpty(cv) || cv.equalsIgnoreCase(this.dJN.getText().toString()))) {
                    this.dJN.setText(cv(j));
                }
                this.dJO.x(j, j2);
                return;
            }
            this.dJN.setTag(R.id.id_count_down_time, Long.valueOf(j));
        }
    }

    private String cv(long j) {
        long toDays = TimeUnit.MILLISECONDS.toDays(j);
        StringBuilder stringBuilder;
        if (toDays <= 0) {
            toDays = TimeUnit.MILLISECONDS.toHours(j);
            if (toDays > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(toDays);
                stringBuilder.append(this.dJL);
                return stringBuilder.toString();
            }
            toDays = TimeUnit.MILLISECONDS.toMinutes(j);
            if (toDays > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(toDays);
                stringBuilder.append(this.dJK);
                return stringBuilder.toString();
            }
            j = TimeUnit.MILLISECONDS.toSeconds(j);
            if (j < 0) {
                return "";
            }
            j = Math.max(1, j);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(j);
            stringBuilder2.append(this.dJJ);
            return stringBuilder2.toString();
        } else if (toDays > 99) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("99+");
            stringBuilder.append(this.dJM);
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(toDays);
            stringBuilder.append(this.dJM);
            return stringBuilder.toString();
        }
    }
}
