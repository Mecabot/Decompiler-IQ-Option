package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.i;
import com.iqoption.d.sn;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.ax;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: TradeRoomRestrictionFragment */
public final class ex extends com.iqoption.fragment.base.b {
    public static final String TAG = "com.iqoption.fragment.ex";
    private boolean coJ;
    private Animator coM;
    private int coN;
    private sn csJ;
    private boolean csK;
    private String csL;
    private b csM;
    private int id;
    @StringRes
    private int text;

    /* compiled from: TradeRoomRestrictionFragment */
    public static final class a {
        @StringRes
        private int actionText;
        private final FragmentManager bbS;
        private boolean csK;
        private final FragmentActivity csX;
        @IdRes
        private final int csY;
        private Fragment csZ;
        @ColorRes
        private int cta;
        private int id;
        @StringRes
        private int text;
        @StringRes
        private int title;

        public static a b(FragmentActivity fragmentActivity, FragmentManager fragmentManager, @IdRes int i) {
            return new a(fragmentActivity, fragmentManager, i);
        }

        private a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, @IdRes int i) {
            this.csX = fragmentActivity;
            this.bbS = fragmentManager;
            this.csY = i;
        }

        public a Q(Fragment fragment) {
            this.csZ = fragment;
            return this;
        }

        public a eG(@ColorRes int i) {
            this.cta = i;
            return this;
        }

        public a eH(@StringRes int i) {
            this.title = i;
            return this;
        }

        public a eI(@StringRes int i) {
            this.text = i;
            return this;
        }

        public a eJ(@StringRes int i) {
            this.actionText = i;
            return this;
        }

        public a eK(int i) {
            this.id = i;
            return this;
        }

        public void show() {
            ex.a(this.csX, this.bbS, this.csZ, this.csY, this.cta, this.title, this.text, this.actionText, this.csK, this.id);
        }
    }

    /* compiled from: TradeRoomRestrictionFragment */
    public interface b {
        void eF(int i);
    }

    private static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, Fragment fragment, @IdRes int i, @ColorRes int i2, @StringRes int i3, @StringRes int i4, @StringRes int i5, boolean z, int i6) {
        String valueOf = String.valueOf(System.nanoTime());
        PopupViewModel.j(fragmentActivity).a(new ey(fragmentManager, fragment, i, i2, i3, i4, i5, z, valueOf, i6), valueOf);
    }

    private static void a(@NonNull FragmentManager fragmentManager, Fragment fragment, @IdRes int i, @ColorRes int i2, @StringRes int i3, @StringRes int i4, @StringRes int i5, boolean z, String str, int i6) {
        String str2 = str;
        FragmentManager fragmentManager2 = fragmentManager;
        if (fragmentManager2.findFragmentByTag(str2) == null) {
            fragmentManager2.beginTransaction().add(i, a(fragment, i2, i3, i4, i5, z, str2, i6), str2).addToBackStack(str2).commitAllowingStateLoss();
        }
    }

    private static ex a(Fragment fragment, @ColorRes int i, @StringRes int i2, @StringRes int i3, @StringRes int i4, boolean z, String str, int i5) {
        ex exVar = new ex();
        exVar.setArguments(new g().v("ARG_IS_BLOCKED", z).O("ARG_TITTLE_COLOR", i).O("ARG_TITTLE", i2).O("ARG_TEXT", i3).O("ARG_ACTION_TEXT", i4).aA("ARG_POPUP_TAG", str).O("ARG_ID", i5).toBundle());
        exVar.setTargetFragment(fragment, 0);
        return exVar;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.csJ = (sn) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_traderoom_restriction, viewGroup, false);
        Bundle arguments = getArguments();
        int i = arguments.getInt("ARG_TITTLE_COLOR");
        int i2 = arguments.getInt("ARG_TITTLE");
        int i3 = arguments.getInt("ARG_ACTION_TEXT");
        this.text = arguments.getInt("ARG_TEXT");
        this.csK = arguments.getBoolean("ARG_IS_BLOCKED");
        this.csL = arguments.getString("ARG_POPUP_TAG");
        this.id = arguments.getInt("ARG_ID");
        this.coN = com.iqoption.util.b.bQ(requireContext());
        this.csJ.bxe.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                ex.this.onClose();
            }
        });
        this.csJ.brN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                ex.this.ahm();
            }
        });
        this.csJ.bDr.setTextColor(ContextCompat.getColor(getContext(), i));
        this.csJ.bDr.setText(i2);
        this.csJ.aip.setText(this.text);
        this.csJ.brN.setText(i3);
        return this.csJ.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void ahm() {
        this.coJ = true;
        onClose();
        if (this.csM != null) {
            com.iqoption.core.d.a.aSe.execute(new ez(this, this.csM));
        }
    }

    final /* synthetic */ void a(b bVar) {
        bVar.eF(this.id);
    }

    public boolean onClose() {
        if (!this.csK || this.coJ) {
            requireFragmentManager().popBackStack();
            PopupViewModel.j(requireActivity()).hO(this.csL);
        } else {
            ahn();
        }
        return true;
    }

    private void ahn() {
        if (this.coM != null) {
            this.coM.cancel();
        }
        this.coM = com.iqoption.util.b.o(this.csJ.blV, this.coN);
    }

    public void ND() {
        this.csJ.blV.setAlpha(0.0f);
        float f;
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            float f2 = (float) dimensionPixelSize2;
            this.csJ.blV.setTranslationX(f2);
            f = (float) (-dimensionPixelSize2);
            this.csJ.blV.setTranslationY(f);
            this.csJ.aip.setTranslationX(f2);
            this.csJ.aip.setTranslationY(f);
            this.csJ.aip.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.csJ.blV, this.csJ.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.csJ.blV.getWidth(), (double) this.csJ.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.csJ.blV;
            r6 = new PropertyValuesHolder[2];
            r6[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r6[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r6);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            TextView textView = this.csJ.aip;
            r11 = new PropertyValuesHolder[3];
            r11[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r11[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            r11[2] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(textView, r11);
            ofPropertyValuesHolder2.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.play(ofPropertyValuesHolder2).after(100);
            animatorSet.start();
            this.csJ.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        f = (float) (-dimensionPixelOffset);
        this.csJ.blV.setTranslationX(f);
        this.csJ.blV.setTranslationY(f);
        this.csJ.blV.setPivotX((float) (this.csJ.blV.getWidth() - dimensionPixelOffset));
        this.csJ.blV.setPivotY(1.0f);
        this.csJ.blV.setScaleX(0.3f);
        this.csJ.blV.setScaleY(0.3f);
        this.csJ.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.csJ.blV.animate().alpha(0.0f).setInterpolator(d.dEM).start();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getTargetFragment() instanceof b) {
            this.csM = (b) getTargetFragment();
        } else if (getParentFragment() instanceof b) {
            this.csM = (b) getParentFragment();
        } else if (context instanceof b) {
            this.csM = (b) context;
        } else {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" doesn't implement OnFragmentInteractionListener");
            i.w(str, stringBuilder.toString());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.csM = null;
    }
}
