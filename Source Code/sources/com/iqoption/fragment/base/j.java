package com.iqoption.fragment.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.iqoption.core.i;
import com.iqoption.d.qj;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.au;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: PromoVideoFragment */
public class j extends b {
    public static final String TAG = "com.iqoption.fragment.base.j";
    protected qj cvX;
    protected boolean cvY = true;
    private Rect cvZ;
    private float cwa;
    private float cwb;
    private float cwc;
    private float cwd;
    private a cwe;
    protected AnimatorSet cwf;
    private int progress;

    /* compiled from: PromoVideoFragment */
    private static final class a {
        private final float alpha;
        private final float cwk;
        private final float ju;

        /* synthetic */ a(float f, float f2, float f3, AnonymousClass1 anonymousClass1) {
            this(f, f2, f3);
        }

        private a(float f, float f2, float f3) {
            this.alpha = f;
            this.cwk = f2;
            this.ju = f3;
        }
    }

    /* compiled from: PromoVideoFragment */
    private class b implements OnTouchListener {
        private float avS;
        private float cwl;
        private float start;

        private b() {
            this.avS = -1.0f;
            this.cwl = -1.0f;
            this.start = -1.0f;
        }

        /* synthetic */ b(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.avS == -1.0f) {
                this.avS = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            }
            if (this.cwl == -1.0f) {
                this.cwl = ((float) view.getHeight()) / 3.0f;
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.start = motionEvent.getY();
                    break;
                case 1:
                case 3:
                    if (this.start != -1.0f) {
                        float y = motionEvent.getY() - this.start;
                        if (Math.abs(y) > this.avS) {
                            if (Math.abs(y) <= this.cwl) {
                                j.this.a(new a(1.0f, 0.0f, 1.0f, null), 200, d.dEM);
                                break;
                            }
                            j.this.cwe = new a(0.0f, (float) ((y > 0.0f ? 1 : -1) * view.getHeight()), j.this.cvX.bAM.getScaleX(), null);
                            j.this.a();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (this.start != -1.0f) {
                        float y2 = motionEvent.getY() - this.start;
                        if (Math.abs(y2) > this.avS) {
                            float e = 1.0f - au.e(Math.abs(y2) / this.cwl, 0.0f, 1.0f);
                            j.this.cvX.bAJ.setAlpha(e);
                            e = (e * 0.1f) + 0.9f;
                            j.this.cvX.bAM.setScaleX(e);
                            j.this.cvX.bAM.setScaleY(e);
                            j.this.cvX.bAM.setTranslationY(y2);
                            break;
                        }
                    }
                    break;
            }
            return true;
        }
    }

    public static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, String str, Rect rect, boolean z) {
        a(R.id.other_fragment, fragmentActivity, fragmentManager, str, rect, z);
    }

    public static void a(@IdRes int i, FragmentActivity fragmentActivity, FragmentManager fragmentManager, String str, Rect rect, boolean z) {
        PopupViewModel.j(fragmentActivity).a(new k(i, fragmentManager, str, rect, z), TAG);
    }

