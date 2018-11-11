package com.iqoption.welcomeonboarding.registration;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.iqoption.d.ug;
import com.iqoption.view.a.a.d;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: LandAnimatorFactory */
public class c extends a {
    public c(ug ugVar) {
        super(ugVar);
    }

    Animator aKI() {
        r1 = new View[2][];
        r1[0] = new View[]{this.dMr.aOU, this.dMr.agA};
        r1[1] = new View[]{this.dMr.bEO, this.dMr.bEQ};
        Collection arrayList = new ArrayList();
        int i = 0;
        for (View[] viewArr : r1) {
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
        animatorSet.setInterpolator(d.dEM);
        return animatorSet;
    }

    Animator aKJ() {
        View root = this.dMr.getRoot();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.cwc});
        return ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
    }
}
