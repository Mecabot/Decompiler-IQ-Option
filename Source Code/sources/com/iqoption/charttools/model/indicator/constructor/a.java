package com.iqoption.charttools.model.indicator.constructor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.iqoption.charttools.model.indicator.p;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.model.indicator.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "Landroid/os/Parcelable;", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "title", "", "groups", "", "Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "inputs", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "(Lcom/iqoption/charttools/model/indicator/MetaIndicator;Ljava/lang/String;[Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;)V", "getGroups", "()[Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "[Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "getInputs", "()[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "getMeta", "()Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getTitle", "()Ljava/lang/String;", "describeContents", "", "getDefaults", "", "values", "Lcom/google/gson/JsonArray;", "(Lcom/google/gson/JsonArray;)[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "techtools_release"})
/* compiled from: Constructor.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new b();
    private static final a ayT = new a(p.ayu, "", new c[0], new InputItem[0]);
    public static final a ayU = new a();
    private final x atH;
    private final c[] ayR;
    private final InputItem[] ayS;
    private final String title;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/Constructor$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "getEMPTY", "()Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "techtools_release"})
    /* compiled from: Constructor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a Ms() {
            return a.ayT;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            x xVar = (x) z.ayE.E(parcel);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            c[] cVarArr = new c[readInt];
            for (int i = 0; readInt > i; i++) {
                cVarArr[i] = (c) c.CREATOR.createFromParcel(parcel);
            }
            readInt = parcel.readInt();
            InputItem[] inputItemArr = new InputItem[readInt];
            for (int i2 = 0; readInt > i2; i2++) {
                inputItemArr[i2] = (InputItem) InputItem.CREATOR.createFromParcel(parcel);
            }
            return new a(xVar, readString, cVarArr, inputItemArr);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        h.e(parcel, "parcel");
        z.ayE.a(this.atH, parcel, i);
        parcel.writeString(this.title);
        c[] cVarArr = this.ayR;
        int length = cVarArr.length;
        parcel.writeInt(length);
        for (i2 = 0; length > i2; i2++) {
            cVarArr[i2].writeToParcel(parcel, 0);
        }
        InputItem[] inputItemArr = this.ayS;
        length = inputItemArr.length;
        parcel.writeInt(length);
        for (i2 = 0; length > i2; i2++) {
            inputItemArr[i2].writeToParcel(parcel, 0);
        }
    }

    public a(x xVar, String str, c[] cVarArr, InputItem[] inputItemArr) {
        h.e(xVar, "meta");
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        h.e(cVarArr, "groups");
        h.e(inputItemArr, "inputs");
        this.atH = xVar;
        this.title = str;
        this.ayR = cVarArr;
        this.ayS = inputItemArr;
    }

    public final c[] Mq() {
        return this.ayR;
    }

    public final List<String> Mp() {
        InputItem[] inputItemArr = this.ayS;
        Collection arrayList = new ArrayList(inputItemArr.length);
        for (InputItem value : inputItemArr) {
            arrayList.add(value.getValue());
        }
        return (List) arrayList;
    }

    public final InputItem[] f(JsonArray jsonArray) {
        JsonArray jsonArray2 = jsonArray;
        if (jsonArray2 == null) {
            return this.ayS;
        }
        InputItem[] inputItemArr = this.ayS;
        Object copyOf = Arrays.copyOf(inputItemArr, inputItemArr.length);
        h.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        inputItemArr = (InputItem[]) copyOf;
        int length = inputItemArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            InputItem inputItem = inputItemArr[i];
            int i3 = i2 + 1;
            JsonElement jsonElement = jsonArray2.get(i2);
            h.d(jsonElement, "values[index]");
            String asString = jsonElement.getAsString();
            h.d(asString, "values[index].asString");
            inputItemArr[i2] = InputItem.a(inputItem, null, null, asString, null, null, null, null, false, 251, null);
            i++;
            i2 = i3;
        }
        return inputItemArr;
    }
}
