package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.widget.Space;
import android.support.v7.gridlayout.R;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridLayout extends ViewGroup {
    private static final int ALIGNMENT_MODE = R.styleable.GridLayout_alignmentMode;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE = new Alignment() {
        String getDebugString() {
            return "BASELINE";
        }

        int getGravityOffset(View view, int i) {
            return 0;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            if (baseline == -1) {
                baseline = Integer.MIN_VALUE;
            }
            return baseline;
        }

        public Bounds getBounds() {
            return new Bounds() {
                private int size;

                protected void reset() {
                    super.reset();
                    this.size = Integer.MIN_VALUE;
                }

                protected void include(int i, int i2) {
                    super.include(i, i2);
                    this.size = Math.max(this.size, i + i2);
                }

                protected int size(boolean z) {
                    return Math.max(super.size(z), this.size);
                }

                protected int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
                    return Math.max(0, super.getOffset(gridLayout, view, alignment, i, z));
                }
            };
        }
    };
    public static final Alignment BOTTOM = TRAILING;
    static final int CAN_STRETCH = 2;
    public static final Alignment CENTER = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return i >> 1;
        }

        String getDebugString() {
            return "CENTER";
        }

        int getGravityOffset(View view, int i) {
            return i >> 1;
        }
    };
    private static final int COLUMN_COUNT = R.styleable.GridLayout_columnCount;
    private static final int COLUMN_ORDER_PRESERVED = R.styleable.GridLayout_columnOrderPreserved;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END = TRAILING;
    public static final Alignment FILL = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        String getDebugString() {
            return "FILL";
        }

        int getGravityOffset(View view, int i) {
            return 0;
        }

        public int getSizeInCell(View view, int i, int i2) {
            return i2;
        }
    };
    public static final int HORIZONTAL = 0;
    static final int INFLEXIBLE = 0;
    private static final Alignment LEADING = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return 0;
        }

        String getDebugString() {
            return "LEADING";
        }

        int getGravityOffset(View view, int i) {
            return 0;
        }
    };
    public static final Alignment LEFT = createSwitchingAlignment(START, END);
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final int MAX_SIZE = 100000;
    static final Printer NO_PRINTER = new Printer() {
        public void println(String str) {
        }
    };
    private static final int ORIENTATION = R.styleable.GridLayout_orientation;
    public static final Alignment RIGHT = createSwitchingAlignment(END, START);
    private static final int ROW_COUNT = R.styleable.GridLayout_rowCount;
    private static final int ROW_ORDER_PRESERVED = R.styleable.GridLayout_rowOrderPreserved;
    public static final Alignment START = LEADING;
    public static final Alignment TOP = LEADING;
    private static final Alignment TRAILING = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return i;
        }

        String getDebugString() {
            return "TRAILING";
        }

        int getGravityOffset(View view, int i) {
            return i;
        }
    };
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        String getDebugString() {
            return "UNDEFINED";
        }

        int getGravityOffset(View view, int i) {
            return Integer.MIN_VALUE;
        }
    };
    static final int UNINITIALIZED_HASH = 0;
    private static final int USE_DEFAULT_MARGINS = R.styleable.GridLayout_useDefaultMargins;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;

    public static abstract class Alignment {
        abstract int getAlignmentValue(View view, int i, int i2);

        abstract String getDebugString();

        abstract int getGravityOffset(View view, int i);

        int getSizeInCell(View view, int i, int i2) {
            return i;
        }

        Alignment() {
        }

        Bounds getBounds() {
            return new Bounds();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Alignment:");
            stringBuilder.append(getDebugString());
            return stringBuilder.toString();
        }
    }

    static final class Arc {
        public final Interval span;
        public boolean valid = GridLayout.DEFAULT_ORDER_PRESERVED;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.span);
            stringBuilder.append(" ");
            stringBuilder.append(!this.valid ? "+>" : "->");
            stringBuilder.append(" ");
            stringBuilder.append(this.value);
            return stringBuilder.toString();
        }
    }

    static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc(cls, cls2);
        }

        public void put(K k, V v) {
            add(Pair.create(k, v));
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.valueType, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = ((Pair) get(i)).first;
                objArr2[i] = ((Pair) get(i)).second;
            }
            return new PackedMap(objArr, objArr2);
        }
    }

    final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int COMPLETE = 2;
        static final int NEW = 0;
        static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid = false;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid = false;
        public int definedCount = Integer.MIN_VALUE;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid = false;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid = false;
        public boolean hasWeights;
        public boolean hasWeightsValid = false;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid = false;
        public int[] locations;
        public boolean locationsValid = false;
        private int maxIndex = Integer.MIN_VALUE;
        boolean orderPreserved = GridLayout.DEFAULT_ORDER_PRESERVED;
        private MutableInt parentMax = new MutableInt(-100000);
        private MutableInt parentMin = new MutableInt(0);
        public int[] trailingMargins;
        public boolean trailingMarginsValid = false;

        static {
            Class cls = GridLayout.class;
        }

        Axis(boolean z) {
            this.horizontal = z;
        }

        private int calculateMaxIndex() {
            int childCount = GridLayout.this.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                i = Math.max(Math.max(Math.max(i, interval.min), interval.max), interval.size());
            }
            return i == -1 ? Integer.MIN_VALUE : i;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public void setCount(int i) {
            if (i != Integer.MIN_VALUE && i < getMaxIndex()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.horizontal ? "column" : "row");
                stringBuilder.append("Count must be greater than or equal to the maximum of all grid indices ");
                stringBuilder.append("(and spans) defined in the LayoutParams of each child");
                GridLayout.handleInvalidParams(stringBuilder.toString());
            }
            this.definedCount = i;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void setOrderPreserved(boolean z) {
            this.orderPreserved = z;
            invalidateStructure();
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc of = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                of.put(spec, spec.getAbsoluteAlignment(this.horizontal).getBounds());
            }
            return of.pack();
        }

        private void computeGroupBounds() {
            int i;
            Bounds[] boundsArr = (Bounds[]) this.groupBounds.values;
            for (Bounds reset : boundsArr) {
                reset.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (i = 0; i < childCount; i++) {
                int i2;
                View childAt = GridLayout.this.getChildAt(i);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                int measurementIncludingMargin = GridLayout.this.getMeasurementIncludingMargin(childAt, this.horizontal);
                if (spec.weight == 0.0f) {
                    i2 = 0;
                } else {
                    i2 = getDeltas()[i];
                }
                ((Bounds) this.groupBounds.getValue(i)).include(GridLayout.this, childAt, spec, this, measurementIncludingMargin + i2);
            }
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.groupBounds;
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z) {
            Assoc of = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = (Spec[]) getGroupBounds().keys;
            int length = specArr.length;
            for (int i = 0; i < length; i++) {
                of.put(z ? specArr[i].span : specArr[i].span.inverse(), new MutableInt());
            }
            return of.pack();
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            int size;
            MutableInt mutableInt;
            MutableInt[] mutableIntArr = (MutableInt[]) packedMap.values;
            for (MutableInt mutableInt2 : mutableIntArr) {
                mutableInt2.reset();
            }
            Bounds[] boundsArr = (Bounds[]) getGroupBounds().values;
            for (int i = 0; i < boundsArr.length; i++) {
                size = boundsArr[i].size(z);
                mutableInt2 = (MutableInt) packedMap.getValue(i);
                int i2 = mutableInt2.value;
                if (!z) {
                    size = -size;
                }
                mutableInt2.value = Math.max(i2, size);
            }
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(GridLayout.DEFAULT_ORDER_PRESERVED);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, GridLayout.DEFAULT_ORDER_PRESERVED);
                this.forwardLinksValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.forwardLinks;
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.backwardLinks;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.size() != 0) {
                if (z) {
                    for (Arc arc : list) {
                        if (arc.span.equals(interval)) {
                            return;
                        }
                    }
                }
                list.add(new Arc(interval, mutableInt));
            }
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, GridLayout.DEFAULT_ORDER_PRESERVED);
        }

        Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int i;
            int i2;
            int count = getCount() + 1;
            Arc[][] arcArr2 = new Arc[count][];
            int[] iArr = new int[count];
            int i3 = 0;
            for (Arc arc : arcArr) {
                i2 = arc.span.min;
                iArr[i2] = iArr[i2] + 1;
            }
            for (i = 0; i < iArr.length; i++) {
                arcArr2[i] = new Arc[iArr[i]];
            }
            Arrays.fill(iArr, 0);
            i = arcArr.length;
            while (i3 < i) {
                Arc arc2 = arcArr[i3];
                i2 = arc2.span.min;
                Arc[] arcArr3 = arcArr2[i2];
                int i4 = iArr[i2];
                iArr[i2] = i4 + 1;
                arcArr3[i4] = arc2;
                i3++;
            }
            return arcArr2;
        }

        private Arc[] topologicalSort(final Arc[] arcArr) {
            return new Object() {
                static final /* synthetic */ boolean $assertionsDisabled = false;
                Arc[][] arcsByVertex = Axis.this.groupArcsByFirstVertex(arcArr);
                int cursor = (this.result.length - 1);
                Arc[] result = new Arc[arcArr.length];
                int[] visited = new int[(Axis.this.getCount() + 1)];

                static {
                    Class cls = GridLayout.class;
                }

                void walk(int i) {
                    switch (this.visited[i]) {
                        case 0:
                            this.visited[i] = 1;
                            for (Arc arc : this.arcsByVertex[i]) {
                                walk(arc.span.max);
                                Arc[] arcArr = this.result;
                                int i2 = this.cursor;
                                this.cursor = i2 - 1;
                                arcArr[i2] = arc;
                            }
                            this.visited[i] = 2;
                            return;
                        default:
                            return;
                    }
                }

                Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i = 0; i < length; i++) {
                        walk(i);
                    }
                    return this.result;
                }
            }.sort();
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            for (int i = 0; i < ((Interval[]) packedMap.keys).length; i++) {
                include(list, ((Interval[]) packedMap.keys)[i], ((MutableInt[]) packedMap.values)[i], false);
            }
        }

        private Arc[] createArcs() {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                i = 0;
                while (i < getCount()) {
                    int i2 = i + 1;
                    include(arrayList, new Interval(i, i2), new MutableInt(0));
                    i = i2;
                }
            }
            i = getCount();
            include(arrayList, new Interval(0, i), this.parentMin, false);
            include(arrayList2, new Interval(i, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort(arrayList), topologicalSort(arrayList2));
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.arcs;
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (!arc.valid) {
                return false;
            }
            Interval interval = arc.span;
            int i = interval.min;
            int i2 = interval.max;
            i = iArr[i] + arc.value.value;
            if (i <= iArr[i2]) {
                return false;
            }
            iArr[i2] = i;
            return GridLayout.DEFAULT_ORDER_PRESERVED;
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private String arcsToString(List<Arc> list) {
            String str = this.horizontal ? "x" : "y";
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (Arc arc : list) {
                StringBuilder stringBuilder2;
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(", ");
                }
                int i = arc.span.min;
                int i2 = arc.span.max;
                int i3 = arc.value.value;
                if (i < i2) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(i2);
                    stringBuilder2.append("-");
                    stringBuilder2.append(str);
                    stringBuilder2.append(i);
                    stringBuilder2.append(">=");
                } else {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(i);
                    stringBuilder2.append("-");
                    stringBuilder2.append(str);
                    stringBuilder2.append(i2);
                    stringBuilder2.append("<=");
                    i3 = -i3;
                }
                stringBuilder2.append(i3);
                stringBuilder.append(stringBuilder2.toString());
            }
            return stringBuilder.toString();
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (int i = 0; i < arcArr.length; i++) {
                Arc arc = arcArr[i];
                if (zArr[i]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
            }
            Printer printer = GridLayout.this.mPrinter;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" constraints: ");
            stringBuilder.append(arcsToString(arrayList));
            stringBuilder.append(" are inconsistent; permanently removing: ");
            stringBuilder.append(arcsToString(arrayList2));
            stringBuilder.append(". ");
            printer.println(stringBuilder.toString());
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, GridLayout.DEFAULT_ORDER_PRESERVED);
        }

        private boolean solve(Arc[] arcArr, int[] iArr, boolean z) {
            String str = this.horizontal ? "horizontal" : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i = 0; i < arcArr.length; i++) {
                int i2;
                int length;
                init(iArr);
                for (int i3 = 0; i3 < count; i3++) {
                    i2 = 0;
                    for (Arc relax : arcArr) {
                        i2 |= relax(iArr, relax);
                    }
                    if (i2 == 0) {
                        if (zArr != null) {
                            logError(str, arcArr, zArr);
                        }
                        return GridLayout.DEFAULT_ORDER_PRESERVED;
                    }
                }
                if (!z) {
                    return false;
                }
                int i4;
                boolean[] zArr2 = new boolean[arcArr.length];
                for (i4 = 0; i4 < count; i4++) {
                    length = arcArr.length;
                    for (i2 = 0; i2 < length; i2++) {
                        zArr2[i2] = zArr2[i2] | relax(iArr, arcArr[i2]);
                    }
                }
                if (i == 0) {
                    zArr = zArr2;
                }
                for (i4 = 0; i4 < arcArr.length; i4++) {
                    if (zArr2[i4]) {
                        Arc arc = arcArr[i4];
                        if (arc.span.min >= arc.span.max) {
                            arc.valid = false;
                            break;
                        }
                    }
                }
            }
            return GridLayout.DEFAULT_ORDER_PRESERVED;
        }

        private void computeMargins(boolean z) {
            int[] iArr = z ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i2 = z ? interval.min : interval.max;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.getMargin1(childAt, this.horizontal, z));
                }
            }
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[(getCount() + 1)];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(GridLayout.DEFAULT_ORDER_PRESERVED);
                this.leadingMarginsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.leadingMargins;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[(getCount() + 1)];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.trailingMargins;
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                        return GridLayout.DEFAULT_ORDER_PRESERVED;
                    }
                }
            }
            return false;
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.hasWeights;
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        private void shareOutDelta(int i, float f) {
            int i2 = 0;
            Arrays.fill(this.deltas, 0);
            int childCount = GridLayout.this.getChildCount();
            while (i2 < childCount) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    float f2 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                    if (f2 != 0.0f) {
                        int round = Math.round((((float) i) * f2) / f);
                        this.deltas[i2] = round;
                        i -= round;
                        f -= f2;
                    }
                }
                i2++;
            }
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), 0);
            solve(iArr);
            int childCount = (this.parentMin.value * GridLayout.this.getChildCount()) + 1;
            if (childCount >= 2) {
                float calculateTotalWeight = calculateTotalWeight();
                int i = childCount;
                childCount = 0;
                boolean z = GridLayout.DEFAULT_ORDER_PRESERVED;
                while (childCount < i) {
                    int i2 = (int) ((((long) childCount) + ((long) i)) / 2);
                    invalidateValues();
                    shareOutDelta(i2, calculateTotalWeight);
                    boolean solve = solve(getArcs(), iArr, false);
                    if (solve) {
                        childCount = i2 + 1;
                    }
                    i = i2;
                    z = solve;
                }
                if (-1 > null && !z) {
                    invalidateValues();
                    shareOutDelta(-1, calculateTotalWeight);
                    solve(iArr);
                }
            }
        }

        private float calculateTotalWeight() {
            int childCount = GridLayout.this.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                }
            }
            return f;
        }

        private void computeLocations(int[] iArr) {
            if (hasWeights()) {
                solveAndDistributeSpace(iArr);
            } else {
                solve(iArr);
            }
            if (!this.orderPreserved) {
                int i = 0;
                int i2 = iArr[0];
                int length = iArr.length;
                while (i < length) {
                    iArr[i] = iArr[i] - i2;
                    i++;
                }
            }
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[(getCount() + 1)];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.locations;
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private void setParentConstraints(int i, int i2) {
            this.parentMin.value = i;
            this.parentMax.value = -i2;
            this.locationsValid = false;
        }

        private int getMeasure(int i, int i2) {
            setParentConstraints(i, i2);
            return size(getLocations());
        }

        public int getMeasure(int i) {
            int mode = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                return getMeasure(0, i);
            }
            if (mode == 0) {
                return getMeasure(0, GridLayout.MAX_SIZE);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return getMeasure(i, i);
        }

        public void layout(int i) {
            setParentConstraints(i, i);
            getLocations();
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }
    }

    static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        Bounds() {
            reset();
        }

        protected void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        protected void include(int i, int i2) {
            this.before = Math.max(this.before, i);
            this.after = Math.max(this.after, i2);
        }

        protected int size(boolean z) {
            if (z || !GridLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return GridLayout.MAX_SIZE;
        }

        protected int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
            return this.before - alignment.getAlignmentValue(view, i, ViewGroupCompat.getLayoutMode(gridLayout));
        }

        protected final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(view, i, ViewGroupCompat.getLayoutMode(gridLayout));
            include(alignmentValue, i - alignmentValue);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bounds{before=");
            stringBuilder.append(this.before);
            stringBuilder.append(", after=");
            stringBuilder.append(this.after);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        int size() {
            return this.max - this.min;
        }

        Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return (this.max == interval.max && this.min == interval.min) ? GridLayout.DEFAULT_ORDER_PRESERVED : false;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(this.min);
            stringBuilder.append(", ");
            stringBuilder.append(this.max);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        private static final int BOTTOM_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginBottom;
        private static final int COLUMN = R.styleable.GridLayout_Layout_layout_column;
        private static final int COLUMN_SPAN = R.styleable.GridLayout_Layout_layout_columnSpan;
        private static final int COLUMN_WEIGHT = R.styleable.GridLayout_Layout_layout_columnWeight;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN = new Interval(Integer.MIN_VALUE, -2147483647);
        private static final int DEFAULT_SPAN_SIZE = DEFAULT_SPAN.size();
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY = R.styleable.GridLayout_Layout_layout_gravity;
        private static final int LEFT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginLeft;
        private static final int MARGIN = R.styleable.GridLayout_Layout_android_layout_margin;
        private static final int RIGHT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginRight;
        private static final int ROW = R.styleable.GridLayout_Layout_layout_row;
        private static final int ROW_SPAN = R.styleable.GridLayout_Layout_layout_rowSpan;
        private static final int ROW_WEIGHT = R.styleable.GridLayout_Layout_layout_rowWeight;
        private static final int TOP_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginTop;
        public Spec columnSpec;
        public Spec rowSpec;

        private LayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Spec spec, Spec spec2) {
            super(i, i2);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            setMargins(i3, i4, i5, i6);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        public LayoutParams() {
            this(Spec.UNDEFINED, Spec.UNDEFINED);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(MARGIN, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int i = obtainStyledAttributes.getInt(GRAVITY, 0);
                this.columnSpec = GridLayout.spec(obtainStyledAttributes.getInt(COLUMN, Integer.MIN_VALUE), obtainStyledAttributes.getInt(COLUMN_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, GridLayout.DEFAULT_ORDER_PRESERVED), obtainStyledAttributes.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(obtainStyledAttributes.getInt(ROW, Integer.MIN_VALUE), obtainStyledAttributes.getInt(ROW_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, false), obtainStyledAttributes.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public void setGravity(int i) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i, GridLayout.DEFAULT_ORDER_PRESERVED));
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, -2);
            this.height = typedArray.getLayoutDimension(i2, -2);
        }

        final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }

        final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return (this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec)) ? GridLayout.DEFAULT_ORDER_PRESERVED : false;
        }

        public int hashCode() {
            return (this.rowSpec.hashCode() * 31) + this.columnSpec.hashCode();
        }
    }

    static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int i) {
            this.value = i;
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        PackedMap(K[] kArr, V[] vArr) {
            this.index = createIndex(kArr);
            this.keys = compact(kArr, this.index);
            this.values = compact(vArr, this.index);
        }

        public V getValue(int i) {
            return this.values[this.index[i]];
        }

        private static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            Map hashMap = new HashMap();
            for (int i = 0; i < length; i++) {
                Object obj = kArr[i];
                Integer num = (Integer) hashMap.get(obj);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(obj, num);
                }
                iArr[i] = num.intValue();
            }
            return iArr;
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            Object[] objArr = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1);
            for (int i = 0; i < length; i++) {
                objArr[iArr[i]] = kArr[i];
            }
            return objArr;
        }
    }

    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        private Spec(boolean z, Interval interval, Alignment alignment, float f) {
            this.startDefined = z;
            this.span = interval;
            this.alignment = alignment;
            this.weight = f;
        }

        Spec(boolean z, int i, int i2, Alignment alignment, float f) {
            this(z, new Interval(i, i2 + i), alignment, f);
        }

        public Alignment getAbsoluteAlignment(boolean z) {
            if (this.alignment != GridLayout.UNDEFINED_ALIGNMENT) {
                return this.alignment;
            }
            if (this.weight != 0.0f) {
                return GridLayout.FILL;
            }
            return z ? GridLayout.START : GridLayout.BASELINE;
        }

        final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        final Spec copyWriteAlignment(Alignment alignment) {
            return new Spec(this.startDefined, this.span, alignment, this.weight);
        }

        final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            return (this.alignment.equals(spec.alignment) && this.span.equals(spec.span)) ? GridLayout.DEFAULT_ORDER_PRESERVED : false;
        }

        public int hashCode() {
            return (this.span.hashCode() * 31) + this.alignment.hashCode();
        }
    }

    static boolean canStretch(int i) {
        return (i & 2) != 0 ? DEFAULT_ORDER_PRESERVED : false;
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHorizontalAxis = new Axis(DEFAULT_ORDER_PRESERVED);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(R.dimen.default_gap);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(ROW_COUNT, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(COLUMN_COUNT, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(ORIENTATION, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(USE_DEFAULT_MARGINS, false));
            setAlignmentMode(obtainStyledAttributes.getInt(ALIGNMENT_MODE, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(ROW_ORDER_PRESERVED, DEFAULT_ORDER_PRESERVED));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(COLUMN_ORDER_PRESERVED, DEFAULT_ORDER_PRESERVED));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            invalidateStructure();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public void setRowCount(int i) {
        this.mVerticalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public void setColumnCount(int i) {
        this.mHorizontalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public void setUseDefaultMargins(boolean z) {
        this.mUseDefaultMargins = z;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public void setAlignmentMode(int i) {
        this.mAlignmentMode = i;
        requestLayout();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    public void setRowOrderPreserved(boolean z) {
        this.mVerticalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.mHorizontalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    static int max2(int[] iArr, int i) {
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        System.arraycopy(tArr2, 0, objArr, tArr.length, tArr2.length);
        return objArr;
    }

    static Alignment getAlignment(int i, boolean z) {
        i = (i & (z ? 7 : 112)) >> (z ? 0 : 4);
        if (i == 1) {
            return CENTER;
        }
        if (i == 3) {
            return z ? LEFT : TOP;
        } else if (i == 5) {
            return z ? RIGHT : BOTTOM;
        } else if (i == 7) {
            return FILL;
        } else {
            if (i == GravityCompat.START) {
                return START;
            }
            if (i != GravityCompat.END) {
                return UNDEFINED_ALIGNMENT;
            }
            return END;
        }
    }

    private int getDefaultMargin(View view, boolean z, boolean z2) {
        return (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) ? 0 : this.mDefaultGap / 2;
    }

    private int getDefaultMargin(View view, boolean z, boolean z2, boolean z3) {
        return getDefaultMargin(view, z2, z3);
    }

    private int getDefaultMargin(View view, LayoutParams layoutParams, boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval interval = spec.span;
        boolean z4 = (z && isLayoutRtlCompat()) ? !z2 ? DEFAULT_ORDER_PRESERVED : false : z2;
        if (z4 ? interval.min != 0 : interval.max != axis.getCount()) {
            z3 = DEFAULT_ORDER_PRESERVED;
        }
        return getDefaultMargin(view, z3, z, z2);
    }

    int getMargin1(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = getLayoutParams(view);
        int i = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        return i == Integer.MIN_VALUE ? getDefaultMargin(view, layoutParams, z, z2) : i;
    }

    private boolean isLayoutRtlCompat() {
        return ViewCompat.getLayoutDirection(this) == 1 ? DEFAULT_ORDER_PRESERVED : false;
    }

    private int getMargin(View view, boolean z, boolean z2) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z, z2);
        }
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z2 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        return leadingMargins[z2 ? spec.span.min : spec.span.max];
    }

    private int getTotalMargin(View view, boolean z) {
        return getMargin(view, z, DEFAULT_ORDER_PRESERVED) + getMargin(view, z, false);
    }

    private static boolean fits(int[] iArr, int i, int i2, int i3) {
        if (i3 > iArr.length) {
            return false;
        }
        while (i2 < i3) {
            if (iArr[i2] > i) {
                return false;
            }
            i2++;
        }
        return DEFAULT_ORDER_PRESERVED;
    }

    private static void procrusteanFill(int[] iArr, int i, int i2, int i3) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i, length), Math.min(i2, length), i3);
    }

    private static void setCellGroup(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.setRowSpecSpan(new Interval(i, i2 + i));
        layoutParams.setColumnSpecSpan(new Interval(i3, i4 + i3));
    }

    private static int clip(Interval interval, boolean z, int i) {
        int size = interval.size();
        if (i == 0) {
            return size;
        }
        return Math.min(size, i - (z ? Math.min(interval.min, i) : 0));
    }

    private void validateLayoutParams() {
        Object obj = this.mOrientation == 0 ? 1 : null;
        Axis axis = obj != null ? this.mHorizontalAxis : this.mVerticalAxis;
        int i = axis.definedCount != Integer.MIN_VALUE ? axis.definedCount : 0;
        int[] iArr = new int[i];
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            Spec spec = obj != null ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z = spec.startDefined;
            int size = interval.size();
            if (z) {
                i3 = interval.min;
            }
            Spec spec2 = obj != null ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z2 = spec2.startDefined;
            int clip = clip(interval2, z2, i);
            if (z2) {
                i2 = interval2.min;
            }
            if (i != 0) {
                if (!z || !z2) {
                    while (true) {
                        int i5 = i2 + clip;
                        if (fits(iArr, i3, i2, i5)) {
                            break;
                        } else if (z2) {
                            i3++;
                        } else if (i5 <= i) {
                            i2++;
                        } else {
                            i3++;
                            i2 = 0;
                        }
                    }
                }
                procrusteanFill(iArr, i2, i2 + clip, i3 + size);
            }
            if (obj != null) {
                setCellGroup(layoutParams, i3, size, i2, clip);
            } else {
                setCellGroup(layoutParams, i2, clip, i3, size);
            }
            i2 += clip;
        }
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        if (this.mHorizontalAxis != null) {
            this.mHorizontalAxis.invalidateStructure();
        }
        if (this.mVerticalAxis != null) {
            this.mVerticalAxis.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        if (this.mHorizontalAxis != null && this.mVerticalAxis != null) {
            this.mHorizontalAxis.invalidateValues();
            this.mVerticalAxis.invalidateValues();
        }
    }

    final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    static void handleInvalidParams(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(". ");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z) {
        StringBuilder stringBuilder;
        String str = z ? "column" : "row";
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        if (interval.min != Integer.MIN_VALUE && interval.min < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" indices must be positive");
            handleInvalidParams(stringBuilder.toString());
        }
        int i = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i != Integer.MIN_VALUE) {
            if (interval.max > i) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" indices (start + span) mustn't exceed the ");
                stringBuilder.append(str);
                stringBuilder.append(" count");
                handleInvalidParams(stringBuilder.toString());
            }
            if (interval.size() > i) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(" span mustn't exceed the ");
                stringBuilder2.append(str);
                stringBuilder2.append(" count");
                handleInvalidParams(stringBuilder2.toString());
            }
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        checkLayoutParams(layoutParams2, DEFAULT_ORDER_PRESERVED);
        checkLayoutParams(layoutParams2, false);
        return DEFAULT_ORDER_PRESERVED;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    private void drawLine(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (isLayoutRtlCompat()) {
            int width = getWidth();
            canvas.drawLine((float) (width - i5), (float) i6, (float) (width - i7), (float) i8, paint);
            return;
        }
        canvas.drawLine((float) i5, (float) i6, (float) i7, (float) i8, paint);
    }

    private int computeLayoutParamsHashCode() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                i = (i * 31) + ((LayoutParams) childAt.getLayoutParams()).hashCode();
            }
        }
        return i;
    }

    private void consistencyCheck() {
        if (this.mLastLayoutParamsHashCode == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (this.mLastLayoutParamsHashCode != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private void measureChildWithMargins2(View view, int i, int i2, int i3, int i4) {
        view.measure(getChildMeasureSpec(i, getTotalMargin(view, DEFAULT_ORDER_PRESERVED), i3), getChildMeasureSpec(i2, getTotalMargin(view, false), i4));
    }

    private void measureChildrenWithMargins(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z) {
                    measureChildWithMargins2(childAt, i, i2, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0 ? DEFAULT_ORDER_PRESERVED : false;
                    Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.getAbsoluteAlignment(z2) == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z2);
                        if (z2) {
                            measureChildWithMargins2(childAt, i, i2, totalMargin, layoutParams.height);
                        } else {
                            measureChildWithMargins2(childAt, i, i2, layoutParams.width, totalMargin);
                        }
                    }
                }
            }
        }
    }

    static int adjust(int i, int i2) {
        return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2 + i), MeasureSpec.getMode(i));
    }

    protected void onMeasure(int i, int i2) {
        int measure;
        consistencyCheck();
        invalidateValues();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int adjust = adjust(i, -paddingLeft);
        int adjust2 = adjust(i2, -paddingTop);
        measureChildrenWithMargins(adjust, adjust2, DEFAULT_ORDER_PRESERVED);
        if (this.mOrientation == 0) {
            measure = this.mHorizontalAxis.getMeasure(adjust);
            measureChildrenWithMargins(adjust, adjust2, false);
            int i3 = measure;
            measure = this.mVerticalAxis.getMeasure(adjust2);
            adjust = i3;
        } else {
            measure = this.mVerticalAxis.getMeasure(adjust2);
            measureChildrenWithMargins(adjust, adjust2, false);
            adjust = this.mHorizontalAxis.getMeasure(adjust);
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(adjust + paddingLeft, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(Math.max(measure + paddingTop, getSuggestedMinimumHeight()), i2, 0));
    }

    private int getMeasurement(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    final int getMeasurementIncludingMargin(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(view, z) + getTotalMargin(view, z);
    }

    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        consistencyCheck();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.mHorizontalAxis.layout((i5 - paddingLeft) - paddingRight);
        this.mVerticalAxis.layout((i6 - paddingTop) - paddingBottom);
        int[] locations = this.mHorizontalAxis.getLocations();
        int[] locations2 = this.mVerticalAxis.getLocations();
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        while (i7 < childCount) {
            int[] iArr;
            int[] iArr2;
            int i8;
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                iArr = locations;
                iArr2 = locations2;
                i8 = childCount;
            } else {
                LayoutParams layoutParams = getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i9 = locations[interval.min];
                int i10 = locations2[interval2.min];
                int i11 = locations[interval.max] - i9;
                int i12 = locations2[interval2.max] - i10;
                int measurement = getMeasurement(childAt, DEFAULT_ORDER_PRESERVED);
                int measurement2 = getMeasurement(childAt, z2);
                Alignment absoluteAlignment = spec.getAbsoluteAlignment(DEFAULT_ORDER_PRESERVED);
                Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(z2);
                Bounds bounds = (Bounds) this.mHorizontalAxis.getGroupBounds().getValue(i7);
                Bounds bounds2 = (Bounds) this.mVerticalAxis.getGroupBounds().getValue(i7);
                int i13 = measurement2;
                iArr = locations;
                int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i11 - bounds.size(DEFAULT_ORDER_PRESERVED));
                Alignment alignment = absoluteAlignment;
                int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i12 - bounds2.size(DEFAULT_ORDER_PRESERVED));
                int margin = getMargin(childAt, DEFAULT_ORDER_PRESERVED, DEFAULT_ORDER_PRESERVED);
                int margin2 = getMargin(childAt, false, DEFAULT_ORDER_PRESERVED);
                int margin3 = getMargin(childAt, DEFAULT_ORDER_PRESERVED, false);
                int i14 = margin + margin3;
                int margin4 = margin2 + getMargin(childAt, false, false);
                Alignment alignment2 = absoluteAlignment2;
                Bounds bounds3 = bounds;
                Alignment alignment3 = alignment;
                Bounds bounds4 = bounds2;
                Alignment alignment4 = alignment2;
                int i15 = i13;
                iArr2 = locations2;
                int i16 = measurement;
                View view = childAt;
                i13 = bounds3.getOffset(this, childAt, alignment3, measurement + i14, DEFAULT_ORDER_PRESERVED);
                int i17 = i15;
                View view2 = view;
                i8 = childCount;
                childCount = i17;
                i6 = bounds4.getOffset(this, view2, alignment4, i17 + margin4, false);
                paddingBottom = alignment3.getSizeInCell(view2, i16, i11 - i14);
                measurement2 = alignment4.getSizeInCell(view2, childCount, i12 - margin4);
                i9 = (i9 + gravityOffset) + i13;
                measurement = !isLayoutRtlCompat() ? (paddingLeft + margin) + i9 : (((i5 - paddingBottom) - paddingRight) - margin3) - i9;
                i6 = (((paddingTop + i10) + gravityOffset2) + i6) + margin2;
                if (!(paddingBottom == view2.getMeasuredWidth() && measurement2 == view2.getMeasuredHeight())) {
                    view2.measure(MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824), MeasureSpec.makeMeasureSpec(measurement2, 1073741824));
                }
                view2.layout(measurement, i6, paddingBottom + measurement, measurement2 + i6);
            }
            i7++;
            locations = iArr;
            locations2 = iArr2;
            childCount = i8;
            z2 = false;
        }
    }

    public static Spec spec(int i, int i2, Alignment alignment, float f) {
        return new Spec(i != Integer.MIN_VALUE ? DEFAULT_ORDER_PRESERVED : false, i, i2, alignment, f);
    }

    public static Spec spec(int i, Alignment alignment, float f) {
        return spec(i, 1, alignment, f);
    }

    public static Spec spec(int i, int i2, float f) {
        return spec(i, i2, UNDEFINED_ALIGNMENT, f);
    }

    public static Spec spec(int i, float f) {
        return spec(i, 1, f);
    }

    public static Spec spec(int i, int i2, Alignment alignment) {
        return spec(i, i2, alignment, 0.0f);
    }

    public static Spec spec(int i, Alignment alignment) {
        return spec(i, 1, alignment);
    }

    public static Spec spec(int i, int i2) {
        return spec(i, i2, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i) {
        return spec(i, 1);
    }

    private static Alignment createSwitchingAlignment(final Alignment alignment, final Alignment alignment2) {
        return new Alignment() {
            int getGravityOffset(View view, int i) {
                Object obj = 1;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    obj = null;
                }
                return (obj == null ? alignment : alignment2).getGravityOffset(view, i);
            }

            public int getAlignmentValue(View view, int i, int i2) {
                Object obj = 1;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    obj = null;
                }
                return (obj == null ? alignment : alignment2).getAlignmentValue(view, i, i2);
            }

            String getDebugString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SWITCHING[L:");
                stringBuilder.append(alignment.getDebugString());
                stringBuilder.append(", R:");
                stringBuilder.append(alignment2.getDebugString());
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        };
    }
}
