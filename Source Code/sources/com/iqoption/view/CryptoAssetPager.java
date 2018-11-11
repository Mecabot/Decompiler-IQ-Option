package com.iqoption.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.h;
import com.iqoption.d.vz;
import com.iqoption.util.au;
import com.iqoption.util.ax;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import java.util.Map;
import java.util.Set;

public final class CryptoAssetPager extends ViewPager {
    private OnClickListener awE;
    private Map<String, c> dBk;
    private Set<String> dBl;
    private Set<String> dBm;
    private a dBn;
    private vz dBo;
    private f dBp;
    private g dBq;
    private AnimatorSet dBr;
    private final OnTouchListener dBs;

    public static final class c {
        int image;
        int sprite;
    }

    public interface f {
        void d(@NonNull h hVar);
    }

    public interface g {
        void e(@NonNull h hVar);
    }

    private final class a extends PagerAdapter {
        private final LayoutInflater aDN;
        private ImmutableList<h> dtl;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* synthetic */ a(CryptoAssetPager cryptoAssetPager, ImmutableList immutableList, LayoutInflater layoutInflater, AnonymousClass1 anonymousClass1) {
            this(immutableList, layoutInflater);
        }

        private a(ImmutableList<h> immutableList, LayoutInflater layoutInflater) {
            this.dtl = immutableList;
            this.aDN = layoutInflater;
        }

        public int getCount() {
            return this.dtl.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            int i2;
            int i3;
            int i4 = 0;
            vz K = vz.K(this.aDN, viewGroup, false);
            View root = K.getRoot();
            viewGroup.addView(root);
            com.iqoption.core.microservices.tradingengine.response.active.a gO = gO(i);
            K.avo.setText(com.iqoption.util.e.a.s(gO));
            c cVar = (c) CryptoAssetPager.this.dBk.get(gO.getInstrumentId());
            if (cVar != null) {
                i2 = cVar.image;
                i3 = cVar.sprite;
            } else {
                i2 = R.drawable.crypto_placeholder;
                i3 = R.drawable.crypto_placeholder_na;
            }
            K.aEt.setImageResource(i2);
            K.bJj.setImageResource(i3);
            View view = K.bJh;
            if (com.iqoption.util.e.a.G(gO)) {
                i4 = 4;
            }
            view.setVisibility(i4);
            K.bAL.setOnClickListener(CryptoAssetPager.this.awE);
            root.setTag(Integer.valueOf(i));
            if (CryptoAssetPager.this.dBo == null && CryptoAssetPager.this.getCurrentItem() == i) {
                CryptoAssetPager.this.aIg();
            }
            return root;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @NonNull
        private h gO(int i) {
            return (h) this.dtl.get(i);
        }
    }

    private static class b implements PageTransformer {
        private vz dBv;

        protected float N(float f) {
            return (f * 0.25f) + 0.75f;
        }

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        public vz aIh() {
            return this.dBv;
        }

        public void transformPage(View view, float f) {
            this.dBv = (vz) DataBindingUtil.getBinding(view);
            float abs = Math.abs(f);
            float f2 = 1.0f - abs;
            float N = N(f2);
            this.dBv.bJi.setScaleX(N);
            this.dBv.bJi.setScaleY(N);
            this.dBv.bJi.setAlpha(2.0f - abs);
            this.dBv.aEt.setAlpha(f2);
            this.dBv.bJg.setAlpha(au.e(f2, 0.66f, 1.0f));
            this.dBv.bJj.setAlpha(abs);
            this.dBv.avo.setAlpha(f2);
        }
    }

    @TargetApi(21)
    private static final class d extends b {
        private d() {
            super();
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void transformPage(View view, float f) {
            super.transformPage(view, f);
            View root = aIh().getRoot();
            root.setTranslationX(-((((float) view.getWidth()) / 1.3f) * f));
            root.setZ(1.0f - Math.abs(f));
        }
    }

    private static class e extends b {
        protected float N(float f) {
            return (f * 0.35f) + 0.65f;
        }

        private e() {
            super();
        }

        /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void transformPage(View view, float f) {
            super.transformPage(view, f);
            aIh().getRoot().setTranslationX(-((((float) view.getWidth()) / 1.9f) * f));
        }
    }

    public void setIconsMap(Map<String, c> map) {
        this.dBk.clear();
        if (map != null) {
            this.dBk.putAll(map);
        }
    }

    public void setBumperedAssets(Set<String> set) {
        this.dBl.clear();
        if (set != null) {
            this.dBl.addAll(set);
        }
        if (this.dBo != null) {
            aIg();
        }
    }

    public void setClickableAssets(Set<String> set) {
        this.dBm.clear();
        if (set != null) {
            this.dBm.addAll(set);
        }
    }

    private boolean b(h hVar) {
        return hVar != null && this.dBl.contains(hVar.getInstrumentId());
    }

    private boolean c(h hVar) {
        return hVar != null && this.dBm.contains(hVar.getInstrumentId());
    }

    public CryptoAssetPager(Context context) {
        this(context, null);
    }

