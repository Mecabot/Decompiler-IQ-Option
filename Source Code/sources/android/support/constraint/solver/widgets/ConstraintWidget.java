package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX;
    protected int mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void resolve() {
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = -1.0f;
        this.mWeight[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxDimension[1] = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintMaxHeight = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        if (this.mResolutionWidth != null) {
            this.mResolutionWidth.reset();
        }
        if (this.mResolutionHeight != null) {
            this.mResolutionHeight.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public boolean isFullyResolved() {
        if (this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1) {
            return true;
        }
        return false;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, Type.LEFT);
        this.mTop = new ConstraintAnchor(this, Type.TOP);
        this.mRight = new ConstraintAnchor(this, Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, Type.LEFT);
        this.mTop = new ConstraintAnchor(this, Type.TOP);
        this.mRight = new ConstraintAnchor(this, Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        return (this instanceof ConstraintWidgetContainer) && (this.mParent == null || !(this.mParent instanceof ConstraintWidgetContainer));
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        return constraintWidget instanceof WidgetContainer ? (WidgetContainer) constraintWidget : null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(Type.CENTER, constraintWidget, Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".left");
        createObjectVariable.setName(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(".top");
        createObjectVariable2.setName(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(".right");
        createObjectVariable3.setName(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(".bottom");
        createObjectVariable4.setName(stringBuilder2.toString());
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(".baseline");
            createObjectVariable5.setName(stringBuilder2.toString());
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        StringBuilder stringBuilder3 = new StringBuilder();
        if (this.mType != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("type: ");
            stringBuilder.append(this.mType);
            stringBuilder.append(" ");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.mDebugName != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("id: ");
            stringBuilder.append(this.mDebugName);
            stringBuilder.append(" ");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("(");
        stringBuilder3.append(this.mX);
        stringBuilder3.append(", ");
        stringBuilder3.append(this.mY);
        stringBuilder3.append(") - (");
        stringBuilder3.append(this.mWidth);
        stringBuilder3.append(" x ");
        stringBuilder3.append(this.mHeight);
        stringBuilder3.append(") wrap: (");
        stringBuilder3.append(this.mWrapWidth);
        stringBuilder3.append(" x ");
        stringBuilder3.append(this.mWrapHeight);
        stringBuilder3.append(")");
        return stringBuilder3.toString();
    }

    int getInternalDrawX() {
        return this.mDrawX;
    }

    int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i);
        } else if (this.mMatchConstraintMinWidth > 0) {
            i = this.mMatchConstraintMinWidth;
            this.mWidth = i;
        } else {
            i = 0;
        }
        return (this.mMatchConstraintMaxWidth <= 0 || this.mMatchConstraintMaxWidth >= i) ? i : this.mMatchConstraintMaxWidth;
    }

    public int getOptimizerWrapHeight() {
        int i = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i);
        } else if (this.mMatchConstraintMinHeight > 0) {
            i = this.mMatchConstraintMinHeight;
            this.mHeight = i;
        } else {
            i = 0;
        }
        return (this.mMatchConstraintMaxHeight <= 0 || this.mMatchConstraintMaxHeight >= i) ? i : this.mMatchConstraintMaxHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        return i == 1 ? getHeight() : 0;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        return i == 1 ? this.mVerticalBiasPercent : -1.0f;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(Type type, int i) {
        switch (type) {
            case LEFT:
                this.mLeft.mGoneMargin = i;
                return;
            case TOP:
                this.mTop.mGoneMargin = i;
                return;
            case RIGHT:
                this.mRight.mGoneMargin = i;
                return;
            case BOTTOM:
                this.mBottom.mGoneMargin = i;
                return;
            default:
                return;
        }
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void forceUpdateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void setDrawOrigin(int i, int i2) {
        this.mDrawX = i - this.mOffsetX;
        this.mDrawY = i2 - this.mOffsetY;
        this.mX = this.mDrawX;
        this.mY = this.mDrawY;
    }

    public void setDrawX(int i) {
        this.mDrawX = i - this.mOffsetX;
        this.mX = this.mDrawX;
    }

    public void setDrawY(int i) {
        this.mDrawY = i - this.mOffsetY;
        this.mY = this.mDrawY;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String str) {
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        float parseFloat;
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        indexOf = str.indexOf(58);
        if (indexOf < 0 || indexOf >= length - 1) {
            str = str.substring(i2);
            if (str.length() > 0) {
                parseFloat = Float.parseFloat(str);
            }
        } else {
            String substring2 = str.substring(i2, indexOf);
            str = str.substring(indexOf + 1);
            if (substring2.length() > 0 && str.length() > 0) {
                try {
                    float parseFloat2 = Float.parseFloat(substring2);
                    parseFloat = Float.parseFloat(str);
                    if (parseFloat2 > 0.0f && parseFloat > 0.0f) {
                        parseFloat = i == 1 ? Math.abs(parseFloat / parseFloat2) : Math.abs(parseFloat2 / parseFloat);
                    }
                } catch (NumberFormatException unused) {
                    parseFloat = 0.0f;
                }
            }
        }
        if (parseFloat > 0.0f) {
            this.mDimensionRatio = parseFloat;
            this.mDimensionRatioSide = i;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mHeight = i2;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        i3 -= i;
        i4 -= i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i3 < this.mWidth) {
            i3 = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i4 < this.mHeight) {
            i4 = this.mHeight;
        }
        this.mWidth = i3;
        this.mHeight = i4;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.mOptimizerMeasured = true;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        return i == 1 ? this.mRelY : 0;
    }

    void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(Type type, ConstraintWidget constraintWidget, Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, Strength.STRONG, 0, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connect(Type type, ConstraintWidget constraintWidget, Type type2, int i) {
        connect(type, constraintWidget, type2, i, Strength.STRONG);
    }

    public void connect(Type type, ConstraintWidget constraintWidget, Type type2) {
        connect(type, constraintWidget, type2, 0, Strength.STRONG);
    }

    public void connect(Type type, ConstraintWidget constraintWidget, Type type2, int i, Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    public void connect(Type type, ConstraintWidget constraintWidget, Type type2, int i, Strength strength, int i2) {
        Type type3 = type;
        ConstraintWidget constraintWidget2 = constraintWidget;
        Type type4 = type2;
        int i3 = i2;
        int i4 = 0;
        ConstraintAnchor anchor;
        ConstraintAnchor anchor2;
        ConstraintAnchor anchor3;
        if (type3 == Type.CENTER) {
            ConstraintWidget constraintWidget3;
            Strength strength2;
            int i5;
            Type type5;
            if (type4 == Type.CENTER) {
                Object obj;
                anchor = getAnchor(Type.LEFT);
                anchor2 = getAnchor(Type.RIGHT);
                ConstraintAnchor anchor4 = getAnchor(Type.TOP);
                ConstraintAnchor anchor5 = getAnchor(Type.BOTTOM);
                Object obj2 = 1;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    constraintWidget3 = constraintWidget2;
                    strength2 = strength;
                    i5 = i3;
                    connect(Type.LEFT, constraintWidget3, Type.LEFT, 0, strength2, i5);
                    connect(Type.RIGHT, constraintWidget3, Type.RIGHT, 0, strength2, i5);
                    obj = 1;
                } else {
                    obj = null;
                }
                if ((anchor4 == null || !anchor4.isConnected()) && (anchor5 == null || !anchor5.isConnected())) {
                    constraintWidget3 = constraintWidget2;
                    strength2 = strength;
                    i5 = i3;
                    connect(Type.TOP, constraintWidget3, Type.TOP, 0, strength2, i5);
                    connect(Type.BOTTOM, constraintWidget3, Type.BOTTOM, 0, strength2, i5);
                } else {
                    obj2 = null;
                }
                if (obj != null && obj2 != null) {
                    getAnchor(Type.CENTER).connect(constraintWidget2.getAnchor(Type.CENTER), 0, i3);
                } else if (obj != null) {
                    getAnchor(Type.CENTER_X).connect(constraintWidget2.getAnchor(Type.CENTER_X), 0, i3);
                } else if (obj2 != null) {
                    getAnchor(Type.CENTER_Y).connect(constraintWidget2.getAnchor(Type.CENTER_Y), 0, i3);
                }
            } else if (type4 == Type.LEFT || type4 == Type.RIGHT) {
                constraintWidget3 = constraintWidget2;
                type5 = type4;
                strength2 = strength;
                i5 = i3;
                connect(Type.LEFT, constraintWidget3, type5, 0, strength2, i5);
                connect(Type.RIGHT, constraintWidget3, type5, 0, strength2, i5);
                getAnchor(Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
            } else if (type4 == Type.TOP || type4 == Type.BOTTOM) {
                constraintWidget3 = constraintWidget2;
                type5 = type4;
                strength2 = strength;
                i5 = i3;
                connect(Type.TOP, constraintWidget3, type5, 0, strength2, i5);
                connect(Type.BOTTOM, constraintWidget3, type5, 0, strength2, i5);
                getAnchor(Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
            }
        } else if (type3 == Type.CENTER_X && (type4 == Type.LEFT || type4 == Type.RIGHT)) {
            anchor = getAnchor(Type.LEFT);
            anchor2 = constraintWidget.getAnchor(type2);
            anchor3 = getAnchor(Type.RIGHT);
            anchor.connect(anchor2, 0, i3);
            anchor3.connect(anchor2, 0, i3);
            getAnchor(Type.CENTER_X).connect(anchor2, 0, i3);
        } else if (type3 == Type.CENTER_Y && (type4 == Type.TOP || type4 == Type.BOTTOM)) {
            anchor = constraintWidget.getAnchor(type2);
            getAnchor(Type.TOP).connect(anchor, 0, i3);
            getAnchor(Type.BOTTOM).connect(anchor, 0, i3);
            getAnchor(Type.CENTER_Y).connect(anchor, 0, i3);
        } else if (type3 == Type.CENTER_X && type4 == Type.CENTER_X) {
            getAnchor(Type.LEFT).connect(constraintWidget2.getAnchor(Type.LEFT), 0, i3);
            getAnchor(Type.RIGHT).connect(constraintWidget2.getAnchor(Type.RIGHT), 0, i3);
            getAnchor(Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i3);
        } else if (type3 == Type.CENTER_Y && type4 == Type.CENTER_Y) {
            getAnchor(Type.TOP).connect(constraintWidget2.getAnchor(Type.TOP), 0, i3);
            getAnchor(Type.BOTTOM).connect(constraintWidget2.getAnchor(Type.BOTTOM), 0, i3);
            getAnchor(Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i3);
        } else {
            anchor2 = getAnchor(type);
            anchor3 = constraintWidget.getAnchor(type2);
            if (anchor2.isValidConnection(anchor3)) {
                ConstraintAnchor anchor6;
                if (type3 == Type.BASELINE) {
                    anchor = getAnchor(Type.TOP);
                    anchor6 = getAnchor(Type.BOTTOM);
                    if (anchor != null) {
                        anchor.reset();
                    }
                    if (anchor6 != null) {
                        anchor6.reset();
                    }
                } else {
                    if (type3 == Type.TOP || type3 == Type.BOTTOM) {
                        anchor6 = getAnchor(Type.BASELINE);
                        if (anchor6 != null) {
                            anchor6.reset();
                        }
                        anchor6 = getAnchor(Type.CENTER);
                        if (anchor6.getTarget() != anchor3) {
                            anchor6.reset();
                        }
                        anchor = getAnchor(type).getOpposite();
                        anchor6 = getAnchor(Type.CENTER_Y);
                        if (anchor6.isConnected()) {
                            anchor.reset();
                            anchor6.reset();
                        }
                    } else if (type3 == Type.LEFT || type3 == Type.RIGHT) {
                        anchor6 = getAnchor(Type.CENTER);
                        if (anchor6.getTarget() != anchor3) {
                            anchor6.reset();
                        }
                        anchor = getAnchor(type).getOpposite();
                        anchor6 = getAnchor(Type.CENTER_X);
                        if (anchor6.isConnected()) {
                            anchor.reset();
                            anchor6.reset();
                        }
                    }
                    i4 = i;
                }
                anchor2.connect(anchor3, i4, strength, i3);
                anchor3.getOwner().connectedTo(anchor2.getOwner());
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getHeight() == getWrapHeight()) {
                    setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getHeight() > getMinHeight()) {
                    setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                ((ConstraintAnchor) this.mAnchors.get(i)).reset();
            }
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = (ConstraintAnchor) this.mAnchors.get(i2);
                if (i == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        return i == 1 ? getVerticalDimensionBehaviour() : null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public boolean isInHorizontalChain() {
        return (this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) || (this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight);
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintWidget constraintWidget3;
            ConstraintAnchor anchor = constraintWidget.getAnchor(Type.LEFT);
            if (anchor == null) {
                anchor = null;
            } else {
                anchor = anchor.getTarget();
            }
            if (anchor == null) {
                constraintWidget3 = null;
            } else {
                constraintWidget3 = anchor.getOwner();
            }
            if (constraintWidget3 == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor constraintAnchor;
            if (constraintWidget3 == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = constraintWidget3.getAnchor(Type.RIGHT).getTarget();
            }
            if (constraintAnchor == null || constraintAnchor.getOwner() == constraintWidget) {
                constraintWidget = constraintWidget3;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public boolean isInVerticalChain() {
        return (this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) || (this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom);
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintWidget constraintWidget3;
            ConstraintAnchor anchor = constraintWidget.getAnchor(Type.TOP);
            if (anchor == null) {
                anchor = null;
            } else {
                anchor = anchor.getTarget();
            }
            if (anchor == null) {
                constraintWidget3 = null;
            } else {
                constraintWidget3 = anchor.getOwner();
            }
            if (constraintWidget3 == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor constraintAnchor;
            if (constraintWidget3 == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = constraintWidget3.getAnchor(Type.BOTTOM).getTarget();
            }
            if (constraintAnchor == null || constraintAnchor.getOwner() == constraintWidget) {
                constraintWidget = constraintWidget3;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    private boolean isChainHead(int i) {
        i *= 2;
        if (!(this.mListAnchors[i].mTarget == null || this.mListAnchors[i].mTarget.mTarget == this.mListAnchors[i])) {
            i++;
            if (this.mListAnchors[i].mTarget != null && this.mListAnchors[i].mTarget.mTarget == this.mListAnchors[i]) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:154:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0271  */
    /* JADX WARNING: Missing block: B:102:0x01c3, code:
            if (r15.mResolvedDimensionRatioSide == -1) goto L_0x01c7;
     */
    public void addToSolver(android.support.constraint.solver.LinearSystem r42) {
        /*
        r41 = this;
        r15 = r41;
        r14 = r42;
        r0 = r15.mLeft;
        r21 = r14.createObjectVariable(r0);
        r0 = r15.mRight;
        r13 = r14.createObjectVariable(r0);
        r0 = r15.mTop;
        r12 = r14.createObjectVariable(r0);
        r0 = r15.mBottom;
        r11 = r14.createObjectVariable(r0);
        r0 = r15.mBaseline;
        r10 = r14.createObjectVariable(r0);
        r0 = r15.mParent;
        r1 = 8;
        r9 = 1;
        r8 = 0;
        if (r0 == 0) goto L_0x00b7;
    L_0x002a:
        r0 = r15.mParent;
        if (r0 == 0) goto L_0x003a;
    L_0x002e:
        r0 = r15.mParent;
        r0 = r0.mListDimensionBehaviors;
        r0 = r0[r8];
        r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 != r2) goto L_0x003a;
    L_0x0038:
        r0 = 1;
        goto L_0x003b;
    L_0x003a:
        r0 = 0;
    L_0x003b:
        r2 = r15.mParent;
        if (r2 == 0) goto L_0x004b;
    L_0x003f:
        r2 = r15.mParent;
        r2 = r2.mListDimensionBehaviors;
        r2 = r2[r9];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r2 != r3) goto L_0x004b;
    L_0x0049:
        r2 = 1;
        goto L_0x004c;
    L_0x004b:
        r2 = 0;
    L_0x004c:
        r3 = r15.isChainHead(r8);
        if (r3 == 0) goto L_0x005b;
    L_0x0052:
        r3 = r15.mParent;
        r3 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r3;
        r3.addChain(r15, r8);
        r3 = 1;
        goto L_0x005f;
    L_0x005b:
        r3 = r41.isInHorizontalChain();
    L_0x005f:
        r4 = r15.isChainHead(r9);
        if (r4 == 0) goto L_0x006e;
    L_0x0065:
        r4 = r15.mParent;
        r4 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r4;
        r4.addChain(r15, r9);
        r4 = 1;
        goto L_0x0072;
    L_0x006e:
        r4 = r41.isInVerticalChain();
    L_0x0072:
        if (r0 == 0) goto L_0x008f;
    L_0x0074:
        r5 = r15.mVisibility;
        if (r5 == r1) goto L_0x008f;
    L_0x0078:
        r5 = r15.mLeft;
        r5 = r5.mTarget;
        if (r5 != 0) goto L_0x008f;
    L_0x007e:
        r5 = r15.mRight;
        r5 = r5.mTarget;
        if (r5 != 0) goto L_0x008f;
    L_0x0084:
        r5 = r15.mParent;
        r5 = r5.mRight;
        r5 = r14.createObjectVariable(r5);
        r14.addGreaterThan(r5, r13, r8, r9);
    L_0x008f:
        if (r2 == 0) goto L_0x00b0;
    L_0x0091:
        r5 = r15.mVisibility;
        if (r5 == r1) goto L_0x00b0;
    L_0x0095:
        r5 = r15.mTop;
        r5 = r5.mTarget;
        if (r5 != 0) goto L_0x00b0;
    L_0x009b:
        r5 = r15.mBottom;
        r5 = r5.mTarget;
        if (r5 != 0) goto L_0x00b0;
    L_0x00a1:
        r5 = r15.mBaseline;
        if (r5 != 0) goto L_0x00b0;
    L_0x00a5:
        r5 = r15.mParent;
        r5 = r5.mBottom;
        r5 = r14.createObjectVariable(r5);
        r14.addGreaterThan(r5, r11, r8, r9);
    L_0x00b0:
        r7 = r2;
        r16 = r3;
        r22 = r4;
        r2 = r0;
        goto L_0x00bd;
    L_0x00b7:
        r2 = 0;
        r7 = 0;
        r16 = 0;
        r22 = 0;
    L_0x00bd:
        r0 = r15.mWidth;
        r3 = r15.mMinWidth;
        if (r0 >= r3) goto L_0x00c5;
    L_0x00c3:
        r0 = r15.mMinWidth;
    L_0x00c5:
        r3 = r15.mHeight;
        r4 = r15.mMinHeight;
        if (r3 >= r4) goto L_0x00cd;
    L_0x00cb:
        r3 = r15.mMinHeight;
    L_0x00cd:
        r4 = r15.mListDimensionBehaviors;
        r4 = r4[r8];
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r4 == r5) goto L_0x00d7;
    L_0x00d5:
        r4 = 1;
        goto L_0x00d8;
    L_0x00d7:
        r4 = 0;
    L_0x00d8:
        r5 = r15.mListDimensionBehaviors;
        r5 = r5[r9];
        r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r5 == r6) goto L_0x00e2;
    L_0x00e0:
        r5 = 1;
        goto L_0x00e3;
    L_0x00e2:
        r5 = 0;
    L_0x00e3:
        r6 = r15.mDimensionRatioSide;
        r15.mResolvedDimensionRatioSide = r6;
        r6 = r15.mDimensionRatio;
        r15.mResolvedDimensionRatio = r6;
        r6 = r15.mMatchConstraintDefaultWidth;
        r9 = r15.mMatchConstraintDefaultHeight;
        r8 = r15.mDimensionRatio;
        r17 = 0;
        r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1));
        r17 = 4;
        if (r8 <= 0) goto L_0x01a4;
    L_0x00f9:
        r8 = r15.mVisibility;
        r1 = 8;
        if (r8 == r1) goto L_0x01a4;
    L_0x00ff:
        r1 = r15.mListDimensionBehaviors;
        r8 = 0;
        r1 = r1[r8];
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        r27 = r0;
        r0 = 3;
        if (r1 != r8) goto L_0x010e;
    L_0x010b:
        if (r6 != 0) goto L_0x010e;
    L_0x010d:
        r6 = 3;
    L_0x010e:
        r1 = r15.mListDimensionBehaviors;
        r8 = 1;
        r1 = r1[r8];
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 != r8) goto L_0x011a;
    L_0x0117:
        if (r9 != 0) goto L_0x011a;
    L_0x0119:
        r9 = 3;
    L_0x011a:
        r1 = r15.mListDimensionBehaviors;
        r8 = 0;
        r1 = r1[r8];
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 != r8) goto L_0x0135;
    L_0x0123:
        r1 = r15.mListDimensionBehaviors;
        r8 = 1;
        r1 = r1[r8];
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 != r8) goto L_0x0135;
    L_0x012c:
        if (r6 != r0) goto L_0x0135;
    L_0x012e:
        if (r9 != r0) goto L_0x0135;
    L_0x0130:
        r15.setupDimensionRatio(r2, r7, r4, r5);
        goto L_0x0199;
    L_0x0135:
        r1 = r15.mListDimensionBehaviors;
        r4 = 0;
        r1 = r1[r4];
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 != r5) goto L_0x0163;
    L_0x013e:
        if (r6 != r0) goto L_0x0163;
    L_0x0140:
        r15.mResolvedDimensionRatioSide = r4;
        r0 = r15.mResolvedDimensionRatio;
        r1 = r15.mHeight;
        r1 = (float) r1;
        r0 = r0 * r1;
        r0 = (int) r0;
        r1 = r15.mListDimensionBehaviors;
        r4 = 1;
        r1 = r1[r4];
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 == r5) goto L_0x015a;
    L_0x0153:
        r18 = r0;
        r28 = r3;
        r25 = r9;
        goto L_0x01ae;
    L_0x015a:
        r18 = r0;
        r28 = r3;
        r17 = r6;
        r25 = r9;
        goto L_0x01a1;
    L_0x0163:
        r4 = 1;
        r1 = r15.mListDimensionBehaviors;
        r1 = r1[r4];
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 != r5) goto L_0x0199;
    L_0x016c:
        if (r9 != r0) goto L_0x0199;
    L_0x016e:
        r15.mResolvedDimensionRatioSide = r4;
        r0 = r15.mDimensionRatioSide;
        r1 = -1;
        if (r0 != r1) goto L_0x017c;
    L_0x0175:
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = r15.mResolvedDimensionRatio;
        r0 = r0 / r1;
        r15.mResolvedDimensionRatio = r0;
    L_0x017c:
        r0 = r15.mResolvedDimensionRatio;
        r1 = r15.mWidth;
        r1 = (float) r1;
        r0 = r0 * r1;
        r0 = (int) r0;
        r1 = r15.mListDimensionBehaviors;
        r3 = 0;
        r1 = r1[r3];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 == r3) goto L_0x0196;
    L_0x018d:
        r28 = r0;
        r17 = r6;
        r18 = r27;
        r25 = 4;
        goto L_0x01ae;
    L_0x0196:
        r28 = r0;
        goto L_0x019b;
    L_0x0199:
        r28 = r3;
    L_0x019b:
        r17 = r6;
        r25 = r9;
        r18 = r27;
    L_0x01a1:
        r27 = 1;
        goto L_0x01b0;
    L_0x01a4:
        r27 = r0;
        r28 = r3;
        r17 = r6;
        r25 = r9;
        r18 = r27;
    L_0x01ae:
        r27 = 0;
    L_0x01b0:
        r0 = r15.mResolvedMatchConstraintDefault;
        r1 = 0;
        r0[r1] = r17;
        r0 = r15.mResolvedMatchConstraintDefault;
        r1 = 1;
        r0[r1] = r25;
        if (r27 == 0) goto L_0x01ca;
    L_0x01bc:
        r0 = r15.mResolvedDimensionRatioSide;
        if (r0 == 0) goto L_0x01c6;
    L_0x01c0:
        r0 = r15.mResolvedDimensionRatioSide;
        r1 = -1;
        if (r0 != r1) goto L_0x01cb;
    L_0x01c5:
        goto L_0x01c7;
    L_0x01c6:
        r1 = -1;
    L_0x01c7:
        r19 = 1;
        goto L_0x01cd;
    L_0x01ca:
        r1 = -1;
    L_0x01cb:
        r19 = 0;
    L_0x01cd:
        r0 = r15.mListDimensionBehaviors;
        r3 = 0;
        r0 = r0[r3];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 != r3) goto L_0x01dc;
    L_0x01d6:
        r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer;
        if (r0 == 0) goto L_0x01dc;
    L_0x01da:
        r6 = 1;
        goto L_0x01dd;
    L_0x01dc:
        r6 = 0;
    L_0x01dd:
        r0 = r15.mCenter;
        r0 = r0.isConnected();
        r9 = 1;
        r23 = r0 ^ 1;
        r0 = r15.mHorizontalResolution;
        r8 = 2;
        r26 = 0;
        if (r0 == r8) goto L_0x0261;
    L_0x01ed:
        r0 = r15.mParent;
        if (r0 == 0) goto L_0x01fb;
    L_0x01f1:
        r0 = r15.mParent;
        r0 = r0.mRight;
        r0 = r14.createObjectVariable(r0);
        r4 = r0;
        goto L_0x01fd;
    L_0x01fb:
        r4 = r26;
    L_0x01fd:
        r0 = r15.mParent;
        if (r0 == 0) goto L_0x020b;
    L_0x0201:
        r0 = r15.mParent;
        r0 = r0.mLeft;
        r0 = r14.createObjectVariable(r0);
        r3 = r0;
        goto L_0x020d;
    L_0x020b:
        r3 = r26;
    L_0x020d:
        r0 = r15.mListDimensionBehaviors;
        r20 = 0;
        r5 = r0[r20];
        r0 = r15.mLeft;
        r8 = r15.mRight;
        r9 = r15.mX;
        r31 = r11;
        r11 = r15.mMinWidth;
        r1 = r15.mMaxDimension;
        r24 = r1[r20];
        r1 = r15.mHorizontalBiasPercent;
        r33 = r13;
        r13 = r15.mMatchConstraintMinWidth;
        r34 = r13;
        r13 = r15.mMatchConstraintMaxWidth;
        r35 = r13;
        r13 = r15.mMatchConstraintPercentWidth;
        r36 = r0;
        r0 = r15;
        r32 = r1;
        r1 = r14;
        r37 = r7;
        r7 = r36;
        r38 = r10;
        r10 = r18;
        r29 = r31;
        r39 = r12;
        r12 = r24;
        r30 = r13;
        r24 = r33;
        r18 = r34;
        r20 = r35;
        r13 = r32;
        r14 = r19;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r20;
        r19 = r30;
        r20 = r23;
        r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        r15 = r41;
        goto L_0x026b;
    L_0x0261:
        r37 = r7;
        r38 = r10;
        r29 = r11;
        r39 = r12;
        r24 = r13;
    L_0x026b:
        r0 = r15.mVerticalResolution;
        r1 = 2;
        if (r0 != r1) goto L_0x0271;
    L_0x0270:
        return;
    L_0x0271:
        r0 = r15.mListDimensionBehaviors;
        r14 = 1;
        r0 = r0[r14];
        r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 != r1) goto L_0x0280;
    L_0x027a:
        r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer;
        if (r0 == 0) goto L_0x0280;
    L_0x027e:
        r6 = 1;
        goto L_0x0281;
    L_0x0280:
        r6 = 0;
    L_0x0281:
        if (r27 == 0) goto L_0x028f;
    L_0x0283:
        r0 = r15.mResolvedDimensionRatioSide;
        if (r0 == r14) goto L_0x028c;
    L_0x0287:
        r0 = r15.mResolvedDimensionRatioSide;
        r1 = -1;
        if (r0 != r1) goto L_0x028f;
    L_0x028c:
        r16 = 1;
        goto L_0x0291;
    L_0x028f:
        r16 = 0;
    L_0x0291:
        r0 = r15.mBaselineDistance;
        if (r0 <= 0) goto L_0x02d0;
    L_0x0295:
        r0 = r15.mBaseline;
        r0 = r0.getResolutionNode();
        r0 = r0.state;
        if (r0 != r14) goto L_0x02ad;
    L_0x029f:
        r0 = r15.mBaseline;
        r0 = r0.getResolutionNode();
        r13 = r42;
        r0.addResolvedValue(r13);
        r12 = r39;
        goto L_0x02d4;
    L_0x02ad:
        r13 = r42;
        r0 = r41.getBaselineDistance();
        r1 = 6;
        r2 = r38;
        r12 = r39;
        r13.addEquality(r2, r12, r0, r1);
        r0 = r15.mBaseline;
        r0 = r0.mTarget;
        if (r0 == 0) goto L_0x02d4;
    L_0x02c1:
        r0 = r15.mBaseline;
        r0 = r0.mTarget;
        r0 = r13.createObjectVariable(r0);
        r3 = 0;
        r13.addEquality(r2, r0, r3, r1);
        r20 = 0;
        goto L_0x02d6;
    L_0x02d0:
        r12 = r39;
        r13 = r42;
    L_0x02d4:
        r20 = r23;
    L_0x02d6:
        r0 = r15.mParent;
        if (r0 == 0) goto L_0x02e4;
    L_0x02da:
        r0 = r15.mParent;
        r0 = r0.mBottom;
        r0 = r13.createObjectVariable(r0);
        r4 = r0;
        goto L_0x02e6;
    L_0x02e4:
        r4 = r26;
    L_0x02e6:
        r0 = r15.mParent;
        if (r0 == 0) goto L_0x02f4;
    L_0x02ea:
        r0 = r15.mParent;
        r0 = r0.mTop;
        r0 = r13.createObjectVariable(r0);
        r3 = r0;
        goto L_0x02f6;
    L_0x02f4:
        r3 = r26;
    L_0x02f6:
        r0 = r15.mListDimensionBehaviors;
        r5 = r0[r14];
        r7 = r15.mTop;
        r8 = r15.mBottom;
        r9 = r15.mY;
        r11 = r15.mMinHeight;
        r0 = r15.mMaxDimension;
        r17 = r0[r14];
        r10 = r15.mVerticalBiasPercent;
        r2 = r15.mMatchConstraintMinHeight;
        r1 = r15.mMatchConstraintMaxHeight;
        r0 = r15.mMatchConstraintPercentHeight;
        r19 = r0;
        r0 = r15;
        r18 = r1;
        r1 = r13;
        r23 = r2;
        r2 = r37;
        r26 = r10;
        r10 = r28;
        r28 = r12;
        r12 = r17;
        r13 = r26;
        r14 = r16;
        r15 = r22;
        r16 = r25;
        r17 = r23;
        r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        if (r27 == 0) goto L_0x0358;
    L_0x032f:
        r6 = 6;
        r7 = r41;
        r0 = r7.mResolvedDimensionRatioSide;
        r1 = 1;
        if (r0 != r1) goto L_0x0348;
    L_0x0337:
        r5 = r7.mResolvedDimensionRatio;
        r6 = 6;
        r0 = r42;
        r1 = r29;
        r2 = r28;
        r3 = r24;
        r4 = r21;
        r0.addRatio(r1, r2, r3, r4, r5, r6);
        goto L_0x035a;
    L_0x0348:
        r5 = r7.mResolvedDimensionRatio;
        r0 = r42;
        r1 = r24;
        r2 = r21;
        r3 = r29;
        r4 = r28;
        r0.addRatio(r1, r2, r3, r4, r5, r6);
        goto L_0x035a;
    L_0x0358:
        r7 = r41;
    L_0x035a:
        r0 = r7.mCenter;
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x0382;
    L_0x0362:
        r0 = r7.mCenter;
        r0 = r0.getTarget();
        r0 = r0.getOwner();
        r1 = r7.mCircleConstraintAngle;
        r2 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r1 = r1 + r2;
        r1 = (double) r1;
        r1 = java.lang.Math.toRadians(r1);
        r1 = (float) r1;
        r2 = r7.mCenter;
        r2 = r2.getMargin();
        r3 = r42;
        r3.addCenterPoint(r7, r0, r1, r2);
    L_0x0382:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.addToSolver(android.support.constraint.solver.LinearSystem):void");
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && !(this.mLeft.isConnected() && this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && !(this.mTop.isConnected() && this.mBottom.isConnected() && this.mLeft.isConnected() && this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02e7 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02e7 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dc  */
    private void applyConstraints(android.support.constraint.solver.LinearSystem r32, boolean r33, android.support.constraint.solver.SolverVariable r34, android.support.constraint.solver.SolverVariable r35, android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour r36, boolean r37, android.support.constraint.solver.widgets.ConstraintAnchor r38, android.support.constraint.solver.widgets.ConstraintAnchor r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, int r47, int r48, int r49, float r50, boolean r51) {
        /*
        r31 = this;
        r0 = r31;
        r10 = r32;
        r12 = r34;
        r13 = r35;
        r14 = r38;
        r15 = r39;
        r1 = r42;
        r2 = r43;
        r9 = r10.createObjectVariable(r14);
        r8 = r10.createObjectVariable(r15);
        r6 = r38.getTarget();
        r7 = r10.createObjectVariable(r6);
        r6 = r39.getTarget();
        r6 = r10.createObjectVariable(r6);
        r12 = r10.graphOptimizer;
        r16 = 1;
        r22 = r6;
        if (r12 == 0) goto L_0x0069;
    L_0x0030:
        r12 = r38.getResolutionNode();
        r12 = r12.state;
        r6 = 1;
        if (r12 != r6) goto L_0x0069;
    L_0x0039:
        r12 = r39.getResolutionNode();
        r12 = r12.state;
        if (r12 != r6) goto L_0x0069;
    L_0x0041:
        r1 = android.support.constraint.solver.LinearSystem.getMetrics();
        if (r1 == 0) goto L_0x0051;
    L_0x0047:
        r1 = android.support.constraint.solver.LinearSystem.getMetrics();
        r2 = r1.resolvedWidgets;
        r5 = r2 + r16;
        r1.resolvedWidgets = r5;
    L_0x0051:
        r1 = r38.getResolutionNode();
        r1.addResolvedValue(r10);
        r1 = r39.getResolutionNode();
        r1.addResolvedValue(r10);
        if (r46 != 0) goto L_0x0068;
    L_0x0061:
        if (r33 == 0) goto L_0x0068;
    L_0x0063:
        r1 = 0;
        r2 = 6;
        r10.addGreaterThan(r13, r8, r1, r2);
    L_0x0068:
        return;
    L_0x0069:
        r6 = android.support.constraint.solver.LinearSystem.getMetrics();
        if (r6 == 0) goto L_0x0079;
    L_0x006f:
        r6 = android.support.constraint.solver.LinearSystem.getMetrics();
        r12 = r6.nonresolvedWidgets;
        r1 = r12 + r16;
        r6.nonresolvedWidgets = r1;
    L_0x0079:
        r1 = r38.isConnected();
        r2 = r39.isConnected();
        r6 = r0.mCenter;
        r6 = r6.isConnected();
        if (r1 == 0) goto L_0x008b;
    L_0x0089:
        r12 = 1;
        goto L_0x008c;
    L_0x008b:
        r12 = 0;
    L_0x008c:
        if (r2 == 0) goto L_0x0090;
    L_0x008e:
        r12 = r12 + 1;
    L_0x0090:
        if (r6 == 0) goto L_0x0094;
    L_0x0092:
        r12 = r12 + 1;
    L_0x0094:
        if (r45 == 0) goto L_0x0098;
    L_0x0096:
        r13 = 3;
        goto L_0x009a;
    L_0x0098:
        r13 = r47;
    L_0x009a:
        r16 = android.support.constraint.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour;
        r17 = r36.ordinal();
        r16 = r16[r17];
        r15 = 4;
        switch(r16) {
            case 1: goto L_0x00a6;
            case 2: goto L_0x00a6;
            case 3: goto L_0x00a6;
            case 4: goto L_0x00a9;
            default: goto L_0x00a6;
        };
    L_0x00a6:
        r16 = 0;
        goto L_0x00ae;
    L_0x00a9:
        if (r13 != r15) goto L_0x00ac;
    L_0x00ab:
        goto L_0x00a6;
    L_0x00ac:
        r16 = 1;
    L_0x00ae:
        r15 = r0.mVisibility;
        r3 = 8;
        if (r15 != r3) goto L_0x00b8;
    L_0x00b4:
        r3 = 0;
        r16 = 0;
        goto L_0x00ba;
    L_0x00b8:
        r3 = r41;
    L_0x00ba:
        if (r51 == 0) goto L_0x00d7;
    L_0x00bc:
        if (r1 != 0) goto L_0x00c8;
    L_0x00be:
        if (r2 != 0) goto L_0x00c8;
    L_0x00c0:
        if (r6 != 0) goto L_0x00c8;
    L_0x00c2:
        r15 = r40;
        r10.addEquality(r9, r15);
        goto L_0x00d7;
    L_0x00c8:
        if (r1 == 0) goto L_0x00d7;
    L_0x00ca:
        if (r2 != 0) goto L_0x00d7;
    L_0x00cc:
        r15 = r38.getMargin();
        r23 = r6;
        r6 = 6;
        r10.addEquality(r9, r7, r15, r6);
        goto L_0x00da;
    L_0x00d7:
        r23 = r6;
        r6 = 6;
    L_0x00da:
        if (r16 != 0) goto L_0x010a;
    L_0x00dc:
        if (r37 == 0) goto L_0x00fa;
    L_0x00de:
        r6 = 3;
        r15 = 0;
        r10.addEquality(r8, r9, r15, r6);
        r6 = r42;
        if (r6 <= 0) goto L_0x00ec;
    L_0x00e7:
        r15 = 6;
        r10.addGreaterThan(r8, r9, r6, r15);
        goto L_0x00ed;
    L_0x00ec:
        r15 = 6;
    L_0x00ed:
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r24 = r7;
        r7 = r43;
        if (r7 >= r3) goto L_0x0102;
    L_0x00f6:
        r10.addLowerThan(r8, r9, r7, r15);
        goto L_0x0102;
    L_0x00fa:
        r24 = r7;
        r6 = r42;
        r15 = 6;
        r10.addEquality(r8, r9, r3, r15);
    L_0x0102:
        r6 = r48;
        r15 = r49;
        r25 = r13;
        goto L_0x01cb;
    L_0x010a:
        r24 = r7;
        r6 = r42;
        r15 = 6;
        r7 = -2;
        r15 = r48;
        if (r15 != r7) goto L_0x0118;
    L_0x0114:
        r15 = r49;
        r6 = r3;
        goto L_0x011b;
    L_0x0118:
        r6 = r15;
        r15 = r49;
    L_0x011b:
        if (r15 != r7) goto L_0x011e;
    L_0x011d:
        r15 = r3;
    L_0x011e:
        if (r6 <= 0) goto L_0x0129;
    L_0x0120:
        r7 = 6;
        r10.addGreaterThan(r8, r9, r6, r7);
        r3 = java.lang.Math.max(r3, r6);
        goto L_0x012a;
    L_0x0129:
        r7 = 6;
    L_0x012a:
        if (r15 <= 0) goto L_0x0133;
    L_0x012c:
        r10.addLowerThan(r8, r9, r15, r7);
        r3 = java.lang.Math.min(r3, r15);
    L_0x0133:
        r7 = 1;
        if (r13 != r7) goto L_0x014b;
    L_0x0136:
        if (r33 == 0) goto L_0x013e;
    L_0x0138:
        r7 = 6;
        r10.addEquality(r8, r9, r3, r7);
        goto L_0x01b2;
    L_0x013e:
        if (r46 == 0) goto L_0x0146;
    L_0x0140:
        r7 = 4;
        r10.addEquality(r8, r9, r3, r7);
        goto L_0x01b2;
    L_0x0146:
        r7 = 1;
        r10.addEquality(r8, r9, r3, r7);
        goto L_0x01b2;
    L_0x014b:
        r7 = 2;
        if (r13 != r7) goto L_0x01b2;
    L_0x014e:
        r7 = r38.getType();
        r25 = r13;
        r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP;
        if (r7 == r13) goto L_0x0180;
    L_0x0158:
        r7 = r38.getType();
        r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        if (r7 != r13) goto L_0x0161;
    L_0x0160:
        goto L_0x0180;
    L_0x0161:
        r7 = r0.mParent;
        r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT;
        r7 = r7.getAnchor(r13);
        r7 = r10.createObjectVariable(r7);
        r13 = r0.mParent;
        r26 = r7;
        r7 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT;
        r7 = r13.getAnchor(r7);
        r7 = r10.createObjectVariable(r7);
        r19 = r7;
        r20 = r26;
        goto L_0x019e;
    L_0x0180:
        r7 = r0.mParent;
        r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP;
        r7 = r7.getAnchor(r13);
        r7 = r10.createObjectVariable(r7);
        r13 = r0.mParent;
        r27 = r7;
        r7 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        r7 = r13.getAnchor(r7);
        r7 = r10.createObjectVariable(r7);
        r19 = r7;
        r20 = r27;
    L_0x019e:
        r16 = r32.createRow();
        r17 = r8;
        r18 = r9;
        r21 = r50;
        r7 = r16.createRowDimensionRatio(r17, r18, r19, r20, r21);
        r10.addConstraint(r7);
        r16 = 0;
        goto L_0x01b4;
    L_0x01b2:
        r25 = r13;
    L_0x01b4:
        if (r16 == 0) goto L_0x01cb;
    L_0x01b6:
        r7 = 2;
        if (r12 == r7) goto L_0x01cb;
    L_0x01b9:
        if (r45 != 0) goto L_0x01cb;
    L_0x01bb:
        r3 = java.lang.Math.max(r6, r3);
        if (r15 <= 0) goto L_0x01c5;
    L_0x01c1:
        r3 = java.lang.Math.min(r15, r3);
    L_0x01c5:
        r13 = 6;
        r10.addEquality(r8, r9, r3, r13);
        r16 = 0;
    L_0x01cb:
        if (r51 == 0) goto L_0x0309;
    L_0x01cd:
        if (r46 == 0) goto L_0x01d1;
    L_0x01cf:
        goto L_0x0309;
    L_0x01d1:
        r12 = 5;
        if (r1 != 0) goto L_0x01e5;
    L_0x01d4:
        if (r2 != 0) goto L_0x01e5;
    L_0x01d6:
        if (r23 != 0) goto L_0x01e5;
    L_0x01d8:
        if (r33 == 0) goto L_0x01e0;
    L_0x01da:
        r5 = 0;
        r13 = r35;
        r10.addGreaterThan(r13, r8, r5, r12);
    L_0x01e0:
        r1 = r8;
    L_0x01e1:
        r3 = 0;
        r4 = 6;
        goto L_0x0301;
    L_0x01e5:
        r5 = 0;
        r13 = r35;
        if (r1 == 0) goto L_0x01f2;
    L_0x01ea:
        if (r2 != 0) goto L_0x01f2;
    L_0x01ec:
        if (r33 == 0) goto L_0x01e0;
    L_0x01ee:
        r10.addGreaterThan(r13, r8, r5, r12);
        goto L_0x01e0;
    L_0x01f2:
        if (r1 != 0) goto L_0x020b;
    L_0x01f4:
        if (r2 == 0) goto L_0x020b;
    L_0x01f6:
        r4 = r39;
        r1 = r39.getMargin();
        r1 = -r1;
        r2 = r22;
        r3 = 6;
        r10.addEquality(r8, r2, r1, r3);
        if (r33 == 0) goto L_0x01e0;
    L_0x0205:
        r1 = r34;
        r10.addGreaterThan(r9, r1, r5, r12);
        goto L_0x01e0;
    L_0x020b:
        r12 = r22;
        r3 = 4;
        r4 = r39;
        if (r1 == 0) goto L_0x01e0;
    L_0x0212:
        if (r2 == 0) goto L_0x01e0;
    L_0x0214:
        if (r16 == 0) goto L_0x0279;
    L_0x0216:
        if (r33 == 0) goto L_0x0221;
    L_0x0218:
        r1 = r42;
        if (r1 != 0) goto L_0x0221;
    L_0x021c:
        r2 = 6;
        r10.addGreaterThan(r8, r9, r5, r2);
        goto L_0x0222;
    L_0x0221:
        r2 = 6;
    L_0x0222:
        if (r25 != 0) goto L_0x024c;
    L_0x0224:
        if (r15 > 0) goto L_0x022c;
    L_0x0226:
        if (r6 <= 0) goto L_0x0229;
    L_0x0228:
        goto L_0x022c;
    L_0x0229:
        r1 = 0;
        r3 = 6;
        goto L_0x022d;
    L_0x022c:
        r1 = 1;
    L_0x022d:
        r7 = r38.getMargin();
        r13 = r24;
        r10.addEquality(r9, r13, r7, r3);
        r7 = r39.getMargin();
        r7 = -r7;
        r10.addEquality(r8, r12, r7, r3);
        if (r15 > 0) goto L_0x0245;
    L_0x0240:
        if (r6 <= 0) goto L_0x0243;
    L_0x0242:
        goto L_0x0245;
    L_0x0243:
        r6 = 0;
        goto L_0x0246;
    L_0x0245:
        r6 = 1;
    L_0x0246:
        r17 = r1;
        r1 = r6;
        r6 = 1;
        r15 = 5;
        goto L_0x0280;
    L_0x024c:
        r13 = r24;
        r1 = r25;
        r6 = 1;
        if (r1 != r6) goto L_0x0258;
    L_0x0253:
        r1 = 1;
        r15 = 6;
    L_0x0255:
        r17 = 1;
        goto L_0x0280;
    L_0x0258:
        r2 = 3;
        if (r1 != r2) goto L_0x0277;
    L_0x025b:
        if (r45 != 0) goto L_0x0265;
    L_0x025d:
        r1 = r0.mResolvedDimensionRatioSide;
        r2 = -1;
        if (r1 == r2) goto L_0x0265;
    L_0x0262:
        if (r15 > 0) goto L_0x0265;
    L_0x0264:
        r3 = 6;
    L_0x0265:
        r1 = r38.getMargin();
        r10.addEquality(r9, r13, r1, r3);
        r1 = r39.getMargin();
        r1 = -r1;
        r10.addEquality(r8, r12, r1, r3);
        r1 = 1;
        r15 = 5;
        goto L_0x0255;
    L_0x0277:
        r1 = 0;
        goto L_0x027d;
    L_0x0279:
        r13 = r24;
        r6 = 1;
        r1 = 1;
    L_0x027d:
        r15 = 5;
        r17 = 0;
    L_0x0280:
        if (r1 == 0) goto L_0x02c6;
    L_0x0282:
        r7 = r38.getMargin();
        r18 = r39.getMargin();
        r1 = r10;
        r19 = 6;
        r2 = r9;
        r3 = r13;
        r0 = r4;
        r4 = r7;
        r7 = 0;
        r5 = r44;
        r29 = r13;
        r13 = 6;
        r19 = 1;
        r6 = r12;
        r13 = r29;
        r7 = r8;
        r11 = r8;
        r8 = r18;
        r30 = r11;
        r11 = r9;
        r9 = r15;
        r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9);
        r1 = r14.mTarget;
        r1 = r1.mOwner;
        r1 = r1 instanceof android.support.constraint.solver.widgets.Barrier;
        r2 = r0.mTarget;
        r2 = r2.mOwner;
        r2 = r2 instanceof android.support.constraint.solver.widgets.Barrier;
        if (r1 == 0) goto L_0x02be;
    L_0x02b5:
        if (r2 != 0) goto L_0x02be;
    L_0x02b7:
        r19 = r33;
        r1 = 1;
        r6 = 5;
        r28 = 6;
        goto L_0x02d1;
    L_0x02be:
        if (r1 != 0) goto L_0x02ca;
    L_0x02c0:
        if (r2 == 0) goto L_0x02ca;
    L_0x02c2:
        r1 = r33;
        r6 = 6;
        goto L_0x02cf;
    L_0x02c6:
        r0 = r4;
        r30 = r8;
        r11 = r9;
    L_0x02ca:
        r1 = r33;
        r19 = r1;
        r6 = 5;
    L_0x02cf:
        r28 = 5;
    L_0x02d1:
        if (r17 == 0) goto L_0x02d6;
    L_0x02d3:
        r2 = 6;
        r6 = 6;
        goto L_0x02d8;
    L_0x02d6:
        r2 = r28;
    L_0x02d8:
        if (r16 != 0) goto L_0x02dc;
    L_0x02da:
        if (r19 != 0) goto L_0x02de;
    L_0x02dc:
        if (r17 == 0) goto L_0x02e5;
    L_0x02de:
        r3 = r38.getMargin();
        r10.addGreaterThan(r11, r13, r3, r6);
    L_0x02e5:
        if (r16 != 0) goto L_0x02e9;
    L_0x02e7:
        if (r1 != 0) goto L_0x02eb;
    L_0x02e9:
        if (r17 == 0) goto L_0x02f6;
    L_0x02eb:
        r0 = r39.getMargin();
        r0 = -r0;
        r1 = r30;
        r10.addLowerThan(r1, r12, r0, r2);
        goto L_0x02f8;
    L_0x02f6:
        r1 = r30;
    L_0x02f8:
        if (r33 == 0) goto L_0x01e1;
    L_0x02fa:
        r2 = r34;
        r3 = 0;
        r4 = 6;
        r10.addGreaterThan(r11, r2, r3, r4);
    L_0x0301:
        if (r33 == 0) goto L_0x0308;
    L_0x0303:
        r5 = r35;
        r10.addGreaterThan(r5, r1, r3, r4);
    L_0x0308:
        return;
    L_0x0309:
        r1 = r8;
        r11 = r9;
        r2 = r34;
        r3 = 0;
        r4 = 6;
        r5 = r35;
        r6 = 2;
        if (r12 >= r6) goto L_0x031c;
    L_0x0314:
        if (r33 == 0) goto L_0x031c;
    L_0x0316:
        r10.addGreaterThan(r11, r2, r3, r4);
        r10.addGreaterThan(r5, r1, r3, r4);
    L_0x031c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.applyConstraints(android.support.constraint.solver.LinearSystem, boolean, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, android.support.constraint.solver.widgets.ConstraintAnchor, android.support.constraint.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }
}
