package com.iqoption.fragment.cashbox;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.iqoption.core.microservices.billing.response.deposit.d;
import com.iqoption.d.gm;
import com.iqoption.x.R;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: DepositAmountAdapter */
public class c extends Adapter {
    private static final String TAG = "com.iqoption.fragment.cashbox.c";
    private String aOu;
    private final int ahg;
    @Nullable
    private RecyclerView ahx;
    private ImmutableList<d> cwo;
    private final b cwp;
    private String cwq;
    private final int cwr;
    private final int cws;
    private final int cwt;
    private d cwu;
    private HashSet<d> cwv = new HashSet();
    private OnClickListener cww = new OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x006f  */
        public void onClick(android.view.View r6) {
            /*
            r5 = this;
            r0 = com.iqoption.fragment.cashbox.c.this;
            r0 = r0.cwo;
            r1 = com.iqoption.fragment.cashbox.c.this;
            r1 = r1.cwu;
            r0 = r0.indexOf(r1);
            r1 = com.iqoption.fragment.cashbox.c.this;
            r2 = 0;
            r1.cwu = r2;
            r1 = com.iqoption.fragment.cashbox.c.this;
            r1 = r1.ahx;
            r2 = -1;
            if (r1 == 0) goto L_0x0065;
        L_0x001f:
            r1 = com.iqoption.fragment.cashbox.c.this;
            r1 = r1.ahx;
            r6 = r1.getChildLayoutPosition(r6);
            if (r6 == r2) goto L_0x0065;
        L_0x002b:
            r1 = com.iqoption.fragment.cashbox.c.this;
            r1 = r1.cwo;
            r1 = r1.size();
            if (r6 >= r1) goto L_0x0065;
        L_0x0037:
            r1 = com.iqoption.fragment.cashbox.c.this;
            r1 = r1.cwo;
            r1 = r1.get(r6);
            r1 = (com.iqoption.core.microservices.billing.response.deposit.d) r1;
            r3 = com.iqoption.fragment.cashbox.c.this;
            r3.cwu = r1;
            r3 = com.iqoption.fragment.cashbox.c.this;
            r3.notifyItemChanged(r6);
            r3 = com.iqoption.fragment.cashbox.c.this;
            r3 = r3.cwp;
            if (r3 == 0) goto L_0x0066;
        L_0x0055:
            r3 = com.iqoption.fragment.cashbox.c.this;
            r3 = r3.cwp;
            r4 = com.iqoption.fragment.cashbox.c.this;
            r4 = r4.aOu;
            r3.b(r1, r4);
            goto L_0x0066;
        L_0x0065:
            r6 = -1;
        L_0x0066:
            if (r6 == r2) goto L_0x006d;
        L_0x0068:
            r1 = com.iqoption.fragment.cashbox.c.this;
            r1.notifyItemChanged(r6);
        L_0x006d:
            if (r0 == r2) goto L_0x0074;
        L_0x006f:
            r6 = com.iqoption.fragment.cashbox.c.this;
            r6.notifyItemChanged(r0);
        L_0x0074:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cashbox.c.1.onClick(android.view.View):void");
        }
    };

    /* compiled from: DepositAmountAdapter */
    public interface b {
        void b(d dVar, String str);
    }

    /* compiled from: DepositAmountAdapter */
    public static class a extends ViewHolder {
        private Animator animator;
        private final gm cwy;

        public static a n(ViewGroup viewGroup) {
            return new a((gm) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.deposit_page_amount_item, viewGroup, false));
        }

        public a(gm gmVar) {
            super(gmVar.getRoot());
            this.cwy = gmVar;
        }

        public gm akd() {
            return this.cwy;
        }

        public void setAnimator(Animator animator) {
            this.animator = animator;
        }

        @Nullable
        public Animator getAnimator() {
            return this.animator;
        }
    }

    public void b(d dVar) {
        int indexOf = this.cwo.indexOf(this.cwu);
        int indexOf2 = this.cwo.indexOf(dVar);
        if (indexOf != indexOf2) {
            this.cwu = dVar;
            if (indexOf != -1) {
                notifyItemChanged(indexOf);
            }
            if (indexOf2 != -1) {
                notifyItemChanged(indexOf2);
            }
        }
    }

