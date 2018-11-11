package com.iqoption.microservice.vip;

import com.iqoption.vip.WeekDay;
import com.iqoption.vip.j;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b8\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bë\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"¢\u0006\u0002\u0010%J\t\u0010A\u001a\u00020\u0004HÆ\u0003J\t\u0010B\u001a\u00020\nHÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\n0\u0012HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\t\u0010E\u001a\u00020\nHÆ\u0003J\t\u0010F\u001a\u00020\nHÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\u0012HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012HÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\fHÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0\u0012HÆ\u0003J\u0015\u0010O\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"HÆ\u0003J\t\u0010P\u001a\u00020\u0004HÆ\u0003J\t\u0010Q\u001a\u00020\u0004HÆ\u0003J\t\u0010R\u001a\u00020\u0004HÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003J\t\u0010V\u001a\u00020\u000fHÆ\u0003J\u0002\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00122\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\b\b\u0002\u0010\u001f\u001a\u00020\f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"HÆ\u0001J\u0013\u0010X\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u000fHÖ\u0001J\t\u0010[\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010'R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u001f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+¨\u0006\\"}, aXE = {"Lcom/iqoption/microservice/vip/VipManager;", "", "()V", "canBeRated", "", "canOrderCallBack", "canOrderVipSupportCallback", "hasVipManager", "isOnline", "managerBirthCountry", "", "managerBirthday", "Ljava/util/Date;", "managerDescription", "managerGender", "", "managerId", "managerLanguages", "", "managerName", "managerPhone", "managerPhoto", "managerPhotosList", "trainingSessionsCategories", "Lcom/iqoption/microservice/vip/TrainingSessionCategory;", "trainingSessions", "Lcom/iqoption/microservice/vip/TrainingSession;", "certificates", "Lcom/iqoption/microservice/vip/Certificate;", "educationMaterials", "Lcom/iqoption/microservice/vip/EducationMaterial;", "managerWorkStartDate", "managerWorkTimeUTC", "managerWorkPeriodUtc", "", "Lcom/iqoption/vip/WeekDay;", "Lcom/iqoption/vip/WorkingPeriod;", "(ZZZZZLjava/lang/String;Ljava/util/Date;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Date;Ljava/util/List;Ljava/util/Map;)V", "getCanBeRated", "()Z", "getCanOrderCallBack", "getCanOrderVipSupportCallback", "getCertificates", "()Ljava/util/List;", "getEducationMaterials", "getHasVipManager", "getManagerBirthCountry", "()Ljava/lang/String;", "getManagerBirthday", "()Ljava/util/Date;", "getManagerDescription", "getManagerGender", "()I", "getManagerId", "getManagerLanguages", "getManagerName", "getManagerPhone", "getManagerPhoto", "getManagerPhotosList", "getManagerWorkPeriodUtc", "()Ljava/util/Map;", "getManagerWorkStartDate", "getManagerWorkTimeUTC", "getTrainingSessions", "getTrainingSessionsCategories", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipManagerResposnses.kt */
public final class d {
    private final boolean akU;
    private final boolean cSP;
    private final boolean cSQ;
    private final boolean cSR;
    private final String cSS;
    private final Date cST;
    private final String cSU;
    private final int cSV;
    private final String cSW;
    private final List<String> cSX;
    private final String cSY;
    private final List<String> cSZ;
    private final List<c> cTa;
    private final List<b> cTb;
    private final List<Object> cTc;
    private final List<Object> cTd;
    private final Date cTe;
    private final List<String> cTf;
    private final Map<WeekDay, j> cTg;
    private final boolean canBeRated;
    private final String managerName;
    private final String managerPhone;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if ((this.canBeRated == dVar.canBeRated ? 1 : null) != null) {
                if ((this.cSP == dVar.cSP ? 1 : null) != null) {
                    if ((this.cSQ == dVar.cSQ ? 1 : null) != null) {
                        if ((this.cSR == dVar.cSR ? 1 : null) != null) {
                            if ((this.akU == dVar.akU ? 1 : null) != null && h.E(this.cSS, dVar.cSS) && h.E(this.cST, dVar.cST) && h.E(this.cSU, dVar.cSU)) {
                                return (this.cSV == dVar.cSV ? 1 : null) != null && h.E(this.cSW, dVar.cSW) && h.E(this.cSX, dVar.cSX) && h.E(this.managerName, dVar.managerName) && h.E(this.managerPhone, dVar.managerPhone) && h.E(this.cSY, dVar.cSY) && h.E(this.cSZ, dVar.cSZ) && h.E(this.cTa, dVar.cTa) && h.E(this.cTb, dVar.cTb) && h.E(this.cTc, dVar.cTc) && h.E(this.cTd, dVar.cTd) && h.E(this.cTe, dVar.cTe) && h.E(this.cTf, dVar.cTf) && h.E(this.cTg, dVar.cTg);
                            }
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        int i = this.canBeRated;
        int i2 = 1;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        int i3 = this.cSP;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.cSQ;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.cSR;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        boolean z = this.akU;
        if (!z) {
            i2 = z;
        }
        i = (i + i2) * 31;
        String str = this.cSS;
        i3 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Date date = this.cST;
        i = (i + (date != null ? date.hashCode() : 0)) * 31;
        str = this.cSU;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.cSV) * 31;
        str = this.cSW;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.cSX;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        str = this.managerName;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.managerPhone;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.cSY;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        list = this.cSZ;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.cTa;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.cTb;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.cTc;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.cTd;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        date = this.cTe;
        i = (i + (date != null ? date.hashCode() : 0)) * 31;
        list = this.cTf;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        Map map = this.cTg;
        if (map != null) {
            i3 = map.hashCode();
        }
        return i + i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VipManager(canBeRated=");
        stringBuilder.append(this.canBeRated);
        stringBuilder.append(", canOrderCallBack=");
        stringBuilder.append(this.cSP);
        stringBuilder.append(", canOrderVipSupportCallback=");
        stringBuilder.append(this.cSQ);
        stringBuilder.append(", hasVipManager=");
        stringBuilder.append(this.cSR);
        stringBuilder.append(", isOnline=");
        stringBuilder.append(this.akU);
        stringBuilder.append(", managerBirthCountry=");
        stringBuilder.append(this.cSS);
        stringBuilder.append(", managerBirthday=");
        stringBuilder.append(this.cST);
        stringBuilder.append(", managerDescription=");
        stringBuilder.append(this.cSU);
        stringBuilder.append(", managerGender=");
        stringBuilder.append(this.cSV);
        stringBuilder.append(", managerId=");
        stringBuilder.append(this.cSW);
        stringBuilder.append(", managerLanguages=");
        stringBuilder.append(this.cSX);
        stringBuilder.append(", managerName=");
        stringBuilder.append(this.managerName);
        stringBuilder.append(", managerPhone=");
        stringBuilder.append(this.managerPhone);
        stringBuilder.append(", managerPhoto=");
        stringBuilder.append(this.cSY);
        stringBuilder.append(", managerPhotosList=");
        stringBuilder.append(this.cSZ);
        stringBuilder.append(", trainingSessionsCategories=");
        stringBuilder.append(this.cTa);
        stringBuilder.append(", trainingSessions=");
        stringBuilder.append(this.cTb);
        stringBuilder.append(", certificates=");
        stringBuilder.append(this.cTc);
        stringBuilder.append(", educationMaterials=");
        stringBuilder.append(this.cTd);
        stringBuilder.append(", managerWorkStartDate=");
        stringBuilder.append(this.cTe);
        stringBuilder.append(", managerWorkTimeUTC=");
        stringBuilder.append(this.cTf);
        stringBuilder.append(", managerWorkPeriodUtc=");
        stringBuilder.append(this.cTg);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, Date date, String str2, int i, String str3, List<String> list, String str4, String str5, String str6, List<String> list2, List<c> list3, List<b> list4, List<Object> list5, List<Object> list6, Date date2, List<String> list7, Map<WeekDay, j> map) {
        String str7 = str;
        Date date3 = date;
        String str8 = str2;
        String str9 = str3;
        List<String> list8 = list;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        List<String> list9 = list2;
        List<c> list10 = list3;
        List<b> list11 = list4;
        List<Object> list12 = list5;
        List<Object> list13 = list6;
        Date date4 = date2;
        List<String> list14 = list7;
        h.e(str7, "managerBirthCountry");
        h.e(date3, "managerBirthday");
        h.e(str8, "managerDescription");
        h.e(str9, "managerId");
        h.e(list8, "managerLanguages");
        h.e(str10, "managerName");
        h.e(str11, "managerPhone");
        h.e(str12, "managerPhoto");
        h.e(list9, "managerPhotosList");
        h.e(list10, "trainingSessionsCategories");
        h.e(list11, "trainingSessions");
        h.e(list12, "certificates");
        h.e(list13, "educationMaterials");
        h.e(date4, "managerWorkStartDate");
        h.e(list14, "managerWorkTimeUTC");
        h.e(map, "managerWorkPeriodUtc");
        this.canBeRated = z;
        this.cSP = z2;
        this.cSQ = z3;
        this.cSR = z4;
        this.akU = z5;
        this.cSS = str7;
        this.cST = date3;
        this.cSU = str8;
        this.cSV = i;
        this.cSW = str9;
        this.cSX = list8;
        this.managerName = str10;
        this.managerPhone = str11;
        this.cSY = str12;
        this.cSZ = list9;
        this.cTa = list10;
        this.cTb = list11;
        this.cTc = list12;
        this.cTd = list13;
        this.cTe = date4;
        this.cTf = list7;
        this.cTg = map;
    }

    public final boolean ate() {
        return this.cSP;
    }

    public final Date atf() {
        return this.cST;
    }

    public final String atg() {
        return this.cSU;
    }

    public final List<String> ath() {
        return this.cSX;
    }

    public final String ati() {
        return this.managerName;
    }

    public final String atj() {
        return this.managerPhone;
    }

    public final String atk() {
        return this.cSY;
    }

    public final List<String> atl() {
        return this.cSZ;
    }

    public final List<c> atm() {
        return this.cTa;
    }

    public final List<b> atn() {
        return this.cTb;
    }

    public final Date ato() {
        return this.cTe;
    }

    public final List<String> atp() {
        return this.cTf;
    }

    public final Map<WeekDay, j> atq() {
        return this.cTg;
    }

    public d() {
        List emptyList = Collections.emptyList();
        h.d(emptyList, "Collections.emptyList<String>()");
        List emptyList2 = Collections.emptyList();
        h.d(emptyList2, "Collections.emptyList<String>()");
        List emptyList3 = Collections.emptyList();
        h.d(emptyList3, "Collections.emptyList<TrainingSessionCategory>()");
        List emptyList4 = Collections.emptyList();
        h.d(emptyList4, "Collections.emptyList<TrainingSession>()");
        List emptyList5 = Collections.emptyList();
        h.d(emptyList5, "Collections.emptyList<Certificate>()");
        List emptyList6 = Collections.emptyList();
        h.d(emptyList6, "Collections.emptyList<EducationMaterial>()");
        Date date = new Date();
        List emptyList7 = Collections.emptyList();
        h.d(emptyList7, "Collections.emptyList<String>()");
        Map emptyMap = Collections.emptyMap();
        List list = emptyList7;
        h.d(emptyMap, "Collections.emptyMap()");
        Map map = emptyMap;
        List list2 = list;
        Date date2 = date;
        List list3 = emptyList6;
        List list4 = emptyList5;
        List list5 = emptyList4;
        List list6 = emptyList3;
        this(false, false, false, false, false, "", new Date(), "", 0, "", emptyList, "", "", "", emptyList2, list6, list5, list4, list3, date2, list2, map);
    }
}
