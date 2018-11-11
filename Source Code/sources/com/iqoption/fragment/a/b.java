package com.iqoption.fragment.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.fragment.base.f;
import com.iqoption.x.R;

/* compiled from: DebugMenuFragment */
public class b extends f {
    private boolean czs = false;
    PagerAdapter mPagerAdapter;
    ViewPager mViewPager;

    /* compiled from: DebugMenuFragment */
    public class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            if (b.this.czs) {
                i++;
            }
            switch (i) {
                case 0:
                    return new i();
                case 1:
                    return new c();
                case 2:
                    return new g();
                default:
                    return null;
            }
        }

        public long getItemId(int i) {
            return super.getItemId(i);
        }

        public int getCount() {
            return b.this.czs ? 2 : 3;
        }

        public CharSequence getPageTitle(int i) {
            if (b.this.czs) {
                i++;
            }
            switch (i) {
                case 0:
                    return "Sandbox";
                case 1:
                    return "Feature";
                case 2:
                    return "Parameters";
                default:
                    return null;
            }
        }
    }

    public static b akV() {
        return new b();
    }

    public static b akW() {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putBoolean("mEasyDebugMenu", true);
        bVar.setArguments(bundle);
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.debug_console, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            this.czs = getArguments().getBoolean("mEasyDebugMenu", false);
        }
        TextView textView = (TextView) view.findViewById(R.id.buildVersion);
        String in = IQApp.Dl().in("debug menu");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Version=5.5.1(388)\n");
        stringBuilder.append(in);
        textView.setText(stringBuilder.toString());
        this.mPagerAdapter = new a(getChildFragmentManager());
        this.mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setCurrentItem(0);
        this.mViewPager.setOffscreenPageLimit(0);
        view.findViewById(R.id.backButton).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.onBackPressed();
                b.this.getFragmentManager().popBackStack();
            }
        });
    }

    public boolean onBackPressed() {
        com.iqoption.app.managers.feature.b.HT().save();
        return super.aN();
    }
}
