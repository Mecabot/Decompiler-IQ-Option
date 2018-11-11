package com.jumio.nv.view.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.ScaleableImageView;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.core.plugins.Plugin;
import com.jumio.core.plugins.PluginRegistry;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.gui.DrawView;
import com.jumio.nv.R;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.liveness.overlay.LivenessOverlay;
import com.jumio.nv.view.interactors.NVScanView;
import com.jumio.nv.view.interactors.NVScanView.GuiState;
import com.jumio.nv.view.interactors.NVScanView.HelpViewStyle;
import com.jumio.sdk.exception.JumioError;
import com.jumio.sdk.exception.JumioError.ErrorInterface;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.gui.MaterialProgressBar;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.presentation.BaseScanPresenter.BaseScanControl;
import com.jumio.sdk.view.fragment.BaseScanFragment;
import jumio.nv.core.aa;
import jumio.nv.core.x;

@RequiresPresenter(x.class)
public class NVScanFragment extends BaseScanFragment<x, INetverifyFragmentCallback> implements INetverifyActivityCallback, NVScanView {
    @Nullable
    private View a;
    private OnSwipeTouchListener b = null;
    @Nullable
    private View c;
    @Nullable
    private RelativeLayout d;
    @Nullable
    private MaterialProgressBar e;
    private boolean f = true;
    private Bitmap g;
    private int h;
    private LinearLayout i;
    private LinearLayout j;
    private ImageView k;
    private aa l;
    private AnimatorSet m;
    private RelativeLayout n;

    public class OnSwipeTouchListener implements OnTouchListener {
        private GestureDetector b;

        final class a extends SimpleOnGestureListener {
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            private a() {
            }

