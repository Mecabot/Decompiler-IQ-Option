package com.iqoption.a;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.a.p.e;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.af;
import com.iqoption.core.i;
import com.iqoption.d.ags;
import com.iqoption.dto.entity.iqbus.SignalLegacy;
import com.iqoption.x.R;

/* compiled from: PriceMovementsHighFrequencyAdapter */
public class q extends Adapter<n<ags>> {
    private static final String TAG = "com.iqoption.a.q";
    private ImmutableList<SignalLegacy> ahR;
    private final a ahS;
    @Nullable
    private RecyclerView ahx;

    /* compiled from: PriceMovementsHighFrequencyAdapter */
    public interface a {
        void b(SignalLegacy signalLegacy, View view);
    }

    public q(a aVar, ImmutableList<SignalLegacy> immutableList) {
        this.ahR = immutableList;
        this.ahS = aVar;
        setHasStableIds(true);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.ahx = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = null;
    }

    public void b(ImmutableList<SignalLegacy> immutableList) {
        this.ahR = immutableList;
        notifyDataSetChanged();
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                if (q.this.ahx != null) {
                    q.this.ahx.getLayoutManager().scrollToPosition(0);
                }
            }
        }, 200);
    }

    public long getItemId(int i) {
        return i < this.ahR.size() ? ((SignalLegacy) this.ahR.get(i)).id.longValue() : -1;
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    /* renamed from: a */
    public n<ags> onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new n((ags) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.price_movements_high_frequecy_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(n<ags> nVar, int i) {
        final SignalLegacy signalLegacy = (SignalLegacy) this.ahR.get(i);
        IQApp.Dk().getApplicationContext();
        CharSequence cW = com.iqoption.app.helpers.a.FI().cW(signalLegacy.active_id.intValue());
        a((n) nVar, signalLegacy);
        ((ags) nVar.ahp).bHW.setText(cW);
        e b = p.b(signalLegacy);
        ((ags) nVar.ahp).bQe.setTextColor(b.ahM);
        int indexOf = b.ahI.indexOf(37);
        if (indexOf == -1) {
            ((ags) nVar.ahp).bQe.setText(b.ahI);
        } else {
            CharSequence spannableString = new SpannableString(b.ahI);
            spannableString.setSpan(new StyleSpan(1), indexOf, indexOf + 1, 33);
            ((ags) nVar.ahp).bQe.setText(spannableString);
        }
        nVar.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (q.this.ahS != null) {
                    q.this.ahS.b(signalLegacy, view);
                }
            }
        });
    }

    private void a(n<ags> nVar, SignalLegacy signalLegacy) {
        final View root = ((ags) nVar.ahp).getRoot();
        ValueAnimator valueAnimator = (ValueAnimator) root.getTag(R.id.valueAnimatorTag);
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
            root.setTag(R.id.valueAnimatorTag, null);
        }
        long Hw = af.Hu().Hw() - (signalLegacy.created.longValue() * 1000);
        if (Hw >= 0) {
            float f = (float) Hw;
            if (f < 10000.0f) {
                float f2 = 1.0f - (f / 10000.0f);
                Hw = (long) (f2 * 10000.0f);
                int argb = Color.argb((int) (((0.20000002f * f2) + 0.3f) * 255.0f), 147, 168, 194);
                int argb2 = Color.argb(25, 147, 168, 194);
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(argb), Integer.valueOf(argb2)});
                ofObject.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((GradientDrawable) root.getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                root.setTag(R.id.valueAnimatorTag, ofObject);
                ofObject.setDuration(Hw);
                ofObject.start();
                return;
            }
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NO ANIMATION elapsed=");
        stringBuilder.append(Hw);
        i.v(str, stringBuilder.toString());
        ((GradientDrawable) root.getBackground()).setColor(Color.argb(25, 147, 168, 194));
    }

    public int getItemCount() {
        return this.ahR == null ? 0 : this.ahR.size();
    }
}
