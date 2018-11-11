package com.jumio.nv.view.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.core.data.Strings;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.nv.R;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.view.interactors.CountryListView;
import jumio.nv.core.r;
import jumio.nv.core.r.a;
import jumio.nv.core.w;

@RequiresPresenter(w.class)
public class CountryListFragment extends NVBaseFragment<w> implements OnQueryTextListener, OnItemClickListener, INetverifyActivityCallback, CountryListView {
    private ListView a;
    private TextView b;
    private r c;
    private SearchView d;
    protected Toolbar toolbar;
    protected TextView toolbarSubtitle;
    protected LinearLayout toolbarSubtitleContainer;

    public void onError(Throwable th) {
    }

    public boolean onHomeButtonPressed() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((INetverifyFragmentCallback) this.callback).registerActivityCallback(this);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nv_fragment_countrylist, viewGroup, false);
        this.b = (TextView) inflate.findViewById(16908292);
        this.a = (ListView) inflate.findViewById(R.id.countryListView);
        this.toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        this.toolbarSubtitle = (TextView) getActivity().findViewById(R.id.toolbar_subtitle);
        if (!(this.toolbarSubtitleContainer == null || this.d == null)) {
            this.toolbarSubtitleContainer.removeView(this.d);
        }
        this.toolbarSubtitleContainer = (LinearLayout) getActivity().findViewById(R.id.toolbarSubtitleContainer);
        this.d = (SearchView) layoutInflater.inflate(R.layout.nv_fragment_country_search_item, null);
        this.d.setFilterTouchesWhenObscured(true);
        this.d.setOnQueryTextListener(this);
        this.d.setIconifiedByDefault(true);
        this.d.setFocusable(true);
        this.d.setIconified(false);
        this.d.setContentDescription(Strings.getExternalString(getContext(), NVStrings.COUNTRYLIST_TITLE));
        this.d.setOnSearchClickListener(new OnClickListener() {
            public void onClick(View view) {
                JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.COUNTRY_LIST, UserAction.SEARCH_STARTED));
            }
        });
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.colorControlNormal, typedValue, true);
        CompatibilityLayer.getDrawable(getResources(), R.drawable.nv_ic_search_alpha).setColorFilter(typedValue.data, Mode.SRC_ATOP);
        this.d.findViewById(android.support.v7.appcompat.R.id.search_plate).getBackground().setColorFilter(typedValue.data, Mode.MULTIPLY);
        this.toolbarSubtitleContainer.addView(this.d);
        ((INetverifyFragmentCallback) this.callback).setUiAutomationId(R.string.netverify_automation_country_list);
        return inflate;
    }

    public void onResume() {
        super.onResume();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.c = new r(((w) getPresenter()).a());
        this.b.setText(Strings.getExternalString(getActivity(), NVStrings.COUNTRYLIST_EMPTY));
        this.a.setEmptyView(this.b);
        this.a.setAdapter(this.c);
        this.a.setOnItemClickListener(this);
        this.a.setFastScrollEnabled(true);
        this.a.setFilterTouchesWhenObscured(true);
        a();
    }

    private void a() {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator ofFloat = ObjectAnimator.ofFloat(this.toolbarSubtitleContainer, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(100);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.toolbarSubtitleContainer, "translationY", new float[]{(float) (-this.toolbarSubtitleContainer.getHeight()), 0.0f});
        ofFloat2.setDuration(100);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                CountryListFragment.this.toolbarSubtitleContainer.setVisibility(8);
            }

            public void onAnimationEnd(Animator animator) {
                CountryListFragment.this.toolbarSubtitleContainer.setVisibility(0);
            }
        });
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.start();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.d.requestFocusFromTouch();
        JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.COUNTRY_LIST, null));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onQueryTextSubmit(String str) {
        if (this.c != null) {
            this.c.a(str);
        }
        return false;
    }

    public boolean onQueryTextChange(String str) {
        if (this.c != null) {
            this.c.a(str);
        }
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = (a) view.getTag();
        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.COUNTRY_LIST, UserAction.COUNTRY_SELECTED, aVar.a.getIsoCode()));
        ((w) getPresenter()).a(aVar.a);
        b();
        finishFragment();
    }

    public void finishFragment() {
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
                CountryListFragment.this.toolbarSubtitleContainer.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                CountryListFragment.this.toolbarSubtitleContainer.setVisibility(8);
                if (CountryListFragment.this.d != null) {
                    CountryListFragment.this.toolbarSubtitleContainer.removeView(CountryListFragment.this.d);
                }
                CountryListFragment.this.a();
                ((INetverifyFragmentCallback) CountryListFragment.this.callback).closeFragment(R.animator.nv_slide_up, R.animator.nv_slide_down);
            }
        });
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.start();
    }

    public boolean onBackButtonPressed() {
        if (this.d != null) {
            this.d.setQuery("", false);
        }
        finishFragment();
        return true;
    }

    private void b() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public void handleOrientationChange(boolean z, boolean z2) {
        ((LayoutParams) getActivity().findViewById(R.id.country_container).getLayoutParams()).topMargin = ScreenUtil.dpToPx(getActivity(), z ? 156 : 74);
        if (z) {
            this.toolbar.setTitle((CharSequence) " ");
            setActionbarSubTitle(Strings.getExternalString(getContext(), NVStrings.COUNTRYLIST_TITLE));
            return;
        }
        this.toolbar.setTitle(Strings.getExternalString(getContext(), NVStrings.COUNTRYLIST_TITLE));
        setActionbarSubTitle(null);
        b();
    }
}
