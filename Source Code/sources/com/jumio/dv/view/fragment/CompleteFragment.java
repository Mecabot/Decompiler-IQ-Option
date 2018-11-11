package com.jumio.dv.view.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.SVGImageView;
import com.jumio.core.data.Strings;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.dv.R;
import com.jumio.dv.api.calls.DvBackend;
import com.jumio.dv.view.interactors.CompleteView;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.gui.CircleView;
import com.jumio.sdk.gui.MaterialProgressBar;
import com.jumio.sdk.models.CredentialsModel;

@RequiresPresenter(com.jumio.dv.b.a.class)
public class CompleteFragment extends DvBaseFragment<com.jumio.dv.b.a> implements IDvActivityCallback, CompleteView {
    private ViewGroup a;
    private SVGImageView b;
    private CircleView c;
    private MaterialProgressBar d;
    private FrameLayout e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private View j;
    private Button k;
    private JumioException l;
    private c m;

    private class a implements OnClickListener {
        private JumioException b;

        public a(JumioException jumioException) {
            this.b = jumioException;
        }

        public void onClick(View view) {
            ((com.jumio.dv.b.a) CompleteFragment.this.getPresenter()).a(this.b);
        }
    }

    private class b implements OnClickListener {
        private b() {
        }

        /* synthetic */ b(CompleteFragment completeFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onClick(View view) {
            view.setEnabled(false);
            if (CompleteFragment.this.l != null) {
                CompleteFragment.this.l = null;
            }
            ((com.jumio.dv.b.a) CompleteFragment.this.getPresenter()).a();
            CompleteFragment.this.a(c.PROGRESS);
            view.setEnabled(true);
        }
    }

    private enum c {
        PROGRESS,
        SUCCESS,
        ERROR
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((IDvFragmentCallback) this.callback).registerActivityCallback(this);
        if (bundle != null) {
            this.l = (JumioException) bundle.getSerializable("JumioException");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putSerializable("JumioException", this.l);
        }
    }

    public boolean onBackButtonPressed() {
        if (this.m == c.SUCCESS) {
            return true;
        }
        if (this.l == null || this.l.getErrorCase().retry()) {
            DvBackend.cancelAllPending();
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
            this.i.setTranslationY((float) (-this.i.getHeight()));
            this.j.setAlpha(1.0f);
            setStatusBarColor(typedValue.data);
            return false;
        }
        ((com.jumio.dv.b.a) getPresenter()).a(this.l);
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = new FrameLayout(getContext());
        this.e.setLayoutParams(new LayoutParams(-1, -1));
        getActivity().findViewById(R.id.fragment_container).bringToFront();
        ((IDvFragmentCallback) this.callback).setUiAutomationId(R.string.documentverification_automation_submission);
        return this.e;
    }

