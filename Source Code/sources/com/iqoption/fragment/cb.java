package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.common.util.concurrent.o;
import com.iqoption.a.r;
import com.iqoption.a.r.b;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.ql;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.iqbus.Subscriptions;
import com.iqoption.dto.entity.iqbus.Subscriptions.Category;
import com.iqoption.dto.entity.iqbus.Subscriptions.Group;
import com.iqoption.fragment.base.g;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.util.be;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PushSettingsFragment */
public class cb extends g {
    public static final String TAG = "com.iqoption.fragment.cb";
    private ql cqF;
    private r cqG;
    private a cqH;
    AnimationDrawable cqI;
    protected Builder cqJ;

    /* compiled from: PushSettingsFragment */
    private static class a extends ItemAnimator implements AnimatorListener, AnimatorUpdateListener {
        private ValueAnimator cqL = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        private ArrayList<ViewHolder> cqM = new ArrayList();

        public boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2) {
            return false;
        }

        public boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2) {
            return false;
        }

        public boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2) {
            return false;
        }

        public void endAnimation(ViewHolder viewHolder) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public a() {
            this.cqL.setDuration(getAddDuration());
            this.cqL.setStartDelay(250);
            this.cqL.addUpdateListener(this);
            this.cqL.addListener(this);
        }

        public boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2) {
            if (viewHolder.getItemViewType() == 1) {
                this.cqM.add(viewHolder);
                View AY = ((b) viewHolder).AY();
                AY.setAlpha(0.0f);
                ((MarginLayoutParams) AY.getLayoutParams()).setMargins(0, -AY.getHeight(), 0, 0);
                AY.requestLayout();
            }
            return true;
        }

        public void runPendingAnimations() {
            this.cqL.start();
        }

        public void endAnimations() {
            this.cqL.end();
        }

        public boolean isRunning() {
            return this.cqL.isRunning();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = this.cqM.iterator();
            while (it.hasNext()) {
                View AY = ((b) ((ViewHolder) it.next())).AY();
                AY.setAlpha(floatValue);
                ((MarginLayoutParams) AY.getLayoutParams()).setMargins(0, (int) ((floatValue - 1.0f) * ((float) AY.getHeight())), 0, 0);
                AY.requestLayout();
            }
        }

        public void onAnimationEnd(Animator animator) {
            Iterator it = this.cqM.iterator();
            while (it.hasNext()) {
                dispatchAnimationFinished((ViewHolder) it.next());
            }
            this.cqM.clear();
        }

        public void onAnimationCancel(Animator animator) {
            Iterator it = this.cqM.iterator();
            while (it.hasNext()) {
                ViewHolder viewHolder = (ViewHolder) it.next();
                View AY = ((b) viewHolder).AY();
                AY.setAlpha(1.0f);
                ((MarginLayoutParams) AY.getLayoutParams()).setMargins(0, 0, 0, 0);
                AY.requestLayout();
                dispatchAnimationFinished(viewHolder);
            }
            this.cqM.clear();
        }
    }

    public String gF() {
        return "push-settings";
    }

    public static cb ahI() {
        return new cb();
    }

    public static void i(FragmentManager fragmentManager) {
        Fragment ahI = ahI();
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            fragmentManager.beginTransaction().add(R.id.other_fragment, ahI, TAG).addToBackStack(TAG).commit();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cqF = (ql) DataBindingUtil.inflate(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), (int) R.style.PushSettingsTheme)), R.layout.fragment_push_settings, viewGroup, false);
        this.cqF.a(this);
        this.cqF.bAR.setLayoutManager(new LinearLayoutManager(getContext()));
        this.cqG = new r();
        this.cqG.setHasStableIds(true);
        this.cqF.bAR.setAdapter(this.cqG);
        this.cqH = new a();
        this.cqH.setAddDuration(250);
        this.cqF.bAR.setItemAnimator(this.cqH);
        this.cqF.bAO.setBackgroundResource(R.drawable.push_settings_alert_anim);
        this.cqI = (AnimationDrawable) this.cqF.bAO.getBackground();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onResume() {
        super.onResume();
        if (NotificationManagerCompat.from(getContext()).areNotificationsEnabled()) {
            this.cqJ = null;
            this.cqF.Hw.setVisibility(0);
            this.cqF.bAR.setVisibility(0);
            this.cqF.bAP.setVisibility(8);
            o.a(f.auw(), new com.iqoption.system.c.b<cb, Subscriptions>(this) {
                /* renamed from: b */
                public void z(cb cbVar, Subscriptions subscriptions) {
                    if (cbVar.isAdded()) {
                        cbVar.a(subscriptions);
                    }
                }

                /* renamed from: a */
                public void c(cb cbVar, Throwable th) {
                    if (cbVar.isAdded()) {
                        cb.this.cqF.Hw.setVisibility(8);
                        com.iqoption.app.a.b.aT(cb.this.getContext());
                    }
                }
            }, com.iqoption.core.d.a.aSe);
            return;
        }
        this.cqJ = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "push-settings-enabling");
        this.cqF.Hw.setVisibility(8);
        this.cqF.bAR.setVisibility(8);
        this.cqF.bAP.setVisibility(0);
        this.cqF.bAQ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "push-settings-enabling_go-to-settings"));
                be.bS(cb.this.getContext());
            }
        });
        this.cqI.start();
    }

    public void onPause() {
        super.onPause();
        if (this.cqJ != null) {
            EventManager.Bm().a(this.cqJ.calcDuration().build());
        }
    }

    public View getContentView() {
        return this.cqF.getRoot();
    }

    public void ahJ() {
        onClose();
    }

    private void a(Subscriptions subscriptions) {
        this.cqF.Hw.setVisibility(8);
        if (subscriptions == null || subscriptions.categories == null) {
            com.iqoption.app.a.b.aT(getContext());
            return;
        }
        this.cqG.AX();
        Iterator it = subscriptions.categories.iterator();
        while (it.hasNext()) {
            Category category = (Category) it.next();
            this.cqG.a(category.id, category.title);
            if (category.groups != null) {
                Iterator it2 = category.groups.iterator();
                while (it2.hasNext()) {
                    Group group = (Group) it2.next();
                    this.cqG.a(group.id, group.title, group.description, group.enabled.booleanValue());
                }
            }
        }
        this.cqG.notifyDataSetChanged();
    }
}
