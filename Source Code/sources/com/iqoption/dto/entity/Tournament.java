package com.iqoption.dto.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Tournament implements Serializable {
    public static final int STATUS_FINISHED = 5;
    public static final int STATUS_FORCE_FINISHED = 4;
    public static final int STATUS_HIDE = 6;
    public static final int STATUS_NOT_ACTIVATED = 1;
    public static final int STATUS_NOT_STARTED = 2;
    public static final int STATUS_RUN = 3;
    public static final int TYPE_FREE = 2;
    public static final int TYPE_PAID = 5;
    @SerializedName("balance_id")
    private Long balanceId;
    @SerializedName("cost")
    private Double cost;
    @SerializedName("currency")
    private String currency;
    @SerializedName("description")
    private String description;
    @SerializedName("end_date")
    private Long endDate;
    @SerializedName("id")
    private Long id;
    @SerializedName("image")
    private String image;
    @SerializedName("name")
    private String name;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("position")
    private Integer position;
    @SerializedName("rebuy")
    private Boolean rebuy;
    @SerializedName("rebuy_cost")
    private Double rebuyCost;
    @SerializedName("rebuy_count")
    private Integer rebuyCount;
    @SerializedName("registered")
    private Boolean registered;
    @SerializedName("start_amount")
    private Double startAmount;
    @SerializedName("start_date")
    private Long startDate;
    @SerializedName("status")
    private Integer status;
    @SerializedName("time")
    private Long time;
    @SerializedName("users_count")
    private Integer usersCount;
    @SerializedName("win_amount")
    private Double winAmount;
    @SerializedName("winners")
    private ArrayList<MemberTournament> winners;
    @SerializedName("winners_table")
    private HashMap<Integer, String> winnersTable;

    public static class List extends ArrayList<Tournament> {
    }

    public static class Map extends HashMap<Integer, ArrayList<Tournament>> {
    }

    public Tournament(Long l) {
        this.id = l;
    }

    public ArrayList<MemberTournament> getWinners() {
        return this.winners;
    }

    public void setWinners(ArrayList<MemberTournament> arrayList) {
        if (this.winners == null) {
            this.winners = new ArrayList();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            MemberTournament memberTournament = (MemberTournament) arrayList.get(i);
            if (i < this.winners.size()) {
                ((MemberTournament) this.winners.get(i)).merge(memberTournament);
            } else {
                this.winners.add(memberTournament);
            }
        }
    }

    public Long getBalanceId() {
        return this.balanceId;
    }

    public void setBalanceId(Long l) {
        this.balanceId = l;
    }

    public Double getCost() {
        return Double.valueOf(this.cost == null ? 0.0d : this.cost.doubleValue());
    }

    public void setCost(Double d) {
        this.cost = d;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public Long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Long l) {
        this.endDate = l;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getOptionType() {
        return this.optionType;
    }

    public void setOptionType(String str) {
        this.optionType = str;
    }

    public Boolean getRebuy() {
        return Boolean.valueOf(this.rebuy == null ? false : this.rebuy.booleanValue());
    }

    public void setRebuy(Boolean bool) {
        this.rebuy = bool;
    }

    public Double getRebuyCost() {
        return Double.valueOf(this.rebuyCost == null ? 0.0d : this.rebuyCost.doubleValue());
    }

    public void setRebuyCost(Double d) {
        this.rebuyCost = d;
    }

    public Integer getRebuyCount() {
        return Integer.valueOf(this.rebuyCount == null ? 0 : this.rebuyCount.intValue());
    }

    public void setRebuyCount(Integer num) {
        this.rebuyCount = num;
    }

    public Boolean getRegistered() {
        return this.registered;
    }

    public void setRegistered(Boolean bool) {
        this.registered = bool;
    }

    public Double getStartAmount() {
        return Double.valueOf(this.startAmount == null ? 0.0d : this.startAmount.doubleValue());
    }

    public void setStartAmount(Double d) {
        this.startAmount = d;
    }

    public Long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Long l) {
        this.startDate = l;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long l) {
        this.time = l;
    }

    public Integer getPosition() {
        return Integer.valueOf(this.position == null ? -1 : this.position.intValue());
    }

    public void setPosition(Integer num) {
        this.position = num;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public Integer getUsersCount() {
        return Integer.valueOf(this.usersCount == null ? 0 : this.usersCount.intValue());
    }

    public void setUsersCount(Integer num) {
        this.usersCount = num;
    }

    public Double getWinAmount() {
        return Double.valueOf(this.winAmount == null ? 0.0d : this.winAmount.doubleValue());
    }

    public void setWinAmount(Double d) {
        this.winAmount = d;
    }

    public HashMap<Integer, String> getWinnersTable() {
        return this.winnersTable;
    }

    public void setWinnersTable(HashMap<Integer, String> hashMap) {
        this.winnersTable = hashMap;
    }

    public boolean equals(Object obj) {
        return this.id.equals(((Tournament) obj).id);
    }

    public void merge(Tournament tournament) {
        if (tournament.balanceId != null) {
            this.balanceId = tournament.balanceId;
        }
        if (tournament.cost != null) {
            this.cost = tournament.cost;
        }
        if (!TextUtils.isEmpty(tournament.currency)) {
            this.currency = tournament.currency;
        }
        if (!TextUtils.isEmpty(tournament.description)) {
            this.description = tournament.description;
        }
        if (tournament.endDate != null) {
            this.endDate = tournament.endDate;
        }
        if (!TextUtils.isEmpty(tournament.image)) {
            this.image = tournament.image;
        }
        if (!TextUtils.isEmpty(tournament.name)) {
            this.name = tournament.name;
        }
        if (!TextUtils.isEmpty(tournament.optionType)) {
            this.optionType = tournament.optionType;
        }
        if (tournament.rebuy != null) {
            this.rebuy = tournament.rebuy;
        }
        if (tournament.rebuyCost != null) {
            this.rebuyCost = tournament.rebuyCost;
        }
        if (tournament.rebuyCount != null) {
            this.rebuyCount = tournament.rebuyCount;
        }
        if (tournament.registered != null) {
            this.registered = tournament.registered;
        }
        if (tournament.startAmount != null) {
            this.startAmount = tournament.startAmount;
        }
        if (tournament.startDate != null) {
            this.startDate = tournament.startDate;
        }
        if (tournament.status != null) {
            this.status = tournament.status;
        }
        if (tournament.time != null) {
            this.time = tournament.time;
        }
        if (tournament.usersCount != null) {
            this.usersCount = tournament.usersCount;
        }
        if (tournament.position != null) {
            this.position = tournament.position;
        }
        if (tournament.winAmount != null) {
            this.winAmount = tournament.winAmount;
        }
        if (!(tournament.winners == null || tournament.winners.isEmpty())) {
            setWinners(tournament.winners);
        }
        if (tournament.winnersTable != null && !tournament.winnersTable.isEmpty()) {
            setWinnersTable(tournament.winnersTable);
        }
    }
}