    public void handleOrientationChange(boolean z, boolean z2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        if (z2) {
            this.e.removeAllViews();
        }
        this.a = (ViewGroup) from.inflate(z ? R.layout.dv_fragment_complete_portrait : R.layout.dv_fragment_complete_landscape, null);
        this.g = (TextView) this.a.findViewById(R.id.upload_title);
        this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), "upload_progress")));
        this.f = (TextView) this.a.findViewById(R.id.upload_description);
        this.f.setText(Strings.getExternalString(getContext(), "upload_progress_description"));
        this.h = this.a.findViewById(R.id.upload_separator);
        this.h.setVisibility(0);
        this.i = getActivity().findViewById(R.id.loadingBackground);
        this.j = getActivity().findViewById(R.id.toolbarContainer);
        View view = this.i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g.getText());
        stringBuilder.append("\n");
        stringBuilder.append(this.f.getText());
        view.setContentDescription(stringBuilder.toString());
        int dpToPx = ScreenUtil.dpToPx(getContext(), 190);
        int dpToPx2 = ScreenUtil.dpToPx(getContext(), 40);
        int dpToPx3 = ScreenUtil.dpToPx(getContext(), 6);
        RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.doctype_container);
        this.d = new MaterialProgressBar(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.addRule(13);
        this.d.setLayoutParams(layoutParams);
        this.d.setPadding(0, 0, 0, 0);
        this.d.setCircleBackgroundEnabled(false);
        this.d.setProgressStokeWidth(dpToPx3);
        relativeLayout.addView(this.d);
        this.c = new CircleView(getContext());
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(13);
        this.c.setLayoutParams(layoutParams2);
        this.c.setPadding(0, 0, 0, 0);
        this.c.setVisibility(4);
        relativeLayout.addView(this.c);
        this.b = new SVGImageView(getContext());
        layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(13);
        this.b.setLayoutParams(layoutParams2);
        this.b.setPadding(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
        this.b.setPathString("M520 743 l0 -458 -208 208 -207 207 -53 -53 -52 -52 300 -300 300 -300 300 300 300 300 -52 52 -53 53 -207 -207 -208 -208 0 458 0 457 -80 0 -80 0 0 -457z");
        relativeLayout.addView(this.b);
        this.k = (Button) this.a.findViewById(R.id.upload_retry);
        this.a.setVisibility(0);
        this.a.setVisibility(0);
        if (z2) {
            if (this.m.equals(c.PROGRESS)) {
                this.c.setVisibility(4);
                this.b.setPathString("M520 743 l0 -458 -208 208 -207 207 -53 -53 -52 -52 300 -300 300 -300 300 300 300 300 -52 52 -53 53 -207 -207 -208 -208 0 458 0 457 -80 0 -80 0 0 -457z");
                this.b.requestLayout();
                this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), "upload_progress")));
                this.f.setText(Strings.getExternalString(getContext(), "upload_progress_description"));
                this.k.setVisibility(8);
            } else if (this.m.equals(c.SUCCESS)) {
                this.c.setScaleX(1.0f);
                this.c.setScaleY(1.0f);
                this.c.setVisibility(0);
                this.b.setPathString("M226.749912,330.55 L166.199912,270 L146.016579,290.183333 L226.749912,370.916667 L399.749912,197.916667 L379.566579,177.733333 L226.749912,330.55 Z");
                this.b.requestLayout();
                this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), "upload_successful")));
                this.f.setText("");
            } else if (this.m.equals(c.ERROR)) {
                this.c.setScaleX(1.0f);
                this.c.setScaleY(1.0f);
                this.c.setVisibility(0);
                this.b.setPathString("M370.916667,190.266667 L350.733333,170.083333 L270,250.816667 L189.266667,170.083333 L169.083333,190.266667 L249.816667,271 L169.083333,351.733333 L189.266667,371.916667 L270,291.183333 L350.733333,371.916667 L370.916667,351.733333 L290.183333,271 L370.916667,190.266667 Z");
                this.b.requestLayout();
                this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), "upload_error")));
                this.f.setText(this.l.getErrorCase().localizedMessage(getContext()));
                this.k.setText(Strings.getExternalString(getContext(), this.l.getErrorCase().retry() ? "button_retry" : "button_cancel"));
                this.k.setOnClickListener(this.l.getErrorCase().retry() ? new b(this, null) : new a(this.l));
                this.k.setVisibility(0);
            }
            b(this.m);
        } else {
            this.m = c.PROGRESS;
            this.d.setAlpha(0.0f);
            this.a.setAlpha(0.0f);
            this.i.setVisibility(0);
            b(this.m);
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(R.attr.dv_submissionProgressSuccessBackground, typedValue, true);
            this.i.setBackgroundColor(typedValue.data);
        }
        this.e.addView(this.a);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.j, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(100);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                CompleteFragment.this.a("");
            }
        });
        ofFloat.start();
        ofFloat = ObjectAnimator.ofFloat(this.i, "translationY", new float[]{(float) (-this.i.getHeight()), 0.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.dv_slide_up);
        loadAnimator.setTarget(this.a);
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.d, "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(300);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(loadAnimator).before(ofFloat2);
        animatorSet.start();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void uploadComplete() {
        a(c.SUCCESS);
    }

    public CredentialsModel getCredentialsModel() {
        return ((IDvFragmentCallback) this.callback).getCredentials();
    }

    private void a(c cVar) {
        final c cVar2 = cVar;
        if (!cVar2.equals(this.m)) {
            this.m = cVar2;
            TypedValue typedValue = new TypedValue();
            TypedValue typedValue2 = new TypedValue();
            Theme theme = getContext().getTheme();
            theme.resolveAttribute(R.attr.dv_submissionProgressSuccessBackground, typedValue, true);
            theme.resolveAttribute(R.attr.dv_submissionErrorBackground, typedValue2, true);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator animatorSet2 = new AnimatorSet();
            Animator ofFloat = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{1.0f, 0.1f});
            Animator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{1.0f, 0.1f});
            Animator ofFloat3 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{1.0f, 0.2f});
            Animator ofFloat4 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{1.0f, 0.2f});
            animatorSet2.setDuration(150);
            animatorSet2.addListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (cVar2.equals(c.PROGRESS)) {
                        CompleteFragment.this.c.setVisibility(4);
                        CompleteFragment.this.b.setPathString("M520 743 l0 -458 -208 208 -207 207 -53 -53 -52 -52 300 -300 300 -300 300 300 300 300 -52 52 -53 53 -207 -207 -208 -208 0 458 0 457 -80 0 -80 0 0 -457z");
                        CompleteFragment.this.b.requestLayout();
                        CompleteFragment.this.g.setText(Html.fromHtml(Strings.getExternalString(CompleteFragment.this.getContext(), "upload_progress")));
                        CompleteFragment.this.f.setText(Strings.getExternalString(CompleteFragment.this.getContext(), "upload_progress_description"));
                        CompleteFragment.this.k.setVisibility(8);
                        CompleteFragment.this.d.setVisibility(0);
                        ((IDvFragmentCallback) CompleteFragment.this.callback).setUiAutomationId(R.string.documentverification_automation_submission);
                    } else if (cVar2.equals(c.SUCCESS)) {
                        CompleteFragment.this.c.setScaleX(0.1f);
                        CompleteFragment.this.c.setScaleY(0.1f);
                        CompleteFragment.this.c.setVisibility(0);
                        CompleteFragment.this.b.setPathString("M226.749912,330.55 L166.199912,270 L146.016579,290.183333 L226.749912,370.916667 L399.749912,197.916667 L379.566579,177.733333 L226.749912,330.55 Z");
                        CompleteFragment.this.b.requestLayout();
                        CompleteFragment.this.g.setText(Html.fromHtml(Strings.getExternalString(CompleteFragment.this.getContext(), "upload_successful")));
                        CompleteFragment.this.f.setText("");
                        CompleteFragment.this.d.setVisibility(4);
                        ((IDvFragmentCallback) CompleteFragment.this.callback).setUiAutomationId(R.string.documentverification_automation_success);
                    } else if (cVar2.equals(c.ERROR)) {
                        CompleteFragment.this.c.setScaleX(0.1f);
                        CompleteFragment.this.c.setScaleY(0.1f);
                        CompleteFragment.this.c.setVisibility(0);
                        CompleteFragment.this.b.setPathString("M370.916667,190.266667 L350.733333,170.083333 L270,250.816667 L189.266667,170.083333 L169.083333,190.266667 L249.816667,271 L169.083333,351.733333 L189.266667,371.916667 L270,291.183333 L350.733333,371.916667 L370.916667,351.733333 L290.183333,271 L370.916667,190.266667 Z");
                        CompleteFragment.this.b.requestLayout();
                        CompleteFragment.this.g.setText(Html.fromHtml(Strings.getExternalString(CompleteFragment.this.getContext(), "upload_error")));
                        CompleteFragment.this.f.setText(CompleteFragment.this.l.getErrorCase().localizedMessage(CompleteFragment.this.getContext()));
                        CompleteFragment.this.k.setAlpha(0.0f);
                        CompleteFragment.this.k.setVisibility(0);
                        CompleteFragment.this.d.setVisibility(4);
                        ((IDvFragmentCallback) CompleteFragment.this.callback).setUiAutomationId(R.string.documentverification_automation_error);
                    }
                    CompleteFragment.this.b(cVar2);
                }
            });
            Builder with = animatorSet2.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            ofFloat2 = new AnimatorSet();
            ofFloat3 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{0.1f, 1.0f});
            ofFloat4 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{0.1f, 1.0f});
            Animator ofFloat5 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{0.2f, 1.0f});
            Animator ofFloat6 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{0.2f, 1.0f});
            ofFloat2.setDuration(150);
            Builder with2 = ofFloat2.play(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
            Builder before = animatorSet.play(animatorSet2).before(ofFloat2);
            Animator ofInt;
            Animator ofFloat7;
            if (cVar2.equals(c.PROGRESS)) {
                ofInt = ValueAnimator.ofInt(new int[]{typedValue2.data, typedValue.data});
                ofInt.setDuration(300);
                ofInt.setEvaluator(new ArgbEvaluator());
                ofInt.setInterpolator(new DecelerateInterpolator());
                ofInt.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        CompleteFragment.this.i.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                before.with(ofInt);
                ofInt = ObjectAnimator.ofFloat(this.b, "rotation", new float[]{90.0f, 0.0f});
                ofFloat7 = ObjectAnimator.ofFloat(this.c, "scaleX", new float[]{1.0f, 0.1f});
                with.with(ofFloat7).with(ObjectAnimator.ofFloat(this.c, "scaleY", new float[]{1.0f, 0.1f})).with(ofInt);
                ofInt = ObjectAnimator.ofFloat(this.d, "alpha", new float[]{0.0f, 1.0f});
                ofFloat7 = ObjectAnimator.ofFloat(this.d, "scaleX", new float[]{0.1f, 1.0f});
                Animator ofFloat8 = ObjectAnimator.ofFloat(this.d, "scaleY", new float[]{0.1f, 1.0f});
                animatorSet2 = AnimatorInflater.loadAnimator(getContext(), R.animator.dv_slide_down);
                animatorSet2.setTarget(this.k);
                with2.with(ofInt).with(ofFloat7).with(ofFloat8).with(animatorSet2);
            } else {
                ofFloat2 = ObjectAnimator.ofFloat(this.d, "alpha", new float[]{1.0f, 0.0f});
                Animator ofFloat9 = ObjectAnimator.ofFloat(this.d, "scaleX", new float[]{1.0f, 0.1f});
                with.with(ofFloat2).with(ofFloat9).with(ObjectAnimator.ofFloat(this.d, "scaleY", new float[]{1.0f, 0.1f}));
                ofFloat = ObjectAnimator.ofFloat(this.c, "scaleX", new float[]{0.1f, 1.0f});
                with2.with(ofFloat).with(ObjectAnimator.ofFloat(this.c, "scaleY", new float[]{0.1f, 1.0f}));
                if (cVar2.equals(c.ERROR)) {
                    ofInt = ValueAnimator.ofInt(new int[]{typedValue.data, typedValue2.data});
                    ofInt.setDuration(300);
                    ofInt.setEvaluator(new ArgbEvaluator());
                    ofInt.setInterpolator(new DecelerateInterpolator());
                    ofInt.addUpdateListener(new AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CompleteFragment.this.i.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofFloat7 = ObjectAnimator.ofFloat(this.b, "rotation", new float[]{0.0f, 90.0f});
                    before.with(ofInt);
                    ofInt = AnimatorInflater.loadAnimator(getContext(), R.animator.dv_slide_up);
                    ofInt.setTarget(this.k);
                    with2.with(ofInt).with(ofFloat7);
                }
            }
            animatorSet.start();
        }
    }

    private void b(c cVar) {
        Object obj = cVar == c.ERROR ? 1 : null;
        TypedValue typedValue = new TypedValue();
        Theme theme = getContext().getTheme();
        theme.resolveAttribute(obj != null ? R.attr.dv_submissionErrorBackground : R.attr.dv_submissionProgressSuccessBackground, typedValue, true);
        int i = typedValue.data;
        theme.resolveAttribute(obj != null ? R.attr.dv_submissionErrorImage : R.attr.dv_submissionProgressSuccessImage, typedValue, true);
        int i2 = typedValue.data;
        this.c.setFillColor(i2);
        SVGImageView sVGImageView = this.b;
        if (cVar == c.PROGRESS) {
            i = i2;
        }
        sVGImageView.setPaintColor(i);
        this.d.setColorSchemeColors(i2);
        theme.resolveAttribute(obj != null ? R.attr.dv_submissionErrorTitle : R.attr.dv_submissionProgressSuccessTitle, typedValue, true);
        this.g.setTextColor(typedValue.data);
        theme.resolveAttribute(obj != null ? R.attr.dv_submissionErrorDescription : R.attr.dv_submissionProgressSuccessDescription, typedValue, true);
        this.f.setTextColor(typedValue.data);
        theme.resolveAttribute(obj != null ? R.attr.dv_submissionErrorSeperator : R.attr.dv_submissionProgressSuccessSeperator, typedValue, true);
        this.h.setBackgroundColor(typedValue.data);
        theme.resolveAttribute(obj != null ? R.attr.dv_submissionErrorStatusBar : R.attr.colorPrimaryDark, typedValue, true);
        setStatusBarColor(typedValue.data);
        if (obj != null && this.k.getCompoundDrawables()[0] != null) {
            theme.resolveAttribute(R.attr.dv_submissionErrorDescription, typedValue, true);
            this.k.getCompoundDrawables()[0].setColorFilter(typedValue.data, Mode.SRC_IN);
        }
    }

    public void onError(Throwable th) {
        if (!this.m.equals(c.ERROR) && (th instanceof JumioException)) {
            this.l = (JumioException) th;
            JumioErrorCase errorCase = this.l.getErrorCase();
            this.k.setText(Strings.getExternalString(getContext(), errorCase.retry() ? "button_retry" : "button_cancel"));
            this.k.setOnClickListener(errorCase.retry() ? new b(this, null) : new a(this.l));
            a(c.ERROR);
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("errorCode", Integer.valueOf(this.l.getErrorCase().code()));
            metaInfo.put("detailedErrorCode", Integer.valueOf(this.l.getDetailedErrorCase()));
            metaInfo.put("retryPossible", Boolean.valueOf(true));
        }
    }
}