    public void a(Collection<d> collection, String str, String str2) {
        this.cwo = collection == null ? ImmutableList.sL() : ImmutableList.m(collection);
        this.cwq = str;
        this.aOu = str2;
        this.cwu = null;
        this.cwv.clear();
        notifyDataSetChanged();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.ahx = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = null;
    }

    public c(Context context, Collection<d> collection, String str, String str2, b bVar) {
        this.cwo = collection == null ? ImmutableList.sL() : ImmutableList.m(collection);
        this.cwq = str;
        this.aOu = str2;
        this.cwp = bVar;
        this.cwr = ContextCompat.getColor(context, R.color.deposit_page_orange);
        this.cwt = ContextCompat.getColor(context, R.color.deposit_page_frame_orange_filling_start);
        this.cws = ContextCompat.getColor(context, R.color.deposit_page_frame_orange_filling_end);
        this.ahg = ContextCompat.getColor(context, R.color.deposit_page_green);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder n = a.n(viewGroup);
        n.akd().getRoot().setOnClickListener(this.cww);
        return n;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        gm akd = aVar.akd();
        d dVar = (d) this.cwo.get(i);
        akd.bph.setText(w(dVar.UO()));
        boolean equals = "vip".equals(dVar.UP());
        boolean equal = f.equal(dVar, this.cwu);
        int i2 = R.drawable.deposit_page_amount_item_white_border;
        if (equals) {
            equals = this.cwv.contains(dVar);
            akd.bpr.setVisibility(0);
            TextView textView = akd.bph;
            if (equal) {
                i2 = R.drawable.deposit_page_amount_item_orange_border;
            }
            textView.setBackgroundResource(i2);
            TextView textView2 = akd.bph;
            int i3 = (equal || equals) ? this.cwr : this.ahg;
            textView2.setTextColor(i3);
            if (!(equal || equals)) {
                Animator a = a(akd);
                a.setStartDelay(500);
                Animator animator = aVar.getAnimator();
                if (animator != null) {
                    animator.cancel();
                }
                this.cwv.add(dVar);
                aVar.setAnimator(a);
                a.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                    }
                });
                a.start();
            }
            if (equal) {
                this.cwv.add(dVar);
                return;
            }
            return;
        }
        akd.bpr.setVisibility(8);
        akd.bpq.setVisibility(8);
        akd.bpp.setBackgroundColor(this.cwt);
        TextView textView3 = akd.bph;
        if (equal) {
            i2 = R.drawable.deposit_page_amount_item_green_border;
        }
        textView3.setBackgroundResource(i2);
        akd.bph.setTextColor(this.ahg);
    }

    private Animator a(gm gmVar) {
        gm gmVar2 = gmVar;
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe.ofFloat(0.5f, 1.0f).setInterpolator(new LinearInterpolator());
        Keyframe.ofFloat(1.0f, 0.0f).setInterpolator(new LinearInterpolator());
        gmVar2.bpq.setAlpha(0.0f);
        gmVar2.bpq.setVisibility(0);
        ImageView imageView = gmVar2.bpq;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat, r6, r7});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration(1200);
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        gmVar2.bpr.setAlpha(0.0f);
        AppCompatImageView appCompatImageView = gmVar2.bpr;
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[1];
        propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(appCompatImageView, propertyValuesHolderArr2);
        ofPropertyValuesHolder2.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder2.setDuration(1200);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(gmVar2.bph, "textColor", new int[]{this.ahg, this.cwr});
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(840);
        Keyframe ofInt2 = Keyframe.ofInt(0.0f, this.cwt);
        Keyframe.ofInt(0.5f, this.cws).setInterpolator(new LinearInterpolator());
        Keyframe.ofInt(1.0f, this.cwt).setInterpolator(new LinearInterpolator());
        View view = gmVar2.bpp;
        PropertyValuesHolder[] propertyValuesHolderArr3 = new PropertyValuesHolder[1];
        propertyValuesHolderArr3[0] = PropertyValuesHolder.ofKeyframe("backgroundColor", new Keyframe[]{ofInt2, r4, r5});
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr3);
        ofPropertyValuesHolder3.setEvaluator(new ArgbEvaluator());
        ofPropertyValuesHolder3.setDuration(1200);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder2, ofInt, ofPropertyValuesHolder3});
        return animatorSet;
    }

    public int getItemCount() {
        return this.cwo.size();
    }

    private String w(double d) {
        return String.format(Locale.US, "%s%s", new Object[]{this.cwq, b.h(Double.valueOf(d))});
    }
}
