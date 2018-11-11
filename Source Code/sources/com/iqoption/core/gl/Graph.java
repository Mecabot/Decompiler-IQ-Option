package com.iqoption.core.gl;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.core.i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Keep
public final class Graph {
    public static final int GRAPH_TYPE_PREVIEW = 1;
    public static final int GRAPH_TYPE_REGULAR = 0;
    public static final int GRAPH_TYPE_REGULAR_LAND = 2;
    public static final int SCALE_BAR_TYPE_CFD = 2;
    public static final int SCALE_BAR_TYPE_LONG = 1;
    public static final int SCALE_BAR_TYPE_SHORT = 0;
    public static final int SCALE_BAR_TYPE_WALLET = 3;
    private static String TAG = "Graph";
    private static AssetManager assetManager;
    private static Lock initLock = new ReentrantLock();
    private static Condition initialized = initLock.newCondition();
    private static AtomicBoolean isInitialized = new AtomicBoolean();
    private GraphCallback callback;
    private long nativePtr;

    private static native long nCreate(int i, GraphCallback graphCallback);

    @Nullable
    public static native String nCreateInputs(@NonNull String str);

    @Nullable
    public static native String nCreateParams(@NonNull String str, @NonNull String str2);

    private static native void nInit(@NonNull AssetManager assetManager);

    public native void addCandleTimeUnsafeId(int i, int i2, int i3, long j, long j2, double d, double d2, double d3, double d4, double d5, long j3);

    public native void addCandleTimeUnsafeIds(int i, int i2, int i3, int[] iArr, long[] jArr, long[] jArr2, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, long[] jArr3);

    public native void addLiveDealUnsafe(long j, double d, long j2, double d2, int i, String str, int i2, int i3);

    public native void addNewLiveDeal(long j, double d, long j2, double d2, int i, String str, int i2, int i3);

    public native void addValueTimeId(int i, int i2, long j, long j2, long j3, double d, double d2, double d3, double d4, double d5);

    public native void finishCandlesBatchInsertion(int i);

    public native void finishLiveDealBatchInsertion();

    public native int getCandleColorType(String str);

    public native int getChartType(String str);

    public native void glchActionMove(float f, float f2, float f3);

    public native void glchActionMoveEnded();

    public native void glchActionScale(float f);

    public native int glchActionTouchBegin(float f, float f2);

    public native void glchActionTouchCanceled();

    public native int glchActionTouchEnd(float f, float f2);

    public native void glchActionTouchMovedToPoint(float f, float f2);

    public native void glchAddOrder(String str, int i, String str2, double d, double d2, double d3, double d4, int i2, long j, long j2, long j3, String str3, double d5, String str4, String str5, String str6, String str7);

    public native void glchAddPosition(int i, String str, String str2, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i2, int i3, long j, long j2, long j3, long j4, String str3, int i4, String str4, String str5, String str6, double d9, double d10, double d11, int i5, int i6, double d12, boolean z, long j5);

    public native void glchApplyAutoSize();

    public native void glchChartAddCandleTimeUnsafe(int i, int i2, int i3, long j, long j2, double d, double d2, double d3, double d4, double d5, long j3);

    public native void glchChartAddFirstCandleUnsafe(int i, int i2, long j, long j2, double d, double d2, double d3, double d4, double d5);

    public native void glchChartAddFirstCandlesUnsafe(int i, int i2, int[] iArr, long[] jArr, long[] jArr2, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5);

    public native void glchChartAddValueTime(int i, int i2, long j, long j2, long j3, double d, double d2, double d3, double d4, double d5, double d6, double d7);

    public native void glchClearOrders();

    public native void glchClearPositions();

    public native void glchClearVisibleUnits();

    public native void glchCommonSetDrawEnabled(int i);

    public native void glchCommonSetScaleFactor(float f);

    public native double glchDataGetMaxTimes(String str);

    public native double glchDataGetMaxValues(String str);

    public native double glchDataGetMinTimes(String str);

    public native double glchDataGetMinValues(String str);