            /* synthetic */ a(OnSwipeTouchListener onSwipeTouchListener, AnonymousClass1 anonymousClass1) {
                this();
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (((Integer) NVScanFragment.this.a.getTag()).intValue() == 0) {
                    JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.HELP_SELECTED, "ON"));
                    NVScanFragment.this.a(true);
                } else {
                    JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.HELP_SELECTED, "OFF"));
                    NVScanFragment.this.a(false);
                }
                return super.onSingleTapUp(motionEvent);
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                try {
                    float y = motionEvent2.getY() - motionEvent.getY();
                    if (Math.abs(y) > 100.0f && Math.abs(f2) > 100.0f) {
                        if (y > 0.0f) {
                            if (((Integer) NVScanFragment.this.a.getTag()).intValue() == 1) {
                                JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.HELP_SELECTED, "OFF"));
                                NVScanFragment.this.a(false);
                            }
                        } else if (((Integer) NVScanFragment.this.a.getTag()).intValue() == 0) {
                            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.HELP_SELECTED, "ON"));
                            NVScanFragment.this.a(true);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        }

        public OnSwipeTouchListener(Context context) {
            this.b = new GestureDetector(context, new a(this, null));
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.b.onTouchEvent(motionEvent);
        }
    }

    class a implements ErrorInterface {
        private JumioException b;

        public a(JumioException jumioException) {
            this.b = jumioException;
        }

        public String getCaption() {
            return Strings.getExternalString(NVScanFragment.this.getContext(), "button_cancel");
        }

        public void getAction() {
            ((x) NVScanFragment.this.getPresenter()).a(this.b);
        }

        public int getColorID() {
            return R.attr.netverify_dialogNegativeButtonTextColor;
        }
    }

    class b implements ErrorInterface {
        private b() {
        }

        /* synthetic */ b(NVScanFragment nVScanFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public String getCaption() {
            return Strings.getExternalString(NVScanFragment.this.getContext(), "button_retry");
        }

        public void getAction() {
            ((x) NVScanFragment.this.getPresenter()).m();
        }

        public int getColorID() {
            return R.attr.netverify_dialogPositiveButtonTextColor;
        }
    }

    public void faceOnBackside() {
    }

    public void noUsAddressFound() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((INetverifyFragmentCallback) this.callback).registerActivityCallback(this);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            ((x) getPresenter()).a((GuiState) bundle.getSerializable("guiState"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        int i = (this.rotationManager.isScreenPortrait() || this.rotationManager.isTablet()) ? R.layout.nv_confirmationview_portrait : R.layout.nv_confirmationview_landscape;
        this.c = layoutInflater.inflate(i, this.mFragmentRootView, false);
        this.c.setVisibility(4);
        this.mFragmentRootView.addView(this.c);
        i = (this.rotationManager.isScreenPortrait() || this.rotationManager.isTablet()) ? R.layout.nv_newhelpview_portrait : R.layout.nv_newhelpview_land;
        this.a = layoutInflater.inflate(i, null, false);
        this.a.setVisibility(4);
        this.mFragmentRootView.addView(this.a);
        this.l = new aa(getContext());
        this.overlayView.setAlpha(0.0f);
        return onCreateView;
    }

    public void onResume() {
        super.onResume();
        ((INetverifyFragmentCallback) this.callback).animateActionbar(true, false);
        a(Strings.getExternalString(getActivity(), ScanSide.FACE.equals(((x) getPresenter()).d()) ? NVStrings.SCANVIEW_TITLE_FACE : "scanview_title"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("guiState", ((x) getPresenter()).k());
    }

    protected void handleControls(boolean z, boolean z2) {
        if (this.f) {
            super.handleControls(z, z2);
        }
    }

    public CredentialsModel getCredentialsModel() {
        return ((INetverifyFragmentCallback) this.callback).getCredentials();
    }

    public NfcController getNfcController() {
        return ((INetverifyFragmentCallback) this.callback).getNfcController();
    }

    public void showNFC(Bundle bundle) {
        Plugin plugin = PluginRegistry.getPlugin(PluginMode.NFC);
        ((INetverifyFragmentCallback) this.callback).setUiAutomationId(R.string.netverify_automation_scan_nfc);
        ((INetverifyFragmentCallback) this.callback).startFragment((Fragment) plugin.getOverlay(getContext(), bundle), true, 0, R.animator.nv_fade_out);
    }

    /* JADX WARNING: Missing block: B:30:0x0106, code:
            r14 = null;
     */
    /* JADX WARNING: Missing block: B:39:0x0157, code:
            r14 = r12;
            r12 = null;
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:50:0x01ee, code:
            if (r12 != null) goto L_0x0207;
     */
    /* JADX WARNING: Missing block: B:51:0x01f0, code:
            r12 = getContext();
     */
    /* JADX WARNING: Missing block: B:52:0x01fc, code:
            if (r1.side.equals(com.jumio.core.data.document.ScanSide.FRONT) == false) goto L_0x0201;
     */
    /* JADX WARNING: Missing block: B:53:0x01fe, code:
            r8 = com.jumio.nv.data.NVStrings.FRONT;
     */
    /* JADX WARNING: Missing block: B:54:0x0201, code:
            r8 = com.jumio.nv.data.NVStrings.BACK;
     */
    /* JADX WARNING: Missing block: B:55:0x0203, code:
            r12 = com.jumio.core.data.Strings.getExternalString(r12, r8);
     */
    /* JADX WARNING: Missing block: B:56:0x0207, code:
            if (r13 != null) goto L_0x021d;
     */
    /* JADX WARNING: Missing block: B:57:0x0209, code:
            r13 = java.lang.String.format(com.jumio.core.data.Strings.getExternalString(getContext(), com.jumio.nv.data.NVStrings.HELPVIEW_SMALL_TITLE_SCAN), new java.lang.Object[]{r4, r12});
     */
    /* JADX WARNING: Missing block: B:58:0x021d, code:
            r4 = com.jumio.core.data.Strings.getExternalString(getContext(), r6);
            r6 = com.jumio.core.data.Strings.getExternalString(getContext(), r14);
            r8 = "";
     */
    /* JADX WARNING: Missing block: B:59:0x0231, code:
            if (r1.totalParts <= 1) goto L_0x0253;
     */
    /* JADX WARNING: Missing block: B:60:0x0233, code:
            r8 = java.lang.String.format(com.jumio.core.data.Strings.getExternalString(getContext(), com.jumio.nv.data.NVStrings.HELPVIEW_PROGRESS_TEXT), new java.lang.Object[]{java.lang.Integer.valueOf(r1.part), java.lang.Integer.valueOf(r1.totalParts)});
     */
    /* JADX WARNING: Missing block: B:61:0x0253, code:
            r3 = new java.lang.StringBuilder(android.text.Html.fromHtml(r13));
            r2.setText(android.text.Html.fromHtml(r13));
     */
    /* JADX WARNING: Missing block: B:62:0x0267, code:
            if (android.text.TextUtils.isEmpty(r8) != false) goto L_0x0270;
     */
    /* JADX WARNING: Missing block: B:63:0x0269, code:
            r5.setText(r8);
            r3.append(r8);
     */
    /* JADX WARNING: Missing block: B:64:0x0270, code:
            r5.setVisibility(8);
     */
    /* JADX WARNING: Missing block: B:65:0x0275, code:
            if (r4 == null) goto L_0x027d;
     */
    /* JADX WARNING: Missing block: B:66:0x0277, code:
            r10.setText(r4);
            r3.append(r4);
     */
    /* JADX WARNING: Missing block: B:67:0x027d, code:
            if (r6 == null) goto L_0x0282;
     */
    /* JADX WARNING: Missing block: B:68:0x027f, code:
            r11.setText(r6);
     */
    /* JADX WARNING: Missing block: B:69:0x0282, code:
            r0.i.setContentDescription(r3.toString());
            r3 = 8;
     */
    public void showHelp(com.jumio.nv.view.interactors.NVScanView.NVHelpConfiguration r18, boolean r19) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r0.a;
        if (r2 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r2 = r17.getContext();
        r3 = r1.side;
        r4 = com.jumio.core.data.document.ScanSide.FACE;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0021;
    L_0x0017:
        r3 = r1.showFullscreen;
        if (r3 == 0) goto L_0x001e;
    L_0x001b:
        r3 = "scanview_title_problems";
        goto L_0x0023;
    L_0x001e:
        r3 = "scanview_title_face";
        goto L_0x0023;
    L_0x0021:
        r3 = "scanview_title";
    L_0x0023:
        r2 = com.jumio.core.data.Strings.getExternalString(r2, r3);
        r0.a(r2);
        r2 = r0.a;
        r3 = 2;
        r2.setImportantForAccessibility(r3);
        r2 = r0.a;
        r4 = 4;
        r2.setVisibility(r4);
        r2 = r0.a;
        r5 = com.jumio.nv.R.id.ic_toggle;
        r2 = r2.findViewById(r5);
        r2 = (android.widget.ImageView) r2;
        r0.k = r2;
        r2 = r0.a;
        r5 = com.jumio.nv.R.id.smallHelpView;
        r2 = r2.findViewById(r5);
        r2 = (android.widget.LinearLayout) r2;
        r0.i = r2;
        r2 = r0.a;
        r5 = com.jumio.nv.R.id.fullHelpView;
        r2 = r2.findViewById(r5);
        r2 = (android.widget.LinearLayout) r2;
        r0.j = r2;
        r2 = r1.scanMode;
        r5 = com.jumio.core.data.document.DocumentScanMode.FACE;
        r7 = 1;
        r8 = 8;
        r9 = 0;
        if (r2 == r5) goto L_0x028f;
    L_0x0064:
        r2 = r0.a;
        r5 = com.jumio.nv.R.id.help_tv_title;
        r2 = r2.findViewById(r5);
        r2 = (android.widget.TextView) r2;
        r5 = r0.a;
        r10 = com.jumio.nv.R.id.help_tv_steps;
        r5 = r5.findViewById(r10);
        r5 = (android.widget.TextView) r5;
        r10 = r0.a;
        r11 = com.jumio.nv.R.id.help_tv_description;
        r10 = r10.findViewById(r11);
        r10 = (android.widget.TextView) r10;
        r11 = r0.a;
        r12 = com.jumio.nv.R.id.help_tv_description_long;
        r11 = r11.findViewById(r12);
        r11 = (android.widget.TextView) r11;
        r12 = r1.helpViewStyle;
        r12 = r0.getHelpViewHeight(r12);
        r0.h = r12;
        r12 = com.jumio.nv.view.fragment.NVScanFragment.AnonymousClass7.a;
        r13 = r1.helpViewStyle;
        r13 = r13.ordinal();
        r12 = r12[r13];
        switch(r12) {
            case 1: goto L_0x00de;
            case 2: goto L_0x00ca;
            case 3: goto L_0x00b6;
            case 4: goto L_0x00a2;
            default: goto L_0x00a1;
        };
    L_0x00a1:
        goto L_0x00ec;
    L_0x00a2:
        r12 = r0.k;
        r13 = r1.isExpandable;
        if (r13 == 0) goto L_0x00a9;
    L_0x00a8:
        r4 = 0;
    L_0x00a9:
        r12.setVisibility(r4);
        r2.setVisibility(r9);
        r5.setVisibility(r9);
        r10.setVisibility(r9);
        goto L_0x00ec;
    L_0x00b6:
        r12 = r0.k;
        r13 = r1.isExpandable;
        if (r13 == 0) goto L_0x00bd;
    L_0x00bc:
        r4 = 0;
    L_0x00bd:
        r12.setVisibility(r4);
        r2.setVisibility(r9);
        r5.setVisibility(r9);
        r10.setVisibility(r8);
        goto L_0x00ec;
    L_0x00ca:
        r12 = r0.k;
        r13 = r1.isExpandable;
        if (r13 == 0) goto L_0x00d1;
    L_0x00d0:
        r4 = 0;
    L_0x00d1:
        r12.setVisibility(r4);
        r2.setVisibility(r8);
        r5.setVisibility(r8);
        r10.setVisibility(r8);
        goto L_0x00ec;
    L_0x00de:
        r4 = r0.k;
        r4.setVisibility(r8);
        r2.setVisibility(r8);
        r5.setVisibility(r8);
        r10.setVisibility(r8);
    L_0x00ec:
        r4 = r1.documentType;
        r12 = r17.getContext();
        r4 = r4.getLocalizedName(r12);
        r12 = com.jumio.nv.view.fragment.NVScanFragment.AnonymousClass7.b;
        r13 = r1.scanMode;
        r13 = r13.ordinal();
        r12 = r12[r13];
        switch(r12) {
            case 1: goto L_0x015c;
            case 2: goto L_0x015c;
            case 3: goto L_0x015c;
            case 4: goto L_0x015c;
            case 5: goto L_0x015c;
            case 6: goto L_0x015c;
            case 7: goto L_0x015c;
            case 8: goto L_0x0153;
            case 9: goto L_0x014e;
            case 10: goto L_0x0136;
            case 11: goto L_0x0109;
            default: goto L_0x0103;
        };
    L_0x0103:
        r6 = 0;
        r12 = 0;
        r13 = 0;
    L_0x0106:
        r14 = 0;
        goto L_0x01ee;
    L_0x0109:
        r12 = r17.getContext();
        r13 = r1.side;
        r14 = com.jumio.core.data.document.ScanSide.FRONT;
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x011a;
    L_0x0117:
        r13 = "inside";
        goto L_0x011c;
    L_0x011a:
        r13 = "outside";
    L_0x011c:
        r12 = com.jumio.core.data.Strings.getExternalString(r12, r13);
        r13 = r17.getContext();
        r14 = "helpview_small_title_capture";
        r13 = com.jumio.core.data.Strings.getExternalString(r13, r14);
        r14 = new java.lang.Object[r3];
        r14[r9] = r4;
        r14[r7] = r12;
        r13 = java.lang.String.format(r13, r14);
        r6 = 0;
        goto L_0x0106;
    L_0x0136:
        r12 = "";
        r13 = "";
        r14 = "";
        r15 = r0.callback;
        r15 = (com.jumio.nv.view.fragment.INetverifyFragmentCallback) r15;
        r6 = com.jumio.nv.R.string.netverify_automation_help_face;
        r15.setUiAutomationId(r6);
        r6 = r12;
        r12 = 0;
        r16 = r14;
        r14 = r13;
        r13 = r16;
        goto L_0x01ee;
    L_0x014e:
        r6 = "helpview_small_description_barcode";
        r12 = "helpview_full_description_barcode";
        goto L_0x0157;
    L_0x0153:
        r6 = "helpview_small_description_template";
        r12 = "helpview_full_description_template";
    L_0x0157:
        r14 = r12;
        r12 = 0;
        r13 = 0;
        goto L_0x01ee;
    L_0x015c:
        r6 = r1.isUSDLFallback;
        if (r6 == 0) goto L_0x019c;
    L_0x0160:
        r6 = new com.jumio.analytics.MetaInfo;
        r6.<init>();
        r12 = com.jumio.nv.enums.NVErrorCase.ADDRESS_MISSING;
        r13 = "detailedErrorCode";
        r14 = java.lang.Integer.valueOf(r9);
        r6.put(r13, r14);
        r13 = "errorCode";
        r14 = r12.code();
        r14 = java.lang.Integer.valueOf(r14);
        r6.put(r13, r14);
        r13 = "retryPossible";
        r12 = r12.retry();
        r12 = java.lang.Boolean.valueOf(r12);
        r6.put(r13, r12);
        r12 = com.jumio.analytics.JumioAnalytics.getSessionId();
        r13 = com.jumio.analytics.Screen.ERROR;
        r6 = com.jumio.analytics.MobileEvents.pageView(r12, r13, r6);
        com.jumio.analytics.JumioAnalytics.add(r6);
        r6 = "helpview_small_description";
        r12 = "helpview_description_usdl_fallback";
        goto L_0x0157;
    L_0x019c:
        r6 = r1.initialScanMode;
        r12 = com.jumio.core.data.document.DocumentScanMode.CNIS;
        if (r6 != r12) goto L_0x01a7;
    L_0x01a2:
        r6 = "helpview_small_description_card";
        r12 = "helpview_full_description_card";
        goto L_0x0157;
    L_0x01a7:
        r6 = r1.isIdBackFaceDetected;
        if (r6 == 0) goto L_0x01e8;
    L_0x01ab:
        r6 = new com.jumio.analytics.MetaInfo;
        r6.<init>();
        r12 = com.jumio.nv.enums.NVErrorCase.NO_FACE_ON_BACK;
        r13 = "detailedErrorCode";
        r14 = java.lang.Integer.valueOf(r9);
        r6.put(r13, r14);
        r13 = "errorCode";
        r14 = r12.code();
        r14 = java.lang.Integer.valueOf(r14);
        r6.put(r13, r14);
        r13 = "retryPossible";
        r12 = r12.retry();
        r12 = java.lang.Boolean.valueOf(r12);
        r6.put(r13, r12);
        r12 = com.jumio.analytics.JumioAnalytics.getSessionId();
        r13 = com.jumio.analytics.Screen.ERROR;
        r6 = com.jumio.analytics.MobileEvents.pageView(r12, r13, r6);
        com.jumio.analytics.JumioAnalytics.add(r6);
        r6 = "helpview_small_description";
        r12 = "helpview_description_face_on_back";
        goto L_0x0157;
    L_0x01e8:
        r6 = "helpview_small_description";
        r12 = "helpview_full_description";
        goto L_0x0157;
    L_0x01ee:
        if (r12 != 0) goto L_0x0207;
    L_0x01f0:
        r12 = r17.getContext();
        r15 = r1.side;
        r8 = com.jumio.core.data.document.ScanSide.FRONT;
        r8 = r15.equals(r8);
        if (r8 == 0) goto L_0x0201;
    L_0x01fe:
        r8 = "front";
        goto L_0x0203;
    L_0x0201:
        r8 = "back";
    L_0x0203:
        r12 = com.jumio.core.data.Strings.getExternalString(r12, r8);
    L_0x0207:
        if (r13 != 0) goto L_0x021d;
    L_0x0209:
        r8 = r17.getContext();
        r13 = "helpview_small_title_scan";
        r8 = com.jumio.core.data.Strings.getExternalString(r8, r13);
        r13 = new java.lang.Object[r3];
        r13[r9] = r4;
        r13[r7] = r12;
        r13 = java.lang.String.format(r8, r13);
    L_0x021d:
        r4 = r17.getContext();
        r4 = com.jumio.core.data.Strings.getExternalString(r4, r6);
        r6 = r17.getContext();
        r6 = com.jumio.core.data.Strings.getExternalString(r6, r14);
        r8 = "";
        r12 = r1.totalParts;
        if (r12 <= r7) goto L_0x0253;
    L_0x0233:
        r8 = r17.getContext();
        r12 = "helpview_progress_text";
        r8 = com.jumio.core.data.Strings.getExternalString(r8, r12);
        r3 = new java.lang.Object[r3];
        r12 = r1.part;
        r12 = java.lang.Integer.valueOf(r12);
        r3[r9] = r12;
        r12 = r1.totalParts;
        r12 = java.lang.Integer.valueOf(r12);
        r3[r7] = r12;
        r8 = java.lang.String.format(r8, r3);
    L_0x0253:
        r3 = new java.lang.StringBuilder;
        r12 = android.text.Html.fromHtml(r13);
        r3.<init>(r12);
        r12 = android.text.Html.fromHtml(r13);
        r2.setText(r12);
        r2 = android.text.TextUtils.isEmpty(r8);
        if (r2 != 0) goto L_0x0270;
    L_0x0269:
        r5.setText(r8);
        r3.append(r8);
        goto L_0x0275;
    L_0x0270:
        r2 = 8;
        r5.setVisibility(r2);
    L_0x0275:
        if (r4 == 0) goto L_0x027d;
    L_0x0277:
        r10.setText(r4);
        r3.append(r4);
    L_0x027d:
        if (r6 == 0) goto L_0x0282;
    L_0x027f:
        r11.setText(r6);
    L_0x0282:
        r2 = r0.i;
        r3 = r3.toString();
        r2.setContentDescription(r3);
        r3 = 8;
        goto L_0x034f;
    L_0x028f:
        r2 = r0.k;
        r3 = 8;
        r2.setVisibility(r3);
        r2 = r17.getContext();
        r5 = android.view.LayoutInflater.from(r2);
        r6 = r0.j;
        r6.removeAllViews();
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r8 = r1.isPortrait;
        if (r8 == 0) goto L_0x0304;
    L_0x02ac:
        r4 = com.jumio.nv.R.layout.nv_livenesshelp;
        r8 = r0.j;
        r5.inflate(r4, r8, r7);
        r4 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_liveness_glasses_text;
        r4 = r4.findViewById(r5);
        r4 = (android.widget.TextView) r4;
        r5 = "helpview_full_description_liveness_glasses";
        r5 = com.jumio.core.data.Strings.getExternalString(r2, r5);
        r4.setText(r5);
        r4 = r4.getText();
        r6.append(r4);
        r4 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_liveness_cap_text;
        r4 = r4.findViewById(r5);
        r4 = (android.widget.TextView) r4;
        r5 = "helpview_full_description_liveness_cap";
        r5 = com.jumio.core.data.Strings.getExternalString(r2, r5);
        r4.setText(r5);
        r4 = r4.getText();
        r6.append(r4);
        r4 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_liveness_light_text;
        r4 = r4.findViewById(r5);
        r4 = (android.widget.TextView) r4;
        r5 = "helpview_full_description_liveness_light";
        r2 = com.jumio.core.data.Strings.getExternalString(r2, r5);
        r4.setText(r2);
        r2 = r4.getText();
        r6.append(r2);
        r1.showFallback = r7;
        goto L_0x034b;
    L_0x0304:
        r2 = r0.j;
        r5 = r17.getContext();
        r5 = com.jumio.nv.liveness.overlay.LivenessOverlay.getRotationLayout(r5);
        r2.addView(r5);
        r2 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_doctype_title;
        r2 = r2.findViewById(r5);
        r2 = (android.widget.TextView) r2;
        r2 = r2.getText();
        r6.append(r2);
        r2 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_scan_instructions;
        r2 = r2.findViewById(r5);
        r2 = (android.widget.TextView) r2;
        r2 = r2.getText();
        r6.append(r2);
        r2 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_progress_info;
        r2 = r2.findViewById(r5);
        r2.setVisibility(r4);
        r2 = r0.j;
        r5 = com.jumio.nv.R.id.helpview_fallback_button;
        r2 = r2.findViewById(r5);
        r2.setVisibility(r4);
        r1.showFallback = r9;
    L_0x034b:
        r6 = r6.toString();
    L_0x034f:
        r2 = r0.j;
        r2.setContentDescription(r6);
        r2 = r0.a;
        r4 = com.jumio.nv.R.id.helpview_fallback_button;
        r2 = r2.findViewById(r4);
        r2 = (android.widget.Button) r2;
        if (r2 == 0) goto L_0x03bc;
    L_0x0360:
        r4 = r1.scanMode;
        r5 = com.jumio.core.data.document.DocumentScanMode.PDF417;
        if (r4 != r5) goto L_0x0374;
    L_0x0366:
        r4 = r17.getContext();
        r5 = "helpview_fallback_barcode";
        r4 = com.jumio.core.data.Strings.getExternalString(r4, r5);
        r2.setText(r4);
        goto L_0x03ac;
    L_0x0374:
        r4 = r1.scanMode;
        r5 = com.jumio.core.data.document.DocumentScanMode.FACE;
        if (r4 != r5) goto L_0x0388;
    L_0x037a:
        r4 = r17.getContext();
        r5 = "helpview_liveness_continue";
        r4 = com.jumio.core.data.Strings.getExternalString(r4, r5);
        r2.setText(r4);
        goto L_0x03ac;
    L_0x0388:
        r4 = r1.isUSDLFallback;
        if (r4 != 0) goto L_0x039f;
    L_0x038c:
        r4 = r1.isIdBackFaceDetected;
        if (r4 == 0) goto L_0x0391;
    L_0x0390:
        goto L_0x039f;
    L_0x0391:
        r4 = r17.getContext();
        r5 = "helpview_fallback";
        r4 = com.jumio.core.data.Strings.getExternalString(r4, r5);
        r2.setText(r4);
        goto L_0x03ac;
    L_0x039f:
        r4 = r17.getContext();
        r5 = "helpview_usdl_fallback_continue";
        r4 = com.jumio.core.data.Strings.getExternalString(r4, r5);
        r2.setText(r4);
    L_0x03ac:
        r4 = r1.showFallback;
        if (r4 == 0) goto L_0x03b1;
    L_0x03b0:
        r3 = 0;
    L_0x03b1:
        r2.setVisibility(r3);
        r3 = new com.jumio.nv.view.fragment.NVScanFragment$1;
        r3.<init>(r1);
        r2.setOnClickListener(r3);
    L_0x03bc:
        r2 = r1.isExpandable;
        if (r2 == 0) goto L_0x03d3;
    L_0x03c0:
        r2 = new com.jumio.nv.view.fragment.NVScanFragment$OnSwipeTouchListener;
        r3 = r17.getContext();
        r2.<init>(r3);
        r0.b = r2;
        r2 = r0.a;
        r3 = r0.b;
        r2.setOnTouchListener(r3);
        goto L_0x03d6;
    L_0x03d3:
        r2 = 0;
        r0.b = r2;
    L_0x03d6:
        if (r19 != 0) goto L_0x03f0;
    L_0x03d8:
        r2 = r0.a;
        r3 = java.lang.Integer.valueOf(r9);
        r2.setTag(r3);
        r2 = r0.mFragmentRootView;
        r2 = r2.getViewTreeObserver();
        r3 = new com.jumio.nv.view.fragment.NVScanFragment$2;
        r3.<init>(r1);
        r2.addOnGlobalLayoutListener(r3);
        goto L_0x0460;
    L_0x03f0:
        r2 = r0.l;
        r3 = r0.a;
        r4 = r0.rotationManager;
        r4 = r4.isScreenPortrait();
        if (r4 != 0) goto L_0x0406;
    L_0x03fc:
        r4 = r0.rotationManager;
        r4 = r4.isTablet();
        if (r4 == 0) goto L_0x0405;
    L_0x0404:
        goto L_0x0406;
    L_0x0405:
        r7 = 0;
    L_0x0406:
        r2.a(r3, r1, r7);
        r1 = r0.a;
        r1 = r1.getTag();
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r2 = 0;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r1 != 0) goto L_0x0440;
    L_0x041a:
        r1 = r0.a;
        r4 = r0.mFragmentRootView;
        r4 = r4.getHeight();
        r5 = r0.h;
        r4 = r4 - r5;
        r4 = (float) r4;
        r1.setTranslationY(r4);
        r1 = r0.i;
        r1.setAlpha(r3);
        r1 = r0.j;
        r1.setAlpha(r2);
        r1 = r0.overlayView;
        r1.setAlpha(r3);
        r1 = r0.k;
        r2 = com.jumio.nv.R.drawable.nv_slide_up;
        r1.setImageResource(r2);
        goto L_0x045b;
    L_0x0440:
        r1 = r0.l;
        r1.a();
        r1 = r0.a;
        r1.setTranslationY(r2);
        r1 = r0.i;
        r1.setAlpha(r2);
        r1 = r0.j;
        r1.setAlpha(r3);
        r1 = r0.k;
        r2 = com.jumio.nv.R.drawable.nv_slide_down;
        r1.setImageResource(r2);
    L_0x045b:
        r1 = r0.a;
        r1.setVisibility(r9);
    L_0x0460:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.view.fragment.NVScanFragment.showHelp(com.jumio.nv.view.interactors.NVScanView$NVHelpConfiguration, boolean):void");
    }

    private void a(final boolean z) {
        LinearLayout linearLayout;
        String str;
        float[] fArr;
        this.a.setOnTouchListener(null);
        if (this.m != null && this.m.isRunning()) {
            this.m.cancel();
            this.m.setupEndValues();
        }
        this.m = new AnimatorSet();
        this.m.setDuration(500);
        this.m.setInterpolator(new AccelerateDecelerateInterpolator());
        this.m.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                NVScanFragment.this.a.setTag(Integer.valueOf(z));
                if (z) {
                    NVScanFragment.this.handleControls(false, false);
                    NVScanFragment.this.f = false;
                    ((x) NVScanFragment.this.getPresenter()).a(z);
                    NVScanFragment.this.l.a();
                    return;
                }
                NVScanFragment.this.l.b();
                ((x) NVScanFragment.this.getPresenter()).l();
            }

            public void onAnimationEnd(Animator animator) {
                NVScanFragment.this.k.setImageResource(z ? R.drawable.nv_slide_down : R.drawable.nv_slide_up);
                if (!z) {
                    ((x) NVScanFragment.this.getPresenter()).a(z);
                    NVScanFragment.this.f = true;
                    NVScanFragment.this.handleControls(((x) NVScanFragment.this.getPresenter()).control(BaseScanControl.hasMultipleCameras), ((x) NVScanFragment.this.getPresenter()).control(BaseScanControl.hasFlash));
                }
                NVScanFragment.this.a.setOnTouchListener(NVScanFragment.this.b);
            }
        });
        View view = this.a;
        String str2 = "translationY";
        float[] fArr2 = new float[2];
        fArr2[0] = this.a.getTranslationY();
        fArr2[1] = z ? 0.0f : (float) (this.mFragmentRootView.getHeight() - this.h);
        Builder play = this.m.play(ObjectAnimator.ofFloat(view, str2, fArr2));
        float f = 1.0f;
        if ((z && this.i.getAlpha() == 1.0f) || (!z && this.i.getAlpha() == 0.0f)) {
            linearLayout = this.i;
            str = "alpha";
            fArr = new float[2];
            fArr[0] = z ? 1.0f : 0.0f;
            fArr[1] = z ? 0.0f : 1.0f;
            play.with(ObjectAnimator.ofFloat(linearLayout, str, fArr));
        }
        if ((z && this.j.getAlpha() == 0.0f) || (!z && this.j.getAlpha() == 1.0f)) {
            linearLayout = this.j;
            str = "alpha";
            fArr = new float[2];
            fArr[0] = z ? 0.0f : 1.0f;
            fArr[1] = z ? 1.0f : 0.0f;
            play.with(ObjectAnimator.ofFloat(linearLayout, str, fArr));
        }
        if ((z && this.overlayView.getAlpha() == 1.0f) || (!z && this.overlayView.getAlpha() == 0.0f)) {
            DrawView drawView = this.overlayView;
            str = "alpha";
            float[] fArr3 = new float[2];
            fArr3[0] = z ? 1.0f : 0.0f;
            if (z) {
                f = 0.0f;
            }
            fArr3[1] = f;
            play.with(ObjectAnimator.ofFloat(drawView, str, fArr3));
        }
        this.m.start();
    }

    public void showConfirmation(String str, boolean z) {
        handleControls(false, false);
        this.f = false;
        a(Strings.getExternalString(getContext(), "scanview_title_check"));
        ((INetverifyFragmentCallback) this.callback).setUiAutomationId(R.string.netverify_automation_confirmation);
        if (this.c != null) {
            Animator ofFloat;
            View findViewById = this.c.findViewById(R.id.confirmation_layout_base);
            ScaleableImageView scaleableImageView = (ScaleableImageView) this.c.findViewById(R.id.confirmationImage);
            TextView textView = (TextView) this.c.findViewById(R.id.confirmationSnackBar);
            final TextView textView2 = (TextView) this.c.findViewById(R.id.confirmationPositiveTextView);
            final TextView textView3 = (TextView) this.c.findViewById(R.id.confirmationNegativeTextView);
            if (this.g != null) {
                this.g.recycle();
                this.g = null;
                System.gc();
            }
            this.g = BitmapFactory.decodeFile(str);
            scaleableImageView.setImageBitmap(this.g);
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
                    ((x) NVScanFragment.this.getPresenter()).f();
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
                    NVScanFragment.this.f = true;
                    NVScanFragment.this.handleControls(((x) NVScanFragment.this.getPresenter()).control(BaseScanControl.hasMultipleCameras), ((x) NVScanFragment.this.getPresenter()).control(BaseScanControl.hasFlash));
                    if (NVScanFragment.this.c != null) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        Animator ofFloat = ObjectAnimator.ofFloat(scaleableImageView2, "alpha", new float[]{1.0f, 0.0f});
                        ofFloat.setDuration(400);
                        ofFloat.setStartDelay(100);
                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                        Builder play = animatorSet.play(ofFloat);
                        View findViewById = NVScanFragment.this.c.findViewById(R.id.buttonLayout);
                        Animator ofFloat2;
                        if (NVScanFragment.this.rotationManager.isScreenPortrait() || NVScanFragment.this.rotationManager.isTablet()) {
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
                                ((x) NVScanFragment.this.getPresenter()).a();
                            }

                            public void onAnimationEnd(Animator animator) {
                                NVScanFragment.this.c.setVisibility(4);
                                ((x) NVScanFragment.this.getPresenter()).h();
                                if (NVScanFragment.this.g != null) {
                                    NVScanFragment.this.g.recycle();
                                    NVScanFragment.this.g = null;
                                    System.gc();
                                }
                            }
                        });
                        animatorSet.start();
                    }
                    NVScanFragment.this.a(Strings.getExternalString(NVScanFragment.this.getContext(), "scanview_title"));
                }
            });
            scaleableImageView.setAlpha(0.0f);
            View findViewById2 = this.c.findViewById(R.id.buttonLayout);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator ofFloat2 = ObjectAnimator.ofFloat(scaleableImageView, "alpha", new float[]{0.0f, 1.0f});
            ofFloat2.setDuration(300);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            Builder play = animatorSet.play(ofFloat2);
            if (this.rotationManager.isScreenPortrait() || this.rotationManager.isTablet()) {
                textView.setTranslationY((float) (findViewById2.getHeight() + textView.getHeight()));
                Animator ofFloat3 = ObjectAnimator.ofFloat(textView, "translationY", new float[]{(float) (findViewById2.getHeight() + textView.getHeight()), 0.0f});
                ofFloat3.setStartDelay(100);
                ofFloat3.setDuration(400);
                ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
                findViewById2.setTranslationY((float) (findViewById2.getHeight() + textView.getHeight()));
                ofFloat = ObjectAnimator.ofFloat(findViewById2, "translationY", new float[]{(float) (findViewById2.getHeight() + textView.getHeight()), 0.0f});
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
            this.c.setVisibility(0);
            animatorSet.start();
            if (!z) {
                JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.CONFIRMATION, null));
            }
        }
    }

    public void showLoading() {
        if (this.d != null) {
            this.mFragmentRootView.removeView(this.d);
            this.d = null;
            this.e = null;
        }
        TypedValue typedValue = new TypedValue();
        int dpToPx = ScreenUtil.dpToPx(getContext(), 45);
        getContext().getTheme().resolveAttribute(R.attr.netverify_fastfillLoadingBackground, typedValue, true);
        this.d = new RelativeLayout(this.mFragmentRootView.getContext());
        this.d.setLayoutParams(new LayoutParams(-1, -1));
        this.d.setPadding(dpToPx, 0, dpToPx, 0);
        this.d.setBackgroundColor(typedValue.data);
        dpToPx = ScreenUtil.dpToPx(getContext(), 190);
        int dpToPx2 = ScreenUtil.dpToPx(getContext(), 6);
        getContext().getTheme().resolveAttribute(R.attr.netverify_fastfillLoadingProgress, typedValue, true);
        this.e = new MaterialProgressBar(this.mFragmentRootView.getContext());
        this.e.setLayoutParams(new LayoutParams(dpToPx, dpToPx));
        this.e.setCircleBackgroundEnabled(false);
        this.e.setColorSchemeColors(typedValue.data);
        this.e.setProgressStokeWidth(dpToPx2);
        this.d.addView(this.e);
        a();
        this.mFragmentRootView.addView(this.d);
    }

    private void a() {
        if (this.e != null) {
            LayoutParams layoutParams = (LayoutParams) this.e.getLayoutParams();
            if (!this.rotationManager.isScreenLandscape() || this.rotationManager.isTablet()) {
                layoutParams.addRule(14);
                layoutParams.topMargin = ScreenUtil.dpToPx(getContext(), 60);
            } else {
                layoutParams.addRule(13);
                layoutParams.topMargin = 0;
            }
            this.e.setLayoutParams(layoutParams);
        }
    }

    public void extractionStarted() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                NVScanFragment.this.handleControls(false, false);
                NVScanFragment.this.f = false;
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.g != null && !this.g.isRecycled()) {
            this.g.recycle();
            this.g = null;
            System.gc();
        }
    }

    public void scansComplete() {
        ((x) getPresenter()).g();
        ((INetverifyFragmentCallback) this.callback).startFragment(new UploadFragment(), true, 0, R.animator.nv_fade_out);
    }

    public void partComplete() {
        ((x) getPresenter()).j();
        ((INetverifyFragmentCallback) this.callback).startFragment(new NVScanFragment(), true, 0, R.animator.nv_fade_out);
    }

    public void updateUiAutomationScanId(PluginMode pluginMode) {
        StringBuilder stringBuilder = new StringBuilder(getResources().getString(R.string.netverify_automation_scan));
        stringBuilder.append(pluginMode.toString().toLowerCase());
        ((INetverifyFragmentCallback) this.callback).setUiAutomationString(stringBuilder.toString());
    }

    public void showLegalHint(String str) {
        if (str != null) {
            Toast makeText = Toast.makeText(getActivity(), str, 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public boolean displayOverlay(boolean z) {
        if (!ScanSide.FACE.equals(((x) getPresenter()).d())) {
            return true;
        }
        int i = 4;
        if (this.n == null) {
            this.n = LivenessOverlay.getRotationLayout(getContext());
            this.n.setVisibility(4);
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(R.attr.netverify_scanOverlayLivenessBackground, typedValue, true);
            this.n.setBackgroundColor(typedValue.data);
            this.overlayView.addView(this.n);
        }
        RelativeLayout relativeLayout = this.n;
        if (!z) {
            i = 0;
        }
        relativeLayout.setVisibility(i);
        return z;
    }

    public int getHelpViewHeight(HelpViewStyle helpViewStyle) {
        int i = 0;
        if (helpViewStyle == null) {
            return 0;
        }
        switch (helpViewStyle) {
            case MICRO:
                i = (int) getContext().getResources().getDimension(R.dimen.nv_helpview_small_landscape_height);
                break;
            case MINI:
                i = (int) getContext().getResources().getDimension(R.dimen.nv_helpview_small_portrait_manual_height);
                break;
            case SMALL:
                i = (int) getContext().getResources().getDimension(R.dimen.nv_helpview_small_portrait_height);
                break;
        }
        return i;
    }

    public void onLayoutRotated(boolean z) {
        int intValue;
        LayoutInflater from = LayoutInflater.from(getContext());
        if (this.overlayView != null) {
            ((x) getPresenter()).a(jumio.nv.core.x.a.OVERLAY, z);
        }
        if (this.a != null) {
            intValue = this.a.getTag() == null ? 0 : ((Integer) this.a.getTag()).intValue();
            if (intValue == 1) {
                this.l.b();
            }
            this.mFragmentRootView.removeView(this.a);
            this.a = from.inflate(z ? R.layout.nv_newhelpview_portrait : R.layout.nv_newhelpview_land, this.mFragmentRootView, false);
            this.a.setTag(Integer.valueOf(intValue));
            this.mFragmentRootView.addView(this.a);
            ((x) getPresenter()).a(jumio.nv.core.x.a.HELP, z);
        }
        if (this.c != null) {
            intValue = this.c.getVisibility();
            this.mFragmentRootView.removeView(this.c);
            this.c = from.inflate(z ? R.layout.nv_confirmationview_portrait : R.layout.nv_confirmationview_landscape, this.mFragmentRootView, false);
            this.c.setVisibility(intValue);
            this.mFragmentRootView.addView(this.c);
            if (intValue == 0) {
                ((x) getPresenter()).a(jumio.nv.core.x.a.CONFIRMATION, z);
            }
        }
        ((x) getPresenter()).a(jumio.nv.core.x.a.BRANDING, z);
        if (this.d != null) {
            a();
            this.d.bringToFront();
        }
        super.onLayoutRotated(z);
    }

    public void hideHelp() {
        if (this.a != null) {
            if (this.m != null) {
                this.m.cancel();
            }
            this.a.setOnTouchListener(null);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{(float) (this.mFragmentRootView.getHeight() - this.h), (float) this.mFragmentRootView.getHeight()});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
        }
    }

    public void onError(Throwable th) {
        if (th instanceof JumioException) {
            JumioException jumioException = (JumioException) th;
            JumioErrorCase errorCase = jumioException.getErrorCase();
            if (!errorCase.retry() || !((x) getPresenter()).c() || errorCase == NVErrorCase.OCR_LOADING_FAILED || errorCase == NVErrorCase.GOOGLE_VISION_LOADING_FAILED) {
                JumioError.getAlertDialogBuilder(getContext(), jumioException, new b(this, null), new a(jumioException));
            }
        }
    }
}
