package com.iqoption.charttools.constructor;

import com.google.gson.JsonArray;
import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.charttools.model.indicator.constructor.b;
import com.iqoption.charttools.model.indicator.constructor.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J_\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u0004\u0018\u00010\n*\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u001c\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, aXE = {"Lcom/iqoption/charttools/constructor/InputAdapterItemsHelper;", "", "()V", "makeAdapterItems", "", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "inputs", "", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "groups", "Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "defaults", "", "hosts", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "canChooseHost", "", "onChanged", "Lkotlin/Function0;", "", "([Lcom/iqoption/charttools/model/indicator/constructor/InputItem;[Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;Ljava/util/List;Ljava/util/List;ZLkotlin/jvm/functions/Function0;)Ljava/util/List;", "makeValues", "Lcom/google/gson/JsonArray;", "activeId", "", "items", "(I[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;Ljava/util/List;)Lcom/google/gson/JsonArray;", "getByInputIndex", "inputIndex", "([Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;I)Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "techtools_release"})
/* compiled from: InputAdapterItemsHelper.kt */
public final class e {
    public final List<d> a(InputItem[] inputItemArr, c[] cVarArr, List<String> list, List<b> list2, boolean z, a<l> aVar) {
        Object obj = inputItemArr;
        Object obj2 = cVarArr;
        List<String> list3 = list;
        List<b> list4 = list2;
        h.e(obj, "inputs");
        h.e(obj2, "groups");
        h.e(list3, "defaults");
        h.e(list4, "hosts");
        a<l> aVar2 = aVar;
        h.e(aVar2, "onChanged");
        List<d> arrayList = new ArrayList();
        c cVar = (c) null;
        int length = obj.length;
        Object obj3 = cVar;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            InputItem inputItem = obj[i4];
            int i5 = i + 1;
            if (!inputItem.MC()) {
                int i6;
                c a = a(obj2, i);
                if (i == 0 || (h.E(a, obj3) ^ 1) != 0) {
                    if (a != null) {
                        if ((((CharSequence) a.getName()).length() > 0 ? 1 : null) != null) {
                            i2++;
                            c cVar2 = a;
                            arrayList.add(new l(i2, a.getName(), a.getDescription() != null, false, cVar2));
                            obj3 = cVar2;
                            if (obj3.getDescription() != null) {
                                i2++;
                            }
                            i3++;
                        }
                    }
                    obj3 = a;
                    i3++;
                }
                Object obj4 = obj3;
                int i7 = i3;
                switch (inputItem.My()) {
                    case BOOL:
                    case PLOT_VISIBILITY:
                        i6 = i2 + 1;
                        arrayList.add(new g(i6, i7, inputItem, (String) list3.get(i), aVar2));
                        break;
                    case INT:
                    case DOUBLE:
                    case STRING:
                        if (inputItem.MB() == null) {
                            i6 = i2 + 1;
                            arrayList.add(new j(i6, i7, inputItem, (String) list3.get(i), aVar2));
                            break;
                        }
                        i6 = i2 + 1;
                        arrayList.add(new u(i6, i7, inputItem, (String) list3.get(i), aVar2));
                        break;
                    case INT_SELECTION:
                    case DOUBLE_SELECTION:
                    case STRING_SELECTION:
                        i2++;
                        arrayList.add(new s(i2, i7, inputItem, (String) list3.get(i), null, 0, 48, null));
                        break;
                    case COLOR:
                        i6 = i2 + 1;
                        arrayList.add(new i(i6, i7, inputItem, (String) list3.get(i), aVar2));
                        break;
                    case LINE_WIDTH:
                        i6 = i2 + 1;
                        arrayList.add(new r(i6, i7, inputItem, (String) list3.get(i), aVar2));
                        break;
                    case HOST:
                        if ((list4.isEmpty() ^ 1) == 0) {
                            i2++;
                            arrayList.add(new m(i2, i7, inputItem, (String) list3.get(i), false, null, 0, 112, null));
                            break;
                        }
                        i2++;
                        String str = (String) list3.get(i);
                        b[] bVarArr = new b[(list2.size() + 1)];
                        i3 = bVarArr.length;
                        for (i6 = 0; i6 < i3; i6++) {
                            b Lk;
                            if (i6 == 0) {
                                Lk = m.auv.Lk();
                            } else {
                                Lk = (b) list4.get(i6 - 1);
                            }
                            bVarArr[i6] = Lk;
                        }
                        arrayList.add(new m(i2, i7, inputItem, str, z, bVarArr, 0, 64, null));
                        break;
                }
                i2 = i6;
                i3 = i7;
                obj3 = obj4;
                continue;
            }
            i4++;
            i = i5;
        }
        return arrayList;
    }

    private final c a(c[] cVarArr, int i) {
        if ((cVarArr.length == 0 ? 1 : null) != null) {
            return null;
        }
        for (c cVar : cVarArr) {
            int[] indices = cVar.getIndices();
            if (indices != null) {
                if (((indices.length == 0 ? 1 : 0) ^ 1) == 0) {
                    continue;
                } else if (i.r(indices) <= i && i.s(indices) >= i) {
                    return cVar;
                } else {
                    if (i.r(indices) > i) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public final JsonArray a(int i, InputItem[] inputItemArr, List<? extends d> list) {
        h.e(inputItemArr, "inputs");
        h.e(list, "items");
        Iterator it = m.f(m.b(u.ac(list), InputAdapterItemsHelper$makeValues$iterator$1.aul), InputAdapterItemsHelper$makeValues$iterator$2.aum).iterator();
        JsonArray jsonArray = new JsonArray();
        for (InputItem inputItem : inputItemArr) {
            InputItem inputItem2;
            if (!inputItem2.MC()) {
                inputItem2 = null;
            }
            if (inputItem2 == null) {
                inputItem2 = (InputItem) it.next();
            }
            switch (inputItem2.My()) {
                case INT:
                case INT_SELECTION:
                case DOUBLE_SELECTION:
                case STRING_SELECTION:
                case LINE_WIDTH:
                case HOST:
                    jsonArray.add((Number) Integer.valueOf(inputItem2.getIntValue()));
                    break;
                case COLOR:
                    jsonArray.add((Number) Long.valueOf(com.iqoption.core.ext.c.toUnsignedLong(inputItem2.getIntValue())));
                    break;
                case DOUBLE:
                    jsonArray.add((Number) Double.valueOf(inputItem2.Mu()));
                    break;
                case BOOL:
                case PLOT_VISIBILITY:
                    jsonArray.add(Boolean.valueOf(inputItem2.getBooleanValue()));
                    break;
                case ACTIVE:
                    jsonArray.add((Number) Integer.valueOf(inputItem2.getIntValue() != -1 ? inputItem2.getIntValue() : i));
                    break;
                default:
                    jsonArray.add(inputItem2.getValue());
                    break;
            }
        }
        return jsonArray;
    }
}
