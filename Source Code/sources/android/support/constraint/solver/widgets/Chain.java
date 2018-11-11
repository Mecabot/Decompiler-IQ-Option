package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        int i4 = 0;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = i2;
            i2 = 0;
        } else {
            i2 = 2;
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            i3 = i5;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        while (i4 < i3) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i2, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
            i4++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:194:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0512  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0518  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0533  */
    /* JADX WARNING: Missing block: B:15:0x0035, code:
            if (r2.mHorizontalChainStyle == 2) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:17:0x0039, code:
            r5 = null;
     */
    /* JADX WARNING: Missing block: B:28:0x0053, code:
            if (r2.mVerticalChainStyle == 2) goto L_0x0037;
     */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r46, android.support.constraint.solver.LinearSystem r47, int r48, int r49, android.support.constraint.solver.widgets.ChainHead r50) {
        /*
        r0 = r46;
        r9 = r47;
        r1 = r50;
        r11 = r1.mFirst;
        r12 = r1.mLast;
        r13 = r1.mFirstVisibleWidget;
        r14 = r1.mLastVisibleWidget;
        r2 = r1.mHead;
        r3 = r1.mTotalWeight;
        r4 = r1.mFirstMatchConstraintWidget;
        r4 = r1.mLastMatchConstraintWidget;
        r4 = r0.mListDimensionBehaviors;
        r4 = r4[r48];
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r7 = 1;
        if (r4 != r5) goto L_0x0021;
    L_0x001f:
        r4 = 1;
        goto L_0x0022;
    L_0x0021:
        r4 = 0;
    L_0x0022:
        r5 = 2;
        if (r48 != 0) goto L_0x0042;
    L_0x0025:
        r8 = r2.mHorizontalChainStyle;
        if (r8 != 0) goto L_0x002b;
    L_0x0029:
        r8 = 1;
        goto L_0x002c;
    L_0x002b:
        r8 = 0;
    L_0x002c:
        r6 = r2.mHorizontalChainStyle;
        if (r6 != r7) goto L_0x0032;
    L_0x0030:
        r6 = 1;
        goto L_0x0033;
    L_0x0032:
        r6 = 0;
    L_0x0033:
        r7 = r2.mHorizontalChainStyle;
        if (r7 != r5) goto L_0x0039;
    L_0x0037:
        r5 = 1;
        goto L_0x003a;
    L_0x0039:
        r5 = 0;
    L_0x003a:
        r7 = r5;
        r18 = r6;
        r17 = r8;
        r6 = r11;
        r5 = 0;
        goto L_0x0056;
    L_0x0042:
        r6 = r2.mVerticalChainStyle;
        if (r6 != 0) goto L_0x0048;
    L_0x0046:
        r8 = 1;
        goto L_0x0049;
    L_0x0048:
        r8 = 0;
    L_0x0049:
        r6 = r2.mVerticalChainStyle;
        r7 = 1;
        if (r6 != r7) goto L_0x0050;
    L_0x004e:
        r6 = 1;
        goto L_0x0051;
    L_0x0050:
        r6 = 0;
    L_0x0051:
        r7 = r2.mVerticalChainStyle;
        if (r7 != r5) goto L_0x0039;
    L_0x0055:
        goto L_0x0037;
    L_0x0056:
        r22 = 0;
        if (r5 != 0) goto L_0x0135;
    L_0x005a:
        r8 = r6.mListAnchors;
        r8 = r8[r49];
        if (r4 != 0) goto L_0x0066;
    L_0x0060:
        if (r7 == 0) goto L_0x0063;
    L_0x0062:
        goto L_0x0066;
    L_0x0063:
        r23 = 4;
        goto L_0x0068;
    L_0x0066:
        r23 = 1;
    L_0x0068:
        r24 = r8.getMargin();
        r25 = r3;
        r3 = r8.mTarget;
        if (r3 == 0) goto L_0x007c;
    L_0x0072:
        if (r6 == r11) goto L_0x007c;
    L_0x0074:
        r3 = r8.mTarget;
        r3 = r3.getMargin();
        r24 = r24 + r3;
    L_0x007c:
        r3 = r24;
        if (r7 == 0) goto L_0x008a;
    L_0x0080:
        if (r6 == r11) goto L_0x008a;
    L_0x0082:
        if (r6 == r13) goto L_0x008a;
    L_0x0084:
        r27 = r2;
        r26 = r5;
        r5 = 6;
        goto L_0x009a;
    L_0x008a:
        if (r17 == 0) goto L_0x0094;
    L_0x008c:
        if (r4 == 0) goto L_0x0094;
    L_0x008e:
        r27 = r2;
        r26 = r5;
        r5 = 4;
        goto L_0x009a;
    L_0x0094:
        r27 = r2;
        r26 = r5;
        r5 = r23;
    L_0x009a:
        r2 = r8.mTarget;
        if (r2 == 0) goto L_0x00c7;
    L_0x009e:
        if (r6 != r13) goto L_0x00af;
    L_0x00a0:
        r2 = r8.mSolverVariable;
        r28 = r11;
        r11 = r8.mTarget;
        r11 = r11.mSolverVariable;
        r29 = r7;
        r7 = 5;
        r9.addGreaterThan(r2, r11, r3, r7);
        goto L_0x00bd;
    L_0x00af:
        r29 = r7;
        r28 = r11;
        r2 = r8.mSolverVariable;
        r7 = r8.mTarget;
        r7 = r7.mSolverVariable;
        r11 = 6;
        r9.addGreaterThan(r2, r7, r3, r11);
    L_0x00bd:
        r2 = r8.mSolverVariable;
        r7 = r8.mTarget;
        r7 = r7.mSolverVariable;
        r9.addEquality(r2, r7, r3, r5);
        goto L_0x00cb;
    L_0x00c7:
        r29 = r7;
        r28 = r11;
    L_0x00cb:
        if (r4 == 0) goto L_0x0102;
    L_0x00cd:
        r2 = r6.getVisibility();
        r3 = 8;
        if (r2 == r3) goto L_0x00f1;
    L_0x00d5:
        r2 = r6.mListDimensionBehaviors;
        r2 = r2[r48];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r2 != r3) goto L_0x00f1;
    L_0x00dd:
        r2 = r6.mListAnchors;
        r3 = r49 + 1;
        r2 = r2[r3];
        r2 = r2.mSolverVariable;
        r3 = r6.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mSolverVariable;
        r5 = 0;
        r7 = 5;
        r9.addGreaterThan(r2, r3, r5, r7);
        goto L_0x00f2;
    L_0x00f1:
        r5 = 0;
    L_0x00f2:
        r2 = r6.mListAnchors;
        r2 = r2[r49];
        r2 = r2.mSolverVariable;
        r3 = r0.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mSolverVariable;
        r7 = 6;
        r9.addGreaterThan(r2, r3, r5, r7);
    L_0x0102:
        r2 = r6.mListAnchors;
        r3 = r49 + 1;
        r2 = r2[r3];
        r2 = r2.mTarget;
        if (r2 == 0) goto L_0x0123;
    L_0x010c:
        r2 = r2.mOwner;
        r3 = r2.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mTarget;
        if (r3 == 0) goto L_0x0123;
    L_0x0116:
        r3 = r2.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mTarget;
        r3 = r3.mOwner;
        if (r3 == r6) goto L_0x0121;
    L_0x0120:
        goto L_0x0123;
    L_0x0121:
        r22 = r2;
    L_0x0123:
        if (r22 == 0) goto L_0x012a;
    L_0x0125:
        r6 = r22;
        r5 = r26;
        goto L_0x012b;
    L_0x012a:
        r5 = 1;
    L_0x012b:
        r3 = r25;
        r2 = r27;
        r11 = r28;
        r7 = r29;
        goto L_0x0056;
    L_0x0135:
        r27 = r2;
        r25 = r3;
        r29 = r7;
        r28 = r11;
        if (r14 == 0) goto L_0x0161;
    L_0x013f:
        r2 = r12.mListAnchors;
        r3 = r49 + 1;
        r2 = r2[r3];
        r2 = r2.mTarget;
        if (r2 == 0) goto L_0x0161;
    L_0x0149:
        r2 = r14.mListAnchors;
        r2 = r2[r3];
        r5 = r2.mSolverVariable;
        r6 = r12.mListAnchors;
        r3 = r6[r3];
        r3 = r3.mTarget;
        r3 = r3.mSolverVariable;
        r2 = r2.getMargin();
        r2 = -r2;
        r8 = 5;
        r9.addLowerThan(r5, r3, r2, r8);
        goto L_0x0162;
    L_0x0161:
        r8 = 5;
    L_0x0162:
        if (r4 == 0) goto L_0x017e;
    L_0x0164:
        r0 = r0.mListAnchors;
        r2 = r49 + 1;
        r0 = r0[r2];
        r0 = r0.mSolverVariable;
        r3 = r12.mListAnchors;
        r3 = r3[r2];
        r3 = r3.mSolverVariable;
        r4 = r12.mListAnchors;
        r2 = r4[r2];
        r2 = r2.getMargin();
        r4 = 6;
        r9.addGreaterThan(r0, r3, r2, r4);
    L_0x017e:
        r0 = r1.mWeightedMatchConstraintsWidgets;
        if (r0 == 0) goto L_0x022e;
    L_0x0182:
        r2 = r0.size();
        r7 = 1;
        if (r2 <= r7) goto L_0x022e;
    L_0x0189:
        r3 = r1.mHasUndefinedWeights;
        if (r3 == 0) goto L_0x0196;
    L_0x018d:
        r3 = r1.mHasComplexMatchWeights;
        if (r3 != 0) goto L_0x0196;
    L_0x0191:
        r3 = r1.mWidgetsMatchCount;
        r3 = (float) r3;
        r25 = r3;
    L_0x0196:
        r3 = 0;
        r5 = r22;
        r4 = 0;
        r31 = 0;
    L_0x019c:
        if (r4 >= r2) goto L_0x022e;
    L_0x019e:
        r6 = r0.get(r4);
        r6 = (android.support.constraint.solver.widgets.ConstraintWidget) r6;
        r11 = r6.mWeight;
        r11 = r11[r48];
        r16 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1));
        if (r16 >= 0) goto L_0x01cc;
    L_0x01ac:
        r11 = r1.mHasComplexMatchWeights;
        if (r11 == 0) goto L_0x01c6;
    L_0x01b0:
        r11 = r6.mListAnchors;
        r16 = r49 + 1;
        r11 = r11[r16];
        r11 = r11.mSolverVariable;
        r6 = r6.mListAnchors;
        r6 = r6[r49];
        r6 = r6.mSolverVariable;
        r7 = 0;
        r8 = 4;
        r9.addEquality(r11, r6, r7, r8);
        r8 = 6;
        r11 = 0;
        goto L_0x01e4;
    L_0x01c6:
        r8 = 4;
        r7 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r11 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        goto L_0x01cd;
    L_0x01cc:
        r8 = 4;
    L_0x01cd:
        r7 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1));
        if (r7 != 0) goto L_0x01e7;
    L_0x01d1:
        r7 = r6.mListAnchors;
        r11 = r49 + 1;
        r7 = r7[r11];
        r7 = r7.mSolverVariable;
        r6 = r6.mListAnchors;
        r6 = r6[r49];
        r6 = r6.mSolverVariable;
        r8 = 6;
        r11 = 0;
        r9.addEquality(r7, r6, r11, r8);
    L_0x01e4:
        r39 = r0;
        goto L_0x0225;
    L_0x01e7:
        r7 = 0;
        r8 = 6;
        if (r5 == 0) goto L_0x0220;
    L_0x01eb:
        r3 = r5.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mSolverVariable;
        r5 = r5.mListAnchors;
        r15 = r49 + 1;
        r5 = r5[r15];
        r5 = r5.mSolverVariable;
        r7 = r6.mListAnchors;
        r7 = r7[r49];
        r7 = r7.mSolverVariable;
        r8 = r6.mListAnchors;
        r8 = r8[r15];
        r8 = r8.mSolverVariable;
        r39 = r0;
        r0 = r47.createRow();
        r30 = r0;
        r32 = r25;
        r33 = r11;
        r34 = r3;
        r35 = r5;
        r36 = r7;
        r37 = r8;
        r30.createRowEqualMatchDimensions(r31, r32, r33, r34, r35, r36, r37);
        r9.addConstraint(r0);
        goto L_0x0222;
    L_0x0220:
        r39 = r0;
    L_0x0222:
        r5 = r6;
        r31 = r11;
    L_0x0225:
        r4 = r4 + 1;
        r0 = r39;
        r3 = 0;
        r7 = 1;
        r8 = 5;
        goto L_0x019c;
    L_0x022e:
        if (r13 == 0) goto L_0x029a;
    L_0x0230:
        if (r13 == r14) goto L_0x0234;
    L_0x0232:
        if (r29 == 0) goto L_0x029a;
    L_0x0234:
        r11 = r28;
        r0 = r11.mListAnchors;
        r0 = r0[r49];
        r1 = r12.mListAnchors;
        r2 = r49 + 1;
        r1 = r1[r2];
        r3 = r11.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mTarget;
        if (r3 == 0) goto L_0x0251;
    L_0x0248:
        r3 = r11.mListAnchors;
        r3 = r3[r49];
        r3 = r3.mTarget;
        r3 = r3.mSolverVariable;
        goto L_0x0253;
    L_0x0251:
        r3 = r22;
    L_0x0253:
        r4 = r12.mListAnchors;
        r4 = r4[r2];
        r4 = r4.mTarget;
        if (r4 == 0) goto L_0x0265;
    L_0x025b:
        r4 = r12.mListAnchors;
        r4 = r4[r2];
        r4 = r4.mTarget;
        r4 = r4.mSolverVariable;
        r5 = r4;
        goto L_0x0267;
    L_0x0265:
        r5 = r22;
    L_0x0267:
        if (r13 != r14) goto L_0x0271;
    L_0x0269:
        r0 = r13.mListAnchors;
        r0 = r0[r49];
        r1 = r13.mListAnchors;
        r1 = r1[r2];
    L_0x0271:
        if (r3 == 0) goto L_0x04f9;
    L_0x0273:
        if (r5 == 0) goto L_0x04f9;
    L_0x0275:
        if (r48 != 0) goto L_0x027d;
    L_0x0277:
        r2 = r27;
        r2 = r2.mHorizontalBiasPercent;
    L_0x027b:
        r4 = r2;
        goto L_0x0282;
    L_0x027d:
        r2 = r27;
        r2 = r2.mVerticalBiasPercent;
        goto L_0x027b;
    L_0x0282:
        r6 = r0.getMargin();
        r7 = r1.getMargin();
        r2 = r0.mSolverVariable;
        r8 = r1.mSolverVariable;
        r10 = 5;
        r0 = r9;
        r1 = r2;
        r2 = r3;
        r3 = r6;
        r6 = r8;
        r8 = r10;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x04f9;
    L_0x029a:
        r11 = r28;
        if (r17 == 0) goto L_0x03c4;
    L_0x029e:
        if (r13 == 0) goto L_0x03c4;
    L_0x02a0:
        r0 = r1.mWidgetsMatchCount;
        if (r0 <= 0) goto L_0x02ad;
    L_0x02a4:
        r0 = r1.mWidgetsCount;
        r1 = r1.mWidgetsMatchCount;
        if (r0 != r1) goto L_0x02ad;
    L_0x02aa:
        r38 = 1;
        goto L_0x02af;
    L_0x02ad:
        r38 = 0;
    L_0x02af:
        r7 = r13;
        r8 = r7;
    L_0x02b1:
        if (r8 == 0) goto L_0x04f9;
    L_0x02b3:
        r0 = r8.mNextChainWidget;
        r0 = r0[r48];
        r6 = r0;
    L_0x02b8:
        if (r6 == 0) goto L_0x02c7;
    L_0x02ba:
        r0 = r6.getVisibility();
        r5 = 8;
        if (r0 != r5) goto L_0x02c9;
    L_0x02c2:
        r0 = r6.mNextChainWidget;
        r6 = r0[r48];
        goto L_0x02b8;
    L_0x02c7:
        r5 = 8;
    L_0x02c9:
        if (r6 != 0) goto L_0x02de;
    L_0x02cb:
        if (r8 != r14) goto L_0x02ce;
    L_0x02cd:
        goto L_0x02de;
    L_0x02ce:
        r21 = r6;
        r15 = r7;
        r44 = r11;
        r43 = r12;
    L_0x02d5:
        r11 = 8;
        r16 = 6;
        r20 = 4;
        r12 = r8;
        goto L_0x03b3;
    L_0x02de:
        r0 = r8.mListAnchors;
        r0 = r0[r49];
        r1 = r0.mSolverVariable;
        r2 = r0.mTarget;
        if (r2 == 0) goto L_0x02ed;
    L_0x02e8:
        r2 = r0.mTarget;
        r2 = r2.mSolverVariable;
        goto L_0x02ef;
    L_0x02ed:
        r2 = r22;
    L_0x02ef:
        if (r7 == r8) goto L_0x02fa;
    L_0x02f1:
        r2 = r7.mListAnchors;
        r3 = r49 + 1;
        r2 = r2[r3];
        r2 = r2.mSolverVariable;
        goto L_0x0311;
    L_0x02fa:
        if (r8 != r13) goto L_0x0311;
    L_0x02fc:
        if (r7 != r8) goto L_0x0311;
    L_0x02fe:
        r2 = r11.mListAnchors;
        r2 = r2[r49];
        r2 = r2.mTarget;
        if (r2 == 0) goto L_0x030f;
    L_0x0306:
        r2 = r11.mListAnchors;
        r2 = r2[r49];
        r2 = r2.mTarget;
        r2 = r2.mSolverVariable;
        goto L_0x0311;
    L_0x030f:
        r2 = r22;
    L_0x0311:
        r0 = r0.getMargin();
        r3 = r8.mListAnchors;
        r4 = r49 + 1;
        r3 = r3[r4];
        r3 = r3.getMargin();
        if (r6 == 0) goto L_0x0335;
    L_0x0321:
        r5 = r6.mListAnchors;
        r5 = r5[r49];
        r40 = r6;
        r6 = r5.mSolverVariable;
        r41 = r5;
        r5 = r8.mListAnchors;
        r5 = r5[r4];
        r5 = r5.mSolverVariable;
        r15 = r5;
        r5 = r41;
        goto L_0x0351;
    L_0x0335:
        r40 = r6;
        r5 = r12.mListAnchors;
        r5 = r5[r4];
        r5 = r5.mTarget;
        if (r5 == 0) goto L_0x0344;
    L_0x033f:
        r6 = r5.mSolverVariable;
        r42 = r5;
        goto L_0x0348;
    L_0x0344:
        r42 = r5;
        r6 = r22;
    L_0x0348:
        r5 = r8.mListAnchors;
        r5 = r5[r4];
        r5 = r5.mSolverVariable;
        r15 = r5;
        r5 = r42;
    L_0x0351:
        if (r5 == 0) goto L_0x0358;
    L_0x0353:
        r5 = r5.getMargin();
        r3 = r3 + r5;
    L_0x0358:
        if (r7 == 0) goto L_0x0363;
    L_0x035a:
        r5 = r7.mListAnchors;
        r5 = r5[r4];
        r5 = r5.getMargin();
        r0 = r0 + r5;
    L_0x0363:
        if (r1 == 0) goto L_0x03aa;
    L_0x0365:
        if (r2 == 0) goto L_0x03aa;
    L_0x0367:
        if (r6 == 0) goto L_0x03aa;
    L_0x0369:
        if (r15 == 0) goto L_0x03aa;
    L_0x036b:
        if (r8 != r13) goto L_0x0375;
    L_0x036d:
        r0 = r13.mListAnchors;
        r0 = r0[r49];
        r0 = r0.getMargin();
    L_0x0375:
        r5 = r0;
        if (r8 != r14) goto L_0x0383;
    L_0x0378:
        r0 = r14.mListAnchors;
        r0 = r0[r4];
        r0 = r0.getMargin();
        r16 = r0;
        goto L_0x0385;
    L_0x0383:
        r16 = r3;
    L_0x0385:
        if (r38 == 0) goto L_0x038a;
    L_0x0387:
        r19 = 6;
        goto L_0x038c;
    L_0x038a:
        r19 = 4;
    L_0x038c:
        r4 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0 = r9;
        r3 = r5;
        r20 = 8;
        r5 = r6;
        r21 = r40;
        r6 = r15;
        r15 = r7;
        r7 = r16;
        r44 = r11;
        r43 = r12;
        r11 = 8;
        r16 = 6;
        r20 = 4;
        r12 = r8;
        r8 = r19;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x03b3;
    L_0x03aa:
        r15 = r7;
        r44 = r11;
        r43 = r12;
        r21 = r40;
        goto L_0x02d5;
    L_0x03b3:
        r0 = r12.getVisibility();
        if (r0 == r11) goto L_0x03bb;
    L_0x03b9:
        r7 = r12;
        goto L_0x03bc;
    L_0x03bb:
        r7 = r15;
    L_0x03bc:
        r8 = r21;
        r12 = r43;
        r11 = r44;
        goto L_0x02b1;
    L_0x03c4:
        r44 = r11;
        r43 = r12;
        r11 = 8;
        r16 = 6;
        r20 = 4;
        if (r18 == 0) goto L_0x04f7;
    L_0x03d0:
        if (r13 == 0) goto L_0x04f7;
    L_0x03d2:
        r0 = r1.mWidgetsMatchCount;
        if (r0 <= 0) goto L_0x03df;
    L_0x03d6:
        r0 = r1.mWidgetsCount;
        r1 = r1.mWidgetsMatchCount;
        if (r0 != r1) goto L_0x03df;
    L_0x03dc:
        r38 = 1;
        goto L_0x03e1;
    L_0x03df:
        r38 = 0;
    L_0x03e1:
        r8 = r13;
        r12 = r8;
    L_0x03e3:
        if (r12 == 0) goto L_0x0494;
    L_0x03e5:
        r0 = r12.mNextChainWidget;
        r0 = r0[r48];
    L_0x03e9:
        if (r0 == 0) goto L_0x03f6;
    L_0x03eb:
        r1 = r0.getVisibility();
        if (r1 != r11) goto L_0x03f6;
    L_0x03f1:
        r0 = r0.mNextChainWidget;
        r0 = r0[r48];
        goto L_0x03e9;
    L_0x03f6:
        if (r12 == r13) goto L_0x0481;
    L_0x03f8:
        if (r12 == r14) goto L_0x0481;
    L_0x03fa:
        if (r0 == 0) goto L_0x0481;
    L_0x03fc:
        if (r0 != r14) goto L_0x0401;
    L_0x03fe:
        r7 = r22;
        goto L_0x0402;
    L_0x0401:
        r7 = r0;
    L_0x0402:
        r0 = r12.mListAnchors;
        r0 = r0[r49];
        r1 = r0.mSolverVariable;
        r2 = r0.mTarget;
        if (r2 == 0) goto L_0x0410;
    L_0x040c:
        r2 = r0.mTarget;
        r2 = r2.mSolverVariable;
    L_0x0410:
        r2 = r8.mListAnchors;
        r3 = r49 + 1;
        r2 = r2[r3];
        r2 = r2.mSolverVariable;
        r0 = r0.getMargin();
        r4 = r12.mListAnchors;
        r4 = r4[r3];
        r4 = r4.getMargin();
        if (r7 == 0) goto L_0x0438;
    L_0x0426:
        r5 = r7.mListAnchors;
        r5 = r5[r49];
        r6 = r5.mSolverVariable;
        r11 = r5.mTarget;
        if (r11 == 0) goto L_0x0435;
    L_0x0430:
        r11 = r5.mTarget;
        r11 = r11.mSolverVariable;
        goto L_0x044b;
    L_0x0435:
        r11 = r22;
        goto L_0x044b;
    L_0x0438:
        r5 = r12.mListAnchors;
        r5 = r5[r3];
        r5 = r5.mTarget;
        if (r5 == 0) goto L_0x0443;
    L_0x0440:
        r6 = r5.mSolverVariable;
        goto L_0x0445;
    L_0x0443:
        r6 = r22;
    L_0x0445:
        r11 = r12.mListAnchors;
        r11 = r11[r3];
        r11 = r11.mSolverVariable;
    L_0x044b:
        if (r5 == 0) goto L_0x0452;
    L_0x044d:
        r5 = r5.getMargin();
        r4 = r4 + r5;
    L_0x0452:
        r15 = r4;
        if (r8 == 0) goto L_0x045e;
    L_0x0455:
        r4 = r8.mListAnchors;
        r3 = r4[r3];
        r3 = r3.getMargin();
        r0 = r0 + r3;
    L_0x045e:
        r3 = r0;
        if (r38 == 0) goto L_0x0464;
    L_0x0461:
        r19 = 6;
        goto L_0x0466;
    L_0x0464:
        r19 = 4;
    L_0x0466:
        if (r1 == 0) goto L_0x047d;
    L_0x0468:
        if (r2 == 0) goto L_0x047d;
    L_0x046a:
        if (r6 == 0) goto L_0x047d;
    L_0x046c:
        if (r11 == 0) goto L_0x047d;
    L_0x046e:
        r4 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0 = r9;
        r5 = r6;
        r6 = r11;
        r11 = r7;
        r7 = r15;
        r15 = r8;
        r10 = 5;
        r8 = r19;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x0484;
    L_0x047d:
        r11 = r7;
        r15 = r8;
        r10 = 5;
        goto L_0x0484;
    L_0x0481:
        r15 = r8;
        r10 = 5;
        r11 = r0;
    L_0x0484:
        r0 = r12.getVisibility();
        r1 = 8;
        if (r0 == r1) goto L_0x048e;
    L_0x048c:
        r8 = r12;
        goto L_0x048f;
    L_0x048e:
        r8 = r15;
    L_0x048f:
        r12 = r11;
        r11 = 8;
        goto L_0x03e3;
    L_0x0494:
        r10 = 5;
        r0 = r13.mListAnchors;
        r0 = r0[r49];
        r1 = r44;
        r1 = r1.mListAnchors;
        r1 = r1[r49];
        r1 = r1.mTarget;
        r2 = r14.mListAnchors;
        r3 = r49 + 1;
        r11 = r2[r3];
        r12 = r43;
        r2 = r12.mListAnchors;
        r2 = r2[r3];
        r8 = r2.mTarget;
        if (r1 == 0) goto L_0x04e4;
    L_0x04b1:
        if (r13 == r14) goto L_0x04bf;
    L_0x04b3:
        r2 = r0.mSolverVariable;
        r1 = r1.mSolverVariable;
        r0 = r0.getMargin();
        r9.addEquality(r2, r1, r0, r10);
        goto L_0x04e4;
    L_0x04bf:
        if (r8 == 0) goto L_0x04e4;
    L_0x04c1:
        r2 = r0.mSolverVariable;
        r3 = r1.mSolverVariable;
        r4 = r0.getMargin();
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r6 = r11.mSolverVariable;
        r7 = r8.mSolverVariable;
        r15 = r11.getMargin();
        r16 = 5;
        r0 = r9;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r15;
        r10 = r8;
        r8 = r16;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x04e5;
    L_0x04e4:
        r10 = r8;
    L_0x04e5:
        if (r10 == 0) goto L_0x04f9;
    L_0x04e7:
        if (r13 == r14) goto L_0x04f9;
    L_0x04e9:
        r0 = r11.mSolverVariable;
        r1 = r10.mSolverVariable;
        r2 = r11.getMargin();
        r2 = -r2;
        r3 = 5;
        r9.addEquality(r0, r1, r2, r3);
        goto L_0x04f9;
    L_0x04f7:
        r12 = r43;
    L_0x04f9:
        if (r17 != 0) goto L_0x04fd;
    L_0x04fb:
        if (r18 == 0) goto L_0x055f;
    L_0x04fd:
        if (r13 == 0) goto L_0x055f;
    L_0x04ff:
        r0 = r13.mListAnchors;
        r0 = r0[r49];
        r1 = r14.mListAnchors;
        r2 = r49 + 1;
        r1 = r1[r2];
        r3 = r0.mTarget;
        if (r3 == 0) goto L_0x0512;
    L_0x050d:
        r3 = r0.mTarget;
        r3 = r3.mSolverVariable;
        goto L_0x0514;
    L_0x0512:
        r3 = r22;
    L_0x0514:
        r4 = r1.mTarget;
        if (r4 == 0) goto L_0x051d;
    L_0x0518:
        r4 = r1.mTarget;
        r4 = r4.mSolverVariable;
        goto L_0x051f;
    L_0x051d:
        r4 = r22;
    L_0x051f:
        if (r12 == r14) goto L_0x0530;
    L_0x0521:
        r4 = r12.mListAnchors;
        r4 = r4[r2];
        r5 = r4.mTarget;
        if (r5 == 0) goto L_0x052e;
    L_0x0529:
        r4 = r4.mTarget;
        r4 = r4.mSolverVariable;
        goto L_0x0530;
    L_0x052e:
        r4 = r22;
    L_0x0530:
        r5 = r4;
        if (r13 != r14) goto L_0x053b;
    L_0x0533:
        r0 = r13.mListAnchors;
        r0 = r0[r49];
        r1 = r13.mListAnchors;
        r1 = r1[r2];
    L_0x053b:
        if (r3 == 0) goto L_0x055f;
    L_0x053d:
        if (r5 == 0) goto L_0x055f;
    L_0x053f:
        r4 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r6 = r0.getMargin();
        if (r14 != 0) goto L_0x0548;
    L_0x0547:
        goto L_0x0549;
    L_0x0548:
        r12 = r14;
    L_0x0549:
        r7 = r12.mListAnchors;
        r2 = r7[r2];
        r7 = r2.getMargin();
        r2 = r0.mSolverVariable;
        r8 = r1.mSolverVariable;
        r10 = 5;
        r0 = r9;
        r1 = r2;
        r2 = r3;
        r3 = r6;
        r6 = r8;
        r8 = r10;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x055f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
