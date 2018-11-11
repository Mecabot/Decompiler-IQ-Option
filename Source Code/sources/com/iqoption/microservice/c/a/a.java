package com.iqoption.microservice.c.a;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* compiled from: OtnLeaderBoardResponse */
public final class a {
    @SerializedName("isSuccessful")
    private boolean aVB;
    @SerializedName("result")
    private a cRX;

    /* compiled from: OtnLeaderBoardResponse */
    public static final class a {
        @SerializedName("user_id")
        private int aWm;
        @SerializedName("top_size")
        private int aWx;
        @SerializedName("positional")
        private Map<Integer, Object> cRY;
        @SerializedName("position")
        private int cRZ;
        @SerializedName("score")
        private double cSa;
        @SerializedName("next_emission_amount")
        private double cSb;

        public int asI() {
            return this.cRZ;
        }

        public int asJ() {
            return this.aWx;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Result{userId=");
            stringBuilder.append(this.aWm);
            stringBuilder.append(", usersRowMap=");
            stringBuilder.append(this.cRY);
            stringBuilder.append(", currentUserPosition=");
            stringBuilder.append(this.cRZ);
            stringBuilder.append(", currentUserScore=");
            stringBuilder.append(this.cSa);
            stringBuilder.append(", topSize =");
            stringBuilder.append(this.aWx);
            stringBuilder.append(", nextEmissionAmount=");
            stringBuilder.append(this.cSb);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public a asH() {
        return this.cRX;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OtnLeaderBoardResponse{isSuccessful=");
        stringBuilder.append(this.aVB);
        stringBuilder.append(", result=");
        stringBuilder.append(this.cRX);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
