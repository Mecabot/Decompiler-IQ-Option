package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() {
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal();
    private ArrayList<Animator> mAnimators = new ArrayList();
    boolean mCanRemoveViews = false;
    private ArrayList<Animator> mCurrentAnimators = new ArrayList();
    long mDuration = -1;
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class> mTargetTypeChildExcludes = null;
    private ArrayList<Class> mTargetTypeExcludes = null;
    private ArrayList<Class> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList();

    private static class AnimationInfo {
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowIdImpl mWindowId;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.mView = view;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowIdImpl;
            this.mTransition = transition;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            return arrayList.isEmpty() ? null : arrayList;
        }
    }

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Object obj = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                obj[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                obj[i] = 1;
            } else if (MATCH_NAME_STR.equalsIgnoreCase(trim)) {
                obj[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                obj[i] = 4;
            } else if (trim.isEmpty()) {
                Object obj2 = new int[(obj.length - 1)];
                System.arraycopy(obj, 0, obj2, 0, i);
                i--;
                obj = obj2;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown match type in matchOrder: '");
                stringBuilder.append(trim);
                stringBuilder.append("'");
                throw new InflateException(stringBuilder.toString());
            }
            i++;
        }
        return obj;
    }

    @NonNull
    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    @NonNull
    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (alreadyContains(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            } else {
                i++;
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View view = (View) arrayMap.keyAt(size);
            if (view != null && isValidTarget(view)) {
                TransitionValues transitionValues = (TransitionValues) arrayMap2.remove(view);
                if (!(transitionValues == null || transitionValues.view == null || !isValidTarget(transitionValues.view))) {
                    this.mStartValuesList.add((TransitionValues) arrayMap.removeAt(size));
                    this.mEndValuesList.add(transitionValues);
                }
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) longSparseArray.valueAt(i);
            if (view != null && isValidTarget(view)) {
                View view2 = (View) longSparseArray2.get(longSparseArray.keyAt(i));
                if (view2 != null && isValidTarget(view2)) {
                    TransitionValues transitionValues = (TransitionValues) arrayMap.get(view);
                    TransitionValues transitionValues2 = (TransitionValues) arrayMap2.get(view2);
                    if (!(transitionValues == null || transitionValues2 == null)) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(view);
                        arrayMap2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null && isValidTarget(view)) {
                View view2 = (View) sparseArray2.get(sparseArray.keyAt(i));
                if (view2 != null && isValidTarget(view2)) {
                    TransitionValues transitionValues = (TransitionValues) arrayMap.get(view);
                    TransitionValues transitionValues2 = (TransitionValues) arrayMap2.get(view2);
                    if (!(transitionValues == null || transitionValues2 == null)) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(view);
                        arrayMap2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayMap3.valueAt(i);
            if (view != null && isValidTarget(view)) {
                View view2 = (View) arrayMap4.get(arrayMap3.keyAt(i));
                if (view2 != null && isValidTarget(view2)) {
                    TransitionValues transitionValues = (TransitionValues) arrayMap.get(view);
                    TransitionValues transitionValues2 = (TransitionValues) arrayMap2.get(view2);
                    if (!(transitionValues == null || transitionValues2 == null)) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(view);
                        arrayMap2.remove(view2);
                    }
                }
            }
        }
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            TransitionValues transitionValues = (TransitionValues) arrayMap.valueAt(i);
            if (isValidTarget(transitionValues.view)) {
                this.mStartValuesList.add(transitionValues);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            TransitionValues transitionValues2 = (TransitionValues) arrayMap2.valueAt(i2);
            if (isValidTarget(transitionValues2.view)) {
                this.mEndValuesList.add(transitionValues2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap(transitionValuesMaps.mViewValues);
        ArrayMap arrayMap2 = new ArrayMap(transitionValuesMaps2.mViewValues);
        for (int i : this.mMatchOrder) {
            switch (i) {
                case 1:
                    matchInstances(arrayMap, arrayMap2);
                    break;
                case 2:
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.mNameValues, transitionValuesMaps2.mNameValues);
                    break;
                case 3:
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.mIdValues, transitionValuesMaps2.mIdValues);
                    break;
                case 4:
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.mItemIdValues, transitionValuesMaps2.mItemIdValues);
                    break;
                default:
                    break;
            }
        }
        addUnmatched(arrayMap, arrayMap2);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i = 0;
        while (i < size) {
            int i2;
            int i3;
            TransitionValues transitionValues = (TransitionValues) arrayList.get(i);
            TransitionValues transitionValues2 = (TransitionValues) arrayList2.get(i);
            if (!(transitionValues == null || transitionValues.mTargetedTransitions.contains(this))) {
                transitionValues = null;
            }
            if (!(transitionValues2 == null || transitionValues2.mTargetedTransitions.contains(this))) {
                transitionValues2 = null;
            }
            if (!(transitionValues == null && transitionValues2 == null)) {
                Object obj = (transitionValues == null || transitionValues2 == null || isTransitionRequired(transitionValues, transitionValues2)) ? 1 : null;
                if (obj != null) {
                    Animator createAnimator = createAnimator(viewGroup2, transitionValues, transitionValues2);
                    if (createAnimator != null) {
                        View view;
                        TransitionValues transitionValues3;
                        Object obj2;
                        Animator animator;
                        if (transitionValues2 != null) {
                            TransitionValues transitionValues4;
                            view = transitionValues2.view;
                            String[] transitionProperties = getTransitionProperties();
                            if (view == null || transitionProperties == null || transitionProperties.length <= 0) {
                                i2 = size;
                                i3 = i;
                                createAnimator = createAnimator;
                                transitionValues4 = null;
                            } else {
                                transitionValues4 = new TransitionValues();
                                transitionValues4.view = view;
                                animator = createAnimator;
                                i2 = size;
                                transitionValues3 = (TransitionValues) transitionValuesMaps2.mViewValues.get(view);
                                if (transitionValues3 != null) {
                                    size = 0;
                                    while (size < transitionProperties.length) {
                                        i3 = i;
                                        TransitionValues transitionValues5 = transitionValues3;
                                        transitionValues4.values.put(transitionProperties[size], transitionValues3.values.get(transitionProperties[size]));
                                        size++;
                                        i = i3;
                                        transitionValues3 = transitionValues5;
                                        ArrayList<TransitionValues> arrayList3 = arrayList2;
                                    }
                                }
                                i3 = i;
                                int size2 = runningAnimators.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get((Animator) runningAnimators.keyAt(i4));
                                    if (animationInfo.mValues != null && animationInfo.mView == view && animationInfo.mName.equals(getName()) && animationInfo.mValues.equals(transitionValues4)) {
                                        createAnimator = null;
                                        break;
                                    }
                                }
                                createAnimator = animator;
                            }
                            obj2 = createAnimator;
                            transitionValues3 = transitionValues4;
                        } else {
                            animator = createAnimator;
                            i2 = size;
                            i3 = i;
                            view = transitionValues.view;
                            obj2 = animator;
                            transitionValues3 = null;
                        }
                        if (obj2 != null) {
                            if (this.mPropagation != null) {
                                long startDelay = this.mPropagation.getStartDelay(viewGroup2, this, transitionValues, transitionValues2);
                                sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                                j = Math.min(startDelay, j);
                            }
                            long j2 = j;
                            runningAnimators.put(obj2, new AnimationInfo(view, getName(), this, ViewUtils.getWindowId(viewGroup), transitionValues3));
                            this.mAnimators.add(obj2);
                            j = j2;
                        }
                        i = i3 + 1;
                        size = i2;
                    }
                }
            }
            i2 = size;
            i3 = i;
            i = i3 + 1;
            size = i2;
        }
        if (j != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator2 = (Animator) this.mAnimators.get(sparseIntArray.keyAt(i5));
                animator2.setStartDelay((((long) sparseIntArray.valueAt(i5)) - j) + animator2.getStartDelay());
            }
        }
    }

    /* JADX WARNING: Missing block: B:37:0x0082, code:
            return true;
     */
    boolean isValidTarget(android.view.View r6) {
        /*
        r5 = this;
        r0 = r6.getId();
        r1 = r5.mTargetIdExcludes;
        r2 = 0;
        if (r1 == 0) goto L_0x0016;
    L_0x0009:
        r1 = r5.mTargetIdExcludes;
        r3 = java.lang.Integer.valueOf(r0);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r5.mTargetExcludes;
        if (r1 == 0) goto L_0x0023;
    L_0x001a:
        r1 = r5.mTargetExcludes;
        r1 = r1.contains(r6);
        if (r1 == 0) goto L_0x0023;
    L_0x0022:
        return r2;
    L_0x0023:
        r1 = r5.mTargetTypeExcludes;
        if (r1 == 0) goto L_0x0042;
    L_0x0027:
        r1 = r5.mTargetTypeExcludes;
        r1 = r1.size();
        r3 = 0;
    L_0x002e:
        if (r3 >= r1) goto L_0x0042;
    L_0x0030:
        r4 = r5.mTargetTypeExcludes;
        r4 = r4.get(r3);
        r4 = (java.lang.Class) r4;
        r4 = r4.isInstance(r6);
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        return r2;
    L_0x003f:
        r3 = r3 + 1;
        goto L_0x002e;
    L_0x0042:
        r1 = r5.mTargetNameExcludes;
        if (r1 == 0) goto L_0x0059;
    L_0x0046:
        r1 = android.support.v4.view.ViewCompat.getTransitionName(r6);
        if (r1 == 0) goto L_0x0059;
    L_0x004c:
        r1 = r5.mTargetNameExcludes;
        r3 = android.support.v4.view.ViewCompat.getTransitionName(r6);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0059;
    L_0x0058:
        return r2;
    L_0x0059:
        r1 = r5.mTargetIds;
        r1 = r1.size();
        r3 = 1;
        if (r1 != 0) goto L_0x0083;
    L_0x0062:
        r1 = r5.mTargets;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0083;
    L_0x006a:
        r1 = r5.mTargetTypes;
        if (r1 == 0) goto L_0x0076;
    L_0x006e:
        r1 = r5.mTargetTypes;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0076:
        r1 = r5.mTargetNames;
        if (r1 == 0) goto L_0x0082;
    L_0x007a:
        r1 = r5.mTargetNames;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0082:
        return r3;
    L_0x0083:
        r1 = r5.mTargetIds;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r1.contains(r0);
        if (r0 != 0) goto L_0x00c9;
    L_0x008f:
        r0 = r5.mTargets;
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x0098;
    L_0x0097:
        goto L_0x00c9;
    L_0x0098:
        r0 = r5.mTargetNames;
        if (r0 == 0) goto L_0x00a9;
    L_0x009c:
        r0 = r5.mTargetNames;
        r1 = android.support.v4.view.ViewCompat.getTransitionName(r6);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x00a9;
    L_0x00a8:
        return r3;
    L_0x00a9:
        r0 = r5.mTargetTypes;
        if (r0 == 0) goto L_0x00c8;
    L_0x00ad:
        r0 = 0;
    L_0x00ae:
        r1 = r5.mTargetTypes;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00c8;
    L_0x00b6:
        r1 = r5.mTargetTypes;
        r1 = r1.get(r0);
        r1 = (java.lang.Class) r1;
        r1 = r1.isInstance(r6);
        if (r1 == 0) goto L_0x00c5;
    L_0x00c4:
        return r3;
    L_0x00c5:
        r0 = r0 + 1;
        goto L_0x00ae;
    L_0x00c8:
        return r2;
    L_0x00c9:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Transition.isValidTarget(android.view.View):boolean");
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = (ArrayMap) sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        arrayMap = new ArrayMap();
        sRunningAnimators.set(arrayMap);
        return arrayMap;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void runAnimators() {
        start();
        ArrayMap runningAnimators = getRunningAnimators();
        Iterator it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (runningAnimators.containsKey(animator)) {
                start();
                runAnimator(animator, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    Transition.this.mCurrentAnimators.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    Transition.this.mCurrentAnimators.remove(animator);
                }
            });
            animate(animator);
        }
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.mTargets.add(view);
        return this;
    }

    @NonNull
    public Transition addTarget(@IdRes int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList();
        }
        this.mTargetNames.add(str);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.mTargets.remove(view);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        if (this.mTargetNames != null) {
            this.mTargetNames.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class cls) {
        if (this.mTargetTypes != null) {
            this.mTargetTypes.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t == null) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, t);
        }
        return ArrayListManager.remove(arrayList, t);
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i <= 0) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, Integer.valueOf(i));
        }
        return ArrayListManager.remove(arrayList, Integer.valueOf(i));
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, view);
        }
        return ArrayListManager.remove(arrayList, view);
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, cls);
        }
        return ArrayListManager.remove(arrayList, cls);
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class> getTargetTypes() {
        return this.mTargetTypes;
    }

    void captureValues(ViewGroup viewGroup, boolean z) {
        int i;
        int i2;
        View view;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && ((this.mTargetNames == null || this.mTargetNames.isEmpty()) && (this.mTargetTypes == null || this.mTargetTypes.isEmpty()))) {
            for (i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(((Integer) this.mTargetIds.get(i)).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = findViewById;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (i2 = 0; i2 < this.mTargets.size(); i2++) {
                view = (View) this.mTargets.get(i2);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.view = view;
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!z && this.mNameOverrides != null) {
            i2 = this.mNameOverrides.size();
            ArrayList arrayList = new ArrayList(i2);
            for (i = 0; i < i2; i++) {
                arrayList.add(this.mStartValues.mNameValues.remove((String) this.mNameOverrides.keyAt(i)));
            }
            for (int i3 = 0; i3 < i2; i3++) {
                view = (View) arrayList.get(i3);
                if (view != null) {
                    this.mStartValues.mNameValues.put((String) this.mNameOverrides.valueAt(i3), view);
                }
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.mViewValues.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(id) >= 0) {
                transitionValuesMaps.mIdValues.put(id, null);
            } else {
                transitionValuesMaps.mIdValues.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.mNameValues.containsKey(transitionName)) {
                transitionValuesMaps.mNameValues.put(transitionName, null);
            } else {
                transitionValuesMaps.mNameValues.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.mItemIdValues.indexOfKey(itemIdAtPosition) >= 0) {
                    view = (View) transitionValuesMaps.mItemIdValues.get(itemIdAtPosition);
                    if (view != null) {
                        ViewCompat.setHasTransientState(view, false);
                        transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, view);
            }
        }
    }

    void clearValues(boolean z) {
        if (z) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
            return;
        }
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view)) {
                int size;
                if (this.mTargetTypeExcludes != null) {
                    size = this.mTargetTypeExcludes.size();
                    int i = 0;
                    while (i < size) {
                        if (!((Class) this.mTargetTypeExcludes.get(i)).isInstance(view)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = view;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, view, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, view, transitionValues);
                    }
                }
                if ((view instanceof ViewGroup) && (this.mTargetIdChildExcludes == null || !this.mTargetIdChildExcludes.contains(Integer.valueOf(id)))) {
                    if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view)) {
                        if (this.mTargetTypeChildExcludes != null) {
                            id = this.mTargetTypeChildExcludes.size();
                            size = 0;
                            while (size < id) {
                                if (!((Class) this.mTargetTypeChildExcludes.get(size)).isInstance(view)) {
                                    size++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            captureHierarchy(viewGroup.getChildAt(i2), z);
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        return (TransitionValues) (z ? this.mStartValues : this.mEndValues).mViewValues.get(view);
    }

    TransitionValues getMatchedTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getMatchedTransitionValues(view, z);
        }
        ArrayList arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        TransitionValues transitionValues = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            TransitionValues transitionValues2 = (TransitionValues) arrayList.get(i2);
            if (transitionValues2 == null) {
                return null;
            }
            if (transitionValues2.view == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            transitionValues = (TransitionValues) (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return transitionValues;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdImpl windowId = ViewUtils.getWindowId(view);
            for (size--; size >= 0; size--) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(size);
                if (animationInfo.mView != null && windowId.equals(animationInfo.mWindowId)) {
                    AnimatorUtils.pause((Animator) runningAnimators.keyAt(size));
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    ((TransitionListener) arrayList.get(size)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdImpl windowId = ViewUtils.getWindowId(view);
                for (size--; size >= 0; size--) {
                    AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(size);
                    if (animationInfo.mView != null && windowId.equals(animationInfo.mWindowId)) {
                        AnimatorUtils.resume((Animator) runningAnimators.keyAt(size));
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (size = 0; size < size2; size++) {
                        ((TransitionListener) arrayList.get(size)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    void playTransition(ViewGroup viewGroup) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
        for (size--; size >= 0; size--) {
            Animator animator = (Animator) runningAnimators.keyAt(size);
            if (animator != null) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get(animator);
                if (!(animationInfo == null || animationInfo.mView == null || !windowId.equals(animationInfo.mWindowId))) {
                    TransitionValues transitionValues = animationInfo.mValues;
                    View view = animationInfo.mView;
                    TransitionValues transitionValues2 = getTransitionValues(view, true);
                    TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                    Object obj = (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.mTransition.isTransitionRequired(transitionValues, matchedTransitionValues)) ? 1 : null;
                    if (obj != null) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            runningAnimators.remove(animator);
                        }
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i = 0;
            while (i < length) {
                if (!isValueChanged(transitionValues, transitionValues2, transitionProperties[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String isValueChanged : transitionValues.values.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            int i;
            View view;
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionEnd(this);
                }
            }
            for (i = 0; i < this.mStartValues.mItemIdValues.size(); i++) {
                view = (View) this.mStartValues.mItemIdValues.valueAt(i);
                if (view != null) {
                    ViewCompat.setHasTransientState(view, false);
                }
            }
            for (i = 0; i < this.mEndValues.mItemIdValues.size(); i++) {
                view = (View) this.mEndValues.mItemIdValues.valueAt(i);
                if (view != null) {
                    ViewCompat.setHasTransientState(view, false);
                }
            }
            this.mEnded = true;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void forceToEnd(ViewGroup viewGroup) {
        ArrayMap runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null) {
            WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
            for (size--; size >= 0; size--) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(size);
                if (!(animationInfo.mView == null || windowId == null || !windowId.equals(animationInfo.mWindowId))) {
                    ((Animator) runningAnimators.keyAt(size)).end();
                }
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            ((Animator) this.mCurrentAnimators.get(size)).cancel();
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList.get(i)).onTransitionCancel(this);
            }
        }
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        if (this.mListeners == null) {
            return this;
        }
        this.mListeners.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public Rect getEpicenter() {
        if (this.mEpicenterCallback == null) {
            return null;
        }
        return this.mEpicenterCallback.onGetEpicenter(this);
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    void capturePropagationValues(TransitionValues transitionValues) {
        if (!(this.mPropagation == null || transitionValues.values.isEmpty())) {
            String[] propagationProperties = this.mPropagation.getPropagationProperties();
            if (propagationProperties != null) {
                Object obj = null;
                for (Object containsKey : propagationProperties) {
                    if (!transitionValues.values.containsKey(containsKey)) {
                        break;
                    }
                }
                obj = 1;
                if (obj == null) {
                    this.mPropagation.captureValues(transitionValues);
                }
            }
        }
    }

    Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    String toString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(": ");
        str = stringBuilder.toString();
        if (this.mDuration != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dur(");
            stringBuilder.append(this.mDuration);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.mStartDelay != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dly(");
            stringBuilder.append(this.mStartDelay);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.mInterpolator != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("interp(");
            stringBuilder.append(this.mInterpolator);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("tgts(");
        str = stringBuilder.toString();
        if (this.mTargetIds.size() > 0) {
            String str2 = str;
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                StringBuilder stringBuilder2;
                if (i > 0) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(", ");
                    str2 = stringBuilder2.toString();
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(this.mTargetIds.get(i));
                str2 = stringBuilder2.toString();
            }
            str = str2;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(", ");
                    str = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.mTargets.get(i2));
                str = stringBuilder.toString();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
