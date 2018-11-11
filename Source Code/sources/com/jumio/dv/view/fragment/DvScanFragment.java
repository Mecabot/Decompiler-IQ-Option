package com.jumio.dv.view.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.ScaleableImageView;
import com.jumio.core.data.Strings;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.dv.R;
import com.jumio.dv.b.b;
import com.jumio.dv.view.interactors.DvScanView;
import com.jumio.dv.view.interactors.DvScanView.GuiState;
import com.jumio.sdk.exception.JumioError;
import com.jumio.sdk.exception.JumioError.ErrorInterface;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.gui.MaterialProgressBar;
import com.jumio.sdk.presentation.BaseScanPresenter.BaseScanControl;
import com.jumio.sdk.view.fragment.BaseScanFragment;

@RequiresPresenter(b.class)
public class DvScanFragment extends BaseScanFragment<b, IDvFragmentCallback> implements IDvActivityCallback, DvScanView {
    @Nullable
    private View a;
    @Nullable
    private View b;
    private boolean c = true;
    private Bitmap d;
    private int e;
    @Nullable
    private MaterialProgressBar f;
    @Nullable
    private RelativeLayout g;

    private class a implements ErrorInterface {
        private JumioException b;

        public a(JumioException jumioException) {
            this.b = jumioException;
        }

        public String getCaption() {
            return Strings.getExternalString(DvScanFragment.this.getContext(), "button_cancel");
        }

        public void getAction() {
            ((b) DvScanFragment.this.getPresenter()).a(this.b);
        }

