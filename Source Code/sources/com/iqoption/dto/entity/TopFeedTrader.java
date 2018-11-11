package com.iqoption.dto.entity;

import com.google.gson.annotations.SerializedName;
import com.iqoption.mobbtech.connect.response.options.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TopFeedTrader implements Serializable {
    @SerializedName("active_id")
    private Integer activeId;
    @SerializedName("active_name")
    private String activeName;
    @SerializedName("flag")
    private String flag;
    @SerializedName("option_ids")
    private ArrayList<Option> optionIds;
    private ArrayList<e> positions = new ArrayList();
    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("win_amount")
    private Double winAmount;

    public static class List extends ArrayList<TopFeedTrader> {
    }

    public static class Option {
        private Double amount;
        private Long created;
        private String direction;
        private Double value;

        public Double getValue() {
            return this.value;
        }

        public void setValue(Double d) {
            this.value = d;
        }

        public Long getCreated() {
            return this.created;
        }

        public void setCreated(Long l) {
            this.created = l;
        }

        public String getDirection() {
            return this.direction;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public Double getAmount() {
            return this.amount;
        }

        public void setAmount(Double d) {
            this.amount = d;
        }
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public Integer getActiveId() {
        return this.activeId;
    }

    public void setActiveId(Integer num) {
        this.activeId = num;
    }

    public Double getWinAmount() {
        return this.winAmount;
    }

    public void setWinAmount(Double d) {
        this.winAmount = d;
    }

    public ArrayList<Option> getOptionIds() {
        return this.optionIds;
    }

    public void setOptionIds(ArrayList<Option> arrayList) {
        this.optionIds = arrayList;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getActiveName() {
        return this.activeName;
    }

    public void setActiveName(String str) {
        this.activeName = str;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public ArrayList<e> getOptionIdsToPositions(long j, double d) {
        if (!this.positions.isEmpty()) {
            return this.positions;
        }
        float f = 0.0f;
        Iterator it = this.optionIds.iterator();
        while (it.hasNext()) {
            e option2openoption = e.option2openoption((Option) it.next(), this.activeId.intValue(), j, d);
            if (option2openoption.getWin().equals("win")) {
                f = (float) (((double) f) + option2openoption.getInvestSum().doubleValue());
            }
            this.positions.add(option2openoption);
        }
        Iterator it2 = this.positions.iterator();
        while (it2.hasNext()) {
            e eVar = (e) it2.next();
            if (eVar.getWin().equals("win")) {
                eVar.setProfitAmount(Double.valueOf(eVar.getInvestSum().doubleValue() * (this.winAmount.doubleValue() / ((double) f))));
            }
        }
        return this.positions;
    }
}
