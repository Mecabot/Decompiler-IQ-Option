package com.iqoption.welcomeonboarding.registration;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.iqoption.d.ug;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: PortAnimatorFactory */
public class d extends a {
    public d(ug ugVar) {
        super(ugVar);
    }

    public Animator aKI() {
        r0 = new View[3][];
        r0[0] = new View[]{this.dMr.aOU, this.dMr.agA};
        r0[1] = new View[]{this.dMr.bEO};
        r0[2] = new View[]{this.dMr.bEQ};
        Collection arrayList = new ArrayList();
        int i = 0;
        for (View[] viewArr : r0) {
            Animator P;
            if (viewArr.length == 1) {
                P = P(viewArr[0]);
                P.setStartDelay((long) i);
            } else {
                Collection arrayList2 = new ArrayList();
                for (View P2 : viewArr) {
                    arrayList2.add(P(P2));
                }
                P = new AnimatorSet();
                P.playTogether(arrayList2);
            }
            arrayList.add(P);
            P.setStartDelay((long) i);
            i += 20;
        }
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        return animatorSet;
    }

    public Animator aKJ() {
        View root = this.dMr.getRoot();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.cwc});
        return ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
    }
}
