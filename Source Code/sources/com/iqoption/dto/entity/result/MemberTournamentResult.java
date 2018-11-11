package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.MemberTournament;
import java.util.ArrayList;

public class MemberTournamentResult {
    @SerializedName("result")
    public Result result;

    public class Result {
        @SerializedName("balance")
        public Double balance;
        @SerializedName("list")
        public ArrayList<MemberTournament> memberTournaments;
        @SerializedName("position")
        public Integer position;
    }
}