    public native void glchDeleteOrder(String str, int i, String str2, double d, double d2, double d3, double d4, int i2, long j, long j2, long j3, String str3, double d5, String str4, String str5, String str6, String str7);

    public native void glchDeletePosition(int i, String str, String str2, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i2, int i3, long j, long j2, long j3, long j4, String str3, int i4, String str4, String str5, String str6, double d9, double d10, int i5, int i6, double d11, boolean z, long j5);

    public native void glchEnableAutoscale(int i);

    public native void glchInstrumentAdd(String str, int i, String str2, boolean z);

    public native boolean glchInstrumentExists(String str, int i);

    public native void glchInstrumentHide(String str, int i, boolean z);

    public native void glchInstrumentRemove(String str, int i);

    public native void glchInstrumentRemoveAll(String str);

    public native void glchInstrumentSelect(String str, int i);

    public native void glchInstrumentUnselectAll(String str);

    public native void glchInstrumentUpdate(String str, int i, String str2);

    public native int glchIsCandleDurationEqualToCurrent(int i, int i2);

    public native boolean glchIsInstrumentHidden(String str, int i);

    public native void glchLock();

    public native void glchOnAppUnfolding();

    public native void glchProviderTexts(String str, String str2);

    public native void glchRemoveAllResources();

    public native void glchSelectLimitOrder(double d, int i);

    public native void glchSetActiveTab(String str);

    public native void glchSetBetTickerExtendedView(boolean z);

    public native void glchSetBidAsk(String str, double d, double d2);

    public native void glchSetFeatureState(String str, String str2);

    public native void glchSetFirstDOSellExperience(int i);

    public native void glchSetLimitOrder(double d, int i, int i2);

    public native void glchSetProfitMaskText(String str);

    public native void glchSetPurchaseTexts(int i, String str, String str2);

    public native void glchSetSelectedPosition(String str, String str2);

    public native void glchSetServerTime(double d);

    public native void glchSetText(String str, String str2);

    public native void glchSetTimeScaleBarType(String str, int i);

    public native void glchSetTopTradersProfitMaskText(String str);

    public native void glchSetTradersMoodTexts(String str, String str2);

    public native void glchTabAdd(String str, long j);

    public native void glchTabAddAggregatedSmallDealCFD(int i, long j, double d, double d2, double d3, String str, String str2, String str3, String str4, String[] strArr, int i2);

    public native void glchTabAddBestTradersDeals(long j, String str);

    public native void glchTabAddBets(int i, int[] iArr, long[] jArr, int[] iArr2, int[] iArr3, double[] dArr, long[] jArr2, long[] jArr3, long[] jArr4, double[] dArr2, double[] dArr3, double[] dArr4);

    public native void glchTabAddSmallDeal(int i, long j, double d, double d2, double d3, String str, String str2, String str3, String str4, int i2);

    public native void glchTabAddSmallDealCFD(int i, long j, double d, double d2, double d3, String str, String str2, String str3, String str4, String str5, int i2);

    public native void glchTabAddStrike(int i, double d, String str, String str2, int i2, double d2, double d3, double d4, double d5, double d6, int i3, int i4, int i5);

    public native void glchTabClearBets();

    public native void glchTabDeleteStrike(String str);

    public native long glchTabGetActualTime(String str);

    public native double glchTabGetActualValue(String str);

    public native boolean glchTabHasVisibleChartWithoutHoles(String str);

    public native int glchTabIsDataAvailable(String str);

    public native void glchTabOnBetSelected(long j);

    public native void glchTabOnBetsProfitChange(long j, double d);

    public native void glchTabRemove(String str);

    public native void glchTabRemoveAll();

    public native void glchTabRemoveAllSmallDeals();

    public native void glchTabSelectStrike(String str, String str2);

    public native void glchTabSetActiveId(String str, int i);

    public native void glchTabSetAutoScale(String str, boolean z);

    public native void glchTabSetBestActiveId(String str, int i, String str2, String str3, int i2);