    private static void a(@IdRes int i, FragmentManager fragmentManager, String str, Rect rect, boolean z) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            fragmentManager.beginTransaction().add(i, a(str, rect, z), TAG).addToBackStack(TAG).commit();
        }
    }

    public static Fragment a(String str, Rect rect, boolean z) {
        Fragment jVar = new j();
        jVar.setArguments(new g().aA("arg.videoPath", str).a("arg.revealRect", (Parcelable) rect).v("arg.allowMediaController", z).toBundle());
        return jVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.progress = bundle.getInt("key.progress");
        }
    }

    /* renamed from: akc */
    protected void b() {
        this.cvX.bAL.setOnTouchListener(new b(this, null));
        this.cvX.bAK.setVisibility(8);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        qj qjVar = (qj) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_promo_video, viewGroup, false);
        this.cvX = qjVar;
        return qjVar.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            i.w(TAG, "videoPath is empty");
            a();
            return;
        }
        Object string = arguments.getString("arg.videoPath");
        if (TextUtils.isEmpty(string)) {
            i.w(TAG, "videoPath is empty");
            a();
            return;
        }
        this.cvX.bAK.setVisibility(this.cvY ? 0 : 8);
        this.cvX.bAN.setOnErrorListener(new l(this));
        this.cvX.bAN.setOnPreparedListener(new m(this));
        this.cvX.bAN.setOnCompletionListener(new n(this));
        this.cvX.bAN.setVideoPath(string);
        this.cvX.bAN.seekTo(this.progress);
        if (arguments.getBoolean("arg.allowMediaController")) {
            this.cvX.bAN.setMediaController(new MediaController(getContext()));
        }
        this.cvZ = (Rect) arguments.getParcelable("arg.revealRect");
        if (this.cvZ != null) {
            this.cvX.getRoot().addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    j.this.cvX.getRoot().removeOnLayoutChangeListener(this);
                    int width = j.this.cvX.bAM.getWidth();
                    i = j.this.cvX.bAM.getHeight();
                    i2 = j.this.cvZ.width();
                    i3 = j.this.cvZ.height();
                    float f = (float) width;
                    j.this.cwa = ((float) i2) / f;
                    float f2 = (float) i;
                    j.this.cwb = ((float) i3) / f2;
                    float f3 = (float) j.this.cvZ.left;
                    float f4 = (float) j.this.cvZ.top;
                    j.this.cvX.bAM.setScaleX(j.this.cwa);
                    j.this.cvX.bAM.setScaleY(j.this.cwb);
                    i4 = (int) (j.this.cwb * f2);
                    j.this.cwc = f3 - ((float) ((width - ((int) (j.this.cwa * f))) / 2));
                    j.this.cwd = f4 - ((float) ((i - i4) / 2));
                    j.this.cvX.bAM.setTranslationX(j.this.cwc);
                    j.this.cvX.bAM.setTranslationY(j.this.cwd);
                    j.this.cvX.bAM.setAlpha(0.0f);
                }
            });
        }
        com.iqoption.core.ui.navigation.a aVar = null;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof com.iqoption.core.ui.navigation.a) {
            aVar = (com.iqoption.core.ui.navigation.a) parentFragment;
        }
        FragmentActivity activity = zzakw();
        if (aVar == null && (activity instanceof com.iqoption.core.ui.navigation.a)) {
            aVar = (com.iqoption.core.ui.navigation.a) activity;
        }
        if (aVar != null) {
            getLifecycle().a(new PromoVideoFragment$2(this, aVar));
        }
    }

    public void onResume() {
        super.onResume();
        this.cvX.bAN.start();
    }

    public void onPause() {
        super.onPause();
        this.cvX.bAN.pause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.progress = this.cvX.bAN.getCurrentPosition();
        bundle.putInt("key.progress", this.progress);
    }

    /* renamed from: onClose */
    public boolean a() {
        FragmentManager fragmentManager = getFragmentManager();
        if (!(fragmentManager == null || fragmentManager.isStateSaved())) {
            fragmentManager.popBackStack();
        }
        PopupViewModel.j(requireActivity()).hO(TAG);
        return true;
    }

    protected void a(a aVar, long j, Interpolator interpolator) {
        if (this.cwf != null) {
            this.cwf.cancel();
        }
        this.cwf = new AnimatorSet();
        AnimatorSet animatorSet = this.cwf;
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.cvX.bAJ, View.ALPHA, new float[]{aVar.alpha});
        FrameLayout frameLayout = this.cvX.bAM;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[5];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{aVar.alpha});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{aVar.ju});
        propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{aVar.ju});
        propertyValuesHolderArr[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
        propertyValuesHolderArr[4] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{aVar.cwk});
        animatorArr[1] = ObjectAnimator.ofPropertyValuesHolder(frameLayout, propertyValuesHolderArr);
        animatorSet.playTogether(animatorArr);
        com.iqoption.util.b.a(this.cwf, j).setInterpolator(interpolator);
        this.cwf.start();
    }

    protected void a(long j, Interpolator interpolator) {
        if (this.cwf != null) {
            this.cwf.cancel();
        }
        this.cwf = new AnimatorSet();
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.cvX.bAJ, View.ALPHA, new float[]{1.0f});
        FrameLayout frameLayout = this.cvX.bAM;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[5];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f});
        propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f});
        propertyValuesHolderArr[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
        propertyValuesHolderArr[4] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
        animatorArr[1] = ObjectAnimator.ofPropertyValuesHolder(frameLayout, propertyValuesHolderArr);
        animatorSet.playTogether(animatorArr);
        AnimatorSet animatorSet2 = this.cwf;
        Animator[] animatorArr2 = new Animator[2];
        animatorArr2[0] = ObjectAnimator.ofFloat(this.cvX.bAM, View.ALPHA, new float[]{1.0f});
        animatorArr2[1] = animatorSet;
        animatorSet2.playSequentially(animatorArr2);
        com.iqoption.util.b.a(this.cwf, j).setInterpolator(interpolator);
        this.cwf.start();
    }

    protected void b(long j, Interpolator interpolator) {
        if (this.cwf != null) {
            this.cwf.cancel();
        }
        this.cwf = new AnimatorSet();
        AnimatorSet animatorSet;
        if (this.cvZ != null) {
            animatorSet = this.cwf;
            Animator[] animatorArr = new Animator[2];
            animatorArr[0] = ObjectAnimator.ofFloat(this.cvX.bAJ, View.ALPHA, new float[]{0.0f});
            FrameLayout frameLayout = this.cvX.bAM;
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[5];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{this.cwa});
            propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{this.cwb});
            propertyValuesHolderArr[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.cwc});
            propertyValuesHolderArr[4] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{this.cwd});
            animatorArr[1] = ObjectAnimator.ofPropertyValuesHolder(frameLayout, propertyValuesHolderArr);
            animatorSet.playTogether(animatorArr);
        } else {
            animatorSet = this.cwf;
            Animator[] animatorArr2 = new Animator[2];
            animatorArr2[0] = ObjectAnimator.ofFloat(this.cvX.bAJ, View.ALPHA, new float[]{0.0f});
            animatorArr2[1] = ObjectAnimator.ofFloat(this.cvX.bAM, View.ALPHA, new float[]{0.0f});
            animatorSet.playTogether(animatorArr2);
        }
        com.iqoption.util.b.a(this.cwf, j).setInterpolator(interpolator);
        this.cwf.start();
    }

    public void ND() {
        a(500, d.dEM);
    }

    public void NE() {
        if (this.cwe != null) {
            a(this.cwe, 200, d.aQW);
        } else {
            b(200, d.dEM);
        }
    }
}
