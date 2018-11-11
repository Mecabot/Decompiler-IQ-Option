package com.iqoption.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.ae;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.am;
import com.iqoption.view.l;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AboutDialog */
public class a extends Dialog {
    private Builder adT = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "about_close");

    public a(Context context) {
        super(context, 16973840);
        ae.d(getContext(), 16384);
        setContentView(R.layout.about_dialog);
        getWindow().setFlags(1024, 1024);
        aep();
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                EventManager.Bm().a(a.this.adT.calcDuration().build());
            }
        });
    }

    private void aep() {
        if (IQApp.aQ(getContext())) {
            initViewPager();
        } else {
            findViewById(R.id.peopleChoose).setBackgroundDrawable(null);
            ((TextView) findViewById(R.id.peopleChooseText)).setTextColor(getContext().getResources().getColor(R.color.blue));
            findViewById(R.id.triangle1).setVisibility(8);
            findViewById(R.id.triangle2).setVisibility(8);
        }
        findViewById(R.id.backButton).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
    }

    private void initViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.abousUsPager);
        List arrayList = new ArrayList();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.about_page_1, null);
        inflate.findViewById(R.id.peopleChoose).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(1, true);
            }
        });
        arrayList.add(inflate);
        arrayList.add(LayoutInflater.from(getContext()).inflate(R.layout.about_page_2, null));
        viewPager.setAdapter(new l(arrayList));
    }

    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        getWindow().clearFlags(8);
        am.bS(getWindow().getDecorView());
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("About");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }
}
