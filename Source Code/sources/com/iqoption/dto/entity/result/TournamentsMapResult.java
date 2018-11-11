package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.Tournament;
import com.iqoption.dto.entity.Tournament.Map;
import java.util.ArrayList;

public class TournamentsMapResult {
    @SerializedName("result")
    public Map result;

    public ArrayList<Tournament> getList() {
        ArrayList<Tournament> arrayList = new ArrayList();
        for (ArrayList addAll : this.result.values()) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }
}
