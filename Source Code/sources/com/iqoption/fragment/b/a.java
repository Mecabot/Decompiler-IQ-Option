package com.iqoption.fragment.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.iqoption.app.af;
import com.iqoption.x.R;

/* compiled from: PriceMovementsAttention */
public class a {
    private static a cHN = new a();

    public static a aof() {
        return cHN;
    }

    public void a(final Context context, final View view, int i) {
        if (!af.aR(context).Fe()) {
            com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                public void run() {
                    a.this.d(context, view);
                }
            }, (long) i);
        }
    }

    private void d(Context context, View view) {
        if (!af.aR(context).Fe()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.price_movements_attention, null);
            final PopupWindow popupWindow = new PopupWindow(inflate);
            popupWindow.setWidth(-1);
            popupWindow.setHeight(-1);
            popupWindow.setAnimationStyle(R.style.PickerPopup);
            inflate.findViewById(R.id.iUnderstand).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    af.aR(view.getContext()).be(true);
                    popupWindow.dismiss();
                }
            });
            popupWindow.showAtLocation(view, 0, 0, 0);
        }
    }
}