    public CryptoAssetPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBk = new ArrayMap();
        this.dBl = new ArraySet();
        this.dBm = new ArraySet();
        this.awE = new OnClickListener() {
            public void onClick(View view) {
                h selectedAsset = CryptoAssetPager.this.getSelectedAsset();
                if (selectedAsset != null && CryptoAssetPager.this.dBq != null) {
                    CryptoAssetPager.this.dBq.e(selectedAsset);
                }
            }
        };
        this.dBs = new com.iqoption.view.d.e(new com.iqoption.view.d.f(0.95f)) {
            public boolean f(View view, MotionEvent motionEvent) {
                if (CryptoAssetPager.this.dBr != null) {
                    CryptoAssetPager.this.dBr.cancel();
                }
                return false;
            }
        };
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            addOnPageChangeListener(new OnPageChangeListener() {
                private int dBu;

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                }

                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && this.dBu != CryptoAssetPager.this.getCurrentItem()) {
                        this.dBu = CryptoAssetPager.this.getCurrentItem();
                        if (CryptoAssetPager.this.dBp != null) {
                            CryptoAssetPager.this.dBp.d(((a) CryptoAssetPager.this.getAdapter()).gO(this.dBu));
                        }
                        CryptoAssetPager.this.aIg();
                    }
                }
            });
            setOffscreenPageLimit(7);
            setPageTransformer(false, ax.dws ? new d() : new e());
        }
    }

    public void setAssetChangeListener(f fVar) {
        this.dBp = fVar;
    }

    public void setAssetClickListener(g gVar) {
        this.dBq = gVar;
    }

    public void setActives(Iterable<com.iqoption.core.microservices.tradingengine.response.active.a> iterable) {
        if (iterable != null) {
            this.dBn = new a(this, ImmutableList.g(i.c((Iterable) iterable).b(g.$instance)), LayoutInflater.from(getContext()), null);
            setAdapter(this.dBn);
            setCurrentItem(this.dBn.getCount() / 2);
            return;
        }
        this.dBn = null;
        setAdapter(null);
    }

    static final /* synthetic */ h J(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return (aVar == null || aVar.getInstrumentType() != InstrumentType.CRYPTO_INSTRUMENT) ? null : (h) aVar;
    }

    public void setSelectedAsset(int i) {
        if (this.dBn == null) {
            com.iqoption.core.i.w("CryptoAssetPager", "Adapter is null!");
            return;
        }
        int count = this.dBn.getCount();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            h a = this.dBn.gO(i3);
            if (a.getActiveId() == i) {
                String instrumentId = a.getInstrumentId();
                if (!this.dBk.containsKey(instrumentId)) {
                    instrumentId = null;
                }
                com.iqoption.view.drawable.e.jY(instrumentId);
                i2 = i3;
                setCurrentItem(i2, true);
            }
        }
        setCurrentItem(i2, true);
    }

    public h getSelectedAsset() {
        if (this.dBn != null) {
            return this.dBn.gO(getCurrentItem());
        }
        com.iqoption.core.i.w("CryptoAssetPager", "Adapter is null!");
        return null;
    }

    public Rect getCoinRect() {
        if (this.dBo != null) {
            return bg.J(this.dBo.aEt);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find selected binding");
        stringBuilder.append(getCurrentItem());
        com.iqoption.core.i.w("CryptoAssetPager", stringBuilder.toString());
        return null;
    }

    public void aIf() {
        if (this.dBo == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find selected binding");
            stringBuilder.append(getCurrentItem());
            com.iqoption.core.i.w("CryptoAssetPager", stringBuilder.toString());
            return;
        }
        if (this.dBr != null) {
            this.dBr.cancel();
        }
        this.dBr = new AnimatorSet();
        CryptoBumperView cryptoBumperView = this.dBo.bJg;
        r1 = new PropertyValuesHolder[3];
        r1[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        r1[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.9f, 1.0f});
        r1[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.9f, 1.0f});
        Animator duration = ObjectAnimator.ofPropertyValuesHolder(cryptoBumperView, r1).setDuration(400);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                CryptoAssetPager.this.dBo.bJg.setDrawStatic(true);
            }
        });
        duration.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.dBo.bAL, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.95f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.95f})}).setDuration(400);
        duration2.setRepeatCount(-1);
        duration2.setRepeatMode(2);
        this.dBr.playSequentially(new Animator[]{duration, duration2});
        this.dBr.start();
    }

    private void aIg() {
        h selectedAsset = getSelectedAsset();
        boolean c = c(selectedAsset);
        boolean b = b(selectedAsset);
        if (this.dBo != null) {
            if (this.dBr != null) {
                this.dBr.cancel();
            }
            this.dBo.bJg.setDrawStatic(false);
            this.dBo.bAL.setOnTouchListener(null);
            this.dBo = null;
        }
        this.dBo = (vz) DataBindingUtil.getBinding(findViewWithTag(Integer.valueOf(getCurrentItem())));
        if (this.dBo != null) {
            if (c) {
                this.dBo.bAL.setOnTouchListener(this.dBs);
            }
            if (b) {
                aIf();
            }
        }
    }
}
