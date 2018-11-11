package com.iqoption.view.materialcalendar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.dto.ToastEntity;
import java.util.Calendar;
import java.util.Date;

/* compiled from: CalendarDay */
public final class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        /* renamed from: aa */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: hd */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private transient Calendar dGv;
    private transient Date dGw;
    private final int day;
    private final int month;
    private final int year;

    private static int r(int i, int i2, int i3) {
        return ((i * ToastEntity.ALERT_TOAST_DURATION) + (i2 * 100)) + i3;
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public static b aJd() {
        return b(f.getInstance());
    }

    @NonNull
    public static b q(int i, int i2, int i3) {
        return new b(i, i2, i3);
    }

    public static b b(@Nullable Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return q(f.e(calendar), f.f(calendar), f.g(calendar));
    }

    public static b c(@Nullable Date date) {
        return date == null ? null : b(f.d(date));
    }

    @Deprecated
    public b() {
        this(f.getInstance());
    }

    @Deprecated
    public b(Calendar calendar) {
        this(f.e(calendar), f.f(calendar), f.g(calendar));
    }

    @Deprecated
    public b(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    @NonNull
    public Date getDate() {
        if (this.dGw == null) {
            this.dGw = getCalendar().getTime();
        }
        return this.dGw;
    }

    @NonNull
    public Calendar getCalendar() {
        if (this.dGv == null) {
            this.dGv = f.getInstance();
            c(this.dGv);
        }
        return this.dGv;
    }

    public void c(@NonNull Calendar calendar) {
        calendar.clear();
        calendar.set(this.year, this.month, this.day);
    }

    public boolean c(@Nullable b bVar, @Nullable b bVar2) {
        return (bVar == null || !bVar.b(this)) && (bVar2 == null || !bVar2.a(this));
    }

    public boolean a(@NonNull b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("other cannot be null");
        }
        boolean z = false;
        if (this.year == bVar.year) {
            return this.month == bVar.month ? z : z;
            z = true;
        }
        if (this.year < bVar.year) {
            z = true;
        }
        return z;
    }

    public boolean b(@NonNull b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("other cannot be null");
        }
        boolean z = false;
        if (this.year == bVar.year) {
            return this.month == bVar.month ? z : z;
            z = true;
        }
        if (this.year > bVar.year) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!(this.day == bVar.day && this.month == bVar.month && this.year == bVar.year)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return r(this.year, this.month, this.day);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CalendarDay{");
        stringBuilder.append(this.year);
        stringBuilder.append("-");
        stringBuilder.append(this.month);
        stringBuilder.append("-");
        stringBuilder.append(this.day);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public b(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.day);
    }
}