    public native void glchTabSetClosedBets(int i, int[] iArr, long[] jArr, int[] iArr2, int[] iArr3, double[] dArr, long[] jArr2, long[] jArr3, long[] jArr4, double[] dArr2, double[] dArr3, double[] dArr4);

    public native void glchTabSetDollarRate(double d);

    public native void glchTabSetExpirationTime(String str, int i, double d, double d2);

    public native void glchTabSetFinanceInstrument(String str, String str2);

    public native void glchTabSetFrame(float f, float f2, float f3, float f4, float f5);

    public native void glchTabSetHeikinashi(String str, boolean z);

    public native void glchTabSetHighLowVisible(int i);

    public native void glchTabSetMonochromeColor(String str);

    public native void glchTabSetPrecision(String str, int i);

    public native void glchTabSetSmallDealsEnabled(int i);

    public native void glchTabSetStartTime(String str, long j);

    public native void glchTabSetStrikesDisplayMode(String str, int i);

    public native void glchTabSetTimeScaleBarXOffsetAndPadding(double d, double d2, double d3);

    public native void glchTabSetTimes(String str, int i, int i2);

    public native void glchTabSetTradersMoodEnable(boolean z);

    public native void glchTabSetVariegatedColor(String str);

    public native void glchTabShowSignal(int i, int i2, long j, long j2, double d, double d2, String str, String str2, String str3, boolean z, long j3, String str4);

    public native void glchTabUpdateStrike(String str, double d, double d2, double d3, double d4, int i, int i2);

    public native void glchTradersMoodSetCallPercentage(int i, int i2, String str);

    public native void glchUnlock();

    public native void glchUpdatePosition(int i, String str, String str2, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i2, int i3, long j, long j2, long j3, long j4, String str3, int i4, String str4, String str5, String str6, double d9, double d10, double d11, int i5, int i6, double d12, boolean z, long j5);

    public native boolean isAutoScaleEnabled(String str);

    public native boolean isHeikenAshiEnabled(String str);

    public native boolean isLiveDealsEnabled(String str);

    public native boolean isTradersMoodEnabled(String str);

    public native void onDrawFrame();

    public native void onSurfaceChanged(int i, int i2, int i3, int i4, int i5, int i6, boolean z);

    public native void onSurfaceCreated(int i);

    public native void recycle();

    public native void setInterfaceMode(int i);

    public native void setLiveDealsEnabled(boolean z);

    public native void setRawImageByUrl(@NonNull String str, @NonNull Bitmap bitmap);

    public native void setUserMainInfo(long j, @NonNull String str, int i, @NonNull String str2, @NonNull String str3);

    public native void setUserWeekPlace(long j, int i);

    public native void setUserWeekProfit(long j, int i);

    public native void startCandlesBatchInsertion(int i);

    public native void startLiveDealBatchInsertion();

    public native void startSellPosition(String str);

    static {
        System.loadLibrary("game");
    }

    public static void setRequiresInit() {
        isInitialized.set(false);
    }

    public static void init(@NonNull Context context) {
        try {
            initLock.lock();
            if (!isInitialized.get()) {
                assetManager = context.getAssets();
                nInit(assetManager);
                isInitialized.set(true);
                initialized.signalAll();
            }
            initLock.unlock();
        } catch (Throwable th) {
            initLock.unlock();
        }
    }

    public static void await() {
        try {
            initLock.lock();
            if (!isInitialized.get()) {
                initialized.await();
            }
        } catch (Throwable e) {
            i.d(TAG, "GL initialization has been interrupted", e);
        } catch (Throwable th) {
            initLock.unlock();
        }
        initLock.unlock();
    }

    public Graph(int i) {
        this(i, null);
    }

    public Graph(int i, GraphCallback graphCallback) {
        if (graphCallback == null) {
            graphCallback = new a();
        }
        this.callback = graphCallback;
        this.nativePtr = nCreate(i, graphCallback);
    }

    public GraphCallback getCallback() {
        return this.callback;
    }
}
