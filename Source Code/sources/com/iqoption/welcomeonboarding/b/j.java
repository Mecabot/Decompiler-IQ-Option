package com.iqoption.welcomeonboarding.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.iqoption.d.ub;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: AnimatorFactory */
class j extends a {
    public j(ub ubVar) {
        super(ubVar);
    }

    public Animator aKI() {
        r0 = new View[4][];
        r0[0] = new View[]{this.dLU.aOU, this.dLU.agA};
        r0[1] = new View[]{this.dLU.bxr};
        r0[2] = new View[]{this.dLU.bGi};
        r0[3] = new View[]{this.dLU.getRoot().findViewById(R.id.socialTitle), this.dLU.getRoot().findViewById(R.id.facebookLogin), this.dLU.getRoot().findViewById(R.id.googleLogin)};
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
        animatorSet.setInterpolator(d.dEM);
        return animatorSet;
    }

    public Animator aKJ() {
        View root = this.dLU.getRoot();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.cwc});
        return ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
    }
}
