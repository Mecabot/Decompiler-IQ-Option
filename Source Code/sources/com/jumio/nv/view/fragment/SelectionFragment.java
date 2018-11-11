package com.jumio.nv.view.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.Strings;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.nv.R;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.view.interactors.SelectionView;
import com.jumio.sdk.exception.JumioError;
import com.jumio.sdk.exception.JumioError.ErrorInterface;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.gui.MaterialProgressBar;
import com.jumio.sdk.models.CredentialsModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jumio.nv.core.y;

@RequiresPresenter(y.class)
public class SelectionFragment extends NVBaseFragment<y> implements INetverifyActivityCallback, SelectionView {
    private ScrollView a;
    private TextView b;
    private LinearLayout c;
    private LinearLayout d;
    private View e;
    private int f;
    protected Toolbar toolbar;
    protected TextView toolbarSubtitle;
    protected LinearLayout toolbarSubtitleContainer;

    class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(SelectionFragment selectionFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onClick(View view) {
            view.setEnabled(false);
            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN_OPTIONS, UserAction.CHOOSE_OTHER_COUNTRY_SELECTED));
            SelectionFragment.this.a();
            view.setEnabled(true);
        }
    }

    static class b {
        DocumentType a;
        NVDocumentVariant b;

        public b(DocumentType documentType, NVDocumentVariant nVDocumentVariant) {
            this.a = documentType;
            this.b = nVDocumentVariant;
        }

        public DocumentType a() {
            return this.a;
        }

        public NVDocumentVariant b() {
            return this.b;
        }
    }

    class c implements OnClickListener {
        private c() {
        }

        /* synthetic */ c(SelectionFragment selectionFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onClick(View view) {
            b bVar = (b) view.getTag();
            ((y) SelectionFragment.this.getPresenter()).a(bVar.a(), bVar.b());
        }
    }

    class d implements ErrorInterface {
        private JumioException b;

        public d(JumioException jumioException) {
            this.b = jumioException;
        }

        public String getCaption() {
            return Strings.getExternalString(SelectionFragment.this.getContext(), "button_cancel");
        }

        public void getAction() {
            ((y) SelectionFragment.this.getPresenter()).a(this.b);
        }

        public int getColorID() {
            return R.attr.netverify_dialogNegativeButtonTextColor;
        }
    }

    class e implements ErrorInterface {
        private e() {
        }

        /* synthetic */ e(SelectionFragment selectionFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public String getCaption() {
            return Strings.getExternalString(SelectionFragment.this.getContext(), "button_retry");
        }

        public void getAction() {
            ((y) SelectionFragment.this.getPresenter()).a();
        }

        public int getColorID() {
            return R.attr.netverify_dialogPositiveButtonTextColor;
        }
    }

    public void handleOrientationChange(boolean z, boolean z2) {
        ((LayoutParams) getActivity().findViewById(R.id.selection_container).getLayoutParams()).topMargin = ScreenUtil.dpToPx(getActivity(), z ? 76 : 16);
        ((LinearLayout.LayoutParams) getActivity().findViewById(R.id.scan_options_document_selection).getLayoutParams()).topMargin = ScreenUtil.dpToPx(getActivity(), z ? 112 : 80);
        if (z) {
            this.toolbar.setTitle((CharSequence) " ");
            setActionbarSubTitle(Strings.getExternalString(getContext(), NVStrings.SCAN_OPTIONS_SUBTITLE_TYPE));
            return;
        }
        this.toolbar.setTitle(Strings.getExternalString(getContext(), NVStrings.SCAN_OPTIONS_SUBTITLE_TYPE));
        setActionbarSubTitle(null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((INetverifyFragmentCallback) this.callback).registerActivityCallback(this);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (ScrollView) layoutInflater.inflate(R.layout.nv_fragment_selection, viewGroup, false);
        TypedValue typedValue = new TypedValue();
        Theme theme = getContext().getTheme();
        ((INetverifyFragmentCallback) this.callback).setUiAutomationId(R.string.netverify_automation_scan_options);
        this.c = (LinearLayout) this.a.findViewById(R.id.scan_options_document_selection);
        this.toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        this.toolbarSubtitle = (TextView) getActivity().findViewById(R.id.toolbar_subtitle);
        this.toolbarSubtitleContainer = (LinearLayout) getActivity().findViewById(R.id.toolbarSubtitleContainer);
        getActivity().findViewById(R.id.toolbarContainer).bringToFront();
        getActivity().findViewById(R.id.toolbarSubtitleContainer).bringToFront();
        if (!(this.toolbarSubtitleContainer == null || this.b == null)) {
            this.toolbarSubtitleContainer.removeView(this.b);
        }
        this.b = (TextView) layoutInflater.inflate(R.layout.nv_fragment_selection_country, null);
        this.b.setText(Html.fromHtml(Strings.getExternalString(getContext(), NVStrings.SCAN_OPTIONS_COUNTRY_SELECTION)));
        this.toolbarSubtitleContainer.addView(this.b);
        this.e = getActivity().findViewById(R.id.loadingBackground);
        this.e.setVisibility(0);
        int dpToPx = ScreenUtil.dpToPx(getContext(), 190);
        int dpToPx2 = ScreenUtil.dpToPx(getContext(), 6);
        theme.resolveAttribute(R.attr.netverify_scanOptionsLoadingProgress, typedValue, true);
        this.d = (LinearLayout) getActivity().findViewById(R.id.spinnerContainer);
        this.d.setVisibility(0);
        this.d.setContentDescription(getResources().getString(R.string.jumio_accessibility_loading));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        View materialProgressBar = new MaterialProgressBar(viewGroup.getContext());
        materialProgressBar.setLayoutParams(layoutParams);
        materialProgressBar.setCircleBackgroundEnabled(false);
        materialProgressBar.setColorSchemeColors(typedValue.data);
        materialProgressBar.setProgressStokeWidth(dpToPx2);
        this.d.addView(materialProgressBar);
        theme.resolveAttribute(16842836, typedValue, true);
        this.f = typedValue.data;
        this.a.setAlpha(0.0f);
        return this.a;
    }

    public void onResume() {
        super.onResume();
        if (this.e.getTranslationY() != 0.0f) {
            ((INetverifyFragmentCallback) this.callback).animateActionbar(true, true);
            this.e.setVisibility(8);
            return;
        }
        getActivity().findViewById(R.id.toolbarContainer).setVisibility(4);
        getActivity().findViewById(R.id.fragment_container).setVisibility(4);
    }

    public void onError(Throwable th) {
        if (th instanceof JumioException) {
            JumioException jumioException = (JumioException) th;
            JumioError.getAlertDialogBuilder(getContext(), jumioException, new e(this, null), new d(jumioException));
        }
    }

    public CredentialsModel getCredentialsModel() {
        return ((INetverifyFragmentCallback) this.callback).getCredentials();
    }

    public void onCountriesReceived(List<Country> list, Country country, boolean z) {
        if (country == null) {
            this.b.setText(Html.fromHtml(Strings.getExternalString(getContext(), NVStrings.SCAN_OPTIONS_SELECT_COUNTRY)));
            this.b.setOnClickListener(new a(this, null));
        } else if (z) {
            this.b.setText(Html.fromHtml(String.format(Strings.getExternalString(getContext(), NVStrings.SCAN_OPTIONS_COUNTRY_SELECTION), new Object[]{country.getName()})));
            this.b.setOnClickListener(new a(this, null));
        } else {
            this.b.setText(Html.fromHtml(String.format(Strings.getExternalString(getContext(), NVStrings.SCAN_OPTIONS_COUNTRY_SELECTION_LOCK), new Object[]{country.getName()})));
            this.b.setOnClickListener(null);
        }
    }

    public void onDocumentTypesReceived(List<DocumentType> list, NVDocumentVariant nVDocumentVariant) {
        Collections.sort(list);
        LayoutInflater from = LayoutInflater.from(getContext());
        for (int i = 0; i < list.size(); i++) {
            int i2;
            DocumentType documentType = (DocumentType) list.get(i);
            NVDocumentType id = documentType.getId();
            List arrayList = new ArrayList();
            if (nVDocumentVariant == null) {
                arrayList.add(NVDocumentVariant.PLASTIC);
                if (documentType.hasPaperVariant()) {
                    arrayList.add(NVDocumentVariant.PAPER);
                }
            }
            switch (id) {
                case PASSPORT:
                    i2 = R.drawable.nv_selection_passport;
                    break;
                case DRIVER_LICENSE:
                    i2 = R.drawable.nv_selection_driver_license;
                    break;
                case VISA:
                    i2 = R.drawable.nv_selection_visa;
                    break;
                case IDENTITY_CARD:
                    i2 = R.drawable.nv_selection_id_card;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            TypedValue typedValue = new TypedValue();
            Theme theme = getContext().getTheme();
            int dpToPx = ScreenUtil.dpToPx(getContext(), 16);
            View linearLayout = new LinearLayout(getContext());
            linearLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(dpToPx, dpToPx));
            linearLayout.setBackgroundColor(this.f);
            b bVar = new b(documentType, nVDocumentVariant != null ? nVDocumentVariant : NVDocumentVariant.PLASTIC);
            if (arrayList.size() <= 1) {
                CardView cardView = (CardView) from.inflate(R.layout.nv_fragment_selection_item, null);
                ImageView imageView = (ImageView) cardView.findViewById(R.id.item_scan_option_button_icon);
                TextView textView = (TextView) cardView.findViewById(R.id.item_scan_option_button_title);
                cardView.setTag(bVar);
                cardView.setOnClickListener(new c(this, null));
                cardView.setFilterTouchesWhenObscured(true);
                theme.resolveAttribute(R.attr.netverify_scanOptionsItemBackground, typedValue, true);
                cardView.setCardBackgroundColor(typedValue.data);
                imageView.setImageResource(i2);
                textView.setText(documentType.getId().getLocalizedName(getContext()));
                cardView.setContentDescription(documentType.getId().getLocalizedName(getContext()));
                this.c.addView(cardView);
            } else {
                CardView cardView2 = (CardView) from.inflate(R.layout.nv_fragment_selection_subitem, null);
                cardView2.setTag(bVar);
                theme.resolveAttribute(R.attr.netverify_scanOptionsItemBackground, typedValue, true);
                cardView2.setCardBackgroundColor(typedValue.data);
                LinearLayout linearLayout2 = (LinearLayout) cardView2.findViewById(R.id.item_scan_option_header_layout);
                View findViewById = cardView2.findViewById(R.id.item_scan_option_variant_divider);
                theme.resolveAttribute(R.attr.netverify_scanOptionsItemHeaderBackground, typedValue, true);
                linearLayout2.setBackgroundColor(typedValue.data);
                findViewById.setBackgroundColor(typedValue.data);
                ((TextView) cardView2.findViewById(R.id.item_scan_option_header_title)).setText(documentType.getId().getLocalizedName(getContext()));
                ImageView imageView2 = (ImageView) cardView2.findViewById(R.id.item_scan_option_header_icon);
                TextView textView2 = (TextView) cardView2.findViewById(R.id.item_scan_option_variant_plastic);
                textView2.setTag(new b(documentType, NVDocumentVariant.PLASTIC));
                textView2.setText(Strings.getExternalString(getContext(), NVStrings.DOCUMENT_VARIANT_PLASTIC));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(documentType.getId().getLocalizedName(getContext()));
                stringBuilder.append(" ");
                stringBuilder.append(Strings.getExternalString(getContext(), NVStrings.DOCUMENT_VARIANT_PLASTIC));
                textView2.setContentDescription(stringBuilder.toString());
                textView2.setOnClickListener(new c(this, null));
                textView2 = (TextView) cardView2.findViewById(R.id.item_scan_option_variant_other);
                textView2.setText(Strings.getExternalString(getContext(), NVStrings.DOCUMENT_VARIANT_OTHER));
                textView2.setTag(new b(documentType, NVDocumentVariant.PAPER));
                stringBuilder = new StringBuilder();
                stringBuilder.append(documentType.getId().getLocalizedName(getContext()));
                stringBuilder.append(" ");
                stringBuilder.append(Strings.getExternalString(getContext(), NVStrings.DOCUMENT_VARIANT_OTHER));
                textView2.setContentDescription(stringBuilder.toString());
                textView2.setOnClickListener(new c(this, null));
                imageView2.setImageResource(i2);
                this.c.addView(cardView2);
            }
            this.c.addView(linearLayout);
        }
        this.c.setVisibility(0);
    }

    public void jumpToScanFragment(boolean z) {
        int i;
        if (z) {
            this.e.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    SelectionFragment.this.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator ofFloat = ObjectAnimator.ofFloat(SelectionFragment.this.e, "translationY", new float[]{0.0f, (float) (-SelectionFragment.this.e.getHeight())});
                    ofFloat.setStartDelay(150);
                    ofFloat.setDuration(300);
                    ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                    Animator ofFloat2 = ObjectAnimator.ofFloat(SelectionFragment.this.d, "alpha", new float[]{1.0f, 0.0f});
                    ofFloat2.setDuration(300);
                    ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                    animatorSet.play(ofFloat).after(ofFloat2);
                    animatorSet.addListener(new AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                            SelectionFragment.this.a.setVisibility(4);
                            SelectionFragment.this.toolbarSubtitleContainer.setVisibility(0);
                            SelectionFragment.this.getActivity().findViewById(R.id.toolbarContainer).setVisibility(0);
                            SelectionFragment.this.getActivity().findViewById(R.id.fragment_container).setVisibility(0);
                        }

                        public void onAnimationEnd(Animator animator) {
                            SelectionFragment.this.e.setVisibility(8);
                        }
                    });
                    animatorSet.start();
                }
            });
            i = 0;
        } else {
            ((INetverifyFragmentCallback) this.callback).animateActionbar(false, false);
            i = R.animator.nv_fade_out;
        }
        ((INetverifyFragmentCallback) this.callback).startFragment(new NVScanFragment(), z, 0, i);
    }

    public void hideLoading(final boolean z, final boolean z2) {
        this.e.post(new Runnable() {
            public void run() {
                Animator loadAnimator = AnimatorInflater.loadAnimator(SelectionFragment.this.getContext(), R.animator.nv_slide_up);
                loadAnimator.setTarget(SelectionFragment.this.a);
                AnimatorSet animatorSet = new AnimatorSet();
                Builder play = animatorSet.play(loadAnimator);
                if (SelectionFragment.this.e.getTranslationY() == 0.0f) {
                    Animator ofFloat;
                    Animator ofFloat2;
                    if (z) {
                        ofFloat = ObjectAnimator.ofFloat(SelectionFragment.this.e, "translationY", new float[]{0.0f, (float) (-SelectionFragment.this.e.getHeight())});
                        ofFloat.setStartDelay(150);
                        ofFloat.setDuration(450);
                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                        ofFloat2 = ObjectAnimator.ofFloat(SelectionFragment.this.d, "alpha", new float[]{1.0f, 0.0f});
                        ofFloat2.setDuration(300);
                        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                        play.with(ofFloat).with(ofFloat2);
                    } else {
                        SelectionFragment.this.e.setTranslationY((float) (-SelectionFragment.this.e.getHeight()));
                        SelectionFragment.this.d.setAlpha(0.0f);
                        SelectionFragment.this.b.setAlpha(1.0f);
                    }
                    ofFloat = ObjectAnimator.ofFloat(SelectionFragment.this.toolbar, "alpha", new float[]{0.0f, 1.0f});
                    ofFloat.setDuration(300);
                    ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat2 = ObjectAnimator.ofFloat(SelectionFragment.this.toolbarSubtitle, "alpha", new float[]{0.0f, 1.0f});
                    ofFloat2.setStartDelay(150);
                    ofFloat2.setDuration(300);
                    ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                    Animator ofFloat3 = ObjectAnimator.ofFloat(SelectionFragment.this.b, "alpha", new float[]{0.0f, 1.0f});
                    ofFloat3.setStartDelay(300);
                    ofFloat3.setDuration(300);
                    ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
                    play.before(ofFloat).before(ofFloat2).before(ofFloat3);
                    animatorSet.addListener(new AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                            SelectionFragment.this.getActivity().findViewById(R.id.toolbarContainer).setVisibility(0);
                            SelectionFragment.this.getActivity().findViewById(R.id.toolbarSubtitleContainer).setVisibility(0);
                            if (((INetverifyFragmentCallback) SelectionFragment.this.callback).getRotationManager().isScreenPortrait() || ((INetverifyFragmentCallback) SelectionFragment.this.callback).getRotationManager().isTablet()) {
                                SelectionFragment.this.toolbar.setTitle((CharSequence) " ");
                                SelectionFragment.this.setActionbarSubTitle(Strings.getExternalString(SelectionFragment.this.getContext(), NVStrings.SCAN_OPTIONS_SUBTITLE_TYPE));
                            } else {
                                SelectionFragment.this.toolbar.setTitle(Strings.getExternalString(SelectionFragment.this.getContext(), NVStrings.SCAN_OPTIONS_SUBTITLE_TYPE));
                                SelectionFragment.this.setActionbarSubTitle(null);
                            }
                            SelectionFragment.this.getActivity().findViewById(R.id.fragment_container).setVisibility(0);
                        }

                        public void onAnimationEnd(Animator animator) {
                            SelectionFragment.this.e.setVisibility(8);
                            SelectionFragment.this.b.setAlpha(1.0f);
                            if (z2 && SelectionFragment.this.b != null) {
                                SelectionFragment.this.b.performClick();
                            }
                        }
                    });
                } else {
                    SelectionFragment.this.b.setAlpha(1.0f);
                }
                animatorSet.start();
            }
        });
    }

    public NfcController getNfcController() {
        return ((INetverifyFragmentCallback) this.callback).getNfcController();
    }

    private void a() {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator ofFloat = ObjectAnimator.ofFloat(this.toolbarSubtitleContainer, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(100);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.toolbarSubtitleContainer, "translationY", new float[]{0.0f, (float) (-this.toolbarSubtitleContainer.getHeight())});
        ofFloat2.setDuration(100);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                SelectionFragment.this.toolbarSubtitleContainer.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                SelectionFragment.this.toolbarSubtitleContainer.setVisibility(8);
                if (SelectionFragment.this.b != null) {
                    SelectionFragment.this.toolbarSubtitleContainer.removeView(SelectionFragment.this.b);
                }
                ((INetverifyFragmentCallback) SelectionFragment.this.callback).startFragment(new CountryListFragment(), false, R.animator.nv_slide_up, R.animator.nv_slide_down);
            }
        });
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.start();
    }
}
