package com.iqoption.welcomeonboarding.c.a;

import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView.CacheStrategy;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonObject;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.ox;
import com.iqoption.dto.Event;
import com.iqoption.util.bg;
import com.iqoption.welcomeonboarding.c.e;
import com.iqoption.x.R;

/* compiled from: OnboardingSlideFragment */
public class a extends Fragment implements e {
    private static final String TAG = "com.iqoption.welcomeonboarding.c.a.a";
    private Boolean dMl;
    private ox dMm;
    private String dMn;
    private String description;
    private int position;
    private String title;

    public static a a(b bVar, int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create onboarding welcome slide fragment, file name= ");
        stringBuilder.append(bVar.aLf());
        stringBuilder.append(", title= ");
        stringBuilder.append(bVar.aLg());
        stringBuilder.append(" , description= ");
        stringBuilder.append(bVar.aLh());
        i.d(str, stringBuilder.toString());
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("animation_file_name", bVar.aLf());
        bundle.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, bVar.aLg());
        bundle.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, bVar.aLh());
        bundle.putInt("position", i);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.dMn = kl(getArguments().getString("animation_file_name"));
        this.title = getArguments().getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        this.description = getArguments().getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.position = getArguments().getInt("position");
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dMm = (ox) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_onboardin_welcom_slide, viewGroup, false);
        if (this.dMl != null) {
            this.dMm.bzi.setProgress(this.dMl.booleanValue() ? 1.0f : 0.0f);
            this.dMl = null;
        }
        return this.dMm.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.dMm.bzi.a(this.dMn, CacheStrategy.Weak);
        this.dMm.bzi.setProgress(0.0f);
        this.dMm.bzm.setText(this.title);
        this.dMm.bzl.setText(this.description);
    }

    public void c(float f, int i) {
        if (getView() != null) {
            switch (i) {
                case 0:
                    this.dMm.bzm.setAlpha(f);
                    this.dMm.bzl.setAlpha(f);
                    break;
                case 1:
                    float f2 = 1.0f - f;
                    this.dMm.bzm.setAlpha(f2);
                    this.dMm.bzl.setAlpha(f2);
                    break;
            }
        }
    }

    public void aLb() {
        if (getView() != null) {
            this.dMm.bzi.cV();
            this.dMm.bzi.setProgress(0.0f);
            this.dMm.bzi.cT();
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_SCREEN_OPENED, "welcomescreen_swipe-carousel").setParameters(aLd()).build());
        }
    }

    public void aLc() {
        if (getView() != null) {
            this.dMm.bzi.cV();
            this.dMm.bzi.setProgress(0.0f);
        }
    }

    private JsonObject aLd() {
        return com.iqoption.core.util.i.ZZ().l("animation_json_name", this.dMn).l("screen_number", Integer.valueOf(this.position)).l("screen_orientation", getResources().getConfiguration().orientation == 1 ? "vertical" : "horizontal").aab();
    }

    public Rect aLe() {
        if (this.dMm == null) {
            return null;
        }
        return bg.J(this.dMm.bzi);
    }

    public void fu(boolean z) {
        if (this.dMm == null) {
            this.dMl = Boolean.valueOf(z);
        } else {
            this.dMm.bzi.setProgress(z ? 1.0f : 0.0f);
        }
    }

    private String kl(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lottie/welcome/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