        public int getColorID() {
            return R.attr.dv_dialogNegativeButtonTextColor;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((IDvFragmentCallback) this.callback).registerActivityCallback(this);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            ((b) getPresenter()).a((GuiState) bundle.getSerializable("guiState"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        int i = (this.rotationManager.isScreenPortrait() || this.rotationManager.isTablet()) ? R.layout.dv_confirmationview_portrait : R.layout.dv_confirmationview_landscape;
        this.b = layoutInflater.inflate(i, this.mFragmentRootView, false);
        this.b.setVisibility(4);
        this.mFragmentRootView.addView(this.b);
        i = (this.rotationManager.isScreenPortrait() || this.rotationManager.isTablet()) ? R.layout.dv_helpview_portrait : R.layout.dv_helpview_landscape;
        this.a = layoutInflater.inflate(i, null, false);
        this.a.setVisibility(4);
        this.mFragmentRootView.addView(this.a);
        this.overlayView.setAlpha(0.0f);
        return onCreateView;
    }

    public void showLoading() {
        if (this.g != null) {
            this.mFragmentRootView.removeView(this.g);
            this.g = null;
            this.f = null;
        }
        TypedValue typedValue = new TypedValue();
        int dpToPx = ScreenUtil.dpToPx(getContext(), 45);
        getContext().getTheme().resolveAttribute(R.attr.dv_scanOptionsLoadingBackground, typedValue, true);
        this.g = new RelativeLayout(this.mFragmentRootView.getContext());
        this.g.setLayoutParams(new LayoutParams(-1, -1));
        this.g.setPadding(dpToPx, 0, dpToPx, 0);
        this.g.setBackgroundColor(typedValue.data);
        dpToPx = ScreenUtil.dpToPx(getContext(), 190);
        int dpToPx2 = ScreenUtil.dpToPx(getContext(), 6);
        getContext().getTheme().resolveAttribute(R.attr.dv_scanOptionsLoadingProgress, typedValue, true);
        this.f = new MaterialProgressBar(this.mFragmentRootView.getContext());
        this.f.setLayoutParams(new LayoutParams(dpToPx, dpToPx));
        this.f.setCircleBackgroundEnabled(false);
        this.f.setColorSchemeColors(typedValue.data);
        this.f.setProgressStokeWidth(dpToPx2);
        this.g.addView(this.f);
        a();
        this.mFragmentRootView.addView(this.g);
    }

    private void a() {
        if (this.f != null) {
            LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
            if (!this.rotationManager.isScreenLandscape() || this.rotationManager.isTablet()) {
                layoutParams.addRule(14);
                layoutParams.topMargin = ScreenUtil.dpToPx(getContext(), 60);
            } else {
                layoutParams.addRule(13);
                layoutParams.topMargin = 0;
            }
            this.f.setLayoutParams(layoutParams);
        }
    }

    public void onResume() {
        super.onResume();
        ((IDvFragmentCallback) this.callback).animateActionbar(true);
        a(Strings.getExternalString(getActivity(), "scanview_title"));
    }

    protected void handleControls(boolean z, boolean z2) {
        if (this.c) {
            super.handleControls(z, z2);
        }
    }

    public void onLayoutRotated(boolean z) {
        int visibility;
        LayoutInflater from = LayoutInflater.from(getContext());
        if (this.overlayView != null) {
            this.overlayView.requestLayout();
        }
        if (this.a != null) {
            visibility = this.a.getVisibility();
            this.mFragmentRootView.removeView(this.a);
            this.a = from.inflate(z ? R.layout.dv_helpview_portrait : R.layout.dv_helpview_landscape, this.mFragmentRootView, false);
            this.a.setVisibility(visibility);
            this.mFragmentRootView.addView(this.a);
            if (visibility == 0) {
                ((b) getPresenter()).a(com.jumio.dv.b.b.a.HELP, z);
            }
        }
        if (this.b != null) {
            visibility = this.b.getVisibility();
            this.mFragmentRootView.removeView(this.b);
            this.b = from.inflate(z ? R.layout.dv_confirmationview_portrait : R.layout.dv_confirmationview_landscape, this.mFragmentRootView, false);
            this.b.setVisibility(visibility);
            this.mFragmentRootView.addView(this.b);
            if (visibility == 0) {
                ((b) getPresenter()).a(com.jumio.dv.b.b.a.CONFIRMATION, z);
            }
        }
        if (this.g != null) {
            a();
            this.g.bringToFront();
        }
        super.onLayoutRotated(z);
    }

    public void showConfirmation(String str, boolean z) {
        handleControls(false, false);
        this.c = false;
        a(Strings.getExternalString(getContext(), "scanview_title_check"));
        if (this.b != null) {
            Animator ofFloat;
            ((IDvFragmentCallback) this.callback).setUiAutomationId(R.string.documentverification_automation_confirmation);
            View findViewById = this.b.findViewById(R.id.confirmation_layout_base);
            ScaleableImageView scaleableImageView = (ScaleableImageView) this.b.findViewById(R.id.confirmationImage);
            TextView textView = (TextView) this.b.findViewById(R.id.confirmationSnackBar);
            final TextView textView2 = (TextView) this.b.findViewById(R.id.confirmationPositiveTextView);
            final TextView textView3 = (TextView) this.b.findViewById(R.id.confirmationNegativeTextView);
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
                System.gc();
            }
            this.d = BitmapFactory.decodeFile(str);
            scaleableImageView.setImageBitmap(this.d);
            textView.setText(Strings.getExternalString(getContext(), "scanview_snackbar_check"));
            if (!TextUtils.isEmpty(textView.getText())) {
                scaleableImageView.setContentDescription(textView.getText());
                findViewById.setContentDescription(textView.getText());
            }
            textView2.setEnabled(true);
            textView2.setText(Strings.getExternalString(getContext(), "scanview_readable"));
            textView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    textView2.setEnabled(false);
                    textView3.setEnabled(false);
                    ((b) DvScanFragment.this.getPresenter()).a();
                }
            });
            textView3.setEnabled(true);
            textView3.setText(Strings.getExternalString(getContext(), "scanview_retake"));
            final TextView textView4 = textView3;
            final ScaleableImageView scaleableImageView2 = scaleableImageView;
            final TextView textView5 = textView;
            textView3.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    textView2.setEnabled(false);
                    textView4.setEnabled(false);
                    DvScanFragment.this.c = true;
                    DvScanFragment.this.handleControls(((b) DvScanFragment.this.getPresenter()).control(BaseScanControl.hasMultipleCameras), ((b) DvScanFragment.this.getPresenter()).control(BaseScanControl.hasFlash));
                    if (DvScanFragment.this.b != null) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        Animator ofFloat = ObjectAnimator.ofFloat(scaleableImageView2, "alpha", new float[]{1.0f, 0.0f});
                        ofFloat.setDuration(400);
                        ofFloat.setStartDelay(100);
                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                        Builder play = animatorSet.play(ofFloat);
                        View findViewById = DvScanFragment.this.b.findViewById(R.id.buttonLayout);
                        Animator ofFloat2;
                        if (DvScanFragment.this.rotationManager.isScreenPortrait() || DvScanFragment.this.rotationManager.isTablet()) {
                            Animator ofFloat3 = ObjectAnimator.ofFloat(textView5, "translationY", new float[]{0.0f, (float) textView5.getHeight()});
                            ofFloat3.setDuration(300);
                            ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
                            ofFloat2 = ObjectAnimator.ofFloat(findViewById, "translationY", new float[]{0.0f, (float) findViewById.getHeight()});
                            ofFloat2.setStartDelay(100);
                            ofFloat2.setDuration(400);
                            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                            play.with(ofFloat3).with(ofFloat2);
                        } else {
                            ofFloat2 = ObjectAnimator.ofFloat(findViewById, "translationX", new float[]{0.0f, (float) findViewById.getWidth()});
                            ofFloat2.setDuration(300);
                            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                            play.with(ofFloat2);
                        }
                        animatorSet.addListener(new AnimatorListener() {
                            public void onAnimationCancel(Animator animator) {
                            }

                            public void onAnimationRepeat(Animator animator) {
                            }

                            public void onAnimationStart(Animator animator) {
                            }

                            public void onAnimationEnd(Animator animator) {
                                DvScanFragment.this.b.setVisibility(4);
                                ((b) DvScanFragment.this.getPresenter()).b();
                                if (DvScanFragment.this.d != null) {
                                    DvScanFragment.this.d.recycle();
                                    DvScanFragment.this.d = null;
                                    System.gc();
                                }
                            }
                        });
                        animatorSet.start();
                    }
                    DvScanFragment.this.a(Strings.getExternalString(DvScanFragment.this.getContext(), "scanview_title"));
                }
            });
            scaleableImageView.setAlpha(0.0f);
            View findViewById2 = this.b.findViewById(R.id.buttonLayout);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator ofFloat2 = ObjectAnimator.ofFloat(scaleableImageView, "alpha", new float[]{0.0f, 1.0f});
            ofFloat2.setDuration(300);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            Builder play = animatorSet.play(ofFloat2);
            if (this.rotationManager.isScreenPortrait() || this.rotationManager.isTablet()) {
                textView.setTranslationY((float) textView.getHeight());
                Animator ofFloat3 = ObjectAnimator.ofFloat(textView, "translationY", new float[]{(float) textView.getHeight(), 0.0f});
                ofFloat3.setStartDelay(100);
                ofFloat3.setDuration(400);
                ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
                findViewById2.setTranslationY((float) findViewById2.getHeight());
                ofFloat = ObjectAnimator.ofFloat(findViewById2, "translationY", new float[]{(float) findViewById2.getHeight(), 0.0f});
                ofFloat.setDuration(300);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                play.with(ofFloat3).with(ofFloat);
            } else {
                findViewById2.setTranslationX((float) findViewById2.getWidth());
                ofFloat = ObjectAnimator.ofFloat(findViewById2, "translationX", new float[]{(float) findViewById2.getWidth(), 0.0f});
                ofFloat.setDuration(300);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                play.with(ofFloat);
            }
            if (!z) {
                ofFloat = ObjectAnimator.ofFloat(this.overlayView, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(300);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                play.before(ofFloat);
            }
            this.b.setVisibility(0);
            animatorSet.start();
        }
    }

    public void extractionStarted() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                DvScanFragment.this.handleControls(false, false);
                DvScanFragment.this.c = false;
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
            System.gc();
        }
    }

    public void scansComplete() {
        ((IDvFragmentCallback) this.callback).startFragment(new CompleteFragment(), true, 0, R.animator.dv_fade_out);
    }

    public void updateUiAutomationScanId(PluginMode pluginMode) {
        StringBuilder stringBuilder = new StringBuilder(getResources().getString(R.string.documentverification_automation_scan));
        stringBuilder.append(pluginMode.toString().toLowerCase());
        ((IDvFragmentCallback) this.callback).setUiAutomationString(stringBuilder.toString());
    }

    /* JADX WARNING: Missing block: B:79:0x016b, code:
            if (r9.equals("IC") != false) goto L_0x0199;
     */
    public void showHelp(java.lang.String r9, com.jumio.dv.view.interactors.DvScanView.HelpViewStyle r10, java.lang.String r11, boolean r12) {
        /*
        r8 = this;
        r0 = r8.a;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r8.getContext();
        r1 = "scanview_title";
        r0 = com.jumio.core.data.Strings.getExternalString(r0, r1);
        r8.a(r0);
        r0 = r8.a;
        r1 = 2;
        r0.setImportantForAccessibility(r1);
        r0 = r8.a;
        r2 = 4;
        r0.setVisibility(r2);
        r0 = r8.a;
        r3 = com.jumio.dv.R.id.smallHelpView;
        r0 = r0.findViewById(r3);
        r0 = (android.widget.LinearLayout) r0;
        r3 = r8.a;
        r4 = com.jumio.dv.R.id.help_tv_title;
        r3 = r3.findViewById(r4);
        r3 = (android.widget.TextView) r3;
        r4 = r8.getPresenter();
        r4 = (com.jumio.dv.b.b) r4;
        r4 = r4.a(r10);
        r8.e = r4;
        r4 = com.jumio.dv.view.fragment.DvScanFragment.AnonymousClass6.a;
        r10 = r10.ordinal();
        r10 = r4[r10];
        r4 = 8;
        r5 = 0;
        switch(r10) {
            case 1: goto L_0x0059;
            case 2: goto L_0x0055;
            case 3: goto L_0x0051;
            case 4: goto L_0x004d;
            default: goto L_0x004c;
        };
    L_0x004c:
        goto L_0x005c;
    L_0x004d:
        r3.setVisibility(r5);
        goto L_0x005c;
    L_0x0051:
        r3.setVisibility(r5);
        goto L_0x005c;
    L_0x0055:
        r3.setVisibility(r4);
        goto L_0x005c;
    L_0x0059:
        r3.setVisibility(r4);
    L_0x005c:
        r10 = "helpview_header_document";
        r6 = 1;
        if (r11 == 0) goto L_0x0069;
    L_0x0061:
        r7 = r11.isEmpty();
        if (r7 != 0) goto L_0x0069;
    L_0x0067:
        goto L_0x01f3;
    L_0x0069:
        r11 = -1;
        r7 = r9.hashCode();
        switch(r7) {
            case 2113: goto L_0x018d;
            case 2129: goto L_0x0183;
            case 2143: goto L_0x0178;
            case 2144: goto L_0x016e;
            case 2330: goto L_0x0165;
            case 2546: goto L_0x015a;
            case 2656: goto L_0x014f;
            case 2686: goto L_0x0144;
            case 2701: goto L_0x013a;
            case 2733: goto L_0x012f;
            case 2750: goto L_0x0123;
            case 66547: goto L_0x0118;
            case 66996: goto L_0x010d;
            case 71336: goto L_0x0101;
            case 75122: goto L_0x00f6;
            case 81978: goto L_0x00ea;
            case 82403: goto L_0x00de;
            case 82806: goto L_0x00d2;
            case 2060557: goto L_0x00c7;
            case 2342130: goto L_0x00bb;
            case 2362391: goto L_0x00af;
            case 2371921: goto L_0x00a3;
            case 2541447: goto L_0x0097;
            case 2556079: goto L_0x008b;
            case 2614654: goto L_0x007f;
            case 2677568: goto L_0x0073;
            default: goto L_0x0071;
        };
    L_0x0071:
        goto L_0x0198;
    L_0x0073:
        r1 = "WWCC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x007b:
        r1 = 20;
        goto L_0x0199;
    L_0x007f:
        r1 = "USSS";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0087:
        r1 = 19;
        goto L_0x0199;
    L_0x008b:
        r1 = "STUC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0093:
        r1 = 13;
        goto L_0x0199;
    L_0x0097:
        r1 = "SENC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x009f:
        r1 = 16;
        goto L_0x0199;
    L_0x00a3:
        r1 = "MOAP";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00ab:
        r1 = 9;
        goto L_0x0199;
    L_0x00af:
        r1 = "MEDC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00b7:
        r1 = 17;
        goto L_0x0199;
    L_0x00bb:
        r1 = "LOAP";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00c3:
        r1 = 8;
        goto L_0x0199;
    L_0x00c7:
        r1 = "CAAP";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00cf:
        r1 = 4;
        goto L_0x0199;
    L_0x00d2:
        r1 = "TAC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00da:
        r1 = 22;
        goto L_0x0199;
    L_0x00de:
        r1 = "SSC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00e6:
        r1 = 25;
        goto L_0x0199;
    L_0x00ea:
        r1 = "SEL";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00f2:
        r1 = 23;
        goto L_0x0199;
    L_0x00f6:
        r1 = "LAG";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x00fe:
        r1 = 7;
        goto L_0x0199;
    L_0x0101:
        r1 = "HCC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0109:
        r1 = 14;
        goto L_0x0199;
    L_0x010d:
        r1 = "CRC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0115:
        r1 = 5;
        goto L_0x0199;
    L_0x0118:
        r1 = "CCS";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0120:
        r1 = 6;
        goto L_0x0199;
    L_0x0123:
        r1 = "VT";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x012b:
        r1 = 11;
        goto L_0x0199;
    L_0x012f:
        r1 = "VC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0137:
        r1 = 12;
        goto L_0x0199;
    L_0x013a:
        r1 = "UB";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0142:
        r1 = 3;
        goto L_0x0199;
    L_0x0144:
        r1 = "TR";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x014c:
        r1 = 10;
        goto L_0x0199;
    L_0x014f:
        r1 = "SS";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0157:
        r1 = 21;
        goto L_0x0199;
    L_0x015a:
        r1 = "PB";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0162:
        r1 = 24;
        goto L_0x0199;
    L_0x0165:
        r2 = "IC";
        r9 = r9.equals(r2);
        if (r9 == 0) goto L_0x0198;
    L_0x016d:
        goto L_0x0199;
    L_0x016e:
        r1 = "CC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0176:
        r1 = 1;
        goto L_0x0199;
    L_0x0178:
        r1 = "CB";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0180:
        r1 = 15;
        goto L_0x0199;
    L_0x0183:
        r1 = "BS";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x018b:
        r1 = 0;
        goto L_0x0199;
    L_0x018d:
        r1 = "BC";
        r9 = r9.equals(r1);
        if (r9 == 0) goto L_0x0198;
    L_0x0195:
        r1 = 18;
        goto L_0x0199;
    L_0x0198:
        r1 = -1;
    L_0x0199:
        switch(r1) {
            case 0: goto L_0x01e9;
            case 1: goto L_0x01e6;
            case 2: goto L_0x01e3;
            case 3: goto L_0x01e0;
            case 4: goto L_0x01dd;
            case 5: goto L_0x01da;
            case 6: goto L_0x01d7;
            case 7: goto L_0x01d4;
            case 8: goto L_0x01d1;
            case 9: goto L_0x01ce;
            case 10: goto L_0x01cb;
            case 11: goto L_0x01c8;
            case 12: goto L_0x01c5;
            case 13: goto L_0x01c2;
            case 14: goto L_0x01bf;
            case 15: goto L_0x01bc;
            case 16: goto L_0x01b9;
            case 17: goto L_0x01b6;
            case 18: goto L_0x01b3;
            case 19: goto L_0x01b0;
            case 20: goto L_0x01ad;
            case 21: goto L_0x01aa;
            case 22: goto L_0x01a7;
            case 23: goto L_0x01a4;
            case 24: goto L_0x01a1;
            case 25: goto L_0x019e;
            default: goto L_0x019c;
        };
    L_0x019c:
        goto L_0x01eb;
    L_0x019e:
        r10 = "helpview_header_social_security_card";
        goto L_0x01eb;
    L_0x01a1:
        r10 = "helpview_header_phone_bill";
        goto L_0x01eb;
    L_0x01a4:
        r10 = "helpview_header_school_enrolment_letter";
        goto L_0x01eb;
    L_0x01a7:
        r10 = "helpview_header_trade_association_card";
        goto L_0x01eb;
    L_0x01aa:
        r10 = "helpview_header_superannuation_statement";
        goto L_0x01eb;
    L_0x01ad:
        r10 = "helpview_header_working_with_children_check";
        goto L_0x01eb;
    L_0x01b0:
        r10 = "helpview_header_us_social_security_card";
        goto L_0x01eb;
    L_0x01b3:
        r10 = "helpview_header_birth_certificate";
        goto L_0x01eb;
    L_0x01b6:
        r10 = "helpview_header_medicare_card";
        goto L_0x01eb;
    L_0x01b9:
        r10 = "helpview_header_seniors_card";
        goto L_0x01eb;
    L_0x01bc:
        r10 = "helpview_header_council_bill";
        goto L_0x01eb;
    L_0x01bf:
        r10 = "helpview_header_health_care_card";
        goto L_0x01eb;
    L_0x01c2:
        r10 = "helpview_header_student_card";
        goto L_0x01eb;
    L_0x01c5:
        r10 = "helpview_header_voided_check";
        goto L_0x01eb;
    L_0x01c8:
        r10 = "helpview_header_vehicle_title";
        goto L_0x01eb;
    L_0x01cb:
        r10 = "helpview_header_tax_return";
        goto L_0x01eb;
    L_0x01ce:
        r10 = "helpview_header_mortgage_application";
        goto L_0x01eb;
    L_0x01d1:
        r10 = "helpview_header_loan_application";
        goto L_0x01eb;
    L_0x01d4:
        r10 = "helpview_header_lease_agreement";
        goto L_0x01eb;
    L_0x01d7:
        r10 = "helpview_header_credit_card_statement";
        goto L_0x01eb;
    L_0x01da:
        r10 = "helpview_header_corporate_resolution_certificate";
        goto L_0x01eb;
    L_0x01dd:
        r10 = "helpview_header_cash_advance_application";
        goto L_0x01eb;
    L_0x01e0:
        r10 = "helpview_header_utility_bill";
        goto L_0x01eb;
    L_0x01e3:
        r10 = "helpview_header_insurance_card";
        goto L_0x01eb;
    L_0x01e6:
        r10 = "helpview_header_credit_card";
        goto L_0x01eb;
    L_0x01e9:
        r10 = "helpview_header_bank_statement";
    L_0x01eb:
        r9 = r8.getContext();
        r11 = com.jumio.core.data.Strings.getExternalString(r9, r10);
    L_0x01f3:
        r9 = r8.getContext();
        r10 = "helpview_small_title_capture";
        r9 = com.jumio.core.data.Strings.getExternalString(r9, r10);
        r10 = new java.lang.Object[r6];
        r10[r5] = r11;
        r9 = java.lang.String.format(r9, r10);
        r10 = android.text.Html.fromHtml(r9);
        r3.setText(r10);
        r9 = android.text.Html.fromHtml(r9);
        r0.setContentDescription(r9);
        r9 = r8.rotationManager;
        r9 = r9.isScreenPortrait();
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r9 != 0) goto L_0x0232;
    L_0x021d:
        r9 = r8.rotationManager;
        r9 = r9.isTablet();
        if (r9 == 0) goto L_0x0226;
    L_0x0225:
        goto L_0x0232;
    L_0x0226:
        r9 = r8.overlayView;
        r11 = 0;
        r9.setTranslationY(r11);
        r9 = r8.overlayView;
        r9.setAlpha(r10);
        goto L_0x0240;
    L_0x0232:
        r9 = r8.overlayView;
        r11 = r8.e;
        r11 = -r11;
        r11 = (float) r11;
        r9.setTranslationY(r11);
        r9 = r8.overlayView;
        r9.setAlpha(r10);
    L_0x0240:
        if (r12 != 0) goto L_0x0251;
    L_0x0242:
        r9 = r8.mFragmentRootView;
        r9 = r9.getViewTreeObserver();
        r10 = new com.jumio.dv.view.fragment.DvScanFragment$4;
        r10.<init>();
        r9.addOnGlobalLayoutListener(r10);
        goto L_0x0268;
    L_0x0251:
        r9 = r8.a;
        r11 = r8.mFragmentRootView;
        r11 = r11.getHeight();
        r12 = r8.e;
        r11 = r11 - r12;
        r11 = (float) r11;
        r9.setTranslationY(r11);
        r0.setAlpha(r10);
        r9 = r8.a;
        r9.setVisibility(r5);
    L_0x0268:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.dv.view.fragment.DvScanFragment.showHelp(java.lang.String, com.jumio.dv.view.interactors.DvScanView$HelpViewStyle, java.lang.String, boolean):void");
    }

    public void hideHelp() {
        if (this.a != null) {
            this.a.setOnTouchListener(null);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{(float) (this.mFragmentRootView.getHeight() - this.e), (float) this.mFragmentRootView.getHeight()});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
        }
    }

    public void onError(Throwable th) {
        if (th instanceof JumioException) {
            JumioException jumioException = (JumioException) th;
            if (!jumioException.getErrorCase().retry()) {
                JumioError.getAlertDialogBuilder(getContext(), jumioException, null, new a(jumioException));
            }
        }
    }

    private void b() {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator ofFloat = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{(float) this.mFragmentRootView.getHeight(), (float) (this.mFragmentRootView.getHeight() - this.e)});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                DvScanFragment.this.handleControls(((b) DvScanFragment.this.getPresenter()).control(BaseScanControl.hasMultipleCameras), ((b) DvScanFragment.this.getPresenter()).control(BaseScanControl.hasFlash));
            }
        });
        animatorSet.play(ofFloat);
        animatorSet.start();
    }
}
