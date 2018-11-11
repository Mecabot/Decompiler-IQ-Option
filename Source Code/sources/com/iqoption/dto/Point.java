package com.iqoption.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Predicates;
import com.google.common.base.d;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.iqoption.microservice.quotes.history.response.a;
import com.iqoption.microservice.quotes.history.response.e;
import com.iqoption.util.i;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;

public class Point implements Parcelable {
    public static final Creator<Point> CREATOR = new Creator<Point>() {
        public Point createFromParcel(Parcel parcel) {
            return new Point(parcel, null);
        }

        public Point[] newArray(int i) {
            return new Point[i];
        }
    };
    public double rate;
    public long timestamp;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ Point(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.timestamp);
        parcel.writeDouble(this.rate);
    }

    private Point(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.rate = parcel.readDouble();
    }

    public static ArrayList<Point> parseHistoryPoints(JSONArray jSONArray, int i) {
        i = jSONArray.length();
        if (i <= 0) {
            return null;
        }
        ArrayList<Point> arrayList = new ArrayList(300);
        for (int i2 = 0; i2 < i; i2++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
            Point point = new Point();
            point.timestamp = jSONArray2.getLong(0);
            point.rate = jSONArray2.getDouble(1);
            arrayList.add(point);
        }
        return arrayList;
    }

    public static ImmutableList<Point> fromQuotes(Collection<e> collection) {
        if (i.H(collection)) {
            return ImmutableList.sL();
        }
        return com.google.common.collect.i.c((Iterable) collection).b(new d<e, Point>() {
            public Point apply(e eVar) {
                if (eVar == null) {
                    return null;
                }
                Point point = new Point();
                point.timestamp = eVar.getTime();
                point.rate = eVar.getValue();
                return point;
            }
        }).sA();
    }

    public static ImmutableList<Point> fromCandles(Collection<a> collection, j<Point> jVar) {
        if (i.H(collection)) {
            return ImmutableList.sL();
        }
        j jVar2;
        if (jVar2 == null) {
            jVar2 = Predicates.pQ();
        }
        return com.google.common.collect.i.c((Iterable) collection).b(Point$$Lambda$0.$instance).c(jVar2).sA();
    }

    static final /* synthetic */ Point lambda$fromCandles$0$Point(a aVar) {
        if (aVar == null) {
            return null;
        }
        Point point = new Point();
        point.timestamp = aVar.asV();
        point.rate = aVar.asW();
        return point;
    }
}
