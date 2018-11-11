package com.iqoption.videoeducation.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.iqoption.analytics.o;
import com.iqoption.core.ui.fragment.b;
import com.iqoption.core.ui.viewmodel.AnimViewModel;
import com.iqoption.d.tn;
import com.iqoption.util.EventSenderLifecycleObserver;
import com.iqoption.videoeducation.VideoEducationViewModel;
import com.iqoption.videoeducation.a.f;
import com.iqoption.widget.h;
import com.iqoption.x.R;

/* compiled from: VideoCatalogsFragment */
public class a extends b {
    public static final String TAG = "com.iqoption.videoeducation.fragment.a";

    public boolean KE() {
        return true;
    }

    public static a aHQ() {
        return new a();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        tn tnVar = (tn) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_video_education_categories, viewGroup, false);
        tnVar.bFF.setHasFixedSize(true);
        tnVar.bFF.setLayoutManager(new LinearLayoutManager(getContext()));
        tnVar.bFF.addItemDecoration(new h(com.iqoption.core.ext.a.c((Fragment) this, (int) R.dimen.dp8)));
        VideoEducationViewModel H = VideoEducationViewModel.H(requireActivity());
        Adapter fVar = new f(new b(H));
        tnVar.bFF.setAdapter(fVar);
        AnimViewModel.s(this).YZ().observe(this, new c(this, H, fVar));
        getLifecycle().a(new EventSenderLifecycleObserver(o.BM(), null));
        return tnVar.getRoot();
    }

    final /* synthetic */ void a(VideoEducationViewModel videoEducationViewModel, f fVar, Boolean bool) {
        if (Boolean.FALSE.equals(bool)) {
            videoEducationViewModel.aHF().observe(this, new d(fVar));
            videoEducationViewModel.aHG().observe(this, new e(this));
        }
    }

    final /* synthetic */ void c(com.iqoption.videoeducation.b.a aVar) {
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(j.TAG);
        if (aVar != null) {
            if (findFragmentByTag == null) {
                supportFragmentManager.beginTransaction().add(R.id.other_fragment, new j(), j.TAG).commitNow();
            }
        } else if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitNow();
        }
    }

    @Nullable
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        Animation onCreateAnimation = super.onCreateAnimation(i, z, i2);
        if (z && onCreateAnimation != null) {
            AnimViewModel.s(this).a(onCreateAnimation);
        }
        return onCreateAnimation;
    }
}
