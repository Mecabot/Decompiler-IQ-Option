package com.iqoption.charttools.tools;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import com.iqoption.app.IQApp;
import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.model.chart.ChartType;
import com.iqoption.charttools.model.indicator.v;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.tools.data.SettingType;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \\2\u00020\u0001:\u0003\\]^B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u0018\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020CH\u0002J\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00050E2\u0006\u0010B\u001a\u00020\u0013H\u0002J \u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020\"2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020CH\u0002J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004J\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004J\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00050\u00042\u0006\u0010B\u001a\u00020\u0013J\u0006\u0010K\u001a\u00020=J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0\u0004J\b\u0010M\u001a\u00020=H\u0014J\u0006\u0010N\u001a\u00020=J\u000e\u0010O\u001a\u00020=2\u0006\u0010P\u001a\u00020QJ\u000e\u0010R\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u000e\u0010S\u001a\u00020\f2\u0006\u0010P\u001a\u00020QJ\u0006\u0010T\u001a\u00020=J\u0016\u0010U\u001a\u00020=2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020CJ\u000e\u0010V\u001a\u00020=2\u0006\u0010B\u001a\u00020CJ\u0010\u0010W\u001a\u00020=2\b\u0010X\u001a\u0004\u0018\u00010/J\u000e\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u000203J\u000e\u0010[\u001a\u00020=2\u0006\u0010P\u001a\u00020QR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 X\u0004¢\u0006\u0002\n\u0000R/\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"8B@BX\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010*\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00050\n0+X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\bR\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020/0\nX\u0004¢\u0006\u0002\n\u0000R\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\bR\u001a\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00050\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u001a\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\nX\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, aXE = {"Lcom/iqoption/charttools/tools/ToolsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "activeIndicators", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/charttools/tools/data/ActiveIndicatorItem;", "getActiveIndicators", "()Landroid/arch/lifecycle/LiveData;", "activeIndicatorsData", "Landroid/arch/lifecycle/MutableLiveData;", "activeToolsClearAllMode", "", "getActiveToolsClearAllMode", "activeToolsClearAllModeData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "calculateTemplatesProcessor", "Lcom/iqoption/core/rx/IQBehaviorProcessor;", "categoryItems", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "getCategoryItems", "categoryItemsData", "countActiveIndicators", "", "countAppliedTemplates", "currentActiveId", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "events", "Lcom/iqoption/charttools/tools/Event;", "getEvents", "eventsData", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "<set-?>", "Lcom/iqoption/charttools/tools/ToolsViewModel$ExpandedMeta;", "expandedItem", "getExpandedItem", "()Lcom/iqoption/charttools/tools/ToolsViewModel$ExpandedMeta;", "setExpandedItem", "(Lcom/iqoption/charttools/tools/ToolsViewModel$ExpandedMeta;)V", "expandedItem$delegate", "Lkotlin/properties/ReadWriteProperty;", "indicatorsDataMap", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "isDisabledActiveIndicators", "screen", "Lcom/iqoption/charttools/tools/ToolsScreen;", "getScreen", "screenData", "settingItems", "Lcom/iqoption/charttools/tools/data/SettingItem;", "getSettingItems", "settingItemsData", "tabId", "", "templateItems", "Lcom/iqoption/charttools/tools/data/TemplateAdapterItem;", "getTemplateItems", "templateItemsData", "applyTemplate", "", "templateItem", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "collapse", "categoryAdapterItem", "item", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "createIndicatorsStream", "Lio/reactivex/Flowable;", "expand", "newExpanded", "getCountActiveIndicatorsLiveData", "getCountAppliedTemplates", "getIndicators", "hideActiveToolsClearAllMode", "isDisabledActiveIndicatorsLiveData", "onCleared", "removeAllInstruments", "removeInstrument", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "removeTemplate", "selectIndicator", "showActiveToolsClearAllMode", "toggleExpanded", "toggleFavorites", "toggleScreen", "toolsScreen", "toggleSetting", "settingItem", "updateIndicatorVisibility", "Companion", "ExpandedMeta", "OnTemplateApplied", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ToolsViewModel.kt */
public final class ToolsViewModel extends ViewModel {
    private static final String TAG = "ToolsViewModel";
    private static final io.reactivex.c.e<Throwable> aBj = d.aBt;
    private static final io.reactivex.c.e<Object> aBk = c.aBs;
    private static final io.reactivex.c.a aBl = b.aBr;
    private static final int aBm = com.iqoption.core.f.getColor(R.color.grey_blue_70);
    public static final a aBn = new a();
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(ToolsViewModel.class), "expandedItem", "getExpandedItem()Lcom/iqoption/charttools/tools/ToolsViewModel$ExpandedMeta;"))};
    private final com.iqoption.core.data.b.c<Integer> aAO = new com.iqoption.core.data.b.c(Integer.valueOf(0));
    private final com.iqoption.core.data.b.c<Integer> aAP = new com.iqoption.core.data.b.c(Integer.valueOf(0));
    private final com.iqoption.core.data.b.c<Boolean> aAQ = new com.iqoption.core.data.b.c(Boolean.valueOf(true));
    private final MutableLiveData<ToolsScreen> aAR = new MutableLiveData();
    private final LiveData<ToolsScreen> aAS = this.aAR;
    private final MutableLiveData<List<com.iqoption.charttools.tools.data.c>> aAT = new MutableLiveData();
    private final LiveData<List<com.iqoption.charttools.tools.data.c>> aAU = this.aAT;
    private final MutableLiveData<List<com.iqoption.charttools.tools.data.a>> aAV = new MutableLiveData();
    private final LiveData<List<com.iqoption.charttools.tools.data.a>> aAW = this.aAV;
    private final com.iqoption.core.data.b.c<Boolean> aAX = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> aAY = this.aAX;
    private final MutableLiveData<List<com.iqoption.charttools.tools.data.k>> aAZ = new MutableLiveData();
    private final LiveData<List<com.iqoption.charttools.tools.data.k>> aBa = this.aAZ;
    private int aBb = -1;
    private final com.iqoption.core.data.b.c<List<com.iqoption.charttools.tools.data.j>> aBc;
    private final LiveData<List<com.iqoption.charttools.tools.data.j>> aBd;
    private final com.iqoption.core.data.b.b<a> aBe;
    private final LiveData<a> aBf;
    private final com.iqoption.core.h.a<Boolean> aBg;
    private final Map<com.iqoption.charttools.tools.data.c, MutableLiveData<List<com.iqoption.charttools.tools.data.h>>> aBh;
    private final kotlin.e.d aBi;
    private final io.reactivex.disposables.a asp;
    private String atG;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JD\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001eH\u0002JL\u0010\u001f\u001a\u00020 *\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\f\u0010#\u001a\u00020$*\u00020%H\u0002J2\u0010&\u001a\u00020%*\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0002JF\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001b*\b\u0012\u0004\u0012\u00020'0.2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010/\u001a\u0002002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0002J4\u00101\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00150\u001b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n03H\u0002J\u0014\u00104\u001a\u00020\u0017*\u0002052\u0006\u00106\u001a\u00020\u0017H\u0002J(\u00107\u001a\u00020\u0017*\u00020\u00152\u0006\u00108\u001a\u00020\u00152\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n09H\u0002J4\u0010:\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00150\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n09H\u0002J\u0014\u0010<\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, aXE = {"Lcom/iqoption/charttools/tools/ToolsViewModel$Companion;", "", "()V", "EMPTY_ACTION", "Lio/reactivex/functions/Action;", "EMPTY_CONSUMER", "Lio/reactivex/functions/Consumer;", "LOGGING_CONSUMER", "", "PARAMS_COLOR", "", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/charttools/tools/ToolsViewModel;", "f", "Landroid/support/v4/app/Fragment;", "mapActive", "Lcom/iqoption/charttools/tools/data/ActiveIndicatorItem;", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "isApplied", "", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "isVolumeEnabled", "currentIndicators", "", "currentFigures", "mapping", "Landroid/support/v4/util/ArrayMap;", "map", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "appliedCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "mapInfo", "Lcom/iqoption/charttools/tools/data/InfoIndicatorItem;", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "mapTitle", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "expanded", "Lcom/iqoption/charttools/tools/ToolsViewModel$ExpandedMeta;", "favorites", "active", "mapToSortedList", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "Lkotlin/sequences/Sequence;", "item", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "matchIndicators", "indicators", "", "matches", "Lcom/iqoption/charttools/model/chart/ChartConfig;", "isVolumeIndicatorEnabled", "matchesFigure", "figure", "", "matchesFigures", "lines", "matchesIndicator", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ToolsViewModel.kt */
    public static final class a {

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        /* compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return b.c(((com.iqoption.charttools.tools.data.m) t).getTitle(), ((com.iqoption.charttools.tools.data.m) t2).getTitle());
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final boolean a(com.iqoption.charttools.model.chart.a aVar, boolean z) {
            com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
            kotlin.jvm.internal.h.d(Il, "TabHelper.instance()");
            com.iqoption.app.managers.tab.a.g IC = Il.IC();
            if (IC == null) {
                return false;
            }
            int ordinal;
            boolean booleanValue;
            boolean booleanValue2;
            com.iqoption.settings.b aDQ;
            ChartType LP = aVar.LP();
            if (LP != null) {
                ordinal = LP.ordinal();
                kotlin.jvm.internal.h.d(IC, "tab");
                if (ordinal != IC.IX().chartType) {
                    return false;
                }
            }
            ChartColor LQ = aVar.LQ();
            if (LQ != null) {
                ordinal = LQ.ordinal();
                kotlin.jvm.internal.h.d(IC, "tab");
                if (ordinal != (IC.IX().apA ^ 1)) {
                    return false;
                }
            }
            Integer LR = aVar.LR();
            if (LR != null) {
                ordinal = LR.intValue();
                kotlin.jvm.internal.h.d(IC, "tab");
                if (ordinal != IC.IX().candleSize) {
                    return false;
                }
            }
            Boolean LS = aVar.LS();
            if (LS != null) {
                booleanValue = LS.booleanValue();
                kotlin.jvm.internal.h.d(IC, "tab");
                if (booleanValue != IC.IX().apC) {
                    return false;
                }
            }
            LS = aVar.LT();
            if (LS != null) {
                booleanValue = LS.booleanValue();
                kotlin.jvm.internal.h.d(IC, "tab");
                if (booleanValue != IC.IX().apB) {
                    return false;
                }
            }
            Boolean LU = aVar.LU();
            if (LU != null) {
                booleanValue2 = LU.booleanValue();
                aDQ = com.iqoption.settings.b.aDQ();
                kotlin.jvm.internal.h.d(aDQ, "SettingsManager.instance()");
                if (booleanValue2 != aDQ.MU()) {
                    return false;
                }
            }
            LU = aVar.LV();
            if (LU != null) {
                booleanValue2 = LU.booleanValue();
                aDQ = com.iqoption.settings.b.aDQ();
                kotlin.jvm.internal.h.d(aDQ, "SettingsManager.instance()");
                if (booleanValue2 != aDQ.MV()) {
                    return false;
                }
            }
            Boolean LW = aVar.LW();
            if (LW == null || LW.booleanValue() == z) {
                return true;
            }
            return false;
        }

        private final boolean a(com.iqoption.charttools.model.indicator.h hVar, com.iqoption.charttools.model.indicator.h hVar2) {
            return (kotlin.jvm.internal.h.E(hVar.KJ(), hVar2.KJ()) ^ 1) == 0 && hVar.isHidden() == hVar2.isHidden() && (kotlin.jvm.internal.h.E(hVar.Mc(), hVar2.Mc()) ^ 1) == 0;
        }

        private final boolean a(List<com.iqoption.charttools.model.indicator.h> list, List<com.iqoption.charttools.model.indicator.h> list2, Map<Integer, Integer> map) {
            if (list.size() != list2.size()) {
                return false;
            }
            for (com.iqoption.charttools.model.indicator.h hVar : list) {
                for (Object next : list2) {
                    if (ToolsViewModel.aBn.a(hVar, (com.iqoption.charttools.model.indicator.h) next)) {
                        break;
                    }
                }
                Object next2 = null;
                com.iqoption.charttools.model.indicator.h hVar2 = (com.iqoption.charttools.model.indicator.h) next2;
                if (hVar2 == null) {
                    return false;
                }
                map.put(Integer.valueOf(hVar.getIndex()), Integer.valueOf(hVar2.getIndex()));
            }
            return true;
        }

        private final boolean a(com.iqoption.charttools.model.indicator.h hVar, com.iqoption.charttools.model.indicator.h hVar2, Map<Integer, Integer> map) {
            x KJ = hVar.KJ();
            if (KJ == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.model.indicator.Figure");
            }
            com.iqoption.charttools.model.indicator.k kVar = (com.iqoption.charttools.model.indicator.k) KJ;
            if ((kotlin.jvm.internal.h.E(kVar, hVar2.KJ()) ^ 1) != 0) {
                return false;
            }
            int a = kVar.a(hVar.Mc());
            Integer num = (Integer) map.get(Integer.valueOf(a));
            kVar.a(num != null ? num.intValue() : -1, hVar.Mc());
            boolean a2 = a(hVar, hVar2);
            kVar.a(a, hVar.Mc());
            return a2;
        }

        private final boolean b(List<com.iqoption.charttools.model.indicator.h> list, List<com.iqoption.charttools.model.indicator.h> list2, Map<Integer, Integer> map) {
            if (list.size() != list2.size()) {
                return false;
            }
            Iterator it = list.iterator();
            boolean z;
            do {
                z = true;
                if (!it.hasNext()) {
                    return true;
                }
                com.iqoption.charttools.model.indicator.h hVar = (com.iqoption.charttools.model.indicator.h) it.next();
                Iterable<com.iqoption.charttools.model.indicator.h> iterable = list2;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (com.iqoption.charttools.model.indicator.h a : iterable) {
                        if (ToolsViewModel.aBn.a(hVar, a, (Map) map)) {
                            continue;
                            break;
                        }
                    }
                }
                z = false;
                continue;
            } while (z);
            return false;
        }

        private final boolean a(com.iqoption.charttools.model.a.a aVar, boolean z, List<com.iqoption.charttools.model.indicator.h> list, List<com.iqoption.charttools.model.indicator.h> list2, ArrayMap<Integer, Integer> arrayMap) {
            com.iqoption.charttools.model.chart.a MK = aVar.MK();
            if (MK != null && !ToolsViewModel.aBn.a(MK, z)) {
                return false;
            }
            arrayMap.clear();
            a aVar2 = this;
            Map map = arrayMap;
            if (aVar2.a(aVar.JT(), (List) list, map) && aVar2.b(aVar.Kr(), list2, map)) {
                return true;
            }
            return false;
        }

        private final com.iqoption.charttools.tools.data.l a(com.iqoption.charttools.model.a.a aVar, boolean z, List<com.iqoption.charttools.model.indicator.h> list, List<com.iqoption.charttools.model.indicator.h> list2, ArrayMap<Integer, Integer> arrayMap, AtomicInteger atomicInteger) {
            String a;
            if ((aVar.JT().isEmpty() ^ 1) != 0) {
                a = u.a(aVar.JT(), ", ", null, null, 0, null, ToolsViewModel$Companion$map$1.aBu, 30, null);
            } else {
                a = com.iqoption.core.f.getString(R.string.chart_settings_only);
            }
            String str = a;
            boolean a2 = a(aVar, z, (List) list, (List) list2, (ArrayMap) arrayMap);
            if (a2) {
                atomicInteger.incrementAndGet();
            }
            return new com.iqoption.charttools.tools.data.l(aVar, str, a2);
        }

        private final List<com.iqoption.charttools.tools.data.h> a(kotlin.sequences.h<? extends x> hVar, e eVar, com.iqoption.charttools.tools.data.c cVar, List<? extends x> list, List<com.iqoption.charttools.model.indicator.h> list2) {
            List<com.iqoption.charttools.tools.data.h> g = m.g(m.a(m.f(hVar, new ToolsViewModel$Companion$mapToSortedList$1(eVar, list, list2)), (Comparator) new a()));
            if (eVar != null && kotlin.jvm.internal.h.E(eVar.Oa(), cVar)) {
                int i = 0;
                for (com.iqoption.charttools.tools.data.h Jf : g) {
                    if (kotlin.jvm.internal.h.E((String) Jf.Jf(), eVar.Ob().Jf())) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    g.add(i + 1, ToolsViewModel.aBn.b(eVar.Ob()));
                }
            }
            return g;
        }

        private final com.iqoption.charttools.tools.data.a o(com.iqoption.charttools.model.indicator.h hVar) {
            String string;
            int dH;
            x KJ = hVar.KJ();
            if (KJ instanceof com.iqoption.charttools.model.indicator.k) {
                com.iqoption.charttools.model.indicator.k kVar = (com.iqoption.charttools.model.indicator.k) KJ;
                switch (kVar.d(hVar.Mc())) {
                    case 1:
                        string = com.iqoption.core.f.getString(R.string.thin);
                        break;
                    case 2:
                        string = com.iqoption.core.f.getString(R.string.medium);
                        break;
                    case 3:
                        string = com.iqoption.core.f.getString(R.string.thick);
                        break;
                    default:
                        string = "";
                        break;
                }
                dH = com.iqoption.core.ext.a.dH(kVar.c(hVar.Mc()));
            } else {
                string = com.iqoption.charttools.l.asx.b(hVar);
                dH = ToolsViewModel.aBm;
            }
            return new com.iqoption.charttools.tools.data.a(KJ.Mi(), string, dH, hVar);
        }

        private final com.iqoption.charttools.tools.data.m a(x xVar, e eVar, List<? extends x> list, List<com.iqoption.charttools.model.indicator.h> list2) {
            int i;
            Object KJ;
            Iterable<com.iqoption.charttools.model.indicator.h> iterable = list2;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                i = 0;
            } else {
                i = 0;
                for (com.iqoption.charttools.model.indicator.h KJ2 : iterable) {
                    if (kotlin.jvm.internal.h.E(KJ2.KJ(), xVar)) {
                        i++;
                    }
                }
            }
            int LZ = xVar.LZ();
            boolean z = LZ == 0 || LZ > i;
            String Mi = xVar.Mi();
            com.iqoption.core.data.model.c Mj = xVar.Mj();
            String info = xVar.getInfo();
            if (eVar != null) {
                com.iqoption.charttools.tools.data.m Ob = eVar.Ob();
                if (Ob != null) {
                    KJ = Ob.KJ();
                    return new com.iqoption.charttools.tools.data.m(xVar, Mi, Mj, info, kotlin.jvm.internal.h.E(KJ, xVar), list.contains(xVar), z);
                }
            }
            KJ = null;
            return new com.iqoption.charttools.tools.data.m(xVar, Mi, Mj, info, kotlin.jvm.internal.h.E(KJ, xVar), list.contains(xVar), z);
        }

        private final com.iqoption.charttools.tools.data.i b(com.iqoption.charttools.tools.data.m mVar) {
            x KJ = mVar.KJ();
            String info = mVar.getInfo();
            if (info == null) {
                info = "";
            }
            return new com.iqoption.charttools.tools.data.i(KJ, info, mVar.KJ().Mk());
        }

        public final ToolsViewModel h(Fragment fragment) {
            kotlin.jvm.internal.h.e(fragment, "f");
            Factory factory = (Factory) null;
            ViewModelProvider d = ViewModelProviders.d(fragment);
            kotlin.jvm.internal.h.d(d, "ViewModelProviders.of(f)");
            ViewModel h = d.h(ToolsViewModel.class);
            kotlin.jvm.internal.h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (ToolsViewModel) h;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, aXE = {"Lcom/iqoption/charttools/tools/ToolsViewModel$ExpandedMeta;", "", "categoryAdapterItem", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "item", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "(Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;)V", "getCategoryAdapterItem", "()Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "getItem", "()Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "equals", "", "other", "hashCode", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ToolsViewModel.kt */
    private static final class e {
        private final com.iqoption.charttools.tools.data.c aBv;
        private final com.iqoption.charttools.tools.data.m aBw;

        public e(com.iqoption.charttools.tools.data.c cVar, com.iqoption.charttools.tools.data.m mVar) {
            kotlin.jvm.internal.h.e(cVar, "categoryAdapterItem");
            kotlin.jvm.internal.h.e(mVar, "item");
            this.aBv = cVar;
            this.aBw = mVar;
        }

        public final com.iqoption.charttools.tools.data.c Oa() {
            return this.aBv;
        }

        public final com.iqoption.charttools.tools.data.m Ob() {
            return this.aBw;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((kotlin.jvm.internal.h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
                return false;
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.tools.ToolsViewModel.ExpandedMeta");
            }
            e eVar = (e) obj;
            if (this.aBv.getId() == eVar.aBv.getId() && (kotlin.jvm.internal.h.E(this.aBw.Jf(), eVar.aBw.Jf()) ^ 1) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Long.valueOf(this.aBv.getId()).hashCode() * 31) + this.aBw.Jf().hashCode();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/charttools/tools/ToolsViewModel$OnTemplateApplied;", "Lcom/iqoption/app/events/IQEvent;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ToolsViewModel.kt */
    public static final class f {
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ToolsViewModel.kt */
    static final class g implements Runnable {
        final /* synthetic */ com.iqoption.charttools.model.a.a arV;

        g(com.iqoption.charttools.model.a.a aVar) {
            this.arV = aVar;
        }

        public final void run() {
            com.iqoption.charttools.model.chart.a MK = this.arV.MK();
            if (MK != null) {
                com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
                kotlin.jvm.internal.h.d(Il, "TabHelper.instance()");
                com.iqoption.app.managers.tab.a.g IC = Il.IC();
                if (IC != null) {
                    boolean booleanValue;
                    com.iqoption.settings.b aDQ;
                    ChartType LP = MK.LP();
                    int ordinal = LP != null ? LP.ordinal() : IC.IX().chartType;
                    Integer LR = MK.LR();
                    IC.X(ordinal, LR != null ? LR.intValue() : IC.IX().candleSize);
                    ChartColor LQ = MK.LQ();
                    if (LQ != null) {
                        switch (LQ) {
                            case mono:
                                IC.bB(true);
                                break;
                            case redGreen:
                                IC.bB(false);
                                break;
                        }
                    }
                    Boolean LS = MK.LS();
                    if (LS != null) {
                        IC.bD(LS.booleanValue());
                    }
                    LS = MK.LT();
                    if (LS != null) {
                        IC.bC(LS.booleanValue());
                    }
                    Boolean LU = MK.LU();
                    if (LU != null) {
                        booleanValue = LU.booleanValue();
                        aDQ = com.iqoption.settings.b.aDQ();
                        kotlin.jvm.internal.h.d(aDQ, "SettingsManager.instance()");
                        aDQ.bU(booleanValue);
                    }
                    LU = MK.LV();
                    if (LU != null) {
                        booleanValue = LU.booleanValue();
                        aDQ = com.iqoption.settings.b.aDQ();
                        kotlin.jvm.internal.h.d(aDQ, "SettingsManager.instance()");
                        aDQ.setLiveDealsEnabled(booleanValue);
                    }
                    Boolean LW = MK.LW();
                    if (LW != null) {
                        com.iqoption.charttools.f.arM.bF(LW.booleanValue());
                    }
                }
            }
            IQApp.Dn().aE(new f());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ToolsViewModel.kt */
    static final class s implements Runnable {
        final /* synthetic */ com.iqoption.charttools.model.indicator.h aBE;
        final /* synthetic */ ToolsViewModel aBo;

        s(ToolsViewModel toolsViewModel, com.iqoption.charttools.model.indicator.h hVar) {
            this.aBo = toolsViewModel;
            this.aBE = hVar;
        }

        public final void run() {
            com.iqoption.gl.b.aow().glchInstrumentSelect(this.aBo.atG, this.aBE.getIndex());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ToolsViewModel.kt */
    /* renamed from: com.iqoption.charttools.tools.ToolsViewModel$1 */
    static final class AnonymousClass1<T> implements io.reactivex.c.e<com.iqoption.charttools.k> {
        final /* synthetic */ ToolsViewModel aBo;

        AnonymousClass1(ToolsViewModel toolsViewModel) {
            this.aBo = toolsViewModel;
        }

        /* renamed from: b */
        public final void accept(com.iqoption.charttools.k kVar) {
            List arrayList = new ArrayList();
            arrayList.add(com.iqoption.charttools.tools.data.b.aBN);
            arrayList.add(com.iqoption.charttools.tools.data.g.aBR);
            if (com.iqoption.app.managers.feature.a.eW("script-indicators") && (kVar.Kj().isEmpty() ^ 1) != 0) {
                for (com.iqoption.charttools.model.a aVar : kVar.Kj()) {
                    String gW = LocalizationUtil.gW(aVar.getName());
                    kotlin.jvm.internal.h.d(gW, "LocalizationUtil.translateOpt(category.name)");
                    arrayList.add(new com.iqoption.charttools.tools.data.d(aVar, gW));
                }
            }
            this.aBo.aAT.postValue(arrayList);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ToolsViewModel.kt */
    /* renamed from: com.iqoption.charttools.tools.ToolsViewModel$3 */
    static final class AnonymousClass3<T> implements io.reactivex.c.e<List<? extends com.iqoption.charttools.model.indicator.h>> {
        final /* synthetic */ ToolsViewModel aBo;

        AnonymousClass3(ToolsViewModel toolsViewModel) {
            this.aBo = toolsViewModel;
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.charttools.model.indicator.h> list) {
            MutableLiveData g = this.aBo.aAV;
            kotlin.jvm.internal.h.d(list, "indicators");
            Iterable<com.iqoption.charttools.model.indicator.h> iterable = list;
            a aVar = ToolsViewModel.aBn;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (com.iqoption.charttools.model.indicator.h a : iterable) {
                arrayList.add(aVar.o(a));
            }
            g.postValue((List) arrayList);
            int size = list.size();
            this.aBo.aAO.postValue(Integer.valueOf(size));
            this.aBo.aAQ.postValue(Boolean.valueOf(size == 0));
            if (size == 0 && ((ToolsScreen) this.aBo.NL().getValue()) == ToolsScreen.ACTIVE_TOOLS) {
                this.aBo.aAR.postValue(null);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ToolsViewModel.kt */
    static final class b implements io.reactivex.c.a {
        public static final b aBr = new b();

        b() {
        }

        public final void run() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "accept"})
    /* compiled from: ToolsViewModel.kt */
    static final class c<T> implements io.reactivex.c.e<Object> {
        public static final c aBs = new c();

        c() {
        }

        public final void accept(Object obj) {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ToolsViewModel.kt */
    static final class d<T> implements io.reactivex.c.e<Throwable> {
        public static final d aBt = new d();

        d() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(ToolsViewModel.TAG, "Error occurred", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "it", "Lcom/iqoption/charttools/IndicatorsLibrary;", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class h<T, R> implements io.reactivex.c.f<T, R> {
        public static final h aBx = new h();

        h() {
        }

        /* renamed from: e */
        public final List<x> apply(com.iqoption.charttools.k kVar) {
            kotlin.jvm.internal.h.e(kVar, "it");
            return kVar.JT();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "it", "Lcom/iqoption/charttools/IndicatorsLibrary;", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class i<T, R> implements io.reactivex.c.f<T, R> {
        public static final i aBy = new i();

        i() {
        }

        /* renamed from: e */
        public final List<x> apply(com.iqoption.charttools.k kVar) {
            kotlin.jvm.internal.h.e(kVar, "it");
            Collection arrayList = new ArrayList();
            for (Object next : kVar.Kk()) {
                if (((x) next) instanceof v) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "it", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class j<T, R> implements io.reactivex.c.f<T, R> {
        public static final j aBz = new j();

        j() {
        }

        /* renamed from: m */
        public final List<x> apply(List<? extends x> list) {
            kotlin.jvm.internal.h.e(list, "it");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (((x) next) instanceof v) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "it", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class k<T, R> implements io.reactivex.c.f<T, R> {
        public static final k aBA = new k();

        k() {
        }

        /* renamed from: m */
        public final List<com.iqoption.charttools.model.indicator.h> apply(List<com.iqoption.charttools.model.indicator.h> list) {
            kotlin.jvm.internal.h.e(list, "it");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (((com.iqoption.charttools.model.indicator.h) next).KJ() instanceof v) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "indicators", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "favorites", "active", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class l<T1, T2, T3, R> implements io.reactivex.c.g<List<? extends x>, List<? extends x>, List<? extends com.iqoption.charttools.model.indicator.h>, List<? extends com.iqoption.charttools.tools.data.h>> {
        final /* synthetic */ com.iqoption.charttools.tools.data.c aBB;
        final /* synthetic */ ToolsViewModel aBo;

        l(ToolsViewModel toolsViewModel, com.iqoption.charttools.tools.data.c cVar) {
            this.aBo = toolsViewModel;
            this.aBB = cVar;
        }

        /* renamed from: a */
        public final List<com.iqoption.charttools.tools.data.h> b(List<? extends x> list, List<? extends x> list2, List<com.iqoption.charttools.model.indicator.h> list3) {
            kotlin.jvm.internal.h.e(list, "indicators");
            kotlin.jvm.internal.h.e(list2, "favorites");
            kotlin.jvm.internal.h.e(list3, "active");
            return ToolsViewModel.aBn.a(u.ac(list), this.aBo.NY(), this.aBB, (List) list2, (List) list3);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "<anonymous parameter 0>", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "favorites", "active", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class m<T1, T2, T3, R> implements io.reactivex.c.g<List<? extends x>, List<? extends x>, List<? extends com.iqoption.charttools.model.indicator.h>, List<? extends com.iqoption.charttools.tools.data.h>> {
        final /* synthetic */ com.iqoption.charttools.tools.data.c aBB;
        final /* synthetic */ ToolsViewModel aBo;

        m(ToolsViewModel toolsViewModel, com.iqoption.charttools.tools.data.c cVar) {
            this.aBo = toolsViewModel;
            this.aBB = cVar;
        }

        /* renamed from: a */
        public final List<com.iqoption.charttools.tools.data.h> b(List<? extends x> list, List<? extends x> list2, List<com.iqoption.charttools.model.indicator.h> list3) {
            kotlin.jvm.internal.h.e(list, "<anonymous parameter 0>");
            kotlin.jvm.internal.h.e(list2, "favorites");
            kotlin.jvm.internal.h.e(list3, "active");
            return ToolsViewModel.aBn.a(u.ac(list2), this.aBo.NY(), this.aBB, (List) list2, (List) list3);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "indicators", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "favorites", "active", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "apply"})
    /* compiled from: ToolsViewModel.kt */
    static final class n<T1, T2, T3, R> implements io.reactivex.c.g<List<? extends x>, List<? extends x>, List<? extends com.iqoption.charttools.model.indicator.h>, List<? extends com.iqoption.charttools.tools.data.h>> {
        final /* synthetic */ com.iqoption.charttools.tools.data.c aBB;
        final /* synthetic */ ToolsViewModel aBo;

        n(ToolsViewModel toolsViewModel, com.iqoption.charttools.tools.data.c cVar) {
            this.aBo = toolsViewModel;
            this.aBB = cVar;
        }

        /* renamed from: a */
        public final List<com.iqoption.charttools.tools.data.h> b(List<? extends x> list, List<? extends x> list2, List<com.iqoption.charttools.model.indicator.h> list3) {
            kotlin.jvm.internal.h.e(list, "indicators");
            kotlin.jvm.internal.h.e(list2, "favorites");
            kotlin.jvm.internal.h.e(list3, "active");
            return ToolsViewModel.aBn.a(m.b(u.ac(list), new ToolsViewModel$createIndicatorsStream$7$1(this)), this.aBo.NY(), this.aBB, (List) list2, (List) list3);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "com/iqoption/charttools/tools/ToolsViewModel$getIndicators$1$2"})
    /* compiled from: ToolsViewModel.kt */
    static final class o<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ com.iqoption.charttools.tools.data.c aBC;
        final /* synthetic */ ToolsViewModel aBo;

        o(ToolsViewModel toolsViewModel, com.iqoption.charttools.tools.data.c cVar) {
            this.aBo = toolsViewModel;
            this.aBC = cVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ki = ToolsViewModel.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to load indicators for category ");
            stringBuilder.append(this.aBC);
            com.iqoption.core.i.w(Ki, stringBuilder.toString(), th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ToolsViewModel.kt */
    static final class p<T> implements io.reactivex.c.e<List<? extends com.iqoption.charttools.tools.data.h>> {
        final /* synthetic */ MutableLiveData receiver$0;

        p(MutableLiveData mutableLiveData) {
            this.receiver$0 = mutableLiveData;
        }

        /* renamed from: C */
        public final void accept(List<? extends com.iqoption.charttools.tools.data.h> list) {
            Object list2;
            MutableLiveData mutableLiveData = this.receiver$0;
            kotlin.jvm.internal.h.d(list2, "it");
            if ((list2.isEmpty() ^ 1) == 0) {
                list2 = null;
            }
            if (list2 == null) {
                list2 = l.cr(com.iqoption.charttools.tools.data.e.aBP);
            }
            mutableLiveData.postValue(list2);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ToolsViewModel.kt */
    static final class q implements io.reactivex.c.a {
        final /* synthetic */ ToolsViewModel aBo;

        q(ToolsViewModel toolsViewModel) {
            this.aBo = toolsViewModel;
        }

        public final void run() {
            this.aBo.aBe.postValue(c.aAy);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ToolsViewModel.kt */
    static final class r<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ List aBD;
        final /* synthetic */ ToolsViewModel aBo;

        r(ToolsViewModel toolsViewModel, List list) {
            this.aBo = toolsViewModel;
            this.aBD = list;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(ToolsViewModel.TAG, "Error during deleting template", th);
            this.aBo.aAZ.postValue(this.aBD);
            this.aBo.aBe.postValue(new b(com.iqoption.core.f.getString(R.string.could_not_delete_template)));
        }
    }

    private final e NY() {
        return (e) this.aBi.b(this, apP[0]);
    }

    private final void a(e eVar) {
        this.aBi.a(this, apP[0], eVar);
    }

    public ToolsViewModel() {
        String str = com.iqoption.app.managers.tab.a.aoY;
        kotlin.jvm.internal.h.d(str, "TabHelper.NOT_INITILIZED_TAB_ID_STRING");
        this.atG = str;
        this.aBe = new com.iqoption.core.data.b.b();
        this.aBf = this.aBe;
        this.aBg = com.iqoption.core.h.a.baf.bi(Boolean.valueOf(true));
        this.asp = new io.reactivex.disposables.a();
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        kotlin.jvm.internal.h.d(Il, "TabHelper.instance()");
        com.iqoption.app.managers.tab.a.g IC = Il.IC();
        if (IC != null) {
            kotlin.jvm.internal.h.d(IC, "it");
            this.aBb = IC.getActiveId();
            str = IC.IM();
            kotlin.jvm.internal.h.d(str, "it.idString");
            this.atG = str;
        }
        this.asp.e(com.iqoption.charttools.l.asx.Km().h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass1(this), aBj));
        if (com.iqoption.app.managers.feature.a.eX("templates")) {
            final ArrayMap arrayMap = new ArrayMap();
            final AtomicInteger atomicInteger = new AtomicInteger();
            this.asp.e(com.iqoption.core.h.g.a(com.iqoption.charttools.r.asX.Kv(), com.iqoption.charttools.f.arM.fo(this.atG), com.iqoption.charttools.f.arM.JZ(), this.aBg, new io.reactivex.c.h<List<? extends com.iqoption.charttools.model.a.a>, List<? extends com.iqoption.charttools.model.indicator.h>, Boolean, Boolean, kotlin.l>(this) {
                final /* synthetic */ ToolsViewModel aBo;

                public final void a(List<com.iqoption.charttools.model.a.a> list, List<com.iqoption.charttools.model.indicator.h> list2, boolean z, boolean z2) {
                    kotlin.jvm.internal.h.e(list, "templates");
                    kotlin.jvm.internal.h.e(list2, "indicators");
                    MutableLiveData g = this.aBo.aAV;
                    Iterable<com.iqoption.charttools.model.indicator.h> iterable = list2;
                    a aVar = ToolsViewModel.aBn;
                    Collection arrayList = new ArrayList(n.e(iterable, 10));
                    for (com.iqoption.charttools.model.indicator.h a : iterable) {
                        arrayList.add(aVar.o(a));
                    }
                    g.postValue((List) arrayList);
                    int size = list2.size();
                    this.aBo.aAO.postValue(Integer.valueOf(size));
                    this.aBo.aAQ.postValue(Boolean.valueOf(size == 0));
                    if (size == 0 && ((ToolsScreen) this.aBo.NL().getValue()) == ToolsScreen.ACTIVE_TOOLS) {
                        this.aBo.aAR.postValue(null);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object next : iterable) {
                        if (((com.iqoption.charttools.model.indicator.h) next).KJ() instanceof com.iqoption.charttools.model.indicator.k) {
                            arrayList2.add(next);
                        } else {
                            arrayList3.add(next);
                        }
                    }
                    Pair pair = new Pair(arrayList2, arrayList3);
                    List list3 = (List) pair.aXG();
                    List list4 = (List) pair.aXH();
                    atomicInteger.set(0);
                    MutableLiveData d = this.aBo.aAZ;
                    List arrayList4 = new ArrayList();
                    for (com.iqoption.charttools.model.a.a a2 : list) {
                        arrayList4.add(ToolsViewModel.aBn.a(a2, z, list4, list3, arrayMap, atomicInteger));
                    }
                    this.aBo.aAP.postValue(Integer.valueOf(atomicInteger.get()));
                    if (arrayList4.isEmpty()) {
                        arrayList4.add(com.iqoption.charttools.tools.data.f.aBQ);
                    }
                    d.postValue(arrayList4);
                }
            }).d(com.iqoption.core.h.i.Yo()).a(aBk, aBj));
        } else {
            this.asp.e(com.iqoption.charttools.f.arM.fo(this.atG).d(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass3(this), aBj, aBl));
        }
        r3 = new com.iqoption.charttools.tools.data.j[4];
        SettingType settingType = SettingType.TRADERS_MOOD;
        com.iqoption.settings.b aDQ = com.iqoption.settings.b.aDQ();
        kotlin.jvm.internal.h.d(aDQ, "SettingsManager.instance()");
        r3[0] = new com.iqoption.charttools.tools.data.j(settingType, aDQ.MU());
        SettingType settingType2 = SettingType.LIVE_DEALS;
        com.iqoption.settings.b aDQ2 = com.iqoption.settings.b.aDQ();
        kotlin.jvm.internal.h.d(aDQ2, "SettingsManager.instance()");
        r3[1] = new com.iqoption.charttools.tools.data.j(settingType2, aDQ2.MV());
        r3[2] = new com.iqoption.charttools.tools.data.j(SettingType.APPLY_TO_ALL_ASSETS, com.iqoption.charttools.f.arM.Kb());
        r3[3] = new com.iqoption.charttools.tools.data.j(SettingType.VOLUME, com.iqoption.charttools.f.arM.Ka());
        this.aBc = new com.iqoption.core.data.b.c(m.listOf(r3));
        this.aBd = this.aBc;
        this.aBh = new LinkedHashMap();
        this.aBi = com.iqoption.core.e.c.bg(null);
    }

    public final LiveData<ToolsScreen> NL() {
        return this.aAS;
    }

    public final LiveData<List<com.iqoption.charttools.tools.data.c>> NM() {
        return this.aAU;
    }

    public final LiveData<List<com.iqoption.charttools.tools.data.a>> NN() {
        return this.aAW;
    }

    public final LiveData<Boolean> NO() {
        return this.aAY;
    }

    public final LiveData<List<com.iqoption.charttools.tools.data.k>> NP() {
        return this.aBa;
    }

    public final LiveData<List<com.iqoption.charttools.tools.data.j>> NQ() {
        return this.aBd;
    }

    public final LiveData<a> NR() {
        return this.aBf;
    }

    protected void onCleared() {
        super.onCleared();
        this.asp.clear();
    }

    public final LiveData<Boolean> NS() {
        return this.aAQ;
    }

    public final LiveData<Integer> NT() {
        return this.aAO;
    }

    public final LiveData<Integer> NU() {
        return this.aAP;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c0  */
    public final void a(com.iqoption.charttools.tools.data.j r10) {
        /*
        r9 = this;
        r0 = "settingItem";
        kotlin.jvm.internal.h.e(r10, r0);
        r0 = r10.Of();
        r1 = r10.Og();
        r2 = com.iqoption.charttools.tools.g.aoS;
        r1 = r1.ordinal();
        r1 = r2[r1];
        r2 = 1;
        switch(r1) {
            case 1: goto L_0x006d;
            case 2: goto L_0x0053;
            case 3: goto L_0x002e;
            case 4: goto L_0x001b;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x008f;
    L_0x001b:
        r1 = com.iqoption.charttools.f.arM;
        r3 = r0.isEnabled();
        r1.bF(r3);
        r1 = com.iqoption.charttools.tools.d.aAz;
        r3 = r0.isEnabled();
        r1.bX(r3);
        goto L_0x008f;
    L_0x002e:
        r1 = com.iqoption.charttools.f.arM;
        r3 = r9.atG;
        r4 = r0.isEnabled();
        r1 = r1.k(r3, r4);
        r3 = com.iqoption.core.h.i.Yr();
        r1 = r1.b(r3);
        r3 = aBl;
        r4 = aBj;
        r1.a(r3, r4);
        r1 = com.iqoption.charttools.tools.d.aAz;
        r3 = r0.isEnabled();
        r1.bW(r3);
        goto L_0x008f;
    L_0x0053:
        r1 = com.iqoption.settings.b.aDQ();
        r3 = "SettingsManager.instance()";
        kotlin.jvm.internal.h.d(r1, r3);
        r3 = r0.isEnabled();
        r1.setLiveDealsEnabled(r3);
        r1 = r9.aBg;
        r3 = java.lang.Boolean.valueOf(r2);
        r1.e(r3);
        goto L_0x008f;
    L_0x006d:
        r1 = com.iqoption.settings.b.aDQ();
        r3 = "SettingsManager.instance()";
        kotlin.jvm.internal.h.d(r1, r3);
        r3 = r0.isEnabled();
        r1.bU(r3);
        r1 = r9.aBg;
        r3 = java.lang.Boolean.valueOf(r2);
        r1.e(r3);
        r1 = com.iqoption.charttools.tools.d.aAz;
        r3 = r0.isEnabled();
        r1.bV(r3);
    L_0x008f:
        r1 = r9.aBc;
        r1 = r1.getValue();
        r1 = (java.util.List) r1;
        r3 = r1.iterator();
        r4 = 0;
        r5 = 0;
    L_0x009d:
        r6 = r3.hasNext();
        r7 = -1;
        if (r6 == 0) goto L_0x00bd;
    L_0x00a4:
        r6 = r3.next();
        r6 = (com.iqoption.charttools.tools.data.j) r6;
        r6 = r6.Og();
        r8 = r10.Og();
        if (r6 != r8) goto L_0x00b6;
    L_0x00b4:
        r6 = 1;
        goto L_0x00b7;
    L_0x00b6:
        r6 = 0;
    L_0x00b7:
        if (r6 == 0) goto L_0x00ba;
    L_0x00b9:
        goto L_0x00be;
    L_0x00ba:
        r5 = r5 + 1;
        goto L_0x009d;
    L_0x00bd:
        r5 = -1;
    L_0x00be:
        if (r5 == r7) goto L_0x00c9;
    L_0x00c0:
        r10 = r9.aBc;
        r0 = com.iqoption.core.ext.c.a(r1, r5, r0);
        r10.setValue(r0);
    L_0x00c9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.tools.ToolsViewModel.a(com.iqoption.charttools.tools.data.j):void");
    }

    public final void e(ToolsScreen toolsScreen) {
        Object toolsScreen2;
        MutableLiveData mutableLiveData = this.aAR;
        if (((ToolsScreen) mutableLiveData.getValue()) == toolsScreen2) {
            toolsScreen2 = null;
        }
        com.iqoption.core.ext.a.a(mutableLiveData, toolsScreen2);
        if (toolsScreen2 != null) {
            switch (toolsScreen2) {
                case ACTIVE_TOOLS:
                    d.aAz.Nr();
                    return;
                case INDICATORS:
                    d.aAz.Nq();
                    return;
                case TEMPLATES:
                    d.aAz.Ns();
                    return;
                default:
                    return;
            }
        }
    }

    public final void NV() {
        com.iqoption.charttools.f.arM.fq(this.atG).b(com.iqoption.core.h.i.Yr()).a(aBl, aBj);
    }

    public final void l(com.iqoption.charttools.model.indicator.h hVar) {
        kotlin.jvm.internal.h.e(hVar, "indicator");
        com.iqoption.charttools.f.arM.y(this.atG, hVar.getIndex()).b(com.iqoption.core.h.i.Yr()).a(aBl, aBj);
    }

    public final void b(com.iqoption.charttools.tools.data.l lVar) {
        kotlin.jvm.internal.h.e(lVar, "templateItem");
        com.iqoption.charttools.model.a.a Oh = lVar.Oh();
        d.aAz.Z(Oh.JT().size(), Oh.Kr().size());
        com.iqoption.charttools.f.arM.a(this.atG, this.aBb, Oh).b((io.reactivex.c) io.reactivex.a.p(new g(Oh))).b(com.iqoption.core.h.i.Yr()).a(aBl, aBj);
    }

    public final void m(com.iqoption.charttools.model.indicator.h hVar) {
        kotlin.jvm.internal.h.e(hVar, "indicator");
        com.iqoption.charttools.f.a(com.iqoption.charttools.f.arM, this.atG, hVar.getIndex(), Boolean.valueOf(hVar.isHidden() ^ 1), null, false, 24, null).b(com.iqoption.core.h.i.Yr()).a(aBl, aBj);
    }

    public final boolean n(com.iqoption.charttools.model.indicator.h hVar) {
        kotlin.jvm.internal.h.e(hVar, "indicator");
        if (!(hVar.KJ() instanceof com.iqoption.charttools.model.indicator.k)) {
            return false;
        }
        io.reactivex.a.p(new s(this, hVar)).b(com.iqoption.core.h.i.Yr()).a(aBl, aBj);
        return true;
    }

    public final void c(com.iqoption.charttools.tools.data.l lVar) {
        kotlin.jvm.internal.h.e(lVar, "templateItem");
        List<com.iqoption.charttools.tools.data.k> list = (List) this.aBa.getValue();
        if (list != null) {
            int i = 0;
            for (com.iqoption.charttools.tools.data.k Jf : list) {
                if (kotlin.jvm.internal.h.E((String) Jf.Jf(), lVar.Jf())) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                this.aAZ.setValue(com.iqoption.core.ext.c.a((List) list, i));
            }
        }
        com.iqoption.charttools.model.a.a Oh = lVar.Oh();
        d.aAz.Y(Oh.JT().size(), Oh.Kr().size());
        com.iqoption.charttools.r.asX.aJ(lVar.Oh().getId()).b(com.iqoption.core.h.i.Yo()).a(new q(this), new r(this, list));
    }

    public final void NW() {
        com.iqoption.core.ext.a.a(this.aAX, Boolean.valueOf(true));
    }

    public final void NX() {
        com.iqoption.core.ext.a.a(this.aAX, Boolean.valueOf(false));
    }

    public final void a(com.iqoption.charttools.tools.data.c cVar, com.iqoption.charttools.tools.data.m mVar) {
        kotlin.jvm.internal.h.e(cVar, "categoryAdapterItem");
        kotlin.jvm.internal.h.e(mVar, "item");
        e eVar = new e(cVar, mVar);
        e NY = NY();
        if (kotlin.jvm.internal.h.E(eVar, NY)) {
            b(cVar, mVar);
        } else if (NY == null) {
            a(eVar, cVar, mVar);
        } else {
            b(NY.Oa(), NY.Ob());
            a(eVar, cVar, mVar);
        }
    }

    private final void b(com.iqoption.charttools.tools.data.c cVar, com.iqoption.charttools.tools.data.m mVar) {
        MutableLiveData mutableLiveData = (MutableLiveData) this.aBh.get(cVar);
        if (mutableLiveData != null) {
            List<com.iqoption.charttools.tools.data.h> list = (List) mutableLiveData.getValue();
            if (list != null) {
                kotlin.jvm.internal.h.d(list, "items");
                Object obj = null;
                int i = 0;
                for (com.iqoption.charttools.tools.data.h Jf : list) {
                    if (kotlin.jvm.internal.h.E((String) Jf.Jf(), mVar.Jf())) {
                        break;
                    }
                    i++;
                }
                i = -1;
                int i2 = i + 1;
                if (i != -1 && mVar.getInfo() != null) {
                    List O = u.O((Collection) list);
                    O.set(i, com.iqoption.charttools.tools.data.m.a(mVar, null, null, null, null, false, false, false, 111, null));
                    com.iqoption.charttools.tools.data.h hVar = (com.iqoption.charttools.tools.data.h) O.get(i2);
                    if ((hVar instanceof com.iqoption.charttools.tools.data.i) && kotlin.jvm.internal.h.E(((com.iqoption.charttools.tools.data.i) hVar).KJ(), mVar.KJ())) {
                        obj = 1;
                    }
                    if (obj != null) {
                        O.remove(i2);
                    }
                    mutableLiveData.setValue(O);
                    a((e) null);
                }
            }
        }
    }

    private final void a(e eVar, com.iqoption.charttools.tools.data.c cVar, com.iqoption.charttools.tools.data.m mVar) {
        MutableLiveData mutableLiveData = (MutableLiveData) this.aBh.get(cVar);
        if (mutableLiveData != null) {
            List<com.iqoption.charttools.tools.data.h> list = (List) mutableLiveData.getValue();
            if (list != null) {
                kotlin.jvm.internal.h.d(list, "items");
                int i = 0;
                for (com.iqoption.charttools.tools.data.h Jf : list) {
                    if (kotlin.jvm.internal.h.E((String) Jf.Jf(), mVar.Jf())) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1 && mVar.getInfo() != null) {
                    List O = u.O((Collection) list);
                    O.set(i, com.iqoption.charttools.tools.data.m.a(mVar, null, null, null, null, true, false, false, 111, null));
                    O.add(i + 1, aBn.b(mVar));
                    mutableLiveData.setValue(O);
                    a(eVar);
                }
            }
        }
    }

    public final void a(com.iqoption.charttools.tools.data.m mVar) {
        kotlin.jvm.internal.h.e(mVar, "item");
        if (mVar.Ok()) {
            com.iqoption.charttools.i.ash.b(mVar.KJ()).b(com.iqoption.core.h.i.Yo()).a(aBl, aBj);
        } else {
            com.iqoption.charttools.i.ash.a(mVar.KJ()).b(com.iqoption.core.h.i.Yo()).a(aBl, aBj);
        }
    }

    public final LiveData<List<com.iqoption.charttools.tools.data.h>> a(com.iqoption.charttools.tools.data.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "item");
        MutableLiveData mutableLiveData = (MutableLiveData) this.aBh.get(cVar);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        mutableLiveData = new MutableLiveData();
        this.asp.e(b(cVar).d(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new p(mutableLiveData), (io.reactivex.c.e) new o(this, cVar)));
        this.aBh.put(cVar, mutableLiveData);
        return mutableLiveData;
    }

    private final io.reactivex.e<List<com.iqoption.charttools.tools.data.h>> b(com.iqoption.charttools.tools.data.c cVar) {
        io.reactivex.e aWk;
        io.reactivex.e Kg;
        io.reactivex.e fo;
        io.reactivex.c.g lVar;
        if (com.iqoption.app.managers.feature.a.eW("script-indicators")) {
            aWk = com.iqoption.charttools.l.asx.Km().n(h.aBx).aWk();
            kotlin.jvm.internal.h.d(aWk, "IndicatorsLibraryManager…            .toFlowable()");
            Kg = com.iqoption.charttools.i.ash.Kg();
            fo = com.iqoption.charttools.f.arM.fo(this.atG);
        } else {
            aWk = com.iqoption.charttools.l.asx.Km().n(i.aBy).aWk();
            kotlin.jvm.internal.h.d(aWk, "IndicatorsLibraryManager…            .toFlowable()");
            Kg = com.iqoption.charttools.i.ash.Kg().d((io.reactivex.c.f) j.aBz);
            kotlin.jvm.internal.h.d(Kg, "FavoriteIndicatorsManage… it is LocalIndicator } }");
            fo = com.iqoption.charttools.f.arM.fo(this.atG).d((io.reactivex.c.f) k.aBA);
            kotlin.jvm.internal.h.d(fo, "ActiveIndicatorsManager.…eta is LocalIndicator } }");
        }
        if (kotlin.jvm.internal.h.E(cVar, com.iqoption.charttools.tools.data.b.aBN)) {
            lVar = new l(this, cVar);
        } else if (kotlin.jvm.internal.h.E(cVar, com.iqoption.charttools.tools.data.g.aBR)) {
            lVar = new m(this, cVar);
        } else if (cVar instanceof com.iqoption.charttools.tools.data.d) {
            lVar = new n(this, cVar);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return com.iqoption.core.h.g.a(aWk, Kg, fo, lVar);
    }
}
