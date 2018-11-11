package com.iqoption.operations;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.iqoption.app.IQApp;
import com.iqoption.util.ag;
import com.iqoption.util.ba;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0003\t\f\u0014\u0018\u0000 )2\u00020\u0001:\u0005)*+,-B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0005J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\b\b\u0002\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006."}, aXE = {"Lcom/iqoption/operations/OperationViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "changedFilterLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "getChangedFilterLiveData", "()Landroid/arch/lifecycle/MutableLiveData;", "dateFilterGroup", "com/iqoption/operations/OperationViewModel$dateFilterGroup$1", "Lcom/iqoption/operations/OperationViewModel$dateFilterGroup$1;", "operationFilterGroup", "com/iqoption/operations/OperationViewModel$operationFilterGroup$1", "Lcom/iqoption/operations/OperationViewModel$operationFilterGroup$1;", "searchResultDataSource", "", "Lcom/iqoption/microservice/operation/Transaction;", "getSearchResultDataSource", "()Ljava/util/List;", "statusFilterGroup", "com/iqoption/operations/OperationViewModel$statusFilterGroup$1", "Lcom/iqoption/operations/OperationViewModel$statusFilterGroup$1;", "clearSearchDataSource", "", "filterGroupByFilterType", "Lcom/iqoption/operations/OperationViewModel$FilterGroup;", "filterType", "getFilterItems", "", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "filterGroup", "getSelectionFilterString", "", "performSearch", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/operations/OperationViewModel$OperationsResult;", "startFrom", "", "toggleSelection", "filterItem", "Companion", "FilterGroup", "FilterItem", "FilterType", "OperationsResult", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationViewModel.kt */
public final class OperationViewModel extends ViewModel {
    public static final a cXA = new a();
    private static final Calendar calendar = GregorianCalendar.getInstance();
    private final MutableLiveData<FilterType> cXv = new MutableLiveData();
    private final List<com.iqoption.microservice.b.b> cXw = new ArrayList();
    private final e cXx = new e(FilterType.DATE, m.listOf(new c(R.string.all_time, true), new c(R.string.today, false), new c(R.string.yesterday, false), new c(R.string.last_7_days, false), new c(R.string.month_1, false), new c(R.string.month_3, false)));
    private final f cXy = new f(FilterType.OPERATION, m.listOf(new c(R.string.all, true), new c(R.string.deposit, false), new c(R.string.withdrawal, false), new c(R.string.tournament_rebuy, false), new c(R.string.tournament_reward, false)));
    private final i cXz = new i(FilterType.STATUS, m.listOf(new c(R.string.all, true), new c(R.string.completed, false), new c(R.string.in_process, false), new c(R.string.canceled, false), new c(R.string.failed, false)));

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, aXE = {"Lcom/iqoption/operations/OperationViewModel$FilterType;", "", "(Ljava/lang/String;I)V", "DATE", "STATUS", "OPERATION", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public enum FilterType {
        DATE,
        STATUS,
        OPERATION
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/operations/OperationViewModel$Companion;", "", "()V", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/operations/OperationViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final OperationViewModel s(FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.h.e(fragmentActivity, "activity");
            return (OperationViewModel) ViewModelProviders.b(fragmentActivity).h(OperationViewModel.class);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH&J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, aXE = {"Lcom/iqoption/operations/OperationViewModel$FilterGroup;", "", "filterType", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "filterItems", "", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "(Lcom/iqoption/operations/OperationViewModel$FilterType;Ljava/util/List;)V", "getFilterItems", "()Ljava/util/List;", "getFilterType", "()Lcom/iqoption/operations/OperationViewModel$FilterType;", "applyFilterParams", "", "params", "", "", "getSelectedItems", "multiSelection", "", "toggleSelection", "filterItem", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static abstract class b {
        private final FilterType cXB;
        private final List<c> cXC;

        public boolean avy() {
            return true;
        }

        public b(FilterType filterType, List<c> list) {
            kotlin.jvm.internal.h.e(filterType, "filterType");
            kotlin.jvm.internal.h.e(list, "filterItems");
            this.cXB = filterType;
            this.cXC = list;
        }

        public final List<c> avA() {
            return this.cXC;
        }

        public void a(c cVar) {
            kotlin.jvm.internal.h.e(cVar, "filterItem");
            Object obj;
            if (cVar.avB() != R.string.all) {
                c cVar2;
                Object obj2;
                cVar.setSelected(cVar.getSelected() ^ true);
                Collection arrayList = new ArrayList();
                for (Object obj22 : this.cXC) {
                    cVar2 = (c) obj22;
                    obj = (cVar2.avB() == R.string.all || !cVar2.getSelected()) ? null : 1;
                    if (obj != null) {
                        arrayList.add(obj22);
                    }
                }
                List list = (List) arrayList;
                for (c cVar3 : this.cXC) {
                    if (cVar3.avB() == R.string.all) {
                        obj = 1;
                        continue;
                    } else {
                        obj = null;
                        continue;
                    }
                    if (obj != null) {
                        cVar3.setSelected(list.isEmpty());
                        if (list.size() == this.cXC.size() - 1) {
                            for (c cVar4 : this.cXC) {
                                if (cVar4.avB() == R.string.all) {
                                    obj22 = 1;
                                    continue;
                                } else {
                                    obj22 = null;
                                    continue;
                                }
                                if (obj22 != null) {
                                    cVar4.setSelected(true);
                                    arrayList = new ArrayList();
                                    for (Object obj222 : this.cXC) {
                                        cVar2 = (c) obj222;
                                        obj = (cVar2.avB() == R.string.all || !cVar2.getSelected()) ? null : 1;
                                        if (obj != null) {
                                            arrayList.add(obj222);
                                        }
                                    }
                                    for (c cVar42 : (List) arrayList) {
                                        cVar42.setSelected(false);
                                    }
                                    return;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            } else if (!cVar.getSelected()) {
                Collection arrayList2 = new ArrayList();
                for (Object obj3 : this.cXC) {
                    if ((((c) obj3).avB() != R.string.all ? 1 : null) != null) {
                        arrayList2.add(obj3);
                    }
                }
                for (c selected : (List) arrayList2) {
                    selected.setSelected(false);
                }
                cVar.setSelected(true);
            }
        }

        public final List<c> avz() {
            Collection arrayList = new ArrayList();
            Iterator it = this.cXC.iterator();
            while (true) {
                int i = 1;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                c cVar = (c) next;
                if (!cVar.getSelected() || cVar.avB() == R.string.all) {
                    i = 0;
                }
                if (i != 0) {
                    arrayList.add(next);
                }
            }
            List<c> list = (List) arrayList;
            List<c> singletonList;
            if (list.isEmpty() || list.size() == this.cXC.size() - 1) {
                singletonList = Collections.singletonList(u.bU(this.cXC));
                kotlin.jvm.internal.h.d(singletonList, "Collections.singletonList(filterItems.first())");
                return singletonList;
            } else if (avy()) {
                return list;
            } else {
                singletonList = Collections.singletonList(u.bU(list));
                kotlin.jvm.internal.h.d(singletonList, "Collections.singletonList(selected.first())");
                return singletonList;
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, aXE = {"Lcom/iqoption/operations/OperationViewModel$FilterItem;", "", "stringRes", "", "selected", "", "(IZ)V", "getSelected", "()Z", "setSelected", "(Z)V", "getStringRes", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static final class c {
        private final int cXD;
        private boolean selected;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FilterItem(stringRes=");
            stringBuilder.append(this.cXD);
            stringBuilder.append(", selected=");
            stringBuilder.append(this.selected);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public c(int i, boolean z) {
            this.cXD = i;
            this.selected = z;
        }

        public final int avB() {
            return this.cXD;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        public final void setSelected(boolean z) {
            this.selected = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((kotlin.jvm.internal.h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
                return false;
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.operations.OperationViewModel.FilterItem");
            }
            if (this.cXD != ((c) obj).cXD) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.cXD;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, aXE = {"Lcom/iqoption/operations/OperationViewModel$OperationsResult;", "", "items", "", "Lcom/iqoption/microservice/operation/Transaction;", "hasMore", "", "allCount", "", "(Ljava/util/List;ZI)V", "getAllCount", "()I", "getHasMore", "()Z", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static final class d {
        private final boolean aWg;
        private final int cXE;
        private final List<com.iqoption.microservice.b.b> nj;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (kotlin.jvm.internal.h.E(this.nj, dVar.nj)) {
                    if ((this.aWg == dVar.aWg ? 1 : null) != null) {
                        if ((this.cXE == dVar.cXE ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            List list = this.nj;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            int i = this.aWg;
            if (i != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.cXE;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OperationsResult(items=");
            stringBuilder.append(this.nj);
            stringBuilder.append(", hasMore=");
            stringBuilder.append(this.aWg);
            stringBuilder.append(", allCount=");
            stringBuilder.append(this.cXE);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public d(List<com.iqoption.microservice.b.b> list, boolean z, int i) {
            kotlin.jvm.internal.h.e(list, "items");
            this.nj = list;
            this.aWg = z;
            this.cXE = i;
        }

        public final boolean VW() {
            return this.aWg;
        }

        public final int avC() {
            return this.cXE;
        }

        public final List<com.iqoption.microservice.b.b> getItems() {
            return this.nj;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, aXE = {"com/iqoption/operations/OperationViewModel$dateFilterGroup$1", "Lcom/iqoption/operations/OperationViewModel$FilterGroup;", "applyFilterParams", "", "params", "", "", "", "multiSelection", "", "toggleSelection", "filterItem", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static final class e extends b {
        public boolean avy() {
            return false;
        }

        e(FilterType filterType, List list) {
            super(filterType, list);
        }

        public void C(Map<String, Object> map) {
            kotlin.jvm.internal.h.e(map, "params");
            for (Object next : avA()) {
                if (((c) next).getSelected()) {
                    break;
                }
            }
            Object next2 = null;
            c cVar = (c) next2;
            if (cVar != null && cVar.avB() != R.string.all_time) {
                int timeInMillis;
                int timeInMillis2;
                Calendar avx = OperationViewModel.calendar;
                kotlin.jvm.internal.h.d(avx, "calendar");
                avx.setTimeInMillis(System.currentTimeMillis());
                switch (cVar.avB()) {
                    case R.string.last_7_days:
                        OperationViewModel.calendar.add(5, -7);
                        avx = OperationViewModel.calendar;
                        kotlin.jvm.internal.h.d(avx, "calendar");
                        timeInMillis = (int) (avx.getTimeInMillis() / ((long) 1000));
                        break;
                    case R.string.month_1:
                        OperationViewModel.calendar.add(2, -1);
                        avx = OperationViewModel.calendar;
                        kotlin.jvm.internal.h.d(avx, "calendar");
                        timeInMillis = (int) (avx.getTimeInMillis() / ((long) 1000));
                        break;
                    case R.string.month_3:
                        OperationViewModel.calendar.add(2, -3);
                        avx = OperationViewModel.calendar;
                        kotlin.jvm.internal.h.d(avx, "calendar");
                        timeInMillis = (int) (avx.getTimeInMillis() / ((long) 1000));
                        break;
                    case R.string.today:
                        OperationViewModel.calendar.add(5, -1);
                        avx = OperationViewModel.calendar;
                        kotlin.jvm.internal.h.d(avx, "calendar");
                        timeInMillis = (int) (avx.getTimeInMillis() / ((long) 1000));
                        break;
                    case R.string.yesterday:
                        OperationViewModel.calendar.add(5, -1);
                        avx = OperationViewModel.calendar;
                        kotlin.jvm.internal.h.d(avx, "calendar");
                        long j = (long) 1000;
                        timeInMillis = (int) (avx.getTimeInMillis() / j);
                        OperationViewModel.calendar.add(5, -1);
                        Calendar avx2 = OperationViewModel.calendar;
                        kotlin.jvm.internal.h.d(avx2, "calendar");
                        timeInMillis2 = (int) (avx2.getTimeInMillis() / j);
                        break;
                    default:
                        timeInMillis = -1;
                        timeInMillis2 = -1;
                        break;
                }
                timeInMillis2 = timeInMillis;
                timeInMillis = -1;
                if (timeInMillis != -1) {
                    map.put("to", Integer.valueOf(timeInMillis));
                }
                if (timeInMillis2 != -1) {
                    map.put("from", Integer.valueOf(timeInMillis2));
                }
            }
        }

        public void a(c cVar) {
            kotlin.jvm.internal.h.e(cVar, "filterItem");
            for (c selected : avA()) {
                selected.setSelected(false);
            }
            cVar.setSelected(true);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¨\u0006\b"}, aXE = {"com/iqoption/operations/OperationViewModel$operationFilterGroup$1", "Lcom/iqoption/operations/OperationViewModel$FilterGroup;", "applyFilterParams", "", "params", "", "", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static final class f extends b {
        f(FilterType filterType, List list) {
            super(filterType, list);
        }

        public void C(Map<String, Object> map) {
            kotlin.jvm.internal.h.e(map, "params");
            Collection arrayList = new ArrayList();
            for (Object next : avA()) {
                if (((c) next).getSelected()) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            List arrayList2 = new ArrayList();
            if (list.size() == 1 && ((c) list.get(0)).avB() == R.string.all) {
                Collection arrayList3 = new ArrayList();
                for (Object next2 : avA()) {
                    if ((((c) next2).avB() != R.string.all ? 1 : null) != null) {
                        arrayList3.add(next2);
                    }
                }
                list = (List) arrayList3;
            }
            for (c avB : list) {
                switch (avB.avB()) {
                    case R.string.deposit:
                        arrayList2.add("deposit");
                        break;
                    case R.string.tournament_rebuy:
                        arrayList2.add("tournament_rebuy");
                        break;
                    case R.string.tournament_reward:
                        arrayList2.add("tournament_reward");
                        break;
                    case R.string.withdrawal:
                        arrayList2.add("withdrawal");
                        break;
                    default:
                        break;
                }
            }
            map.put("types", arrayList2);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/operation/TransactionResponse;", "call"})
    /* compiled from: OperationViewModel.kt */
    static final class g<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ MutableLiveData $liveData;
        final /* synthetic */ OperationViewModel cXF;
        final /* synthetic */ int cXG;

        g(OperationViewModel operationViewModel, int i, MutableLiveData mutableLiveData) {
            this.cXF = operationViewModel;
            this.cXG = i;
            this.$liveData = mutableLiveData;
        }

        /* renamed from: a */
        public final void aU(com.iqoption.microservice.b.c cVar) {
            kotlin.jvm.internal.h.e(cVar, "it");
            if (this.cXG == 0) {
                this.cXF.avv().clear();
            }
            this.cXF.avv().addAll(cVar.getItems());
            this.$liveData.postValue(ba.dww.bK(new d(cVar.getItems(), cVar.getCount() <= this.cXG + 100, cVar.getCount())));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: OperationViewModel.kt */
    static final class h implements com.iqoption.util.ag.a {
        final /* synthetic */ MutableLiveData $liveData;

        h(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        public final void n(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            this.$liveData.postValue(com.iqoption.util.ba.a.a(ba.dww, th, th.getMessage(), null, 4, null));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¨\u0006\b"}, aXE = {"com/iqoption/operations/OperationViewModel$statusFilterGroup$1", "Lcom/iqoption/operations/OperationViewModel$FilterGroup;", "applyFilterParams", "", "params", "", "", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationViewModel.kt */
    public static final class i extends b {
        i(FilterType filterType, List list) {
            super(filterType, list);
        }

        public void C(Map<String, Object> map) {
            kotlin.jvm.internal.h.e(map, "params");
            Collection arrayList = new ArrayList();
            for (Object next : avA()) {
                if (((c) next).getSelected()) {
                    arrayList.add(next);
                }
            }
            List<c> list = (List) arrayList;
            if (list.size() != 1 || ((c) list.get(0)).avB() != R.string.all) {
                List arrayList2 = new ArrayList();
                for (c avB : list) {
                    int avB2 = avB.avB();
                    if (avB2 == R.string.canceled) {
                        arrayList2.add("canceled");
                    } else if (avB2 == R.string.completed) {
                        arrayList2.add("completed");
                    } else if (avB2 == R.string.failed) {
                        arrayList2.add("failed");
                    } else if (avB2 == R.string.in_process) {
                        arrayList2.add("in_process");
                    }
                }
                map.put("statuses", arrayList2);
            }
        }
    }

    public final MutableLiveData<FilterType> avu() {
        return this.cXv;
    }

    public final List<com.iqoption.microservice.b.b> avv() {
        return this.cXw;
    }

    public final void avw() {
        this.cXw.clear();
    }

    public final LiveData<ba<d>> fC(int i) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        Map linkedHashMap = new LinkedHashMap();
        this.cXx.C(linkedHashMap);
        this.cXy.C(linkedHashMap);
        this.cXz.C(linkedHashMap);
        ag.a(com.iqoption.microservice.b.a.a(com.iqoption.microservice.b.a.cRO, linkedHashMap, i, 0, 4, null), (com.iqoption.util.ag.e) new g(this, i, mutableLiveData), (com.iqoption.util.ag.a) new h(mutableLiveData));
        return mutableLiveData;
    }

    public final String d(FilterType filterType) {
        kotlin.jvm.internal.h.e(filterType, "filterType");
        CharSequence charSequence = ", ";
        Iterable<c> avz = e(filterType).avz();
        Collection arrayList = new ArrayList(n.e(avz, 10));
        for (c avB : avz) {
            arrayList.add(IQApp.Dk().getString(avB.avB()));
        }
        String join = TextUtils.join(charSequence, (List) arrayList);
        kotlin.jvm.internal.h.d(join, "TextUtils.join(\", \", sel…etString(it.stringRes) })");
        return join;
    }

    public final b e(FilterType filterType) {
        kotlin.jvm.internal.h.e(filterType, "filterType");
        switch (filterType) {
            case DATE:
                return this.cXx;
            case STATUS:
                return this.cXz;
            case OPERATION:
                return this.cXy;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void a(c cVar, FilterType filterType) {
        kotlin.jvm.internal.h.e(cVar, "filterItem");
        kotlin.jvm.internal.h.e(filterType, "filterType");
        e(filterType).a(cVar);
        this.cXv.setValue(null);
        this.cXv.postValue(filterType);
    }

    public final List<c> a(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "filterGroup");
        return bVar.avA();
    }
}
