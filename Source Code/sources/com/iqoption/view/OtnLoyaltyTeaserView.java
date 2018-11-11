package com.iqoption.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.util.bg;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OtnLoyaltyTeaserView extends FrameLayout {
    private static final Map<Integer, b> dCM = new com.google.common.collect.ImmutableMap.a().r(Integer.valueOf(R.id.btc), b.dCX).r(Integer.valueOf(R.id.dsh), b.dCX).r(Integer.valueOf(R.id.ltc), b.dCX).r(Integer.valueOf(R.id.otn), b.dCZ).r(Integer.valueOf(R.id.text), b.dCY).tc();
    private static final Map<Integer, b> dCN = new com.google.common.collect.ImmutableMap.a().r(Integer.valueOf(R.id.btc), b.dCY).r(Integer.valueOf(R.id.dsh), b.dDa).r(Integer.valueOf(R.id.ltc), b.dCZ).r(Integer.valueOf(R.id.otn), b.dCZ).r(Integer.valueOf(R.id.text), b.dCY).tc();
    private static final Map<Integer, b> dCO = new com.google.common.collect.ImmutableMap.a().r(Integer.valueOf(R.id.btc), b.dCY).r(Integer.valueOf(R.id.dsh), b.dCY).r(Integer.valueOf(R.id.ltc), b.dCY).r(Integer.valueOf(R.id.otn), b.dCY).r(Integer.valueOf(R.id.text), b.dDd).tc();
    private static final Map<Integer, b> dCP = new com.google.common.collect.ImmutableMap.a().r(Integer.valueOf(R.id.btc), b.dCY).r(Integer.valueOf(R.id.dsh), b.dDb).r(Integer.valueOf(R.id.ltc), b.dDc).r(Integer.valueOf(R.id.text), b.dDe).tc();
    private Animator animator;
    private View ceS;
    private View dCQ;
    private View dCR;
    private View dCS;
    private View dCT;
    private a dCU;
    private boolean dCV;

    private abstract class a {
        abstract void aIv();

        abstract Animator aIz();

        private a() {
        }

        /* synthetic */ a(OtnLoyaltyTeaserView otnLoyaltyTeaserView, AnonymousClass1 anonymousClass1) {
            this();
        }

        final void aIA() {
            int childCount = OtnLoyaltyTeaserView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = OtnLoyaltyTeaserView.this.getChildAt(i);
                childAt.setAlpha(0.0f);
                childAt.setTranslationX(((b) OtnLoyaltyTeaserView.dCM.get(Integer.valueOf(childAt.getId()))).f(OtnLoyaltyTeaserView.this));
            }
            OtnLoyaltyTeaserView.this.dCT.setRotation(-180.0f);
        }
    }

    private interface b {
        public static final b dCX = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return ((float) otnLoyaltyTeaserView.getWidth()) - (((float) otnLoyaltyTeaserView.dCT.getWidth()) / 2.0f);
            }
        };
        public static final b dCY = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return 0.0f;
            }
        };
        public static final b dCZ = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return (float) otnLoyaltyTeaserView.dCQ.getMeasuredWidth();
            }
        };
        public static final b dDa = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return ((float) otnLoyaltyTeaserView.dCQ.getMeasuredWidth()) / 2.0f;
            }
        };
        public static final b dDb = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return ((float) otnLoyaltyTeaserView.dCQ.getMeasuredWidth()) / 3.0f;
            }
        };
        public static final b dDc = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return (((float) otnLoyaltyTeaserView.dCQ.getMeasuredWidth()) / 3.0f) * 2.0f;
            }
        };
        public static final b dDd = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return (float) (-otnLoyaltyTeaserView.dCQ.getMeasuredWidth());
            }
        };
        public static final b dDe = new b() {
            public float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView) {
                return -(((float) otnLoyaltyTeaserView.dCQ.getMeasuredWidth()) / 3.0f);
            }
        };

        float f(OtnLoyaltyTeaserView otnLoyaltyTeaserView);
    }

    public OtnLoyaltyTeaserView(@NonNull Context context) {
        super(context);
        init(null);
    }

    public OtnLoyaltyTeaserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public OtnLoyaltyTeaserView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    @TargetApi(21)
    public OtnLoyaltyTeaserView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_otn_loyalty_teaser, this);
        this.dCQ = findViewById(R.id.btc);
        this.dCR = findViewById(R.id.dsh);
        this.dCS = findViewById(R.id.ltc);
        this.dCT = findViewById(R.id.otn);
        this.ceS = findViewById(R.id.text);
        boolean z = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.iqoption.b.b.OtnLoyaltyTeaserView);
            if (obtainStyledAttributes.getBoolean(0, true)) {
                this.dCU = new a() {
                    public Animator aIz() {
                        PropertyValuesHolder[] propertyValuesHolderArr;
                        Animator animatorSet = new AnimatorSet();
                        View[] viewArr = new View[]{OtnLoyaltyTeaserView.this.dCQ, OtnLoyaltyTeaserView.this.dCR, OtnLoyaltyTeaserView.this.dCS};
                        List arrayList = new ArrayList();
                        for (View view : viewArr) {
                            propertyValuesHolderArr = new PropertyValuesHolder[2];
                            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
                            propertyValuesHolderArr[1] = OtnLoyaltyTeaserView.this.cf(view);
                            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
                            ofPropertyValuesHolder.setInterpolator(d.aQV);
                            arrayList.add(ofPropertyValuesHolder.setDuration(150));
                        }
                        new AnimatorSet().playSequentially(arrayList);
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        Animator[] animatorArr = new Animator[2];
                        View a = OtnLoyaltyTeaserView.this.dCT;
                        propertyValuesHolderArr = new PropertyValuesHolder[4];
                        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
                        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f, 1.2f});
                        propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f, 1.2f});
                        propertyValuesHolderArr[3] = PropertyValuesHolder.ofFloat(View.ROTATION, new float[]{0.0f});
                        animatorArr[0] = ObjectAnimator.ofPropertyValuesHolder(a, propertyValuesHolderArr);
                        animatorArr[1] = ObjectAnimator.ofFloat(OtnLoyaltyTeaserView.this.ceS, View.ALPHA, new float[]{0.0f, 1.0f});
                        animatorSet2.playTogether(animatorArr);
                        animatorSet2.setInterpolator(d.dEM);
                        com.iqoption.util.b.a(animatorSet2, 350);
                        AnimatorSet animatorSet3 = new AnimatorSet();
                        r9 = new Animator[5];
                        r9[0] = ObjectAnimator.ofFloat(OtnLoyaltyTeaserView.this.dCQ, View.ALPHA, new float[]{0.0f});
                        View c = OtnLoyaltyTeaserView.this.dCR;
                        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[2];
                        propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
                        propertyValuesHolderArr2[1] = OtnLoyaltyTeaserView.this.cg(OtnLoyaltyTeaserView.this.dCR);
                        r9[1] = ObjectAnimator.ofPropertyValuesHolder(c, propertyValuesHolderArr2);
                        View view2 = OtnLoyaltyTeaserView.this.dCS;
                        propertyValuesHolderArr = new PropertyValuesHolder[2];
                        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
                        propertyValuesHolderArr[1] = OtnLoyaltyTeaserView.this.cg(OtnLoyaltyTeaserView.this.dCS);
                        r9[2] = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
                        view2 = OtnLoyaltyTeaserView.this.dCT;
                        propertyValuesHolderArr = new PropertyValuesHolder[3];
                        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f});
                        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f});
                        propertyValuesHolderArr[2] = OtnLoyaltyTeaserView.this.cg(OtnLoyaltyTeaserView.this.dCT);
                        r9[3] = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
                        r9[4] = ObjectAnimator.ofPropertyValuesHolder(OtnLoyaltyTeaserView.this.ceS, new PropertyValuesHolder[]{OtnLoyaltyTeaserView.this.cg(OtnLoyaltyTeaserView.this.ceS)});
                        animatorSet3.playTogether(r9);
                        animatorSet3.setInterpolator(d.dEM);
                        com.iqoption.util.b.a(animatorSet3, 300);
                        animatorSet.playSequentially(new Animator[]{r3, animatorSet2, animatorSet3});
                        return animatorSet;
                    }

                    public void aIv() {
                        r0 = new View[5];
                        int i = 0;
                        r0[0] = OtnLoyaltyTeaserView.this.dCQ;
                        r0[1] = OtnLoyaltyTeaserView.this.dCR;
                        r0[2] = OtnLoyaltyTeaserView.this.dCS;
                        r0[3] = OtnLoyaltyTeaserView.this.dCT;
                        r0[4] = OtnLoyaltyTeaserView.this.ceS;
                        int length = r0.length;
                        while (true) {
                            float f = 0.0f;
                            if (i < length) {
                                View view = r0[i];
                                if (view == OtnLoyaltyTeaserView.this.ceS) {
                                    f = 1.0f;
                                }
                                view.setAlpha(f);
                                view.setTranslationX(((b) OtnLoyaltyTeaserView.dCO.get(Integer.valueOf(view.getId()))).f(OtnLoyaltyTeaserView.this));
                                i++;
                            } else {
                                OtnLoyaltyTeaserView.this.dCT.setRotation(0.0f);
                                OtnLoyaltyTeaserView.this.dCT.setAlpha(1.0f);
                                OtnLoyaltyTeaserView.this.dCT.setScaleX(1.0f);
                                OtnLoyaltyTeaserView.this.dCT.setScaleY(1.0f);
                                return;
                            }
                        }
                    }
                };
                z = false;
            }
            obtainStyledAttributes.recycle();
        }
        if (z) {
            this.dCU = new a() {
                public Animator aIz() {
                    Animator animatorSet = new AnimatorSet();
                    View[] viewArr = new View[]{OtnLoyaltyTeaserView.this.dCQ, OtnLoyaltyTeaserView.this.dCR, OtnLoyaltyTeaserView.this.dCS};
                    List arrayList = new ArrayList();
                    for (View view : viewArr) {
                        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
                        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
                        propertyValuesHolderArr[1] = OtnLoyaltyTeaserView.this.ce(view);
                        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
                        ofPropertyValuesHolder.setInterpolator(d.aQV);
                        arrayList.add(ofPropertyValuesHolder.setDuration(150));
                    }
                    new AnimatorSet().playSequentially(arrayList);
                    View e = OtnLoyaltyTeaserView.this.ceS;
                    PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[2];
                    propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
                    propertyValuesHolderArr2[1] = OtnLoyaltyTeaserView.this.ce(OtnLoyaltyTeaserView.this.ceS);
                    Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(e, propertyValuesHolderArr2);
                    ofPropertyValuesHolder2.setInterpolator(d.dEM);
                    ofPropertyValuesHolder2.setDuration(350);
                    animatorSet.playSequentially(new Animator[]{r1, ofPropertyValuesHolder2});
                    return animatorSet;
                }

                public void aIv() {
                    r0 = new View[4];
                    int i = 0;
                    r0[0] = OtnLoyaltyTeaserView.this.dCQ;
                    r0[1] = OtnLoyaltyTeaserView.this.dCR;
                    r0[2] = OtnLoyaltyTeaserView.this.dCS;
                    r0[3] = OtnLoyaltyTeaserView.this.ceS;
                    int length = r0.length;
                    while (i < length) {
                        View view = r0[i];
                        view.setAlpha(1.0f);
                        view.setTranslationX(((b) OtnLoyaltyTeaserView.dCP.get(Integer.valueOf(view.getId()))).f(OtnLoyaltyTeaserView.this));
                        i++;
                    }
                    OtnLoyaltyTeaserView.this.dCT.setAlpha(0.0f);
                }
            };
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.animator == null) {
            if (this.dCV) {
                this.dCU.aIv();
            } else {
                this.dCU.aIA();
            }
            this.animator = this.dCU.aIz();
        }
    }

    private PropertyValuesHolder ce(View view) {
        float f = ((b) dCM.get(Integer.valueOf(view.getId()))).f(this);
        float f2 = ((b) dCP.get(Integer.valueOf(view.getId()))).f(this);
        return PropertyValuesHolder.ofFloat(TRANSLATION_X, new float[]{f, f2});
    }

    private PropertyValuesHolder cf(View view) {
        float f = ((b) dCM.get(Integer.valueOf(view.getId()))).f(this);
        float f2 = ((b) dCN.get(Integer.valueOf(view.getId()))).f(this);
        return PropertyValuesHolder.ofFloat(TRANSLATION_X, new float[]{f, f2});
    }

    private PropertyValuesHolder cg(View view) {
        float f = ((b) dCN.get(Integer.valueOf(view.getId()))).f(this);
        float f2 = ((b) dCO.get(Integer.valueOf(view.getId()))).f(this);
        return PropertyValuesHolder.ofFloat(TRANSLATION_X, new float[]{f, f2});
    }

    public void aIv() {
        if (this.animator == null) {
            this.dCV = true;
            return;
        }
        this.animator.cancel();
        this.dCU.aIv();
    }

    public void play() {
        if (this.animator == null) {
            bg.b(this, new Runnable() {
                public void run() {
                    OtnLoyaltyTeaserView.this.play();
                }
            });
        } else if (!this.animator.isRunning()) {
            this.animator.start();
        }
    }
}
