package com.microblink.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public class e {
    private boolean dUP = false;
    private boolean dUQ = false;
    private boolean dUR = false;
    private boolean dUS = false;
    private boolean dUT = false;
    private a dUU = new a();

    /* compiled from: line */
    public static class a implements Parcelable {
        public static final Creator<a> CREATOR = new Creator<a>() {
            /* renamed from: ag */
            public final a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* renamed from: hM */
            public final a[] newArray(int i) {
                return new a[i];
            }
        };
        private boolean dUV = false;
        private boolean dUW = false;
        private boolean dUX = false;
        private a dUY = new a();

        /* compiled from: line */
        public static class a implements Parcelable {
            public static final Creator<a> CREATOR = new Creator<a>() {
                /* renamed from: ah */
                public final a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* renamed from: hN */
                public final a[] newArray(int i) {
                    return new a[i];
                }
            };
            private boolean dUW = false;
            private boolean dUZ = false;
            private boolean dVa = false;
            private boolean dVb = false;

            public int describeContents() {
                return 0;
            }

            public boolean aOZ() {
                return this.dVa;
            }

            public boolean aPa() {
                return this.dUZ;
            }

            public boolean aOW() {
                return this.dUW;
            }

            public boolean aPb() {
                return this.dVb;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeByte(this.dUZ);
                parcel.writeByte(this.dVa);
                parcel.writeByte(this.dUW);
                parcel.writeByte(this.dVb);
            }

            protected a(Parcel parcel) {
                boolean z = false;
                this.dUZ = parcel.readByte() != (byte) 0;
                this.dVa = parcel.readByte() != (byte) 0;
                this.dUW = parcel.readByte() != (byte) 0;
                if (parcel.readByte() != (byte) 0) {
                    z = true;
                }
                this.dVb = z;
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean aOV() {
            return this.dUV;
        }

        public boolean aOW() {
            return this.dUW;
        }

        public boolean aOX() {
            return this.dUX;
        }

        public a aOY() {
            return this.dUY;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte(this.dUV);
            parcel.writeByte(this.dUW);
            parcel.writeByte(this.dUX);
            parcel.writeParcelable(this.dUY, i);
        }

        protected a(Parcel parcel) {
            boolean z = false;
            this.dUV = parcel.readByte() != (byte) 0;
            this.dUW = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.dUX = z;
            this.dUY = (a) parcel.readParcelable(a.class.getClassLoader());
        }
    }

    public boolean aOP() {
        return this.dUP;
    }

    public boolean aOQ() {
        return this.dUS;
    }

    public boolean aOR() {
        return this.dUQ;
    }

    public boolean aOS() {
        return this.dUR;
    }

    public boolean aOT() {
        return this.dUT;
    }

    public a aOU() {
        return this.dUU;
    }
}
